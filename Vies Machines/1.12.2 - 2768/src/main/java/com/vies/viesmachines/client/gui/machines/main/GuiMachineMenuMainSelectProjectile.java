package com.vies.viesmachines.client.gui.machines.main;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuMainSelectProjectile;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletConsume;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletElectrical;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletExplosive;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageHelperGuiMachineMenuSelectProjectileBulletNormal;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiMachineMenuMainSelectProjectile extends GuiContainerVM {
	
	private ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_main_select_projectile.png");
	
	public GuiMachineMenuMainSelectProjectile(IInventory playerInv, EntityMachineBase machineIn)
	{
		super(new ContainerMachineMenuMainSelectProjectile(playerInv, machineIn), playerInv, machineIn);
		
		this.ammoToApply = machineIn.getAmmoAmount();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonBulletNormal = new GuiButtonGeneral1VM(21, this.guiLeft + 102, this.guiTop + 35, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonBulletElectrical = new GuiButtonGeneral1VM(22, this.guiLeft + 124, this.guiTop + 35, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonBulletExplosive = new GuiButtonGeneral1VM(23, this.guiLeft + 146, this.guiTop + 35, 14, 14, References.localNameVC(""), 1);
		
    	GuiVM.buttonConsume = new GuiButtonGeneral1VM(12, this.guiLeft + 24, this.guiTop + 110, 42, 14, References.localNameVC("viesmachines.button.consume"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(13, this.guiLeft + 127, this.guiTop + 121, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
		
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		this.buttonList.add(GuiVM.buttonBulletNormal);
		this.buttonList.add(GuiVM.buttonBulletElectrical);
		this.buttonList.add(GuiVM.buttonBulletExplosive);
		this.buttonList.add(GuiVM.buttonConsume);
		this.buttonList.add(GuiVM.buttonBack);
		
		GuiVM.buttonMM1.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Bullet Normal:
		if(parButton.id == 21)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuSelectProjectileBulletNormal());
	    }
		// Bullet Electrical:
		if(parButton.id == 22)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuSelectProjectileBulletElectrical());
	    }
		// Bullet Explosive:
		if(parButton.id == 23)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuSelectProjectileBulletExplosive());
	    }
		
		// Apply:
		if(parButton.id == 12)
	    {
			if(!this.machine.inventory.getStackInSlot(1).isEmpty())
			{
				this.ammoToApply = this.machine.inventory.getStackInSlot(1).getCount();
				
				if(EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier() == this.machine.getAmmoAmount())
				{
					
				}
				else if(EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier() >= (this.ammoToApply + this.machine.getAmmoAmount()))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuSelectProjectileBulletConsume());
				}
				else if(EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier() < (this.ammoToApply + this.machine.getAmmoAmount()))
				{
					this.ammoToApply = EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier() - this.machine.getAmmoAmount();
					
					NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuSelectProjectileBulletConsume());
				}
			}
	    }
		
		// Back:
		if(parButton.id == 13)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Binds and draws the background texture:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.zLevel = -200.0F;
		
		// Bullets over buttons:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(218, 90, 0);
			
			// Normal bullet over button:
			this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_NORMAL, 1), 0, 0, "");
		}
		GlStateManager.popMatrix();
		
		// Bullets over buttons:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(218+44, 90, 0);
			
			// Electrical bullet over button:
			this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_ELECTRICAL, 1), 0, 0, "");
			
		}
		GlStateManager.popMatrix();
		// Bullets over buttons:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			GlStateManager.translate(218+44+44, 90, 0);
			
			// Explosive bullet over button:
			this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_EXPLOSIVE, 1), 0, 0, "");
		}
		GlStateManager.popMatrix();
		
		// Main headers:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.weaponmenu.0"), 118, 12, Color.BLACK.getRGB());
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.selectprojectile.0"), 176, 30, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.ammoinfo.0"), 61, 30, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Left Menu:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.bullets.0"), 61, 49, Color.WHITE.getRGB());
			this.centeredString(fontRenderer, this.machine.getAmmoAmount() + " / " + EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier(), 61, 60, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			GlStateManager.translate(61, 78.5, 0);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.selected.0"), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(37+8.5, 68+15, 0);
			
			if (this.machine.getAmmoType() == 0)
			{
				this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_NORMAL), 0, 0, " ");
			}
			
			if (this.machine.getAmmoType() == 1)
			{
				this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_ELECTRICAL), 0, 0, " ");
			}
			
			if (this.machine.getAmmoType() == 2)
			{
				this.drawItemStack(new ItemStack(ItemsVM.PARTICLE_BULLET_EXPLOSIVE), 0, 0, " ");
			}
		}
		GlStateManager.popMatrix();
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Button Normal Bullet:
		if (this.machine.getAmmoType() == 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(131, 62, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.normalbullet.0"), 0, 0, Color.WHITE.getRGB());
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.normalbullet.1"), 0, 23, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.normalbullet.2"), 0, 33, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC(" "), 0, 43, Color.WHITE.getRGB());
				this.centeredString(fontRenderer, References.localNameVC(" "), 0, 53, Color.WHITE.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.normalbullet.3"), 0, 63, Color.WHITE.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// Logic for mouse-over tooltip - Button Electrical Bullet:
		if (this.machine.getAmmoType() == 1)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(131, 62, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.electricalbullet.0"), 0, 0, Color.WHITE.getRGB());
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.electricalbullet.1"), 0, 23, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.electricalbullet.2") + " 10%", 0, 33, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC(" "), 0, 43, Color.WHITE.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.electricalbullet.3"), 0, 53, Color.RED.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.electricalbullet.4"), 0, 63, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// Logic for mouse-over tooltip - Explosive Normal Bullet:
		if (this.machine.getAmmoType() == 2)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(131, 62, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.explosivebullet.0"), 0, 0, Color.WHITE.getRGB());
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.explosivebullet.1"), 0, 23, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.explosivebullet.2"), 0, 33, Color.GREEN.getRGB());
				this.centeredString(fontRenderer, References.localNameVC(" "), 0, 43, Color.WHITE.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.explosivebullet.3"), 0, 53, Color.RED.getRGB());
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.main.weapon.explosivebullet.4"), 0, 63, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
		}
    }
	
	@Override
	public void updateScreen()
    {
		super.updateScreen();
		
		if (this.machine.getAmmoType() == 0)
		{
			GuiVM.buttonBulletNormal.enabled = false;
			GuiVM.buttonBulletElectrical.enabled = true;
			GuiVM.buttonBulletExplosive.enabled = true;
		}
		if (this.machine.getAmmoType() == 1)
		{
			GuiVM.buttonBulletNormal.enabled = true;
			GuiVM.buttonBulletElectrical.enabled = false;
			GuiVM.buttonBulletExplosive.enabled = true;
		}
		if (this.machine.getAmmoType() == 2)
		{
			GuiVM.buttonBulletNormal.enabled = true;
			GuiVM.buttonBulletElectrical.enabled = true;
			GuiVM.buttonBulletExplosive.enabled = false;
		}
		
		// Checks if the Consume button is enabled:
		if(this.machine.inventory.getStackInSlot(1).isEmpty()
		|| EnumsVM.FlyingMachineComponentTier.byId(this.machine.getTierComponent()).getMaxAmmoModifier() == this.machine.getAmmoAmount())
		{
			GuiVM.buttonConsume.enabled = false;
		}
		else
		{
			GuiVM.buttonConsume.enabled = true;
		}
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
		super.mouseClicked(x, y, btn);
    }
}

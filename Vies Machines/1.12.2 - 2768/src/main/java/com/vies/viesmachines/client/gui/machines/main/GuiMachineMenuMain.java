package com.vies.viesmachines.client.gui.machines.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Loghelper;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.EntityMachineFuel;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuMain;
import com.vies.viesmachines.configs.VMConfiguration;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainArmed;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainAutorun;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainCompress;
import com.vies.viesmachines.network.server.machine.gui.main.MessageHelperGuiMachineMenuMainPowered;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.projectile.MessageGuiMachineMenuSelectProjectile;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageGuiMachineMenuSelectMusic;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicPlay;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicRandom;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMusicStop;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageAutorunDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageAutorunEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessagePoweredOnDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessagePoweredOnEnabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemDisabled;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemEnabled;
import com.vies.viesmachines.proxy.ClientProxy;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuMain extends GuiContainerVM {
	
	public static int machineId;
	public static int selectedSongId;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_main.png");
	
	public GuiMachineMenuMain(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineMenuMain(playerInv, airshipIn), playerInv, airshipIn);
		
		this.machineId = this.machine.getEntityId();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonMusicSelect = new GuiButtonGeneral1VM(40, this.guiLeft + 117, this.guiTop + 88, 52, 14, References.localNameVC("viesmachines.gui.select.0"), 0);
    	GuiVM.buttonMusicStop = new GuiButtonGeneral1VM(41, this.guiLeft + 119, this.guiTop + 119, 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonMusicPlay = new GuiButtonGeneral1VM(42, this.guiLeft + 136, this.guiTop + 119, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonMusicRandom = new GuiButtonGeneral1VM(43, this.guiLeft + 153, this.guiTop + 119, 14, 14, References.localNameVC(""), 3);
		
    	GuiVM.buttonMachineCompress = new GuiButtonGeneral2VM(51, this.guiLeft + 13, this.guiTop + 21, 14, 14, References.localNameVC(""), 0);
    	GuiVM.buttonMachineRename = new GuiButtonGeneral2VM(52, this.guiLeft + 39, this.guiTop + 21, 14, 14, References.localNameVC(""), 2);
    	
    	GuiVM.buttonMachineArmedTrue = new GuiButtonGeneral1VM(59, this.guiLeft + 13, this.guiTop + 57, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonMachineArmedFalse = new GuiButtonGeneral1VM(60, this.guiLeft + 13, this.guiTop + 57, 14, 14, References.localNameVC(""), 2);
    	
    	GuiVM.buttonMachineSelectProjectile = new GuiButtonGeneral2VM(63, this.guiLeft + 39, this.guiTop + 57, 14, 14, References.localNameVC(""), 2);
    	
    	GuiVM.buttonMachineOnTrue = new GuiButtonGeneral1VM(53, this.guiLeft + 93, this.guiTop + 21, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonMachineOnFalse = new GuiButtonGeneral1VM(54, this.guiLeft + 93, this.guiTop + 21, 14, 14, References.localNameVC(""), 2);
    	
    	// Not used right now:
    	GuiVM.button01 = new GuiButtonGeneral1VM(55, this.guiLeft + 93, this.guiTop + 39, 14, 14, References.localNameVC(""), 1);
    	GuiVM.button02 = new GuiButtonGeneral1VM(56, this.guiLeft + 93, this.guiTop + 39, 14, 14, References.localNameVC(""), 3);
    	
    	GuiVM.buttonMachineAutorunTrue = new GuiButtonGeneral1VM(57, this.guiLeft + 93, this.guiTop + 57, 14, 14, References.localNameVC(""), 1);
    	GuiVM.buttonMachineAutorunFalse = new GuiButtonGeneral1VM(58, this.guiLeft + 93, this.guiTop + 57, 14, 14, References.localNameVC(""), 2);
    	
    	//--------------------------------------------------
    	
    	this.buttonList.add(GuiVM.buttonMusicSelect);
    	this.buttonList.add(GuiVM.buttonMusicStop);
    	this.buttonList.add(GuiVM.buttonMusicPlay);
    	this.buttonList.add(GuiVM.buttonMusicRandom);
    	
    	this.buttonList.add(GuiVM.buttonMachineCompress);
    	this.buttonList.add(GuiVM.buttonMachineRename);
    	
    	this.buttonList.add(GuiVM.buttonMachineArmedTrue);
    	this.buttonList.add(GuiVM.buttonMachineArmedFalse);
    	
    	this.buttonList.add(GuiVM.buttonMachineSelectProjectile);
    	
    	this.buttonList.add(GuiVM.buttonMachineOnTrue);
    	this.buttonList.add(GuiVM.buttonMachineOnFalse);
    	
    	//this.buttonList.add(GuiVC.button01);
    	//this.buttonList.add(GuiVC.button02);
    	
    	this.buttonList.add(GuiVM.buttonMachineAutorunTrue);
    	this.buttonList.add(GuiVM.buttonMachineAutorunFalse);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonMM1.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Select Song:
		if (parButton.id == 40)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuSelectMusic());
	    }
		
		// Stop song:
		if (parButton.id == 41)
	    {
			this.machineId = this.machine.getEntityId();
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicStop());
	    }
		
		// Play song:
		if (parButton.id == 42)
	    {
			this.machineId = this.machine.getEntityId();
			this.selectedSongId = 1;
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicPlay());
	    }
		
		// Random song:
		if (parButton.id == 43)
	    {
			this.selectedSongId = References.random.nextInt(ClientProxy.musicListRecord.size());
			this.machineId = this.machine.getEntityId();
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicRandom());
	    }
		
		// Compress machine into an item:
		if (parButton.id == 51)
	    {
			this.machineId = this.machine.getEntityId();
			
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuMainCompress());
	    }
		
		// Rename menu:
		if (parButton.id == 52)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuChangeName());
	    }
		
		// Machine 'On' toggle:
		if (parButton.id == 53
		|| parButton.id == 54)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuMainPowered());
			
			if (!this.machine.getPoweredOn())
			{
				NetworkHandler.sendToServer(new PlayerMessagePoweredOnEnabled());
			}
			else
			{
				NetworkHandler.sendToServer(new PlayerMessagePoweredOnDisabled());
			}
	    }
		
		// Unused:
		if (parButton.id == 55
		|| parButton.id == 56)
	    {
			//NetworkHandler.sendToServer(new MessageHelperMachineGuiMenuMainPowered());
	    }
		
		// Autorun toggle:
		if (parButton.id == 57
		|| parButton.id == 58)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuMainAutorun());			
			
			if (!this.machine.getAutorun())
			{
				NetworkHandler.sendToServer(new PlayerMessageAutorunEnabled());
			}
			else
			{
				NetworkHandler.sendToServer(new PlayerMessageAutorunDisabled());
			}
	    }
		
		// Armed toggle:
		if (parButton.id == 59
		|| parButton.id == 60)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuMainArmed());
			
			if (!this.machine.getArmed())
			{
				NetworkHandler.sendToServer(new PlayerMessageWeaponSystemEnabled());
			}
			else
			{
				NetworkHandler.sendToServer(new PlayerMessageWeaponSystemDisabled());
			}
	    }
		
		// Select Projectile menu:
		if (parButton.id == 63)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuSelectProjectile());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Binds and renders the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Check to see if this machine can take and calculate fuel:
		if (this.machine instanceof EntityMachineFuel)
		{
			EntityMachineFuel fuelMachineIn = (EntityMachineFuel) this.machine;
			
			// Draws the fuel bar:
			if (fuelMachineIn.getFuel() > 0)
	        {
				int k = this.getBurnLeftScaled(44);
				// Top Fuel bar:
	            this.drawTexturedModalRect(this.guiLeft + 131-7, this.guiTop + 9+15, 176, 12, 8, 44);
				// Fuel to take away:
	            this.drawTexturedModalRect(this.guiLeft + 131-7, this.guiTop + 9+15, 124, 24, 8, 44 - k);
			}
			
			// Draws lit light bulbs if the machine is on and burning fuel:
			if (fuelMachineIn.isFuelBurning())
			{
				// Top bulbs:
	            this.drawTexturedModalRect(this.guiLeft + 136, this.guiTop + 27, 177, 1, 7, 9);
	            this.drawTexturedModalRect(this.guiLeft + 155, this.guiTop + 27, 177, 1, 7, 9);
	            // Bottom bulbs:
	            this.drawTexturedModalRect(this.guiLeft + 136, this.guiTop + 56, 184, 1, 7, 9);
	            this.drawTexturedModalRect(this.guiLeft + 155, this.guiTop + 56, 184, 1, 7, 9);
			}
			
			// Draws broken fuel slot texture:
			if (fuelMachineIn.getBroken())
			{
				this.drawTexturedModalRect(this.guiLeft + 141, this.guiTop + 38, 177, 58, 16, 16);
			}
		}
    }
	
	/** Calculates the fuel bar in %. */
    private int getBurnLeftScaled(int pixels)
    {
    	EntityMachineFuel fuelMachineIn = (EntityMachineFuel) this.machine;
    	
        int i = fuelMachineIn.getField(1);
        
        if (i == 0)
        {
        	i = fuelMachineIn.getItemstackFuelSize() + 1;
        }
        
        return fuelMachineIn.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Menu labels:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.options.0"), 45, 10, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.toggle.0"), 134, 10, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.fueltank.0"), 191, 10, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.weapons.0"), 45, 58, Color.BLACK.getRGB());
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.radio.0"), 191, 107, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// If the machine isn't broken, display song information:
		if (!this.machine.getBroken())
        {
			if (this.machine.getSelectedRecord() < 0)
			{
				// No songs:
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(143, 108.5, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					
					this.centeredString(fontRenderer, References.localNameVC("--------"), 0, 0, Color.RED.getRGB());
				}
				GlStateManager.popMatrix();
			}
			else if (this.machine.getTierComponent() == 0
			&& !this.machine.getLearnedRecordSlot1().equals(""))
	        {
				this.validRecordName(this.machine);
	        }
			else if (this.machine.getTierComponent() == 1
			&& !this.machine.getLearnedRecordSlot1().equals("")
			|| !this.machine.getLearnedRecordSlot2().equals("")
			|| !this.machine.getLearnedRecordSlot3().equals(""))
			{
				this.validRecordName(this.machine);
			}
			else if (this.machine.getTierComponent() == 2
			&& !this.machine.getLearnedRecordSlot1().equals("")
			|| !this.machine.getLearnedRecordSlot2().equals("")
			|| !this.machine.getLearnedRecordSlot3().equals("")
			|| !this.machine.getLearnedRecordSlot4().equals("")
			|| !this.machine.getLearnedRecordSlot5().equals(""))
			{
				this.validRecordName(this.machine);
			}
			else if (this.machine.getTierComponent() == 3
			&& !this.machine.getLearnedRecordSlot1().equals("")
			|| !this.machine.getLearnedRecordSlot2().equals("")
			|| !this.machine.getLearnedRecordSlot3().equals("")
			|| !this.machine.getLearnedRecordSlot4().equals("")
			|| !this.machine.getLearnedRecordSlot5().equals("")
			|| !this.machine.getLearnedRecordSlot6().equals("")
			|| !this.machine.getLearnedRecordSlot7().equals(""))
			{
				this.validRecordName(this.machine);
			}
			else if(this.machine.getSelectedRecord() >= 0)
			{
				this.validRecordName(this.machine);
			}
			else
			{
				// No songs:
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(143, 108.5, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					
					this.centeredString(fontRenderer, References.localNameVC("--------"), 0, 0, Color.RED.getRGB());
				}
				GlStateManager.popMatrix();
			}
        }
		
		//--------------------------------------------------
		
		// Binds the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Stop symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(119, 119.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 200, 0, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Play symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(136, 119.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 200, 28, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Random symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(153, 119.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 200, 56, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Compress symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(13.0, 21.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 0, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Rename Symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39.0, 21.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 28, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Armed symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(13.0, 57.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 140, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Select Weapon Symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39.0, 57.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 168, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Power symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(93, 21.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 56, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Unused:
		//GlStateManager.pushMatrix();
		//{
		//	GlStateManager.translate(94.25, 40.25, 0);
		//	GlStateManager.scale(0.36F, 0.36F, 0.36F);
			
		//	this.drawTexturedModalRect(0, 0, 228, 84, 32, 32);
		//}
		//GlStateManager.popMatrix();
		
		// Autorun symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(93, 57.0, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 112, 28, 28);
		}
		GlStateManager.popMatrix();
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Compress:
		if(mouseX >= this.guiLeft + 13 && mouseX <= this.guiLeft + 26
		&& mouseY >= this.guiTop + 21 && mouseY <= this.guiTop + 34)
		{
			List<String> text = new ArrayList<String>();
			if (VMConfiguration.machineHardmode)
	        {
				text.add(TextFormatting.DARK_RED + "" + TextFormatting.BOLD + "!!! " + References.localNameVC("viesmachines.gui.tt.compress.3") + " !!!");
				text.add(TextFormatting.RED + "" + TextFormatting.BOLD + References.localNameVC("viesmachines.gui.tt.compress.4"));
				text.add(TextFormatting.RED + "" + TextFormatting.BOLD + References.localNameVC("viesmachines.gui.tt.compress.5"));
	        }
			else
			{
				text.add(TextFormatting.RED + "" + TextFormatting.BOLD + References.localNameVC("viesmachines.gui.tt.compress.1"));
				text.add(TextFormatting.RED + "" + TextFormatting.BOLD + References.localNameVC("viesmachines.gui.tt.compress.2"));
			}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = 0;
				
				if (VMConfiguration.machineHardmode)
		        {
					textNumber = References.localNameVC("viesmachines.gui.tt.compress.4").length();
		        }
				else
				{
					textNumber = References.localNameVC("viesmachines.gui.tt.compress.1").length();
				}
				
				GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		// Disables button overlays if broken and can't be used:
		if (!this.machine.getBroken())
		{
			// Logic for mouse-over tooltip - Rename:
			if(mouseX >= this.guiLeft + 39 && mouseX <= this.guiLeft + 52
			&& mouseY >= this.guiTop + 21 && mouseY <= this.guiTop + 34)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.changename.1"));
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.changename.2"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.changename.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			// Logic for mouse-over tooltip - Armed:
			if(mouseX >= this.guiLeft + 13 && mouseX <= this.guiLeft + 26
			&& mouseY >= this.guiTop + 57 && mouseY <= this.guiTop + 70)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.armed.1"));
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.armed.2"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.armed.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			// Logic for mouse-over tooltip - Select Projectile:
			if(mouseX >= this.guiLeft + 39 && mouseX <= this.guiLeft + 52
			&& mouseY >= this.guiTop + 57 && mouseY <= this.guiTop + 70)
			{
				List<String> text = new ArrayList<String>();
				//text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.selectprojectile.1"));
				//text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.selectprojectile.2"));
				text.add("Disabled for now!");
				GlStateManager.pushMatrix();
				{
					int textNumber = text.toString().length();//References.localNameVC("viesmachines.gui.tt.selectprojectile.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			// Logic for mouse-over tooltip - Power:
			if(mouseX >= this.guiLeft + 93 && mouseX <= this.guiLeft + 106
			&& mouseY >= this.guiTop + 21 && mouseY <= this.guiTop + 34)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.powered.1"));
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.powered.2"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.powered.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			/*
			//Logic for mouse-over ----- tooltip
			if(mouseX >= this.guiLeft + 93 && mouseX <= this.guiLeft + 106
			&& mouseY >= this.guiTop + 39 && mouseY <= this.guiTop + 52)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.-----.1"));
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.-----.2"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.-----.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			*/
			
			// Logic for mouse-over tooltip - Autorun:
			if(mouseX >= this.guiLeft + 93 && mouseX <= this.guiLeft + 106
			&& mouseY >= this.guiTop + 57 && mouseY <= this.guiTop + 70)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.autorun.1"));
				text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.autorun.2"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.autorun.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			// Logic for mouse-over tooltip - Fuel Tank:
			if(mouseX >= this.guiLeft + 140 && mouseX <= this.guiLeft + 157
			&& mouseY >= this.guiTop + 37 && mouseY <= this.guiTop + 54)
			{
				List<String> text = new ArrayList<String>();
				
				if (this.machine.getControllingPassenger() instanceof EntityPlayer)
				{
					EntityPlayer playerin = (EntityPlayer) this.machine.getControllingPassenger();
					
					if (playerin.isCreative())
					{
						text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.fuel.3"));
						text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.fuel.4"));
					}
					else
					{
						text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.fuel.1"));
						text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.fuel.2"));
					}
				}
				
				GlStateManager.pushMatrix();
				{
					int textNumber = References.localNameVC("viesmachines.gui.tt.fuel.1").length();
					
					GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			
			//if (this.machine.getSelectedRecord() < 0)
	        {
				// Logic for mouse-over tooltip - Music Stop:
				if(mouseX >= this.guiLeft + 119 && mouseX <= this.guiLeft + 132
				&& mouseY >= this.guiTop + 119 && mouseY <= this.guiTop + 132)
				{
					List<String> text = new ArrayList<String>();
					
					if (this.machine.getSelectedRecord() >= 0)
			        {
						text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.main.musicstop.0"));
						
						GlStateManager.pushMatrix();
						{
							int textNumber = text.toString().length();
							
							GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
							GlStateManager.scale(0.5, 0.5, 0.5);
							
							this.drawHoveringText(text, 0, 0);
						}
						GlStateManager.popMatrix();
			        }
				}
				
				// Logic for mouse-over tooltip - Music Play:
				if(mouseX >= this.guiLeft + 136 && mouseX <= this.guiLeft + 149
				&& mouseY >= this.guiTop + 119 && mouseY <= this.guiTop + 132)
				{
					List<String> text = new ArrayList<String>();
					
					if (this.machine.getSelectedRecord() >= 0)
			        {
						text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.main.musicplay.0"));
						
						GlStateManager.pushMatrix();
						{
							int textNumber = text.toString().length();
							
							GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
							GlStateManager.scale(0.5, 0.5, 0.5);
							
							this.drawHoveringText(text, 0, 0);
						}
						GlStateManager.popMatrix();
			        }
				}
				
				// Logic for mouse-over tooltip - Music Random:
				if(mouseX >= this.guiLeft + 153 && mouseX <= this.guiLeft + 166
				&& mouseY >= this.guiTop + 119 && mouseY <= this.guiTop + 132)
				{
					List<String> text = new ArrayList<String>();
					
					if (this.machine.getTierComponent() >= 3)
			        {
						text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.main.musicrandom.0"));
			        }
					else
					{
						text.add(TextFormatting.RED + References.localNameVC("viesmachines.gui.tt.main.musicrandom.1"));
					}
					GlStateManager.pushMatrix();
					{
						int textNumber = text.toString().length();
						
						GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 19, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						
						this.drawHoveringText(text, 0, 0);
					}
					GlStateManager.popMatrix();
				}
	        }
		}
		else
		{
			
		}
	}
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        // Deals with hiding unused toggle buttons:
        if(this.machine.getPoweredOn())
		{
			GuiVM.buttonMachineOnTrue.visible = true;
			GuiVM.buttonMachineOnFalse.visible = false;
		}
		else
		{
			GuiVM.buttonMachineOnTrue.visible = false;
			GuiVM.buttonMachineOnFalse.visible = true;
		}
        
        // Deals with hiding unused toggle buttons:
        if(this.machine.getAutorun())
		{
			GuiVM.buttonMachineAutorunTrue.visible = true;
			GuiVM.buttonMachineAutorunFalse.visible = false;
		}
		else
		{
			GuiVM.buttonMachineAutorunTrue.visible = false;
			GuiVM.buttonMachineAutorunFalse.visible = true;
		}
        
        // Deals with hiding unused toggle buttons:
        if(this.machine.getArmed())
		{
			GuiVM.buttonMachineArmedTrue.visible = true;
			GuiVM.buttonMachineArmedFalse.visible = false;
		}
		else
		{
			GuiVM.buttonMachineArmedTrue.visible = false;
			GuiVM.buttonMachineArmedFalse.visible = true;
		}
        
        // Handles the toggle 'On' button:
        if (this.machine.inventory.getStackInSlot(0).isEmpty())
        {
        	if (((EntityMachineFuel) this.machine).getFuel() == 0)
        	{
        		if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        		{
        			if (((EntityPlayer)this.machine.getControllingPassenger()).isCreative())
        			{
        				GuiVM.buttonMachineOnTrue.enabled = true;
                    	GuiVM.buttonMachineOnFalse.enabled = true;
        			}
            		else
            		{
            			GuiVM.buttonMachineOnTrue.enabled = false;
                    	GuiVM.buttonMachineOnFalse.enabled = false;
            		}
        		}
        	}
        	else
        	{
        		GuiVM.buttonMachineOnTrue.enabled = true;
            	GuiVM.buttonMachineOnFalse.enabled = true;
        	}
        }
        else
        {
        	GuiVM.buttonMachineOnTrue.enabled = true;
        	GuiVM.buttonMachineOnFalse.enabled = true;
        }
        
        // Deals with button 'On' and durability:
        if (this.machine.getDurability() == 0
        && !this.machine.getBroken())
        {
        	GuiVM.buttonMachineOnTrue.enabled = false;
        	GuiVM.buttonMachineOnFalse.enabled = false;
		}
		else
		{
			GuiVM.buttonMachineOnTrue.enabled = true;
        	GuiVM.buttonMachineOnFalse.enabled = true;
		}
        
        // Deals with disabling all buttons if the machine is broken:
        if (this.machine.getBroken())
        {
        	GuiVM.buttonMusicSelect.enabled = false;
        	GuiVM.buttonMusicStop.enabled = false;
        	GuiVM.buttonMusicPlay.enabled = false;
        	GuiVM.buttonMusicRandom.enabled = false;
        	
        	GuiVM.buttonMachineRename.enabled = false;
			GuiVM.buttonMachineOnTrue.enabled = false;
			GuiVM.buttonMachineOnFalse.enabled = false;
        	GuiVM.buttonMachineAutorunTrue.enabled = false;
			GuiVM.buttonMachineAutorunFalse.enabled = false;
        	GuiVM.buttonMachineArmedTrue.enabled = false;
			GuiVM.buttonMachineArmedFalse.enabled = false;
			GuiVM.buttonMachineSelectProjectile.enabled = false;
        }
        else
        {
        	GuiVM.buttonMusicSelect.enabled = true;
        	GuiVM.buttonMusicStop.enabled = true;
        	GuiVM.buttonMusicPlay.enabled = true;
        	GuiVM.buttonMusicRandom.enabled = true;
        	
        	GuiVM.buttonMachineRename.enabled = true;
			GuiVM.buttonMachineOnTrue.enabled = true;
			GuiVM.buttonMachineOnFalse.enabled = true;
        	GuiVM.buttonMachineAutorunTrue.enabled = true;
			GuiVM.buttonMachineAutorunFalse.enabled = true;
        	GuiVM.buttonMachineArmedTrue.enabled = true;
			GuiVM.buttonMachineArmedFalse.enabled = true;
			GuiVM.buttonMachineSelectProjectile.enabled = true;
        }
        
        if (this.machine.getSelectedRecord() < 0)
        {
        	GuiVM.buttonMusicPlay.enabled = false;
        	GuiVM.buttonMusicStop.enabled = false;
        }
        
        if (this.machine.getTierComponent() >= 3)
        {
        	GuiVM.buttonMusicRandom.enabled = true;
        }
        else
        {
        	GuiVM.buttonMusicRandom.enabled = false;
        }

        if (this.machine.getBroken())
        {
        	GuiVM.buttonMusicPlay.enabled = false;
        	GuiVM.buttonMusicStop.enabled = false;
        	GuiVM.buttonMusicRandom.enabled = false;
        	GuiVM.buttonMusicSelect.enabled = false;
        }
        
        // Makes it so you can't convert broken machines into item via config:
        if (VMConfiguration.machineHardmode)
        {
        	if (this.machine.getBroken())
        	{
        		GuiVM.buttonMachineCompress.enabled = false;
        	}
        }
        
        // TODO Remove soon!
        GuiVM.buttonMachineSelectProjectile.enabled = false;
    }
	
	/** Gets the record mod and name. */
	public void validRecordName(EntityMachineBase machineIn)
	{
		// Current Song:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(144, 105, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.currentsong.0") + " :", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Actual song name:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(144, 112, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.centeredString(fontRenderer, 
			this.stringToFlashGolden(
			References.localNameVC("item." + 
			ClientProxy.musicListRecord.get(machineIn.getSelectedRecord()).getResourcePath().toString() 
			+ ".desc")
			, 1, false, TextFormatting.DARK_AQUA, 0)	
			, 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
	}
}

package com.viesis.viescraft.client.gui.airship.upgrade;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerUpgradeMenu;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.upgrade.MessageHelperGuiUpgradeBalloonVC;
import com.viesis.viescraft.network.server.airship.upgrade.MessageHelperGuiUpgradeCoreVC;
import com.viesis.viescraft.network.server.airship.upgrade.MessageHelperGuiUpgradeEngineVC;
import com.viesis.viescraft.network.server.airship.upgrade.MessageHelperGuiUpgradeFrameVC;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiUpgradeMenu extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_upgrade.png");
	
	public GuiUpgradeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerUpgradeMenu(playerInv, airshipIn), playerInv, airshipIn);
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVC.buttonC1 = new GuiButtonGeneral1VC(11, this.guiLeft + 24, this.guiTop + 88, 14, 14, "", 1);
    	GuiVC.buttonC2 = new GuiButtonGeneral1VC(12, this.guiLeft + 62, this.guiTop + 88, 14, 14, "", 1);
    	GuiVC.buttonC3 = new GuiButtonGeneral1VC(13, this.guiLeft + 100, this.guiTop + 88, 14, 14, "", 1);
    	GuiVC.buttonC4 = new GuiButtonGeneral1VC(14, this.guiLeft + 138, this.guiTop + 88, 14, 14, "", 1);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
    	
		this.buttonList.add(GuiVC.buttonC1);
    	this.buttonList.add(GuiVC.buttonC2);
    	this.buttonList.add(GuiVC.buttonC3);
    	this.buttonList.add(GuiVC.buttonC4);
    	
		GuiVC.buttonMM2.enabled = false;
    }
	
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		this.metaInfo = 0;
		
		if (parButton.id == 11)
	    {
			if(!this.airship.inventory.getStackInSlot(1).isEmpty())
			{
				this.metaInfo = this.airship.inventory.getStackInSlot(1).getMetadata();
				
				if(this.metaInfo > this.airship.getMainTierCore()
				&& this.metaInfo == (this.airship.getMainTierCore() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeCoreVC());
				}
			}
	    }
		
		if (parButton.id == 12)
	    {
			if(!this.airship.inventory.getStackInSlot(2).isEmpty())
			{
				this.metaInfo = this.airship.inventory.getStackInSlot(2).getMetadata();
				
				if(this.metaInfo > this.airship.getMainTierFrame()
				&& this.metaInfo == (this.airship.getMainTierFrame() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeFrameVC());
				}
				
			}
	    }
		
		if (parButton.id == 13)
	    {
			if(!this.airship.inventory.getStackInSlot(3).isEmpty())
			{
				this.metaInfo = this.airship.inventory.getStackInSlot(3).getMetadata();
				
				if(this.metaInfo > this.airship.getMainTierEngine()
				&& this.metaInfo == (this.airship.getMainTierEngine() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeEngineVC());
				}
				
			}
	    }
		
		if (parButton.id == 14)
	    {
			if(!this.airship.inventory.getStackInSlot(4).isEmpty())
			{
				this.metaInfo = this.airship.inventory.getStackInSlot(4).getMetadata();
				
				if(this.metaInfo > this.airship.getMainTierBalloon()
				&& this.metaInfo == (this.airship.getMainTierBalloon() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeBalloonVC());
				}
				
			}
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the checkbox when things are maxed.
		if((this.airship.getMainTierCore()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMainTierFrame()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 61, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 61, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMainTierEngine()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 99, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 99, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMainTierBalloon()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 137, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 137, this.guiTop + 83, 176, 16, 16, 20);
		}
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49-4, this.guiTop - 17, this.guiLeft + 127+4, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-4, this.guiTop - 16, this.guiLeft + 126+4, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-4, this.guiTop - 14, this.guiLeft + 124+4, this.guiTop, Color.BLACK.getRGB());
		
		//Disable/hides all button on default
    	GuiVC.buttonC1.enabled = false;
    	GuiVC.buttonC2.enabled = false;
    	GuiVC.buttonC3.enabled = false;
    	GuiVC.buttonC4.enabled = false;
    	GuiVC.buttonC1.visible = false;
    	GuiVC.buttonC2.visible = false;
    	GuiVC.buttonC3.visible = false;
    	GuiVC.buttonC4.visible = false;
    	
    	//Enables a button if the conditions are right
    	if(!this.airship.inventory.getStackInSlot(1).isEmpty())
		{
			this.metaInfo = this.airship.inventory.getStackInSlot(1).getMetadata();
			
			if(this.metaInfo > this.airship.getMainTierCore()
			&& this.metaInfo == (this.airship.getMainTierCore() + 1))
			{
				GuiVC.buttonC1.enabled = true;
				GuiVC.buttonC1.visible = true;
			}
			
		}
    	if(!this.airship.inventory.getStackInSlot(2).isEmpty())
		{
			this.metaInfo = this.airship.inventory.getStackInSlot(2).getMetadata();
			
			if(this.metaInfo > this.airship.getMainTierFrame()
			&& this.metaInfo == (this.airship.getMainTierFrame() + 1))
			{
				GuiVC.buttonC2.enabled = true;
				GuiVC.buttonC2.visible = true;
			}
			
		}
    	if(!this.airship.inventory.getStackInSlot(3).isEmpty())
		{
			this.metaInfo = this.airship.inventory.getStackInSlot(3).getMetadata();
			
			if(this.metaInfo > this.airship.getMainTierEngine()
			&& this.metaInfo == (this.airship.getMainTierEngine() + 1))
			{
				GuiVC.buttonC3.enabled = true;
				GuiVC.buttonC3.visible = true;
			}
			
		}
    	if(!this.airship.inventory.getStackInSlot(4).isEmpty())
		{
			this.metaInfo = this.airship.inventory.getStackInSlot(4).getMetadata();
			
			if(this.metaInfo > this.airship.getMainTierBalloon()
			&& this.metaInfo == (this.airship.getMainTierBalloon() + 1))
			{
				GuiVC.buttonC4.enabled = true;
				GuiVC.buttonC4.visible = true;
			}
			
		}
    	
    	//Hides the button if airship is maxed
    	if(this.airship.getMainTierCore() >= 5)
    	{
    		GuiVC.buttonC1.visible = false;
    	}
    	if(this.airship.getMainTierFrame() >= 5)
    	{
    		GuiVC.buttonC2.visible = false;
    	}
    	if(this.airship.getMainTierEngine() >= 5)
    	{
    		GuiVC.buttonC3.visible = false;
    	}
    	if(this.airship.getMainTierBalloon() >= 5)
    	{
    		GuiVC.buttonC4.visible = false;
    	}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.upgrademenu"), 53, -10, Color.CYAN.getRGB());
		
		//Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(22.5, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.core"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMainTierCore() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(21, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, this.airship.getMainTierCore()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		//Frame
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(58, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.frame"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMainTierFrame() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(59, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, this.airship.getMainTierFrame()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		//Engine
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(95.5, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.engine"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMainTierEngine() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(97, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, this.airship.getMainTierEngine()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(132, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.balloon"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMainTierBalloon() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(135, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, this.airship.getMainTierBalloon()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		int tooltipFrameX = 22;
		int tooltipFrameY = 33;
		int isMaxedTooltip = 23;
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 0 && mouseX <= this.guiLeft + tooltipFrameX + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.1"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + EnumsVC.MainTierCore.byId(this.airship.mainTierCore).getStoredRedstone());
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.airship.getMainTierCore() == 5)
		{
			//Logic for mouse-over Core MAXED tooltip
			if(mouseX >= this.guiLeft + tooltipFrameX + 0 && mouseX <= this.guiLeft + tooltipFrameX + 17
			&& mouseY >= this.guiTop + isMaxedTooltip + tooltipFrameY + 0 && mouseY <= this.guiTop + isMaxedTooltip + tooltipFrameY + 17)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.2"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 26, mouseY - this.guiTop - 12, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Frame tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 38 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 38 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.1"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.2"));
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + "+" + this.airship.mainTierFrame);
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.airship.getMainTierFrame() == 5)
		{
			//Logic for mouse-over Frame MAXED tooltip
			if(mouseX >= this.guiLeft + tooltipFrameX + 38 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 38 + 17
			&& mouseY >= this.guiTop + isMaxedTooltip + tooltipFrameY + 0 && mouseY <= this.guiTop + isMaxedTooltip + tooltipFrameY + 17)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.2"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 26, mouseY - this.guiTop - 12, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Engine tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 76 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 76 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.1"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.2"));
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.RED + "-" + (EnumsVC.MainTierEngine.byId(this.airship.mainTierEngine).getFuelPerTick()));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.airship.getMainTierEngine() == 5)
		{
			//Logic for mouse-over Engine MAXED tooltip
			if(mouseX >= this.guiLeft + tooltipFrameX + 76 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 76 + 17
			&& mouseY >= this.guiTop + isMaxedTooltip + tooltipFrameY + 0 && mouseY <= this.guiTop + isMaxedTooltip + tooltipFrameY + 17)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.2"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 26, mouseY - this.guiTop - 12, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 114 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 114 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.1"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.2"));
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + (EnumsVC.MainTierBalloon.byId(this.airship.mainTierBalloon).getMaxAltitude()));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.airship.getMainTierBalloon() == 5)
		{
			//Logic for mouse-over Balloon MAXED tooltip
			if(mouseX >= this.guiLeft + tooltipFrameX + 114 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 114 + 17
			&& mouseY >= this.guiTop + isMaxedTooltip + tooltipFrameY + 0 && mouseY <= this.guiTop + isMaxedTooltip + tooltipFrameY + 17)
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.maxed.2"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 26, mouseY - this.guiTop - 12, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
	}
}

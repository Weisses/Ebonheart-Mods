package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipMenuStorageGreater;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiAirshipMenuStorageGreater extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_airship_menu_storage_greater.png");
	
	public GuiAirshipMenuStorageGreater(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipMenuStorageGreater(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
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
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 32, this.guiTop + 10 + (14 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 32, this.guiTop + 10 + (14 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 32, this.guiTop + 10 + (14 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 32, this.guiTop + 10 + (14 * 3), 36, 14, "", 3);
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		GuiVC.buttonM1.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		//if (parButton.id == 1)
	    //{
		//	  NetworkHandler.sendToServer(new MessageGuiAirshipMenu());
	    //}
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 3)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenu());
	    }
		if (parButton.id == 4)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draw "on" indicators
		if (this.airship.getPowered() > 0)
        {
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 9, 176, 19, 8, 1 + k);
            //left bulb
            this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 34, 176, 0, 9, 19);
            //right bulb
            this.drawTexturedModalRect(this.guiLeft + 161, this.guiTop + 34, 176 + 9, 0, 9, 19);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 9, 184, 19, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 22, 177, 67, 17, 17);
		}
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49+6, this.guiTop - 17, this.guiLeft + 127-6, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50+6, this.guiTop - 16, this.guiLeft + 126-6, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52+6, this.guiTop - 14, this.guiLeft + 124-6, this.guiTop, Color.BLACK.getRGB());
		
		//Draws a gray box over the red X if there is an item in the slot
		if(this.airship.getMetaTierCore() > 0)
		{
			this.drawRect(this.guiLeft + 21, this.guiTop + 41, this.guiLeft + 31, this.guiTop + 51, Color.GRAY.getRGB());
		}
		if(this.airship.getMetaTierFrame() > 0)
		{
			this.drawRect(this.guiLeft + 44, this.guiTop + 41, this.guiLeft + 54, this.guiTop + 51, Color.GRAY.getRGB());
		}
		if(this.airship.getMetaTierEngine() > 0)
		{
			this.drawRect(this.guiLeft + 67, this.guiTop + 41, this.guiLeft + 77, this.guiTop + 51, Color.GRAY.getRGB());
		}
		if(this.airship.getMetaTierBalloon() > 0)
		{
			this.drawRect(this.guiLeft + 90, this.guiTop + 41, this.guiLeft + 100, this.guiTop + 51, Color.GRAY.getRGB());
		}
		
		
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 15 && mouseX <= this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			this.drawTexturedModalRect(this.guiLeft + 14, this.guiTop + 28, 177, 83, 24, 28);
		}
		//Logic for mouse-over Frame tooltip
		if(mouseX >= 23 + this.guiLeft + 15 && mouseX <= 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			this.drawTexturedModalRect(this.guiLeft + 14 + 23, this.guiTop + 28, 177, 83, 24, 28);
		}
		//Logic for mouse-over Engine tooltip
		if(mouseX >= 23 + 23 + this.guiLeft + 15 && mouseX <= 23 + 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			this.drawTexturedModalRect(this.guiLeft + 14 + 23 + 23, this.guiTop + 28, 177, 83, 24, 28);
		}
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= 23 + 23 + 23 + this.guiLeft + 15 && mouseX <= 23 + 23 + 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			this.drawTexturedModalRect(this.guiLeft + 14 + 23 + 23 + 23, this.guiTop + 28, 177, 83, 24, 28);
		}
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(1);
        
        if (i == 0)
        {
        	i = this.airship.itemFuelStack + 1;
        }
        
        return this.airship.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.mainmenu"), 64, -10, 65535);
		this.fontRenderer.drawString(References.localNameVC("vc.main.fuel"), 145, 10, 16777215);
		
		//Speed
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(71.5 + 4, 11.25, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String speedIn = TextFormatting.BLACK + "-" + TextFormatting.GREEN + "+" + String.valueOf((int)(EnumsVC.AirshipTierFrame.byId(this.airship.metaTierFrame).getSpeedModifier() *100));
			
			if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.AirshipTierFrame.byId(this.airship.metaTierFrame).getSpeedModifier() *100)  + 1);
			}
			else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.AirshipTierFrame.byId(this.airship.metaTierFrame).getSpeedModifier() *100)  + 2);
			}
			else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.AirshipTierFrame.byId(this.airship.metaTierFrame).getSpeedModifier() *100)  + 3);
			}
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.speed") + ": " + speedIn, 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		
		//Fuel
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(71.5 + 9, 17, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String fuelIn = TextFormatting.RED + "-" + String.valueOf(this.airship.getAirshipFuelTick());
			
			if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
			{
				fuelIn = TextFormatting.GOLD + "-" + String.valueOf(this.airship.getAirshipFuelTick());
				
				if(this.airship.getMetaTierEngine() == 5)
				{
					fuelIn = TextFormatting.BLACK + "-" + TextFormatting.GOLD + "-" + String.valueOf(this.airship.getAirshipFuelTick());
				}
			}
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.fuel") + ": " + fuelIn, 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		
		//Altitude
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(71.5 + 0.1, 22.75, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String altitudeIn = TextFormatting.GREEN + String.valueOf((int)EnumsVC.AirshipTierBalloon.byId(this.airship.metaTierBalloon).getMaxAltitude());
			
			if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
			{
				altitudeIn = TextFormatting.AQUA + "225";
			}
			else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
			{
				altitudeIn = TextFormatting.AQUA + "250";
			}
			else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
			{
				altitudeIn = TextFormatting.BLACK + "ii" + TextFormatting.AQUA + "\u221e";
			}
			else if(this.airship.getMetaTierBalloon() == 0)
			{
				altitudeIn = TextFormatting.BLACK + "-" + TextFormatting.GREEN + String.valueOf((int)EnumsVC.AirshipTierBalloon.byId(this.airship.metaTierBalloon).getMaxAltitude());
			}
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.altitude") + ": " + altitudeIn, 0, 0, 16777215);
			
		}
		GlStateManager.popMatrix();
		
		
		
		//Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(19.5, 31.5, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.core"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(20, 40, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMetaTierCore() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_CORE, 1, this.airship.getMetaTierCore()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Frame
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(41, 31.5, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.frame"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(43, 40, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMetaTierFrame() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, this.airship.getMetaTierFrame()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		
		//Engine
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(63.5, 31.5, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.engine"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(66, 40, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMetaTierEngine() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, this.airship.getMetaTierEngine()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Balloon
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(85.5, 31.5, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.balloon"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(89, 40, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMetaTierBalloon() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, this.airship.getMetaTierBalloon()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Module Slot 1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(18.2, 10.5, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.slot1"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(18, 14, 0);
			GlStateManager.scale(1, 1, 1);
			
			if(this.airship.getModuleVariantSlot1() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, this.airship.getModuleVariantSlot1()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		
		
		//Logic for mouse-over Fuel tooltip
		if(mouseX >= this.guiLeft + 146 && mouseX <= this.guiLeft + 163
		&& mouseY >= this.guiTop + 21 && mouseY <= this.guiTop + 38
		&& this.airship.inventory.getStackInSlot(0).isEmpty())
		{
			if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				
			}
			else 
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("vc.gui.tt.fuel.1"));
				text.add(TextFormatting.YELLOW + References.localNameVC("vc.gui.tt.fuel.2"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop - 13, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 15 && mouseX <= this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 18, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Frame tooltip
		if(mouseX >= 23 + this.guiLeft + 15 && mouseX <= 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + "+" + this.airship.metaTierFrame);
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Engine tooltip
		if(mouseX >= 23 + 23 + this.guiLeft + 15 && mouseX <= 23 + 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.RED + "-" + (EnumsVC.AirshipTierEngine.byId(this.airship.metaTierEngine).getFuelPerTick()));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= 23 + 23 + 23 + this.guiLeft + 15 && mouseX <= 23 + 23 + 23 + this.guiLeft + 36
		&& mouseY >= this.guiTop + 30 && mouseY <= this.guiTop + 54)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + (EnumsVC.AirshipTierBalloon.byId(this.airship.metaTierBalloon).getMaxAltitude()));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	/**
     * Draws an ItemStack.
     */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
    
    public FontRenderer getFontRenderer()
    {
        return this.mc.fontRenderer;
    }
}

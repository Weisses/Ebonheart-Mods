package com.viesis.viescraft.client.gui.airship.customize.engine;

import java.awt.Color;
import java.util.Calendar;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.GuiButtonGeneral2VC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayBlocksPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySymbolsPg1;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineMain extends GuiContainerVC {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_4.png");
	
	public GuiCustomizeMenuEngineMain(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
		
		this.metaInfo = this.airship.engineDisplayIDVisual;
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
    	int startPlace = 95;
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 3);
		
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonT1 = new GuiButtonGeneral1VC(11, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 0), 69, 14, References.localNameVC("Symbols"), 0);
		GuiVC.buttonT2 = new GuiButtonGeneral1VC(12, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 1), 69, 14, References.localNameVC("Blocks"), 0);
		GuiVC.buttonT3 = new GuiButtonGeneral1VC(13, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 2), 69, 14, References.localNameVC("Items"), 0);
		GuiVC.buttonT4 = new GuiButtonGeneral1VC(14, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 3), 69, 14, References.localNameVC("Heads"), 0);
		GuiVC.buttonT5 = new GuiButtonGeneral1VC(15, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 4), 69, 14, References.localNameVC("Supporter Heads"), 0);
		
		//Holidays
		GuiVC.button11 = new GuiButtonGeneral2VC(111, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("  New Years  ", false)), 3);
		GuiVC.button12 = new GuiButtonGeneral2VC(112, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("Valentine's Day", false)), 3);
		GuiVC.button13 = new GuiButtonGeneral2VC(113, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("    Easter    ", false)), 3);
		GuiVC.button14 = new GuiButtonGeneral2VC(114, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("     4th of July     ", false)), 3);
		GuiVC.button15 = new GuiButtonGeneral2VC(115, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("   Halloween   ", false)), 3);
		GuiVC.button16 = new GuiButtonGeneral2VC(116, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("      Thanksgiving      ", false)), 3);
		GuiVC.button17 = new GuiButtonGeneral2VC(117, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow(" Christmas ", false)), 3);
		
		//Creative
		GuiVC.button01 = new GuiButtonGeneral2VC(101, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, References.localNameVC(this.stringToRainbow("  New Years  ", false)), 3);
		GuiVC.button02 = new GuiButtonGeneral2VC(102, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 1), 69, 14, References.localNameVC(this.stringToRainbow("Valentine's Day", false)), 3);
		GuiVC.button03 = new GuiButtonGeneral2VC(103, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 2), 69, 14, References.localNameVC(this.stringToRainbow("    Easter    ", false)), 3);
		GuiVC.button04 = new GuiButtonGeneral2VC(104, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 3), 69, 14, References.localNameVC(this.stringToRainbow("     4th of July     ", false)), 3);
		GuiVC.button05 = new GuiButtonGeneral2VC(105, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 4), 69, 14, References.localNameVC(this.stringToRainbow("   Halloween   ", false)), 3);
		GuiVC.button06 = new GuiButtonGeneral2VC(106, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 5), 69, 14, References.localNameVC(this.stringToRainbow("      Thanksgiving      ", false)), 3);
		GuiVC.button07 = new GuiButtonGeneral2VC(107, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 6), 69, 14, References.localNameVC(this.stringToRainbow(" Christmas ", false)), 3);
		
		GuiVC.buttonA16 = new GuiButtonGeneral1VC(16, this.guiLeft + 21, this.guiTop + 177, 60, 14, References.localNameVC("Particles"), 0);
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonT1);
		this.buttonList.add(GuiVC.buttonT2);
		this.buttonList.add(GuiVC.buttonT3);
		this.buttonList.add(GuiVC.buttonT4);
		this.buttonList.add(GuiVC.buttonT5);
		
		
		this.buttonList.add(GuiVC.buttonA16);
		
		GuiVC.buttonM3.enabled = false;
		
		if(Minecraft.getMinecraft().player.isCreative())
		{
			this.buttonList.add(GuiVC.button01);
			this.buttonList.add(GuiVC.button02);
			this.buttonList.add(GuiVC.button03);
			this.buttonList.add(GuiVC.button04);
			this.buttonList.add(GuiVC.button05);
			this.buttonList.add(GuiVC.button06);
			this.buttonList.add(GuiVC.button07);
		}
		else
		{
			if(References.isDateAroundHalloween(Calendar.getInstance()))
			{
				this.buttonList.add(GuiVC.button15);
			}
		}
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			//If airship has small inv module installed
        	if(this.airship.getModuleActiveSlot1() == 3)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageLesser());
        	}
        	//If airship has large inv module installed
        	else if(this.airship.getModuleActiveSlot1() == 4)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageGreater());
        	}
        	//If airship has jukebox module installed
        	else if(this.airship.getModuleActiveSlot1() == 10)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuMusic());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenu());
        	}
	    }
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 3)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		if (parButton.id == 4)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
		//Back to main customize gui menu
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplaySymbolsPg1());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplayBlocksPg1());
	    }
		if (parButton.id == 13)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier3Pg1());
	    }
		if (parButton.id == 14)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier4Pg1());
	    }
		if (parButton.id == 15)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier5Pg1());
	    }
		if (parButton.id == 16)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameColor());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 132, this.guiTop + 115, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden("Stored Redstone", 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.RED;
		
		if(this.airship.storedRedstone >= 500)
		{
			redstoneColor = Color.CYAN;
		}
		else if(this.airship.storedRedstone >= 375)
		{
			redstoneColor = Color.GREEN;
		}
		else if(this.airship.storedRedstone >= 250)
		{
			redstoneColor = Color.YELLOW;
		}
		else if(this.airship.storedRedstone >= 125)
		{
			redstoneColor = Color.ORANGE;
		}
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 77+48, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25+44, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 100+40, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
		this.drawRotatingItemStack(new ItemStack(ItemsVC.ITEM_DISPLAY_SYMBOL, 1, metaInfo), this.guiLeft + 51, this.guiTop + 80);
		
		this.drawEntityOnScreen(this.guiLeft + 134, this.guiTop + 100, 13, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.engine"), 72, 16, 11111111);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
        //Undo arrows
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(84, 180, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		

		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(51, 42, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, "Symbol Display", 0, 0, 1111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(51, 50, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "Current Symbol", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
    }
}

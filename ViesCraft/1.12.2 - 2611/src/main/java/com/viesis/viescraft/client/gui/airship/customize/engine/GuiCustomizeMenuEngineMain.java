package com.viesis.viescraft.client.gui.airship.customize.engine;

import java.awt.Color;
import java.util.Calendar;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayBlockItemPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplayHeadPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageGuiCustomizeMenuEngineDisplaySymbolPg1;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineMain extends GuiContainerVC {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_4.png");
	
	public GuiCustomizeMenuEngineMain(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.metaInfo = this.airship.engineDisplayTypeVisual;
		this.itemstackInfo = this.airship.engineDisplayItemstackVisual;
		this.itemstackMetaInfo = this.airship.engineDisplayItemstackMetaVisual;
		this.headInfo = this.airship.engineDisplayHeadVisual;
		this.supporterHeadInfo = this.airship.engineDisplaySupporterHeadVisual;
		this.holidayInfo = this.airship.engineDisplayHolidayVisual;
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
    	
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonT1 = new GuiButtonGeneral1VC(11, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 0), 69, 14, References.localNameVC("vc.button.symbols"), 0);
		GuiVC.buttonT2 = new GuiButtonGeneral1VC(12, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 1), 69, 14, References.localNameVC("vc.button.blockitems"), 0);
		GuiVC.buttonT3 = new GuiButtonGeneral1VC(14, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 2), 69, 14, References.localNameVC("vc.button.heads"), 0);
		GuiVC.buttonT4 = new GuiButtonGeneral1VC(15, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 3), 69, 14, References.localNameVC("vc.button.supporterheads"), 0);
		
		//Holidays
		GuiVC.button11 = new GuiButtonGeneral2VC(111, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.newyears"), false), 3);
		GuiVC.button12 = new GuiButtonGeneral2VC(112, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.valentinesday"), false), 3);
		GuiVC.button13 = new GuiButtonGeneral2VC(113, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.easter"), false), 3);
		GuiVC.button14 = new GuiButtonGeneral2VC(114, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.4thofjuly"), false), 3);
		GuiVC.button15 = new GuiButtonGeneral2VC(115, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.halloween"), false), 3);
		GuiVC.button16 = new GuiButtonGeneral2VC(116, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.thanksgiving"), false), 3);
		GuiVC.button17 = new GuiButtonGeneral2VC(117, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.christmas"), false), 3);
		
		//Creative
		GuiVC.button01 = new GuiButtonGeneral2VC(101, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 0), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.newyears"), false), 3);
		GuiVC.button02 = new GuiButtonGeneral2VC(102, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 1), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.valentinesday"), false), 3);
		GuiVC.button03 = new GuiButtonGeneral2VC(103, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 2), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.easter"), false), 3);
		GuiVC.button04 = new GuiButtonGeneral2VC(104, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 3), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.4thofjuly"), false), 3);
		GuiVC.button05 = new GuiButtonGeneral2VC(105, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 4), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.halloween"), false), 3);
		GuiVC.button06 = new GuiButtonGeneral2VC(106, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 5), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.thanksgiving"), false), 3);
		GuiVC.button07 = new GuiButtonGeneral2VC(107, this.guiLeft - 67, this.guiTop + startPlace - 4 + (14 * 6), 69, 14, this.stringToRainbow(References.localNameVC("vc.button.christmas"), false), 3);
		
		GuiVC.buttonA16 = new GuiButtonGeneral1VC(16, this.guiLeft + 21, this.guiTop + 177, 60, 14, References.localNameVC("vc.button.particles"), 0);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonT1);
		this.buttonList.add(GuiVC.buttonT2);
		this.buttonList.add(GuiVC.buttonT3);
		this.buttonList.add(GuiVC.buttonT4);
		
		//this.buttonList.add(GuiVC.buttonA16);
		
		GuiVC.buttonMM3.enabled = false;
		
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
		super.actionPerformed(parButton);
		
		//Back to main customize gui menu
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplaySymbolPg1());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplayBlockItemPg1());
	    }
		if (parButton.id == 13)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier3Pg1());
	    }
		if (parButton.id == 14)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplayHeadPg1());
	    }
		if (parButton.id == 15)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineDisplaySupporterHeadPg1());
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
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		//Block/Item
		if(this.airship.engineDisplayTypeVisual == 1)
		{
			this.drawRotatingItemStack(new ItemStack(Item.getItemById(this.airship.engineDisplayItemstackVisual), 1, this.airship.engineDisplayItemstackMetaVisual), this.guiLeft + 51, this.guiTop + 80);
		}
		//Head
		if(this.airship.engineDisplayTypeVisual == 2)
		{
			this.drawEntityHead(0, 0, this.headInfo);
		}
		//Supporter Head
		if(this.airship.engineDisplayTypeVisual == 3)
		{
			this.drawEntitySupporterHead(0, 0, this.supporterHeadInfo);
		}
		//Holiday
		if(this.airship.engineDisplayTypeVisual == 4)
		{
			//this.drawRotatingItemStack(new ItemStack(Item.getItemById(this.airship.engineDisplayItemstackVisual), 1, this.airship.engineDisplayItemstackMetaVisual), this.guiLeft + 51, this.guiTop + 80);
		}
		//Display Symbol
		if(this.airship.engineDisplayTypeVisual >= 10)
		{
			this.drawRotatingItemStack(new ItemStack(ItemsVC.ITEM_DISPLAY_SYMBOL, 1, this.airship.engineDisplayTypeVisual), this.guiLeft + 51, this.guiTop + 80);
		}
		
		this.drawEntityOnScreen(this.guiLeft + 134, this.guiTop + 100, 13, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
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

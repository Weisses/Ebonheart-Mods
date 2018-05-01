package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeEngineBlock;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItem;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItemDefault;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineDisplayBlockItemVC extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_6.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuEngineDisplayBlockItemVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeEngineBlock(playerInv, airshipIn), playerInv, airshipIn);
		
		this.itemstackInfo = this.airship.engineDisplayItemstackVisual;
		this.itemstackMetaInfo = this.airship.engineDisplayItemstackMetaVisual;
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
    	
		GuiVC.button502 = new GuiButtonGeneral2VC(502, this.guiLeft + 58, this.guiTop + 177, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVC.button503 = new GuiButtonGeneral1VC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVC.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 7, this.guiTop + 177, 48, 14, References.localNameVC("vc.button.apply"), 1);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 502)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayBlockItemDefault());
	    }
		if (parButton.id == 503)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineMain());
	    }
		if (parButton.id == 501)
	    {
			Item previousItem = Item.getItemById(this.airship.engineDisplayItemstackVisual);
			int previousMeta = this.airship.engineDisplayItemstackMetaVisual;
			
			Item currentItem = Item.getItemById(this.itemstackInfo);
			int currentMeta = this.itemstackMetaInfo;
			
			if(currentItem == previousItem)
			{
				if(currentMeta != previousMeta)
				{
					NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayBlockItem());
				}
			}
			else
			{
				NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayBlockItem());
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
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		if(!this.airship.inventory.getStackInSlot(18).isEmpty())
		{
			itemstackInfo = Item.getIdFromItem(this.airship.inventory.getStackInSlot(18).getItem());
			itemstackMetaInfo = this.airship.inventory.getStackInSlot(18).getMetadata();
		}
		else
		{
			itemstackInfo = 0;
			itemstackMetaInfo = 0;
		}
		
		Item previousItem = Item.getItemById(this.airship.engineDisplayItemstackVisual);
		int previousMeta = this.airship.engineDisplayItemstackMetaVisual;
		
		Item currentItem = Item.getItemById(this.itemstackInfo);
		int currentMeta = this.itemstackMetaInfo;
		
		if(this.airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST)
		{
			if(currentItem == previousItem)
			{
				if(currentMeta != previousMeta)
				{
					GuiVC.button501.enabled = true;
				}
				else
				{
					GuiVC.button501.enabled = false;
				}
			}
			else if(currentItem != previousItem)
			{
				GuiVC.button501.enabled = true;
			}
			else
			{
				GuiVC.button501.enabled = false;
			}
		}
		else
		{
			GuiVC.button501.enabled = false;
		}
	
		this.drawRotatingItemStack(new ItemStack(Item.getItemById(itemstackInfo), 1, itemstackMetaInfo), this.guiLeft + 134, this.guiTop + 70);
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 105.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46, this.guiTop + 77+34, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.ENGINE_DISPLAY_SYMBOL_COST), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Reset tooltip
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
		&& mouseY >= this.guiTop + 143 && mouseY <= this.guiTop + 156)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Default skin, costs nothing!"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 38, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
    }
}

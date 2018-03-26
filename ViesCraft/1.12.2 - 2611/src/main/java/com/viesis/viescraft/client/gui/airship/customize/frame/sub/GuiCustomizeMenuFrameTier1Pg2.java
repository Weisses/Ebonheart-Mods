package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier1Pg2 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier1Pg2(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
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
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.reset"), 1);
    	GuiVC.button504 = new GuiButtonGeneralVC(504, this.guiLeft + 2, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonA13 = new GuiButtonGeneralVC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.13"), 0);
		GuiVC.buttonA14 = new GuiButtonGeneralVC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.14"), 0);
		GuiVC.buttonA15 = new GuiButtonGeneralVC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.15"), 0);
		GuiVC.buttonA16 = new GuiButtonGeneralVC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.16"), 0);
		GuiVC.buttonA17 = new GuiButtonGeneralVC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.17"), 0);
		GuiVC.buttonA18 = new GuiButtonGeneralVC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.18"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA13);
		this.buttonList.add(GuiVC.buttonA14);
		this.buttonList.add(GuiVC.buttonA15);
		this.buttonList.add(GuiVC.buttonA16);
		this.buttonList.add(GuiVC.buttonA17);
		this.buttonList.add(GuiVC.buttonA18);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		this.fontRenderer.drawString(References.localNameVC("vc.enum.tier.1"), 120, 26, 16777215);
    }
}

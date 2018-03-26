package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier5Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier5Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.reset"), 0);
		GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonA55 = new GuiButtonGeneralVC(55, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.55"), 0);
		GuiVC.buttonA56 = new GuiButtonGeneralVC(56, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.56"), 0);
		GuiVC.buttonA57 = new GuiButtonGeneralVC(57, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.57"), 0);
		GuiVC.buttonA58 = new GuiButtonGeneralVC(58, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.58"), 0);
		GuiVC.buttonA59 = new GuiButtonGeneralVC(59, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.59"), 0);
		GuiVC.buttonA60 = new GuiButtonGeneralVC(60, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.60"), 0);
		
		GuiVC.buttonA61 = new GuiButtonGeneralVC(61, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.61"), 0);
		GuiVC.buttonA62 = new GuiButtonGeneralVC(62, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.62"), 0);
		GuiVC.buttonA63 = new GuiButtonGeneralVC(63, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.63"), 0);
		GuiVC.buttonA64 = new GuiButtonGeneralVC(64, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.64"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA55);
		this.buttonList.add(GuiVC.buttonA56);
		this.buttonList.add(GuiVC.buttonA57);
		this.buttonList.add(GuiVC.buttonA58);
		this.buttonList.add(GuiVC.buttonA59);
		this.buttonList.add(GuiVC.buttonA60);

		this.buttonList.add(GuiVC.buttonA61);
		this.buttonList.add(GuiVC.buttonA62);
		this.buttonList.add(GuiVC.buttonA63);
		this.buttonList.add(GuiVC.buttonA64);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
		this.fontRenderer.drawString(References.localNameVC("vc.enum.tier.5"), 120, 26, 16777215);
    }
}

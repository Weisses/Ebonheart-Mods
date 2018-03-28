package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

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
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
		GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
		GuiVC.button501 = new GuiButtonGeneralVC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
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
		this.buttonList.add(GuiVC.button501);
		
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
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 55)
    	{
    		GuiVC.buttonA55.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA55.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 56)
    	{
    		GuiVC.buttonA56.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA56.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 57)
    	{
    		GuiVC.buttonA57.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA57.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 58)
    	{
    		GuiVC.buttonA58.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA58.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 59)
    	{
    		GuiVC.buttonA59.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA59.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 60)
    	{
    		GuiVC.buttonA60.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA60.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 61)
    	{
    		GuiVC.buttonA61.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA61.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 62)
    	{
    		GuiVC.buttonA62.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA62.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 63)
    	{
    		GuiVC.buttonA63.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA63.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 64)
    	{
    		GuiVC.buttonA64.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA64.enabled = true;
    	}/**
    	if(this.airship.frameSkinTexture == 65)
    	{
    		GuiVC.buttonA65.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA65.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 66)
    	{
    		GuiVC.buttonA66.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA66.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 67)
    	{
    		GuiVC.buttonA67.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA67.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 68)
    	{
    		GuiVC.buttonA68.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA68.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 69)
    	{
    		GuiVC.buttonA69.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA69.enabled = true;
    	}*/
    }
}

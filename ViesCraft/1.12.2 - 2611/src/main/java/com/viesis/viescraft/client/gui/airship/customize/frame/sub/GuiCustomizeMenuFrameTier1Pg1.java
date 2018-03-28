package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier1Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier1Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	GuiVC.button503 = new GuiButtonGeneralVC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVC.button501 = new GuiButtonGeneralVC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	GuiVC.buttonA01 = new GuiButtonGeneralVC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.1"), 0);
		GuiVC.buttonA02 = new GuiButtonGeneralVC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.2"), 0);
		GuiVC.buttonA03 = new GuiButtonGeneralVC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.3"), 0);
		GuiVC.buttonA04 = new GuiButtonGeneralVC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.4"), 0);
		GuiVC.buttonA05 = new GuiButtonGeneralVC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.5"), 0);
		GuiVC.buttonA06 = new GuiButtonGeneralVC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.6"), 0);
		
		GuiVC.buttonA07 = new GuiButtonGeneralVC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.7"), 0);
		GuiVC.buttonA08 = new GuiButtonGeneralVC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.8"), 0);
		GuiVC.buttonA09 = new GuiButtonGeneralVC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.9"), 0);
		GuiVC.buttonA10 = new GuiButtonGeneralVC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.10"), 0);
		GuiVC.buttonA11 = new GuiButtonGeneralVC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.11"), 0);
		GuiVC.buttonA12 = new GuiButtonGeneralVC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.12"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonA01);
		this.buttonList.add(GuiVC.buttonA02);
		this.buttonList.add(GuiVC.buttonA03);
		this.buttonList.add(GuiVC.buttonA04);
		this.buttonList.add(GuiVC.buttonA05);
		this.buttonList.add(GuiVC.buttonA06);

		this.buttonList.add(GuiVC.buttonA07);
		this.buttonList.add(GuiVC.buttonA08);
		this.buttonList.add(GuiVC.buttonA09);
		this.buttonList.add(GuiVC.buttonA10);
		this.buttonList.add(GuiVC.buttonA11);
		this.buttonList.add(GuiVC.buttonA12);
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 1)
    	{
    		GuiVC.buttonA01.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA01.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 2)
    	{
    		GuiVC.buttonA02.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA02.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 3)
    	{
    		GuiVC.buttonA03.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA03.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 4)
    	{
    		GuiVC.buttonA04.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA04.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 5)
    	{
    		GuiVC.buttonA05.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA05.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 6)
    	{
    		GuiVC.buttonA06.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA06.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 7)
    	{
    		GuiVC.buttonA07.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA07.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 8)
    	{
    		GuiVC.buttonA08.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA08.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 9)
    	{
    		GuiVC.buttonA09.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA09.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 10)
    	{
    		GuiVC.buttonA10.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA10.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 11)
    	{
    		GuiVC.buttonA11.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA11.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 12)
    	{
    		GuiVC.buttonA12.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA12.enabled = true;
    	}
    }
}

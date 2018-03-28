package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier1Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier1Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonB01 = new GuiButtonGeneralVC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.1"), 0);
		GuiVC.buttonB02 = new GuiButtonGeneralVC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.2"), 0);
		GuiVC.buttonB03 = new GuiButtonGeneralVC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.3"), 0);
		GuiVC.buttonB04 = new GuiButtonGeneralVC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.4"), 0);
		GuiVC.buttonB05 = new GuiButtonGeneralVC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.5"), 0);
		GuiVC.buttonB06 = new GuiButtonGeneralVC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.6"), 0);
		
		GuiVC.buttonB07 = new GuiButtonGeneralVC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualballoon.7"), 0);
		GuiVC.buttonB08 = new GuiButtonGeneralVC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualballoon.8"), 0);
		GuiVC.buttonB09 = new GuiButtonGeneralVC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualballoon.9"), 0);
		GuiVC.buttonB10 = new GuiButtonGeneralVC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualballoon.10"), 0);
		GuiVC.buttonB11 = new GuiButtonGeneralVC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualballoon.11"), 0);
		GuiVC.buttonB12 = new GuiButtonGeneralVC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualballoon.12"), 0);
		
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonB01);
		this.buttonList.add(GuiVC.buttonB02);
		this.buttonList.add(GuiVC.buttonB03);
		this.buttonList.add(GuiVC.buttonB04);
		this.buttonList.add(GuiVC.buttonB05);
		this.buttonList.add(GuiVC.buttonB06);

		//this.buttonList.add(GuiVC.buttonB07);
		//this.buttonList.add(GuiVC.buttonB08);
		//this.buttonList.add(GuiVC.buttonB09);
		//this.buttonList.add(GuiVC.buttonB10);
		//this.buttonList.add(GuiVC.buttonB11);
		//this.buttonList.add(GuiVC.buttonB12);
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
    		GuiVC.buttonB01.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB01.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 2)
    	{
    		GuiVC.buttonB02.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB02.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 3)
    	{
    		GuiVC.buttonB03.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB03.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 4)
    	{
    		GuiVC.buttonB04.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB04.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 5)
    	{
    		GuiVC.buttonB05.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB05.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 6)
    	{
    		GuiVC.buttonB06.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB06.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 7)
    	{
    		GuiVC.buttonB07.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB07.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 8)
    	{
    		GuiVC.buttonB08.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB08.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 9)
    	{
    		GuiVC.buttonB09.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB09.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 10)
    	{
    		GuiVC.buttonB10.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB10.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 11)
    	{
    		GuiVC.buttonB11.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB11.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 12)
    	{
    		GuiVC.buttonB12.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB12.enabled = true;
    	}
    }
}

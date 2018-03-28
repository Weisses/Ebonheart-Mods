package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier5Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier5Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonB55 = new GuiButtonGeneralVC(55, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.55"), 0);
		GuiVC.buttonB56 = new GuiButtonGeneralVC(56, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.56"), 0);
		GuiVC.buttonB57 = new GuiButtonGeneralVC(57, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.57"), 0);
		GuiVC.buttonB58 = new GuiButtonGeneralVC(58, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.58"), 0);
		GuiVC.buttonB59 = new GuiButtonGeneralVC(59, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.59"), 0);
		GuiVC.buttonB60 = new GuiButtonGeneralVC(60, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.60"), 0);
		
		GuiVC.buttonB61 = new GuiButtonGeneralVC(61, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualballoon.61"), 0);
		GuiVC.buttonB62 = new GuiButtonGeneralVC(62, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualballoon.62"), 0);
		GuiVC.buttonB63 = new GuiButtonGeneralVC(63, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualballoon.63"), 0);
		GuiVC.buttonB64 = new GuiButtonGeneralVC(64, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualballoon.64"), 0);
		GuiVC.buttonB65 = new GuiButtonGeneralVC(65, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualballoon.65"), 0);
		GuiVC.buttonB66 = new GuiButtonGeneralVC(66, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualballoon.66"), 0);
		
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonB55);
		this.buttonList.add(GuiVC.buttonB56);
		this.buttonList.add(GuiVC.buttonB57);
		this.buttonList.add(GuiVC.buttonB58);
		this.buttonList.add(GuiVC.buttonB59);
		this.buttonList.add(GuiVC.buttonB60);

		this.buttonList.add(GuiVC.buttonB61);
		this.buttonList.add(GuiVC.buttonB62);
		this.buttonList.add(GuiVC.buttonB63);
		//this.buttonList.add(GuiVC.buttonB64);
		//this.buttonList.add(GuiVC.buttonB65);
		//this.buttonList.add(GuiVC.buttonB66);
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

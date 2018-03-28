package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier1Pg2 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier1Pg2(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonB13 = new GuiButtonGeneralVC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.1"), 0);
		GuiVC.buttonB14 = new GuiButtonGeneralVC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.2"), 0);
		GuiVC.buttonB15 = new GuiButtonGeneralVC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.3"), 0);
		GuiVC.buttonB16 = new GuiButtonGeneralVC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.4"), 0);
		GuiVC.buttonB17 = new GuiButtonGeneralVC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.5"), 0);
		GuiVC.buttonB18 = new GuiButtonGeneralVC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.6"), 0);
		
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
		
		this.buttonList.add(GuiVC.buttonB13);
		this.buttonList.add(GuiVC.buttonB14);
		this.buttonList.add(GuiVC.buttonB15);
		this.buttonList.add(GuiVC.buttonB16);
		this.buttonList.add(GuiVC.buttonB17);
		this.buttonList.add(GuiVC.buttonB18);

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
    	if(this.airship.frameSkinTexture == 13)
    	{
    		GuiVC.buttonB13.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB13.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 14)
    	{
    		GuiVC.buttonB14.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB14.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 15)
    	{
    		GuiVC.buttonB15.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB15.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 16)
    	{
    		GuiVC.buttonB16.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB16.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 17)
    	{
    		GuiVC.buttonB17.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB17.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 18)
    	{
    		GuiVC.buttonB18.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB18.enabled = true;
    	}
    }
}

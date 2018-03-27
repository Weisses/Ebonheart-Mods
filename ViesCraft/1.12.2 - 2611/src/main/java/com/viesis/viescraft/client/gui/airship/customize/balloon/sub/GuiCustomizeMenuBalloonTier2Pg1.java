package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier2Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier2Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonB19 = new GuiButtonGeneralVC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.19"), 0);
		GuiVC.buttonB20 = new GuiButtonGeneralVC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.20"), 0);
		GuiVC.buttonB21 = new GuiButtonGeneralVC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.21"), 0);
		GuiVC.buttonB22 = new GuiButtonGeneralVC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.22"), 0);
		GuiVC.buttonB23 = new GuiButtonGeneralVC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.23"), 0);
		GuiVC.buttonB24 = new GuiButtonGeneralVC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.24"), 0);
		
		GuiVC.buttonB25 = new GuiButtonGeneralVC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualballoon.25"), 0);
		GuiVC.buttonB26 = new GuiButtonGeneralVC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualballoon.26"), 0);
		GuiVC.buttonB27 = new GuiButtonGeneralVC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualballoon.27"), 0);
		GuiVC.buttonB28 = new GuiButtonGeneralVC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualballoon.28"), 0);
		GuiVC.buttonB29 = new GuiButtonGeneralVC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualballoon.29"), 0);
		GuiVC.buttonB30 = new GuiButtonGeneralVC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualballoon.30"), 0);
		
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonB19);
		this.buttonList.add(GuiVC.buttonB20);
		this.buttonList.add(GuiVC.buttonB21);
		//this.buttonList.add(GuiVC.buttonB22);
		//this.buttonList.add(GuiVC.buttonB23);
		//this.buttonList.add(GuiVC.buttonB24);

		//this.buttonList.add(GuiVC.buttonB25);
		//this.buttonList.add(GuiVC.buttonB26);
		//this.buttonList.add(GuiVC.buttonB27);
		//this.buttonList.add(GuiVC.buttonB28);
		//this.buttonList.add(GuiVC.buttonB29);
		//this.buttonList.add(GuiVC.buttonB30);
    }
}

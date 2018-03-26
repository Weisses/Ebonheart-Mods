package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier4Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier4Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonA43 = new GuiButtonGeneralVC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.43"), 0);
		GuiVC.buttonA44 = new GuiButtonGeneralVC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.44"), 0);
		GuiVC.buttonA45 = new GuiButtonGeneralVC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.45"), 0);
		GuiVC.buttonA46 = new GuiButtonGeneralVC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.46"), 0);
		GuiVC.buttonA47 = new GuiButtonGeneralVC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.47"), 0);
		GuiVC.buttonA48 = new GuiButtonGeneralVC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.48"), 0);
		
		GuiVC.buttonA49 = new GuiButtonGeneralVC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.49"), 0);
		GuiVC.buttonA50 = new GuiButtonGeneralVC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.50"), 0);
		GuiVC.buttonA51 = new GuiButtonGeneralVC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.51"), 0);
		GuiVC.buttonA52 = new GuiButtonGeneralVC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.52"), 0);
		GuiVC.buttonA53 = new GuiButtonGeneralVC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.53"), 0);
		GuiVC.buttonA54 = new GuiButtonGeneralVC(54, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.54"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonA43);
		this.buttonList.add(GuiVC.buttonA44);
		this.buttonList.add(GuiVC.buttonA45);
		this.buttonList.add(GuiVC.buttonA46);
		this.buttonList.add(GuiVC.buttonA47);
		this.buttonList.add(GuiVC.buttonA48);

		this.buttonList.add(GuiVC.buttonA49);
		this.buttonList.add(GuiVC.buttonA50);
		this.buttonList.add(GuiVC.buttonA51);
		this.buttonList.add(GuiVC.buttonA52);
		this.buttonList.add(GuiVC.buttonA53);
		this.buttonList.add(GuiVC.buttonA54);
    }
}

package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier3Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier3Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonA31 = new GuiButtonGeneralVC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.31"), 0);
		GuiVC.buttonA32 = new GuiButtonGeneralVC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.32"), 0);
		GuiVC.buttonA33 = new GuiButtonGeneralVC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.33"), 0);
		GuiVC.buttonA34 = new GuiButtonGeneralVC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.34"), 0);
		GuiVC.buttonA35 = new GuiButtonGeneralVC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.35"), 0);
		GuiVC.buttonA36 = new GuiButtonGeneralVC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.36"), 0);
		
		GuiVC.buttonA37 = new GuiButtonGeneralVC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.37"), 0);
		GuiVC.buttonA38 = new GuiButtonGeneralVC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.38"), 0);
		GuiVC.buttonA39 = new GuiButtonGeneralVC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.39"), 0);
		GuiVC.buttonA40 = new GuiButtonGeneralVC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.40"), 0);
		GuiVC.buttonA41 = new GuiButtonGeneralVC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.41"), 0);
		GuiVC.buttonA42 = new GuiButtonGeneralVC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.42"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonA31);
		this.buttonList.add(GuiVC.buttonA32);
		this.buttonList.add(GuiVC.buttonA33);
		this.buttonList.add(GuiVC.buttonA34);
		this.buttonList.add(GuiVC.buttonA35);
		this.buttonList.add(GuiVC.buttonA36);

		this.buttonList.add(GuiVC.buttonA37);
		this.buttonList.add(GuiVC.buttonA38);
		this.buttonList.add(GuiVC.buttonA39);
		this.buttonList.add(GuiVC.buttonA40);
		this.buttonList.add(GuiVC.buttonA41);
		this.buttonList.add(GuiVC.buttonA42);
    }
}

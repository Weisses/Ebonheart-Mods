package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier3Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier3Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonB31 = new GuiButtonGeneralVC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.31"), 0);
		GuiVC.buttonB32 = new GuiButtonGeneralVC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.32"), 0);
		GuiVC.buttonB33 = new GuiButtonGeneralVC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.33"), 0);
		GuiVC.buttonB34 = new GuiButtonGeneralVC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.34"), 0);
		GuiVC.buttonB35 = new GuiButtonGeneralVC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.35"), 0);
		GuiVC.buttonB36 = new GuiButtonGeneralVC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.36"), 0);
		
		GuiVC.buttonB37 = new GuiButtonGeneralVC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualballoon.37"), 0);
		GuiVC.buttonB38 = new GuiButtonGeneralVC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualballoon.38"), 0);
		GuiVC.buttonB39 = new GuiButtonGeneralVC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualballoon.39"), 0);
		GuiVC.buttonB40 = new GuiButtonGeneralVC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualballoon.40"), 0);
		GuiVC.buttonB41 = new GuiButtonGeneralVC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualballoon.41"), 0);
		GuiVC.buttonB42 = new GuiButtonGeneralVC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualballoon.42"), 0);
		
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonB31);
		this.buttonList.add(GuiVC.buttonB32);
		this.buttonList.add(GuiVC.buttonB33);
		this.buttonList.add(GuiVC.buttonB34);
		this.buttonList.add(GuiVC.buttonB35);
		this.buttonList.add(GuiVC.buttonB36);

		//this.buttonList.add(GuiVC.buttonB37);
		//this.buttonList.add(GuiVC.buttonB38);
		//this.buttonList.add(GuiVC.buttonB39);
		//this.buttonList.add(GuiVC.buttonB40);
		//this.buttonList.add(GuiVC.buttonB41);
		//this.buttonList.add(GuiVC.buttonB42);
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 31)
    	{
    		GuiVC.buttonB31.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB31.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 32)
    	{
    		GuiVC.buttonB32.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB32.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 33)
    	{
    		GuiVC.buttonB33.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB33.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 34)
    	{
    		GuiVC.buttonB34.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB34.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 35)
    	{
    		GuiVC.buttonB35.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB35.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 36)
    	{
    		GuiVC.buttonB36.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB36.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 37)
    	{
    		GuiVC.buttonB37.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB37.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 38)
    	{
    		GuiVC.buttonB38.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB38.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 39)
    	{
    		GuiVC.buttonB39.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB39.enabled = true;
    	}

    	if(this.airship.frameSkinTexture == 40)
    	{
    		GuiVC.buttonB40.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB40.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 41)
    	{
    		GuiVC.buttonB41.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB41.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 42)
    	{
    		GuiVC.buttonB42.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB42.enabled = true;
    	}
    }
}

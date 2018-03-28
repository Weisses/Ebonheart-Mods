package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier2Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier2Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.buttonA19 = new GuiButtonGeneralVC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.19"), 0);
		GuiVC.buttonA20 = new GuiButtonGeneralVC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.20"), 0);
		GuiVC.buttonA21 = new GuiButtonGeneralVC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.21"), 0);
		GuiVC.buttonA22 = new GuiButtonGeneralVC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.22"), 0);
		GuiVC.buttonA23 = new GuiButtonGeneralVC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.23"), 0);
		GuiVC.buttonA24 = new GuiButtonGeneralVC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.24"), 0);
		
		GuiVC.buttonA25 = new GuiButtonGeneralVC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.25"), 0);
		GuiVC.buttonA26 = new GuiButtonGeneralVC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.26"), 0);
		GuiVC.buttonA27 = new GuiButtonGeneralVC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.27"), 0);
		GuiVC.buttonA28 = new GuiButtonGeneralVC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.28"), 0);
		GuiVC.buttonA29 = new GuiButtonGeneralVC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.29"), 0);
		GuiVC.buttonA30 = new GuiButtonGeneralVC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.30"), 0);
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonA19);
		this.buttonList.add(GuiVC.buttonA20);
		this.buttonList.add(GuiVC.buttonA21);
		this.buttonList.add(GuiVC.buttonA22);
		this.buttonList.add(GuiVC.buttonA23);
		this.buttonList.add(GuiVC.buttonA24);

		this.buttonList.add(GuiVC.buttonA25);
		this.buttonList.add(GuiVC.buttonA26);
		this.buttonList.add(GuiVC.buttonA27);
		this.buttonList.add(GuiVC.buttonA28);
		this.buttonList.add(GuiVC.buttonA29);
		this.buttonList.add(GuiVC.buttonA30);
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 19)
    	{
    		GuiVC.buttonA19.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA19.enabled = true;
    	}

    	if(this.airship.frameSkinTexture == 20)
    	{
    		GuiVC.buttonA20.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA20.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 21)
    	{
    		GuiVC.buttonA21.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA21.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 22)
    	{
    		GuiVC.buttonA22.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA22.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 23)
    	{
    		GuiVC.buttonA23.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA23.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 24)
    	{
    		GuiVC.buttonA24.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA24.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 25)
    	{
    		GuiVC.buttonA25.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA25.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 26)
    	{
    		GuiVC.buttonA26.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA26.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 27)
    	{
    		GuiVC.buttonA27.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA27.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 28)
    	{
    		GuiVC.buttonA28.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA28.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 29)
    	{
    		GuiVC.buttonA29.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA29.enabled = true;
    	}

    	if(this.airship.frameSkinTexture == 30)
    	{
    		GuiVC.buttonA30.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA30.enabled = true;
    	}
    }
}

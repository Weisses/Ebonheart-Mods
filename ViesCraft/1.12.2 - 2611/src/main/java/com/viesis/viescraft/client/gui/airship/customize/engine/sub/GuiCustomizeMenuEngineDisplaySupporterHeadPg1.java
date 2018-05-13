package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuEngineDisplaySupporterHeadPg1 extends GuiCustomizeMenuEngineDisplaySupporterHeadVC {
	
	public GuiCustomizeMenuEngineDisplaySupporterHeadPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
    	
    	this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.button01);
		this.buttonList.add(GuiVC.button02);
		this.buttonList.add(GuiVC.button03);
		this.buttonList.add(GuiVC.button04);
/**		this.buttonList.add(GuiVC.button05);
		this.buttonList.add(GuiVC.button06);
		this.buttonList.add(GuiVC.button07);
		this.buttonList.add(GuiVC.button08);
		this.buttonList.add(GuiVC.button09);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);*/
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& this.supporterHeadInfo != this.airship.engineDisplaySupporterHeadVisual)
		{
			GuiVC.button501.enabled = true;
		}
		else
		{
			GuiVC.button501.enabled = false;
		}
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.supporterHeadInfo == 1)
    	{
    		GuiVC.button01.enabled = false;
    	}
    	else
    	{
    		GuiVC.button01.enabled = true;
    	}
    	if(this.supporterHeadInfo == 2)
    	{
    		GuiVC.button02.enabled = false;
    	}
    	else
    	{
    		GuiVC.button02.enabled = true;
    	}
    	if(this.supporterHeadInfo == 3)
    	{
    		GuiVC.button03.enabled = false;
    	}
    	else
    	{
    		GuiVC.button03.enabled = true;
    	}
    	if(this.supporterHeadInfo == 4)
    	{
    		GuiVC.button04.enabled = false;
    	}
    	else
    	{
    		GuiVC.button04.enabled = true;
    	}
    	if(this.supporterHeadInfo == 5)
    	{
    		GuiVC.button05.enabled = false;
    	}
    	else
    	{
    		GuiVC.button05.enabled = true;
    	}
    	if(this.supporterHeadInfo == 6)
    	{
    		GuiVC.button06.enabled = false;
    	}
    	else
    	{
    		GuiVC.button06.enabled = true;
    	}
    	if(this.supporterHeadInfo == 7)
    	{
    		GuiVC.button07.enabled = false;
    	}
    	else
    	{
    		GuiVC.button07.enabled = true;
    	}
    	if(this.supporterHeadInfo == 8)
    	{
    		GuiVC.button08.enabled = false;
    	}
    	else
    	{
    		GuiVC.button08.enabled = true;
    	}
    	if(this.supporterHeadInfo == 9)
    	{
    		GuiVC.button09.enabled = false;
    	}
    	else
    	{
    		GuiVC.button09.enabled = true;
    	}
    	if(this.supporterHeadInfo == 10)
    	{
    		GuiVC.button10.enabled = false;
    	}
    	else
    	{
    		GuiVC.button10.enabled = true;
    	}
    	if(this.supporterHeadInfo == 11)
    	{
    		GuiVC.button11.enabled = false;
    	}
    	else
    	{
    		GuiVC.button11.enabled = true;
    	}
    	if(this.supporterHeadInfo == 12)
    	{
    		GuiVC.button12.enabled = false;
    	}
    	else
    	{
    		GuiVC.button12.enabled = true;
    	}
    }
}

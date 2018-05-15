package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuEngineDisplayHolidayPg1 extends GuiCustomizeMenuEngineDisplayHeadVC {
	
	public GuiCustomizeMenuEngineDisplayHolidayPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVC.button00);
		this.buttonList.add(GuiVC.button01);
		this.buttonList.add(GuiVC.button02);
		this.buttonList.add(GuiVC.button03);
		this.buttonList.add(GuiVC.button04);
		this.buttonList.add(GuiVC.button05);
		
		this.buttonList.add(GuiVC.button06);
		this.buttonList.add(GuiVC.button07);
		this.buttonList.add(GuiVC.button08);
		this.buttonList.add(GuiVC.button09);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	/**
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
    	*/
    }
}

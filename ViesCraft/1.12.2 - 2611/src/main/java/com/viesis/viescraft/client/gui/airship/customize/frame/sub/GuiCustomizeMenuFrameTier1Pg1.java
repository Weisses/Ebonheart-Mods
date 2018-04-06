package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuFrameTier1Pg1 extends GuiCustomizeMenuFrameTierVC {
	
	public GuiCustomizeMenuFrameTier1Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	this.buttonList.add(GuiVC.button501);
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button503);
		//this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
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
		this.buttonList.add(GuiVC.button12);
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
    		GuiVC.button01.enabled = false;
    	}
    	else
    	{
    		GuiVC.button01.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 2)
    	{
    		GuiVC.button02.enabled = false;
    	}
    	else
    	{
    		GuiVC.button02.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 3)
    	{
    		GuiVC.button03.enabled = false;
    	}
    	else
    	{
    		GuiVC.button03.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 4)
    	{
    		GuiVC.button04.enabled = false;
    	}
    	else
    	{
    		GuiVC.button04.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 5)
    	{
    		GuiVC.button05.enabled = false;
    	}
    	else
    	{
    		GuiVC.button05.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 6)
    	{
    		GuiVC.button06.enabled = false;
    	}
    	else
    	{
    		GuiVC.button06.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 7)
    	{
    		GuiVC.button07.enabled = false;
    	}
    	else
    	{
    		GuiVC.button07.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 8)
    	{
    		GuiVC.button08.enabled = false;
    	}
    	else
    	{
    		GuiVC.button08.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 9)
    	{
    		GuiVC.button09.enabled = false;
    	}
    	else
    	{
    		GuiVC.button09.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 10)
    	{
    		GuiVC.button10.enabled = false;
    	}
    	else
    	{
    		GuiVC.button10.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 11)
    	{
    		GuiVC.button11.enabled = false;
    	}
    	else
    	{
    		GuiVC.button11.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 12)
    	{
    		GuiVC.button12.enabled = false;
    	}
    	else
    	{
    		GuiVC.button12.enabled = true;
    	}
    }
}

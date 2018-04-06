package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
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
    	
    	this.buttonList.add(GuiVC.button501);
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		//this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.button31);
		this.buttonList.add(GuiVC.button32);
		this.buttonList.add(GuiVC.button33);
		this.buttonList.add(GuiVC.button34);
		this.buttonList.add(GuiVC.button35);
		this.buttonList.add(GuiVC.button36);
		
		this.buttonList.add(GuiVC.button37);
		this.buttonList.add(GuiVC.button38);
		this.buttonList.add(GuiVC.button39);
		this.buttonList.add(GuiVC.button40);
		this.buttonList.add(GuiVC.button41);
		this.buttonList.add(GuiVC.button42);
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
    		GuiVC.button31.enabled = false;
    	}
    	else
    	{
    		GuiVC.button31.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 32)
    	{
    		GuiVC.button32.enabled = false;
    	}
    	else
    	{
    		GuiVC.button32.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 33)
    	{
    		GuiVC.button33.enabled = false;
    	}
    	else
    	{
    		GuiVC.button33.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 34)
    	{
    		GuiVC.button34.enabled = false;
    	}
    	else
    	{
    		GuiVC.button34.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 35)
    	{
    		GuiVC.button35.enabled = false;
    	}
    	else
    	{
    		GuiVC.button35.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 36)
    	{
    		GuiVC.button36.enabled = false;
    	}
    	else
    	{
    		GuiVC.button36.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 37)
    	{
    		GuiVC.button37.enabled = false;
    	}
    	else
    	{
    		GuiVC.button37.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 38)
    	{
    		GuiVC.button38.enabled = false;
    	}
    	else
    	{
    		GuiVC.button38.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 39)
    	{
    		GuiVC.button39.enabled = false;
    	}
    	else
    	{
    		GuiVC.button39.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 40)
    	{
    		GuiVC.button40.enabled = false;
    	}
    	else
    	{
    		GuiVC.button40.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 41)
    	{
    		GuiVC.button41.enabled = false;
    	}
    	else
    	{
    		GuiVC.button41.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 42)
    	{
    		GuiVC.button42.enabled = false;
    	}
    	else
    	{
    		GuiVC.button42.enabled = true;
    	}
    }
}

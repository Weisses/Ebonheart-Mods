package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
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
    	
    	this.buttonList.add(GuiVC.button501);
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.button13);
		this.buttonList.add(GuiVC.button14);
		this.buttonList.add(GuiVC.button15);
		this.buttonList.add(GuiVC.button16);
		this.buttonList.add(GuiVC.button17);
		this.buttonList.add(GuiVC.button18);
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 13)
    	{
    		GuiVC.button13.enabled = false;
    	}
    	else
    	{
    		GuiVC.button13.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 14)
    	{
    		GuiVC.button14.enabled = false;
    	}
    	else
    	{
    		GuiVC.button14.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 15)
    	{
    		GuiVC.button15.enabled = false;
    	}
    	else
    	{
    		GuiVC.button15.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 16)
    	{
    		GuiVC.button16.enabled = false;
    	}
    	else
    	{
    		GuiVC.button16.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 17)
    	{
    		GuiVC.button17.enabled = false;
    	}
    	else
    	{
    		GuiVC.button17.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 18)
    	{
    		GuiVC.button18.enabled = false;
    	}
    	else
    	{
    		GuiVC.button18.enabled = true;
    	}
    }
}

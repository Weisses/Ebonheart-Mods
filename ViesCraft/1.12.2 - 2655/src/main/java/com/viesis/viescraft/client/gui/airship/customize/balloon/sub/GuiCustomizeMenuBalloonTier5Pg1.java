package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier5Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier5Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	this.buttonList.add(GuiVC.button501);
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		//this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.button55);
		this.buttonList.add(GuiVC.button56);
		this.buttonList.add(GuiVC.button57);
		this.buttonList.add(GuiVC.button58);
		this.buttonList.add(GuiVC.button59);
		this.buttonList.add(GuiVC.button60);

		this.buttonList.add(GuiVC.button61);
		this.buttonList.add(GuiVC.button62);
		this.buttonList.add(GuiVC.button63);
		this.buttonList.add(GuiVC.button64);
		this.buttonList.add(GuiVC.button65);
		this.buttonList.add(GuiVC.button66);
		
		GuiVC.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVC.button58.visible = false;
		GuiVC.button59.visible = false;
		GuiVC.button60.visible = false;
		GuiVC.button61.visible = false;
		GuiVC.button62.visible = false;
		GuiVC.button63.visible = false;
		GuiVC.button64.visible = false;
		GuiVC.button65.visible = false;
		GuiVC.button66.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 55)
    	{
    		GuiVC.button55.enabled = false;
    	}
    	else
    	{
    		GuiVC.button55.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 56)
    	{
    		GuiVC.button56.enabled = false;
    	}
    	else
    	{
    		GuiVC.button56.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 57)
    	{
    		GuiVC.button57.enabled = false;
    	}
    	else
    	{
    		GuiVC.button57.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 58)
    	{
    		GuiVC.button58.enabled = false;
    	}
    	else
    	{
    		GuiVC.button58.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 59)
    	{
    		GuiVC.button59.enabled = false;
    	}
    	else
    	{
    		GuiVC.button59.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 60)
    	{
    		GuiVC.button60.enabled = false;
    	}
    	else
    	{
    		GuiVC.button60.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 61)
    	{
    		GuiVC.button61.enabled = false;
    	}
    	else
    	{
    		GuiVC.button61.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 62)
    	{
    		GuiVC.button62.enabled = false;
    	}
    	else
    	{
    		GuiVC.button62.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 63)
    	{
    		GuiVC.button63.enabled = false;
    	}
    	else
    	{
    		GuiVC.button63.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 64)
    	{
    		GuiVC.button64.enabled = false;
    	}
    	else
    	{
    		GuiVC.button64.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 65)
    	{
    		GuiVC.button65.enabled = false;
    	}
    	else
    	{
    		GuiVC.button65.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 66)
    	{
    		GuiVC.button66.enabled = false;
    	}
    	else
    	{
    		GuiVC.button66.enabled = true;
    	}
    }
}

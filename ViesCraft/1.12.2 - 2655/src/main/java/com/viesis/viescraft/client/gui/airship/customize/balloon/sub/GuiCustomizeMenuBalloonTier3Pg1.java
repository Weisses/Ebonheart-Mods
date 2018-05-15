package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
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
		
		GuiVC.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVC.button33.visible = false;
		GuiVC.button34.visible = false;
		GuiVC.button35.visible = false;
		GuiVC.button36.visible = false;
		GuiVC.button37.visible = false;
		GuiVC.button38.visible = false;
		GuiVC.button39.visible = false;
		GuiVC.button40.visible = false;
		GuiVC.button41.visible = false;
		GuiVC.button42.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 31)
    	{
    		GuiVC.button31.enabled = false;
    	}
    	else
    	{
    		GuiVC.button31.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 32)
    	{
    		GuiVC.button32.enabled = false;
    	}
    	else
    	{
    		GuiVC.button32.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 33)
    	{
    		GuiVC.button33.enabled = false;
    	}
    	else
    	{
    		GuiVC.button33.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 34)
    	{
    		GuiVC.button34.enabled = false;
    	}
    	else
    	{
    		GuiVC.button34.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 35)
    	{
    		GuiVC.button35.enabled = false;
    	}
    	else
    	{
    		GuiVC.button35.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 36)
    	{
    		GuiVC.button36.enabled = false;
    	}
    	else
    	{
    		GuiVC.button36.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 37)
    	{
    		GuiVC.button37.enabled = false;
    	}
    	else
    	{
    		GuiVC.button37.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 38)
    	{
    		GuiVC.button38.enabled = false;
    	}
    	else
    	{
    		GuiVC.button38.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 39)
    	{
    		GuiVC.button39.enabled = false;
    	}
    	else
    	{
    		GuiVC.button39.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 40)
    	{
    		GuiVC.button40.enabled = false;
    	}
    	else
    	{
    		GuiVC.button40.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 41)
    	{
    		GuiVC.button41.enabled = false;
    	}
    	else
    	{
    		GuiVC.button41.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 42)
    	{
    		GuiVC.button42.enabled = false;
    	}
    	else
    	{
    		GuiVC.button42.enabled = true;
    	}
    }
}

package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier2Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier2Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVC.button19);
		this.buttonList.add(GuiVC.button20);
		this.buttonList.add(GuiVC.button21);
		this.buttonList.add(GuiVC.button22);
		this.buttonList.add(GuiVC.button23);
		this.buttonList.add(GuiVC.button24);
		
		this.buttonList.add(GuiVC.button25);
		this.buttonList.add(GuiVC.button26);
		this.buttonList.add(GuiVC.button27);
		this.buttonList.add(GuiVC.button28);
		this.buttonList.add(GuiVC.button29);
		this.buttonList.add(GuiVC.button30);
		
		GuiVC.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVC.button25.visible = false;
		GuiVC.button26.visible = false;
		GuiVC.button27.visible = false;
		GuiVC.button28.visible = false;
		GuiVC.button29.visible = false;
		GuiVC.button30.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 19)
    	{
    		GuiVC.button19.enabled = false;
    	}
    	else
    	{
    		GuiVC.button19.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 20)
    	{
    		GuiVC.button20.enabled = false;
    	}
    	else
    	{
    		GuiVC.button20.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 21)
    	{
    		GuiVC.button21.enabled = false;
    	}
    	else
    	{
    		GuiVC.button21.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 22)
    	{
    		GuiVC.button22.enabled = false;
    	}
    	else
    	{
    		GuiVC.button22.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 23)
    	{
    		GuiVC.button23.enabled = false;
    	}
    	else
    	{
    		GuiVC.button23.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 24)
    	{
    		GuiVC.button24.enabled = false;
    	}
    	else
    	{
    		GuiVC.button24.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 25)
    	{
    		GuiVC.button25.enabled = false;
    	}
    	else
    	{
    		GuiVC.button25.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 26)
    	{
    		GuiVC.button26.enabled = false;
    	}
    	else
    	{
    		GuiVC.button26.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 27)
    	{
    		GuiVC.button27.enabled = false;
    	}
    	else
    	{
    		GuiVC.button27.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 28)
    	{
    		GuiVC.button28.enabled = false;
    	}
    	else
    	{
    		GuiVC.button28.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 29)
    	{
    		GuiVC.button29.enabled = false;
    	}
    	else
    	{
    		GuiVC.button29.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 30)
    	{
    		GuiVC.button30.enabled = false;
    	}
    	else
    	{
    		GuiVC.button30.enabled = true;
    	}
    }
}

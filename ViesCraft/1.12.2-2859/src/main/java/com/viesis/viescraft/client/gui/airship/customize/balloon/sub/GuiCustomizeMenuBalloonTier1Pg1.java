package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier1Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier1Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		GuiVC.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVC.button04.visible = false;
		GuiVC.button05.visible = false;
		GuiVC.button06.visible = false;
		GuiVC.button07.visible = false;
		GuiVC.button08.visible = false;
		GuiVC.button09.visible = false;
		GuiVC.button10.visible = false;
		GuiVC.button11.visible = false;
		GuiVC.button12.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 1)
    	{
    		GuiVC.button01.enabled = false;
    	}
    	else
    	{
    		GuiVC.button01.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 2)
    	{
    		GuiVC.button02.enabled = false;
    	}
    	else
    	{
    		GuiVC.button02.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 3)
    	{
    		GuiVC.button03.enabled = false;
    	}
    	else
    	{
    		GuiVC.button03.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 4)
    	{
    		GuiVC.button04.enabled = false;
    	}
    	else
    	{
    		GuiVC.button04.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 5)
    	{
    		GuiVC.button05.enabled = false;
    	}
    	else
    	{
    		GuiVC.button05.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 6)
    	{
    		GuiVC.button06.enabled = false;
    	}
    	else
    	{
    		GuiVC.button06.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 7)
    	{
    		GuiVC.button07.enabled = false;
    	}
    	else
    	{
    		GuiVC.button07.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 8)
    	{
    		GuiVC.button08.enabled = false;
    	}
    	else
    	{
    		GuiVC.button08.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 9)
    	{
    		GuiVC.button09.enabled = false;
    	}
    	else
    	{
    		GuiVC.button09.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 10)
    	{
    		GuiVC.button10.enabled = false;
    	}
    	else
    	{
    		GuiVC.button10.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 11)
    	{
    		GuiVC.button11.enabled = false;
    	}
    	else
    	{
    		GuiVC.button11.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 12)
    	{
    		GuiVC.button12.enabled = false;
    	}
    	else
    	{
    		GuiVC.button12.enabled = true;
    	}
    }
}

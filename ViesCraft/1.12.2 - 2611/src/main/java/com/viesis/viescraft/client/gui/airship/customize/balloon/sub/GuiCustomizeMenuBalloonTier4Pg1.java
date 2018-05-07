package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuBalloonTier4Pg1 extends GuiCustomizeMenuBalloonTierVC {
	
	public GuiCustomizeMenuBalloonTier4Pg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVC.button43);
		this.buttonList.add(GuiVC.button44);
		this.buttonList.add(GuiVC.button45);
		this.buttonList.add(GuiVC.button46);
		this.buttonList.add(GuiVC.button47);
		this.buttonList.add(GuiVC.button48);

		this.buttonList.add(GuiVC.button49);
		this.buttonList.add(GuiVC.button50);
		this.buttonList.add(GuiVC.button51);
		this.buttonList.add(GuiVC.button52);
		this.buttonList.add(GuiVC.button53);
		this.buttonList.add(GuiVC.button54);
		
		GuiVC.buttonMM3.enabled = false;
		
		//TO REMOVE WHEN TEXTURES ARE MADE
		GuiVC.button46.visible = false;
		GuiVC.button47.visible = false;
		GuiVC.button48.visible = false;
		GuiVC.button49.visible = false;
		GuiVC.button50.visible = false;
		GuiVC.button51.visible = false;
		GuiVC.button52.visible = false;
		GuiVC.button53.visible = false;
		GuiVC.button54.visible = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.balloonPatternTexture == 43)
    	{
    		GuiVC.button43.enabled = false;
    	}
    	else
    	{
    		GuiVC.button43.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 44)
    	{
    		GuiVC.button44.enabled = false;
    	}
    	else
    	{
    		GuiVC.button44.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 45)
    	{
    		GuiVC.button45.enabled = false;
    	}
    	else
    	{
    		GuiVC.button45.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 46)
    	{
    		GuiVC.button46.enabled = false;
    	}
    	else
    	{
    		GuiVC.button46.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 47)
    	{
    		GuiVC.button47.enabled = false;
    	}
    	else
    	{
    		GuiVC.button47.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 48)
    	{
    		GuiVC.button48.enabled = false;
    	}
    	else
    	{
    		GuiVC.button48.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 49)
    	{
    		GuiVC.button49.enabled = false;
    	}
    	else
    	{
    		GuiVC.button49.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 50)
    	{
    		GuiVC.button50.enabled = false;
    	}
    	else
    	{
    		GuiVC.button50.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 51)
    	{
    		GuiVC.button51.enabled = false;
    	}
    	else
    	{
    		GuiVC.button51.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 52)
    	{
    		GuiVC.button52.enabled = false;
    	}
    	else
    	{
    		GuiVC.button52.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 53)
    	{
    		GuiVC.button53.enabled = false;
    	}
    	else
    	{
    		GuiVC.button53.enabled = true;
    	}
    	if(this.airship.balloonPatternTexture == 54)
    	{
    		GuiVC.button54.enabled = false;
    	}
    	else
    	{
    		GuiVC.button54.enabled = true;
    	}
    }
}

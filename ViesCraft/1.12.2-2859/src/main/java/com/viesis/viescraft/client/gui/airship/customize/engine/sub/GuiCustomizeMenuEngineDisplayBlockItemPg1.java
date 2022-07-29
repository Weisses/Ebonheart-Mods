package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;

public class GuiCustomizeMenuEngineDisplayBlockItemPg1 extends GuiCustomizeMenuEngineDisplayBlockItemVC {
	
	public GuiCustomizeMenuEngineDisplayBlockItemPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    }
}

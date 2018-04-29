package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuEngineDisplaySymbolPg1 extends GuiCustomizeMenuEngineDisplaySymbolVC {
	
	public GuiCustomizeMenuEngineDisplaySymbolPg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);
		this.buttonList.add(GuiVC.button13);
		this.buttonList.add(GuiVC.button14);
		this.buttonList.add(GuiVC.button15);
		
		this.buttonList.add(GuiVC.button16);
		this.buttonList.add(GuiVC.button17);
		this.buttonList.add(GuiVC.button18);
		this.buttonList.add(GuiVC.button19);
		this.buttonList.add(GuiVC.button20);
		this.buttonList.add(GuiVC.button21);
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVC.ENGINE_DISPLAY_SYMBOL_COST
		&& this.metaInfo != this.airship.engineDisplayTypeVisual)
		{
			GuiVC.button501.enabled = true;
		}
		else
		{
			GuiVC.button501.enabled = false;
		}
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.metaInfo == 10)
    	{
    		GuiVC.button10.enabled = false;
    	}
    	else
    	{
    		GuiVC.button10.enabled = true;
    	}
    	if(this.metaInfo == 11)
    	{
    		GuiVC.button11.enabled = false;
    	}
    	else
    	{
    		GuiVC.button11.enabled = true;
    	}
    	if(this.metaInfo == 12)
    	{
    		GuiVC.button12.enabled = false;
    	}
    	else
    	{
    		GuiVC.button12.enabled = true;
    	}
    	if(this.metaInfo == 13)
    	{
    		GuiVC.button13.enabled = false;
    	}
    	else
    	{
    		GuiVC.button13.enabled = true;
    	}
    	if(this.metaInfo == 14)
    	{
    		GuiVC.button14.enabled = false;
    	}
    	else
    	{
    		GuiVC.button14.enabled = true;
    	}
    	if(this.metaInfo == 15)
    	{
    		GuiVC.button15.enabled = false;
    	}
    	else
    	{
    		GuiVC.button15.enabled = true;
    	}
    	if(this.metaInfo == 16)
    	{
    		GuiVC.button16.enabled = false;
    	}
    	else
    	{
    		GuiVC.button16.enabled = true;
    	}
    	if(this.metaInfo == 17)
    	{
    		GuiVC.button17.enabled = false;
    	}
    	else
    	{
    		GuiVC.button17.enabled = true;
    	}
    	if(this.metaInfo == 18)
    	{
    		GuiVC.button18.enabled = false;
    	}
    	else
    	{
    		GuiVC.button18.enabled = true;
    	}
    	if(this.metaInfo == 19)
    	{
    		GuiVC.button19.enabled = false;
    	}
    	else
    	{
    		GuiVC.button19.enabled = true;
    	}
    	if(this.metaInfo == 20)
    	{
    		GuiVC.button20.enabled = false;
    	}
    	else
    	{
    		GuiVC.button20.enabled = true;
    	}
    	if(this.metaInfo == 21)
    	{
    		GuiVC.button21.enabled = false;
    	}
    	else
    	{
    		GuiVC.button21.enabled = true;
    	}
    }
}

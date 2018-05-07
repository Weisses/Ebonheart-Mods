package com.viesis.viescraft.client.gui.airship.customize.core.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.viesis.viescraft.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelEngine;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuCoreModelEnginePg1 extends GuiCustomizeMenuCoreModelVC {
	
	public GuiCustomizeMenuCoreModelEnginePg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
		
		this.metaInfo = this.airship.coreModelVisualEngine;
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
		
		this.buttonList.add(GuiVC.buttonB00);
		this.buttonList.add(GuiVC.buttonB01);
		this.buttonList.add(GuiVC.buttonB02);
		//this.buttonList.add(GuiVC.buttonB03);
		//this.buttonList.add(GuiVC.buttonB04);
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelEngine());
	    }
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelEngine());
	    }
		if (parButton.id == 503)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuCoreMain());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
    	
		if(airship.getStoredRedstone() >= CostsVC.CORE_MODEL_ENGINE_COST
		&& this.metaInfo != this.airship.coreModelVisualEngine)
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
    	if(this.airship.coreModelVisualEngine == 0)
    	{
    		GuiVC.buttonB00.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB00.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 1)
    	{
    		GuiVC.buttonB01.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB01.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 2)
    	{
    		GuiVC.buttonB02.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB02.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 3)
    	{
    		GuiVC.buttonB03.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB03.enabled = true;
    	}
    	if(this.airship.coreModelVisualEngine == 4)
    	{
    		GuiVC.buttonB04.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB04.enabled = true;
    	}
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipCore entityIn)
    {
    	int current = entityIn.coreModelVisualEngine;
        entityIn.coreModelVisualEngine = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		entityIn.coreModelVisualEngine = current;
    }
}

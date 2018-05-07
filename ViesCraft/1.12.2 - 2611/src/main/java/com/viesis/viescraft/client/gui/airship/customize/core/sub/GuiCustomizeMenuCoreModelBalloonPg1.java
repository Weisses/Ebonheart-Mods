package com.viesis.viescraft.client.gui.airship.customize.core.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.viesis.viescraft.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelBalloon;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuCoreModelBalloonPg1 extends GuiCustomizeMenuCoreModelVC {
	
	public GuiCustomizeMenuCoreModelBalloonPg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(playerInv, airshipIn);
		
		this.metaInfo = this.airship.coreModelVisualBalloon;
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
		
		this.buttonList.add(GuiVC.buttonC00);
		this.buttonList.add(GuiVC.buttonC01);
		this.buttonList.add(GuiVC.buttonC02);
		this.buttonList.add(GuiVC.buttonC03);
		this.buttonList.add(GuiVC.buttonC04);
		
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
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelBalloon());
	    }
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelBalloon());
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
    	
		if(airship.getStoredRedstone() >= CostsVC.CORE_MODEL_BALLOON_COST
		&& this.metaInfo != this.airship.coreModelVisualBalloon)
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
    	if(this.airship.coreModelVisualBalloon == 0)
    	{
    		GuiVC.buttonC00.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonC00.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 1)
    	{
    		GuiVC.buttonC01.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonC01.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 2)
    	{
    		GuiVC.buttonC02.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonC02.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 3)
    	{
    		GuiVC.buttonC03.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonC03.enabled = true;
    	}
    	if(this.airship.coreModelVisualBalloon == 4)
    	{
    		GuiVC.buttonC04.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonC04.enabled = true;
    	}
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipCore entityIn)
    {
    	int current = entityIn.coreModelVisualBalloon;
        entityIn.coreModelVisualBalloon = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		entityIn.coreModelVisualBalloon = current;
    }
}

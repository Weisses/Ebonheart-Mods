package com.viesis.viescraft.client.gui.airship.customize.core.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.viesis.viescraft.network.server.airship.customize.core.sub.MessageHelperGuiCustomizeMenuCoreModelFrame;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.inventory.IInventory;

public class GuiCustomizeMenuCoreModelFramePg1 extends GuiCustomizeMenuCoreModelVC {
	
	public GuiCustomizeMenuCoreModelFramePg1(IInventory playerInv, EntityAirshipCore airshipIn)
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
		//this.buttonList.add(GuiVC.button504);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA00);
		this.buttonList.add(GuiVC.buttonA01);
		this.buttonList.add(GuiVC.buttonA02);
		this.buttonList.add(GuiVC.buttonA03);
		this.buttonList.add(GuiVC.buttonA04);
    }
	
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelFrame());
	    }
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuCoreModelFrame());
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
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.coreModelVisualFrame == 0)
    	{
    		GuiVC.buttonA00.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA00.enabled = true;
    	}
    	if(this.airship.coreModelVisualFrame == 1)
    	{
    		GuiVC.buttonA01.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA01.enabled = true;
    	}
    	if(this.airship.coreModelVisualFrame == 2)
    	{
    		GuiVC.buttonA02.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA02.enabled = true;
    	}
    	if(this.airship.coreModelVisualFrame == 3)
    	{
    		GuiVC.buttonA03.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA03.enabled = true;
    	}
    	if(this.airship.coreModelVisualFrame == 4)
    	{
    		GuiVC.buttonA04.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonA04.enabled = true;
    	}
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    protected void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityAirshipBaseVC entityIn)
    {
    	int current = entityIn.coreModelVisualFrame;
        entityIn.coreModelVisualFrame = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, entityIn);
    	
		entityIn.coreModelVisualFrame = current;
    }
}

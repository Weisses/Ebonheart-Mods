package com.viesis.viescraft.client.gui.airship.customize.balloon.sub;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
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
    	
    	GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVC.button503 = new GuiButtonGeneralVC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVC.button501 = new GuiButtonGeneralVC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	GuiVC.buttonB43 = new GuiButtonGeneralVC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualballoon.43"), 0);
		GuiVC.buttonB44 = new GuiButtonGeneralVC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualballoon.44"), 0);
		GuiVC.buttonB45 = new GuiButtonGeneralVC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualballoon.45"), 0);
		GuiVC.buttonB46 = new GuiButtonGeneralVC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualballoon.46"), 0);
		GuiVC.buttonB47 = new GuiButtonGeneralVC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualballoon.47"), 0);
		GuiVC.buttonB48 = new GuiButtonGeneralVC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualballoon.48"), 0);
		
		GuiVC.buttonB49 = new GuiButtonGeneralVC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualballoon.49"), 0);
		GuiVC.buttonB50 = new GuiButtonGeneralVC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualballoon.50"), 0);
		GuiVC.buttonB51 = new GuiButtonGeneralVC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualballoon.51"), 0);
		GuiVC.buttonB52 = new GuiButtonGeneralVC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualballoon.52"), 0);
		GuiVC.buttonB53 = new GuiButtonGeneralVC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualballoon.53"), 0);
		GuiVC.buttonB54 = new GuiButtonGeneralVC(54, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualballoon.54"), 0);
		
		this.buttonList.add(GuiVC.button502);
		//this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonB43);
		this.buttonList.add(GuiVC.buttonB44);
		this.buttonList.add(GuiVC.buttonB45);
		//this.buttonList.add(GuiVC.buttonB46);
		//this.buttonList.add(GuiVC.buttonB47);
		//this.buttonList.add(GuiVC.buttonB48);

		//this.buttonList.add(GuiVC.buttonB49);
		//this.buttonList.add(GuiVC.buttonB50);
		//this.buttonList.add(GuiVC.buttonB51);
		//this.buttonList.add(GuiVC.buttonB52);
		//this.buttonList.add(GuiVC.buttonB53);
		//this.buttonList.add(GuiVC.buttonB54);
    }
    
    @Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
    	super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
    	
    	this.grayOutSelectedButton();
	}
    
    private void grayOutSelectedButton()
    {
    	if(this.airship.frameSkinTexture == 43)
    	{
    		GuiVC.buttonB43.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB43.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 44)
    	{
    		GuiVC.buttonB44.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB44.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 45)
    	{
    		GuiVC.buttonB45.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB45.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 46)
    	{
    		GuiVC.buttonB46.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB46.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 47)
    	{
    		GuiVC.buttonB47.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB47.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 48)
    	{
    		GuiVC.buttonB48.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB48.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 49)
    	{
    		GuiVC.buttonB49.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB49.enabled = true;
    	}

    	if(this.airship.frameSkinTexture == 50)
    	{
    		GuiVC.buttonB50.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB50.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 51)
    	{
    		GuiVC.buttonB51.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB51.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 52)
    	{
    		GuiVC.buttonB52.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB52.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 53)
    	{
    		GuiVC.buttonB53.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB53.enabled = true;
    	}
    	if(this.airship.frameSkinTexture == 54)
    	{
    		GuiVC.buttonB54.enabled = false;
    	}
    	else
    	{
    		GuiVC.buttonB54.enabled = true;
    	}
    }
}

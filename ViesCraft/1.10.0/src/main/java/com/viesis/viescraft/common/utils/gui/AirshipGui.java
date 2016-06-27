package com.viesis.viescraft.common.utils.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

import com.viesis.viescraft.testbed.ContainerAirship;
import com.viesis.viescraft.testbed.EntityAirship;

public class AirshipGui extends GuiContainer {

	private EntityAirship airship;
	
	public AirshipGui(GuiScreen screen, InventoryPlayer inventoryplayer,EntityAirship air) 
	{
		super(new ContainerAirship(inventoryplayer, air));
		
		airship = air;
	}
	/**
	@Override
	public void onGuiClosed()
	{
		this.entryList.onGuiClosed();
		
		if (this.configID != null && this.parentScreen instanceof GuiConfig)
		{
			GuiConfig parentGuiConfig = (GuiConfig) this.parentScreen;
			parentGuiConfig.needsRefresh = true;
			parentGuiConfig.initGui();
		}
		
		if (!(this.parentScreen instanceof GuiConfig))
			Keyboard.enableRepeatEvents(false);
			
		if(ViesCraft.config.hasChanged())
		{
			ViesCraft.config.save();	
			LogHelper.info("Configuration saved.");
			
			//EbonArtsMod.config.;
			//InitItemsEARender.registerRenders();
			//LogHelper.info("Configuration loaded.");
		}
	}
	
	*/

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks,
			int mouseX, int mouseY) {
		// TODO Auto-generated method stub
		
	}
	
	
}

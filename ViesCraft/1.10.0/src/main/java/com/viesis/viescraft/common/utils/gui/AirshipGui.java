package com.viesis.viescraft.common.utils.gui;

import com.viesis.viescraft.common.entity.EntityAirshipVC;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class AirshipGui extends GuiContainer {

	private EntityAirshipVC airship;
	
	public AirshipGui(GuiScreen screen, InventoryPlayer inventoryplayer, EntityAirshipVC air) 
	{
		super(null
				//new ContainerAirshipVC(inventoryplayer, air)
				);
		
		//airship = air;
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

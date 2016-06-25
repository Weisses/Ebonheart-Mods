package com.viesis.viescraft.common.utils.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.client.config.GuiConfig;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.LogHelper;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen screen) 
	{
		super(screen, new ConfigElement(ViesCraft.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(), Reference.MOD_NAME, true, true, GuiConfig.getAbridgedConfigPath(ViesCraft.config.toString()));
		
		if(ViesCraft.config.hasChanged())
		{
			ViesCraft.config.save();
			LogHelper.info("Configuration saved.");
		}
	}
	
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
}

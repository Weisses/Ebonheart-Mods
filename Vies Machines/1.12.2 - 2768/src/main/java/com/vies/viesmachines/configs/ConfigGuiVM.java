package com.vies.viesmachines.configs;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Loghelper;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGuiVM extends GuiConfig {
	
	public ConfigGuiVM(GuiScreen screen) 
	{
		super(screen, new ConfigElement(VMConfiguration.config.getCategory(VMConfiguration.CATEGORY_VM)).getChildElements(), References.MOD_NAME, true, false, GuiConfig.getAbridgedConfigPath(VMConfiguration.config.toString()));
	}
	
	@Override
	public void onGuiClosed()
	{
		this.entryList.onGuiClosed();
		
		if(this.configID != null && this.parentScreen instanceof GuiConfig)
		{
			GuiConfig parentGuiConfig = (GuiConfig) this.parentScreen;
			parentGuiConfig.needsRefresh = true;
			parentGuiConfig.initGui();
		}
		
		if(!(this.parentScreen instanceof GuiConfig))
		{
			Keyboard.enableRepeatEvents(false);
		}
		
		// Saves the config:
		VMConfiguration.reloadConfig();
		Loghelper.info("Config saved.");
		
		super.onGuiClosed();
	}
}

package com.viesis.dismounter.client.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

import org.lwjgl.input.Keyboard;

import com.viesis.dismounter.api.Reference;
import com.viesis.dismounter.api.util.LogHelper;
import com.viesis.dismounter.configs.ViesisDismounterConfig;

public class ConfigGui extends GuiConfig {
	
	public ConfigGui(GuiScreen screen) 
	{
		super(screen, new ConfigElement(ViesisDismounterConfig.config.getCategory(ViesisDismounterConfig.CATEGORY_VC)).getChildElements(), Reference.MOD_NAME, true, true, GuiConfig.getAbridgedConfigPath(ViesisDismounterConfig.config.toString()));
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
		
		ViesisDismounterConfig.config.save();
		LogHelper.info("Configuration saved.");
	}
}

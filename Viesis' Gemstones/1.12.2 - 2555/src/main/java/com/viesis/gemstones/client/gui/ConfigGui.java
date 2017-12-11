package com.viesis.gemstones.client.gui;

import org.lwjgl.input.Keyboard;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.util.LogHelper;
import com.viesis.gemstones.configs.ViesisGemstonesConfig;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen screen) 
	{
		super(screen, new ConfigElement(ViesisGemstonesConfig.config.getCategory(ViesisGemstonesConfig.CATEGORY_VG)).getChildElements(), References.MOD_NAME, true, true, GuiConfig.getAbridgedConfigPath(ViesisGemstonesConfig.config.toString()));
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
		
		if(!(this.parentScreen instanceof GuiConfig))
		{
			Keyboard.enableRepeatEvents(false);
		}
		
		ViesisGemstonesConfig.config.save();	
		LogHelper.info("Configuration saved.");
	}
}

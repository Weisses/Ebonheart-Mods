package com.viesis.gemstones.api.gui;

import java.util.Set;

import com.viesis.gemstones.client.gui.ConfigGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public class VGGuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) 
	{
		
	}

	@Override
	public boolean hasConfigGui() 
	{
		return true;
	}

	@Override
	public GuiScreen createConfigGui(GuiScreen parentScreen) 
	{
		return new ConfigGui(parentScreen);
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() 
	{
		return null;
	}
}

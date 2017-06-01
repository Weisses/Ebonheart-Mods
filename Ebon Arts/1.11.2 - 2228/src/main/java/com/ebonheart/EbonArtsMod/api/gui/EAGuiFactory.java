package com.ebonheart.EbonArtsMod.api.gui;

import java.util.Set;

import com.ebonheart.EbonArtsMod.common.utils.gui.ConfigGui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;

public class EAGuiFactory implements IModGuiFactory {

	@Override
	public void initialize(Minecraft minecraftInstance) 
	{
		
	}

	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() 
	{
		return ConfigGui.class;
	}

	@Override
	public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() 
	{
		return null;
	}

	@Override
	public RuntimeOptionGuiHandler getHandlerFor(RuntimeOptionCategoryElement element) 
	{
		return null;
	}
}

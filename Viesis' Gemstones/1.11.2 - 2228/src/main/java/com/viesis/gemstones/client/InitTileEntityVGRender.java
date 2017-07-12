package com.viesis.gemstones.client;

import com.viesis.gemstones.client.tileentity.RenderGemstoneConverter;
import com.viesis.gemstones.client.tileentity.RenderGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class InitTileEntityVGRender {
	
	public static void registerTileEntityRender()
	{
		registerRender(TileEntityGemstoneWorkbench.class, new RenderGemstoneWorkbench());
		registerRender(TileEntityGemstoneConverter.class, new RenderGemstoneConverter());
	}
	
	public static void registerTileEntityRenderTEMP()
	{
		
	}
	
	public static <T extends TileEntity> void registerRender(Class<T> classIn, TileEntitySpecialRenderer<? super T> renderItem)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(classIn, renderItem);
	}
}

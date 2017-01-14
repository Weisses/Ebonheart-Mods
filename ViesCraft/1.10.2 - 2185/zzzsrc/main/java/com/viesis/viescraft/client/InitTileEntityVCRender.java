package com.viesis.viescraft.client;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import com.viesis.viescraft.client.tileentity.render.RenderAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;


public final class InitTileEntityVCRender {
	
	public static void registerTileEntityRender()
	{
		registerRender(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
	}
	
	public static void registerTileEntityRenderTEMP()
	{
		
	}
	
	public static <T extends TileEntity> void registerRender(Class<T> classIn, TileEntitySpecialRenderer<? super T> renderItem)
	{
		ClientRegistry.bindTileEntitySpecialRenderer(classIn, renderItem);
	}
}

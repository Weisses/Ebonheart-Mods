package com.viesis.gemstones.init;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class InitTileEntitiesVG {
	
	public static void registerTileEntity() 
	{
		GameRegistry.registerTileEntity(TileEntityGemstoneWorkbench.class, "tile_entity_gemstone_workbench");
	}
	
	public static void registerTileEntityTEMP()
	{
		
	}
	
	public static void register()
	{
		
	}
}

package com.viesis.viescraft.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public final class InitTileEntitiesVC {
	
	public static void registerTileEntity() 
	{
		GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
	}
	
	public static void registerTileEntityTEMP()
	{
		
	}
	
	public static void register()
	{
		
	}
}

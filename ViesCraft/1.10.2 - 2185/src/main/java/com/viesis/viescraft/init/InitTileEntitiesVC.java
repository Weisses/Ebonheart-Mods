package com.viesis.viescraft.init;

import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.common.tileentity.TileEntityAirshipDisassembler;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public final class InitTileEntitiesVC {
	
	public static void preInit() 
	{
		GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
		//GameRegistry.registerTileEntity(TileEntityAirshipDisassembler.class, "tile_entity_airship_disassembler");
	}
	
	public static void register()
	{
		
	}
}

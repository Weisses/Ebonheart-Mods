package com.viesis.viescraft.init;

import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityBatteryCharger;

import net.minecraftforge.fml.common.registry.GameRegistry;

public final class InitTileEntitiesVC {
	
	public static void registerTileEntity() 
	{
		GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
		//GameRegistry.registerTileEntity(TileEntityBatteryCharger.class, "tile_entity_battery_charger");
	}
	
	public static void registerTileEntityTEMP()
	{
		
	}
	
	public static void register()
	{
		
	}
}

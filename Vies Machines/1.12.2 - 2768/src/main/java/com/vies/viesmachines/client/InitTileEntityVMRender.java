package com.vies.viesmachines.client;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.tileentity.render.RenderExtractor;
import com.vies.viesmachines.client.tileentity.render.RenderKitFabricator;
import com.vies.viesmachines.client.tileentity.render.RenderMachineBeacon;
import com.vies.viesmachines.client.tileentity.render.RenderMachineTransmogrifier;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.TileEntityMachineBeacon;
import com.vies.viesmachines.common.tileentity.TileEntityMachineTransmogrifier;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public final class InitTileEntityVMRender {
	
	public static void registerTileEntityRender()
	{
		registerRender(TileEntityExtractor.class, "appliance_extractor", new RenderExtractor());
		registerRender(TileEntityKitFabricator.class, "appliance_kit_fabricator", new RenderKitFabricator());
		registerRender(TileEntityMachineTransmogrifier.class, "appliance_machine_transmogrifier", new RenderMachineTransmogrifier());
		registerRender(TileEntityMachineBeacon.class, "appliance_machine_beacon", new RenderMachineBeacon());
		
		//registerRender(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		//registerRender(TileEntityBatteryCharger.class, new RenderBatteryCharger());
	}
	
	public static <T extends TileEntity> void registerRender(Class<T> classIn, String nameIn, TileEntitySpecialRenderer<? super T> renderItem)
	{
		ClientRegistry.registerTileEntity(classIn, References.MOD_ID + ":" + nameIn, renderItem);
		ClientRegistry.bindTileEntitySpecialRenderer(classIn, renderItem);
	}
}

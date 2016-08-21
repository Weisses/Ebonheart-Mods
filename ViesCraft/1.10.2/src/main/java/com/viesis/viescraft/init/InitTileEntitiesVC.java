package com.viesis.viescraft.init;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.tileentity.render.RenderAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public final class InitTileEntitiesVC {
	
	//public static Block Test_Block_Tile_Entity;
	
	public static void init() 
	{
		GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
		
		//GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
		//GameRegistry.registerBlock(Test_Block_Tile_Entity = new TestBlockTileEntity("tile_entity"), "tile_entity");
	}
	
	public static void register()
	{
		//////GameRegistry.registerTileEntity(TileEntityAirshipWorkbench.class, "tile_entity_airship_workbench");
		
		//GameRegistry.registerTileEntity(TestTileEntity.class, "tile_entity");
	}
	
	public static void registerRenders()
	{
		registerRender(BlocksVC.airship_workbench);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	public static void clientRegisterRenders()
	{
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
	}
}

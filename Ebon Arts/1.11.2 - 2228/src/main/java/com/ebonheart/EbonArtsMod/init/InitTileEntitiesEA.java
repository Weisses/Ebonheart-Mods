package com.ebonheart.EbonArtsMod.init;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.ebonheart.EbonArtsMod.api.References;



public final class InitTileEntitiesEA {
	
	//public static Block Test_Block_Tile_Entity;
	
	
	public static void init() {
		
		//GameRegistry.registerBlock(Test_Block_Tile_Entity = new TestBlockTileEntity("tile_entity"), "tile_entity");
		
		
		
	}

	
	public static void register()
	{
		
		//GameRegistry.registerTileEntity(TestTileEntity.class, "tile_entity");
		
		
	}
	
	
	public static void registerRenders()
	{
		
		//registerRender(Test_Block_Tile_Entity);
		
		
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(References.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
	
	//public static void clientRegisterRenders()
	//{
	//	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityDragonwoodPlant.class, new TileEntityDragonwoodPlantRenderer());
    	
	//}
}

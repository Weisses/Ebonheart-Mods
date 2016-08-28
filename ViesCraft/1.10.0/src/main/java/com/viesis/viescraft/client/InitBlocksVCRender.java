package com.viesis.viescraft.client;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.client.registry.ClientRegistry;

import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.client.tileentity.render.RenderAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public final class InitBlocksVCRender extends BlocksVC {
	
	public static void registerRenders()
	{
		registerRender(airship_workbench);
		//registerRender(cryptic_ebonheart_block_fancybrick);
	}
	
	//public static void registerSpecialRenders()
	//{
	//	registerRender(airship_workbench);
	//	ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirshipWorkbench.class, new RenderAirshipWorkbench());
		
	//}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));
	}
	
	public static void registerRender(Block block, int meta, String file) 
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(Reference.MOD_ID + ":" + file, "inventory"));
	}
	
}

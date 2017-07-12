package com.viesis.gemstones.client;

import com.viesis.gemstones.api.VGBlocks;
import com.viesis.gemstones.api.VGEnum.GemstoneTypeBlockV1;
import com.viesis.gemstones.api.VGEnum.GemstoneTypeOre;
import com.viesis.gemstones.api.VGEnum.RegistryType;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitBlocksVGRender extends VGBlocks {
	
	public static void registerBlockRender()
	{
		registerRender(gemstone_workbench);
		//registerRender(gemstone_converter);
		
		for (GemstoneTypeOre meta : GemstoneTypeOre.values()) 
		{
			registerRenderEnumOre(geminfused_ore, meta.getMetadata());
		}
		
		for (GemstoneTypeBlockV1 meta : GemstoneTypeBlockV1.values()) 
		{
			if(meta.getRegistryType() == RegistryType.ALL
			|| meta.getRegistryType() == RegistryType.BLOCKONLY)
			{
				registerRenderEnum(gemstone_basic_block_v1, meta.getMetadata());
			}
		}
		
		for (GemstoneTypeBlockV1 meta : GemstoneTypeBlockV1.values()) 
		{
			if(meta.getRegistryType() == RegistryType.ALL
			|| meta.getRegistryType() == RegistryType.BLOCKONLY)
			{
				registerRenderEnum(gemstone_basic_brick_v1, meta.getMetadata());
			}
		}
		
		for (GemstoneTypeBlockV1 meta : GemstoneTypeBlockV1.values()) 
		{
			if(meta.getRegistryType() == RegistryType.ALL
			|| meta.getRegistryType() == RegistryType.BLOCKONLY)
			{
				registerRenderEnum(gemstone_basic_fancybrick_v1, meta.getMetadata());
			}
		}
		
				
		registerRender(basic_doubleslab_arcanite);
		registerRender(basic_doubleslab_velious);
		registerRender(basic_doubleslab_fenryte);
		registerRender(basic_doubleslab_electium);
		registerRender(basic_doubleslab_igneelis);
		registerRender(basic_doubleslab_necrocite);
		registerRender(basic_doubleslab_zephyrium);
		registerRender(basic_doubleslab_onyxius);
		registerRender(basic_doubleslab_soularite);
		
		registerRender(basic_halfslab_arcanite);
		registerRender(basic_halfslab_velious);
		registerRender(basic_halfslab_fenryte);
		registerRender(basic_halfslab_electium);
		registerRender(basic_halfslab_igneelis);
		registerRender(basic_halfslab_necrocite);
		registerRender(basic_halfslab_zephyrium);
		registerRender(basic_halfslab_onyxius);
		registerRender(basic_halfslab_soularite);
		
		registerRender(basic_stairs_arcanite);
		registerRender(basic_stairs_velious);
		registerRender(basic_stairs_fenryte);
		registerRender(basic_stairs_electium);
		registerRender(basic_stairs_igneelis);
		registerRender(basic_stairs_necrocite);
		registerRender(basic_stairs_zephyrium);
		registerRender(basic_stairs_onyxius);
		registerRender(basic_stairs_soularite);
		
		registerRender(basic_fence_arcanite);
		registerRender(basic_fence_velious);
		registerRender(basic_fence_fenryte);
		registerRender(basic_fence_electium);
		registerRender(basic_fence_igneelis);
		registerRender(basic_fence_necrocite);
		registerRender(basic_fence_zephyrium);
		registerRender(basic_fence_onyxius);
		registerRender(basic_fence_soularite);
		
		registerRender(basic_gate_arcanite);
		registerRender(basic_gate_velious);
		registerRender(basic_gate_fenryte);
		registerRender(basic_gate_electium);
		registerRender(basic_gate_igneelis);
		registerRender(basic_gate_necrocite);
		registerRender(basic_gate_zephyrium);
		registerRender(basic_gate_onyxius);
		registerRender(basic_gate_soularite);
		
		registerRender(basic_wall_arcanite);
		registerRender(basic_wall_velious);
		registerRender(basic_wall_fenryte);
		registerRender(basic_wall_electium);
		registerRender(basic_wall_igneelis);
		registerRender(basic_wall_necrocite);
		registerRender(basic_wall_zephyrium);
		registerRender(basic_wall_onyxius);
		registerRender(basic_wall_soularite);

		registerRender(basic_torch_arcanite);
		registerRender(basic_torch_velious);
		registerRender(basic_torch_fenryte);
		registerRender(basic_torch_electium);
		registerRender(basic_torch_igneelis);
		registerRender(basic_torch_necrocite);
		registerRender(basic_torch_zephyrium);
		registerRender(basic_torch_onyxius);
		registerRender(basic_torch_soularite);

		registerRender(basic_trapdoor_arcanite);
		registerRender(basic_trapdoor_velious);
		registerRender(basic_trapdoor_fenryte);
		registerRender(basic_trapdoor_electium);
		registerRender(basic_trapdoor_igneelis);
		registerRender(basic_trapdoor_necrocite);
		registerRender(basic_trapdoor_zephyrium);
		registerRender(basic_trapdoor_onyxius);
		registerRender(basic_trapdoor_soularite);
		
		registerRender(basic_ladder_arcanite);
		registerRender(basic_ladder_velious);
		registerRender(basic_ladder_fenryte);
		registerRender(basic_ladder_electium);
		registerRender(basic_ladder_igneelis);
		registerRender(basic_ladder_necrocite);
		registerRender(basic_ladder_zephyrium);
		registerRender(basic_ladder_onyxius);
		registerRender(basic_ladder_soularite);

		registerRender(basic_pillar_arcanite);
		registerRender(basic_pillar_velious);
		registerRender(basic_pillar_fenryte);
		registerRender(basic_pillar_electium);
		registerRender(basic_pillar_igneelis);
		registerRender(basic_pillar_necrocite);
		registerRender(basic_pillar_zephyrium);
		registerRender(basic_pillar_onyxius);
		registerRender(basic_pillar_soularite);

		
		
	}
	
	public static void registerBlockRenderTEMP()
	{
		
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(block.getRegistryName().toString(), "inventory"));
	}
	
	public static void registerRenderEnum(Block block, int meta)
	{
		String itemName = block.getRegistryName().toString() + "_" + GemstoneTypeBlockV1.byMetadata(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
	
	public static void registerRenderEnumOre(Block block, int meta)
	{
		String itemName = block.getRegistryName().toString() + "_" + GemstoneTypeOre.byMetadata(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		Item item = Item.getItemFromBlock(block);
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}

package com.viesis.gemstones.client;

import com.viesis.gemstones.api.VGEnum.GemstoneTypeItemV1;
import com.viesis.gemstones.api.VGEnum.RegistryType;
import com.viesis.gemstones.api.VGItems;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitItemsVGRender extends VGItems {
	
	public static void registerItemRender()
	{
		registerRender(gemstone_item_unidentified);
		
		for (GemstoneTypeItemV1 meta : GemstoneTypeItemV1.values()) 
		{
			if(meta.getRegistryType() == RegistryType.ALL
			|| meta.getRegistryType() == RegistryType.ITEMONLY)
			{
				registerRenderEnum(gemstone_item_basic_v1, meta.getMetadata());
			}
		}
		
		for (GemstoneTypeItemV1 meta : GemstoneTypeItemV1.values()) 
		{
			if(meta.getRegistryType() == RegistryType.ALL
			|| meta.getRegistryType() == RegistryType.ITEMONLY)
			{
				registerRenderEnum(gemstone_item_enchanted_v1, meta.getMetadata());
			}
		}
		
		/**
		registerRender(enchanted_ebonheart);
		registerRender(empowered_blade);
		
		registerRender(glowing_disc);
		registerRender(shimmering_disc);
		registerRender(laminate_disc);
		registerRender(resilient_disc);
		registerRender(dismal_disc);
		registerRender(ethereal_disc);
		registerRender(mirroring_disc);
		
		registerRender(burnished_helmet);
		registerRender(burnished_chestplate);
		registerRender(burnished_leggings);
		registerRender(burnished_boots);
		
		registerRender(scalemail_helmet);
		registerRender(scalemail_chestplate);
		registerRender(scalemail_leggings);
		registerRender(scalemail_boots);
		
		registerRender(vengeance_helmet);
		registerRender(vengeance_chestplate);
		registerRender(vengeance_leggings);
		registerRender(vengeance_boots);
		
		registerRender(celestial_helmet);
		registerRender(celestial_chestplate);
		registerRender(celestial_leggings);
		registerRender(celestial_boots);
		
		//registerRender(void_helmet);
		//registerRender(void_chestplate);
		//registerRender(void_leggings);
		//registerRender(void_boots);
		
		//registerRender(infernal_helmet);
		//registerRender(infernal_chestplate);
		//registerRender(infernal_leggings);
		//registerRender(infernal_boots);
		
		registerRender(arcanite_pickaxe);
		registerRender(arcanite_axe);
		registerRender(arcanite_shovel);
		registerRender(arcanite_hoe);
		registerRender(arcanite_sword);
		
		registerRender(katcheen_pickaxe);
		registerRender(katcheen_axe);
		registerRender(katcheen_shovel);
		registerRender(katcheen_hoe);
		registerRender(katcheen_sword);
		
		registerRender(consecration);
		registerRender(necrosis);
		
		registerRender(deception);
		registerRender(frostbite);
		registerRender(massacre);
		registerRender(blazefury);
		registerRender(despair);
		registerRender(souleater);
		
		registerRender(obsidian_shards);
		registerRender(glowstone_shards);
		
		registerRender(dense_draconium_dust);
		registerRender(dense_velious);
		registerRender(dense_arcanite);
		registerRender(dense_katcheen);
		registerRender(dense_necrocite);
		registerRender(dense_soularite);
		
		//registerRender(hellion_fruit);
		//registerRender(sacred_fruit);
		//registerRender(dragon_fruit);
		*/
		
		
	}
	
	public static void registerItemRenderTEMP()
	{
		
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
	
	public static void registerRenderEnum(Item item, int meta)
	{
		String itemName = item.getRegistryName().toString() + "_" + GemstoneTypeItemV1.byMetadata(meta).getName().toString().toLowerCase().replaceAll("\\s+","");
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(itemName, "inventory"));
	}
}

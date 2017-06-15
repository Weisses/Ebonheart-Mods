package com.ebonheart.EbonArtsMod.client;

import java.util.HashSet;
import java.util.Set;

import com.ebonheart.EbonArtsMod.api.ItemsEA;
import com.ebonheart.EbonArtsMod.api.Reference;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
//import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;

public final class InitItemsEARender extends ItemsEA {
	
	public static void registerRenders()
	{
		//registerRender(test_book);
		registerRender(draconium_dust);
		registerRender(velious);
		registerRender(arcanite);
		registerRender(katcheen);
		registerRender(necrocite);
		registerRender(soularite);
		registerRender(ebonheart);
		
		registerRender(cryptic_draconium_dust);
		registerRender(cryptic_velious);
		registerRender(cryptic_arcanite);
		registerRender(cryptic_katcheen);
		registerRender(cryptic_necrocite);
		registerRender(cryptic_soularite);
		registerRender(cryptic_ebonheart);
		registerRender(cryptic_obsidian_shards);
		registerRender(cryptic_glowstone_shards);
		
		
		
		
		
		
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
		
		registerRender(hellion_fruit);
		registerRender(sacred_fruit);
		registerRender(dragon_fruit);
		
		
		
		
		//registerRender(ebon_airship);
		//registerRender(test_shield);
		
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
	}
}


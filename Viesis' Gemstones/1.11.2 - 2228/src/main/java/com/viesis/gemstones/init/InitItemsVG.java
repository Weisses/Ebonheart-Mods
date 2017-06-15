package com.viesis.gemstones.init;

import java.util.HashSet;
import java.util.Set;

import com.viesis.gemstones.api.VGItems;
import com.viesis.gemstones.common.items.resources.gemstones.ItemGemstoneBasicV1;
import com.viesis.gemstones.common.items.resources.gemstones.ItemGemstoneDenseV1;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitItemsVG extends VGItems {
	
	public static final Set<Item> items = new HashSet<>();
	
	public static final Item.ToolMaterial arcaniteToolMaterial = EnumHelper.addToolMaterial("arcaniteToolMaterial", 2, 315, 6.5F, 2.5F, 15);
	public static final Item.ToolMaterial katcheenToolMaterial = EnumHelper.addToolMaterial("katcheenToolMaterial", 3, 1400, 8.5F, 4.0F, 20);
	public static final Item.ToolMaterial legendaryWeaponMaterial = EnumHelper.addToolMaterial("legendaryWeaponMaterial", 3, 1661, 9.5F, 6.0F, 30);
	public static final Item.ToolMaterial legendaryToolMaterial = EnumHelper.addToolMaterial("legendaryToolMaterial", 4, 1500, 9.5F, 2.5F, 30);
	
	
	
	public static void registerItem()
	{
		//test_book = registerItem(new ItemGuideEA());
		
		gemstone_item_basic_v1 = registerItem(new ItemGemstoneBasicV1());
		gemstone_item_dense_v1 = registerItem(new ItemGemstoneDenseV1());
		
		
		
		//gemstone_item_cryptic_v1 = registerItem(new ItemGemstoneCrypticV1());
		
		/**
		draconium_dust = registerItem(new ItemDraconiumDust());
		velious = registerItem(new ItemVelious());
		arcanite = registerItem(new ItemArcanite());
		katcheen = registerItem(new ItemKatcheen());
		necrocite = registerItem(new ItemNecrocite());
		soularite = registerItem(new ItemSoularite());
		ebonheart = registerItem(new ItemEbonheart());
		obsidian_shards = registerItem(new ItemObsidianShard());
		glowstone_shards = registerItem(new ItemGlowstoneShard());
		
		cryptic_draconium_dust = registerItem(new ItemCryptic("gem/cryptic_draconium_dust"));
		cryptic_velious = registerItem(new ItemCryptic("gem/cryptic_velious"));
		cryptic_arcanite = registerItem(new ItemCryptic("gem/cryptic_arcanite"));
		cryptic_katcheen = registerItem(new ItemCryptic("gem/cryptic_katcheen"));
		cryptic_necrocite = registerItem(new ItemCryptic("gem/cryptic_necrocite"));
		cryptic_soularite = registerItem(new ItemCryptic("gem/cryptic_soularite"));
		cryptic_ebonheart = registerItem(new ItemCryptic("gem/cryptic_ebonheart"));
		cryptic_obsidian_shards = registerItem(new ItemCryptic("gem/cryptic_obsidian_shard"));
		cryptic_glowstone_shards = registerItem(new ItemCryptic("gem/cryptic_glowstone_shard"));
		
		glowing_disc = registerItem(new ItemMusicDiscEA("disc/glowing_disc", SoundEventsEA.island));
		shimmering_disc = registerItem(new ItemMusicDiscEA("disc/shimmering_disc", SoundEventsEA.dire));
		laminate_disc = registerItem(new ItemMusicDiscEA("disc/laminate_disc", SoundEventsEA.marble));
		resilient_disc = registerItem(new ItemMusicDiscEA("disc/resilient_disc", SoundEventsEA.strength));
		dismal_disc = registerItem(new ItemMusicDiscEA("disc/dismal_disc", SoundEventsEA.castle));
		ethereal_disc = registerItem(new ItemMusicDiscEA("disc/ethereal_disc", SoundEventsEA.timescar));
		mirroring_disc = registerItem(new ItemMirroringDisc("disc/mirroring_disc", SoundEventsEA.lostwoods));
		
		empowered_blade = registerItem(new ItemEmpoweredBlade());
		
		enchanted_ebonheart = registerItem(new ItemEnchantedEbonheart());
		
		

		dense_draconium_dust = registerItem(new ItemDense("gem/dense_draconium_dust"));
		dense_velious = registerItem(new ItemDense("gem/dense_velious"));
		dense_arcanite = registerItem(new ItemDense("gem/dense_arcanite"));
		dense_katcheen = registerItem(new ItemDense("gem/dense_katcheen"));
		dense_necrocite = registerItem(new ItemDense("gem/dense_necrocite"));
		dense_soularite = registerItem(new ItemDense("gem/dense_soularite"));
		
		
		hellion_fruit = registerItem(new ItemHellionFruit(6, 0.6F));
		sacred_fruit = registerItem(new ItemSacredFruit(3, 0.8F));
		dragon_fruit = registerItem(new ItemDragonFruit(6, 0.8F));
				//, InitBlocksEA.dragon_fruit//, Blocks.farmland
				//));
		
		arcanite_pickaxe = registerItem(new ItemArcanitePickaxe(arcaniteToolMaterial));
		arcanite_axe = registerItem(new ItemArcaniteAxe(ToolMaterial.IRON));
		arcanite_shovel = registerItem(new ItemArcaniteShovel(arcaniteToolMaterial));
		arcanite_hoe = registerItem(new ItemArcaniteHoe(arcaniteToolMaterial));
		arcanite_sword = registerItem(new ItemArcaniteSword(arcaniteToolMaterial));
		
		burnished_helmet = registerItem(new ItemBurnishedArmor("armor/burnished_helmet", 0, EntityEquipmentSlot.HEAD));
		burnished_chestplate = registerItem(new ItemBurnishedArmor("armor/burnished_chestplate", 0, EntityEquipmentSlot.CHEST));
		burnished_leggings = registerItem(new ItemBurnishedArmor("armor/burnished_leggings", 0, EntityEquipmentSlot.LEGS));
		burnished_boots = registerItem(new ItemBurnishedArmor("armor/burnished_boots", 0, EntityEquipmentSlot.FEET));
		
		katcheen_pickaxe = registerItem(new ItemKatcheenPickaxe(katcheenToolMaterial));
		katcheen_axe = registerItem(new ItemKatcheenAxe(ToolMaterial.DIAMOND));
		katcheen_shovel = registerItem(new ItemKatcheenShovel(katcheenToolMaterial));
		katcheen_hoe = registerItem(new ItemKatcheenHoe(katcheenToolMaterial));
		katcheen_sword = registerItem(new ItemKatcheenSword(katcheenToolMaterial));
		
		scalemail_helmet = registerItem(new ItemScalemailArmor("armor/scalemail_helmet", 0, EntityEquipmentSlot.HEAD));
		scalemail_chestplate = registerItem(new ItemScalemailArmor("armor/scalemail_chestplate", 0, EntityEquipmentSlot.CHEST));
		scalemail_leggings = registerItem(new ItemScalemailArmor("armor/scalemail_leggings", 0, EntityEquipmentSlot.LEGS));
		scalemail_boots = registerItem(new ItemScalemailArmor("armor/scalemail_boots", 0, EntityEquipmentSlot.FEET));
		
		
		vengeance_helmet = registerItem(new ItemVengeanceArmor("armor/vengeance_helmet", 0, EntityEquipmentSlot.HEAD));
		vengeance_chestplate = registerItem(new ItemVengeanceArmor("armor/vengeance_chestplate", 0, EntityEquipmentSlot.CHEST));
		vengeance_leggings = registerItem(new ItemVengeanceArmor("armor/vengeance_leggings", 0, EntityEquipmentSlot.LEGS));
		vengeance_boots = registerItem(new ItemVengeanceArmor("armor/vengeance_boots", 0, EntityEquipmentSlot.FEET));
		
		celestial_helmet = registerItem(new ItemCelestialArmor("armor/celestial_helmet", 0, EntityEquipmentSlot.HEAD));
		celestial_chestplate = registerItem(new ItemCelestialArmor("armor/celestial_chestplate", 0, EntityEquipmentSlot.CHEST));
		celestial_leggings = registerItem(new ItemCelestialArmor("armor/celestial_leggings", 0, EntityEquipmentSlot.LEGS));
		celestial_boots = registerItem(new ItemCelestialArmor("armor/celestial_boots", 0, EntityEquipmentSlot.FEET));
		
		//void_helmet = registerItem(new ItemVoidArmor("armor/void_helmet", 0, EntityEquipmentSlot.HEAD));
		//void_chestplate = registerItem(new ItemVoidArmor("armor/void_chestplate", 0, EntityEquipmentSlot.CHEST));
		//void_leggings = registerItem(new ItemVoidArmor("armor/void_leggings", 0, EntityEquipmentSlot.LEGS));
		//void_boots = registerItem(new ItemVoidArmor("armor/void_boots", 0, EntityEquipmentSlot.FEET));
		
		//infernal_helmet = registerItem(new ItemInfernalArmor("armor/infernal_helmet", 0, EntityEquipmentSlot.HEAD));
		//infernal_chestplate = registerItem(new ItemInfernalArmor("armor/infernal_chestplate", 0, EntityEquipmentSlot.CHEST));
		//infernal_leggings = registerItem(new ItemInfernalArmor("armor/infernal_leggings", 0, EntityEquipmentSlot.LEGS));
		//infernal_boots = registerItem(new ItemInfernalArmor("armor/infernal_boots", 0, EntityEquipmentSlot.FEET));
		
		
		
		deception = registerItem(new ItemDeception(legendaryWeaponMaterial));
		frostbite = registerItem(new ItemFrostbite(legendaryWeaponMaterial));
		massacre = registerItem(new ItemMassacre(legendaryWeaponMaterial));
		blazefury = registerItem(new ItemBlazefury(legendaryWeaponMaterial));
		despair = registerItem(new ItemDespair(legendaryWeaponMaterial));
		souleater = registerItem(new ItemSouleater(legendaryWeaponMaterial));
		
		//test_shield = registerItem(new ItemTestShield());
		//omniplex = new Omniplex().setUnlocalizedName("omniplex");
		//banana = (ItemFood) new ItemFood(3, 0.3F, false).setUnlocalizedName("banana");
		
		consecration = registerItem(new ItemConsecration(legendaryToolMaterial));
		necrosis = registerItem(new ItemNecrosis(legendaryToolMaterial));
		
		
		//ebon_airship = //registerItem(
				//new ItemBoat(EntityBoat.Type.OAK);
		//		new ItemAirship
		//		(
						//EntityBoat.Type.OAK
						//EntityAirship.Type.OAK
		//				);
		
		*/
		//test_door = registerItem(new EAItemDoor(InitBlocksEA.test_door));
		
	}
	
	private static <V extends Item> V registerItem(V item) 
	{
		GameRegistry.register(item);
		items.add(item);

		return item;
	}
}

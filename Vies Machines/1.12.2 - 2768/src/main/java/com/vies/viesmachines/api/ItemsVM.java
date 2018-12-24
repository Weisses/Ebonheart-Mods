package com.vies.viesmachines.api;

import com.vies.viesmachines.common.items.ItemGeneric;
import com.vies.viesmachines.common.items.ItemGenericParticle;
import com.vies.viesmachines.common.items.ItemGenericSymbol;
import com.vies.viesmachines.common.items.ItemGenericWIP;
import com.vies.viesmachines.common.items.kits.ItemKitAdmin;
import com.vies.viesmachines.common.items.kits.ItemKitAmmo;
import com.vies.viesmachines.common.items.kits.ItemKitDurability;
import com.vies.viesmachines.common.items.kits.ItemKitEnergy;
import com.vies.viesmachines.common.items.kits.ItemKitHealth;
import com.vies.viesmachines.common.items.machines.flying.ItemMachineFlyingAirship;
import com.vies.viesmachines.common.items.misc.ItemMachinePellets;
import com.vies.viesmachines.common.items.parts.ItemComponentFlying;
import com.vies.viesmachines.common.items.parts.ItemComponentGround;
import com.vies.viesmachines.common.items.parts.ItemComponentWater;
import com.vies.viesmachines.common.items.tools.ItemToolDismounting;
import com.vies.viesmachines.common.items.tools.ItemToolRadioExpansion;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeComponent;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeEngine;
import com.vies.viesmachines.common.items.upgrades.ItemUpgradeFrame;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;

public class ItemsVM {
	
	public static final Item XEGONITE = new ItemGeneric("item_xegonite", EnumRarity.COMMON);
	public static final Item XEGONITE_WATER = new ItemGeneric("item_xegonite_water", EnumRarity.COMMON);
	public static final Item XEGONITE_LAVA = new ItemGeneric("item_xegonite_lava", EnumRarity.COMMON);
	
	public static final Item XEGONITE_ENDER = new ItemGeneric("item_xegonite_ender", EnumRarity.COMMON);
	public static final Item CIRCUIT_LOGIC = new ItemGeneric("item_circuit_logic", EnumRarity.COMMON);
	public static final Item CIRCUIT_ADAPTIVE = new ItemGeneric("item_circuit_adaptive", EnumRarity.COMMON);
	
	public static final Item KIT_BLANK = new ItemGeneric("kits/item_kit_blank", EnumRarity.COMMON);
	public static final Item KIT_UPGRADE_MAX = new ItemKitAdmin("kits/item_admin_upgrade_max", EnumRarity.EPIC, 0);
	public static final Item KIT_MACHINE_MAX = new ItemKitAdmin("kits/item_admin_machine_max", EnumRarity.EPIC, 1);
	
	//===============================================================
	
	public static final Item MACHINE_PELLETS = new ItemMachinePellets("item_machine_pellets", EnumRarity.UNCOMMON);
	public static final Item MACHINE_FRAME = new ItemGeneric("item_machine_frame", EnumRarity.COMMON);
	public static final Item MACHINE_ENGINE = new ItemGeneric("item_machine_engine", EnumRarity.COMMON);
	
	public static final Item MACHINE_COMPONENT_GROUND = new ItemComponentGround("item_machine_component_ground");
	public static final Item MACHINE_COMPONENT_WATER = new ItemComponentWater("item_machine_component_water");
	public static final Item MACHINE_COMPONENT_FLYING = new ItemComponentFlying("item_machine_component_flying");
	
	public static final Item KIT_AMMO_4 = new ItemKitAmmo("kits/item_kit_ammo_4", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_AMMO_16 = new ItemKitAmmo("kits/item_kit_ammo_16", EnumRarity.RARE, 1);
	public static final Item KIT_AMMO_64 = new ItemKitAmmo("kits/item_kit_ammo_64", EnumRarity.EPIC, 2);
	
	//===============================================================
	
	public static final Item KIT_HEALTH_2 = new ItemKitHealth("kits/item_kit_health_2", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_HEALTH_8 = new ItemKitHealth("kits/item_kit_health_8", EnumRarity.RARE, 1);
	public static final Item KIT_HEALTH_MAX = new ItemKitHealth("kits/item_kit_health_max", EnumRarity.EPIC, 2);
	
	public static final Item KIT_ENERGY_25 = new ItemKitEnergy("kits/item_kit_energy_25", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_ENERGY_100 = new ItemKitEnergy("kits/item_kit_energy_100", EnumRarity.RARE, 1);
	public static final Item KIT_ENERGY_MAX = new ItemKitEnergy("kits/item_kit_energy_max", EnumRarity.EPIC, 2);
	
	public static final Item KIT_DURABILITY_50 = new ItemKitDurability("kits/item_kit_durability_50", EnumRarity.UNCOMMON, 0);
	public static final Item KIT_DURABILITY_200 = new ItemKitDurability("kits/item_kit_durability_200", EnumRarity.RARE, 1);
	public static final Item KIT_DURABILITY_MAX = new ItemKitDurability("kits/item_kit_durability_max", EnumRarity.EPIC, 2);
	
	//===============================================================

	public static final Item ITEM_MACHINE_GROUND_HOVERCRAFT = new ItemGenericWIP("machines/item_machine_ground_hovercraft", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_GROUND_2 = new ItemGenericWIP("machines/item_machine_ground_2", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_GROUND_3 = new ItemGenericWIP("machines/item_machine_ground_3", EnumRarity.RARE);
	
	public static final Item ITEM_MACHINE_WATER_SUBMARINE = new ItemGenericWIP("machines/item_machine_water_submarine", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_WATER_2 = new ItemGenericWIP("machines/item_machine_water_2", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_WATER_3 = new ItemGenericWIP("machines/item_machine_water_3", EnumRarity.RARE);
	
	public static final Item ITEM_MACHINE_FLYING_AIRSHIP = new ItemMachineFlyingAirship("machines/item_machine_flying_airship", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_FLYING_HELICOPTER = new ItemGenericWIP("machines/item_machine_flying_helicopter", EnumRarity.RARE);
	public static final Item ITEM_MACHINE_FLYING_3 = new ItemGenericWIP("machines/item_machine_flying_3", EnumRarity.RARE);
	
	//===============================================================
	
	public static final Item UPGRADE_FRAME_TIER1 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_FRAME_TIER2 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_FRAME_TIER3 = new ItemUpgradeFrame("upgrades/item_upgrade_frame_tier3", EnumRarity.EPIC, 3);
	
	public static final Item UPGRADE_ENGINE_TIER1 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_ENGINE_TIER2 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_ENGINE_TIER3 = new ItemUpgradeEngine("upgrades/item_upgrade_engine_tier3", EnumRarity.EPIC, 3);
	
	public static final Item UPGRADE_COMPONENT_TIER1 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier1", EnumRarity.UNCOMMON, 1);
	public static final Item UPGRADE_COMPONENT_TIER2 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier2", EnumRarity.RARE, 2);
	public static final Item UPGRADE_COMPONENT_TIER3 = new ItemUpgradeComponent("upgrades/item_upgrade_component_tier3", EnumRarity.EPIC, 3);
	
	//===============================================================
	
	public static final Item TOOL_DISMOUNTER = new ItemToolDismounting();
	public static final Item TOOL_RADIO_EXPANSION = new ItemToolRadioExpansion();
	
	//===============================================================
	
	
	
	//==================================================
    // TODO           Display Symbols
	//==================================================
    
	// General:
	public static final Item SYMBOL_LOGOFORGE = new ItemGenericSymbol("symbols/item_symbol_logoforge");
	public static final Item SYMBOL_COINSTACK = new ItemGenericSymbol("symbols/item_symbol_coinstack");
	public static final Item SYMBOL_SCROLL = new ItemGenericSymbol("symbols/item_symbol_scroll");
	public static final Item SYMBOL_WRENCH = new ItemGenericSymbol("symbols/item_symbol_wrench");
	public static final Item SYMBOL_KEY = new ItemGenericSymbol("symbols/item_symbol_key");
	public static final Item SYMBOL_PADLOCK = new ItemGenericSymbol("symbols/item_symbol_padlock");
	public static final Item SYMBOL_BELL = new ItemGenericSymbol("symbols/item_symbol_bell");
	public static final Item SYMBOL_ANCHOR = new ItemGenericSymbol("symbols/item_symbol_anchor");
	public static final Item SYMBOL_BARREL = new ItemGenericSymbol("symbols/item_symbol_barrel");
	public static final Item SYMBOL_GEARS = new ItemGenericSymbol("symbols/item_symbol_gears");
	
	// Elemental:
	public static final Item SYMBOL_ELEMENTAL_EARTH = new ItemGenericSymbol("symbols/item_symbol_elemental_earth");
	public static final Item SYMBOL_ELEMENTAL_WIND = new ItemGenericSymbol("symbols/item_symbol_elemental_wind");
	public static final Item SYMBOL_ELEMENTAL_WATER = new ItemGenericSymbol("symbols/item_symbol_elemental_water");
	public static final Item SYMBOL_ELEMENTAL_FIRE = new ItemGenericSymbol("symbols/item_symbol_elemental_fire");
	public static final Item SYMBOL_ELEMENTAL_NATURE = new ItemGenericSymbol("symbols/item_symbol_elemental_nature");
	public static final Item SYMBOL_ELEMENTAL_LIGHTNING = new ItemGenericSymbol("symbols/item_symbol_elemental_lightning");
	public static final Item SYMBOL_ELEMENTAL_ICE = new ItemGenericSymbol("symbols/item_symbol_elemental_ice");
	public static final Item SYMBOL_ELEMENTAL_LIFE = new ItemGenericSymbol("symbols/item_symbol_elemental_life");
	public static final Item SYMBOL_ELEMENTAL_DEATH = new ItemGenericSymbol("symbols/item_symbol_elemental_death");
	public static final Item SYMBOL_ELEMENTAL_VOID = new ItemGenericSymbol("symbols/item_symbol_elemental_void");
	
	// Animal:
	public static final Item SYMBOL_ANIMAL_DOG = new ItemGenericSymbol("symbols/item_symbol_animal_dog");
	public static final Item SYMBOL_ANIMAL_CAT = new ItemGenericSymbol("symbols/item_symbol_animal_cat");
	public static final Item SYMBOL_ANIMAL_FOX = new ItemGenericSymbol("symbols/item_symbol_animal_fox");
	public static final Item SYMBOL_ANIMAL_OWL = new ItemGenericSymbol("symbols/item_symbol_animal_owl");
	public static final Item SYMBOL_ANIMAL_BEAR = new ItemGenericSymbol("symbols/item_symbol_animal_bear");
	public static final Item SYMBOL_ANIMAL_LION = new ItemGenericSymbol("symbols/item_symbol_animal_lion");
	public static final Item SYMBOL_ANIMAL_WOLF = new ItemGenericSymbol("symbols/item_symbol_animal_wolf");
	public static final Item SYMBOL_ANIMAL_FISH = new ItemGenericSymbol("symbols/item_symbol_animal_fish");
	public static final Item SYMBOL_ANIMAL_SHARK = new ItemGenericSymbol("symbols/item_symbol_animal_shark");
	public static final Item SYMBOL_ANIMAL_OCTOPUS = new ItemGenericSymbol("symbols/item_symbol_animal_octopus");
	
	// Mythical creature:
	//Griffin
	//chimera
	//minotaur
	//jackalope
	//basilisk
	//public static final Item SYMBOL_MYTHICAL_Pegasis = new ItemGenericSymbol("symbols/item_symbol_mythical_phoenix");
	//public static final Item SYMBOL_MYTHICAL_UNICORN = new ItemGenericSymbol("symbols/item_symbol_mythical_phoenix");
	//public static final Item SYMBOL_MYTHICAL_CERBERUS = new ItemGenericSymbol("symbols/item_symbol_mythical_phoenix");
	//public static final Item SYMBOL_MYTHICAL_PHOENIX = new ItemGenericSymbol("symbols/item_symbol_mythical_phoenix");
	//public static final Item SYMBOL_MYTHICAL_DRAGON = new ItemGenericSymbol("symbols/item_symbol_mythical_dragon");
	
	
	// Holidays:
	// Christmas:
	public static final Item SYMBOL_CHRISTMAS_TREE = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_tree");
	public static final Item SYMBOL_CHRISTMAS_WREATH = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_wreath");
	public static final Item SYMBOL_CHRISTMAS_ORNAMENT = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_ornament");
	public static final Item SYMBOL_CHRISTMAS_STOCKING = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_stocking");
	public static final Item SYMBOL_CHRISTMAS_NIGHTSKY = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_nightsky");
	public static final Item SYMBOL_CHRISTMAS_GRINCH = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_grinch");
	public static final Item SYMBOL_CHRISTMAS_MAX = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_max");
	public static final Item SYMBOL_CHRISTMAS_FROSTY = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_frosty");
	public static final Item SYMBOL_CHRISTMAS_PEANUTS = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_peanuts");
	public static final Item SYMBOL_CHRISTMAS_POKEMON = new ItemGenericSymbol("symbols/holidays/item_symbol_christmas_pokemon");
	
	
	
	//==================================================
    // TODO              Particles
	//==================================================
    
	public static final Item PARTICLE_BULLET_NORMAL = new ItemGenericParticle("particles/item_particle_bullet_normal", EnumRarity.COMMON);
	public static final Item PARTICLE_BULLET_ELECTRICAL = new ItemGenericParticle("particles/item_particle_bullet_electrical", EnumRarity.COMMON);
	public static final Item PARTICLE_BULLET_EXPLOSIVE = new ItemGenericParticle("particles/item_particle_bullet_explosive", EnumRarity.COMMON);
	
	public static final Item PARTICLE_STATIC_CHARGE = new ItemGenericParticle("particles/item_particle_static_charge", EnumRarity.COMMON);
	
	
	
	//===============================================================
	
	//Unused
	//public static final Item GUIDEBOOK = new ItemGuidebook();
	//public static final Item TOOL_UNIVERSAL = new ItemToolRepairing();
	
	/*                              Display banner ideas:
	
	//public static final Item SYMBOL_LOGOVIESMACHINES = new ItemGenericSymbol("symbols/item_symbol_logoviesmachines");
	//public static final Item SYMBOL_LOGOMINECRAFT = new ItemGenericSymbol("symbols/item_symbol_logominecraft");
	
	POISON(25, "element_poison", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.25")),
    ARCANE(26, "element_arcane", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.26")),
    
    
    SHIELD(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    HAMMER(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    FIST(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    SUN(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    MOON(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    
    CELTIC(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    YGGDRASIL(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0")),
    MJOLLNIR(7, "lava", References.Old_I18n.translateToLocalFormatted("vc.enum.displaysymbol.0"));
    
    -----------holiday display items---------------------
    //New Years
        YEAR2018(1, "1", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.1")),
        YEAR2019(2, "2", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.2")),
        H3(3, "3", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.3")),
        H4(4, "4", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.4")),
    	H5(5, "5", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.5")),
    	H6(6, "6", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.6")),
    	H7(7, "7", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.7")),
    	H8(8, "8", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.8")),
    	H9(9, "9", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.9")),
    	H10(10, "10", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.10")),
    	H11(11, "11", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.11")),
    	H12(12, "12", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.12")),
    	
    	//Valentine's Day
    	ROSE(13, "13", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.13")),
        TEDDYBEAR(14, "14", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.14")),
    	CUPID(15, "15", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.15")),
    	RING(16, "16", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.16")),
    	CARD(17, "17", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.17")),
    	PRESENTHEART(18, "18", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.18")),
    	HEARTMUSIC(19, "19", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.19")),
    	HEARTLOCK(20, "20", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.20")),
    	HEARTBROKEN(21, "21", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.21")),
    	HEART1(22, "22", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.22")),
    	HEART2(23, "23", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.23")),
        HEART3(24, "24", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.24")),
        
        //Easter
    	EGG1(25, "25", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.25")),
    	EGG2(26, "26", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.26")),
    	EGG3(27, "27", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.27")),
    	EGG4(28, "28", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.28")),
    	BASKETEGG(29, "29", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.29")),
    	FLOWER(30, "30", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.30")),
    	BUTTERFLY(31, "31", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.31")),
    	CHICK1(32, "32", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.32")),
    	CHICK2(33, "33", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.33")),
        BUNNY1(34, "34", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.34")),
    	BUNNY2(35, "35", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.35")),
    	BUNNY3(36, "36", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.36")),
    	
    	//4th of July
    	CRACKEDBELL(37, "37", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.37")),
    	TOPHATUSA(38, "38", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.38")),
    	MEDAL(39, "39", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.39")),
    	FLAGUSA(40, "40", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.40")),
    	REPUBLICAN(41, "41", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.41")),
    	DEMOCRAT(42, "42", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.42")),
    	ROCKET1(43, "43", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.43")),
        ROCKET2(44, "44", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.44")),
        FIREWORK1(45, "45", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.45")),
    	FIREWORK2(46, "46", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.46")),
    	FIREWORK3(47, "47", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.47")),
    	LIBERTYTORCH(48, "48", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.48")),
    	
    	//Halloween
    	JACKOLANTERN(49, "49", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.49")),
    	BLACKCAT(50, "50", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.50")),
    	BAT(51, "51", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.51")),
    	SPIDER(52, "52", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.52")),
    	CAULDRON(53, "53", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.53")),
        NIGHTSKYMOON(54, "54", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.54")),
    	TOMBSTONE(55, "55", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.55")),
    	SCYTHE(56, "56", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.56")),
    	JACK(57, "57", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.57")),
    	SALLY(58, "58", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.58")),
    	ZERO(59, "59", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.59")),
    	BOOGEYMAN(60, "60", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.60")),
    	
    	//Thanksgiving
    	PILGRIMHAT(61, "61", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.61")),
    	INDIANHAT(62, "62", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.62")),
    	BOAT(63, "63", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.63")),
    	MAPLELEAF(64, "64", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.64")),
    	MAPLELEAVES(65, "65", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.65")),
    	SUNFLOWER(66, "66", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.66")),
    	CORNSTALK(67, "67", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.67")),
    	WHEAT(68, "68", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.68")),
    	PIESLICE(69, "69", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.69")),
    	PIEWHOLE(70, "70", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.70")),
    	TURKEY(71, "71", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.71")),
    	BASKET(72, "72", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.72")),
    	
    	//Christmas
    	PRESENTSMALL(73, "73", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.73")),
        PRESENTLARGE(74, "74", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.74")),
    	CANDYCANE(75, "75", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.75")),
    	SNOWFLAKE(76, "76", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.76")),
    	ORNAMENT(77, "77", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.77")),
    	MISTLETOE(78, "78", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.78")),
    	WREATH(79, "79", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.79")),
    	STOCKING(80, "80", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.80")),
    	CHRISTMASTREE(81, "81", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.81")),
    	REINDEER(82, "82", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.82")),
    	SLEIGH(83, "83", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.83")),
        SANTA(84, "84", References.Old_I18n.translateToLocalFormatted("vc.enum.holidaysymbol.84"));
    	
    */
	
	
	
}

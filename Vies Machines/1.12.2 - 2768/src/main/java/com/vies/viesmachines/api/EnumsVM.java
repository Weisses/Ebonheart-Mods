package com.vies.viesmachines.api;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;

public class EnumsVM {
	
	//==================================================
    // TODO            Main Machine Logic
	//==================================================
    
	/** Flying Machine Frame Tier enum - Dictates registry name, localized name, max health, max energy, max durability. */
	public static enum FlyingMachineFrameTier
    {
    	// STRING(meta, registry name, localized name, max health, max energy, max durability):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 8.0F, 100, 250),
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 16.0F, 200, 500),
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 24.0F, 300, 750),
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 32.0F, 500, 1000);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float maxHealth;
        private final int maxEnergy;
        private final int maxDurability;
        
        private FlyingMachineFrameTier(int metadataIn, String registryNameIn, String localizedNameIn, float maxHealthIn, int maxEnergyIn, int maxDurabilityIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.maxHealth = maxHealthIn;
            this.maxEnergy = maxEnergyIn;
            this.maxDurability = maxDurabilityIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public float getMaxHealthModifier()
        {
            return this.maxHealth;
        }
        
        public int getMaxEnergyModifier()
        {
            return this.maxEnergy;
        }
        
        public int getMaxDurabilityModifier()
        {
            return this.maxDurability;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineFrameTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineFrameTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/** Flying Machine Engine Tier enum - Dictates registry name, localized name, forward speed, turn speed, energy increase, durability decrease. */
	public static enum FlyingMachineEngineTier
    {
    	// STRING(meta, registry name, localized name, forward speed, turn speed, energy increase in ticks, durability decrease in ticks):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 0.005F, 0.1F, 2400, 600),//2 minutes, 30 seconds
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 0.010F, 0.2F, 1800, 1200),   //1 minute 30 seconds, 1 minute
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 0.015F, 0.3F, 1200, 1800),   //1 minute, 1 minute 30 seconds
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 0.020F, 0.4F, 600, 2400);  //30 seconds, 2 minutes
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float fowardSpeed;
        private final float turnSpeed;
        private final int energyIncrease;
        private final int durabilityDecrease;
        
        private FlyingMachineEngineTier(int metadataIn, String registryNameIn, String localizedNameIn, float fowardSpeedIn, float turnSpeedIn, int energyIncreaseIn, int durabilityDecreaseIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.fowardSpeed = fowardSpeedIn;
            this.turnSpeed = turnSpeedIn;
            this.energyIncrease = energyIncreaseIn;
            this.durabilityDecrease = durabilityDecreaseIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public float getFowardSpeedModifier()
        {
            return this.fowardSpeed;
        }
        
        public float getTurnSpeedModifier()
        {
            return this.turnSpeed;
        }
        
        public int getEnergyIncreaseModifier()
        {
            return this.energyIncrease;
        }
        
        public int getDurabilityDecreaseModifier()
        {
            return this.durabilityDecrease;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineEngineTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineEngineTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/** Flying Machine Component Tier enum - Dictates registry name, localized name, max ammo, special stat (max elevation). */
	public static enum FlyingMachineComponentTier
    {
    	// STRING(meta, registry name, localized name, max ammo, ?firing cooldown?, special stat (max elevation)):
		BASE(0, "tierbase", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), 100, 1, 75),
		ONE(1, "tier1", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.1"), 200, 3, 125),
		TWO(2, "tier2", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.2"), 300, 5, 200),
		THREE(3, "tier3", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.3"), 500, 7, 4096);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final int maxAmmo;
        private final int maxRecordSlots;
        private final int maxElevation;
        
        private FlyingMachineComponentTier(int metadataIn, String registryNameIn, String localizedNameIn, int maxAmmoIn, int maxRecordSlotsIn, int maxElevationIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.maxAmmo = maxAmmoIn;
            this.maxRecordSlots = maxRecordSlotsIn;
            this.maxElevation = maxElevationIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public int getMaxAmmoModifier()
        {
            return this.maxAmmo;
        }
        
        public int getMaxRecordSlots()
        {
            return this.maxRecordSlots;
        }
        
        public int getMaxElevationModifier()
        {
            return this.maxElevation;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineComponentTier byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.FlyingMachineComponentTier getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	
	
	//==================================================
    // TODO            Event Trigger
	//==================================================
	
	/** Event Trigger enum. Handles all registered machine events. */
	public static enum EventTrigger
    {
    	// STRING(meta, registry name):
		NONE(0, "none"),
		FALL(1, "fall"),
		BROKEN(2, "broken"),
		DESTRUCTION(3, "destruction"),
		LIGHTNING_STRIKE(4, "lightning_strike"),
		INJURED(5, "injured"),
		
		HEALTH_2(11, "health_2"),
		HEALTH_8(12, "health_8"),
		HEALTH_MAX(13, "health_max"),
		
		ENERGY_25(21, "energy_25"),
		ENERGY_100(22, "energy_100"),
		ENERGY_MAX(23, "energy_max"),
		
		DURABILITY_50(31, "durability_50"),
		DURABILITY_200(32, "durability_200"),
		DURABILITY_MAX(33, "durability_max"),
		
		UPGRADE_TIER1(41, "upgrade_tier1"),
		UPGRADE_TIER2(42, "upgrade_tier2"),
		UPGRADE_TIER3(43, "upgrade_tier3"),
		
		AMMO_4(51, "ammo_4"),
		AMMO_16(52, "ammo_16"),
		AMMO_64(53, "ammo_64"),
		
		;
		
		private final int metadata;
        private final String registryName;
        
        private EventTrigger(int metadataIn, String registryNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.EventTrigger byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVM.EventTrigger getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getRegistryName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    
	
	//==================================================
    // TODO            Visual Machine
	//==================================================
	
	/** Visual Machine Texture enum. (47 textures) */
	public static enum VisualMachineTexture
    {
		// STRING(meta, localized name, block, block meta):
		DEFAULT(0, "default", BlocksVM.XEGONITE_BASIC, 0),
    	
    	// Tier 0:
    	COBBLESTONE(1, "cobblestone", Blocks.COBBLESTONE, 0),
    	SANDSTONE(2, "sandstone", Blocks.SANDSTONE, 0),
        SNOW(3, "snow", Blocks.SNOW, 0),
        HAY_BLOCK(4, "hay_block", Blocks.HAY_BLOCK, 0),
        
    	// Tier 1:
        PLANK_OAK(5, "plank_oak", Blocks.PLANKS, 0),
        PLANK_SPRUCE(6, "plank_spruce", Blocks.PLANKS, 1),
        PLANK_BIRCH(7, "plank_birch", Blocks.PLANKS, 2),
        PLANK_JUNGLE(8, "plank_jungle", Blocks.PLANKS, 3),
        PLANK_ACACIA(9, "plank_acacia", Blocks.PLANKS, 4),
        PLANK_DARK_OAK(10, "plank_dark_oak", Blocks.PLANKS, 5),
        PODZOL(11, "podzol", Blocks.DIRT, 1),
        
    	LOG_OAK(12, "log_oak", Blocks.LOG, 0),
    	LOG_SPRUCE(13, "log_spruce", Blocks.LOG, 1),
    	LOG_BIRCH(14, "log_birch", Blocks.LOG, 2),
    	LOG_JUNGLE(15, "log_jungle", Blocks.LOG, 3),
    	LOG_ACACIA(16, "log_acacia", Blocks.LOG2, 0),
    	LOG_DARK_OAK(17, "log_dark_oak", Blocks.LOG2, 1),
        MYCELIUM(18, "mycelium", Blocks.MYCELIUM, 0),
        
        // Tier 2:
        ORE_QUARTZ(19, "ore_quartz", Blocks.QUARTZ_ORE, 0),
        ORE_IRON(20, "ore_iron", Blocks.IRON_ORE, 0),
        ORE_GOLD(21, "ore_gold", Blocks.GOLD_ORE, 0),
        ORE_REDSTONE(22, "ore_redstone", Blocks.REDSTONE_ORE, 0),
        ORE_LAPIS_LAZULI(23, "ore_lapis_lazuli", Blocks.LAPIS_ORE, 0),
        ORE_DIAMOND(24, "ore_diamond", Blocks.DIAMOND_ORE, 0),
        ORE_EMERALD(25, "ore_emerald", Blocks.EMERALD_ORE, 0),
        
        BRICK(26, "brick", Blocks.BRICK_BLOCK, 0),
        IRON(27, "iron", Blocks.IRON_BLOCK, 0),
        GOLD(28, "gold", Blocks.GOLD_BLOCK, 0),
        REDSTONE(29, "redstone", Blocks.REDSTONE_BLOCK, 0),
        LAPIS_LAZULI(30, "lapis_lazuli", Blocks.LAPIS_BLOCK, 0),
        DIAMOND(31, "diamond", Blocks.DIAMOND_BLOCK, 0),
        EMERALD(32, "emerald", Blocks.EMERALD_BLOCK, 0),
        
        // Tier 3:
        ICE(33, "ice", Blocks.ICE, 0),
        SLIME(34, "slime", Blocks.SLIME_BLOCK, 0),
        NETHER_BRICK(35, "nether_brick", Blocks.NETHER_BRICK, 0),
        SOUL_SAND(36, "soul_sand", Blocks.SOUL_SAND, 0),
        QUARTZ(37, "quartz", Blocks.QUARTZ_BLOCK, 0),
        GLOWSTONE(38, "glowstone", Blocks.GLOWSTONE, 0),
        OBSIDIAN(39, "obsidian", Blocks.OBSIDIAN, 0),
        
        BEDROCK(40, "bedrock", Blocks.BEDROCK, 0),
        PRISMARINE(41, "prismarine", Blocks.PRISMARINE, 0),
        END_STONE(42, "end_stone", Blocks.END_STONE, 0),
        PURPUR(43, "purpur", Blocks.PURPUR_BLOCK, 0),
    	WATER(44, "water", BlocksVM.WATER_BASIC, 0), 
    	LAVA(45, "lava", BlocksVM.LAVA_BASIC, 0), 
    	ENDER(46, "ender", BlocksVM.ENDER_BASIC, 0);
		
		private final int metadata;
		private final String registryName;
        private final Block block;
		private final int blockMetadata;
        
        private VisualMachineTexture(int metadataIn, String registryNameIn, Block blockIn, int blockMetadataIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.block = blockIn;
            this.blockMetadata = blockMetadataIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public ItemStack getBlock()
        {
            return new ItemStack(Item.getItemFromBlock(block), 1, this.blockMetadata);//this.block; //Block.getBlockFromItem(new ItemStack(Items.DIAMOND, 0).getItem());
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualMachineTexture byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	/** Visual Display Symbol enum. Dictates registry name. */
	public static enum VisualDisplaySymbol
    {
		// STRING(meta, localized name, item):
		// General:
		SYMBOL_LOGOFORGE(0, "forge", ItemsVM.SYMBOL_LOGOFORGE),
		SYMBOL_COINSTACK(1, "coinstack", ItemsVM.SYMBOL_COINSTACK),
		SYMBOL_SCROLL(2, "scroll", ItemsVM.SYMBOL_SCROLL),
		SYMBOL_WRENCH(3, "wrench", ItemsVM.SYMBOL_WRENCH),
		SYMBOL_KEY(4, "key", ItemsVM.SYMBOL_KEY),
		SYMBOL_PADLOCK(5, "padlock", ItemsVM.SYMBOL_PADLOCK),
		SYMBOL_BELL(6, "bell", ItemsVM.SYMBOL_BELL),
		SYMBOL_ANCHOR(7, "anchor", ItemsVM.SYMBOL_ANCHOR),
		SYMBOL_BARREL(8, "barrel", ItemsVM.SYMBOL_BARREL),
		SYMBOL_GEARS(9, "gears", ItemsVM.SYMBOL_GEARS);
		
		private final int metadata;
		private final String registryName;
        private final Item item;
        
        private VisualDisplaySymbol(int metadataIn, String registryNameIn, Item itemIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.item = itemIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(this.item, 1).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public Item getItem()
        {
            return this.item;
        }
        
        public ItemStack getItemStack()
        {
            return new ItemStack(this.item);
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualDisplaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	/** Visual Texture Holiday enum. Dictates registry name. */
	public static enum VisualTextureHoliday
    {
		// STRING(meta, localized name, item):
		// Christmas:
		NEWYEARS_0(0, "newyears_0"),
		NEWYEARS_1(1, "newyears_1"),
		NEWYEARS_2(2, "newyears_2"),
		NEWYEARS_3(3, "newyears_3"),
		NEWYEARS_4(4, "newyears_4"),
		NEWYEARS_5(5, "newyears_5"),
		NEWYEARS_6(6, "newyears_6"),
		NEWYEARS_7(7, "newyears_7"),
		NEWYEARS_8(8, "newyears_8"),
		NEWYEARS_9(9, "newyears_9"),
		
		// Christmas:
		VALENTINESDAY_0(10, "valentinesday_0"),
		VALENTINESDAY_1(11, "valentinesday_1"),
		VALENTINESDAY_2(12, "valentinesday_2"),
		VALENTINESDAY_3(13, "valentinesday_3"),
		VALENTINESDAY_4(14, "valentinesday_4"),
		VALENTINESDAY_5(15, "valentinesday_5"),
		VALENTINESDAY_6(16, "valentinesday_6"),
		VALENTINESDAY_7(17, "valentinesday_7"),
		VALENTINESDAY_8(18, "valentinesday_8"),
		VALENTINESDAY_9(19, "valentinesday_9"),
		
		// Christmas:
		EASTER_0(20, "easter_0"),
		EASTER_1(21, "easter_1"),
		EASTER_2(22, "easter_2"),
		EASTER_3(23, "easter_3"),
		EASTER_4(24, "easter_4"),
		EASTER_5(25, "easter_5"),
		EASTER_6(26, "easter_6"),
		EASTER_7(27, "easter_7"),
		EASTER_8(28, "easter_8"),
		EASTER_9(29, "easter_9"),
		
		// Fourth of July:
		FOURTHOFJULY_0(30, "4thofjuly_0"),
		FOURTHOFJULY_1(31, "4thofjuly_1"),
		FOURTHOFJULY_2(32, "4thofjuly_2"),
		FOURTHOFJULY_3(33, "4thofjuly_3"),
		FOURTHOFJULY_4(34, "4thofjuly_4"),
		FOURTHOFJULY_5(35, "4thofjuly_5"),
		FOURTHOFJULY_6(36, "4thofjuly_6"),
		FOURTHOFJULY_7(37, "4thofjuly_7"),
		FOURTHOFJULY_8(38, "4thofjuly_8"),
		FOURTHOFJULY_9(39, "4thofjuly_9"),
		
		// Halloween:
		HALLOWEEN_0(40, "halloween_0"),
		HALLOWEEN_1(41, "halloween_1"),
		HALLOWEEN_2(42, "halloween_2"),
		HALLOWEEN_3(43, "halloween_3"),
		HALLOWEEN_4(44, "halloween_4"),
		HALLOWEEN_5(45, "halloween_5"),
		HALLOWEEN_6(46, "halloween_6"),
		HALLOWEEN_7(47, "halloween_7"),
		HALLOWEEN_8(48, "halloween_8"),
		HALLOWEEN_9(49, "halloween_9"),
		
		// Thanksgiving:
		THANKSGIVING_0(50, "thanksgiving_0"),
		THANKSGIVING_1(51, "thanksgiving_1"),
		THANKSGIVING_2(52, "thanksgiving_2"),
		THANKSGIVING_3(53, "thanksgiving_3"),
		THANKSGIVING_4(54, "thanksgiving_4"),
		THANKSGIVING_5(55, "thanksgiving_5"),
		THANKSGIVING_6(56, "thanksgiving_6"),
		THANKSGIVING_7(57, "thanksgiving_7"),
		THANKSGIVING_8(58, "thanksgiving_8"),
		THANKSGIVING_9(59, "thanksgiving_9"),
		
		// Christmas:
		CHRISTMAS_CANDYCANES_WHITE(60, "christmas_candycanes_white"),
		CHRISTMAS_CANDYCANES_BLACK(61, "christmas_candycanes_black"),
		CHRISTMAS_LIGHTS_WHITE(62, "christmas_lights_white"),
		CHRISTMAS_LIGHTS_BLACK(63, "christmas_lights_black"),
		CHRISTMAS_PRESENTS_WHITE(64, "christmas_presents_white"),
		CHRISTMAS_PRESENTS_BLACK(65, "christmas_presents_black"),
		CHRISTMAS_SNOWFLAKES_BLACK(66, "christmas_snowflakes_white"),
		CHRISTMAS_SNOWFLAKES_WHITE(67, "christmas_snowflakes_black"),
		CHRISTMAS_8(68, "christmas_8_white"),
		CHRISTMAS_9(69, "christmas_9_black");
		
		private final int metadata;
		private final String registryName;
        
        private VisualTextureHoliday(int metadataIn, String registryNameIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal("viesmachines.holiday." + this.registryName);
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualTextureHoliday byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
	/** Visual Display Symbol Holiday enum. Dictates registry name. */
	public static enum VisualDisplaySymbolHoliday
    {
		// STRING(meta, localized name, item):
		// New Years:
		SYMBOL_NEWYEARS_0(0, "newyears_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_NEWYEARS_1(1, "newyears_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_NEWYEARS_2(2, "newyears_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_NEWYEARS_3(3, "newyears_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_NEWYEARS_4(4, "newyears_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_NEWYEARS_5(5, "newyears_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_NEWYEARS_6(6, "newyears_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_NEWYEARS_7(7, "newyears_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_NEWYEARS_8(8, "newyears_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_NEWYEARS_9(9, "newyears_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// Valentine's Day:
		SYMBOL_VALENTINESDAY_0(10, "valentinesday_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_VALENTINESDAY_1(11, "valentinesday_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_VALENTINESDAY_2(12, "valentinesday_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_VALENTINESDAY_3(13, "valentinesday_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_VALENTINESDAY_4(14, "valentinesday_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_VALENTINESDAY_5(15, "valentinesday_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_VALENTINESDAY_6(16, "valentinesday_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_VALENTINESDAY_7(17, "valentinesday_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_VALENTINESDAY_8(18, "valentinesday_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_VALENTINESDAY_9(19, "valentinesday_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// Easter:
		SYMBOL_EASTER_0(20, "easter_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_EASTER_1(21, "easter_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_EASTER_2(22, "easter_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_EASTER_3(23, "easter_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_EASTER_4(24, "easter_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_EASTER_5(25, "easter_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_EASTER_6(26, "easter_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_EASTER_7(27, "easter_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_EASTER_8(28, "easter_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_EASTER_9(29, "easter_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// 4th of July:
		SYMBOL_4THOFJULY_0(30, "4thofjuly_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_4THOFJULY_1(31, "4thofjuly_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_4THOFJULY_2(32, "4thofjuly_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_4THOFJULY_3(33, "4thofjuly_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_4THOFJULY_4(34, "4thofjuly_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_4THOFJULY_5(35, "4thofjuly_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_4THOFJULY_6(36, "4thofjuly_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_4THOFJULY_7(37, "4thofjuly_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_4THOFJULY_8(38, "4thofjuly_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_4THOFJULY_9(39, "4thofjuly_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// Halloween:
		SYMBOL_HALLOWEEN_0(40, "halloween_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_HALLOWEEN_1(41, "halloween_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_HALLOWEEN_2(42, "halloween_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_HALLOWEEN_3(43, "halloween_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_HALLOWEEN_4(44, "halloween_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_HALLOWEEN_5(45, "halloween_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_HALLOWEEN_6(46, "halloween_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_HALLOWEEN_7(47, "halloween_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_HALLOWEEN_8(48, "halloween_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_HALLOWEEN_9(49, "halloween_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// Thanksgiving:
		SYMBOL_THANKSGIVING_0(50, "thanksgiving_0", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_THANKSGIVING_1(51, "thanksgiving_1", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_THANKSGIVING_2(52, "thanksgiving_2", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_THANKSGIVING_3(53, "thanksgiving_3", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_THANKSGIVING_4(54, "thanksgiving_4", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_THANKSGIVING_5(55, "thanksgiving_5", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_THANKSGIVING_6(56, "thanksgiving_6", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_THANKSGIVING_7(57, "thanksgiving_7", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_THANKSGIVING_8(58, "thanksgiving_8", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_THANKSGIVING_9(59, "thanksgiving_9", ItemsVM.SYMBOL_CHRISTMAS_POKEMON),
		
		// Christmas:
		SYMBOL_CHRISTMAS_TREE(60, "christmas_tree", ItemsVM.SYMBOL_CHRISTMAS_TREE),
		SYMBOL_CHRISTMAS_WREATH(61, "christmas_wreath", ItemsVM.SYMBOL_CHRISTMAS_WREATH),
		SYMBOL_CHRISTMAS_ORNAMENT(62, "christmas_ornament", ItemsVM.SYMBOL_CHRISTMAS_ORNAMENT),
		SYMBOL_CHRISTMAS_STOCKING(63, "christmas_stocking", ItemsVM.SYMBOL_CHRISTMAS_STOCKING),
		SYMBOL_CHRISTMAS_NIGHTSKY(64, "christmas_nightsky", ItemsVM.SYMBOL_CHRISTMAS_NIGHTSKY),
		SYMBOL_CHRISTMAS_GRINCH(65, "christmas_grinch", ItemsVM.SYMBOL_CHRISTMAS_GRINCH),
		SYMBOL_CHRISTMAS_MAX(66, "christmas_max", ItemsVM.SYMBOL_CHRISTMAS_MAX),
		SYMBOL_CHRISTMAS_FROSTY(67, "christmas_frosty", ItemsVM.SYMBOL_CHRISTMAS_FROSTY),
		SYMBOL_CHRISTMAS_PEANUTS(68, "christmas_peanuts", ItemsVM.SYMBOL_CHRISTMAS_PEANUTS),
		SYMBOL_CHRISTMAS_POKEMON(69, "christmas_pokemon", ItemsVM.SYMBOL_CHRISTMAS_POKEMON);
		
		private final int metadata;
		private final String registryName;
        private final Item item;
        
        private VisualDisplaySymbolHoliday(int metadataIn, String registryNameIn, Item itemIn)
        {
        	this.metadata = metadataIn;
        	this.registryName = registryNameIn;
            this.item = itemIn;
        }
        
        public int getMetadata()
        {
        	return this.metadata;
        }
        
        public String getLocalizedName()
        {
        	return References.Old_I18n.translateToLocal(new ItemStack(this.item, 1).getUnlocalizedName() + ".name");
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public Item getItem()
        {
            return this.item;
        }
        
        public ItemStack getItemStack()
        {
            return new ItemStack(this.item);
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.VisualDisplaySymbolHoliday byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
	
    /** Entity Head Display Symbol enum. Represents various Entity Head types. */
    public static enum EntityHead
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.0")),
        
        STEVE(1, "1", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.1")),
        ALEX(2, "2", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.2")),
        CHICKEN(3, "3", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.3")),
        PIG(4, "4", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.4")),
    	COW(5, "5", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.5")),
    	ZOMBIE(6, "6", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.6")),
    	SKELETON(7, "7", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.7")),
    	SPIDER(8, "8", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.8")),
    	CREEPER(9, "9", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.9")),
    	WITHERSKELETON(10, "10", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.10")),
    	DRAGON(11, "11", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.11")),
    	HEROBRINE(12, "12", References.Old_I18n.translateToLocalFormatted("viesmachines.enum.entityhead.12"));
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private EntityHead(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.EntityHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
    
    /** Patreon Head Display Symbol enum. Represents various Patreon Head types. */
    public static enum PatreonHead
    {
    	// STRING(meta, registry name, localized name):
        NONE(0, "none", "None"),
        VIES(1, "patreonhead_vies", "Vies"),
        SOULFORGE7(2, "patreonhead_soulforge7", "SoulForge7"),
        NEMANOR(3, "patreonhead_nemanor", "Nemanor"),
        VELOURVAULTSUIT(4, "patreonhead_velourvaultsuit", "VelourVaultSuit");
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private PatreonHead(int metadataIn, String registryNameIn, String localizedNameIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.PatreonHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
    
    
	
	//==================================================
    // TODO            Variant Names
	//==================================================
	
	/** Flying Machine Airship Variant Name enum. Dictates localized name. */
	public static enum FlyingMachineAirshipVariantName
    {
    	// STRING(meta, unlocalized name):
		STANDARD(0, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.0")),
		HINDENBURG(1, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.1")),
		DIRIGIBLE(2, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.2")),
		ZEPPELIN(3, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.3")),
		AKRONUS(4, References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.flyingvariant.4"));
		
		private final int metadata;
        private final String unlocalizedName;
        
        private FlyingMachineAirshipVariantName(int metadataIn, String unlocalizedNameIn)
        {
        	this.metadata = metadataIn;
            this.unlocalizedName = unlocalizedNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getUnlocalizedName()
        {
            return this.unlocalizedName;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.FlyingMachineAirshipVariantName byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
    
    
	
	//==================================================
    // TODO                 Misc
	//==================================================
	
	/** Select Color enum - Dictates registry name and localized name. */
	public static enum SelectColor
    {
    	// STRING(meta, registry name, localized name, TextFormatting color):
		BLACK(0, "BLACK", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.BLACK),
	    DARK_BLUE(1, "DARK_BLUE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_BLUE),
	    DARK_GREEN(2, "DARK_GREEN", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_GREEN),
	    DARK_AQUA(3, "DARK_AQUA", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_AQUA),
	    DARK_RED(4, "DARK_RED", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_RED),
	    DARK_PURPLE(5, "DARK_PURPLE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_PURPLE),
	    GOLD(6, "GOLD", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GOLD),
	    GRAY(7, "GRAY", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GRAY),
	    DARK_GRAY(8, "DARK_GRAY", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.DARK_GRAY),
	    BLUE(9, "BLUE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.BLUE),
	    GREEN(10, "GREEN", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.GREEN),
	    AQUA(11, "AQUA", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.AQUA),
	    RED(12, "RED", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.RED),
	    LIGHT_PURPLE(13, "LIGHT_PURPLE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.LIGHT_PURPLE),
	    YELLOW(14, "YELLOW", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.YELLOW),
	    WHITE(15, "WHITE", References.Old_I18n.translateToLocalFormatted("vc.enum.tier.0"), TextFormatting.WHITE);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final TextFormatting textColor;
        
        private SelectColor(int metadataIn, String registryNameIn, String localizedNameIn, TextFormatting textColorIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.textColor = textColorIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public TextFormatting getTextColor()
        {
            return this.textColor;
        }
        
        /** Get type by it's enum ordinal. */
        public static EnumsVM.SelectColor byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
    }
    
	
	
}

package com.viesis.viescraft.api;

import com.viesis.viescraft.client.InitSoundEventsVC;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundEvent;

public class EnumsVC {
	
	/**
     * Main Core Tier enum - Dictates registry name, localized name, HP modifier. 
     * <pre>
     * (Main metadata!)
     * </pre>
     */
	public static enum MainTierCore
    {
    	//STRING(meta, registry name, localized name, Stored Redstone)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 50),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 100),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 200),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 300),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 400),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 500);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final int storedRedstone;
        
        private MainTierCore(int metadataIn, String registryNameIn, String localizedNameIn, int storedRedstoneIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.storedRedstone = storedRedstoneIn;
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
        
        public int getStoredRedstone()
        {
            return this.storedRedstone;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainTierCore byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainTierCore getTypeFromString(String nameIn)
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
	
	/**
     * Main Frame Tier enum - Dictates registry name, localized name, speed modifier.
     */
	public static enum MainTierFrame
    {
    	//STRING(meta, registry name, localized name, speed modifier)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 0.0F),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 0.01F),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 0.02F),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 0.03F),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 0.04F),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 0.05F);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float speed;
        
        private MainTierFrame(int metadataIn, String registryNameIn, String localizedNameIn, float speedModifierIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.speed = speedModifierIn;
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
        
        public float getSpeedModifier()
        {
            return this.speed;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainTierFrame byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainTierFrame getTypeFromString(String nameIn)
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
	
	/**
     * Main Engine Tier enum - Dictates registry name, localized name, fuel per tick.
     */
	public static enum MainTierEngine
    {
    	//STRING(meta, registry name, localized name, fuel per tick)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 60),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 50),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 40),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 30),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 20),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 10);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final int fuel;
        
        private MainTierEngine(int metadataIn, String registryNameIn, String localizedNameIn, int fuelPerTickIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.fuel = fuelPerTickIn;
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
        
        public int getFuelPerTick()
        {
            return this.fuel;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainTierEngine byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainTierEngine getTypeFromString(String nameIn)
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
	
	/**
     * Main Balloon Tier enum - Dictates registry name, localized name, max altitude.
     */
	public static enum MainTierBalloon
    {
    	//STRING(meta, registry name, localized name, max altitude)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 75),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 100),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 125),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 150),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 175),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 200);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final int altitude;
        
        private MainTierBalloon(int metadataIn, String registryNameIn, String localizedNameIn, int maxAltutideIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.altitude = maxAltutideIn;
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
        
        public int getMaxAltitude()
        {
            return this.altitude;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainTierBalloon byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainTierBalloon getTypeFromString(String nameIn)
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
	
    /**
	 * Module Type enum - Represents various Module types.
	 */
    public static enum ModuleType
    {
    	//STRING(meta, registry name, localized name)
        BASE(0, "base", References.localNameVC("vc.item.enum.module.0")),
        ALTITUDE_LESSER(1, "altitude_lesser", References.localNameVC("vc.item.enum.module.1")),
        ALTITUDE_NORMAL(2, "altitude_normal", References.localNameVC("vc.item.enum.module.2")),
        ALTITUDE_GREATER(3, "altitude_greater", References.localNameVC("vc.item.enum.module.3")),
        SPEED_LESSER(4, "speed_lesser", References.localNameVC("vc.item.enum.module.4")),
        SPEED_NORMAL(5, "speed_normal", References.localNameVC("vc.item.enum.module.5")),
        SPEED_GREATER(6, "speed_greater", References.localNameVC("vc.item.enum.module.6")),
        STORAGE_LESSER(7, "storage_lesser", References.localNameVC("vc.item.enum.module.7")),
        STORAGE_NORMAL(8, "storage_normal", References.localNameVC("vc.item.enum.module.8")),
        STORAGE_GREATER(9, "storage_greater", References.localNameVC("vc.item.enum.module.9")),
        FUEL_LESSER(10, "fuel_lesser", References.localNameVC("vc.item.enum.module.10")),
        FUEL_NORMAL(11, "fuel_normal", References.localNameVC("vc.item.enum.module.11")),
    	FUEL_GREATER(12, "fuel_greater", References.localNameVC("vc.item.enum.module.12")),
    	MUSIC_LESSER(13, "music_lesser", References.localNameVC("vc.item.enum.module.13")),
    	MUSIC_NORMAL(14, "music_normal", References.localNameVC("vc.item.enum.module.14")),
    	MUSIC_GREATER(15, "music_greater", References.localNameVC("vc.item.enum.module.15")),
    	CRUISE_LESSER(16, "cruise_lesser", References.localNameVC("vc.item.enum.module.16")),
    	CRUISE_NORMAL(17, "cruise_normal", References.localNameVC("vc.item.enum.module.17")),
    	CRUISE_GREATER(18, "cruise_greater", References.localNameVC("vc.item.enum.module.18")),
        WATER_LESSER(19, "water_lesser", References.localNameVC("vc.item.enum.module.19")),
        WATER_NORMAL(20, "water_normal", References.localNameVC("vc.item.enum.module.20")),
        WATER_GREATER(21, "water_greater", References.localNameVC("vc.item.enum.module.21")),
        INFINITE_FUEL_LESSER(22, "infinite_fuel_lesser", References.localNameVC("vc.item.enum.module.22")),
    	INFINITE_FUEL_NORMAL(23, "infinite_fuel_normal", References.localNameVC("vc.item.enum.module.23")),
    	INFINITE_FUEL_GREATER(24, "infinite_fuel_greater", References.localNameVC("vc.item.enum.module.24")),
    	BOMB_LESSER(25, "bomb_lesser", References.localNameVC("vc.item.enum.module.25")),
    	BOMB_NORMAL(26, "bomb_normal", References.localNameVC("vc.item.enum.module.26")),
    	BOMB_GREATER(27, "bomb_greater", References.localNameVC("vc.item.enum.module.27"));
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private ModuleType(int metadataIn, String registryNameIn, String localizedNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.ModuleType byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.ModuleType getTypeFromString(String nameIn)
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
    
    /**
	 * Song enum - Represents various song types.
	 */
    public static enum AirshipSong
    {
    	//STRING(meta, localized name, soundevent)
    	NONE(0, References.localNameVC("vc.item.enum.song.0"), SoundEvents.UI_BUTTON_CLICK),
    	RECORD11(1, References.localNameVC("vc.item.enum.song.1"), SoundEvents.RECORD_11),
        RECORD13(2, References.localNameVC("vc.item.enum.song.2"), SoundEvents.RECORD_13),
        RECORDBLOCKS(3, References.localNameVC("vc.item.enum.song.3"), SoundEvents.RECORD_BLOCKS),
        RECORDMELLOHI(4, References.localNameVC("vc.item.enum.song.4"), SoundEvents.RECORD_MELLOHI),
        RECORDCAT(5, References.localNameVC("vc.item.enum.song.5"), SoundEvents.RECORD_CAT),
        RECORDSTAL(6, References.localNameVC("vc.item.enum.song.6"), SoundEvents.RECORD_STAL),
        RECORDSTRAD(7, References.localNameVC("vc.item.enum.song.7"), SoundEvents.RECORD_STRAD),
        RECORDCHIRP(8, References.localNameVC("vc.item.enum.song.8"), SoundEvents.RECORD_CHIRP),
        RECORDFAR(9, References.localNameVC("vc.item.enum.song.9"), SoundEvents.RECORD_FAR),
        RECORDMALL(10, References.localNameVC("vc.item.enum.song.10"), SoundEvents.RECORD_MALL),
        RECORDWAIT(11, References.localNameVC("vc.item.enum.song.11"), SoundEvents.RECORD_WAIT),
        RECORDWARD(12, References.localNameVC("vc.item.enum.song.12"), SoundEvents.RECORD_WARD),
        RECORDBRAMBLE(13, References.localNameVC("vc.item.enum.song.13"), InitSoundEventsVC.BRAMBLE),
        RECORDCASTLE(14, References.localNameVC("vc.item.enum.song.14"), InitSoundEventsVC.CASTLE),
        RECORDJUNGLE(15, References.localNameVC("vc.item.enum.song.15"), InitSoundEventsVC.JUNGLE),
        RECORDDIRE(16, References.localNameVC("vc.item.enum.song.16"), InitSoundEventsVC.DIRE),
        RECORDSTORMS(17, References.localNameVC("vc.item.enum.song.17"), InitSoundEventsVC.STORMS),
        RECORDTIMESCAR(18, References.localNameVC("vc.item.enum.song.18"), InitSoundEventsVC.TIMESCAR);
    	
    	private final int metadata;
        private final String registryName;
        private final SoundEvent song;
        
        private AirshipSong(int metadataIn, String registryNameIn, SoundEvent soundIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.song = soundIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getRegistryName()
        {
            return this.registryName;
        }
        
        public SoundEvent getSong()
        {
            return this.song;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.AirshipSong byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipSong getTypeFromString(String nameIn)
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
	
	
    
    /**
	 * Visual Frame Skin Background enum - Represents various visual frame skin types.
	 */
    public static enum VisualFrameSkinBackground
    {
    	//STRING(meta, registry name, localized name)
    	DEFAULT(0, "default", References.localNameVC("vc.enum.visualframe.0")),
    	
    	//Common
    	//Tier 1 - 18
    	DIRT(1, "dirt", References.localNameVC("vc.enum.visualframe.1")),
    	SAND(2, "sand", References.localNameVC("vc.enum.visualframe.2")),
    	REDSAND(3, "redsand", References.localNameVC("vc.enum.visualframe.3")),
        GRAVEL(4, "gravel", References.localNameVC("vc.enum.visualframe.4")),
        CLAY(5, "clay", References.localNameVC("vc.enum.visualframe.5")),
        HAYBALE(6, "haybale", References.localNameVC("vc.enum.visualframe.6")),
        
        PLANKOAK(7, "plank_oak", References.localNameVC("vc.enum.visualframe.7")),
        PLANKSPRUCE(8, "plank_spruce", References.localNameVC("vc.enum.visualframe.8")),
        PLANKBIRCH(9, "plank_birch", References.localNameVC("vc.enum.visualframe.9")),
        PLANKJUNGLE(10, "plank_jungle", References.localNameVC("vc.enum.visualframe.10")),
        PLANKACACIA(11, "plank_acacia", References.localNameVC("vc.enum.visualframe.11")),
        PLANKDARKOAK(12, "plank_dark_oak", References.localNameVC("vc.enum.visualframe.12")),
        
    	LOGOAK(13, "log_oak", References.localNameVC("vc.enum.visualframe.13")),
    	LOGSPRUCE(14, "log_spruce", References.localNameVC("vc.enum.visualframe.14")),
    	LOGBIRCH(15, "log_birch", References.localNameVC("vc.enum.visualframe.15")),
    	LOGJUNGLE(16, "log_jungle", References.localNameVC("vc.enum.visualframe.16")),
    	LOGACACIA(17, "log_acacia", References.localNameVC("vc.enum.visualframe.17")),
    	LOGDARKOAK(18, "log_dark_oak", References.localNameVC("vc.enum.visualframe.18")),
        
        //Uncommon
        //Tier 2 - 12
        GRANITE(19, "granite", References.localNameVC("vc.enum.visualframe.19")),
        DIORITE(20, "diorite", References.localNameVC("vc.enum.visualframe.20")),
        ANDESITE(21, "andesite", References.localNameVC("vc.enum.visualframe.21")),
        SANDSTONE(22, "sandstone", References.localNameVC("vc.enum.visualframe.22")),
        COBBLESTONE(23, "cobblestone", References.localNameVC("vc.enum.visualframe.23")),
        STONE(24, "stone", References.localNameVC("vc.enum.visualframe.24")),
        
        SNOW(25, "snow", References.localNameVC("vc.enum.visualframe.25")),
        ICEPACKED(26, "packed_ice", References.localNameVC("vc.enum.visualframe.26")),
        BONE(27, "bone", References.localNameVC("vc.enum.visualframe.27")),
    	PODZOL(28, "podzol", References.localNameVC("vc.enum.visualframe.28")),
        MYCELIUM(29, "mycelium", References.localNameVC("vc.enum.visualframe.29")),
        GLASS(30, "glass", References.localNameVC("vc.enum.visualframe.30")),
        
        //Rare
        //Tier 3 - 12
        STONEBRICKS(31, "stone_brick", References.localNameVC("vc.enum.visualframe.31")),
        STONEBRICKSMOSSY(32, "stone_brick_mossy", References.localNameVC("vc.enum.visualframe.32")),
        STONEBRICKSCRACK(33, "stone_brick_cracked", References.localNameVC("vc.enum.visualframe.33")),
        STONEBRICKSCHISELED(34, "stone_brick_chiseled", References.localNameVC("vc.enum.visualframe.34")),
        COBBLESTONEMOSSY(35, "cobblestone_mossy", References.localNameVC("vc.enum.visualframe.35")),
        BRICK(36, "brick", References.localNameVC("vc.enum.visualframe.36")),
        
        ORECOAL(37, "ore_coal", References.localNameVC("vc.enum.visualframe.37")),
        OREIRON(38, "ore_iron", References.localNameVC("vc.enum.visualframe.38")),
        OREGOLD(39, "ore_gold", References.localNameVC("vc.enum.visualframe.39")),
        OREREDSTONE(40, "ore_redstone", References.localNameVC("vc.enum.visualframe.40")),
        ORELAPISLAZULI(41, "ore_lapislazuli", References.localNameVC("vc.enum.visualframe.41")),
        OREDIAMOND(42, "ore_diamond", References.localNameVC("vc.enum.visualframe.42")),
        
        //Epic
        //Tier 4 - 12
        COAL(43, "coal", References.localNameVC("vc.enum.visualframe.43")),
        IRON(44, "iron", References.localNameVC("vc.enum.visualframe.44")),
        REDSTONE(45, "redstone", References.localNameVC("vc.enum.visualframe.45")),
        GOLD(46, "gold", References.localNameVC("vc.enum.visualframe.46")),
        LAPISLAZULI(47, "lapislazuli", References.localNameVC("vc.enum.visualframe.47")),
        ICE(48, "ice", References.localNameVC("vc.enum.visualframe.48")),
        
        SLIME(49, "slime", References.localNameVC("vc.enum.visualframe.49")),
        NETHERBRICK(50, "nether_brick", References.localNameVC("vc.enum.visualframe.50")),
        SOULSAND(51, "soulsand", References.localNameVC("vc.enum.visualframe.51")),
        QUARTZ(52, "quartz", References.localNameVC("vc.enum.visualframe.52")),
        GLOWSTONE(53, "glowstone", References.localNameVC("vc.enum.visualframe.53")),
        OBSIDIAN(54, "obsidian", References.localNameVC("vc.enum.visualframe.54")),
        
        //Legendary
    	//Tier 5 - 10
        DIAMOND(55, "diamond", References.localNameVC("vc.enum.visualframe.55")),
        EMERALD(56, "emerald", References.localNameVC("vc.enum.visualframe.56")),
        PRISMARINE(57, "prismarine", References.localNameVC("vc.enum.visualframe.57")),
        ENDSTONE(58, "endstone", References.localNameVC("vc.enum.visualframe.58")),
        PURPUR(59, "purpur", References.localNameVC("vc.enum.visualframe.59")),
    	NETHERSTAR(60, "netherstar", References.localNameVC("vc.enum.visualframe.60")),
    	
    	MYTHIC(61, "mythic", References.localNameVC("vc.enum.visualframe.61")),
    	WATER(62, "water", References.localNameVC("vc.enum.visualframe.62")), 
    	LAVA(63, "lava", References.localNameVC("vc.enum.visualframe.63")), 
    	ENDER(64, "ender", References.localNameVC("vc.enum.visualframe.64")), 
    	ENDER1(65, "ender1", References.localNameVC("vc.enum.visualframe.65")), 
    	ENDER2(66, "ender2", References.localNameVC("vc.enum.visualframe.66"))//,
    	
    	//Holiday
    	//New Years
    	//MYTHIC(61, "mythic", References.localNameVC("vc.enum.visualframe.61")),
    	//WATER(62, "water", References.localNameVC("vc.enum.visualframe.62")), 
    	//LAVA(63, "lava", References.localNameVC("vc.enum.visualframe.63")), 
    	//ENDER(64, "ender", References.localNameVC("vc.enum.visualframe.64")), 
    	//ENDER1(65, "ender1", References.localNameVC("vc.enum.visualframe.65")), 
    	//ENDER2(66, "ender2", References.localNameVC("vc.enum.visualframe.66"))
    	;
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private VisualFrameSkinBackground(int metadataIn, String registryNameIn, String localizedNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.VisualFrameSkinBackground byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.VisualFrameSkinBackground getTypeFromString(String nameIn)
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
    
    
    
    
    
    
    
    
    /**
	 * Visual Balloon Pattern enum - Represents various visual balloon pattern types.
	 */
    public static enum VisualBalloonPattern
    {
    	//STRING(meta, registry name, localed name)
    	DEFAULT(0, "default", References.localNameVC("vc.enum.visualballoon.0")),
    	
    	//Common
    	//Tier 1 - 18
    	SPECKLED(1, "speckled", References.localNameVC("vc.enum.visualballoon.1")),
    	SPECKLEDCOLORED(2, "speckled_colored", References.localNameVC("vc.enum.visualballoon.2")),
    	SPECKLEDCOLOREDINVERTED(3, "speckled_colored_inverted", References.localNameVC("vc.enum.visualballoon.3")),
    	CHECKER(4, "checker", References.localNameVC("vc.enum.visualballoon.4")),
    	CHECKERCOLORED(5, "checker_colored", References.localNameVC("vc.enum.visualballoon.5")),
    	CHECKERCOLOREDINVERTED(6, "checker_colored_inverted", References.localNameVC("vc.enum.visualballoon.6")),
        
        A1(7, "", References.localNameVC("vc.enum.visualballoon.7")),
        A1COLORED(8, "_colored", References.localNameVC("vc.enum.visualballoon.8")),
        A1COLOREDINVERTED(9, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.9")),
        A2(10, " ", References.localNameVC("vc.enum.visualballoon.10")),
        A2COLORED(11, "_colored", References.localNameVC("vc.enum.visualballoon.11")),
        A2COLOREDINVERTED(12, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.12")),
        
    	A3(13, "", References.localNameVC("vc.enum.visualballoon.13")),
    	A3COLORED(14, "_colored", References.localNameVC("vc.enum.visualballoon.14")),
    	A3COLOREDINVERTED(15, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.15")),
    	A4(16, "", References.localNameVC("vc.enum.visualballoon.16")),
    	A4COLORED(17, "_colored", References.localNameVC("vc.enum.visualballoon.17")),
    	A4COLOREDINVERTED(18, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.18")),
        
        //Uncommon
        //Tier 2 - 12
    	POLKADOT(19, "polkadot", References.localNameVC("vc.enum.visualballoon.19")),
    	POLKADOTCOLORED(20, "polkadot_colored", References.localNameVC("vc.enum.visualballoon.20")),
    	POLKADOTCOLOREDINVERTED(21, "polkadot_colored_inverted", References.localNameVC("vc.enum.visualballoon.21")),
        BASKETWEAVE(22, "basketweave", References.localNameVC("vc.enum.visualballoon.22")),
        BASKETWEAVECOLORED(23, "basketweave_colored", References.localNameVC("vc.enum.visualballoon.23")),
        BASKETWEAVECOLOREDINVERTED(24, "basketweave_colored_inverted", References.localNameVC("vc.enum.visualballoon.24")),
        
        A6(25, "", References.localNameVC("vc.enum.visualballoon.25")),
        A6COLORED(26, "_colored", References.localNameVC("vc.enum.visualballoon.26")),
        A6COLOREDINVERTED(27, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.27")),
    	A7(28, "", References.localNameVC("vc.enum.visualballoon.28")),
        A7COLORED(29, "_colored", References.localNameVC("vc.enum.visualballoon.29")),
        A7COLOREDINVERTED(30, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.30")),
        
        //Rare
        //Tier 3 - 12
        ZIGZAG(31, "zigzag", References.localNameVC("vc.enum.visualballoon.31")),
        ZIGZAGCOLORED(32, "zigzag_colored", References.localNameVC("vc.enum.visualballoon.32")),
        ZIGZAGCOLOREDINVERTED(33, "zigzag_colored_inverted", References.localNameVC("vc.enum.visualballoon.33")),
        TOOLS(34, "tools", References.localNameVC("vc.enum.visualballoon.34")),
        TOOLSCOLORED(35, "tools_colored", References.localNameVC("vc.enum.visualballoon.35")),
        TOOLSCOLOREDINVERTED(36, "tools_colored_inverted", References.localNameVC("vc.enum.visualballoon.36")),
        
        A8(37, "", References.localNameVC("vc.enum.visualballoon.37")),
        A8COLORED(38, "_colored", References.localNameVC("vc.enum.visualballoon.38")),
        A8COLOREDINVERTED(39, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.39")),
        A9(40, "", References.localNameVC("vc.enum.visualballoon.40")),
        A9COLORED(41, "_colored", References.localNameVC("vc.enum.visualballoon.41")),
        A9COLOREDINVERTED(42, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.42")),
        
        //Epic
        //Tier 4 - 12
        CREEPER(43, "creeper", References.localNameVC("vc.enum.visualballoon.43")),
        CREEPERCOLORED(44, "creeper_colored", References.localNameVC("vc.enum.visualballoon.44")),
        CREEPERCOLOREDINVERTED(45, "creeper_colored_inverted", References.localNameVC("vc.enum.visualballoon.45")),
        B1(46, "", References.localNameVC("vc.enum.visualballoon.46")),
        B1COLORED(47, "_colored", References.localNameVC("vc.enum.visualballoon.47")),
        B1INVERTED(48, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.48")),
        
        B2(49, "", References.localNameVC("vc.enum.visualballoon.49")),
        B2COLORED(50, "_colored", References.localNameVC("vc.enum.visualballoon.50")),
        B2COLOREDINVERTED(51, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.51")),
        B3(52, "", References.localNameVC("vc.enum.visualballoon.52")),
        B3COLORED(53, "_colored", References.localNameVC("vc.enum.visualballoon.53")),
        B3COLOREDINVERTED(54, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.54")),
        
        //Legendary
    	//Tier 5 - 10
        WATER(55, "water", References.localNameVC("vc.enum.visualballoon.55")),
        WATERCOLORED(56, "water_colored", References.localNameVC("vc.enum.visualballoon.56")),
        WATERCOLOREDINVERTED(57, "water_colored_inverted", References.localNameVC("vc.enum.visualballoon.57")),
        LAVA(58, "lava", References.localNameVC("vc.enum.visualballoon.58")),
        LAVACOLORED(59, "lava_colored", References.localNameVC("vc.enum.visualballoon.59")),
        LAVACOLOREDINVERTED(60, "lava_colored_inverted", References.localNameVC("vc.enum.visualballoon.60")),
    	
        ENDER(61, "ender", References.localNameVC("vc.enum.visualballoon.61")),
    	ENDERCOLORED(62, "ender_colored", References.localNameVC("vc.enum.visualballoon.62")), 
    	ENDERCOLOREDINVERTED(63, "ender_colored_inverted", References.localNameVC("vc.enum.visualballoon.63")), 
    	B4(64, "", References.localNameVC("vc.enum.visualballoon.64")),
    	B4COLORED(65, "_colored", References.localNameVC("vc.enum.visualballoon.65")), 
    	B4COLOREDINVERTED(66, "_colored_inverted", References.localNameVC("vc.enum.visualballoon.66")), ; 
    	
    	
    	
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private VisualBalloonPattern(int metadataIn, String registryNameIn, String localizedNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.VisualBalloonPattern byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.VisualBalloonPattern getTypeFromString(String nameIn)
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
    
   
    
    
    
    
    
    
    
    /**
     * Bomb enum - Dictates registry name, localized name, explosion strength.
     */
	public static enum Bombs
    {
    	//STRING(meta, registry name, localized name, explosion strength)
		CASING(0, "casing", References.localNameVC("vc.enum.bomb.0"), 0.0F),
		SMALL(1, "small", References.localNameVC("vc.enum.bomb.1"), 4.0F),
		BIG(2, "big", References.localNameVC("vc.enum.bomb.2"), 8.0F),
		SCATTER(3, "scatter", References.localNameVC("vc.enum.bomb.3"), 0.3F);
		
		private final int metadata;
        private final String registryName;
        private final String localizedName;
        private final float explosionStrength;
        
        private Bombs(int metadataIn, String registryNameIn, String localizedNameIn, float explosionStrengthIn)
        {
        	this.metadata = metadataIn;
            this.registryName = registryNameIn;
            this.localizedName = localizedNameIn;
            this.explosionStrength = explosionStrengthIn;
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
        
        public float getExplosionStrength()
        {
            return this.explosionStrength;
        }
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.Bombs byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.Bombs getTypeFromString(String nameIn)
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
	
	
	
	
	
	

    
    /**
	 * Achievement enum - Represents various Achievement types.
	 */
    public static enum Achievement
    {
    	//STRING(meta, registry name)
        CREATEENGINE(0, "create_engine"),
    	CREATEIGNITION(1, "create_ignition"),
        CREATE(2, "create"),
        CREATECOLOR(3, "create_color"),
        CREATEMODULE(4, "create_module"),
        AIRBORN(5, "airborn"),
        WATER(6, "water"),
        LAVA(7, "lava");
        
    	private final int metadata;
        private final String registryName;
        
        private Achievement(int metadataIn, String registryNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.Achievement byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.Achievement getTypeFromString(String nameIn)
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
    
    
    
    /**
	 * Display Symbol enum - Represents various Airship Display Symbol types.
	 */
    public static enum MainDisplaySymbol
    {
    	//STRING(meta, registry name, localized name, explosion strength)
        NONE(0, "none", References.localNameVC("vc.enum.displaysymbol.0")),
        
        BLOCKITEM(1, "category_blockitem", References.localNameVC("vc.enum.displaysymbol.1")),
        HEAD(2, "category_head", References.localNameVC("vc.enum.displaysymbol.2")),
        HEADSUPPORTER(3, "category_supporter_head", References.localNameVC("vc.enum.displaysymbol.3")),
        HOLIDAY(4, "category_holiday", References.localNameVC("vc.enum.displaysymbol.4")),
        UNUSED0(5, "category_1", References.localNameVC("vc.enum.displaysymbol.5")),
        UNUSED1(6, "category_2", References.localNameVC("vc.enum.displaysymbol.6")),
        UNUSED2(7, "category_3", References.localNameVC("vc.enum.displaysymbol.7")),
        UNUSED3(8, "category_4", References.localNameVC("vc.enum.displaysymbol.8")),
        UNUSED4(9, "category_5", References.localNameVC("vc.enum.displaysymbol.9")),
        
        
        
    	LOGOVIESCRAFT(10, "10", References.localNameVC("vc.enum.displaysymbol.10")),
    	LOGOFORGE(11, "11", References.localNameVC("vc.enum.displaysymbol.11")),
    	LOGOMINECRAFT(12, "12", References.localNameVC("vc.enum.displaysymbol.12")),
    	COINSTACK(13, "13", References.localNameVC("vc.enum.displaysymbol.13")),
    	SCROLL(14, "14", References.localNameVC("vc.enum.displaysymbol.14")),
    	WRENCH(15, "15", References.localNameVC("vc.enum.displaysymbol.15")),
    	KEY(16, "16", References.localNameVC("vc.enum.displaysymbol.16")),
    	PADLOCK(17, "17", References.localNameVC("vc.enum.displaysymbol.17")),
        BELL(18, "18", References.localNameVC("vc.enum.displaysymbol.18")),
        ANCHOR(19, "19", References.localNameVC("vc.enum.displaysymbol.19")),
    	BARREL(20, "20", References.localNameVC("vc.enum.displaysymbol.20")),
    	GEARS(21, "21", References.localNameVC("vc.enum.displaysymbol.21"));
    	
    	
    	
    	/**
    	DOG(9, "animal_dog", References.localNameVC("vc.enum.displaysymbol.9")),
    	CAT(10, "animal_cat", References.localNameVC("vc.enum.displaysymbol.10")),
    	FOX(11, "animal_squirrel", References.localNameVC("vc.enum.displaysymbol.11")),
    	BEAR(12, "animal_bear", References.localNameVC("vc.enum.displaysymbol.12")),
    	LION(13, "animal_lion", References.localNameVC("vc.enum.displaysymbol.13")),
        WOLF(14, "animal_fox", References.localNameVC("vc.enum.displaysymbol.14")),
        SHARK(15, "animal_wolf", References.localNameVC("vc.enum.displaysymbol.15")),
    	FISH(9, "animal_dog", References.localNameVC("vc.enum.displaysymbol.9")),
    	OCTOPUS(9, "animal_dog", References.localNameVC("vc.enum.displaysymbol.9")),
    	PHOENIX(16, "animal_phoenix", References.localNameVC("vc.enum.displaysymbol.16")),
        DRAGON(17, "animal_dragon", References.localNameVC("vc.enum.displaysymbol.17"));
    	
    	
    	EARTH(18, "element_earth", References.localNameVC("vc.enum.displaysymbol.18")),
        WIND(19, "element_wind", References.localNameVC("vc.enum.displaysymbol.19")),
        WATER(20, "element_water", References.localNameVC("vc.enum.displaysymbol.20")),
        FIRE(21, "element_fire", References.localNameVC("vc.enum.displaysymbol.21")),
        NATURE(22, "element_nature", References.localNameVC("vc.enum.displaysymbol.22")),
        LIGHTNING(23, "element_lightning", References.localNameVC("vc.enum.displaysymbol.23")),
        ICE(24, "element_ice", References.localNameVC("vc.enum.displaysymbol.24")),
        POISON(25, "element_poison", References.localNameVC("vc.enum.displaysymbol.25")),
        ARCANE(26, "element_arcane", References.localNameVC("vc.enum.displaysymbol.26")),
        VOID(27, "element_void", References.localNameVC("vc.enum.displaysymbol.27")),
        HOLY(28, "element_holy", References.localNameVC("vc.enum.displaysymbol.28")),
        UNHOLY(29, "element_unholy", References.localNameVC("vc.enum.displaysymbol.29")),
        
        
        
        SHIELD(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        HAMMER(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        FIST(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        SUN(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        MOON(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        
        
        
        CELTIC(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        YGGDRASIL(7, "lava", References.localNameVC("vc.enum.displaysymbol.0")),
        MJOLLNIR(7, "lava", References.localNameVC("vc.enum.displaysymbol.0"));
        
        JACKOLANTERN(15, "animal_wolf", References.localNameVC("vc.enum.displaysymbol.15")),
    	THANKSGIVINGTURKEY(16, "animal_phoenix", References.localNameVC("vc.enum.displaysymbol.16")),
        CHRISTMASTREE(17, "animal_dragon", References.localNameVC("vc.enum.displaysymbol.17"));
    	
        */
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private MainDisplaySymbol(int metadataIn, String registryNameIn, String localizedNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainDisplaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainDisplaySymbol getTypeFromString(String nameIn)
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
    
    /**
	 * Entity Head Display Symbol enum - Represents various Airship Entity Head types.
	 */
    public static enum EntityHead
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", References.localNameVC("vc.enum.entityhead.0")),
        
        STEVE(1, "1", References.localNameVC("vc.enum.entityhead.1")),
        ALEX(2, "2", References.localNameVC("vc.enum.entityhead.2")),
        CHICKEN(3, "3", References.localNameVC("vc.enum.entityhead.3")),
        PIG(4, "4", References.localNameVC("vc.enum.entityhead.4")),
    	COW(5, "5", References.localNameVC("vc.enum.entityhead.5")),
    	ZOMBIE(6, "6", References.localNameVC("vc.enum.entityhead.6")),
    	SKELETON(7, "7", References.localNameVC("vc.enum.entityhead.7")),
    	SPIDER(8, "8", References.localNameVC("vc.enum.entityhead.8")),
    	CREEPER(9, "9", References.localNameVC("vc.enum.entityhead.9")),
    	WITHERSKELETON(10, "10", References.localNameVC("vc.enum.entityhead.10")),
    	DRAGON(11, "11", References.localNameVC("vc.enum.entityhead.11")),
    	HEROBRINE(12, "12", References.localNameVC("vc.enum.entityhead.12"));
        
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.EntityHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.EntityHead getTypeFromString(String nameIn)
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
    
    /**
	 * Patreon Head Display Symbol enum - Represents various Airship Patreon Head types.
	 */
    public static enum PatreonHead
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", "none"),
        VIES(1, "patreonhead_vies", "Vies"),
        NEMANOR(2, "patreonhead_nemanor", "Nemanor");
        
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.PatreonHead byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.PatreonHead getTypeFromString(String nameIn)
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
    
    /**
	 * Holiday Display Symbol enum - Represents various Airship Holiday Display types.
	 */
    public static enum MainHolidaySymbol
    {
    	//STRING(meta, registry name, localized name)
        NONE(0, "none", References.localNameVC("vc.enum.holidaysymbol.0")),
        
        //New Years
        YEAR2018(1, "1", References.localNameVC("vc.enum.holidaysymbol.1")),
        YEAR2019(2, "2", References.localNameVC("vc.enum.holidaysymbol.2")),
        H3(3, "3", References.localNameVC("vc.enum.holidaysymbol.3")),
        H4(4, "4", References.localNameVC("vc.enum.holidaysymbol.4")),
    	H5(5, "5", References.localNameVC("vc.enum.holidaysymbol.5")),
    	H6(6, "6", References.localNameVC("vc.enum.holidaysymbol.6")),
    	H7(7, "7", References.localNameVC("vc.enum.holidaysymbol.7")),
    	H8(8, "8", References.localNameVC("vc.enum.holidaysymbol.8")),
    	H9(9, "9", References.localNameVC("vc.enum.holidaysymbol.9")),
    	H10(10, "10", References.localNameVC("vc.enum.holidaysymbol.10")),
    	H11(11, "11", References.localNameVC("vc.enum.holidaysymbol.11")),
    	H12(12, "12", References.localNameVC("vc.enum.holidaysymbol.12")),
    	
    	//Valentine's Day
    	ROSE(13, "13", References.localNameVC("vc.enum.holidaysymbol.13")),
        TEDDYBEAR(14, "14", References.localNameVC("vc.enum.holidaysymbol.14")),
    	CUPID(15, "15", References.localNameVC("vc.enum.holidaysymbol.15")),
    	RING(16, "16", References.localNameVC("vc.enum.holidaysymbol.16")),
    	CARD(17, "17", References.localNameVC("vc.enum.holidaysymbol.17")),
    	PRESENTHEART(18, "18", References.localNameVC("vc.enum.holidaysymbol.18")),
    	HEARTMUSIC(19, "19", References.localNameVC("vc.enum.holidaysymbol.19")),
    	HEARTLOCK(20, "20", References.localNameVC("vc.enum.holidaysymbol.20")),
    	HEARTBROKEN(21, "21", References.localNameVC("vc.enum.holidaysymbol.21")),
    	HEART1(22, "22", References.localNameVC("vc.enum.holidaysymbol.22")),
    	HEART2(23, "23", References.localNameVC("vc.enum.holidaysymbol.23")),
        HEART3(24, "24", References.localNameVC("vc.enum.holidaysymbol.24")),
        
        //Easter
    	EGG1(25, "25", References.localNameVC("vc.enum.holidaysymbol.25")),
    	EGG2(26, "26", References.localNameVC("vc.enum.holidaysymbol.26")),
    	EGG3(27, "27", References.localNameVC("vc.enum.holidaysymbol.27")),
    	EGG4(28, "28", References.localNameVC("vc.enum.holidaysymbol.28")),
    	BASKETEGG(29, "29", References.localNameVC("vc.enum.holidaysymbol.29")),
    	FLOWER(30, "30", References.localNameVC("vc.enum.holidaysymbol.30")),
    	BUTTERFLY(31, "31", References.localNameVC("vc.enum.holidaysymbol.31")),
    	CHICK1(32, "32", References.localNameVC("vc.enum.holidaysymbol.32")),
    	CHICK2(33, "33", References.localNameVC("vc.enum.holidaysymbol.33")),
        BUNNY1(34, "34", References.localNameVC("vc.enum.holidaysymbol.34")),
    	BUNNY2(35, "35", References.localNameVC("vc.enum.holidaysymbol.35")),
    	BUNNY3(36, "36", References.localNameVC("vc.enum.holidaysymbol.36")),
    	
    	//4th of July
    	CRACKEDBELL(37, "37", References.localNameVC("vc.enum.holidaysymbol.37")),
    	TOPHATUSA(38, "38", References.localNameVC("vc.enum.holidaysymbol.38")),
    	MEDAL(39, "39", References.localNameVC("vc.enum.holidaysymbol.39")),
    	FLAGUSA(40, "40", References.localNameVC("vc.enum.holidaysymbol.40")),
    	REPUBLICAN(41, "41", References.localNameVC("vc.enum.holidaysymbol.41")),
    	DEMOCRAT(42, "42", References.localNameVC("vc.enum.holidaysymbol.42")),
    	ROCKET1(43, "43", References.localNameVC("vc.enum.holidaysymbol.43")),
        ROCKET2(44, "44", References.localNameVC("vc.enum.holidaysymbol.44")),
        FIREWORK1(45, "45", References.localNameVC("vc.enum.holidaysymbol.45")),
    	FIREWORK2(46, "46", References.localNameVC("vc.enum.holidaysymbol.46")),
    	FIREWORK3(47, "47", References.localNameVC("vc.enum.holidaysymbol.47")),
    	LIBERTYTORCH(48, "48", References.localNameVC("vc.enum.holidaysymbol.48")),
    	
    	//Halloween
    	JACKOLANTERN(49, "49", References.localNameVC("vc.enum.holidaysymbol.49")),
    	BLACKCAT(50, "50", References.localNameVC("vc.enum.holidaysymbol.50")),
    	BAT(51, "51", References.localNameVC("vc.enum.holidaysymbol.51")),
    	SPIDER(52, "52", References.localNameVC("vc.enum.holidaysymbol.52")),
    	CAULDRON(53, "53", References.localNameVC("vc.enum.holidaysymbol.53")),
        NIGHTSKYMOON(54, "54", References.localNameVC("vc.enum.holidaysymbol.54")),
    	TOMBSTONE(55, "55", References.localNameVC("vc.enum.holidaysymbol.55")),
    	SCYTHE(56, "56", References.localNameVC("vc.enum.holidaysymbol.56")),
    	JACK(57, "57", References.localNameVC("vc.enum.holidaysymbol.57")),
    	SALLY(58, "58", References.localNameVC("vc.enum.holidaysymbol.58")),
    	ZERO(59, "59", References.localNameVC("vc.enum.holidaysymbol.59")),
    	BOOGEYMAN(60, "60", References.localNameVC("vc.enum.holidaysymbol.60")),
    	
    	//Thanksgiving
    	PILGRIMHAT(61, "61", References.localNameVC("vc.enum.holidaysymbol.61")),
    	INDIANHAT(62, "62", References.localNameVC("vc.enum.holidaysymbol.62")),
    	BOAT(63, "63", References.localNameVC("vc.enum.holidaysymbol.63")),
    	MAPLELEAF(64, "64", References.localNameVC("vc.enum.holidaysymbol.64")),
    	MAPLELEAVES(65, "65", References.localNameVC("vc.enum.holidaysymbol.65")),
    	SUNFLOWER(66, "66", References.localNameVC("vc.enum.holidaysymbol.66")),
    	CORNSTALK(67, "67", References.localNameVC("vc.enum.holidaysymbol.67")),
    	WHEAT(68, "68", References.localNameVC("vc.enum.holidaysymbol.68")),
    	PIESLICE(69, "69", References.localNameVC("vc.enum.holidaysymbol.69")),
    	PIEWHOLE(70, "70", References.localNameVC("vc.enum.holidaysymbol.70")),
    	TURKEY(71, "71", References.localNameVC("vc.enum.holidaysymbol.71")),
    	BASKET(72, "72", References.localNameVC("vc.enum.holidaysymbol.72")),
    	
    	//Christmas
    	PRESENTSMALL(73, "73", References.localNameVC("vc.enum.holidaysymbol.73")),
        PRESENTLARGE(74, "74", References.localNameVC("vc.enum.holidaysymbol.74")),
    	CANDYCANE(75, "75", References.localNameVC("vc.enum.holidaysymbol.75")),
    	SNOWFLAKE(76, "76", References.localNameVC("vc.enum.holidaysymbol.76")),
    	ORNAMENT(77, "77", References.localNameVC("vc.enum.holidaysymbol.77")),
    	MISTLETOE(78, "78", References.localNameVC("vc.enum.holidaysymbol.78")),
    	WREATH(79, "79", References.localNameVC("vc.enum.holidaysymbol.79")),
    	STOCKING(80, "80", References.localNameVC("vc.enum.holidaysymbol.80")),
    	CHRISTMASTREE(81, "81", References.localNameVC("vc.enum.holidaysymbol.81")),
    	REINDEER(82, "82", References.localNameVC("vc.enum.holidaysymbol.82")),
    	SLEIGH(83, "83", References.localNameVC("vc.enum.holidaysymbol.83")),
        SANTA(84, "84", References.localNameVC("vc.enum.holidaysymbol.84"));
    	
    	
        
    	private final int metadata;
        private final String registryName;
        private final String localizedName;
        
        private MainHolidaySymbol(int metadataIn, String registryNameIn, String localizedNameIn)
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
        
        /**
         * Get type by it's enum ordinal
         */
        public static EnumsVC.MainHolidaySymbol byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.MainHolidaySymbol getTypeFromString(String nameIn)
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
    
}

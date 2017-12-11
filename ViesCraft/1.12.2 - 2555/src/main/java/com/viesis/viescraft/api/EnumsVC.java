package com.viesis.viescraft.api;

import java.util.Random;

import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.achievements.ItemAchievement;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.translation.I18n;

public class EnumsVC {
	
	/**
     * Frame Tier enum - Dictates registry name, localized name, HP modifier.
     */
	public static enum AirshipTierFrame
    {
    	//STRING(meta, registry name, localized name, HP modifier)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 2.0D),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 4.0D),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 6.0D),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 8.0D),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 10.0D),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 12.0D);
		
		private final int metadata;
        private final String name;
        private final String localizedName;
        private final double hp;
        
        private AirshipTierFrame(int metadataIn, String nameIn, String localizedNameIn, double hpModifierIn)
        {
        	this.metadata = metadataIn;
            this.name = nameIn;
            this.localizedName = localizedNameIn;
            this.hp = hpModifierIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public double getHPModifier()
        {
            return this.hp;
        }
        
        /**
         * Get a tier type by it's enum ordinal
         */
        public static EnumsVC.AirshipTierFrame byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipTierFrame getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/**
     * Core Tier enum - Dictates registry name, localized name, speed modifier.
     */
	public static enum AirshipTierCore
    {
    	//STRING(meta, registry name, localized name, speed modifier)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 0.0F),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 0.01F),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 0.02F),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 0.03F),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 0.04F),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 0.05F);
		
		private final int metadata;
        private final String name;
        private final String localizedName;
        private final float speed;
        
        private AirshipTierCore(int metadataIn, String nameIn, String localizedNameIn, float speedModifierIn)
        {
        	this.metadata = metadataIn;
            this.name = nameIn;
            this.localizedName = localizedNameIn;
            this.speed = speedModifierIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.name;
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
         * Get a tier type by it's enum ordinal
         */
        public static EnumsVC.AirshipTierCore byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipTierCore getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/**
     * Engine Tier enum - Dictates registry name, localized name, fuel per tick.
     */
	public static enum AirshipTierEngine
    {
    	//STRING(meta, registry name, localized name, fuel per tick)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 60),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 50),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 40),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 30),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 20),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 10);
		
		private final int metadata;
        private final String name;
        private final String localizedName;
        private final int fuel;
        
        private AirshipTierEngine(int metadataIn, String nameIn, String localizedNameIn, int fuelPerTickIn)
        {
        	this.metadata = metadataIn;
            this.name = nameIn;
            this.localizedName = localizedNameIn;
            this.fuel = fuelPerTickIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.name;
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
         * Get a tier type by it's enum ordinal
         */
        public static EnumsVC.AirshipTierEngine byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipTierEngine getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/**
     * Balloon Tier enum - Dictates registry name, localized name, max altitude.
     */
	public static enum AirshipTierBalloon
    {
    	//STRING(meta, registry name, localized name, max altitude)
		BASE(0, "tierbase", References.localNameVC("vc.enum.tier.0"), 75),
		ONE(1, "tier1", References.localNameVC("vc.enum.tier.1"), 100),
		TWO(2, "tier2", References.localNameVC("vc.enum.tier.2"), 125),
		THREE(3, "tier3", References.localNameVC("vc.enum.tier.3"), 150),
		FOUR(4, "tier4", References.localNameVC("vc.enum.tier.4"), 175),
		FIVE(5, "tier5", References.localNameVC("vc.enum.tier.5"), 200);
		
		private final int metadata;
        private final String name;
        private final String localizedName;
        private final int altitude;
        
        private AirshipTierBalloon(int metadataIn, String nameIn, String localizedNameIn, int maxAltutideIn)
        {
        	this.metadata = metadataIn;
            this.name = nameIn;
            this.localizedName = localizedNameIn;
            this.altitude = maxAltutideIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.name;
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
         * Get a tier type by it's enum ordinal
         */
        public static EnumsVC.AirshipTierBalloon byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipTierBalloon getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
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
    	INFINITE_FUEL_GREATER(24, "infinite_fuel_greater", References.localNameVC("vc.item.enum.module.24"));
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private ModuleType(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a module type by it's enum ordinal
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
                if (values()[i].getName().equals(nameIn))
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
    	
        private final String name;
        private final int metadata;
        private final SoundEvent song;
        
        private AirshipSong(int metadataIn, String nameIn, SoundEvent soundIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.song = soundIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public SoundEvent getSong()
        {
            return this.song;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        /**
         * Get a song type by it's enum ordinal
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
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	
    /**
	 * Visual Frame enum - Represents various visual frame types.
	 */
    public static enum VisualFrame
    {
    	//STRING(meta, registry name, localized name)
    	NONE(0, "none", References.localNameVC("vc.enum.visualframe.0")),
    	
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
    	ENDER2(66, "ender2", References.localNameVC("vc.enum.visualframe.66")); 
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private VisualFrame(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a visual frame type by it's enum ordinal
         */
        public static EnumsVC.VisualFrame byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.VisualFrame getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /**
	 * Visual Frame enum - Represents various visual frame types.
	 */
    public static enum VisualBalloon
    {
    	//STRING(meta, registry name, localized name)
    	NONE(0, "none", References.localNameVC("vc.enum.visualballoon.0")),
    	
    	//Common
    	//Tier 1 - 18
    	SPECKLED(1, "speckled", References.localNameVC("vc.enum.visualballoon.1")),
    	SPECKLEDCOLORIZED(2, "speckled_colorized", References.localNameVC("vc.enum.visualballoon.2")),
    	SPECKLEDCOLORIZEDINVERTED(3, "speckled_colorized_inverted", References.localNameVC("vc.enum.visualballoon.3")),
    	CHECKER(4, "checker", References.localNameVC("vc.enum.visualballoon.4")),
    	CHECKERCOLORIZED(5, "checker_colorized", References.localNameVC("vc.enum.visualballoon.5")),
    	CHECKERCOLORIZEDINVERTED(6, "checker_colorized_inverted", References.localNameVC("vc.enum.visualballoon.6")),
        
        A1(7, "", References.localNameVC("vc.enum.visualballoon.7")),
        A1COLORIZED(8, "_colorized", References.localNameVC("vc.enum.visualballoon.8")),
        A1COLORIZEDINVERTED(9, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.9")),
        A2(10, " ", References.localNameVC("vc.enum.visualballoon.10")),
        A2COLORIZED(11, "_colorized", References.localNameVC("vc.enum.visualballoon.11")),
        A2COLORIZEDINVERTED(12, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.12")),
        
    	A3(13, "", References.localNameVC("vc.enum.visualballoon.13")),
    	A3COLORIZED(14, "_colorized", References.localNameVC("vc.enum.visualballoon.14")),
    	A3COLORIZEDINVERTED(15, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.15")),
    	A4(16, "", References.localNameVC("vc.enum.visualballoon.16")),
    	A4COLORIZED(17, "_colorized", References.localNameVC("vc.enum.visualballoon.17")),
    	A4COLORIZEDINVERTED(18, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.18")),
        
        //Uncommon
        //Tier 2 - 12
    	POLKADOT(19, "polkadot", References.localNameVC("vc.enum.visualballoon.19")),
    	POLKADOTCOLORIZED(20, "polkadot_colorized", References.localNameVC("vc.enum.visualballoon.20")),
    	POLKADOTCOLORIZEDINVERTED(21, "polkadot_colorized_inverted", References.localNameVC("vc.enum.visualballoon.21")),
        A5(22, "", References.localNameVC("vc.enum.visualballoon.22")),
        A5COLORIZED(23, "_colorized", References.localNameVC("vc.enum.visualballoon.23")),
        A5COLORIZEDINVERTED(24, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.24")),
        
        A6(25, "", References.localNameVC("vc.enum.visualballoon.25")),
        A6COLORIZED(26, "_colorized", References.localNameVC("vc.enum.visualballoon.26")),
        A6COLORIZEDINVERTED(27, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.27")),
    	A7(28, "podzol", References.localNameVC("vc.enum.visualballoon.28")),
        A7COLORIZED(29, "_colorized", References.localNameVC("vc.enum.visualballoon.29")),
        A7COLORIZEDINVERTED(30, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.30")),
        
        //Rare
        //Tier 3 - 12
        ZIGZAG(31, "zigzag", References.localNameVC("vc.enum.visualballoon.31")),
        ZIGZAGCOLORIZED(32, "zigzag_colorized", References.localNameVC("vc.enum.visualballoon.32")),
        ZIGZAGCOLORIZEDINVERTED(33, "zigzag_colorized_inverted", References.localNameVC("vc.enum.visualballoon.33")),
        TOOLS(34, "tools", References.localNameVC("vc.enum.visualballoon.34")),
        TOOLSCOLORIZED(35, "tools_colorized", References.localNameVC("vc.enum.visualballoon.35")),
        TOOLSCOLORIZEDINVERTED(36, "tools_colorized_inverted", References.localNameVC("vc.enum.visualballoon.36")),
        
        A8(37, "", References.localNameVC("vc.enum.visualballoon.37")),
        A8COLORIZED(38, "_colorized", References.localNameVC("vc.enum.visualballoon.38")),
        A8COLORIZEDINVERTED(39, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.39")),
        A9(40, "", References.localNameVC("vc.enum.visualballoon.40")),
        A9COLORIZED(41, "_colorized", References.localNameVC("vc.enum.visualballoon.41")),
        A9COLORIZEDINVERTED(42, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.42")),
        
        //Epic
        //Tier 4 - 12
        CREEPER(43, "creeper", References.localNameVC("vc.enum.visualballoon.43")),
        CREEPERCOLORIZED(44, "creeper_colorized", References.localNameVC("vc.enum.visualballoon.44")),
        CREEPERCOLORIZEDINVERTED(45, "creeper_colorized_inverted", References.localNameVC("vc.enum.visualballoon.45")),
        B1(46, "", References.localNameVC("vc.enum.visualballoon.46")),
        B1COLORIZED(47, "_colorized", References.localNameVC("vc.enum.visualballoon.47")),
        B1INVERTED(48, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.48")),
        
        B2(49, "", References.localNameVC("vc.enum.visualballoon.49")),
        B2COLORIZED(50, "_colorized", References.localNameVC("vc.enum.visualballoon.50")),
        B2COLORIZEDINVERTED(51, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.51")),
        B3(52, "", References.localNameVC("vc.enum.visualballoon.52")),
        B3COLORIZED(53, "_colorized", References.localNameVC("vc.enum.visualballoon.53")),
        B3COLORIZEDINVERTED(54, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.54")),
        
        //Legendary
    	//Tier 5 - 10
        WATER(55, "water", References.localNameVC("vc.enum.visualballoon.55")),
        WATERCOLORIZED(56, "water_colorized", References.localNameVC("vc.enum.visualballoon.56")),
        WATERCOLORIZEDINVERTED(57, "water_colorized_inverted", References.localNameVC("vc.enum.visualballoon.57")),
        LAVA(58, "lava", References.localNameVC("vc.enum.visualballoon.58")),
        LAVACOLORIZED(59, "lava_colorized", References.localNameVC("vc.enum.visualballoon.59")),
        LAVACOLORIZEDINVERTED(60, "lava_colorized_inverted", References.localNameVC("vc.enum.visualballoon.60")),
    	
        ENDER(61, "ender", References.localNameVC("vc.enum.visualballoon.61")),
    	ENDERCOLORIZED(62, "ender_colorized", References.localNameVC("vc.enum.visualballoon.62")), 
    	ENDERCOLORIZEDINVERTED(63, "ender_colorized_inverted", References.localNameVC("vc.enum.visualballoon.63")), 
    	B4(64, "", References.localNameVC("vc.enum.visualballoon.64")),
    	B4COLORIZED(65, "_colorized", References.localNameVC("vc.enum.visualballoon.65")), 
    	B4COLORIZEDINVERTED(66, "_colorized_inverted", References.localNameVC("vc.enum.visualballoon.66")), ; 
    	
    	//WAVEHORIZONTAL(7, "Horizontal Wave"),
        //WAVEHORIZONTALCOLORIZED(8, "Colorized Horizontal Wave"),
        //WAVEVERTICAL(9, "Vertical Wave"),
        //WAVEVERTICALCOLORIZED(10, "Colorized Vertical Wave")
    	//BASKETWEAVE(7, "Basketweave")
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private VisualBalloon(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a visual frame type by it's enum ordinal
         */
        public static EnumsVC.VisualBalloon byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.VisualBalloon getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
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
        CREATEENGINE(0, "create_engine"),
    	CREATEIGNITION(1, "create_ignition"),
        CREATE(2, "create"),
        CREATECOLOR(3, "create_color"),
        CREATEMODULE(4, "create_module"),
        AIRBORN(5, "airborn"),
        WATER(6, "water"),
        LAVA(7, "lava");
        
        private final String name;
        private final int metadata;
        
        private Achievement(int metadataIn, String nameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        /**
         * Get a boat type by it's enum ordinal
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
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
	
	/**
	 * Balloon Prefix enum - Represents various Balloon Prefix types.
     */
	/**public static enum AirshipBalloonPrefix
    {
		//STRING(meta, registry name, localized name)
        PLAIN(0, "plain", References.localNameVC("vc.enum.balloon.prefix.0")),
        PLAINCOLORIZED(1, "colorized_plain", References.localNameVC("vc.enum.balloon.prefix.1")),
        PHANTOM(2, "phantom", References.localNameVC("vc.enum.balloon.prefix.2")),
        PHANTOMCOLORIZED(3, "colorized_phantom", References.localNameVC("vc.enum.balloon.prefix.3"));
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private AirshipBalloonPrefix(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a balloon type by it's enum ordinal
         */
        /**public static EnumsVC.AirshipBalloonPrefix byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipBalloonPrefix getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    

	/**
	 * Balloon enum - Represents various Balloon types.
     */
	/**public static enum AirshipBalloonSuffix
    {
		//STRING(meta, registry name, localized name)
        PLAIN(0, "plain", References.localNameVC("vc.enum.balloon.suffix.0")),
        CHECKER(1, "checker", References.localNameVC("vc.enum.balloon.suffix.1")),
        POLKADOT(2, "polkadot", References.localNameVC("vc.enum.balloon.suffix.2")),
        ZIGZAG(3, "zigzag", References.localNameVC("vc.enum.balloon.suffix.3")),
    	CREEPER(4, "creeper", References.localNameVC("vc.enum.balloon.suffix.4")),
    	WATER(5, "water", References.localNameVC("vc.enum.balloon.suffix.5")),
    	LAVA(6, "lava", References.localNameVC("vc.enum.balloon.suffix.6")),
    	ENDER(7, "ender", References.localNameVC("vc.enum.balloon.suffix.7")),
    	TOOLS(8, "tools", References.localNameVC("vc.enum.balloon.suffix.8"))
    	
    	//WAVEHORIZONTAL(7, "Horizontal Wave"),
        //WAVEVERTICAL(9, "Vertical Wave"),
    	//BASKETWEAVE(7, "Basketweave")
    	;
		
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private AirshipBalloonSuffix(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a balloon type by it's enum ordinal
         */
	/**public static EnumsVC.AirshipBalloonSuffix byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipBalloonSuffix getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }*/
    
    /**
	 * DELETE NEXT UPDATE.
	 */
    public static enum AirshipBalloon
    {
        PLAIN(0, "plain", References.localNameVC("vc.item.enum.balloon.0")),
        PLAINCOLORIZED(1, "colorizedplain", References.localNameVC("vc.item.enum.balloon.1")),
        PLAINPHANTOM(2, "phantomplain", References.localNameVC("vc.item.enum.balloon.2")),
        CHECKER(3, "checker", References.localNameVC("vc.item.enum.balloon.3")),
        CHECKERCOLORIZED(4, "colorizedchecker", References.localNameVC("vc.item.enum.balloon.4")),
        CHECKERPHANTOM(5, "phantomchecker", References.localNameVC("vc.item.enum.balloon.5")),
        POLKADOT(6, "polkadot", References.localNameVC("vc.item.enum.balloon.6")),
        POLKADOTCOLORIZED(7, "colorizedpolkadot", References.localNameVC("vc.item.enum.balloon.7")),
        POLKADOTPHANTOM(8, "phantompolkadot", References.localNameVC("vc.item.enum.balloon.8")),
        ZIGZAG(9, "zigzag", References.localNameVC("vc.item.enum.balloon.9")),
    	ZIGZAGCOLORIZED(10, "colorizedzigzag", References.localNameVC("vc.item.enum.balloon.10")),
    	ZIGZAGPHANTOM(11, "phantomzigzag", References.localNameVC("vc.item.enum.balloon.11")),
    	CREEPER(12, "creeper", References.localNameVC("vc.item.enum.balloon.12")),
    	CREEPERCOLORIZED(13, "colorizedcreeper", References.localNameVC("vc.item.enum.balloon.13")),
    	CREEPERPHANTOM(14, "phantomcreeper", References.localNameVC("vc.item.enum.balloon.14")),
    	WATER(15, "water", References.localNameVC("vc.item.enum.balloon.15")),
    	WATERCOLORIZED(16, "colorizedwater", References.localNameVC("vc.item.enum.balloon.16")),
    	WATERPHANTOM(17, "phantomwater", References.localNameVC("vc.item.enum.balloon.17")),
    	LAVA(18, "lava", References.localNameVC("vc.item.enum.balloon.18")),
    	LAVACOLORIZED(19, "colorizedlava", References.localNameVC("vc.item.enum.balloon.19")),
    	LAVAPHANTOM(20, "phantomlava", References.localNameVC("vc.item.enum.balloon.20")),
    	ENDER(21, "ender", References.localNameVC("vc.item.enum.balloon.21")),
    	ENDERCOLORIZED(22, "colorizedender", References.localNameVC("vc.item.enum.balloon.22")),
    	ENDERPHANTOM(23, "phantomender", References.localNameVC("vc.item.enum.balloon.23")),
    	TOOLS(24, "tools", References.localNameVC("vc.item.enum.balloon.24")),
    	TOOLSCOLORIZED(25, "colorizedtools", References.localNameVC("vc.item.enum.balloon.25")),
    	TOOLSPHANTOM(26, "phantomtools", References.localNameVC("vc.item.enum.balloon.26"))//,
        
    	//WAVEHORIZONTAL(7, "Horizontal Wave"),
        //WAVEHORIZONTALCOLORIZED(8, "Colorized Horizontal Wave"),
        //WAVEVERTICAL(9, "Vertical Wave"),
        //WAVEVERTICALCOLORIZED(10, "Colorized Vertical Wave")
    	//BASKETWEAVE(7, "Basketweave")
    	//BASKETWEAVECOLORIZED(7, "Colorized Basketweave")
    	;
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private AirshipBalloon(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a boat type by it's enum ordinal
         */
        public static EnumsVC.AirshipBalloon byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipBalloon getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    

	
    /** OLD REMOVE NEXT UPDATE
	 * Module enum - Represents various Module types.
	 */
    public static enum AirshipModule
    {
    	//STRING(meta, registry name, localized name)
        BASE(0, "base", References.localNameVC("vc.item.enum.module.outdated")),
        MINORSPEED(1, "Minor Speed", References.localNameVC("vc.item.enum.module.outdated")),
        MAJORSPEED(2, "Major Speed", References.localNameVC("vc.item.enum.module.outdated")),
        SMALLINVENTORY(3, "Small Inventory", References.localNameVC("vc.item.enum.module.outdated")),
        LARGEINVENTORY(4, "Large Inventory", References.localNameVC("vc.item.enum.module.outdated")),
        INFINITEFUEL(5, "Infinite Fuel", References.localNameVC("vc.item.enum.module.outdated")),
    	WATERLANDING(6, "Water Landing", References.localNameVC("vc.item.enum.module.outdated")),
    	MAXALTITUDE(7, "Max Altitude", References.localNameVC("vc.item.enum.module.outdated")),
    	MINOREFFICIENCY(8, "Minor Efficiency", References.localNameVC("vc.item.enum.module.outdated")),
    	MAJOREFFICIENCY(9, "Major Efficiency", References.localNameVC("vc.item.enum.module.outdated")),
    	JUKEBOX(10, "Jukebox", References.localNameVC("vc.item.enum.module.outdated")),
    	CRUISECONTROL(11, "Cruise Control", References.localNameVC("vc.item.enum.module.outdated"));
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private AirshipModule(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a module type by it's enum ordinal
         */
        public static EnumsVC.AirshipModule byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EnumsVC.AirshipModule getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    
	
}




/**  ORIGINAL
 * Tier enum - Dictates registryname, localized name, speed mod, max altitude.
 *
public static enum AirshipTier
{
	//STRING(meta, registry name, localized name, speed mod, max altitude, fuel per tick)
	ONE(0, "tier1", References.localNameVC("vc.enum.tier.1"), 0F, 75, 50),
	TWO(1, "tier2", References.localNameVC("vc.enum.tier.2"), 0.01F, 125, 40),
	THREE(2, "tier3", References.localNameVC("vc.enum.tier.3"), 0.02F, 175, 30),
	FOUR(3, "tier4", References.localNameVC("vc.enum.tier.4"), 0.03F, 225, 20),
	FIVE(4, "tier5", References.localNameVC("vc.enum.tier.5"), 0.04F, 500, 10);
	
    private final String name;
    private final int metadata;
    private final float speed;
    private final int elevation;
    private final int fuel;
    private final String localizedName;
    
    private AirshipTier(int metadataIn, String nameIn, String localizedNameIn, float speedModifier, int maxElevation, int fuelPerTick)
    {
        this.name = nameIn;
        this.metadata = metadataIn;
        this.speed = speedModifier;
        this.elevation = maxElevation;
        this.fuel = fuelPerTick;
        this.localizedName = localizedNameIn;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getMetadata()
    {
        return this.metadata;
    }
    
    public String toString()
    {
        return this.name;
    }
    
    public float getSpeed()
    {
        return this.speed;
    }
    
    public int getElevation()
    {
        return this.elevation;
    }
    
    public int getFuelPerTick()
    {
        return this.fuel;
    }
    
    public String getLocalizedName()
    {
        return this.localizedName;
    }
    
    /**
     * Get a tier type by it's enum ordinal
     *
    public static EnumsVC.AirshipTier byId(int id)
    {
        if (id < 0 || id >= values().length)
        {
            id = 0;
        }
        
        return values()[id];
    }
    
    public static EnumsVC.AirshipTier getTypeFromString(String nameIn)
    {
        for (int i = 0; i < values().length; ++i)
        {
            if (values()[i].getName().equals(nameIn))
            {
                return values()[i];
            }
        }
        
        return values()[0];
    }
}
*/



/**
 * Tier Upgrade enum - Represents various Tier Upgrade types.
 *
public static enum UpgradeAirshipTier
{
	//STRING(meta, registry name, localized name)
    BASE(0, "base", References.localNameVC("vc.item.enum.upgradetier.0")),
    ONE(1, "1", "1"),
    TWO(2, "2", "2"),
    THREE(3, "3", "3"),
    FOUR(4, "4", "4"),
    FIVE(5, "5", "5")
    ;
	
    private final String name;
    private final int metadata;
    private final String localizedName;
    
    private UpgradeAirshipTier(int metadataIn, String nameIn, String localizedNameIn)
    {
        this.name = nameIn;
        this.metadata = metadataIn;
        this.localizedName = localizedNameIn;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getMetadata()
    {
        return this.metadata;
    }
    
    public String toString()
    {
        return this.name;
    }
    
    public String getLocalizedName()
    {
        return this.localizedName;
    }
    
    /**
     * Get a balloon type by it's enum ordinal
     *
    public static EnumsVC.UpgradeAirshipTier byId(int id)
    {
        if (id < 0 || id >= values().length)
        {
            id = 0;
        }
        
        return values()[id];
    }
    
    public static EnumsVC.UpgradeAirshipTier getTypeFromString(String nameIn)
    {
        for (int i = 0; i < values().length; ++i)
        {
            if (values()[i].getName().equals(nameIn))
            {
                return values()[i];
            }
        }
        
        return values()[0];
    }
}

/**
 * Frame Upgrade enum - Represents various Frame Upgrade types.
 *
public static enum UpgradeAirshipFrame
{
	//STRING(meta, registry name, localized name)
    BASE(0, "base", References.localNameVC("vc.item.enum.upgradeframe.0")),
    ONE(1, "1", "1"),
    TWO(2, "2", "2"),
    THREE(3, "3", "3"),
    FOUR(4, "4", "4"),
    FIVE(5, "5", "5")
    ;
	
    private final String name;
    private final int metadata;
    private final String localizedName;
    
    private UpgradeAirshipFrame(int metadataIn, String nameIn, String localizedNameIn)
    {
        this.name = nameIn;
        this.metadata = metadataIn;
        this.localizedName = localizedNameIn;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getMetadata()
    {
        return this.metadata;
    }
    
    public String toString()
    {
        return this.name;
    }
    
    public String getLocalizedName()
    {
        return this.localizedName;
    }
    
    /**
     * Get a balloon type by it's enum ordinal
     *
    public static EnumsVC.UpgradeAirshipFrame byId(int id)
    {
        if (id < 0 || id >= values().length)
        {
            id = 0;
        }
        
        return values()[id];
    }
    
    public static EnumsVC.UpgradeAirshipFrame getTypeFromString(String nameIn)
    {
        for (int i = 0; i < values().length; ++i)
        {
            if (values()[i].getName().equals(nameIn))
            {
                return values()[i];
            }
        }
        
        return values()[0];
    }
}

/**
 * Balloon Upgrade enum - Represents various Balloon Upgrade types.
 *
public static enum UpgradeAirshipBalloon
{
	//STRING(meta, registry name, localized name)
    BASE(0, "base", References.localNameVC("vc.item.enum.upgradeballoon.0")),
    ONE(1, "1", "1"),
    TWO(2, "2", "2"),
    THREE(3, "3", "3"),
    FOUR(4, "4", "4"),
    FIVE(5, "5", "5")
    ;
	
    private final String name;
    private final int metadata;
    private final String localizedName;
    
    private UpgradeAirshipBalloon(int metadataIn, String nameIn, String localizedNameIn)
    {
        this.name = nameIn;
        this.metadata = metadataIn;
        this.localizedName = localizedNameIn;
    }
    
    public String getName()
    {
        return this.name;
    }
    
    public int getMetadata()
    {
        return this.metadata;
    }
    
    public String toString()
    {
        return this.name;
    }
    
    public String getLocalizedName()
    {
        return this.localizedName;
    }
    
    /**
     * Get a balloon type by it's enum ordinal
     *
    public static EnumsVC.UpgradeAirshipBalloon byId(int id)
    {
        if (id < 0 || id >= values().length)
        {
            id = 0;
        }
        
        return values()[id];
    }
    
    public static EnumsVC.UpgradeAirshipBalloon getTypeFromString(String nameIn)
    {
        for (int i = 0; i < values().length; ++i)
        {
            if (values()[i].getName().equals(nameIn))
            {
                return values()[i];
            }
        }
        
        return values()[0];
    }
}
*/

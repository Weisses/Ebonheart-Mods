package com.viesis.viescraft.api;

import java.util.Random;

import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;

import net.minecraft.init.SoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.translation.I18n;

public class EnumsVC {
	
	/**
     * Tier enum - Dictates registry/localized name, speed mod, max altitude.
     */
	public static enum AirshipTier
    {
    	//STRING(meta, registry name, localized name, speed mod, max altitude)
		ZERO(0, "TierZero", I18n.translateToLocal("vc.item.enum.frame.0"), 0F, 75),
		ONE(1, "TierOne", I18n.translateToLocal("vc.item.enum.frame.0"), 0F, 90),
		TWO(2, "TierTwo", I18n.translateToLocal("vc.item.enum.frame.0"), 0.01F, 150),
		THREE(3, "TierThree", I18n.translateToLocal("vc.item.enum.frame.0"), 0.02F, 200),
		FOUR(4, "TierFour", I18n.translateToLocal("vc.item.enum.frame.0"), 0.03F, 500),
		FIVE(5, "TierFive", I18n.translateToLocal("vc.item.enum.frame.0"), 0.04F, 500);
		
        private final String name;
        private final int metadata;
        private final float speed;
        private final int elevation;
        private final String localizedName;
        
        private AirshipTier(int metadataIn, String nameIn, String localizedNameIn, float speedModifier, int maxElevation)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.speed = speedModifier;
            this.elevation = maxElevation;
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
        
        public float getElevation()
        {
            return this.elevation;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        /**
         * Get a tier type by it's enum ordinal
         */
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
	
	/**
	 * Balloon enum - Represents various Balloon types.
     */
	public static enum AirshipBalloon
    {
        PLAIN(0, "Plain", I18n.translateToLocal("vc.item.enum.balloon.0")),
        PLAINCOLORIZED(1, "Colorized Plain", I18n.translateToLocal("vc.item.enum.balloon.1")),
        PLAINPHANTOM(2, "Phantom Plain", I18n.translateToLocal("vc.item.enum.balloon.2")),
        CHECKER(3, "Checker", I18n.translateToLocal("vc.item.enum.balloon.3")),
        CHECKERCOLORIZED(4, "Colorized Checker", I18n.translateToLocal("vc.item.enum.balloon.4")),
        CHECKERPHANTOM(5, "Phantom Checker", I18n.translateToLocal("vc.item.enum.balloon.5")),
        POLKADOT(6, "Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.6")),
        POLKADOTCOLORIZED(7, "Colorized Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.7")),
        POLKADOTPHANTOM(8, "Phantom Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.8")),
        ZIGZAG(9, "Zigzag", I18n.translateToLocal("vc.item.enum.balloon.9")),
    	ZIGZAGCOLORIZED(10, "Colorized Zigzag", I18n.translateToLocal("vc.item.enum.balloon.10")),
    	ZIGZAGPHANTOM(11, "Phantom Zigzag", I18n.translateToLocal("vc.item.enum.balloon.11")),
    	CREEPER(12, "Creeper", I18n.translateToLocal("vc.item.enum.balloon.12")),
    	CREEPERCOLORIZED(13, "Colorized Creeper", I18n.translateToLocal("vc.item.enum.balloon.13")),
    	CREEPERPHANTOM(14, "Phantom Creeper", I18n.translateToLocal("vc.item.enum.balloon.14")),
    	WATER(15, "Water", I18n.translateToLocal("vc.item.enum.balloon.15")),
    	WATERCOLORIZED(16, "Colorized Water", I18n.translateToLocal("vc.item.enum.balloon.16")),
    	WATERPHANTOM(17, "Phantom Water", I18n.translateToLocal("vc.item.enum.balloon.17")),
    	LAVA(18, "Lava", I18n.translateToLocal("vc.item.enum.balloon.18")),
    	LAVACOLORIZED(19, "Colorized Lava", I18n.translateToLocal("vc.item.enum.balloon.19")),
    	LAVAPHANTOM(20, "Phantom Lava", I18n.translateToLocal("vc.item.enum.balloon.20")),
    	ENDER(21, "Ender", I18n.translateToLocal("vc.item.enum.balloon.21")),
    	ENDERCOLORIZED(22, "Colorized Ender", I18n.translateToLocal("vc.item.enum.balloon.22")),
    	ENDERPHANTOM(23, "Phantom Ender", I18n.translateToLocal("vc.item.enum.balloon.23")),
    	TOOLS(24, "Tools", I18n.translateToLocal("vc.item.enum.balloon.24")),
    	TOOLSCOLORIZED(25, "Colorized Tools", I18n.translateToLocal("vc.item.enum.balloon.25")),
    	TOOLSPHANTOM(26, "Phantom Tools", I18n.translateToLocal("vc.item.enum.balloon.26"))//,
        
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
         * Get a balloon type by it's enum ordinal
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
    
    /**
	 * Module enum - Represents various Module types.
	 */
    public static enum AirshipModule
    {
        CHIP(0, "Chip", I18n.translateToLocal("vc.item.enum.module.0")),
        MINORSPEED(1, "Minor Speed", I18n.translateToLocal("vc.item.enum.module.1")),
        MAJORSPEED(2, "Major Speed", I18n.translateToLocal("vc.item.enum.module.2")),
        SMALLINVENTORY(3, "Small Inventory", I18n.translateToLocal("vc.item.enum.module.3")),
        LARGEINVENTORY(4, "Large Inventory", I18n.translateToLocal("vc.item.enum.module.4")),
        INFINITEFUEL(5, "Infinite Fuel", I18n.translateToLocal("vc.item.enum.module.5")),
    	WATERLANDING(6, "Water Landing", I18n.translateToLocal("vc.item.enum.module.6")),
    	MAXALTITUDE(7, "Max Altitude", I18n.translateToLocal("vc.item.enum.module.7")),
    	MINOREFFICIENCY(8, "Minor Efficiency", I18n.translateToLocal("vc.item.enum.module.8")),
    	MAJOREFFICIENCY(9, "Major Efficiency", I18n.translateToLocal("vc.item.enum.module.9")),
    	JUKEBOX(10, "Jukebox", I18n.translateToLocal("vc.item.enum.module.10")),
    	CRUISECONTROL(11, "Cruise Control", I18n.translateToLocal("vc.item.enum.module.11"));
    	
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
    
    /**
	 * Song enum - Represents various song types.
	 */
    public static enum AirshipSong
    {
    	NONE(0, I18n.translateToLocal("vc.item.enum.song.0"), SoundEvents.UI_BUTTON_CLICK),
    	RECORD11(1, I18n.translateToLocal("vc.item.enum.song.1"), SoundEvents.RECORD_11),
        RECORD13(2, I18n.translateToLocal("vc.item.enum.song.2"), SoundEvents.RECORD_13),
        RECORDBLOCKS(3, I18n.translateToLocal("vc.item.enum.song.3"), SoundEvents.RECORD_BLOCKS),
        RECORDMELLOHI(4, I18n.translateToLocal("vc.item.enum.song.4"), SoundEvents.RECORD_MELLOHI),
        RECORDCAT(5, I18n.translateToLocal("vc.item.enum.song.5"), SoundEvents.RECORD_CAT),
        RECORDSTAL(6, I18n.translateToLocal("vc.item.enum.song.6"), SoundEvents.RECORD_STAL),
        RECORDSTRAD(7, I18n.translateToLocal("vc.item.enum.song.7"), SoundEvents.RECORD_STRAD),
        RECORDCHIRP(8, I18n.translateToLocal("vc.item.enum.song.8"), SoundEvents.RECORD_CHIRP),
        RECORDFAR(9, I18n.translateToLocal("vc.item.enum.song.9"), SoundEvents.RECORD_FAR),
        RECORDMALL(10, I18n.translateToLocal("vc.item.enum.song.10"), SoundEvents.RECORD_MALL),
        RECORDWAIT(11, I18n.translateToLocal("vc.item.enum.song.11"), SoundEvents.RECORD_WAIT),
        RECORDWARD(12, I18n.translateToLocal("vc.item.enum.song.12"), SoundEvents.RECORD_WARD),
        RECORDTRIGUN(13, I18n.translateToLocal("vc.item.enum.song.13"), InitSoundEventsVC.trigun),
        RECORDBRAMBLE(14, I18n.translateToLocal("vc.item.enum.song.14"), InitSoundEventsVC.bramble),
        RECORDSTORMS(15, I18n.translateToLocal("vc.item.enum.song.15"), InitSoundEventsVC.storms),
        RECORDCOWBOY(16, I18n.translateToLocal("vc.item.enum.song.16"), InitSoundEventsVC.cowboy),
        RECORDSECRET(17, I18n.translateToLocal("vc.item.enum.song.17"), InitSoundEventsVC.bay)
    	;
    	
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
	 * Used in Rendering Airship textures.
	 */
	public static final ResourceLocation[] ENTITY_SCREEN_TEXTURE = new ResourceLocation[] 
	{
		/**new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/no_module.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_speed_minor.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_speed_major.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_inv_small.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_inv_large.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_fuel_infinite.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_water_landing.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_max_altitude.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_minor_efficiency.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_major_efficiency.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_jukebox.png"),
		new ResourceLocation(EnumsVC.MOD_ID, "textures/models/screens/module_cruise_control.png")
	*/};
}

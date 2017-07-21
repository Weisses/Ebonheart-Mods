package com.viesis.gemstones.api;

import net.minecraft.item.EnumRarity;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.text.translation.I18n;

public class VGEnum {
	
	/**
	 * RegistryType enum - Represents what types get loaded on what sides.
	 */
    public static enum RegistryType implements IStringSerializable
    {
    	//STRING(meta, registerName)
    	NONE(0, "none"),
        ALL(1, "all"),
        BLOCKONLY(2, "block"),
        ITEMONLY(3, "item");
    	
    	private final int metadata;
        private final String registerName;
        
        private RegistryType(int metadataIn, String registerNameIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public static RegistryType byMetadata(int meta)
        {
            if (meta < 0 || meta >= values().length)
            {
                meta = 0;
            }
            
            return values()[meta];
        }
        
        public static RegistryType getTypeFromString(String nameIn)
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
	 * Item V1 enum - Represents various Item V1 types.
	 */
    public static enum GemstoneTypeItemV1 implements IStringSerializable
    {
    	//STRING(meta, registerName, localizedName, generalType, enumRarity)
        ARCANITE(0, "arcanite", I18n.translateToLocal("vg.item.enum.frame.0"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
        VELIOUS(1, "velious", I18n.translateToLocal("vg.item.enum.frame.1"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	FENRYTE(2, "fenryte", I18n.translateToLocal("vg.item.enum.frame.2"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	ELECTIUM(3, "electium", I18n.translateToLocal("vg.item.enum.frame.3"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	IGNEELIS(4, "igneelis", I18n.translateToLocal("vg.item.enum.frame.4"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	NECROCITE(5, "necrocite", I18n.translateToLocal("vg.item.enum.frame.5"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	ZEPHYRIUM(6, "zephyrium", I18n.translateToLocal("vg.item.enum.frame.6"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	ONYXIUS(7, "onyxius", I18n.translateToLocal("vg.item.enum.frame.7"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON),
    	SOULARITE(8, "soularite", I18n.translateToLocal("vg.item.enum.frame.8"), RegistryType.ITEMONLY, EnumRarity.UNCOMMON);
    	
    	private final int metadata;
        private final String registerName;
        private final String localizedName;
        private final RegistryType registryType;
        private final EnumRarity enumRarity;
        
        private GemstoneTypeItemV1(int metadataIn, String registerNameIn, String localizedNameIn, RegistryType registryTypeIn, EnumRarity enumRarityIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
            this.localizedName = localizedNameIn;
            this.registryType = registryTypeIn;
            this.enumRarity = enumRarityIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public RegistryType getRegistryType()
        {
            return this.registryType;
        }
        
        public EnumRarity getEnumRarity()
        {
            return this.enumRarity;
        }
        
        public static GemstoneTypeItemV1 byMetadata(int meta)
        {
            if (meta < 0 || meta >= values().length)
            {
            	meta = 0;
            }
            
            return values()[meta];
        }
        
        public static GemstoneTypeItemV1 getTypeFromString(String nameIn)
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
	 * Block Basic V1 enum - Represents various Block Basic V1 types.
	 */
    public static enum GemstoneTypeBlockV1 implements IStringSerializable
    {
    	//STRING(meta, registerName, localizedName, generalType, enumRarity, harvestLevel, hardnessLevel, resistance, lightLevel)
        ARCANITE(0, "arcanite", I18n.translateToLocal("vg.blockv1.enum.frame.0"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 4.0F, 0F),
        VELIOUS(1, "velious", I18n.translateToLocal("vg.blockv1.enum.frame.1"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 15.0F, 0F),
    	FENRYTE(2, "fenryte", I18n.translateToLocal("vg.blockv1.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	ELECTIUM(3, "electium", I18n.translateToLocal("vg.blockv1.enum.frame.3"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	IGNEELIS(4, "igneelis", I18n.translateToLocal("vg.blockv1.enum.frame.4"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	NECROCITE(5, "necrocite", I18n.translateToLocal("vg.blockv1.enum.frame.5"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	ZEPHYRIUM(6, "zephyrium", I18n.translateToLocal("vg.blockv1.enum.frame.6"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	ONYXIUS(7, "onyxius", I18n.translateToLocal("vg.blockv1.enum.frame.7"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	SOULARITE(8, "soularite", I18n.translateToLocal("vg.blockv1.enum.frame.8"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30F, 0F);
    	
    	private final int metadata;
        private final String registerName;
        private final String localizedName;
        private final RegistryType registryType;
        private final EnumRarity enumRarity;
        private final int harvestLevel;
        private final float hardnessLevel;
        private final float resistance;
        private final float lightLevel;
        
        private GemstoneTypeBlockV1(int metadataIn, String registerNameIn, String localizedNameIn, RegistryType registryTypeIn, EnumRarity enumRarityIn, int harvestLevelIn, float hardnessLevelIn, float resistanceIn, float lightLevelIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
            this.localizedName = localizedNameIn;
            this.registryType = registryTypeIn;
            this.enumRarity = enumRarityIn;
            this.harvestLevel = harvestLevelIn;
            this.hardnessLevel = hardnessLevelIn;
            this.resistance = resistanceIn;
            this.lightLevel = lightLevelIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public RegistryType getRegistryType()
        {
            return this.registryType;
        }
        
        public EnumRarity getEnumRarity()
        {
            return this.enumRarity;
        }
        
        public int getHarvestLevel()
        {
            return this.harvestLevel;
        }
        
        public float getHardnessLevel()
        {
            return this.hardnessLevel;
        }
        
        public float getResistance()
        {
            return this.resistance;
        }
        
        public float getLightLevel()
        {
            return this.lightLevel;
        }
        
        public static GemstoneTypeBlockV1 byMetadata(int meta)
        {
            if (meta < 0 || meta >= values().length)
            {
            	meta = 0;
            }
            
            return values()[meta];
        }
        
        public static GemstoneTypeBlockV1 getTypeFromString(String nameIn)
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
	 * Ore enum - Represents various Ore types.
	 */
    public static enum GemstoneTypeOre implements IStringSerializable
    {
    	//STRING(meta, registerName, localizedName, enumRarity)
        OVERWORLD(0, "overworld", I18n.translateToLocal("vg.world.enum.0"), EnumRarity.COMMON),
        NETHER(1, "nether", I18n.translateToLocal("vg.world.enum.1"), EnumRarity.COMMON),
    	END(2, "end", I18n.translateToLocal("vg.world.enum.2"), EnumRarity.COMMON);
    	
    	private final int metadata;
        private final String registerName;
        private final String localizedName;
        private final EnumRarity enumRarity;
        
        private GemstoneTypeOre(int metadataIn, String registerNameIn, String localizedNameIn, EnumRarity enumRarityIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
            this.localizedName = localizedNameIn;
            this.enumRarity = enumRarityIn;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public EnumRarity getEnumRarity()
        {
            return this.enumRarity;
        }
        
        public static GemstoneTypeOre byMetadata(int meta)
        {
            if (meta < 0 || meta >= values().length)
            {
            	meta = 0;
            }
            
            return values()[meta];
        }
        
        public static GemstoneTypeOre getTypeFromString(String nameIn)
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
	 * Item1 Type enum - Represents various item types.
	 */
/**    public static enum MaterialTypeItem implements IStringSerializable
    {
    	//STRING(meta, registerName, localizedName, generalType, enumRarity, harvestLevel, hardnessLevel, resistance, lightLevel)
        DRACONITE(0, "arcanite", I18n.translateToLocal("ea.item.enum.frame.0"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 4.0F, 0F),
        UNUSED1(1, "placeholder1", I18n.translateToLocal("null1"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
        UNUSED2(2, "placeholder2", I18n.translateToLocal("null2"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
        UNUSED3(3, "placeholder3", I18n.translateToLocal("null3"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
        UNUSED4(4, "placeholder4", I18n.translateToLocal("null4"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
        
        VELIOUS(5, "velious", I18n.translateToLocal("ea.item.enum.frame.1"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 15.0F, 0F),
    	UNUSED6(6, "placeholder6", I18n.translateToLocal("null6"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED7(7, "placeholder7", I18n.translateToLocal("null7"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED8(8, "placeholder8", I18n.translateToLocal("null8"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED9(9, "placeholder9", I18n.translateToLocal("null9"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	ARCANITE(10, "fenryte", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED11(11, "placeholder11", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED12(12, "placeholder12", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED13(13, "placeholder13", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED14(14, "placeholder14", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	KATCHEEN(15, "electium", I18n.translateToLocal("ea.item.enum.frame.3"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED16(16, "placeholder16", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED17(17, "placeholder17", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED18(18, "placeholder18", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED19(19, "placeholder19", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	GARAMITE(20, "garamite", I18n.translateToLocal("ea.item.enum.frame.4"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED21(21, "placeholder21", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED22(22, "placeholder22", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED23(23, "placeholder23", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED24(24, "placeholder24", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	ONYXIUS(20, "onyxius", I18n.translateToLocal("ea.item.enum.frame.5"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED26(26, "placeholder26", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED27(27, "placeholder27", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED28(28, "placeholder28", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED29(29, "placeholder29", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	MYSTALIOUS(30, "mystalious", I18n.translateToLocal("ea.item.enum.frame.6"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED31(31, "placeholder31", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED32(32, "placeholder32", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED33(33, "placeholder33", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED34(34, "placeholder34", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	
    	
    	NECROCITE(35, "necrocite", I18n.translateToLocal("ea.item.enum.frame.7"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED36(36, "placeholder36", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED37(37, "placeholder37", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED38(38, "placeholder38", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED39(39, "placeholder39", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	SOULARITE(40, "soularite", I18n.translateToLocal("ea.item.enum.frame.8"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED41(41, "placeholder41", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED42(42, "placeholder42", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED43(43, "placeholder43", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED44(44, "placeholder44", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	INFERNUS(45, "infernus", I18n.translateToLocal("ea.item.enum.frame.9"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED46(46, "placeholder46", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED47(47, "placeholder47", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED48(48, "placeholder48", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED49(49, "placeholder49", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),

    	
    	
    	
    	CARNELIAN(50, "carnelian", I18n.translateToLocal("ea.item.enum.frame.10"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED51(51, "placeholder51", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED52(52, "placeholder52", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED53(53, "placeholder53", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED54(54, "placeholder54", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	ATRIUS(55, "atrius", I18n.translateToLocal("ea.item.enum.frame.11"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED56(56, "placeholder56", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED57(57, "placeholder57", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED58(58, "placeholder58", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED59(59, "placeholder59", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	ENSTATITE(60, "enstatite", I18n.translateToLocal("ea.item.enum.frame.12"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED61(61, "placeholder61", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED62(62, "placeholder62", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED63(63, "placeholder63", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED64(64, "placeholder64", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	
    	
    	EBONHEART(65, "ebonheart", I18n.translateToLocal("ea.item.enum.frame.13"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED66(66, "placeholder66", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED67(67, "placeholder67", I18n.translateToLocal("null12"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED68(68, "placeholder68", I18n.translateToLocal("null13"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	UNUSED69(69, "placeholder69", I18n.translateToLocal("null14"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F);
    	
    	private final int metadata;
        private final String registerName;
        private final String localizedName;
        private final RegistryType generalType;
        private final EnumRarity enumRarity;
        private final int harvestLevel;
        private final float hardnessLevel;
        private final float resistance;
        private final float lightLevel;
        
        private MaterialTypeItem(int metadataIn, String registerNameIn, String localizedNameIn, RegistryType generalTypeIn, EnumRarity enumRarityIn, int harvestLevelIn, float hardnessLevelIn, float resistanceIn, float lightLevelIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
            this.localizedName = localizedNameIn;
            this.generalType = generalTypeIn;
            this.enumRarity = enumRarityIn;
            this.harvestLevel = harvestLevelIn;
            this.hardnessLevel = hardnessLevelIn;
            this.resistance = resistanceIn;
            this.lightLevel = lightLevelIn;
        }
        
        public String toString()
        {
            return this.registerName;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public RegistryType getRegistryType()
        {
            return this.generalType;
        }
        
        public EnumRarity getEnumRarity()
        {
            return this.enumRarity;
        }
        
        public float getHarvestLevel()
        {
            return this.harvestLevel;
        }
        
        public float getHardnessLevel()
        {
            return this.hardnessLevel;
        }
        
        public float getResistance()
        {
            return this.resistance;
        }
        
        public float getLightLevel()
        {
            return this.lightLevel;
        }
        
        /**
         * Get meta by it's enum ordinal
         */
    /**        public static MaterialTypeItem byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static MaterialTypeItem getTypeFromString(String nameIn)
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
	 * Type enum - Represents various frame types.
	 */
    /**    public static enum MaterialTypeGemstoneBlock implements IStringSerializable
    {
    	//STRING(meta, registerName, localizedName, generalType, enumRarity, harvestLevel, hardnessLevel, resistance, lightLevel)
        DRACONITE(0, "arcanite", I18n.translateToLocal("ea.item.enum.frame.0"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 4.0F, 0F),
        VELIOUS(5, "velious", I18n.translateToLocal("ea.item.enum.frame.1"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 15.0F, 0F),
    	ARCANITE(10, "fenryte", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	KATCHEEN(15, "electium", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	ONYXIUS(20, "onyxius", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	MYSTALIOUS(25, "mystalious", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	
    	NECROCITE(30, "necrocite", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	SOULARITE(35, "soularite", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	
    	CARNELIAN(40, "carnelian", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	ATRIUS(45, "atrius", I18n.translateToLocal("ea.item.enum.frame.2"), RegistryType.ALL, EnumRarity.COMMON, 2, 5.0F, 30.0F, 0F),
    	UNUSED46(46, "placeholder46", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F),
    	
    	EBONHEART(46, "placeholder46", I18n.translateToLocal("null11"), RegistryType.NONE, EnumRarity.COMMON, 2, 0F, 0F, 0F);
    	
    	
    	//,
        ////KATCHEEN(3, "electium", I18n.translateToLocal("ea.item.enum.frame.3"), 3, 100.0F),
        //ONYXIUS(3, "Katcheen", I18n.translateToLocal("ea.item.enum.frame.3"), 3, 100.0F),
        //GARAMITE(3, "Katcheen", I18n.translateToLocal("ea.item.enum.frame.3"), 3, 100.0F),
        //MYSTALIOUS(3, "Katcheen", I18n.translateToLocal("ea.item.enum.frame.3"), 3, 100.0F),
        
        
        ////NECROCITE(4, "necrocite", I18n.translateToLocal("ea.item.enum.frame.4"), 3, 45.0F),
        ////SOULARITE(5, "soularite", I18n.translateToLocal("ea.item.enum.frame.5"), 3, 45.0F),
        //INFERNUS(5, "Infernus", I18n.translateToLocal("ea.item.enum.frame.5"), 3, 45.0F),
        
        
        //CARNELIAN(5, "Carnelian", I18n.translateToLocal("ea.item.enum.frame.5"), 3, 45.0F),
        //ATRIUS(5, "Infernus", I18n.translateToLocal("ea.item.enum.frame.5"), 3, 45.0F),
       // ENSTATITE(5, "Infernus", I18n.translateToLocal("ea.item.enum.frame.5"), 3, 45.0F),
        
        
        ////EBONHEART(6, "ebonheart", I18n.translateToLocal("ea.item.enum.frame.6"), 3, 2000.0F);
        
    	private final int metadata;
        private final String registerName;
        private final String localizedName;
        private final RegistryType generalType;
        private final EnumRarity enumRarity;
        private final int harvestLevel;
        private final float hardnessLevel;
        private final float resistance;
        private final float lightLevel;
        
        private MaterialTypeGemstoneBlock(int metadataIn, String registerNameIn, String localizedNameIn, RegistryType generalTypeIn, EnumRarity enumRarityIn, int harvestLevelIn, float hardnessLevelIn, float resistanceIn, float lightLevelIn)
        {
            this.metadata = metadataIn;
            this.registerName = registerNameIn;
            this.localizedName = localizedNameIn;
            this.generalType = generalTypeIn;
            this.enumRarity = enumRarityIn;
            this.harvestLevel = harvestLevelIn;
            this.hardnessLevel = hardnessLevelIn;
            this.resistance = resistanceIn;
            this.lightLevel = lightLevelIn;
        }
        
        public String toString()
        {
            return this.registerName;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String getName()
        {
            return this.registerName;
        }
        
        public String getLocalizedName()
        {
            return this.localizedName;
        }
        
        public RegistryType getRegistryType()
        {
            return this.generalType;
        }
        
        public EnumRarity getEnumRarity()
        {
            return this.enumRarity;
        }
        
        public float getHarvestLevel()
        {
            return this.harvestLevel;
        }
        
        public float getHardnessLevel()
        {
            return this.hardnessLevel;
        }
        
        public float getResistance()
        {
            return this.resistance;
        }
        
        public float getLightLevel()
        {
            return this.lightLevel;
        }
        
        /**
         * Get meta by it's enum ordinal
         */
    /**        public static MaterialTypeGemstoneBlock byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static MaterialTypeGemstoneBlock getTypeFromString(String nameIn)
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
    
}

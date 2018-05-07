package com.viesis.viescraft.common.items.achievements;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

public class ItemAchievement extends Item {
	
	public ItemAchievement() 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		ItemHelper.setItemName(this, "achievements/achievement_airship");
		
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return ("Icon - " + ItemAchievement.Achievement.byId(this.getMetadata(stack)).getName());
    }
	
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
		if (isInCreativeTab(tab)) {
			final List<ItemStack> items = Stream.of(ItemAchievement.Achievement.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
	
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
        public static ItemAchievement.Achievement byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static ItemAchievement.Achievement getTypeFromString(String nameIn)
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

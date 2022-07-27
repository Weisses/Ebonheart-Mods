package com.viesis.viescraft.common.items.achievements;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
		return ("Icon - " + EnumsVC.Achievement.byId(this.getMetadata(stack)).getRegistryName());
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.Achievement.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

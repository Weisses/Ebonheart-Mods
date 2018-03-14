package com.viesis.viescraft.common.items;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirship;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBomb extends Item {
	
	public ItemBomb() 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, "item_bomb");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = TextFormatting.WHITE + "Bomb Casing";
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE + "Bomb Casing";
			case 1:
				return colorName = TextFormatting.YELLOW + "Small Bomb";
			case 2:
				return colorName = TextFormatting.DARK_RED+ "Big Bomb";
			default:
				return colorName = TextFormatting.WHITE + "Bomb Casing";
		}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.Bombs.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

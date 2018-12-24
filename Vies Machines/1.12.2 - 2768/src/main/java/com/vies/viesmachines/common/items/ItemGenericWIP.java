package com.vies.viesmachines.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGenericWIP extends Item {
	
	private EnumRarity rarity;
	
	public ItemGenericWIP(String unlocalizedNameIn, EnumRarity rarityIn) 
	{
		ItemHelper.setItemName(this, unlocalizedNameIn);
		
		this.rarity = rarityIn;
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		TextFormatting textColor = TextFormatting.GRAY;
		
		if (this.rarity == EnumRarity.UNCOMMON)
		{
			textColor = TextFormatting.GOLD;
		}
		
		if (this.rarity == EnumRarity.RARE)
		{
			textColor = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			textColor = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(textColor + "WIP - NOT USED YET! :)");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }
}

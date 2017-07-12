package com.viesis.gemstones.common.items.resources.gemstones;

import java.util.List;

import com.viesis.gemstones.common.items.ItemHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemstoneUnidentified extends Item {
	
	public ItemGemstoneUnidentified() 
	{
		ItemHelper.setItemName(this, "gemstone/item_unidentified");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GRAY + "Gems are infused with this stone. This");
		toolTip.add(TextFormatting.GRAY + "can be processed into any gemstone.");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (I18n.translateToLocal("vg.item.gemstone_unidentified"));
    }
}

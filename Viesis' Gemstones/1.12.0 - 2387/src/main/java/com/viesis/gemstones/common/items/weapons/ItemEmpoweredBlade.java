package com.viesis.gemstones.common.items.weapons;

import java.util.List;

import com.viesis.gemstones.common.items.ItemHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEmpoweredBlade extends Item {

	public ItemEmpoweredBlade() 
	{
		ItemHelper.setItemName(this, "tool/empowered_blade");
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "This sword blade radiates");
		toolTip.add(TextFormatting.DARK_AQUA + "with unknown potential.");
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
}

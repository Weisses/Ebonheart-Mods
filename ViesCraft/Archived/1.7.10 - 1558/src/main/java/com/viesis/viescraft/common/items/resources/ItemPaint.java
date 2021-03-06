package com.viesis.viescraft.common.items.resources;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemPaint extends Item {
	
	private final EntityAirshipV1Core.Type type;
	
	public ItemPaint(EntityAirshipV1Core.Type typeIn) 
	{
		this.type = typeIn;
		ItemHelper.setItemName(this, "item_paint_" + typeIn.getName());
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GOLD + "Airship paint isn't flammable,");
		toolTip.add(TextFormatting.GOLD + "is it?!?");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}

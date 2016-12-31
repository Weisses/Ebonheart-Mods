package com.viesis.viescraft.common.items.airshipitems;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipCore extends Item {
	
	protected static final String[] ITEM_COLOR = new String[] 
	{
		"Plain",
		"Black",
		"Blue",
		"Brown",
		"Cyan",
		"Gray",
		"Green",
		"Lightblue",
		"Lightgray",
		"Lime",
		"Magenta",
		"Orange",
		"Pink",
		"Purple",
		"Red",
		"White",
		"Yellow",
		"Rainbow"
	};
	
	public ItemAirshipCore() 
	{
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "Hold " + TextFormatting.WHITE + "[Shift + Right-Click]" + TextFormatting.DARK_PURPLE + " to throw this");
		toolTip.add(TextFormatting.DARK_PURPLE + "item and unleash the airship within.");
		toolTip.add(TextFormatting.DARK_PURPLE + "No assembly required!");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
}

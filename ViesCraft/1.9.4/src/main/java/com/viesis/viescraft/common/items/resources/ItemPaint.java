package com.viesis.viescraft.common.items.resources;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipBlack;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemPaint extends Item{
	
	private final EntityAirshipNormal.Type type;
	
	public ItemPaint(EntityAirshipNormal.Type typeIn) 
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
	
	//@SideOnly(Side.CLIENT)
    //public boolean hasEffect(ItemStack stack)
    //{
    //    return true;
    //}
	
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}

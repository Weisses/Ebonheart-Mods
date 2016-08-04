package com.viesis.viescraft.common.items.airshipitems;

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

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipNormal;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAirshipCore extends Item {
	
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

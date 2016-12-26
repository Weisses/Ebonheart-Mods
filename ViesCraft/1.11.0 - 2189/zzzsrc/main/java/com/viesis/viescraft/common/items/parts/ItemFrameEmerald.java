package com.viesis.viescraft.common.items.parts;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemFrameEmerald extends Item {
	
	public ItemFrameEmerald() 
	{
		ItemHelper.setItemName(this, "airship_frame_emerald");
		this.setMaxStackSize(16);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "Emerald-plated Minecart used");
		toolTip.add(TextFormatting.DARK_AQUA + "in airship creation.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}

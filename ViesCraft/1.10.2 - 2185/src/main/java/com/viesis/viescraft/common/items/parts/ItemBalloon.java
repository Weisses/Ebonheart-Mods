package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBalloon extends Item {
	
	public ItemBalloon() 
	{
		ItemHelper.setItemName(this, "airship_balloon");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.balloon.1"));
		toolTip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.balloon.2"));
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.COMMON;
    }
}

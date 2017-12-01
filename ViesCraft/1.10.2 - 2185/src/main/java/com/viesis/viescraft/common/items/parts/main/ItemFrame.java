package com.viesis.viescraft.common.items.parts.main;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFrame extends Item {
	
	public ItemFrame() 
	{
		ItemHelper.setItemName(this, "airship_frame");
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.AirshipTierCore.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColorMain = TextFormatting.WHITE;
		TextFormatting stringColorText = TextFormatting.GRAY;
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		toolTip.add(I18n.translateToLocal("vc.item.tt.baseframe.1"));
		toolTip.add(I18n.translateToLocal("vc.item.tt.baseframe.2"));
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        String colorName = TextFormatting.WHITE + "Airship Frame";
		
		return colorName;
    }
}

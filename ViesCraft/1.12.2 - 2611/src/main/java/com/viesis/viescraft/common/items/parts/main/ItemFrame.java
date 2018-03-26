package com.viesis.viescraft.common.items.parts.main;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFrame extends Item {
	
	public ItemFrame() 
	{
		ItemHelper.setItemName(this, "item_airship_frame");
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.MainTierFrame.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColorMain = TextFormatting.WHITE;
		TextFormatting stringColorText = TextFormatting.GRAY;
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(I18n.translateToLocal("vc.item.tt.baseframe.1"));
		tooltip.add(I18n.translateToLocal("vc.item.tt.baseframe.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
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

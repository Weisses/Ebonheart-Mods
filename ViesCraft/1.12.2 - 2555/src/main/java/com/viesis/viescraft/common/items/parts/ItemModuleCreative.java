package com.viesis.viescraft.common.items.parts;

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

public class ItemModuleCreative extends Item {
	
	public ItemModuleCreative() 
	{
		ItemHelper.setItemName(this, "modules/item_module_creative");
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.AirshipTierCore.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColorMain = TextFormatting.WHITE;
		TextFormatting stringColorText = TextFormatting.DARK_RED;
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.BLACK + "---i" + stringColorText + I18n.translateToLocal("vc.item.tt.modulecreative.1"));
		tooltip.add(stringColorText + I18n.translateToLocal("vc.item.tt.modulecreative.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = TextFormatting.GOLD + "" + TextFormatting.BOLD +  "Module Upgrade";
		
		return colorName 
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ " ("
				+ TextFormatting.BLUE
				+ "C"
				+ TextFormatting.GREEN
				+ "r"
				+ TextFormatting.AQUA
				+ "e"
				+ TextFormatting.RED
				+ "a"
				+ TextFormatting.LIGHT_PURPLE
				+ "t"
				+ TextFormatting.YELLOW
				+ "i"
				+ TextFormatting.WHITE
				+ "v"
				+ TextFormatting.DARK_AQUA
				+ "e"
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ ") ";
    }
}

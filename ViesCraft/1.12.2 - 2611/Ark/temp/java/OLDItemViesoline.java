package com.viesis.viescraft.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

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

public class OLDItemViesoline extends Item {
	
	public OLDItemViesoline() 
	{
		ItemHelper.setItemName(this, "viesoline_pellets");
		this.setMaxStackSize(64);
		//this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("THIS IS OUTDATED!"));
		tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("PLACE THIS IN A CRAFTING TABLE!"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = TextFormatting.WHITE + "OLD Viesoline Pellets";
		
		return colorName;
    }
}

package com.viesis.viescraft.common.items.parts;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemViesoline extends Item {
	
	public ItemViesoline() 
	{
		ItemHelper.setItemName(this, "viesoline_pellets");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> toolTip, ITooltipFlag flagIn)
    {
		int timer;
		int remainder;
		int minutes;
		int seconds;
		int hours;
		
		timer = (ViesCraftConfig.viesolineBurnTime);
		remainder = (timer % 3600);
		minutes = remainder / 60;
		seconds = remainder % 60;
		
		String mins = (minutes < 10 ? "0" : "") + minutes;
		String secs = (seconds < 10 ? "0" : "") + seconds;
		
		//Time in seconds to display
		String s = mins + ":" + secs;
		
		toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.viesoline.1"));
		toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.viesoline.2"));
		toolTip.add("");
		toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.viesoline.3") + " " + s);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}

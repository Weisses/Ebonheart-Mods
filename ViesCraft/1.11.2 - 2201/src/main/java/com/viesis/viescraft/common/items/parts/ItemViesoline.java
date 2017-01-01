package com.viesis.viescraft.common.items.parts;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemViesoline extends Item {
	
	public ItemViesoline() 
	{
		ItemHelper.setItemName(this, "item_viesoline");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{

		int timer;
		int remainder;
		int minutes;
		int seconds;
		int hours;
		
		//Calculation from ticks to seconds.
        //timer = (ViesCraftConfig.viesolineBurnTime);
		//remainder = (timer % 3600);
		//minutes = remainder / 60;
		//seconds = remainder % 60;
		//hours = timer / 3600;
		
		timer = (ViesCraftConfig.viesolineBurnTime);
		remainder = (timer % 3600);
		minutes = remainder / 60;
		seconds = remainder % 60;
		
		//String hrs = (hours < 10 ? "0" : "") + hours;
		String mins = (minutes < 10 ? "0" : "") + minutes;
		String secs = (seconds < 10 ? "0" : "") + seconds;
		
		//Time in seconds to display
		String s = mins + ":" + secs;
		
		
		
		toolTip.add(TextFormatting.GOLD + "Fuel designed for");
		toolTip.add(TextFormatting.GOLD + "all airships.");
		toolTip.add(TextFormatting.GOLD + "Burn Time: " + s);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}

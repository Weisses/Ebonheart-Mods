package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModule extends Item {
	
	public ItemModule() 
	{
		ItemHelper.setItemName(this, "modules/airship_module");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		TextFormatting stringColor = TextFormatting.DARK_AQUA;
		
		if(stack.getMetadata() == 0)
		{
			toolTip.add(stringColor + "A basic chip used to make");
			toolTip.add(stringColor + "airship parts.");
		}
		if(stack.getMetadata() == 1)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Speed Modifier: +0.8");
			toolTip.add(TextFormatting.RED + "Con - None.");
		}
		if(stack.getMetadata() == 2)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Speed Modifier: +1.6");
			toolTip.add(TextFormatting.RED + "Con - Fuel burns x2 faster.");
		}
		if(stack.getMetadata() == 3)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - 9 slot inventory.");
			toolTip.add(TextFormatting.RED + "Con - Speed Modifier: -20%");
		}
		if(stack.getMetadata() == 4)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - 18 slot inventory.");
			toolTip.add(TextFormatting.RED + "Con - Speed Modifier: -30%");
			toolTip.add(TextFormatting.RED + "Con - Fuel burns x2 faster.");
		}
		if(stack.getMetadata() == 5)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Fly without fuel.");
			toolTip.add(TextFormatting.RED + "Con - Speed Modifier: -50%");
		}
		if(stack.getMetadata() == 6)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Land on water.");
			toolTip.add(TextFormatting.RED + "Con - None.");
		}
		if(stack.getMetadata() == 7)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Unlimited max altitude.");
			toolTip.add(TextFormatting.RED + "Con - None.");
		}
		if(stack.getMetadata() == 8)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Fuel lasts 25% longer.");
			toolTip.add(TextFormatting.RED + "Con - None.");
		}
		if(stack.getMetadata() == 9)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Fuel lasts 50% longer.");
			toolTip.add(TextFormatting.RED + "Con - Speed Modifier: -25%");//Really 30%
		}
		if(stack.getMetadata() == 10)
		{
			toolTip.add(TextFormatting.GOLD + "Effects while socketed:");
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + "Pro - Play music in area.");
			toolTip.add(TextFormatting.RED + "Con - None.");//Really 30%
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		if(stack.getMetadata() == 0)
        {
        	this.setMaxStackSize(64);
        }
        else
        {
        	this.setMaxStackSize(1);
        }
        
		switch (this.getMetadata(stack))
        {
            default:
            	return EnumRarity.RARE;
        }
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String itemName;
		
		if(stack.getMetadata() == 0)
        {
        	itemName = "Logic Chip";
        }
        else
        {
        	itemName = "Module - " + EntityAirshipBaseVC.Module.byId(this.getMetadata(stack)).getName();
        }
		return itemName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Module contents : EntityAirshipBaseVC.Module.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

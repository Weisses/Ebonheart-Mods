package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.resources.I18n;
import net.minecraft.creativetab.CreativeTabs;
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
        
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		if(stack.getMetadata() == 0)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.0.1"));
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.0.2"));
		}
		if(stack.getMetadata() == 1)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.1.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.1.2"));
		}
		if(stack.getMetadata() == 2)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.2.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.2.2"));
		}
		if(stack.getMetadata() == 3)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.3.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.3.2") + " -20%");
		}
		if(stack.getMetadata() == 4)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.4.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.4.2") + " -30%");
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.4.3"));
		}
		if(stack.getMetadata() == 5)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.5.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.5.2") + " -50%");
		}
		if(stack.getMetadata() == 6)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.6.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.6.2"));
		}
		if(stack.getMetadata() == 7)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.7.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.7.2"));
		}
		if(stack.getMetadata() == 8)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.8.1") + " +25%");
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.8.2"));
		}
		if(stack.getMetadata() == 9)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.9.1") + " +50%");
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.9.2") + " -25%");//Really 30%
		}
		if(stack.getMetadata() == 10)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.10.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.10.2"));//Really 30%
		}
		if(stack.getMetadata() == 11)
		{
			toolTip.add(TextFormatting.GOLD + I18n.format("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.module.11.1"));
			toolTip.add(TextFormatting.RED + I18n.format("vc.item.tt.module.11.2"));//Really 30%
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
			case 0:
				return EnumRarity.UNCOMMON;
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
        	itemName = I18n.format("vc.item.module.0");
        }
        else
        {
        	itemName = I18n.format("vc.item.module.#") + " - " + EntityAirshipBaseVC.Module.byId(this.getMetadata(stack)).getName();
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

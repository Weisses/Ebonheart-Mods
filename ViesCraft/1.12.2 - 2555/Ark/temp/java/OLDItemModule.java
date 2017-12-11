package com.viesis.viescraft.common.items;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OLDItemModule extends Item {
	
	public OLDItemModule() 
	{
		ItemHelper.setItemName(this, "modules/airship_module");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		//this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		
		
		tooltip.add(TextFormatting.RED + "THIS IS AN OUTDATED ITEM!");
		tooltip.add(TextFormatting.RED + "WILL BE REMOVED NEXT UPDATE!");
		tooltip.add(TextFormatting.WHITE + "Place it into a crafting table");
		tooltip.add(TextFormatting.WHITE + "to get an equivalent item.");
		
		/**
		if(stack.getMetadata() == 0)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.0.1"));
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.0.2"));
		}
		if(stack.getMetadata() == 1)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.1.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.1.2"));
		}
		if(stack.getMetadata() == 2)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.2.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.2.2"));
		}
		if(stack.getMetadata() == 3)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.3.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.3.2") + " -20%");
		}
		if(stack.getMetadata() == 4)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.4.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.4.2") + " -30%");
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.4.3"));
		}
		if(stack.getMetadata() == 5)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.5.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.5.2") + " -50%");
		}
		if(stack.getMetadata() == 6)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.6.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.6.2"));
		}
		if(stack.getMetadata() == 7)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.7.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.7.2"));
		}
		if(stack.getMetadata() == 8)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.8.1") + " +25%");
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.8.2"));
		}
		if(stack.getMetadata() == 9)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.9.1") + " +50%");
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.9.2") + " -25%");//Really 30%
		}
		if(stack.getMetadata() == 10)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.10.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.10.2"));//Really 30%
		}
		if(stack.getMetadata() == 11)
		{
			tooltip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			tooltip.add(" ");
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.11.1"));
			tooltip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.11.2"));//Really 30%
		}
		*/
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
        	itemName = I18n.translateToLocal("OLD Logic Chip");
        }
        else
        {
        	itemName = I18n.translateToLocal("vc.item.module.#") + " - " + EnumsVC.AirshipModule.byId(this.getMetadata(stack)).getLocalizedName();
        }
		
		return itemName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.AirshipModule.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

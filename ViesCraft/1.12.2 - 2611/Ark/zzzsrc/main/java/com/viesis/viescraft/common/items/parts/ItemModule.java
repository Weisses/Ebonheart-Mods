package com.viesis.viescraft.common.items.parts;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
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
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> toolTip, ITooltipFlag flagIn)
    {
		if(stack.getMetadata() == 0)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.0.1"));
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.0.2"));
		}
		if(stack.getMetadata() == 1)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.1.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.1.2"));
		}
		if(stack.getMetadata() == 2)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.2.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.2.2"));
		}
		if(stack.getMetadata() == 3)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.3.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.3.2") + " -20%");
		}
		if(stack.getMetadata() == 4)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.4.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.4.2") + " -30%");
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.4.3"));
		}
		if(stack.getMetadata() == 5)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.5.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.5.2") + " -50%");
		}
		if(stack.getMetadata() == 6)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.6.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.6.2"));
		}
		if(stack.getMetadata() == 7)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.7.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.7.2"));
		}
		if(stack.getMetadata() == 8)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.8.1") + " +25%");
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.8.2"));
		}
		if(stack.getMetadata() == 9)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.9.1") + " +50%");
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.9.2") + " -25%");//Really 30%
		}
		if(stack.getMetadata() == 10)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.10.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.10.2"));//Really 30%
		}
		if(stack.getMetadata() == 11)
		{
			toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.module.#"));
			toolTip.add(" ");
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.module.11.1"));
			toolTip.add(TextFormatting.RED + I18n.translateToLocal("vc.item.tt.module.11.2"));//Really 30%
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
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
        	itemName = I18n.translateToLocal("vc.item.module.0");
        }
        else
        {
        	itemName = I18n.translateToLocal("vc.item.module.#") + " - " + EntityAirshipBaseVC.Module.byId(this.getMetadata(stack)).getLocalizedName();
        }
		
		return itemName;
    }
	
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
		if (isInCreativeTab(tab)) {
			final List<ItemStack> items = Stream.of(EntityAirshipBaseVC.Module.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

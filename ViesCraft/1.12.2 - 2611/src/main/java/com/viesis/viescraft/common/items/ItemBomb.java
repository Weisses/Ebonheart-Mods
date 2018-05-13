package com.viesis.viescraft.common.items;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBomb extends Item {
	
	public ItemBomb() 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        this.setMaxStackSize(64);
		
        ItemHelper.setItemName(this, "item_bomb");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			tooltip.add(References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.0.1"));
			tooltip.add(References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.0.2"));
			tooltip.add("");
			tooltip.add(References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.0.3"));
		}
		else if(stack.getMetadata() == 1)
		{
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.1.1"));
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.1.2"));
			tooltip.add("");
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.1.3"));
		}
		else if(stack.getMetadata() == 2)
		{
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.2.1"));
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.2.2"));
			tooltip.add("");
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.2.3"));
		}
		else if(stack.getMetadata() == 3)
		{
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.3.1"));
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.3.2"));
			tooltip.add("");
			tooltip.add(TextFormatting.GOLD + References.Old_I18n.translateToLocalFormatted("vc.item.tt.bomb.3.3"));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String colorName = TextFormatting.WHITE + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_casing.name");
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_casing.name");
			case 1:
				return colorName = TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_small.name");
			case 2:
				return colorName = TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_big.name");
			case 3:
				return colorName = TextFormatting.YELLOW + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_scatter.name");
			default:
				return colorName = TextFormatting.WHITE + References.Old_I18n.translateToLocalFormatted("item.vc:item_bomb_casing.name");
		}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.Bombs.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

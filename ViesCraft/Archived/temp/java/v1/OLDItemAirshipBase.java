package com.viesis.viescraft.common.items.airshipitems.v1;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;

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

public class OLDItemAirshipBase extends Item {
	
	public OLDItemAirshipBase()
	{
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getSpeed() * 100;
		String speedMod = df.format(speedModCal);
		TextFormatting stringColor = TextFormatting.GRAY;
		/**
		if(stack.hasTagCompound())
        {
			if(stack.getTagCompound().getBoolean("FrameVisualActive") == true)
			{
				tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.5") + " " + EnumsVC.AirshipTier.byId(
						stack.getTagCompound().getInteger("FrameVisual")).getName());
			}
			else
			{
				tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.6"));
			}
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.7") + " " + ColorHelperVC.getColorNameFromRgb(
					stack.getTagCompound().getInteger("ColorRed"), 
					stack.getTagCompound().getInteger("ColorGreen"), 
					stack.getTagCompound().getInteger("ColorBlue")));
			tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.8") + " " + EnumsVC.AirshipBalloon.byId(
					stack.getTagCompound().getInteger("Balloon")).getName());
			
        }
        else
        {
        	tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.9"));
        	tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.10"));
        	tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.11"));
        }
		
		if(this.getMetadata(stack) <= 7)
		{
			stringColor = TextFormatting.GRAY;
		}
		else if(this.getMetadata(stack) <= 14)
		{
			stringColor = TextFormatting.GOLD;
		}
		else if(this.getMetadata(stack) <= 20)
		{
			stringColor = TextFormatting.DARK_AQUA;
		}
		else if(this.getMetadata(stack) <= 25)
		{
			stringColor = TextFormatting.DARK_PURPLE;
		}
		else if(this.getMetadata(stack) == 26
		|| this.getMetadata(stack) == 27
		|| this.getMetadata(stack) == 28
		|| this.getMetadata(stack) == 29)
		{
			stringColor = TextFormatting.DARK_RED;
		}
		
		tooltip.add("");
		tooltip.add(stringColor + I18n.translateToLocal("vc.item.tt.airship.1") + " " + TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.2") + stringColor + " " + I18n.translateToLocal("vc.item.tt.airship.3"));
		tooltip.add(stringColor + I18n.translateToLocal("vc.item.tt.airship.4"));
		tooltip.add("");
		
		if(this.getMetadata(stack) <= 5)
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+0.0");
		}
		else if(this.getMetadata(stack) == 15)
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+1.0");
		}
		else if(this.getMetadata(stack) == 25)
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+2.0");
		}
		else if(this.getMetadata(stack) == 27
		|| this.getMetadata(stack) == 28
		|| this.getMetadata(stack) == 29)
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+3.0");
		}
		else
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+" + speedMod);
		}
		
		if(this.getMetadata(stack) >= 25)
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.2") + " " + stringColor + I18n.translateToLocal("vc.item.tt.airship.#.3"));
		}
		else
		{
			tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.2") + " " + stringColor + df.format(EnumsVC.AirshipTier.byId(this.getMetadata(stack)).getElevation()));
		}*/
		
		tooltip.add(TextFormatting.RED + "THIS AIRSHIP IS OLD AND OUTDATED!");
		tooltip.add(TextFormatting.RED + "WILL BE REMOVED NEXT UPDATE!");
		tooltip.add("");
		tooltip.add(TextFormatting.LIGHT_PURPLE + "Maybe someone should place");
		tooltip.add(TextFormatting.LIGHT_PURPLE + "this in a crafting table?!");
		tooltip.add("");
		tooltip.add(TextFormatting.WHITE + "Converts to a new Frame 'Tier'");
		tooltip.add(TextFormatting.WHITE + "airship of equivalent value.");
		
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            	return EnumRarity.COMMON;
            
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            	return EnumRarity.UNCOMMON;
            
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            	return EnumRarity.RARE;
            
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            	return EnumRarity.EPIC;
            
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EntityAirshipBaseVC.FrameCore.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

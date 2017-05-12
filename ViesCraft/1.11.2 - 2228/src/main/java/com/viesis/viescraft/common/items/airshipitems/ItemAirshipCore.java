package com.viesis.viescraft.common.items.airshipitems;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipCore extends Item {
	
	public ItemAirshipCore()
	{
		this.setMaxStackSize(1);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getSpeed() * 100;
		String speedMod = df.format(speedModCal);
		TextFormatting stringColor = TextFormatting.GRAY;
		
		if(stack.hasTagCompound())
        {
			if(stack.getTagCompound().getBoolean("FrameVisualActive") == true)
			{
				toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.5") + " " + EntityAirshipBaseVC.FrameCore.byId(
						stack.getTagCompound().getInteger("FrameVisual")).getName());
			}
			else
			{
				toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.6"));
			}
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.7") + " " + ColorHelperVC.getColorNameFromRgb(
					stack.getTagCompound().getInteger("ColorRed"), 
					stack.getTagCompound().getInteger("ColorGreen"), 
					stack.getTagCompound().getInteger("ColorBlue")));
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.8") + " " + EntityAirshipBaseVC.Balloon.byId(
					stack.getTagCompound().getInteger("Balloon")).getName());
			
        }
        else
        {
        	toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.9"));
        	toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.10"));
        	toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.11"));
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
		else if(this.getMetadata(stack) == 26)
		{
			stringColor = TextFormatting.DARK_RED;
		}
		
		toolTip.add("");
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.airship.1") + " " + TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.2") + stringColor + " " + I18n.translateToLocal("vc.item.tt.airship.3"));
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.airship.4"));
		toolTip.add("");
		
		if(this.getMetadata(stack) <= 5)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+0.0");
		}
		else if(this.getMetadata(stack) == 15)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+1.0");
		}
		else if(this.getMetadata(stack) == 25)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+2.0");
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.1") + " " + stringColor + "+" + speedMod);
		}
		
		if(this.getMetadata(stack) >= 25)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.2") + " " + stringColor + I18n.translateToLocal("vc.item.tt.airship.#.3"));
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.airship.#.2") + " " + stringColor + df.format(EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getElevation()));
		}
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
            	return EnumRarity.EPIC;
            
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.FrameCore contents : EntityAirshipBaseVC.FrameCore.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

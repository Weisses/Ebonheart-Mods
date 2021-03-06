package com.viesis.viescraft.common.items.airshipitems;

import java.util.List;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;

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
		if(stack.hasTagCompound())
        {
			toolTip.add(TextFormatting.GREEN + "Color : " + ColorHelperVC.getColorNameFromRgb(
					stack.getTagCompound().getInteger("ColorRed"), 
					stack.getTagCompound().getInteger("ColorGreen"), 
					stack.getTagCompound().getInteger("ColorBlue")));
			toolTip.add(TextFormatting.GREEN + "Pattern : " + EntityAirshipBaseVC.Balloon.byId(stack.getTagCompound().getInteger("Balloon")).getName());
        }
        else
        {
        	toolTip.add(TextFormatting.GREEN + "Color : Tan");
        	toolTip.add(TextFormatting.GREEN + "Pattern : Plain");
        }
		
		toolTip.add("");
		toolTip.add(TextFormatting.DARK_PURPLE + "Hold " + TextFormatting.WHITE + "[Shift + Right-Click]" + TextFormatting.DARK_PURPLE + " to throw this");
		toolTip.add(TextFormatting.DARK_PURPLE + "item and unleash the airship within.");
		toolTip.add("");
		toolTip.add(TextFormatting.DARK_PURPLE + "No assembly required!");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Frame contents : EntityAirshipBaseVC.Frame.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

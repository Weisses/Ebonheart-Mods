package com.ebonheart.EbonArtsMod.common.items.resources.gemstones;

import java.util.List;

import com.ebonheart.EbonArtsMod.api.EnumEA.GemstoneTypeItemV1;
import com.ebonheart.EbonArtsMod.api.EnumEA.RegistryType;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemGemstoneDenseV1 extends Item {
	
	public ItemGemstoneDenseV1() 
	{
		ItemHelper.setItemName(this, "gemstone/dense/item_dense");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		TextFormatting textInput = TextFormatting.GRAY;
		
		switch(stack.getMetadata())
		{
			case 0: 
				textInput = TextFormatting.GRAY;
				break;
			case 1: 
				textInput = TextFormatting.GOLD;
				break;
			case 2: 
				textInput = TextFormatting.GOLD;
				break;
			case 3: 
				textInput = TextFormatting.DARK_AQUA;
				break;
			case 4: 
				textInput = TextFormatting.DARK_AQUA;
				break;
			case 5: 
				textInput = TextFormatting.DARK_PURPLE;
				break;
			case 6: 
				textInput = TextFormatting.DARK_AQUA;
				break;
			case 7: 
				textInput = TextFormatting.DARK_PURPLE;
				break;
			case 8: 
				textInput = TextFormatting.DARK_PURPLE;
				break;
		}
		
		toolTip.add(textInput +  "A compact gem used to create");
		toolTip.add(textInput +  "powerful items.");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return GemstoneTypeItemV1.byMetadata(this.getMetadata(stack)).getEnumRarity();
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (I18n.translateToLocal("ea.item.dense") + " " + 
        		GemstoneTypeItemV1.byMetadata(this.getMetadata(stack)).getLocalizedName() 
        		+ " " + I18n.translateToLocal("ea.item.gemstone"));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	for (GemstoneTypeItemV1 contents : GemstoneTypeItemV1.values()) 
    	{
			if(contents.getRegistryType() == RegistryType.ALL
			|| contents.getRegistryType() == RegistryType.ITEMONLY)
			{
	    		int meta = contents.getMetadata();
				ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
				subItems.add(subItemStack);
			}
    	}
    }
}

package com.viesis.gemstones.common.items.resources.gemstones;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.gemstones.api.VGEnum.GemstoneTypeItemV1;
import com.viesis.gemstones.api.VGEnum.RegistryType;
import com.viesis.gemstones.common.items.ItemHelper;

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

public class ItemGemstoneEnchantedV1 extends Item {
	
	public ItemGemstoneEnchantedV1() 
	{
		ItemHelper.setItemName(this, "gemstone/enchanted/item_enchanted");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> toolTip, ITooltipFlag flagIn)
	{
		TextFormatting textInput = TextFormatting.DARK_PURPLE;
		
		toolTip.add(textInput +  "An enchanted gem used to create");
		toolTip.add(textInput +  "powerful items.");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.EPIC;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (I18n.translateToLocal("vg.item.enchanted") + " " + 
        		GemstoneTypeItemV1.byMetadata(this.getMetadata(stack)).getLocalizedName() 
        		+ " " + I18n.translateToLocal("vg.item.gemstone"));
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items)
    {
        if (this.isInCreativeTab(tab))
        {
	    	for (GemstoneTypeItemV1 contents : GemstoneTypeItemV1.values()) 
	    	{
				if(contents.getRegistryType() == RegistryType.ALL
				|| contents.getRegistryType() == RegistryType.ITEMONLY)
				{
		    		int meta = contents.getMetadata();
					ItemStack subItemStack = new ItemStack(this, 1, meta);
					items.add(subItemStack);
				}
	    	}
        }
    }
}

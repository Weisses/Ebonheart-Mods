package com.viesis.gemstones.common.items.resources.gemstones;

import java.util.List;

import com.viesis.gemstones.api.VGEnum.GemstoneTypeItemV1;
import com.viesis.gemstones.api.VGEnum.RegistryType;
import com.viesis.gemstones.common.items.ItemHelper;

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

public class ItemGemstoneBasicV1 extends Item {
	
	public ItemGemstoneBasicV1() 
	{
		ItemHelper.setItemName(this, "gemstone/regular/item_regular");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		switch(stack.getMetadata())
		{
			case 0: 
				toolTip.add(TextFormatting.GOLD + "This gemstone consists of little");
				toolTip.add(TextFormatting.GOLD + "shiny imperfections.");
				break;
			case 1: 
				toolTip.add(TextFormatting.GOLD + "A subtle chill emanates from");
				toolTip.add(TextFormatting.GOLD + "the core of this gemstone.");
				break;
			case 2: 
				toolTip.add(TextFormatting.GOLD + "Sharp, slate like gemstone that");
				toolTip.add(TextFormatting.GOLD + "is stronger than Iron.");
				break;
			case 3: 
				toolTip.add(TextFormatting.GOLD + "This gemstone gives off a steady");
				toolTip.add(TextFormatting.GOLD + "wave of warmth when held.");
				break;
			case 4: 
				toolTip.add(TextFormatting.GOLD + "Death and decay flows from");
				toolTip.add(TextFormatting.GOLD + "this cursed gemstone.");
				break;
			case 5: 
				toolTip.add(TextFormatting.GOLD + "Angelic power radiates from");
				toolTip.add(TextFormatting.GOLD + "this divine gemstone.");
				break;
			case 6: 
				toolTip.add(TextFormatting.GOLD + "This gemstone feels much heavier");
				toolTip.add(TextFormatting.GOLD + "than it looks.");
				break;
			case 7: 
				toolTip.add(TextFormatting.GOLD + "Ender energy has been infused");
				toolTip.add(TextFormatting.GOLD + "in this gemstone.");
				break;
			case 8: 
				toolTip.add(TextFormatting.GOLD + "Lost knowledge has been forever");
				toolTip.add(TextFormatting.GOLD + "trapped in this gemstone.");
				break;
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return GemstoneTypeItemV1.byMetadata(this.getMetadata(stack)).getEnumRarity();
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (GemstoneTypeItemV1.byMetadata(this.getMetadata(stack)).getLocalizedName() 
        		+ " " + I18n.translateToLocal("vg.item.gemstone"));
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

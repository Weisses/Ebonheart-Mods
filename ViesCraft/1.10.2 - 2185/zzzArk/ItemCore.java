package com.viesis.viescraft.common.items.parts;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemCore extends Item {
	
	public ItemCore() 
	{
		ItemHelper.setItemName(this, "cores/airship_core");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.AirshipTier.byId(this.getMetadata(stack)).getSpeed() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColor = TextFormatting.GRAY;
		
		if(this.getMetadata(stack) == 0)
		{
			stringColor = TextFormatting.GRAY;
		}
		if(this.getMetadata(stack) == 1)
		{
			stringColor = TextFormatting.GOLD;
		}
		if(this.getMetadata(stack) == 2)
		{
			stringColor = TextFormatting.DARK_AQUA;
		}
		if(this.getMetadata(stack) == 3)
		{
			stringColor = TextFormatting.DARK_PURPLE;
		}
		if(this.getMetadata(stack) == 4)
		{
			stringColor = TextFormatting.DARK_RED;
		}
		
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.core.1")+" " + stringColor + I18n.translateToLocal("vc.item.tt.core.2"));
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.core.3"));
		toolTip.add("");
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.core.4"));
		toolTip.add("");
		
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.core.5") + " " + stringColor + "+" + speedMod);
		
		if(this.getMetadata(stack) >= 4)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.core.6") + " " + stringColor + I18n.translateToLocal("vc.item.tt.core.7"));
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.core.6") + " " + stringColor + df.format(EnumsVC.AirshipTier.byId(this.getMetadata(stack)).getElevation()));
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
            case 0:
            	return EnumRarity.COMMON;
            case 1:
            	return EnumRarity.UNCOMMON;
            case 2:
            	return EnumRarity.RARE;
            case 3:
            	return EnumRarity.EPIC;
            case 4:
            	return EnumRarity.EPIC;
            
            default:
            	return EnumRarity.COMMON;
        }
    }
	/**
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		//ItemStack itemstack = player.getHeldItemMainhand();
        
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
				
				if(airship.metaAirshipTier < this.getMetadata(stack))
				{
					airship.metaAirshipTier = this.getMetadata(stack);
					player.addStat(InitAchievementsVC.airship_create_color);
					
					if (!player.capabilities.isCreativeMode)
                    {
						player.inventory.decrStackSize(player.inventory.currentItem, 1);
                    }
					return true;
				}
				return true;
			}
			return true;
        }
        return false;
    }
	*/
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (EnumsVC.AirshipTier.byId(this.getMetadata(stack)).getLocalizedName() + " " 
        		+ I18n.translateToLocal("vc.item.core"));
    }
	
	//@SideOnly(Side.CLIENT)
	//@Override
    //public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    //{
    //	for (EnumsVC.AirshipTier contents : EnumsVC.AirshipTier.values()) 
    //	{
	//		int meta = contents.getMetadata();
	//		ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
	//		subItems.add(subItemStack);
    //	}
    //}
}

package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFrame extends Item {
	
	public ItemFrame() 
	{
		ItemHelper.setItemName(this, "airship_frame");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		TextFormatting stringColor = TextFormatting.GRAY;
		
		if(this.getMetadata(stack) == 0
		|| this.getMetadata(stack) == 1
		|| this.getMetadata(stack) == 11)
		{
			stringColor = TextFormatting.GRAY;
		}
		if(this.getMetadata(stack) == 2
		|| this.getMetadata(stack) == 3
		|| this.getMetadata(stack) == 4
		|| this.getMetadata(stack) == 12)
		{
			stringColor = TextFormatting.GOLD;
		}
		if(this.getMetadata(stack) == 5
		|| this.getMetadata(stack) == 6
		|| this.getMetadata(stack) == 7)
		{
			stringColor = TextFormatting.DARK_AQUA;
		}
		if(this.getMetadata(stack) == 8
		|| this.getMetadata(stack) == 9
		|| this.getMetadata(stack) == 10
		|| this.getMetadata(stack) == 13)
		{
			stringColor = TextFormatting.DARK_PURPLE;
		}
		
		toolTip.add(TextFormatting.WHITE + "[Shift + Left-Click]" + stringColor + " on an");
		toolTip.add(stringColor + "airship to change the frame.");
		toolTip.add("");
		toolTip.add(stringColor + "Also used in crafting recipes.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
            case 0:
            	return EnumRarity.COMMON;
            case 1:
            	return EnumRarity.COMMON;
            case 2:
            	return EnumRarity.UNCOMMON;
            case 3:
            	return EnumRarity.UNCOMMON;
            case 4:
            	return EnumRarity.UNCOMMON;
            case 5:
            	return EnumRarity.RARE;
            case 6:
            	return EnumRarity.RARE;
            case 7:
            	return EnumRarity.RARE;
            case 8:
            	return EnumRarity.EPIC;
            case 9:
            	return EnumRarity.EPIC;
            case 10:
            	return EnumRarity.EPIC;
            case 11:
            	return EnumRarity.COMMON;
            case 12:
            	return EnumRarity.UNCOMMON;
            case 13:
            	return EnumRarity.RARE;
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		ItemStack itemstack = player.getHeldItemMainhand();
        
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
				
				if(airship.metaFrame != this.getMetadata(stack))
				{
					airship.metaFrame = this.getMetadata(stack);
					player.addStat(InitAchievementsVC.airship_create_color);
					
					if (!player.capabilities.isCreativeMode)
                    {
						itemstack.shrink(1);
                    }
					return true;
				}
				return true;
			}
			return true;
        }
        return false;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (EntityAirshipBaseVC.Frame.byId(this.getMetadata(stack)).getName() + " " 
        		+ "Airship Frame");
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

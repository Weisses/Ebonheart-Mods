package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPaint extends Item {
	
	public ItemPaint() 
	{
		ItemHelper.setItemName(this, "item_paint");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		if(this.getMetadata(stack) == 0)
		{
			toolTip.add(TextFormatting.WHITE + "[Shift + Left-Click]" + TextFormatting.GOLD + " on an");
			toolTip.add(TextFormatting.GOLD + "airship to remove paint.");
			toolTip.add("");
			toolTip.add(TextFormatting.GOLD + "Returns an empty bucket!");
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + "[Shift + Left-Click]" + TextFormatting.GOLD + " on an");
			toolTip.add(TextFormatting.GOLD + "airship to paint it.");
			toolTip.add("");
			toolTip.add(TextFormatting.GOLD + "Returns an empty bucket!");
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
		
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				if(this.getMetadata(stack) == 0)
				{
					if(airship.metaColor != 0)
					{
						airship.metaColor = 0;
						
						if (!player.capabilities.isCreativeMode)
	                    {
							player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
	                    }
						return true;
					}
					return true;
				}
				else
				{
					if(airship.metaColor == 0)
					{
						airship.metaColor = this.getMetadata(stack);
						player.addStat(InitAchievementsVC.airship_create_color);
						
						if (!player.capabilities.isCreativeMode)
	                    {
							player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(Items.BUCKET));
	                    }
						return true;
					}
					return true;
				}
			}
			return true;
        }
        return false;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		if(this.getMetadata(stack) == 0)
		{
			return ("Airship Paint Remover");
		}
		else
		{
			return (EntityAirshipBaseVC.Color.byId(this.getMetadata(stack)).getName() + " Airship Paint");
		}
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Color contents : EntityAirshipBaseVC.Color.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

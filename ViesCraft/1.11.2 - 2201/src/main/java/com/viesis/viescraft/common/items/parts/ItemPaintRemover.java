package com.viesis.viescraft.common.items.parts;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemPaintRemover extends Item {
	
	public ItemPaintRemover() 
	{
		ItemHelper.setItemName(this, "item_paint_remover");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.WHITE + "[Shift + Left-Click]" + TextFormatting.GOLD + " on an");
		toolTip.add(TextFormatting.GOLD + "airship to remove paint.");
		toolTip.add("");
		toolTip.add(TextFormatting.GOLD + "Returns an empty bucket!");
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
			return true;
        }
        return false;
    }
}

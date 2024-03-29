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

public class ItemBalloonPattern extends Item {
	
	public ItemBalloonPattern() 
	{
		ItemHelper.setItemName(this, "patterns/airship_balloon_pattern");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		TextFormatting stringColor = TextFormatting.GOLD;
		
		toolTip.add(TextFormatting.WHITE + "[Shift + Left-Click]" + stringColor + " on an");
		toolTip.add(stringColor + "airship to change the balloon pattern.");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
            default:
            	return EnumRarity.UNCOMMON;
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
				
				if(airship.metaBalloon != this.getMetadata(stack))
				{
					airship.metaBalloon = this.getMetadata(stack);
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
        return (EntityAirshipBaseVC.Balloon.byId(this.getMetadata(stack)).getName() + " " 
        		+ "Balloon Pattern");
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Balloon contents : EntityAirshipBaseVC.Balloon.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

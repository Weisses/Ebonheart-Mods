package com.viesis.viescraft.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OLDItemColorizerBalloon extends Item {
	
	public OLDItemColorizerBalloon() 
	{
		ItemHelper.setItemName(this, "item_balloon_colorizer");
		
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		//this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	/**
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
				
				if(stack.hasTagCompound())
				{
					airship.metaBalloonColorRed = stack.getTagCompound().getInteger("ColorRed");
					airship.metaBalloonColorGreen = stack.getTagCompound().getInteger("ColorGreen");
					airship.metaBalloonColorBlue = stack.getTagCompound().getInteger("ColorBlue");
					
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
        return true;
    }*/
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		
		tooltip.add(TextFormatting.RED + "NOT USED. WILL BE REMOVED NEXT UPDATE!");
		
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	/**
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
    	if(playerIn.isSneaking())
    	{
    		if(worldIn.isRemote)
    		{
        		Minecraft.getMinecraft().displayGuiScreen(new GuiItemBalloonColorizer(playerIn, itemstack));
			}
        	return new ActionResult(EnumActionResult.SUCCESS, itemstack);
        }
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	*/
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return ("OLD " + I18n.translateToLocal("vc.item.colorizer"));
    }
}

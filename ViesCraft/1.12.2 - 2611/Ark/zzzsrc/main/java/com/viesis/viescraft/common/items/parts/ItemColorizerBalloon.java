package com.viesis.viescraft.common.items.parts;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.client.gui.GuiItemBalloonColorizer;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemColorizerBalloon extends Item {
	
	public ItemColorizerBalloon() 
	{
		ItemHelper.setItemName(this, "item_balloon_colorizer");
		
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
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
					airship.metaColorRed = stack.getTagCompound().getInteger("ColorRed");
					airship.metaColorGreen = stack.getTagCompound().getInteger("ColorGreen");
					airship.metaColorBlue = stack.getTagCompound().getInteger("ColorBlue");
					
					//player.addStat(InitAchievementsVC.airship_create_color);
					
					if (!player.capabilities.isCreativeMode)
                    {
						stack.shrink(1);
                    }
					return true;
				}
				return true;
			}
			return true;
        }
        return true;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> toolTip, ITooltipFlag flagIn)
    {
		if(stack.hasTagCompound())
        {
			toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.colorizer.7") + " " + TextFormatting.GREEN + ColorHelperVC.getColorNameFromRgb(
					stack.getTagCompound().getInteger("ColorRed"), 
					stack.getTagCompound().getInteger("ColorGreen"), 
					stack.getTagCompound().getInteger("ColorBlue")));
        }
		else
        {
        	toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.colorizer.8"));
        }
		
		toolTip.add("");
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.colorizer.1") + " " + TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.colorizer.2"));
		toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.colorizer.3"));
		toolTip.add("");
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.colorizer.4") + " " + TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.colorizer.5"));
		toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.colorizer.6"));
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        
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
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return (I18n.translateToLocal("vc.item.colorizer"));
    }
}

package com.viesis.viescraft.common.items.parts;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.client.util.ITooltipFlag;
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
		ItemHelper.setItemName(this, "frames/airship_frame");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> toolTip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getSpeed() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColor = TextFormatting.GRAY;
		
		if(this.getMetadata(stack) == 0
		|| this.getMetadata(stack) == 1
		|| this.getMetadata(stack) == 2
		|| this.getMetadata(stack) == 3
		|| this.getMetadata(stack) == 4
		|| this.getMetadata(stack) == 5
		|| this.getMetadata(stack) == 6
		|| this.getMetadata(stack) == 7)
		{
			stringColor = TextFormatting.GRAY;
		}
		if(this.getMetadata(stack) == 8
		|| this.getMetadata(stack) == 9
		|| this.getMetadata(stack) == 10
		|| this.getMetadata(stack) == 11
		|| this.getMetadata(stack) == 12
		|| this.getMetadata(stack) == 13
		|| this.getMetadata(stack) == 14)
		{
			stringColor = TextFormatting.GOLD;
		}
		if(this.getMetadata(stack) == 15
		|| this.getMetadata(stack) == 16
		|| this.getMetadata(stack) == 17
		|| this.getMetadata(stack) == 18
		|| this.getMetadata(stack) == 19
		|| this.getMetadata(stack) == 20)
		{
			stringColor = TextFormatting.DARK_AQUA;
		}
		if(this.getMetadata(stack) == 21
		|| this.getMetadata(stack) == 22
		|| this.getMetadata(stack) == 23
		|| this.getMetadata(stack) == 24
		|| this.getMetadata(stack) == 25)
		{
			stringColor = TextFormatting.DARK_PURPLE;
		}
		if(this.getMetadata(stack) == 26
		|| this.getMetadata(stack) == 27
		|| this.getMetadata(stack) == 28
		|| this.getMetadata(stack) == 29)
		{
			stringColor = TextFormatting.DARK_RED;
		}
		
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.1")+" " + stringColor + I18n.translateToLocal("vc.item.tt.frame.2"));
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.frame.3"));
		toolTip.add("");
		toolTip.add(stringColor + I18n.translateToLocal("vc.item.tt.frame.4"));
		toolTip.add("");
		
		if(this.getMetadata(stack) <= 5)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.5") + " " + stringColor + "+0.0");
		}
		else if(this.getMetadata(stack) == 15)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.5") + " " + stringColor + "+1.0");
		}
		else if(this.getMetadata(stack) == 25)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.5") + " " + stringColor + "+2.0");
		}
		else if(this.getMetadata(stack) == 27
		|| this.getMetadata(stack) == 28
		|| this.getMetadata(stack) == 29)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.5") + " " + stringColor + "+3.0");
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.5") + " " + stringColor + "+" + speedMod);
		}
		
		if(this.getMetadata(stack) >= 21)
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.6") + " " + stringColor + I18n.translateToLocal("vc.item.tt.frame.7"));
		}
		else
		{
			toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.frame.6") + " " + stringColor + df.format(EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getElevation()));
		}
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            	return EnumRarity.COMMON;
            
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            	return EnumRarity.UNCOMMON;
            
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            	return EnumRarity.RARE;
            
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            	return EnumRarity.EPIC;
            
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		//ItemStack itemstack = player.getHeldItemMainhand();
        
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
				
				if(airship.metaFrameCore < this.getMetadata(stack))
				{
					airship.metaFrameCore = this.getMetadata(stack);
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
        return false;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (EntityAirshipBaseVC.FrameCore.byId(this.getMetadata(stack)).getLocalizedName() + " " 
        		+ I18n.translateToLocal("vc.item.frame"));
    }
	
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) {
		if (isInCreativeTab(tab)) {
			final List<ItemStack> items = Stream.of(EntityAirshipBaseVC.FrameCore.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

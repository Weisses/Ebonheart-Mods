package com.viesis.viescraft.common.items.parts.main;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemLogicChip extends Item {
	
	public ItemLogicChip() 
	{
		ItemHelper.setItemName(this, "item_logic_chip");
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.MainTierFrame.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		TextFormatting stringColorMain = TextFormatting.WHITE;
		TextFormatting stringColorText = TextFormatting.GRAY;
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(References.localNameVC("vc.item.tt.logicchip.1"));
		tooltip.add(References.localNameVC("vc.item.tt.logicchip.2"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
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
}

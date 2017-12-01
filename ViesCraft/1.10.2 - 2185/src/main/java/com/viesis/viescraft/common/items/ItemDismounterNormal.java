package com.viesis.viescraft.common.items;

import java.util.List;

import com.viesis.viescraft.ViesCraft;

import net.minecraft.util.text.translation.I18n;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDismounterNormal extends Item {
	
	public ItemDismounterNormal() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_dismounter_normal");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.dismounternormal.1") + " " + TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounternormal.2"));
		toolTip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounternormal.3"));
		toolTip.add(TextFormatting.GRAY + "");
		toolTip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounternormal.4"));
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		ItemStack itemstack = player.getHeldItemMainhand();
        
		if (!(entity instanceof EntityPlayer)
		&& (entity.getRidingEntity() != null))
        {
			if (!player.capabilities.isCreativeMode)
            {
				itemstack.damageItem(1, player);
            }
        	entity.dismountRidingEntity();
        	
            return true;
        }
        return true;
    }
}

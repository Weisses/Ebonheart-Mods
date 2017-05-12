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

public class ItemAirshipDismounter extends Item {
	
	public ItemAirshipDismounter() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_airship_dismounter");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.dismounter.1") + " " + TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.dismounter.2"));
		toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.dismounter.3"));
		toolTip.add(TextFormatting.GREEN + "");
		toolTip.add(TextFormatting.GOLD + I18n.translateToLocal("vc.item.tt.dismounter.4"));
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

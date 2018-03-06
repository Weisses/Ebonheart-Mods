package com.viesis.viescraft.common.items;

import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDismounterPlayer extends Item {
	
	public ItemDismounterPlayer() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_dismounter_player");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }
	
	@Override
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, IBlockState state, BlockPos pos, EntityLivingBase entityLiving)
    {
        stack.damageItem(1, entityLiving);
        return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if (entity.world.isRemote)
        {
            return false;
        }
        
        if (entity.getRidingEntity() != null)
        {
        	itemstack.damageItem(1, entity);
        	
        	entity.dismountRidingEntity();
        	
            return true;
        }
        
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.WHITE + I18n.translateToLocal("vc.item.tt.dismounterplayer.1") + " " + TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounterplayer.2"));
		tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounterplayer.3"));
		tooltip.add(TextFormatting.GRAY + "");
		tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("vc.item.tt.dismounterplayer.4"));
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.COMMON;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        String colorName = TextFormatting.WHITE + "Dismounter" + " " 
        		+ TextFormatting.GRAY + "("
        		+ TextFormatting.RED + "Player"
        		+ TextFormatting.GRAY + ")"
        		;
        
        return colorName;
    }
}

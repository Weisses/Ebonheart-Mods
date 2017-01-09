package com.viesis.viescraft.common.items;

import java.util.List;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;

public class ItemAirshipDismounter extends Item {
	
	public ItemAirshipDismounter() 
	{
		this.setMaxStackSize(1);
		this.setMaxDamage(25);
		ItemHelper.setItemName(this, "item_airship_dismounter");
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
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
        if (!(entity instanceof EntityPlayer)
        && (entity.getRidingEntity() != null))
        {
        	itemstack.damageItem(1, entity);
        	
        	entity.dismountRidingEntity();
        	
            return true;
        }
        return false;
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.WHITE + "[Right-Click]" + TextFormatting.GREEN + " a mounted entity");
		toolTip.add(TextFormatting.GREEN + "to safely dismount it.");
	}
}

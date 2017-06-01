package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.resources;

import java.util.List;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.entity.EntityEnchantedEbonheart;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityExpBottle;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEnchantedEbonheart extends Item {
	
	public ItemEnchantedEbonheart() 
	{
		ItemHelper.setItemName(this, "gem/enchanted_ebonheart");
		this.setMaxStackSize(16);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "A powerful item containing ancient knowledge.");
		toolTip.add(TextFormatting.DARK_AQUA + "Hold " + TextFormatting.WHITE + "[Shift + Right-Click]" + TextFormatting.DARK_AQUA + " to throw this");
		toolTip.add(TextFormatting.DARK_AQUA + "item and unleash the experience within.");
	}
	
	@SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
	
	public ActionResult<ItemStack> onItemRightClick(World itemStackIn, EntityPlayer worldIn, EnumHand playerIn)
    {
		ItemStack itemstack = worldIn.getHeldItem(playerIn);
		
		if(worldIn.isSneaking())
		{
			
	        if (!worldIn.capabilities.isCreativeMode)
	        {
	            itemstack.shrink(1);
	        }
	
	        itemStackIn.playSound((EntityPlayer)null, worldIn.posX, worldIn.posY, worldIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	
				
			if (!itemStackIn.isRemote)
	        {
				EntityEnchantedEbonheart entityexpbottle = new EntityEnchantedEbonheart(itemStackIn, worldIn);
	            entityexpbottle.setHeadingFromThrower(worldIn, worldIn.rotationPitch, worldIn.rotationYaw, -20.0F, 0.7F, 1.0F);
	            itemStackIn.spawnEntity(entityexpbottle);
	        }
	
	        worldIn.addStat(StatList.getObjectUseStats(this));
	        return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
		
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
}

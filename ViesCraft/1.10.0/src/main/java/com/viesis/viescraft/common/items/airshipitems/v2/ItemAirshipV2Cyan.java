package com.viesis.viescraft.common.items.airshipitems.v2;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2Cyan;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCore;

public class ItemAirshipV2Cyan extends ItemAirshipCore {
	
	public ItemAirshipV2Cyan() 
	{
		ItemHelper.setItemName(this, "item_airship_v2_cyan");
		this.setCreativeTab(ViesCraft.tabViesCraftAirships);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		if(playerIn.isSneaking())
		{
			if (!playerIn.capabilities.isCreativeMode)
			{
				--itemStackIn.stackSize;
			}
			
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV2Cyan entityairship = new EntityItemAirshipV2Cyan(worldIn, playerIn);
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
}
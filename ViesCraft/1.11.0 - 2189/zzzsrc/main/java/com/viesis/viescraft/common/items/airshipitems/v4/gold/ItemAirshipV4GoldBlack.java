package com.viesis.viescraft.common.items.airshipitems.v4.gold;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipitems.v4.gold.EntityItemAirshipV4GoldBlack;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCoreV4;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemAirshipV4GoldBlack extends ItemAirshipCoreV4 {
	
	public ItemAirshipV4GoldBlack() 
	{
		ItemHelper.setItemName(this, "v4/gold/item_airship_v4_gold_black");
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		itemstack.func_190918_g(1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV4GoldBlack entityairship = new EntityItemAirshipV4GoldBlack(worldIn, playerIn);
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return ("" + I18n.translateToLocal(Gold + Black + ViesCraftConfig.v4AirshipName)).trim();
    }
}

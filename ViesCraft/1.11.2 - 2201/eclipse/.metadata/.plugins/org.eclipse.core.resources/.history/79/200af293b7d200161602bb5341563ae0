package com.viesis.viescraft.common.items.airshipitems.v3.old;

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
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCore;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemAirshipV3 extends ItemAirshipCore {
	
	public int metaFrameitem;
	public int metaColoritem;
	
	public ItemAirshipV3(String unlocalizedName, int frameIn, int colorIn) 
	{
		this.metaFrameitem = frameIn;
		this.metaColoritem = colorIn;
		
		ItemHelper.setItemName(this, unlocalizedName);
		//this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV3);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		itemstack.shrink(1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV3 entityairship = new EntityItemAirshipV3(worldIn, playerIn, this.metaFrameitem, metaColoritem);
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntity(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (//Reference.AIRSHIP_FRAME[this.metaFrameitem] + " " + Reference.AIRSHIP_COLOR[this.metaColoritem] + " " + 
        		ViesCraftConfig.v3AirshipName).trim();
    }
}

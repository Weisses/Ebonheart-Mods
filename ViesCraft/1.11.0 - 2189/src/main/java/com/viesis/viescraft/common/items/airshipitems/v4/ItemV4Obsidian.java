package com.viesis.viescraft.common.items.airshipitems.v4;

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

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemV4Obsidian;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCore;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemV4Obsidian extends ItemAirshipCore {
	
	public int typeAirshipitem;
	
	public ItemV4Obsidian(String unlocalizedName, int typeIn) 
	{
		this.typeAirshipitem = typeIn;
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV4);
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
				EntityItemV4Obsidian entityairship = new EntityItemV4Obsidian(worldIn, playerIn, this.typeAirshipitem);
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
        return (Reference.OBSIDIAN + ITEM_COLOR[this.typeAirshipitem] + " " + I18n.translateToLocal(ViesCraftConfig.v4AirshipName)).trim();
    }
}
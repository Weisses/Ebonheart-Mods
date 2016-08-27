package com.viesis.viescraft.common.items.airshipitems.v1;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipBlack;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCore;

public class ItemAirshipBlack extends ItemAirshipCore {
	
	public ItemAirshipBlack() 
	{
		ItemHelper.setItemName(this, "item_airship_black");
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
				EntityItemAirshipBlack entityairship = new EntityItemAirshipBlack(worldIn, playerIn);
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
	
	/**
	
	
	
	@Override
	  public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
	    final int FIRST_HOTBAR_SLOT_NUMBER = 0;
	    final int LAST_HOTBAR_SLOT_NUMBER = 8;

	    if (itemSlot < FIRST_HOTBAR_SLOT_NUMBER || itemSlot > LAST_HOTBAR_SLOT_NUMBER) return;
	    if (worldIn.isRemote) return;
	    if (!(entityIn instanceof EntityPlayerMP)) return;
	    EntityPlayerMP entityPlayerMP = (EntityPlayerMP) entityIn;
	    if (entityPlayerMP.interactionManager.getGameType() != WorldSettings.getGameTypeById(0)) {
	      entityPlayerMP.setGameType(WorldSettings.getGameTypeById(0));
	    }
	  }

	  // adds 'tooltip' text
	  @SideOnly(Side.CLIENT)
	  @SuppressWarnings("unchecked")
	  @Override
	  public void addInformation(ItemStack stack, EntityPlayer playerIn, List tooltip, boolean advanced) {
	    tooltip.add("Place the activator in your hotbar");
	    tooltip.add(" to activate the custom HUD.");
	  }
	  */
}

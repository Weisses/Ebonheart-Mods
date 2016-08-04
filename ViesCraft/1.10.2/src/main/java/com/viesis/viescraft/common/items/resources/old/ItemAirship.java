package com.viesis.viescraft.common.items.resources.old;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipNormal;
import com.viesis.viescraft.common.entity.old.EntityItemAirship;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemAirship extends Item {
	
	public ItemAirship() 
	{
		ItemHelper.setItemName(this, "item_airship_base");
		this.setMaxStackSize(1);
		this.setCreativeTab(null);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "Hold " + TextFormatting.WHITE + "[Shift + Right-Click]" + TextFormatting.DARK_PURPLE + " to throw this");
		toolTip.add(TextFormatting.DARK_PURPLE + "item and unleash the airship within.");
		toolTip.add(TextFormatting.DARK_PURPLE + "No assembly required!");
	}
	
	//@SideOnly(Side.CLIENT)
    //public boolean hasEffect(ItemStack stack)
    //{
    //    return true;
    //}
	
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
				EntityItemAirshipNormal entityenchantedebonheart = new EntityItemAirshipNormal(worldIn, playerIn);
				entityenchantedebonheart.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityenchantedebonheart);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
}

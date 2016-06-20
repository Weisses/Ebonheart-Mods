package com.viesis.viescraft.common.items.resources;

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

import com.viesis.viescraft.common.entity.EntityEnchantedEbonheart;
import com.viesis.viescraft.common.items.ItemHelper;

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
				//EntityEnchantedEbonheart
        	
				EntityEnchantedEbonheart entityenchantedebonheart = new EntityEnchantedEbonheart(worldIn, playerIn);
				entityenchantedebonheart.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityenchantedebonheart);
        	
        	//EntityExpBottle entityexpbottle = new EntityExpBottle(worldIn, playerIn);
            //entityexpbottle.func_184538_a(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
            //worldIn.spawnEntityInWorld(entityexpbottle);
			}

			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
	
	//@Override
	//public ItemStack onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn)
    //{
	//	if(playerIn.isSneaking())
	//	{
	//		if (!playerIn.capabilities.isCreativeMode)
	//        {
	//            --stack.stackSize;
	//        }

	//        worldIn.playSoundAtEntity(playerIn, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

	//        if (!worldIn.isRemote)
	//        {
	//            worldIn.spawnEntityInWorld(new EntityEnchantedEbonheart(worldIn, playerIn));
	//        }
	//        return stack;
	//	}
    //    return stack;
    //}
	
	//@Override
	//public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    //{
    //    IBlockState iblockstate = worldIn.getBlockState(pos);

    //    if (iblockstate.getBlock() == Blocks.jukebox && !((Boolean)iblockstate.getValue(BlockJukebox.HAS_RECORD)).booleanValue())
    //    {
    //        if (!worldIn.isRemote)
    //        {
    //            ((BlockJukebox)Blocks.jukebox).insertRecord(worldIn, pos, iblockstate, stack);
    //            worldIn.playAuxSFXAtEntity((EntityPlayer)null, 1010, pos, Item.getIdFromItem(this));
    //            --stack.stackSize;
    //            playerIn.addStat(StatList.recordPlayed);
    //        }

    //        return EnumActionResult.SUCCESS;
    //    }
    //    else
    //    {
    ///        return EnumActionResult.PASS;
    //    }
    //}
	
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
}

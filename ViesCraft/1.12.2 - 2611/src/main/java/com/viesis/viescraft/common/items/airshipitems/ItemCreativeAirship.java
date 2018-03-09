package com.viesis.viescraft.common.items.airshipitems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirship;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemCreativeAirship extends ItemCreativeAirshipBase {
	
	public ItemCreativeAirship(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirship entityairship = new EntityItemAirship(worldIn, playerIn, 
						5, 5, 5, 5,
						0,
						0,
			    		0, false, false,
			    		255, 255, 255,
			    		0,
			    		0, false, false,
			    		200, 180, 140,
			    		true, 3, true, 3, true, 3, 
			    		true, 3, true, 3, true, 3, 
			    		true, 3, true, 3);
				
				entityairship.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
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
		String colorName = TextFormatting.GOLD + "" + TextFormatting.BOLD +  ViesCraftConfig.v1AirshipName;
		
		return colorName 
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ " ("
				+ TextFormatting.BLUE
				+ "C"
				+ TextFormatting.GREEN
				+ "r"
				+ TextFormatting.AQUA
				+ "e"
				+ TextFormatting.RED
				+ "a"
				+ TextFormatting.LIGHT_PURPLE
				+ "t"
				+ TextFormatting.YELLOW
				+ "i"
				+ TextFormatting.WHITE
				+ "v"
				+ TextFormatting.DARK_AQUA
				+ "e"
				+ TextFormatting.DARK_RED + "" + TextFormatting.BOLD
				+ ") ";
    }
}

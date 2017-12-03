package com.viesis.viescraft.common.items.airshipitems.v4;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV4;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.v1.OLDItemAirshipBase;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class OLDItemAirshipV4 extends OLDItemAirshipBase {
	
	public OLDItemAirshipV4(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, unlocalizedName);
		//this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV4);
	}
	/**
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
        int frameVisual = 0;
        boolean frameVisualActive = false;
        
        int balloon = 0;
        int colorRed = 210;
		int colorGreen = 180;
		int colorBlue = 140;
    	
        if(playerIn.isSneaking())
		{
        	if(itemstack.hasTagCompound())
	        {
        		frameVisual = itemstack.getTagCompound().getInteger("FrameVisual"); 
        		frameVisualActive = itemstack.getTagCompound().getBoolean("FrameVisualActive"); 
        		
        		balloon = itemstack.getTagCompound().getInteger("Balloon"); 
        		colorRed = itemstack.getTagCompound().getInteger("ColorRed"); 
				colorGreen = itemstack.getTagCompound().getInteger("ColorGreen"); 
				colorBlue = itemstack.getTagCompound().getInteger("ColorBlue");
	        }
        	
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV4 entityairship = new EntityItemAirshipV4(worldIn, playerIn, this.getMetadata(itemstack), balloon, colorRed, colorGreen, colorBlue, frameVisual, frameVisualActive);
				
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
        
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }*/
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return ("OLD"
            		+ " " 
            		+ ViesCraftConfig.v4AirshipName);
    }
}

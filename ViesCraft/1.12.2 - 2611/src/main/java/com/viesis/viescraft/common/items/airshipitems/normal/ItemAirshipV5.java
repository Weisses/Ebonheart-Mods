package com.viesis.viescraft.common.items.airshipitems.normal;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV5;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipBase;
import com.viesis.viescraft.configs.ViesCraftConfig;

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

public class ItemAirshipV5 extends ItemAirshipBase {
	
	public ItemAirshipV5(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesCraft.tabViesCraftAirships);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
		this.metaModuleVariantSlot1 = 0;
		
		this.metaTierCore = 0;
		this.metaTierEngine = 0;
		this.metaTierBalloon = 0;
		
		this.metaFrameVisual = 0;
		this.metaFrameVisualTransparent = false;
		this.metaFrameVisualColor = false;
		this.metaFrameColorRed = 0;
		this.metaFrameColorGreen = 0;
		this.metaFrameColorBlue = 0;
		
		this.metaBalloonVisual = 0;
		this.metaBalloonVisualTransparent = false;
		this.metaBalloonVisualColor = true;
		this.metaBalloonColorRed = 210;
		this.metaBalloonColorGreen = 180;
		this.metaBalloonColorBlue = 140;
		
		this.learnedModuleAltitude = false;
		this.selectedModuleAltitude = 0;
		this.learnedModuleSpeed = false;
		this.selectedModuleSpeed = 0;
		this.learnedModuleStorage = false;
		this.selectedModuleStorage = 0;
		this.learnedModuleFuel = false;
		this.selectedModuleFuel = 0;
		this.learnedModuleMusic = false;
		this.selectedModuleMusic = 0;
		this.learnedModuleCruise = false;
		this.selectedModuleCruise = 0;
		this.learnedModuleWater = false;
		this.selectedModuleWater = 0;
		this.learnedModuleFuelInfinite = false;
		this.selectedModuleFuelInfinite = 0;
		
        if(playerIn.isSneaking())
		{
        	if(itemstack.hasTagCompound())
	        {
        		this.metaModuleVariantSlot1 = itemstack.getTagCompound().getInteger(rf.META_MODULE_VARIANT_SLOT1_TAG);
        		
        		this.metaTierCore = itemstack.getTagCompound().getInteger(rf.META_TIER_CORE_TAG);
        		this.metaTierEngine = itemstack.getTagCompound().getInteger(rf.META_TIER_ENGINE_TAG);
        		this.metaTierBalloon = itemstack.getTagCompound().getInteger(rf.META_TIER_BALLOON_TAG);
        		
        		this.metaFrameVisual = itemstack.getTagCompound().getInteger(rf.META_FRAME_VISUAL_TAG);
        		this.metaFrameVisualTransparent = itemstack.getTagCompound().getBoolean(rf.META_FRAME_VISUAL_TRANSPARENT_TAG);
        		this.metaFrameVisualColor = itemstack.getTagCompound().getBoolean(rf.META_FRAME_VISUAL_COLOR_TAG);
        		this.metaFrameColorRed = itemstack.getTagCompound().getInteger(rf.META_FRAME_VISUAL_COLOR_RED_TAG);
        		this.metaFrameColorGreen = itemstack.getTagCompound().getInteger(rf.META_FRAME_VISUAL_COLOR_GREEN_TAG);
        		this.metaFrameColorBlue = itemstack.getTagCompound().getInteger(rf.META_FRAME_VISUAL_COLOR_BLUE_TAG);
        		
        		this.metaBalloonVisual = itemstack.getTagCompound().getInteger(rf.META_BALLOON_VISUAL_TAG);
        		this.metaBalloonVisualTransparent = itemstack.getTagCompound().getBoolean(rf.META_BALLOON_VISUAL_TRANSPARENT_TAG);
        		this.metaBalloonVisualColor = itemstack.getTagCompound().getBoolean(rf.META_BALLOON_VISUAL_COLOR_TAG);
        		this.metaBalloonColorRed = itemstack.getTagCompound().getInteger(rf.META_BALLOON_VISUAL_COLOR_RED_TAG);
        		this.metaBalloonColorGreen = itemstack.getTagCompound().getInteger(rf.META_BALLOON_VISUAL_COLOR_GREEN_TAG);
        		this.metaBalloonColorBlue = itemstack.getTagCompound().getInteger(rf.META_BALLOON_VISUAL_COLOR_BLUE_TAG);
        		
        		
        		
        		this.learnedModuleAltitude = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_ALTITUDE_TAG);
        		this.selectedModuleAltitude = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_ALTITUDE_TAG);
        		this.learnedModuleSpeed = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_SPEED_TAG);
        		this.selectedModuleSpeed = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_SPEED_TAG);
        		this.learnedModuleStorage = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_STORAGE_TAG);
        		this.selectedModuleStorage = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_STORAGE_TAG);
        		this.learnedModuleFuel = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_FUEL_TAG);
        		this.selectedModuleFuel = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_FUEL_TAG);
        		this.learnedModuleMusic = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_MUSIC_TAG);
        		this.selectedModuleMusic = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_MUSIC_TAG);
        		this.learnedModuleCruise = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_CRUISE_TAG);
        		this.selectedModuleCruise = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_CRUISE_TAG);
        		this.learnedModuleWater = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_WATER_TAG);
        		this.selectedModuleWater = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_WATER_TAG);
        		this.learnedModuleFuelInfinite = itemstack.getTagCompound().getBoolean(rf.META_LEARNED_MODULE_FUELINFINITE_TAG);
        		this.selectedModuleFuelInfinite = itemstack.getTagCompound().getInteger(rf.META_SELECTED_MODULE_FUELINFINITE_TAG);
	        }
        	
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV5 entityairship = new EntityItemAirshipV5(worldIn, playerIn, 
						this.getMetadata(itemstack), this.metaTierCore, this.metaTierEngine, this.metaTierBalloon,
						this.metaModuleVariantSlot1,
			    		this.metaFrameVisual, this.metaFrameVisualTransparent, this.metaFrameVisualColor, 
			    		this.metaFrameColorRed, this.metaFrameColorGreen, this.metaFrameColorBlue,
			    		this.metaBalloonVisual, this.metaBalloonVisualTransparent, this.metaBalloonVisualColor, 
			    		this.metaBalloonColorRed, this.metaBalloonColorGreen, this.metaBalloonColorBlue,
			    		this.learnedModuleAltitude, this.selectedModuleAltitude, 
			    		this.learnedModuleSpeed, this.selectedModuleSpeed, 
			    		this.learnedModuleStorage, this.selectedModuleStorage, 
			    		this.learnedModuleFuel, this.selectedModuleFuel, 
			    		this.learnedModuleMusic, this.selectedModuleMusic, 
			    		this.learnedModuleCruise, this.selectedModuleCruise, 
			    		this.learnedModuleWater, this.selectedModuleWater, 
			    		this.learnedModuleFuelInfinite, this.selectedModuleFuelInfinite);
				
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
		String colorName = TextFormatting.WHITE + ViesCraftConfig.v5AirshipName;
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.GRAY + "" + TextFormatting.BOLD + ViesCraftConfig.v5AirshipName;
			case 1:
				return colorName = TextFormatting.WHITE + "" + TextFormatting.BOLD + ViesCraftConfig.v5AirshipName;
			case 2:
				return colorName = TextFormatting.YELLOW + "" + TextFormatting.BOLD + ViesCraftConfig.v5AirshipName;
			case 3:
				return colorName = TextFormatting.AQUA + "" + TextFormatting.BOLD + ViesCraftConfig.v5AirshipName;
			case 4:
				return colorName = TextFormatting.LIGHT_PURPLE + "" + TextFormatting.BOLD + ViesCraftConfig.v5AirshipName;
			case 5:
				return colorName = TextFormatting.RED + "" + TextFormatting.BOLD +  ViesCraftConfig.v5AirshipName;
		}
		return colorName;
    }
}

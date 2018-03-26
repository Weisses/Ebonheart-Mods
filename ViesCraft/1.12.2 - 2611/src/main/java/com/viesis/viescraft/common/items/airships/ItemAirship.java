package com.viesis.viescraft.common.items.airships;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.text.DecimalFormat;
import java.util.List;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.EntityThrownAirship;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemAirship extends ItemAirshipBase {
	
	public ItemAirship(String unlocalizedName) 
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
        
		this.customName = "Airship";
		this.storedFuel = 0;
		this.storedFuelTotal = 0;
		this.fuelItemStackSize = 0;
		this.fuelItemStack = 0;
		this.storedRedstone = 0;
		this.storedRedstoneTotal = 500;
		
		this.mainTierCore = 0;
		this.mainTierFrame = 0;
		this.mainTierEngine = 0;
		this.mainTierBalloon = 0;

		this.coreModelVisualFrame = 0;
		this.coreModelVisualEngine = 0;
		this.coreModelVisualBalloon = 0;
		
		this.frameSkinTexture = 0;
		this.frameSkinTransparent = false;
		this.frameSkinColorRed = 255;
		this.frameSkinColorGreen = 255;
		this.frameSkinColorBlue = 255;
		
		this.engineParticleVisual = 0;
		this.engineDisplayTypeVisual = 0;
		this.engineDisplayIDVisual = 0;
		
		this.balloonPatternTexture = 0;
		this.balloonPatternTransparent = false;
		this.balloonPatternColorRed = 200;
		this.balloonPatternColorGreen = 180;
		this.balloonPatternColorBlue = 140;
		
		this.moduleActiveSlot1 = 0;
		
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
		this.learnedModuleBomb = false;
		this.selectedModuleBomb = 0;
		
		this.storedInventory = new NBTTagCompound();
		
        if(playerIn.isSneaking())
		{
        	if(itemstack.hasTagCompound())
        	{
        		this.customName = itemstack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
        		
        		this.storedFuel = itemstack.getTagCompound().getInteger(rf.STORED_FUEL_TAG);
        		this.storedFuelTotal = itemstack.getTagCompound().getInteger(rf.STORED_FUEL_TOTAL_TAG);
        		this.fuelItemStack = itemstack.getTagCompound().getInteger(rf.FUEL_ITEMSTACK_TAG);
        		this.fuelItemStackSize = itemstack.getTagCompound().getInteger(rf.FUEL_ITEMSTACK_SIZE_TAG);
        		this.storedRedstone = itemstack.getTagCompound().getInteger(rf.STORED_REDSTONE_TAG);
        		this.storedRedstoneTotal = itemstack.getTagCompound().getInteger(rf.STORED_REDSTONE_TOTAL_TAG);
        		
        		this.mainTierCore = itemstack.getTagCompound().getInteger(rf.MAIN_TIER_CORE_TAG);
        		this.mainTierFrame = itemstack.getTagCompound().getInteger(rf.MAIN_TIER_FRAME_TAG);
        		this.mainTierEngine = itemstack.getTagCompound().getInteger(rf.MAIN_TIER_ENGINE_TAG);
        		this.mainTierBalloon = itemstack.getTagCompound().getInteger(rf.MAIN_TIER_BALLOON_TAG);
        		
        		this.coreModelVisualFrame = itemstack.getTagCompound().getInteger(rf.CORE_MODEL_VISUAL_FRAME_TAG);
        		this.coreModelVisualEngine = itemstack.getTagCompound().getInteger(rf.CORE_MODEL_VISUAL_ENGINE_TAG);
        		this.coreModelVisualBalloon = itemstack.getTagCompound().getInteger(rf.CORE_MODEL_VISUAL_BALLOON_TAG);
        		
        		this.frameSkinTexture = itemstack.getTagCompound().getInteger(rf.FRAME_SKIN_TEXTURE_TAG);
        		this.frameSkinTransparent = itemstack.getTagCompound().getBoolean(rf.FRAME_SKIN_TRANSPARENT_TAG);
        		this.frameSkinColorRed = itemstack.getTagCompound().getInteger(rf.FRAME_SKIN_COLOR_RED_TAG);
        		this.frameSkinColorGreen = itemstack.getTagCompound().getInteger(rf.FRAME_SKIN_COLOR_GREEN_TAG);
        		this.frameSkinColorBlue = itemstack.getTagCompound().getInteger(rf.FRAME_SKIN_COLOR_BLUE_TAG);
        		
        		this.engineParticleVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_PARTICLE_VISUAL_TAG);
        		this.engineDisplayTypeVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_TYPE_VISUAL_TAG);
        		this.engineDisplayIDVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_ID_VISUAL_TAG);
        		
        		this.balloonPatternTexture = itemstack.getTagCompound().getInteger(rf.BALLOON_PATTERN_TEXTURE_TAG);
        		this.balloonPatternTransparent = itemstack.getTagCompound().getBoolean(rf.BALLOON_PATTERN_TRANSPARENT_TAG);
        		this.balloonPatternColorRed = itemstack.getTagCompound().getInteger(rf.BALLOON_PATTERN_COLOR_RED_TAG);
        		this.balloonPatternColorGreen = itemstack.getTagCompound().getInteger(rf.BALLOON_PATTERN_COLOR_GREEN_TAG);
        		this.balloonPatternColorBlue = itemstack.getTagCompound().getInteger(rf.BALLOON_PATTERN_COLOR_BLUE_TAG);
        		
        		this.moduleActiveSlot1 = itemstack.getTagCompound().getInteger(rf.MODULE_ACTIVE_SLOT1_TAG);
        		
        		this.learnedModuleAltitude = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_ALTITUDE_TAG);
        		this.selectedModuleAltitude = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_ALTITUDE_TAG);
        		this.learnedModuleSpeed = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_SPEED_TAG);
        		this.selectedModuleSpeed = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_SPEED_TAG);
        		this.learnedModuleStorage = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_STORAGE_TAG);
        		this.selectedModuleStorage = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_STORAGE_TAG);
        		this.learnedModuleFuel = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_FUEL_TAG);
        		this.selectedModuleFuel = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_FUEL_TAG);
        		this.learnedModuleMusic = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_MUSIC_TAG);
        		this.selectedModuleMusic = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_MUSIC_TAG);
        		this.learnedModuleCruise = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_CRUISE_TAG);
        		this.selectedModuleCruise = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_CRUISE_TAG);
        		this.learnedModuleWater = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_WATER_TAG);
        		this.selectedModuleWater = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_WATER_TAG);
        		this.learnedModuleFuelInfinite = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_FUELINFINITE_TAG);
        		this.selectedModuleFuelInfinite = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_FUELINFINITE_TAG);
        		this.learnedModuleBomb = itemstack.getTagCompound().getBoolean(rf.LEARNED_MODULE_BOMB_TAG);
        		this.selectedModuleBomb = itemstack.getTagCompound().getInteger(rf.SELECTED_MODULE_BOMB_TAG);
        		
        		this.storedInventory = itemstack.getTagCompound().getCompoundTag(rf.AIRSHIP_SLOTS_TAG);
	        }
        	
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if(!worldIn.isRemote)
			{
				EntityThrownAirship entityairship = new EntityThrownAirship(worldIn, playerIn, 
				this.getMetadata(itemstack), this.mainTierFrame, this.mainTierEngine, this.mainTierBalloon, 
	    		this.moduleActiveSlot1, 
	    		this.storedFuel, this.storedFuelTotal, this.storedRedstone, this.storedRedstoneTotal, 
	    		
	    		this.coreModelVisualFrame, 
	    		this.coreModelVisualEngine, 
	    		this.coreModelVisualBalloon, 
	    		
	    		this.frameSkinTexture, 
	    		this.frameSkinTransparent, 
	    		this.frameSkinColorRed, this.frameSkinColorGreen, this.frameSkinColorBlue, 
	    		
	    		this.engineParticleVisual, 
	    		this.engineDisplayTypeVisual, this.engineDisplayIDVisual, 
	    		
	    		this.balloonPatternTexture, 
	    		this.balloonPatternTransparent, 
	    		this.balloonPatternColorRed, this.balloonPatternColorGreen, this.balloonPatternColorBlue, 
	    		
	    		this.learnedModuleAltitude, this.selectedModuleAltitude, 
	    		this.learnedModuleSpeed, this.selectedModuleSpeed, 
	    		this.learnedModuleStorage, this.selectedModuleStorage, 
	    		this.learnedModuleFuel, this.selectedModuleFuel, 
	    		this.learnedModuleMusic, this.selectedModuleMusic, 
	    		this.learnedModuleCruise, this.selectedModuleCruise, 
	    		this.learnedModuleWater, this.selectedModuleWater, 
	    		this.learnedModuleFuelInfinite, this.selectedModuleFuelInfinite, 
	    		this.learnedModuleBomb, this.selectedModuleBomb, 
	    		
	    		this.storedInventory, this.customName
	    		);
				
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
		String colorName = TextFormatting.WHITE + "Airship";
		String preName = TextFormatting.WHITE + "ViesCraft";
		
		if(this.coreModelVisualFrame == 0)
		{
			preName = TextFormatting.GREEN + "*" 
					+ TextFormatting.WHITE + "ViesCraft"
					+ TextFormatting.GREEN + "*" ;
		}
		if(this.coreModelVisualFrame == 1)
		{
			preName = TextFormatting.GREEN + "*" 
					+ TextFormatting.WHITE + ViesCraftConfig.v1AirshipName
					+ TextFormatting.GREEN + "*" ;
		}
		if(this.coreModelVisualFrame == 2)
		{
			preName = TextFormatting.GREEN + "*" 
					+ TextFormatting.WHITE + ViesCraftConfig.v2AirshipName
					+ TextFormatting.GREEN + "*" ;
		}
		if(this.coreModelVisualFrame == 3)
		{
			preName = TextFormatting.GREEN + "*" 
					+ TextFormatting.WHITE + ViesCraftConfig.v3AirshipName
					+ TextFormatting.GREEN + "*" ;
		}
		if(this.coreModelVisualFrame == 4)
		{
			preName = TextFormatting.GREEN + "*" 
					+ TextFormatting.WHITE + ViesCraftConfig.v4AirshipName
					+ TextFormatting.GREEN + "*" ;
		}
		
		if(stack.getMetadata() == 0)
		{
			colorName = TextFormatting.GRAY + "" + TextFormatting.BOLD + "Airship";
		}
		if(stack.getMetadata() == 1)
		{
			colorName = TextFormatting.WHITE + "" + TextFormatting.BOLD + "Airship";
		}
		if(stack.getMetadata() == 2)
		{
			colorName = TextFormatting.YELLOW + "" + TextFormatting.BOLD + "Airship";
		}
		if(stack.getMetadata() == 3)
		{
			colorName = TextFormatting.AQUA + "" + TextFormatting.BOLD + "Airship";
		}
		if(stack.getMetadata() == 4)
		{
			colorName = TextFormatting.LIGHT_PURPLE + "" + TextFormatting.BOLD + "Airship";
		}
		if(stack.getMetadata() == 5)
		{
			colorName = TextFormatting.RED + "" + TextFormatting.BOLD + "Airship";
		}
		
		String airshipName = preName + " " + colorName;
		
		return airshipName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		
		int mainTierCoreInfo = 0;
		int mainTierFrameInfo = 0;
		int mainTierEngineInfo = 0;
		int mainTierBalloonInfo = 0;
		
		if(stack.hasTagCompound())
    	{
			mainTierCoreInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_CORE_TAG);
    		mainTierFrameInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_FRAME_TAG);
    		mainTierEngineInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_ENGINE_TAG);
    		mainTierBalloonInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_BALLOON_TAG);
    	}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		//item and unleash the airship within.
		tooltip.add(TextFormatting.GREEN + I18n.translateToLocal("vc.item.tt.airship.1") + this.getPrimaryLabelColor(stack.getMetadata()) + " " + I18n.translateToLocal("vc.item.tt.airship.2"));
		tooltip.add(this.getPrimaryLabelColor(stack.getMetadata()) + I18n.translateToLocal("vc.item.tt.airship.3"));
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//Core = 0 || Frame = 0
		if(stack.getMetadata() == 0
		&& mainTierFrameInfo == 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "-iiiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--ill"
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiiill" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") +  TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--iil"
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Can't be used!!!
		//Core = 0 || Frame < 0
		else if(stack.getMetadata() == 0
			 && mainTierFrameInfo != 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "-iiiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--ill"
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"+ TextFormatting.BLACK + "l" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Core < 0 || Frame = 0
		else if(stack.getMetadata() != 0
			 && mainTierFrameInfo == 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "-iiiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getMetadata()) + EnumsVC.MainTierCore.byId(stack.getMetadata()).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiiill" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--iil" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Core < 0 || Frame < 0
		else if(stack.getMetadata() != 0
			 && mainTierFrameInfo != 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "-iiiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.4") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(stack.getMetadata()) + EnumsVC.MainTierCore.byId(stack.getMetadata()).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "--i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.14") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"+ TextFormatting.BLACK + "l" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		
		//Engine = 0 || Balloon = 0
		if(mainTierEngineInfo == 0
	    && mainTierBalloonInfo == 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--iil" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Engine = 0 || Balloon < 0
		else if(mainTierEngineInfo == 0
			 && mainTierBalloonInfo != 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "---i" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "l" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Engine < 0 || Balloon = 0
		else if(mainTierEngineInfo != 0
		     && mainTierBalloonInfo == 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.DARK_GRAY + I18n.translateToLocal("vc.item.tt.airship.8") + TextFormatting.BLACK + "--iil" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		//Engine < 0 || Balloon < 0
		else if(mainTierEngineInfo != 0
		     && mainTierBalloonInfo != 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.5") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiii" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.6") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "l" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "ii"
				+ TextFormatting.DARK_GREEN + "--------------"
				+ TextFormatting.BLACK + "il"
				+ TextFormatting.DARK_GREEN + "|"
				+ TextFormatting.BLACK + "il"
				+ TextFormatting.DARK_GREEN + "--------------"
				+ TextFormatting.BLACK + "ii"
				+ TextFormatting.DARK_GREEN + "|");
		
		
		float speedModCal = EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		String altMax = "";
		
		if(mainTierBalloonInfo == 0)
		{
			altMax = TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(mainTierBalloonInfo) + df.format(EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
		}
		else if(mainTierBalloonInfo >= 5)
		{
			altMax = TextFormatting.BLACK + "il" + this.getPrimaryLabelColor(mainTierBalloonInfo) + "\u221e" + TextFormatting.BLACK + "ii";
		}
		else
		{
			altMax = this.getPrimaryLabelColor(mainTierBalloonInfo) + df.format(EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
		}
		
		//----- || Airship Speed
		tooltip.add(TextFormatting.DARK_GREEN + "|"
				//+ TextFormatting.BLACK + "iiii" + TextFormatting.BLACK + "il" + TextFormatting.BLUE + I18n.translateToLocal("Rarity") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				//+ TextFormatting.YELLOW + "Uncommon"
				+ TextFormatting.BLACK + "---------------l" 
				+ TextFormatting.DARK_GREEN + "|" 
				+ TextFormatting.BLACK + "iiill" + TextFormatting.BLACK + "i" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.11") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
				+ TextFormatting.GRAY + "(" + TextFormatting.BLACK + "-" + this.getPrimaryLabelColor(mainTierFrameInfo) + "+" + speedMod + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--l"
				+ TextFormatting.DARK_GREEN + "|");
		
		if(mainTierBalloonInfo == 5)
		{
			//Airship Fuel and Altitude
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + "-" + df.format(EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick()) + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + TextFormatting.RED + " \u221e " + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "iiiiill" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		else
		{
			//Airship Fuel and Altitude
			tooltip.add(TextFormatting.DARK_GREEN + "|" 
					+ TextFormatting.BLACK + "iiiil" + TextFormatting.BLACK + "-il" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.13") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i"
					+ TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + "-" + df.format(EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick()) + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "--ii" 
					+ TextFormatting.DARK_GREEN + "|"
					+ TextFormatting.BLACK + "iiil" + TextFormatting.BLUE + I18n.translateToLocal("vc.item.tt.airship.12") + TextFormatting.BLACK + "i" + TextFormatting.DARK_BLUE + ":" + TextFormatting.BLACK + "i" 
					+ TextFormatting.GRAY + "(" + altMax + TextFormatting.GRAY + ")" + TextFormatting.BLACK + "-iiil" 
					+ TextFormatting.DARK_GREEN + "|");
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
}

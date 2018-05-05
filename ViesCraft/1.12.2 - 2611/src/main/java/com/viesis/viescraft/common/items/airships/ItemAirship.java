package com.viesis.viescraft.common.items.airships;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
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
import com.viesis.viescraft.api.References;
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
		this.storedRedstoneTotal = 50;
		
		this.storedBombType1 = 0;
        this.storedBombType2 = 0;
        this.storedBombType3 = 0;
        
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
		this.engineDisplayItemstackVisual = 0;
		this.engineDisplayItemstackMetaVisual = 0;
		this.engineDisplayHeadVisual = 0;
		this.engineDisplaySupporterHeadVisual = 0;
		this.engineDisplayHolidayVisual = 0;
		
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
        		
        		this.storedBombType1 = itemstack.getTagCompound().getInteger(rf.BOMB_TYPE_1_TAG);
        		this.storedBombType2 = itemstack.getTagCompound().getInteger(rf.BOMB_TYPE_2_TAG);
        		this.storedBombType3 = itemstack.getTagCompound().getInteger(rf.BOMB_TYPE_3_TAG);
        		
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
        		this.engineDisplayItemstackVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_ITEMSTACK_VISUAL_TAG);
        		this.engineDisplayItemstackMetaVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_TAG);
        		this.engineDisplayHeadVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_HEAD_VISUAL_TAG);
        		this.engineDisplaySupporterHeadVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_TAG);
        		this.engineDisplayHolidayVisual = itemstack.getTagCompound().getInteger(rf.ENGINE_DISPLAY_HOLIDAY_VISUAL_TAG);
        		
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
	    		this.storedBombType1, this.storedBombType2, this.storedBombType3,
	    		
	    		this.coreModelVisualFrame, 
	    		this.coreModelVisualEngine, 
	    		this.coreModelVisualBalloon, 
	    		
	    		this.frameSkinTexture, 
	    		this.frameSkinTransparent, 
	    		this.frameSkinColorRed, this.frameSkinColorGreen, this.frameSkinColorBlue, 
	    		
	    		this.engineParticleVisual, 
	    		this.engineDisplayTypeVisual, 
	    		this.engineDisplayItemstackVisual, this.engineDisplayItemstackMetaVisual,
	    		this.engineDisplayHeadVisual, 
	    		this.engineDisplaySupporterHeadVisual, 
	    		this.engineDisplayHolidayVisual, 
	    		
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
		String colorName = " ";
		
		this.customName = "Airship";
		
		if(stack.hasTagCompound())
    	{
    		this.customName = stack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
    	}
		
		if(stack.getMetadata() == 0)
		{
			colorName = TextFormatting.GRAY + this.customName;
		}
		if(stack.getMetadata() == 1)
		{
			colorName = TextFormatting.WHITE + this.customName;
		}
		if(stack.getMetadata() == 2)
		{
			colorName = TextFormatting.YELLOW + this.customName;
		}
		if(stack.getMetadata() == 3)
		{
			colorName = TextFormatting.AQUA + this.customName;
		}
		if(stack.getMetadata() == 4)
		{
			colorName = TextFormatting.LIGHT_PURPLE + this.customName;
		}
		if(stack.getMetadata() == 5)
		{
			colorName = TextFormatting.RED + this.customName;
		}
		
		return this.getPrimaryLabelColor(stack.getMetadata()) + References.localNameVC("vc.main.airship") + TextFormatting.GREEN + " - \'" + colorName + TextFormatting.GREEN + "\'";
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		int mainTierCoreInfo = stack.getMetadata();
		int mainTierFrameInfo = 0;
		int mainTierEngineInfo = 0;
		int mainTierBalloonInfo = 0;
		
		int currentRedstoneInfo = 0;
		int currentModuleSlot1Info = 0;
		
		if(stack.hasTagCompound())
    	{
			mainTierFrameInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_FRAME_TAG);
    		mainTierEngineInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_ENGINE_TAG);
    		mainTierBalloonInfo = stack.getTagCompound().getInteger(rf.MAIN_TIER_BALLOON_TAG);
    		currentRedstoneInfo = stack.getTagCompound().getInteger(rf.STORED_REDSTONE_TAG);
    		currentModuleSlot1Info = stack.getTagCompound().getInteger(rf.MODULE_ACTIVE_SLOT1_TAG);
    	}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		//[Hold Shift + Right-Click] to throw this
		tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.airship.1") + this.getSecondaryLabelColor(stack.getMetadata()) + " " + References.localNameVC("vc.item.tt.airship.2"));
		//item and unleash the airship within.
		tooltip.add(this.getSecondaryLabelColor(stack.getMetadata()) + References.localNameVC("vc.item.tt.airship.3"));
		
		if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			//Core : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.core") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.redstone") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierCoreInfo) + EnumsVC.MainTierCore.byId(mainTierCoreInfo).getStoredRedstone());
			//Frame : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.frame") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierFrameInfo) + EnumsVC.MainTierFrame.byId(mainTierFrameInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.speed") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierFrameInfo) + "+" + mainTierFrameInfo);
			//Engine : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.engine") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.fuel") + TextFormatting.DARK_BLUE + " : "
					+ this.getPrimaryLabelColor(mainTierEngineInfo) + EnumsVC.MainTierEngine.byId(mainTierEngineInfo).getFuelPerTick());
			//Balloon : 
			tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.balloon") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + "(" + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getLocalizedName() + TextFormatting.GRAY + ")"
					+ TextFormatting.GREEN + " - "+ TextFormatting.BLUE + References.localNameVC("vc.main.altitude") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(mainTierBalloonInfo) + EnumsVC.MainTierBalloon.byId(mainTierBalloonInfo).getMaxAltitude());
			
			tooltip.add("");
			//Stored Redstone : 
			if(currentRedstoneInfo == 0)
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.storedredstone") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GRAY + currentRedstoneInfo);
			}
			else
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.storedredstone") + TextFormatting.DARK_BLUE + " : " + TextFormatting.GREEN + currentRedstoneInfo);
			}
			//Current Module : 
			if(currentModuleSlot1Info == 0)
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.current") + " " + References.localNameVC("vc.item.module.#") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(currentRedstoneInfo) + "None");
			}
			else
			{
				tooltip.add(TextFormatting.BLUE + References.localNameVC("vc.main.current") + " " + References.localNameVC("vc.item.module.#") + TextFormatting.DARK_BLUE + " : " + this.getPrimaryLabelColor(currentRedstoneInfo) + TextFormatting.GREEN + EnumsVC.ModuleType.byId(currentModuleSlot1Info).getLocalizedName());
			}
		}
		else
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.shifthelper.0"));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
}

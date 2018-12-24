package com.vies.viesmachines.common.items.machines.flying;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;
import com.vies.viesmachines.common.items.ItemHelper;
import com.vies.viesmachines.common.items.machines.ItemMachineBase;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMachineFlyingAirship extends ItemMachineBase {
	
	private EnumRarity rarity;
	
	public ItemMachineFlyingAirship(String unlocalizedName, EnumRarity rarityIn) 
	{
		ItemHelper.setItemName(this, unlocalizedName);
		
		this.rarity = rarityIn;
		
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItemMainhand();
        
		this.frameTier = 0;
		this.engineTier = 0;
		this.componentTier = 0;
		
		// Airship
		this.type = 0;
		this.health = (float) EnumsVM.FlyingMachineFrameTier.byId(this.frameTier).getMaxHealthModifier();
		this.energy = 0;
		this.durability = EnumsVM.FlyingMachineFrameTier.byId(this.frameTier).getMaxDurabilityModifier();
		
		
		this.broken = false;
		this.fuel = 0;
		this.fuelTotal = 0;
		
		this.ammoAmount = 0;
		this.ammoType = 0;
		
		this.machineEnhancement1 = 0;
		
		this.visualModelFrame = 0;
		this.visualModelEngine = 0;
		this.visualModelComponent = 0;
		
		this.visualFrameTexture = 0;
		this.visualFrameTransparent = false;
		this.visualFrameColor = false;
		this.visualFrameColorRed = 0;
		this.visualFrameColorGreen = 0;
		this.visualFrameColorBlue = 0;
		
		this.visualEngineParticle = 0;
		this.visualEngineDisplayType = 0;
		this.visualEngineDisplayItemstack = 0;
		this.visualEngineDisplayItemstackMeta = 0;
		this.visualEngineDisplayHead = 0;
		this.visualEngineDisplaySupporterHead = 0;
		this.visualEngineDisplayHoliday = 0;
		
		this.visualComponentTexture = 0;
		this.visualComponentTransparent = false;
		this.visualComponentColor = false;
		this.visualComponentColorRed = 0;
		this.visualComponentColorGreen = 0;
		this.visualComponentColorBlue = 0;
		
		this.storedInventory = new NBTTagCompound();
		this.customName = "Airship";
		this.visualNameColor = EnumsVM.SelectColor.WHITE.getMetadata();
		
        if(playerIn.isSneaking())
		{
        	if(itemstack.hasTagCompound())
        	{
        		this.frameTier = itemstack.getTagCompound().getInteger(rf.TIER_FRAME_TAG);
        		this.engineTier = itemstack.getTagCompound().getInteger(rf.TIER_ENGINE_TAG);
        		this.componentTier = itemstack.getTagCompound().getInteger(rf.TIER_COMPONENT_TAG);
        		
        		this.type = itemstack.getTagCompound().getInteger(rf.TYPE_TAG);
        		this.health = itemstack.getTagCompound().getFloat(rf.HEALTH_TAG);
        		this.energy = itemstack.getTagCompound().getInteger(rf.ENERGY_TAG);
        		this.durability = itemstack.getTagCompound().getInteger(rf.DURABILITY_TAG);
        		
        		this.broken = itemstack.getTagCompound().getBoolean(rf.BROKEN_TAG);
        		this.fuel = itemstack.getTagCompound().getInteger(rf.FUEL_TAG);
        		this.fuelTotal = itemstack.getTagCompound().getInteger(rf.FUEL_TOTAL_TAG);
        		
        		this.ammoAmount = itemstack.getTagCompound().getInteger(rf.AMMO_AMOUNT_TAG);
        		this.ammoType = itemstack.getTagCompound().getInteger(rf.AMMO_TYPE_TAG);
        		
        		this.machineEnhancement1 = itemstack.getTagCompound().getInteger(rf.MACHINE_ENHANCEMENT_1_TAG);
        		
        		this.visualModelFrame = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_FRAME_TAG);
        		this.visualModelEngine = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_ENGINE_TAG);
        		this.visualModelComponent = itemstack.getTagCompound().getInteger(rf.VISUAL_MODEL_COMPONENT_TAG);
        		
        		this.visualFrameTexture = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_TEXTURE_TAG);
        		this.visualFrameTransparent = itemstack.getTagCompound().getBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG);
        		this.visualFrameColor = itemstack.getTagCompound().getBoolean(rf.VISUAL_FRAME_COLOR_TAG);
        		this.visualFrameColorRed = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_RED_TAG);
        		this.visualFrameColorGreen = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG);
        		this.visualFrameColorBlue = itemstack.getTagCompound().getInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG);
        		
        		this.visualEngineParticle = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_PARTICLE_TAG);
        		this.visualEngineDisplayType = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG);
        		this.visualEngineDisplayItemstack = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG);
        		this.visualEngineDisplayItemstackMeta = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG);
        		this.visualEngineDisplayHead = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG);
        		this.visualEngineDisplaySupporterHead = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG);
        		this.visualEngineDisplayHoliday = itemstack.getTagCompound().getInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG);
        		
        		this.visualComponentTexture = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG);
        		this.visualComponentTransparent = itemstack.getTagCompound().getBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG);
        		this.visualComponentColor = itemstack.getTagCompound().getBoolean(rf.VISUAL_COMPONENT_COLOR_TAG);
        		this.visualComponentColorRed = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG);
        		this.visualComponentColorGreen = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG);
        		this.visualComponentColorBlue = itemstack.getTagCompound().getInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG);
        		
        		this.storedInventory = itemstack.getTagCompound().getCompoundTag(rf.MACHINE_SLOTS_TAG);
        		
        		this.customName = itemstack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
        		this.visualNameColor = itemstack.getTagCompound().getInteger(rf.VISUAL_NAME_COLOR_TAG);
	        }
        	
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		playerIn.inventory.decrStackSize(playerIn.inventory.currentItem, 1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if(!worldIn.isRemote)
			{
				EntityThrownMachineFlyingAirship entityairship = new EntityThrownMachineFlyingAirship(worldIn, playerIn, 
						
						this.frameTier, this.engineTier, this.componentTier, this.type, 
						this.health, this.energy, this.durability,
	    				this.broken, this.fuel, this.fuelTotal, 
	    				this.ammoAmount, this.ammoType, 
	    				this.machineEnhancement1, 
	    				
	    				this.visualModelFrame, this.visualModelEngine, this.visualModelComponent,
	    				
	    				this.visualFrameTexture, 
	    				this.visualFrameTransparent, this.visualFrameColor,
	    				this.visualFrameColorRed, 
	    				this.visualFrameColorGreen, 
	    				this.visualFrameColorBlue,
	    				
	    				this.visualEngineParticle,
	    				this.visualEngineDisplayType,
	    				this.visualEngineDisplayItemstack,
	    				this.visualEngineDisplayItemstackMeta,
	    				this.visualEngineDisplayHead,
	    				this.visualEngineDisplaySupporterHead,
	    				this.visualEngineDisplayHoliday,
	    				
	    				this.visualComponentTexture, 
	    				this.visualComponentTransparent, this.visualComponentColor,
	    				this.visualComponentColorRed, 
	    				this.visualComponentColorGreen, 
	    				this.visualComponentColorBlue,
	    				
	    	    		this.storedInventory, this.customName, this.visualNameColor
				
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
		String colorName = TextFormatting.WHITE + "";
		String itemName = References.Old_I18n.translateToLocal("item.viesmachines:machines/item_machine_flying_airship.name");
		String isBroken = "";
		
		if (stack.hasTagCompound())
    	{
			colorName = EnumsVM.SelectColor.byId(stack.getTagCompound().getInteger(rf.VISUAL_NAME_COLOR_TAG)).getTextColor() + "";
    	}
		
		if (stack.hasTagCompound())
    	{
			itemName = stack.getTagCompound().getString(rf.CUSTOM_NAME_TAG);
    	}
		
		if (stack.hasTagCompound())
		{
			this.broken = stack.getTagCompound().getBoolean(rf.BROKEN_TAG);
		}
		
		if (this.broken)
		{
			isBroken = TextFormatting.RED + "("+ TextFormatting.DARK_RED + "Broken" + TextFormatting.RED + ")";
		}
		
		return colorName + "\"" + itemName + "\"" + " " + isBroken;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		float healthInfo = 8.0F;
		int energyInfo = 0;
		int durabilityInfo = 100;
		String ammoTypeInfo = "Standard";
		int ammoAmountInfo = 0;
		
		int frameInfo = 0;
		int engineInfo = 0;
		int componentInfo = 0;
		
		if (stack.hasTagCompound())
    	{
			healthInfo = stack.getTagCompound().getFloat(rf.HEALTH_TAG);
			energyInfo = stack.getTagCompound().getInteger(rf.ENERGY_TAG);
			durabilityInfo = stack.getTagCompound().getInteger(rf.DURABILITY_PERCENT_TAG);
			ammoTypeInfo = stack.getTagCompound().getString(rf.AMMO_TYPE_TAG);
			ammoAmountInfo = stack.getTagCompound().getInteger(rf.AMMO_AMOUNT_TAG);
			
			frameInfo = stack.getTagCompound().getInteger(rf.TIER_FRAME_TAG);
			engineInfo = stack.getTagCompound().getInteger(rf.TIER_ENGINE_TAG);
			componentInfo = stack.getTagCompound().getInteger(rf.TIER_COMPONENT_TAG);
    	}
		
		String healthInfoDisplay = "";
		
		if (healthInfo >= 10)
		{
			healthInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||"
			+ TextFormatting.RED + (int)healthInfo
			+ TextFormatting.BLACK + "||||||||||"+ "||";
		}
		else if (healthInfo >= 1)
		{
			healthInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||||"
			+ TextFormatting.RED + (int)healthInfo
			+ TextFormatting.BLACK + "||||||||||"+ "|||";
		}
		else if (healthInfo == 0)
		{
			healthInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||"
			+ TextFormatting.DARK_RED + (int)healthInfo
			+ TextFormatting.BLACK + "||||||||||"+ "||";
		}
		
		String energyInfoDisplay = "";
		
		if (energyInfo >= 100)
		{
			energyInfoDisplay = TextFormatting.BLACK + "||||||||||"
			+ TextFormatting.YELLOW + (int)energyInfo
			+ TextFormatting.BLACK + "||||||||||"+ "|";
		}
		else if (energyInfo >= 10)
		{
			energyInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||"
			+ TextFormatting.YELLOW + (int)energyInfo
			+ TextFormatting.BLACK + "||||||||||"+ "||";
		}
		else if (energyInfo <= 9)
		{
			energyInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||||"
			+ TextFormatting.YELLOW + (int)energyInfo
			+ TextFormatting.BLACK + "||||||||||"+ "|||";
		}
		
		String durabilityInfoDisplay = "";
		
		if (durabilityInfo >= 100)
		{
			durabilityInfoDisplay = TextFormatting.BLACK + "||||||||||"
			+ TextFormatting.GREEN + (int)durabilityInfo + "%"
			+ TextFormatting.BLACK + "||||||||";
		}
		else if (durabilityInfo >= 10)
		{
			durabilityInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "|"
			+ TextFormatting.GREEN + (int)durabilityInfo + "%"
			+ TextFormatting.BLACK + "||||||||||";
		}
		else if (durabilityInfo >= 1)
		{
			durabilityInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||"
			+ TextFormatting.GREEN + (int)durabilityInfo + "%"
			+ TextFormatting.BLACK + "||||||||||"+ "||";
		}
		else if (durabilityInfo == 0)
		{
			durabilityInfoDisplay = TextFormatting.BLACK + "||||||||||"+ "||"
			+ TextFormatting.DARK_RED + (int)durabilityInfo + "%"
			+ TextFormatting.BLACK + "||||||||||"+ "||";
		}
		
		
		
		tooltip.add(TextFormatting.BLUE + "Flying Machine - Airship");
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		tooltip.add(TextFormatting.DARK_GREEN + "||" + healthInfoDisplay + TextFormatting.DARK_GREEN + "|" + energyInfoDisplay + TextFormatting.DARK_GREEN + "|" + durabilityInfoDisplay + TextFormatting.DARK_GREEN + "||");
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines.shiftrightclick") + " " + TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines:item_machines.tt.1"));
		
		tooltip.add(TextFormatting.DARK_GREEN + "--------------------------------");
		
		
		if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			String frameInfoDisplay = TextFormatting.GRAY + "None";
			String engineInfoDisplay = TextFormatting.GRAY + "None";
			String componentInfoDisplay = TextFormatting.GRAY + "None";
			
			if (frameInfo == 3)
			{
				frameInfoDisplay = TextFormatting.LIGHT_PURPLE + "Tier " + frameInfo;
			}
			else if (frameInfo == 2)
			{
				frameInfoDisplay = TextFormatting.AQUA + "Tier " + frameInfo;
			}
			else if (frameInfo == 1)
			{
				frameInfoDisplay = TextFormatting.YELLOW + "Tier " + frameInfo;
			}
			
			if (engineInfo == 3)
			{
				engineInfoDisplay = TextFormatting.LIGHT_PURPLE + "Tier " + engineInfo;
			}
			else if (engineInfo == 2)
			{
				engineInfoDisplay = TextFormatting.AQUA + "Tier " + engineInfo;
			}
			else if (engineInfo == 1)
			{
				engineInfoDisplay = TextFormatting.YELLOW + "Tier " + engineInfo;
			}
			
			if (componentInfo == 3)
			{
				componentInfoDisplay = TextFormatting.LIGHT_PURPLE + "Tier " + componentInfo;
			}
			else if (componentInfo == 2)
			{
				componentInfoDisplay = TextFormatting.AQUA + "Tier " + componentInfo;
			}
			else if (componentInfo == 1)
			{
				componentInfoDisplay = TextFormatting.YELLOW + "Tier " + componentInfo;
			}
			
			tooltip.add(TextFormatting.BLUE + "Frame : " + frameInfoDisplay);
			tooltip.add(TextFormatting.BLUE + "Engine : " + engineInfoDisplay);
			tooltip.add(TextFormatting.BLUE + "Component : " + componentInfoDisplay);
			tooltip.add(TextFormatting.BLUE + "Ammo Type : " + TextFormatting.WHITE + ammoTypeInfo);
			tooltip.add(TextFormatting.BLUE + "Ammo Amount : " + TextFormatting.WHITE + ammoAmountInfo);
		}
		else
		{
			tooltip.add(TextFormatting.WHITE + "Hold [Shift] for more info.");
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return this.rarity;
    }
}

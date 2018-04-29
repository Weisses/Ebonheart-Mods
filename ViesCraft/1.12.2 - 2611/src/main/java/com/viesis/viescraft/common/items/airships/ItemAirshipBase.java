package com.viesis.viescraft.common.items.airships;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipBase extends Item {
    
    protected References rf;
    
    protected String customName;
	
    protected int storedFuel;
	protected int storedFuelTotal;
	protected int fuelItemStack;
	protected int fuelItemStackSize;
	protected int storedRedstone;
	protected int storedRedstoneTotal;
	
	protected int mainTierCore;
	protected int mainTierFrame;
	protected int mainTierEngine;
	protected int mainTierBalloon;
	
	protected int coreModelVisualFrame;
	protected int coreModelVisualEngine;
	protected int coreModelVisualBalloon;
	
	protected int frameSkinTexture;
	protected boolean frameSkinTransparent;
	protected int frameSkinColorRed;
	protected int frameSkinColorGreen;
	protected int frameSkinColorBlue;
	
	protected int engineParticleVisual;
	protected int engineDisplayTypeVisual;
	protected int engineDisplayItemstackVisual;
	protected int engineDisplayItemstackMetaVisual;
	protected int engineDisplayHeadVisual;
	protected int engineDisplaySupporterHeadVisual;
	protected int engineDisplayHolidayVisual;
	
	protected int balloonPatternTexture;
	protected boolean balloonPatternTransparent;
	protected int balloonPatternColorRed;
	protected int balloonPatternColorGreen;
	protected int balloonPatternColorBlue;
	
	protected int moduleActiveSlot1;
	
	//Modules
	/** Selected Altitude */
	protected int selectedModuleAltitude;
	/** Learned Altitude */
	protected boolean learnedModuleAltitude;
	/** Selected Speed */
	protected int selectedModuleSpeed;
	/** Learned Speed */
	protected boolean learnedModuleSpeed;
	/** Selected Storage */
	protected int selectedModuleStorage;
	/** Learned Storage */
	protected boolean learnedModuleStorage;
	/** Selected Fuel */
	protected int selectedModuleFuel;
	/** Learned Fuel */
	protected boolean learnedModuleFuel;
	/** Selected Music */
	protected int selectedModuleMusic;
	/** Learned Music */
	protected boolean learnedModuleMusic;
	/** Selected Cruise */
	protected int selectedModuleCruise;
	/** Learned Cruise */
	protected boolean learnedModuleCruise;
	/** Selected Water */
	protected int selectedModuleWater;
	/** Learned Water */
	protected boolean learnedModuleWater;
	/** Selected Fuel Infinite */
	protected int selectedModuleFuelInfinite;
	/** Learned Fuel Infinite */
	protected boolean learnedModuleFuelInfinite;
	/** Selected Bomb */
	protected int selectedModuleBomb;
	/** Learned Bomb */
	protected boolean learnedModuleBomb;
	
	protected NBTTagCompound storedInventory;
	
	public ItemAirshipBase()
	{
		this.setMaxStackSize(1);
	}
	
	protected TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.WHITE;
			case 2:
				return stringColorLabel = TextFormatting.YELLOW;
			case 3:
				return stringColorLabel = TextFormatting.AQUA;
			case 4:
				return stringColorLabel = TextFormatting.LIGHT_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		switch (this.getMetadata(stack))
        {
        	case 0:
        		return EnumRarity.COMMON;
        	case 1:
            	return EnumRarity.COMMON;
            case 2:
            	return EnumRarity.UNCOMMON;
            case 3:
            	return EnumRarity.RARE;
            case 4:
            	return EnumRarity.EPIC;
            case 5:
            	return EnumRarity.EPIC;
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.MainTierCore.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

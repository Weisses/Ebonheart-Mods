package com.viesis.viescraft.common.items.airships;

import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;

public class ItemCreativeAirshipBase extends Item {
	
	protected int metaModuleVariantSlot1;
	
	protected int metaTierFrame;
	protected int metaTierBalloon;
	
	protected int metaFrameVisual;
	protected boolean metaFrameVisualTransparent;
	protected boolean metaFrameVisualColor;
	protected int metaFrameColorRed;
	protected int metaFrameColorGreen;
	protected int metaFrameColorBlue;
	
	protected int metaBalloonVisual;
	protected boolean metaBalloonVisualTransparent;
	protected boolean metaBalloonVisualColor;
	protected int metaBalloonColorRed;
	protected int metaBalloonColorGreen;
	protected int metaBalloonColorBlue;
	
	protected NBTTagCompound storedInventory;
	
	public ItemCreativeAirshipBase()
	{
		this.setMaxStackSize(1);
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return EnumRarity.EPIC;
    }
	
	protected TextFormatting getPrimaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel = TextFormatting.RED;
		
		return stringColorLabel;
	}
	
	protected TextFormatting getSecondaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel = TextFormatting.DARK_RED;
		
		return stringColorLabel;
	}
}

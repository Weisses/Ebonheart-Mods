package com.vies.viesmachines.common.items.machines;

import com.vies.viesmachines.api.References;

import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.TextFormatting;

public class ItemMachineBase extends Item {
    
    protected References rf;
    
	protected int frameTier;
    protected int engineTier;
    protected int componentTier;
    
    protected int type;
    protected float health;
    protected int energy;
    protected int durability;
    
    protected boolean broken;
    protected int fuel;
    protected int fuelTotal;
    
    protected int ammoAmount;
    protected int ammoType;
	
    protected int machineEnhancement1;
    
    protected int visualModelFrame;
    protected int visualModelEngine;
    protected int visualModelComponent;
    
    protected int visualFrameTexture;
    protected boolean visualFrameTransparent;
    protected boolean visualFrameColor;
    protected int visualFrameColorRed;
    protected int visualFrameColorGreen;
    protected int visualFrameColorBlue;
    
    protected int visualEngineParticle;
    protected int visualEngineDisplayType;
    protected int visualEngineDisplayItemstack;
    protected int visualEngineDisplayItemstackMeta;
    protected int visualEngineDisplayHead;
    protected int visualEngineDisplaySupporterHead;
    protected int visualEngineDisplayHoliday;
    
    protected int visualComponentTexture;
    protected boolean visualComponentTransparent;
    protected boolean visualComponentColor;
    protected int visualComponentColorRed;
    protected int visualComponentColorGreen;
    protected int visualComponentColorBlue;
    
    protected NBTTagCompound storedInventory;
    
    protected String customName;
    protected int visualNameColor;
	private String procName;
	
	public ItemMachineBase()
	{
		this.setMaxStackSize(1);
		
		this.procName = "ItemMachineProc";
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
	
	protected TextFormatting getSecondaryLabelColor(int stack)
	{
		TextFormatting stringColorLabel;
		
		switch(stack)
		{
			case 0:
				return stringColorLabel = TextFormatting.GRAY;
			case 1:
				return stringColorLabel = TextFormatting.GRAY;
			case 2:
				return stringColorLabel = TextFormatting.GOLD;
			case 3:
				return stringColorLabel = TextFormatting.DARK_AQUA;
			case 4:
				return stringColorLabel = TextFormatting.DARK_PURPLE;
			case 5:
				return stringColorLabel = TextFormatting.DARK_RED;
			default:
				return stringColorLabel = TextFormatting.GRAY;
		}
	}

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }
}

package com.viesis.gemstones.common.items.zzzTEMP.resources;

import java.util.List;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.common.items.ItemHelper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMusicDiscEA extends ItemRecord {
	
    public ItemMusicDiscEA(String unlocalizedName, SoundEvent soundIn)
    {
    	super(References.MOD_ID + ":" + unlocalizedName, soundIn);
    	ItemHelper.setItemName(this, unlocalizedName);
    }
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "This "  + stack.getDisplayName().toLowerCase() + " plays the ");
		toolTip.add(TextFormatting.DARK_AQUA + "record, \"" + this.getRecordNameLocal() + "\".");
	}

}
package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.api.References;
import com.ebonheart.EbonArtsMod.api.util.LogHelper;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.common.utils.SoundEventsEA;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;
import com.google.common.collect.Maps;

import net.minecraft.block.BlockJukebox;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemRecord;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
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
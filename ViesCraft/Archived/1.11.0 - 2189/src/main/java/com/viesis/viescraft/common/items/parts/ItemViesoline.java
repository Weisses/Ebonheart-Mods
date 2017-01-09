package com.viesis.viescraft.common.items.parts;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemViesoline extends Item {
	
	public EnergyStorage inventory;
	public IStorage test;
	private int size = 2000;
	
	public ItemViesoline() 
	{
		ItemHelper.setItemName(this, "item_viesoline");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
		
		this.inventory = new EnergyStorage(size);
		
		//this.inventory.canExtract();
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		int timer;
		int remainder;
		int minutes;
		int seconds;
		int hours;
		
		timer = (ViesCraftConfig.viesolineBurnTime);
		remainder = (timer % 3600);
		minutes = remainder / 60;
		seconds = remainder % 60;
		
		String mins = (minutes < 10 ? "0" : "") + minutes;
		String secs = (seconds < 10 ? "0" : "") + seconds;
		
		//Time in seconds to display
		String s = mins + ":" + secs;
		
		toolTip.add(TextFormatting.GOLD + "Fuel designed for all");
		toolTip.add(TextFormatting.GOLD + "airship types.");
		toolTip.add("" 
		//+ this.inventory.getEnergyStored()
				);
		toolTip.add(TextFormatting.GREEN + "Time per piece: " + s);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
}

package com.viesis.viescraft.common.items.parts;

import java.util.List;

import net.darkhax.tesla.api.implementation.BaseTeslaContainer;
import net.darkhax.tesla.api.implementation.BaseTeslaContainerProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.caps.DualEnergyStorageVC;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemViesoline extends Item {
	
	public DualEnergyStorageVC inventory;
	public IStorage test;
	private int size = 2000;
	
	public ItemViesoline() 
	{
		ItemHelper.setItemName(this, "item_viesoline");
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
		this.inventory = new DualEnergyStorageVC(1000, 1000, 1);
		//this.inventory = new EnergyStorage(size);
		
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
		//+ this.inventory.getStoredPower()
				);
		toolTip.add(TextFormatting.GREEN + "Time per piece: " + s);
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		this.inventory.receiveEnergy(1, false);
		
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	
	
	//@Override
    //public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) {
    //    return new DualEnergyStorageVC();
    //    return new BaseTeslaContainerProvider(new BaseTeslaContainer());
    //}
}

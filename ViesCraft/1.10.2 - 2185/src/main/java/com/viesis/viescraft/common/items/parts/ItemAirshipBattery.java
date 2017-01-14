package com.viesis.viescraft.common.items.parts;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.caps.CapabilityProviderVC;
import com.viesis.viescraft.common.caps.DualEnergyStorageVC;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipBattery extends Item {
	
	//public DualEnergyStorageVC energy;
	
	private int capacity;
	private int maxReceive;
	private int maxExtract;
	
	public ItemAirshipBattery(int capacityIn, int maxReceiveIn, int maxExtractIn) 
	{
		ItemHelper.setItemName(this, "item_airship_battery");
		
		this.capacity = capacityIn;
		this.maxReceive = maxReceiveIn;
		this.maxExtract = maxExtractIn;
		
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
		
		//this.energy = new DualEnergyStorageVC(capacity, maxReceive, maxExtract);
		
		
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }
	
	//@Override
    //public void addInformation (ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
        
    //    CapabilityProviderVC.createTooltip(stack, tooltip);
    //}
	
	
	@Override
    public ICapabilityProvider initCapabilities (ItemStack stack, NBTTagCompound nbt) 
	{
		/**
		return new ICapabilityProvider()
		{
			public DualEnergyStorageVC energy = new DualEnergyStorageVC(1000, 1000, 2000);
			//public DualEnergyStorage energy = new DualEnergyStorage(ConfigValues.MAX_TESLA, ConfigValues.TESLA_PER_TICK * 2, ConfigValues.TESLA_PER_TICK);

			@Override
			public boolean hasCapability(Capability<?> capability, EnumFacing facing)
			{
				return capability==CapabilityEnergy.ENERGY || capability == DualEnergyStorageVC.CAPABILITY_HOLDER;
			}
			
			@Override
			public <T> T getCapability(Capability<T> capability, EnumFacing facing)
			{
				if(capability==CapabilityEnergy.ENERGY || capability == DualEnergyStorageVC.CAPABILITY_HOLDER)
					return (T) energy;
				//if(capability==CapabilityEnergy.ENERGY)
				//	return (T)shaders;
				return null;
			}
			

			@Override
		    public NBTTagCompound serializeNBT () {
		        
		        return this.energy.serializeNBT();
		    }
		    
		    @Override
		    public void deserializeNBT (NBTTagCompound nbt) {
		        
		        this.energy.deserializeNBT(nbt);
		    }
		};
		*/
		return null;//new CapabilityProviderVC(new DualEnergyStorageVC(1000, 100, 100));
    }
	
	
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return ("Airship Battery");
    }
	

    //public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    //{
    	//DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(CapabilityEnergy.ENERGY, null);
		
    	
    	//LogHelper.info("Tesla energy = " + cap.getCapacity());
    
		
	//}
    
	/**
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
		ItemStack itemstack = playerIn.getHeldItem(handIn);
		DualEnergyStorageVC
		//IEnergyStorage 
		cap = (DualEnergyStorageVC) itemstack.getCapability(
				DualEnergyStorageVC.CAPABILITY_HOLDER
				//CapabilityEnergy.ENERGY
				, null);
		
		if(playerIn.isSneaking())
		{
		//	if (!worldIn.isRemote)
		//	{
				cap.receiveEnergy(10, false);
				
				LogHelper.info("+Stored energy: " + cap.getEnergyStored());
				LogHelper.info("+Max energy = " + cap.getMaxEnergyStored());
		//	}
		}
		else
		{
		//if (!worldIn.isRemote)
		//	{
				cap.extractEnergy(1, false);
				
				LogHelper.info("-Stored energy: " + cap.getEnergyStored());
				LogHelper.info("-Max energy = " + cap.getMaxEnergyStored());
		//	}
		}
        return new ActionResult(EnumActionResult.PASS, playerIn.getHeldItem(handIn));
    }
	
	
	@SideOnly(Side.CLIENT)
	@Override
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		//IEnergyStorage cap = stack.getCapability(CapabilityEnergy.ENERGY, null);
		
		DualEnergyStorageVC
		//IEnergyStorage 
		cap = (DualEnergyStorageVC) stack.getCapability(
				DualEnergyStorageVC.CAPABILITY_HOLDER
				//CapabilityEnergy.ENERGY
				, null);
		
		toolTip.add(TextFormatting.DARK_PURPLE + "Forge Stored energy: " + cap.getEnergyStored());
		toolTip.add(TextFormatting.DARK_PURPLE + "Tesla Stored energy: " + cap.getStoredPower());
		toolTip.add("");
		toolTip.add(TextFormatting.DARK_PURPLE + "Max energy = " + cap.getMaxEnergyStored());
	}

	*/
	
	
	
}

package com.viesis.viescraft.common.caps;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;

public class CapabilityProviderVC{}
/**
public class CapabilityProviderVC implements INBTSerializable<NBTTagCompound>, ICapabilityProvider {

	private DualEnergyStorageVC energy;
	
	public CapabilityProviderVC(DualEnergyStorageVC energyIn) 
	{
		this.energy = energyIn;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		if(//capability == CapabilityEnergy.ENERGY || 
				capability == DualEnergyStorageVC.CAPABILITY_HOLDER)
			return true;
		return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if(//capability == CapabilityEnergy.ENERGY || 
				capability == DualEnergyStorageVC.CAPABILITY_HOLDER)
			return (T) this.energy;
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
}
*/
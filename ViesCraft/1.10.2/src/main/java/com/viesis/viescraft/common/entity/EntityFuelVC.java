package com.viesis.viescraft.common.entity;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.HorseArmorType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityFuelVC extends EntityVC implements IInventoryChangedListener {
	
	public int fuelTime = 0;
    public int currentFuelTime;
    
	
    public EntityFuelVC(World worldIn) 
    {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void entityInit() 
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		
	}



	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) 
	{
		// TODO Auto-generated method stub
		
	}
    

	
	
	
	
	
	
	
	
	
	
	
	
	

    
    
    
    
    
    /**
     * WIP
     * 
     * @param itemstack
     * @return
     */
    
    
    
    
    public int getFuelTime(ItemStack itemstack) 
    {
		if (itemstack == null) 
		{
			return 0;
		}
		Item i = itemstack.getItem();
		
		if (i == Items.COAL) 
		{
			return 1600;
		}
		else if (i == Items.LAVA_BUCKET) 
		{
			return 20000;
		}
		
		else if (i == Items.GUNPOWDER) 
		{
			return 200;
		} 
		else 
		{
			return currentFuelTime;
		}
	}

	

	public int getFuelScale(int i) {
		return (fuelTime * i) / 600;
	}



	
	

	/**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
     */
	@Override
    public void onInventoryChanged(InventoryBasic invBasic)
    {
        //HorseArmorType horsearmortype = this.getHorseArmorType();
        //boolean flag = this.isHorseSaddled();
        //this.updateHorseSlots();

        
    }


    
    
    
    
    
    
    
    
    
    
}

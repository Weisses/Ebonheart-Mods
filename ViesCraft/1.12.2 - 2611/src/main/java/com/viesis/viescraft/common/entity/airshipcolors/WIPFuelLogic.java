package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class WIPFuelLogic {
	
	EntityAirshipCore airship;
	
	//Fuel
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	public int itemFuelStackSize;
	public int itemFuelStack;
	public int airshipFuelTick;
	
	public WIPFuelLogic(EntityAirshipCore entityIn)
    {
        this.airship = entityIn;
    }
    
  //==================================//
    // TODO       Fuel Logic            //
	//==================================//
    
    /**
     * Core fuel logic responsible for flight.
     */
	public void fuelFlight()
    {
    	boolean flag = this.isClientAirshipBurning();
        boolean flag1 = false;
        
        //Sets burn time to 0
        if(this.airshipBurnTime <= this.airship.getBaseFuelTick())
        {
        	this.airshipBurnTime = 0;
        }
        
        //Handles how burn time is ticked down
        if(this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		
        	}
        	else if(this.airship.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		
            }
        	else 
        	{
        		this.airshipBurnTime = this.airshipBurnTime - this.airship.getAirshipFuelTick();
        	}
        }
        
        //Handles when the airship is off
        if(!this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		this.airshipBurnTime = 1;
        	}
        	//Greater Water no fuel
        	else if(this.airship.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		this.airshipBurnTime = 1;
            }
        	//Airship has no controlling passenger
        	else if(this.airship.getControllingPassenger() == null)
        	{
        		this.airshipBurnTime = 0;
        	}
        	else 
        	{
        		this.airshipBurnTime = 0;
        	}
        }
        
        
        if(!this.airship.world.isRemote)
        {
        	ItemStack fuelSlot = this.airship.inventory.getStackInSlot(0);
        	
	        //Core fuel slot logic
	        if(this.isClientAirshipBurning() || !fuelSlot.isEmpty())
	        {
	            if(!this.isClientAirshipBurning()
	            && this.airship.getControllingPassenger() != null)
	            {
	                this.airshipBurnTime = getItemBurnTime(fuelSlot);
	                this.airshipTotalBurnTime = getItemBurnTime(fuelSlot);
	                
	                if(this.isClientAirshipBurning())
	                {
	                    flag1 = true;
	                    
	                    //Consumes the fuel item
	                    if(!fuelSlot.isEmpty())
	                    {
	                    	this.airship.inventory.extractItem(0, 1, false);
	                    }
	                }
	            }
	        }
        }
        
        if(flag != this.isClientAirshipBurning())
        {
            flag1 = true;
        }
    }
    
    /**
     * Is Airship Engine On
     */
    public boolean isClientAirshipBurning()
    {
    	boolean hasFuel = false;
    	
    	if(this.airshipBurnTime > 0)
    	{
    		hasFuel = true;
    	}
    	
    	return hasFuel;
    }
    
    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            //DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            
            if(ViesCraftConfig.vanillaFuel)
    		{
	            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if(block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVC.wooden_slab * 10;
	                }
	                
	                if(block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVC.wood_block_material * 10;
	                }
	                
	                if(block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVC.coal_block * 10;
	                }
	            }
	            
	            if(item == Items.STICK) return FuelVC.stick * 10;
	            if(item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling * 10;
	            if(item == Items.COAL) return FuelVC.coal * 10;
	            if(item == Items.BLAZE_ROD) return FuelVC.blaze_rod * 10;
	            
	            if(item == Items.LAVA_BUCKET) return 20000 * 10;
    		}
            
            if(item == InitItemsVC.VIESOLINE_PELLETS) return (ViesCraftConfig.viesolineBurnTime * 20) * 10;
            //if (item == InitItemsVC.airship_battery) return cap.getEnergyStored();
            
            if(ViesCraftConfig.outsideModFuel)
    		{
            	return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack) * 10;
    		}
            else
            {
            	return 0;
            }
        }
    }
    
    public static boolean isItemFuel(ItemStack stack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(stack) > 0;
    }
    
    /**
     * Calculates total fuel burn time by stack size for GUI
     */
    public void getTotalFuelSlotBurnTime()
    {
    	if(this.airship.getControllingPassenger() != null)
    	{
    		if(this.isClientAirshipBurning())
            {
    			ItemStack itemFuel = this.airship.inventory.getStackInSlot(0);
    			
    			if(!itemFuel.isEmpty())
    			{
    				this.itemFuelStackSize = this.airship.inventory.getStackInSlot(0).getCount();
    					
    				this.itemFuelStack = this.itemFuelStackSize * this.getItemBurnTime(this.airship.inventory.getStackInSlot(0));
    			}
    			else
    			{
    				this.itemFuelStack = 0;
    				this.itemFuelStackSize = 0;
    			}
            }
    		else
    		{
    			this.itemFuelStack = 0;
    			this.itemFuelStackSize = 0;
    		}
    	}
    }
}

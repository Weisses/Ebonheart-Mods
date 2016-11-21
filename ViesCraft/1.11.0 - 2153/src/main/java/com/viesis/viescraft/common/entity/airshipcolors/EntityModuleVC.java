package com.viesis.viescraft.common.entity.airshipcolors;

import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class EntityModuleVC extends EntityInventoryVC {
	
	
	//Passive
	protected static final DataParameter<Boolean> MODULE_INVENTORY_SMALL = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_INVENTORY_LARGE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_FUEL_INFINITE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MINOR = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MAJOR = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	
	//Active
	protected static final DataParameter<Boolean> MODULE_STEALTH = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_DASH = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	//private static final DataParameter<Boolean> MODULE_KEY_PRESSED = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
    
	//Cooldown Timer
	//private static final DataParameter<Integer> MODULE_CD = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	
	//Ability is On
	protected static final DataParameter<Integer> MODULE_ABILITY_ON = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	
	private int dropNumber;
	
	//Passive
    public static boolean moduleInventorySmall;
    public static boolean moduleInventoryLarge;
    public static boolean moduleFuelInfinite;
    public static boolean moduleSpeedMinor;
    public static boolean moduleSpeedMajor;
    
    //Active
    //public static boolean moduleKeyPressed;
    public static boolean moduleStealth;
    public static boolean moduleDash;
    
    //Abilities Active
    //public static boolean stealthActive;
    //public static boolean dashActive;
    
    //Cooldown Timer
    //public int moduleCD;
    public int moduleAbilityOn;
    //private boolean locked;
    
	
	public EntityModuleVC(World worldIn) 
	{
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	//==================================//
  	// TODO     Airship Modules         //
  	//==================================//
    
    public void currentModule()
    {
    	ItemStack itemModule = this.getStackInSlot(1);
		int moduleNumber = this.getModuleID(itemModule);
		
		/**
		if(this.worldObj.isRemote)
		{
			if(this.getModuleInventorySmall())
				LogHelper.info("1");
			if(this.getModuleInventoryLarge())
				LogHelper.info("2");
			if(this.getModuleSpeedMinor())
				LogHelper.info("3");
			if(this.getModuleFuelInfinite())
				LogHelper.info("4");
			if(this.getModuleStealth())
				LogHelper.info("5");
			if(this.getModuleDash())
				LogHelper.info("6");
		}
		*/
		
		//Syncs the module boolean client side
		if(this.worldObj.isRemote)
		{
    		this.moduleInventorySmall = this.getModuleInventorySmall();
    		this.moduleInventoryLarge = this.getModuleInventoryLarge();
    		this.moduleSpeedMinor = this.getModuleSpeedMinor();
    		this.moduleSpeedMajor = this.getModuleSpeedMajor();
    		this.moduleFuelInfinite = this.getModuleFuelInfinite();
    		//this.moduleStealth = this.getModuleStealth();
    		//this.moduleDash = this.getModuleDash();
		}
		
		if(moduleNumber == 1)
		{
			this.moduleInventorySmall = true;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		else if(moduleNumber == 2)
		{
			this.moduleInventoryLarge = true;
			this.moduleInventorySmall = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		else if(moduleNumber == 3)
		{
			this.moduleSpeedMinor = true;
			this.moduleSpeedMajor = false;
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleFuelInfinite = false;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		else if(moduleNumber == 4)
		{
			this.moduleFuelInfinite = true;
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		//else if(moduleNumber == 5)
		//{
		//	this.moduleStealth = true;
		//	this.moduleInventorySmall = false;
		//	this.moduleInventoryLarge = false;
		//	this.moduleSpeedMinor = false;
		//	this.moduleFuelInfinite = false;
		//	this.moduleDash = false;
		//}
		//else if(moduleNumber == 6)
		//{
			//this.moduleDash = true;
		//	this.moduleInventorySmall = false;
		//	this.moduleInventoryLarge = false;
		//	this.moduleSpeedMinor = false;
		//	this.moduleFuelInfinite = false;
			//this.moduleStealth = false;
		//}
		else if(moduleNumber == 7)
		{
			this.moduleFuelInfinite = false;
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = true;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		else// if(moduleNumber == 0)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
			//this.moduleStealth = false;
			//this.moduleDash = false;
		}
		
		//Used to drop inventory if inv modules are removed/switched
		// If there is no module in slot
		if(this.getStackInSlot(1) == null)
		{
			//If small inv mod is removed and slot is empty
			if(dropNumber == 1)
			{
				dropNumber = 0;
				this.dropInv();
			}
			
			//If large inv mod is removed and slot is empty
			if(dropNumber == 2)
			{
				dropNumber = 0;
				this.dropInv();
			}
		}
		//If a module is still in the slot
		else
		{
			//If the module in the slot is small inv mod
			if(this.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_small
			&& dropNumber == 0)
			{
				dropNumber = 1;
			}
			
			//If the module in the slot is large inv mod
			else if(this.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_large
			&& dropNumber == 0)
			{
				dropNumber = 2;
			}
			
			//If the module in the slot is not small inv mod but had it in previously
			else if(this.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_small
					&& dropNumber == 1)
			{
				dropNumber = 0;
				this.dropInv();
			}
			
			//If the module in the slot is not large inv mod but had it in previously
			else if(this.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_large
					&& dropNumber == 2)
			{
				dropNumber = 0;
				this.dropInv();
			}
		}
		
		//Saves the module boolean to server side
    	if(!this.worldObj.isRemote)
		{
			this.setModuleInventorySmall(this.moduleInventorySmall);
    		this.setModuleInventoryLarge(this.moduleInventoryLarge);
    		this.setModuleSpeedMinor(this.moduleSpeedMinor);
    		this.setModuleSpeedMajor(this.moduleSpeedMajor);
    		this.setModuleFuelInfinite(this.moduleFuelInfinite);
    		//this.setModuleStealth(this.moduleStealth);
    		//this.setModuleDash(this.moduleDash);
    	}
    }
    
    /**
     * Checks if a module is in the module slot.
     */
    public static boolean getItemModule(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }
        else
        {
            Item item = stack.getItem();
            
            //Passive
            if (item == InitItemsVC.module_inventory_small) return true;
            if (item == InitItemsVC.module_inventory_large) return true;
            if (item == InitItemsVC.module_speed_increase_minor) return true;
            if (item == InitItemsVC.module_speed_increase_major) return true;
            if (item == InitItemsVC.module_fuel_infinite) return true;
            
            //Active
            //if (item == InitItemsVC.module_stealth) return true;
            //if (item == InitItemsVC.module_dash) return true;
            return false;
        }
    }
    
    /**
     * Set module ID for module in slot.
     */
    public static int getModuleID(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            if (item == InitItemsVC.module_inventory_small)
            {
            	return 1;
            }
            else if (item == InitItemsVC.module_inventory_large)
            {
            	return 2;
            }
            else if (item == InitItemsVC.module_speed_increase_minor)
            {
            	return 3;
            }
            else if (item == InitItemsVC.module_fuel_infinite)
            {
            	return 4;
            }
            else if (item == InitItemsVC.module_speed_increase_major)
            {
            	return 7;
            }
            //else if (item == InitItemsVC.module_stealth)
            //{
            //	return 5;
            //}
            //else if (item == InitItemsVC.module_dash)
            //{
            //	return 6;
            //}
            else 
            {
            	return 0;
            }
        }
    }
    
    public static boolean isItemModule(ItemStack stack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemModule(stack);
    }
    
    /**
     * Drops inventory contents only from airship (not fuel/module)
     */
    public void dropInv()
    {
    	if(this.worldObj.isRemote)
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					this.inventory[x] = null;
				}
			}
		}
		else
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					InventoryHelper.spawnItemStack(this.worldObj, this.posX, this.posY, this.posZ, this.getStackInSlot(x));
					this.inventory[x] = null;
				}
			}
		}
    }
    
    /**
     * Sets the Small Inventory boolean to pass from server to client.
     */
    public void setModuleInventorySmall(boolean moduleInvSmall1)
    {
        this.dataManager.set(MODULE_INVENTORY_SMALL, Boolean.valueOf(moduleInvSmall1));
    }
	
    /**
     * Gets the Small Inventory boolean to pass from server to client.
     */
    public boolean getModuleInventorySmall()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_SMALL)).booleanValue();
    }
    
    /**
     * Sets the Large Inventory boolean to pass from server to client.
     */
    public void setModuleInventoryLarge(boolean moduleInvLarge1)
    {
        this.dataManager.set(MODULE_INVENTORY_LARGE, Boolean.valueOf(moduleInvLarge1));
    }
	
    /**
     * Gets the Large Inventory boolean to pass from server to client.
     */
    public boolean getModuleInventoryLarge()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_LARGE)).booleanValue();
    }
    
    /**
     * Sets the Infinite Fuel boolean to pass from server to client.
     */
    public void setModuleFuelInfinite(boolean moduleFuelInfinite1)
    {
        this.dataManager.set(MODULE_FUEL_INFINITE, Boolean.valueOf(moduleFuelInfinite1));
    }
	
    /**
     * Gets the Infinite Fuel boolean to pass from server to client.
     */
    public boolean getModuleFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_FUEL_INFINITE)).booleanValue();
    }
    
    /**
     * Sets if Minor Speed Increase mod is installed to pass from server to client.
     */
    public void setModuleSpeedMinor(boolean moduleSpeed1)
    {
        this.dataManager.set(MODULE_SPEED_MINOR, Boolean.valueOf(moduleSpeed1));
    }
    
    /**
     * Gets the Minor Speed boolean to pass from server to client.
     */
    public boolean getModuleSpeedMinor()
    {
        return ((Boolean)this.dataManager.get(MODULE_SPEED_MINOR)).booleanValue();
    }
    
    /**
     * Sets if Major Speed Increase mod is installed to pass from server to client.
     */
    public void setModuleSpeedMajor(boolean moduleSpeed2)
    {
        this.dataManager.set(MODULE_SPEED_MAJOR, Boolean.valueOf(moduleSpeed2));
    }
    
    /**
     * Gets the Major Speed boolean to pass from server to client.
     */
    public boolean getModuleSpeedMajor()
    {
        return ((Boolean)this.dataManager.get(MODULE_SPEED_MAJOR)).booleanValue();
    }
    
    /**
     * Sets the Stealth boolean to pass from server to client.
     */
    public void setModuleStealth(boolean moduleStealth1)
    {
        this.dataManager.set(MODULE_STEALTH, Boolean.valueOf(moduleStealth1));
    }
	
    /**
     * Gets the Stealth boolean to pass from server to client.
     */
    public boolean getModuleStealth()
    {
        return ((Boolean)this.dataManager.get(MODULE_STEALTH)).booleanValue();
    }
    
    /**
     * Sets the Dash boolean to pass from server to client.
     */
    public void setModuleDash(boolean moduleDash1)
    {
        this.dataManager.set(MODULE_DASH, Boolean.valueOf(moduleDash1));
    }
	
    /**
     * Gets the Dash boolean to pass from server to client.
     */
    public boolean getModuleDash()
    {
        return ((Boolean)this.dataManager.get(MODULE_DASH)).booleanValue();
    }
    
    
    
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 0)
        {
        	ItemStack itemstack = this.inventory[0];
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        }
        else if(index == 1)
        {
            ItemStack itemstack = this.inventory[1];
            return isItemModule(stack);
        }
        else
        {
        	return true;
        }
    }
    
	
}

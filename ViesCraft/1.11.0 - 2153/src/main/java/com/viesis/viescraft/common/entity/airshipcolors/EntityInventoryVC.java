package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class EntityInventoryVC extends EntityBaseVC implements IInventory {
	
	//public List<ItemStack> test = new ItemStack[1];
	private NonNullList<ItemStack> chestContents = NonNullList.<ItemStack>func_191197_a(20, ItemStack.field_190927_a);
	
	//0 is fuel slot, 1 is expansion slot 2-20(9x2 slots) is inventory.
	protected ItemStack[] inventory = new ItemStack[20];
	public String customName;
	
	public EntityInventoryVC(World worldIn) 
	{
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	//==================================//
    // TODO       Inventory             //
	//==================================//
    
    public String getCustomName() 
    {
		return this.customName;
	}
	
	public void setCustomName(String customName) 
	{
		this.customName = customName;
	}
	
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : ViesCraftConfig.v1AirshipName;
	}
	
	@Override
	public boolean hasCustomName() 
	{
		return this.customName != null && !this.customName.equals("");
	}
	
	@Override
	public ITextComponent getDisplayName() 
	{
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index <0 || index >= this.getSizeInventory())
		{
			return null;
		}
		
		return this.inventory[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(chestContents
				//this.inventory
				, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(chestContents
				//this.inventory
				, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
        this.inventory[index] = stack;
        int test = stack.func_190916_E();
        
        if (stack != null && stack.func_190916_E()
        		//stackSize
        		> this.getInventoryStackLimit())
        {
            test
        	//stack.stackSize
            = this.getInventoryStackLimit();
        }
        
        if (index == 0 && !flag)
        {
            this.markDirty();
        }
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public void markDirty() 
	{
		
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
	}
	
	@Override
	public void openInventory(EntityPlayer player) 
	{
		//player.addStat( -=Achievement=-);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		
	}
	
	
	
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.airshipBurnTime;
            case 1:
                return this.airshipTotalBurnTime;
            case 2:
                return 0;//this.fuelTime;
            case 3:
                return 0;//this.totalFuelTime;
            case 4:
                return 0;//this.airshipBeingDriven;
            case 5:
                return 0;//this.moduleInventorySmall;
            case 6:
                return 0;//this.moduleInventoryLarge;
            default:
                return 0;
        }
    }
    
    public void setField(int id, int value)
    {
        switch (id)
        {
        	//Current Airship Burn Time
            case 0:
                this.airshipBurnTime = value;
                break;
            case 1:
            	this.airshipTotalBurnTime = value;
                break;
            case 2:
                //this.fuelTime = value;
                break;
            case 3:
                //this.totalFuelTime = value;
            	break;
            case 4:
                //this.airshipBeingDriven = value;
            	break;
            case 5:
                //this.moduleInventorySmall = value;
                break;
            case 6:
                //this.moduleInventoryLarge = value;
                break;
        }
    }
    
    public int getFieldCount()
    {
        return 6;
    }
    
	@Override
	public void clear() 
	{
		for (int i = 0; i < this.inventory.length; i++)
		{
			this.inventory[i] = null;
		}
	}
	
	
	
	
	
	
	
	
	
	
	@Override
	public boolean func_191420_l() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	//Fuel
	protected static final DataParameter<Integer> POWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> TOTALPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKSIZEPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
    
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	
	public int itemFuelStackSize;
	public int itemFuelStack;
	
	

    //==================================//
	// TODO     Fuel Consumption        //
	//==================================//
    
	public void fuelFlight()
    {
    	boolean flag = this.isClientAirshipBurning();
        boolean flag1 = false;
        
        //Syncs the server info to the client
        if(this.worldObj.isRemote)
        {
        	this.airshipBurnTime = this.getPowered();
        	this.airshipTotalBurnTime = this.getTotalPowered();
        }
        
        //Handles how burn time is ticked down
        if (this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleFuelInfinite())
        	{
        		
        	}
        	//The player in the airship is in Creative Mode
        	else if(EventHandlerAirship.creativeBurnV1)
        	{
        		if(this.getEntityId() == EventHandlerAirship.playerRidingEntityV1)
        		{
	        		if(this.getControllingPassenger() == null)
	            	{
	            		--this.airshipBurnTime;
	            	}
	        		else
	        		{
	        			
	        		}
        		}
        		else
        		{
        			--this.airshipBurnTime;
        		}
        	}
        	//Airship has either Large Inventory or Minor Speed Module installed
        	else if(this.getModuleInventoryLarge()
        	|| this.getModuleSpeedMajor())
        	{
        		--this.airshipBurnTime;
        		--this.airshipBurnTime;
        	}
        	//Airship has no controlling passenger
        	else if(this.getControllingPassenger() == null)
        	{
        		--this.airshipBurnTime;
        	}
        	//Anything else
        	else
        	{
        		--this.airshipBurnTime;
        	}
        }
        
        //Handles when the airship is off
        if (!this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleFuelInfinite())
        	{
        		this.airshipBurnTime = 1;
        	}
        	//Airship has no controlling passenger
        	else if(this.getControllingPassenger() == null)
        	{
        		this.airshipBurnTime = 0;
        	}
        	//The player in the airship is in Creative Mode
        	else if(EventHandlerAirship.creativeBurnV1)
        	{
        		if (this.getEntityId() == EventHandlerAirship.playerRidingEntityV1)
            	{
            		this.airshipBurnTime = 1;
            	}
        	}
        	else 
        	{
        		this.airshipBurnTime = 0;
        	}
        }
        
        //Core fuel slot logic
        if (this.isClientAirshipBurning() || this.inventory[0] != null)
        {
            if (!this.isClientAirshipBurning())
            {
                this.airshipBurnTime = getItemBurnTime(this.inventory[0]);
                this.airshipTotalBurnTime = getItemBurnTime(this.inventory[0]);
                
                if (this.isClientAirshipBurning())
                {
                    flag1 = true;
                    
                    //Consumes the fuel item
                    if (this.inventory[0] != null)
                    {
                    	this.inventory[0].func_190918_g(1);
                        //--this.inventory[0].func_190916_E();
                        //stackSize;
                        
                        if (this.inventory[0].func_190916_E()
                        		//.stackSize
                        		== 0)
                        {
                            this.inventory[0] = inventory[0].getItem().getContainerItem(inventory[0]);
                        }
                    }
                }
            }
        }
        
        if (flag != this.isClientAirshipBurning())
        {
            flag1 = true;
        }
        
        if (flag1)
        {
            this.markDirty();
        }
        
        //Saves the fuel burntime server side
        if(!this.worldObj.isRemote)
        {
        	this.setPowered(this.airshipBurnTime);
        	this.setTotalPowered(this.airshipTotalBurnTime);
        }
    }
    
    /**
     * Is Airship Engine On
     */
    public boolean isClientAirshipBurning()
    {
    	return this.airshipBurnTime > 0;
    }
    
    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                
                if (block == Blocks.WOODEN_SLAB)
                {
                    return FuelVC.wooden_slab;
                }
                
                if (block.getDefaultState().getMaterial() == Material.WOOD)
                {
                    return FuelVC.wood_block_material;
                }
                
                if (block == Blocks.COAL_BLOCK)
                {
                    return FuelVC.coal_block;
                }
            }
            
            if (item == Items.STICK) return FuelVC.stick;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling;
            if (item == Items.COAL) return FuelVC.coal;
            if (item == Items.BLAZE_ROD) return FuelVC.blaze_rod;
            
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
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
    //TODO
    public void getTotalFuelSlotBurnTime()
    {
    	//Passes itemFuelStack to client for gui
    	if(this.worldObj.isRemote)
		{
    		this.itemFuelStack = this.getItemFuelStackPowered();
			this.itemFuelStackSize = this.getItemFuelStackSizePowered();
		}
    	
    	if(this.getControllingPassenger() != null)
    	{
    		if (this.isClientAirshipBurning())
            {
    			ItemStack itemFuel = this.getStackInSlot(0);
    			
    			if(itemFuel != null)
    			{
    				this.itemFuelStackSize = this.inventory[0].func_190916_E();
    						//.stackSize;
    					
    				this.itemFuelStack = this.itemFuelStackSize 
    						* this.getItemBurnTime(this.inventory[0]);
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
    	
    	if(!this.worldObj.isRemote)
		{
    		this.setItemFuelStackPowered(this.itemFuelStack);
			this.setItemFuelStackSizePowered(this.itemFuelStackSize);
		}
    }
    
	/**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setPowered(int airshipBurnTime1)
    {
        this.dataManager.set(POWERED, Integer.valueOf(airshipBurnTime1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public int getPowered()
    {
        return ((Integer)this.dataManager.get(POWERED)).intValue();
    }
    
    /**
     * Sets the airshipTotalBurnTime to pass from server to client.
     */
    public void setTotalPowered(int airshipTotalBurnTime1)
    {
        this.dataManager.set(TOTALPOWERED, Integer.valueOf(airshipTotalBurnTime1));
    }
	
    /**
     * Gets the airshipTotalBurnTime to pass from server to client.
     */
    public int getTotalPowered()
    {
        return ((Integer)this.dataManager.get(TOTALPOWERED)).intValue();
    }
    
    /**
     * Sets the itemFuelStack to pass from server to client.
     */
    public void setItemFuelStackPowered(int itemFuelStack1)
    {
        this.dataManager.set(ITEMFUELSTACKPOWERED, Integer.valueOf(itemFuelStack1));
    }
	
    /**
     * Gets the itemFuelStack to pass from server to client.
     */
    public int getItemFuelStackPowered()
    {
        return ((Integer)this.dataManager.get(ITEMFUELSTACKPOWERED)).intValue();
    }
    
	/**
     * Sets the itemFuelStackSize to pass from server to client.
     */
    public void setItemFuelStackSizePowered(int itemFuelStackSize1)
    {
        this.dataManager.set(ITEMFUELSTACKSIZEPOWERED, Integer.valueOf(itemFuelStackSize1));
    }
	
    /**
     * Gets the itemFuelStackSize to pass from server to client.
     */
    public int getItemFuelStackSizePowered()
    {
        return ((Integer)this.dataManager.get(ITEMFUELSTACKSIZEPOWERED)).intValue();
    }

	
    
    
    
    @Override
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		// TODO Auto-generated method stub
		return false;
	}
    
    
    /**
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.airshipBurnTime;
            case 1:
                return this.airshipTotalBurnTime;
            case 2:
                return 0;//this.fuelTime;
            case 3:
                return 0;//this.totalFuelTime;
            case 4:
                return 0;//this.airshipBeingDriven;
            case 5:
                return 0;//this.moduleInventorySmall;
            case 6:
                return 0;//this.moduleInventoryLarge;
            default:
                return 0;
        }
    }
    

    public void setField(int id, int value)
    {
        switch (id)
        {
        	//Current Airship Burn Time
            case 0:
                //this.airshipBurnTime = value;
                break;
            case 1:
            	//this.airshipTotalBurnTime = value;
                break;
            case 2:
                //this.fuelTime = value;
                break;
            case 3:
                //this.totalFuelTime = value;
            	break;
            case 4:
                //this.airshipBeingDriven = value;
            	break;
            case 5:
                //this.moduleInventorySmall = value;
                break;
            case 6:
                //this.moduleInventoryLarge = value;
                break;
        }
    }
    */
    
    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
    
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
     */
    
	
	
	
	
	
	
	
	
}

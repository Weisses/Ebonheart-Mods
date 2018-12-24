package com.vies.viesmachines.common.entity.machines;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.FuelVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.SoundsVM;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityMachineFuel extends EntityMachineBase {
	
	// Data Manager:
	/** Keeps track of the fuel value. */
	private static final DataParameter<Integer> FUEL_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the total fuel value. */
	private static final DataParameter<Integer> FUEL_TOTAL_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the item in the fuel slot value. */
	private static final DataParameter<Integer> ITEMSTACK_FUEL_ITEM_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the stack size in the fuel slot value. */
	private static final DataParameter<Integer> ITEMSTACK_FUEL_SIZE_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the energy regeneration value. */
	private static final DataParameter<Integer> ENERGY_INCREASE_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the stored micro energy value. */
	private static final DataParameter<Integer> STORED_MICRO_ENERGY_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the durability degeneration value. */
	private static final DataParameter<Integer> DURABILITY_DECREASE_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	/** Keeps track of the stored micro durability value. */
	private static final DataParameter<Integer> STORED_MICRO_DURABILITY_DM = EntityDataManager.<Integer>createKey(EntityMachineFuel.class, DataSerializers.VARINT);
	
	
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineFuel(World worldIn) 
	{
		super(worldIn);
	}
	
	public EntityMachineFuel(World worldIn, double x, double y, double z,
			
			int frameTierIn, int engineTierIn, int componentTierIn, int typeIn, 
			float healthIn, int energyIn, int durabilityIn, 
			boolean brokenIn, int currentFuelIn, int totalFuelIn, 
			int ammoAmountIn, int ammoTypeIn, 
			int machineEnhancement1In, 
			
			int visualModelFrameIn, int visualModelEngineIn, int visualModelComponentIn, 
			
			int visualFrameTextureIn, 
			boolean visualFrameTransparentIn, boolean visualFrameColorIn, 
			int visualFrameColorRedIn, 
			int visualFrameColorGreenIn, 
			int visualFrameColorBlueIn, 
			
			int visualEngineParticleIn, 
			int visualEngineDisplayTypeIn, 
			int visualEngineDisplayItemstackIn, 
			int visualEngineDisplayItemstackMetaIn, 
			int visualEngineDisplayHeadIn, 
			int visualEngineDisplaySupporterHeadIn, 
			int visualEngineDisplayHolidayIn, 
			
			int visualComponentTextureIn, 
			boolean visualComponentTransparentIn, boolean visualComponentColorIn, 
			int visualComponentColorRedIn, 
			int visualComponentColorGreenIn, 
			int visualComponentColorBlueIn, 
			
    		NBTTagCompound compoundIn, String customNameIn, int customNameColorIn)
	{
		this(worldIn);
        this.setPosition(x, y, z);
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
	}
    
    
    
	//==================================================
    // TODO              Core Inits
	//==================================================
    
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataManager.register(FUEL_DM, Integer.valueOf(0));
        this.dataManager.register(FUEL_TOTAL_DM, Integer.valueOf(0));
        this.dataManager.register(ITEMSTACK_FUEL_ITEM_DM, Integer.valueOf(0));
        this.dataManager.register(ITEMSTACK_FUEL_SIZE_DM, Integer.valueOf(0));
        this.dataManager.register(ENERGY_INCREASE_DM, Integer.valueOf(0));
        this.dataManager.register(STORED_MICRO_ENERGY_DM, Integer.valueOf(0));
        this.dataManager.register(DURABILITY_DECREASE_DM, Integer.valueOf(0));
        this.dataManager.register(STORED_MICRO_DURABILITY_DM, Integer.valueOf(0));
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		super.writeEntityToNBT(compound);
		
		compound.setInteger(rf.FUEL_TAG, this.getFuel());
		compound.setInteger(rf.FUEL_TOTAL_TAG, this.getFuelTotal());
		compound.setInteger(rf.ITEMSTACK_FUEL_ITEM_TAG, this.getItemstackFuelItem());
		compound.setInteger(rf.ITEMSTACK_FUEL_SIZE_TAG, this.getItemstackFuelSize());
		compound.setInteger(rf.ENERGY_INCREASE_TAG, this.getEnergyIncrease());
		compound.setInteger(rf.STORED_MICRO_ENERGY_TAG, this.getStoredMicroEnergy());
		compound.setInteger(rf.DURABILITY_DECREASE_TAG, this.getDurabilityDecrease());
		compound.setInteger(rf.STORED_MICRO_DURABILITY_TAG, this.getStoredMicroDurability());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);
		
		this.setFuel(compound.getInteger(rf.FUEL_TAG));
		this.setFuelTotal(compound.getInteger(rf.FUEL_TOTAL_TAG));
		this.setItemstackFuelItem(compound.getInteger(rf.ITEMSTACK_FUEL_ITEM_TAG));
		this.setItemstackFuelSize(compound.getInteger(rf.ITEMSTACK_FUEL_SIZE_TAG));
		this.setEnergyIncrease(compound.getInteger(rf.ENERGY_INCREASE_TAG));
		this.setStoredMicroEnergy(compound.getInteger(rf.STORED_MICRO_ENERGY_TAG));
		this.setDurabilityDecrease(compound.getInteger(rf.DURABILITY_DECREASE_TAG));
		this.setStoredMicroDurability(compound.getInteger(rf.STORED_MICRO_DURABILITY_TAG));
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	@Override
	public void onUpdate()
    {
		super.onUpdate();
        
		// Implements the fuel and energy systems:
		if (this.isFuelNeeded())
		{
			if (this.getPoweredOn())
			{
				this.initiateFuelSystem();
				this.initiateEnergySystem();
				this.initiateDurabilitySystem();
			}
			
            // Clears stored fuel if the machine is broken:
            if (this.getBroken())
            {
            	this.setFuel(0);
            }
		}
		
		// Shows the Item in the fuel slot regardless of creative or survival:
		if (!this.inventory.getStackInSlot(0).isEmpty())
		{
			this.setItemstackFuelItem(this.inventory.getStackInSlot(0).getItem().getIdFromItem(this.inventory.getStackInSlot(0).getItem()));
		}
		else
		{
			this.setItemstackFuelItem(0);
		}
		
		// Shows the number of Items in the fuel slot:
		if (!this.world.isRemote)
		{
			if (!this.inventory.getStackInSlot(0).isEmpty())
			{
				this.setItemstackFuelSize(this.inventory.getStackInSlot(0).getCount());
			}
			else
			{
				this.setItemstackFuelSize(0);
			}
		}
    }
	
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }
	
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }
	
	
	
	//==================================================
    // TODO              Sound Events
	//==================================================
	
	/** Gets the sound to be triggered when a machine is on/powered. */
	public SoundEvent getOnSound()
    {
        return SoundsVM.ENGINEON;
    }
    
    
    
	//==================================================
    // TODO               Data Logic
	//==================================================
    
    /** Gets the machine's fuel. */
    public final int getFuel()
    {
        return ((Integer)this.dataManager.get(FUEL_DM)).intValue();
    }
	/** Sets the machine's fuel. */
    public void setFuel(int intIn)
    {
        this.dataManager.set(FUEL_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the machine's total fuel. */
    public final int getFuelTotal()
    {
        return ((Integer)this.dataManager.get(FUEL_TOTAL_DM)).intValue();
    }
    /** Sets the machine's total fuel. */
    public void setFuelTotal(int intIn)
    {
        this.dataManager.set(FUEL_TOTAL_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the ItemStack Fuel Item. */
    public final int getItemstackFuelItem()
    {
        return ((Integer)this.dataManager.get(ITEMSTACK_FUEL_ITEM_DM)).intValue();
    }
    /** Sets the ItemStack Fuel Item. */
    public void setItemstackFuelItem(int intIn)
    {
        this.dataManager.set(ITEMSTACK_FUEL_ITEM_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the ItemStack Fuel Size. */
    public final int getItemstackFuelSize()
    {
        return ((Integer)this.dataManager.get(ITEMSTACK_FUEL_SIZE_DM)).intValue();
    }
    /** Sets the ItemStack Fuel Size. */
    public void setItemstackFuelSize(int intIn)
    {
        this.dataManager.set(ITEMSTACK_FUEL_SIZE_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------

    /** Gets the Energy Increase. */
    public final int getEnergyIncrease()
    {
        return ((Integer)this.dataManager.get(ENERGY_INCREASE_DM)).intValue();
    }
    /** Sets the Energy Increase. */
    public void setEnergyIncrease(int intIn)
    {
        this.dataManager.set(ENERGY_INCREASE_DM, Integer.valueOf(intIn));
    }

    /** Gets the machine stored micro energy. */
    public final int getStoredMicroEnergy()
    {
        return ((Integer)this.dataManager.get(STORED_MICRO_ENERGY_DM)).intValue();
    }
	/** Sets the machine stored micro energy. */
    public void setStoredMicroEnergy(int intIn)
    {
        this.dataManager.set(STORED_MICRO_ENERGY_DM, MathHelper.clamp(intIn, 0, this.getMaxEnergyIncrease()));
    }
    
    //--------------------------------------------------

    /** Gets the Durability Decrease. */
    public final int getDurabilityDecrease()
    {
        return ((Integer)this.dataManager.get(DURABILITY_DECREASE_DM)).intValue();
    }
    /** Sets the Durability Decrease. */
    public void setDurabilityDecrease(int intIn)
    {
        this.dataManager.set(DURABILITY_DECREASE_DM, Integer.valueOf(intIn));
    }

    /** Gets the machine stored micro durability. */
    public final int getStoredMicroDurability()
    {
        return ((Integer)this.dataManager.get(STORED_MICRO_DURABILITY_DM)).intValue();
    }
	/** Sets the machine stored micro durability. */
    public void setStoredMicroDurability(int intIn)
    {
        this.dataManager.set(STORED_MICRO_DURABILITY_DM, MathHelper.clamp(intIn, 0, this.getMaxDurabilityDecrease()));
    }
    
    
    
    //==================================================
    // TODO              Fuel Logic
	//==================================================
    
    /** Core fuel logic responsible for machine movement. */
	public void initiateFuelSystem()
    {
    	boolean flag = this.isFuelBurning();
        boolean flag1 = false;
        
        // Sets burn time to 0 so a fraction isn't left:
        if (this.getFuel() <= this.getBaseFuelTick())
        {
        	this.setFuel(0);
        }
        
        // Handles how stored fuel is ticked down:
        if (this.isFuelBurning())
        {
        	// Creative players don't consume fuel:
        	if (this.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
        		
        		if (player.isCreative())
        		{
        			
        		}
            	else 
            	{
            		this.setFuel(this.getFuel() - this.getBaseFuelTick());
            	}
        	}
        	else 
        	{
        		this.setFuel(this.getFuel() - this.getBaseFuelTick());
        	}
        }
        
        // Handles when the airship is off:
        if (!this.isFuelBurning())
        {
        	this.setFuel(0);
        }
        
        // Server side fuel logic:
        if (!this.world.isRemote)
        {
        	ItemStack fuelSlot = this.inventory.getStackInSlot(0);
        	
	        // Core fuel slot logic:
	        if (this.isFuelBurning() || !fuelSlot.isEmpty())
	        {
	            if (!this.isFuelBurning()
	            && this.getControllingPassenger() != null)
	            {
	                this.setFuel(getItemBurnTime(fuelSlot));
	                this.setFuelTotal(getItemBurnTime(fuelSlot));
	                
	                if (this.isFuelBurning())
	                {
	                    flag1 = true;
	                    
	                    // Consumes the fuel item:
	                    if (!fuelSlot.isEmpty())
	                    {
	                    	if (!this.getBroken())
	                    	{
	                    		this.setItemstackFuelItem(this.inventory.getStackInSlot(0).getItem().getIdFromItem(this.inventory.getStackInSlot(0).getItem()));
	                    		
	                    		this.inventory.extractItem(0, 1, false);
	                    		
	                    		this.setItemstackFuelSize(this.inventory.getStackInSlot(0).getCount());
	                    	}
	                    }
	                }
	            }
	        }
        }
        
        if (flag != this.isFuelBurning())
        {
            flag1 = true;
        }
        
        if(VMConfiguration.engineSounds)
    	{
	        if (!this.world.isRemote
	        && this.isFuelBurning()
	        && !this.getBroken()
	        //&& this.engineOnSoundSpeed > 0 
	        && this.ticksExisted % 20 == 0)
	        {
	        	this.playSound(this.getOnSound(), 0.25F, 1.0F);
	        }
    	}
        
        
        if (this.inventory.getStackInSlot(0).isEmpty()
        && this.getFuel() == 0)
        {
        	if (this.getControllingPassenger() instanceof EntityPlayer)
        	{
        		if (((EntityPlayer)this.getControllingPassenger()).isCreative())
        		{
        			this.setPoweredOn(true);
        		}
        	}
        	else
        	{
        		
        		
        		this.setPoweredOn(false);
        	}
        }
    }
    
    /** Is the machine burning fuel? */
	@Override
    public boolean isFuelBurning()
    {
		if (this.getPoweredOn())
		{
			if (this.getControllingPassenger() instanceof EntityPlayer)
	    	{
	    		EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
	    		
	    		if (player.isCreative())
	    		{
	    			return true;
	    		}
	    	}
	    	
	    	if (this.getFuel() > 0)
	    	{
	    		return true;
	    	}
		}
    	
    	return super.isFuelBurning();
    }
    
    /** Returns the number of ticks that the supplied item will keep the machine on for, or 0 if the item isn't fuel. */
    public static int getItemBurnTime(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            //KEEP FOR ENERGY SYSTEM EVENTUALLY:
            //DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            
            if (VMConfiguration.vanillaFuel)
    		{
	            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if (block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVM.wooden_slab;
	                }
	                
	                if (block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVM.wood_block_material;
	                }
	                
	                if (block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVM.coal_block;
	                }
	            }
	            
	            if (item == Items.STICK) return FuelVM.stick;
	            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVM.sapling;
	            if (item == Items.COAL) return FuelVM.coal;
	            if (item == Items.BLAZE_ROD) return FuelVM.blaze_rod;
	            
	            if (item == Items.LAVA_BUCKET) return 20000;
    		}
            
            if (item == ItemsVM.MACHINE_PELLETS) return (VMConfiguration.machinePelletsBurnTime * 20);
            
            //KEEP FOR ENERGY SYSTEM EVENTUALLY:
            //if (item == InitItemsVC.airship_battery) return cap.getEnergyStored();
            
            if (VMConfiguration.outsideModFuel)
    		{
            	return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
    		}
            else
            {
            	return 0;
            }
        }
    }
    
    /** Simple check to see if an item is fuel. */
    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }
    
    /** This calculates how much fuel is used per tick. This is just currently 1 and can change in the future. */
    protected int getBaseFuelTick()
    {
    	int fuelTick;
    	
    	fuelTick = 1;
    	
    	return fuelTick;
    }
    
    
    
    //==================================================
    // TODO             Energy Logic
	//==================================================
    
    /** Core energy logic responsible for machine energy increase while burning fuel. */
    public void initiateEnergySystem()
    {
    	if(!this.world.isRemote)
		{
    		//If the machine is burning fuel and not at max energy, increase the micro energy count.
	    	if(this.isFuelBurning()
	    	&& this.getEnergy() <= this.getMaxEnergy())
	    	{
	    		this.setStoredMicroEnergy(this.getStoredMicroEnergy() + 1);
	    	}
	    	
	    	//When micro energy gets high enough, 1 energy is added.
	    	if (this.getStoredMicroEnergy() >= this.getMaxEnergyIncrease())
	    	{
	    		this.setEnergy(this.getEnergy() + 1);
	    		this.setStoredMicroEnergy(0);
	    	}
		}
    }
    
    /** Gets the max energy increase value of a machine. */
    private int getMaxEnergyIncrease()
    {
        return EnumsVM.FlyingMachineEngineTier.byId(this.getTierEngine()).getEnergyIncreaseModifier();
    }
    
    
    
    //==================================================
    // TODO           Durability Logic
	//==================================================
    
    /** Core durability logic responsible for machine durability decrease while burning fuel. */
    public void initiateDurabilitySystem()
    {
    	if(!this.world.isRemote)
		{
    		//If the machine is burning fuel and not at 0 durability, decrease the micro durability count.
	    	if(this.isFuelBurning()
	    	&& this.getDurability() >= 1)
	    	{
	    		if (this.getControllingPassenger() instanceof EntityPlayer)
		    	{
		    		EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
		    		
		    		if (!player.isCreative())
		    		{
		    			this.setStoredMicroDurability(this.getStoredMicroDurability() + 1);
		    		}
		    	}
	    	}
	    	
	    	//When micro durability gets high enough, 1 energy is added.
	    	if (this.getStoredMicroDurability() >= this.getMaxDurabilityDecrease())
	    	{
	    		this.setDurability(this.getDurability() - 1);
	    		this.setStoredMicroDurability(0);
	    		
	    	}
		}
    }
    
    /** Gets the max durability decrease value of a machine. */
    private int getMaxDurabilityDecrease()
    {
        return EnumsVM.FlyingMachineEngineTier.byId(this.getTierComponent()).getDurabilityDecreaseModifier();
    }
    
    
    
	//==================================================
    // TODO              GUI Logic
	//==================================================
	
    /** Set variables to pass through fields, used in the CLIENT GUI. */
    public void setField(int id, int value)
    {
        switch (id)
        {
        	case 0:
                this.setFuel(value);
                break;
            case 1:
            	this.setFuelTotal(value);
                break;
            default:
            	break;
        }
    }
    
    /** Gets variables to pass through fields, used in the CLIENT GUI. */
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.getFuel();
            case 1:
                return this.getFuelTotal();
            default:
                return 0;
        }
    }
}

package com.vies.viesmachines.common.tileentity;

import javax.annotation.Nullable;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class TileEntityKitFabricator extends TileEntity implements ITickable {
    
    public ItemStackHandler inventory;
    private int size = 64;
    
    public int processTime;
    private int processTimeTotal;
    public int itemToFindMeta;
    public int procChance;
    public int procAmount;
    public boolean isOn;
    
    private String customNameVM;
    private final String defaultNameVM = "appliance_kit_fabricator";
    
    public TileEntityKitFabricator() 
    {
    	this.inventory = new ItemStackHandler(size);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.inventory;
        return super.getCapability(capability, facing);
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	
    	compound.setTag("Slots", this.inventory.serializeNBT());
    	compound.setInteger("ProcessTime", this.processTime);
    	compound.setInteger("ItemToFindMeta", this.itemToFindMeta);
    	compound.setInteger("ProcChance", this.procChance);
    	compound.setBoolean("IsOn", this.isOn);
    	
    	if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customNameVM);
        }
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    	
    	this.processTime = compound.getInteger("ProcessTime");
    	this.itemToFindMeta = compound.getInteger("ItemToFindMeta");
    	this.procChance = compound.getInteger("ProcChance");
    	this.isOn = compound.getBoolean("IsOn");
    	
        if (compound.hasKey("CustomName", 8))
        {
            this.customNameVM = compound.getString("CustomName");
        }
    }
    
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		return new SPacketUpdateTileEntity(this.pos, 3, this.getUpdateTag());
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		super.onDataPacket(net, pkt);
		
		this.itemToFindMeta = pkt.getNbtCompound().getInteger("ItemToFindMeta");
		
		this.processTime = pkt.getNbtCompound().getInteger("ProcessTime");
		this.handleUpdateTag(pkt.getNbtCompound());
	}
	
	/** Get the name of this object. For players this returns their username. */
	public String getName()
    {
        return this.hasCustomName() ? this.customNameVM : this.defaultNameVM;
    }
	
	/** Returns true if this thing is named. */
    public boolean hasCustomName()
    {
        return this.customNameVM != null && !this.customNameVM.isEmpty();
    }

	@Override
	public void update() 
	{
		this.cuttingLogic();
	}
	
	/** Wrapper for all gem cutting logic. */
    private void cuttingLogic()
    {
    	boolean hasBeenCutting = cuttingSomething();
        boolean changedCuttingState = false;
        
        if (!this.world.isRemote)
        {
        	if (this.isOn)
            {
        		// If something in input slot:
            	if (!this.inventory.getStackInSlot(0).isEmpty())
            	{
	        		this.processTimeTotal = getMaxCutTime(this.inventory.getStackInSlot(0));
	                this.procChance = getGemProc(this.inventory.getStackInSlot(0));
	                this.procAmount = this.getMultiProcChance(this.inventory.getStackInSlot(0));
	                
	        		// Start cutting:
	                if (!cuttingSomething() && canCut())
	                {
	                     if (cuttingSomething())
	                     {
	                         changedCuttingState = true;
	                     }
	                }
	                
	                // Continue cutting:
	                if (cuttingSomething() && canCut())
	                {
	                    ++this.processTime;
	                    
	                    this.syncCutTime();
	            		
	                    // Check if completed cutting a gem:
	                    if (this.processTime == this.processTimeTotal)
	                    {
	                    	double procSuccessful = References.random.nextInt(100);
	                    	this.processTime = 0;
	                    	this.processTimeTotal = getMaxCutTime(this.inventory.getStackInSlot(0));
	                    	this.procAmount = this.getMultiProcChance(this.inventory.getStackInSlot(0));
	                    	
	                        if (this.procChance >= procSuccessful)
	                        {
	                        	cutShard();
	                        }
	                        else
	                        {
	                        	this.inventory.getStackInSlot(0).shrink(1);
	                        }
	                    	
	                        changedCuttingState = true;
	                    }
	                }
	                else
	                {
	                    this.processTime = 0;
	                }
            	}
        		else
        		{
        			this.processTime = 0;
        			this.procChance = 0;
        		}
        	}
        	else
        	{
        		this.processTime = 0;
        		
        		if (!this.inventory.getStackInSlot(0).isEmpty())
            	{
        			this.procChance = getGemProc(this.inventory.getStackInSlot(0));
            	}
        		else
        		{
        			this.procChance = getGemProcNoItem();
        		}
        	}
        	
            if (!canCut()
            && this.processTime > 0)
            {
            	this.processTime = 0;
            }
            
            // Started or stopped cutting, update block to change to active or inactive model:
            if (hasBeenCutting != cuttingSomething())
            {
                changedCuttingState = true;
            }
    	}
        
        if(changedCuttingState)
        {
            this.markDirty();
        }
    }
    
    /** Returns true if the appliance can cut a Shard, i.e. has a source item, destination stack isn't full, etc. */
    private boolean canCut()
    {
        if(((ItemStack)this.inventory.getStackInSlot(0)).isEmpty())
        {
            return false;
        }
        else
        {
        	ItemStack itemstack1 = (ItemStack)this.inventory.getStackInSlot(1);
        	
        	if(itemstack1.isEmpty()) return true;
        	
    		ItemStack[] stack = new ItemStack[]
    		{
    			new ItemStack(ItemsVM.KIT_HEALTH_2, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_HEALTH_8, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_HEALTH_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_25, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_100, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_50, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_200, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_4, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_16, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_64, 1 + this.procAmount)
    		};
    		
    		if (itemstack1.getItem() != stack[this.itemToFindMeta].getItem())
    		{
    			return false;
    		}
        	
            int result = itemstack1.getCount() + stack[this.itemToFindMeta].getCount();
            return result <= 64 && result <= itemstack1.getMaxStackSize();
        }
    }
    
    /** Logic to convert ItemStack input to a Shard. */
    public void cutShard()
    {
        if(this.canCut())
        {
        	ItemStack itemstackIn = (ItemStack)this.inventory.getStackInSlot(0);
            ItemStack itemstackOut = ExtractorRecipes.CUT_GEM_OUTPUT[this.itemToFindMeta];
            
            ItemStack itemstack1 = (ItemStack)this.inventory.getStackInSlot(1);
            
    		ItemStack[] stack = new ItemStack[]
    		{
    			new ItemStack(ItemsVM.KIT_HEALTH_2, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_HEALTH_8, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_HEALTH_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_25, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_100, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_ENERGY_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_50, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_200, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_DURABILITY_MAX, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_4, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_16, 1 + this.procAmount),
    			new ItemStack(ItemsVM.KIT_AMMO_64, 1 + this.procAmount)
    		};
            
            if (itemstack1.isEmpty())
            {
            	this.inventory.insertItem(1, stack[this.itemToFindMeta], false);
            }
            else if (itemstack1.isItemEqual(stack[this.itemToFindMeta]))
            {
            	if (itemstack1.getCount() + this.procAmount > 64)
            	{
            		int reducedAmount = 
            		References.random.nextInt((itemstack1.getCount() + this.procAmount) - 64);
            		
            		if (reducedAmount == 0)
            		{
            			reducedAmount = 1;
            		}
            		
            		itemstack1.grow(reducedAmount);
            	}
            	else
            	{
            		itemstack1.grow(1 + this.procAmount);
            	}
            }
            
    		if (itemstack1.getCount() == 65)
    		{
    			itemstack1.shrink(1);
    		}
    		
    		if (itemstack1.getCount() == 66)
    		{
    			itemstack1.shrink(2);
    		}
    		
            itemstackIn.shrink(1);
        }
    }
    
    /**
     * Gets the Max time needed to process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0) For now, just returns 200.
     */
    public int getMaxCutTime(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	return 200;
        }
    }
    
    /**
     * Gets the Shard Proc % needed to successfully process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0).
     */
    public int getGemProc(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	Item item = stack.getItem();
        	
            //if(item == InitItemsVG.GEMSTONE_ITEM_UNIDENTIFIED) return 500;
            
            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                
                //if(block == Blocks.REDSTONE_ORE) return 25;
                
                //if(block.getDefaultState().getMaterial() == Material.WOOD)
                //{
                //    return 13;
                //}
                
                return 25;
            }
            
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 0) return 80;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 1) return 60;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 2) return 40;
            
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 3) return 80;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 4) return 60;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 5) return 40;
            
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 6) return 80;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 7) return 60;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 8) return 40;
            
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 9) return 80;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 10) return 60;
            if (item == ItemsVM.KIT_BLANK && this.itemToFindMeta == 11) return 40;
            
            return 0;
        }
    }
    
    public int getGemProcNoItem()
    {
        if (this.itemToFindMeta == 0) return 80;
        if (this.itemToFindMeta == 1) return 60;
        if (this.itemToFindMeta == 2) return 40;
        
        if (this.itemToFindMeta == 3) return 80;
        if (this.itemToFindMeta == 4) return 60;
        if (this.itemToFindMeta == 5) return 40;
        
        if (this.itemToFindMeta == 6) return 80;
        if (this.itemToFindMeta == 7) return 60;
        if (this.itemToFindMeta == 8) return 40;
        
        if (this.itemToFindMeta == 9) return 80;
        if (this.itemToFindMeta == 10) return 60;
        if (this.itemToFindMeta == 11) return 40;
        
        return 0;
    }
    
    /**
     * Gets the Multi Proc to process an ItemStack into a Shard.
     * @param stack - ItemStack input (Slot 0) 
     * @return
     */
    public int getMultiProcChance(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	if (this.getGemProc(stack) >= 500)
        	{
        		return 4+References.random.nextInt(2);
        	}
        	else if (this.getGemProc(stack) >= 401)
        	{
        		return 3+References.random.nextInt(2);
        	}
        	else if (this.getGemProc(stack) >= 301)
        	{
        		return 2+References.random.nextInt(2);
        	}
        	else if (this.getGemProc(stack) >= 201)
        	{
        		return 1+References.random.nextInt(2);
        	}
        	else if (this.getGemProc(stack) >= 101)
        	{
        		return 0+References.random.nextInt(2);
        	}
        	
        	return 0;
        }
    }
    
    /** Is appliance on? */
    @SideOnly(Side.CLIENT)
    public boolean isApplianceOn()
    {
    	boolean isCutting = false;
    	
    	if (this.processTime > 0)
    	{
    		isCutting = true;
    	}
    	
    	return isCutting;
    }
    
    /** Currently cutting something! */
    public boolean cuttingSomething()
    {
        return true;
    }
    
    public void syncCutTime()
    {
    	if (this.processTime == 1
    	|| this.processTime == 20
		|| this.processTime == 40
		|| this.processTime == 60
		|| this.processTime == 80
		|| this.processTime == 100
		|| this.processTime == 120
		|| this.processTime == 140
		|| this.processTime == 160
		|| this.processTime == 180
		|| this.processTime == 200)
        {
        	this.markUpdate();
        }
    }
    
    protected void markUpdate()
    {
        world.notifyBlockUpdate(this.getPos(), this.getBlockType().getDefaultState(), this.getBlockType().getDefaultState(), 0);
    }
    
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.processTime;
            case 1:
                return this.processTimeTotal;
            case 2:
                return this.procChance;
            default:
                return 0;
        }
    }
    
    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.processTime = value;
                break;
            case 1:
                this.processTimeTotal = value;
                break;
            case 2:
                this.procChance = value;
                break;
        }
    }
    
    public int getFieldCount()
    {
        return 3;
    }
}

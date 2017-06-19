package com.viesis.gemstones.common.tileentity;

import javax.annotation.Nullable;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemTool;
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

public class TileEntityGemstoneWorkbench extends TileEntity implements ITickable {
    
    //public InputItemStackHandler inventoryInput;
    public ItemStackHandler inventory;
    private int size = 2;
    public int cutTime;
    private int totalCutTime;
    public int gemstoneMeta;
    public int procChance;
    public boolean isOn;
    private String gemstoneWorkbenchCustomName;
    
    public TileEntityGemstoneWorkbench() 
    {
    	this.inventory = new ItemStackHandler(size);
    	//this.inventoryInput = new InputItemStackHandler(inventory);
    }
    
    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
    
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) this.inventory;
        return super.getCapability(capability, facing);
    }
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	compound.setTag("Slots", this.inventory.serializeNBT());
    	compound.setInteger("CutTime", this.cutTime);
    	compound.setInteger("GemstoneMeta", this.gemstoneMeta);
    	compound.setInteger("ProcChance", this.procChance);
    	compound.setBoolean("IsOn", this.isOn);
    	
    	if (this.hasCustomName())
        {
            compound.setString("CustomName", this.gemstoneWorkbenchCustomName);
        }
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	this.inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    	this.cutTime = compound.getInteger("CutTime");
    	this.gemstoneMeta = compound.getInteger("GemstoneMeta");
    	this.procChance = compound.getInteger("ProcChance");
    	this.isOn = compound.getBoolean("IsOn");
    	
        if (compound.hasKey("CustomName", 8))
        {
            this.gemstoneWorkbenchCustomName = compound.getString("CustomName");
        }
    }
    
	@Override
	@Nullable
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		return new SPacketUpdateTileEntity(this.pos, 7, this.getUpdateTag());
	}

	@Override
	public NBTTagCompound getUpdateTag() 
	{
		return this.writeToNBT(new NBTTagCompound());
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt) 
	{
		//this.setName(pkt.getNbtCompound().getString("name")); //These may help sync tile entity data.
        //this.setCost(pkt.getNbtCompound().getInteger("cost"));
        
		super.onDataPacket(net, pkt);
		handleUpdateTag(pkt.getNbtCompound());
	}
	
	/**
     * Get the name of this object. For players this returns their username
     */
	public String getName()
    {
        return this.hasCustomName() ? this.gemstoneWorkbenchCustomName : "gemstone_workbench";
    }
	
	/**
     * Returns true if this thing is named
     */
    public boolean hasCustomName()
    {
        return this.gemstoneWorkbenchCustomName != null && !this.gemstoneWorkbenchCustomName.isEmpty();
    }
	
    @Override
    public void update()
    {
    	this.cuttingLogic();
    }
    
    /**
     * Wrapper for all gem cutting logic.
     */
    private void cuttingLogic()
    {
    	boolean hasBeenCutting = cuttingSomething();
        boolean changedCuttingState = false;
    	
        if(!this.world.isRemote)
        {
        	if(this.isOn)
            {
        		//If something in input slot
            	if(!this.inventory.getStackInSlot(0).isEmpty())
            	{
	        		this.totalCutTime = getMaxCutTime(this.inventory.getStackInSlot(0));
	                this.procChance = getGemProc(this.inventory.getStackInSlot(0));
	                
	        		//Start cutting
	                if(!cuttingSomething() && canCut())
	                {
	                     if(cuttingSomething())
	                     {
	                         changedCuttingState = true;
	                     }
	                }
	                
	                //Continue cutting
	                if(cuttingSomething() && canCut())
	                {
	                    ++this.cutTime;
	                    
	                    //Check if completed cutting a gem
	                    if(this.cutTime == this.totalCutTime)
	                    {
	                    	double procSuccessful = References.random.nextInt(100);
	                    	this.cutTime = 0;
	                    	this.totalCutTime = getMaxCutTime(this.inventory.getStackInSlot(0));
	                        if(this.procChance >= procSuccessful)
	                        {
	                        	cutGem();
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
	                    this.cutTime = 0;
	                }
            	}
        		else
        		{
        			this.procChance = 0;
        		}
        	}
        	else
        	{
        		this.cutTime = 0;
        		
        		if(!this.inventory.getStackInSlot(0).isEmpty())
            	{
        			this.procChance = getGemProc(this.inventory.getStackInSlot(0));
            	}
        		else
        		{
        			this.procChance = 0;
        		}
        	}
        	
            if(!canCut()
            && this.cutTime > 0)
            {
            	this.cutTime = 0;
            }
            
            if(this.inventory.getStackInSlot(0).isEmpty()
            && this.cutTime > 0)
            {
            	this.cutTime = 0;
            }
            
            //Started or stopped cutting, update block to change to active or inactive model
            if(hasBeenCutting != cuttingSomething())
            {
                changedCuttingState = true;
                //BlockGrinder.changeBlockBasedOnGrindingStatus(cuttingSomething(), this.world, pos);
            }
    	}
	    
        if(changedCuttingState)
        {
            this.markDirty();
        }
    }
    
    /**
     * Returns true if the workbench can cut a gem, i.e. has a source item, destination stack isn't full, etc.
     */
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
        	if(!itemstack1.isItemEqual(GemCuttingRecipes.CUT_GEM_OUTPUT[this.gemstoneMeta])) return false;
        	
            int result = itemstack1.getCount() + GemCuttingRecipes.CUT_GEM_OUTPUT[this.gemstoneMeta].getCount();
            return result <= 64 && result <= itemstack1.getMaxStackSize();
        }
    }
    
    /**
     * Logic to convert ItemStack input to gem.
     */
    public void cutGem()
    {
        if(this.canCut())
        {
        	ItemStack itemstackIn = (ItemStack)this.inventory.getStackInSlot(0);
            ItemStack itemstackOut = GemCuttingRecipes.CUT_GEM_OUTPUT[this.gemstoneMeta];
        	//GemCuttingRecipes.getRandomGem(GemCuttingRecipes.CUT_GEM_OUTPUT); //Returns a Random Gem from array.
            ItemStack itemstack1 = (ItemStack)this.inventory.getStackInSlot(1);
            
            if(itemstack1.isEmpty())
            {
            	this.inventory.insertItem(1, itemstackOut, false);
            }
            else if(itemstack1.isItemEqual(GemCuttingRecipes.CUT_GEM_OUTPUT[this.gemstoneMeta]))
            {
            	itemstack1.grow(1);
            }
            
            itemstackIn.shrink(1);
        }
    }
    
    /**
     * Gets the Max time needed to process an ItemStack into a Gem.
     * @param stack ItemStack input (Slot 0) For now, just returns 100.
     * @return
     */
    public int getMaxCutTime(ItemStack stack)
    {
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
        	/**
        	Item item = stack.getItem();

            if(item instanceof net.minecraft.item.ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);

                if (block == Blocks.CLAY) return 100;
                if (block == Blocks.COBBLESTONE) return 100;
                if (block == Blocks.MOSSY_COBBLESTONE) return 100;
                if (block == Blocks.DIRT) return 100;
                //CourseDirt
                if (block == Blocks.GRAVEL) return 100;
                if (block == Blocks.SAND) return 100;
                if (block == Blocks.SANDSTONE) return 100;
                if (block == Blocks.RED_SANDSTONE) return 100;
                if (block == Blocks.STONE) return 100;
                //GRANITE
                //Diorite
                //Andesite
                if (block == Blocks.HARDENED_CLAY) return 100;
                
                if (block == Blocks.GRASS) return 100;
                if (block == Blocks.MYCELIUM) return 100;
                if (block == Blocks.GRASS_PATH) return 100;
                if (block == Blocks.FARMLAND) return 100;
                
                if (block == Blocks.NETHERRACK) return 100;
                if (block == Blocks.NETHER_BRICK) return 100;
                if (block == Blocks.RED_NETHER_BRICK) return 100;
                if (block == Blocks.ENCHANTING_TABLE) return 100;
                if (block == Blocks.QUARTZ_BLOCK) return 100;
                if (block == Blocks.OBSIDIAN) return 100;
                if (block == Blocks.PRISMARINE) return 100;
                if (block == Blocks.GLOWSTONE) return 100;
                if (block == Blocks.END_STONE) return 100;
                if (block == Blocks.PURPUR_BLOCK) return 100;
                if (block == Blocks.SEA_LANTERN) return 100;
                
                if (block.getDefaultState().getMaterial() == Material.WOOD)
                {
                    return 100;
                }

                if (block == Blocks.COAL_BLOCK)
                {
                    return 100;
                }
            }
        	*/
            return 100;
        }
    }
    
    //TODO input % gain to harvest gemstone from input ItemStack
    /**
     * Gets the Max time needed to process an ItemStack into a Gem.
     * @param stack ItemStack input (Slot 0) For now, just returns 100.
     * @return
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

            if (item instanceof net.minecraft.item.ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
            {
                Block block = Block.getBlockFromItem(item);
                
                //Low 		1-15
                if(block == Blocks.SAPLING) return 2;
                if(block == Blocks.DIRT) return 3;
                if(block == Blocks.GRASS) return 3;
                if(block == Blocks.PLANKS) return 4;
                if(block == Blocks.SAND) return 5;
                if(block == Blocks.COBBLESTONE) return 5;
                if(block == Blocks.GRAVEL) return 5;
                if(block == Blocks.LOG) return 6;
                if(block == Blocks.LEAVES) return 6;
                
                
                
                
                //Mid-Low 	15-30
                if(block == Blocks.STONE) return 10;
                if(block == Blocks.COAL_ORE) return 50;
                
                //Mid 		30-45
                if(block == Blocks.IRON_ORE) return 60;
                
                //Mid-High 	45-60
                if(block == Blocks.REDSTONE_ORE) return 75;
                if(block == Blocks.GOLD_BLOCK) return 80;
                
                //High 		60-75
                if(block == Blocks.QUARTZ_ORE) return 85;
                
                //High-Rare 75-90
                if(block == Blocks.LAPIS_ORE) return 90;
                
                //Rare 		90-100
                if(block == Blocks.BEDROCK) return 100;
                if(block == Blocks.DIAMOND_ORE) return 100;
                if(block == Blocks.EMERALD_ORE) return 100;
                
                /**
                if(block == Blocks.CLAY) return 8;
                if(block == Blocks.STONE) return 10;
                if(block == Blocks.SANDSTONE) return 10;
                if(block == Blocks.RED_SANDSTONE) return 12;
                if(block == Blocks.GRAVEL) return 15;
                if(block == Blocks.HARDENED_CLAY) return 18;
                if(block == Blocks.MOSSY_COBBLESTONE) return 20;
                if(block == Blocks.MYCELIUM) return 20;
                
                
                //Ores
                if(block == Blocks.COAL_ORE) return 50;
                if(block == Blocks.IRON_ORE) return 60;
                if(block == Blocks.REDSTONE_ORE) return 75;
                if(block == Blocks.GOLD_BLOCK) return 80;
                if(block == Blocks.LAPIS_ORE) return 90;
                if(block == Blocks.QUARTZ_ORE) return 85;
                if(block == Blocks.DIAMOND_ORE) return 100;
                if(block == Blocks.EMERALD_ORE) return 100;
                
                
                
                
                
                
                
                
                if(block == Blocks.NETHERRACK) return 15;
                if(block == Blocks.NETHER_BRICK) return 20;
                if(block == Blocks.RED_NETHER_BRICK) return 20;
                if(block == Blocks.ENCHANTING_TABLE) return 100;
                if(block == Blocks.QUARTZ_BLOCK) return 100;
                if(block == Blocks.OBSIDIAN) return 75;
                if(block == Blocks.PRISMARINE) return 100;
                if(block == Blocks.GLOWSTONE) return 85;
                if(block == Blocks.END_STONE) return 100;
                if(block == Blocks.PURPUR_BLOCK) return 100;
                if(block == Blocks.SEA_LANTERN) return 100;
                
                */
            }
            
            if(item == Items.STICK) return 5;
        	
            return 20;
        }
    }
    
    /**
     * Is workbench on?
     */
    @SideOnly(Side.CLIENT)
    public boolean isWorkbenchOn()
    {
    	boolean isCutting = false;
    	
    	if(this.cutTime > 0)
    	{
    		isCutting = true;
    	}
    	
    	return isCutting;
    }
    
    /**
     * Currently cutting something!
     * @return
     */
    public boolean cuttingSomething()
    {
        return true;
    }
    
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.cutTime;
            case 1:
                return this.totalCutTime;
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
                this.cutTime = value;
                break;
            case 1:
                this.totalCutTime = value;
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

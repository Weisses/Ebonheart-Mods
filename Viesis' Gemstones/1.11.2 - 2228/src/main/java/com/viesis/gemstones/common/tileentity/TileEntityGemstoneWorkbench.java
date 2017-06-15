package com.viesis.gemstones.common.tileentity;

import javax.annotation.Nullable;

import com.viesis.gemstones.api.internal.inventory.InputItemStackHandler;
import com.viesis.gemstones.api.util.LogHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
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
    
    public ItemStackHandler inventory;
    //public InputItemStackHandler inventoryInput;
    private int size = 2;
    private int cutTime;
    private int totalCutTime;
    public int gemstoneMeta;
    
    public TileEntityGemstoneWorkbench() 
    {
    	this.inventory = new ItemStackHandler(size);
    	//this.inventoryInput = new InputItemStackHandler(inventory);
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
    	compound.setInteger("CutTime", this.cutTime);
    	compound.setInteger("GemstoneMeta", this.gemstoneMeta);
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    	this.cutTime = compound.getInteger("CutTime");
    	this.gemstoneMeta = compound.getInteger("GemstoneMeta");
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
		handleUpdateTag(pkt.getNbtCompound());
	}
	
    @Override
    public void update()
    {
    	cuttingLogic();
    	if(!this.world.isRemote)
    	{
    		//LogHelper.info("Cut Time = " + this.cutTime + " - " + this.canCut());
    		//LogHelper.info("Item in FUEL slot = " + this.inventory.getStackInSlot(0));
    		//LogHelper.info("Item in GEM slot = " + this.inventory.getStackInSlot(1));
    		//LogHelper.info("GEM to cut = " + GemCuttingRecipes.CUT_GEM_OUTPUT[this.gemstoneMeta]);
    	}
    	if(this.world.isRemote)
    	{
    		//LogHelper.info("Client ----- " + this.gemstoneMeta);
    	}
    	
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
            //If something in input slot
        	if(!this.inventory.getStackInSlot(0).isEmpty())
            {             
        		this.totalCutTime = getMaxCutTime(this.inventory.getStackInSlot(0));
                
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
                    if (this.cutTime == this.totalCutTime)
                    {
                    	this.cutTime = 0;
                    	this.totalCutTime = getMaxCutTime(this.inventory.getStackInSlot(0));
                        //ticksPerItem = timeToGrindOneItem(grinderItemStackArray[0]);
                        cutGem();
                        changedCuttingState = true;
                    }
                }
                else
                {
                    this.cutTime = 0;
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
                //BlockGrinder.changeBlockBasedOnGrindingStatus(
                //		cuttingSomething(), this.world, pos);
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
                    return 16000;
                }
            }
        	
            return 100;
        }
    }
    public static int getItemBurnTime(ItemStack stack)
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

                if (block == Blocks.WOODEN_SLAB)
                {
                    return 150;
                }

                if (block.getDefaultState().getMaterial() == Material.WOOD)
                {
                    return 300;
                }

                if (block == Blocks.COAL_BLOCK)
                {
                    return 16000;
                }
            }

            if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName())) return 200;
            if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName())) return 200;
            if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName())) return 200;
            if (item == Items.STICK) return 100;
            if (item == Items.COAL) return 1600;
            if (item == Items.LAVA_BUCKET) return 20000;
            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return 100;
            if (item == Items.BLAZE_ROD) return 2400;
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
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
        }
    }

    public int getFieldCount()
    {
        return 2;
    }

    
}

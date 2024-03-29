package com.viesis.viescraft.common.tileentity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;

public class CopyOfTileEntityAirshipWorkbench extends TileEntity implements IInventory {
	
	private ItemStack[] inventory = new ItemStack[9];
	private String customName;
	
	public ItemStack[] craftMatrixInventory;
	
	public CopyOfTileEntityAirshipWorkbench() 
	{
		this.inventory = new ItemStack[this.getSizeInventory()];
		craftMatrixInventory = new ItemStack[9];
	}
	
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
		return this.hasCustomName() ? this.customName : "container.tile_entity_airship_workbench";
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
		if(index < 0 || index >= 9) 
		{
			return null;
		}
		return this.craftMatrixInventory[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inventory, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
        this.inventory[index] = stack;
        
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
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
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return this.worldObj.getTileEntity(this.getPos()) == this && player.getDistanceSq(this.pos.add(0.5, 0.5, 0.5)) <= 64;
	}
	
	@Override
	public void openInventory(EntityPlayer player) 
	{
		
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		
	}
	
	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack) 
	{
		return true;
	}
	
	@Override
	public int getField(int id) 
	{
		return 0;
	}
	
	@Override
	public void setField(int id, int value) 
	{
		
	}
	
	@Override
	public int getFieldCount() 
	{
		return 0;
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
	public NBTTagCompound writeToNBT(NBTTagCompound compound) 
	{
		super.writeToNBT(compound);
		
		NBTTagList nbttaglist = new NBTTagList();
        
        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        
        compound.setTag("Items", nbttaglist);
        
        
        
     // Write Crafting Matrix to NBT
        NBTTagList craftingTag = new NBTTagList();
        for (int currentIndex = 0; currentIndex < craftMatrixInventory.length; ++currentIndex) {
            if (craftMatrixInventory[currentIndex] != null) {
                NBTTagCompound tagCompound = new NBTTagCompound();
                tagCompound.setByte("Slot", (byte) currentIndex);
                craftMatrixInventory[currentIndex].writeToNBT(tagCompound);
                craftingTag.appendTag(tagCompound);
            }
        }
        compound.setTag("CraftingMatrix", craftingTag);
        
        // Write craftingResult to NBT
        //if (craftResult.getStackInSlot(0) != null)
        //    compound.setTag("CraftingResult", craftResult.getStackInSlot(0).writeToNBT(new NBTTagCompound()));
        
		return compound;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        
        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            
            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        
     // Read in the Crafting Matrix from NBT
        NBTTagList craftingTag = compound.getTagList("CraftingMatrix", 10);
        craftMatrixInventory = new ItemStack[9]; //TODO: magic number
        for (int i = 0; i < craftingTag.tagCount(); ++i) 
        {
            NBTTagCompound tagCompound = (NBTTagCompound) craftingTag.getCompoundTagAt(i);
            byte slot = tagCompound.getByte("Slot");
            if (slot >= 0 && slot < craftMatrixInventory.length) 
            {
                craftMatrixInventory[slot] = ItemStack.loadItemStackFromNBT(tagCompound);
            }
        }
        
        
        
	}
}

package com.viesis.gemstones.api.internal.inventory;

import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.items.ItemStackHandler;

public class InputItemStackHandler extends ItemStackHandler {
	
	private final ItemStackHandler internalSlot;
	
	public InputItemStackHandler(ItemStackHandler hidden) 
	{
		super();
		internalSlot = hidden;
	}
	
	@Override
	public void setSize(int size) 
	{
		stacks = NonNullList.withSize(size, ItemStack.EMPTY);
		//stacks = new ItemStackHandler[size];//internalSlot.setSize(size);//stacks = NonNullList.withSize(size, ItemStack.EMPTY);
	}
	
	@Override
	public void setStackInSlot(int slot, ItemStack stack) 
	{
		internalSlot.setStackInSlot(slot, stack);
	}
	
	@Override
	public int getSlots() 
	{
		return internalSlot.getSlots();
	}
	
	@Override
	public ItemStack getStackInSlot(int slot) 
	{
		return internalSlot.getStackInSlot(slot);
	}
	
	@Override
	public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) 
	{
		return internalSlot.insertItem(slot, stack, simulate);
	}
	
	@Override
	public ItemStack extractItem(int slot, int amount, boolean simulate) 
	{
		return internalSlot.extractItem(slot, amount, simulate);
	}
}

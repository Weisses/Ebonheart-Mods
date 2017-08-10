package com.viesis.viescraft.common.items.parts.pouch;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.network.GuiHandler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class ItemPouchAll extends Item {
	
	private static final String TAG_ITEMS = "InvItemsAll";
	
	public ItemPouchAll() 
	{
		ItemHelper.setItemName(this, "item_pouch_all");
		
		this.setMaxDamage(0);
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@Override
	public ICapabilityProvider initCapabilities(ItemStack stack, NBTTagCompound oldCapNbt) 
	{
		return new InvProviderAll();
	}
	
	private static class InvProviderAll implements ICapabilitySerializable<NBTBase> {
		
		private final IItemHandler inv = new ItemStackHandler(24);
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) 
		{
			return capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY;
		}
		
		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) 
		{
			if(capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY)
			{
				return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.cast(inv);
			}
			else 
			{
				return null;
			}
		}
		
		@Override
		public NBTBase serializeNBT() 
		{
			return CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.writeNBT(inv, null);
		}
		
		@Override
		public void deserializeNBT(NBTBase nbt) 
		{
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(inv, null, nbt);
		}
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean selected) 
	{
		if(stack.getTagCompound() != null && stack.getTagCompound().hasKey(TAG_ITEMS)) 
		{
			NBTTagList oldData = stack.getTagCompound().getTagList(TAG_ITEMS, Constants.NBT.TAG_COMPOUND);
			IItemHandler newInv = stack.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null);
			
			CapabilityItemHandler.ITEM_HANDLER_CAPABILITY.readNBT(newInv, null, oldData);
			
			stack.getTagCompound().removeTag(TAG_ITEMS);
			
			if(stack.getTagCompound().getSize() == 0)
			{
				stack.setTagCompound(null);
			}
		}
	}
	
	@Nonnull
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand) 
	{
		playerIn.openGui(ViesCraft.instance, GuiHandler.GUI_ITEM_POUCH_ALL, worldIn, hand == EnumHand.OFF_HAND ? 1 : 0, 0, 0);
		return ActionResult.newResult(EnumActionResult.SUCCESS, playerIn.getHeldItem(hand));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced)
    {
		tooltip.add(TextFormatting.DARK_PURPLE + I18n.translateToLocal("vc.item.tt.pouchall.1"));
		tooltip.add(TextFormatting.DARK_PURPLE + I18n.translateToLocal("vc.item.tt.pouchall.2"));
    }
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
}

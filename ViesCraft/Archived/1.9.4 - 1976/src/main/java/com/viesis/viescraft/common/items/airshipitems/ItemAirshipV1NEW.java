package com.viesis.viescraft.common.items.airshipitems;

import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemAirshipV1NEW extends ItemAirshipCore {
	
	public int metaColor;
	
	public ItemAirshipV1NEW(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, "v1/item_airship_v1");
		this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV1);
	}
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected)
    {
		final NBTTagCompound stackTagCompound = this.getOrCreateTagCompound(stack);
		
		if(this.getMetadata(stack) == 0)
		{
			stackTagCompound.setInteger("Meta", 5);
			LogHelper.info("T = true!");
		}
		
		LogHelper.info("Meta = " + this.metaColor);
    }
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
        //ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		--itemStackIn.stackSize;
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV1 entityairship = new EntityItemAirshipV1(worldIn, playerIn, EntityAirshipBaseVC.Frame.WOOD0.ordinal(), this.getMetadata(itemStackIn));
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntityInWorld(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
		}
        
		return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (EntityAirshipBaseVC.Frame.WOOD0.getName() + " " 
        		+ EntityAirshipBaseVC.Color.byId(this.getMetadata(stack)).getName() + " " 
        		+ ViesCraftConfig.v1AirshipName);
    }
	
	public void setMetaColor(int meta)
	{
		meta = this.metaColor;
	}
	
	public int getMetaColor()
    {
        return this.metaColor;
    }
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
		
		ItemStack itemstack = player.getHeldItem(EnumHand.MAIN_HAND);
		
		
		if (entity instanceof EntityAirshipBaseVC)
        {
			if(player.isSneaking())
			{
				player.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(InitItemsVC.item_airship_v1));
				return true;
			}
			return true;
        }
        return false;
		//this.setMetaColor(7);
		
		
    }
	
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
		NBTTagCompound comp = new NBTTagCompound();
		
		comp.setInteger("Meta", this.metaColor);
		
		return comp;
		
    }
	
	public void readFromNBT()
	{
		NBTTagCompound comp = new NBTTagCompound();
		
		this.metaColor = comp.getInteger("Meta");
		
	}
	
	
	public static NBTTagCompound getOrCreateTagCompound(ItemStack itemStack) {
		if (!itemStack.hasTagCompound()) {
			itemStack.setTagCompound(new NBTTagCompound());
		}

		final NBTTagCompound tagCompound = itemStack.getTagCompound();
		assert tagCompound != null;

		return tagCompound;
	}
	
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Frame contents : EntityAirshipBaseVC.Frame.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

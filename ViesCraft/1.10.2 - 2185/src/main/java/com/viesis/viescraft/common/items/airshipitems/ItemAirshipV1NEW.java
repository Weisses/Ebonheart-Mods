package com.viesis.viescraft.common.items.airshipitems;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemAirshipV1NEW extends ItemAirshipCore {
	
	public ItemAirshipV1NEW(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, "v1/item_airship_v1");
		this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV1);
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
	
	@SideOnly(Side.CLIENT)
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EntityAirshipBaseVC.Color contents : EntityAirshipBaseVC.Color.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
	
	
}

package com.viesis.viescraft.common.items.airshipitems.v4;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemAirshipV4;
import com.viesis.viescraft.common.items.ItemHelper;
import com.viesis.viescraft.common.items.airshipitems.ItemAirshipCore;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class ItemAirshipV4Iron extends ItemAirshipCore {
	
	public ItemAirshipV4Iron(String unlocalizedName) 
	{
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
        ItemHelper.setItemName(this, "v4/iron/item_airship_v4");
		this.setCreativeTab(ViesCraft.tabViesCraftAirshipsV4);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        if(playerIn.isSneaking())
		{
        	if (!playerIn.capabilities.isCreativeMode)
        	{
        		itemstack.shrink(1);
        	}
        	
			worldIn.playSound((EntityPlayer)null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_EXPERIENCE_BOTTLE_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!worldIn.isRemote)
			{
				EntityItemAirshipV4 entityairship = new EntityItemAirshipV4(worldIn, playerIn, EntityAirshipBaseVC.Frame.IRON.ordinal(), this.getMetadata(itemstack));
				entityairship.setHeadingFromThrower(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
				worldIn.spawnEntity(entityairship);
			}
			
			playerIn.addStat(StatList.getObjectUseStats(this));
			return new ActionResult(EnumActionResult.SUCCESS, itemstack);
		}
		return new ActionResult(EnumActionResult.SUCCESS, itemstack);
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        return (EntityAirshipBaseVC.Frame.IRON.getName() + " " 
        		+ EntityAirshipBaseVC.Color.byId(this.getMetadata(stack)).getName() + " " 
        		+ ViesCraftConfig.v4AirshipName);
    }
}

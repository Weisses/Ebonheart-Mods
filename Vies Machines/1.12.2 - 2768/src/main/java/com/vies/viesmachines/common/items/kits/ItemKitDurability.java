package com.vies.viesmachines.common.items.kits;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKitDurability extends Item {
	
	private int repairItem;
	private EnumRarity rarity;
	private String procName;
	
	public ItemKitDurability(String unlocalizedName, EnumRarity rarityIn, int durabilityItemIn) 
	{
		this.setMaxStackSize(64);
		this.repairItem = durabilityItemIn;
		this.rarity = rarityIn;
		
		this.procName = "KitDurabilityProc_" + this.rarity;
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			// If this machine is fully healed, ignore all below code:
			if (((EntityMachineBase) entity).getDurability() == ((EntityMachineBase) entity).getMaxDurability())
        	{
				return true;
        	}
			
			// Heals the machine for 50 Durability:
			if(this.repairItem == 0)
			{
				((EntityMachineBase) entity).replenishDurability(50);
		    	
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_50.getMetadata());
				
		    	return true;
			}
			
			// Heals the machine for 200 Durability:
			if(this.repairItem == 1)
			{
				((EntityMachineBase) entity).replenishDurability(200);
		    	
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_200.getMetadata());
				
		    	return true;
			}
			
			// Heals the machine for Max Durability:
			if(this.repairItem == 2)
			{
				((EntityMachineBase) entity).setDurability(((EntityMachineBase) entity).getMaxDurability());
				
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_MAX.getMetadata());
				
		    	return true;
			}
        }
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					// If this machine is fully healed, ignore all below code:
					if (((EntityMachineBase) entity.getRidingEntity()).getDurability() == ((EntityMachineBase) entity.getRidingEntity()).getMaxDurability())
		        	{
						return true;
		        	}
					
					// Heals the machine for 50 Durability:
					if(this.repairItem == 0)
					{
						((EntityMachineBase) entity.getRidingEntity()).replenishDurability(50);
				    	
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_50.getMetadata());
						
				    	return true;
					}
					
					// Heals the machine for 200 Durability:
					if(this.repairItem == 1)
					{
						((EntityMachineBase) entity.getRidingEntity()).replenishDurability(200);
				    	
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_200.getMetadata());
						
				    	return true;
					}
					
					// Heals the machine for Max Durability:
					if(this.repairItem == 2)
					{
						((EntityMachineBase) entity.getRidingEntity()).setDurability(((EntityMachineBase) entity.getRidingEntity()).getMaxDurability());
						
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.DURABILITY_MAX.getMetadata());
						
				    	return true;
					}
				}
			}
        }
		else
		{
			return true;
		}
		
		return true;
    }
	
	@Override
    public boolean itemInteractionForEntity(ItemStack itemstack, net.minecraft.entity.player.EntityPlayer player, EntityLivingBase entity, net.minecraft.util.EnumHand hand)
    {
        if(entity.world.isRemote)
        {
            return false;
        }
        
        if(entity instanceof EntityMachineBase)
        {
        	return true;
        }
        
        return false;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		TextFormatting color = TextFormatting.GOLD;
		
		if (this.rarity == EnumRarity.RARE)
		{
			color = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			color = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(color + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add("");
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines.leftclick") + " " + color + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }
}

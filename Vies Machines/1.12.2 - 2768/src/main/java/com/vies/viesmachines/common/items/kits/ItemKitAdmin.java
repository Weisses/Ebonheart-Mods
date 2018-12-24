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
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemKitAdmin extends Item {
	
	private int repairItem;
	private EnumRarity rarity;
	
	public ItemKitAdmin(String unlocalizedName, EnumRarity rarityIn, int repairItemIn) 
	{
		this.setMaxStackSize(64);
		this.repairItem = repairItemIn;
		this.rarity = rarityIn;
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			// Upgrades all Tiers:
			if(this.repairItem == 0)
			{
				((EntityMachineBase) entity).setTierFrame(3);
				((EntityMachineBase) entity).setTierEngine(3);
				((EntityMachineBase) entity).setTierComponent(3);
				
				// Sets the max health attribute:
				((EntityMachineBase) entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity).getTierFrame()).getMaxHealthModifier());
		        
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
				
		    	return true;
			}
			
			// Upgrades all Tiers, gives max health and energy:
			if(this.repairItem == 1)
			{
				((EntityMachineBase) entity).setTierFrame(3);
				((EntityMachineBase) entity).setTierEngine(3);
				((EntityMachineBase) entity).setTierComponent(3);
				
				// Sets the max health attribute:
				((EntityMachineBase) entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity).getTierFrame()).getMaxHealthModifier());
		        
				// If this machine is broken, fix it:
				if (((EntityMachineBase) entity).getBroken())
				{
					((EntityMachineBase) entity).setBroken(false);
				}
				
				((EntityMachineBase) entity).setHealth(((EntityMachineBase) entity).getMaxHealth());
				((EntityMachineBase) entity).setEnergy(((EntityMachineBase) entity).getMaxEnergy());
				((EntityMachineBase) entity).setDurability(((EntityMachineBase) entity).getMaxDurability());
				
				((EntityMachineBase) entity).setAmmoAmount(((EntityMachineBase) entity).getMaxAmmoAmount());
				
				
				if(!player.isCreative())
				{
					stack.shrink(1);
				}
				
				((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
				
		    	return true;
			}
        }
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					// Upgrades all Tiers:
					if(this.repairItem == 0)
					{
						((EntityMachineBase) entity.getRidingEntity()).setTierFrame(3);
						((EntityMachineBase) entity.getRidingEntity()).setTierEngine(3);
						((EntityMachineBase) entity.getRidingEntity()).setTierComponent(3);
						
						// Sets the max health attribute:
						((EntityMachineBase) entity.getRidingEntity()).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity.getRidingEntity()).getTierFrame()).getMaxHealthModifier());
				        
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
						
				    	return true;
					}
					
					// Upgrades all Tiers, gives max health and energy:
					if(this.repairItem == 1)
					{
						((EntityMachineBase) entity.getRidingEntity()).setTierFrame(3);
						((EntityMachineBase) entity.getRidingEntity()).setTierEngine(3);
						((EntityMachineBase) entity.getRidingEntity()).setTierComponent(3);
						
						// Sets the max health attribute:
						((EntityMachineBase) entity.getRidingEntity()).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity.getRidingEntity()).getTierFrame()).getMaxHealthModifier());
						
						// If this machine is broken, fix it:
						if (((EntityMachineBase) entity.getRidingEntity()).getBroken())
						{
							((EntityMachineBase) entity.getRidingEntity()).setBroken(false);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setHealth(((EntityMachineBase) entity.getRidingEntity()).getMaxHealth());
						((EntityMachineBase) entity.getRidingEntity()).setEnergy(((EntityMachineBase) entity.getRidingEntity()).getMaxEnergy());
						((EntityMachineBase) entity.getRidingEntity()).setDurability(((EntityMachineBase) entity.getRidingEntity()).getMaxDurability());
						
						((EntityMachineBase) entity.getRidingEntity()).setAmmoAmount(((EntityMachineBase) entity.getRidingEntity()).getMaxAmmoAmount());
						
						if(!player.isCreative())
						{
							stack.shrink(1);
						}
						
						((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
						
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
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.DARK_RED + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add(TextFormatting.DARK_RED + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines.leftclick") + " " + TextFormatting.DARK_RED + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.3"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		return TextFormatting.GOLD + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".name");
    }
}

package com.vies.viesmachines.common.items.upgrades;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.items.ItemHelper;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAlreadyKnown;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier1;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier2;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeAppliedTier3;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeBroken;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeRequiredTier1;
import com.vies.viesmachines.network.server.world.upgrade.PlayerMessageUpgradeRequiredTier2;

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

public class ItemUpgradeFrame extends Item {
	
	private EnumRarity rarity;
	private int upgradeTier;
	private String procName;
	
	public ItemUpgradeFrame(String unlocalizedNameIn, EnumRarity rarityIn, int upgradeTierIn) 
	{
		this.setMaxStackSize(1);
		
		this.rarity = rarityIn;
		this.upgradeTier = upgradeTierIn;
		
		this.procName = "UpgradeFrameProc";
		
		ItemHelper.setItemName(this, unlocalizedNameIn);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@Override
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
		if (entity instanceof EntityMachineBase)
        {
			if (!((EntityMachineBase) entity).getBroken())
			{
				if (((EntityMachineBase) entity).getTierFrame() < (this.upgradeTier)
				&& ((EntityMachineBase) entity).getTierFrame() == (this.upgradeTier - 1))
				{
					((EntityMachineBase) entity).setTierFrame(this.upgradeTier);

					// Adjusts the max health attribute:
					((EntityMachineBase) entity).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity).getTierFrame()).getMaxHealthModifier());
					
					if (!player.isCreative())
					{
						stack.shrink(1);
					}
					
					if (((EntityMachineBase) entity).getTierFrame() == 1)
					{
						((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER1.getMetadata());
						
						if (player.world.isRemote)
						{
							NetworkHandler.sendToServer(new PlayerMessageUpgradeAppliedTier1());
						}
					}
					else if (((EntityMachineBase) entity).getTierFrame() == 2)
					{
						((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER2.getMetadata());
						
						if (player.world.isRemote)
						{
							NetworkHandler.sendToServer(new PlayerMessageUpgradeAppliedTier2());
						}
					}
					else if (((EntityMachineBase) entity).getTierFrame() == 3)
					{
						((EntityMachineBase) entity).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
						
						if (player.world.isRemote)
						{
							NetworkHandler.sendToServer(new PlayerMessageUpgradeAppliedTier3());
						}
					}
	        	}
				else
				{
					
					
					
					if (((EntityMachineBase) entity).getTierFrame() == 0)
					{
						if (this.upgradeTier == 0)
						{
							if (player.world.isRemote)
							{
								NetworkHandler.sendToServer(new PlayerMessageUpgradeAlreadyKnown());
							}
						}
						else
						{
							if (player.world.isRemote)
							{
								NetworkHandler.sendToServer(new PlayerMessageUpgradeRequiredTier1());
							}
						}
					}
					else if (((EntityMachineBase) entity).getTierFrame() == 1)
					{
						if (this.upgradeTier == 1)
						{
							if (player.world.isRemote)
							{
								NetworkHandler.sendToServer(new PlayerMessageUpgradeAlreadyKnown());
							}
						}
						else
						{
							if (player.world.isRemote)
							{
								NetworkHandler.sendToServer(new PlayerMessageUpgradeRequiredTier1());
							}
						}
					}
					else if (((EntityMachineBase) entity).getTierFrame() == 2)
					{
						if (this.upgradeTier == 2)
						{
							if (player.world.isRemote)
							{
								NetworkHandler.sendToServer(new PlayerMessageUpgradeAlreadyKnown());
							}
						}
					}
				}
			}
			else
			{
				if (player.world.isRemote)
				{
					NetworkHandler.sendToServer(new PlayerMessageUpgradeBroken());
				}
			}
        }
		else if(entity instanceof EntityLiving)
        {
			if (entity.getRidingEntity() != null)
			{
				if (entity.getRidingEntity() instanceof EntityMachineBase)
				{
					if (!((EntityMachineBase) entity.getRidingEntity()).getBroken())
					{
						if (((EntityMachineBase) entity.getRidingEntity()).getTierFrame() < (this.upgradeTier)
						&& ((EntityMachineBase) entity.getRidingEntity()).getTierFrame() == (this.upgradeTier - 1))
						{
							((EntityMachineBase) entity.getRidingEntity()).setTierFrame(this.upgradeTier);

							// Adjusts the max health attribute:
							((EntityMachineBase) entity.getRidingEntity()).getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue((double)EnumsVM.FlyingMachineFrameTier.byId(((EntityMachineBase) entity.getRidingEntity()).getTierFrame()).getMaxHealthModifier());
							
							if (!player.isCreative())
							{
								stack.shrink(1);
							}
							
							if (((EntityMachineBase) entity.getRidingEntity()).getTierFrame() == 1)
							{
								((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER1.getMetadata());
							}
							else if (((EntityMachineBase) entity.getRidingEntity()).getTierFrame() == 2)
							{
								((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER2.getMetadata());
							}
							else if (((EntityMachineBase) entity.getRidingEntity()).getTierFrame() == 3)
							{
								((EntityMachineBase) entity.getRidingEntity()).setEventTrigger(EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata());
							}
			        	}
					}
				}
			}
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
		TextFormatting textColor = TextFormatting.GRAY;
		
		if (this.rarity == EnumRarity.UNCOMMON)
		{
			textColor = TextFormatting.GOLD;
		}
		
		if (this.rarity == EnumRarity.RARE)
		{
			textColor = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			textColor = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		tooltip.add(TextFormatting.WHITE + References.Old_I18n.translateToLocal("viesmachines.leftclick") + " " + textColor + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add("");
		tooltip.add(textColor + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
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

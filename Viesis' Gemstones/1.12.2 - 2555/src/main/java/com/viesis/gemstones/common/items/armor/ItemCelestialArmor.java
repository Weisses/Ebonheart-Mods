package com.viesis.gemstones.common.items.armor;

import java.util.List;
import java.util.Random;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.items.ItemHelper;
import com.viesis.gemstones.common.items.MaterialHelper;
import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Soularite
public class ItemCelestialArmor extends ItemArmor {
	
	double playerPosX;
	double playerPosY;
	double playerPosZ;
	
	Random random = new Random();
	
	public ItemCelestialArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.CELESTIAL, renderIndexIn, equipmentSlotIn);
		
		ItemHelper.setItemName(this, unlocalizedName);
		//this.setCreativeTab(ViesisGemstones.tabEbonArtsItems);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
		return new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 0) == repair ? true : super.getIsRepairable(toRepair, repair);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "Divine armor with the soul");
		toolTip.add(TextFormatting.DARK_PURPLE + "of an Archangel.");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + "Set Bonus:");
		toolTip.add(TextFormatting.GREEN + "Ability - Flight.");
		toolTip.add(TextFormatting.GREEN + "Ability - Safe Fall.");
		//toolTip.add(TextFormatting.GREEN + "Speed increased by 120%");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	/**
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsVG.celestial_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsVG.celestial_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsVG.celestial_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsVG.celestial_boots) 
		{
			if(!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.CELESTIAL_SPEED_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(VGAttributeModifier.CELESTIAL_SPEED_BONUS);
			}
			
			
			
			if (!player.capabilities.isCreativeMode)
			{
				
				if (player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.CELESTIAL_SPEED_BONUS) 
					&& !player.capabilities.allowFlying)
				
				{
					player.capabilities.allowFlying = true;
				}
				
				
				if (world.isRemote)
				{
					if (player.capabilities.isFlying)
					{
						
						player.addVelocity(-(player.motionX * .1), -(player.motionY * .15), -(player.motionZ * .1));
						
					}
					
				}
				
			}
			
			if(!ViesisGemstonesConfig.armorParticle)
			{
				if (world.isRemote)
				{
					if (player.capabilities.isFlying)
					{
						if(player.motionX != 0 || player.motionY != 0 || player.motionX != 0)
						{
							int d = random.nextInt(100) + 1;
							
							if (d <= 25)
							{
									
								ViesisGemstones.proxy.generateFlightParticles(player);
									
							}
								
						}
							
					}
						
				}
					
			}
			
		}
		/**	if (!player.capabilities.isCreativeMode)
			{
				
				if (!player.capabilities.allowFlying)
				{
					player.capabilities.allowFlying = true;
				}
				
				if (world.isRemote)
				{
					if (player.capabilities.isFlying)
					{
						
						player.addVelocity(-(player.motionX * .1), -(player.motionY * .15), -(player.motionZ * .1));
						
					}
					
				}
				
			}
			
			if(!EbonArtsConfiguration.armorParticle)
			{
				if (world.isRemote)
				{
					if (player.capabilities.isFlying)
					{
						if(player.motionX != 0 || player.motionY != 0 || player.motionX != 0)
						{
							int d = random.nextInt(100) + 1;
							
							if (d <= 25)
							{
									
								EbonArtsMod.proxy.generateFlightParticles(player);
									
							}
								
						}
							
					}
						
				}
					
			}
				
		}
		else
		{
			if (!player.capabilities.isCreativeMode)
			{
				player.capabilities.isFlying = false;
				player.capabilities.allowFlying = false;
			}
		}
		
		
	}*/
}

package com.ebonheart.EbonArtsMod.common.items.zzzTEMP.armor;

import java.util.List;
import java.util.Random;

import com.ebonheart.EbonArtsMod.EbonArts;
import com.ebonheart.EbonArtsMod.common.entity.modifiers.EAAttributeModifier;
import com.ebonheart.EbonArtsMod.common.items.MaterialHelper;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.configs.EbonArtsConfiguration;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.PlayerCapabilities;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.client.ForgeHooksClient;
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
		this.setCreativeTab(ViesisGemstones.tabEbonArtsItems);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return InitItemsVG.soularite == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
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
		
		*/
	}
}

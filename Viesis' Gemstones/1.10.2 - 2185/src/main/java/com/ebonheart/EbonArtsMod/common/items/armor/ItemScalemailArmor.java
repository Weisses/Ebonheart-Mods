package com.ebonheart.EbonArtsMod.common.items.armor;

import java.util.List;
import java.util.Random;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.entity.modifiers.EAAttributeModifier;
import com.ebonheart.EbonArtsMod.common.items.MaterialHelper;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.configs.EbonArtsConfiguration;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.entity.EntityLiving;
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
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Katcheen
public class ItemScalemailArmor extends ItemArmor {
	
	public static boolean isDoubleJumping;
	
	double playerPosX;
	double playerPosY;
	double playerPosZ;
	
	Random random = new Random();
	
	public ItemScalemailArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.SCALEMAIL, renderIndexIn, equipmentSlotIn);
		
		ItemHelper.setItemName(this, unlocalizedName);
		this.setCreativeTab(EbonArtsMod.tabEbonArtsItems);
	}
	
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return InitItemsEA.katcheen == repair.getItem() ? true : super.getIsRepairable(toRepair, repair);
    }
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_AQUA + "Strong scales are woven in a flexible");
		toolTip.add(TextFormatting.DARK_AQUA + "mesh, enhancing acrobatics.");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + "Set Bonus:");
		toolTip.add(TextFormatting.GREEN + "Ability - Double Jump.");
		toolTip.add(TextFormatting.GREEN + "Ability - Safe Fall.");
		//toolTip.add(TextFormatting.GREEN + "Speed increased by 110%");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsEA.scalemail_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsEA.scalemail_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsEA.scalemail_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsEA.scalemail_boots) 
		{
			if(player.fallDistance >= 2)
			{
				player.fallDistance = 0;
			}
			
			if(player.onGround) 
			{
				isDoubleJumping = false;
			}
			
			if (world.isRemote)
			{
				
				if (isDoubleJumping)
				{
					
					if(!EbonArtsConfiguration.armorParticle)
					{
						
						if(world.isRemote)
						{
							
							playerPosX = player.getPositionVector().xCoord;
							playerPosY = player.getPositionVector().yCoord;
							playerPosZ = player.getPositionVector().zCoord;
							
							int d = random.nextInt(100) + 1;
							
							if (d <= 25)
							{
								
								world.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, playerPosX, playerPosY, playerPosZ, (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), new int[0]);
								
							}
							
						}
						
					}
					
				}
				
				if(Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed())
				{
					
					if(!player.onGround && !isDoubleJumping)
					{
						isDoubleJumping = true;
						player.addVelocity(0, (-(player.motionY) + 0.6F), 0);
					}
					
				}
				
			}
			
		}
		
	}
	
}

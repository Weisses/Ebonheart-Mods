package com.ebonheart.EbonArtsMod.common.items.armor;

import java.util.List;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.entity.modifiers.EAAttributeModifier;
import com.ebonheart.EbonArtsMod.common.items.MaterialHelper;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentThorns;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Katcheen
public class ItemInfernalArmor extends ItemArmor {
	
	public static boolean isDoubleJumping;
	
	public ItemInfernalArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
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
		toolTip.add(TextFormatting.DARK_AQUA + "Fire resistance???");
		toolTip.add(TextFormatting.DARK_AQUA + "Maaayyybbbbeeeeee?????");
		toolTip.add(" ");
		toolTip.add(TextFormatting.WHITE + " ");
		toolTip.add(TextFormatting.GREEN + "-");
		toolTip.add(TextFormatting.GREEN + "-");
		//toolTip.add(TextFormatting.GREEN + "Speed increased by 110%");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.RARE;
    }
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsEA.infernal_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsEA.infernal_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsEA.infernal_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsEA.infernal_boots) 
		{
			
			
			
			
			
			
			
			
			
			//if(!player.isImmuneToFire())
			//{
			//	player.isImmuneToFire();
			//}
			
			//if(EntityDamageSource.lava != null)
			//{
				
				
			//LivingAttackEvent event = new LivingAttackEvent(player, null, damageReduceAmount);
			
			
				//player.setEntityInvulnerable(EntityDamageSource.inFire);
				//player.setEntityInvulnerable(player.isEntityInvulnerable(EntityDamageSource.lava));
				//player.setEntityInvulnerable(player.isEntityInvulnerable(EntityDamageSource.onFire));
				
				//player.isEntityInvulnerable(EntityDamageSource.lava);
				
				//player.setEntityInvulnerable(EntityDamageSource.lava.setFireDamage());
				
				//player.isEntityInvulnerable(EntityDamageSource.onFire);
				//player.isEntityInvulnerable(EntityDamageSource.inFire);
				
				//@ForgeSubscribe
				//public void onBurnDamage(LivingAttackEvent event)
				//{
				    //if(event.entity instanceof EntityPlayer)
				    //{
				
				        //EntityPlayer player = (EntityPlayer)event.getSource();
				    	//if(event.equals(DamageSource.lava) 
				    	//    || event.equals(DamageSource.inFire) 
				    	//    || event.equals(DamageSource.onFire))
				    	//    {
				                 //if(player.ridingEntity instanceof EntityChocoboPurple)
				    		//{
				    	//	    event.setCanceled(true);
				    		//}
				    	//    }
				       //}
				   //}
				//}
				
			//}
			//EntityPlayer.isImmuneToFire();
			//player.isImmuneToFire();
			//player.isImmuneToExplosions();
			
			//player.fireResistance = 99;
			
			//player.extinguish();
			
			
			//Enchantment.getEnchantmentByID(1);
			//player.isBurning();
			
			
			
			//if(player.isInLava())
			//{
				
			//	player.isImmuneToFire();
			//	player.extinguish();
				
			//}
			
			//if(player.isBurning())
			//{

			//	player.isImmuneToFire();
			//	player.extinguish();
				
			//}
			
			/**
			player.fallDistance = 0;
			if(!player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS))
			{
				player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).applyModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS);
				player.fallDistance = 0;
			}
			
			if(player.onGround) 
			{
				isDoubleJumping = false;
			}
			
			if (world.isRemote)
			{
				if(Minecraft.getMinecraft().gameSettings.keyBindJump.isPressed())
				{
					if(!player.onGround && !isDoubleJumping)
					{
						player.addVelocity(0, 0.6F, 0);
						//player.setVelocity(player.motionX, 0.6F, player.motionZ);
						isDoubleJumping = true;
					}
				}
			}
		}
		else
		{
			player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.SCALEMAIL_SPEED_BONUS);
		**/
		}
		
	}
}

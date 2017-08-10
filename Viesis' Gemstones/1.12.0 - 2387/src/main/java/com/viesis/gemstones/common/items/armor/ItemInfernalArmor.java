package com.viesis.gemstones.common.items.armor;

import java.util.List;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

//Katcheen
public class ItemInfernalArmor extends ItemArmor {
	
	public static boolean isDoubleJumping;
	
	public ItemInfernalArmor(String unlocalizedName, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn)
	{
		super(MaterialHelper.SCALEMAIL, renderIndexIn, equipmentSlotIn);
		
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
	/**
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) 
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null && player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == InitItemsVG.infernal_helmet
			&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == InitItemsVG.infernal_chestplate
			&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == InitItemsVG.infernal_leggings
			&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == InitItemsVG.infernal_boots) 
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
		**
		}
		
	}*/
}

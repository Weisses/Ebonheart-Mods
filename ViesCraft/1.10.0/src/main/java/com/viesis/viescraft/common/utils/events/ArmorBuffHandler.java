package com.viesis.viescraft.common.utils.events;

import java.util.UUID;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityAirshipVC.Status;
import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitItemsVC;

public class ArmorBuffHandler {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	
    	Status airshipStatus = EntityAirshipVC.Status.UNDER_WATER;
    	
    	UUID airship = null;
    	
    	
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipVC)
        {
    		isRiding = true;
    		airship = event.player.getRidingEntity().getUniqueID();
        }
		//else
		//{
		//	isRiding = false;
		//}
    	
		
		
		
		if (isRiding) 
    	{
    		LogHelper.info("Riding in an Airship.");
    		LogHelper.info(airship);
    		
    		
    		
    		
    		if (event.player.getRidingEntity().isInWater()) 
    		{
    			
    			LogHelper.info("Airship Underwater!");

    			
    			event.player.addStat(InitAchievementsVC.airship_water);
    			
    			//event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.BURNISHED_SPEED_BONUS);
    			//LogHelper.info("Burnished buff removed!");
    			
    	    }
    		
        }
		
		
    }
    	/**
    	ItemStack helmet = event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
		ItemStack chestplate = event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
		ItemStack leggings = event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
		ItemStack boots = event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
		
    	boolean burnishedBuff = false;
    	boolean vengeanceBuff = false;
    	boolean celestialBuff = false;
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(EAAttributeModifier.BURNISHED_SPEED_BONUS))
        {
    		burnishedBuff = true;
        }
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(EAAttributeModifier.VENGEANCE_SPEED_BONUS)
    		|| event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(EAAttributeModifier.VENGEANCE_HP_BONUS)
    		|| event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(EAAttributeModifier.VENGEANCE_ATTACK_BONUS))
		{
    		vengeanceBuff = true;
		}
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(EAAttributeModifier.CELESTIAL_SPEED_BONUS))
        {
    		celestialBuff = true;
        }
		
    	//===================================================================
    	
    	if (burnishedBuff) 
    	{
    		//LogHelper.info("Has Burnished buff.");
    		if (event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != InitItemsEA.burnished_helmet
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != InitItemsEA.burnished_chestplate
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != InitItemsEA.burnished_leggings
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != InitItemsEA.burnished_boots) 
    		{
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.BURNISHED_SPEED_BONUS);
    			//LogHelper.info("Burnished buff removed!");
    			
    	    }
    		
        } 
    	
    	if (vengeanceBuff) 
    	{
    		//LogHelper.info("Has Vengeance buff.");
    		if (event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != InitItemsEA.vengeance_helmet
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != InitItemsEA.vengeance_chestplate
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != InitItemsEA.vengeance_leggings
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != InitItemsEA.vengeance_boots) 
    		{
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.VENGEANCE_SPEED_BONUS);
    			event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(EAAttributeModifier.VENGEANCE_HP_BONUS);
    			event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(EAAttributeModifier.VENGEANCE_ATTACK_BONUS);
    			//LogHelper.info("Vengeance buff removed!");
    			
    	    }
    		
        }
    	
    	if (celestialBuff) 
    	{
    		//LogHelper.info("Has Burnished buff.");
    		if (event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != InitItemsEA.celestial_helmet
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != InitItemsEA.celestial_chestplate
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != InitItemsEA.celestial_leggings
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != InitItemsEA.celestial_boots) 
    		{
    			event.player.capabilities.allowFlying = false;
    			event.player.capabilities.isFlying = false;
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(EAAttributeModifier.CELESTIAL_SPEED_BONUS);
    			//LogHelper.info("Burnished buff removed!");
    			
    	    }
    		
        } 
    	
    }
    */
}

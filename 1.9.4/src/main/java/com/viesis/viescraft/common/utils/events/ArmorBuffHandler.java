package com.viesis.viescraft.common.utils.events;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.common.entity.modifiers.EAAttributeModifier;
import com.viesis.viescraft.init.InitItemsEA;

public class ArmorBuffHandler {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	
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
    
}

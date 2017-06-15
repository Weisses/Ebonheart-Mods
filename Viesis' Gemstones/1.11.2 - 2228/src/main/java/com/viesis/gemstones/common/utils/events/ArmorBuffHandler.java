package com.viesis.gemstones.common.utils.events;

import com.viesis.gemstones.zzzArk.modifier.VGAttributeModifier;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

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
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.BURNISHED_SPEED_BONUS))
        {
    		burnishedBuff = true;
        }
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.VENGEANCE_SPEED_BONUS)
    		|| event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).hasModifier(VGAttributeModifier.VENGEANCE_HP_BONUS)
    		|| event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).hasModifier(VGAttributeModifier.VENGEANCE_ATTACK_BONUS))
		{
    		vengeanceBuff = true;
		}
    	
    	if(event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).hasModifier(VGAttributeModifier.CELESTIAL_SPEED_BONUS))
        {
    		celestialBuff = true;
        }
		
    	//===================================================================
    	/**
    	if (burnishedBuff) 
    	{
    		//LogHelper.info("Has Burnished buff.");
    		if (event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != InitItemsEA.burnished_helmet
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != InitItemsEA.burnished_chestplate
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != InitItemsEA.burnished_leggings
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != InitItemsEA.burnished_boots) 
    		{
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(VGAttributeModifier.BURNISHED_SPEED_BONUS);
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
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(VGAttributeModifier.VENGEANCE_SPEED_BONUS);
    			event.player.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).removeModifier(VGAttributeModifier.VENGEANCE_HP_BONUS);
    			event.player.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).removeModifier(VGAttributeModifier.VENGEANCE_ATTACK_BONUS);
    			//LogHelper.info("Vengeance buff removed!");
    			
    	    }
    		
        }
    	
    	if (celestialBuff) 
    	{
    		//LogHelper.info("Has Celestial buff.");
    		if (event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() != InitItemsEA.celestial_helmet
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() != InitItemsEA.celestial_chestplate
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() != InitItemsEA.celestial_leggings
    			|| event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET) == null || event.player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() != InitItemsEA.celestial_boots) 
    		{
    			
    			
    			
    			if (!event.player.capabilities.isCreativeMode)
    			{
    				event.player.capabilities.allowFlying = false;
    				event.player.capabilities.isFlying = false;
    				
    				//LogHelper.info("Removed Celestial Flight. - Survival");
    			}
    			
    			event.player.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).removeModifier(VGAttributeModifier.CELESTIAL_SPEED_BONUS);
    			//LogHelper.info("Removed Celestial buff.");
    	    }
    		
        } 
    	*/
    }
    
}

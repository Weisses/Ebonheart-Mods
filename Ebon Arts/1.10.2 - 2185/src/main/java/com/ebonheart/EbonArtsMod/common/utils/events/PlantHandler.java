package com.ebonheart.EbonArtsMod.common.utils.events;

import com.ebonheart.EbonArtsMod.common.entity.modifiers.EAAttributeModifier;
import com.ebonheart.EbonArtsMod.init.InitBlocksEA;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class PlantHandler {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent
    		//.WorldTickEvent 
    		event) 
    {
    	//worldIn.spawnParticle(EnumParticleTypes.CLOUD, -1110, 8, -1124, (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), (double)((random.nextFloat() - 0.5F) * 0.2F), new int[0]);
        
        
    	
    	//InitBlocksEA.hellion_fruit.onBlockHarvested(world, pos, state, player);

    	
    	
    }
    
}

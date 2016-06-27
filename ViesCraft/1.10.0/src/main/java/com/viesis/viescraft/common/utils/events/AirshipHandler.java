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

public class AirshipHandler {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	UUID airship = null;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipVC)
        {
    		isRiding = true;
    		airship = event.player.getRidingEntity().getUniqueID();
        }
		
		//===================================================================
    	
		if (isRiding) 
    	{
    		//LogHelper.info("Riding in an Airship.");
    		//LogHelper.info(airship);
    		
    		if (event.player.getRidingEntity().isInWater()) 
    		{
    			//LogHelper.info("Airship Underwater!");
    			event.player.addStat(InitAchievementsVC.airship_water);
    	    }
        }
    }
}

package com.viesis.viescraft.common.utils.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.init.InitAchievementsVC;

public class EventHandlerAchievement {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	boolean isInAir = false;
    	boolean isInWater = false;
    	boolean isInLava = false;
    	boolean isAnimalPassenger = false;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipBaseVC)
        {
			isRiding = true;
        }
		
		//===================================================================
    	
		if(isRiding) 
    	{
			if(event.player.getRidingEntity().isInWater()) 
    		{
    			isInWater = true;
    	    }
			
			if(event.player.getRidingEntity().isInLava()) 
    		{
    			isInLava = true;
    	    }
    		
			if(event.player.getRidingEntity().isBeingRidden()) 
			{
				isInAir = true;
			}
    	}
		
		if(isInAir) 
    	{
			//LogHelper.info("Airship is in the Air!");
			event.player.addStat(InitAchievementsVC.airship_airborn);
    	}
		
		if(isInWater) 
    	{
			//LogHelper.info("Airship is Underwater!");
			event.player.addStat(InitAchievementsVC.airship_water);
    	}
		
		if(isInLava) 
    	{
			//LogHelper.info("Airship is in Lava!");
			event.player.addStat(InitAchievementsVC.airship_lava);
    	}
    }
}

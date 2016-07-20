package com.viesis.viescraft.common.utils.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.common.entity.EntityAirshipBase;
import com.viesis.viescraft.init.InitAchievementsVC;

public class AirshipHandler {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	
    	boolean isInAir = false;
    	boolean isInWater = false;
    	boolean isInLava = false;
    	boolean isAnimalPassenger = false;
    	
    	//Entity test = null;
    	//boolean test = event.player.getRidingEntity() instanceof EntityAirshipVC;
    	//UUID airship = null;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipBase)
        {
    		isRiding = true;
    		//LogHelper.info( event.player.getRidingEntity().isPassenger(test)
    				//instanceof EntityChicken
    		//		);
    				//event.player.hasAchievement(InitAchievementsVC.airship_airborn));
    		//airship = event.player.getRidingEntity().getUniqueID();
        }
		
		//===================================================================
    	
		if (isRiding) 
    	{
			if (event.player.getRidingEntity().isInWater()) 
    		{
    			isInWater = true;
    	    }
			
			if (event.player.getRidingEntity().isInLava()) 
    		{
    			isInLava = true;
    	    }
    		
			if (event.player.getRidingEntity().isBeingRidden()) 
			{
				isInAir = true;
			}
			
			//if (//event.player.getRidingEntity().getPassengers()
				//event.player.getRidingEntity().isBeingRidden() instanceof EntityAnimal
				//&& 
			//	event.player.getRidingEntity().getPassengers() instanceof EntityAnimal
			//	) 
			//{
			//	isAnimalPassenger = true;
			//}
    	}
		
		if (isInAir) 
    	{
			//LogHelper.info("Airship is in the Air!");
			event.player.addStat(InitAchievementsVC.airship_airborn);
    	}
		
		if (isInWater) 
    	{
			//LogHelper.info("Airship is Underwater!");
			event.player.addStat(InitAchievementsVC.airship_water);
    	}
		
		if (isInLava) 
    	{
			//LogHelper.info("Airship is in Lava!");
			event.player.addStat(InitAchievementsVC.airship_lava);
    	}
		
		//if (isAnimalPassenger) 
    	//{
		//	LogHelper.info("Airship's passenger is an animal!");
			//event.player.addStat(InitAchievementsVC.airship_lava);
    	//}
    }
}

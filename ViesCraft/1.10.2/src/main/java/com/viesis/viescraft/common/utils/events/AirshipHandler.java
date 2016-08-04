package com.viesis.viescraft.common.utils.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipYellow;
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
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipCore
		|| event.player.getRidingEntity() instanceof EntityAirshipBlack
		|| event.player.getRidingEntity() instanceof EntityAirshipBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipBrown
		|| event.player.getRidingEntity() instanceof EntityAirshipCyan
		|| event.player.getRidingEntity() instanceof EntityAirshipGray
		|| event.player.getRidingEntity() instanceof EntityAirshipGreen
		|| event.player.getRidingEntity() instanceof EntityAirshipLightBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipLightGray
		|| event.player.getRidingEntity() instanceof EntityAirshipLime
		|| event.player.getRidingEntity() instanceof EntityAirshipMagenta
		|| event.player.getRidingEntity() instanceof EntityAirshipOrange
		|| event.player.getRidingEntity() instanceof EntityAirshipPink
		|| event.player.getRidingEntity() instanceof EntityAirshipPurple
		|| event.player.getRidingEntity() instanceof EntityAirshipRed
		|| event.player.getRidingEntity() instanceof EntityAirshipWhite
		|| event.player.getRidingEntity() instanceof EntityAirshipYellow)
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
			//	event.player.getRidingEntity().isRidingOrBeingRiddenBy(entityIn) == entityIn instanceof EntityAnimal
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

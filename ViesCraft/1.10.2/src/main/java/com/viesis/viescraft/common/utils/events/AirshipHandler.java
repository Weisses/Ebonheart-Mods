package com.viesis.viescraft.common.utils.events;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlack;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBrown;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCyan;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipGreen;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightBlue;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLightGray;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipLime;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipMagenta;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipNormal;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipOrange;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPink;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipPurple;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipRed;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipWhite;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipYellow;
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
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipNormal
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

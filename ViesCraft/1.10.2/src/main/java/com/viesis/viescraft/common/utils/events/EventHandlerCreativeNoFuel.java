package com.viesis.viescraft.common.utils.events;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.init.InitAchievementsVC;

public class EventHandlerCreativeNoFuel {
	
	public static boolean creativeBurn;
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipV1Core
		|| event.player.getRidingEntity() instanceof EntityAirshipV2Core
		|| event.player.getRidingEntity() instanceof EntityAirshipV3Core)
        {
			isRiding = true;
        }
		else
		{
			isRiding = false;
		}
		
		//===================================================================
    	
		if(isRiding) 
    	{
			if(event.player.isCreative())
			{
				creativeBurn = true;
			}
			else
			{
				creativeBurn = false;
			}
    	}
    }
}

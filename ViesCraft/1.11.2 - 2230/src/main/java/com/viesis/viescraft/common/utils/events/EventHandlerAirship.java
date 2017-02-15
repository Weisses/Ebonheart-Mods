package com.viesis.viescraft.common.utils.events;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventHandlerAirship {
	
	public static boolean creativeBurn;
	public static int playerRidingEntity;
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	
    	if(event.player.getRidingEntity() instanceof EntityAirshipBaseVC)
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
			playerRidingEntity = event.player.getRidingEntity().getEntityId();
					
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

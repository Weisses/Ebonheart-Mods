package com.viesis.viescraft.common.utils.events;

import java.util.UUID;

import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.init.InitAchievementsVC;

public class EventHandlerCreativeNoFuel {
	
	public static boolean creativeBurn;
	
	public static int test;
	
	private EntityAirshipV1Core airshipV1;
	
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
			
			test = event.player.getRidingEntity().getEntityId();
			
			//LogHelper.info("T = " + event.player.getRidingEntity().getEntityId());
			
			//if()
			//{
				 //UUID test = this.airshipV1.getUniqueID();
				 //UUID test1 = event.player.getRidingEntity().getUniqueID();
				
					//if(test == test1)
					//{
					
					if(event.player.isCreative())
					{
						creativeBurn = true;
					}
					else
					{
						creativeBurn = false;
					}
				//}
			//}
		}
			
    }
    	
    	
    	
    
}

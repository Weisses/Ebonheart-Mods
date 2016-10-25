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

	public static boolean creativeBurn1;
	public static boolean creativeBurn2;
	public static boolean creativeBurn3;
	
	public static int test1;
	public static int test2;
	public static int test3;
	
	public boolean ss;
	
	private EntityAirshipV1Core airshipV1;
	private EntityAirshipV2Core airshipV2;
	private EntityAirshipV3Core airshipV3;
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	
    	
    	
    	boolean isRidingV1 = false;
    	boolean isRidingV2 = false;
    	boolean isRidingV3 = false;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipV1Core)
		{
			isRidingV1 = true;
			isRidingV2 = false;
			isRidingV3 = false;
		}
				
				
		else if(event.player.getRidingEntity() instanceof EntityAirshipV2Core)
		{
			isRidingV1 = false;
			isRidingV2 = true;
			isRidingV3 = false;
		}
		
		
		else if(event.player.getRidingEntity() instanceof EntityAirshipV3Core)
        {
			isRidingV1 = false;
			isRidingV2 = false;
			isRidingV3 = true;
        }
		else
		{
			isRidingV1 = false;
			isRidingV2 = false;
			isRidingV3 = false;
		}
		
		//===================================================================
    	
		if(isRidingV1) 
    	{
			
			test1 = event.player.getRidingEntity().getEntityId();
			
			this.airshipV1 = (EntityAirshipV1Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurn1 = true;
				
				//LogHelper.info("Is Creative v1");
			}
			else
			{
				creativeBurn1 = false;
			}
			
		}
		
		
		
		if(isRidingV2) 
    	{
			
			test2 = event.player.getRidingEntity().getEntityId();
			
			this.airshipV2 = (EntityAirshipV2Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurn2 = true;
				
				//LogHelper.info("Is Creative v2");
			}
			else
			{
				creativeBurn2 = false;
			}
			
		}
		
		if(isRidingV3) 
    	{
			
			test3 = event.player.getRidingEntity().getEntityId();
			
			this.airshipV3 = (EntityAirshipV3Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurn3 = true;
				
				//LogHelper.info("Is Creative v3");
			}
			else
			{
				creativeBurn3 = false;
			}
			
		}
		
			
    }
    	
    	
    	
    
}

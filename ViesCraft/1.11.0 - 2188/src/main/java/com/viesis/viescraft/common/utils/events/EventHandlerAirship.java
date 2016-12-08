package com.viesis.viescraft.common.utils.events;

import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.EntityTrackerEntry;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;

public class EventHandlerAirship {
	
	public static boolean creativeBurnV1;
	public static boolean creativeBurnV2;
	public static boolean creativeBurnV3;
	public static boolean creativeBurnV4;
	
	public static int playerRidingEntityV1;
	public static int playerRidingEntityV2;
	public static int playerRidingEntityV3;
	public static int playerRidingEntityV4;
	
	private EntityAirshipV1Core airshipV1;
	private EntityAirshipV2Core airshipV2;
	private EntityAirshipV3Core airshipV3;
	private EntityAirshipV4Core airshipV4;
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRidingV1 = false;
    	boolean isRidingV2 = false;
    	boolean isRidingV3 = false;
    	boolean isRidingV4 = false;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipV1Core)
		{
			isRidingV1 = true;
			isRidingV2 = false;
			isRidingV3 = false;
			isRidingV4 = false;
		}
		/**
		else if(event.player.getRidingEntity() instanceof EntityAirshipV2Core)
		{
			isRidingV1 = false;
			isRidingV2 = true;
			isRidingV3 = false;
			isRidingV4 = false;
		}
		else if(event.player.getRidingEntity() instanceof EntityAirshipV3Core)
        {
			isRidingV1 = false;
			isRidingV2 = false;
			isRidingV3 = true;
			isRidingV4 = false;
        }
		else if(event.player.getRidingEntity() instanceof EntityAirshipV4Core)
        {
			isRidingV1 = false;
			isRidingV2 = false;
			isRidingV3 = false;
			isRidingV4 = true;
        }
        */
		else
		{
			isRidingV1 = false;
			isRidingV2 = false;
			isRidingV3 = false;
			isRidingV4 = false;
		}
		
		//===================================================================
    	
		if(isRidingV1) 
    	{
			playerRidingEntityV1 = event.player.getRidingEntity().getEntityId();
			this.airshipV1 = (EntityAirshipV1Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurnV1 = true;
			}
			else
			{
				creativeBurnV1 = false;
			}
			/**
			if(airshipV1.stealthActive)
			{
				if(!event.player.isInvisible())
				{
					event.player.addPotionEffect(new PotionEffect(Potion.getPotionById(14), 1, 1));
					event.player.setInvisible(true);
				}
			}
			else 
			{
				if(event.player.isInvisible())
				{
					event.player.setInvisible(false);
				}
			}
			*/
		}
		//else 
		//{
		//	if(event.player.isInvisible())
		//	{
		//		event.player.setInvisible(false);
		//	}
		//}
		/**
		if(isRidingV2) 
    	{
			playerRidingEntityV2 = event.player.getRidingEntity().getEntityId();
			this.airshipV2 = (EntityAirshipV2Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurnV2 = true;
			}
			else
			{
				creativeBurnV2 = false;
			}
		}
		
		if(isRidingV3) 
    	{
			playerRidingEntityV3 = event.player.getRidingEntity().getEntityId();
			this.airshipV3 = (EntityAirshipV3Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurnV3 = true;
			}
			else
			{
				creativeBurnV3 = false;
			}
		}
		
		if(isRidingV4) 
    	{
			playerRidingEntityV4 = event.player.getRidingEntity().getEntityId();
			this.airshipV4 = (EntityAirshipV4Core) event.player.getRidingEntity();
					
			if(event.player.isCreative())
			{
				creativeBurnV4 = true;
			}
			else
			{
				creativeBurnV4 = false;
			}
		}
		*/
    }
}

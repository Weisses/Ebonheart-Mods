package com.viesis.viescraft.common.utils.events;

public class EventHandlerAirship {
	/**
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
    		//EntityAirshipBaseVC test = (EntityAirshipBaseVC) event.player.getRidingEntity();
    		
    		//test.getAmbientSound();
    		
    		//NetworkHandler.sendToServer(new MessageGuiPlayEngineSound());
    		/**
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
    	//else
		//{
		//	creativeBurn = false;
		//}*/
    //}
}

package com.viesis.viescraft.common.utils.events;

import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityTracker;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventHandlerAirship {
	/**
	@SubscribeEvent
	public void onKeyInput(PlayerEvent.StartTracking event) 
	{
		LogHelper.info("test");
		
		
		
		//event.getEntityPlayer().startRiding(entityIn)
		//EntityTracker et = ((WorldServer) entity.worldObj).getEntityTracker(); // You get EntityTracker of world in which there is entity you want to synchronize
		//et.func_151248_b(entity, SimpleNetworkWrapper#getInstance().getPacketFrom(new SomeDataPacket()); // You need SNW instance, the method might vari between versions. The method itself says "send this packet to everyone who is tracking this "entity".
	}
	
	/**
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyInput(InputEvent.KeyInputEvent event) 
	{
		LogHelper.info("Pressed 1");
        if(Keybinds.vcForward.isKeyDown())
        {  
        	LogHelper.info("Pressed 222222222222222222222");
        	
        	//KeyBinding bind = FMLClientHandler.instance().getClient().gameSettings.keyBindForward;
            //if (bind.isKeyDown()) 
            //{ //Player is going forwards, make them stop
            //    KeyBinding.setKeyBindState(bind.getKeyCode(), false);
            //} 
            //else 
            //{ //Player is not going forwards, make them start
            //    KeyBinding.setKeyBindState(bind.getKeyCode(), true);
            //}
        	Keybinds.vcForward.unPressAllKeys();
        }
    }
	*/
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

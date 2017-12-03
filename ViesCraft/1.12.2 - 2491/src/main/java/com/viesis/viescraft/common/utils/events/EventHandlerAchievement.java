package com.viesis.viescraft.common.utils.events;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.init.InitAchievementsVC;

import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventHandlerAchievement {
	
    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) 
    {
    	boolean isRiding = false;
    	boolean isInAir = false;
    	boolean isInWater = false;
    	boolean isInLava = false;
    	boolean isAnimalPassenger = false;
    	
		if(event.player.getRidingEntity() instanceof EntityAirshipBaseVC)
        {
			isRiding = true;
        }
		
		//===================================================================
    	
		if(isRiding) 
    	{
			if(event.player.getRidingEntity().isInWater()) 
    		{
    			isInWater = true;
    	    }
			
			if(event.player.getRidingEntity().isInLava()) 
    		{
    			isInLava = true;
    	    }
    		
			if(event.player.getRidingEntity().isBeingRidden()) 
			{
				isInAir = true;
			}
    	}
		
		if(isInAir) 
    	{
			//LogHelper.info("Airship is in the Air!");
			event.player.addStat(InitAchievementsVC.airship_airborn);
    	}
		
		if(isInWater) 
    	{
			//LogHelper.info("Airship is Underwater!");
			event.player.addStat(InitAchievementsVC.airship_water);
    	}
		
		if(isInLava) 
    	{
			//LogHelper.info("Airship is in Lava!");
			event.player.addStat(InitAchievementsVC.airship_lava);
    	}
    }
    
    /**
    
    private static volatile ISound soundTEST;
    
    @SubscribeEvent
    @SideOnly(Side.CLIENT)
	public void tick(ClientTickEvent e) 
    {
    	if (!Minecraft.getMinecraft().isGamePaused()) 
		{
    		SoundManager mng = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager");
    		
    		Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, mng, "playingSounds");
    		
    		Iterator it = playingSounds.keySet().iterator();
    		
    		while(it.hasNext())
    		{
    			JukeboxMovingSoundVC ps = (JukeboxMovingSoundVC)playingSounds.get(it.next());
    		   
    		   ResourceLocation reloc = ReflectionHelper.getPrivateValue(JukeboxMovingSoundVC.class, ps, "field_147664_a");
    		   
    		   if("music.game".equals(reloc.getResourcePath()))
    		   {
    		      Minecraft.getMinecraft().getSoundHandler().stopSound(ps);
    		      
    		      System.out.println("stopped music");
    		      
    		      break;
    		   }
    		   
    		   //LogHelper.info("- " + ps);
    		}
		}
	}
    
	public static boolean isPlaying(ISound soundTEST) {
		return soundTEST != null && Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(soundTEST);
	}
	
	public static void StopMusic() {
		LogHelper.info("TEST2");
		if (isPlaying(soundTEST))
			Minecraft.getMinecraft().getSoundHandler().stopSound(soundTEST);
		soundTEST = null;
		SoundStopperVC.stop(0);
	}
	
	*/
	
}

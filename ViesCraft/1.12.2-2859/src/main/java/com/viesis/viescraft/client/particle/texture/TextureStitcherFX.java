package com.viesis.viescraft.client.particle.texture;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class TextureStitcherFX {

	@SubscribeEvent
	  public void stitcherEventPre(TextureStitchEvent.Pre event) {
	    ResourceLocation flameRL = new ResourceLocation("vc:items/airship_balloon");
	    event.getMap().registerSprite(flameRL);
	  }
	
	
	
}

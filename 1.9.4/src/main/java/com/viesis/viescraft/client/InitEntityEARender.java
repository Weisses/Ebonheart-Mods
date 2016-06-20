package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsEA;
import com.viesis.viescraft.client.projectile.RenderEnchantedEbonheart;
import com.viesis.viescraft.common.entity.EntityEnchantedEbonheart;

public final class InitEntityEARender extends ItemsEA {
	
	public static RenderManager EARender;
	
	public static void registerRenders()
	{
		
		registerRender(EntityEnchantedEbonheart.class
				//, RenderEnchantedEbonheart::new
				);
		
		//registerRender(EntityAirship.class);
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn)
	{
		
		EARender = Minecraft.getMinecraft().getRenderManager(); 
		
		//RenderingRegistry.registerEntityRenderingHandler(classIn, renderFactory);
		
		RenderingRegistry.registerEntityRenderingHandler(classIn, new RenderEnchantedEbonheart(EARender));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityAirshipEA.class, new RenderEnchantedEbonheart(EARender));
		
	}
}

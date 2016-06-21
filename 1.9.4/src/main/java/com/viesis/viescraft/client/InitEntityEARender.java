package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsEA;
import com.viesis.viescraft.client.projectile.RenderItemViesdenburg;
import com.viesis.viescraft.common.entity.EntityItemViesdenburg;

public final class InitEntityEARender extends ItemsEA {
	
	public static RenderManager EARender;
	
	public static void registerRenders()
	{
		
		registerRender(EntityItemViesdenburg.class
				//, RenderEnchantedEbonheart::new
				);
		
		//registerRender(EntityAirship.class);
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn)
	{
		
		EARender = Minecraft.getMinecraft().getRenderManager(); 
		
		//RenderingRegistry.registerEntityRenderingHandler(classIn, renderFactory);
		
		RenderingRegistry.registerEntityRenderingHandler(classIn, new RenderItemViesdenburg(EARender));
		
		//RenderingRegistry.registerEntityRenderingHandler(EntityAirshipEA.class, new RenderEnchantedEbonheart(EARender));
		
	}
}

package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsEA;
import com.viesis.viescraft.client.entity.RenderTest;
import com.viesis.viescraft.client.projectile.RenderItemViesdenburg;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityItemViesdenburg;

public final class InitEntityEARender extends ItemsEA {
	
	public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	
	public static void registerRenders()
	{
		
		registerRender(EntityItemViesdenburg.class,  new RenderItemViesdenburg(EARender));
		
		registerRender(EntityAirshipVC.class,  new RenderTest(EARender));
		
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn, Render<? extends Entity> renderItem)
	{
		RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
}

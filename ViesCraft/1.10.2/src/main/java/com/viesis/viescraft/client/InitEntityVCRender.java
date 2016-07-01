package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.RenderAirshipVC;
import com.viesis.viescraft.client.projectile.RenderItemViesdenburg;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityItemViesdenburg;
import com.viesis.viescraft.testbed.client.model.ModelAirshipVC;
import com.viesis.viescraft.testbed.client.render.RenderEntityAirshipBase;
import com.viesis.viescraft.testbed.client.render.RenderItemAirship;
import com.viesis.viescraft.testbed.common.entity.EntityAirshipBase;
import com.viesis.viescraft.testbed.common.entity.EntityItemAirship;



public final class InitEntityVCRender extends ItemsVC {
	
	public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	 //public static ModelHorse test1 = new ModelHorse();
	 
	 public static ModelAirshipVC test = new ModelAirshipVC();
	
	public static void registerRenders()
	{
		
		registerRender(EntityItemViesdenburg.class,  new RenderItemViesdenburg(EARender));
		
		registerRender(EntityAirshipVC.class,  new RenderAirshipVC(EARender));
		
		
		
		
		//registerRender(EntityAirshipVCtest.class,  new RenderAirshipVCtest(EARender, test, 0));
		
		registerRender(EntityItemAirship.class,  new RenderItemAirship(EARender));
		
		
		
		
		registerRender(EntityAirshipBase.class,  new RenderEntityAirshipBase(EARender, test, 0));
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn, Render<? extends Entity> renderItem)
	{
		RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
}

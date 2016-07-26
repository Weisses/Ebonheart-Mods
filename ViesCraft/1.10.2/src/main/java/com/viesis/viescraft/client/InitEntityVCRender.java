package com.viesis.viescraft.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.RenderAirshipBase;
import com.viesis.viescraft.client.entity.render.RenderAirshipBase2;
import com.viesis.viescraft.client.projectile.RenderItemAirship;
import com.viesis.viescraft.client.projectile.RenderItemAirshipV2;
import com.viesis.viescraft.common.entity.EntityAirshipBase;
import com.viesis.viescraft.common.entity.EntityAirshipBase2;
import com.viesis.viescraft.common.entity.EntityItemAirship;
import com.viesis.viescraft.common.entity.EntityItemAirshipV2;



public final class InitEntityVCRender extends ItemsVC {
	
	public static RenderManager EARender = Minecraft.getMinecraft().getRenderManager(); 
	 //public static ModelHorse test1 = new ModelHorse();
	 
	 //public static ModelAirshipBase test = new ModelAirshipBase();
	
	public static void registerRenders()
	{
		
		//registerRender(EntityItemViesdenburg.class,  new RenderItemViesdenburg(EARender));
		
		//registerRender(EntityAirshipVC.class,  new RenderAirshipVC(EARender));
		
		
		
		
		//registerRender(EntityAirshipVCtest.class,  new RenderAirshipVCtest(EARender, test, 0));
		
		registerRender(EntityItemAirship.class,  new RenderItemAirship(EARender));
		registerRender(EntityItemAirshipV2.class,  new RenderItemAirshipV2(EARender));
		
		//registerRender(EntityItemAirshipFurnace.class,  new RenderItemAirshipFurnace(EARender));
		
		
		
		registerRender(EntityAirshipBase.class,  new RenderAirshipBase(EARender));
		registerRender(EntityAirshipBase2.class,  new RenderAirshipBase2(EARender));
		
		//registerRender(EntityAirshipFurnace.class,  new RenderAirshipFurnace(EARender));
		
	}
	
	public static void registerRender(Class<? extends Entity> classIn, Render<? extends Entity> renderItem)
	{
		RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	}
}

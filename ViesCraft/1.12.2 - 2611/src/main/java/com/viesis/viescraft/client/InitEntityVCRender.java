package com.viesis.viescraft.client;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.RenderAirship;
import com.viesis.viescraft.client.entity.render.RenderBombBig;
import com.viesis.viescraft.client.entity.render.RenderBombSmall;
import com.viesis.viescraft.client.entity.render.RenderThrownAirship;
import com.viesis.viescraft.common.entity.EntityBombBig;
import com.viesis.viescraft.common.entity.EntityBombSmall;
import com.viesis.viescraft.common.entity.EntityThrownAirship;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVCRender extends ItemsVC {
	
	public static void registerEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityBombSmall.class, renderManager -> new RenderBombSmall(renderManager));
		RenderingRegistry.registerEntityRenderingHandler(EntityBombBig.class, renderManager -> new RenderBombBig(renderManager));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownAirship.class, renderManager -> new RenderThrownAirship(renderManager));
		
		//===========================================
		
		RenderingRegistry.registerEntityRenderingHandler(EntityAirshipCore.class, renderManager -> new RenderAirship(renderManager));
		
		/**
		registerRender1(EntityAirshipV1.class,  renderManager -> new RenderAirshipV1(renderManager));
		registerRender(EntityAirshipV2.class,  new RenderAirshipV2(VCRender));
		*/
	}
	
	public static void registerEntityRenderTEMP()
	{
		
	}
	
	//public static void registerRender1(Class<? extends Entity> classIn, Object renderItem)
	//{
	//	RenderingRegistry.registerEntityRenderingHandler(classIn, renderItem);
	//}
}

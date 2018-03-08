package com.viesis.viescraft.client;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.RenderAirship;
import com.viesis.viescraft.client.entity.render.RenderItemAirship;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirship;

public final class InitEntityVCRender extends ItemsVC {
	
	public static void registerEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityItemAirship.class, renderManager -> new RenderItemAirship(renderManager));
		
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

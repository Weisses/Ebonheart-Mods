package com.viesis.viescraft.client;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipV1;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3;
import com.viesis.viescraft.client.entity.render.airshipcolors.v4.RenderAirshipV4;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipV1;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3;
import com.viesis.viescraft.client.entity.render.projectile.v4.RenderItemAirshipV4;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityAirshipV4;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemAirshipV4;
import com.viesis.viescraft.configs.ViesCraftConfig;

public final class InitEntityVCRender extends ItemsVC {
	
	//public static RenderManager VCRender = Minecraft.getMinecraft().getRenderManager(); 
	
	public static void registerEntityRender()
	{
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV1.class, renderManager -> new RenderItemAirshipV1(renderManager));
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV2.class, renderManager -> new RenderItemAirshipV2(renderManager));
		}
				
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV3.class, renderManager -> new RenderItemAirshipV3(renderManager));
		}
				
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV4.class, renderManager -> new RenderItemAirshipV4(renderManager));
		}
		
		//===========================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV1.class, renderManager -> new RenderAirshipV1(renderManager));
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV2.class, renderManager -> new RenderAirshipV2(renderManager));
		}
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV3.class, renderManager -> new RenderAirshipV3(renderManager));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV4.class, renderManager -> new RenderAirshipV4(renderManager));
		}
		
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

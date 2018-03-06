package com.viesis.viescraft.client;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV1;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV2;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV3;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV4;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV5;
import com.viesis.viescraft.client.entity.render.airshipcolors.RenderAirshipV6;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV1;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV2;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV3;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV4;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV5;
import com.viesis.viescraft.client.entity.render.projectile.RenderItemAirshipV6;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV5Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV6Core;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV1;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV2;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV3;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV4;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV5;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipV6;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVCRender extends ItemsVC {
	
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
		//V5
		if(ViesCraftConfig.v5AirshipEnabled)
		{
			//RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV5.class, renderManager -> new RenderItemAirshipV5(renderManager));
		}
		//V6
		if(ViesCraftConfig.v6AirshipEnabled)
		{
			//RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV6.class, renderManager -> new RenderItemAirshipV6(renderManager));
		}
		
		//===========================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV1Core.class, renderManager -> new RenderAirshipV1(renderManager));
		}
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV2Core.class, renderManager -> new RenderAirshipV2(renderManager));
		}
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV3Core.class, renderManager -> new RenderAirshipV3(renderManager));
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV4Core.class, renderManager -> new RenderAirshipV4(renderManager));
		}
		//V5
		if(ViesCraftConfig.v5AirshipEnabled)
		{
			//RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV5Core.class, renderManager -> new RenderAirshipV5(renderManager));
		}
		//V6
		if(ViesCraftConfig.v6AirshipEnabled)
		{
			//RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV6Core.class, renderManager -> new RenderAirshipV6(renderManager));
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

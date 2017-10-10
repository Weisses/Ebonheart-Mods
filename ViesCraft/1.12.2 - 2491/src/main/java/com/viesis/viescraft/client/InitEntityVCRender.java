package com.viesis.viescraft.client;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.client.entity.render.airshipcolors.v1.RenderAirshipV1;
import com.viesis.viescraft.client.entity.render.airshipcolors.v2.RenderAirshipV2;
import com.viesis.viescraft.client.entity.render.airshipcolors.v3.RenderAirshipV3;
import com.viesis.viescraft.client.entity.render.airshipcolors.v4.RenderAirshipV4;
import com.viesis.viescraft.client.entity.render.airshipcolors.v5.RenderAirshipV5;
import com.viesis.viescraft.client.entity.render.airshipcolors.v6.RenderAirshipV6;
import com.viesis.viescraft.client.entity.render.projectile.v1.RenderItemAirshipV1;
import com.viesis.viescraft.client.entity.render.projectile.v2.RenderItemAirshipV2;
import com.viesis.viescraft.client.entity.render.projectile.v3.RenderItemAirshipV3;
import com.viesis.viescraft.client.entity.render.projectile.v4.RenderItemAirshipV4;
import com.viesis.viescraft.client.entity.render.projectile.v5.RenderItemAirshipV5;
import com.viesis.viescraft.client.entity.render.projectile.v6.RenderItemAirshipV6;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV5Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV6Core;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemAirshipV4;
import com.viesis.viescraft.common.entity.airshipitems.v5.EntityItemAirshipV5;
import com.viesis.viescraft.common.entity.airshipitems.v6.EntityItemAirshipV6;
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
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV5.class, renderManager -> new RenderItemAirshipV5(renderManager));
		}
		//V6
		if(ViesCraftConfig.v6AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityItemAirshipV6.class, renderManager -> new RenderItemAirshipV6(renderManager));
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
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV5Core.class, renderManager -> new RenderAirshipV5(renderManager));
		}
		//V6
		if(ViesCraftConfig.v6AirshipEnabled)
		{
			RenderingRegistry.registerEntityRenderingHandler(EntityAirshipV6Core.class, renderManager -> new RenderAirshipV6(renderManager));
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

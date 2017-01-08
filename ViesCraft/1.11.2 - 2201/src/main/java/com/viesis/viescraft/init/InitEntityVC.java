package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityAirshipV1;
import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityAirshipV2;
import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3;
import com.viesis.viescraft.common.entity.airshipcolors.v4.EntityAirshipV4;
import com.viesis.viescraft.common.entity.airshipitems.v1.EntityItemAirshipV1;
import com.viesis.viescraft.common.entity.airshipitems.v2.EntityItemAirshipV2;
import com.viesis.viescraft.common.entity.airshipitems.v3.EntityItemAirshipV3;
import com.viesis.viescraft.common.entity.airshipitems.v4.EntityItemAirshipV4;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			register("item_airship_v1", EntityItemAirshipV1.class, "item.airship.v1", 64, 20, true);
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			register("item_airship_v2", EntityItemAirshipV2.class, "item.airship.v2", 64, 20, true);
		}
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			register("item_airship_v3", EntityItemAirshipV3.class, "item.airship.v3", 64, 20, true);
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			register("item_airship_v4", EntityItemAirshipV4.class, "item.airship.v4", 64, 20, true);
		}
		
		//===========================================
		
		//V1
		if(ViesCraftConfig.v1AirshipEnabled)
		{
			register("airship_v1", EntityAirshipV1.class, "airship.v1", 64, 1, true);
		}
		
		//V2
		if(ViesCraftConfig.v2AirshipEnabled)
		{
			register("airship_v2", EntityAirshipV2.class, "airship.v2", 64, 1, true);
		}
		
		//V3
		if(ViesCraftConfig.v3AirshipEnabled)
		{
			register("airship_v3", EntityAirshipV3.class, "airship.v3", 64, 1, true);
		}
		
		//V4
		if(ViesCraftConfig.v4AirshipEnabled)
		{
			register("airship_v4", EntityAirshipV4.class, "airship.v4", 64, 1, true);
		}
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("vc:" + name), entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

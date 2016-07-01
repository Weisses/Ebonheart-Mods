package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityItemViesdenburg;
import com.viesis.viescraft.testbed.common.entity.EntityAirshipBase;
import com.viesis.viescraft.testbed.common.entity.EntityItemAirship;


public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
		register(EntityAirshipVC.class, "AirshipEbonheart", 64, 1, true);
		
		register(EntityItemAirship.class, "EnchantedEbonheartNEW", 64, 20, true);
		//register(EntityAirshipVCtest.class, "AirshipEbonheartNEW", 64, 1, true);
		
		
		
		register(EntityAirshipBase.class, "AirshipVCBase", 64, 1, true);
		
		
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

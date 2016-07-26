package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.EntityAirshipBase;
import com.viesis.viescraft.common.entity.EntityAirshipBase2;
import com.viesis.viescraft.common.entity.EntityItemAirship;


public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		//register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
		//register(EntityAirshipVC.class, "AirshipEbonheart", 64, 1, true);
		
		register(EntityItemAirship.class, "vc.ItemAirship", 64, 20, true);
		//register(EntityAirshipVCtest.class, "AirshipEbonheartNEW", 64, 1, true);
		
		//register(EntityItemAirshipFurnace.class, "vc.ItemAirshipFurnace", 64, 20, true);
		
		
		
		register(EntityAirshipBase.class, "AirshipEbonheart", 64, 1, true);
		register(EntityAirshipBase2.class, "AirshipV2", 64, 1, true);
		
		//register(EntityAirshipFurnace.class, "AirshipVCFurnace", 64, 1, true);
		
		
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

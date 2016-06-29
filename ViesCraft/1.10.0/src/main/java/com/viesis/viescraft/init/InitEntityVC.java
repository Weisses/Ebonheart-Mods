package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityItemViesdenburg;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void preInit()
	{
		
		//throwingRock = new ItemThrowingRock().setUnlocalizedName("throwingRock");
		register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
		register(EntityAirshipVC.class, "Airship Ebonheart", 64, 1, true);
		
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		//int modEntityID = 0;
		//EntityRegistry.registerModEntity(EntityEnchantedEbonheart.class, "Ebonheart", ++modEntityID, Reference.MOD_ID, 64, 10, true);
		
		EntityRegistry.registerModEntity(entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		
		
		//EntityRegistry.registerModEntity(EntityEbonheart.class, "Ebonheart", EntityRegistry.findGlobalUniqueEntityId(), Reference.MOD_ID, 64, 10, true);
		
	}
}

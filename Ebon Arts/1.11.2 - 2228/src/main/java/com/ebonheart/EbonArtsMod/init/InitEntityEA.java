package com.ebonheart.EbonArtsMod.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.entity.EntityEnchantedEbonheart;

public class InitEntityEA {
	
	private static int entityID = 1;
	
	public static void preInit()
	{

		
		//throwingRock = new ItemThrowingRock().setUnlocalizedName("throwingRock");
		register(EntityEnchantedEbonheart.class, "Enchanted Ebonheart", 64, 20, true);
		//register(EntityAirshipEA.class, "Airship Ebonheart", 64, 20, true);
		
	}
	
	public static void register(Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		//int modEntityID = 0;
		//EntityRegistry.registerModEntity(EntityEnchantedEbonheart.class, "Ebonheart", ++modEntityID, Reference.MOD_ID, 64, 10, true);
		
		EntityRegistry.registerModEntity(new ResourceLocation("ea:entity"), entityClass, entityName, entityID++, EbonArtsMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		
		//EntityRegistry.registerModEntity(null, entityClass, entityName, entityID++, EbonArtsMod.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		//EntityRegistry.registerModEntity(EntityEbonheart.class, "Ebonheart", EntityRegistry.findGlobalUniqueEntityId(), Reference.MOD_ID, 64, 10, true);
		
	}
}

package com.viesis.gemstones.init;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.zzzArk.EntityEnchantedEbonheart;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntityVG {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("enchanted_ebonheart", EntityEnchantedEbonheart.class, "enchanted.ebonheart", 64, 20, true);
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("vc:" + name), entityClass, entityName, entityID++, ViesisGemstones.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

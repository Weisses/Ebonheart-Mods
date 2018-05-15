package com.viesis.viescraft.init;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.EntityBombBig;
import com.viesis.viescraft.common.entity.EntityBombScatter;
import com.viesis.viescraft.common.entity.EntityBombSmall;
import com.viesis.viescraft.common.entity.EntityThrownAirship;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("entity_thrown_airship", EntityThrownAirship.class, "entity.thrown.airship", 64, 20, true);
		
		//===========================================
		
		register("entity_airship", EntityAirshipCore.class, "entity.airship", 64, 1, true);
		
		//===========================================
		
		register("entity_bomb_small", EntityBombSmall.class, "entity.bomb.small", 64, 20, true);
		register("entity_bomb_big", EntityBombBig.class, "entity.bomb.big", 64, 20, true);
		register("entity_bomb_scatter", EntityBombScatter.class, "entity.bomb.scatter", 64, 20, true);
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("vc:" + name), entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

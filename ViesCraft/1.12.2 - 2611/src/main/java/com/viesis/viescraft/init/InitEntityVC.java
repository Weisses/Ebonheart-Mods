package com.viesis.viescraft.init;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.EntityItemBombSmall;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirship;

public class InitEntityVC {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("entity_item_airship", EntityItemAirship.class, "entity.item.airship", 64, 20, true);
		
		//===========================================
		
		register("entity_airship", EntityAirshipCore.class, "entity.airship", 64, 1, true);
		
		//===========================================
		
		register("entity_item_bomb", EntityItemBombSmall.class, "entity.item.bomb", 64, 20, true);
	}
	
	public static void registerEntityTEMP()
	{
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation("vc:" + name), entityClass, entityName, entityID++, ViesCraft.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

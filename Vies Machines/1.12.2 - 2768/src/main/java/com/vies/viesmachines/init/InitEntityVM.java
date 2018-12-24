package com.vies.viesmachines.init;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.common.entity.particles.EntityMachineFlyingBombNormal;
import com.vies.viesmachines.common.entity.particles.EntityStaticCharge;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class InitEntityVM {
	
	private static int entityID = 1;
	
	public static void registerEntity()
	{
		register("particle_static_charge", EntityStaticCharge.class, "particle.static.charge", 64, 20, true);
		
		//----------//----------//----------//----------//----------//
		
		register("bomb_flying_standard", EntityMachineFlyingBombNormal.class, "bomb.flying.standard", 64, 1, true);
		
		//----------//----------//----------//----------//----------//
		
		register("thrown_machine_flying_airship", EntityThrownMachineFlyingAirship.class, "thrown.machine.flying.airship", 64, 20, true);
		
		//----------//----------//----------//----------//----------//
		
		//register("machine_ground", EntityMachineGround.class, "machine.ground", 128, 1, true);
		//register("machine_water", EntityMachineWater.class, "machine.water", 128, 1, true);
		register("machine.flying.airship", EntityMachineFlyingAirship.class, "machine.flying.airship", 128, 1, true);
		
	}
	
	public static void register(String name, Class<? extends Entity> entityClass, String entityName, int trackingRange, int updateFrequency, boolean sendsVelocityUpdates)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(References.MOD_ID + ":" + name), entityClass, entityName, entityID++, ViesMachines.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
	}
}

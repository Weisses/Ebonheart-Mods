package com.vies.viesmachines.client;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.client.entity.machines.flying.models.airship.ModelAirshipFrameDisplayBannerStand;
import com.vies.viesmachines.client.entity.machines.flying.renderers.airship.RenderEntityMachineFlyingAirship;
import com.vies.viesmachines.client.entity.particles.renderers.RenderMachineFlyingBombNormal;
import com.vies.viesmachines.client.entity.particles.renderers.RenderStaticCharge;
import com.vies.viesmachines.client.entity.thrown.RenderThrownMachineFlying;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;
import com.vies.viesmachines.common.entity.particles.EntityMachineFlyingBombNormal;
import com.vies.viesmachines.common.entity.particles.EntityStaticCharge;
import com.vies.viesmachines.common.entity.thrown.EntityThrownMachineFlyingAirship;

import net.minecraftforge.fml.client.registry.RenderingRegistry;

public final class InitEntityVMRender extends ItemsVM {
	
	public static void registerEntityRender()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityStaticCharge.class, renderManager -> new RenderStaticCharge(renderManager));
		
		//----------//----------//----------//----------//----------//
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineFlyingBombNormal.class, renderManager -> new RenderMachineFlyingBombNormal(renderManager));
		
		//----------//----------//----------//----------//----------//
		
		RenderingRegistry.registerEntityRenderingHandler(EntityThrownMachineFlyingAirship.class, renderManager -> new RenderThrownMachineFlying(renderManager));
		
		//----------//----------//----------//----------//----------//
		
		RenderingRegistry.registerEntityRenderingHandler(EntityMachineFlyingAirship.class, renderManager -> new RenderEntityMachineFlyingAirship(renderManager, new ModelAirshipFrameDisplayBannerStand(), 1));
		
	}
}

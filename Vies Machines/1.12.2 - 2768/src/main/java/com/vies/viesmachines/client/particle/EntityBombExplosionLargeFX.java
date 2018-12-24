package com.vies.viesmachines.client.particle;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityBombExplosionLargeFX extends ParticleFlame {
    
    public EntityBombExplosionLargeFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        setParticleTextureIndex(48);
        setRBGColorF(1, 10, 0);
    }
    
    @Override
    public void onUpdate()
    {
    	if(this.world.collidesWithAnyBlock(getBoundingBox()))
	    {
	    	this.setExpired();
	    }
    	
    	super.onUpdate();
    }
}

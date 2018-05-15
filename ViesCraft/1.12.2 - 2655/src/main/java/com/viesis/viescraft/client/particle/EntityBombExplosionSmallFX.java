package com.viesis.viescraft.client.particle;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityBombExplosionSmallFX extends ParticleFlame {
    
    public EntityBombExplosionSmallFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        this.setParticleTextureIndex(65);
        this.setRBGColorF(50, 50, 50);
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

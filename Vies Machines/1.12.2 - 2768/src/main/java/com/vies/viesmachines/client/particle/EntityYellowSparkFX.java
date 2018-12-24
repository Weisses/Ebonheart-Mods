package com.vies.viesmachines.client.particle;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityYellowSparkFX extends ParticleFlame {
    
    public EntityYellowSparkFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        //this.particleScale = 10.25F;//.particleScale.particleMaxAge = 2;
        this.setParticleTextureIndex(65);
        this.setRBGColorF(25, 25, 0);
    }
}

package com.vies.viesmachines.client.particle;

import com.vies.viesmachines.api.References;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityUpgradeFX extends ParticleFlame {
    
    public EntityUpgradeFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        int d1 = References.random.nextInt(150) + 1;
        int d2 = References.random.nextInt(150) + 1;
        int d3 = References.random.nextInt(150) + 1;
        
        this.setParticleTextureIndex(65);
        this.setRBGColorF(d1, d2, d3);
    }
}

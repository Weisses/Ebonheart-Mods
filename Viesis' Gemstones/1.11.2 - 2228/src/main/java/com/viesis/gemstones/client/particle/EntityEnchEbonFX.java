package com.viesis.gemstones.client.particle;

import java.util.Random;

import com.viesis.gemstones.api.References;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityEnchEbonFX extends ParticleFlame {
	
    public EntityEnchEbonFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        int d1 = References.random.nextInt(250) + 1;
        int d2 = References.random.nextInt(250) + 1;
        int d3 = References.random.nextInt(250) + 1;
        
        particleScale = 0.7F;
        setRBGColorF(d1, d2, d3);
        
    }
    
}
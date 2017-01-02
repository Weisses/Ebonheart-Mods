package com.viesis.viescraft.client.particle;

import java.util.Random;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityEnchEbonFX extends ParticleFlame {
	
	Random random = new Random();

    public EntityEnchEbonFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        int d1 = random.nextInt(250) + 1;
        int d2 = random.nextInt(250) + 1;
        int d3 = random.nextInt(250) + 1;
        
        particleScale = 0.7F;
        setRBGColorF(d1, d2, d3);
        
    }
    
}
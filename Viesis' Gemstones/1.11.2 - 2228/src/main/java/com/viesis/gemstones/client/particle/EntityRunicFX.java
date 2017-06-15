package com.viesis.gemstones.client.particle;

import com.viesis.gemstones.api.References;

import net.minecraft.client.particle.ParticleEnchantmentTable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityRunicFX extends ParticleEnchantmentTable {
	
    public EntityRunicFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        int d1 = References.random.nextInt(150) + 1;
        int d2 = References.random.nextInt(150) + 1;
        int d3 = References.random.nextInt(150) + 1;
        
        particleScale = 0.5F;
        setRBGColorF(d1, d2, d3);
    }
}

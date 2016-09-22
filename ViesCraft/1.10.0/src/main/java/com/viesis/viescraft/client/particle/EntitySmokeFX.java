package com.viesis.viescraft.client.particle;

import net.minecraft.client.particle.ParticleFlame;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntitySmokeFX extends ParticleFlame {
    
	public EntitySmokeFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setRBGColorF(0, 15, 25);
    }
    
}

/**
 * 
 Radiates green flames from a central point.
@SideOnly(Side.CLIENT)
public class EntitySmokeFX extends ParticleFlame {
    
	public EntitySmokeFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        setRBGColorF(0, 15, 25);
    }
    
}
*/
package com.ebonheart.EbonArtsMod.client.particle;

import java.util.Random;

import com.ebonheart.EbonArtsMod.api.Reference;
import com.ebonheart.EbonArtsMod.common.utils.LogHelper;

import net.minecraft.client.particle.IParticleFactory;
import net.minecraft.client.particle.ParticleEnchantmentTable;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.client.renderer.VertexBuffer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityFlightFX extends ParticleEnchantmentTable {
	
	Random random = new Random();

    public EntityFlightFX(World parWorld,
            double parX, double parY, double parZ,
            double parMotionX, double parMotionY, double parMotionZ) 
    {
        super(parWorld, parX, parY, parZ, parMotionX, parMotionY, parMotionZ);
        
        int d1 = random.nextInt(150) + 1;
        int d2 = random.nextInt(150) + 1;
        int d3 = random.nextInt(150) + 1;
        
        particleScale = 0.5F;
        setRBGColorF(d1, d2, d3);
        
    }
    
}
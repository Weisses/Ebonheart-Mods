package com.viesis.viescraft.client;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.particle.EntityBombExplosionLargeFX;
import com.viesis.viescraft.client.particle.EntityBombExplosionSmallFX;
import com.viesis.viescraft.client.particle.EntityColorFlameFX;
import com.viesis.viescraft.client.particle.EntityRunicRainbowFX;
import com.viesis.viescraft.client.particle.EntityRunicWhiteFX;
import com.viesis.viescraft.client.particle.EntityUnholyFX;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;

public class InitParticlesVCRender {
	
	//Airship Engine Smoke
	public static void generateAirshipSmokeParticles0(Entity entityIn, double xIn, double yIn, double zIn)
	{
		entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entityIn.posX - (double)(MathHelper.sin(-entityIn.rotationYaw * 0.017453292F) * 00.90F) + xIn, 
		entityIn.posY + 0.95D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos(entityIn.rotationYaw * 0.017453292F) * 00.90F) + zIn, 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	public static void generateAirshipSmokeParticles1(Entity entityIn, double xIn, double yIn, double zIn)
	{
		entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entityIn.posX - (double)(MathHelper.sin(-entityIn.rotationYaw * 0.017453292F) * 00.82F) + xIn, 
		entityIn.posY + 0.95D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos(entityIn.rotationYaw * 0.017453292F) * 00.82F) + zIn, 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	public static void generateAirshipSmokeParticles2(Entity entityIn, double xIn, double yIn, double zIn)
	{
		entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entityIn.posX - (double)(MathHelper.sin((-entityIn.rotationYaw - 15) * 0.017453292F) * 00.96F) + xIn, 
		entityIn.posY + 0.98D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos((entityIn.rotationYaw + 15) * 0.017453292F) * 00.96F) + zIn, 
		0.0D, 0.0D, 0.0D, new int[0]);
		
		entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entityIn.posX - (double)(MathHelper.sin((-entityIn.rotationYaw - 345) * 0.017453292F) * 00.96F) + xIn, 
		entityIn.posY + 0.98D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos((entityIn.rotationYaw + 345) * 0.017453292F) * 00.96F) + zIn, 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	
	//============================================
	
	//Bomb Particles
	public static void generateBombFuseSmokeParticles(Entity entityIn)
	{
		entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entityIn.posX + (entityIn.world.rand.nextFloat() * 0.025D), 
		entityIn.posY + 1.6D + (entityIn.world.rand.nextFloat() * 0.025D), 
		entityIn.posZ + (entityIn.world.rand.nextFloat() * 0.025D), 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	public static void generateBombFuseFlameParticles(Entity entityIn)
	{
		entityIn.world.spawnParticle(EnumParticleTypes.FLAME, 
		entityIn.posX + (entityIn.world.rand.nextFloat() * 0.025D), 
		entityIn.posY + 1.6D + (entityIn.world.rand.nextFloat() * 0.025D), 
		entityIn.posZ + (entityIn.world.rand.nextFloat() * 0.025D), 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	public static void generateBombExplosionSmallParticles(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.1D;
	    double motionY = entityIn.world.rand.nextGaussian() * 0.1D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.1D;
	    
	    Particle particleExplosionSmall = new EntityBombExplosionSmallFX(
	          entityIn.world, 
	          entityIn.posX + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
	          entityIn.posY + 0.5D + entityIn.world.rand.nextFloat() * entityIn.height, 
	          entityIn.posZ + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
	          motionX, motionY, motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleExplosionSmall);        
	}
	public static void generateBombExplosionLargeParticles(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.15D;
	    double motionY = entityIn.world.rand.nextGaussian() * 0.15D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.15D;
	    
	    Particle particleExplosionLarge = new EntityBombExplosionLargeFX(
	          entityIn.world, 
	          entityIn.posX + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
	          entityIn.posY + 0.5D + entityIn.world.rand.nextFloat() * entityIn.height, 
	          entityIn.posZ + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
	          motionX, motionY, motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleExplosionLarge);        
	}
	
	//============================================
	
	//Engine Particle System
	public static void generateParticleRunesNormal(Entity entity)
	{
	    double motionX = entity.world.rand.nextGaussian() * 0.03D;
	    double motionY = entity.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.03D;
	    
	    Particle particleRunic = new EntityRunicWhiteFX(entity.world, 
	          entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          entity.posY + 0.3D + entity.world.rand.nextFloat() * entity.height, 
	          entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleRunic);        
	}
	
	public static void generateParticleRunesRainbow(Entity entity)
	{
	    double motionX = entity.world.rand.nextGaussian() * 0.03D;
	    double motionY = entity.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.03D;
	    
	    Particle particleRunic = new EntityRunicRainbowFX(entity.world, 
	          entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          entity.posY + 0.3D + entity.world.rand.nextFloat() * entity.height, 
	          entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleRunic);        
	}
	
	public static void generateParticleFlamesNormal(Entity entity)
	{
		double motionX = entity.world.rand.nextGaussian() * 0.02D;
	    double motionY = entity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.02D;
	    
		entity.world.spawnParticle(EnumParticleTypes.FLAME, 
		entity.posX - (double)(MathHelper.sin(-entity.rotationYaw * 0.017453292F) * 0.9F), 
		entity.posY + 0.4D + (entity.world.rand.nextFloat() * 0.025D), 
		entity.posZ - (double)(MathHelper.cos(entity.rotationYaw * 0.017453292F) * 0.9F), 
		motionX, motionY, motionZ, new int[0]);
	}
	
	public static void generateParticleFlamesColor(Entity entity)
	{
	    double motionX = entity.world.rand.nextGaussian() * 0.02D;
	    double motionY = entity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleColorFlame = new EntityColorFlameFX(entity.world, 
	    	entity.posX - (double)(MathHelper.sin(-entity.rotationYaw * 0.017453292F) * 0.9F), 
	    	entity.posY + 0.4D, 
	        entity.posZ - (double)(MathHelper.cos(entity.rotationYaw * 0.017453292F) * 0.9F), 
	        motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleColorFlame);        
	}
	
	
	
	//=======================================================
	
	public static void generateExplosions(Entity entity)
	{
		entity.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
				entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
				entity.posY + 0.5D,
				entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
				0.0D, 0.0D, 0.0D, new int[0]);
    	
    	for (int ii = 0; ii < 10; ++ii)
    	{
    		int d = References.random.nextInt(100) + 1;
    		
    		if (d <= 2)
    		{
    			entity.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
    					entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					entity.posY + 0.5D,
    					entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					0.0D, 0.0D, 0.0D, new int[0]);
    		}
    		
    		if (d <= 15)
    		{
    			entity.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
    					entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					entity.posY + 0.5D,
    					entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					0.0D, 0.25D, 0.0D, new int[0]);
    		}
    		
    		if (d <= 25)
    		{
    			entity.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
    					entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					entity.posY + 0.5D,
    					entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width,
    					0.0D, 0.0D, 0.0D, new int[0]);
    		}
    	}
	}
	
	//=======================================================
	
	public static void generateUnholyParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    Particle particleUnholy = new EntityUnholyFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
}

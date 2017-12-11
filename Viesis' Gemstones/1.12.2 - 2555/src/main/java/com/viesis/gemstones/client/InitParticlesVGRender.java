package com.viesis.gemstones.client;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.client.particle.EntityColorFlameFX;
import com.viesis.gemstones.client.particle.EntityGemstoneRunesFX;
import com.viesis.gemstones.client.particle.EntityRunicFX;
import com.viesis.gemstones.client.particle.EntityUnholyFX;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;

public class InitParticlesVGRender {
	
	public static void generateRunicWorkbenchParticles(TileEntityGemstoneWorkbench entity)
	{
		double motionX = entity.getWorld().rand.nextGaussian() * 0.03D;
	    double motionY = entity.getWorld().rand.nextGaussian() * 0.03D;
	    double motionZ = entity.getWorld().rand.nextGaussian() * 0.03D;
	    
	    Particle particleRunic = new EntityGemstoneRunesFX(entity.getWorld(), 
			entity.getPos().getX() + entity.getWorld().rand.nextFloat(), 
			entity.getPos().getY() + entity.getWorld().rand.nextFloat(), 
			entity.getPos().getZ() + entity.getWorld().rand.nextFloat(), 
			motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleRunic);        
	}
	
	/**
	public static void generateSmokeParticles(Entity entity)
	{
		entity.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
		entity.posX - (double)(MathHelper.sin(-entity.rotationYaw * 0.017453292F) * 00.82F), 
		entity.posY + 0.95D + (entity.world.rand.nextFloat() * 0.025D), 
		entity.posZ - (double)(MathHelper.cos(entity.rotationYaw * 0.017453292F) * 00.82F), 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	
	public static void generateRunicParticles(Entity entity)
	{
	    double motionX = entity.world.rand.nextGaussian() * 0.03D;
	    double motionY = entity.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.03D;
	    
	    Particle particleRunic = new EntityRunicFX(
	          entity.world, 
	          entity.posX + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          entity.posY + 0.3D + entity.world.rand.nextFloat() * entity.height, 
	          entity.posZ + entity.world.rand.nextFloat() * entity.width * 2.0F - entity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleRunic);        
	}
	
	public static void generateFlameParticles(Entity entity)
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
	
	public static void generateColorFlameParticles(Entity entity)
	{
	    double motionX = entity.world.rand.nextGaussian() * 0.02D;
	    double motionY = entity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = entity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleColorFlame = new EntityColorFlameFX(
	    	entity.world, 
	    	entity.posX - (double)(MathHelper.sin(-entity.rotationYaw * 0.017453292F + 1) * 01.005F), 
	    	entity.posY + 0.5D, 
	        entity.posZ - (double)(MathHelper.cos(entity.rotationYaw * 0.017453292F - 1) * 01.005F), 
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
	
	public void generateUnholyParticles(Entity theEntity)
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
	
	
	
	//=============================================================
	
	/**
	 * Particles
	 */
	/**
	@Override
	public void generateSprintParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    Particle particleSprint = new EntitySprintFX(
	    	theEntity.world, 
	    	theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	        theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	        theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	        motionX, 
	        motionY, 
	        motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleSprint);        
	}
	
	@Override
	public void generateUnholyParticles(Entity theEntity)
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
	
	@Override
	public void generateFlightParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    Particle particleFlight = new EntityFlightFX(
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
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleFlight);        
	}
	
	@Override
	public void generateEnchEbonParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    Particle particleEnchEbon = new EntityEnchEbonFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          theEntity.posY + 0.1D + theEntity.world.rand.nextFloat() 
	                * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width 
	                * 2.0F - theEntity.width, 
	          motionX, 
	          motionY, 
	          motionZ);
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleEnchEbon);        
	}
	*/
}

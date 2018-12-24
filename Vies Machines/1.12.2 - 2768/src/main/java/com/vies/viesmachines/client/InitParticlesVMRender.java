package com.vies.viesmachines.client;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.particle.EntityBombExplosionLargeFX;
import com.vies.viesmachines.client.particle.EntityBombExplosionSmallFX;
import com.vies.viesmachines.client.particle.EntityExtractorFX;
import com.vies.viesmachines.client.particle.EntityHealAmmoFX;
import com.vies.viesmachines.client.particle.EntityHealDurabilityFX;
import com.vies.viesmachines.client.particle.EntityHealEnergyFX;
import com.vies.viesmachines.client.particle.EntityHealHealthFX;
import com.vies.viesmachines.client.particle.EntityUpgradeFX;
import com.vies.viesmachines.common.entity.particles.EntityStaticCharge;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.Entity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.MathHelper;

public class InitParticlesVMRender {
	
	//==================================================
    // TODO             Tile Entities
	//==================================================
    
    public static void generateParticlesExtractor(TileEntityExtractor entity)
	{
		double motionX = entity.getWorld().rand.nextGaussian() * 0.03D;
	    double motionY = entity.getWorld().rand.nextGaussian() * 0.03D;
	    double motionZ = entity.getWorld().rand.nextGaussian() * 0.03D;
	    
	    Particle particleRunic = new EntityExtractorFX(entity.getWorld(), 
			entity.getPos().getX() + entity.getWorld().rand.nextFloat(), 
			entity.getPos().getY() + entity.getWorld().rand.nextFloat(), 
			entity.getPos().getZ() + entity.getWorld().rand.nextFloat(), 
			motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleRunic);        
	}
	
	
    
	//==================================================
    // TODO            Broken Particles
	//==================================================
    
    public static void generateParticlesBrokenSmoke(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.02D;
	    double motionY = 0;//entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.02D;
	    
	    entityIn.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
	    		(double)entityIn.posX + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
	    		(double)entityIn.posY + (double)(entityIn.world.rand.nextFloat() * 0.025D) + 0.5D, 
	    		(double)entityIn.posZ + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
	    		motionX, motionY, motionZ, new int[0]);  
	}
	
	public static void generateParticlesBrokenBubbles(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionY = 0;//entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.03D;
	    
	    entityIn.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, 
	    		(double)entityIn.posX + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
				(double)entityIn.posY + (double)(entityIn.world.rand.nextFloat() * 0.025D) + 0.25D, 
				(double)entityIn.posZ + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
	    		motionX, motionY, motionZ, new int[0]);      
	}
	
	public static void generateParticlesBrokenWakes(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.02D;
	    double motionY = 0;//entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.02D;
	    
	    entityIn.world.spawnParticle(EnumParticleTypes.WATER_WAKE, 
	    		(double)entityIn.posX + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
				(double)entityIn.posY + (double)(entityIn.world.rand.nextFloat() * 0.025D) + 0.25D, 
				(double)entityIn.posZ + (double)(entityIn.world.rand.nextFloat() * entityIn.width * 2.0F) - (double)entityIn.width, 
	    		motionX, motionY, motionZ, new int[0]);      
	}
	
	
    
	//==================================================
    // TODO            Broken Particles
	//==================================================
    
	public static void generateParticlesExplosions(Entity entity)
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
	
	
    
	//==================================================
    // TODO           Projectile Particles
	//==================================================

	/** Used when using an upgrade item on a machine. */
	public static void generateUpgradeParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleUnholy = new EntityUpgradeFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	/** Used when using a health healing item on a machine. */
	public static void generateHealHealthParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleUnholy = new EntityHealHealthFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	/** Used when using an energy healing item on a machine. */
	public static void generateHealEnergyParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleUnholy = new EntityHealEnergyFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	/** Used when using a durability healing item on a machine. */
	public static void generateHealDurabilityParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleUnholy = new EntityHealDurabilityFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	/** Used when using a ammo healing item on a machine. */
	public static void generateAmmoParticles(Entity theEntity)
	{
	    double motionX = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionY = theEntity.world.rand.nextGaussian() * 0.02D;
	    double motionZ = theEntity.world.rand.nextGaussian() * 0.02D;
	    
	    Particle particleUnholy = new EntityHealAmmoFX(
	          theEntity.world, 
	          theEntity.posX + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          theEntity.posY + 0.5D + theEntity.world.rand.nextFloat() * theEntity.height, 
	          theEntity.posZ + theEntity.world.rand.nextFloat() * theEntity.width * 2.0F - theEntity.width, 
	          motionX, motionY, motionZ);
	    
	    Minecraft.getMinecraft().effectRenderer.addEffect(particleUnholy);        
	}
	
	/** Static Charge that builds up before a lightning strike. */
	public static void generateParticleStaticCharge(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionY = entityIn.world.rand.nextGaussian() * 0.03D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.03D;
	    
	    EntityStaticCharge entityParticleStaticCharge = new EntityStaticCharge(entityIn.world, 
	    		entityIn.posX + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
		        entityIn.posY + 0.3D + entityIn.world.rand.nextFloat() * entityIn.height, 
		        entityIn.posZ + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width);
	    
	    entityParticleStaticCharge.shoot(motionX, motionY, motionZ, 0.1F, 0.2F);
	    
	    entityIn.world.spawnEntity(entityParticleStaticCharge);
	}
	
	/** Burst of static electric particles after a lightning strike. */
	public static void generateParticleStaticChargeLightningStrike(Entity entityIn)
	{
	    double motionX = entityIn.world.rand.nextGaussian() * 0.1D;
	    double motionY = entityIn.world.rand.nextGaussian() * 0.1D;
	    double motionZ = entityIn.world.rand.nextGaussian() * 0.1D;
	    
	    EntityStaticCharge entityParticleStaticCharge = new EntityStaticCharge(entityIn.world, 
	    		entityIn.posX + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width, 
		          entityIn.posY + 0.5D + entityIn.world.rand.nextFloat() * entityIn.height, 
		          entityIn.posZ + entityIn.world.rand.nextFloat() * entityIn.width * 2.0F - entityIn.width 
		          );
	    
	    entityParticleStaticCharge.shoot(motionX, motionY, motionZ, 0.1F, 0.2F);
	    
	    entityIn.world.spawnEntity(entityParticleStaticCharge);
	}
	
	
    
	//==================================================
    // TODO         Engine Smoke Particles
	//==================================================

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
		entityIn.posX - (double)(MathHelper.sin(-entityIn.rotationYaw * 0.017453292F) * 01.04F) + xIn, 
		entityIn.posY + 0.95D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos(entityIn.rotationYaw * 0.017453292F) * 01.04F) + zIn, 
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
		entityIn.posX - (double)(MathHelper.sin((-entityIn.rotationYaw - 345) * 0.017453292F) * 01.00F) + xIn, 
		entityIn.posY + 0.98D + (entityIn.world.rand.nextFloat() * 0.025D) + yIn, 
		entityIn.posZ - (double)(MathHelper.cos((entityIn.rotationYaw + 345) * 0.017453292F) * 01.00F) + zIn, 
		0.0D, 0.0D, 0.0D, new int[0]);
	}
	
	
    
	//==================================================
    // TODO            Bomb Particles
	//==================================================

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
}

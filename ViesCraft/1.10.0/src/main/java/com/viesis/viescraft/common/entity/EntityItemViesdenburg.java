package com.viesis.viescraft.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemViesdenburg extends EntityThrowable {
	
    public EntityItemViesdenburg(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemViesdenburg(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemViesdenburg(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
    protected float getGravityVelocity()
    {
        return 0.07F;
    }
    
    protected float getVelocity()
    {
        return 0.7F;
    }
    
    protected float getInaccuracy()
    {
        return -20.0F;
    }
    
    /** 
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
    	
    	
    	if (this.worldObj.isRemote)
    	{
    		for (int ii = 0; ii < 10; ++ii)
        	{
        		this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, this.posX + rand.nextDouble(), this.posY + 0.5D, this.posZ + rand.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
        		this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, this.posX + rand.nextDouble(), this.posY + 0.5D, this.posZ + rand.nextDouble(), 0.0D, 0.0D, 0.0D, new int[0]);
        		this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        	}
    		
        	for (int ii = 0; ii < 20; ++ii)
        	{
        		this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        	}
    	}
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	
            this.worldObj.spawnEntityInWorld(new EntityAirshipVC(this.worldObj, this.posX, this.posY, this.posZ));
            this.setDead();
        }
    }
}

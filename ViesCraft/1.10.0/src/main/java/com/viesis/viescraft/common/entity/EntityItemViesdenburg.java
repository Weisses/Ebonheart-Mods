package com.viesis.viescraft.common.entity;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemViesdenburg extends EntityThrowable {
	
	Random random = new Random();
	
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
    
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	
            this.worldObj.spawnEntityInWorld(new EntityAirshipVC(this.worldObj, this.posX, this.posY, this.posZ));
            this.setDead();
        }
        else
    	{
    		for (int ii = 0; ii < 10; ++ii)
        	{
    			int d = random.nextInt(100) + 1;
				
    			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
    					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
    					this.posY + 0.5D,
    					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
    					0.0D, 0.0D, 0.0D, new int[0]);
            	
				if (d <= 2)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.0D, 0.0D, new int[0]);
				}
				if (d <= 15)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.25D, 0.0D, new int[0]);
				}
				if (d <= 25)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.0D, 0.0D, new int[0]);
				}
			}
    	}
    }
}

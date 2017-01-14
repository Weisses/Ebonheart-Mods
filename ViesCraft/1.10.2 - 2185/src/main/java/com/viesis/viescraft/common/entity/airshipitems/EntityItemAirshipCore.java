package com.viesis.viescraft.common.entity.airshipitems;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipCore extends EntityThrowable {
	
	public static Random random = new Random();
	
    public EntityItemAirshipCore(World worldObjIn)
    {
        super(worldObjIn);
    }
    
    public EntityItemAirshipCore(World worldObjIn, EntityLivingBase entity)
    {
        super(worldObjIn, entity);
    }
    
    public EntityItemAirshipCore(World worldObjIn, double x, double y, double z)
    {
        super(worldObjIn, x, y, z);
    }
    
    protected float getGravityVelocity()
    {
        return 0.07F;
    }
    
    protected float getVelocity()
    {
        return 0.7F;
    }
    
    @Override
	protected void onImpact(RayTraceResult result)
	{
		
	}
    
    /**
     * Animations for airship spawning. Must be called client side.
     */
    protected void explosionAnimation()
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

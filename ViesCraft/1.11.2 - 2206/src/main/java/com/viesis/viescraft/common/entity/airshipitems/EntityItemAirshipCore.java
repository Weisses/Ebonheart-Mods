package com.viesis.viescraft.common.entity.airshipitems;

import com.viesis.viescraft.api.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipCore extends EntityThrowable {
	
    public EntityItemAirshipCore(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipCore(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemAirshipCore(World worldIn, double x, double y, double z)
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
			int d = Reference.random.nextInt(100) + 1;
			
			this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
					this.posX + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.0D, 0.0D, new int[0]);
        	
			if (d <= 2)
			{
				this.world.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
					this.posX + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.0D, 0.0D, new int[0]);
			}
			if (d <= 15)
			{
				this.world.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
					this.posX + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.25D, 0.0D, new int[0]);
			}
			if (d <= 25)
			{
				this.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
					this.posX + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.world.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.0D, 0.0D, new int[0]);
			}
		}
    }
}

package com.viesis.viescraft.common.entity;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBombBig extends EntityThrowable {
	
    public EntityBombBig(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityBombBig(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityBombBig(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    protected float getGravityVelocity()
    {
        return 0.005F;
    }
    
    protected float getVelocity()
    {
        return 0.1F;
    }
    
    @Override
    public void onUpdate()
    {
    	if(this.isInWater()
		|| this.isInWeb
		|| this.isInLava())
		{
			this.onImpact(new RayTraceResult(this));
		}
    	super.onUpdate();
    }
    
    @Override
	protected void onImpact(RayTraceResult result)
	{
		if(result.entityHit instanceof EntityAirshipCore
		||	result.entityHit instanceof EntityPlayer)
		{
			
		}
		else
		{
			if (!this.world.isRemote)
	        {
				this.world.createExplosion(this, this.posX, this.posY, this.posZ, 
						EnumsVC.Bombs.byId(2).getExplosionStrength(), true);
				this.setDead();
	        }
			else
			{
				for(int i = 0; i < 100; i++)
				{
					InitParticlesVCRender.generateBombExplosionSmallParticles(this);
					InitParticlesVCRender.generateBombExplosionLargeParticles(this);
				}
				for(int i = 0; i < 100; i++)
				{
					InitParticlesVCRender.generateBombExplosionSmallParticles(this);
					InitParticlesVCRender.generateBombExplosionLargeParticles(this);
				}
			}
		}
	}
}

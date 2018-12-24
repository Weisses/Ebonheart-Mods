package com.vies.viesmachines.common.entity.particles;

import com.vies.viesmachines.client.InitParticlesVMRender;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityMachineFlyingBombNormal extends EntityThrowable {
	
    public EntityMachineFlyingBombNormal(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityMachineFlyingBombNormal(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityMachineFlyingBombNormal(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    protected float getGravityVelocity()
    {
        return 0.01F;
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
    	if(result.entityHit instanceof EntityMachineBase
		|| result.entityHit instanceof EntityPlayer)
		{
			
		}
		else
		{
			if(!this.world.isRemote)
	        {
				this.world.createExplosion(this, this.posX, this.posY, this.posZ, 4.0F, true);
				this.setDead();
	        }
			else
			{
				for(int i = 0; i < 100; i++)
				{
					InitParticlesVMRender.generateBombExplosionSmallParticles(this);
					InitParticlesVMRender.generateBombExplosionLargeParticles(this);
				}
				for(int i = 0; i < 100; i++)
				{
					InitParticlesVMRender.generateBombExplosionSmallParticles(this);
					InitParticlesVMRender.generateBombExplosionLargeParticles(this);
				}
			}
		}
	}
}

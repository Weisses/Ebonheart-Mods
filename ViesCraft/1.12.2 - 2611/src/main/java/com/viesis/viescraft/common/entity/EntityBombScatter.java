package com.viesis.viescraft.common.entity;

import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBombScatter extends EntityThrowable {
	
    public EntityBombScatter(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityBombScatter(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityBombScatter(World worldIn, double x, double y, double z)
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
    	if(result.entityHit instanceof EntityAirshipCore
		|| result.entityHit instanceof EntityPlayer)
		{
    		
		}
		else
		{
			if(!this.world.isRemote)
	        {
				EntityBombSmall bombDrop1 = new EntityBombSmall(this.world, this.posX + 0.25, this.posY + 0.51, this.posZ + 0.25);
				EntityBombSmall bombDrop2 = new EntityBombSmall(this.world, this.posX + 0.25, this.posY + 0.51, this.posZ - 0.25);
				EntityBombSmall bombDrop3 = new EntityBombSmall(this.world, this.posX - 0.25, this.posY + 0.51, this.posZ + 0.25);
				EntityBombSmall bombDrop4 = new EntityBombSmall(this.world, this.posX - 0.25, this.posY + 0.51, this.posZ - 0.25);
				
				bombDrop1.shoot(this, -45, 0, 0, 0.3F, 0);
				this.world.spawnEntity(bombDrop1);
				
				bombDrop2.shoot(this, -45, 90, 0, 0.3F, 0);
				this.world.spawnEntity(bombDrop2);

				bombDrop3.shoot(this, -45, 180, 0, 0.3F, 0);
				this.world.spawnEntity(bombDrop3);

				bombDrop4.shoot(this, -45, 270, 0, 0.3F, 0);
				this.world.spawnEntity(bombDrop4);
				
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

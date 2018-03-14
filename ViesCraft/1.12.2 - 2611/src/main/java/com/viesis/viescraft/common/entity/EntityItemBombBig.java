package com.viesis.viescraft.common.entity;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemBombBig extends EntityThrowable {
	
    public EntityItemBombBig(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemBombBig(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemBombBig(World worldIn, double x, double y, double z)
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
		}
	}
}

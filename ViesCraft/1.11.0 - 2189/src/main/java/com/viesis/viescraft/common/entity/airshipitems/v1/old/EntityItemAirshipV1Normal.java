package com.viesis.viescraft.common.entity.airshipitems.v1.old;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.v1.old.EntityAirshipV1Normal;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

public class EntityItemAirshipV1Normal extends EntityItemAirshipCore {
	
    public EntityItemAirshipV1Normal(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV1Normal(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemAirshipV1Normal(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityAirshipV1Normal(this.worldObj, this.posX, this.posY + 0.5F, this.posZ));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}
package com.viesis.viescraft.common.entity.airshipitems.v1;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.v1.EntityV1Iron;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

public class EntityItemV1Iron extends EntityItemAirshipCore {
	
	private int type;
	
    public EntityItemV1Iron(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemV1Iron(World worldIn, EntityLivingBase entity, int typeIn)
    {
        super(worldIn, entity);
        this.type = typeIn;
    }
    
    public EntityItemV1Iron(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityV1Iron(this.worldObj, this.posX, this.posY + 0.5F, this.posZ, this.type));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}
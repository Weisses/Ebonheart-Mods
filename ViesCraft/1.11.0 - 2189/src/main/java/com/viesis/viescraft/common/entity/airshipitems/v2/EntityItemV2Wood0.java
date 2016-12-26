package com.viesis.viescraft.common.entity.airshipitems.v2;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.v2.EntityV2Wood0;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

public class EntityItemV2Wood0 extends EntityItemAirshipCore {
	
	private int type;
	
    public EntityItemV2Wood0(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemV2Wood0(World worldIn, EntityLivingBase entity, int typeIn)
    {
        super(worldIn, entity);
        this.type = typeIn;
    }
    
    public EntityItemV2Wood0(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityV2Wood0(this.worldObj, this.posX, this.posY + 0.5F, this.posZ, this.type));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}

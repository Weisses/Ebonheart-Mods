package com.viesis.viescraft.common.entity.airshipitems.v4;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipV4 extends EntityItemAirshipCore {
	
	private int metaFrameItem;
	private int metaColorItem;
	
    public EntityItemAirshipV4(World worldObjIn)
    {
        super(worldObjIn);
    }
    
    public EntityItemAirshipV4(World worldObjIn, EntityLivingBase entity, int frameIn, int colorIn)
    {
        super(worldObjIn, entity);
        
        this.metaFrameItem = frameIn;
        this.metaColorItem = colorIn;
    }
    
    public EntityItemAirshipV4(World worldObjIn, double x, double y, double z)
    {
        super(worldObjIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityAirshipV4Core(this.worldObj, this.posX, this.posY + 0.5F, this.posZ, this.metaFrameItem, this.metaColorItem));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}

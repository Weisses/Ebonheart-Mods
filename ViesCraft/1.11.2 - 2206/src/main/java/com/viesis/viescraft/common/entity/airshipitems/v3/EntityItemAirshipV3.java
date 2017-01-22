package com.viesis.viescraft.common.entity.airshipitems.v3;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipitems.v1.old.EntityItemAirshipCoreOLD;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipV3 extends EntityItemAirshipCoreOLD {
	
	private int metaFrameItem;
	private int metaColorItem;
	
    public EntityItemAirshipV3(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV3(World worldIn, EntityLivingBase entity, int frameIn, int colorIn)
    {
        super(worldIn, entity);
        
        this.metaFrameItem = frameIn;
        this.metaColorItem = colorIn;
    }
    
    public EntityItemAirshipV3(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.world.spawnEntity(new EntityAirshipV3Core(this.world, this.posX, this.posY + 0.5F, this.posZ, this.metaFrameItem, this.metaColorItem));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}

package com.viesis.viescraft.common.entity.airshipitems.v2;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipV2 extends EntityItemAirshipCore {
	
	private int metaFrameItem;
	
	private float metaColorRedItem;
	private float metaColorGreenItem;
	private float metaColorBlueItem;
	
    public EntityItemAirshipV2(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV2(World worldIn, EntityLivingBase entity, int frameIn, float colorRed, float colorGreen, float colorBlue)
    {
        super(worldIn, entity);
        
        this.metaFrameItem = frameIn;
        this.metaColorRedItem = colorRed;
        this.metaColorGreenItem = colorGreen;
        this.metaColorBlueItem = colorBlue;
    }
    
    public EntityItemAirshipV2(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.world.spawnEntity(new EntityAirshipV2Core(this.world, this.posX, this.posY + 0.5F, this.posZ, this.metaFrameItem, this.metaColorRedItem, this.metaColorGreenItem, this.metaColorBlueItem));
            
        	this.setDead();
        }
        else
    	{
        	this.explosionAnimation();
    	}
    }
}

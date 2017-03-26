package com.viesis.viescraft.common.entity.airshipitems.v3;

import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipV3 extends EntityItemAirshipCore {
	
	private int metaFrameVisualItem;
	private boolean frameVisualActiveItem;
	
	private int metaFrameItem;
	private int metaBalloonItem;
	
	private int metaColorRedItem;
	private int metaColorGreenItem;
	private int metaColorBlueItem;
	
    public EntityItemAirshipV3(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV3(World worldIn, EntityLivingBase entity, int frameIn, int balloonIn, int colorRed, int colorGreen, int colorBlue, int frameVisualIn, boolean frameVisualActive)
    {
        super(worldIn, entity);
        
        this.metaFrameVisualItem = frameVisualIn;
        this.frameVisualActiveItem = frameVisualActive;
        
        this.metaFrameItem = frameIn;
        this.metaBalloonItem = balloonIn;
        this.metaColorRedItem = colorRed;
        this.metaColorGreenItem = colorGreen;
        this.metaColorBlueItem = colorBlue;
    }
    
    public EntityItemAirshipV3(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityAirshipV3Core(this.worldObj, this.posX, this.posY + 0.5F, this.posZ, this.metaFrameItem, this.metaBalloonItem, this.metaColorRedItem, this.metaColorGreenItem, this.metaColorBlueItem, this.metaFrameVisualItem, this.frameVisualActiveItem));
            
        	this.setDead();
        }
        else
    	{
        	InitParticlesVCRender.generateExplosions(this);
    	}
    }
}

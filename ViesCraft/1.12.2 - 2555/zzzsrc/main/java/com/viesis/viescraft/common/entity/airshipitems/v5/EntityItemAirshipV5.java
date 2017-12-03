package com.viesis.viescraft.common.entity.airshipitems.v5;

import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV5Core;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipV5 extends EntityItemAirshipCore {
	
	private int metaFrameVisualItem;
	private boolean frameVisualActiveItem;
	
	private int metaFrameItem;
	private int metaBalloonItem;
	
	private int metaColorRedItem;
	private int metaColorGreenItem;
	private int metaColorBlueItem;
	
    public EntityItemAirshipV5(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV5(World worldIn, EntityLivingBase entity, int frameIn, int balloonIn, int colorRed, int colorGreen, int colorBlue, int frameVisualIn, boolean frameVisualActive)
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
    
    public EntityItemAirshipV5(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.world.spawnEntity(new EntityAirshipV5Core(this.world, this.posX, this.posY + 0.5F, this.posZ, this.metaFrameItem, this.metaBalloonItem, this.metaColorRedItem, this.metaColorGreenItem, this.metaColorBlueItem, this.metaFrameVisualItem, this.frameVisualActiveItem));
            
        	this.setDead();
        }
        else
    	{
        	InitParticlesVCRender.generateExplosions(this);
    	}
    }
}

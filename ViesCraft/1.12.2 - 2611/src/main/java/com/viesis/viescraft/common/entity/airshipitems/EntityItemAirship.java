package com.viesis.viescraft.common.entity.airshipitems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;

public class EntityItemAirship extends EntityItemAirshipCore {
	
    public EntityItemAirship(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirship(World worldIn, EntityLivingBase entity,
    		int coreIn, int frameIn, int engineIn, int balloonIn, 
    		int moduleSlot1In, 
    		int coreVisualIn, 
    		int frameVisualIn, boolean frameVisualTransparentIn, boolean frameVisualColorIn,
    		int frameColorRedIn, int frameColorGreenIn, int frameColorBlueIn,
    		int engineVisualIn, 
    		int balloonVisualIn, boolean balloonVisualTransparentIn, boolean balloonVisualColorIn,
    		int balloonColorRedIn, int balloonColorGreenIn, int balloonColorBlueIn,
    		boolean learnedModuleAltitudeIn, int selectedModuleAltitudeIn, 
    		boolean learnedModuleSpeedIn, int selectedModuleSpeedIn, 
    		boolean learnedModuleStorageIn, int selectedModuleStorageIn, 
    		boolean learnedModuleFuelIn, int selectedModuleFuelIn, 
    		boolean learnedModuleMusicIn, int selectedModuleMusicIn, 
    		boolean learnedModuleCruiseIn, int selectedModuleCruiseIn, 
    		boolean learnedModuleWaterIn, int selectedModuleWaterIn, 
    		boolean learnedModuleFuelInfiniteIn, int selectedModuleFuelInfiniteIn)
    {
        super(worldIn, entity);
        
        this.metaTypeCore = coreIn;
        this.metaTypeFrame = frameIn;
        this.metaTypeEngine = engineIn;
        this.metaTypeBalloon = balloonIn;
        
        this.metaModuleVariantSlot1 = moduleSlot1In;
        
        this.metaCoreVisual = coreVisualIn;
        
        this.metaFrameVisual = frameVisualIn;
        this.metaFrameVisualTransparent = frameVisualTransparentIn;
        this.metaFrameVisualColor = frameVisualColorIn;
        this.metaFrameColorRed = frameColorRedIn;
        this.metaFrameColorGreen = frameColorGreenIn;
        this.metaFrameColorBlue = frameColorBlueIn;
        
        this.metaEngineVisual = engineVisualIn;
        
        this.metaBalloonVisual = balloonVisualIn;
        this.metaBalloonVisualTransparent = balloonVisualTransparentIn;
        this.metaBalloonVisualColor = balloonVisualColorIn;
        this.metaBalloonColorRed = balloonColorRedIn;
        this.metaBalloonColorGreen = balloonColorGreenIn;
        this.metaBalloonColorBlue = balloonColorBlueIn;
        
        this.learnedModuleAltitude = learnedModuleAltitudeIn;
        this.selectedModuleAltitude = selectedModuleAltitudeIn;
        this.learnedModuleSpeed = learnedModuleSpeedIn;
        this.selectedModuleSpeed = selectedModuleSpeedIn;
        this.learnedModuleStorage = learnedModuleStorageIn;
        this.selectedModuleStorage = selectedModuleStorageIn;
        this.learnedModuleFuel = learnedModuleFuelIn;
        this.selectedModuleFuel = selectedModuleFuelIn;
        this.learnedModuleMusic = learnedModuleMusicIn;
        this.selectedModuleMusic = selectedModuleMusicIn;
        this.learnedModuleCruise = learnedModuleCruiseIn;
        this.selectedModuleCruise = selectedModuleCruiseIn;
        this.learnedModuleWater = learnedModuleWaterIn;
        this.selectedModuleWater = selectedModuleWaterIn;
        this.learnedModuleFuelInfinite = learnedModuleFuelInfiniteIn;
        this.selectedModuleFuelInfinite = selectedModuleFuelInfiniteIn;
    }
    
    public EntityItemAirship(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if(!this.world.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.world.spawnEntity(new EntityAirshipCore(this.world, this.posX, this.posY + 0.5F, this.posZ, 
    			this.metaTypeCore, this.metaTypeFrame, this.metaTypeEngine, this.metaTypeBalloon, 
    			this.metaModuleVariantSlot1, 
    			this.metaCoreVisual, 
	    		this.metaFrameVisual, this.metaFrameVisualTransparent, this.metaFrameVisualColor,
	    		this.metaFrameColorRed, this.metaFrameColorGreen, this.metaFrameColorBlue,
	    		this.metaEngineVisual, 
	    		this.metaBalloonVisual, this.metaBalloonVisualTransparent, this.metaBalloonVisualColor,
	    		this.metaBalloonColorRed, this.metaBalloonColorGreen, this.metaBalloonColorBlue,
	    		this.learnedModuleAltitude, this.selectedModuleAltitude, 
	    		this.learnedModuleSpeed, this.selectedModuleSpeed, 
	    		this.learnedModuleStorage, this.selectedModuleStorage, 
	    		this.learnedModuleFuel, this.selectedModuleFuel, 
	    		this.learnedModuleMusic, this.selectedModuleMusic, 
	    		this.learnedModuleCruise, this.selectedModuleCruise, 
	    		this.learnedModuleWater, this.selectedModuleWater, 
	    		this.learnedModuleFuelInfinite, this.selectedModuleFuelInfinite));
            
        	this.setDead();
        }
        else
    	{
        	InitParticlesVCRender.generateExplosions(this);
    	}
    }
}

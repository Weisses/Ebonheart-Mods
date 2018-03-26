package com.viesis.viescraft.common.entity;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownAirship extends EntityThrownAirshipCore {
	
    public EntityThrownAirship(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityThrownAirship(World worldIn, EntityLivingBase entityIn, 
    		int coreTierIn, int frameTierIn, int engineTierIn, int balloonTierIn, 
    		int moduleSlot1In, 
    		int fuelIn, int fuelTotalIn, int redstoneIn, int redstoneTotalIn, 
    		
    		int coreModelVisualFrameIn, 
    		int coreModelVisualEngineIn, 
    		int coreModelVisualBalloonIn, 
    		
    		int frameSkinTextureIn, 
    		boolean frameSkinTransparentIn, 
    		int frameSkinColorRedIn, int frameSkinColorGreenIn, int frameSkinColorBlueIn,
    		
    		int engineParticleVisualIn, 
    		int engineDisplayTypeVisualIn, int engineDisplayIDVisualIn,
    		
    		int balloonPatternTextureIn, 
    		boolean balloonPatternTransparentIn, 
    		int balloonPatternColorRedIn, int balloonPatternColorGreenIn, int balloonPatternColorBlueIn, 
    		
    		boolean learnedModuleAltitudeIn, int selectedModuleAltitudeIn, 
    		boolean learnedModuleSpeedIn, int selectedModuleSpeedIn, 
    		boolean learnedModuleStorageIn, int selectedModuleStorageIn, 
    		boolean learnedModuleFuelIn, int selectedModuleFuelIn, 
    		boolean learnedModuleMusicIn, int selectedModuleMusicIn, 
    		boolean learnedModuleCruiseIn, int selectedModuleCruiseIn, 
    		boolean learnedModuleWaterIn, int selectedModuleWaterIn, 
    		boolean learnedModuleFuelInfiniteIn, int selectedModuleFuelInfiniteIn,
    		boolean learnedModuleBombIn, int selectedModuleBombIn,
    		
    		NBTTagCompound compoundIn, String customNameIn)
    {
        super(worldIn, entityIn);
        
        this.customName = customNameIn;
        
        this.mainTierCore = coreTierIn;
        this.mainTierFrame = frameTierIn;
        this.mainTierEngine = engineTierIn;
        this.mainTierBalloon = balloonTierIn;
        
        this.moduleActiveSlot1 = moduleSlot1In;
        
        this.storedFuel = fuelIn;
        this.storedFuelTotal = fuelTotalIn;
        this.storedRedstone = redstoneIn;
        this.storedRedstoneTotal = redstoneTotalIn;
        
        this.coreModelVisualFrame = coreModelVisualFrameIn;
        this.coreModelVisualEngine = coreModelVisualEngineIn;
        this.coreModelVisualBalloon = coreModelVisualBalloonIn;
        
        this.frameSkinTexture = frameSkinTextureIn;
        this.frameSkinTransparent = frameSkinTransparentIn;
        this.frameSkinColorRed = frameSkinColorRedIn;
        this.frameSkinColorGreen = frameSkinColorGreenIn;
        this.frameSkinColorBlue = frameSkinColorBlueIn;
        
        this.engineParticleVisual = engineParticleVisualIn;
        this.engineDisplayTypeVisual = engineDisplayTypeVisualIn;
        this.engineDisplayIDVisual = engineDisplayIDVisualIn;
        
        this.balloonPatternTexture = balloonPatternTextureIn;
        this.balloonPatternTransparent = balloonPatternTransparentIn;
        this.balloonPatternColorRed = balloonPatternColorRedIn;
        this.balloonPatternColorGreen = balloonPatternColorGreenIn;
        this.balloonPatternColorBlue = balloonPatternColorBlueIn;
        
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
        this.learnedModuleBomb = learnedModuleBombIn;
        this.selectedModuleBomb = selectedModuleBombIn;
        
        this.storedInventory = compoundIn;
    }
    
    public EntityThrownAirship(World worldIn, double x, double y, double z)
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
        			this.mainTierCore, this.mainTierFrame, this.mainTierEngine, this.mainTierBalloon, 
		    		this.moduleActiveSlot1, 
		    		this.storedFuel, this.storedFuelTotal, this.storedRedstone, this.storedRedstoneTotal, 
		    		
		    		this.coreModelVisualFrame, 
		    		this.coreModelVisualEngine, 
		    		this.coreModelVisualBalloon, 
		    		
		    		this.frameSkinTexture, 
		    		this.frameSkinTransparent, 
		    		this.frameSkinColorRed, this.frameSkinColorGreen, this.frameSkinColorBlue, 
		    		
		    		this.engineParticleVisual, 
		    		this.engineDisplayTypeVisual, this.engineDisplayIDVisual, 
		    		
		    		this.balloonPatternTexture, 
		    		this.balloonPatternTransparent, 
		    		this.balloonPatternColorRed, this.balloonPatternColorGreen, this.balloonPatternColorBlue, 
		    		
		    		this.learnedModuleAltitude, this.selectedModuleAltitude, 
		    		this.learnedModuleSpeed, this.selectedModuleSpeed, 
		    		this.learnedModuleStorage, this.selectedModuleStorage, 
		    		this.learnedModuleFuel, this.selectedModuleFuel, 
		    		this.learnedModuleMusic, this.selectedModuleMusic, 
		    		this.learnedModuleCruise, this.selectedModuleCruise, 
		    		this.learnedModuleWater, this.selectedModuleWater, 
		    		this.learnedModuleFuelInfinite, this.selectedModuleFuelInfinite, 
		    		this.learnedModuleBomb, this.selectedModuleBomb, 
		    		
		    		this.storedInventory, this.customName
		    		));
            
        	this.setDead();
        }
        else
    	{
        	InitParticlesVCRender.generateExplosions(this);
    	}
    }
}

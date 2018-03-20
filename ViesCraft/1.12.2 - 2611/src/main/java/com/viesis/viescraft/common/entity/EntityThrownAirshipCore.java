package com.viesis.viescraft.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownAirshipCore extends EntityThrowable {
	
	protected String customName;
	
	protected int storedFuel;
	protected int storedFuelTotal;
	protected int fuelItemStack;
	protected int fuelItemStackSize;
	protected int storedRedstone;
	protected int storedRedstoneTotal;
	
	protected int mainTierCore;
	protected int mainTierFrame;
	protected int mainTierEngine;
	protected int mainTierBalloon;

	protected int coreModelVisualFrame;
	protected int coreModelVisualEngine;
	protected int coreModelVisualBalloon;
	
	protected int frameSkinVisual;
	protected boolean frameSkinVisualTransparent;
	protected boolean frameSkinVisualColor;
	protected int frameSkinColorRed;
	protected int frameSkinColorGreen;
	protected int frameSkinColorBlue;
	
	protected int engineParticleVisual;
	protected int engineDisplayTypeVisual;
	protected int engineDisplayIDVisual;
	
	protected int balloonPatternVisual;
	protected boolean balloonPatternVisualTransparent;
	protected boolean balloonPatternVisualColor;
	protected int balloonPatternColorRed;
	protected int balloonPatternColorGreen;
	protected int balloonPatternColorBlue;
	
	protected int moduleActiveSlot1;
	
	//Modules
	/** Selected Altitude */
	protected int selectedModuleAltitude;
	/** Learned Altitude */
	protected boolean learnedModuleAltitude;
	/** Selected Speed */
	protected int selectedModuleSpeed;
	/** Learned Speed */
	protected boolean learnedModuleSpeed;
	/** Selected Storage */
	protected int selectedModuleStorage;
	/** Learned Storage */
	protected boolean learnedModuleStorage;
	/** Selected Fuel */
	protected int selectedModuleFuel;
	/** Learned Fuel */
	protected boolean learnedModuleFuel;
	/** Selected Music */
	protected int selectedModuleMusic;
	/** Learned Music */
	protected boolean learnedModuleMusic;
	/** Selected Cruise */
	protected int selectedModuleCruise;
	/** Learned Cruise */
	protected boolean learnedModuleCruise;
	/** Selected Water */
	protected int selectedModuleWater;
	/** Learned Water */
	protected boolean learnedModuleWater;
	/** Selected Fuel Infinite */
	protected int selectedModuleFuelInfinite;
	/** Learned Fuel Infinite */
	protected boolean learnedModuleFuelInfinite;
	/** Selected Bomb */
	protected int selectedModuleBomb;
	/** Learned Bomb */
	protected boolean learnedModuleBomb;
	
	protected NBTTagCompound storedInventory;
	
    public EntityThrownAirshipCore(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityThrownAirshipCore(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityThrownAirshipCore(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    protected float getGravityVelocity()
    {
        return 0.07F;
    }
    
    protected float getVelocity()
    {
        return 0.7F;
    }
    
    @Override
	protected void onImpact(RayTraceResult result)
	{
		
	}
}

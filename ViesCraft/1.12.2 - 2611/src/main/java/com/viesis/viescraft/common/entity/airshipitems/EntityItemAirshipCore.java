package com.viesis.viescraft.common.entity.airshipitems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipCore extends EntityThrowable {
	
	protected int metaTypeFrame;
	protected int metaTypeCore;
	protected int metaTypeEngine;
	protected int metaTypeBalloon;
	
	protected int metaModuleVariantSlot1;
	
	protected int metaFrameVisual;
	protected boolean metaFrameVisualTransparent;
	protected boolean metaFrameVisualColor;
	protected int metaFrameColorRed;
	protected int metaFrameColorGreen;
	protected int metaFrameColorBlue;
	
	protected int metaBalloonVisual;
	protected boolean metaBalloonVisualTransparent;
	protected boolean metaBalloonVisualColor;
	protected int metaBalloonColorRed;
	protected int metaBalloonColorGreen;
	protected int metaBalloonColorBlue;
	
	//Modules
	/** Selected Altitude */
	public int selectedModuleAltitude;
	/** Learned Altitude */
	public boolean learnedModuleAltitude;
	/** Selected Speed */
	public int selectedModuleSpeed;
	/** Learned Speed */
	public boolean learnedModuleSpeed;
	/** Selected Storage */
	public int selectedModuleStorage;
	/** Learned Storage */
	public boolean learnedModuleStorage;
	/** Selected Fuel */
	public int selectedModuleFuel;
	/** Learned Fuel */
	public boolean learnedModuleFuel;
	/** Selected Music */
	public int selectedModuleMusic;
	/** Learned Music */
	public boolean learnedModuleMusic;
	/** Selected Cruise */
	public int selectedModuleCruise;
	/** Learned Cruise */
	public boolean learnedModuleCruise;
	/** Selected Water */
	public int selectedModuleWater;
	/** Learned Water */
	public boolean learnedModuleWater;
	/** Selected Fuel Infinite */
	public int selectedModuleFuelInfinite;
	/** Learned Fuel Infinite */
	public boolean learnedModuleFuelInfinite;
	
    public EntityItemAirshipCore(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipCore(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemAirshipCore(World worldIn, double x, double y, double z)
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

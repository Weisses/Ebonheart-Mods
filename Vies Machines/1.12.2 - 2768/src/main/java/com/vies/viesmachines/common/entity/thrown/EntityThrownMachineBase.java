package com.vies.viesmachines.common.entity.thrown;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownMachineBase extends EntityThrowable {
	
	protected int frameTier;
    protected int engineTier;
    protected int componentTier;
    
    protected int type;
    protected float health;
    protected int energy;
    protected int durability;
    
    protected boolean broken;
    protected int fuel;
    protected int fuelTotal;
    
    protected int itemstackFuelItem;
    protected int itemstackFuelSize;
    
    protected int ammoAmount;
    protected int ammoType;
	
    protected int machineEnhancement1;
    
    
    
    protected int visualModelFrame;
    protected int visualModelEngine;
    protected int visualModelComponent;
    
    protected int visualFrameTexture;
    protected boolean visualFrameTransparent;
    protected boolean visualFrameColor;
    protected int visualFrameColorRed;
    protected int visualFrameColorGreen;
    protected int visualFrameColorBlue;
    
    protected int visualEngineParticle;
    protected int visualEngineDisplayType;
    protected int visualEngineDisplayItemstack;
    protected int visualEngineDisplayItemstackMeta;
    protected int visualEngineDisplayHead;
    protected int visualEngineDisplaySupporterHead;
    protected int visualEngineDisplayHoliday;
    
    protected int visualComponentTexture;
    protected boolean visualComponentTransparent;
    protected boolean visualComponentColor;
    protected int visualComponentColorRed;
    protected int visualComponentColorGreen;
    protected int visualComponentColorBlue;
    
    protected NBTTagCompound storedInventory;
    
    protected String customName;
    protected int visualNameColor;
    
	
	
    public EntityThrownMachineBase(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityThrownMachineBase(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityThrownMachineBase(World worldIn, double x, double y, double z)
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

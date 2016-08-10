package com.viesis.viescraft.common.entity.airshipitems;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityItemAirshipCore extends EntityThrowable {
	
	public static Random random = new Random();
	
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
    
    protected float getInaccuracy()
    {
        return -20.0F;
    }
    
    @Override
	protected void onImpact(RayTraceResult result)
	{
		
	}
}

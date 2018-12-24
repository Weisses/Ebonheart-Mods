package com.vies.viesmachines.common.entity.particles;

import com.vies.viesmachines.api.References;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityStaticCharge extends EntityThrowable {
	
	private int timeToLive;
	
    public EntityStaticCharge(World worldIn)
    {
        super(worldIn);
        
        this.timeToLive = 0;
        this.isImmuneToFire = true;
    }
    
    public EntityStaticCharge(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
        
        this.timeToLive = 0;
        this.isImmuneToFire = true;
    }
    
    public EntityStaticCharge(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
        
        this.timeToLive = 0;
        this.isImmuneToFire = true;
    }
    
    protected float getGravityVelocity()
    {
        return 0.0F;
    }
    
    protected float getVelocity()
    {
        return 0.1F;
    }
    
    @Override
    public void onUpdate()
    {
    	this.timeToLive++;
    	
    	if (this.timeToLive > References.random.nextInt(19 + 1) + 5)
    	{
    		this.setDead();
    	}
    	
    	if(this.isInWater()
		|| this.isInWeb
		|| this.isInLava())
		{
			this.onImpact(new RayTraceResult(this));
		}
    	
    	super.onUpdate();
    }
    
    @Override
	protected void onImpact(RayTraceResult result)
	{
    	if(result.entityHit != null) 
    	{
    		//Ignores collision with thrower and checks if there is a valid thrower
    		if(this.getThrower() != null && result.entityHit == this.getThrower())
    		{
     			return;
    		}
    		
    		this.setDead();
    	}
	}
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getBrightnessForRender()
    {
        return 15728880;
    }

    @Override
    public float getBrightness()
    {
        return 1.0F;
    }
}

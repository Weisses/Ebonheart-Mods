package com.viesis.viescraft.common.entity.airshipitems.v3;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.v3.EntityAirshipV3White;
import com.viesis.viescraft.common.entity.airshipitems.EntityItemAirshipCore;

public class EntityItemAirshipV3White extends EntityItemAirshipCore {
	
    public EntityItemAirshipV3White(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityItemAirshipV3White(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }
    
    public EntityItemAirshipV3White(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.worldObj.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	this.worldObj.spawnEntityInWorld(new EntityAirshipV3White(this.worldObj, this.posX, this.posY + 0.5F, this.posZ));
        	
            this.setDead();
        }
        else
    	{
    		for (int ii = 0; ii < 10; ++ii)
        	{
    			int d = random.nextInt(100) + 1;
				
    			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
    					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
    					this.posY + 0.5D,
    					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
    					0.0D, 0.0D, 0.0D, new int[0]);
            	
				if (d <= 2)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.0D, 0.0D, new int[0]);
				}
				if (d <= 15)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.25D, 0.0D, new int[0]);
				}
				if (d <= 25)
				{
					this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
						this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						this.posY + 0.5D,
						this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
						0.0D, 0.0D, 0.0D, new int[0]);
				}
			}
    	}
    }
}

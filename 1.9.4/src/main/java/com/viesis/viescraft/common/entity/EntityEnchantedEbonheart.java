package com.viesis.viescraft.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import com.viesis.viescraft.ViesCraft;

public class EntityEnchantedEbonheart extends EntityThrowable {
	
    public EntityEnchantedEbonheart(World worldIn)
    {
        super(worldIn);
    }

    public EntityEnchantedEbonheart(World worldIn, EntityLivingBase entity)
    {
        super(worldIn, entity);
    }

    public EntityEnchantedEbonheart(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    /**
     * Gets the amount of gravity to apply to the thrown entity with each tick.
     */
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

    /** 
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(RayTraceResult result)
    {
    	if (this.worldObj.isRemote)
    	{
    		for (int ii = 0; ii < 6; ++ii)
            {
    			//ViesCraft.proxy.generateEnchEbonParticles(this);
            }
    	}
        if (!this.worldObj.isRemote)
        {
        	this.worldObj.playEvent(2002, new BlockPos(this), 0);
            int i = 3 + this.worldObj.rand.nextInt(15) + this.worldObj.rand.nextInt(15);
            
            while (i > 0)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.worldObj.spawnEntityInWorld(new EntityXPOrb(this.worldObj, this.posX, this.posY, this.posZ, j));
                
                
                    
            }

            this.setDead();
        }
        
    }
    
}
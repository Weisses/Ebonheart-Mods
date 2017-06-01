package com.ebonheart.EbonArtsMod.common.entity;

import com.ebonheart.EbonArtsMod.EbonArtsMod;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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
    	if (this.world.isRemote)
    	{
    		for (int ii = 0; ii < 6; ++ii)
            {
            	EbonArtsMod.proxy.generateEnchEbonParticles(this);
            }
    	}
        if (!this.world.isRemote)
        {
        	this.world.playEvent(2002, new BlockPos(this), 0);
            int i = 3 + this.world.rand.nextInt(15) + this.world.rand.nextInt(15);
            
            while (i > 0)
            {
                int j = EntityXPOrb.getXPSplit(i);
                i -= j;
                this.world.spawnEntity(new EntityXPOrb(this.world, this.posX, this.posY, this.posZ, j));
                
                
                    
            }

            this.setDead();
        }
        
    }
    
}
package com.viesis.viescraft.testbed.common.entity;

import net.minecraft.entity.passive.IAnimals;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;


public class EntityAirshipBaseVC extends EntityFuelVC //implements IAnimals
{

	public EntityAirshipBaseVC(World worldIn) 
	{
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else
        {
            //this.inLove = 0;
            return super.attackEntityFrom(source, amount);
        }
    }
	
	/**
     * Returns the Y Offset of this entity.
     */
    public double getYOffset()
    {
        return 0.29D;
    }
    
    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 120;
    }
    
    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return false;
    }
	
}
	
	

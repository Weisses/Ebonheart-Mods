package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityVC extends Entity {
	
	public float momentum;
    public float outOfControlTicks;
    public float deltaRotation;
    public float alphaRotation;
    public int lerpSteps;
    public double boatPitch;
    public double lerpY;
    public double lerpZ;
    public double boatYaw;
    public double lerpXRot;
    public double waterLevel;
    public float boatGlide;
    public double lastYd;
    
    public boolean leftInputDown;
    public boolean rightInputDown;
    public boolean forwardInputDown;
    public boolean backInputDown;
    public boolean upInputDown;
    public boolean downInputDown;
    public boolean openInputDown;
    public boolean moduleInputDown;
	
    public Random random = new Random();
    
	public EntityVC(World worldIn) 
	{
		super(worldIn);
	}
	
	@Override
	protected void entityInit() 
	{
		
	}
	
	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) 
	{
		
	}
	
	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) 
	{
		
	}
	
    
    
    //==================================//
    //          Misc Attributes         //
	//==================================//
    
	/**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
	protected boolean canTriggerWalking()
    {
        return false;
    }
	
	/**
     * Returns a boundingBox used to collide the entity with other entities and blocks. This enables the entity to be
     * pushable on contact, like boats or minecarts.
     */
    @Nullable
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.getEntityBoundingBox();
    }
    
    /**
     * Returns the collision bounding box for this entity
     */
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return this.getEntityBoundingBox();
    }
    
    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return true;
    }
    
    /**
     * Returns the Y offset from the entity's position for any entity riding this one.
     */
    public double getMountedYOffset()
    {
        return -0.1D;
    }
    
    /**
     * Applies a velocity to the entities, to push them away from eachother.
     */
    public void applyEntityCollision(Entity entityIn)
    {
        if (entityIn instanceof EntityAirshipV1Core)
        {
            if (entityIn.getEntityBoundingBox().minY < this.getEntityBoundingBox().maxY)
            {
                super.applyEntityCollision(entityIn);
            }
        }
        else if (entityIn.getEntityBoundingBox().minY <= this.getEntityBoundingBox().minY)
        {
            super.applyEntityCollision(entityIn);
        }
    }
    
    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
    
    /**
     * Gets the horizontal facing direction of this Entity, adjusted to take specially-treated entity types into
     * account.
     */
    public EnumFacing getAdjustedHorizontalFacing()
    {
        return this.getHorizontalFacing().rotateY();
    }
    
    /**
     * How many passengers the entity can seat.
     */
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 2;
    }
    
    /**
     * Gets the driver.
     */
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    /**
     * Action when someone does the /kill command.
     */
    @Override
    public void onKillCommand()
    {
        
    }
    
	public void setDeadVC() 
	{
		
	}
}

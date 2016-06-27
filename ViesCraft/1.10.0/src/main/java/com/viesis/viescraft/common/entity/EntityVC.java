package com.viesis.viescraft.common.entity;

import java.util.List;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityVC extends Entity {
	
	/** How much of current speed to retain. Value zero to one. */
    public float momentum;
    public float outOfControlTicks;
    public float deltaRotation;
    public int lerpSteps;
    public double boatPitch;
    public double lerpY;
    public double lerpZ;
    public double boatYaw;
    public double lerpXRot;
    public boolean leftInputDown;
    public boolean rightInputDown;
    public boolean forwardInputDown;
    public boolean backInputDown;
    public boolean upInputDown;
    public boolean downInputDown;
    public double waterLevel;
    
    public float boatGlide;
    public EntityAirshipVC.Status status;
    public EntityAirshipVC.Status previousStatus;
    public double lastYd;
	
    public int fuelTime = 0;
    
    Random random = new Random();
    
    
	public EntityVC(World worldIn) {
		super(worldIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void entityInit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		
	}
	
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
        if (entityIn instanceof EntityAirshipVC)
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
    
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 2;
    }
    
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    
    
    
    
    
    
    public boolean interact(EntityPlayer entityplayer) 
    {

		if (this.isRidingOrBeingRiddenBy(entityplayer)) 
		{
			return true;
		}
		if (!worldObj.isRemote) 
		{
			ItemStack itemstack = entityplayer.inventory.getCurrentItem();
			if (itemstack != null && itemstack.getItem() == Items.BOW) 
			{
				return false;
			} 
			else 
			{
				entityplayer.startRiding(this);
			}
		}

		return true;

	}
    
    
    
    
    
    
    
    
    
    
    private int getFuelTime(ItemStack itemstack) {
		if (itemstack == null) {
			return 0;
		}
		Item i = itemstack.getItem();//.shiftedIndex;
		//if (i < 256 && Block.blocksList[i].blockMaterial == Material.wood) {
		//	return 300;
		//}
		//if (i == Item.stick.shiftedIndex) {
		//	return 100;
		//}
		if (i == Items.COAL) {
			return 1600;
		}
		if (i == Items.LAVA_BUCKET) {
			return 20000;
		}
		//if (i == Blocks.COAL_BLOCK) {
		//	return 100;
		//}
		if (i == Items.GUNPOWDER) {
			return 200;
		} else {
			return currentFuelTime; //ModLoader.addAllFuel(i,0);
		}
	}

	int currentFuelTime;

	public int getFuelScaled(int i) {
		return (fuelTime * i) / 600;
	}
    
    
    
    
    
    
    
    
    
    
    
}

package com.viesis.viescraft.common.entity.old;

import javax.annotation.Nullable;

import net.minecraft.entity.item.EntityMinecartFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.minecart.MinecartInteractEvent;

public class EntityAirshipFurnace extends EntityAirshipBase {
	
	private static final DataParameter<Boolean> POWERED = EntityDataManager.<Boolean>createKey(EntityMinecartFurnace.class, DataSerializers.BOOLEAN);
    private int fuel;
    
	public EntityAirshipFurnace(World worldIn) 
	{
		super(worldIn);
		// TODO Auto-generated constructor stub
	}
	
	public EntityAirshipFurnace(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
	
	protected void entityInit()
    {
        super.entityInit();
        this.dataManager.register(POWERED, Boolean.valueOf(false));
    }
	
	public void onUpdate()
    {
		
		
        super.onUpdate();

        if (this.fuel > 0)
        {
            --this.fuel;
        }

        if (this.fuel <= 0)
        {
            this.momentum = 0;
        }

        this.setMinecartPowered(this.fuel > 0);

        if (this.isMinecartPowered() && this.rand.nextInt(4) == 0)
        {
            this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY + 0.8D, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
        }
    }
	
	public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
    {
        //if (net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(new MinecartInteractEvent(this, player, stack, hand))) return true;

		if(player.isSneaking())
		{
			return true;
		}
		
        if (stack != null && stack.getItem() == Items.COAL && this.fuel + 3600 <= 32000)
        {
            if (!player.capabilities.isCreativeMode)
            {
                --stack.stackSize;
            }

            this.fuel += 3600;
        }

        //this.pushX = this.posX - player.posX;
        //this.pushZ = this.posZ - player.posZ;
        return true;
    }
	
	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        super.writeEntityToNBT(compound);
        
        compound.setShort("Fuel", (short)this.fuel);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        super.readEntityFromNBT(compound);
        
        this.fuel = compound.getShort("Fuel");
    }

    protected boolean isMinecartPowered()
    {
        return ((Boolean)this.dataManager.get(POWERED)).booleanValue();
    }

    protected void setMinecartPowered(boolean p_94107_1_)
    {
        this.dataManager.set(POWERED, Boolean.valueOf(p_94107_1_));
    }
	
	
	
	
	
	
	
}

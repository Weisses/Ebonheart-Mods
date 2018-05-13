package com.viesis.viescraft.common.entity.airships;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * Base Airship Logic mainly from Boats
 */
public class EntityBaseVC extends Entity {
	
	//General
    protected static final DataParameter<Integer> AIRSHIP_TIME_SINCE_HIT = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_FORWARD_DIRECTION = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Float>   AIRSHIP_DAMAGE_TAKEN = EntityDataManager.<Float>createKey(EntityAirshipBaseVC.class, DataSerializers.FLOAT);
    
    protected EntityAirshipBaseVC.Status status;
    protected EntityAirshipBaseVC.Status previousStatus;
    
    /** How much of current speed to retain. Value zero to one. */
    protected float momentum;
    protected float outOfControlTicks;
    protected float deltaRotation;
    protected double waterLevel;
    /**
     * How much the airship should glide given the slippery blocks it's currently gliding over.
     * Halved every tick.
     */
    private float boatGlide;
    protected double lastYd;
    
    private int lerpSteps;
    private double boatPitch;
    private double lerpY;
    private double lerpZ;
    private double boatYaw;
    private double lerpXRot;
    
    //Movement
    public boolean leftInputDown;
    public boolean rightInputDown;
    public boolean forwardInputDown;
    public boolean backInputDown;
    protected boolean upInputDown;
    protected boolean downInputDown;
    protected boolean openInputDown;
    protected boolean dropBombInputDown;
    
    protected float bombDropTimer;
    public boolean canDropBomb;
    
    public EntityBaseVC(World worldIn)
    {
        super(worldIn);

        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        
        this.setSize(0.9F, 0.4F);
    }
    
    public EntityBaseVC(World worldIn, double x, double y, double z, 
    		int coreTierIn, int frameTierIn, int engineTierIn, int balloonTierIn, 
    		int moduleSlot1In, 
    		int fuelIn, int fuelTotalIn, int redstoneIn, int redstoneTotalIn,
    		int bombType1, int bombType2, int bombType3,
    		
    		int coreModelVisualFrameIn, 
    		int coreModelVisualEngineIn, 
    		int coreModelVisualBalloonIn, 
    		
    		int frameSkinTextureIn, 
    		boolean frameSkinTransparentIn, 
    		boolean frameSkinColorIn, 
    		int frameSkinColorRedIn, int frameSkinColorGreenIn, int frameSkinColorBlueIn,
    		
    		int engineParticleVisualIn, 
    		int engineDisplayTypeVisualIn, 
    		int engineDisplayItemStackVisualIn, int engineDisplayItemStackMetaVisualIn,
    		int engineDisplayHeadVisualIn, 
    		int engineDisplaySupporterHeadVisualIn, 
    		int engineDisplayHolidayVisualIn, 
    		
    		int balloonPatternTextureIn, 
    		boolean balloonPatternTransparentIn, 
    		boolean balloonPatternColorIn, 
    		int balloonPatternColorRedIn, int balloonPatternColorGreenIn, int balloonPatternColorBlueIn, 
    		
    		boolean learnedModuleAltitudeIn, int selectedModuleAltitudeIn, 
    		boolean learnedModuleSpeedIn, int selectedModuleSpeedIn, 
    		boolean learnedModuleStorageIn, int selectedModuleStorageIn, 
    		boolean learnedModuleFuelIn, int selectedModuleFuelIn, 
    		boolean learnedModuleMusicIn, int selectedModuleMusicIn, 
    		boolean learnedModuleCruiseIn, int selectedModuleCruiseIn, 
    		boolean learnedModuleWaterIn, int selectedModuleWaterIn, 
    		boolean learnedModuleFuelInfiniteIn, int selectedModuleFuelInfiniteIn,
    		boolean learnedModuleBombIn, int selectedModuleBombIn,
    		
    		NBTTagCompound compoundIn, String customNameIn)
    {
        
    	this(worldIn);
        this.setPosition(x, y, z);
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
    
	@Override
	protected void entityInit() 
	{
		this.dataManager.register(AIRSHIP_TIME_SINCE_HIT, Integer.valueOf(0));
        this.dataManager.register(AIRSHIP_FORWARD_DIRECTION, Integer.valueOf(1));
        this.dataManager.register(AIRSHIP_DAMAGE_TAKEN, Float.valueOf(0.0F));
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
    // TODO   Airship Boat Logic        //
	//==================================//
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	this.previousStatus = this.status;
        this.status = this.getAirshipStatus();
        
        if (this.getTimeSinceHit() > 0)
        {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        
        if (this.getDamageTaken() > 0.0F)
        {
            this.setDamageTaken(this.getDamageTaken() - 1.0F);
        }
        
    }
	
    /**
     * Main entity item drop.
     */
    protected ItemStack getItemAirship()
    {
		return null;
    }
    
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    @Nullable
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.canBePushed() ? entityIn.getEntityBoundingBox() : null;
    }
    
    @Override
    @Nullable
    public AxisAlignedBB getCollisionBoundingBox()
    {
        return this.getEntityBoundingBox();
    }
    
    @Override
    public boolean canBePushed()
    {
        return false;
    }
    
    @Override
    public double getMountedYOffset()
    {
        return 0.15D;
    }
    
    
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	if(source.isProjectile())
    	{
    		return false;
    	}
    	if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (!this.world.isRemote && !this.isDead)
        {
        	if (source instanceof EntityDamageSourceIndirect && source.getTrueSource() != null && this.isPassenger(source.getTrueSource()))
            {
                return false;
            }
            else
            {
                this.setForwardDirection(-this.getForwardDirection());
                this.setTimeSinceHit(10);
                this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
                this.markVelocityChanged();
                //this.setBeenAttacked();
                boolean flag = source.getTrueSource() instanceof EntityPlayer && ((EntityPlayer)source.getTrueSource()).capabilities.isCreativeMode;
                
                if (flag || this.getDamageTaken() > 40.0F)
                {
                    if (!flag && this.world.getGameRules().getBoolean("doEntityDrops"))
                    {
                        this.entityDropItem(this.getItemAirship(), 0.0F);
                    }
                    this.setDeadVC();
                }
                return true;
            }
        }
        else
        {
            return true;
        }
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void performHurtAnimation()
    {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }
    
    @Override
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
        this.boatPitch = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.boatYaw = (double)yaw;
        this.lerpXRot = (double)pitch;
        this.lerpSteps = 10;
    }
    
    @Override
    public EnumFacing getAdjustedHorizontalFacing()
    {
        return this.getHorizontalFacing().rotateY();
    }
    
    /**
     * Update the boat's speed, based on momentum.
     */
    public void updateMotion()
    {
        
    }
    
    /**
     * Update the movement, based on client key inputs.
     */
    public void controlAirship()
    {
        
    }
    
    
    
    //==================================//
    // TODO       Core Logic            //
	//==================================//
	
    /**
     * Downward empty movement.
     */
    protected void tickLerp()
    {
        if (this.lerpSteps > 0 && !this.canPassengerSteer())
        {
            double d0 = this.posX + (this.boatPitch - this.posX) / (double)this.lerpSteps;
            double d1 = this.posY + (this.lerpY - this.posY) / (double)this.lerpSteps;
            double d2 = this.posZ + (this.lerpZ - this.posZ) / (double)this.lerpSteps;
            double d3 = MathHelper.wrapDegrees(this.boatYaw - (double)this.rotationYaw);
            this.rotationYaw = (float)((double)this.rotationYaw + d3 / (double)this.lerpSteps);
            this.rotationPitch = (float)((double)this.rotationPitch + (this.lerpXRot - (double)this.rotationPitch) / (double)this.lerpSteps);
            --this.lerpSteps;
            this.setPosition(d0, d1, d2);
            this.setRotation(this.rotationYaw, this.rotationPitch);
        }
    }
    
    /**
     * Determines whether the boat is in water, gliding on land, or in air
     */
    protected EntityAirshipBaseVC.Status getAirshipStatus()
    {
        EntityAirshipBaseVC.Status NEWEntityBaseVC$status = this.getUnderwaterStatus();
        
        if (NEWEntityBaseVC$status != null)
        {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return NEWEntityBaseVC$status;
        }
        else if (this.checkInWater())
        {
            return EntityAirshipBaseVC.Status.IN_WATER;
        }
        else
        {
            float f = this.getBoatGlide();
            
            if (f > 0.0F)
            {
                this.boatGlide = f;
                return EntityAirshipBaseVC.Status.ON_LAND;
            }
            else
            {
                return EntityAirshipBaseVC.Status.IN_AIR;
            }
        }
    }
    
    public float getWaterLevelAbove()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(axisalignedbb.maxY - this.lastYd);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();
        
        try
        {
            label78:

            for (int k1 = k; k1 < l; ++k1)
            {
                float f = 0.0F;
                int l1 = i;

                while (true)
                {
                    if (l1 >= j)
                    {
                        if (f < 1.0F)
                        {
                            float f2 = (float)blockpos$pooledmutableblockpos.getY() + f;
                            return f2;
                        }

                        break;
                    }

                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(l1, k1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            f = Math.max(f, getBlockLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos));
                        }

                        if (f >= 1.0F)
                        {
                            continue label78;
                        }
                    }

                    ++l1;
                }
            }

            float f1 = (float)(l + 1);
            return f1;
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }
    }
    
    public static float getBlockLiquidHeight(IBlockState p_184456_0_, IBlockAccess p_184456_1_, BlockPos p_184456_2_)
    {
        int i = ((Integer)p_184456_0_.getValue(BlockLiquid.LEVEL)).intValue();
        return (i & 7) == 0 && p_184456_1_.getBlockState(p_184456_2_.up()).getMaterial() == Material.WATER ? 1.0F : 1.0F - BlockLiquid.getLiquidHeightPercent(i);
    }
    
    /**
     * Decides how much the boat should be gliding on the land (based on any slippery blocks)
     */
    public float getBoatGlide()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        AxisAlignedBB axisalignedbb1 = new AxisAlignedBB(axisalignedbb.minX, axisalignedbb.minY - 0.001D, axisalignedbb.minZ, axisalignedbb.maxX, axisalignedbb.minY, axisalignedbb.maxZ);
        int i = MathHelper.floor(axisalignedbb1.minX) - 1;
        int j = MathHelper.ceil(axisalignedbb1.maxX) + 1;
        int k = MathHelper.floor(axisalignedbb1.minY) - 1;
        int l = MathHelper.ceil(axisalignedbb1.maxY) + 1;
        int i1 = MathHelper.floor(axisalignedbb1.minZ) - 1;
        int j1 = MathHelper.ceil(axisalignedbb1.maxZ) + 1;
        List<AxisAlignedBB> list = Lists.<AxisAlignedBB>newArrayList();
        float f = 0.0F;
        int k1 = 0;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int l1 = i; l1 < j; ++l1)
            {
                for (int i2 = i1; i2 < j1; ++i2)
                {
                    int j2 = (l1 != i && l1 != j - 1 ? 0 : 1) + (i2 != i1 && i2 != j1 - 1 ? 0 : 1);

                    if (j2 != 2)
                    {
                        for (int k2 = k; k2 < l; ++k2)
                        {
                            if (j2 <= 0 || k2 != k && k2 != l - 1)
                            {
                                blockpos$pooledmutableblockpos.setPos(l1, k2, i2);
                                IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);
                                iblockstate.addCollisionBoxToList(this.world, blockpos$pooledmutableblockpos, axisalignedbb1, list, this, false);

                                if (!list.isEmpty())
                                {
                                    f += iblockstate.getBlock().slipperiness;
                                    ++k1;
                                }

                                list.clear();
                            }
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return f / (float)k1;
    }
    
    private boolean checkInWater()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.minY);
        int l = MathHelper.ceil(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        this.waterLevel = Double.MIN_VALUE;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            float f = getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos);
                            this.waterLevel = Math.max((double)f, this.waterLevel);
                            flag |= axisalignedbb.minY < (double)f;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag;
    }
    
    public static float getLiquidHeight(IBlockState p_184452_0_, IBlockAccess p_184452_1_, BlockPos p_184452_2_)
    {
        return (float)p_184452_2_.getY() + getBlockLiquidHeight(p_184452_0_, p_184452_1_, p_184452_2_);
    }
    
    /**
     * Decides whether the boat is currently underwater.
     */
    @Nullable
    private EntityAirshipBaseVC.Status getUnderwaterStatus()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        double d0 = axisalignedbb.maxY + 0.001D;
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(d0);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag = false;
        BlockPos.PooledMutableBlockPos blockpos$pooledmutableblockpos = BlockPos.PooledMutableBlockPos.retain();

        try
        {
            for (int k1 = i; k1 < j; ++k1)
            {
                for (int l1 = k; l1 < l; ++l1)
                {
                    for (int i2 = i1; i2 < j1; ++i2)
                    {
                        blockpos$pooledmutableblockpos.setPos(k1, l1, i2);
                        IBlockState iblockstate = this.world.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                                EntityAirshipBaseVC.Status EntityAirshipBaseVC$status = EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER;
                                return EntityAirshipBaseVC$status;
                            }

                            flag = true;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag ? EntityAirshipBaseVC.Status.UNDER_WATER : null;
    }
    
    @Override
    public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
            float f = 0.0F;
            float f1 = (float)((this.isDead ? 0.009999999776482582D : this.getMountedYOffset()) + passenger.getYOffset());
            
            if (this.getPassengers().size() > 1)
            {
                int i = this.getPassengers().indexOf(passenger);
                
                if (i == 0)
                {
                    f = 0.2F;
                }
                else
                {
                    f = -0.6F;
                }
                
                if (passenger instanceof EntityAnimal)
                {
                    f = (float)((double)f + 0.2D);
                }
            }
            
            Vec3d vec3d = (new Vec3d((double)f, 0.0D, 0.0D)).rotateYaw(-this.rotationYaw * 0.017453292F - ((float)Math.PI / 2F));
            passenger.setPosition(this.posX + vec3d.x, this.posY + (double)f1, this.posZ + vec3d.z);
            passenger.rotationYaw += this.deltaRotation;
            passenger.setRotationYawHead(passenger.getRotationYawHead() + this.deltaRotation);
            this.applyYawToEntity(passenger);
            
            if (passenger instanceof EntityAnimal && this.getPassengers().size() > 1)
            {
                int j = passenger.getEntityId() % 2 == 0 ? 90 : 270;
                passenger.setRenderYawOffset(((EntityAnimal)passenger).renderYawOffset + (float)j);
                passenger.setRotationYawHead(passenger.getRotationYawHead() + (float)j);
            }
        }
    }
    
    /**
     * Applies this boat's yaw to the given entity. Used to update the orientation of its passenger.
     */
    protected void applyYawToEntity(Entity entityToUpdate)
    {
        entityToUpdate.setRenderYawOffset(this.rotationYaw);
        float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
        float f1 = MathHelper.clamp(f, -105.0F, 105.0F);
        entityToUpdate.prevRotationYaw += f1 - f;
        entityToUpdate.rotationYaw += f1 - f;
        entityToUpdate.setRotationYawHead(entityToUpdate.rotationYaw);
    }
    
    @SideOnly(Side.CLIENT)
    @Override
    public void applyOrientationToEntity(Entity entityToUpdate)
    {
        this.applyYawToEntity(entityToUpdate);
    }
    
    /**
     * The initial interaction when Airship is right-clicked.
     */
    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand stack)
    {
    	if(this.world.isRemote)
    	{
    		Keybinds.vcInventory.unPressAllKeys();
    	}
    	
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!this.world.isRemote && this.outOfControlTicks < 60.0F)
            {
                player.startRiding(this);
            }
            
            return true;
        }
    }
    
    /**
     * What happens when the Airship is in the air.
     */
    @Override
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        
    }
    
    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 2;
    }
    
    @Override
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    public static enum Status
    {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR;
    }

    
    
    //==================================//
    // TODO   Setters / Getters         //
	//==================================//
    
    /**
     * Sets the damage taken from the last hit.
     */
    public void setDamageTaken(float damageTaken)
    {
        this.dataManager.set(AIRSHIP_DAMAGE_TAKEN, Float.valueOf(damageTaken));
    }
    /**
     * Gets the damage taken from the last hit.
     */
    public float getDamageTaken()
    {
        return ((Float)this.dataManager.get(AIRSHIP_DAMAGE_TAKEN)).floatValue();
    }
    
    /**
     * Sets the time to count down from since the last time entity was hit.
     */
    public void setTimeSinceHit(int timeSinceHit)
    {
        this.dataManager.set(AIRSHIP_TIME_SINCE_HIT, Integer.valueOf(timeSinceHit));
    }
    /**
     * Gets the time since the last hit.
     */
    public int getTimeSinceHit()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TIME_SINCE_HIT)).intValue();
    }
    
    /**
     * Sets the forward direction of the entity.
     */
    public void setForwardDirection(int forwardDirection)
    {
        this.dataManager.set(AIRSHIP_FORWARD_DIRECTION, Integer.valueOf(forwardDirection));
    }
    /**
     * Gets the forward direction of the entity.
     */
    public int getForwardDirection()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_FORWARD_DIRECTION)).intValue();
    }
    
    
    
	//==================================//
    // TODO     Input Updates           //
	//==================================//
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, Boats, and Airships are generally "steered" by the controlling passenger.
     */
    @SideOnly(Side.CLIENT)
    public void updateInputs()
    {
    	this.leftInputDown = Keybinds.vcLeft.isKeyDown();
        this.rightInputDown = Keybinds.vcRight.isKeyDown();
        this.forwardInputDown = Keybinds.vcForward.isKeyDown();
        this.backInputDown = Keybinds.vcBack.isKeyDown();
        this.upInputDown = Keybinds.vcUp.isKeyDown();
        this.downInputDown = Keybinds.vcDown.isKeyDown();
        this.openInputDown = Keybinds.vcInventory.isPressed();
        this.dropBombInputDown = Keybinds.vcDropBomb.isPressed();
    }
    
    
    
	//==================================//
    // TODO      Airship Logic          //
	//==================================//
    
    /**
     * What happens when the airship is dead.
     */
	public void setDeadVC() 
	{
		
	}
	
}

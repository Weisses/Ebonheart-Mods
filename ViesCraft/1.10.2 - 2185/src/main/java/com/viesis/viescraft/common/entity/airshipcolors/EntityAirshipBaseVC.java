package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
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

public class EntityAirshipBaseVC extends Entity {
	
	public int metaFrame;
	public int metaBalloon;
	
	public int metaColorRed;
	public int metaColorGreen;
	public int metaColorBlue;
	
    public static final DataParameter<Integer> TIME_SINCE_HIT_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> FORWARD_DIRECTION_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Float> DAMAGE_TAKEN_VC = EntityDataManager.<Float>createKey(EntityAirshipBaseVC.class, DataSerializers.FLOAT);
    protected static final DataParameter<Integer> AIRSHIP_TYPE_FRAME_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_TYPE_BALLOON_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_RED_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_GREEN_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_BLUE_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    /** How much of current speed to retain. Value zero to one. */
    protected float momentum;
    protected float outOfControlTicks;
    protected float deltaRotation;
    private int lerpSteps;
    private double boatPitch;
    private double lerpY;
    private double lerpZ;
    private double boatYaw;
    private double lerpXRot;
    
    public boolean leftInputDown;
    public boolean rightInputDown;
    public boolean forwardInputDown;
    public boolean backInputDown;
    protected boolean upInputDown;
    protected boolean downInputDown;
    protected boolean openInputDown;
    
    protected double waterLevel;
    
    /**
     * How much the boat should glide given the slippery blocks it's currently gliding over.
     * Halved every tick.
     */
    private float boatGlide;
    protected EntityAirshipBaseVC.Status status;
    protected EntityAirshipBaseVC.Status previousStatus;
    protected double lastYd;
    
    public float AirshipSpeedTurn;
    public float AirshipSpeedForward;
    public float AirshipSpeedUp;
    public float AirshipSpeedDown;
	
    public EntityAirshipBaseVC(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        
        this.setSize(1.0F, 0.5F);
    }
    
    public EntityAirshipBaseVC(World worldIn, double x, double y, double z, int frameIn, int balloonIn, int colorRedIn, int colorGreenIn, int colorBlueIn)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        
        this.metaFrame = frameIn;
        this.metaBalloon = balloonIn;
        this.metaColorRed = colorRedIn;
        this.metaColorGreen = colorGreenIn;
        this.metaColorBlue = colorBlueIn;
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
    
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    public void entityInit()
    {
        this.dataManager.register(TIME_SINCE_HIT_VC, Integer.valueOf(0));
        this.dataManager.register(FORWARD_DIRECTION_VC, Integer.valueOf(1));
        this.dataManager.register(DAMAGE_TAKEN_VC, Float.valueOf(0.0F));
        this.dataManager.register(AIRSHIP_TYPE_FRAME_VC, Integer.valueOf(this.metaFrame));
        this.dataManager.register(AIRSHIP_TYPE_BALLOON_VC, Integer.valueOf(this.metaBalloon));
        this.dataManager.register(BALLOON_COLOR_RED_VC, Integer.valueOf(this.metaColorRed));
        this.dataManager.register(BALLOON_COLOR_GREEN_VC, Integer.valueOf(this.metaColorGreen));
        this.dataManager.register(BALLOON_COLOR_BLUE_VC, Integer.valueOf(this.metaColorBlue));
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
        return true;
    }
    
    @Override
    public double getMountedYOffset()
    {
        return 0.15D;
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (!this.worldObj.isRemote && !this.isDead)
        {
            if (source instanceof EntityDamageSourceIndirect && source.getEntity() != null && this.isPassenger(source.getEntity()))
            {
                return false;
            }
            else
            {
                this.setForwardDirection(-this.getForwardDirection());
                this.setTimeSinceHit(10);
                this.setDamageTaken(this.getDamageTaken() + amount * 10.0F);
                this.setBeenAttacked();
                boolean flag = source.getEntity() instanceof EntityPlayer && ((EntityPlayer)source.getEntity()).capabilities.isCreativeMode;
                
                if (flag || this.getDamageTaken() > 40.0F)
                {
                    if (!flag && this.worldObj.getGameRules().getBoolean("doEntityDrops"))
                    {
                        this.entityDropItem(this.getItemBoat(), 0.0F);
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
    
    @Override
    public void applyEntityCollision(Entity entityIn)
    {
        if (entityIn instanceof EntityAirshipBaseVC)
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
     * Main entity item drop.
     */
    protected ItemStack getItemBoat()
    {
		return null;
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
    
    @Override
    public void onUpdate()
    {
    	
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
        int i = MathHelper.floor_double(axisalignedbb.minX);
        int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
        int k = MathHelper.floor_double(axisalignedbb.maxY);
        int l = MathHelper.ceiling_double_int(axisalignedbb.maxY - this.lastYd);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
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
                        IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            f = Math.max(f, getBlockLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos));
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
        int i = MathHelper.floor_double(axisalignedbb1.minX) - 1;
        int j = MathHelper.ceiling_double_int(axisalignedbb1.maxX) + 1;
        int k = MathHelper.floor_double(axisalignedbb1.minY) - 1;
        int l = MathHelper.ceiling_double_int(axisalignedbb1.maxY) + 1;
        int i1 = MathHelper.floor_double(axisalignedbb1.minZ) - 1;
        int j1 = MathHelper.ceiling_double_int(axisalignedbb1.maxZ) + 1;
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
                                IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);
                                iblockstate.addCollisionBoxToList(this.worldObj, blockpos$pooledmutableblockpos, axisalignedbb1, list, this);

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
        int i = MathHelper.floor_double(axisalignedbb.minX);
        int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
        int k = MathHelper.floor_double(axisalignedbb.minY);
        int l = MathHelper.ceiling_double_int(axisalignedbb.minY + 0.001D);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
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
                        IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER)
                        {
                            float f = getLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos);
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
        int i = MathHelper.floor_double(axisalignedbb.minX);
        int j = MathHelper.ceiling_double_int(axisalignedbb.maxX);
        int k = MathHelper.floor_double(axisalignedbb.maxY);
        int l = MathHelper.ceiling_double_int(d0);
        int i1 = MathHelper.floor_double(axisalignedbb.minZ);
        int j1 = MathHelper.ceiling_double_int(axisalignedbb.maxZ);
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
                        IBlockState iblockstate = this.worldObj.getBlockState(blockpos$pooledmutableblockpos);

                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)getLiquidHeight(iblockstate, this.worldObj, blockpos$pooledmutableblockpos))
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
            passenger.setPosition(this.posX + vec3d.xCoord, this.posY + (double)f1, this.posZ + vec3d.zCoord);
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
        float f1 = MathHelper.clamp_float(f, -105.0F, 105.0F);
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
    
    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        
    }
    
    @Override
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        
    }
    
    /**
     * The initial interaction when Airship is right-clicked.
     */
    @Override
    public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
    {
        if (player.isSneaking())
        {
            return false;
        }
        else
        {
            if (!this.worldObj.isRemote && this.outOfControlTicks < 60.0F)
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
    
    /**
     * Sets the damage taken from the last hit.
     */
    public void setDamageTaken(float damageTaken)
    {
        this.dataManager.set(DAMAGE_TAKEN_VC, Float.valueOf(damageTaken));
    }
    
    /**
     * Gets the damage taken from the last hit.
     */
    public float getDamageTaken()
    {
        return ((Float)this.dataManager.get(DAMAGE_TAKEN_VC)).floatValue();
    }
    
    /**
     * Sets the time to count down from since the last time entity was hit.
     */
    public void setTimeSinceHit(int timeSinceHit)
    {
        this.dataManager.set(TIME_SINCE_HIT_VC, Integer.valueOf(timeSinceHit));
    }
    
    /**
     * Gets the time since the last hit.
     */
    public int getTimeSinceHit()
    {
        return ((Integer)this.dataManager.get(TIME_SINCE_HIT_VC)).intValue();
    }
    
    /**
     * Sets the forward direction of the entity.
     */
    public void setForwardDirection(int forwardDirection)
    {
        this.dataManager.set(FORWARD_DIRECTION_VC, Integer.valueOf(forwardDirection));
    }
    
    /**
     * Gets the forward direction of the entity.
     */
    public int getForwardDirection()
    {
        return ((Integer)this.dataManager.get(FORWARD_DIRECTION_VC)).intValue();
    }

    /**
     * Sets the Frame.
     */
    public void setAirshipMetaFrame(int airshipMeta)
    {
        this.dataManager.set(AIRSHIP_TYPE_FRAME_VC, Integer.valueOf(airshipMeta));
    }
	
    /**
     * Gets the Frame.
     */
    public int getAirshipMetaFrame()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TYPE_FRAME_VC)).intValue();
    }
    
    /**
     * Sets the Balloon pattern.
     */
    public void setAirshipMetaBalloon(int airshipMeta)
    {
        this.dataManager.set(AIRSHIP_TYPE_BALLOON_VC, Integer.valueOf(airshipMeta));
    }
	
    /**
     * Gets the Balloon pattern.
     */
    public int getAirshipMetaBalloon()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TYPE_BALLOON_VC)).intValue();
    }
    
    /**
     * Sets the Color Red.
     */
    public void setAirshipMetaColorRed(int airshipMeta)
    {
        this.dataManager.set(BALLOON_COLOR_RED_VC, Integer.valueOf(airshipMeta));
    }
	
    /**
     * Gets the Color Red.
     */
    public int getAirshipMetaColorRed()
    {
        return ((Integer)this.dataManager.get(BALLOON_COLOR_RED_VC)).intValue();
    }
    
    /**
     * Sets the Color Green.
     */
    public void setAirshipMetaColorGreen(int airshipMeta)
    {
        this.dataManager.set(BALLOON_COLOR_GREEN_VC, Integer.valueOf(airshipMeta));
    }
	
    /**
     * Gets the Color Green.
     */
    public int getAirshipMetaColorGreen()
    {
        return ((Integer)this.dataManager.get(BALLOON_COLOR_GREEN_VC)).intValue();
    }
    
    /**
     * Sets the Color Blue.
     */
    public void setAirshipMetaColorBlue(int airshipMeta)
    {
        this.dataManager.set(BALLOON_COLOR_BLUE_VC, Integer.valueOf(airshipMeta));
    }
	
    /**
     * Gets the Color Blue.
     */
    public int getAirshipMetaColorBlue()
    {
        return ((Integer)this.dataManager.get(BALLOON_COLOR_BLUE_VC)).intValue();
    }
    
    /**
     * Gets the airship type.
     */
    public void updateAirshipMeta()
    {
        if (this.worldObj.isRemote)
        {
        	this.metaFrame = this.getAirshipMetaFrame();
        	this.metaBalloon = this.getAirshipMetaBalloon();
        	this.metaColorRed = this.getAirshipMetaColorRed();
        	this.metaColorGreen = this.getAirshipMetaColorGreen();
        	this.metaColorBlue = this.getAirshipMetaColorBlue();
        }
    	
        if(!this.worldObj.isRemote)
		{
        	this.setAirshipMetaFrame(this.metaFrame);
        	this.setAirshipMetaBalloon(this.metaBalloon);
        	this.setAirshipMetaColorRed(this.metaColorRed);
        	this.setAirshipMetaColorGreen(this.metaColorGreen);
        	this.setAirshipMetaColorBlue(this.metaColorBlue);
		}
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
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
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
    }
    
    /**
     * What happens when the airship is dead.
     */
	public void setDeadVC() 
	{
		
	}
    
	/**
     * Airship water interaction.
     */
	protected void waterDamage()
	{
		//Sets explosion ticks to 0 if not in water, else increase the tick count
		if (this.status != EntityAirshipBaseVC.Status.UNDER_WATER 
		 && this.status != EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER)
        {
            this.outOfControlTicks = 0.0F;
        }
        else
        {
        	if(this.worldObj.isRemote)
        	{
        		InitParticlesVCRender.generateExplosions(this);
        	}
            ++this.outOfControlTicks;
        }
		
		//Removes passenger if they do not get out of water in time to explode the airship.
        if (!this.worldObj.isRemote && this.outOfControlTicks >= 60.0F)
        {
            this.removePassengers();
        }
	}
	
	/**
     * Airship water interaction.
     */
	protected void waterPartsDrop()
	{
		if (!this.worldObj.isRemote)
    	{
    		this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
    		
    		int drop1 = Reference.random.nextInt(100) + 1;
    		int drop2 = Reference.random.nextInt(100) + 1;
    		int drop3 = Reference.random.nextInt(100) + 1;
    		int drop4 = Reference.random.nextInt(100) + 1;
    		
    	    if (drop1 < 75)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.airship_balloon, 1, 0.0F);
        	}
    	    
    	    if (drop2 < 55)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
    	    	
    	    	if (drop3 < 35)
            	{
        	    	this.dropItemWithOffset(InitItemsVC.airship_engine, 1, 0.0F);
            	}
        	}
    	    
    	    if (drop4 < 15)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.airship_ignition, 1, 0.0F);
        	}
    	    
    	    this.dropInvDead();
        	this.setDead();
    	}
	}
	
	/**
     * Drops all inventory contents.
     */
    protected void dropInvDead()
    {
    	
    }
	
	/**
	 * Frame enum - Represents various frame types.
	 */
    public static enum Frame
    {
        WOOD0(0, "Oak"),
    	IRON(1, "Iron"),
        REDSTONE(2, "Redstone"),
        GOLD(3, "Gold"),
        LAPISLAZULI(4, "Lapis Lazuli"),
        OBSIDIAN(5, "Obsidian"),
        DIAMOND(6, "Diamond"),
        EMERALD(7, "Emerald"),
        NETHERBRICK(8, "Nether Brick"),
        PURPUR(9, "Purpur"),
        ICE(10, "Ice"),
    	SANDSTONE(11, "Sandstone");
    	//BRICK(12, "Brick")
        //GLOWSTONE(13, "Glowstone")
        //QUARTZ(14, "Quartz")
    	//PRISMARINE(15, "Prismarine")
    	//SOULSAND(16, "SoulSand")
    	//GHOST(17, "Ghost")  // This is a special one that uses nether stars.
    	
        private final String name;
        private final int metadata;
        
        private Frame(int metadataIn, String nameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntityAirshipBaseVC.Frame byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipBaseVC.Frame getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    /**
	 * Balloon enum - Represents various balloon types.
	 */
    public static enum Balloon
    {
        PLAIN(0, "Plain"),
        CHECKER(1, "Checker"),
        CHECKERCOLORIZED(2, "Colorized Checker"),
        POLKADOT(3, "Polka Dot"),
        POLKADOTCOLORIZED(4, "Colorized Polka Dot"),
        ZIGZAG(5, "Zigzag"),
    	ZIGZAGCOLORIZED(6, "Colorized Zigzag");
    	
        private final String name;
        private final int metadata;
        
        private Balloon(int metadataIn, String nameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntityAirshipBaseVC.Balloon byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipBaseVC.Balloon getTypeFromString(String nameIn)
        {
            for (int i = 0; i < values().length; ++i)
            {
                if (values()[i].getName().equals(nameIn))
                {
                    return values()[i];
                }
            }
            
            return values()[0];
        }
    }
    
    
    
	//==================================//
  	// TODO     Sound Events            //
  	//==================================//
    
    /**
     * Sounds! - Unused ATM.
     */
    //public SoundCategory getSoundCategory()
    //{
    //    return SoundCategory.HOSTILE;
    //}
	
    //protected SoundEvent getAmbientSound()
    //{
    //    return SoundEvents.ENTITY_ENDERDRAGON_AMBIENT;
    //}
	
    //protected SoundEvent getHurtSound()
    //{
    //    return SoundEvents.ENTITY_ENDERDRAGON_HURT;
    //}
	
    /**
     * Returns the volume for the sounds this mob makes.
     */
    //protected float getSoundVolume()
    //{
    //    return 5.0F;
    //}
	
}

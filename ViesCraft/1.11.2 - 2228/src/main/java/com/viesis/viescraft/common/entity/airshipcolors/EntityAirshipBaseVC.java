package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.MovingSoundVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipBaseVC extends Entity {
	
	/** Fuel */
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	public int itemFuelStackSize;
	public int itemFuelStack;
	public int airshipFuelTick;
	
    /** My capabilities inventory */
    public ItemStackHandler inventory;
    protected int size = 20;
    
	public int metaFrameCore;
	public int metaBalloon;
	
	public int metaFrameVisual;
	public boolean frameVisualActive;
	
	public int metaColorRed;
	public int metaColorGreen;
	public int metaColorBlue;
	
    public static final DataParameter<Integer> TIME_SINCE_HIT_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> FORWARD_DIRECTION_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Float> DAMAGE_TAKEN_VC = EntityDataManager.<Float>createKey(EntityAirshipBaseVC.class, DataSerializers.FLOAT);

    protected static final DataParameter<Integer> AIRSHIP_VISUAL_FRAME_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> AIRSHIP_VISUAL_FRAME_ACTIVE_VC = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    
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
     * How much the airship should glide given the slippery blocks it's currently gliding over.
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
        
        this.setSize(0.9F, 0.3F);
    }
    
    public EntityAirshipBaseVC(World worldIn, double x, double y, double z, int frameIn, int balloonIn, int colorRedIn, int colorGreenIn, int colorBlueIn, int frameVisualIn, boolean frameVisualActive)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        
        this.metaFrameVisual = frameVisualIn;
        this.frameVisualActive = frameVisualActive;
        
        this.metaFrameCore = frameIn;
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
        
        this.dataManager.register(AIRSHIP_VISUAL_FRAME_VC, Integer.valueOf(this.metaFrameVisual));
        this.dataManager.register(AIRSHIP_VISUAL_FRAME_ACTIVE_VC, Boolean.valueOf(this.frameVisualActive));
        
        this.dataManager.register(AIRSHIP_TYPE_FRAME_VC, Integer.valueOf(this.metaFrameCore));
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
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (!this.world.isRemote && !this.isDead)
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
                    if (!flag && this.world.getGameRules().getBoolean("doEntityDrops"))
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
                            f = Math.max(f, BlockLiquid.getBlockLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos));
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
                            float f = BlockLiquid.getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos);
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

                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)BlockLiquid.getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
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
    public boolean processInitialInteract(EntityPlayer player, EnumHand stack)
    {
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
        if (this.world.isRemote)
        {
        	this.metaFrameCore = this.getAirshipMetaFrame();
        	this.metaBalloon = this.getAirshipMetaBalloon();
        	this.metaColorRed = this.getAirshipMetaColorRed();
        	this.metaColorGreen = this.getAirshipMetaColorGreen();
        	this.metaColorBlue = this.getAirshipMetaColorBlue();
        }
    	
        if(!this.world.isRemote)
		{
        	this.setAirshipMetaFrame(this.metaFrameCore);
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
        	if(this.world.isRemote)
        	{
        		InitParticlesVCRender.generateExplosions(this);
        	}
            ++this.outOfControlTicks;
        }
		
		//Removes passenger if they do not get out of water in time to explode the airship.
        if (!this.world.isRemote && this.outOfControlTicks >= 60.0F)
        {
            this.removePassengers();
        }
	}
	
	/**
     * Airship water interaction.
     */
	protected void waterPartsDrop()
	{
		if (!this.world.isRemote)
    	{
    		this.world.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
    		
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
     * Height Restrictions.
     */
    protected boolean airshipHeightLimit()
    {
    	Boolean maxHeightReached;
    	
    	int airshipHeight = this.getPosition().getY();
    	if(airshipHeight > FrameCore.byId(this.metaFrameCore).getElevation())
    	{
    		maxHeightReached = true;
    	}
    	else
    	{
    		maxHeightReached = false;
    	}
		
		return maxHeightReached;
    }
    
    /**
     * Calculates the number of ticks an airship needs.
     */
    protected int getAirshipFuelTick()
    {
    	this.airshipFuelTick = 10;
    	
    	if(this.getModuleMinorEfficiency())
    	{
    		this.airshipFuelTick = 8;
    	}
    	if(this.getModuleMajorEfficiency())
    	{
    		this.airshipFuelTick = 5;
    	}
    	if(this.getModuleSpeedMajor()
    	|| this.getModuleInventoryLarge())
    	{
    		this.airshipFuelTick = 20;
    	}
    	
    	return airshipFuelTick;
    }
	
    
    
    /**
	 * Core Frame enum - Represents various frame types.
	 */
    public static enum FrameCore
    {
    	//STRING(meta, name, speed, altitude)
    	//Common - 8 items
        WOOD0(0, "Oak", 0F, 75),
        WOOD1(1, "Spruce", 0F, 75),
        WOOD2(2, "Birch", 0F, 75),
        WOOD3(3, "Jungle", 0F, 75),
        WOOD4(4, "Acacia", 0F, 75),
        WOOD5(5, "Dark Oak", 0F, 75),
        SANDSTONE(6, "Sandstone", 0.001F, 80),
        BRICK(7, "Brick", 0.002F, 90),
        
        //Uncommon - 7 items
        BONE(8, "Bone", 0.003F, 100),
    	IRON(9, "Iron", 0.004F, 110),
        REDSTONE(10, "Redstone", 0.005F, 120),
        GOLD(11, "Gold", 0.006F, 130),
        LAPISLAZULI(12, "Lapis Lazuli", 0.007F, 140),
        SLIME(13, "Slime", 0.008F, 150),
        MYCELIUM(14, "Mycelium", 0.009F, 160),
        
        //Rare - 6 items
        NETHERBRICK(15, "Nether Brick", 0.010F, 170),
        SOULSAND(16, "Soul Sand", 0.011F, 180),
        QUARTZ(17, "Quartz", 0.012F, 190),
        ICE(18, "Ice", 0.013F, 200),
        GLOWSTONE(19, "Glowstone", 0.014F, 210),
        OBSIDIAN(20, "Obsidian", 0.015F, 220),
        
        //Epic - 5 items + 1 admin-only item
        DIAMOND(21, "Diamond", 0.016F, 230),
        EMERALD(22, "Emerald", 0.017F, 240),
        PRISMARINE(23, "Prismarine", 0.018F, 250),
    	PURPUR(24, "Purpur", 0.019F, 260),
    	NETHERSTAR(25, "Nether Star", 0.020F, 500),
    	MYTHIC(26, "Mythic", 0.025F, 500);  // This is a special admin only Airship.
    	
        private final String name;
        private final int metadata;
        private final float speed;
        private final int elevation;
        
        private FrameCore(int metadataIn, String nameIn, float speedModifier, int maxElevation)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.speed = speedModifier;
            this.elevation = maxElevation;
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
        
        public float getSpeed()
        {
            return this.speed;
        }
        
        public float getElevation()
        {
            return this.elevation;
        }
        
        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntityAirshipBaseVC.FrameCore byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipBaseVC.FrameCore getTypeFromString(String nameIn)
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
    	ZIGZAGCOLORIZED(6, "Colorized Zigzag")//,
        //WAVEHORIZONTAL(7, "Horizontal Wave"),
        //WAVEHORIZONTALCOLORIZED(8, "Colorized Horizontal Wave"),
        //WAVEVERTICAL(9, "Vertical Wave"),
        //WAVEVERTICALCOLORIZED(10, "Colorized Vertical Wave")
    	//BASKETWEAVE(7, "Basketweave")
    	//BASKETWEAVECOLORIZED(7, "Colorized Basketweave")
    	;
    	
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
    
    /**
	 * Module enum - Represents various Module types.
	 */
    public static enum Module
    {
        CHIP(0, "Chip"),
        MINORSPEED(1, "Minor Speed"),
        MAJORSPEED(2, "Major Speed"),
        SMALLINVENTORY(3, "Small Inventory"),
        LARGEINVENTORY(4, "Large Inventory"),
        INFINITEFUEL(5, "Infinite Fuel"),
    	WATERLANDING(6, "Water Landing"),
    	MAXALTITUDE(7, "Max Altitude"),
    	MINOREFFICIENCY(8, "Minor Efficiency"),
    	MAJOREFFICIENCY(9, "Major Efficiency"),
    	JUKEBOX(10, "Jukebox");
    	
        private final String name;
        private final int metadata;
        
        private Module(int metadataIn, String nameIn)
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
        public static EntityAirshipBaseVC.Module byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipBaseVC.Module getTypeFromString(String nameIn)
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
  	// TODO    Root Getter Methods      //
  	//==================================//
    
    /**
     * Gets the Small Inventory boolean to pass from server to client.
     */
    public boolean getModuleInventorySmall()
    {
        return false;
    }
    
    /**
     * Gets the Large Inventory boolean to pass from server to client.
     */
    public boolean getModuleInventoryLarge()
    {
        return false;
    }
    
    /**
     * Gets the Infinite Fuel boolean to pass from server to client.
     */
    public boolean getModuleFuelInfinite()
    {
        return false;
    }
    
    /**
     * Gets the Minor Speed boolean to pass from server to client.
     */
    public boolean getModuleSpeedMinor()
    {
        return false;
    }
    
    /**
     * Gets the Major Speed boolean to pass from server to client.
     */
    public boolean getModuleSpeedMajor()
    {
        return false;
    }
    
    /**
     * Gets the Water Landing boolean to pass from server to client.
     */
    public boolean getModuleWaterLanding()
    {
        return false;
    }
    
    /**
     * Gets the Max Altitude boolean to pass from server to client.
     */
    public boolean getModuleMaxAltitude()
    {
        return false;
    }
    
    /**
     * Gets the Minor Efficiency boolean to pass from server to client.
     */
    public boolean getModuleMinorEfficiency()
    {
        return false;
    }
    
    /**
     * Gets the Major Efficiency boolean to pass from server to client.
     */
    public boolean getModuleMajorEfficiency()
    {
        return false;
    }
    
    /**
     * Gets the Jukebox boolean to pass from server to client.
     */
    public boolean getModuleJukebox()
    {
        return false;
    }
    
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public int getPowered()
    {
        return 0;
    }
    
    /**
     * Gets the airshipTotalBurnTime to pass from server to client.
     */
    public int getTotalPowered()
    {
        return 0;
    }
    
    /**
     * Gets the itemFuelStack to pass from server to client.
     */
    public int getItemFuelStackPowered()
    {
        return 0;
    }
    
    /**
     * Gets the itemFuelStackSize to pass from server to client.
     */
    public int getItemFuelStackSizePowered()
    {
        return 0;
    }
    
    /**
     * Setter for variables to pass through fields.
     */
    public void setField(int id, int value)
    {
        
    }
    
    public int getField(int id)
    {
    	return 0;
    }
    
    /**
     * Checker to see if the airship has glitched through solid ground.
     */
    protected boolean fallInGround()
    {
    	boolean isGlitched = false;
    	
    	if(this.isEntityInsideOpaqueBlock())
    	{
    		isGlitched = true;
    	}
    	
		return isGlitched;
    }
    
    
    
	//==================================//
  	// TODO     Sound Events            //
  	//==================================//
    
    /**
     * Sounds! - Unused ATM.
     */
    //public SoundCategory getSoundCategory()
    //{
    //    return SoundCategory.RECORDS;
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

    
    //@SideOnly(Side.CLIENT)
    //@Override
    public void playSoundVC(SoundEvent soundIn, float volume, float pitch)
    {
    	//MovingSoundVC t = new MovingSoundVC(this, SoundEvents.RECORD_WARD);
    	

    	//NetworkHandler
    	//.sendToAllAround(new MessageGuiNoMusic(), 
    	//new TargetPoint(this.dimension, this.posX, this.posY, this.posZ, 15));
    	
    	
    	//t.getSound();
    	LogHelper.info("here = " 
    	//+ t
    			);
    	
    	
    	
    	//if (!this.isSilent())
        //{
    	//	Minecraft.getMinecraft().getSoundHandler().playSound(t);
    		//soundHandler.playSound(new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD));
    		///////////////Minecraft.getMinecraft().getSoundHandler().playSound(t);
    		//this.world.playSound((EntityPlayer)null, 
    		//    	t.getXPosF(), 
    		//    	t.getYPosF(), 
    		//    	t.getZPosF(),
    		//		this.posX, 
    		//		this.posY, 
    		//		this.posZ, 
    		//		soundIn, this.getSoundCategory(), volume, pitch);
        //}
    	
    	//MovingSoundVC t = new MovingSoundVC(this, SoundEvents.RECORD_WARD);
    	
        //if (!this.isSilent())
        //{
        //    this.world.playSound((EntityPlayer)null, t.getXPosF(), t.getYPosF(), t.getZPosF(), soundIn, SoundCategory.RECORDS, volume, pitch);
        //}
    }
    
}

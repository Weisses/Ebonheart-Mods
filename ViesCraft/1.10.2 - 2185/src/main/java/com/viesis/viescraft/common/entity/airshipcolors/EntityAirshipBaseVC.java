package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipBaseVC extends Entity {
	
	/** General */
    protected static final DataParameter<Integer> TIME_SINCE_HIT_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> FORWARD_DIRECTION_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Float> DAMAGE_TAKEN_VC = EntityDataManager.<Float>createKey(EntityAirshipBaseVC.class, DataSerializers.FLOAT);

    protected static final DataParameter<Integer> AIRSHIP_VISUAL_FRAME_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> AIRSHIP_VISUAL_FRAME_ACTIVE_VC = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    
    protected static final DataParameter<Integer> AIRSHIP_TYPE_FRAME_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_TYPE_BALLOON_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_RED_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_GREEN_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_COLOR_BLUE_VC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
	/** Fuel */
	protected static final DataParameter<Integer> POWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> TOTALPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKSIZEPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    /** Passive Modules */
	protected static final DataParameter<Boolean> MODULE_INVENTORY_SMALL = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_INVENTORY_LARGE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_FUEL_INFINITE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MINOR = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MAJOR = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_WATER_LANDING = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_MAX_ALTITUDE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_MINOR_EFFICIENCY = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_MAJOR_EFFICIENCY = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_JUKEBOX = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_JUKEBOX_SELECTED_SONG = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_CRUISECONTROL = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_CRUISECONTROL_SELECTED_SPEED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	//Fuel
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	public int itemFuelStackSize;
	public int itemFuelStack;
	public int airshipFuelTick;
	
    //My capabilities inventory
	//Slot 0 =    Fuel
	//Slot 1 = 	  Module 1st
	//Slot 2-19 = Inventory slots
	//Slot 20 =   Unused
    public ItemStackHandler inventory;
    protected int size = 20;
    
    //Main getters
	public int metaFrameCore;
	public int metaBalloon;
	
	public int metaFrameVisual;
	public boolean frameVisualActive;
	
	public int metaColorRed;
	public int metaColorGreen;
	public int metaColorBlue;
	
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
    
    //Movement
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
    
    public float speedModifier;
	
	public String customName;
	protected int dropNumber;
	
	/** Passive Modules */
    public static boolean moduleInventorySmall;
    public static boolean moduleInventoryLarge;
    public static boolean moduleFuelInfinite;
    public static boolean moduleSpeedMinor;
    public static boolean moduleSpeedMajor;
    public static boolean moduleWaterLanding;
    public static boolean moduleMaxAltitude;
    public static boolean moduleMinorEfficiency;
    public static boolean moduleMajorEfficiency;
    public static boolean moduleJukebox;
    public int jukeboxSelectedSong;
    public static boolean moduleCruiseControl;
    public int cruiseControlSelectedSpeed;
    public static boolean cruiseControlToggle;
    
    
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
        	this.metaFrameCore = this.getAirshipMetaFrame();
        	this.metaBalloon = this.getAirshipMetaBalloon();
        	this.metaColorRed = this.getAirshipMetaColorRed();
        	this.metaColorGreen = this.getAirshipMetaColorGreen();
        	this.metaColorBlue = this.getAirshipMetaColorBlue();
        }
    	
        if(!this.worldObj.isRemote)
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
    
    
    
	//==================================//
    // TODO     Input Updates           //
	//==================================//
    
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
    
    
    
	//==================================//
    // TODO          Enums              //
	//==================================//
    
    /**
	 * Core Frame enum - Represents various frame types.
	 */
    public static enum FrameCore
    {
    	//STRING(meta, name, speed, altitude)
    	//Common - 8 items
        WOOD0(0, "Oak", I18n.translateToLocal("vc.item.enum.frame.0"), 0F, 75),
        WOOD1(1, "Spruce", I18n.translateToLocal("vc.item.enum.frame.1"), 0F, 75),
        WOOD2(2, "Birch", I18n.translateToLocal("vc.item.enum.frame.2"), 0F, 75),
        WOOD3(3, "Jungle", I18n.translateToLocal("vc.item.enum.frame.3"), 0F, 75),
        WOOD4(4, "Acacia", I18n.translateToLocal("vc.item.enum.frame.4"), 0F, 75),
        WOOD5(5, "Dark Oak", I18n.translateToLocal("vc.item.enum.frame.5"), 0F, 75),
        SANDSTONE(6, "Sandstone", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        BRICK(7, "Brick", I18n.translateToLocal("vc.item.enum.frame.7"), 0.002F, 90),
        
        //Uncommon - 7 items
        BONE(8, "Bone", I18n.translateToLocal("vc.item.enum.frame.8"), 0.003F, 100),
    	IRON(9, "Iron", I18n.translateToLocal("vc.item.enum.frame.9"), 0.004F, 110),
        REDSTONE(10, "Redstone", I18n.translateToLocal("vc.item.enum.frame.10"), 0.005F, 120),
        GOLD(11, "Gold", I18n.translateToLocal("vc.item.enum.frame.11"), 0.006F, 130),
        LAPISLAZULI(12, "Lapis Lazuli", I18n.translateToLocal("vc.item.enum.frame.12"), 0.007F, 140),
        SLIME(13, "Slime", I18n.translateToLocal("vc.item.enum.frame.13"), 0.008F, 150),
        MYCELIUM(14, "Mycelium", I18n.translateToLocal("vc.item.enum.frame.14"), 0.009F, 160),
        
        //Rare - 6 items
        NETHERBRICK(15, "Nether Brick", I18n.translateToLocal("vc.item.enum.frame.15"), 0.010F, 170),
        SOULSAND(16, "Soul Sand", I18n.translateToLocal("vc.item.enum.frame.16"), 0.011F, 180),
        QUARTZ(17, "Quartz", I18n.translateToLocal("vc.item.enum.frame.17"), 0.012F, 190),
        ICE(18, "Ice", I18n.translateToLocal("vc.item.enum.frame.18"), 0.013F, 200),
        GLOWSTONE(19, "Glowstone", I18n.translateToLocal("vc.item.enum.frame.19"), 0.014F, 210),
        OBSIDIAN(20, "Obsidian", I18n.translateToLocal("vc.item.enum.frame.20"), 0.015F, 220),
        
        //Epic - 5 items + 1 admin-only item
        DIAMOND(21, "Diamond", I18n.translateToLocal("vc.item.enum.frame.21"), 0.016F, 230),
        EMERALD(22, "Emerald", I18n.translateToLocal("vc.item.enum.frame.22"), 0.017F, 240),
        PRISMARINE(23, "Prismarine", I18n.translateToLocal("vc.item.enum.frame.23"), 0.018F, 250),
    	PURPUR(24, "Purpur", I18n.translateToLocal("vc.item.enum.frame.24"), 0.019F, 260),
    	NETHERSTAR(25, "Nether Star", I18n.translateToLocal("vc.item.enum.frame.25"), 0.020F, 500),
    	
    	MYTHIC(26, "Mythic", I18n.translateToLocal("vc.item.enum.frame.26"), 0.025F, 500),  // This is a special admin only Airship.
    	WATER(27, "Water", I18n.translateToLocal("vc.item.enum.frame.27"), 0.030F, 500), 
    	LAVA(28, "Lava", I18n.translateToLocal("vc.item.enum.frame.28"), 0.031F, 500), 
    	ENDER(29, "Ender", I18n.translateToLocal("vc.item.enum.frame.29"), 0.032F, 500); 
    	
        private final String name;
        private final int metadata;
        private final float speed;
        private final int elevation;
        private final String localizedName;
        
        private FrameCore(int metadataIn, String nameIn, String localizedNameIn, float speedModifier, int maxElevation)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.speed = speedModifier;
            this.elevation = maxElevation;
            this.localizedName = localizedNameIn;
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
        
        public String getLocalizedName()
        {
            return this.localizedName;
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
        PLAIN(0, "Plain", I18n.translateToLocal("vc.item.enum.balloon.0")),
        PLAINCOLORIZED(1, "Colorized Plain", I18n.translateToLocal("vc.item.enum.balloon.1")),
        PLAINPHANTOM(2, "Phantom Plain", I18n.translateToLocal("vc.item.enum.balloon.2")),
        CHECKER(3, "Checker", I18n.translateToLocal("vc.item.enum.balloon.3")),
        CHECKERCOLORIZED(4, "Colorized Checker", I18n.translateToLocal("vc.item.enum.balloon.4")),
        CHECKERPHANTOM(5, "Phantom Checker", I18n.translateToLocal("vc.item.enum.balloon.5")),
        POLKADOT(6, "Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.6")),
        POLKADOTCOLORIZED(7, "Colorized Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.7")),
        POLKADOTPHANTOM(8, "Phantom Polka Dot", I18n.translateToLocal("vc.item.enum.balloon.8")),
        ZIGZAG(9, "Zigzag", I18n.translateToLocal("vc.item.enum.balloon.9")),
    	ZIGZAGCOLORIZED(10, "Colorized Zigzag", I18n.translateToLocal("vc.item.enum.balloon.10")),
    	ZIGZAGPHANTOM(11, "Phantom Zigzag", I18n.translateToLocal("vc.item.enum.balloon.11")),
    	CREEPER(12, "Creeper", I18n.translateToLocal("vc.item.enum.balloon.12")),
    	CREEPERCOLORIZED(13, "Colorized Creeper", I18n.translateToLocal("vc.item.enum.balloon.13")),
    	CREEPERPHANTOM(14, "Phantom Creeper", I18n.translateToLocal("vc.item.enum.balloon.14")),
    	WATER(15, "Water", I18n.translateToLocal("vc.item.enum.balloon.15")),
    	WATERCOLORIZED(16, "Colorized Water", I18n.translateToLocal("vc.item.enum.balloon.16")),
    	WATERPHANTOM(17, "Phantom Water", I18n.translateToLocal("vc.item.enum.balloon.17")),
    	LAVA(18, "Lava", I18n.translateToLocal("vc.item.enum.balloon.18")),
    	LAVACOLORIZED(19, "Colorized Lava", I18n.translateToLocal("vc.item.enum.balloon.19")),
    	LAVAPHANTOM(20, "Phantom Lava", I18n.translateToLocal("vc.item.enum.balloon.20")),
    	ENDER(21, "Ender", I18n.translateToLocal("vc.item.enum.balloon.21")),
    	ENDERCOLORIZED(22, "Colorized Ender", I18n.translateToLocal("vc.item.enum.balloon.22")),
    	ENDERPHANTOM(23, "Phantom Ender", I18n.translateToLocal("vc.item.enum.balloon.23")),
    	TOOLS(24, "Tools", I18n.translateToLocal("vc.item.enum.balloon.24")),
    	TOOLSCOLORIZED(25, "Colorized Tools", I18n.translateToLocal("vc.item.enum.balloon.25")),
    	TOOLSPHANTOM(26, "Phantom Tools", I18n.translateToLocal("vc.item.enum.balloon.26"))//,
        
    	//WAVEHORIZONTAL(7, "Horizontal Wave"),
        //WAVEHORIZONTALCOLORIZED(8, "Colorized Horizontal Wave"),
        //WAVEVERTICAL(9, "Vertical Wave"),
        //WAVEVERTICALCOLORIZED(10, "Colorized Vertical Wave")
    	//BASKETWEAVE(7, "Basketweave")
    	//BASKETWEAVECOLORIZED(7, "Colorized Basketweave")
    	;
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private Balloon(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
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
        
        public String getLocalizedName()
        {
            return this.localizedName;
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
        CHIP(0, "Chip", I18n.translateToLocal("vc.item.enum.module.0")),
        MINORSPEED(1, "Minor Speed", I18n.translateToLocal("vc.item.enum.module.1")),
        MAJORSPEED(2, "Major Speed", I18n.translateToLocal("vc.item.enum.module.2")),
        SMALLINVENTORY(3, "Small Inventory", I18n.translateToLocal("vc.item.enum.module.3")),
        LARGEINVENTORY(4, "Large Inventory", I18n.translateToLocal("vc.item.enum.module.4")),
        INFINITEFUEL(5, "Infinite Fuel", I18n.translateToLocal("vc.item.enum.module.5")),
    	WATERLANDING(6, "Water Landing", I18n.translateToLocal("vc.item.enum.module.6")),
    	MAXALTITUDE(7, "Max Altitude", I18n.translateToLocal("vc.item.enum.module.7")),
    	MINOREFFICIENCY(8, "Minor Efficiency", I18n.translateToLocal("vc.item.enum.module.8")),
    	MAJOREFFICIENCY(9, "Major Efficiency", I18n.translateToLocal("vc.item.enum.module.9")),
    	JUKEBOX(10, "Jukebox", I18n.translateToLocal("vc.item.enum.module.10")),
    	CRUISECONTROL(11, "Cruise Control", I18n.translateToLocal("vc.item.enum.module.11"));
    	
        private final String name;
        private final int metadata;
        private final String localizedName;
        
        private Module(int metadataIn, String nameIn, String localizedNameIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.localizedName = localizedNameIn;
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
        
        public String getLocalizedName()
        {
            return this.localizedName;
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
    
    /**
	 * Song enum - Represents various song types.
	 */
    public static enum Song
    {
    	NONE(0, I18n.translateToLocal("vc.item.enum.song.0"), SoundEvents.UI_BUTTON_CLICK),
    	RECORD11(1, I18n.translateToLocal("vc.item.enum.song.1"), SoundEvents.RECORD_11),
        RECORD13(2, I18n.translateToLocal("vc.item.enum.song.2"), SoundEvents.RECORD_13),
        RECORDBLOCKS(3, I18n.translateToLocal("vc.item.enum.song.3"), SoundEvents.RECORD_BLOCKS),
        RECORDMELLOHI(4, I18n.translateToLocal("vc.item.enum.song.4"), SoundEvents.RECORD_MELLOHI),
        RECORDCAT(5, I18n.translateToLocal("vc.item.enum.song.5"), SoundEvents.RECORD_CAT),
        RECORDSTAL(6, I18n.translateToLocal("vc.item.enum.song.6"), SoundEvents.RECORD_STAL),
        RECORDSTRAD(7, I18n.translateToLocal("vc.item.enum.song.7"), SoundEvents.RECORD_STRAD),
        RECORDCHIRP(8, I18n.translateToLocal("vc.item.enum.song.8"), SoundEvents.RECORD_CHIRP),
        RECORDFAR(9, I18n.translateToLocal("vc.item.enum.song.9"), SoundEvents.RECORD_FAR),
        RECORDMALL(10, I18n.translateToLocal("vc.item.enum.song.10"), SoundEvents.RECORD_MALL),
        RECORDWAIT(11, I18n.translateToLocal("vc.item.enum.song.11"), SoundEvents.RECORD_WAIT),
        RECORDWARD(12, I18n.translateToLocal("vc.item.enum.song.12"), SoundEvents.RECORD_WARD),
        RECORDTRIGUN(13, I18n.translateToLocal("vc.item.enum.song.13"), InitSoundEventsVC.trigun),
        RECORDBRAMBLE(14, I18n.translateToLocal("vc.item.enum.song.14"), InitSoundEventsVC.bramble),
        RECORDSTORMS(15, I18n.translateToLocal("vc.item.enum.song.15"), InitSoundEventsVC.storms),
        RECORDCOWBOY(16, I18n.translateToLocal("vc.item.enum.song.16"), InitSoundEventsVC.cowboy),
        RECORDSECRET(17, I18n.translateToLocal("vc.item.enum.song.17"), InitSoundEventsVC.bay)
    	;
    	
        private final String name;
        private final int metadata;
        private final SoundEvent song;
        
        private Song(int metadataIn, String nameIn, SoundEvent soundIn)
        {
            this.name = nameIn;
            this.metadata = metadataIn;
            this.song = soundIn;
        }
        
        public String getName()
        {
            return this.name;
        }
        
        public int getMetadata()
        {
            return this.metadata;
        }
        
        public SoundEvent getSong()
        {
            return this.song;
        }
        
        public String toString()
        {
            return this.name;
        }
        
        /**
         * Get a boat type by it's enum ordinal
         */
        public static EntityAirshipBaseVC.Song byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipBaseVC.Song getTypeFromString(String nameIn)
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
     * Gets the Jukebox selected song int to pass from server to client.
     */
    public int getJukeboxSelectedSong()
    {
        return 0;
    }
    
    /**
     * Gets the Cruise Control boolean to pass from server to client.
     */
    public boolean getModuleCruiseControl()
    {
        return false;
    }
    
    /**
     * Gets the Cruise Control selected speed int to pass from server to client.
     */
    public int getCruiseControlSelectedSpeed()
    {
        return 0;
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
    //    return SoundCategory.AMBIENT;
    //}
	
    //protected SoundEvent getAmbientSound()
    //{
    //    return SoundEvents.ENTITY_GENERIC_EXPLODE;
    //}
	
    //protected SoundEvent getHurtSound()
    //{
    //    return SoundEvents.ENTITY_COW_HURT;
    //}
	
    /**
     * Returns the volume for the sounds this mob makes.
     */
    //protected float getSoundVolume()
    //{
    //    return 5.0F;
    //}
}

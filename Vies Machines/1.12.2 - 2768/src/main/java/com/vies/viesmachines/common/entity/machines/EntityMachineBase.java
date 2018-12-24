package com.vies.viesmachines.common.entity.machines;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.Lists;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.SoundsVM;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.api.util.Loghelper;
import com.vies.viesmachines.client.InitParticlesVMRender;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.MessageFlyingThunderStrike;
import com.vies.viesmachines.network.server.machine.MessageMachineFlyingBombStandard;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger01Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger02Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger04Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger05Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger11Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger12Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger13Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger21Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger22Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger23Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger31Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger32Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger33Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger41Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger42Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger43Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger51Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger52Server;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger53Server;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemError;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageWeaponSystemOutOfAmmo;
import com.vies.viesmachines.proxy.CommonProxy;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureAttribute;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineBase extends EntityLiving {
	
	// Attribute:
	//public static final IAttribute DEFENSE = (new RangedAttribute(null, "generic.defense", 4.0D, 0.0D, 1024.0D)).setShouldWatch(true);
	
	/** Shortcut to References. */
    protected static References rf;
    
	// Data Manager:
    /** Keeps track of a machine's energy value. */
	private static final DataParameter<Integer> ENERGY_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of a machine's durability value. */
	private static final DataParameter<Integer> DURABILITY_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	
	/** Keeps track of the frame tier value. */
	private static final DataParameter<Integer> TIER_FRAME_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the engine tier value. */
	private static final DataParameter<Integer> TIER_ENGINE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the component tier value. (Ground = Jump Height / Water = Max Oxygen / Flying = Max Altitude) */
	private static final DataParameter<Integer> TIER_COMPONENT_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
  	
	//** Keeps track of the type value. (Hovercraft, Submarine, Airship, etc.) */
	//private static final DataParameter<Integer> TYPE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the forward speed value. */
	private static final DataParameter<Float> FORWARD_SPEED_DM = EntityDataManager.<Float>createKey(EntityMachineBase.class, DataSerializers.FLOAT);
	/** Keeps track of the turn speed value. */
	private static final DataParameter<Float> TURN_SPEED_DM = EntityDataManager.<Float>createKey(EntityMachineBase.class, DataSerializers.FLOAT);
	/** Keeps track of the broken toggle. */
	private static final DataParameter<Boolean> BROKEN_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the powered on toggle. */
	private static final DataParameter<Boolean> POWERED_ON_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the autorun toggle. */
	private static final DataParameter<Boolean> AUTORUN_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	
	/** Keeps track of the armed toggle. */
	private static final DataParameter<Boolean> ARMED_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
	/** Keeps track of the ammo amount value. */
	private static final DataParameter<Integer> AMMO_AMOUNT_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the ammo type value. */
	private static final DataParameter<Integer> AMMO_TYPE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);

	/** Keeps track of the selected record. */
	private static final DataParameter<Integer> SELECTED_RECORD_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the learned record in slot 1. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_1_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 2. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_2_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 3. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_3_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 4. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_4_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 5. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_5_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 6. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_6_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	/** Keeps track of the learned record in slot 7. */
	private static final DataParameter<String> LEARNED_RECORD_SLOT_7_DM = EntityDataManager.<String>createKey(EntityMachineBase.class, DataSerializers.STRING);
	
	/** Keeps track of the primed for lightning strike in ticks. */
	private static final DataParameter<Integer> PRIMED_FOR_LIGHTNING_STRIKE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	/** Keeps track of the machine issue in ticks. */
	private static final DataParameter<Integer> MACHINE_ISSUE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	
	/** Keeps track of the current active machine Enhancement slot 1. */
	private static final DataParameter<Integer> MACHINE_ENHANCEMENT_1_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	
	
	
	/**
	 * Keeps track of the event to be triggered. <br> <br>
	 *
	 *  0 = No event to trigger.<br>
	 *  1 = Trigger fall sound/particles. <br>
	 *  2 = Trigger broken sound/particles. <br>
	 *  3 = Trigger destruction logic. <br>
	 *  4 = Trigger lightning strike sound/particles. <br><br>
	 *  
	 *  11 = Triggers 2 health heal sound/particles. <br>
	 *  12 = Triggers 8 health heal sound/particles. <br>
	 *  13 = Triggers MAX health heal sound/particles. <br><br>
	 *  
	 *  21 = Triggers 25 energy heal sound/particles. <br>
	 *  22 = Triggers 100 energy heal sound/particles. <br>
	 *  23 = Triggers MAX energy heal sound/particles. <br><br>
	 *  
	 *  31 = Triggers 50 durability heal sound/particles. <br>
	 *  32 = Triggers 200 durability heal sound/particles. <br>
	 *  33 = Triggers MAX durability heal sound/particles. <br><br>
	 *  
	 *  41 = Triggers tier 1 upgrade sound/particles. <br>
	 *  42 = Triggers tier 2 upgrade sound/particles. <br>
	 *  43 = Triggers tier 3 upgrade sound/particles. <br><br>
	 */
	private static final DataParameter<Integer> EVENT_TRIGGER_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
	
	
	
	/** Keeps track of the customName color value. */
    protected static final DataParameter<Integer> VISUAL_NAME_COLOR_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of what machine variant is active. (Spiked, etc) */
    protected static final DataParameter<Integer> VISUAL_MODEL_FRAME_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of what machine variant is active. (Single exhaust, Double exhaust, etc) */
    protected static final DataParameter<Integer> VISUAL_MODEL_ENGINE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of what machine variant is active. (Hindenburg, Dirigible, etc) */
    protected static final DataParameter<Integer> VISUAL_MODEL_COMPONENT_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the frame texture. */
    protected static final DataParameter<Integer> VISUAL_FRAME_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame texture transparency. */
    protected static final DataParameter<Boolean> VISUAL_FRAME_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the frame texture color. */
    protected static final DataParameter<Boolean> VISUAL_FRAME_COLOR_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the frame red color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame green color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the frame blue color value. */
    protected static final DataParameter<Integer> VISUAL_FRAME_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the display type. <br> <br>
	 *
	 *  0 = Renders Nothing. (Default) <br>
	 *  1 = Renders Block/Item. (Default) <br>
	 *  2 = Renders Head. (Default) <br>
	 *  3 = Renders Supporter Head. (Default) <br>
	 *  10 - 999 = Renders Symbols. (Default) <br>
	 *  1000+ = Renders Holiday Symbols. (Default) <br>
     * 
     * (Block, Item, Head, etc...) */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_TYPE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display itemstack id. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display itemstack metadata value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display head value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_HEAD_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display supporter head value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the display holiday value. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_DISPLAY_HOLIDAY_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the particle texture. */
    protected static final DataParameter<Integer> VISUAL_ENGINE_PARTICLE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the component texture. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component texture transparency. */
    protected static final DataParameter<Boolean> VISUAL_COMPONENT_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the component texture color. */
    protected static final DataParameter<Boolean> VISUAL_COMPONENT_COLOR_DM = EntityDataManager.<Boolean>createKey(EntityMachineBase.class, DataSerializers.BOOLEAN);
    /** Keeps track of the component red color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component green color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    /** Keeps track of the component blue color value. */
    protected static final DataParameter<Integer> VISUAL_COMPONENT_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    /** Keeps track of the preview part value. <br> <br>
	 *
	 *  0 = Render whole model. (Default) <br>
	 *  1 = Render Frame only. <br>
	 *  2 = Render Engine only. <br>
	 *  3 = Render Component only. <br>
	 */
    protected static final DataParameter<Integer> PREVIEW_PART_DM = EntityDataManager.<Integer>createKey(EntityMachineBase.class, DataSerializers.VARINT);
    
    //===============================================================
	
    // General:
	/** Stores the entity ID for passing into lightning strikes.  */
	public static int entityID;
	/** Has autorun been triggered? */
    public boolean autorunTrigger;
	/** Keeps count of the firing cooldown. */
	protected int weaponCooldown;
	//** Keeps count of the number of charges before a lightning strike happens. 20 charges equals 1 strike.*/
	//protected int primedForLightningStrike;
    
	// Status:
	/** Current machine status. */
	public EntityMachineBase.Status status;
	/** Previous machine status. */
    protected EntityMachineBase.Status previousStatus;
    
    /** The living update tick. **/
    public long updateTick = 0;
    /** Used to signal a player when enough control is lost. */
    protected float outOfControlTicks;
    
    // Size:
    /** The width of this mob. XZ axis. **/
	public float setWidth;
    /** The height of this mob. Y axis. **/
	public float setHeight;
	
	// Movement:
    /** The left/right turn yaw. */
    protected float deltaRotation;
    /** Uses hitbox to check the water level. */
    protected double waterLevel;
    /** How much of current speed to retain. Value zero to one. */
	protected double momentum;
    /** How much the airship should glide given the slippery blocks it's currently gliding over.
     * Halved every tick. 
     * NOT USED YET THANKS TO TRAVEL() FRICTION!!! */
    private float machineGlide;
    /** Stores previous motion, mainly for momentum.
     * NOT USED YET */
    protected double lastYd;
    
    protected int fallDistancePosY;
	
    // Durability issues:
	protected boolean engineTrouble;
	protected boolean previouslyPoweredOn;
    
	// Inventory:
	/**
	 * SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel Slot<br>
	 * Slot  1 = Ammo Slot <br>
	 * Slot  2 = Block/Item to Display Slot <br>
	 //* Slot  1 = Upgrade Core <br>
	 //* Slot  2 = Upgrade Frame <br>
	 //* Slot  3 = Upgrade Engine <br>
	 //* Slot  4 = Upgrade Balloon <br>
	 //* Slot 11 = Module Slot1 <br>
	 //* Slot 12 = Module Slot2 <br>
	 //* Slot 16 = Redstone Slot <br>
	 //* Slot 18 = Block/Item to Display <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 //* Slot 51 = Bomb Slot1 <br>
	 */
    public ItemStackHandler inventory;
    /** The amount of slots the machine has for storage. */
    protected int size = 64;
    
    // Movement:
    protected boolean leftInputDown;
    protected boolean rightInputDown;
    protected boolean forwardInputDown;
    protected boolean backInputDown;
    protected boolean upInputDown;
    protected boolean downInputDown;
    protected boolean openGuiMenuInputDown;
    protected boolean shootProjectileInputDown;
    protected boolean toggleAbilityInputDown;
    
    // Radio:
    //public ArrayList<ResourceLocation> currentMusicListRecord = new ArrayList<ResourceLocation>();
	
    
    //** Stores the selected song using the int position of the musicListRecord array. */
    //public int selectedSong;
    

    //public float controllingPassengerPitch;
    //public float controllingPassengerYaw;
	
    // To debug and fix...
	private BlockPos homePosition = BlockPos.ORIGIN;
    /** If -1 there is no maximum distance. */
    private float maximumHomeDistance = -1.0F;
    
    
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineBase(World worldIn) 
	{
		super(worldIn);
		
		// This is a metal machine after all:
		this.isImmuneToFire = true;
		this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        
        // Sets up the inventory:
        this.inventory = new ItemStackHandler(size);
	}

	public EntityMachineBase(World worldIn, double x, double y, double z,
			
			int frameTierIn, int engineTierIn, int componentTierIn, int typeIn, 
			float healthIn, int energyIn, int durabilityIn, 
			boolean brokenIn, int currentFuelIn, int totalFuelIn, 
			int ammoAmountIn, int ammoTypeIn, 
			int machineEnhancement1In, 
			
			int visualModelFrameIn, int visualModelEngineIn, int visualModelComponentIn, 
			
			int visualFrameTextureIn, 
			boolean visualFrameTransparentIn, boolean visualFrameColorIn, 
			int visualFrameColorRedIn, 
			int visualFrameColorGreenIn, 
			int visualFrameColorBlueIn, 
			
			int visualEngineParticleIn, 
			int visualEngineDisplayTypeIn, 
			int visualEngineDisplayItemstackIn, 
			int visualEngineDisplayItemstackMetaIn, 
			int visualEngineDisplayHeadIn, 
			int visualEngineDisplaySupporterHeadIn, 
			int visualEngineDisplayHolidayIn, 
			
			int visualComponentTextureIn, 
			boolean visualComponentTransparentIn, boolean visualComponentColorIn, 
			int visualComponentColorRedIn, 
			int visualComponentColorGreenIn, 
			int visualComponentColorBlueIn, 
			
    		NBTTagCompound compoundIn, String customNameIn, int customNameColorIn)
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
	
	
	
	//==================================================
    // TODO         Inventory Capability
	//==================================================
    
	@Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return true;
        return super.hasCapability(capability, facing);
    }
	
    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing)
    {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) return (T) inventory;
        return super.getCapability(capability, facing);
    }
    
    
    
	//==================================================
    // TODO              Core Inits
	//==================================================
    
    /** 
     * Initiates the entity AI tasks to run. 
     */
	@Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    }
	
	/** 
	 * Creates and sets all the entity attributes with default values.
	 */
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(this.getTierFrame()).getMaxHealthModifier());
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue((double)EnumsVM.FlyingMachineEngineTier.byId(this.getTierEngine()).getFowardSpeedModifier());
    }
	
	/** 
	 * Initiates the entity, setting all the values to be watched by the data watcher. 
	 */
	@Override
    protected void entityInit()
    {
        super.entityInit();
        
        this.dataManager.register(ENERGY_DM, Integer.valueOf(0));
        
        this.dataManager.register(DURABILITY_DM, Integer.valueOf(0));
        
        this.dataManager.register(TIER_FRAME_DM, Integer.valueOf(0));
        this.dataManager.register(TIER_ENGINE_DM, Integer.valueOf(0));
        this.dataManager.register(TIER_COMPONENT_DM, Integer.valueOf(0));
        
        //this.dataManager.register(TYPE_DM, Integer.valueOf(0));
        this.dataManager.register(FORWARD_SPEED_DM, Float.valueOf(0.0F));
        this.dataManager.register(TURN_SPEED_DM, Float.valueOf(0.0F));
        this.dataManager.register(BROKEN_DM, Boolean.valueOf(false));
        this.dataManager.register(POWERED_ON_DM, Boolean.valueOf(false));
        this.dataManager.register(AUTORUN_DM, Boolean.valueOf(false));
        
        this.dataManager.register(ARMED_DM, Boolean.valueOf(false));
        this.dataManager.register(AMMO_AMOUNT_DM, Integer.valueOf(0));
        this.dataManager.register(AMMO_TYPE_DM, Integer.valueOf(0));

        this.dataManager.register(SELECTED_RECORD_DM, Integer.valueOf(-1));
        this.dataManager.register(LEARNED_RECORD_SLOT_1_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_2_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_3_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_4_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_5_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_6_DM, String.valueOf(""));
        this.dataManager.register(LEARNED_RECORD_SLOT_7_DM, String.valueOf(""));
        
        this.dataManager.register(PRIMED_FOR_LIGHTNING_STRIKE_DM, Integer.valueOf(0));
        this.dataManager.register(MACHINE_ISSUE_DM, Integer.valueOf(0));
        
        this.dataManager.register(MACHINE_ENHANCEMENT_1_DM, Integer.valueOf(0));
        
        this.dataManager.register(EVENT_TRIGGER_DM, Integer.valueOf(0));
        
        
        
        this.dataManager.register(VISUAL_MODEL_FRAME_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_MODEL_ENGINE_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_MODEL_COMPONENT_DM, Integer.valueOf(0));
        
        this.dataManager.register(VISUAL_FRAME_TEXTURE_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_FRAME_TRANSPARENT_DM, Boolean.valueOf(false));
        this.dataManager.register(VISUAL_FRAME_COLOR_DM, Boolean.valueOf(false));
        this.dataManager.register(VISUAL_FRAME_COLOR_RED_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_FRAME_COLOR_GREEN_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_FRAME_COLOR_BLUE_DM, Integer.valueOf(0));
        
        this.dataManager.register(VISUAL_ENGINE_PARTICLE_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_TYPE_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_HEAD_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM, Integer.valueOf(0));
        
        this.dataManager.register(VISUAL_COMPONENT_TEXTURE_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_COMPONENT_TRANSPARENT_DM, Boolean.valueOf(false));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_DM, Boolean.valueOf(false));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_RED_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_GREEN_DM, Integer.valueOf(0));
        this.dataManager.register(VISUAL_COMPONENT_COLOR_BLUE_DM, Integer.valueOf(0));
        
        this.dataManager.register(VISUAL_NAME_COLOR_DM, Integer.valueOf(0));
        
        this.dataManager.register(PREVIEW_PART_DM, Integer.valueOf(0));
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		compound.setTag(rf.MACHINE_SLOTS_TAG, this.inventory.serializeNBT());
		
		compound.setInteger(rf.TIER_FRAME_TAG, this.getTierFrame());
		compound.setInteger(rf.TIER_ENGINE_TAG, this.getTierEngine());
		compound.setInteger(rf.TIER_COMPONENT_TAG, this.getTierComponent());
		
		compound.setInteger(rf.ENERGY_TAG, this.getEnergy());
		
		compound.setInteger(rf.DURABILITY_TAG, this.getDurability());
		
		//compound.setFloat(rf.TYPE_TAG, this.getType());
		compound.setFloat(rf.FORWARD_SPEED_TAG, this.getForwardSpeed());
		compound.setFloat(rf.TURN_SPEED_TAG, this.getTurnSpeed());
		compound.setBoolean(rf.BROKEN_TAG, this.getBroken());
		compound.setBoolean(rf.POWERED_ON_TAG, this.getPoweredOn());
		compound.setBoolean(rf.AUTORUN_TAG, this.getAutorun());
		
		compound.setBoolean(rf.ARMED_TAG, this.getArmed());
		compound.setInteger(rf.AMMO_AMOUNT_TAG, this.getAmmoAmount());
		compound.setInteger(rf.AMMO_TYPE_TAG, this.getAmmoType());

		compound.setInteger(rf.SELECTED_SONG_TAG, this.getSelectedRecord());
		compound.setString(rf.LEARNED_RECORD_SLOT_1_TAG, this.getLearnedRecordSlot1());
		compound.setString(rf.LEARNED_RECORD_SLOT_2_TAG, this.getLearnedRecordSlot2());
		compound.setString(rf.LEARNED_RECORD_SLOT_3_TAG, this.getLearnedRecordSlot3());
		compound.setString(rf.LEARNED_RECORD_SLOT_4_TAG, this.getLearnedRecordSlot4());
		compound.setString(rf.LEARNED_RECORD_SLOT_5_TAG, this.getLearnedRecordSlot5());
		compound.setString(rf.LEARNED_RECORD_SLOT_6_TAG, this.getLearnedRecordSlot6());
		compound.setString(rf.LEARNED_RECORD_SLOT_7_TAG, this.getLearnedRecordSlot7());
		
		compound.setInteger(rf.PRIMED_FOR_LIGHTNING_STRIKE_TAG, this.getPrimedForLightningStrike());
		compound.setInteger(rf.MACHINE_ISSUE_TAG, this.getIssueTick());
		
		compound.setInteger(rf.MACHINE_ENHANCEMENT_1_TAG, this.getMachineEnhancement1());
		
		compound.setInteger(rf.EVENT_TRIGGER_TAG, this.getEventTrigger());
		
		//--------------------------------------------------
		
		compound.setInteger(rf.VISUAL_NAME_COLOR_TAG, this.getVisualNameColor());
    	
		compound.setInteger(rf.VISUAL_MODEL_FRAME_TAG, this.getVisualModelFrame());
		compound.setInteger(rf.VISUAL_MODEL_ENGINE_TAG, this.getVisualModelEngine());
		compound.setInteger(rf.VISUAL_MODEL_COMPONENT_TAG, this.getVisualModelComponent());
    	
    	compound.setInteger(rf.VISUAL_FRAME_TEXTURE_TAG, this.getVisualFrameTexture());
    	compound.setBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG, this.getVisualFrameTransparent());
    	compound.setBoolean(rf.VISUAL_FRAME_COLOR_TAG, this.getVisualFrameColor());
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_RED_TAG, this.getVisualFrameColorRed());
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG, this.getVisualFrameColorGreen());
    	compound.setInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG, this.getVisualFrameColorBlue());
    	
    	compound.setInteger(rf.VISUAL_ENGINE_PARTICLE_TAG, this.getVisualEngineParticle());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG, this.getVisualEngineDisplayType());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG, this.getVisualEngineDisplayItemstack());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG, this.getVisualEngineDisplayItemstackMeta());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG, this.getVisualEngineDisplayHead());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG, this.getVisualEngineDisplaySupporterHead());
    	compound.setInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG, this.getVisualEngineDisplayHoliday());
    	
    	compound.setInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG, this.getVisualComponentTexture());
    	compound.setBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG, this.getVisualComponentTransparent());
    	compound.setBoolean(rf.VISUAL_COMPONENT_COLOR_TAG, this.getVisualComponentColor());
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG, this.getVisualComponentColorRed());
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG, this.getVisualComponentColorGreen());
    	compound.setInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG, this.getVisualComponentColorBlue());
    	
    	
    	/*
    	NBTTagList nbtTagList = new NBTTagList();
    	for (int i = 0; i < this.currentMusicListRecord.size(); i++)
        {
        	NBTTagCompound itemTag = new NBTTagCompound();
            itemTag.setString("Record", this.currentMusicListRecord.get(i).getResourceDomain() + ":" + this.currentMusicListRecord.get(i).getResourcePath());
            
            nbtTagList.appendTag(itemTag);
        }
        
        compound.setTag("LearnedRecords", nbtTagList);
    	*/
    	
    	super.writeEntityToNBT(compound);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		this.inventory.deserializeNBT(compound.getCompoundTag(rf.MACHINE_SLOTS_TAG));
    	
		this.setTierFrame(compound.getInteger(rf.TIER_FRAME_TAG));
		this.setTierEngine(compound.getInteger(rf.TIER_ENGINE_TAG));
		this.setTierComponent(compound.getInteger(rf.TIER_COMPONENT_TAG));
		
		this.setEnergy(compound.getInteger(rf.ENERGY_TAG));
		
		this.setDurability(compound.getInteger(rf.DURABILITY_TAG));
		
		//this.setType(compound.getInteger(rf.TYPE_TAG));
		this.setForwardSpeed(compound.getFloat(rf.FORWARD_SPEED_TAG));
		this.setTurnSpeed(compound.getFloat(rf.TURN_SPEED_TAG));
		this.setBroken(compound.getBoolean(rf.BROKEN_TAG));
		this.setPoweredOn(compound.getBoolean(rf.POWERED_ON_TAG));
		this.setAutorun(compound.getBoolean(rf.AUTORUN_TAG));
		
		this.setArmed(compound.getBoolean(rf.ARMED_TAG));
		this.setAmmoAmount(compound.getInteger(rf.AMMO_AMOUNT_TAG));
		this.setAmmoType(compound.getInteger(rf.AMMO_TYPE_TAG));

		this.setSelectedRecord(compound.getInteger(rf.SELECTED_SONG_TAG));
		this.setLearnedRecordSlot1(compound.getString(rf.LEARNED_RECORD_SLOT_1_TAG));
		this.setLearnedRecordSlot2(compound.getString(rf.LEARNED_RECORD_SLOT_2_TAG));
		this.setLearnedRecordSlot3(compound.getString(rf.LEARNED_RECORD_SLOT_3_TAG));
		this.setLearnedRecordSlot4(compound.getString(rf.LEARNED_RECORD_SLOT_4_TAG));
		this.setLearnedRecordSlot5(compound.getString(rf.LEARNED_RECORD_SLOT_5_TAG));
		this.setLearnedRecordSlot6(compound.getString(rf.LEARNED_RECORD_SLOT_6_TAG));
		this.setLearnedRecordSlot7(compound.getString(rf.LEARNED_RECORD_SLOT_7_TAG));
		
		
		this.setPrimedForLightningStrike(compound.getInteger(rf.PRIMED_FOR_LIGHTNING_STRIKE_TAG));
		this.setIssueTick(compound.getInteger(rf.MACHINE_ISSUE_TAG));
		
		this.setMachineEnhancement1(compound.getInteger(rf.MACHINE_ENHANCEMENT_1_TAG));
		
		this.setEventTrigger(compound.getInteger(rf.EVENT_TRIGGER_TAG));
		
		//--------------------------------------------------
		
		this.setVisualNameColor(compound.getInteger(rf.VISUAL_NAME_COLOR_TAG));
    	
		this.setVisualModelFrame(compound.getInteger(rf.VISUAL_MODEL_FRAME_TAG));
		this.setVisualModelEngine(compound.getInteger(rf.VISUAL_MODEL_ENGINE_TAG));
		this.setVisualModelComponent(compound.getInteger(rf.VISUAL_MODEL_COMPONENT_TAG));
    	
    	this.setVisualFrameTexture(compound.getInteger(rf.VISUAL_FRAME_TEXTURE_TAG));
    	this.setVisualFrameTransparent(compound.getBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG));
    	this.setVisualFrameColor(compound.getBoolean(rf.VISUAL_FRAME_COLOR_TAG));
    	this.setVisualFrameColorRed(compound.getInteger(rf.VISUAL_FRAME_COLOR_RED_TAG));
    	this.setVisualFrameColorGreen(compound.getInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG));
    	this.setVisualFrameColorBlue(compound.getInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG));
    	
    	this.setVisualEngineParticle(compound.getInteger(rf.VISUAL_ENGINE_PARTICLE_TAG));
    	this.setVisualEngineDisplayType(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG));
    	this.setVisualEngineDisplayItemstack(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG));
    	this.setVisualEngineDisplayItemstackMeta(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG));
    	this.setVisualEngineDisplayHead(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG));
    	this.setVisualEngineDisplaySupporterHead(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG));
    	this.setVisualEngineDisplayHoliday(compound.getInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG));
    	
    	this.setVisualComponentTexture(compound.getInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG));
    	this.setVisualComponentTransparent(compound.getBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG));
    	this.setVisualComponentColor(compound.getBoolean(rf.VISUAL_COMPONENT_COLOR_TAG));
    	this.setVisualComponentColorRed(compound.getInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG));
    	this.setVisualComponentColorGreen(compound.getInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG));
    	this.setVisualComponentColorBlue(compound.getInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG));
    	
    	
    	/*
    	// Clears the list so it doesn't keep the old one from the previous world load:
    	//this.currentMusicListRecord.clear();
    	
    	NBTTagList tagList = compound.getTagList("LearnedRecords", Constants.NBT.TAG_COMPOUND);
    	for (int i = 0; i < tagList.tagCount(); i++)
        {
            NBTTagCompound itemTags = tagList.getCompoundTagAt(i);
            
            this.currentMusicListRecord.add(new ResourceLocation(itemTags.getString("Record")));
            
        }
    	Collections.sort(this.currentMusicListRecord);
    	LogHelper.info("******************READ = " +this.currentMusicListRecord);
    	*/
    	
    	super.readEntityFromNBT(compound);
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	/**
     * The main update method, all the important updates go here.
     */
	@Override
	public void onUpdate()
    {
		//Used to clear out all test machines for testing purposes:
        //	this.isDead = true;
        
		//--------------------------------------------------
		
		/*
		if (this.ticksExisted % 40 == 0)
		{
			//this.setLearnedRecordSlot1("");
		LogHelper.info(
			  this.getLearnedRecordSlot1() + " - "
			+ this.getLearnedRecordSlot2() + " - "
			+ this.getLearnedRecordSlot3() + " - "
			+ this.getLearnedRecordSlot4() + " - "
			+ this.getLearnedRecordSlot5() + " - "
			+ this.getLearnedRecordSlot6() + " - "
			+ this.getLearnedRecordSlot7() + " - "
			);
		}
		*/
		
        //--------------------------------------------------
		
        this.entityID = this.getEntityId();
        
		this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        
        super.onUpdate();
        
        // Gets the machine status regardless of being ridden:
        this.previousStatus = this.status;
        this.status = this.getMachineStatus();
        
        // Logic for when this machine is being ridden:
        if (this.canPassengerSteer())
        {
        	this.initiateControlAirship();
        	
        	if (this.world.isRemote)
            {
        		this.initiateUpdateInputs();
        		this.initiateControlMachineGui();
        		this.initiateWeaponMachineGui();
            }
        	
        	this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }
        else
        {
        	this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }
        
        // :D Can touch this:
        this.doBlockCollisions();
        
        // Logic for multi-passenger use: (Currently not used yet)
        List<Entity> list = this.world.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntitySelectors.<Entity>getTeamCollisionPredicate(this));
        
        if (!list.isEmpty())
        {
            boolean flag = !this.world.isRemote && !(this.getControllingPassenger() instanceof EntityPlayer);
            
            for (int j = 0; j < list.size(); ++j)
            {
                Entity entity = (Entity)list.get(j);
                
                if (!entity.isPassenger(this))
                {
                	if (flag && this.getPassengers().size() < 2 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                    if (flag && this.getPassengers().size() < 1 && !entity.isRiding() && entity.width < this.width && entity instanceof EntityLivingBase && !(entity instanceof EntityWaterMob) && !(entity instanceof EntityPlayer))
                    {
                        entity.startRiding(this);
                    }
                    else
                    {
                        this.applyEntityCollision(entity);
                    }
                }
            }
        }
        
        this.reduceAmmoToMax();
        this.initiateCanGetStruckByLightning();
        this.initiateWeaponFiringCooldown();
        this.initiateEventTrigger();
        this.initiateDurabilityIssues();
    }
	
	/**
     * The main update method, upgrades and enhancements get applied here.
     */
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
        
        // Sets the machine to be fixed if broken and above 0 HP:
        if (this.getHealth() > 0
        && this.getBroken())
        {
        	this.setBroken(false);
        	this.isDead = false;
        }
        
        // Shuts off a machine if broken:
        if (this.getBroken() && this.getPoweredOn())
        {
        	this.setPoweredOn(false);
        }
        
        // Makes a broken machine smoke/bubble:
        if (this.world.isRemote)
        {
        	if (this.getBroken())
            {
        		this.spawnBrokenParticles();
            }
        }
        
        // Damages machines from environment status:
        if (!this.world.isRemote)
        {
        	this.damageMachineByStatus();
        }
    }
	
	/**
     * The main update method, behavior and custom update logic should go here.
     */
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
		//this.setVisualEngineDisplayType(2);
		//this.setVisualEngineDisplayItemstack(Items.ACACIA_BOAT.getIdFromItem(Items.ACACIA_BOAT));
        // As this machine exists, update the ticks:
		this.updateTick++;
		
		// Reset the updateTick every 10 minutes, just to be safe:
		//if (this.updateTick >= 12000)
		//{
		//	this.updateTick = 1;
		//}
    }
	
	
	
	//==================================================
    // TODO       Overrides from EntityLiving
	//==================================================
	
	/** Action performed when right-clicking a machine. */
	@Override
    protected boolean processInteract(EntityPlayer player, EnumHand hand)
    {
		// Needed to fix the auto pop up machine GUI bug:
		if (this.world.isRemote)
		{
			Keybinds.openGuiMenu.unPressAllKeys();
		}
		
		super.processInteract(player, hand);
		
		// Saving this for a later feature???:
        if (player.isSneaking())
        {
        	return false;
        }
        else
        {
            if (!this.world.isRemote)
            {
                player.startRiding(this);
            }
            //else
            //{
            //	GlStateManager.pushMatrix();
        	//	{
        	//		GlStateManager.scale(0.25F, 0.25F, 0.25F);
        			
        	//		Minecraft.getMinecraft().ingameGUI
        	//		//.setOverlayMessage("TEST", true);
        	//		.displayTitle("TEST1", "This is random", 100, 100, 100);
        	//	}
        	//	GlStateManager.popMatrix();
            //}
            
            return true;
        }
    }
	
	@Override
	@Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata)
    {
        return super.onInitialSpawn(difficulty, livingdata);
    }
	
	@Override
	public boolean attackEntityFrom(DamageSource source, float amount)
    {
		// Triggers the explosion when broken:
		if(!this.getBroken())
		{
			if ((this.getHealth() - amount) <= 0)
			{
				this.setEventTrigger(EnumsVM.EventTrigger.BROKEN.getMetadata());
				
				if (this.getDurability() >= 250)
				{
					this.setDurability(this.getDurability() - 250);
				}
				else
				{
					this.setDurability(0);
				}
			}
		}
		
		// Destroys the machine if it is out of the world:
		if (source == DamageSource.OUT_OF_WORLD)
		{
			this.setEventTrigger(EnumsVM.EventTrigger.DESTRUCTION.getMetadata());
		}
		
		// Destroys the machine if it is out of the world:
		//if (source == DamageSource.LIGHTNING_BOLT)
		//{
			//this.setEventTrigger(EnumsVM.EventTrigger.LIGHTNING_STRIKE.getMetadata());
		//}
		
		
		
		// Destroys the machine if it is broken and is hit with explosion damage:
		if (this.getBroken())
		{
			if (source.isExplosion())
			{
				if (!this.world.isRemote)
		        {
		            if (this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot"))
		            {
		                boolean flag = this.recentlyHit > 0;
		                this.dropLoot(flag, 0, source);
		            }
		        }
				
				this.setEventTrigger(EnumsVM.EventTrigger.DESTRUCTION.getMetadata());
			}
		}
		
        Entity entity = source.getTrueSource();
        return this.isBeingRidden() && entity != null && this.isRidingOrBeingRiddenBy(entity) ? false : super.attackEntityFrom(source, amount);
    }
	
	@Override
	public boolean canRiderInteract()
    {
        return false;
    }
	
	@Override
	public boolean shouldDismountInWater(Entity rider)
    {
        return false;
    }
	
	@Override
	public boolean canBreatheUnderwater()
    {
        return true;
    }
	
	@Override
	protected boolean canDespawn()
    {
        return false;
    }
    
    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }
    
    @Override
    public boolean canBePushed()
    {
        return false;
    }
    
    @Override
	public boolean isPushedByWater() 
    {
        return true;
    }
    
    @Override
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
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
	public boolean canBeSteered()
    {
        return this.getControllingPassenger() instanceof EntityLivingBase;
    }
    
    @Override
    @Nullable
    public Entity getControllingPassenger()
    {
        List<Entity> list = this.getPassengers();
        
        return list.isEmpty() ? null : (Entity)list.get(0);
    }
    
    @Override
    protected boolean canFitPassenger(Entity passenger)
    {
        return this.getPassengers().size() < 1;
    }
    
    @Override
    public void updatePassenger(Entity passenger)
    {
    	super.updatePassenger(passenger);
    	
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
    
    /** Applies this boat's yaw to the given entity. Used to update the orientation of its passenger. */
    protected void applyYawToEntity(Entity entityToUpdate)
    {
        entityToUpdate.setRenderYawOffset(this.rotationYaw);
        float f = MathHelper.wrapDegrees(entityToUpdate.rotationYaw - this.rotationYaw);
        float f1 = MathHelper.clamp(f, 
        		//-105.0F, 105.0F
        		-85.0F, 85.0F
        		);
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
    public EnumFacing getAdjustedHorizontalFacing()
    {
        return this.getHorizontalFacing().rotateY();
    }
    
	@Override
	public boolean canBeHitWithPotion()
    {
        return false;
    }
    
    @Override
    public boolean attackable()
    {
        return true;
    }
    
	@Override
	public int getMaxFallHeight()
    {
        return 0;
    }
    
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
		int currentPosY = 0;
		
		if (this.status == Status.IN_AIR)
		{
			if (!this.getPoweredOn())
			{
				if (this.fallDistancePosY == 0)
				{
					this.fallDistancePosY = (int)this.posY;
				}
			}
			
			if (this.getPoweredOn())
			{
				this.fallDistancePosY = 0;
			}
		}
		
		if (this.status == Status.ON_LAND	
		&& this.previousStatus == Status.IN_AIR)
		{
			this.fallDistancePosY = (int) (this.fallDistancePosY - this.posY);
			
			if(this.fallDistancePosY >= 6)
			{
				this.setEventTrigger(EnumsVM.EventTrigger.FALL.getMetadata());
			}
		}
    }
	
	/** Was used to calculate fall damage. */
	@Override
	public void fall(float distance, float damageMultiplier)
    {
		
    }
	
    
	
	//==================================================
    // TODO              GUI Logic
	//==================================================
	
    /** Opens the machine GUI on button press. */
    @SideOnly(Side.CLIENT)
    protected void initiateControlMachineGui()
    {
    	if (this.openGuiMenuInputDown 
    	&& this.getControllingPassenger() != null)
		{
    		NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
        	//Minecraft.getMinecraft().setIngameFocus();
        }
    }
    
    /** Shoots a projectile on button press. */
    @SideOnly(Side.CLIENT)
    protected void initiateWeaponMachineGui()
    {
    	if (this.shootProjectileInputDown 
    	&& this.getControllingPassenger() != null
    	&& this.weaponCooldown >= this.weaponFiringCooldownTicks(this.getAmmoType()))
		{
    		if (this.getControllingPassenger() instanceof EntityPlayer)
    		{
    			EntityPlayer player = (EntityPlayer) this.getControllingPassenger();
	    		
	    		if (this.getArmed())
	    		{
	    			if (this instanceof EntityMachineGround)
	    			{
	    				Loghelper.info("This is using a ground weapon!");
	    				
	    				//NetworkHandler.sendToServer(new MessageMachineProjectileShoot());
		    			
		    			this.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F);
		    			
		    			this.weaponCooldown = 0;
	    			}
	    			
	    			if (this instanceof EntityMachineWater)
	    			{
	    				Loghelper.info("This is using a water weapon!");
	    				
	    				//NetworkHandler.sendToServer(new MessageMachineProjectileShoot());
		    			
		    			this.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F);
		    			
		    			this.weaponCooldown = 0;
	    			}
	    			
	    			if (this instanceof EntityMachineFlying)
	    			{
	    				Loghelper.info("This is using a flying weapon!");
	    				
	    				NetworkHandler.sendToServer(new MessageMachineFlyingBombStandard());
		    			
		    			this.playSound(SoundEvents.ITEM_FIRECHARGE_USE, 1.0F, 1.0F);
		    			
		    			this.weaponCooldown = 0;
	    			}
	    			
	    			
	    			
	    			
	    			
	    			
	    			if (this.getAmmoAmount() == 0
					&& !player.isCreative())
	    			{
	    				NetworkHandler.sendToServer(new PlayerMessageWeaponSystemOutOfAmmo());
	    			}
	    		}
	    		else
	    		{
	    			this.playSound(SoundEvents.BLOCK_WOOD_BUTTON_CLICK_ON, 1.0F, 1.0F);
	    			
	    			NetworkHandler.sendToServer(new PlayerMessageWeaponSystemError());
	    		}
    		}
        }
    }
    
    
    
	//==================================================
    // TODO           Particles Logic
	//==================================================
    
    /** Particles that spawn when a machine is broken. */
    @SideOnly(Side.CLIENT)
    protected void spawnBrokenParticles()
    {
    	if (this.status == this.status.ON_LAND
    	|| this.status == this.status.IN_AIR)
    	{
			InitParticlesVMRender.generateParticlesBrokenSmoke(this);
    	}
    	
    	if (this.status == this.status.IN_WATER)
    	{
    		InitParticlesVMRender.generateParticlesBrokenSmoke(this);
    		InitParticlesVMRender.generateParticlesBrokenBubbles(this);
    		InitParticlesVMRender.generateParticlesBrokenWakes(this);
    	}
    	
    	if (this.status == this.status.UNDER_WATER
    	|| this.status == this.status.UNDER_FLOWING_WATER)
    	{
    		InitParticlesVMRender.generateParticlesBrokenBubbles(this);
    		InitParticlesVMRender.generateParticlesBrokenWakes(this);
    	}
    }
    
    //--------------------------------------------------
    
    /** Particles that spawn when a machine takes damage. */
    @SideOnly(Side.CLIENT)
    public void spawnInjuredParticles()
    {
    	for (int i = 0; i < 20; i++)
		{
			InitParticlesVMRender.generateParticlesExplosions(this);
		}
    }
    
    //--------------------------------------------------
    
    /** Particles that spawn when a machine falls and hits the ground. */
    @SideOnly(Side.CLIENT)
    public void spawnFallParticles()
    {
    	for (int i = 0; i < 20; i++)
		{
			InitParticlesVMRender.generateParticlesExplosions(this);
		}
    }
    
    /** Particles that spawn when a machine changes to broken. */
    @SideOnly(Side.CLIENT)
    public void spawnInitialBrokenParticles()
    {
    	for (int i = 1; i < 80; i++)
    	{
	    	if (this.status == this.status.ON_LAND
	    	|| this.status == this.status.IN_AIR)
	    	{
	    		this.world.spawnParticle(EnumParticleTypes.LAVA, true, this.posX, this.posY, this.posZ, 0, 0, 0, new int[0]);
	    	}
	    	
	    	if (this.status == this.status.IN_WATER
	    	|| this.status == this.status.UNDER_WATER
	    	|| this.status == this.status.UNDER_FLOWING_WATER)
	    	{
	    		this.world.spawnParticle(EnumParticleTypes.LAVA, true, this.posX, this.posY, this.posZ, 0, 0, 0, new int[0]);
	    	}
    	}
    }
    
    /** Particles that spawn when a machine is struck by lightning. */
    @SideOnly(Side.CLIENT)
    public void spawnLightningStrikeParticles()
    {
    	for (int i = 0; i < 100; i++)
		{
			InitParticlesVMRender.generateParticleStaticChargeLightningStrike(this);
			InitParticlesVMRender.generateParticleStaticChargeLightningStrike(this);
			InitParticlesVMRender.generateParticleStaticChargeLightningStrike(this);
			InitParticlesVMRender.generateParticleStaticChargeLightningStrike(this);
		}
    }
    
    /** Particles that spawn when a machine's health is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealHealthParticles1()
    {
    	for (int i = 0; i < 10; i++)
		{
    		InitParticlesVMRender.generateHealHealthParticles(this);
		}
    }
    /** Particles that spawn when a machine's health is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealHealthParticles2()
    {
    	for (int i = 0; i < 25; i++)
		{
    		InitParticlesVMRender.generateHealHealthParticles(this);
		}
    }
    /** Particles that spawn when a machine's health is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealHealthParticles3()
    {
    	for (int i = 0; i < 50; i++)
		{
    		InitParticlesVMRender.generateHealHealthParticles(this);
		}
    }
    
    /** Particles that spawn when a machine's energy is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealEnergyParticles1()
    {
    	for (int i = 0; i < 10; i++)
		{
    		InitParticlesVMRender.generateHealEnergyParticles(this);
		}
    }
    /** Particles that spawn when a machine's energy is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealEnergyParticles2()
    {
    	for (int i = 0; i < 25; i++)
		{
    		InitParticlesVMRender.generateHealEnergyParticles(this);
		}
    }
    /** Particles that spawn when a machine's energy is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealEnergyParticles3()
    {
    	for (int i = 0; i < 50; i++)
		{
    		InitParticlesVMRender.generateHealEnergyParticles(this);
		}
    }
    
    /** Particles that spawn when a machine's durability is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealDurabilityParticles1()
    {
    	for (int i = 0; i < 10; i++)
		{
    		InitParticlesVMRender.generateHealDurabilityParticles(this);
		}
    }
    /** Particles that spawn when a machine's durability is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealDurabilityParticles2()
    {
    	for (int i = 0; i < 25; i++)
		{
    		InitParticlesVMRender.generateHealDurabilityParticles(this);
		}
    }
    /** Particles that spawn when a machine's durability is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnHealDurabilityParticles3()
    {
    	for (int i = 0; i < 50; i++)
		{
    		InitParticlesVMRender.generateHealDurabilityParticles(this);
		}
    }
    
    /** Particles that spawn when a machine's ammo is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnAmmoParticles1()
    {
    	for (int i = 0; i < 10; i++)
		{
			InitParticlesVMRender.generateAmmoParticles(this);
		}
    }
    
    /** Particles that spawn when a machine's ammo is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnAmmoParticles2()
    {
    	for (int i = 0; i < 25; i++)
		{
			InitParticlesVMRender.generateAmmoParticles(this);
		}
    }
    
    /** Particles that spawn when a machine's ammo is healed. */
    @SideOnly(Side.CLIENT)
    public void spawnAmmoParticles3()
    {
    	for (int i = 0; i < 50; i++)
		{
			InitParticlesVMRender.generateAmmoParticles(this);
		}
    }
    
    /** Particles that spawn when a machine is upgraded. */
    @SideOnly(Side.CLIENT)
    public void spawnUpgradeParticles1()
    {
    	for (int i = 0; i < 10; i++)
		{
			InitParticlesVMRender.generateUpgradeParticles(this);
		}
    }
    
    /** Particles that spawn when a machine is upgraded. */
    @SideOnly(Side.CLIENT)
    public void spawnUpgradeParticles2()
    {
    	for (int i = 0; i < 25; i++)
		{
			InitParticlesVMRender.generateUpgradeParticles(this);
		}
    }
    
    /** Particles that spawn when a machine is upgraded. */
    @SideOnly(Side.CLIENT)
    public void spawnUpgradeParticles3()
    {
    	for (int i = 0; i < 50; i++)
		{
			InitParticlesVMRender.generateUpgradeParticles(this);
		}
    }
	
    
	
	//==================================================
    // TODO              Sound Events
	//==================================================
	
	/** Gets the sound to be triggered when a machine is damaged. */
	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
		SoundEvent soundIn = SoundEvents.BLOCK_ANVIL_BREAK;
		
		if (this.status == this.status.ON_LAND
    	|| this.status == this.status.IN_AIR)
    	{
			soundIn = SoundEvents.BLOCK_PISTON_CONTRACT;
    	}
    	
		if (this.status == this.status.IN_WATER
    	|| this.status == this.status.UNDER_WATER
    	|| this.status == this.status.UNDER_FLOWING_WATER)
    	{
			soundIn = SoundEvents.ENTITY_BOBBER_SPLASH;
    	}
		
		return soundIn;
    }
	
	/** Gets the sound to be triggered when a machine hits the ground while falling and off. */
	@Override
	@SideOnly(Side.CLIENT)
    protected SoundEvent getFallSound(int heightIn)
    {
        return SoundEvents.ENTITY_GENERIC_BIG_FALL;
    }
	
	/** Gets the sound to be triggered when a machine is broken. */
	@Override
	@Nullable
	@SideOnly(Side.CLIENT)
    protected SoundEvent getDeathSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }
	
	/** Gets the sound to be triggered when a machine is broken. */
	protected SoundEvent getBrokenSound()
    {
        return SoundEvents.ENTITY_GENERIC_EXPLODE;
    }
	
	/** Gets the sound to be triggered when a machine is broken. */
	protected SoundEvent getInjuredSound()
    {
        return SoundEvents.BLOCK_PISTON_EXTEND;
    }
	
	/** Gets the sound to be triggered when a machine is struck by lightning. */
	protected SoundEvent getLightningStrikeSound()
    {
        return SoundEvents.BLOCK_ANVIL_LAND;
    }
	
	/** Gets the sound to be triggered when a machine's Tier is upgraded. */
	protected SoundEvent getUpgradeSound()
    {
        return SoundsVM.UPGRADE;
    }
	
	/** Gets the sound to be triggered when a machine's health is healed. */
	public SoundEvent getHealHealthSound()
    {
        return SoundsVM.HEAL;
    }
	
	/** Gets the sound to be triggered when a machine's energy is healed. */
	protected SoundEvent getHealEnergySound()
    {
        return SoundsVM.HEAL;
    }
	
	/** Gets the sound to be triggered when a machine's durability is healed. */
	protected SoundEvent getHealDurabilitySound()
    {
        return SoundsVM.HEAL;
    }
	
	/** Gets the sound to be triggered when a machine's ammo is healed. */
	protected SoundEvent getHealAmmoSound()
    {
        return SoundsVM.HEAL;
    }
    
    
    
	//==================================================
    // TODO            Input Updates
	//==================================================
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, Boats, and Machines are generally "steered" by the controlling passenger.
     */
    @SideOnly(Side.CLIENT)
    public void initiateUpdateInputs()
    {
    	this.leftInputDown = Keybinds.moveLeft.isKeyDown();
        this.rightInputDown = Keybinds.moveRight.isKeyDown();
        this.forwardInputDown = Keybinds.moveForward.isKeyDown();
        this.backInputDown = Keybinds.moveBack.isKeyDown();
        this.upInputDown = Keybinds.moveUp.isKeyDown();
        this.downInputDown = Keybinds.moveDown.isKeyDown();
        this.openGuiMenuInputDown = Keybinds.openGuiMenu.isPressed();
        this.shootProjectileInputDown = Keybinds.shootProjectile.isPressed();
        this.toggleAbilityInputDown = Keybinds.toggleAbility.isPressed();
    }
	
	
	
	//==================================================
    // TODO             Death Events
	//==================================================
	
	@Override
	public void onDeath(DamageSource cause)
    {
    	//super.onDeath(cause);
    	
    	this.setBroken(true);
    	this.setPoweredOn(false);
    	this.setAutorun(false);
    	this.setArmed(false);
    }
	
	@Override
	public void onKillCommand()
    {
        
    }
	
	@Override
	public void setDead()
    {
		if (this.getEventTrigger() == EnumsVM.EventTrigger.DESTRUCTION.getMetadata())
		{
			super.setDead();
		}
		//this.entityDropItem(this.getItemMachine(), 1);
		//super.setDead();
		// Remove the thing that caused a dead entity to be removed:
        //this.isDead = true;
		
		//if (this.getBroken())
		//{
			
		//	if (this.attackEntityFrom(DamageSource.OUT_OF_WORLD, 0.0F))
		//	{
		//		this.isDead = true;
		//		LogHelper.info("DEAD!");
		//	}
		//}
		
		
		//if (!this.world.isRemote)
        //{
            
        //    if (this.canDropLoot() && this.world.getGameRules().getBoolean("doMobLoot"))
        //    {
        //        boolean flag = this.recentlyHit > 0;
                //this.dropLoot(flag, 0, source);
        //    }
        //}
    }
	
	
	
	//==================================================
    // TODO              Leash Events
	//==================================================
	
	/** Applies logic related to leashes, for example dragging the entity or breaking the leash. */
    @Override
    protected void updateLeashedState()
    {
        super.updateLeashedState();

        if (this.getLeashed() && this.getLeashHolder() != null && this.getLeashHolder().world == this.world)
        {
            Entity entity = this.getLeashHolder();
            this.setHomePosAndDistance(new BlockPos((int)entity.posX, (int)entity.posY, (int)entity.posZ), 5);
            float f = this.getDistance(entity);

            //if (this instanceof EntityTameable && ((EntityTameable)this).isSitting())
            //{
            //    if (f > 10.0F)
            //    {
            //        this.clearLeashed(true, true);
            //    }
            //
            //    return;
            //}

            this.onLeashDistance(f);

            if (f > 10.0F)
            {
                this.clearLeashed(true, true);
                this.tasks.disableControlFlag(1);
            }
            else if (f > 6.0F)
            {
                double d0 = (entity.posX - this.posX) / (double)f;
                double d1 = (entity.posY - this.posY) / (double)f;
                double d2 = (entity.posZ - this.posZ) / (double)f;
                this.motionX += d0 * Math.abs(d0) * 0.4D;
                this.motionY += d1 * Math.abs(d1) * 0.4D;
                this.motionZ += d2 * Math.abs(d2) * 0.4D;
            }
            else
            {
                this.tasks.enableControlFlag(1);
                float f1 = 2.0F;
                Vec3d vec3d = (new Vec3d(entity.posX - this.posX, entity.posY - this.posY, entity.posZ - this.posZ)).normalize().scale((double)Math.max(f - 2.0F, 0.0F));
                this.getNavigator().tryMoveToXYZ(this.posX + vec3d.x, this.posY + vec3d.y, this.posZ + vec3d.z, this.followLeashSpeed());
            }
        }
    }
    
    /** If the entity got a PathEntity it returns true, else false. */
    public boolean hasPath()
    {
        return !this.navigator.noPath();
    }

    public boolean isWithinHomeDistanceCurrentPosition()
    {
        return this.isWithinHomeDistanceFromPosition(new BlockPos(this));
    }

    public boolean isWithinHomeDistanceFromPosition(BlockPos pos)
    {
        if (this.maximumHomeDistance == -1.0F)
        {
            return true;
        }
        else
        {
            return this.homePosition.distanceSq(pos) < (double)(this.maximumHomeDistance * this.maximumHomeDistance);
        }
    }

    /** Sets home position and max distance for it. */
    public void setHomePosAndDistance(BlockPos pos, int distance)
    {
        this.homePosition = pos;
        this.maximumHomeDistance = (float)distance;
    }

    public BlockPos getHomePosition()
    {
        return this.homePosition;
    }

    public float getMaximumHomeDistance()
    {
        return this.maximumHomeDistance;
    }

    public void detachHome()
    {
        this.maximumHomeDistance = -1.0F;
    }

    /** Returns whether a home area is defined for this entity. */
    public boolean hasHome()
    {
        return this.maximumHomeDistance != -1.0F;
    }

    protected double followLeashSpeed()
    {
        return 1.0D;
    }

    protected void onLeashDistance(float distanceIn)
    {
    }
    
    public boolean canBeLeashedTo(EntityPlayer player)
    {
        return super.canBeLeashedTo(player) && this.getCreatureAttribute() != EnumCreatureAttribute.UNDEAD;
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
    
    /** Translates inputs to motion modifiers. */
    public void initiateControlAirship()
    {
    	// Sync the forward speed based off of engine tier:
    	this.getMaxForwardSpeed();
    	// Sync the turn speed based off of engine tier:
    	this.getMaxTurnSpeed();
    	
    	if (this.isBeingRidden())
        {
            float f = 0.0F;
            
            if (this.getBroken()
            || !this.getPoweredOn())
    		{
        		
    		}
    		else
			{
    			// Turn Left:
	            if (this.leftInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						this.deltaRotation -= this.getTurnSpeed();
						}
    					else
    					{
    						this.deltaRotation -= 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation -= (float) this.getTurnSpeed();
    				}
	            }
	            
	            // Turn Right:
	            if (this.rightInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
	            		if (this.isFuelBurning())
    					{
    						this.deltaRotation += (float) this.getTurnSpeed();
    					}
    					else
    					{
    						this.deltaRotation += 0.05D;
    					}
            		}
    				else
    				{
    					this.deltaRotation += (float) this.getTurnSpeed();
    				}
	            }
	            
	            // Left or Right, with Forward and no Backward:
	            if (this.rightInputDown != this.leftInputDown 
        		&& this.forwardInputDown 
        		&& !this.backInputDown)
	            {
	            	if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						f += (float) this.getForwardSpeed();//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					f += (float) this.getForwardSpeed();//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    				}
	            }
	            
	            // Left or Right, with Backward and no Forward:
	            if (this.rightInputDown != this.leftInputDown 
        		&& !this.forwardInputDown 
        		&& this.backInputDown)
	            {
		            if (this.isFuelNeeded())
					{
						if (this.isFuelBurning())
						{
							f -= (float) this.getForwardSpeed() * 0.5;//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
						}
						else
						{
							
						}
	        		}
					else
					{
						f -= (float) this.getForwardSpeed() * 0.5;//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
					}
	            }
	            
	            this.rotationYaw += this.deltaRotation;
	            
	            // Move Forwards with no left and no right:
	        	if (this.forwardInputDown 
        		&& !this.rightInputDown 
        		&& !this.leftInputDown)
	            {
	        		if (this.isFuelNeeded())
    				{
        				if (this.isFuelBurning())
    					{
        					// Initiates the autorun trigger.
            				if (this.getAutorun())
            				{
            					this.autorunTrigger = true;
            				}
            				else
            				{
            					f += (float) this.getForwardSpeed();//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
            				}
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					// Initiates the autorun trigger.
    					if (this.getAutorun())
        				{
        					this.autorunTrigger = true;
        				}
    					else
    					{
    						f += (float) this.getForwardSpeed();//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
    					}
    				}
	            }
	        	
	        	// Applies autorun:
	        	if (this.getAutorun()
	        	&& this.autorunTrigger)
				{
					f += (float) this.getForwardSpeed();//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue();
				}
	        	
	        	// Move Backwards with no left and no right:
	        	if (this.backInputDown 
        		&& !this.rightInputDown 
        		&& !this.leftInputDown)
	            {
	        		// Handles canceling autorun:
	        		if (this.autorunTrigger)
	        		{
	        			this.autorunTrigger = false;
	        		}
	        		
	        		if (this.isFuelNeeded())
    				{
    					if (this.isFuelBurning())
    					{
    						f -= (float) this.getForwardSpeed() * 0.5;//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
    					}
    					else
    					{
    						
    					}
            		}
    				else
    				{
    					f -= (float) this.getForwardSpeed() * 0.5;//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue() * 0.5;
    				}
	            }
			}
            
            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            
            this.rotationPitch += 10;
        }
    }
    
    /**
     * Main movement logic. Responsible for applying motion to move machines. Used with all EntityLiving AI.
     */
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
    	//this.initiateControlAirship();
    	// Main movement logic:
    	if (this.canPassengerSteer()) 
        {
    		//this.rotationYaw = this.getControllingPassenger().rotationYaw;
            
            //this.rotationPitch = this.getControllingPassenger().rotationPitch;
    		
            
            
            /**
    		EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
            
            this.rotationYaw = entitylivingbase.rotationYaw;
            this.prevRotationYaw = this.rotationYaw;
            this.rotationPitch = entitylivingbase.rotationPitch * 0.5F;*/
            //this.setRotation(this.rotationYaw, this.rotationPitch);
    		
    		//EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
            //entitylivingbase.rotationYaw = this.rotationYaw;
    		
    		
    		
    		
    		// This crashed the server...
    		if (this.world.isRemote)
    		{
    			this.applyOrientationToEntity(this);
    			
    			
    			//this.rotationPitch = this.getRidingEntity().rotationPitch;
    			
    			EntityLivingBase entitylivingbase = (EntityLivingBase)this.getControllingPassenger();
                
    			this.rotationPitch = entitylivingbase.rotationPitch;
    			
    			this.rotationYawHead = entitylivingbase.rotationYawHead;
    			
    			
    			//this.turn(this.rotationYaw, this.rotationPitch);
    		}
    		
    		
    		
    		this.momentum = 0.8999999761581421D;
    		this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
            
	    	this.moveRelative(strafe, vertical, forward, 0.0000001F);
	        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	        this.motionX *= this.momentum;
	        this.motionY *= this.momentum;
	        this.motionZ *= this.momentum;
	        this.deltaRotation *= this.momentum;
        }
    	
    	
    	
    	
    	
    	// Keep for reference:
    	if (this.isBeingRidden() && this.canBeSteered())
        {
    		
        }
    	
/**
    	// Machine upward motion while in water:
    	if (this.status == this.status.UNDER_WATER
		|| this.status == this.status.UNDER_FLOWING_WATER)
		{
    		this.motionY = 0.05D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    	*/
    	
    	// Machine upward motion while in lava:
    	if (this.status == this.status.UNDER_LAVA
		|| this.status == this.status.UNDER_FLOWING_LAVA)
		{
    		this.motionY = 0.015D;
	        	
			this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		}
    }
    
    
    
	//==================================================
    // TODO               Data Logic
	//==================================================
    
    @Override
    public void setHealth(float health)
    {
    	this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(EnumsVM.FlyingMachineFrameTier.byId(this.getTierFrame()).getMaxHealthModifier());
        
        super.setHealth(health);
    }
    
    /** Gets the max health value of a machine. */
    public final float getMachineMaxHealth()
    {
        return EnumsVM.FlyingMachineFrameTier.byId(this.getTierFrame()).getMaxHealthModifier();
    }
    
    @Override
    public void heal(float healAmount)
    {
        super.heal(healAmount);
    }
    
    /** Get the health in a % format. */
    public int getHealthPercent()
    {
    	float total = this.getMaxHealth();
		float current = this.getHealth();
		float percentHealth = ((total - (total-current )) / total) * 100;
		
		return (int) percentHealth;
    }
    
    //--------------------------------------------------
    
    /** Gets the energy value of a machine. */
    public final int getEnergy()
    {
        return ((Integer)this.dataManager.get(ENERGY_DM)).intValue();
    }
    /** Sets the energy value of a machine. */
    public void setEnergy(int intIn)
    {
    	this.dataManager.set(ENERGY_DM, MathHelper.clamp(intIn, 0, this.getMaxEnergy()));
    }
    
    /** Gets the max energy value of a machine. */
    public int getMaxEnergy()
    {
    	return EnumsVM.FlyingMachineFrameTier.byId(this.getTierFrame()).getMaxEnergyModifier();
    }
    
    /** Replenish a machine's energy points. */
    public void replenishEnergy(int healAmount)
    {
        if (healAmount <= 0)
    	{
    		return;
    	}
        
        int f = this.getEnergy();

        if ((f + healAmount) <= this.getMaxEnergy())
        {
        	this.setEnergy(f + healAmount);
        }
    }
    
    /** Get the energy in a % format. */
    public int getEnergyPercent()
    {
    	float total = this.getMaxEnergy();
		float current = this.getEnergy();
		float percentEnergy = ((total - (total-current )) / total) * 100;
		
		return (int) percentEnergy;
    }
    
    //--------------------------------------------------
    
    /** Gets the durability value of a machine. */
    public final int getDurability()
    {
        return ((Integer)this.dataManager.get(DURABILITY_DM)).intValue();
    }
    /** Sets the durability value of a machine. */
    public void setDurability(int intIn)
    {
    	this.dataManager.set(DURABILITY_DM, MathHelper.clamp(intIn, 0, this.getMaxDurability()));
    }
    
    /** Gets the max durability value of a machine. */
    public int getMaxDurability()
    {
    	return EnumsVM.FlyingMachineFrameTier.byId(this.getTierFrame()).getMaxDurabilityModifier();
    }
    
    /** Replenish a machine's durability points. */
    public void replenishDurability(int healAmount)
    {
        if (healAmount <= 0)
    	{
    		return;
    	}
        
        int f = this.getDurability();

        if ((f + healAmount) <= this.getMaxDurability())
        {
        	this.setDurability(f + healAmount);
        }
    }
    
    /** Get the durability in a % format. */
    public int getDurabilityPercent()
    {
    	float total = this.getMaxDurability();
		float current = this.getDurability();
		float percentDurability = ((total - (total-current )) / total) * 100;
		
		return (int) percentDurability;
    }
    
    
    //--------------------------------------------------
    
    /** Gets the Frame tier. */
    public final int getTierFrame()
    {
        return ((Integer)this.dataManager.get(TIER_FRAME_DM)).intValue();
    }
    /** Sets the Frame tier. */
    public void setTierFrame(int intIn)
    {
        this.dataManager.set(TIER_FRAME_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Engine tier. */
    public final int getTierEngine()
    {
        return ((Integer)this.dataManager.get(TIER_ENGINE_DM)).intValue();
    }
    /** Sets the Engine tier. */
    public void setTierEngine(int intIn)
    {
        this.dataManager.set(TIER_ENGINE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Component tier. */
    public final int getTierComponent()
    {
        return ((Integer)this.dataManager.get(TIER_COMPONENT_DM)).intValue();
    }
    /** Sets the Component tier. */
    public void setTierComponent(int intIn)
    {
        this.dataManager.set(TIER_COMPONENT_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the type. (Hovercraft, Submarine, Airship, etc.) */
    //public final int getType()
    //{
    //    return ((Integer)this.dataManager.get(TYPE_DM)).intValue();
    //}
    /** Sets the type. (Hovercraft, Submarine, Airship, etc.) */
    //public void setType(int intIn)
    //{
    //    this.dataManager.set(TYPE_DM, Integer.valueOf(intIn));
    //}
    
    //--------------------------------------------------
    
    /** Gets the Forward Speed. */
    protected final float getForwardSpeed()
    {
        return ((Float)this.dataManager.get(FORWARD_SPEED_DM)).floatValue();
    }
    /** Sets the Forward Speed. */
    protected void setForwardSpeed(float floatIn)
    {
        this.dataManager.set(FORWARD_SPEED_DM, Float.valueOf(floatIn));
    }
    
    /** Gets the Max Forward Speed. */
    protected final void getMaxForwardSpeed()
    {
    	this.setForwardSpeed((Float)EnumsVM.FlyingMachineEngineTier.byId(this.getTierEngine()).getFowardSpeedModifier());
    }
    
    //--------------------------------------------------
    
    /** Gets the Turn Speed. */
    protected final float getTurnSpeed()
    {
        return ((Float)this.dataManager.get(TURN_SPEED_DM)).floatValue();
    }
    /** Sets the Turn Speed. */
    protected void setTurnSpeed(float floatIn)
    {
        this.dataManager.set(TURN_SPEED_DM, Float.valueOf(floatIn));
    }
    
    /** Gets the Max Turn Speed. */
    protected final void getMaxTurnSpeed()
    {
    	this.setTurnSpeed((Float)EnumsVM.FlyingMachineEngineTier.byId(this.getTierEngine()).getTurnSpeedModifier());
    }
    
    //--------------------------------------------------
    
    /** Gets the Broken Machine boolean. */
    public final boolean getBroken()
    {
        return ((Boolean)this.dataManager.get(BROKEN_DM)).booleanValue();
    }
    /** Sets the Broken Machine boolean. */
    public void setBroken(boolean booleanIn)
    {
        this.dataManager.set(BROKEN_DM, Boolean.valueOf(booleanIn));
    }
    
    /** Gets the Powered On boolean. */
    public final boolean getPoweredOn()
    {
        return ((Boolean)this.dataManager.get(POWERED_ON_DM)).booleanValue();
    }
    /** Sets the Powered On boolean. */
    public void setPoweredOn(boolean booleanIn)
    {
        this.dataManager.set(POWERED_ON_DM, Boolean.valueOf(booleanIn));
    }
    
    /** Gets the Autorun boolean. */
    public final boolean getAutorun()
    {
        return ((Boolean)this.dataManager.get(AUTORUN_DM)).booleanValue();
    }
    /** Sets the Autorun boolean. */
    public void setAutorun(boolean booleanIn)
    {
        this.dataManager.set(AUTORUN_DM, Boolean.valueOf(booleanIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the Armed Machine boolean. */
    public final boolean getArmed()
    {
        return ((Boolean)this.dataManager.get(ARMED_DM)).booleanValue();
    }
    /** Sets the Armed Machine boolean. */
    public void setArmed(boolean booleanIn)
    {
        this.dataManager.set(ARMED_DM, Boolean.valueOf(booleanIn));
    }

    /** Gets the ammo amount. */
    public final int getAmmoAmount()
    {
        return ((Integer)this.dataManager.get(AMMO_AMOUNT_DM)).intValue();
    }
    /** Sets the ammo amount. */
    public void setAmmoAmount(int intIn)
    {
        this.dataManager.set(AMMO_AMOUNT_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Max Ammo amount. */
    public final int getMaxAmmoAmount()
    {
    	return EnumsVM.FlyingMachineComponentTier.byId(this.getTierComponent()).getMaxAmmoModifier();
    }
    
    /** Gets the ammo type. */
    public final int getAmmoType()
    {
        return ((Integer)this.dataManager.get(AMMO_TYPE_DM)).intValue();
    }
    /** Sets the ammo type. */
    public void setAmmoType(int intIn)
    {
        this.dataManager.set(AMMO_TYPE_DM, Integer.valueOf(intIn));
    }
    
    //----------------------------------------------------
    
    /** Gets the selected record. */
    public final int getSelectedRecord()
    {
        return ((Integer)this.dataManager.get(SELECTED_RECORD_DM)).intValue();
    }
    /** Sets the selected record. */
    public void setSelectedRecord(int intIn)
    {
        this.dataManager.set(SELECTED_RECORD_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Learned Record Slot 1 Song. */
    public final String getLearnedRecordSlot1()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_1_DM));
    }
    /** Sets the Learned Record Slot 1 Song. */
    public void setLearnedRecordSlot1(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_1_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 2 Song. */
    public final String getLearnedRecordSlot2()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_2_DM));
    }
    /** Sets the Learned Record Slot 2 Song. */
    public void setLearnedRecordSlot2(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_2_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 3 Song. */
    public final String getLearnedRecordSlot3()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_3_DM));
    }
    /** Sets the Learned Record Slot 3 Song. */
    public void setLearnedRecordSlot3(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_3_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 4 Song. */
    public final String getLearnedRecordSlot4()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_4_DM));
    }
    /** Sets the Learned Record Slot 4 Song. */
    public void setLearnedRecordSlot4(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_4_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 5 Song. */
    public final String getLearnedRecordSlot5()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_5_DM));
    }
    /** Sets the Learned Record Slot 5 Song. */
    public void setLearnedRecordSlot5(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_5_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 6 Song. */
    public final String getLearnedRecordSlot6()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_6_DM));
    }
    /** Sets the Learned Record Slot 6 Song. */
    public void setLearnedRecordSlot6(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_6_DM, String.valueOf(stringIn));
    }
    
    /** Gets the Learned Record Slot 7 Song. */
    public final String getLearnedRecordSlot7()
    {
        return ((String)this.dataManager.get(LEARNED_RECORD_SLOT_7_DM));
    }
    /** Sets the Learned Record Slot 7 Song. */
    public void setLearnedRecordSlot7(String stringIn)
    {
        this.dataManager.set(LEARNED_RECORD_SLOT_7_DM, String.valueOf(stringIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the machine enhancement 1. */
    public final int getMachineEnhancement1()
    {
        return ((Integer)this.dataManager.get(MACHINE_ENHANCEMENT_1_DM)).intValue();
    }
    /** Sets the machine enhancement 1. */
    public void setMachineEnhancement1(int intIn)
    {
        this.dataManager.set(MACHINE_ENHANCEMENT_1_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the primed for lightning strike in ticks. */
    public final int getPrimedForLightningStrike()
    {
        return ((Integer)this.dataManager.get(PRIMED_FOR_LIGHTNING_STRIKE_DM)).intValue();
    }
    /** Sets the primed for lightning strike in ticks. */
    public void setPrimedForLightningStrike(int intIn)
    {
        this.dataManager.set(PRIMED_FOR_LIGHTNING_STRIKE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Issue Tick in ticks. */
    public final int getIssueTick()
    {
        return ((Integer)this.dataManager.get(MACHINE_ISSUE_DM)).intValue();
    }
    /** Sets the Issue Tick in ticks. */
    public void setIssueTick(int intIn)
    {
        this.dataManager.set(MACHINE_ISSUE_DM, Integer.valueOf(intIn));
    }
    
    /**
	 * Keeps track of the event to be triggered. <br> <br>
	 *
	 *  0 = No event to trigger.<br>
	 *  1 = Trigger fall sound/particles. <br>
	 *  2 = Trigger broken sound/particles. <br>
	 *  3 = Trigger destruction logic. <br>
	 *  4 = Trigger lightning strike sound/particles. <br><br>
	 *  
	 *  11 = Triggers 2 health heal sound/particles. <br>
	 *  12 = Triggers 8 health heal sound/particles. <br>
	 *  13 = Triggers MAX health heal sound/particles. <br><br>
	 *  
	 *  21 = Triggers 25 energy heal sound/particles. <br>
	 *  22 = Triggers 100 energy heal sound/particles. <br>
	 *  23 = Triggers MAX energy heal sound/particles. <br><br>
	 *  
	 *  31 = Triggers 50 durability heal sound/particles. <br>
	 *  32 = Triggers 200 durability heal sound/particles. <br>
	 *  33 = Triggers MAX durability heal sound/particles. <br><br>
	 *  
	 *  41 = Triggers tier 1 upgrade sound/particles. <br>
	 *  42 = Triggers tier 2 upgrade sound/particles. <br>
	 *  43 = Triggers tier 3 upgrade sound/particles. <br><br>
	 */
    public final int getEventTrigger()
    {
        return ((Integer)this.dataManager.get(EVENT_TRIGGER_DM)).intValue();
    }
    /**
	 * Keeps track of the event to be triggered. <br> <br>
	 *
	 *  0 = No event to trigger.<br>
	 *  1 = Trigger fall sound/particles. <br>
	 *  2 = Trigger broken sound/particles. <br>
	 *  3 = Trigger destruction logic. <br>
	 *  4 = Trigger lightning strike sound/particles. <br><br>
	 *  
	 *  11 = Triggers 2 health heal sound/particles. <br>
	 *  12 = Triggers 8 health heal sound/particles. <br>
	 *  13 = Triggers MAX health heal sound/particles. <br><br>
	 *  
	 *  21 = Triggers 25 energy heal sound/particles. <br>
	 *  22 = Triggers 100 energy heal sound/particles. <br>
	 *  23 = Triggers MAX energy heal sound/particles. <br><br>
	 *  
	 *  31 = Triggers 50 durability heal sound/particles. <br>
	 *  32 = Triggers 200 durability heal sound/particles. <br>
	 *  33 = Triggers MAX durability heal sound/particles. <br><br>
	 *  
	 *  41 = Triggers tier 1 upgrade sound/particles. <br>
	 *  42 = Triggers tier 2 upgrade sound/particles. <br>
	 *  43 = Triggers tier 3 upgrade sound/particles. <br><br>
	 */
    public void setEventTrigger(int intIn)
    {
        this.dataManager.set(EVENT_TRIGGER_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    //--------------------------------------------------
    
    //--------------------------------------------------
    
    /** Gets the Visual Model Frame. */
    public final int getVisualModelFrame()
    {
        return ((Integer)this.dataManager.get(VISUAL_MODEL_FRAME_DM)).intValue();
    }
    /** Sets the Visual Model Frame. */
    public void setVisualModelFrame(int intIn)
    {
        this.dataManager.set(VISUAL_MODEL_FRAME_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Model Engine. */
    public final int getVisualModelEngine()
    {
        return ((Integer)this.dataManager.get(VISUAL_MODEL_ENGINE_DM)).intValue();
    }
    /** Sets the Visual Model Engine. */
    public void setVisualModelEngine(int intIn)
    {
        this.dataManager.set(VISUAL_MODEL_ENGINE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Model Component. */
    public final int getVisualModelComponent()
    {
        return ((Integer)this.dataManager.get(VISUAL_MODEL_COMPONENT_DM)).intValue();
    }
    /** Sets the Visual Model Component. */
    public void setVisualModelComponent(int intIn)
    {
        this.dataManager.set(VISUAL_MODEL_COMPONENT_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the Visual Frame Texture. */
    public final int getVisualFrameTexture()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_TEXTURE_DM)).intValue();
    }
    /** Sets the Visual Frame Texture. */
    public void setVisualFrameTexture(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_TEXTURE_DM, Integer.valueOf(intIn));
    }

    /** Gets the Visual Frame Transparent. */
    public final boolean getVisualFrameTransparent()
    {
        return ((Boolean)this.dataManager.get(VISUAL_FRAME_TRANSPARENT_DM)).booleanValue();
    }
    /** Sets the Visual Frame Transparent. */
    public void setVisualFrameTransparent(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_FRAME_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }

    /** Gets the Visual Frame Color. */
    public final boolean getVisualFrameColor()
    {
        return ((Boolean)this.dataManager.get(VISUAL_FRAME_COLOR_DM)).booleanValue();
    }
    /** Sets the Visual Frame Color. */
    public void setVisualFrameColor(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_DM, Boolean.valueOf(booleanIn));
    }

    /** Gets the Visual Frame Color Red. */
    public final int getVisualFrameColorRed()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_RED_DM)).intValue();
    }
    /** Sets the Visual Frame Color Red. */
    public void setVisualFrameColorRed(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_RED_DM, Integer.valueOf(intIn));
    }

    /** Gets the Visual Frame Color Green. */
    public final int getVisualFrameColorGreen()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_GREEN_DM)).intValue();
    }
    /** Sets the Visual Frame Color Green. */
    public void setVisualFrameColorGreen(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }

    /** Gets the Visual Frame Color Blue. */
    public final int getVisualFrameColorBlue()
    {
        return ((Integer)this.dataManager.get(VISUAL_FRAME_COLOR_BLUE_DM)).intValue();
    }
    /** Sets the Visual Frame Color Blue. */
    public void setVisualFrameColorBlue(int intIn)
    {
        this.dataManager.set(VISUAL_FRAME_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the Visual Engine Particle. */
    public final int getVisualEngineParticle()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_PARTICLE_DM)).intValue();
    }
    /** Sets the Visual Engine Particle. */
    public void setVisualEngineParticle(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_PARTICLE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Type. */
    public final int getVisualEngineDisplayType()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_TYPE_DM)).intValue();
    }
    /** Sets the Visual Engine Display Type. */
    public void setVisualEngineDisplayType(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_TYPE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Itemstack. */
    public final int getVisualEngineDisplayItemstack()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM)).intValue();
    }
    /** Sets the Visual Engine Display Itemstack. */
    public void setVisualEngineDisplayItemstack(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_ITEMSTACK_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Itemstack Meta. */
    public final int getVisualEngineDisplayItemstackMeta()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM)).intValue();
    }
    /** Sets the Visual Engine Display Itemstack Meta. */
    public void setVisualEngineDisplayItemstackMeta(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Head. */
    public final int getVisualEngineDisplayHead()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_HEAD_DM)).intValue();
    }
    /** Sets the Visual Engine Display Head. */
    public void setVisualEngineDisplayHead(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_HEAD_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Supporter Head. */
    public final int getVisualEngineDisplaySupporterHead()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM)).intValue();
    }
    /** Sets the Visual Engine Display Supporter Head. */
    public void setVisualEngineDisplaySupporterHead(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Engine Display Holiday. */
    public final int getVisualEngineDisplayHoliday()
    {
        return ((Integer)this.dataManager.get(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM)).intValue();
    }
    /** Sets the Visual Engine Display Holiday. */
    public void setVisualEngineDisplayHoliday(int intIn)
    {
        this.dataManager.set(VISUAL_ENGINE_DISPLAY_HOLIDAY_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the Visual Component Texture. */
    public final int getVisualComponentTexture()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_TEXTURE_DM)).intValue();
    }
    /** Sets the Visual Component Texture. */
    public void setVisualComponentTexture(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_TEXTURE_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Component Transparent. */
    public final boolean getVisualComponentTransparent()
    {
        return ((Boolean)this.dataManager.get(VISUAL_COMPONENT_TRANSPARENT_DM)).booleanValue();
    }
    /** Sets the Visual Component Transparent. */
    public void setVisualComponentTransparent(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }
    
    /** Gets the Visual Component Color. */
    public final boolean getVisualComponentColor()
    {
        return ((Boolean)this.dataManager.get(VISUAL_COMPONENT_COLOR_DM)).booleanValue();
    }
    /** Sets the Visual Component Color. */
    public void setVisualComponentColor(boolean booleanIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_DM, Boolean.valueOf(booleanIn));
    }
    
    /** Gets the Visual Component Color Red. */
    public final int getVisualComponentColorRed()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_RED_DM)).intValue();
    }
    /** Sets the Visual Component Color Red. */
    public void setVisualComponentColorRed(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_RED_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Component Color Green. */
    public final int getVisualComponentColorGreen()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_GREEN_DM)).intValue();
    }
    /** Sets the Visual Component Color Green. */
    public void setVisualComponentColorGreen(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }
    
    /** Gets the Visual Component Color Blue. */
    public final int getVisualComponentColorBlue()
    {
        return ((Integer)this.dataManager.get(VISUAL_COMPONENT_COLOR_BLUE_DM)).intValue();
    }
    /** Sets the Visual Component Color Blue. */
    public void setVisualComponentColorBlue(int intIn)
    {
        this.dataManager.set(VISUAL_COMPONENT_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    
    //--------------------------------------------------
    
    /** Gets the Visual Name Color. */
    public final int getVisualNameColor()
    {
        return ((Integer)this.dataManager.get(VISUAL_NAME_COLOR_DM)).intValue();
    }
    /** Sets the Visual Name Color. */
    public void setVisualNameColor(int intIn)
    {
        this.dataManager.set(VISUAL_NAME_COLOR_DM, Integer.valueOf(MathHelper.clamp(intIn, 0, 15)));
    }
    
    //--------------------------------------------------
    
    /** Gets Machine part to preview.  <br> <br>
	 *
	 *  0 = Render whole model. (Default) <br>
	 *  1 = Render Frame only. <br>
	 *  2 = Render Engine only. <br>
	 *  3 = Render Component only. <br>
	 */
    @SideOnly(Side.CLIENT)
    public final int getPreviewPart()
    {
        return ((Integer)this.dataManager.get(PREVIEW_PART_DM)).intValue();
    }
    /** Sets Machine part to preview.  <br> <br>
	 *
	 *  0 = Render whole model. (Default) <br>
	 *  1 = Render Frame only. <br>
	 *  2 = Render Engine only. <br>
	 *  3 = Render Component only. <br>
	 */
    @SideOnly(Side.CLIENT)
    public void setPreviewPart(int intIn)
    {
        this.dataManager.set(PREVIEW_PART_DM, Integer.valueOf(intIn));
    }
    
    
    
	//==================================================
    // TODO         Machine Status Logic
	//==================================================
    
    /** Determines whether the machine is in water, gliding on land, or in air. */
    protected EntityMachineBase.Status getMachineStatus()
    {
        EntityMachineBase.Status EntityMachineBase$status = this.getUnderwaterStatus();
        
        if (EntityMachineBase$status != null)
        {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return EntityMachineBase$status;
        }
        else if (this.checkInWater())
        {
            return EntityMachineBase.Status.IN_WATER;
        }
        else if (this.checkInLava())
        {
            return EntityMachineBase.Status.IN_LAVA;
        }
        else
        {
            float f = this.getMachineGlide();
            
            if (f > 0.0F)
            {
                this.machineGlide = f;
                return EntityMachineBase.Status.ON_LAND;
            }
            else
            {
                return EntityMachineBase.Status.IN_AIR;
            }
        }
    }
    
    /** Gets the water above a machine based on the bounding box. */
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
    
    /** Get the height of the water/lava above the machine. */
    public static float getBlockLiquidHeight(IBlockState blockStateIn, IBlockAccess blockAccessIn, BlockPos posIn)
    {
        int i = ((Integer)blockStateIn.getValue(BlockLiquid.LEVEL)).intValue();
        return (i & 7) == 0 && blockAccessIn.getBlockState(posIn.up()).getMaterial() == Material.WATER ? 1.0F :
        	   (i & 7) == 0 && blockAccessIn.getBlockState(posIn.up()).getMaterial() == Material.LAVA ? 1.0F :
        		   1.0F - BlockLiquid.getLiquidHeightPercent(i);
    }
    
    /** Gets if the machine is on land and the gliding factor. (based on any slippery blocks) */
    public float getMachineGlide()
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
    
    /** A check to see if the machine is in water. */
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
    
    /** A check to see if the machine is in lava. */
    private boolean checkInLava()
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

                        if (iblockstate.getMaterial() == Material.LAVA)
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
    
    /** Get the height of the liquid. */
    public static float getLiquidHeight(IBlockState blockStateIn, IBlockAccess blockAccessIn, BlockPos posIn)
    {
        return (float)posIn.getY() + getBlockLiquidHeight(blockStateIn, blockAccessIn, posIn);
    }
    
    /** Decides whether the machine is currently under water/lava. */
    @Nullable
    private EntityMachineBase.Status getUnderwaterStatus()
    {
        AxisAlignedBB axisalignedbb = this.getEntityBoundingBox();
        double d0 = axisalignedbb.maxY + 0.001D;
        int i = MathHelper.floor(axisalignedbb.minX);
        int j = MathHelper.ceil(axisalignedbb.maxX);
        int k = MathHelper.floor(axisalignedbb.maxY);
        int l = MathHelper.ceil(d0);
        int i1 = MathHelper.floor(axisalignedbb.minZ);
        int j1 = MathHelper.ceil(axisalignedbb.maxZ);
        boolean flag1 = false;
        boolean flag2 = false;
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
                        
                        // Under Water:
                        if (iblockstate.getMaterial() == Material.WATER && d0 < (double)getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                                EntityMachineBase.Status EntityMachineBase$status = EntityMachineBase.Status.UNDER_FLOWING_WATER;
                                return EntityMachineBase$status;
                            }

                            flag1 = true;
                        }
                        
                        // Under Lava:
                        if (iblockstate.getMaterial() == Material.LAVA && d0 < (double)getLiquidHeight(iblockstate, this.world, blockpos$pooledmutableblockpos))
                        {
                            if (((Integer)iblockstate.getValue(BlockLiquid.LEVEL)).intValue() != 0)
                            {
                                EntityMachineBase.Status EntityMachineBase$status = EntityMachineBase.Status.UNDER_FLOWING_LAVA;
                                return EntityMachineBase$status;
                            }

                            flag2 = true;
                        }
                    }
                }
            }
        }
        finally
        {
            blockpos$pooledmutableblockpos.release();
        }

        return flag1 ? EntityMachineBase.Status.UNDER_WATER : flag2 ? EntityMachineBase.Status.UNDER_LAVA :null;
    }
    
    /** Enum responsible for determining the status of a machine. */
    public static enum Status
    {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        IN_LAVA,
        UNDER_LAVA,
        UNDER_FLOWING_LAVA,
        ON_LAND,
        IN_AIR;
    }
    
    
    

    //==================================================
    // TODO              Custom Logic
	//==================================================
	
    /** Get the Item form of the current Machine. */
    public ItemStack getItemMachine()
    {
		return null;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        if (this instanceof EntityMachineBase)
        {
        	return this.getItemMachine();
        }
        
        return null;
    }
    
    /** Is this a Ground Machine? */
	public boolean isGroundMachine()
    {
		return false;
    }
    
	/** Is this a Water Machine? */
	public boolean isWaterMachine()
    {
		return false;
    }
    
    /** Is this a Flying Machine? */
	public boolean isFlyingMachine()
    {
		return false;
    }
    
    /** Does this machine need fuel to run? */
	protected boolean isFuelNeeded()
	{
		return false;
	}
	
	/** Is this machine burning fuel? */
	public boolean isFuelBurning()
    {
		return false;
    }
	
	/** Get the damage done by the status of a machine. */
	protected void damageMachineByStatus()
    {
		if (this.getHealth() > 0.0F)
    	{
			if (this.status == this.status.UNDER_LAVA
			|| this.status == this.status.UNDER_FLOWING_LAVA)
			{
				this.attackEntityFrom(DamageSource.DROWN, 0.5F);
			}
    	}
    }
	
	/** This gets the block that is -0.25 below the entity. */
    private IBlockState findBlockUnderEntity(Entity parEntity)
    {
    	return parEntity.world.getBlockState(new BlockPos(this.posX, this.posY- 0.25D, this.posZ));
    }
    
    /** This checks if the block -0.25 below the entity is an air block. */
    protected boolean isBlockUnderEntityAir()
    {
    	if (this.findBlockUnderEntity(this) == Blocks.AIR.getDefaultState())
    	{
    		return true;
    	}
    	
    	return false;
    }
    
    /** Returns the string machine category name. (Used in GUI) (Ground, Water, Flying) */
	public String getCategoryName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.categorynone.0");
	}
	
	/** Returns the string machine type name. (Used in GUI) (Airship, Helicopter, etc.) */
	public String getTypeName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.typenone.0");
	}
	
    /** Returns the string machine component name. (Used in GUI) (Jump Height, Max Oxygen, Max Elevation) */
	public String getComponentName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentnamenone.0");
	}
    
    /** Returns the string machine component name. (Used in GUI) (Blocks, Seconds, Y Coord.) */
	public String getComponentNameValue()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.componentvaluenamenone.0");
	}
    
    /** Returns the string machine default name. (Used in GUI) */
	public String getMachineDefaultName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultnamenone.0");
	}
	
	/** Returns the string machine variant name. (VisualModelComponent) (Standard, Hindenburg, Dirigible) */
    public String getVariantName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultnamenone.0");
	}
    
    //--------------------------------------------------
    
    /** Sets the weapon firing cooldown depending on type in ticks. */
    protected int weaponFiringCooldownTicks(int ammoTypeIn)
    {
		int amount = 20;
    	
		if (ammoTypeIn == 1)
		{
			amount = 40;
		}
		
		if (ammoTypeIn == 2)
		{
			amount = 40;
		}
		
    	return amount;
    }
    
    /** Sets the weapon firing cooldown depending on type in ticks. */
    protected void initiateWeaponFiringCooldown()
    {
    	this.weaponFiringCooldownTicks(this.getAmmoType());
    	
    	if (this.weaponCooldown <= this.weaponFiringCooldownTicks(this.getAmmoType()))
    	{
    		this.weaponCooldown++;
    	}
    }
    
    //--------------------------------------------------
    
    /** Is this Machine primed for a Lightning Strike? */
	protected boolean isPrimedForLightningStrike()
	{
		boolean buildingStrike = false;
		
		if (this.getPrimedForLightningStrike() >= 20)
    	{
			buildingStrike = true;
    	}
		
		return buildingStrike;
	}
	
	/** Initiate the Lightning Strike on the Machine and reset the primed counter. */
	protected void machineLightningStrike()
	{
		NetworkHandler.sendToServer(new MessageFlyingThunderStrike());
		
		this.setPrimedForLightningStrike(0);
	}
	
	/** Core Lightning Strike logic responsible for checking to see if the Lightning Strike counter should tick. */
    private void initiateCanGetStruckByLightning()
    {
    	if (!this.world.isRemote)
    	{
    		boolean badWeather = this.world.isRainingAt(this.getPosition());
    		boolean severeWeather = this.world.isThundering();
    		
    		int machineHeight = this.getPosition().getY();
    		
    		//If the weather is bad, start ticking the lightning strike counter based on the elevation.
    		if (badWeather || severeWeather)
    		{
    			if (machineHeight >= 200)
	    		{
		    		if (References.random.nextInt(100) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
	    		else if (machineHeight >= 175)
	    		{
		    		if (References.random.nextInt(150) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
	    		else if (machineHeight >= 150)
	    		{
		    		if (References.random.nextInt(200) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
	    		else if (machineHeight >= 125)
	    		{
		    		if (References.random.nextInt(250) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
	    		else if (machineHeight >= 100)
	    		{
		    		if (References.random.nextInt(375) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
	    		else if (machineHeight >= 70)
	    		{
		    		if (References.random.nextInt(500) <= 1)
		    		{
		    			this.setPrimedForLightningStrike(this.getPrimedForLightningStrike() + 1);
		    		}
	    		}
    		}
    		else
    		{
    			this.setPrimedForLightningStrike(0);
    		}
    		
    		//Clear the counter if Y is 70 or below.
    		if (machineHeight <= 70)
    		{
    			this.setPrimedForLightningStrike(0);
    		}
    	}
    	else
    	{
    		if (this.getPrimedForLightningStrike() > 0)
    		{
    			if (References.random.nextInt(20) <= 1)
    			{
    				InitParticlesVMRender.generateParticleStaticCharge(this);
    			}
    			
    			if (this.getPrimedForLightningStrike() >= 5)
        		{
    				if (References.random.nextInt(10) <= 1)
        			{
        				InitParticlesVMRender.generateParticleStaticCharge(this);
        			}
        		}
    			
    			if (this.getPrimedForLightningStrike() >= 10)
        		{
    				if (References.random.nextInt(10) <= 1)
        			{
        				InitParticlesVMRender.generateParticleStaticCharge(this);
        			}
        		}
    			
    			if (this.getPrimedForLightningStrike() >= 15)
        		{
    				if (References.random.nextInt(5) <= 1)
        			{
        				InitParticlesVMRender.generateParticleStaticCharge(this);
        			}
        		}
    		}
    	}
    	

    	// Try to cause a lightning strike:
    	if (this.isPrimedForLightningStrike())
		{
    		this.setEventTrigger(EnumsVM.EventTrigger.LIGHTNING_STRIKE.getMetadata());
    		
    		this.machineLightningStrike();
		}
    }
    
    //--------------------------------------------------
    
    /** Initiates a durability issue based on the getDurability() value. */
    protected void initiateDurabilityIssues()
    {
    	
    	this.machineEngineStall();
    	
    }
    
    protected void machineEngineStall()
    {
    	if (!this.world.isRemote)
    	{
    		if (this.getPoweredOn())
	    	{
    			if (this.isFuelBurning())
    			{
	    			float total = this.getMaxDurability();
	    			float current = this.getDurability();
	    			float percentDurability = ((total - (total-current )) / total) * 100;
	    			
	    			if (percentDurability <= 4)
	    			{
	    				this.majorIssue();
	    			}
	    			else if (percentDurability <= 24)
	    			{
	    				this.minorIssue();
	    			}
	    			
	    			
	    			
			    	if (this.getIssueTick() > 0)
			    	{
			    		this.setPoweredOn(false);
			    		
			    		this.setIssueTick(this.getIssueTick() - 1);
			    		
			    		if (this.getIssueTick() > 40)
				    	{
				    		this.setIssueTick(0);
				    	}
			    	}
    			}
	    	}
    		else
    		{
    			if (this.getIssueTick() == 1)
		    	{
		    		this.setPoweredOn(true);
		    	}
    			
    			if (this.getIssueTick() > 0)
    			{
    				this.setIssueTick(this.getIssueTick() - 1);
    			}
    		}
    	}
    }
    
    
    
    
    
    
    
    
    
    
    /**  */
    private void minorIssue()
    {
    	if (References.random.nextInt(400) <= 1)
    	{
    		this.setIssueTick(this.getIssueTick() + 2);
    	}
    }
    
    /**  */
    private void majorIssue()
    {
    	if (References.random.nextInt(300) <= 1)
    	{
    		this.setIssueTick(this.getIssueTick() + 5);
    	}
    	if (References.random.nextInt(250) <= 1)
    	{
    		this.setIssueTick(this.getIssueTick() + 2);
    	}
    	if (References.random.nextInt(200) <= 1)
    	{
    		this.setIssueTick(this.getIssueTick() + 2);
    	}
    }
    
    
    
    //--------------------------------------------------
    
    /** Initiates a event trigger based on the getEventTrigger() value. */
    protected void initiateEventTrigger()
    {
    	//LogHelper.info("ticking - " + this.getEventTrigger());
    	// Play the fall sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.FALL.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger01Server());
    		}
			else
    		{
				this.playSound(this.getFallSound(4), 1.0F, 1.0F);
    		}
    	}
    	
    	// Play the broken sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.BROKEN.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
    			NetworkHandler.sendToServer(new MessageHelperEventTrigger02Server());
    		}
			else
    		{
				this.playSound(this.getBrokenSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	// Permanently destroys the machine:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.DESTRUCTION.getMetadata())
    	{
    		//LogHelper.info("ENTITYMACHINEBASE - It's Dead!!!");
    		//this.setDead();
    		this.isDead = true;
    	}
    	
    	// Play the lightning strike sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.LIGHTNING_STRIKE.getMetadata())
    	{
    		NetworkHandler.sendToServer(new MessageHelperEventTrigger04Server());
    		
    		if (this.world.isRemote)
    		{
    			
    		}
			else
    		{
				this.playSound(this.getLightningStrikeSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	// Play the injured sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.INJURED.getMetadata())
    	{
    		NetworkHandler.sendToServer(new MessageHelperEventTrigger05Server());
    		
    		if (this.world.isRemote)
    		{
    			
    		}
			else
    		{
				this.playSound(this.getInjuredSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//--------------------------------------------------
    	
    	// Play the 2 health sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.HEALTH_2.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger11Server());
    		}
			else
    		{
				this.playSound(this.getHealHealthSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the 8 health sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.HEALTH_8.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger12Server());
    		}
			else
    		{
				this.playSound(this.getHealHealthSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the max health sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.HEALTH_MAX.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger13Server());
    		}
			else
    		{
				this.playSound(this.getHealHealthSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//--------------------------------------------------
    	
    	// Play the 25 energy sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.ENERGY_25.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger21Server());
    		}
			else
    		{
				this.playSound(this.getHealEnergySound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the 100 energy sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.ENERGY_100.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger22Server());
    		}
			else
    		{
				this.playSound(this.getHealEnergySound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the max energy sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.ENERGY_MAX.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger23Server());
    		}
			else
    		{
				this.playSound(this.getHealEnergySound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//--------------------------------------------------
    	
    	// Play the 50 durability sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.DURABILITY_50.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger31Server());
    		}
			else
    		{
				this.playSound(this.getHealDurabilitySound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the 200 durability sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.DURABILITY_200.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger32Server());
    		}
			else
    		{
				this.playSound(this.getHealDurabilitySound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the max durability sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.DURABILITY_MAX.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger33Server());
    		}
			else
    		{
				this.playSound(this.getHealDurabilitySound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//--------------------------------------------------
    	
    	// Play the 4 ammo sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.AMMO_4.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger51Server());
    		}
			else
    		{
				this.playSound(this.getHealAmmoSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the 16 ammo sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.AMMO_16.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger52Server());
    		}
			else
    		{
				this.playSound(this.getHealAmmoSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the 64 ammo sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.AMMO_64.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger53Server());
    		}
			else
    		{
				this.playSound(this.getHealAmmoSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//--------------------------------------------------
    	
    	// Play the tier 1 upgrade sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.UPGRADE_TIER1.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger41Server());
    		}
			else
    		{
				this.playSound(this.getUpgradeSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the tier 2 upgrade sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.UPGRADE_TIER2.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger42Server());
    		}
			else
    		{
				this.playSound(this.getUpgradeSound(), 1.0F, 1.0F);
    		}
    	}
    	// Play the tier 3 upgrade sound/particles:
    	if (this.getEventTrigger() == EnumsVM.EventTrigger.UPGRADE_TIER3.getMetadata())
    	{
    		if (this.world.isRemote)
    		{
				NetworkHandler.sendToServer(new MessageHelperEventTrigger43Server());
    		}
			else
    		{
				this.playSound(this.getUpgradeSound(), 1.0F, 1.0F);
    		}
    	}
    	
    	//this.setLearnedRecordSlot1("");
    	
    	// Resets the event trigger:
    	this.setEventTrigger(0);
    }
    
    private void reduceAmmoToMax()
    {
    	if (this.getAmmoAmount() > this.getMaxAmmoAmount())
    	{
    		this.setAmmoAmount(this.getMaxAmmoAmount());
    	}
    }
    
    public String applySongtoRecordList(int intIn)
    {
    	this.setLearnedRecordSlot1(CommonProxy.musicListRecord.get(intIn).getResourcePath());
		return cachedUniqueIdString;
		
    	//if (!this.currentMusicListRecord.toString().contains(CommonProxy.musicListRecord.get(intIn).getResourcePath()))
    	//{
    	//	this.setLearnedRecordSlot1(CommonProxy.musicListRecord.get(intIn).getResourcePath());
    	//	//this.currentMusicListRecord.add(new ResourceLocation(this.addSongtoRecordList(intIn)));
    	//	//Collections.sort(this.currentMusicListRecord);
    	//}
    }
    
    public String addSongtoRecordList(int resourceLocationIn)
    {
    	String name = /*CommonProxy.musicListRecord.get(resourceLocationIn).getResourceDomain() + ":" + 
    	*/
    	//"item." + 
    	
    	CommonProxy.musicListRecord.get(resourceLocationIn).getResourcePath();
		
		return name;
    }
}

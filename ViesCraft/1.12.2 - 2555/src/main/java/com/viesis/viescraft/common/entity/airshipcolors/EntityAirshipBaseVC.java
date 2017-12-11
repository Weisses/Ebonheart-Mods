package com.viesis.viescraft.common.entity.airshipcolors;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipBaseVC extends EntityBaseVC {
	
	//Fuel system
  	protected static final DataParameter<Integer> AIRSHIP_POWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_POWERED_TOTAL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_ITEMFUELSTACK_POWERED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_ITEMFUELSTACK_POWERED_SIZE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
  	//Tier system
  	protected static final DataParameter<Integer> AIRSHIP_TIER_FRAME = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_TIER_CORE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_TIER_ENGINE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> AIRSHIP_TIER_BALLOON = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Frame system
    protected static final DataParameter<Integer> AIRSHIP_FRAME_VISUAL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> AIRSHIP_FRAME_VISUAL_TRANSPARENT = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Boolean> AIRSHIP_FRAME_VISUAL_COLOR = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Integer> AIRSHIP_FRAME_COLOR_RED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_FRAME_COLOR_GREEN = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_FRAME_COLOR_BLUE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Core system
    protected static final DataParameter<Integer> AIRSHIP_CORE_VISUAL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Engine system
    protected static final DataParameter<Integer> AIRSHIP_ENGINE_VISUAL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Balloon system
    protected static final DataParameter<Integer> AIRSHIP_BALLOON_VISUAL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> AIRSHIP_BALLOON_VISUAL_TRANSPARENT = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Boolean> AIRSHIP_BALLOON_VISUAL_COLOR = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Integer> AIRSHIP_BALLOON_COLOR_RED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_BALLOON_COLOR_GREEN = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> AIRSHIP_BALLOON_COLOR_BLUE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Module system
    protected static final DataParameter<Integer> MODULE_SLOT1_VARIANT = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> MODULE_JUKEBOX_SELECTED_SONG = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> MODULE_CRUISECONTROL_SELECTED_SPEED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_ALTITUDE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_ALTITUDE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_SPEED = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_SPEED = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_STORAGE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_STORAGE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_FUEL = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_FUEL = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);

	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_MUSIC = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_MUSIC = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);

	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_CRUISE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_CRUISE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);

	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_WATER = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_WATER = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_SLOT1_LEARNED_FUELINFINITE = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SLOT1_SELECTED_FUELINFINITE = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	
	
	/**
	 * AIRSHIP SLOTS: <br> <br>
	 *
	 * Slot  0 = Fuel <br>
	 * Slot  1 = Upgrade Frame <br>
	 * Slot  2 = Upgrade Core <br>
	 * Slot  3 = Upgrade Engine <br>
	 * Slot  4 = Upgrade Balloon <br>
	 * Slot 11 = Module Slot1 <br>
	 * Slot 12 = Module Slot2 <br>
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 */
    public ItemStackHandler inventory;
    protected int size = 64;
    
	//Fuel
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	public int itemFuelStackSize;
	public int itemFuelStack;
	public int airshipFuelTick;
	
    //Main setters/getters
	public int metaTierCore;
	public int metaTierFrame;
	public int metaTierEngine;
	public int metaTierBalloon;
	
	public int metaFrameVisual;
	public boolean metaFrameVisualTransparent;
	public boolean metaFrameVisualColor;
	public int metaFrameColorRed;
	public int metaFrameColorGreen;
	public int metaFrameColorBlue;
	
	public int metaCoreVisual;
	
	public int metaEngineVisual;
	
	public int metaBalloonVisual;
	public boolean metaBalloonVisualTransparent;
	public boolean metaBalloonVisualColor;
	public int metaBalloonColorRed;
	public int metaBalloonColorGreen;
	public int metaBalloonColorBlue;
	
    //Movement logic
    public float AirshipSpeedTurn;
    public float AirshipSpeedForward;
    public float AirshipSpeedUp;
    public float AirshipSpeedDown;
    
    public String customName;
	protected boolean canDrop;
	
	public float speedModifier;
	
	//Modules
	public int metaModuleVariantSlot1;
	
	public int metaJukeboxSelectedSong;
    public int metaCruiseControlSelectedSpeed;
    public boolean cruiseControlToggle;
    
	/** Selected Altitude */
	public int selectedModuleAltitude;
	/** Learned Altitude */
	public boolean learnedModuleAltitude;
	/** Selected Speed */
	public int selectedModuleSpeed;
	/** Learned Speed */
	public boolean learnedModuleSpeed;
	/** Selected Storage */
	public int selectedModuleStorage;
	/** Learned Storage */
	public boolean learnedModuleStorage;
	/** Selected Fuel */
	public int selectedModuleFuel;
	/** Learned Fuel */
	public boolean learnedModuleFuel;
	/** Selected Music */
	public int selectedModuleMusic;
	/** Learned Music */
	public boolean learnedModuleMusic;
	/** Selected Cruise */
	public int selectedModuleCruise;
	/** Learned Cruise */
	public boolean learnedModuleCruise;
	/** Selected Water */
	public int selectedModuleWater;
	/** Learned Water */
	public boolean learnedModuleWater;
	/** Selected Fuel Infinite */
	public int selectedModuleFuelInfinite;
	/** Learned Fuel Infinite */
	public boolean learnedModuleFuelInfinite;
    
    References rf;
	
	
	
    public EntityAirshipBaseVC(World worldIn)
    {
        super(worldIn);
        
        this.inventory = new ItemStackHandler(size);
    }
    
    public EntityAirshipBaseVC(World worldIn, double x, double y, double z, 
    		int coreTierIn, int frameTierIn, int engineTierIn, int balloonTierIn, 
    		int moduleSlot1In,
    		int frameVisualIn, boolean frameVisualTransparentIn, boolean frameVisualColorIn,
    		int frameColorRedIn, int frameColorGreenIn, int frameColorBlueIn,
    		int balloonVisualIn, boolean balloonVisualTransparentIn, boolean balloonVisualColorIn,
    		int balloonColorRedIn, int balloonColorGreenIn, int balloonColorBlueIn,
    		boolean learnedModuleAltitudeIn, int selectedModuleAltitudeIn, 
    		boolean learnedModuleSpeedIn, int selectedModuleSpeedIn, 
    		boolean learnedModuleStorageIn, int selectedModuleStorageIn, 
    		boolean learnedModuleFuelIn, int selectedModuleFuelIn, 
    		boolean learnedModuleMusicIn, int selectedModuleMusicIn, 
    		boolean learnedModuleCruiseIn, int selectedModuleCruiseIn, 
    		boolean learnedModuleWaterIn, int selectedModuleWaterIn, 
    		boolean learnedModuleFuelInfiniteIn, int selectedModuleFuelInfiniteIn)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        
        this.inventory = new ItemStackHandler(size);
    }
    
    @Override
    public void entityInit()
    {
    	super.entityInit();
    	
		this.dataManager.register(AIRSHIP_POWERED, Integer.valueOf(this.airshipBurnTime));
        this.dataManager.register(AIRSHIP_POWERED_TOTAL, Integer.valueOf(this.airshipTotalBurnTime));
        this.dataManager.register(AIRSHIP_ITEMFUELSTACK_POWERED, Integer.valueOf(this.itemFuelStack));
        this.dataManager.register(AIRSHIP_ITEMFUELSTACK_POWERED_SIZE, Integer.valueOf(this.itemFuelStackSize));
        
        this.dataManager.register(AIRSHIP_TIER_CORE, Integer.valueOf(this.metaTierCore));
        this.dataManager.register(AIRSHIP_TIER_FRAME, Integer.valueOf(this.metaTierFrame));
        this.dataManager.register(AIRSHIP_TIER_ENGINE, Integer.valueOf(this.metaTierEngine));
        this.dataManager.register(AIRSHIP_TIER_BALLOON, Integer.valueOf(this.metaTierBalloon));
        
        this.dataManager.register(AIRSHIP_FRAME_VISUAL, Integer.valueOf(this.metaFrameVisual));
        this.dataManager.register(AIRSHIP_FRAME_VISUAL_TRANSPARENT, Boolean.valueOf(this.metaFrameVisualTransparent));
        this.dataManager.register(AIRSHIP_FRAME_VISUAL_COLOR, Boolean.valueOf(this.metaFrameVisualColor));
        this.dataManager.register(AIRSHIP_FRAME_COLOR_RED, Integer.valueOf(this.metaFrameColorRed));
        this.dataManager.register(AIRSHIP_FRAME_COLOR_GREEN, Integer.valueOf(this.metaFrameColorGreen));
        this.dataManager.register(AIRSHIP_FRAME_COLOR_BLUE, Integer.valueOf(this.metaFrameColorBlue));
        
        this.dataManager.register(AIRSHIP_CORE_VISUAL, Integer.valueOf(this.metaCoreVisual));
        
        this.dataManager.register(AIRSHIP_ENGINE_VISUAL, Integer.valueOf(this.metaEngineVisual));
        
        this.dataManager.register(AIRSHIP_BALLOON_VISUAL, Integer.valueOf(this.metaBalloonVisual));
        this.dataManager.register(AIRSHIP_BALLOON_VISUAL_TRANSPARENT, Boolean.valueOf(this.metaBalloonVisualTransparent));
        this.dataManager.register(AIRSHIP_BALLOON_VISUAL_COLOR, Boolean.valueOf(this.metaBalloonVisualColor));
        this.dataManager.register(AIRSHIP_BALLOON_COLOR_RED, Integer.valueOf(this.metaBalloonColorRed));
        this.dataManager.register(AIRSHIP_BALLOON_COLOR_GREEN, Integer.valueOf(this.metaBalloonColorGreen));
        this.dataManager.register(AIRSHIP_BALLOON_COLOR_BLUE, Integer.valueOf(this.metaBalloonColorBlue));
        
        this.dataManager.register(MODULE_SLOT1_VARIANT, Integer.valueOf(this.metaModuleVariantSlot1));
        
        this.dataManager.register(MODULE_JUKEBOX_SELECTED_SONG, Integer.valueOf(this.metaJukeboxSelectedSong));
        this.dataManager.register(MODULE_CRUISECONTROL_SELECTED_SPEED, Integer.valueOf(this.metaCruiseControlSelectedSpeed));
        
        
        
        this.dataManager.register(MODULE_SLOT1_SELECTED_ALTITUDE, Integer.valueOf(this.selectedModuleAltitude));
        this.dataManager.register(MODULE_SLOT1_LEARNED_ALTITUDE, Boolean.valueOf(this.learnedModuleAltitude));
        this.dataManager.register(MODULE_SLOT1_SELECTED_SPEED, Integer.valueOf(this.selectedModuleSpeed));
        this.dataManager.register(MODULE_SLOT1_LEARNED_SPEED, Boolean.valueOf(this.learnedModuleSpeed));
        this.dataManager.register(MODULE_SLOT1_SELECTED_STORAGE, Integer.valueOf(this.selectedModuleStorage));
        this.dataManager.register(MODULE_SLOT1_LEARNED_STORAGE, Boolean.valueOf(this.learnedModuleStorage));
        this.dataManager.register(MODULE_SLOT1_SELECTED_FUEL, Integer.valueOf(this.selectedModuleFuel));
        this.dataManager.register(MODULE_SLOT1_LEARNED_FUEL, Boolean.valueOf(this.learnedModuleFuel));
        this.dataManager.register(MODULE_SLOT1_SELECTED_MUSIC, Integer.valueOf(this.selectedModuleMusic));
        this.dataManager.register(MODULE_SLOT1_LEARNED_MUSIC, Boolean.valueOf(this.learnedModuleMusic));
        this.dataManager.register(MODULE_SLOT1_SELECTED_CRUISE, Integer.valueOf(this.selectedModuleCruise));
        this.dataManager.register(MODULE_SLOT1_LEARNED_CRUISE, Boolean.valueOf(this.learnedModuleCruise));
        this.dataManager.register(MODULE_SLOT1_SELECTED_WATER, Integer.valueOf(this.selectedModuleWater));
        this.dataManager.register(MODULE_SLOT1_LEARNED_WATER, Boolean.valueOf(this.learnedModuleWater));
        this.dataManager.register(MODULE_SLOT1_SELECTED_FUELINFINITE, Integer.valueOf(this.selectedModuleFuelInfinite));
        this.dataManager.register(MODULE_SLOT1_LEARNED_FUELINFINITE, Boolean.valueOf(this.learnedModuleFuelInfinite));
    }
	
	
	
    //================================================================================
	
	
	
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
	
	
	
    //================================================================================
	
	
	
	//==================================//
    // TODO       Read/Write            //
	//==================================//
    
    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
    	super.writeToNBT(compound);
    	
    	compound.setTag(rf.META_AIRSHIP_SLOTS_TAG, inventory.serializeNBT());

    	compound.setInteger(rf.META_TIER_FRAME_TAG, this.metaTierFrame);
    	compound.setInteger(rf.META_TIER_CORE_TAG, this.metaTierCore);
    	compound.setInteger(rf.META_TIER_ENGINE_TAG, this.metaTierEngine);
    	compound.setInteger(rf.META_TIER_BALLOON_TAG, this.metaTierBalloon);
    	
    	compound.setInteger(rf.META_FRAME_VISUAL_TAG, this.metaFrameVisual);
    	compound.setBoolean(rf.META_FRAME_VISUAL_TRANSPARENT_TAG, this.metaFrameVisualTransparent);
    	compound.setBoolean(rf.META_FRAME_VISUAL_COLOR_TAG, this.metaFrameVisualColor);
    	compound.setInteger(rf.META_FRAME_VISUAL_COLOR_RED_TAG, this.metaFrameColorRed);
    	compound.setInteger(rf.META_FRAME_VISUAL_COLOR_GREEN_TAG, this.metaFrameColorGreen);
    	compound.setInteger(rf.META_FRAME_VISUAL_COLOR_BLUE_TAG, this.metaFrameColorBlue);
    	
    	compound.setInteger(rf.META_BALLOON_VISUAL_TAG, this.metaBalloonVisual);
    	compound.setBoolean(rf.META_BALLOON_VISUAL_TRANSPARENT_TAG, this.metaBalloonVisualTransparent);
    	compound.setBoolean(rf.META_BALLOON_VISUAL_COLOR_TAG, this.metaBalloonVisualColor);
    	compound.setInteger(rf.META_BALLOON_VISUAL_COLOR_RED_TAG, this.metaBalloonColorRed);
    	compound.setInteger(rf.META_BALLOON_VISUAL_COLOR_GREEN_TAG, this.metaBalloonColorGreen);
    	compound.setInteger(rf.META_BALLOON_VISUAL_COLOR_BLUE_TAG, this.metaBalloonColorBlue);
    	
    	compound.setInteger(rf.META_AIRSHIP_BURNTIME_TAG, this.airshipBurnTime);
    	compound.setInteger(rf.META_AIRSHIP_BURNTIME_TOTAL_TAG, this.airshipTotalBurnTime);
    	compound.setInteger(rf.META_ITEM_FUELSTACK_TAG, this.itemFuelStack);
    	compound.setInteger(rf.META_ITEM_FUELSTACK_SIZE_TAG, this.itemFuelStackSize);
    	
    	compound.setInteger(rf.META_MODULE_VARIANT_SLOT1_TAG, this.metaModuleVariantSlot1);
		compound.setInteger(rf.META_JUKEBOX_SELECTED_SONG_TAG, this.metaJukeboxSelectedSong);
		
		compound.setBoolean(rf.META_LEARNED_MODULE_ALTITUDE_TAG, this.learnedModuleAltitude);
		compound.setInteger(rf.META_SELECTED_MODULE_ALTITUDE_TAG, this.selectedModuleAltitude);
		compound.setBoolean(rf.META_LEARNED_MODULE_SPEED_TAG, this.learnedModuleSpeed);
		compound.setInteger(rf.META_SELECTED_MODULE_SPEED_TAG, this.selectedModuleSpeed);
		compound.setBoolean(rf.META_LEARNED_MODULE_STORAGE_TAG, this.learnedModuleStorage);
		compound.setInteger(rf.META_SELECTED_MODULE_STORAGE_TAG, this.selectedModuleStorage);
		compound.setBoolean(rf.META_LEARNED_MODULE_FUEL_TAG, this.learnedModuleFuel);
		compound.setInteger(rf.META_SELECTED_MODULE_FUEL_TAG, this.selectedModuleFuel);
		compound.setBoolean(rf.META_LEARNED_MODULE_MUSIC_TAG, this.learnedModuleMusic);
		compound.setInteger(rf.META_SELECTED_MODULE_MUSIC_TAG, this.selectedModuleMusic);
		compound.setBoolean(rf.META_LEARNED_MODULE_CRUISE_TAG, this.learnedModuleCruise);
		compound.setInteger(rf.META_SELECTED_MODULE_CRUISE_TAG, this.selectedModuleCruise);
		compound.setBoolean(rf.META_LEARNED_MODULE_WATER_TAG, this.learnedModuleWater);
		compound.setInteger(rf.META_SELECTED_MODULE_WATER_TAG, this.selectedModuleWater);
		compound.setBoolean(rf.META_LEARNED_MODULE_FUELINFINITE_TAG, this.learnedModuleFuelInfinite);
		compound.setInteger(rf.META_SELECTED_MODULE_FUELINFINITE_TAG, this.selectedModuleFuelInfinite);
		
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	inventory.deserializeNBT(compound.getCompoundTag(rf.META_AIRSHIP_SLOTS_TAG));

    	this.metaTierFrame = compound.getInteger(rf.META_TIER_FRAME_TAG);
    	this.metaTierCore = compound.getInteger(rf.META_TIER_CORE_TAG);
    	this.metaTierEngine = compound.getInteger(rf.META_TIER_ENGINE_TAG);
    	this.metaTierBalloon = compound.getInteger(rf.META_TIER_BALLOON_TAG);
    	
    	this.metaFrameVisual = compound.getInteger(rf.META_FRAME_VISUAL_TAG);
    	this.metaFrameVisualTransparent = compound.getBoolean(rf.META_FRAME_VISUAL_TRANSPARENT_TAG);
    	this.metaFrameVisualColor = compound.getBoolean(rf.META_FRAME_VISUAL_COLOR_TAG);
    	this.metaFrameColorRed = compound.getInteger(rf.META_FRAME_VISUAL_COLOR_RED_TAG);
    	this.metaFrameColorGreen = compound.getInteger(rf.META_FRAME_VISUAL_COLOR_GREEN_TAG);
    	this.metaFrameColorBlue = compound.getInteger(rf.META_FRAME_VISUAL_COLOR_BLUE_TAG);
    	
    	this.metaBalloonVisual = compound.getInteger(rf.META_BALLOON_VISUAL_TAG);
    	this.metaBalloonVisualTransparent = compound.getBoolean(rf.META_BALLOON_VISUAL_TRANSPARENT_TAG);
    	this.metaBalloonVisualColor = compound.getBoolean(rf.META_BALLOON_VISUAL_COLOR_TAG);
    	this.metaBalloonColorRed = compound.getInteger(rf.META_BALLOON_VISUAL_COLOR_RED_TAG);
    	this.metaBalloonColorGreen = compound.getInteger(rf.META_BALLOON_VISUAL_COLOR_GREEN_TAG);
    	this.metaBalloonColorBlue = compound.getInteger(rf.META_BALLOON_VISUAL_COLOR_BLUE_TAG);
    	
        this.airshipBurnTime = compound.getInteger(rf.META_AIRSHIP_BURNTIME_TAG);
        this.airshipTotalBurnTime = compound.getInteger(rf.META_AIRSHIP_BURNTIME_TOTAL_TAG);
        this.itemFuelStack = compound.getInteger(rf.META_ITEM_FUELSTACK_TAG);
        this.itemFuelStackSize = compound.getInteger(rf.META_ITEM_FUELSTACK_SIZE_TAG);
        
        this.metaModuleVariantSlot1 = compound.getInteger(rf.META_MODULE_VARIANT_SLOT1_TAG);
        this.metaJukeboxSelectedSong = compound.getInteger(rf.META_JUKEBOX_SELECTED_SONG_TAG);
        
        this.learnedModuleAltitude = compound.getBoolean(rf.META_LEARNED_MODULE_ALTITUDE_TAG);
        this.selectedModuleAltitude = compound.getInteger(rf.META_SELECTED_MODULE_ALTITUDE_TAG);
        this.learnedModuleSpeed = compound.getBoolean(rf.META_LEARNED_MODULE_SPEED_TAG);
        this.selectedModuleSpeed = compound.getInteger(rf.META_SELECTED_MODULE_SPEED_TAG);
        this.learnedModuleStorage = compound.getBoolean(rf.META_LEARNED_MODULE_STORAGE_TAG);
        this.selectedModuleStorage = compound.getInteger(rf.META_SELECTED_MODULE_STORAGE_TAG);
        this.learnedModuleFuel = compound.getBoolean(rf.META_LEARNED_MODULE_FUEL_TAG);
        this.selectedModuleFuel = compound.getInteger(rf.META_SELECTED_MODULE_FUEL_TAG);
        this.learnedModuleMusic = compound.getBoolean(rf.META_LEARNED_MODULE_MUSIC_TAG);
        this.selectedModuleMusic = compound.getInteger(rf.META_SELECTED_MODULE_MUSIC_TAG);
        this.learnedModuleCruise = compound.getBoolean(rf.META_LEARNED_MODULE_CRUISE_TAG);
        this.selectedModuleCruise = compound.getInteger(rf.META_SELECTED_MODULE_CRUISE_TAG);
        this.learnedModuleWater = compound.getBoolean(rf.META_LEARNED_MODULE_WATER_TAG);
        this.selectedModuleWater = compound.getInteger(rf.META_SELECTED_MODULE_WATER_TAG);
        this.learnedModuleFuelInfinite = compound.getBoolean(rf.META_LEARNED_MODULE_FUELINFINITE_TAG);
        this.selectedModuleFuelInfinite = compound.getInteger(rf.META_SELECTED_MODULE_FUELINFINITE_TAG);
    }
	
	
	
    //================================================================================
	
	
	
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	this.updateAirshipMeta();
    	this.getAirshipFuelTick();
    	this.noInventoryModuleDropItems();
    }
    
    
    
    //==================================//
    // TODO          GUI                //
	//==================================//
	
    /**
     * Opens the correct inventory on button press.
     */
    protected void controlAirshipGui()
    {
    	if(this.openInputDown 
    	&& this.getControllingPassenger() != null)
		{
			//Lesser Storage
        	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageLesser());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Normal Storage
        	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageNormal());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Greater Storage
        	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageGreater());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Any Music
        	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    			 || this.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    			 || this.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuMusic());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenu());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        }
    }
    
    
    
    //==================================//
    // TODO     Airship Behavior        //
	//==================================//
    
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
    		
    		int drop1 = References.random.nextInt(100) + 1;
    		int drop2 = References.random.nextInt(100) + 1;
    		int drop3 = References.random.nextInt(100) + 1;
    		int drop4 = References.random.nextInt(100) + 1;
    		
    	    if (drop1 < 75)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.AIRSHIP_BALLOON, 1, 0.0F);
        	}
    	    
    	    if (drop2 < 55)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.AIRSHIP_ENGINE, 1, 0.0F);
    	    	
    	    	if (drop3 < 35)
            	{
        	    	this.dropItemWithOffset(InitItemsVC.AIRSHIP_ENGINE, 1, 0.0F);
            	}
        	}
    	    
    	    if (drop4 < 15)
        	{
    	    	this.dropItemWithOffset(InitItemsVC.AIRSHIP_IGNITION, 1, 0.0F);
        	}
    	    
    	    this.dropInventoryAll();
        	this.setDead();
    	}
	}
    
    /**
     * Height Restrictions.
     */
    protected boolean airshipHeightLimit()
    {
    	Boolean maxHeightReached;
    	
    	int airshipHeight = this.getPosition().getY();
    	if(airshipHeight > EnumsVC.AirshipTierBalloon.byId(this.getMetaTierBalloon()).getMaxAltitude())
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
    public int getAirshipFuelTick()
    {
    	this.airshipFuelTick = this.getBaseFuelTick();
    	
    	//Lesser Fuel 20%
    	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 2);
    	}
    	//Normal Fuel 40%
    	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 4);
    	}
    	//Greater Fuel 60%
    	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 6);
    	}
    	////Major Speed & Large Inventory 50
    	//if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata()
    	//|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
    	//{
    	//	this.airshipFuelTick = this.airshipFuelTick + (this.getBaseFuelPercent10() * 5);
    	//}
    	
    	return airshipFuelTick;
    }
    
    protected int getBaseFuelTick()
    {
    	this.airshipFuelTick = EnumsVC.AirshipTierEngine.byId(this.getMetaTierEngine()).getFuelPerTick();
    	
    	return this.airshipFuelTick;
    }
    
    protected int getBaseFuelPercent10()
    {
    	switch(this.getMetaTierEngine())
    	{
	    	case 0:
	    		return 6;
	    	case 1:
	    		return 5;
	    	case 2:
	    		return 4;
	    	case 3:
	    		return 3;
	    	case 4:
	    		return 2;
	    	case 5:
	    		return 1;
    		default:
    			return 0;
    	}
    }
    //======================================================================================

    
    
    //==================================//
    // TODO          Misc               //
	//==================================//
    
    protected String getNameColor()
	{
		switch (this.getMetaTierFrame())
        {
	        case 0:
	        	return TextFormatting.GRAY + "";
        	case 1:
            	return TextFormatting.WHITE + "";
            case 2:
            	return TextFormatting.GOLD + "";
            case 3:
            	return TextFormatting.AQUA + "";
            case 4:
            	return TextFormatting.LIGHT_PURPLE + "";
            case 5:
            	return TextFormatting.RED + "";
            default:
            	return TextFormatting.GRAY + "";
        }
	}
    
    /**
     * Setter for variables to pass through fields.
     */
    public void setField(int id, int value)
    {
        switch (id)
        {
        	case 0:
                this.airshipBurnTime = value;
                break;
            case 1:
            	this.airshipTotalBurnTime = value;
                break;
            default:
            	break;
        }
    }
    
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.airshipBurnTime;
            case 1:
                return this.airshipTotalBurnTime;
            default:
                return 0;
        }
    }
    
    //public int getFieldCount()
    //{
    //    return 2;
    //}
    
    /**
     * Checker to see if the airship has glitched through solid ground.
     */
    protected boolean fallenInGround()
    {
    	boolean isGlitched = false;
    	
    	if(this.isEntityInsideOpaqueBlock())
    	{
    		isGlitched = true;
    	}
    	
		return isGlitched;
    }
    
    /**
     * Drops all items stored.
     */
    protected void dropInventoryAll()
    {
    	if(this.world.isRemote)
		{
			for(int x = 0; x < this.inventory.getSlots(); ++x) 
			{
				if(!this.inventory.getStackInSlot(x).isEmpty())
				{
					this.inventory.setStackInSlot(x, null);
				}
			}
		}
		else
		{
			for(int x = 0; x < this.inventory.getSlots(); ++x) 
			{
				if(!this.inventory.getStackInSlot(x).isEmpty())
				{
					InventoryHelper.spawnItemStack(this.world, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
					//this.inventory.setStackInSlot(x, null);
				}
			}
		}
    }
    
    /**
     * Drops inventory contents only from airship storage slots (not fuel/upgrades/module).
     */
    public void dropInventoryItemStorageOnly()
    {
    	if(this.world.isRemote)
		{
			for (int x = 20; x < 47; ++x) 
			{
				if(!this.inventory.getStackInSlot(x).isEmpty())
				{
					this.inventory.setStackInSlot(x, null);
				}
			}
		}
		else
		{
			for (int x = 20; x < 47; ++x) 
			{
				if(!this.inventory.getStackInSlot(x).isEmpty())
				{
					InventoryHelper.spawnItemStack(this.world, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
					//this.inventory.setStackInSlot(x, null);
				}
			}
		}
    }
    
    /**
     * Root Method that will drop everything in all inventory slots minus fuel
     */
    protected void noInventoryModuleDropItems()
    {
    	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
    	{
    		canDrop = true;
    	}
    	
    	if(this.getModuleVariantSlot1() != EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
		&& this.getModuleVariantSlot1() != EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
		&& this.getModuleVariantSlot1() != EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()
    	&& canDrop)
    	{
    		this.dropInventoryItemStorageOnly();
    		canDrop = false;
    	}
    }
    
    @Override
    public void setDeadVC()
    {
    	if (!this.world.isRemote)
    	{
    		this.dropInventoryAll();
    		
    		this.playSound(SoundEvents.ENTITY_ENDEREYE_LAUNCH, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
    		this.playSound(SoundEvents.ENTITY_SHEEP_SHEAR, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
    		
    		this.isDead = true;
    	}
    	else
    	{
        	InitParticlesVCRender.generateExplosions(this);
    	}
    }
    
    public ItemStack getPickedResult(RayTraceResult target)
    {
        if (this instanceof EntityBaseVC)
        {
        	return this.getItemAirship();
        }
        
        return null;
    }
    
    
    
    //==================================//
    // TODO    Speed and Motion         //
	//==================================//
    
    @Override
    public void updateMotion()
    {
        double d0 = 0.0D;
        double d5 = -0.0005D;
        this.momentum = 0.05F;
        
        if (this.previousStatus == EntityAirshipBaseVC.Status.IN_AIR && this.status != EntityAirshipBaseVC.Status.IN_AIR && this.status != EntityAirshipBaseVC.Status.ON_LAND)
        {
            this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
            this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
            this.motionY = 0.0D;
            this.lastYd = 0.0D;
            this.status = EntityAirshipBaseVC.Status.IN_WATER;
        }
        else
        {
            if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
            {
            	this.momentum = 0.45F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
            {
            	this.momentum = 0.67F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
            	this.momentum = 0.9F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
            {
            	if(this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_LESSER.getMetadata()
        		|| this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
        		|| this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            	{
            		this.waterPartsDrop();
            	}
            }
            else if (this.status == EntityAirshipBaseVC.Status.IN_AIR
            	  || this.status == EntityAirshipBaseVC.Status.ON_LAND)
            {
            	this.momentum = 0.9F;
            }
            
            this.motionX *= (double)this.momentum;
            this.motionZ *= (double)this.momentum;
            this.deltaRotation *= this.momentum;
            
            if(this.getControllingPassenger() == null)
            {
            	if(this.motionY < -0.060D)
        		{
            		this.motionY = -0.060D;
        		}
        		
            	this.motionY += d5;
            }
            else if(isClientAirshipBurning())
        	{
            	this.motionY *= (double)this.momentum;
        	}
            else
            {
            	if(this.motionY < -0.060D)
        		{
            		this.motionY = -0.060D;
        		}
        		
            	this.motionY += d5;
            }
            
            if(this.fallenInGround())
    		{
        		this.motionY = 0;
    		}
            
            
            
            if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
            	if(this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
				|| this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
				{
            		this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
				}
            	if(this.status == EntityAirshipBaseVC.Status.IN_WATER)
	            {
	            	this.motionY = 0;
	            }
            }
            
            //Max altitude Module
            if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
            {
            	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
            	{
            		//Lesser Altitude
                	if(this.getPosition().getY() > 225)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
            	{
            		//Altitude
                	if(this.getPosition().getY() > 250)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
            	{
            		//Greater Altitude
                	if(this.getPosition().getY() > 500)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
        	}
        	//Default Altitude logic.
            else
        	{
            	if(this.getPosition().getY() > EnumsVC.AirshipTierBalloon.byId(this.metaTierBalloon).getMaxAltitude())
	            {
            		this.motionY = -0.1D;
	            }
        	}
        }
    }
    
    
    
    //==================================//
    // TODO       Fuel Logic            //
	//==================================//
    
    /**
     * Core fuel logic responsible for flight.
     */
	public void fuelFlight()
    {
    	boolean flag = this.isClientAirshipBurning();
        boolean flag1 = false;
        
        //Sets burn time to 0
        if(this.airshipBurnTime <= this.getBaseFuelTick())
        {
        	this.airshipBurnTime = 0;
        }
        
        //Handles how burn time is ticked down
        if (this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		
        	}
        	else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		
            }
        	else 
        	{
        		this.airshipBurnTime = this.airshipBurnTime - this.getAirshipFuelTick();
        	}
        }
        
        //Handles when the airship is off
        if (!this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		this.airshipBurnTime = 1;
        	}
        	//Greater Water no fuel
        	else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		this.airshipBurnTime = 1;
            }
        	//Airship has no controlling passenger
        	else if(this.getControllingPassenger() == null)
        	{
        		this.airshipBurnTime = 0;
        	}
        	else 
        	{
        		this.airshipBurnTime = 0;
        	}
        }
        
        
        if (!this.world.isRemote)
        {
        	ItemStack fuelSlot = this.inventory.getStackInSlot(0);
        	
	        //Core fuel slot logic
	        if (this.isClientAirshipBurning() || !fuelSlot.isEmpty())
	        {
	            if (!this.isClientAirshipBurning()
	            && this.getControllingPassenger() != null)
	            {
	                this.airshipBurnTime = getItemBurnTime(fuelSlot);
	                this.airshipTotalBurnTime = getItemBurnTime(fuelSlot);
	                
	                if (this.isClientAirshipBurning())
	                {
	                    flag1 = true;
	                    
	                    //Consumes the fuel item
	                    if (!fuelSlot.isEmpty())
	                    {
	                    	this.inventory.extractItem(0, 1, false);
	                    }
	                }
	            }
	        }
        }
        
        if (flag != this.isClientAirshipBurning())
        {
            flag1 = true;
        }
    }
    
    /**
     * Is Airship Engine On
     */
    public boolean isClientAirshipBurning()
    {
    	boolean hasFuel = false;
    	
    	if(this.airshipBurnTime > 0)
    	{
    		hasFuel = true;
    	}
    	
    	return hasFuel;
    }
    
    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            //DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            
            if(ViesCraftConfig.vanillaFuel)
    		{
	            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if (block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVC.wooden_slab * 10;
	                }
	                
	                if (block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVC.wood_block_material * 10;
	                }
	                
	                if (block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVC.coal_block * 10;
	                }
	            }
	            
	            if (item == Items.STICK) return FuelVC.stick * 10;
	            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling * 10;
	            if (item == Items.COAL) return FuelVC.coal * 10;
	            if (item == Items.BLAZE_ROD) return FuelVC.blaze_rod * 10;
	            
	            if (item == Items.LAVA_BUCKET) return 20000 * 10;
    		}
            
            if (item == InitItemsVC.VIESOLINE_PELLETS) return (ViesCraftConfig.viesolineBurnTime * 20) * 10;
            //if (item == InitItemsVC.airship_battery) return cap.getEnergyStored();
            
            if(ViesCraftConfig.outsideModFuel)
    		{
            	return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack) * 10;
    		}
            else
            {
            	return 0;
            }
        }
    }
    
    public static boolean isItemFuel(ItemStack stack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemBurnTime(stack) > 0;
    }
    

    /**
     * Calculates total fuel burn time by stack size for GUI
     */
    public void getTotalFuelSlotBurnTime()
    {
    	if(this.getControllingPassenger() != null)
    	{
    		if (this.isClientAirshipBurning())
            {
    			ItemStack itemFuel = this.inventory.getStackInSlot(0);
    			
    			if(!itemFuel.isEmpty())
    			{
    				this.itemFuelStackSize = this.inventory.getStackInSlot(0).getCount();
    					
    				this.itemFuelStack = this.itemFuelStackSize * this.getItemBurnTime(this.inventory.getStackInSlot(0));
    			}
    			else
    			{
    				this.itemFuelStack = 0;
    				this.itemFuelStackSize = 0;
    			}
            }
    		else
    		{
    			this.itemFuelStack = 0;
    			this.itemFuelStackSize = 0;
    		}
    	}
    }
    
    
    
	//==================================//
  	// TODO    Root Getter Methods      //
  	//==================================//
    
    /**
     * Gets the airship type.
     */
    public void updateAirshipMeta()
    {
        if (this.world.isRemote)
        {
        	this.airshipBurnTime = this.getPowered();
        	this.airshipTotalBurnTime = this.getTotalPowered();
        	this.itemFuelStack = this.getItemFuelStackPowered();
			this.itemFuelStackSize = this.getItemFuelStackSizePowered();
			
        	this.metaTierCore = this.getMetaTierCore();
        	this.metaTierFrame = this.getMetaTierFrame();
        	this.metaTierEngine = this.getMetaTierEngine();
        	this.metaTierBalloon = this.getMetaTierBalloon();
        	
            this.metaFrameVisual = this.getFrameVisual();
            this.metaFrameVisualTransparent = this.getFrameVisualTransparent();
            this.metaFrameVisualColor = this.getFrameVisualColor();
            this.metaFrameColorRed = this.getFrameColorRed();
            this.metaFrameColorGreen = this.getFrameColorGreen();
            this.metaFrameColorBlue = this.getFrameColorBlue();
            
            this.metaCoreVisual = this.getCoreVisual();
            
            this.metaEngineVisual = this.getEngineVisual();
            
            this.metaBalloonVisual = this.getBalloonVisual();
            this.metaBalloonVisualTransparent = this.getBalloonVisualTransparent();
            this.metaBalloonVisualColor = this.getBalloonVisualColor();
            this.metaBalloonColorRed = this.getBalloonColorRed();
            this.metaBalloonColorGreen = this.getBalloonColorGreen();
            this.metaBalloonColorBlue = this.getBalloonColorBlue();
            
            this.metaModuleVariantSlot1 = this.getModuleVariantSlot1();
            
            this.metaJukeboxSelectedSong = this.getJukeboxSelectedSong();
            this.metaCruiseControlSelectedSpeed = this.getCruiseControlSelectedSpeed();
            
            this.learnedModuleAltitude = this.getModuleLearnedAltitude();
            this.selectedModuleAltitude = this.getModuleSelectedAltitude();
            this.learnedModuleSpeed = this.getModuleLearnedSpeed();
            this.selectedModuleSpeed = this.getModuleSelectedSpeed();
            this.learnedModuleStorage = this.getModuleLearnedStorage();
            this.selectedModuleStorage = this.getModuleSelectedStorage();
            this.learnedModuleFuel = this.getModuleLearnedFuel();
            this.selectedModuleFuel = this.getModuleSelectedFuel();
            this.learnedModuleMusic = this.getModuleLearnedMusic();
            this.selectedModuleMusic = this.getModuleSelectedMusic();
            this.learnedModuleCruise = this.getModuleLearnedCruise();
            this.selectedModuleCruise = this.getModuleSelectedCruise();
            this.learnedModuleWater = this.getModuleLearnedWater();
            this.selectedModuleWater = this.getModuleSelectedWater();
            this.learnedModuleFuelInfinite = this.getModuleLearnedFuelInfinite();
            this.selectedModuleFuelInfinite = this.getModuleSelectedFuelInfinite();
        }
    	
        if(!this.world.isRemote)
		{
        	this.setPowered(this.airshipBurnTime);
        	this.setTotalPowered(this.airshipTotalBurnTime);
        	this.setItemFuelStackPowered(this.itemFuelStack);
			this.setItemFuelStackSizePowered(this.itemFuelStackSize);
			
        	this.setMetaTierCore(this.metaTierCore);
        	this.setMetaTierFrame(this.metaTierFrame);
        	this.setMetaTierEngine(this.metaTierEngine);
        	this.setMetaTierBalloon(this.metaTierBalloon);
        	
            this.setFrameVisual(this.metaFrameVisual);
            this.setFrameVisualTransparent(this.metaFrameVisualTransparent);
            this.setFrameVisualColor(this.metaFrameVisualColor);
            this.setFrameColorRed(this.metaFrameColorRed);
            this.setFrameColorGreen(this.metaFrameColorGreen);
            this.setFrameColorBlue(this.metaFrameColorBlue);
            
            this.setCoreVisual(this.metaCoreVisual);
            
            this.setEngineVisual(this.metaEngineVisual);
            
            this.setBalloonVisual(this.metaBalloonVisual);
            this.setBalloonVisualTransparent(this.metaBalloonVisualTransparent);
            this.setBalloonVisualColor(this.metaBalloonVisualColor);
            this.setBalloonColorRed(this.metaBalloonColorRed);
            this.setBalloonColorGreen(this.metaBalloonColorGreen);
            this.setBalloonColorBlue(this.metaBalloonColorBlue);
            
            this.setModuleVariantSlot1(this.metaModuleVariantSlot1);
            
            this.setJukeboxSelectedSong(this.metaJukeboxSelectedSong);
            this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
            
            this.setModuleLearnedAltitude(this.learnedModuleAltitude);
            this.setModuleSelectedAltitude(this.selectedModuleAltitude);
            this.setModuleLearnedSpeed(this.learnedModuleSpeed);
            this.setModuleSelectedSpeed(this.selectedModuleSpeed);
            this.setModuleLearnedStorage(this.learnedModuleStorage);
            this.setModuleSelectedStorage(this.selectedModuleStorage);
            this.setModuleLearnedFuel(this.learnedModuleFuel);
            this.setModuleSelectedFuel(this.selectedModuleFuel);
            this.setModuleLearnedMusic(this.learnedModuleMusic);
            this.setModuleSelectedMusic(this.selectedModuleMusic);
            this.setModuleLearnedCruise(this.learnedModuleCruise);
            this.setModuleSelectedCruise(this.selectedModuleCruise);
            this.setModuleLearnedWater(this.learnedModuleWater);
            this.setModuleSelectedWater(this.selectedModuleWater);
            this.setModuleLearnedFuelInfinite(this.learnedModuleFuelInfinite);
            this.setModuleSelectedFuelInfinite(this.selectedModuleFuelInfinite);
		}
    }
    
    //======================================================================================
    
    /**
     * Sets the Core Tier.
     */
    public void setMetaTierCore(int airshipTierCore0)
    {
        this.dataManager.set(AIRSHIP_TIER_CORE, Integer.valueOf(airshipTierCore0));
    }
    /**
     * Gets the Core Tier.
     */
    public int getMetaTierCore()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TIER_CORE)).intValue();
    }
    /**
     * Sets the Frame Tier.
     */
    public void setMetaTierFrame(int airshipTierFrame0)
    {
        this.dataManager.set(AIRSHIP_TIER_FRAME, Integer.valueOf(airshipTierFrame0));
    }
    /**
     * Gets the Frame Tier.
     */
    public int getMetaTierFrame()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TIER_FRAME)).intValue();
    }
    /**
     * Sets the Engine Tier.
     */
    public void setMetaTierEngine(int airshipTierEngine0)
    {
        this.dataManager.set(AIRSHIP_TIER_ENGINE, Integer.valueOf(airshipTierEngine0));
    }
    /**
     * Gets the Engine Tier.
     */
    public int getMetaTierEngine()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TIER_ENGINE)).intValue();
    }
    /**
     * Sets the Balloon Tier.
     */
    public void setMetaTierBalloon(int airshipTierBalloon0)
    {
        this.dataManager.set(AIRSHIP_TIER_BALLOON, Integer.valueOf(airshipTierBalloon0));
    }
    /**
     * Gets the Balloon Tier.
     */
    public int getMetaTierBalloon()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_TIER_BALLOON)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Frame.
     */
    public void setFrameVisual(int airshipVisualFrame0)
    {
        this.dataManager.set(AIRSHIP_FRAME_VISUAL, Integer.valueOf(airshipVisualFrame0));
    }
    /**
     * Gets the Visual Frame.
     */
    public int getFrameVisual()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_FRAME_VISUAL)).intValue();
    }
    /**
     * Sets the Frame Transparency.
     */
    public void setFrameVisualTransparent(boolean airshipFrameTransparent0)
    {
        this.dataManager.set(AIRSHIP_FRAME_VISUAL_TRANSPARENT, Boolean.valueOf(airshipFrameTransparent0));
    }
    /**
     * Gets the Frame Transparency.
     */
    public boolean getFrameVisualTransparent()
    {
        return ((Boolean)this.dataManager.get(AIRSHIP_FRAME_VISUAL_TRANSPARENT)).booleanValue();
    }
    /**
     * Sets the Frame Color.
     */
    public void setFrameVisualColor(boolean airshipFrameColor0)
    {
        this.dataManager.set(AIRSHIP_FRAME_VISUAL_COLOR, Boolean.valueOf(airshipFrameColor0));
    }
    /**
     * Gets the Frame Color.
     */
    public boolean getFrameVisualColor()
    {
        return ((Boolean)this.dataManager.get(AIRSHIP_FRAME_VISUAL_COLOR)).booleanValue();
    }
    /**
     * Sets the Frame Color Red.
     */
    public void setFrameColorRed(int airshipFrameRed0)
    {
        this.dataManager.set(AIRSHIP_FRAME_COLOR_RED, Integer.valueOf(airshipFrameRed0));
    }
    /**
     * Gets the Frame Color Red.
     */
    public int getFrameColorRed()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_FRAME_COLOR_RED)).intValue();
    }
    /**
     * Sets the Frame Color Green.
     */
    public void setFrameColorGreen(int airshipFrameGreen0)
    {
        this.dataManager.set(AIRSHIP_FRAME_COLOR_GREEN, Integer.valueOf(airshipFrameGreen0));
    }
    /**
     * Gets the Frame Color Green.
     */
    public int getFrameColorGreen()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_FRAME_COLOR_GREEN)).intValue();
    }
    /**
     * Sets the Frame Color Blue.
     */
    public void setFrameColorBlue(int airshipFrameBlue0)
    {
        this.dataManager.set(AIRSHIP_FRAME_COLOR_BLUE, Integer.valueOf(airshipFrameBlue0));
    }
    /**
     * Gets the Frame Color Blue.
     */
    public int getFrameColorBlue()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_FRAME_COLOR_BLUE)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Core pattern.
     */
    public void setCoreVisual(int airshipVisualCore0)
    {
        this.dataManager.set(AIRSHIP_CORE_VISUAL, Integer.valueOf(airshipVisualCore0));
    }
    /**
     * Gets the Visual Core pattern.
     */
    public int getCoreVisual()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_CORE_VISUAL)).intValue();
    }
    
    
    //======================================================================================
    
    /**
     * Sets the Visual Engine pattern.
     */
    public void setEngineVisual(int airshipVisualEngine0)
    {
        this.dataManager.set(AIRSHIP_ENGINE_VISUAL, Integer.valueOf(airshipVisualEngine0));
    }
    /**
     * Gets the Visual Engine pattern.
     */
    public int getEngineVisual()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_ENGINE_VISUAL)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Balloon pattern.
     */
    public void setBalloonVisual(int airshipVisualBalloon0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_VISUAL, Integer.valueOf(airshipVisualBalloon0));
    }
    /**
     * Gets the Visual Balloon pattern.
     */
    public int getBalloonVisual()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_BALLOON_VISUAL)).intValue();
    }
    /**
     * Sets the Balloon Transparency.
     */
    public void setBalloonVisualTransparent(boolean airshipBalloonTransparent0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_VISUAL_TRANSPARENT, Boolean.valueOf(airshipBalloonTransparent0));
    }
    /**
     * Gets the Balloon Transparency.
     */
    public boolean getBalloonVisualTransparent()
    {
        return ((Boolean)this.dataManager.get(AIRSHIP_BALLOON_VISUAL_TRANSPARENT)).booleanValue();
    }
    /**
     * Sets the Balloon Color.
     */
    public void setBalloonVisualColor(boolean airshipBalloonColor0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_VISUAL_COLOR, Boolean.valueOf(airshipBalloonColor0));
    }
    /**
     * Gets the Balloon Color.
     */
    public boolean getBalloonVisualColor()
    {
        return ((Boolean)this.dataManager.get(AIRSHIP_BALLOON_VISUAL_COLOR)).booleanValue();
    }
    /**
     * Sets the Balloon Color Red.
     */
    public void setBalloonColorRed(int airshipBalloonRed0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_COLOR_RED, Integer.valueOf(airshipBalloonRed0));
    }
    /**
     * Gets the Balloon Color Red.
     */
    public int getBalloonColorRed()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_BALLOON_COLOR_RED)).intValue();
    }
    /**
     * Sets the Balloon Color Green.
     */
    public void setBalloonColorGreen(int airshipBalloonGreen0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_COLOR_GREEN, Integer.valueOf(airshipBalloonGreen0));
    }
    /**
     * Gets the Balloon Color Green.
     */
    public int getBalloonColorGreen()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_BALLOON_COLOR_GREEN)).intValue();
    }
    /**
     * Sets the Balloon Color Blue.
     */
    public void setBalloonColorBlue(int airshipBalloonBlue0)
    {
        this.dataManager.set(AIRSHIP_BALLOON_COLOR_BLUE, Integer.valueOf(airshipBalloonBlue0));
    }
    /**
     * Gets the Balloon Color Blue.
     */
    public int getBalloonColorBlue()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_BALLOON_COLOR_BLUE)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Slot1 Module Variant.
     */
    public void setModuleVariantSlot1(int modulesVariantSlot1)
    {
        this.dataManager.set(MODULE_SLOT1_VARIANT, Integer.valueOf(modulesVariantSlot1));
    }
    /**
     * Gets the Slot1 Module Variant.
     */
    public int getModuleVariantSlot1()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_VARIANT)).intValue();
    }
    
    /**
     * Sets the jukebox selected song.
     */
    public void setJukeboxSelectedSong(int jukeboxSelectedSong0)
    {
        this.dataManager.set(MODULE_JUKEBOX_SELECTED_SONG, Integer.valueOf(jukeboxSelectedSong0));
    }
    /**
     * Gets the jukebox selected song.
     */
	public int getJukeboxSelectedSong()
    {
        return ((Integer)this.dataManager.get(MODULE_JUKEBOX_SELECTED_SONG)).intValue();
    }
	
	/**
     * Sets the Cruise Control selected speed.
     */
    public void setCruiseControlSelectedSpeed(int cruiseControlSelectedSpeed0)
    {
        this.dataManager.set(MODULE_CRUISECONTROL_SELECTED_SPEED, Integer.valueOf(cruiseControlSelectedSpeed0));
    }
    /**
     * Gets the Cruise Control selected speed.
     */
    public int getCruiseControlSelectedSpeed()
    {
        return ((Integer)this.dataManager.get(MODULE_CRUISECONTROL_SELECTED_SPEED)).intValue();
    }
    
    //======================================================================================
    
	/**
     * Sets the Airship Burn Time.
     */
    public void setPowered(int airshipBurnTime1)
    {
        this.dataManager.set(AIRSHIP_POWERED, Integer.valueOf(airshipBurnTime1));
    }
    /**
     * Gets the Airship Burn Time.
     */
    public int getPowered()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_POWERED)).intValue();
    }
    
    /**
     * Sets the Airship Total Burn Time.
     */
    public void setTotalPowered(int airshipTotalBurnTime1)
    {
        this.dataManager.set(AIRSHIP_POWERED_TOTAL, Integer.valueOf(airshipTotalBurnTime1));
    }
    /**
     * Gets the Airship Total Burn Time.
     */
    public int getTotalPowered()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_POWERED_TOTAL)).intValue();
    }
    
    /**
     * Sets the Item Fuel Stack.
     */
    public void setItemFuelStackPowered(int itemFuelStack1)
    {
        this.dataManager.set(AIRSHIP_ITEMFUELSTACK_POWERED, Integer.valueOf(itemFuelStack1));
    }
    /**
     * Gets the Item Fuel Stack.
     */
    public int getItemFuelStackPowered()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_ITEMFUELSTACK_POWERED)).intValue();
    }
    
	/**
     * Sets the Item Fuel Stack Size.
     */
    public void setItemFuelStackSizePowered(int itemFuelStackSize1)
    {
        this.dataManager.set(AIRSHIP_ITEMFUELSTACK_POWERED_SIZE, Integer.valueOf(itemFuelStackSize1));
    }
    /**
     * Gets the Item Fuel Stack Size.
     */
    public int getItemFuelStackSizePowered()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_ITEMFUELSTACK_POWERED_SIZE)).intValue();
    }
    
    //======================================================================================
    
	/**
     * Sets the Int of Module Altitude.
     */
    public void setModuleSelectedAltitude(int moduleSelectedAltitude)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_ALTITUDE, Integer.valueOf(moduleSelectedAltitude));
    }
    /**
     * Gets the Int of Module Altitude.
     */
    public int getModuleSelectedAltitude()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_ALTITUDE)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Altitude.
     */
    public void setModuleLearnedAltitude(boolean moduleLearnedAltitude)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_ALTITUDE, Boolean.valueOf(moduleLearnedAltitude));
    }
    /**
     * Gets the Learned boolean of Module Altitude.
     */
    public boolean getModuleLearnedAltitude()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_ALTITUDE)).booleanValue();
    }

	/**
     * Sets the Int of Module Speed.
     */
    public void setModuleSelectedSpeed(int moduleSelectedSpeed)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_SPEED, Integer.valueOf(moduleSelectedSpeed));
    }
    /**
     * Gets the Int of Module Speed.
     */
    public int getModuleSelectedSpeed()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_SPEED)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Speed.
     */
    public void setModuleLearnedSpeed(boolean moduleLearnedSpeed)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_SPEED, Boolean.valueOf(moduleLearnedSpeed));
    }
    /**
     * Gets the Learned boolean of Module Speed.
     */
    public boolean getModuleLearnedSpeed()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_SPEED)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Storage.
     */
    public void setModuleSelectedStorage(int moduleSelectedStorage)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_STORAGE, Integer.valueOf(moduleSelectedStorage));
    }
    /**
     * Gets the Int of Module Storage.
     */
    public int getModuleSelectedStorage()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_STORAGE)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Storage.
     */
    public void setModuleLearnedStorage(boolean moduleLearnedStorage)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_STORAGE, Boolean.valueOf(moduleLearnedStorage));
    }
    /**
     * Gets the Learned boolean of Module Storage.
     */
    public boolean getModuleLearnedStorage()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_STORAGE)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Fuel.
     */
    public void setModuleSelectedFuel(int moduleSelectedFuel)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_FUEL, Integer.valueOf(moduleSelectedFuel));
    }
    /**
     * Gets the Int of Module Fuel.
     */
    public int getModuleSelectedFuel()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_FUEL)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Fuel.
     */
    public void setModuleLearnedFuel(boolean moduleLearnedFuel)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_FUEL, Boolean.valueOf(moduleLearnedFuel));
    }
    /**
     * Gets the Learned boolean of Module Fuel.
     */
    public boolean getModuleLearnedFuel()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_FUEL)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Music.
     */
    public void setModuleSelectedMusic(int moduleSelectedMusic)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_MUSIC, Integer.valueOf(moduleSelectedMusic));
    }
    /**
     * Gets the Int of Module Music.
     */
    public int getModuleSelectedMusic()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_MUSIC)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Music.
     */
    public void setModuleLearnedMusic(boolean moduleLearnedMusic)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_MUSIC, Boolean.valueOf(moduleLearnedMusic));
    }
    /**
     * Gets the Learned boolean of Module Music.
     */
    public boolean getModuleLearnedMusic()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_MUSIC)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Cruise.
     */
    public void setModuleSelectedCruise(int moduleSelectedCruise)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_CRUISE, Integer.valueOf(moduleSelectedCruise));
    }
    /**
     * Gets the Int of Module Cruise.
     */
    public int getModuleSelectedCruise()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_CRUISE)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Cruise.
     */
    public void setModuleLearnedCruise(boolean moduleLearnedCruise)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_CRUISE, Boolean.valueOf(moduleLearnedCruise));
    }
    /**
     * Gets the Learned boolean of Module Cruise.
     */
    public boolean getModuleLearnedCruise()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_CRUISE)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Water.
     */
    public void setModuleSelectedWater(int moduleSelectedWater)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_WATER, Integer.valueOf(moduleSelectedWater));
    }
    /**
     * Gets the Int of Module Water.
     */
    public int getModuleSelectedWater()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_WATER)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Water.
     */
    public void setModuleLearnedWater(boolean moduleLearnedWater)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_WATER, Boolean.valueOf(moduleLearnedWater));
    }
    /**
     * Gets the Learned boolean of Module Water.
     */
    public boolean getModuleLearnedWater()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_WATER)).booleanValue();
    }
    
    /**
     * Sets the Int of Module FuelInfinite.
     */
    public void setModuleSelectedFuelInfinite(int moduleSelectedFuelInfinite)
    {
        this.dataManager.set(MODULE_SLOT1_SELECTED_FUELINFINITE, Integer.valueOf(moduleSelectedFuelInfinite));
    }
    /**
     * Gets the Int of Module FuelInfinite.
     */
    public int getModuleSelectedFuelInfinite()
    {
        return ((Integer)this.dataManager.get(MODULE_SLOT1_SELECTED_FUELINFINITE)).intValue();
    }
    /**
     * Sets the Learned boolean of Module FuelInfinite.
     */
    public void setModuleLearnedFuelInfinite(boolean moduleLearnedFuelInfinite)
    {
        this.dataManager.set(MODULE_SLOT1_LEARNED_FUELINFINITE, Boolean.valueOf(moduleLearnedFuelInfinite));
    }
    /**
     * Gets the Learned boolean of Module FuelInfinite.
     */
    public boolean getModuleLearnedFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_SLOT1_LEARNED_FUELINFINITE)).booleanValue();
    }
    
    
    
    
    
    
    
    
    
    
    //==================================//
    // TODO          Enums              //
	//==================================//
    
    /**
	 * TO BE REMOVED.
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
        
        
        
        //GRAVEL(0, "Gravel", I18n.translateToLocal("vc.item.enum.frame.0"), 0F, 75),
        
        
        
        //GRANITE(6, "Granite", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        //DIORITE(6, "Diorite", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        //ANDESITE(6, "Andesite", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        SANDSTONE(6, "Sandstone", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        //STONE(0, "Stone", I18n.translateToLocal("vc.item.enum.frame.0"), 0F, 75),
        //////COBBLESTONE(6, "Cobblestone", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        BRICK(7, "Brick", I18n.translateToLocal("vc.item.enum.frame.7"), 0.002F, 90),
        
        //Uncommon - 7 items
        //////MOSSYCOBBLESTONE(6, "Mossy Cobblestone", I18n.translateToLocal("vc.item.enum.frame.6"), 0.001F, 80),
        
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
    
}

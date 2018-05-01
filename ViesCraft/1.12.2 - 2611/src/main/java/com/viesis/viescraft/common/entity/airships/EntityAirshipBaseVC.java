package com.viesis.viescraft.common.entity.airships;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
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
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipBaseVC extends EntityBaseVC {
	
	protected static final DataParameter<String> CUSTOM_NAME_DM = EntityDataManager.<String>createKey(EntityAirshipBaseVC.class, DataSerializers.STRING);
  	
	//Fuel system
  	protected static final DataParameter<Integer> STORED_FUEL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> STORED_FUEL_TOTAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> FUEL_ITEMSTACK_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> FUEL_ITEMSTACK_SIZE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> STORED_REDSTONE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> STORED_REDSTONE_TOTAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	
  	//Tier system
  	protected static final DataParameter<Integer> MAIN_TIER_CORE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> MAIN_TIER_FRAME_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> MAIN_TIER_ENGINE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	protected static final DataParameter<Integer> MAIN_TIER_BALLOON_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
  	
    //Core system
    protected static final DataParameter<Integer> CORE_MODEL_VISUAL_FRAME_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> CORE_MODEL_VISUAL_ENGINE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> CORE_MODEL_VISUAL_BALLOON_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Frame system
    protected static final DataParameter<Integer> FRAME_SKIN_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> FRAME_SKIN_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Integer> FRAME_SKIN_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> FRAME_SKIN_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> FRAME_SKIN_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Engine system
    protected static final DataParameter<Integer> ENGINE_PARTICLE_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_TYPE_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_ITEMSTACK_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_HEAD_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> ENGINE_DISPLAY_HOLIDAY_VISUAL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Balloon system
    protected static final DataParameter<Integer> BALLOON_PATTERN_TEXTURE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Boolean> BALLOON_PATTERN_TRANSPARENT_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
    protected static final DataParameter<Integer> BALLOON_PATTERN_COLOR_RED_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_PATTERN_COLOR_GREEN_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    protected static final DataParameter<Integer> BALLOON_PATTERN_COLOR_BLUE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
    
    //Module system
    protected static final DataParameter<Integer> MODULE_ACTIVE_SLOT1_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
    protected static final DataParameter<Integer> MODULE_JUKEBOX_SELECTED_SONG_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> MODULE_CRUISECONTROL_SELECTED_SPEED_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	protected static final DataParameter<Boolean> MODULE_LEARNED_ALTITUDE_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_ALTITUDE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_SPEED_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_SPEED_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_STORAGE_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_STORAGE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_FUEL_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_FUEL_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_MUSIC_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_MUSIC_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_CRUISE_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_CRUISE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_WATER_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_WATER_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_FUELINFINITE_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_FUELINFINITE_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	protected static final DataParameter<Boolean> MODULE_LEARNED_BOMB_DM = EntityDataManager.<Boolean>createKey(EntityAirshipBaseVC.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Integer> MODULE_SELECTED_BOMB_DM = EntityDataManager.<Integer>createKey(EntityAirshipBaseVC.class, DataSerializers.VARINT);
	
	
	
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
	 * Slot 16 = Display Banner <br> 
	 * Slot 20-28 = Inventory Small <br>
	 * Slot 20-37 = Inventory Large <br>
	 */
    public ItemStackHandler inventory;
    protected int size = 64;
    
    public String customName = "Airship";
	
	//Fuel
	public int storedFuel;
	public int storedFuelTotal;
	public int fuelItemStack;
	public int fuelItemStackSize;
	public int storedRedstone;
	public int storedRedstoneTotal;
	
	public int airshipFuelTick;
	
    //Main setters/getters
	public int mainTierCore;
	public int mainTierFrame;
	public int mainTierEngine;
	public int mainTierBalloon;
	
	public int coreModelVisualFrame;
	public int coreModelVisualEngine;
	public int coreModelVisualBalloon;
	
	public int frameSkinTexture;
	public boolean frameSkinTransparent;
	public int frameSkinColorRed;
	public int frameSkinColorGreen;
	public int frameSkinColorBlue;
	
	public int engineParticleVisual;
	public int engineDisplayTypeVisual;
	public int engineDisplayItemstackVisual;
	public int engineDisplayItemstackMetaVisual;
	public int engineDisplayHeadVisual;
	public int engineDisplaySupporterHeadVisual;
	public int engineDisplayHolidayVisual;
	
	public int balloonPatternTexture;
	public boolean balloonPatternTransparent;
	public int balloonPatternColorRed;
	public int balloonPatternColorGreen;
	public int balloonPatternColorBlue;
	
    //Movement logic
    public float AirshipSpeedTurn;
    public float AirshipSpeedForward;
    public float AirshipSpeedUp;
    public float AirshipSpeedDown;
    
    protected boolean canDrop;
	
	public float speedModifier;
	
	//Modules
	public int moduleActiveSlot1;
	
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
	/** Selected Bomb */
	public int selectedModuleBomb;
	/** Learned Bomb */
	public boolean learnedModuleBomb;
	
    References rf;
	
	
	
    public EntityAirshipBaseVC(World worldIn)
    {
        super(worldIn);
        
        this.inventory = new ItemStackHandler(size);
    }
    
    public EntityAirshipBaseVC(World worldIn, double x, double y, double z, 
    		int coreTierIn, int frameTierIn, int engineTierIn, int balloonTierIn, 
    		int moduleSlot1In, 
    		int fuelIn, int fuelTotalIn, int redstoneIn, int redstoneTotalIn,
    		
    		int coreModelVisualFrameIn, 
    		int coreModelVisualEngineIn, 
    		int coreModelVisualBalloonIn, 
    		
    		int frameSkinTextureIn, 
    		boolean frameSkinTransparentIn, 
    		int frameSkinColorRedIn, int frameSkinColorGreenIn, int frameSkinColorBlueIn,
    		
    		int engineParticleVisualIn, 
    		int engineDisplayTypeVisualIn, 
    		int engineDisplayItemStackVisualIn, int engineDisplayItemStackMetaVisualIn,
    		int engineDisplayHeadVisualIn, 
    		int engineDisplaySupporterHeadVisualIn, 
    		int engineDisplayHolidayVisualIn, 
    		
    		int balloonPatternTextureIn, 
    		boolean balloonPatternTransparentIn, 
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
    public void entityInit()
    {
    	super.entityInit();
    	
    	this.dataManager.register(CUSTOM_NAME_DM, String.valueOf(this.customName));
        
		this.dataManager.register(STORED_FUEL_DM, Integer.valueOf(this.storedFuel));
        this.dataManager.register(STORED_FUEL_TOTAL_DM, Integer.valueOf(this.storedFuelTotal));
        this.dataManager.register(FUEL_ITEMSTACK_DM, Integer.valueOf(this.fuelItemStack));
        this.dataManager.register(FUEL_ITEMSTACK_SIZE_DM, Integer.valueOf(this.fuelItemStackSize));
        this.dataManager.register(STORED_REDSTONE_DM, Integer.valueOf(this.storedRedstone));
        this.dataManager.register(STORED_REDSTONE_TOTAL_DM, Integer.valueOf(this.storedRedstoneTotal));
        
        this.dataManager.register(MAIN_TIER_CORE_DM, Integer.valueOf(this.mainTierCore));
        this.dataManager.register(MAIN_TIER_FRAME_DM, Integer.valueOf(this.mainTierFrame));
        this.dataManager.register(MAIN_TIER_ENGINE_DM, Integer.valueOf(this.mainTierEngine));
        this.dataManager.register(MAIN_TIER_BALLOON_DM, Integer.valueOf(this.mainTierBalloon));
        
        this.dataManager.register(CORE_MODEL_VISUAL_FRAME_DM, Integer.valueOf(this.coreModelVisualFrame));
        this.dataManager.register(CORE_MODEL_VISUAL_ENGINE_DM, Integer.valueOf(this.coreModelVisualEngine));
        this.dataManager.register(CORE_MODEL_VISUAL_BALLOON_DM, Integer.valueOf(this.coreModelVisualBalloon));
        
        this.dataManager.register(FRAME_SKIN_TEXTURE_DM, Integer.valueOf(this.frameSkinTexture));
        this.dataManager.register(FRAME_SKIN_TRANSPARENT_DM, Boolean.valueOf(this.frameSkinTransparent));
        this.dataManager.register(FRAME_SKIN_COLOR_RED_DM, Integer.valueOf(this.frameSkinColorRed));
        this.dataManager.register(FRAME_SKIN_COLOR_GREEN_DM, Integer.valueOf(this.frameSkinColorGreen));
        this.dataManager.register(FRAME_SKIN_COLOR_BLUE_DM, Integer.valueOf(this.frameSkinColorBlue));
        
        this.dataManager.register(ENGINE_PARTICLE_VISUAL_DM, Integer.valueOf(this.engineParticleVisual));
        this.dataManager.register(ENGINE_DISPLAY_TYPE_VISUAL_DM, Integer.valueOf(this.engineDisplayTypeVisual));
        this.dataManager.register(ENGINE_DISPLAY_ITEMSTACK_VISUAL_DM, Integer.valueOf(this.engineDisplayItemstackVisual));
        this.dataManager.register(ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_DM, Integer.valueOf(this.engineDisplayItemstackMetaVisual));
        this.dataManager.register(ENGINE_DISPLAY_HEAD_VISUAL_DM, Integer.valueOf(this.engineDisplayHeadVisual));
        this.dataManager.register(ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_DM, Integer.valueOf(this.engineDisplaySupporterHeadVisual));
        this.dataManager.register(ENGINE_DISPLAY_HOLIDAY_VISUAL_DM, Integer.valueOf(this.engineDisplayHolidayVisual));
        
        this.dataManager.register(BALLOON_PATTERN_TEXTURE_DM, Integer.valueOf(this.balloonPatternTexture));
        this.dataManager.register(BALLOON_PATTERN_TRANSPARENT_DM, Boolean.valueOf(this.balloonPatternTransparent));
        this.dataManager.register(BALLOON_PATTERN_COLOR_RED_DM, Integer.valueOf(this.balloonPatternColorRed));
        this.dataManager.register(BALLOON_PATTERN_COLOR_GREEN_DM, Integer.valueOf(this.balloonPatternColorGreen));
        this.dataManager.register(BALLOON_PATTERN_COLOR_BLUE_DM, Integer.valueOf(this.balloonPatternColorBlue));
        
        this.dataManager.register(MODULE_ACTIVE_SLOT1_DM, Integer.valueOf(this.moduleActiveSlot1));
        
        this.dataManager.register(MODULE_JUKEBOX_SELECTED_SONG_DM, Integer.valueOf(this.metaJukeboxSelectedSong));
        this.dataManager.register(MODULE_CRUISECONTROL_SELECTED_SPEED_DM, Integer.valueOf(this.metaCruiseControlSelectedSpeed));
        
        this.dataManager.register(MODULE_SELECTED_ALTITUDE_DM, Integer.valueOf(this.selectedModuleAltitude));
        this.dataManager.register(MODULE_LEARNED_ALTITUDE_DM, Boolean.valueOf(this.learnedModuleAltitude));
        this.dataManager.register(MODULE_SELECTED_SPEED_DM, Integer.valueOf(this.selectedModuleSpeed));
        this.dataManager.register(MODULE_LEARNED_SPEED_DM, Boolean.valueOf(this.learnedModuleSpeed));
        this.dataManager.register(MODULE_SELECTED_STORAGE_DM, Integer.valueOf(this.selectedModuleStorage));
        this.dataManager.register(MODULE_LEARNED_STORAGE_DM, Boolean.valueOf(this.learnedModuleStorage));
        this.dataManager.register(MODULE_SELECTED_FUEL_DM, Integer.valueOf(this.selectedModuleFuel));
        this.dataManager.register(MODULE_LEARNED_FUEL_DM, Boolean.valueOf(this.learnedModuleFuel));
        this.dataManager.register(MODULE_SELECTED_MUSIC_DM, Integer.valueOf(this.selectedModuleMusic));
        this.dataManager.register(MODULE_LEARNED_MUSIC_DM, Boolean.valueOf(this.learnedModuleMusic));
        this.dataManager.register(MODULE_SELECTED_CRUISE_DM, Integer.valueOf(this.selectedModuleCruise));
        this.dataManager.register(MODULE_LEARNED_CRUISE_DM, Boolean.valueOf(this.learnedModuleCruise));
        this.dataManager.register(MODULE_SELECTED_WATER_DM, Integer.valueOf(this.selectedModuleWater));
        this.dataManager.register(MODULE_LEARNED_WATER_DM, Boolean.valueOf(this.learnedModuleWater));
        this.dataManager.register(MODULE_SELECTED_FUELINFINITE_DM, Integer.valueOf(this.selectedModuleFuelInfinite));
        this.dataManager.register(MODULE_LEARNED_FUELINFINITE_DM, Boolean.valueOf(this.learnedModuleFuelInfinite));
        this.dataManager.register(MODULE_SELECTED_BOMB_DM, Integer.valueOf(this.selectedModuleBomb));
        this.dataManager.register(MODULE_LEARNED_BOMB_DM, Boolean.valueOf(this.learnedModuleBomb));
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
    	
    	if (this.customName != null)
        {
    		compound.setString(rf.CUSTOM_NAME_TAG, this.customName);
        }
    	
    	compound.setTag(rf.AIRSHIP_SLOTS_TAG, this.inventory.serializeNBT());
    	
    	compound.setInteger(rf.MAIN_TIER_CORE_TAG, this.mainTierCore);
    	compound.setInteger(rf.MAIN_TIER_FRAME_TAG, this.mainTierFrame);
    	compound.setInteger(rf.MAIN_TIER_ENGINE_TAG, this.mainTierEngine);
    	compound.setInteger(rf.MAIN_TIER_BALLOON_TAG, this.mainTierBalloon);
    	
    	compound.setInteger(rf.CORE_MODEL_VISUAL_FRAME_TAG, this.coreModelVisualFrame);
    	compound.setInteger(rf.CORE_MODEL_VISUAL_ENGINE_TAG, this.coreModelVisualEngine);
    	compound.setInteger(rf.CORE_MODEL_VISUAL_BALLOON_TAG, this.coreModelVisualBalloon);
    	
    	compound.setInteger(rf.FRAME_SKIN_TEXTURE_TAG, this.frameSkinTexture);
    	compound.setBoolean(rf.FRAME_SKIN_TRANSPARENT_TAG, this.frameSkinTransparent);
    	compound.setInteger(rf.FRAME_SKIN_COLOR_RED_TAG, this.frameSkinColorRed);
    	compound.setInteger(rf.FRAME_SKIN_COLOR_GREEN_TAG, this.frameSkinColorGreen);
    	compound.setInteger(rf.FRAME_SKIN_COLOR_BLUE_TAG, this.frameSkinColorBlue);
    	
    	compound.setInteger(rf.ENGINE_PARTICLE_VISUAL_TAG, this.engineParticleVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_TYPE_VISUAL_TAG, this.engineDisplayTypeVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_ITEMSTACK_VISUAL_TAG, this.engineDisplayItemstackVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_TAG, this.engineDisplayItemstackMetaVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_HEAD_VISUAL_TAG, this.engineDisplayHeadVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_TAG, this.engineDisplaySupporterHeadVisual);
    	compound.setInteger(rf.ENGINE_DISPLAY_HOLIDAY_VISUAL_TAG, this.engineDisplayHolidayVisual);
    	
    	compound.setInteger(rf.BALLOON_PATTERN_TEXTURE_TAG, this.balloonPatternTexture);
    	compound.setBoolean(rf.BALLOON_PATTERN_TRANSPARENT_TAG, this.balloonPatternTransparent);
    	compound.setInteger(rf.BALLOON_PATTERN_COLOR_RED_TAG, this.balloonPatternColorRed);
    	compound.setInteger(rf.BALLOON_PATTERN_COLOR_GREEN_TAG, this.balloonPatternColorGreen);
    	compound.setInteger(rf.BALLOON_PATTERN_COLOR_BLUE_TAG, this.balloonPatternColorBlue);
    	
    	compound.setInteger(rf.STORED_FUEL_TAG, this.storedFuel);
    	compound.setInteger(rf.STORED_FUEL_TOTAL_TAG, this.storedFuelTotal);
    	compound.setInteger(rf.FUEL_ITEMSTACK_TAG, this.fuelItemStack);
    	compound.setInteger(rf.FUEL_ITEMSTACK_SIZE_TAG, this.fuelItemStackSize);
    	compound.setInteger(rf.STORED_REDSTONE_TAG, this.storedRedstone);
    	compound.setInteger(rf.STORED_REDSTONE_TOTAL_TAG, this.storedRedstoneTotal);
    	
    	compound.setInteger(rf.MODULE_ACTIVE_SLOT1_TAG, this.moduleActiveSlot1);
		compound.setInteger(rf.JUKEBOX_SELECTED_SONG_TAG, this.metaJukeboxSelectedSong);
		
		compound.setBoolean(rf.LEARNED_MODULE_ALTITUDE_TAG, this.learnedModuleAltitude);
		compound.setInteger(rf.SELECTED_MODULE_ALTITUDE_TAG, this.selectedModuleAltitude);
		compound.setBoolean(rf.LEARNED_MODULE_SPEED_TAG, this.learnedModuleSpeed);
		compound.setInteger(rf.SELECTED_MODULE_SPEED_TAG, this.selectedModuleSpeed);
		compound.setBoolean(rf.LEARNED_MODULE_STORAGE_TAG, this.learnedModuleStorage);
		compound.setInteger(rf.SELECTED_MODULE_STORAGE_TAG, this.selectedModuleStorage);
		compound.setBoolean(rf.LEARNED_MODULE_FUEL_TAG, this.learnedModuleFuel);
		compound.setInteger(rf.SELECTED_MODULE_FUEL_TAG, this.selectedModuleFuel);
		compound.setBoolean(rf.LEARNED_MODULE_MUSIC_TAG, this.learnedModuleMusic);
		compound.setInteger(rf.SELECTED_MODULE_MUSIC_TAG, this.selectedModuleMusic);
		compound.setBoolean(rf.LEARNED_MODULE_CRUISE_TAG, this.learnedModuleCruise);
		compound.setInteger(rf.SELECTED_MODULE_CRUISE_TAG, this.selectedModuleCruise);
		compound.setBoolean(rf.LEARNED_MODULE_WATER_TAG, this.learnedModuleWater);
		compound.setInteger(rf.SELECTED_MODULE_WATER_TAG, this.selectedModuleWater);
		compound.setBoolean(rf.LEARNED_MODULE_FUELINFINITE_TAG, this.learnedModuleFuelInfinite);
		compound.setInteger(rf.SELECTED_MODULE_FUELINFINITE_TAG, this.selectedModuleFuelInfinite);
		compound.setBoolean(rf.LEARNED_MODULE_BOMB_TAG, this.learnedModuleBomb);
		compound.setInteger(rf.SELECTED_MODULE_BOMB_TAG, this.selectedModuleBomb);
		
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.customName = compound.getString(rf.CUSTOM_NAME_TAG);
    	
    	this.inventory.deserializeNBT(compound.getCompoundTag(rf.AIRSHIP_SLOTS_TAG));
    	
    	this.mainTierCore = compound.getInteger(rf.MAIN_TIER_CORE_TAG);
    	this.mainTierFrame = compound.getInteger(rf.MAIN_TIER_FRAME_TAG);
    	this.mainTierEngine = compound.getInteger(rf.MAIN_TIER_ENGINE_TAG);
    	this.mainTierBalloon = compound.getInteger(rf.MAIN_TIER_BALLOON_TAG);
    	
    	this.coreModelVisualFrame = compound.getInteger(rf.CORE_MODEL_VISUAL_FRAME_TAG);
    	this.coreModelVisualEngine = compound.getInteger(rf.CORE_MODEL_VISUAL_ENGINE_TAG);
    	this.coreModelVisualBalloon = compound.getInteger(rf.CORE_MODEL_VISUAL_BALLOON_TAG);
    	
    	this.frameSkinTexture = compound.getInteger(rf.FRAME_SKIN_TEXTURE_TAG);
    	this.frameSkinTransparent = compound.getBoolean(rf.FRAME_SKIN_TRANSPARENT_TAG);
    	this.frameSkinColorRed = compound.getInteger(rf.FRAME_SKIN_COLOR_RED_TAG);
    	this.frameSkinColorGreen = compound.getInteger(rf.FRAME_SKIN_COLOR_GREEN_TAG);
    	this.frameSkinColorBlue = compound.getInteger(rf.FRAME_SKIN_COLOR_BLUE_TAG);
    	
    	this.engineParticleVisual = compound.getInteger(rf.ENGINE_PARTICLE_VISUAL_TAG);
    	this.engineDisplayTypeVisual = compound.getInteger(rf.ENGINE_DISPLAY_TYPE_VISUAL_TAG);
    	this.engineDisplayItemstackVisual = compound.getInteger(rf.ENGINE_DISPLAY_ITEMSTACK_VISUAL_TAG);
    	this.engineDisplayItemstackMetaVisual = compound.getInteger(rf.ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_TAG);
    	this.engineDisplayHeadVisual = compound.getInteger(rf.ENGINE_DISPLAY_HEAD_VISUAL_TAG);
    	this.engineDisplaySupporterHeadVisual = compound.getInteger(rf.ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_TAG);
    	this.engineDisplayHolidayVisual = compound.getInteger(rf.ENGINE_DISPLAY_HOLIDAY_VISUAL_TAG);
    	
    	this.balloonPatternTexture = compound.getInteger(rf.BALLOON_PATTERN_TEXTURE_TAG);
    	this.balloonPatternTransparent = compound.getBoolean(rf.BALLOON_PATTERN_TRANSPARENT_TAG);
    	this.balloonPatternColorRed = compound.getInteger(rf.BALLOON_PATTERN_COLOR_RED_TAG);
    	this.balloonPatternColorGreen = compound.getInteger(rf.BALLOON_PATTERN_COLOR_GREEN_TAG);
    	this.balloonPatternColorBlue = compound.getInteger(rf.BALLOON_PATTERN_COLOR_BLUE_TAG);
    	
        this.storedFuel = compound.getInteger(rf.STORED_FUEL_TAG);
        this.storedFuelTotal = compound.getInteger(rf.STORED_FUEL_TOTAL_TAG);
        this.fuelItemStack = compound.getInteger(rf.FUEL_ITEMSTACK_TAG);
        this.fuelItemStackSize = compound.getInteger(rf.FUEL_ITEMSTACK_SIZE_TAG);
        this.storedRedstone = compound.getInteger(rf.STORED_REDSTONE_TAG);
        this.storedRedstoneTotal = compound.getInteger(rf.STORED_REDSTONE_TOTAL_TAG);
        
        this.moduleActiveSlot1 = compound.getInteger(rf.MODULE_ACTIVE_SLOT1_TAG);
        this.metaJukeboxSelectedSong = compound.getInteger(rf.JUKEBOX_SELECTED_SONG_TAG);
        
        this.learnedModuleAltitude = compound.getBoolean(rf.LEARNED_MODULE_ALTITUDE_TAG);
        this.selectedModuleAltitude = compound.getInteger(rf.SELECTED_MODULE_ALTITUDE_TAG);
        this.learnedModuleSpeed = compound.getBoolean(rf.LEARNED_MODULE_SPEED_TAG);
        this.selectedModuleSpeed = compound.getInteger(rf.SELECTED_MODULE_SPEED_TAG);
        this.learnedModuleStorage = compound.getBoolean(rf.LEARNED_MODULE_STORAGE_TAG);
        this.selectedModuleStorage = compound.getInteger(rf.SELECTED_MODULE_STORAGE_TAG);
        this.learnedModuleFuel = compound.getBoolean(rf.LEARNED_MODULE_FUEL_TAG);
        this.selectedModuleFuel = compound.getInteger(rf.SELECTED_MODULE_FUEL_TAG);
        this.learnedModuleMusic = compound.getBoolean(rf.LEARNED_MODULE_MUSIC_TAG);
        this.selectedModuleMusic = compound.getInteger(rf.SELECTED_MODULE_MUSIC_TAG);
        this.learnedModuleCruise = compound.getBoolean(rf.LEARNED_MODULE_CRUISE_TAG);
        this.selectedModuleCruise = compound.getInteger(rf.SELECTED_MODULE_CRUISE_TAG);
        this.learnedModuleWater = compound.getBoolean(rf.LEARNED_MODULE_WATER_TAG);
        this.selectedModuleWater = compound.getInteger(rf.SELECTED_MODULE_WATER_TAG);
        this.learnedModuleFuelInfinite = compound.getBoolean(rf.LEARNED_MODULE_FUELINFINITE_TAG);
        this.selectedModuleFuelInfinite = compound.getInteger(rf.SELECTED_MODULE_FUELINFINITE_TAG);
        this.learnedModuleBomb = compound.getBoolean(rf.LEARNED_MODULE_BOMB_TAG);
        this.selectedModuleBomb = compound.getInteger(rf.SELECTED_MODULE_BOMB_TAG);
    }
	
	
	
    //================================================================================
	
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
    	//Makes airships immune to explosion!
	    if (source.isExplosion())
	    {
	    	return false;
	    }
	    
	    return super.attackEntityFrom(source, amount);
    }
	
	
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
    		NetworkHandler.sendToServer(new MessageGuiMainMenu());
        	Minecraft.getMinecraft().setIngameFocus();
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
    	if(airshipHeight > EnumsVC.MainTierBalloon.byId(this.getMainTierBalloon()).getMaxAltitude())
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
    	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 2);
    	}
    	//Normal Fuel 40%
    	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 4);
    	}
    	//Greater Fuel 60%
    	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
    	{
    		this.airshipFuelTick = this.airshipFuelTick - (this.getBaseFuelPercent10() * 6);
    	}
    	////Major Speed & Large Inventory 50
    	//if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata()
    	//|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
    	//{
    	//	this.airshipFuelTick = this.airshipFuelTick + (this.getBaseFuelPercent10() * 5);
    	//}
    	
    	return airshipFuelTick;
    }
    
    protected int getBaseFuelTick()
    {
    	this.airshipFuelTick = EnumsVC.MainTierEngine.byId(this.getMainTierEngine()).getFuelPerTick();
    	
    	return this.airshipFuelTick;
    }
    
    protected int getBaseFuelPercent10()
    {
    	switch(this.getMainTierEngine())
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
    
    
    //==================================//
    // TODO          Misc               //
	//==================================//
    
    protected String getNameColor()
	{
		switch (this.getMainTierFrame())
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
                this.storedFuel = value;
                break;
            case 1:
            	this.storedFuelTotal = value;
                break;
            case 2:
                this.storedRedstone = value;
                break;
            case 3:
            	this.storedRedstoneTotal = value;
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
                return this.storedFuel;
            case 1:
                return this.storedFuelTotal;
            case 2:
                return this.storedRedstone;
            case 3:
                return this.storedRedstoneTotal;
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
    		this.motionY += 0.0001;
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
					this.inventory.extractItem(x, this.inventory.getStackInSlot(x).getCount(), false);
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
					this.inventory.extractItem(x, this.inventory.getStackInSlot(x).getCount(), false);
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
				}
			}
		}
    }
    
    /**
     * Root Method that will drop everything in all inventory slots minus fuel
     */
    protected void noInventoryModuleDropItems()
    {
    	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
    	{
    		canDrop = true;
    	}
    	
    	if(this.getModuleActiveSlot1() != EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
		&& this.getModuleActiveSlot1() != EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
		&& this.getModuleActiveSlot1() != EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()
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
    		//this.dropInventoryAll();
    		
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
        
        if(this.previousStatus == EntityAirshipBaseVC.Status.IN_AIR 
		&& this.status != EntityAirshipBaseVC.Status.IN_AIR 
		&& this.status != EntityAirshipBaseVC.Status.ON_LAND)
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
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
            {
            	this.momentum = 0.45F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
            {
            	this.momentum = 0.67F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
            	this.momentum = 0.9F;
            }
            else if(this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
            {
            	if(this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_LESSER.getMetadata()
        		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
        		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_GREATER.getMetadata())
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
            else if(isFuelBurning())
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
            
            
            
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
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
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
            {
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
            	{
            		//Lesser Altitude
                	if(this.getPosition().getY() > 225)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
            	{
            		//Altitude
                	if(this.getPosition().getY() > 250)
    	            {
    	            	this.motionY = -0.1D;
    	            }
            	}
            	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
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
            	if(this.getPosition().getY() > EnumsVC.MainTierBalloon.byId(this.mainTierBalloon).getMaxAltitude())
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
    	boolean flag = this.isFuelBurning();
        boolean flag1 = false;
        
        //Sets burn time to 0
        if(this.storedFuel <= this.getBaseFuelTick())
        {
        	this.storedFuel = 0;
        }
        
        //Handles how burn time is ticked down
        if(this.isFuelBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		
        	}
        	else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		
            }
        	else 
        	{
        		this.storedFuel = this.storedFuel - this.getAirshipFuelTick();
        	}
        }
        
        //Handles when the airship is off
        if(!this.isFuelBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        	{
        		this.storedFuel = 1;
        	}
        	//Greater Water no fuel
        	else if(this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
            {
        		this.storedFuel = 1;
            }
        	//Airship has no controlling passenger
        	else if(this.getControllingPassenger() == null)
        	{
        		this.storedFuel = 0;
        	}
        	else 
        	{
        		this.storedFuel = 0;
        	}
        }
        
        
        if(!this.world.isRemote)
        {
        	ItemStack fuelSlot = this.inventory.getStackInSlot(0);
        	
	        //Core fuel slot logic
	        if(this.isFuelBurning() || !fuelSlot.isEmpty())
	        {
	            if(!this.isFuelBurning()
	            && this.getControllingPassenger() != null)
	            {
	                this.storedFuel = getItemBurnTime(fuelSlot);
	                this.storedFuelTotal = getItemBurnTime(fuelSlot);
	                
	                if(this.isFuelBurning())
	                {
	                    flag1 = true;
	                    
	                    //Consumes the fuel item
	                    if(!fuelSlot.isEmpty())
	                    {
	                    	this.inventory.extractItem(0, 1, false);
	                    }
	                }
	            }
	        }
        }
        
        if(flag != this.isFuelBurning())
        {
            flag1 = true;
        }
    }
    
    /**
     * Is Airship Engine On
     */
    public boolean isFuelBurning()
    {
    	boolean hasFuel = false;
    	
    	if(this.storedFuel > 0)
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
        if(stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            //DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            
            if(ViesCraftConfig.vanillaFuel)
    		{
	            if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if(block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVC.wooden_slab * 10;
	                }
	                
	                if(block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVC.wood_block_material * 10;
	                }
	                
	                if(block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVC.coal_block * 10;
	                }
	            }
	            
	            if(item == Items.STICK) return FuelVC.stick * 10;
	            if(item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling * 10;
	            if(item == Items.COAL) return FuelVC.coal * 10;
	            if(item == Items.BLAZE_ROD) return FuelVC.blaze_rod * 10;
	            
	            if(item == Items.LAVA_BUCKET) return 20000 * 10;
    		}
            
            if(item == InitItemsVC.VIESOLINE_PELLETS) return (ViesCraftConfig.viesolineBurnTime * 20) * 10;
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
    		if(this.isFuelBurning())
            {
    			ItemStack itemFuel = this.inventory.getStackInSlot(0);
    			
    			if(!itemFuel.isEmpty())
    			{
    				this.fuelItemStackSize = this.inventory.getStackInSlot(0).getCount();
    					
    				this.fuelItemStack = this.fuelItemStackSize * this.getItemBurnTime(this.inventory.getStackInSlot(0));
    			}
    			else
    			{
    				this.fuelItemStack = 0;
    				this.fuelItemStackSize = 0;
    			}
            }
    		else
    		{
    			this.fuelItemStack = 0;
    			this.fuelItemStackSize = 0;
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
        if(this.world.isRemote)
        {
        	this.customName = this.getCustomName();
        	
        	this.storedFuel = this.getStoredFuel();
        	this.storedFuelTotal = this.getStoredFuelTotal();
        	this.fuelItemStack = this.getFuelItemStackPowered();
			this.fuelItemStackSize = this.getFuelItemStackSizePowered();
			this.storedRedstone = this.getStoredRedstone();
        	this.storedRedstoneTotal = this.getStoredRedstoneTotal();
        	
        	this.mainTierCore = this.getMainTierCore();
        	this.mainTierFrame = this.getMainTierFrame();
        	this.mainTierEngine = this.getMainTierEngine();
        	this.mainTierBalloon = this.getMainTierBalloon();
        	
        	this.coreModelVisualFrame = this.getCoreModelVisualFrame();
        	this.coreModelVisualEngine = this.getCoreModelVisualEngine();
        	this.coreModelVisualBalloon = this.getCoreModelVisualBalloon();
        	
            this.frameSkinTexture = this.getFrameSkinTexture();
            this.frameSkinTransparent = this.getFrameSkinTransparent();
            this.frameSkinColorRed = this.getFrameSkinColorRed();
            this.frameSkinColorGreen = this.getFrameSkinColorGreen();
            this.frameSkinColorBlue = this.getFrameSkinColorBlue();
            
            this.engineParticleVisual = this.getEngineParticleVisual();
            this.engineDisplayTypeVisual = this.getEngineDisplayTypeVisual();
            this.engineDisplayItemstackVisual = this.getEngineDisplayItemstackVisual();
            this.engineDisplayItemstackMetaVisual = this.getEngineDisplayItemstackMetaVisual();
            this.engineDisplayHeadVisual = this.getEngineDisplayHeadVisual();
            this.engineDisplaySupporterHeadVisual = this.getEngineDisplaySupporterHeadVisual();
            this.engineDisplayHolidayVisual = this.getEngineDisplayHolidayVisual();
            
            this.balloonPatternTexture = this.getBalloonPatternTexture();
            this.balloonPatternTransparent = this.getBalloonPatternTransparent();
            this.balloonPatternColorRed = this.getBalloonPatternColorRed();
            this.balloonPatternColorGreen = this.getBalloonPatternColorGreen();
            this.balloonPatternColorBlue = this.getBalloonPatternColorBlue();
            
            this.moduleActiveSlot1 = this.getModuleActiveSlot1();
            
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
            this.learnedModuleBomb = this.getModuleLearnedBomb();
            this.selectedModuleBomb = this.getModuleSelectedBomb();
        }
    	
        if(!this.world.isRemote)
		{
        	this.setCustomName(this.customName);
        	
        	this.setStoredFuel(this.storedFuel);
        	this.setStoredFuelTotal(this.storedFuelTotal);
        	this.setFuelItemStackPowered(this.fuelItemStack);
			this.setFuelItemStackSizePowered(this.fuelItemStackSize);
			this.setStoredRedstone(this.storedRedstone);
        	this.setStoredRedstoneTotal(this.storedRedstoneTotal);
        	
        	this.setMainTierCore(this.mainTierCore);
        	this.setMainTierFrame(this.mainTierFrame);
        	this.setMainTierEngine(this.mainTierEngine);
        	this.setMainTierBalloon(this.mainTierBalloon);
        	
            this.setCoreModelVisualFrame(this.coreModelVisualFrame);
            this.setCoreModelVisualEngine(this.coreModelVisualEngine);
            this.setCoreModelVisualBalloon(this.coreModelVisualBalloon);
            
            this.setFrameSkinTexture(this.frameSkinTexture);
            this.setFrameSkinTransparent(this.frameSkinTransparent);
            this.setFrameSkinColorRed(this.frameSkinColorRed);
            this.setFrameSkinColorGreen(this.frameSkinColorGreen);
            this.setFrameSkinColorBlue(this.frameSkinColorBlue);
            
            this.setEngineParticleVisual(this.engineParticleVisual);
            this.setEngineDisplayTypeVisual(this.engineDisplayTypeVisual);
            this.setEngineDisplayItemstackVisual(this.engineDisplayItemstackVisual);
            this.setEngineDisplayItemstackMetaVisual(this.engineDisplayItemstackMetaVisual);
            this.setEngineDisplayHeadVisual(this.engineDisplayHeadVisual);
            this.setEngineDisplaySupporterHeadVisual(this.engineDisplaySupporterHeadVisual);
            this.setEngineDisplayHolidayVisual(this.engineDisplayHolidayVisual);
            
            this.setBalloonPatternTexture(this.balloonPatternTexture);
            this.setBalloonPatternTransparent(this.balloonPatternTransparent);
            this.setBalloonPatternColorRed(this.balloonPatternColorRed);
            this.setBalloonPatternColorGreen(this.balloonPatternColorGreen);
            this.setBalloonPatternColorBlue(this.balloonPatternColorBlue);
            
            this.setModuleActiveSlot1(this.moduleActiveSlot1);
            
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
            this.setModuleLearnedBomb(this.learnedModuleBomb);
            this.setModuleSelectedBomb(this.selectedModuleBomb);
		}
    }
    
    //======================================================================================
    
    /**
     * Sets the Custom Name.
     */
    public void setCustomName(String stringIn)
    {
        this.dataManager.set(CUSTOM_NAME_DM, String.valueOf(stringIn));
    }
    /**
     * Gets the Custom Name.
     */
    public String getCustomName()
    {
        return ((String)this.dataManager.get(CUSTOM_NAME_DM));
    }
    
    //======================================================================================
    
    /**
     * Sets the Main Core Tier.
     */
    public void setMainTierCore(int intIn)
    {
        this.dataManager.set(MAIN_TIER_CORE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Main Core Tier.
     */
    public int getMainTierCore()
    {
        return ((Integer)this.dataManager.get(MAIN_TIER_CORE_DM)).intValue();
    }
    /**
     * Sets the Main Frame Tier.
     */
    public void setMainTierFrame(int intIn)
    {
        this.dataManager.set(MAIN_TIER_FRAME_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Main Frame Tier.
     */
    public int getMainTierFrame()
    {
        return ((Integer)this.dataManager.get(MAIN_TIER_FRAME_DM)).intValue();
    }
    /**
     * Sets the Main Engine Tier.
     */
    public void setMainTierEngine(int intIn)
    {
        this.dataManager.set(MAIN_TIER_ENGINE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Main Engine Tier.
     */
    public int getMainTierEngine()
    {
        return ((Integer)this.dataManager.get(MAIN_TIER_ENGINE_DM)).intValue();
    }
    /**
     * Sets the Main Balloon Tier.
     */
    public void setMainTierBalloon(int intIn)
    {
        this.dataManager.set(MAIN_TIER_BALLOON_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Main Balloon Tier.
     */
    public int getMainTierBalloon()
    {
        return ((Integer)this.dataManager.get(MAIN_TIER_BALLOON_DM)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Core Model Frame. (Currently used for the whole model)
     */
    public void setCoreModelVisualFrame(int intIn)
    {
        this.dataManager.set(CORE_MODEL_VISUAL_FRAME_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Core Model Frame.
     */
    public int getCoreModelVisualFrame()
    {
        return ((Integer)this.dataManager.get(CORE_MODEL_VISUAL_FRAME_DM)).intValue();
    }
    
    /**
     * Sets the Visual Core Model Engine.
     */
    public void setCoreModelVisualEngine(int intIn)
    {
        this.dataManager.set(CORE_MODEL_VISUAL_ENGINE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Core Model Engine.
     */
    public int getCoreModelVisualEngine()
    {
        return ((Integer)this.dataManager.get(CORE_MODEL_VISUAL_ENGINE_DM)).intValue();
    }
    
    /**
     * Sets the Visual Core Model Balloon.
     */
    public void setCoreModelVisualBalloon(int intIn)
    {
        this.dataManager.set(CORE_MODEL_VISUAL_BALLOON_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Core Model Balloon.
     */
    public int getCoreModelVisualBalloon()
    {
        return ((Integer)this.dataManager.get(CORE_MODEL_VISUAL_BALLOON_DM)).intValue();
    }
    //======================================================================================
    
    /**
     * Sets the Visual Frame Skin Texture.
     */
    public void setFrameSkinTexture(int intIn)
    {
        this.dataManager.set(FRAME_SKIN_TEXTURE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Skin Texture.
     */
    public int getFrameSkinTexture()
    {
        return ((Integer)this.dataManager.get(FRAME_SKIN_TEXTURE_DM)).intValue();
    }
    /**
     * Sets the Visual Frame Skin Transparency.
     */
    public void setFrameSkinTransparent(boolean booleanIn)
    {
        this.dataManager.set(FRAME_SKIN_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Frame Skin Transparency.
     */
    public boolean getFrameSkinTransparent()
    {
        return ((Boolean)this.dataManager.get(FRAME_SKIN_TRANSPARENT_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Frame Skin Color Red.
     */
    public void setFrameSkinColorRed(int intIn)
    {
        this.dataManager.set(FRAME_SKIN_COLOR_RED_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Skin Color Red.
     */
    public int getFrameSkinColorRed()
    {
        return ((Integer)this.dataManager.get(FRAME_SKIN_COLOR_RED_DM)).intValue();
    }
    /**
     * Sets the Visual Frame Skin Color Green.
     */
    public void setFrameSkinColorGreen(int intIn)
    {
        this.dataManager.set(FRAME_SKIN_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Skin Color Green.
     */
    public int getFrameSkinColorGreen()
    {
        return ((Integer)this.dataManager.get(FRAME_SKIN_COLOR_GREEN_DM)).intValue();
    }
    /**
     * Sets the Visual Frame Skin Color Blue.
     */
    public void setFrameSkinColorBlue(int intIn)
    {
        this.dataManager.set(FRAME_SKIN_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Frame Skin Color Blue.
     */
    public int getFrameSkinColorBlue()
    {
        return ((Integer)this.dataManager.get(FRAME_SKIN_COLOR_BLUE_DM)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Engine Particle.
     */
    public void setEngineParticleVisual(int intIn)
    {
        this.dataManager.set(ENGINE_PARTICLE_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Particle.
     */
    public int getEngineParticleVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_PARTICLE_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Type.
     */
    public void setEngineDisplayTypeVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_TYPE_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Type.
     */
    public int getEngineDisplayTypeVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_TYPE_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Itemstack.
     */
    public void setEngineDisplayItemstackVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_ITEMSTACK_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Itemstack.
     */
    public int getEngineDisplayItemstackVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_ITEMSTACK_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Itemstack Meta.
     */
    public void setEngineDisplayItemstackMetaVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Itemstack Meta.
     */
    public int getEngineDisplayItemstackMetaVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_ITEMSTACK_META_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Head.
     */
    public void setEngineDisplayHeadVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_HEAD_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Head.
     */
    public int getEngineDisplayHeadVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_HEAD_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Supporter Head.
     */
    public void setEngineDisplaySupporterHeadVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Supporter Head.
     */
    public int getEngineDisplaySupporterHeadVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_SUPPORTER_HEAD_VISUAL_DM)).intValue();
    }
    /**
     * Sets the Visual Engine Display Holiday.
     */
    public void setEngineDisplayHolidayVisual(int intIn)
    {
        this.dataManager.set(ENGINE_DISPLAY_HOLIDAY_VISUAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Engine Display Holiday.
     */
    public int getEngineDisplayHolidayVisual()
    {
        return ((Integer)this.dataManager.get(ENGINE_DISPLAY_HOLIDAY_VISUAL_DM)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Visual Balloon Pattern Texture.
     */
    public void setBalloonPatternTexture(int intIn)
    {
        this.dataManager.set(BALLOON_PATTERN_TEXTURE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Balloon Pattern Texture.
     */
    public int getBalloonPatternTexture()
    {
        return ((Integer)this.dataManager.get(BALLOON_PATTERN_TEXTURE_DM)).intValue();
    }
    /**
     * Sets the Visual Balloon Pattern Transparency.
     */
    public void setBalloonPatternTransparent(boolean booleanIn)
    {
        this.dataManager.set(BALLOON_PATTERN_TRANSPARENT_DM, Boolean.valueOf(booleanIn));
    }
    /**
     * Gets the Visual Balloon Pattern Transparency.
     */
    public boolean getBalloonPatternTransparent()
    {
        return ((Boolean)this.dataManager.get(BALLOON_PATTERN_TRANSPARENT_DM)).booleanValue();
    }
    
    /**
     * Sets the Visual Balloon Pattern Color Red.
     */
    public void setBalloonPatternColorRed(int intIn)
    {
        this.dataManager.set(BALLOON_PATTERN_COLOR_RED_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Balloon Pattern Color Red.
     */
    public int getBalloonPatternColorRed()
    {
        return ((Integer)this.dataManager.get(BALLOON_PATTERN_COLOR_RED_DM)).intValue();
    }
    /**
     * Sets the Visual Balloon Pattern Color Green.
     */
    public void setBalloonPatternColorGreen(int intIn)
    {
        this.dataManager.set(BALLOON_PATTERN_COLOR_GREEN_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Balloon Pattern Color Green.
     */
    public int getBalloonPatternColorGreen()
    {
        return ((Integer)this.dataManager.get(BALLOON_PATTERN_COLOR_GREEN_DM)).intValue();
    }
    /**
     * Sets the Visual Balloon Pattern Color Blue.
     */
    public void setBalloonPatternColorBlue(int intIn)
    {
        this.dataManager.set(BALLOON_PATTERN_COLOR_BLUE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Visual Balloon Pattern Color Blue.
     */
    public int getBalloonPatternColorBlue()
    {
        return ((Integer)this.dataManager.get(BALLOON_PATTERN_COLOR_BLUE_DM)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Active Slot1 Module.
     */
    public void setModuleActiveSlot1(int intIn)
    {
        this.dataManager.set(MODULE_ACTIVE_SLOT1_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Active Slot1 Module.
     */
    public int getModuleActiveSlot1()
    {
        return ((Integer)this.dataManager.get(MODULE_ACTIVE_SLOT1_DM)).intValue();
    }
    
    //======================================================================================
    
    /**
     * Sets the Jukebox selected song.
     */
    public void setJukeboxSelectedSong(int intIn)
    {
        this.dataManager.set(MODULE_JUKEBOX_SELECTED_SONG_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Jukebox selected song.
     */
	public int getJukeboxSelectedSong()
    {
        return ((Integer)this.dataManager.get(MODULE_JUKEBOX_SELECTED_SONG_DM)).intValue();
    }
	
	/**
     * Sets the Cruise Control selected speed.
     */
    public void setCruiseControlSelectedSpeed(int intIn)
    {
        this.dataManager.set(MODULE_CRUISECONTROL_SELECTED_SPEED_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Cruise Control selected speed.
     */
    public int getCruiseControlSelectedSpeed()
    {
        return ((Integer)this.dataManager.get(MODULE_CRUISECONTROL_SELECTED_SPEED_DM)).intValue();
    }
    
    //======================================================================================
    
	/**
     * Sets the Stored Fuel.
     */
    public void setStoredFuel(int intIn)
    {
        this.dataManager.set(STORED_FUEL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Stored Fuel.
     */
    public int getStoredFuel()
    {
        return ((Integer)this.dataManager.get(STORED_FUEL_DM)).intValue();
    }
    
    /**
     * Sets the Stored Fuel Total.
     */
    public void setStoredFuelTotal(int intIn)
    {
        this.dataManager.set(STORED_FUEL_TOTAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Stored Fuel Total.
     */
    public int getStoredFuelTotal()
    {
        return ((Integer)this.dataManager.get(STORED_FUEL_TOTAL_DM)).intValue();
    }
    
    /**
     * Sets the Fuel ItemStack.
     */
    public void setFuelItemStackPowered(int intIn)
    {
        this.dataManager.set(FUEL_ITEMSTACK_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Fuel ItemStack.
     */
    public int getFuelItemStackPowered()
    {
        return ((Integer)this.dataManager.get(FUEL_ITEMSTACK_DM)).intValue();
    }
    
	/**
     * Sets the Fuel ItemStack Size.
     */
    public void setFuelItemStackSizePowered(int intIn)
    {
        this.dataManager.set(FUEL_ITEMSTACK_SIZE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Fuel ItemStack Size.
     */
    public int getFuelItemStackSizePowered()
    {
        return ((Integer)this.dataManager.get(FUEL_ITEMSTACK_SIZE_DM)).intValue();
    }
    
    /**
     * Sets the Stored Redstone.
     */
    public void setStoredRedstone(int intIn)
    {
        this.dataManager.set(STORED_REDSTONE_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Stored Redstone.
     */
    public int getStoredRedstone()
    {
        return ((Integer)this.dataManager.get(STORED_REDSTONE_DM)).intValue();
    }
    
    /**
     * Sets the Stored Redstone Total.
     */
    public void setStoredRedstoneTotal(int intIn)
    {
        this.dataManager.set(STORED_REDSTONE_TOTAL_DM, Integer.valueOf(intIn));
    }
    /**
     * Gets the Stored Redstone Total.
     */
    public int getStoredRedstoneTotal()
    {
        return ((Integer)this.dataManager.get(STORED_REDSTONE_TOTAL_DM)).intValue();
    }
    
    
    //======================================================================================
    
	/**
     * Sets the Int of Module Altitude.
     */
    public void setModuleSelectedAltitude(int moduleSelectedAltitude)
    {
        this.dataManager.set(MODULE_SELECTED_ALTITUDE_DM, Integer.valueOf(moduleSelectedAltitude));
    }
    /**
     * Gets the Int of Module Altitude.
     */
    public int getModuleSelectedAltitude()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_ALTITUDE_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Altitude.
     */
    public void setModuleLearnedAltitude(boolean moduleLearnedAltitude)
    {
        this.dataManager.set(MODULE_LEARNED_ALTITUDE_DM, Boolean.valueOf(moduleLearnedAltitude));
    }
    /**
     * Gets the Learned boolean of Module Altitude.
     */
    public boolean getModuleLearnedAltitude()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_ALTITUDE_DM)).booleanValue();
    }

	/**
     * Sets the Int of Module Speed.
     */
    public void setModuleSelectedSpeed(int moduleSelectedSpeed)
    {
        this.dataManager.set(MODULE_SELECTED_SPEED_DM, Integer.valueOf(moduleSelectedSpeed));
    }
    /**
     * Gets the Int of Module Speed.
     */
    public int getModuleSelectedSpeed()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_SPEED_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Speed.
     */
    public void setModuleLearnedSpeed(boolean moduleLearnedSpeed)
    {
        this.dataManager.set(MODULE_LEARNED_SPEED_DM, Boolean.valueOf(moduleLearnedSpeed));
    }
    /**
     * Gets the Learned boolean of Module Speed.
     */
    public boolean getModuleLearnedSpeed()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_SPEED_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Storage.
     */
    public void setModuleSelectedStorage(int moduleSelectedStorage)
    {
        this.dataManager.set(MODULE_SELECTED_STORAGE_DM, Integer.valueOf(moduleSelectedStorage));
    }
    /**
     * Gets the Int of Module Storage.
     */
    public int getModuleSelectedStorage()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_STORAGE_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Storage.
     */
    public void setModuleLearnedStorage(boolean moduleLearnedStorage)
    {
        this.dataManager.set(MODULE_LEARNED_STORAGE_DM, Boolean.valueOf(moduleLearnedStorage));
    }
    /**
     * Gets the Learned boolean of Module Storage.
     */
    public boolean getModuleLearnedStorage()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_STORAGE_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Fuel.
     */
    public void setModuleSelectedFuel(int moduleSelectedFuel)
    {
        this.dataManager.set(MODULE_SELECTED_FUEL_DM, Integer.valueOf(moduleSelectedFuel));
    }
    /**
     * Gets the Int of Module Fuel.
     */
    public int getModuleSelectedFuel()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_FUEL_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Fuel.
     */
    public void setModuleLearnedFuel(boolean moduleLearnedFuel)
    {
        this.dataManager.set(MODULE_LEARNED_FUEL_DM, Boolean.valueOf(moduleLearnedFuel));
    }
    /**
     * Gets the Learned boolean of Module Fuel.
     */
    public boolean getModuleLearnedFuel()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_FUEL_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Music.
     */
    public void setModuleSelectedMusic(int moduleSelectedMusic)
    {
        this.dataManager.set(MODULE_SELECTED_MUSIC_DM, Integer.valueOf(moduleSelectedMusic));
    }
    /**
     * Gets the Int of Module Music.
     */
    public int getModuleSelectedMusic()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_MUSIC_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Music.
     */
    public void setModuleLearnedMusic(boolean moduleLearnedMusic)
    {
        this.dataManager.set(MODULE_LEARNED_MUSIC_DM, Boolean.valueOf(moduleLearnedMusic));
    }
    /**
     * Gets the Learned boolean of Module Music.
     */
    public boolean getModuleLearnedMusic()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_MUSIC_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Cruise.
     */
    public void setModuleSelectedCruise(int moduleSelectedCruise)
    {
        this.dataManager.set(MODULE_SELECTED_CRUISE_DM, Integer.valueOf(moduleSelectedCruise));
    }
    /**
     * Gets the Int of Module Cruise.
     */
    public int getModuleSelectedCruise()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_CRUISE_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Cruise.
     */
    public void setModuleLearnedCruise(boolean moduleLearnedCruise)
    {
        this.dataManager.set(MODULE_LEARNED_CRUISE_DM, Boolean.valueOf(moduleLearnedCruise));
    }
    /**
     * Gets the Learned boolean of Module Cruise.
     */
    public boolean getModuleLearnedCruise()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_CRUISE_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Water.
     */
    public void setModuleSelectedWater(int moduleSelectedWater)
    {
        this.dataManager.set(MODULE_SELECTED_WATER_DM, Integer.valueOf(moduleSelectedWater));
    }
    /**
     * Gets the Int of Module Water.
     */
    public int getModuleSelectedWater()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_WATER_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Water.
     */
    public void setModuleLearnedWater(boolean moduleLearnedWater)
    {
        this.dataManager.set(MODULE_LEARNED_WATER_DM, Boolean.valueOf(moduleLearnedWater));
    }
    /**
     * Gets the Learned boolean of Module Water.
     */
    public boolean getModuleLearnedWater()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_WATER_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module FuelInfinite.
     */
    public void setModuleSelectedFuelInfinite(int moduleSelectedFuelInfinite)
    {
        this.dataManager.set(MODULE_SELECTED_FUELINFINITE_DM, Integer.valueOf(moduleSelectedFuelInfinite));
    }
    /**
     * Gets the Int of Module FuelInfinite.
     */
    public int getModuleSelectedFuelInfinite()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_FUELINFINITE_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module FuelInfinite.
     */
    public void setModuleLearnedFuelInfinite(boolean moduleLearnedFuelInfinite)
    {
        this.dataManager.set(MODULE_LEARNED_FUELINFINITE_DM, Boolean.valueOf(moduleLearnedFuelInfinite));
    }
    /**
     * Gets the Learned boolean of Module FuelInfinite.
     */
    public boolean getModuleLearnedFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_FUELINFINITE_DM)).booleanValue();
    }
    
    /**
     * Sets the Int of Module Bomb.
     */
    public void setModuleSelectedBomb(int moduleSelectedBomb)
    {
        this.dataManager.set(MODULE_SELECTED_BOMB_DM, Integer.valueOf(moduleSelectedBomb));
    }
    /**
     * Gets the Int of Module Bomb.
     */
    public int getModuleSelectedBomb()
    {
        return ((Integer)this.dataManager.get(MODULE_SELECTED_BOMB_DM)).intValue();
    }
    /**
     * Sets the Learned boolean of Module Bomb.
     */
    public void setModuleLearnedBomb(boolean moduleLearnedBomb)
    {
        this.dataManager.set(MODULE_LEARNED_BOMB_DM, Boolean.valueOf(moduleLearnedBomb));
    }
    /**
     * Gets the Learned boolean of Module Bomb.
     */
    public boolean getModuleLearnedBomb()
    {
        return ((Boolean)this.dataManager.get(MODULE_LEARNED_BOMB_DM)).booleanValue();
    }
}

package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.api.References;
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
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;

public class EntityAirshipV3Core extends EntityAirshipBaseVC {
	
    float finalAirshipSpeedTurn = 0.18F * (ViesCraftConfig.v3AirshipSpeed / 100);
    float finalAirshipSpeedForward = (0.01F * (ViesCraftConfig.v3AirshipSpeed / 100));
    float finalAirshipSpeedUp = 0.004F * (ViesCraftConfig.v3AirshipSpeed / 100);
    float finalAirshipSpeedDown = 0.004F * (ViesCraftConfig.v3AirshipSpeed / 100);
    
    ISound soundCacheIdle;
    ISound soundCacheMoving;
    
    References rf;
    
	public EntityAirshipV3Core(World worldIn)
    {
        super(worldIn);
    }
	
    public EntityAirshipV3Core(World worldIn, double x, double y, double z, 
    		int frameTierIn, int coreTierIn, int engineTierIn, int balloonTierIn, 
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
        this.setPosition(x, y + 0.5D, z);

        this.metaTierFrame = frameTierIn;
        this.metaTierCore = coreTierIn;
        this.metaTierEngine = engineTierIn;
        this.metaTierBalloon = balloonTierIn;
        
        this.metaModuleVariantSlot1 = moduleSlot1In;
        
        this.metaFrameVisual = frameVisualIn;
        this.metaFrameVisualTransparent = frameVisualTransparentIn;
        this.metaFrameVisualColor = frameVisualColorIn;
        this.metaFrameColorRed = frameColorRedIn;
        this.metaFrameColorGreen = frameColorGreenIn;
        this.metaFrameColorBlue = frameColorBlueIn;
        
        this.metaBalloonVisual = balloonVisualIn;
        this.metaBalloonVisualTransparent = balloonVisualTransparentIn;
        this.metaBalloonVisualColor = balloonVisualColorIn;
        this.metaBalloonColorRed = balloonColorRedIn;
        this.metaBalloonColorGreen = balloonColorGreenIn;
        this.metaBalloonColorBlue = balloonColorBlueIn;
        
        this.learnedModuleAltitude = learnedModuleAltitudeIn;
        this.selectedModuleAltitude = selectedModuleAltitudeIn;
        this.learnedModuleSpeed = learnedModuleSpeedIn;
        this.selectedModuleSpeed = selectedModuleSpeedIn;
        this.learnedModuleStorage = learnedModuleStorageIn;
        this.selectedModuleStorage = selectedModuleStorageIn;
        this.learnedModuleFuel = learnedModuleFuelIn;
        this.selectedModuleFuel = selectedModuleFuelIn;
        this.learnedModuleMusic = learnedModuleMusicIn;
        this.selectedModuleMusic = selectedModuleMusicIn;
        this.learnedModuleCruise = learnedModuleCruiseIn;
        this.selectedModuleCruise = selectedModuleCruiseIn;
        this.learnedModuleWater = learnedModuleWaterIn;
        this.selectedModuleWater = selectedModuleWaterIn;
        this.learnedModuleFuelInfinite = learnedModuleFuelInfiniteIn;
        this.selectedModuleFuelInfinite = selectedModuleFuelInfiniteIn;
        
        
        
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
    
    
    
	//==================================//
    // TODO        Item/Name            //
	//==================================//
    
    @Override
	public ItemStack getItemAirship()
    {
    	ItemStack stack = new ItemStack(InitItemsVC.ITEM_V3_AIRSHIP, 1, this.metaTierFrame);
    	stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger(rf.META_TIER_CORE_TAG, this.metaTierCore);
    	stack.getTagCompound().setInteger(rf.META_TIER_ENGINE_TAG, this.metaTierEngine);
    	stack.getTagCompound().setInteger(rf.META_TIER_BALLOON_TAG, this.metaTierBalloon);
    	
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_TAG, this.metaFrameVisual);
    	stack.getTagCompound().setBoolean(rf.META_FRAME_VISUAL_TRANSPARENT_TAG, this.metaFrameVisualTransparent);
    	stack.getTagCompound().setBoolean(rf.META_FRAME_VISUAL_COLOR_TAG, this.metaFrameVisualColor);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_RED_TAG, this.metaFrameColorRed);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_GREEN_TAG, this.metaFrameColorGreen);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_BLUE_TAG, this.metaFrameColorBlue);
    	
    	stack.getTagCompound().setInteger(rf.META_BALLOON_VISUAL_TAG, this.metaBalloonVisual);
    	stack.getTagCompound().setBoolean(rf.META_BALLOON_VISUAL_TRANSPARENT_TAG, this.metaBalloonVisualTransparent);
    	stack.getTagCompound().setBoolean(rf.META_BALLOON_VISUAL_COLOR_TAG, this.metaBalloonVisualColor);
    	stack.getTagCompound().setInteger(rf.META_BALLOON_VISUAL_COLOR_RED_TAG, this.metaBalloonColorRed);
    	stack.getTagCompound().setInteger(rf.META_BALLOON_VISUAL_COLOR_GREEN_TAG, this.metaBalloonColorGreen);
    	stack.getTagCompound().setInteger(rf.META_BALLOON_VISUAL_COLOR_BLUE_TAG, this.metaBalloonColorBlue);
    	
    	stack.getTagCompound().setInteger(rf.META_AIRSHIP_BURNTIME_TAG, this.airshipBurnTime);
    	stack.getTagCompound().setInteger(rf.META_AIRSHIP_BURNTIME_TOTAL_TAG, this.airshipTotalBurnTime);
    	stack.getTagCompound().setInteger(rf.META_ITEM_FUELSTACK_TAG, this.itemFuelStack);
    	stack.getTagCompound().setInteger(rf.META_ITEM_FUELSTACK_SIZE_TAG, this.itemFuelStackSize);
    	
    	stack.getTagCompound().setInteger(rf.META_MODULE_VARIANT_SLOT1_TAG, this.metaModuleVariantSlot1);
		stack.getTagCompound().setInteger(rf.META_JUKEBOX_SELECTED_SONG_TAG, this.metaJukeboxSelectedSong);
    	
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_ALTITUDE_TAG, this.learnedModuleAltitude);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_ALTITUDE_TAG, this.selectedModuleAltitude);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_SPEED_TAG, this.learnedModuleSpeed);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_SPEED_TAG, this.selectedModuleSpeed);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_STORAGE_TAG, this.learnedModuleStorage);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_STORAGE_TAG, this.selectedModuleStorage);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_FUEL_TAG, this.learnedModuleFuel);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_FUEL_TAG, this.selectedModuleFuel);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_MUSIC_TAG, this.learnedModuleMusic);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_MUSIC_TAG, this.selectedModuleMusic);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_CRUISE_TAG, this.learnedModuleCruise);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_CRUISE_TAG, this.selectedModuleCruise);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_WATER_TAG, this.learnedModuleWater);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_WATER_TAG, this.selectedModuleWater);
		stack.getTagCompound().setBoolean(rf.META_LEARNED_MODULE_FUELINFINITE_TAG, this.learnedModuleFuelInfinite);
		stack.getTagCompound().setInteger(rf.META_SELECTED_MODULE_FUELINFINITE_TAG, this.selectedModuleFuelInfinite);
		//stack.getTagCompound().setTag(rf.META_AIRSHIP_SLOTS_TAG, inventory.serializeNBT());
    	return stack;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() 
	{
		String tier_name = this.getNameColor() + EnumsVC.AirshipTierFrame.byId(this.getMetaTierFrame()).getLocalizedName();
		String visualframe_name = "";
		String visualballoon_name = "";
		
		if(this.getFrameVisual() > 0)
		{
			visualframe_name = "\"" + EnumsVC.VisualFrame.byId(this.metaFrameVisual).getLocalizedName() + "\" ";
		}
		
		if(this.getBalloonVisual() > 0)
		{
			visualballoon_name = "\"" + EnumsVC.VisualBalloon.byId(this.metaBalloonVisual).getLocalizedName() + "\" ";
		}
		
		return this.hasCustomName() ? this.customName : 
			this.getNameColor() + ViesCraftConfig.v3AirshipName + " " + TextFormatting.GRAY + "(" + tier_name + TextFormatting.GRAY +")";
	}
	
	private String getNameColor()
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
	
	
	
    //==================================//
    // TODO       On Update             //
	//==================================//
    
    @Override
    public void onUpdate()
    {
        if(this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_LESSER.getMetadata()
		|| this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
		|| this.getModuleVariantSlot1() != EnumsVC.ModuleType.WATER_GREATER.getMetadata())
        {
        	this.waterDamage();
        }
        
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        super.onUpdate();
        this.tickLerp();
        
        this.airshipCoreAI();
        
        if (this.canPassengerSteer())
        {
        	this.updateMotion();
        	this.controlAirship();
        	
        	if (this.world.isRemote)
            {
        		this.updateInputs();
        		this.controlAirshipGui();
            }
        	
        	this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        }
        else
        {
        	this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }
        
        this.doBlockCollisions();
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
    }
    
    /**
     * Handles root method calls for core airship AI logic
     */
    private void airshipCoreAI()
    {
    	this.fuelFlight();
        this.getTotalFuelSlotBurnTime();
        
        this.currentModule();
        
        this.noInventoryModuleDropItems();
        
        if(ViesCraftConfig.engineSounds)
        {
        	if(this.isClientAirshipBurning())
	        {
	        	this.world.playSound(this.posX, this.posY, this.posZ, InitSoundEventsVC.ENGINEON, SoundCategory.AMBIENT, 0.4F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 0.7F, true);
	        }
        }
        
        if(!(this.getControllingPassenger() instanceof EntityPlayer)
          && this.metaCruiseControlSelectedSpeed != 0)
		{
    		this.metaCruiseControlSelectedSpeed = 0;
    		this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
		}
    }
    
    
    
    //==================================//
    // TODO    Speed and Motion         //
	//==================================//
    
    @Override
    public void updateMotion()
    {
        double d0 = 0.0D;
        double d5 = -0.001D;
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
            	if(this.fallenInGround())
        		{
            		this.motionY = 0;
        		}
            	else if(this.motionY <= -0.039D)
        		{
        			this.motionY += d5;
        		}
        		else
        		{
        			this.motionY = -0.04D;
        		}
            }
            else if(isClientAirshipBurning())
        	{
            	this.motionY *= (double)this.momentum;
        	}
            else
            {
            	this.motionY += d5;
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
    
    @Override
    public void controlAirship()
    {
    	if(this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            //Turning Left
            if(this.leftInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }
            
            this.rotationYaw += this.deltaRotation;
            
            //Move Forward
            //Cruise Control
            if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(this.forwardInputDown)
	            {
            		if(this.metaCruiseControlSelectedSpeed < 3)
	            	{
	            		this.metaCruiseControlSelectedSpeed++;
	            	}
	            	else
	            	{
	            		this.metaCruiseControlSelectedSpeed = 3;
	            	}
            		
            		this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
	            	
	            	if(isClientAirshipBurning())
	        		{
	        			
	        		}
	            	else
	            	{
	            		f += 0.003F;
	            	}
	            }
            }
            else
            {
            	if(this.forwardInputDown)
	            {
	            	if(isClientAirshipBurning())
	        		{
	        			f += finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier;
	        		}
	            	else
	            	{
	            		f += 0.003F;
	            	}
	            }
            }
            
            //Moving Backwards
            //Cruise Control
            if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(this.backInputDown)
	            {
	            	if(this.metaCruiseControlSelectedSpeed > 0)
	            	{
	            		this.metaCruiseControlSelectedSpeed--;
	            	}
	            	else
	            	{
	            		this.metaCruiseControlSelectedSpeed = 0;
	            	}
	            	
            		this.setCruiseControlSelectedSpeed(this.metaCruiseControlSelectedSpeed);
	            	
		            if(isClientAirshipBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            }
            else
            {
	            if (this.backInputDown)
	            {
	            	if(isClientAirshipBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            }
            
            //Handles forward movement with the Cruise Control Module
            if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(isClientAirshipBurning()
            	&& this.getControllingPassenger() != null)
        		{
            		switch(this.metaCruiseControlSelectedSpeed)
	            	{
		            	case 0:
		            		f += 0F;
		            		break;
		            	case 1:
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier) / 4;
		            		break;
		            	case 2:
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier) / 2;
		            		break;
		            	case 3:
		            		f += finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() + this.speedModifier;
		            		break;
	            	}
        		}
            	else
            	{
            		f += 0F;
            	}
            }
            
            //Moving Up
            if (this.upInputDown)
            {
            	if(isClientAirshipBurning())
        		{
        			if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
                    {
        				f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() / 14);
                    }
                	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() / 8);
                    }
                	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() / 4);
                    }
                	else if(!this.airshipHeightLimit())
	    			{
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() / 32);
	    			}
        		}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= finalAirshipSpeedDown + (EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier() / 4) + (this.speedModifier / 4);
            }
            
            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            this.motionY += (double)(3.017453292F * f1);
            
            this.rotationPitch += 10;
        }
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
    // TODO          Misc               //
	//==================================//
    
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
    
    
    
    //==================================//
    // TODO       Inventory             //
	//==================================//
    
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
    
    @Override
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
    
    public int getFieldCount()
    {
        return 2;
    }
	
	
	
    //==================================//
	// TODO     Fuel Consumption        //
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
        
        
        
        //Core fuel slot logic
        if (this.isClientAirshipBurning() || !this.inventory.getStackInSlot(0).isEmpty())
        {
            if (!this.isClientAirshipBurning()
            && this.getControllingPassenger() != null)
            {
                this.airshipBurnTime = getItemBurnTime(this.inventory.getStackInSlot(0));
                this.airshipTotalBurnTime = getItemBurnTime(this.inventory.getStackInSlot(0));
                
                if (this.isClientAirshipBurning())
                {
                    flag1 = true;
                    
                    //Consumes the fuel item
                    if (!this.inventory.getStackInSlot(0).isEmpty())
                    {
                    	if (this.inventory.getStackInSlot(0).getCount() == 0)
                        {
                        	ItemStack test = this.inventory.getStackInSlot(0);
                            test = inventory.getStackInSlot(0).getItem().getContainerItem(inventory.getStackInSlot(0));
                        }
                        
                        this.inventory.extractItem(0, 1, false);
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
  	// TODO     Airship Modules         //
  	//==================================//
    
    public void currentModule()
    {
    	int moduleNumber = this.getModuleVariantSlot1();
    	
		if(moduleNumber >= 0)
		{
			this.metaModuleVariantSlot1 = 0;
			
			if(moduleNumber > 0)
			{
				this.metaModuleVariantSlot1 = moduleNumber;
			}
			
			if(moduleNumber == EnumsVC.ModuleType.BASE.getMetadata())
			{
				this.speedModifier = 0;
			}
			
			if(moduleNumber == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
			{
				this.speedModifier = 0.01F;
			}
			if(moduleNumber == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
			{
				this.speedModifier = 0.02F;
			}
			if(moduleNumber == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
			{
				this.speedModifier = 0.03F;
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.30F);
			}
			
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.66F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.33F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
			{
				this.speedModifier = 0;
			}
			
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.90F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.80F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierCore.byId(this.metaTierCore).getSpeedModifier()) * 0.70F);
			}
		}
    }
    
	
    
    //==================================//
  	// TODO          Misc               //
  	//==================================//
    
    public ItemStack getPickedResult(RayTraceResult target)
    {
        if (this instanceof EntityBaseVC)
        {
        	return this.getItemAirship();
        }
        
        return null;
    }
}

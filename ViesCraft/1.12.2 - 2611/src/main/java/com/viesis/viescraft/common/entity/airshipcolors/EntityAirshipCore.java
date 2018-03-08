package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

public class EntityAirshipCore extends EntityAirshipBaseVC {
	
    float finalAirshipSpeedTurn = 0.18F * (ViesCraftConfig.v1AirshipSpeed / 100);
    float finalAirshipSpeedForward = (0.01F * (ViesCraftConfig.v1AirshipSpeed / 100));
    float finalAirshipSpeedUp = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
    float finalAirshipSpeedDown = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
    
	public EntityAirshipCore(World worldIn)
    {
        super(worldIn);
    }
	
    public EntityAirshipCore(World worldIn, double x, double y, double z, 
    		int coreTierIn, int frameTierIn, int engineTierIn, int balloonTierIn, 
    		int moduleSlot1In, 
    		int coreVisualIn, 
    		int frameVisualIn, boolean frameVisualTransparentIn, boolean frameVisualColorIn,
    		int frameColorRedIn, int frameColorGreenIn, int frameColorBlueIn,
    		int engineVisualIn, 
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

        this.metaTierCore = coreTierIn;
        this.metaTierFrame = frameTierIn;
        this.metaTierEngine = engineTierIn;
        this.metaTierBalloon = balloonTierIn;
        
        this.metaModuleVariantSlot1 = moduleSlot1In;
        
        this.metaCoreVisual = coreVisualIn;
        
        this.metaFrameVisual = frameVisualIn;
        this.metaFrameVisualTransparent = frameVisualTransparentIn;
        this.metaFrameVisualColor = frameVisualColorIn;
        this.metaFrameColorRed = frameColorRedIn;
        this.metaFrameColorGreen = frameColorGreenIn;
        this.metaFrameColorBlue = frameColorBlueIn;
        
        this.metaEngineVisual = engineVisualIn;
        
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
    
    
    
	//==================================//
    // TODO        Item/Name            //
	//==================================//
    
    @Override
	public ItemStack getItemAirship()
    {
    	ItemStack stack = new ItemStack(InitItemsVC.ITEM_AIRSHIP, 1, this.metaTierCore);
    	stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger(rf.META_TIER_FRAME_TAG, this.metaTierFrame);
    	stack.getTagCompound().setInteger(rf.META_TIER_ENGINE_TAG, this.metaTierEngine);
    	stack.getTagCompound().setInteger(rf.META_TIER_BALLOON_TAG, this.metaTierBalloon);
    	
    	stack.getTagCompound().setInteger(rf.META_CORE_VISUAL_TAG, this.metaCoreVisual);
    	
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_TAG, this.metaFrameVisual);
    	stack.getTagCompound().setBoolean(rf.META_FRAME_VISUAL_TRANSPARENT_TAG, this.metaFrameVisualTransparent);
    	stack.getTagCompound().setBoolean(rf.META_FRAME_VISUAL_COLOR_TAG, this.metaFrameVisualColor);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_RED_TAG, this.metaFrameColorRed);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_GREEN_TAG, this.metaFrameColorGreen);
    	stack.getTagCompound().setInteger(rf.META_FRAME_VISUAL_COLOR_BLUE_TAG, this.metaFrameColorBlue);
    	
    	stack.getTagCompound().setInteger(rf.META_ENGINE_VISUAL_TAG, this.metaEngineVisual);
    	
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
		String tier_name = this.getNameColor() + EnumsVC.AirshipTierCore.byId(this.getMetaTierCore()).getLocalizedName();
		String visualframe_name = "";
		String visualballoon_name = "";
		
		if(this.getCoreVisual() > 0)
		{
			visualframe_name = "\"" + EnumsVC.VisualFrame.byId(this.metaFrameVisual).getLocalizedName() + "\" ";
		}
		
		if(this.getBalloonVisual() > 0)
		{
			visualballoon_name = "\"" + EnumsVC.VisualBalloon.byId(this.metaBalloonVisual).getLocalizedName() + "\" ";
		}
		
		return this.hasCustomName() ? this.customName : 
			this.getNameColor() + ViesCraftConfig.v1AirshipName + " " + TextFormatting.GRAY + "(" + tier_name + TextFormatting.GRAY +")";
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
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() * 4)) * 0.5F;
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
	        			f += finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier;
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
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
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
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
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
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier) / 4;
		            		break;
		            	case 2:
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier) / 2;
		            		break;
		            	case 3:
		            		f += finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() + this.speedModifier;
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
        				f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() / 14);
                    }
                	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() / 8);
                    }
                	else if(this.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() / 4);
                    }
                	else if(!this.airshipHeightLimit())
	    			{
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() / 32);
	    			}
        		}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= finalAirshipSpeedDown + (EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier() / 4) + (this.speedModifier / 4);
            }
            
            this.motionX += (double)(MathHelper.sin(-this.rotationYaw * 0.017453292F) * f);
            this.motionZ += (double)(MathHelper.cos(this.rotationYaw * 0.017453292F) * f);
            this.motionY += (double)(3.017453292F * f1);
            
            this.rotationPitch += 10;
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
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.30F);
			}
			
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.66F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.33F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
			{
				this.speedModifier = 0;
			}
			
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.90F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.80F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.metaTierFrame).getSpeedModifier()) * 0.70F);
			}
		}
    }
}

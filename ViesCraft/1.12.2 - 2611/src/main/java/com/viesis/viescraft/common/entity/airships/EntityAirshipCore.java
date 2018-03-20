package com.viesis.viescraft.common.entity.airships;

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
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

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
    		int fuelIn, int fuelTotalIn, int redstoneIn, int redstoneTotalIn,
    		
    		int coreModelVisualFrameIn, 
    		int coreModelVisualEngineIn, 
    		int coreModelVisualBalloonIn, 
    		
    		int frameSkinVisualIn, 
    		boolean frameSkinVisualTransparentIn, 
    		boolean frameSkinVisualColorIn,
    		int frameSkinColorRedIn, int frameSkinColorGreenIn, int frameSkinColorBlueIn,
    		
    		int engineParticleVisualIn, 
    		int engineDisplayTypeVisualIn, int engineDisplayIDVisualIn,
    		
    		int balloonPatternVisualIn, 
    		boolean balloonPatternVisualTransparentIn, 
    		boolean balloonPatternVisualColorIn,
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
        this.setPosition(x, y + 0.5D, z);
        
        this.mainTierCore = coreTierIn;
        this.mainTierFrame = frameTierIn;
        this.mainTierEngine = engineTierIn;
        this.mainTierBalloon = balloonTierIn;
        
        this.moduleActiveSlot1 = moduleSlot1In;
        
        this.storedFuel = fuelIn;
        this.storedFuelTotal = fuelTotalIn;
        this.storedRedstone = redstoneIn;
        this.storedRedstoneTotal = redstoneTotalIn;
        
        this.coreModelVisualFrame = coreModelVisualFrameIn;
        this.coreModelVisualEngine = coreModelVisualEngineIn;
        this.coreModelVisualBalloon = coreModelVisualBalloonIn;
        
        this.frameSkinVisual = frameSkinVisualIn;
        this.frameSkinVisualTransparent = frameSkinVisualTransparentIn;
        this.frameSkinVisualColor = frameSkinVisualColorIn;
        this.frameSkinColorRed = frameSkinColorRedIn;
        this.frameSkinColorGreen = frameSkinColorGreenIn;
        this.frameSkinColorBlue = frameSkinColorBlueIn;
        
        this.engineParticleVisual = engineParticleVisualIn;
        this.engineDisplayTypeVisual = engineDisplayTypeVisualIn;
        this.engineDisplayIDVisual = engineDisplayIDVisualIn;
        
        this.balloonPatternVisual = balloonPatternVisualIn;
        this.balloonPatternVisualTransparent = balloonPatternVisualTransparentIn;
        this.balloonPatternVisualColor = balloonPatternVisualColorIn;
        this.balloonPatternColorRed = balloonPatternColorRedIn;
        this.balloonPatternColorGreen = balloonPatternColorGreenIn;
        this.balloonPatternColorBlue = balloonPatternColorBlueIn;
        
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
        this.learnedModuleBomb = learnedModuleBombIn;
        this.selectedModuleBomb = selectedModuleBombIn;
        
        this.inventory = new ItemStackHandler(size);
        this.inventory.deserializeNBT(compoundIn);
        
        this.customName = customNameIn;
        
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
    	ItemStack stack = new ItemStack(InitItemsVC.ITEM_AIRSHIP, 1, this.mainTierCore);
    	stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger(rf.MAIN_TIER_FRAME_TAG, this.mainTierFrame);
    	stack.getTagCompound().setInteger(rf.MAIN_TIER_ENGINE_TAG, this.mainTierEngine);
    	stack.getTagCompound().setInteger(rf.MAIN_TIER_BALLOON_TAG, this.mainTierBalloon);
    	
    	stack.getTagCompound().setInteger(rf.CORE_MODEL_VISUAL_FRAME_TAG, this.coreModelVisualFrame);
    	stack.getTagCompound().setInteger(rf.CORE_MODEL_VISUAL_ENGINE_TAG, this.coreModelVisualEngine);
    	stack.getTagCompound().setInteger(rf.CORE_MODEL_VISUAL_BALLOON_TAG, this.coreModelVisualBalloon);
    	
    	stack.getTagCompound().setInteger(rf.FRAME_SKIN_VISUAL_TAG, this.frameSkinVisual);
    	stack.getTagCompound().setBoolean(rf.FRAME_SKIN_VISUAL_TRANSPARENT_TAG, this.frameSkinVisualTransparent);
    	stack.getTagCompound().setBoolean(rf.FRAME_SKIN_VISUAL_COLOR_TAG, this.frameSkinVisualColor);
    	stack.getTagCompound().setInteger(rf.FRAME_SKIN_VISUAL_COLOR_RED_TAG, this.frameSkinColorRed);
    	stack.getTagCompound().setInteger(rf.FRAME_SKIN_VISUAL_COLOR_GREEN_TAG, this.frameSkinColorGreen);
    	stack.getTagCompound().setInteger(rf.FRAME_SKIN_VISUAL_COLOR_BLUE_TAG, this.frameSkinColorBlue);
    	
    	stack.getTagCompound().setInteger(rf.ENGINE_PARTICLE_VISUAL_TAG, this.engineParticleVisual);
    	stack.getTagCompound().setInteger(rf.ENGINE_DISPLAY_TYPE_VISUAL_TAG, this.engineDisplayTypeVisual);
    	stack.getTagCompound().setInteger(rf.ENGINE_DISPLAY_ID_VISUAL_TAG, this.engineDisplayIDVisual);
    	
    	stack.getTagCompound().setInteger(rf.BALLOON_PATTERN_VISUAL_TAG, this.balloonPatternVisual);
    	stack.getTagCompound().setBoolean(rf.BALLOON_PATTERN_VISUAL_TRANSPARENT_TAG, this.balloonPatternVisualTransparent);
    	stack.getTagCompound().setBoolean(rf.BALLOON_PATTERN_VISUAL_COLOR_TAG, this.balloonPatternVisualColor);
    	stack.getTagCompound().setInteger(rf.BALLOON_PATTERN_VISUAL_COLOR_RED_TAG, this.balloonPatternColorRed);
    	stack.getTagCompound().setInteger(rf.BALLOON_PATTERN_VISUAL_COLOR_GREEN_TAG, this.balloonPatternColorGreen);
    	stack.getTagCompound().setInteger(rf.BALLOON_PATTERN_VISUAL_COLOR_BLUE_TAG, this.balloonPatternColorBlue);
    	
    	stack.getTagCompound().setInteger(rf.STORED_FUEL_TAG, this.storedFuel);
    	stack.getTagCompound().setInteger(rf.STORED_FUEL_TOTAL_TAG, this.storedFuelTotal);
    	stack.getTagCompound().setInteger(rf.FUEL_ITEMSTACK_TAG, this.fuelItemStack);
    	stack.getTagCompound().setInteger(rf.FUEL_ITEMSTACK_SIZE_TAG, this.fuelItemStackSize);
    	stack.getTagCompound().setInteger(rf.STORED_REDSTONE_TAG, this.storedRedstone);
    	stack.getTagCompound().setInteger(rf.STORED_REDSTONE_TOTAL_TAG, this.storedRedstoneTotal);
    	
    	stack.getTagCompound().setInteger(rf.MODULE_ACTIVE_SLOT1_TAG, this.moduleActiveSlot1);
    	
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_ALTITUDE_TAG, this.learnedModuleAltitude);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_ALTITUDE_TAG, this.selectedModuleAltitude);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_SPEED_TAG, this.learnedModuleSpeed);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_SPEED_TAG, this.selectedModuleSpeed);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_STORAGE_TAG, this.learnedModuleStorage);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_STORAGE_TAG, this.selectedModuleStorage);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_FUEL_TAG, this.learnedModuleFuel);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_FUEL_TAG, this.selectedModuleFuel);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_MUSIC_TAG, this.learnedModuleMusic);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_MUSIC_TAG, this.selectedModuleMusic);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_CRUISE_TAG, this.learnedModuleCruise);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_CRUISE_TAG, this.selectedModuleCruise);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_WATER_TAG, this.learnedModuleWater);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_WATER_TAG, this.selectedModuleWater);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_FUELINFINITE_TAG, this.learnedModuleFuelInfinite);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_FUELINFINITE_TAG, this.selectedModuleFuelInfinite);
		stack.getTagCompound().setBoolean(rf.LEARNED_MODULE_BOMB_TAG, this.learnedModuleBomb);
		stack.getTagCompound().setInteger(rf.SELECTED_MODULE_BOMB_TAG, this.selectedModuleBomb);
		
		stack.getTagCompound().setTag(rf.AIRSHIP_SLOTS_TAG, this.inventory.serializeNBT());
		
		stack.getTagCompound().setString(rf.CUSTOM_NAME_TAG, this.customName);
		
    	return stack;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() 
	{
		String tier_name = this.getNameColor() //+ //EnumsVC.AirshipTierCore.byId(this.getMetaTierCore()).getLocalizedName()
				;
		String visualframe_name = "";
		String visualballoon_name = "";
		/**
		if(this.getCoreVisual() > 0)
		{
			visualframe_name = "\"" + EnumsVC.VisualFrame.byId(this.metaFrameVisual).getLocalizedName() + "\" ";
		}
		
		if(this.getBalloonVisual() > 0)
		{
			visualballoon_name = "\"" + EnumsVC.VisualBalloon.byId(this.metaBalloonVisual).getLocalizedName() + "\" ";
		}
		*/
		return this.hasCustomName() ? this.customName : 
			this.getNameColor() + ViesCraftConfig.v1AirshipName + " " + TextFormatting.GRAY + "(" + tier_name + TextFormatting.GRAY +")";
	}
	
	
	
	
	
    //==================================//
    // TODO       On Update             //
	//==================================//
    
    @Override
    public void onUpdate()
    {
    	if(this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_LESSER.getMetadata()
		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
		|| this.getModuleActiveSlot1() != EnumsVC.ModuleType.WATER_GREATER.getMetadata())
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
        	if(this.isFuelBurning())
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
            	if(isFuelBurning())
            	{
            		if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation -= (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	if(isFuelBurning())
            	{
            		if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 4));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 8));
                    }
            		else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
                    {
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier * 12));
                    }
            		else
            		{
            			this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 2));
            		}
            	}
            	else
            	{
            		this.deltaRotation += (finalAirshipSpeedTurn + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() * 4)) * 0.5F;
            	}
            }
            
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }
            
            this.rotationYaw += this.deltaRotation;
            
            //Move Forward
            //Cruise Control
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
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
	            	
	            	if(isFuelBurning())
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
	            	if(isFuelBurning())
	        		{
	        			f += finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier;
	        		}
	            	else
	            	{
	            		f += 0.003F;
	            	}
	            }
            }
            
            //Moving Backwards
            //Cruise Control
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
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
	            	
		            if(isFuelBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
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
	            	if(isFuelBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            }
            
            //Handles forward movement with the Cruise Control Module
            if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
    		|| this.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
            {
            	if(isFuelBurning()
            	&& this.getControllingPassenger() != null)
        		{
            		switch(this.metaCruiseControlSelectedSpeed)
	            	{
		            	case 0:
		            		f += 0F;
		            		break;
		            	case 1:
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) / 4;
		            		break;
		            	case 2:
		            		f += (finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier) / 2;
		            		break;
		            	case 3:
		            		f += finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() + this.speedModifier;
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
            	if(isFuelBurning())
        		{
        			if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
                    {
        				f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 14);
                    }
                	else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 8);
                    }
                	else if(this.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
                    {
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 4);
                    }
                	else if(!this.airshipHeightLimit())
	    			{
                		f1 += finalAirshipSpeedUp + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 32);
	    			}
        		}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= finalAirshipSpeedDown + (EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier() / 4) + (this.speedModifier / 4);
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
    	int moduleNumber = this.getModuleActiveSlot1();
    	
		if(moduleNumber >= 0)
		{
			this.moduleActiveSlot1 = 0;
			
			if(moduleNumber > 0)
			{
				this.moduleActiveSlot1 = moduleNumber;
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
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.30F);
			}
			if(moduleNumber == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.30F);
			}
			
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.66F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.33F);
			}
			if(moduleNumber == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
			{
				this.speedModifier = 0;
			}
			
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.90F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.80F);
			}
			if(moduleNumber == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				this.speedModifier = -((finalAirshipSpeedForward + EnumsVC.AirshipTierFrame.byId(this.mainTierFrame).getSpeedModifier()) * 0.70F);
			}
		}
    }
}

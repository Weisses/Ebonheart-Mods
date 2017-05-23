package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiDefault;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventoryLarge;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventorySmall;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipV1Core extends EntityAirshipBaseVC {
	
    float finalAirshipSpeedTurn = 0.18F * (ViesCraftConfig.v1AirshipSpeed / 100);
    float finalAirshipSpeedForward = (0.01F * (ViesCraftConfig.v1AirshipSpeed / 100));
    float finalAirshipSpeedUp = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
    float finalAirshipSpeedDown = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
    
    ISound soundCacheIdle;
    ISound soundCacheMoving;
    
	public EntityAirshipV1Core(World worldIn)
    {
        super(worldIn);
        
        this.inventory = new ItemStackHandler(size);
    }
	
    public EntityAirshipV1Core(World worldIn, double x, double y, double z, int frameIn, int balloonIn, int metaColorRedItem, int metaColorGreenItem, int metaColorBlueItem, int frameVisualIn, boolean frameVisualActive)
    {
        this(worldIn);
        this.setPosition(x, y + 0.5D, z);
        
        this.metaFrameVisual = frameVisualIn;
        this.frameVisualActive = frameVisualActive;
        
        this.metaFrameCore = frameIn;
        this.metaBalloon = balloonIn;
        this.metaColorRed = metaColorRedItem;
        this.metaColorGreen = metaColorGreenItem;
        this.metaColorBlue = metaColorBlueItem;
        
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
        
		this.dataManager.register(POWERED, Integer.valueOf(this.airshipBurnTime));
        this.dataManager.register(TOTALPOWERED, Integer.valueOf(this.airshipTotalBurnTime));
        this.dataManager.register(ITEMFUELSTACKPOWERED, Integer.valueOf(this.itemFuelStack));
        this.dataManager.register(ITEMFUELSTACKSIZEPOWERED, Integer.valueOf(this.itemFuelStackSize));
        
        this.dataManager.register(MODULE_SPEED_MINOR, Boolean.valueOf(this.moduleSpeedMinor));
        this.dataManager.register(MODULE_SPEED_MAJOR, Boolean.valueOf(this.moduleSpeedMajor));
        this.dataManager.register(MODULE_INVENTORY_SMALL, Boolean.valueOf(this.moduleInventorySmall));
        this.dataManager.register(MODULE_INVENTORY_LARGE, Boolean.valueOf(this.moduleInventoryLarge));
        this.dataManager.register(MODULE_FUEL_INFINITE, Boolean.valueOf(this.moduleFuelInfinite));
        this.dataManager.register(MODULE_WATER_LANDING, Boolean.valueOf(this.moduleWaterLanding));
        this.dataManager.register(MODULE_MAX_ALTITUDE, Boolean.valueOf(this.moduleMaxAltitude));
        this.dataManager.register(MODULE_MINOR_EFFICIENCY, Boolean.valueOf(this.moduleMinorEfficiency));
        this.dataManager.register(MODULE_MAJOR_EFFICIENCY, Boolean.valueOf(this.moduleMajorEfficiency));
        this.dataManager.register(MODULE_JUKEBOX, Boolean.valueOf(this.moduleJukebox));
        this.dataManager.register(MODULE_JUKEBOX_SELECTED_SONG, Integer.valueOf(this.jukeboxSelectedSong));
        this.dataManager.register(MODULE_CRUISECONTROL, Boolean.valueOf(this.moduleCruiseControl));
        this.dataManager.register(MODULE_CRUISECONTROL_SELECTED_SPEED, Integer.valueOf(this.cruiseControlSelectedSpeed));
        
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
    	
    	compound.setInteger("FrameVisual", this.metaFrameVisual);
    	compound.setBoolean("FrameVisualActive", this.frameVisualActive);
    	
    	compound.setInteger("Frame", this.metaFrameCore);
    	compound.setInteger("Balloon", this.metaBalloon);
    	compound.setInteger("ColorRed", this.metaColorRed);
    	compound.setInteger("ColorGreen", this.metaColorGreen);
    	compound.setInteger("ColorBlue", this.metaColorBlue);
    	
    	compound.setTag("Slots", inventory.serializeNBT());
    	
    	compound.setInteger("BurnTime", this.airshipBurnTime);
    	compound.setInteger("TotalBurnTime", this.airshipTotalBurnTime);
    	compound.setInteger("FuelStackTime", this.itemFuelStack);
    	compound.setInteger("FuelStackTimeSize", this.itemFuelStackSize);
    	
    	compound.setInteger("JukeboxSelectedSong", this.jukeboxSelectedSong);
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
    	this.metaFrameVisual = compound.getInteger("FrameVisual");
    	this.frameVisualActive = compound.getBoolean("FrameVisualActive");
    	
    	this.metaFrameCore = compound.getInteger("Frame");
    	this.metaBalloon = compound.getInteger("Balloon");
    	this.metaColorRed = compound.getInteger("ColorRed");
    	this.metaColorGreen = compound.getInteger("ColorGreen");
    	this.metaColorBlue = compound.getInteger("ColorBlue");
    	
    	inventory.deserializeNBT(compound.getCompoundTag("Slots"));
    	
        this.airshipBurnTime = compound.getInteger("BurnTime");
        this.airshipTotalBurnTime = compound.getInteger("TotalBurnTime");
        this.itemFuelStack = compound.getInteger("FuelStackTime");
        this.itemFuelStackSize = compound.getInteger("FuelStackTimeSize");
        
        this.jukeboxSelectedSong = compound.getInteger("JukeboxSelectedSong");
    }
    
    
    
	//==================================//
    // TODO        Item/Name            //
	//==================================//
    
    @Override
	public ItemStack getItemBoat()
    {
    	ItemStack stack = new ItemStack(InitItemsVC.item_airship_v1, 1, this.metaFrameCore);
    	stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger("FrameVisual", this.metaFrameVisual);
    	stack.getTagCompound().setBoolean("FrameVisualActive", this.frameVisualActive);
    	
    	stack.getTagCompound().setInteger("Balloon", this.metaBalloon);
    	stack.getTagCompound().setInteger("ColorRed", this.metaColorRed);
    	stack.getTagCompound().setInteger("ColorGreen", this.metaColorGreen);
    	stack.getTagCompound().setInteger("ColorBlue", this.metaColorBlue);
    	
    	return stack;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() 
	{
		String name = FrameCore.byId(this.metaFrameCore).getName();
		
		if(this.frameVisualActive)
		{
			name = "\"" + FrameCore.byId(this.metaFrameCore).getName() + "\"";
		}
		
		return this.hasCustomName() ? this.customName : 
			ColorHelperVC.getColorNameFromRgb(this.metaColorRed, this.metaColorGreen, this.metaColorBlue)		
			+ " " + name + " " + ViesCraftConfig.v1AirshipName;
	}
	
	
	
    //==================================//
    // TODO       On Update             //
	//==================================//
    
    @Override
    public void onUpdate()
    {
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
        
        if(!this.getModuleWaterLanding())
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
        	
        	if (this.worldObj.isRemote)
            {
        		this.updateInputs();
        		this.controlAirshipGui();
            }
        	
        	this.moveEntity(this.motionX, this.motionY, this.motionZ);
        }
        else
        {
        	this.motionX = 0.0D;
            this.motionY = 0.0D;
            this.motionZ = 0.0D;
        }
        
        this.doBlockCollisions();
        List<Entity> list = this.worldObj.getEntitiesInAABBexcluding(this, this.getEntityBoundingBox().expand(0.20000000298023224D, -0.009999999776482582D, 0.20000000298023224D), EntitySelectors.<Entity>getTeamCollisionPredicate(this));
        
        if (!list.isEmpty())
        {
            boolean flag = !this.worldObj.isRemote && !(this.getControllingPassenger() instanceof EntityPlayer);
            
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
    	this.updateAirshipMeta();
        this.fallInGround();
        this.getAirshipFuelTick();
        
        this.fuelFlight();
        this.getTotalFuelSlotBurnTime();
        
        this.visualFrame();
        this.currentModule();
        
        this.noModuleDropInv();
        
        //if (this.world.isRemote)
        //{
        //	this.engineOnSound();
        //}
        
        if(!(this.getControllingPassenger() instanceof EntityPlayer)
        	&& this.cruiseControlSelectedSpeed != 0)
		{
    		this.cruiseControlSelectedSpeed = 0;
    		this.setCruiseControlSelectedSpeed(this.cruiseControlSelectedSpeed);
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
            if (this.status == EntityAirshipBaseVC.Status.IN_WATER
            && !this.getModuleWaterLanding())
            {
            	this.momentum = 0.45F;
            }
            else if (this.status == EntityAirshipBaseVC.Status.IN_WATER
            && this.getModuleWaterLanding())
            {
            	this.momentum = 0.9F;
            }
            else if (this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipBaseVC.Status.UNDER_WATER
        	  && !this.getModuleWaterLanding())
            {
            	this.waterPartsDrop();
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
        		if(this.motionY >= -0.039D)
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
            
            if(fallInGround())
            {
            	this.motionY = 0;
            }
            
            if(this.getModuleWaterLanding())
            {
            	if (this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
				|| this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
				{
            		this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
				}
            	if (this.status == EntityAirshipBaseVC.Status.IN_WATER)
	            {
	            	this.motionY = 0;
	            }
            }
            
            if(!this.getModuleMaxAltitude()
            && this.getPosition().getY() > FrameCore.byId(this.metaFrameCore).getElevation())
            {
            	this.motionY = -0.1D;
            }
        }
    }
    
    @Override
    public void controlAirship()
    {
    	if (this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            //Turning Left
            if (this.leftInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation -= (finalAirshipSpeedTurn + (FrameCore.byId(this.metaFrameCore).getSpeed() * 4));
            	}
            	else
            	{
            		this.deltaRotation -= (finalAirshipSpeedTurn + (FrameCore.byId(this.metaFrameCore).getSpeed() * 4)) * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation += (finalAirshipSpeedTurn + (FrameCore.byId(this.metaFrameCore).getSpeed() * 4));
            	}
            	else
            	{
            		this.deltaRotation += (finalAirshipSpeedTurn + (FrameCore.byId(this.metaFrameCore).getSpeed() * 4)) * 0.5F;
            	}
            }
            
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }
            
            this.rotationYaw += this.deltaRotation;
            
            //Move Forward
            if(this.getModuleCruiseControl())
            {
            	if(this.forwardInputDown)
	            {
            		if(this.cruiseControlSelectedSpeed < 3)
	            	{
	            		this.cruiseControlSelectedSpeed++;
	            	}
	            	else
	            	{
	            		this.cruiseControlSelectedSpeed = 3;
	            	}
            		
            		this.setCruiseControlSelectedSpeed(this.cruiseControlSelectedSpeed);
	            	
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
	        			f += finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier;
	        		}
	            	else
	            	{
	            		f += 0.003F;
	            	}
	            }
            }
            
            //Moving Backwards
            if(this.getModuleCruiseControl())
            {
            	if(this.backInputDown)
	            {
	            	if(this.cruiseControlSelectedSpeed > 0)
	            	{
	            		this.cruiseControlSelectedSpeed--;
	            	}
	            	else
	            	{
	            		this.cruiseControlSelectedSpeed = 0;
	            	}
	            	
            		this.setCruiseControlSelectedSpeed(this.cruiseControlSelectedSpeed);
	            	
		            if(isClientAirshipBurning())
	        		{
	        			f -= (finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier) * 0.5;
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
	        			f -= (finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier) * 0.5;
	        		}
	            	else
	            	{
	            		f -= 0.003F * 0.5;
	            	}
	            }
            }
            
            //Handles forward movement with the Cruise Control Module
            if(this.getModuleCruiseControl())
            {
            	if(isClientAirshipBurning()
            	&& this.getControllingPassenger() != null)
        		{
            		switch(this.cruiseControlSelectedSpeed)
	            	{
		            	case 0:
		            		f += 0F;
		            		break;
		            	case 1:
		            		f += (finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier) / 4;
		            		break;
		            	case 2:
		            		f += (finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier) / 2;
		            		break;
		            	case 3:
		            		f += finalAirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed() + this.speedModifier;
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
            	//Check airship max height
            	if(!this.airshipHeightLimit()
            	|| this.getModuleMaxAltitude())
    			{
            		if(isClientAirshipBurning())
            		{
            			f1 += finalAirshipSpeedUp + (FrameCore.byId(this.metaFrameCore).getSpeed() / 4);
            		}
    			}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= finalAirshipSpeedDown + (FrameCore.byId(this.metaFrameCore).getSpeed() / 4);
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
			//If airship has small inv module installed
        	if(this.getModuleInventorySmall())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleInventorySmall());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//If airship has large inv module installed
        	else if(this.getModuleInventoryLarge())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleInventoryLarge());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//If airship has jukebox module installed
        	else if(this.getModuleJukebox())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleJukebox());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiDefault());
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
    	if (!this.worldObj.isRemote)
    	{
    		this.dropInvDead();
    		
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
        
        //Syncs the server info to the client
        if(this.worldObj.isRemote)
        {
        	this.airshipBurnTime = this.getPowered();
        	this.airshipTotalBurnTime = this.getTotalPowered();
        }
        
        //Handles how burn time is ticked down
        if (this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleFuelInfinite())
        	{
        		
        	}
        	else 
        	{
        		this.airshipBurnTime = this.airshipBurnTime - this.airshipFuelTick;
        	}
        }
        
        //Handles when the airship is off
        if (!this.isClientAirshipBurning())
        {
        	//Airship has Infinite Fuel Module installed
        	if(this.getModuleFuelInfinite())
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
        if (this.isClientAirshipBurning() || this.inventory.getStackInSlot(0) != null)
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
                    if (this.inventory.getStackInSlot(0) != null)
                    {
                        if (this.inventory.getStackInSlot(0).stackSize == 0)
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
        
        //Saves the fuel burn time server side
        if(!this.worldObj.isRemote)
        {
        	this.setPowered(this.airshipBurnTime);
        	this.setTotalPowered(this.airshipTotalBurnTime);
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
        if (stack == null)
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
            
            if (item == InitItemsVC.viesoline_pellets) return (ViesCraftConfig.viesolineBurnTime * 20) * 10;
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
    	//Passes itemFuelStack to client for gui
    	if(this.worldObj.isRemote)
		{
    		this.itemFuelStack = this.getItemFuelStackPowered();
			this.itemFuelStackSize = this.getItemFuelStackSizePowered();
		}
    	
    	if(this.getControllingPassenger() != null)
    	{
    		if (this.isClientAirshipBurning())
            {
    			ItemStack itemFuel = this.inventory.getStackInSlot(0);
    			
    			if(itemFuel != null)
    			{
    				this.itemFuelStackSize = this.inventory.getStackInSlot(0).stackSize;
    					
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
    	
    	if(!this.worldObj.isRemote)
		{
    		this.setItemFuelStackPowered(this.itemFuelStack);
			this.setItemFuelStackSizePowered(this.itemFuelStackSize);
		}
    }
    
	/**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setPowered(int airshipBurnTime1)
    {
        this.dataManager.set(POWERED, Integer.valueOf(airshipBurnTime1));
    }
	
    @Override
    public int getPowered()
    {
        return ((Integer)this.dataManager.get(POWERED)).intValue();
    }
    
    /**
     * Sets the airshipTotalBurnTime to pass from server to client.
     */
    public void setTotalPowered(int airshipTotalBurnTime1)
    {
        this.dataManager.set(TOTALPOWERED, Integer.valueOf(airshipTotalBurnTime1));
    }
	
    @Override
    public int getTotalPowered()
    {
        return ((Integer)this.dataManager.get(TOTALPOWERED)).intValue();
    }
    
    /**
     * Sets the itemFuelStack to pass from server to client.
     */
    public void setItemFuelStackPowered(int itemFuelStack1)
    {
        this.dataManager.set(ITEMFUELSTACKPOWERED, Integer.valueOf(itemFuelStack1));
    }
	
    @Override
    public int getItemFuelStackPowered()
    {
        return ((Integer)this.dataManager.get(ITEMFUELSTACKPOWERED)).intValue();
    }
    
	/**
     * Sets the itemFuelStackSize to pass from server to client.
     */
    public void setItemFuelStackSizePowered(int itemFuelStackSize1)
    {
        this.dataManager.set(ITEMFUELSTACKSIZEPOWERED, Integer.valueOf(itemFuelStackSize1));
    }
	
    @Override
    public int getItemFuelStackSizePowered()
    {
        return ((Integer)this.dataManager.get(ITEMFUELSTACKSIZEPOWERED)).intValue();
    }
    
    
    
    //==================================//
  	// TODO     Airship Modules         //
  	//==================================//
    
    public void currentModule()
    {
    	ItemStack itemModule = this.inventory.getStackInSlot(1);
		int moduleNumber = this.getModuleID(itemModule);
		
		/**
		if(this.world.isRemote)
		{
			if(this.getModuleSpeedMinor())
				LogHelper.info("1");
			if(this.getModuleSpeedMajor())
				LogHelper.info("2");
			if(this.getModuleInventorySmall())
				LogHelper.info("3");
			if(this.getModuleInventoryLarge())
				LogHelper.info("4");
			if(this.getModuleFuelInfinite())
				LogHelper.info("5");
			if(this.getModuleWaterLanding())
				LogHelper.info("6");
			if(this.getModuleMaxAltitude())
				LogHelper.info("7");
			if(this.getModuleMinorEfficiency())
				LogHelper.info("8");
			if(this.getModuleMajorEfficiency())
				LogHelper.info("9");
			if(this.getModuleJukebox())
				LogHelper.info("10");
			if(this.getModuleCruiseControl())
				LogHelper.info("11");
		}
		*/
		
		//Syncs the module boolean client side
		if(this.worldObj.isRemote)
		{
    		this.moduleSpeedMinor = this.getModuleSpeedMinor();
    		this.moduleSpeedMajor = this.getModuleSpeedMajor();
    		this.moduleInventorySmall = this.getModuleInventorySmall();
    		this.moduleInventoryLarge = this.getModuleInventoryLarge();
    		this.moduleFuelInfinite = this.getModuleFuelInfinite();
    		this.moduleWaterLanding = this.getModuleWaterLanding();
    		this.moduleMaxAltitude = this.getModuleMaxAltitude();
    		this.moduleMinorEfficiency = this.getModuleMinorEfficiency();
    		this.moduleMajorEfficiency = this.getModuleMajorEfficiency();
    		this.moduleJukebox = this.getModuleJukebox();
    		this.jukeboxSelectedSong = this.getJukeboxSelectedSong();
    		this.moduleCruiseControl = this.getModuleCruiseControl();
    		this.cruiseControlSelectedSpeed = this.getCruiseControlSelectedSpeed();
		}
		
		if(moduleNumber >= 0)
		{
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleFuelInfinite = false;
			this.moduleWaterLanding = false;
			this.moduleMaxAltitude = false;
			this.moduleMinorEfficiency = false;
			this.moduleMajorEfficiency = false;
			this.moduleJukebox = false;
			this.moduleCruiseControl = false;
			
			if(moduleNumber == 0)
			{
				this.speedModifier = 0;
			}
			if(moduleNumber == 1)
			{
				this.moduleSpeedMinor = true;
				this.speedModifier = 0.008F;
			}
			if(moduleNumber == 2)
			{
				this.moduleSpeedMajor = true;
				this.speedModifier = 0.016F;
			}
			if(moduleNumber == 3)
			{
				this.moduleInventorySmall = true;
				this.speedModifier = -(finalAirshipSpeedForward * 0.2F);
			}
			if(moduleNumber == 4)
			{
				this.moduleInventoryLarge = true;
				this.speedModifier = -(finalAirshipSpeedForward * 0.3F);
			}
			if(moduleNumber == 5)
			{
				this.moduleFuelInfinite = true;
				this.speedModifier = -(finalAirshipSpeedForward * 0.5F);
			}
			if(moduleNumber == 6)
			{
				this.moduleWaterLanding = true;
				this.speedModifier = 0;
			}
			if(moduleNumber == 7)
			{
				this.moduleMaxAltitude = true;
				this.speedModifier = 0;
			}
			if(moduleNumber == 8)
			{
				this.moduleMinorEfficiency = true;
				this.speedModifier = 0;
			}
			if(moduleNumber == 9)
			{
				this.moduleMajorEfficiency = true;
				this.speedModifier = -(finalAirshipSpeedForward * 0.3F);
			}
			if(moduleNumber == 10)
			{
				this.moduleJukebox = true;
				this.speedModifier = 0;
			}
			if(moduleNumber == 11)
			{
				this.moduleCruiseControl = true;
				this.speedModifier = 0;
			}
		}
		
		//Saves the module boolean to server side
    	if(!this.worldObj.isRemote)
		{
    		this.setModuleSpeedMinor(this.moduleSpeedMinor);
    		this.setModuleSpeedMajor(this.moduleSpeedMajor);
    		this.setModuleInventorySmall(this.moduleInventorySmall);
    		this.setModuleInventoryLarge(this.moduleInventoryLarge);
    		this.setModuleFuelInfinite(this.moduleFuelInfinite);
    		this.setModuleWaterLanding(this.moduleWaterLanding);
    		this.setModuleMaxAltitude(this.moduleMaxAltitude);
    		this.setModuleMinorEfficiency(this.moduleMinorEfficiency);
    		this.setModuleMajorEfficiency(this.moduleMajorEfficiency);
    		this.setModuleJukebox(this.moduleJukebox);
    		this.setJukeboxSelectedSong(this.jukeboxSelectedSong);
    		this.setModuleCruiseControl(this.moduleCruiseControl);
    		this.setCruiseControlSelectedSpeed(this.cruiseControlSelectedSpeed);
    	}
    }
    
    /**
     * Checks if a module is in the module slot.
     */
    public static boolean getItemModule(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }
        else
        {
            Item item = stack.getItem();
            
            if (item == InitItemsVC.airship_module) return true;
            
            return false;
        }
    }
    
    /**
     * Set module ID for module in slot.
     */
    public static int getModuleID(ItemStack stack)
    {
        if (stack == null)
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            
            if(item == InitItemsVC.airship_module)
            {
            	return item.getMetadata(stack);
            }
            else 
            {
            	return 0;
            }
        }
    }
    
    public static boolean isItemModule(ItemStack stack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemModule(stack);
    }
    
    /**
     * Sets if Minor Speed Increase mod is installed to pass from server to client.
     */
    public void setModuleSpeedMinor(boolean moduleSpeed1)
    {
        this.dataManager.set(MODULE_SPEED_MINOR, Boolean.valueOf(moduleSpeed1));
    }
    
    @Override
    public boolean getModuleSpeedMinor()
    {
        return ((Boolean)this.dataManager.get(MODULE_SPEED_MINOR)).booleanValue();
    }
    
    /**
     * Sets if Major Speed Increase mod is installed to pass from server to client.
     */
    public void setModuleSpeedMajor(boolean moduleSpeed2)
    {
        this.dataManager.set(MODULE_SPEED_MAJOR, Boolean.valueOf(moduleSpeed2));
    }
    
    @Override
    public boolean getModuleSpeedMajor()
    {
        return ((Boolean)this.dataManager.get(MODULE_SPEED_MAJOR)).booleanValue();
    }
    
    /**
     * Sets the Small Inventory boolean to pass from server to client.
     */
    public void setModuleInventorySmall(boolean moduleInvSmall1)
    {
        this.dataManager.set(MODULE_INVENTORY_SMALL, Boolean.valueOf(moduleInvSmall1));
    }
	
    @Override
    public boolean getModuleInventorySmall()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_SMALL)).booleanValue();
    }
    
    /**
     * Sets the Large Inventory boolean to pass from server to client.
     */
    public void setModuleInventoryLarge(boolean moduleInvLarge1)
    {
        this.dataManager.set(MODULE_INVENTORY_LARGE, Boolean.valueOf(moduleInvLarge1));
    }
	
    @Override
    public boolean getModuleInventoryLarge()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_LARGE)).booleanValue();
    }
    
    /**
     * Sets the Infinite Fuel boolean to pass from server to client.
     */
    public void setModuleFuelInfinite(boolean moduleFuelInfinite1)
    {
        this.dataManager.set(MODULE_FUEL_INFINITE, Boolean.valueOf(moduleFuelInfinite1));
    }
	
    @Override
    public boolean getModuleFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_FUEL_INFINITE)).booleanValue();
    }
    
    /**
     * Sets if Water Landing mod is installed to pass from server to client.
     */
    public void setModuleWaterLanding(boolean moduleWaterLanding1)
    {
        this.dataManager.set(MODULE_WATER_LANDING, Boolean.valueOf(moduleWaterLanding1));
    }
    
    @Override
    public boolean getModuleWaterLanding()
    {
        return ((Boolean)this.dataManager.get(MODULE_WATER_LANDING)).booleanValue();
    }

    /**
     * Sets if Max Altitude mod is installed to pass from server to client.
     */
    public void setModuleMaxAltitude(boolean moduleMaxAltitude1)
    {
        this.dataManager.set(MODULE_MAX_ALTITUDE, Boolean.valueOf(moduleMaxAltitude1));
    }
    
    @Override
    public boolean getModuleMaxAltitude()
    {
        return ((Boolean)this.dataManager.get(MODULE_MAX_ALTITUDE)).booleanValue();
    }

    /**
     * Sets if Minor Efficiency mod is installed to pass from server to client.
     */
    public void setModuleMinorEfficiency(boolean moduleMinorEfficiency1)
    {
        this.dataManager.set(MODULE_MINOR_EFFICIENCY, Boolean.valueOf(moduleMinorEfficiency1));
    }
    
    @Override
    public boolean getModuleMinorEfficiency()
    {
        return ((Boolean)this.dataManager.get(MODULE_MINOR_EFFICIENCY)).booleanValue();
    }

    /**
     * Sets if Major Efficiency mod is installed to pass from server to client.
     */
    public void setModuleMajorEfficiency(boolean moduleMajorEfficiency1)
    {
        this.dataManager.set(MODULE_MAJOR_EFFICIENCY, Boolean.valueOf(moduleMajorEfficiency1));
    }
    
    @Override
    public boolean getModuleMajorEfficiency()
    {
        return ((Boolean)this.dataManager.get(MODULE_MAJOR_EFFICIENCY)).booleanValue();
    }

    /**
     * Sets if Jukebox mod is installed to pass from server to client.
     */
    public void setModuleJukebox(boolean moduleJukebox1)
    {
        this.dataManager.set(MODULE_JUKEBOX, Boolean.valueOf(moduleJukebox1));
    }
    
    @Override
    public boolean getModuleJukebox()
    {
        return ((Boolean)this.dataManager.get(MODULE_JUKEBOX)).booleanValue();
    }
    
	/**
     * Sets the jukebox selected song to pass from server to client.
     */
    public void setJukeboxSelectedSong(int jukeboxSelectedSong1)
    {
        this.dataManager.set(MODULE_JUKEBOX_SELECTED_SONG, Integer.valueOf(jukeboxSelectedSong1));
    }
	
    @Override
    public int getJukeboxSelectedSong()
    {
        return ((Integer)this.dataManager.get(MODULE_JUKEBOX_SELECTED_SONG)).intValue();
    }

    /**
     * Sets if Cruise Control mod is installed to pass from server to client.
     */
    public void setModuleCruiseControl(boolean moduleCruiseControl1)
    {
        this.dataManager.set(MODULE_CRUISECONTROL, Boolean.valueOf(moduleCruiseControl1));
    }
    
    @Override
    public boolean getModuleCruiseControl()
    {
        return ((Boolean)this.dataManager.get(MODULE_CRUISECONTROL)).booleanValue();
    }
    
	/**
     * Sets the Cruise Control selected speed to pass from server to client.
     */
    public void setCruiseControlSelectedSpeed(int cruiseControlSelectedSpeed1)
    {
        this.dataManager.set(MODULE_CRUISECONTROL_SELECTED_SPEED, Integer.valueOf(cruiseControlSelectedSpeed1));
    }
	
    @Override
    public int getCruiseControlSelectedSpeed()
    {
        return ((Integer)this.dataManager.get(MODULE_CRUISECONTROL_SELECTED_SPEED)).intValue();
    }
    
    
    
    //==================================//
  	// TODO          Misc               //
  	//==================================//
    
    /**
     * Root Method that will drop everything in all inventory slots minus fuel
     */
    private void noModuleDropInv()
    {
    	//Used to drop inventory if inv modules are removed/switched
		// If there is no module in slot
		if(this.inventory.getStackInSlot(1) == null)
		{
			//If small inv mod is removed and slot is empty
			if(dropNumber == 1)
			{
				dropNumber = 0;
				this.dropInv();
			}
			
			//If large inv mod is removed and slot is empty
			if(dropNumber == 2)
			{
				dropNumber = 0;
				this.dropInv();
			}
		}
		//If a module is still in the slot
		else
		{
			//If the module in the slot is small inv mod
			if(this.inventory.getStackInSlot(1).getItem() == new ItemStack(InitItemsVC.airship_module, 1, 3).getItem()
			&& dropNumber == 0)
			{
				dropNumber = 1;
			}
			
			//If the module in the slot is large inv mod
			else if(this.inventory.getStackInSlot(1).getItem() == new ItemStack(InitItemsVC.airship_module, 1, 4).getItem()
			&& dropNumber == 0)
			{
				dropNumber = 2;
			}
			
			//If the module in the slot is not small inv mod but had it in previously
			else if(this.inventory.getStackInSlot(1).getItem() != new ItemStack(InitItemsVC.airship_module, 1, 3).getItem()
					&& dropNumber == 1)
			{
				dropNumber = 0;
				this.dropInv();
			}
			
			//If the module in the slot is not large inv mod but had it in previously
			else if(this.inventory.getStackInSlot(1).getItem() != new ItemStack(InitItemsVC.airship_module, 1, 4).getItem()
					&& dropNumber == 2)
			{
				dropNumber = 0;
				this.dropInv();
			}
		}
    }
    
    /**
     * Drops inventory contents only from airship (not fuel/module).
     */
    public void dropInv()
    {
    	if(this.worldObj.isRemote)
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.inventory.getStackInSlot(x) != null)
				{
					ItemStack test = this.inventory.getStackInSlot(x);
					test = null;
				}
			}
		}
		else
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.inventory.getStackInSlot(x) != null)
				{
					ItemStack test = this.inventory.getStackInSlot(x);
					InventoryHelper.spawnItemStack(this.worldObj, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
					test = null;
				}
			}
		}
    }
    
    /**
     * Drops all inventory contents.
     */
    protected void dropInvDead()
    {
    	if(this.worldObj.isRemote)
		{
			for (int x = 0; x < 20; ++x) 
			{
				if(this.inventory.getStackInSlot(x) != null)
				{
					ItemStack test = this.inventory.getStackInSlot(x);
					test = null;
				}
			}
		}
		else
		{
			for (int x = 0; x < 20; ++x) 
			{
				if(this.inventory.getStackInSlot(x) != null)
				{
					ItemStack test = this.inventory.getStackInSlot(x);
					InventoryHelper.spawnItemStack(this.worldObj, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
					test = null;
				}
			}
		}
    }
    
    public void visualFrame()
    {
    	if(this.frameVisualActive == true
    	&& this.metaFrameVisual == this.metaFrameCore)
    	{
    		this.frameVisualActive = false;
    	}
    	
    	//Syncs the module boolean client side
		if(this.worldObj.isRemote)
		{
    		this.metaFrameVisual = this.getVisualFrame();
    		this.frameVisualActive = this.getVisualFrameActive();
		}
    	
    	//Saves the visual frame to server side
    	if(!this.worldObj.isRemote)
		{
			this.setVisualFrame(this.metaFrameVisual);
			this.setVisualFrameActive(this.frameVisualActive);
    	}
    }
    
	/**
     * Sets the Visual Frame to pass from server to client.
     */
    public void setVisualFrame(int metaVisualFrame1)
    {
        this.dataManager.set(AIRSHIP_VISUAL_FRAME_VC, Integer.valueOf(metaVisualFrame1));
    }
	
    /**
     * Gets the Visual Frame to pass from server to client.
     */
    public int getVisualFrame()
    {
        return ((Integer)this.dataManager.get(AIRSHIP_VISUAL_FRAME_VC)).intValue();
    }
    
    /**
     * Gets the Minor Speed boolean to pass from server to client.
     */
    public boolean getVisualFrameActive()
    {
        return ((Boolean)this.dataManager.get(AIRSHIP_VISUAL_FRAME_ACTIVE_VC)).booleanValue();
    }
    
    /**
     * Sets if Major Speed Increase mod is installed to pass from server to client.
     */
    public void setVisualFrameActive(boolean frameVisualActive1)
    {
        this.dataManager.set(AIRSHIP_VISUAL_FRAME_ACTIVE_VC, Boolean.valueOf(frameVisualActive1));
    }
    
    
    
	//==================================//
  	// TODO     Sound Events            //
  	//==================================//
    /**
    @SideOnly(Side.CLIENT)
    protected void engineOnSound()
    {
    	if(ViesCraftConfig.engineSounds)
    	{
	    	SoundHandler handler = Minecraft.getMinecraft().getSoundHandler();
	    	
	    	if(this.isClientAirshipBurning())
	    	{
	    		/**
	    		if(this.motionX >= 0.003 || this.motionY >= 0.003 || this.motionX >= 0.003
	    		|| this.motionX <= -0.003 || this.motionY <= -0.003 || this.motionX <= -0.003)
				{
	    			if(soundCacheMoving==null || !handler.isSoundPlaying(soundCacheMoving))
			    	{
			    		if(soundCacheMoving==null)
			    		{
			    			soundCacheMoving = new EngineOnMovingSoundVC(this, InitSoundEventsVC.engineOn);
			    		}
			    		handler.playSound(soundCacheMoving);
			    	}
				}
    			else
    	        {
    	    		if(handler.isSoundPlaying(soundCacheMoving))
    		    	{
    		    		handler.stopSound(soundCacheMoving);
    		    	}
    	        }
	    		*/
    /**
	    		//soundCacheIdle = new EngineOnMovingSoundVC(this, InitSoundEventsVC.engineOn);
		    	if(soundCacheIdle==null || !handler.isSoundPlaying(soundCacheIdle))
		    	{
		    		if(soundCacheIdle==null)
		    		{
		    			LogHelper.info("Set sound");
		    			soundCacheIdle = new EngineOnMovingSoundVC(this, InitSoundEventsVC.engineOn);
		    		}
		    		LogHelper.info("Play sound");
		    		handler.playSound(soundCacheIdle);
		    	}
	    	}
	    	else
	        {
	    		if(handler.isSoundPlaying(soundCacheIdle))
		    	{
	    			LogHelper.info("Stop sound");
		    		handler.stopSound(soundCacheIdle);
		    	}
	        }
    	}
    }
    */
    //public void test()
    //{
    //	LogHelper.info("test = " + Keybinds.vcForward.isPressed());
    //	if(Keybinds.vcForward
    ///			.isPressed()
    //			//.isKeyDown()
    //			&& this.getControllingPassenger() != null
    //			)
    //	{
    		
    //		LogHelper.info("Pressed tg254");
    //	}
    //}
}

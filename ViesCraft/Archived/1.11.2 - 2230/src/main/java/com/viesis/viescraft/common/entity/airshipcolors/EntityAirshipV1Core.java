package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.FuelVC;
import com.viesis.viescraft.client.InitParticlesVCRender;
import com.viesis.viescraft.common.caps.DualEnergyStorageVC;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v1.MessageGuiV1Default;
import com.viesis.viescraft.network.server.v1.MessageGuiV1ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v1.MessageGuiV1ModuleInventorySmall;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
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
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;

public class EntityAirshipV1Core extends EntityAirshipBaseVC {
	
	/** Fuel */
	protected static final DataParameter<Integer> POWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> TOTALPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	protected static final DataParameter<Integer> ITEMFUELSTACKSIZEPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
    
    /** Passive Modules */
	protected static final DataParameter<Boolean> MODULE_INVENTORY_SMALL = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_INVENTORY_LARGE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_FUEL_INFINITE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MINOR = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	protected static final DataParameter<Boolean> MODULE_SPEED_MAJOR = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	
	public String customName;
	private int dropNumber;
	
	/** Fuel */
	public int airshipBurnTime;
	public int airshipTotalBurnTime;
	public int itemFuelStackSize;
	public int itemFuelStack;
	
	/** Passive Modules */
    public static boolean moduleInventorySmall;
    public static boolean moduleInventoryLarge;
    public static boolean moduleFuelInfinite;
    public static boolean moduleSpeedMinor;
    public static boolean moduleSpeedMajor;
    
    /** My capabilities inventory */
    public ItemStackHandler inventory;
    private int size = 20;
    
    public float AirshipSpeedTurn = 0.18F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedForward = 0.016F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedUp = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedDown = 0.004F * (ViesCraftConfig.v1AirshipSpeed / 100);
	
	public EntityAirshipV1Core(World worldIn)
    {
        super(worldIn);
        
        this.inventory = new ItemStackHandler(size);
    }
	
    public EntityAirshipV1Core(World worldIn, double x, double y, double z, int frameIn, int balloonIn, int metaColorRedItem, int metaColorGreenItem, int metaColorBlueItem)
    {
        this(worldIn);
        this.setPosition(x, y + 0.5D, z);
        
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
        
        this.dataManager.register(AIRSHIP_TYPE_FRAME_VC, Integer.valueOf(this.metaFrameCore));
        this.dataManager.register(AIRSHIP_TYPE_BALLOON_VC, Integer.valueOf(this.metaBalloon));
        this.dataManager.register(BALLOON_COLOR_RED_VC, Integer.valueOf(this.metaColorRed));
        this.dataManager.register(BALLOON_COLOR_GREEN_VC, Integer.valueOf(this.metaColorGreen));
        this.dataManager.register(BALLOON_COLOR_BLUE_VC, Integer.valueOf(this.metaColorBlue));
        
		this.dataManager.register(POWERED, Integer.valueOf(this.airshipBurnTime));
        this.dataManager.register(TOTALPOWERED, Integer.valueOf(this.airshipTotalBurnTime));
        this.dataManager.register(ITEMFUELSTACKPOWERED, Integer.valueOf(this.itemFuelStack));
        this.dataManager.register(ITEMFUELSTACKSIZEPOWERED, Integer.valueOf(this.itemFuelStackSize));
        
        this.dataManager.register(MODULE_INVENTORY_SMALL, Boolean.valueOf(this.moduleInventorySmall));
        this.dataManager.register(MODULE_INVENTORY_LARGE, Boolean.valueOf(this.moduleInventoryLarge));
        this.dataManager.register(MODULE_FUEL_INFINITE, Boolean.valueOf(this.moduleFuelInfinite));
        this.dataManager.register(MODULE_SPEED_MINOR, Boolean.valueOf(this.moduleSpeedMinor));
        this.dataManager.register(MODULE_SPEED_MAJOR, Boolean.valueOf(this.moduleSpeedMajor));
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
    	
        return compound;
    }
    
    @Override
    public void readFromNBT(NBTTagCompound compound)
    {
    	super.readFromNBT(compound);
    	
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
    }
    
    
    
	//==================================//
    // TODO        Item/Name            //
	//==================================//
    
    @Override
	public ItemStack getItemBoat()
    {
    	ItemStack stack = new ItemStack(InitItemsVC.item_airship_v1, 1, this.metaFrameCore);
    	stack.setTagCompound(new NBTTagCompound());
    	
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
		return this.hasCustomName() ? this.customName : 
			ColorHelperVC.getColorNameFromRgb(this.metaColorRed, this.metaColorGreen, this.metaColorBlue)		
			+ " " 
			+ FrameCore.byId(this.metaFrameCore).getName() 
			+ " " 
			+ ViesCraftConfig.v1AirshipName;
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
        
        this.waterDamage();
        this.updateAirshipMeta();
        
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        super.onUpdate();
        this.tickLerp();
        
        this.fuelFlight();
        this.getTotalFuelSlotBurnTime();
        
        this.currentModule();
        
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
            if (this.status == EntityAirshipBaseVC.Status.IN_WATER)
            {
            	this.momentum = 0.45F;
            }
            else if (this.status == EntityAirshipBaseVC.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipBaseVC.Status.UNDER_WATER)
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
            	if(this.isCollidedVertically)
                {
                	this.motionY = 0;
                }
            	else
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
            }
            else if(isClientAirshipBurning())
        	{
            	this.motionY *= (double)this.momentum;
        	}
            else if(this.isCollidedVertically)
            {
            	this.motionY = 0;
            }
            else
            {
            	this.motionY += d5;
            }
        }
    }
    
    @Override
    public void controlAirship()
    {
    	float finalAirshipSpeedTurn = AirshipSpeedTurn + (FrameCore.byId(this.metaFrameCore).getSpeed() * 4);
        float finalAirshipSpeedForward = AirshipSpeedForward + FrameCore.byId(this.metaFrameCore).getSpeed();
        float finalAirshipSpeedUp = AirshipSpeedUp + (FrameCore.byId(this.metaFrameCore).getSpeed() / 4);
        float finalAirshipSpeedDown = AirshipSpeedDown + (FrameCore.byId(this.metaFrameCore).getSpeed() / 4);
        
        if (this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            //Turning Left
            if (this.leftInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation -= finalAirshipSpeedTurn;
            	}
            	else
            	{
            		this.deltaRotation -= finalAirshipSpeedTurn * 0.5F;
            	}
            }
            
            //Turning Right
            if (this.rightInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation += finalAirshipSpeedTurn;
            	}
            	else
            	{
            		this.deltaRotation += finalAirshipSpeedTurn * 0.5F;
            	}
            }
            
            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }
            
            this.rotationYaw += this.deltaRotation;
            
            //Move Forward
            if (this.forwardInputDown)
            {
            	if(isClientAirshipBurning())
        		{
        			//Small inv module installed
                	if(this.getModuleInventorySmall())
                    {
                		f += finalAirshipSpeedForward - (finalAirshipSpeedForward * 0.2F);
                    }
                	//Large inv module installed
                	else if(this.getModuleInventoryLarge())
                	{
                		f += finalAirshipSpeedForward - (finalAirshipSpeedForward * 0.3F);
                	}
                	//Infinite fuel module installed
                	else if(this.getModuleFuelInfinite())
                	{
                		f += finalAirshipSpeedForward - (finalAirshipSpeedForward * 0.4F);
                	}
                	//Minor speed module installed
                	else if(this.getModuleSpeedMinor())
                	{
                		f += finalAirshipSpeedForward + 0.008F;
                	}
                	//Major speed module installed
                	else if(this.getModuleSpeedMajor())
                	{
                		f += finalAirshipSpeedForward + 0.016F;
                	}
                	else
                	{
                		f += finalAirshipSpeedForward;
                	}
        		}
            	//If airship is off
            	else
            	{
            		f += 0.0030F;
            	}
            }
            
            //Moving Backwards
            if (this.backInputDown)
            {
            	//Check airship is burning fuel
        		if(isClientAirshipBurning())
        		{
        			//Small inv module installed
                	if(this.getModuleInventorySmall())
                	{
                		f -= (finalAirshipSpeedForward * 0.5) - ((finalAirshipSpeedForward * 0.5)* 0.2);
                	} 
                	//Large inv module installed
                	else if(this.getModuleInventoryLarge())
                	{
                		f -= (finalAirshipSpeedForward * 0.5) - ((finalAirshipSpeedForward * 0.5)* 0.3);
                	}
                	//Infinite fuel module installed
                	else if(this.getModuleFuelInfinite())
                	{
                		f -= (finalAirshipSpeedForward * 0.5) - ((finalAirshipSpeedForward * 0.4)* 0.5);
                	}
                	//Minor speed module installed
                	else if(this.getModuleSpeedMinor())
                	{
                		f -= (finalAirshipSpeedForward * 0.5) + 0.004F;
                	}
                	//Major speed module installed
                	else if(this.getModuleSpeedMajor())
                	{
                		f -= (finalAirshipSpeedForward * 0.5) + 0.008F;
                	}
                	else
                	{
                		f -= finalAirshipSpeedForward * 0.5;
                	}
        		}
            	//If airship is off
            	else
            	{
            		f -= 0.0030F * 0.5;
            	}
            }
            
            //Moving Up
            if (this.upInputDown)
            {
            	//Check airship max height
            	if(!this.airshipHeightLimit())
    			{
            		//Check airship is burning fuel
            		if(isClientAirshipBurning())
            		{
            			//Small inv module installed
                    	if(this.getModuleInventorySmall())
                    	{
                    		f1 += finalAirshipSpeedUp - (finalAirshipSpeedUp * 0.2);
                    	}
                    	//Large inv module installed
                    	else if(this.getModuleInventoryLarge())
                    	{
                    		f1 += finalAirshipSpeedUp - (finalAirshipSpeedUp * 0.3);
                    	}
                    	//Infinite fuel module installed
                    	else if(this.getModuleFuelInfinite())
                    	{
                    		f1 += finalAirshipSpeedUp - (finalAirshipSpeedUp * 0.4);
                    	}
                    	else
                    	{
                    		f1 += finalAirshipSpeedUp;
                    	}
            		}
    			}
            }
            
            //Moving down
            if (this.downInputDown)
            {
                f1 -= finalAirshipSpeedDown;
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
        		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventorySmall());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//If airship has large inv module installed
        	else if(this.getModuleInventoryLarge())
        	{
        		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventoryLarge());
            	Minecraft.getMinecraft().setIngameFocus();
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiV1Default());
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
        if(this.world.isRemote)
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
        	//The player in the airship is in Creative Mode
        	else if(EventHandlerAirship.creativeBurn)
        	{
        		if(this.getEntityId() == EventHandlerAirship.playerRidingEntity)
        		{
        			
        		}
        		else
        		{
        			--this.airshipBurnTime;
        		}
        	}
        	//Airship has either Large Inventory or Minor Speed Module installed
        	else if(this.getModuleInventoryLarge()
        	|| this.getModuleSpeedMajor())
        	{
        		--this.airshipBurnTime;
        		--this.airshipBurnTime;
        	}
        	//Airship has no controlling passenger
        	else if(this.getControllingPassenger() == null)
        	{
        		--this.airshipBurnTime;
        	}
        	//Anything else
        	else
        	{
        		--this.airshipBurnTime;
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
        	//The player in the airship is in Creative Mode
        	else if(EventHandlerAirship.creativeBurn)
        	{
        		if (this.getEntityId() == EventHandlerAirship.playerRidingEntity
        		&& this.getControllingPassenger() instanceof EntityPlayer)
            	{
            		this.airshipBurnTime = 1;
            	}
        		else
        		{
        			this.airshipBurnTime = 0;
        		}
        		
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
        
        //Saves the fuel burntime server side
        if(!this.world.isRemote)
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
    	return this.airshipBurnTime > 0;
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
            DualEnergyStorageVC cap = (DualEnergyStorageVC) stack.getCapability(DualEnergyStorageVC.CAPABILITY_HOLDER , null);
            if(ViesCraftConfig.vanillaFuel)
    		{
	            if (item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.AIR)
	            {
	                Block block = Block.getBlockFromItem(item);
	                
	                if (block == Blocks.WOODEN_SLAB)
	                {
	                    return FuelVC.wooden_slab;
	                }
	                
	                if (block.getDefaultState().getMaterial() == Material.WOOD)
	                {
	                    return FuelVC.wood_block_material;
	                }
	                
	                if (block == Blocks.COAL_BLOCK)
	                {
	                    return FuelVC.coal_block;
	                }
	            }
	            
	            if (item == Items.STICK) return FuelVC.stick;
	            if (item == Item.getItemFromBlock(Blocks.SAPLING)) return FuelVC.sapling;
	            if (item == Items.COAL) return FuelVC.coal;
	            if (item == Items.BLAZE_ROD) return FuelVC.blaze_rod;
	            
	            if (item == Items.LAVA_BUCKET) return 20000;
    		}
            
            if (item == InitItemsVC.viesoline_pellets) return (ViesCraftConfig.viesolineBurnTime * 20);
            //if (item == InitItemsVC.airship_battery) return cap.getEnergyStored();
            
            return net.minecraftforge.fml.common.registry.GameRegistry.getFuelValue(stack);
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
    //TODO
    public void getTotalFuelSlotBurnTime()
    {
    	//Passes itemFuelStack to client for gui
    	if(this.world.isRemote)
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
    				this.itemFuelStackSize = this.inventory.getStackInSlot(0).getCount();
    					
    				this.itemFuelStack = this.itemFuelStackSize 
    						* this.getItemBurnTime(this.inventory.getStackInSlot(0));
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
    	
    	if(!this.world.isRemote)
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
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
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
	
    /**
     * Gets the airshipTotalBurnTime to pass from server to client.
     */
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
	
    /**
     * Gets the itemFuelStack to pass from server to client.
     */
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
	
    /**
     * Gets the itemFuelStackSize to pass from server to client.
     */
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
			if(this.getModuleInventorySmall())
				LogHelper.info("1");
			if(this.getModuleInventoryLarge())
				LogHelper.info("2");
			if(this.getModuleSpeedMinor())
				LogHelper.info("3");
			if(this.getModuleFuelInfinite())
				LogHelper.info("4");
			if(this.getModuleStealth())
				LogHelper.info("5");
			if(this.getModuleDash())
				LogHelper.info("6");
		}
		*/
		
		//Syncs the module boolean client side
		if(this.world.isRemote)
		{
    		this.moduleInventorySmall = this.getModuleInventorySmall();
    		this.moduleInventoryLarge = this.getModuleInventoryLarge();
    		this.moduleSpeedMinor = this.getModuleSpeedMinor();
    		this.moduleSpeedMajor = this.getModuleSpeedMajor();
    		this.moduleFuelInfinite = this.getModuleFuelInfinite();
		}
		
		if(moduleNumber == 1)
		{
			this.moduleInventorySmall = true;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
		}
		else if(moduleNumber == 2)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = true;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
		}
		else if(moduleNumber == 3)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = true;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
		}
		else if(moduleNumber == 4)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = true;
			this.moduleFuelInfinite = false;
		}
		else if(moduleNumber == 5)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = true;
		}
		else// if(moduleNumber == 0)
		{
			this.moduleInventorySmall = false;
			this.moduleInventoryLarge = false;
			this.moduleSpeedMinor = false;
			this.moduleSpeedMajor = false;
			this.moduleFuelInfinite = false;
		}
		
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
			if(this.inventory.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_small
			&& dropNumber == 0)
			{
				dropNumber = 1;
			}
			
			//If the module in the slot is large inv mod
			else if(this.inventory.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_large
			&& dropNumber == 0)
			{
				dropNumber = 2;
			}
			
			//If the module in the slot is not small inv mod but had it in previously
			else if(this.inventory.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_small
					&& dropNumber == 1)
			{
				dropNumber = 0;
				this.dropInv();
			}
			
			//If the module in the slot is not large inv mod but had it in previously
			else if(this.inventory.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_large
					&& dropNumber == 2)
			{
				dropNumber = 0;
				this.dropInv();
			}
		}
		
		//Saves the module boolean to server side
    	if(!this.world.isRemote)
		{
			this.setModuleInventorySmall(this.moduleInventorySmall);
    		this.setModuleInventoryLarge(this.moduleInventoryLarge);
    		this.setModuleSpeedMinor(this.moduleSpeedMinor);
    		this.setModuleSpeedMajor(this.moduleSpeedMajor);
    		this.setModuleFuelInfinite(this.moduleFuelInfinite);
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
            
            //Passive
            if (item == InitItemsVC.module_inventory_small) return true;
            if (item == InitItemsVC.module_inventory_large) return true;
            if (item == InitItemsVC.module_speed_increase_minor) return true;
            if (item == InitItemsVC.module_speed_increase_major) return true;
            if (item == InitItemsVC.module_fuel_infinite) return true;
            
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
            
            if (item == InitItemsVC.module_inventory_small)
            {
            	return 1;
            }
            else if (item == InitItemsVC.module_inventory_large)
            {
            	return 2;
            }
            else if (item == InitItemsVC.module_speed_increase_minor)
            {
            	return 3;
            }
            else if (item == InitItemsVC.module_speed_increase_major)
            {
            	return 4;
            }
            else if (item == InitItemsVC.module_fuel_infinite)
            {
            	return 5;
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
     * Sets the Small Inventory boolean to pass from server to client.
     */
    public void setModuleInventorySmall(boolean moduleInvSmall1)
    {
        this.dataManager.set(MODULE_INVENTORY_SMALL, Boolean.valueOf(moduleInvSmall1));
    }
	
    /**
     * Gets the Small Inventory boolean to pass from server to client.
     */
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
	
    /**
     * Gets the Large Inventory boolean to pass from server to client.
     */
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
	
    /**
     * Gets the Infinite Fuel boolean to pass from server to client.
     */
    public boolean getModuleFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_FUEL_INFINITE)).booleanValue();
    }
    
    /**
     * Sets if Minor Speed Increase mod is installed to pass from server to client.
     */
    public void setModuleSpeedMinor(boolean moduleSpeed1)
    {
        this.dataManager.set(MODULE_SPEED_MINOR, Boolean.valueOf(moduleSpeed1));
    }
    
    /**
     * Gets the Minor Speed boolean to pass from server to client.
     */
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
    
    /**
     * Gets the Major Speed boolean to pass from server to client.
     */
    public boolean getModuleSpeedMajor()
    {
        return ((Boolean)this.dataManager.get(MODULE_SPEED_MAJOR)).booleanValue();
    }
    
    
    
    //==================================//
  	// TODO          Misc               //
  	//==================================//
    
    /**
     * Drops inventory contents only from airship (not fuel/module).
     */
    public void dropInv()
    {
    	if(this.world.isRemote)
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
					InventoryHelper.spawnItemStack(this.world, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
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
    	if(this.world.isRemote)
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
					InventoryHelper.spawnItemStack(this.world, this.posX, this.posY, this.posZ, this.inventory.getStackInSlot(x));
					test = null;
				}
			}
		}
    }
}

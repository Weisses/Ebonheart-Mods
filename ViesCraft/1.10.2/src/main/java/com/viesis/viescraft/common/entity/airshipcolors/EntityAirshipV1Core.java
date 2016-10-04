package com.viesis.viescraft.common.entity.airshipcolors;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.block.BlockLiquid;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityTracker;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EntitySelectors;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.ItemStackHandler;

import com.google.common.collect.Lists;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.slots.FuelSlotVC;
import com.viesis.viescraft.common.utils.events.EventHandlerCreativeNoFuel;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiV1Default;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventoryLarge;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventorySmall;

public class EntityAirshipV1Core extends EntityVC implements IInventory//, ITickable 
{
	private static final DataParameter<Integer> TIME_SINCE_HIT = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> FORWARD_DIRECTION = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	private static final DataParameter<Float> DAMAGE_TAKEN = EntityDataManager.<Float>createKey(EntityAirshipV1Core.class, DataSerializers.FLOAT);
	private static final DataParameter<Integer> BOAT_TYPE = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
    
	private static final DataParameter<Integer> POWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> ITEMFUELSTACKPOWERED = EntityDataManager.<Integer>createKey(EntityAirshipV1Core.class, DataSerializers.VARINT);
    
	private static final DataParameter<Boolean> MODULE_INVENTORY_SMALL = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MODULE_INVENTORY_LARGE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MODULE_FUEL_EFFICIENCY = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
	private static final DataParameter<Boolean> MODULE_FUEL_INFINITE = EntityDataManager.<Boolean>createKey(EntityAirshipV1Core.class, DataSerializers.BOOLEAN);
    
	
	//0 is fuel slot, 1 is expansion slot 2-20(9x2 slots) is inventory.
	private ItemStack[] inventory = new ItemStack[20];
	public String customName;
	
	public int airshipBurnTime;
    //private int currentItemBurnTime;
    //private int fuelTime;
    //private int totalFuelTime;
    
    //public boolean testIsOn;
    public static boolean moduleInventorySmall;
    public static boolean moduleInventoryLarge;
    public static boolean moduleFuelEfficiency;
    public static boolean moduleFuelInfinite;
    
	public EntityAirshipV1Core.Status status;
    public EntityAirshipV1Core.Status previousStatus;
    
    public float AirshipSpeedTurn = 0.18F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedForward = 0.0125F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedUp = 0.0035F * (ViesCraftConfig.v1AirshipSpeed / 100);
    public float AirshipSpeedDown = 0.0035F * (ViesCraftConfig.v1AirshipSpeed / 100);
	
    public int itemFuelStack;
    //public int itemFuel;
    //public int test;
    
    private int dropNumber;
    
	public EntityAirshipV1Core(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
        this.inventory = new ItemStack[this.getSizeInventory()];
    }
	
    public EntityAirshipV1Core(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.inventory = new ItemStack[this.getSizeInventory()];
    }
    
	@Override
	protected void entityInit() 
	{
		this.dataManager.register(TIME_SINCE_HIT, Integer.valueOf(0));
        this.dataManager.register(FORWARD_DIRECTION, Integer.valueOf(1));
        this.dataManager.register(DAMAGE_TAKEN, Float.valueOf(0.0F));
        
        this.dataManager.register(POWERED, Integer.valueOf(this.airshipBurnTime));
        this.dataManager.register(ITEMFUELSTACKPOWERED, Integer.valueOf(this.itemFuelStack));
        
        this.dataManager.register(MODULE_INVENTORY_SMALL, Boolean.valueOf(this.moduleInventorySmall));
        this.dataManager.register(MODULE_INVENTORY_LARGE, Boolean.valueOf(this.moduleInventoryLarge));
        this.dataManager.register(MODULE_FUEL_EFFICIENCY, Boolean.valueOf(this.moduleFuelEfficiency));
        this.dataManager.register(MODULE_FUEL_INFINITE, Boolean.valueOf(this.moduleFuelInfinite));
        
        this.dataManager.register(BOAT_TYPE, Integer.valueOf(EntityAirshipV1Core.Type.NORMAL.ordinal()));
	}
	
	
    
    //================================================================================
    
	
    
	/**
     * Main entity item drop.
     */
	public Item getItemBoat()
    {
		return null;
    }
	
    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if (this.isEntityInvulnerable(source))
        {
            return false;
        }
        else if (!this.isDead)
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
                    if (!this.worldObj.isRemote && !flag && this.worldObj.getGameRules().getBoolean("doEntityDrops"))
                    {
                        this.dropItemWithOffset(this.getItemBoat(), 1, 0.0F);
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
     * Setups the entity to do the hurt animation. Only used by packets in multiplayer.
     */
    @SideOnly(Side.CLIENT)
    public void performHurtAnimation()
    {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }
    
    /**
     * Set the position and rotation values directly without any clamping.
     */
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
        this.boatPitch = x;
        this.lerpY = y;
        this.lerpZ = z;
        this.boatYaw = (double)yaw;
        this.lerpXRot = (double)pitch;
        this.lerpSteps = 10;
    }
    
    
    
    //==================================//
    // TODO       On Update             //
	//==================================//
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        this.previousStatus = this.status;
        this.status = this.getAirshipStatus();
        
        if (this.status != EntityAirshipV1Core.Status.UNDER_WATER && this.status != EntityAirshipV1Core.Status.UNDER_FLOWING_WATER)
        {
            this.outOfControlTicks = 0.0F;
        }
        else
        {
            ++this.outOfControlTicks;
        }
        
        if (!this.worldObj.isRemote && this.outOfControlTicks >= 60.0F)
        {
            this.removePassengers();
        }
        
        if (this.getTimeSinceHit() > 0)
        {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }
        
        if (this.getDamageTaken() > 0.0F)
        {
            this.setDamageTaken(this.getDamageTaken() - 1.0F);
        }
        
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        super.onUpdate();
        this.tickFall();
        
        this.fuelFlight();
        this.getTotalFuelSlotBurnTime();
        
        this.currentModule();
        
        
        
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
     * How players interact with the Airship
     */
    public boolean processInitialInteract(EntityPlayer player, @Nullable ItemStack stack, EnumHand hand)
    {
        if (!this.worldObj.isRemote && !player.isSneaking() && this.outOfControlTicks < 60.0F)
        {
            player.startRiding(this);
        }
        
        //if(!this.worldObj.isRemote && player.isSneaking())
        //{
        //	NetworkHandler.sendToServer(new MessageGuiOpen());
        //	Minecraft.getMinecraft().setIngameFocus();	
        //}
        
        return true;
    }
    
    
    
    //==================================//
    // TODO    Speed and Motion         //
	//==================================//
    
    /**
     * Update the boat's speed, based on momentum.
     */
    public void updateMotion()
    {
        double d0 = 0.0D;
        double d5 = -0.001D;
        this.momentum = 0.05F;
        
        if (this.previousStatus == EntityAirshipV1Core.Status.IN_AIR && this.status != EntityAirshipV1Core.Status.IN_AIR && this.status != EntityAirshipV1Core.Status.ON_LAND)
        {
            this.waterLevel = this.getEntityBoundingBox().minY + (double)this.height;
            this.setPosition(this.posX, (double)(this.getWaterLevelAbove() - this.height) + 0.101D, this.posZ);
            this.motionY = 0.0D;
            this.lastYd = 0.0D;
            this.status = EntityAirshipV1Core.Status.IN_WATER;
        }
        else
        {
            if (this.status == EntityAirshipV1Core.Status.IN_WATER)
            {
            	this.momentum = 0.45F;
            }
            else if (this.status == EntityAirshipV1Core.Status.UNDER_FLOWING_WATER 
        	  || this.status == EntityAirshipV1Core.Status.UNDER_WATER)
            {
            	if (!this.worldObj.isRemote)
            	{
            		this.worldObj.createExplosion(this, this.posX, this.posY + (double)(this.height / 16.0F), this.posZ, 2.0F, true);
            		
            		int drop1 = random.nextInt(100) + 1;
            		int drop2 = random.nextInt(100) + 1;
            		int drop3 = random.nextInt(100) + 1;
            		int drop4 = random.nextInt(100) + 1;
            		int drop5 = random.nextInt(100) + 1;
            		
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
            	    
            	    if (drop4 < 35)
                	{
            	    	this.dropItemWithOffset(Items.MINECART, 1, 0.0F);
                	}
            	    
            	    if (drop5 < 15)
                	{
            	    	this.dropItemWithOffset(InitItemsVC.airship_ignition, 1, 0.0F);
                	}
            	}
            	this.setDeadVC();
            }
            else if (this.status == EntityAirshipV1Core.Status.IN_AIR
            	  || this.status == EntityAirshipV1Core.Status.ON_LAND)
            {
            	this.momentum = 0.9F;
            }
            
            	
            this.motionX *= (double)this.momentum;
            this.motionZ *= (double)this.momentum;
            this.deltaRotation *= this.momentum;
            
            
            if(this.getControllingPassenger() == null)
            {
            	this.motionY += d5;
            }
            else if(isClientAirshipBurning())
        	{
            	this.motionY *= (double)this.momentum;
        	}
            else
            {
            	this.motionY += d5;
            }
        }
    }
    
    public void controlAirship()
    {
        if (this.isBeingRidden())
        {
            float f = 0.0F;
            float f1 = 0.0F;
            
            if (this.leftInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation -= AirshipSpeedTurn;
                    this.alphaRotation -= AirshipSpeedTurn;
            	}
            	else
            	{
            		this.deltaRotation -= AirshipSpeedTurn * 0.5F;
                    this.alphaRotation -= AirshipSpeedTurn * 0.5F;
            	}
            }

            if (this.rightInputDown)
            {
            	if(isClientAirshipBurning())
            	{
            		this.deltaRotation += AirshipSpeedTurn;
            	}
            	else
            	{
            		this.deltaRotation += AirshipSpeedTurn * 0.5F;
            	}
            }

            if (this.rightInputDown != this.leftInputDown && !this.forwardInputDown && !this.backInputDown)
            {
                f += 0.005F;
            }

            this.rotationYaw += this.deltaRotation;

            if (this.forwardInputDown)
            {
            	if(isClientAirshipBurning()
                && this.getModuleInventorySmall())
                {
            		f += AirshipSpeedForward - (AirshipSpeedForward * 0.2F);
                }
            	else if(isClientAirshipBurning()
            	&& this.getModuleInventoryLarge())
            	{
            		f += AirshipSpeedForward - (AirshipSpeedForward * 0.3F);
            	}
            	else if(isClientAirshipBurning()
            	&& this.getModuleFuelInfinite())
            	{
            		f += AirshipSpeedForward - (AirshipSpeedForward * 0.5F);
            	}
            	else if(isClientAirshipBurning())
            	{
            		f += AirshipSpeedForward;
            	}
            	else
            	{
            		f += 0.0030F;
            	}
            }

            if (this.backInputDown)
            {
            	if(isClientAirshipBurning()
            	&& this.getModuleInventorySmall())
            	{
            		f -= (AirshipSpeedForward * 0.5) - ((AirshipSpeedForward * 0.5)* 0.2);
            	} 
            	else if(isClientAirshipBurning()
            	&& this.getModuleInventoryLarge())
            	{
            		f -= (AirshipSpeedForward * 0.5) - ((AirshipSpeedForward * 0.5)* 0.3);
            	}
            	else if(isClientAirshipBurning()
            	&& this.getModuleFuelInfinite())
            	{
            		f -= (AirshipSpeedForward * 0.5) - ((AirshipSpeedForward * 0.5)* 0.5);
            	}
            	else if(isClientAirshipBurning())
            	{
            		f -= AirshipSpeedForward * 0.5;
            	}
            	else
            	{
            		f -= 0.0030F * 0.5;
            	}
            }
            
            if (this.upInputDown)
            {
            	if(isClientAirshipBurning()
            	&& this.getModuleInventorySmall())
            	{
            		f1 += AirshipSpeedUp - (AirshipSpeedUp * 0.2);
            	}
            	else if(isClientAirshipBurning()
            	&& this.getModuleInventoryLarge())
            	{
            		f1 += AirshipSpeedUp - (AirshipSpeedUp * 0.3);
            	}
            	else if(isClientAirshipBurning()
            	&& this.getModuleFuelInfinite())
            	{
            		f1 += AirshipSpeedUp - (AirshipSpeedUp * 0.5);
            	}
            	else if(isClientAirshipBurning())
            	{
            		f1 += AirshipSpeedUp;
            	}
            }
            
            if (this.downInputDown)
            {
                f1 -= AirshipSpeedDown;
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
	
    protected void controlAirshipGui()
    {
    	if (this.isBeingRidden())
        {
    		if (this.openInputDown)	
            {
            	if(this.getModuleInventorySmall())
            	{
            		//LogHelper.info("1");
            		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventorySmall());
                	Minecraft.getMinecraft().setIngameFocus();
            	}
            	else if(this.getModuleInventoryLarge())
            	{
            		//LogHelper.info("2");
            		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventoryLarge());
                	Minecraft.getMinecraft().setIngameFocus();
            	}
            	else if(this.getModuleFuelEfficiency())
            	{
            		//LogHelper.info("3");
            		NetworkHandler.sendToServer(new MessageGuiV1Default());
                	Minecraft.getMinecraft().setIngameFocus();
            	}
            	else if(this.getModuleFuelInfinite())
            	{
            		//LogHelper.info("4");
            		NetworkHandler.sendToServer(new MessageGuiV1Default());
                	Minecraft.getMinecraft().setIngameFocus();
            	}
            	else
            	{
            		//LogHelper.info("5");
            		NetworkHandler.sendToServer(new MessageGuiV1Default());
                	Minecraft.getMinecraft().setIngameFocus();
            	}
    			//if(this.moduleInventorySmall == 1)
            	//{
            //		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventorySmall());
            	///	Minecraft.getMinecraft().setIngameFocus();
            	//}
            	//else if(this.moduleInventoryLarge == 1)
            	//{
            	//	NetworkHandler.sendToServer(new MessageGuiV1ModuleInventoryLarge());
            	//	Minecraft.getMinecraft().setIngameFocus();
            	//}
            	//else
            	//{
            		//NetworkHandler.sendToServer(new MessageGuiV1Default());
                	//Minecraft.getMinecraft().setIngameFocus();
            	//}
    			
            }
        }
    }
    
    
    
    //==================================//
    // TODO          Misc               //
	//==================================//
    
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
    
    /**
     * Applies this entity's orientation (pitch/yaw) to another entity. Used to update passenger orientation.
     */
    @SideOnly(Side.CLIENT)
    public void applyOrientationToEntity(Entity entityToUpdate)
    {
        this.applyYawToEntity(entityToUpdate);
    }
    
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        
    }
    
    /**
     * Sets the damage taken from the last hit.
     */
    public void setDamageTaken(float damageTaken)
    {
        this.dataManager.set(DAMAGE_TAKEN, Float.valueOf(damageTaken));
    }
    
    /**
     * Gets the damage taken from the last hit.
     */
    public float getDamageTaken()
    {
        return ((Float)this.dataManager.get(DAMAGE_TAKEN)).floatValue();
    }
    
    /**
     * Sets the time to count down from since the last time entity was hit.
     */
    public void setTimeSinceHit(int timeSinceHit)
    {
        this.dataManager.set(TIME_SINCE_HIT, Integer.valueOf(timeSinceHit));
    }
    
    /**
     * Gets the time since the last hit.
     */
    public int getTimeSinceHit()
    {
        return ((Integer)this.dataManager.get(TIME_SINCE_HIT)).intValue();
    }
    
    /**
     * Sets the forward direction of the entity.
     */
    public void setForwardDirection(int forwardDirection)
    {
        this.dataManager.set(FORWARD_DIRECTION, Integer.valueOf(forwardDirection));
    }
    
    /**
     * Gets the forward direction of the entity.
     */
    public int getForwardDirection()
    {
        return ((Integer)this.dataManager.get(FORWARD_DIRECTION)).intValue();
    }
    
    public void setBoatType(EntityAirshipV1Core.Type boatType)
    {
        this.dataManager.set(BOAT_TYPE, Integer.valueOf(boatType.ordinal()));
    }
    
    public EntityAirshipV1Core.Type getBoatType()
    {
        return EntityAirshipV1Core.Type.byId(((Integer)this.dataManager.get(BOAT_TYPE)).intValue());
    }
    
    /**
     * For vehicles, the first passenger is generally considered the controller and "drives" the vehicle. For example,
     * Pigs, Horses, and Boats are generally "steered" by the controlling passenger.
     */
    @SideOnly(Side.CLIENT)
    public void updateInputs()
    {
    	this.leftInputDown = Keybinds.vcLeft.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindLeft.isKeyDown();//.isPressed();
        this.rightInputDown = Keybinds.vcRight.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindRight.isKeyDown();
        this.forwardInputDown = Keybinds.vcForward.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindForward.isKeyDown();//.isPressed();
        this.backInputDown = Keybinds.vcBack.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindBack.isKeyDown();
        this.upInputDown = Keybinds.vcUp.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown();
        this.downInputDown = Keybinds.vcDown.isKeyDown();//Minecraft.getMinecraft().gameSettings.keyBindPlayerList.isKeyDown();
        this.openInputDown = Keybinds.vcInventory.isPressed();
    }
    
    /**
     * Emun Status
     */
    public static enum Status
    {
        IN_WATER,
        UNDER_WATER,
        UNDER_FLOWING_WATER,
        ON_LAND,
        IN_AIR;
    }
    
    /**
     * Types - Unused ATM
     */
    public static enum Type
    {
    	NORMAL(16, "normal"),
        BLACK(0, "black"),
        RED(1, "red"),
        GREEN(2, "green"),
        BROWN(3, "brown"),
        BLUE(4, "blue"),
        PURPLE(5, "purple"),
        CYAN(6, "cyan"),
        LIGHTGRAY(7, "lightgray"),
        GRAY(8, "gray"),
        PINK(9, "pink"),
        LIME(10, "lime"),
        YELLOW(11, "yellow"),
        LIGHTBLUE(12, "lightblue"),
        MAGENTA(13, "magenta"),
        ORANGE(14, "orange"),
        WHITE(15, "white");
        
        
        //DARK_OAK(BlockPlanks.EnumType.DARK_OAK.getMetadata(), "dark_oak");
    	
        
        private final String name;
        private final int metadata;
        
        private Type(int metadataIn, String nameIn)
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
        public static EntityAirshipV1Core.Type byId(int id)
        {
            if (id < 0 || id >= values().length)
            {
                id = 0;
            }
            
            return values()[id];
        }
        
        public static EntityAirshipV1Core.Type getTypeFromString(String nameIn)
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
     * Airship logic on death.
     */
    @Override
    public void setDeadVC()
    {
    	if (!this.worldObj.isRemote)
    	{
    		this.setAirshipDead();
    		this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
    		
    		this.isDead = true;
        
    	}
    	else
    	{
        	this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
					this.posY + 0.5D,
					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
					0.0D, 0.0D, 0.0D, new int[0]);
        	
        	for (int ii = 0; ii < 10; ++ii)
        	{
        		int d = random.nextInt(100) + 1;
        		
        		if (d <= 2)
        		{
        			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, 
        					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					this.posY + 0.5D,
        					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					0.0D, 0.0D, 0.0D, new int[0]);
        		}
        		if (d <= 15)
        		{
        			this.worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, 
        					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					this.posY + 0.5D,
        					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					0.0D, 0.25D, 0.0D, new int[0]);
        		}
        		if (d <= 25)
        		{
        			this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, 
        					this.posX + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					this.posY + 0.5D,
        					this.posZ + this.worldObj.rand.nextFloat() * this.width * 2.0F - this.width,
        					0.0D, 0.0D, 0.0D, new int[0]);
        		}
        	}
    	}
    }
    
    public void setAirshipDead()
    {
		InventoryHelper.dropInventoryItems(this.worldObj, this.getPosition(), this);
    }
    
    
    
    //==================================//
    // TODO       Inventory             //
	//==================================//
    
    public String getCustomName() {
		return this.customName;
	}
	
	public void setCustomName(String customName) {
		this.customName = customName;
	}
	
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : ViesCraftConfig.v1AirshipName;
	}

	@Override
	public boolean hasCustomName() {
		return this.customName != null && !this.customName.equals("");
	}

	@Override
	public ITextComponent getDisplayName() {
		return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
	}
	
	@Override
	public int getSizeInventory() 
	{
		return inventory.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int index) 
	{
		if(index <0 || index >= this.getSizeInventory())
		{
			return null;
		}
		
		return this.inventory[index];
	}
	
	@Override
	public ItemStack decrStackSize(int index, int count) 
	{
		return ItemStackHelper.getAndSplit(this.inventory, index, count);
	}
	
	@Override
	public ItemStack removeStackFromSlot(int index) 
	{
		return ItemStackHelper.getAndRemove(this.inventory, index);
	}
	
	@Override
	public void setInventorySlotContents(int index, ItemStack stack) 
	{
		boolean flag = stack != null && stack.isItemEqual(this.inventory[index]) && ItemStack.areItemStackTagsEqual(stack, this.inventory[index]);
        this.inventory[index] = stack;
        
        if (stack != null && stack.stackSize > this.getInventoryStackLimit())
        {
            stack.stackSize = this.getInventoryStackLimit();
        }
        
        if (index == 0 && !flag)
        {
            this.markDirty();
        }
	}
	
	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}
	
	@Override
	public void markDirty() 
	{
		
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return true;
	}
	
	@Override
	public void openInventory(EntityPlayer player) 
	{
		//player.addStat( -=Achievement=-);
	}
	
	@Override
	public void closeInventory(EntityPlayer player) 
	{
		
	}
	
	/**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot.
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 0)
        {
        	ItemStack itemstack = this.inventory[0];
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        }
        else if(index == 1)
        {
            ItemStack itemstack = this.inventory[1];
            return isItemModule(stack);
        }
        //else if(index == 10)
        //{
        //    ItemStack itemstack = this.inventory[10];
        //    return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && (itemstack == null || itemstack.getItem() != Items.BUCKET);
        //}
        else
        {
        	return true;
        }
    }
	
    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.airshipBurnTime;
            case 1:
                return 0;//this.currentItemBurnTime;
            case 2:
                return 0;//this.fuelTime;
            case 3:
                return 0;//this.totalFuelTime;
            case 4:
                return 0;//this.airshipBeingDriven;
                
              //Module Small Inventory
            case 5:
                return 0;//this.moduleInventorySmall;
              //Module Large Inventory
            case 6:
                return 0;//this.moduleInventoryLarge;
            default:
                return 0;
        }
    }
    
    public void setField(int id, int value)
    {
        switch (id)
        {
        	//Current Airship Burn Time
            case 0:
                this.airshipBurnTime = value;
                break;
            //Current int value of fuel items in fuel slot
            case 1:
                //this.currentItemBurnTime = value;
                break;
            case 2:
                //this.fuelTime = value;
                break;
            case 3:
                //this.totalFuelTime = value;
            	break;
            case 4:
                //this.airshipBeingDriven = value;
            	break;
            //Module Small Inventory present
            case 5:
                //this.moduleInventorySmall = value;
                break;
            //Module Large Inventory present
            case 6:
                //this.moduleInventoryLarge = value;
                break;
        }
    }
    
    public int getFieldCount()
    {
        return 6;
    }
    
	@Override
	public void clear() 
	{
		for (int i = 0; i < this.inventory.length; i++)
		{
			this.inventory[i] = null;
		}
	}
	
	
	
    //==================================//
	// TODO     Fuel Consumption        //
	//==================================//
    
	private void fuelFlight()
    {
    	boolean flag = this.isClientAirshipBurning();
        boolean flag1 = false;
        
        //Syncs the server info to the client
        if(this.worldObj.isRemote)
        {
        	this.airshipBurnTime = this.getPowered();
        }
        
        
        
        //Handles how burn time in is handled
        if (this.isClientAirshipBurning())
        {
        	if(this.getModuleFuelInfinite())
        	{
        		
        	}
        	
        	else if(this.getModuleInventoryLarge())
        	{
        		--this.airshipBurnTime;
        		--this.airshipBurnTime;
        	}
        	
        	else if(this.getControllingPassenger() == null)
        	{
        		--this.airshipBurnTime;
        	}
        	
        	
        	
        	else if(EventHandlerCreativeNoFuel.creativeBurn)
        	{
        		
        		if(this.getEntityId() == EventHandlerCreativeNoFuel.test)
        		{
        			
	        		if(this.getControllingPassenger() == null)
	            	{
	            		--this.airshipBurnTime;
	            	}
	        		else
	        		{
	        			
	        		}
        		
        		
        		
        			
        		}
        		else
        		{
        			--this.airshipBurnTime;
        		}
        		
        		
        	}
        	
        	
        	
        	
        	/**
        	else if(EventHandlerCreativeNoFuel.creativeBurn)
        	{
        		
        		
        		if(this.getEntityId() == EventHandlerCreativeNoFuel.test)
        		{
        			
        			if(this.getControllingPassenger() == null)
                	{
        				LogHelper.info("g1");
                		--this.airshipBurnTime;
                	}
            		
        			
        		}
        		else
        		{
        			LogHelper.info("t");
        			--this.airshipBurnTime;
        		}
        		
        		
        	}
        	*/
        	
        	//else if (this.getEntityId() == EventHandlerCreativeNoFuel.test
        	//&& this.getControllingPassenger() != null)
        	//{
        	//	
        	//}
        	
        	//else if(this.getControllingPassenger() == null)
        	//{
        	//	--this.airshipBurnTime;
        	//}
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	else
        	{
        		--this.airshipBurnTime;
        	}
        	
        	
        	
        }
        
        //Handles when a creative player is mounted
        if (!this.isClientAirshipBurning())
        {
        	if(this.getModuleFuelInfinite())
        	{
        		this.airshipBurnTime = 1;
        	}
        	
        	else if(this.getControllingPassenger() == null)
        	{
        		this.airshipBurnTime = 0;
        	}
        	
        	else if(EventHandlerCreativeNoFuel.creativeBurn)
        	{
        		
        		
            	if (this.getEntityId() == EventHandlerCreativeNoFuel.test)
            	{
            		this.airshipBurnTime = 1;
            		
            		//LogHelper.info("Player Creative! = " + this.getUniqueID());
            	}
        		
        	}
        	
        	
        	
        	
        	
        	
        	
        	//if(this.getControllingPassenger() == null)
        	//{
        	//	this.airshipBurnTime = 0;
        	//}
        	//if(this.getModuleFuelInfinite())
        	//{
        	//	this.airshipBurnTime = 1;
        	//}
        	//
        	//else if(EventHandlerCreativeNoFuel.creativeBurn)
        	//{
        	//	this.airshipBurnTime = 1;
        	//}
        	else 
        	{
        		this.airshipBurnTime = 0;
        	}
        	
        }
        
        if (this.isClientAirshipBurning() || this.inventory[0] != null)
        {
            if (!this.isClientAirshipBurning())
            {
                this.airshipBurnTime = getItemBurnTime(this.inventory[0]);
                
                if (this.isClientAirshipBurning())
                {
                    flag1 = true;
                    
                    if (this.inventory[0] != null)
                    {
                        --this.inventory[0].stackSize;
                        
                        if (this.inventory[0].stackSize == 0)
                        {
                            this.inventory[0] = inventory[0].getItem().getContainerItem(inventory[0]);
                        }
                    }
                }
            }
        }
        
        if (flag != this.isClientAirshipBurning())
        {
            flag1 = true;
        }
        
        if (flag1)
        {
            this.markDirty();
        }
        
        if(!this.worldObj.isRemote)
        {
        	this.setPowered(this.airshipBurnTime);
        }
    }
    
    /**
     * Is Airship Engine On
     */
    public boolean isClientAirshipBurning()
    {
    	return this.airshipBurnTime > 0;
    }
    
    @SideOnly(Side.CLIENT)
    public static boolean isAirshipBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }
    
    public int getFuelTime(@Nullable ItemStack stack)
    {
        return (ViesCraftConfig.v1FuelBurnTime * 20);//1200;
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
            
            if (item == Items.COAL) return (ViesCraftConfig.v1FuelBurnTime * 20);//1200;//1600
            
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
    
    public void getTotalFuelSlotBurnTime()
    {
    	//Passes itemFuelStack to client for gui
    	if(this.worldObj.isRemote)
		{
			this.itemFuelStack = this.getItemFuelStackPowered();
		}
    	
    	if(this.getControllingPassenger() != null)
    	{
    		if (this.isClientAirshipBurning())
            {
    			ItemStack itemFuel = this.getStackInSlot(0);
    			
    			if(itemFuel != null)
    			{
    				this.itemFuelStack = this.inventory[0].stackSize * (ViesCraftConfig.v1FuelBurnTime);
    			}
    			else
    			{
    				this.itemFuelStack = 0;
    			}
            }
    		else
    		{
    			this.itemFuelStack = 0;
    		}
    	}
    	
    	if(!this.worldObj.isRemote)
		{
			this.setItemFuelStackPowered(this.itemFuelStack);
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
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setItemFuelStackPowered(int itemFuelStack1)
    {
        this.dataManager.set(ITEMFUELSTACKPOWERED, Integer.valueOf(itemFuelStack1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public int getItemFuelStackPowered()
    {
        return ((Integer)this.dataManager.get(ITEMFUELSTACKPOWERED)).intValue();
    }
    
    
    
    //==================================//
  	// TODO     Airship Modules         //
  	//==================================//
    
    public void currentModule()
    {
    	//if(this.getControllingPassenger() != null)
        //{
    		ItemStack itemModule = this.getStackInSlot(1);
    		int moduleNumber = this.getModuleID(itemModule);
    		
    		
    		/**
    		if(this.worldObj.isRemote)
			{
    			if(this.moduleInventorySmall)
    				LogHelper.info("1");
    			if(this.moduleInventoryLarge)
    				LogHelper.info("2");
    			if(this.moduleFuelEfficiency)
    				LogHelper.info("3");
    			if(this.moduleFuelInfinite)
    			LogHelper.info("4");
			}
    		*/
    		
    		
    		if(this.worldObj.isRemote)
			{
	    		this.moduleInventorySmall = this.getModuleInventorySmall();
	    		this.moduleInventoryLarge = this.getModuleInventoryLarge();
	    		this.moduleFuelEfficiency = this.getModuleFuelEfficiency();
	    		this.moduleFuelInfinite = this.getModuleFuelInfinite();
			}
    		
    		
	    	
    		if(moduleNumber == 1)
			{
				this.moduleInventorySmall = true;
				this.moduleInventoryLarge = false;
				this.moduleFuelEfficiency = false;
				this.moduleFuelInfinite = false;
				
			}
			else if(moduleNumber == 2)
			{
				this.moduleInventorySmall = false;
				this.moduleInventoryLarge = true;
				this.moduleFuelEfficiency = false;
				this.moduleFuelInfinite = false;
				
			}
			else if(moduleNumber == 3)
			{
				this.moduleInventorySmall = false;
				this.moduleInventoryLarge = false;
				this.moduleFuelEfficiency = true;
				this.moduleFuelInfinite = false;
				
			}
			else if(moduleNumber == 4)
			{
				this.moduleInventorySmall = false;
				this.moduleInventoryLarge = false;
				this.moduleFuelEfficiency = false;
				this.moduleFuelInfinite = true;
				
			}
			else if(moduleNumber == 0)
			{
				this.moduleInventorySmall = false;
				this.moduleInventoryLarge = false;
				this.moduleFuelEfficiency = false;
				this.moduleFuelInfinite = false;
				
			}
    		
    		
    		
    		
    		
    		//If there is no module in slot
    		if(this.getStackInSlot(1) == null)
    		{
    			//If small inv mod is removed and slot is empty
    			if(dropNumber == 1)
    			{
    				dropNumber = 0;
    				this.dropLargeModInv();
    				LogHelper.info("Inv dropped");
    				//this.dropSmallModInv();
    			}
    			
    			//If large inv mod is removed and slot is empty
    			if(dropNumber == 2)
    			{
    				dropNumber = 0;
    				this.dropLargeModInv();
    				LogHelper.info("Inv dropped");
    				//this.dropLargeModInv();
    			}
    		}
    		//If a module is still in the slot
    		else
    		{
    			//If the module in the slot is small inv mod
    			if(this.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_small
    			&& dropNumber == 0)
    			{
    				dropNumber = 1;
    				LogHelper.info("Small mod in.");
    			}
    			
    			//If the module in the slot is large inv mod
    			else if(this.getStackInSlot(1).getItem() == InitItemsVC.module_inventory_large
    			&& dropNumber == 0)
    			{
    				dropNumber = 2;
    				LogHelper.info("Large mod in.");
    				//LogHelper.info(" v2 upgraded form small to large");
    			}
    			
    			
    			
    			//If the module in the slot is not small inv mod but had it in previously
    			else if(this.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_small
    					&& dropNumber == 1)
    			{
    				dropNumber = 0;
    				this.dropLargeModInv();
    				LogHelper.info("Inv dropped");
    				//this.dropSmallModInv();
    			}
    			
    			
    			//If the module in the slot is not large inv mod but had it in previously
    			else if(this.getStackInSlot(1).getItem() != InitItemsVC.module_inventory_large
    					&& dropNumber == 2)
    			{
    				dropNumber = 0;
    				this.dropLargeModInv();
    				LogHelper.info("Inv dropped");
    			}
    			
    			
    			
    		}
        //}
    	
    	
    	
    	if(!this.worldObj.isRemote)
		{
			this.setModuleInventorySmall(this.moduleInventorySmall);
    		this.setModuleInventoryLarge(this.moduleInventoryLarge);
    		this.setModuleFuelEfficiency(this.moduleFuelEfficiency);
    		this.setModuleFuelInfinite(this.moduleFuelInfinite);
    	}
    	
    }
    
    /**
     * Checks if a module is in the module slot.
     */
    private static boolean getItemModule(ItemStack stack)
    {
        if (stack == null)
        {
            return false;
        }
        else
        {
            Item item = stack.getItem();
            
            if (item == InitItemsVC.module_inventory_small) return true;
            
            if (item == InitItemsVC.module_inventory_large) return true;
            
            if (item == InitItemsVC.module_fuel_efficiency) return true;
            
            if (item == InitItemsVC.module_fuel_infinite) return true;
            
            return false;
        }
    }
    
    /**
     * Set module ID for module in slot.
     */
    private static int getModuleID(ItemStack stack)
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
            else if (item == InitItemsVC.module_fuel_efficiency)
            {
            	return 3;
            }
            else if (item == InitItemsVC.module_fuel_infinite)
            {
            	return 4;
            }
            else
            {
            	return 0;
            }
        }
    }
    
    private static boolean isItemModule(ItemStack stack)
    {
        /**
         * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
         * fuel
         */
        return getItemModule(stack);
    }
    /**
     * Drops small inventory contents from airship
     */
    private void dropSmallModInv()
    {
    	if(!this.worldObj.isRemote)
		{
			for (int x = 2; x < 11; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					InventoryHelper.spawnItemStack(this.worldObj, this.posX, this.posY, this.posZ, this.getStackInSlot(x));
					this.inventory[x] = null;
				}
			}
		}
		else
		{
			for (int x = 2; x < 11; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					this.inventory[x] = null;
				}
			}
		}
    }
    /**
     * Drops large inventory contents from airship
     */
    private void dropLargeModInv()
    {
    	if(this.worldObj.isRemote)
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					this.inventory[x] = null;
				}
			}
		}
		else
		{
			for (int x = 2; x < 20; ++x) 
			{
				if(this.getStackInSlot(x) != null)
				{
					InventoryHelper.spawnItemStack(this.worldObj, this.posX, this.posY, this.posZ, this.getStackInSlot(x));
					this.inventory[x] = null;
				}
			}
		}
    }
    
    /**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setModuleInventorySmall(boolean moduleInvSmall1)
    {
        this.dataManager.set(MODULE_INVENTORY_SMALL, Boolean.valueOf(moduleInvSmall1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public boolean getModuleInventorySmall()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_SMALL)).booleanValue();
    }
    
    /**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setModuleInventoryLarge(boolean moduleInvLarge1)
    {
        this.dataManager.set(MODULE_INVENTORY_LARGE, Boolean.valueOf(moduleInvLarge1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public boolean getModuleInventoryLarge()
    {
        return ((Boolean)this.dataManager.get(MODULE_INVENTORY_LARGE)).booleanValue();
    }
    
    /**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setModuleFuelEfficiency(boolean moduleFuelEff1)
    {
        this.dataManager.set(MODULE_FUEL_EFFICIENCY, Boolean.valueOf(moduleFuelEff1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public boolean getModuleFuelEfficiency()
    {
        return ((Boolean)this.dataManager.get(MODULE_FUEL_EFFICIENCY)).booleanValue();
    }
    
    /**
     * Sets the airshipBurnTime to pass from server to client.
     */
    public void setModuleFuelInfinite(boolean moduleInvLarge1)
    {
        this.dataManager.set(MODULE_FUEL_INFINITE, Boolean.valueOf(moduleInvLarge1));
    }
	
    /**
     * Gets the airshipBurnTime to pass from server to client.
     */
    public boolean getModuleFuelInfinite()
    {
        return ((Boolean)this.dataManager.get(MODULE_FUEL_INFINITE)).booleanValue();
    }
    
    
    
    //==================================//
	// TODO     Airship Status          //
	//==================================//
    
    /**
     * Downward empty movement.
     */
    public void tickFall()
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
    public EntityAirshipV1Core.Status getAirshipStatus()
    {
        EntityAirshipV1Core.Status EntityAirshipEA$status = this.getUnderwaterStatus();
        
        if (EntityAirshipEA$status != null)
        {
            this.waterLevel = this.getEntityBoundingBox().maxY;
            return EntityAirshipEA$status;
        }
        else if (this.checkInWater())
        {
            return EntityAirshipV1Core.Status.IN_WATER;
        }
        else
        {
            float f = this.getBoatGlide();

            if (f > 0.0F)
            {
                this.boatGlide = f;
                return EntityAirshipV1Core.Status.ON_LAND;
            }
            else
            {
                return EntityAirshipV1Core.Status.IN_AIR;
            }
        }
    }
    
    /**
     * Determines the water level to position the airship to.
     */
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

    /**
     * Decides whether the boat is currently underwater.
     */
    @Nullable
    private EntityAirshipV1Core.Status getUnderwaterStatus()
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
                                EntityAirshipV1Core.Status EntityAirshipEA$status = EntityAirshipV1Core.Status.UNDER_FLOWING_WATER;
                                return EntityAirshipEA$status;
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

        return flag ? EntityAirshipV1Core.Status.UNDER_WATER : null;
    }

    public static float getBlockLiquidHeight(IBlockState p_184456_0_, IBlockAccess p_184456_1_, BlockPos p_184456_2_)
    {
        int i = ((Integer)p_184456_0_.getValue(BlockLiquid.LEVEL)).intValue();
        return (i & 7) == 0 && p_184456_1_.getBlockState(p_184456_2_.up()).getMaterial() == Material.WATER ? 1.0F : 1.0F - BlockLiquid.getLiquidHeightPercent(i);
    }

    public static float getLiquidHeight(IBlockState p_184452_0_, IBlockAccess p_184452_1_, BlockPos p_184452_2_)
    {
        return (float)p_184452_2_.getY() + getBlockLiquidHeight(p_184452_0_, p_184452_1_, p_184452_2_);
    }
    
    
    
    //==================================//
    // TODO       Read/Write            //
	//==================================//
    
	/**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    @Override
    public void writeEntityToNBT(NBTTagCompound compound)
    {
    	super.writeEntityToNBT(compound);
    	
    	compound.setInteger("BurnTime", this.airshipBurnTime);
    	compound.setInteger("FuelStackTime", this.itemFuelStack);
    	
    	compound.setBoolean("ModuleInvSmall", this.getModuleInventorySmall());
    	compound.setBoolean("ModuleInvLarge", this.getModuleInventoryLarge());
    	compound.setBoolean("ModuleFuelEff", this.getModuleFuelEfficiency());
    	compound.setBoolean("ModuleFuelInf", this.getModuleFuelInfinite());
    	
    	
    	//compound.setBoolean("ModuleInvSmall", this.moduleInventorySmall);
    	
    	
        //compound.setInteger("FuelTime", this.fuelTime);
        //compound.setInteger("FuelTimeTotal", this.totalFuelTime);
        
        //compound.setInteger("ModuleInventorySmall", this.moduleInventorySmall);
        //compound.setInteger("ModuleInventoryLarge", this.moduleInventoryLarge);
        
        //compound.set.setBoolean("test", this.test);
        
        
        
        
        NBTTagList nbttaglist = new NBTTagList();
        
        for (int i = 0; i < this.inventory.length; ++i)
        {
            if (this.inventory[i] != null)
            {
                NBTTagCompound nbttagcompound = new NBTTagCompound();
                nbttagcompound.setByte("Slot", (byte)i);
                this.inventory[i].writeToNBT(nbttagcompound);
                nbttaglist.appendTag(nbttagcompound);
            }
        }
        
        if(this.hasCustomName()) 
        {
			compound.setString("CustomName", this.getCustomName());
		}
        
        compound.setTag("Items", nbttaglist);
    }
    
    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    @Override
    public void readEntityFromNBT(NBTTagCompound compound)
    {
    	super.readEntityFromNBT(compound);
    	
    	NBTTagList nbttaglist = compound.getTagList("Items", 10);
        this.inventory = new ItemStack[this.getSizeInventory()];
        
        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound = nbttaglist.getCompoundTagAt(i);
            int j = nbttagcompound.getByte("Slot");
            
            if (j >= 0 && j < this.inventory.length)
            {
                this.inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound);
            }
        }
        
        if(compound.hasKey("CustomName", 8)) 
        {
    			this.setCustomName(compound.getString("CustomName"));
    	}
        
        this.airshipBurnTime = compound.getInteger("BurnTime");
        this.itemFuelStack = compound.getInteger("FuelStackTime");
        
        this.moduleInventorySmall = compound.getBoolean("ModuleInvSmall");
        this.moduleInventoryLarge = compound.getBoolean("ModuleInvLarge");
        this.moduleFuelEfficiency = compound.getBoolean("ModuleFuelEff");
        this.moduleFuelInfinite = compound.getBoolean("ModuleFuelInf");
        
        
        //this.moduleInventorySmall = compound.getBoolean("ModuleInvSmall");
        
        
        //this.test = compound.getBoolean("test");
        //this.fuelTime = compound.getInteger("FuelTime");
        //this.totalFuelTime = compound.getInteger("FuelTimeTotal");
        //this.currentItemBurnTime = getItemBurnTime(this.inventory[1]);
        
        //this.test = getItemBurnTime(this.inventory[0]);
        
        //this.moduleInventorySmall = compound.getInteger("ModuleInventorySmall");
        //this.moduleInventoryLarge = compound.getInteger("ModuleInventoryLarge");
        
        
        //this.testIsOn = compound.getBoolean("test");
        
    }
    
    /**
     * Sounds! - Unused ATM.
     */
    //public SoundCategory getSoundCategory()
    //{
    //    return SoundCategory.HOSTILE;
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
    
    
    
    //protected boolean isMinecartPowered()
    //{
    //    return ((Boolean)this.dataManager.get(POWERED)).booleanValue();
    //}

    //protected void setMinecartPowered(boolean p_94107_1_)
    //{
    //    this.dataManager.set(POWERED, Boolean.valueOf(p_94107_1_));
    //}
    
    //@Override
	//public Packet getDescriptionPacket() {
	//	NBTTagCompound nbtTag = new NBTTagCompound();
	//	this.writeToNBT(nbtTag);
	//	return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	//}

	//@Override
	//public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
	//	readFromNBT(packet.func_148857_g());
	//}
	
	
	public void test(Entity entity)
	{

        EntityTracker et = ((WorldServer) entity.worldObj).getEntityTracker(); 
        
        //LogHelper.info("Test = " + EntityAirshipV1Core.moduleInventorySmall);
        		
        		et.trackEntity(this);
        
       // et.sendToAllTrackingEntity(entity, 
        		//NetworkHandler.sendToClient(new MessageTest(), (EntityPlayerMP) entity)
        		//CommonProxy.NETWORK.getPacketFrom(
        		//		new SyncPlayerPropsMessage()
        				
        				//new MessageTest()
        		//		)
        		
        		//);
        
	}
        /**
        .sendToAllTrackingEntity(
        		
        		entity, 
        		
        		new SimpleNetworkWrapper("VCTest")
        		.getPacketFrom
        		(new MessageTest())
        		
        		//NetworkHandler.sendToClient(
        		//		new MessageTest(), 
        		//		(EntityPlayerMP)entity
        		//		)
        		//packetIn
        		//NetworkHandler.sendToServer(MessageTest())
        		//SimpleNetworkWrapper.getInstance().getPacketFrom()
        		);
        
        */
        
        
        // You get EntityTracker of world in which there is entity you want to synchronize
        
        //et.getTrackingPlayers(entity);
        //.func_151248_b(entity, 
        //		NetworkHandler.sendToServer(new MessageGuiV1ModuleInventorySmall())
        		//SimpleNetworkWrapper.getInstance().getPacketFrom(new SomeDataPacket())
        //		; 
        // You need SNW instance, the method might vari between versions. The method itself says "send this packet to everyone who is tracking this "entity".
        
        //LogHelper.info(et.getTrackingPlayers(entity));
	//}
	
	
}

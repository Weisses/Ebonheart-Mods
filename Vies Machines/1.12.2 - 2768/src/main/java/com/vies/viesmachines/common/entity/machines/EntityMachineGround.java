package com.vies.viesmachines.common.entity.machines;

import com.vies.viesmachines.init.LootTableHandler;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.ai.attributes.RangedAttribute;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineGround extends EntityMachineFuel {
	
	//protected static final IAttribute JUMP_STRENGTH = (new RangedAttribute((IAttribute)null, "horse.jumpStrength", 0.7D, 0.0D, 2.0D)).setDescription("Jump Strength").setShouldWatch(true);
    
    /** Has this machine jumped in the air? */
	protected boolean machineJumping;
    
	protected float jumpPower;
    
    
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineGround(World worldIn) 
	{
		super(worldIn);
		
		// Sets a base name if there isn't one:
		if(!this.hasCustomName())
		{
			this.setCustomNameTag("Ground Machine");
		}
		
		// Sets width and height:
		this.setWidth = 1.5F;
		this.setHeight = 0.5F;
		
		this.width = this.setWidth;
		this.height = this.setHeight;
		
		this.setSize(this.width, this.height);
		
	}
	
	public EntityMachineGround(World worldIn, double x, double y, double z,
			
			int frameTierIn, int engineTierIn, int componentTierIn, int typeIn, 
			float healthIn, int energyIn, int durabilityIn, 
			boolean brokenIn, int currentFuelIn, int totalFuelIn, 
			//int itemstackFuelItemIn, int itemstackFuelSizeIn, 
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
		
        /**
		this.frameTier = frameTierIn;
		this.engineTier = engineTierIn;
		this.componentTier = componentTierIn;
		this.setHealth(currentHPIn);
		this.storedEnergy = currentEPIn;
		this.storedFuel = currentFuelIn;
		this.storedFuelTotal = totalFuelIn;
		this.itemstackFuelItem = itemstackFuelItemIn;
		this.itemstackFuelSize = itemstackFuelSizeIn;
		this.broken = brokenIn;
		this.machineEnhancement1 = machineEnhancement1In;
		
		this.visualTypeModel = visualTypeModelIn;
		this.visualVariantModel = visualVariantModelIn;
		
		this.visualFrameTexture = visualFrameTextureIn;
		this.visualFrameTransparent = visualFrameTransparentIn;
		this.visualFrameColor = visualFrameColorIn;
		this.visualFrameColorRed = visualFrameColorRedIn;
		this.visualFrameColorGreen = visualFrameColorGreenIn;
		this.visualFrameColorBlue = visualFrameColorBlueIn;
		
		this.visualEngineParticle = visualEngineParticleIn;
		this.visualEngineDisplayType = visualEngineDisplayTypeIn;
		this.visualEngineDisplayItemstack = visualEngineDisplayItemstackIn;
		this.visualEngineDisplayItemstackMeta = visualEngineDisplayItemstackMetaIn;
		this.visualEngineDisplayHead = visualEngineDisplayHeadIn;
		this.visualEngineDisplaySupporterHead = visualEngineDisplaySupporterHeadIn;
		this.visualEngineDisplayHoliday = visualEngineDisplayHolidayIn;
		
		this.visualComponentTexture = visualComponentTextureIn;
		this.visualComponentTransparent = visualComponentTransparentIn;
		this.visualComponentColor = visualComponentColorIn;
		this.visualComponentColorRed = visualComponentColorRedIn;
		this.visualComponentColorGreen = visualComponentColorGreenIn;
		this.visualComponentColorBlue = visualComponentColorBlueIn;
		
        this.inventory = new ItemStackHandler(size);
        this.inventory.deserializeNBT(compoundIn);
        
        this.setCustomNameTag(customNameIn);
		this.visualNameColor = visualNameColorIn;
		*/
	}
	
	
	
	//==================================================
    // TODO              Core Inits
	//==================================================
    
	@Override
    protected void initEntityAI()
    {
    	super.initEntityAI();
    }
	
	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
    }
	
	@Override
    protected void entityInit()
    {
        super.entityInit();
    }
	
	
	
	//==================================================
    // TODO            Read/Write Logic
	//==================================================
    
	@Override
	public void writeEntityToNBT(NBTTagCompound compound)
    {
		super.writeEntityToNBT(compound);
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound compound)
    {
		super.readEntityFromNBT(compound);
    }
	
	
	
	//==================================================
    // TODO           Main update logic
	//==================================================
    
	@Override
	public void onUpdate()
    {
		super.onUpdate();
    }
	
	@Override
	public void onEntityUpdate()
    {
        super.onEntityUpdate();
    }
	
	@Override
	public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }
	
	
	
	//==================================================
    // TODO       Overrides from EntityLiving
	//==================================================

	@Override
    protected ResourceLocation getLootTable()
    {
    	return LootTableHandler.MACHINE_GROUND;
    }
	
	@Override
    public double getMountedYOffset()
    {
        return 0.15D;
    }
    
	@Override
	protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos)
    {
        
    }
    
    
    
	//==================================================
    // TODO            Movement Logic
	//==================================================
	
    @Override
    public void initiateControlAirship()
    {
    	super.initiateControlAirship();
    	
    	if (this.isBeingRidden()
    	&& this.getPoweredOn())
    	{
    		if (Minecraft.getMinecraft().gameSettings.keyBindJump.isKeyDown())
        	{
        		if (!this.machineJumping)
        		{
        			this.motionY = 0.2;
        			
        			this.machineJumping = true;
        		}
        	}
    	}
    }
    
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
    	super.travel(strafe, vertical, forward);
    	
    	if(!this.isBlockUnderEntityAir())
    	{
    		if(this.machineJumping)
			{
    			this.machineJumping = false;
			}
    	}
    	
    	if(this.getPoweredOn())//.isBeingRidden())
    	{
	    	
    		
    		if(this.isFuelNeeded())
	    	{
	    		if(this.isFuelBurning())
	    		{
	    			
	    			if(this.isBlockUnderEntityAir())
	    	    	{
	    				this.motionY -= 0.005F;
	    	    		
	    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    	    	}
	    			else
	    	    	{
	    				this.motionY += 0.005F;
	    	    		
	    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    	    	}
	    			
	    			if (!this.isBeingRidden())
	    			{
	    				this.motionY -= 0.005F;
	    	    		
	    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    			}
	    		}
	    		else
	    		{
	    			this.motionY = -0.25D;
    	    		
    	    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
	    		}
	    	}
	    	else
	    	{
	    		if(this.isBlockUnderEntityAir())
		    	{
		    		this.motionY -= 0.005F;
		    		
		    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		    	}
				else
		    	{
		    		this.motionY += 0.005F;
		    		
		    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
		    	}
	    	}
    	}
    	else
    	{
    		this.motionY -= 0.005F;
    		
    		this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
    	}
    }
    
    
    
	//==================================================
    // TODO              Custom Logic
	//==================================================
	
    @Override
    protected boolean isFuelNeeded()
	{
		return true;
	}
    
    @Override
    public boolean isGroundMachine()
    {
		return true;
    }
	
	@Override
	protected void damageMachineByStatus()
    {
		super.damageMachineByStatus();
		
		if(this.getHealth() > 0.0F)
    	{
			
    	}
    }
	
	
	
	
}

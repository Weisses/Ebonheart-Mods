package com.vies.viesmachines.common.entity.machines.types.flying;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.items.ItemStackHandler;

public class EntityMachineFlyingAirship extends EntityMachineFlying {
	
	//==================================================
    // TODO             Constructor
	//==================================================
    
	public EntityMachineFlyingAirship(World worldIn) 
	{
		super(worldIn);
		
		// Sets width and height:
		this.setWidth = 1.5F;
		this.setHeight = 0.75F;
		this.width = this.setWidth;
		this.height = this.setHeight;
		
		// Sets the hitbox size:
		this.setSize(this.width, this.height);
		
		// Sets a base name if there isn't one:
		if (!this.hasCustomName())
		{
			this.setCustomNameTag(References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.defaultname.7"));
		}
	}
	
	public EntityMachineFlyingAirship(World worldIn, double x, double y, double z,
			
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
        
        this.setTierFrame(frameTierIn);
		this.setTierEngine(engineTierIn);
		this.setTierComponent(componentTierIn);
		//this.setType(typeIn);
		
		this.setHealth(healthIn);
		this.setEnergy(energyIn);
		this.setDurability(durabilityIn);
		
		this.setBroken(brokenIn);
		this.setFuel(currentFuelIn);
		this.setFuelTotal(totalFuelIn);
		
		this.setAmmoAmount(ammoAmountIn);
		this.setAmmoType(ammoTypeIn);
		this.setMachineEnhancement1(machineEnhancement1In);
		
		this.setVisualModelFrame(visualModelFrameIn);
		this.setVisualModelEngine(visualModelEngineIn);
		this.setVisualModelComponent(visualModelComponentIn);
		
		this.setVisualFrameTexture(visualFrameTextureIn);
		this.setVisualFrameTransparent(visualFrameTransparentIn);
		this.setVisualFrameColor(visualFrameColorIn);
		this.setVisualFrameColorRed(visualFrameColorRedIn);
		this.setVisualFrameColorGreen(visualFrameColorGreenIn);
		this.setVisualFrameColorBlue(visualFrameColorBlueIn);
		
		this.setVisualEngineParticle(visualEngineParticleIn);
		this.setVisualEngineDisplayType(visualEngineDisplayTypeIn);
		this.setVisualEngineDisplayItemstack(visualEngineDisplayItemstackIn);
		this.setVisualEngineDisplayItemstackMeta(visualEngineDisplayItemstackMetaIn);
		this.setVisualEngineDisplayHead(visualEngineDisplayHeadIn);
		this.setVisualEngineDisplaySupporterHead(visualEngineDisplaySupporterHeadIn);
		this.setVisualEngineDisplayHoliday(visualEngineDisplayHolidayIn);
		
		this.setVisualComponentTexture(visualComponentTextureIn);
		this.setVisualComponentTransparent(visualComponentTransparentIn);
		this.setVisualComponentColor(visualComponentColorIn);
		this.setVisualComponentColorRed(visualComponentColorRedIn);
		this.setVisualComponentColorGreen(visualComponentColorGreenIn);
		this.setVisualComponentColorBlue(visualComponentColorBlueIn);
		
        this.inventory = new ItemStackHandler(size);
        this.inventory.deserializeNBT(compoundIn);
        
        this.setCustomNameTag(customNameIn);
		this.setVisualNameColor(customNameColorIn);
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
    public double getMountedYOffset()
    {
        return 0.25D;
    }
    
    
    
	//==================================================
    // TODO              Custom Logic
	//==================================================
	
    @Override
	public ItemStack getItemMachine()
    {
    	ItemStack stack = new ItemStack(ItemsVM.ITEM_MACHINE_FLYING_AIRSHIP, 1);
    	
    	stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger(rf.TIER_FRAME_TAG, this.getTierFrame());
		stack.getTagCompound().setInteger(rf.TIER_ENGINE_TAG, this.getTierEngine());
		stack.getTagCompound().setInteger(rf.TIER_COMPONENT_TAG, this.getTierComponent());
		
		//stack.getTagCompound().setInteger(rf.TYPE_TAG, this.getType());
		stack.getTagCompound().setFloat(rf.HEALTH_TAG, this.getHealth());
		stack.getTagCompound().setInteger(rf.ENERGY_TAG, this.getEnergy());
		stack.getTagCompound().setInteger(rf.DURABILITY_TAG, this.getDurability());
		stack.getTagCompound().setInteger(rf.DURABILITY_PERCENT_TAG, this.getDurabilityPercent());
		
		stack.getTagCompound().setBoolean(rf.BROKEN_TAG, this.getBroken());
		stack.getTagCompound().setInteger(rf.FUEL_TAG, this.getFuel());
		stack.getTagCompound().setInteger(rf.FUEL_TOTAL_TAG, this.getFuelTotal());
		
		stack.getTagCompound().setInteger(rf.AMMO_AMOUNT_TAG, this.getAmmoAmount());
		stack.getTagCompound().setInteger(rf.AMMO_TYPE_TAG, this.getAmmoType());
		stack.getTagCompound().setInteger(rf.MACHINE_ENHANCEMENT_1_TAG, this.getMachineEnhancement1());
		
		stack.getTagCompound().setInteger(rf.VISUAL_MODEL_FRAME_TAG, this.getVisualModelFrame());
		stack.getTagCompound().setInteger(rf.VISUAL_MODEL_ENGINE_TAG, this.getVisualModelEngine());
		stack.getTagCompound().setInteger(rf.VISUAL_MODEL_COMPONENT_TAG, this.getVisualModelComponent());
		
		stack.getTagCompound().setInteger(rf.VISUAL_FRAME_TEXTURE_TAG, this.getVisualFrameTexture());
		stack.getTagCompound().setBoolean(rf.VISUAL_FRAME_TRANSPARENT_TAG, this.getVisualFrameTransparent());
		stack.getTagCompound().setBoolean(rf.VISUAL_FRAME_COLOR_TAG, this.getVisualFrameColor());
		stack.getTagCompound().setInteger(rf.VISUAL_FRAME_COLOR_RED_TAG, this.getVisualFrameColorRed());
		stack.getTagCompound().setInteger(rf.VISUAL_FRAME_COLOR_GREEN_TAG, this.getVisualFrameColorGreen());
		stack.getTagCompound().setInteger(rf.VISUAL_FRAME_COLOR_BLUE_TAG, this.getVisualFrameColorBlue());
		
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_PARTICLE_TAG, this.getVisualEngineParticle());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_TYPE_TAG, this.getVisualEngineDisplayType());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_TAG, this.getVisualEngineDisplayItemstack());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_ITEMSTACK_META_TAG, this.getVisualEngineDisplayItemstackMeta());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_HEAD_TAG, this.getVisualEngineDisplayHead());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_SUPPORTER_HEAD_TAG, this.getVisualEngineDisplaySupporterHead());
		stack.getTagCompound().setInteger(rf.VISUAL_ENGINE_DISPLAY_HOLIDAY_TAG, this.getVisualEngineDisplayHoliday());
		
		stack.getTagCompound().setInteger(rf.VISUAL_COMPONENT_TEXTURE_TAG, this.getVisualComponentTexture());
		stack.getTagCompound().setBoolean(rf.VISUAL_COMPONENT_TRANSPARENT_TAG, this.getVisualComponentTransparent());
		stack.getTagCompound().setBoolean(rf.VISUAL_COMPONENT_COLOR_TAG, this.getVisualComponentColor());
		stack.getTagCompound().setInteger(rf.VISUAL_COMPONENT_COLOR_RED_TAG, this.getVisualComponentColorRed());
		stack.getTagCompound().setInteger(rf.VISUAL_COMPONENT_COLOR_GREEN_TAG, this.getVisualComponentColorGreen());
		stack.getTagCompound().setInteger(rf.VISUAL_COMPONENT_COLOR_BLUE_TAG, this.getVisualComponentColorBlue());
		
		stack.getTagCompound().setTag(rf.MACHINE_SLOTS_TAG, this.inventory.serializeNBT());
		stack.getTagCompound().setString(rf.CUSTOM_NAME_TAG, this.getCustomNameTag());
		stack.getTagCompound().setInteger(rf.VISUAL_NAME_COLOR_TAG, this.getVisualNameColor());
		
    	return stack;
    }
	
    //--------------------------------------------------
    
	//@Override
	//public String getTypeName()
	//{
	//	return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.typeflying." + this.getType());
	//}
	
	@Override
	public String getVariantName()
	{
		return EnumsVM.FlyingMachineAirshipVariantName.byId(this.getVisualModelComponent()).getUnlocalizedName();
	}
    
	@Override
	public String getMachineDefaultName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.typeflying.0");
	}
	
	/** Returns the string machine type name. (Used in GUI) (Airship, Helicopter, etc.) */
	public String getTypeName()
	{
		return References.Old_I18n.translateToLocalFormatted("viesmachines.enum.machinename.typeflying.0");
	}
}

package com.vies.viesmachines.common.entity.thrown;

import com.vies.viesmachines.client.InitParticlesVMRender;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityThrownMachineFlyingAirship extends EntityThrownMachineBase {
	
    public EntityThrownMachineFlyingAirship(World worldIn)
    {
        super(worldIn);
    }
    
    public EntityThrownMachineFlyingAirship(World worldIn, EntityLivingBase entityIn, 
			
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
        super(worldIn, entityIn);
        
        this.frameTier = frameTierIn;
		this.engineTier = engineTierIn;
		this.componentTier = componentTierIn;
		
		this.type = typeIn;
		this.health = healthIn;
		this.energy = energyIn;
		this.durability = durabilityIn;
		
		this.broken = brokenIn;
		this.fuel = currentFuelIn;
		this.fuelTotal = totalFuelIn;
		
		this.ammoAmount = ammoAmountIn;
		this.ammoType = ammoTypeIn;
		
		this.machineEnhancement1 = machineEnhancement1In;
		
		this.visualModelFrame = visualModelFrameIn;
		this.visualModelEngine = visualModelEngineIn;
		this.visualModelComponent = visualModelComponentIn;
		
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
		
		this.storedInventory = compoundIn;
        this.customName = customNameIn;
		this.visualNameColor = customNameColorIn;
    }
    
    public EntityThrownMachineFlyingAirship(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        if(!this.world.isRemote)
        {
        	this.playSound(SoundEvents.ENTITY_GENERIC_EXPLODE, 0.5F, 0.4F / .5F * 0.4F + 0.8F);
        	EntityMachineFlyingAirship spawnAirship = new EntityMachineFlyingAirship(this.world, this.posX, this.posY + 0.5F, this.posZ, 
					
					this.frameTier, this.engineTier, this.componentTier, this.type, 
					this.health, this.energy, this.durability,
    				this.broken, this.fuel, this.fuelTotal, 
    				this.ammoAmount, this.ammoType, 
    				this.machineEnhancement1, 
    				
    				this.visualModelFrame, this.visualModelEngine, this.visualModelComponent,
    				
    				this.visualFrameTexture, 
    				this.visualFrameTransparent, this.visualFrameColor,
    				this.visualFrameColorRed, 
    				this.visualFrameColorGreen, 
    				this.visualFrameColorBlue,
    				
    				this.visualEngineParticle,
    				this.visualEngineDisplayType,
    				this.visualEngineDisplayItemstack,
    				this.visualEngineDisplayItemstackMeta,
    				this.visualEngineDisplayHead,
    				this.visualEngineDisplaySupporterHead,
    				this.visualEngineDisplayHoliday,
    				
    				this.visualComponentTexture, 
    				this.visualComponentTransparent, this.visualComponentColor,
    				this.visualComponentColorRed, 
    				this.visualComponentColorGreen, 
    				this.visualComponentColorBlue,
    				
    	    		this.storedInventory, this.customName, this.visualNameColor
		    		);
        	
        	spawnAirship.rotationYaw = this.getThrower().rotationYawHead;
        	this.world.spawnEntity(spawnAirship);
        	
        	this.setDead();
        }
        else
    	{
        	InitParticlesVMRender.generateParticlesExplosions(this);
    	}
    }
}

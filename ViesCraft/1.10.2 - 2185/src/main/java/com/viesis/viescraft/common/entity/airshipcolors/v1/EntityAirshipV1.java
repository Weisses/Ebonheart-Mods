package com.viesis.viescraft.common.entity.airshipcolors.v1;

import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.ReturnItemHelperVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class EntityAirshipV1 extends EntityAirshipV1Core {
	
	public EntityAirshipV1(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
    }
	
    public EntityAirshipV1(World worldIn, double x, double y, double z, int frameIn, int colorIn)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        
        this.metaFrame = frameIn;
        this.metaColor = colorIn;
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }
    
	/**
     * Main entity item drop.
     */
    @Override
	public Item getItemBoat()
    {
    	switch (this.getBoatFrame().ordinal())
        {
            case 0:
            	return ReturnItemHelperVC.V1_ITEM_WOOD0[this.metaColor];
            case 1:
            	return ReturnItemHelperVC.V1_ITEM_IRON[this.metaColor];
            case 2:
            	return ReturnItemHelperVC.V1_ITEM_REDSTONE[this.metaColor];
            case 3:
            	return ReturnItemHelperVC.V1_ITEM_GOLD[this.metaColor];
            case 4:
            	return ReturnItemHelperVC.V1_ITEM_LAPISLAZULI[this.metaColor];
            case 5:
            	return ReturnItemHelperVC.V1_ITEM_OBSIDIAN[this.metaColor];
            case 6:
            	return ReturnItemHelperVC.V1_ITEM_DIAMOND[this.metaColor];
            case 7:
            	return ReturnItemHelperVC.V1_ITEM_EMERALD[this.metaColor];
            default:
            	return null;
        }
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.customName : Reference.AIRSHIP_FRAME[this.metaFrame] + " " + Reference.AIRSHIP_COLOR[this.metaColor] + " " + ViesCraftConfig.v1AirshipName;
	}
	
	@Override
	public void entityInit() 
	{
		this.dataManager.register(TIME_SINCE_HIT, Integer.valueOf(0));
        this.dataManager.register(FORWARD_DIRECTION, Integer.valueOf(1));
        this.dataManager.register(DAMAGE_TAKEN, Float.valueOf(0.0F));
        this.dataManager.register(BOAT_TYPE_FRAME, Integer.valueOf(this.metaFrame));
        this.dataManager.register(BOAT_TYPE_COLOR, Integer.valueOf(this.metaColor));
        
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
}

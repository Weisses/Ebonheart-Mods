package com.viesis.viescraft.common.entity.airshipcolors.v4;

import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

public class EntityAirshipV4LightBlue extends EntityAirshipV4Core {
	
	public EntityAirshipV4LightBlue(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
    }
	
    public EntityAirshipV4LightBlue(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
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
		return InitItemsVC.item_airship_v4_lightblue;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : "Light Blue " + ViesCraftConfig.v4AirshipName;
	}
}

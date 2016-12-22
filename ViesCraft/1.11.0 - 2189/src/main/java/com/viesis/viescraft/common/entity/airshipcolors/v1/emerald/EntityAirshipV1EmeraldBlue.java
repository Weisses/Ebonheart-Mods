package com.viesis.viescraft.common.entity.airshipcolors.v1.emerald;

import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

public class EntityAirshipV1EmeraldBlue extends EntityAirshipV1Core {
	
	public EntityAirshipV1EmeraldBlue(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
    }
	
    public EntityAirshipV1EmeraldBlue(World worldIn, double x, double y, double z)
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
		return InitItemsVC.item_airship_v1_emerald_blue;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : Emerald + Blue + ViesCraftConfig.v1AirshipName;
	}
}

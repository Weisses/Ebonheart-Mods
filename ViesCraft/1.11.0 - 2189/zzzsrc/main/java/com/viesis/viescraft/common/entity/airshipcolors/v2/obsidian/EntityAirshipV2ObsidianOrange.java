package com.viesis.viescraft.common.entity.airshipcolors.v2.obsidian;

import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitItemsVC;

public class EntityAirshipV2ObsidianOrange extends EntityAirshipV2Core {
	
	public EntityAirshipV2ObsidianOrange(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
    }
	
    public EntityAirshipV2ObsidianOrange(World worldIn, double x, double y, double z)
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
		return InitItemsVC.item_airship_v2_obsidian_orange;
    }
    
    /**
     * Custom name for Waila.
     */
	@Override
	public String getName() {
		return this.hasCustomName() ? this.customName : Obsidian + Orange + ViesCraftConfig.v2AirshipName;
	}
}

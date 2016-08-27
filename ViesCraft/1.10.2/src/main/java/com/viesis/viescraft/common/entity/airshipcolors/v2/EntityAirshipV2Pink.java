package com.viesis.viescraft.common.entity.airshipcolors.v2;

import net.minecraft.item.Item;
import net.minecraft.world.World;

import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.init.InitItemsVC;

public class EntityAirshipV2Pink extends EntityAirshipV2Core {
	
	public EntityAirshipV2Pink(World worldIn)
    {
        super(worldIn);
        
        this.ignoreFrustumCheck = true;
        this.preventEntitySpawning = true;
        this.setSize(1.0F, 0.35F);
    }
	
    public EntityAirshipV2Pink(World worldIn, double x, double y, double z)
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
	public Item getItemBoat()
    {
		return InitItemsVC.item_airship_v2_pink;
    }
}

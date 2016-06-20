package com.viesis.viescraft.common.utils;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.stats.StatList;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import com.mojang.authlib.GameProfile;
import com.viesis.viescraft.common.entity.EntityAirshipEA;

public class EntityPlayerEA extends EntityPlayer {

	
	public EntityPlayerEA(World worldIn, GameProfile gameProfileIn) 
	{
		
		super(worldIn, gameProfileIn);
		
	}

	/**
     * Adds a value to a mounted movement statistic field - by minecart, boat, or pig.
     */
	
    private void addMountedMovementStat(double p_71015_1_, double p_71015_3_, double p_71015_5_)
    {
        if (this.isRiding())
        {
            int i = Math.round(MathHelper.sqrt_double(p_71015_1_ * p_71015_1_ + p_71015_3_ * p_71015_3_ + p_71015_5_ * p_71015_5_) * 100.0F);

            if (i > 0)
            {
                if (this.getRidingEntity() instanceof EntityAirshipEA)
                {
                    this.addStat(StatList.BOAT_ONE_CM, i);
                }
                
            }
            
        }
        
    }

	@Override
	public boolean isSpectator() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCreative() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
    
}

package com.viesis.viescraft.common.blocks.basic;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;

import com.viesis.viescraft.common.blocks.BlockHelper;

public class BlockEA extends Block {
	
	public BlockEA(String unlocalizedName) 
	{
		super(Material.rock);
		BlockHelper.setBlockName(this, unlocalizedName);
				
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setStepSound(soundTypeStone);
		this.useNeighborBrightness=true;
	}
	
	@Override
    public boolean isOpaqueCube()
    {
    	return false;
    }
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
}

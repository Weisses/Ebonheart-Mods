package com.vies.viesmachines.common.blocks.slab;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDoubleSlabVM extends BlockSlabVM {
	
	public BlockDoubleSlabVM(String nameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(nameIn, materialIn, soundTypeIn);
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
	
	@Override
	public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face)
    {
        return BlockFaceShape.SOLID;
    }
}

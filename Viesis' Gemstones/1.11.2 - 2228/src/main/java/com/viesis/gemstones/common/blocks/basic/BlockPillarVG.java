package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockPillarVG extends BlockRotatedPillar {
	
	public BlockPillarVG(String unlocalizedName)
	{
		super(Material.ROCK);
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
		this.useNeighborBrightness = true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
}

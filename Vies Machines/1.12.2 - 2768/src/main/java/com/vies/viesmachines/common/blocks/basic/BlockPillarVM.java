package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockRotatedPillar;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;

public class BlockPillarVM extends BlockRotatedPillar {
	
	public BlockPillarVM(String nameIn, Material materialIn, SoundType soundTypeIn)
	{
		super(materialIn);
		BlockHelper.setBlockName(this, nameIn);
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setSoundType(soundTypeIn);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}
}

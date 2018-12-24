package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockStairsVM extends BlockStairs {
	
	public BlockStairsVM(String nameIn, Material materialIn, SoundType soundTypeIn, Block block) 
	{
		super(block.getDefaultState());
		BlockHelper.setBlockName(this, nameIn);
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setSoundType(soundTypeIn);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
	}
}

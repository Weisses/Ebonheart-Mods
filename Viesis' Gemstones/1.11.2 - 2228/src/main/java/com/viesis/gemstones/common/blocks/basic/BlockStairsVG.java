package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.block.SoundType;

public class BlockStairsVG extends BlockStairs {
	
	public BlockStairsVG(String unlocalizedName, Block block) 
	{
		super(block.getDefaultState());
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.useNeighborBrightness = true;
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}

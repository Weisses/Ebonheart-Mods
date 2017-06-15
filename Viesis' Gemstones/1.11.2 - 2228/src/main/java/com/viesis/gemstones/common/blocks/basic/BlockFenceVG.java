package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFenceVG extends BlockFence {
	
	public BlockFenceVG(String unlocalizedName) 
	{
		super(Material.WOOD, null);
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}

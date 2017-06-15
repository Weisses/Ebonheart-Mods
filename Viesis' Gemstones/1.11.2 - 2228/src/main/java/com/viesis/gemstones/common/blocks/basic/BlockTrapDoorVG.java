package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockTrapDoorVG extends BlockTrapDoor {
	
	public BlockTrapDoorVG(String unlocalizedName) 
	{
		super(Material.ROCK);
		
		BlockHelper.setBlockName(this, unlocalizedName);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
	}
}

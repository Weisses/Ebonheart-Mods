package com.ebonheart.EbonArtsMod.common.blocks.basic;

import com.ebonheart.EbonArtsMod.common.blocks.BlockHelper;

import net.minecraft.block.BlockTrapDoor;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EABlockTrapDoor extends BlockTrapDoor {

	public EABlockTrapDoor(String unlocalizedName) {
		super(Material.ROCK);
		
		BlockHelper.setBlockName(this, unlocalizedName);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
	}

}

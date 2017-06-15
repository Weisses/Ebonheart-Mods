package com.viesis.gemstones.common.blocks.zzzTEMP.dyeables;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockMysticStone extends Block {
	
	public BlockMysticStone(String unlocalizedName) 
	{
		super(Material.ROCK);
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setCreativeTab(ViesisGemstones.tabVGDyeables);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setResistance(100.0F);
		this.setSoundType(SoundType.STONE);
	}
}

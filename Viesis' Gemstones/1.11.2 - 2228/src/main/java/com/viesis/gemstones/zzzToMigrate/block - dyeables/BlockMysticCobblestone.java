package com.viesis.gemstones.common.blocks.zzzTEMP.dyeables;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.basic.BlockPillarVG;

import net.minecraft.block.SoundType;

public class BlockMysticCobblestone extends BlockPillarVG {
	
	public BlockMysticCobblestone(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.setCreativeTab(ViesisGemstones.tabVGDyeables);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setResistance(100.0F);
		this.setSoundType(SoundType.STONE);
	}
}

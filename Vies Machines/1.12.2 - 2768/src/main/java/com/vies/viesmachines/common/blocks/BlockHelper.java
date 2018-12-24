package com.vies.viesmachines.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;

public class BlockHelper extends Block {
	
	public BlockHelper(Material materialIn, MapColor mapColorIn, String blockNameIn) 
	{
		super(materialIn, mapColorIn);
		this.setBlockName(this, blockNameIn);
	}
	
	public BlockHelper(Material materialIn, String blockNameIn) 
	{
		this(materialIn, materialIn.getMaterialMapColor(), blockNameIn);
	}
	
	/** Set the registry name of {@code block} to {@code blockName} and the unlocalized name to the full registry name. */
	public static void setBlockName(Block block, String blockName) 
	{
		block.setRegistryName(blockName);
		block.setUnlocalizedName(block.getRegistryName().toString());
	}
}

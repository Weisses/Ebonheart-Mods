package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockFence;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockFenceVM extends BlockFence {
	
	public BlockFenceVM(String nameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(materialIn, null);
		BlockHelper.setBlockName(this, nameIn);
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setSoundType(soundTypeIn);
		this.setCreativeTab(ViesMachines.tabBlocks);
		
		this.fullBlock = false;
		this.useNeighborBrightness = true;
		//this.setLightOpacity(0);
	}
}

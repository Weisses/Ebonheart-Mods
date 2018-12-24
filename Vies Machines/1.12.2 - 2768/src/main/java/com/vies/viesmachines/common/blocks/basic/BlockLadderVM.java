package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;

public class BlockLadderVM extends BlockLadder {
    
    public BlockLadderVM(String nameIn, Material materialIn, SoundType soundTypeIn)
    {
        super();
        BlockHelper.setBlockName(this, nameIn);
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        
        this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
    }
}

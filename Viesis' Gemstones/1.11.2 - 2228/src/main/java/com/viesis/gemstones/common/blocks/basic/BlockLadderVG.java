package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockLadder;
import net.minecraft.util.EnumFacing;

public class BlockLadderVG extends BlockLadder {
    
    public BlockLadderVG(String unlocalizedName)
    {
        super();
        BlockHelper.setBlockName(this, unlocalizedName);
        
        this.useNeighborBrightness = true;
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(5.0F);
    }
}

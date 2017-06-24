package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGateVG extends BlockFenceGate {
	
	public BlockGateVG(String unlocalizedName) 
	{
		super(BlockPlanks.EnumType.OAK);
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)).withProperty(IN_WALL, Boolean.valueOf(false)));
        this.setHarvestLevel("pickaxe", 2);
        this.setHardness(5.0F);
        this.setSoundType(SoundType.STONE);
		this.setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
}

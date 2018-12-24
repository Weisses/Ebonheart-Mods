package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockFenceGate;
import net.minecraft.block.BlockPlanks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGateVM extends BlockFenceGate {
	
	public BlockGateVM(String nameIn, Material materialIn, SoundType soundTypeIn) 
	{
		super(BlockPlanks.EnumType.OAK);
		BlockHelper.setBlockName(this, nameIn);
		
		this.setDefaultState(this.blockState.getBaseState().withProperty(OPEN, Boolean.valueOf(false)).withProperty(POWERED, Boolean.valueOf(false)).withProperty(IN_WALL, Boolean.valueOf(false)));
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setSoundType(soundTypeIn);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
	}
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
}

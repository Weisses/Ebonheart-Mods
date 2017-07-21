package com.viesis.gemstones.common.blocks.basic;

import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockBaseVG extends Block {
	
	public BlockBaseVG(String unlocalizedName) 
	{
		super(Material.ROCK);
		
		BlockHelper.setBlockName(this, unlocalizedName);
		
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setResistance(5F);
		this.setSoundType(SoundType.STONE);
		this.useNeighborBrightness=true;
	}
	
	@Override
    public boolean isOpaqueCube(IBlockState state)
    {
    	return false;
    }
	
	@Override
	public boolean isFlammable(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return false;
    }
	
	@Override
    public boolean canSilkHarvest(World world, BlockPos pos, IBlockState state, EntityPlayer player) 
    {
		return true;
    }
}

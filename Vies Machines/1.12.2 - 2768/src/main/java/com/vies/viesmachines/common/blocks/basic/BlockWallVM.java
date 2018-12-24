package com.vies.viesmachines.common.blocks.basic;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockWallVM extends BlockWall {
	
	public BlockWallVM(String nameIn, Material materialIn, SoundType soundTypeIn, Block block) 
    {
		super(block);
		BlockHelper.setBlockName(this, nameIn);
		
		this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setSoundType(soundTypeIn);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
		items.add(new ItemStack(this, 1, 0));
    }
	
	@Override
	public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
	
	@Override
	public boolean canPlaceTorchOnTop(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        if (state.isSideSolid(world, pos, EnumFacing.UP))
        {
            return true;
        }
        else
        {
            return this instanceof BlockWallVM || this == net.minecraft.init.Blocks.GLASS || this == net.minecraft.init.Blocks.COBBLESTONE_WALL;
        }
    }
}

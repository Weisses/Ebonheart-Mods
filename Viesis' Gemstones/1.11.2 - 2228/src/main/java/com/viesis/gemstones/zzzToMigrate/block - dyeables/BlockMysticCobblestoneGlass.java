package com.viesis.gemstones.common.blocks.zzzTEMP.dyeables;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.basic.BlockPillarVG;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockMysticCobblestoneGlass extends BlockPillarVG {
	
	private boolean ignoreSimilarity = true;
	
	public BlockMysticCobblestoneGlass(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.setCreativeTab(ViesisGemstones.tabVGDyeables);
		this.setHarvestLevel("pickaxe", 2);
		this.setHardness(5.0F);
		this.setSoundType(SoundType.STONE);
	}
	
	@SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }

    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
    
    /**
     * Used to determine ambient occlusion and culling when rebuilding chunks for render
     */
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        IBlockState iblockstate = blockAccess.getBlockState(pos.offset(side));
        Block block = iblockstate.getBlock();
        
        IBlockState test = blockAccess.getBlockState(pos.offset(side));
        Block test1 = iblockstate.getBlock();
/**
        if (this == InitBlocksVG.cobble_mystic_block_glass
         || this == InitBlocksVG.mystic_block_glass
         || this == InitBlocksVG.wood_mystic_block_glass)
        {
        	
            if (blockState != iblockstate)
            {
                return true;
            }

            if (block == this)
            {
                return false;
            }
        }
*/
        return !this.ignoreSimilarity && block == this ? false : super.shouldSideBeRendered(blockState, blockAccess, pos, side);
    }
    
}

package com.viesis.gemstones.common.blocks.torches;

import java.util.Random;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.BlockHelper;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTorchNecrociteVG extends BlockTorch {
	
    public BlockTorchNecrociteVG(String unlocalizedName)
    {
        super();
        BlockHelper.setBlockName(this, unlocalizedName);
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setLightLevel(0.9375F);
		this.setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
    }
    
    @SideOnly(Side.CLIENT)
    public void randomDisplayTick(IBlockState worldIn, World pos, BlockPos state, Random rand)
    {
        EnumFacing enumfacing = (EnumFacing)worldIn.getValue(FACING);
        double d0 = (double)state.getX() + 0.5D;
        double d1 = (double)state.getY() + 0.7D;
        double d2 = (double)state.getZ() + 0.5D;
        double d3 = 0.22D;
        double d4 = 0.27D;
        
        if (enumfacing.getAxis().isHorizontal())
        {
            EnumFacing enumfacing1 = enumfacing.getOpposite();
            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 5.0D, 0.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), -9.0D, 9.0D, -9.0D, new int[0]);
        }
        else
        {
            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0, d1, d2, 0.0D, 5.0D, 0.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, -9.0D, 9.0D, -9.0D, new int[0]);
        }
    }
}

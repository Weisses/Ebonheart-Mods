package com.vies.viesmachines.common.blocks.basic;

import java.util.Random;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.common.blocks.BlockHelper;

import net.minecraft.block.BlockTorch;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTorchVM extends BlockTorch {
	
    public BlockTorchVM(String unlocalizedName, Material materialIn, SoundType soundTypeIn)
    {
        super();
        BlockHelper.setBlockName(this, unlocalizedName);
        
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
        this.setTickRandomly(true);
        this.setLightLevel(1.0F);
        
        this.setHarvestLevel("pickaxe", 1);
		this.setHardness(15.0F);
		this.setResistance(50.0F);
		this.setCreativeTab(ViesMachines.tabBlocks);
		this.setLightOpacity(255);
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
            pos.spawnParticle(EnumParticleTypes.LAVA, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 0.0D, 0.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 5.0D, 2.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 5.1D, 3.4D, new int[0]);
        }
        else
        {
        	pos.spawnParticle(EnumParticleTypes.LAVA, d0, d1, d2, 0.0D, 0.0D, 0.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0, d1, d2, 0.0D, 5.0D, 2.0D, new int[0]);
            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 0.0D, 5.1D, 3.4D, new int[0]);
        }
    }
}

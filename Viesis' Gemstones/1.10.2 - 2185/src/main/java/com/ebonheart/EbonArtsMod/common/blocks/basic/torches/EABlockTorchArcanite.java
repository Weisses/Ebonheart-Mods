package com.ebonheart.EbonArtsMod.common.blocks.basic.torches;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
//import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
//import net.minecraft.util.EnumWorldBlockLayer;
//import net.minecraft.util.MovingObjectPosition;
//import net.minecraft.util.Vec3;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.blocks.BlockHelper;
import com.google.common.base.Predicate;

public class EABlockTorchArcanite extends BlockTorch {
		
	    public EABlockTorchArcanite()
	    {
	        super();
	        BlockHelper.setBlockName(this, "gem/arcanite/arcanite_torch");
	        
	        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.UP));
	        this.setTickRandomly(true);
	        this.setLightLevel(0.9375F);
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
	            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 5.0D, 2.0D, new int[0]);
	            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0 + d4 * (double)enumfacing1.getFrontOffsetX(), d1 + d3, d2 + d4 * (double)enumfacing1.getFrontOffsetZ(), 0.0D, 5.1D, 3.4D, new int[0]);
	        }
	        else
	        {
	            pos.spawnParticle(EnumParticleTypes.SPELL_MOB_AMBIENT, d0, d1, d2, 0.0D, 5.0D, 2.0D, new int[0]);
	            pos.spawnParticle(EnumParticleTypes.REDSTONE, d0, d1, d2, 0.0D, 5.1D, 3.4D, new int[0]);
	        }
	    }

	}


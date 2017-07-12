package com.viesis.gemstones.common.blocks.tileentity;

import java.util.List;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.References;
import com.viesis.gemstones.common.blocks.basic.BlockBaseVG;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.GuiHandler;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGemstoneCutter extends BlockBaseVG implements ITileEntityProvider {
	
	public BlockGemstoneCutter(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.isBlockContainer = true;
		this.setLightOpacity(255);
		this.setCreativeTab(ViesisGemstones.tabVGGeneral);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing heldItem, float side, float hitX, float hitY) 
	{
		if (worldIn.isRemote)
        {
            return true;
        }
        else
        {
        	playerIn.openGui(References.MOD_ID, GuiHandler.GUI_GEMSTONE_WORKBENCH_MAIN, worldIn, pos.getX(), pos.getY(), pos.getZ());
            //playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityGemstoneWorkbench te = (TileEntityGemstoneWorkbench)world.getTileEntity(pos);
		
		for (int x = 0; x < 2; ++x)
		{
			if(!te.inventory.getStackInSlot(x).isEmpty())
			{
				ItemStack dropItems = te.inventory.getStackInSlot(x);
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), te.inventory.getStackInSlot(x));
				dropItems.isEmpty();
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) 
	{
		if(stack.hasDisplayName()) 
		{
			((TileEntityGemstoneWorkbench)world.getTileEntity(pos)).getDisplayName();
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityGemstoneWorkbench();
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vg.item.tt.cutter.1"));
		toolTip.add(TextFormatting.GREEN + I18n.translateToLocal("vg.item.tt.cutter.2"));
	}
}

package com.viesis.viescraft.common.blocks;

import java.util.List;
import java.util.Random;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.blocks.basic.BlockEA;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.network.GuiHandler;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockAirshipWorkbench extends BlockEA implements ITileEntityProvider {
	
	private Random rand = new Random();
	
	public BlockAirshipWorkbench(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.setCreativeTab(ViesCraft.tabViesCraftBlocks);
		this.isBlockContainer = true;
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
        	playerIn.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_WORKBENCH, worldIn, pos.getX(), pos.getY(), pos.getZ());
            playerIn.addStat(StatList.CRAFTING_TABLE_INTERACTION);
            return true;
        }
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) 
	{
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) 
	{
		return EnumBlockRenderType.INVISIBLE;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) 
	{
		TileEntityAirshipWorkbench te = (TileEntityAirshipWorkbench)world.getTileEntity(pos);
		
		//TODO Check this!
		for (int x = 0; x < 8; ++x) 
		{
			if(te.inventory.getStackInSlot(x) != null)
			{
				ItemStack test = te.inventory.getStackInSlot(x);
				InventoryHelper.spawnItemStack(world, pos.getX(), pos.getY(), pos.getZ(), te.inventory.getStackInSlot(x));
				test = null;
			}
		}
		
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) 
	{
		if(stack.hasDisplayName()) 
		{
			((TileEntityAirshipWorkbench)world.getTileEntity(pos)).getDisplayName();
		}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) 
	{
		return new TileEntityAirshipWorkbench();
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.GREEN + "Used to craft all parts,");
		toolTip.add(TextFormatting.GREEN + "airships, and modules.");
	}
}

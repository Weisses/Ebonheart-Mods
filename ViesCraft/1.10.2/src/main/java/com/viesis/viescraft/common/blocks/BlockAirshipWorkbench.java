package com.viesis.viescraft.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockWorkbench;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerWorkbench;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.StatList;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.IInteractionObject;
import net.minecraft.world.World;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.blocks.basic.BlockEA;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.network.GuiHandler;

public class BlockAirshipWorkbench extends BlockEA implements ITileEntityProvider {

	public BlockAirshipWorkbench(String unlocalizedName) {
		super(unlocalizedName);
		this.setCreativeTab(ViesCraft.tabViesCraftBlocks);
		//this.setUnlocalizedName("cooking_pot");
		this.isBlockContainer = true;
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		//if (world.isRemote)
        //{
        //    return true;
        //}
        //else
        //{
        //    player.displayGui(new BlockWorkbench.InterfaceCraftingTable(world, pos));
        //    player.addStat(StatList.CRAFTING_TABLE_INTERACTION);
        //    return true;
        //}
		if(!world.isRemote) {
			player.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_WORKBENCH, world, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.INVISIBLE;
	}
	
	@Override
	public void breakBlock(World world, BlockPos pos, IBlockState state) {
		TileEntityAirshipWorkbench te = (TileEntityAirshipWorkbench)world.getTileEntity(pos);
		InventoryHelper.dropInventoryItems(world, pos, te);
		super.breakBlock(world, pos, state);
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase player, ItemStack stack) {
		//if(stack.hasDisplayName()) {
			//((TileEntityAirshipWorkbench)world.getTileEntity(pos)).setCustomName(stack.getDisplayName());
		//}
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityAirshipWorkbench();
	}
	/**
	public static class InterfaceCraftingTable implements IInteractionObject
    {
        private final World world;
        private final BlockPos position;

        public InterfaceCraftingTable(World worldIn, BlockPos pos)
        {
            this.world = worldIn;
            this.position = pos;
        }

        /**
         * Get the name of this object. For players this returns their username
         */
	/**    public String getName()
        {
            return null;
        }

        /**
         * Returns true if this thing is named
         */
	/**     public boolean hasCustomName()
        {
            return false;
        }

        /**
         * Get the formatted ChatComponent that will be used for the sender's username in chat
         */
	/**    public ITextComponent getDisplayName()
        {
            return new TextComponentTranslation(Blocks.CRAFTING_TABLE.getUnlocalizedName() + ".name", new Object[0]);
        }

        public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
        {
            return new ContainerWorkbench(playerInventory, this.world, this.position);
        }

        public String getGuiID()
        {
            return "minecraft:crafting_table";
        }
    }
	*/
}

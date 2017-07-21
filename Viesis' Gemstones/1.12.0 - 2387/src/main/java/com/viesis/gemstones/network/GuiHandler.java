package com.viesis.gemstones.network;

import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneConverterMain;
import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneWorkbenchMain;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.common.tileentity.containers.ContainerGemstoneConverter;
import com.viesis.gemstones.common.tileentity.containers.ContainerGemstoneWorkbench;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	
	public static final int GUI_GEMSTONE_WORKBENCH_MAIN = 1;
	
	public static final int GUI_GEMSTONE_CONVERTER_MAIN = 5;
	
	public GuiHandler() 
	{
    	instance = this;
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//Gemstone Workbench Container
		if (ID == GUI_GEMSTONE_WORKBENCH_MAIN)
		{
			return new ContainerGemstoneWorkbench(player.inventory, world, (TileEntityGemstoneWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Gemstone Converter Container
		if (ID == GUI_GEMSTONE_CONVERTER_MAIN)
		{
			return new ContainerGemstoneConverter(player.inventory, world, (TileEntityGemstoneConverter)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//Gemstone Workbench GUI
		if (ID == GUI_GEMSTONE_WORKBENCH_MAIN)
		{
			return new GuiTileEntityGemstoneWorkbenchMain(player.inventory, world, (TileEntityGemstoneWorkbench)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		//Gemstone Converter GUI
		if (ID == GUI_GEMSTONE_CONVERTER_MAIN)
		{
			return new GuiTileEntityGemstoneConverterMain(player.inventory, world, (TileEntityGemstoneConverter)world.getTileEntity(new BlockPos(x, y, z)));
		}
		
		return null;
	}
}

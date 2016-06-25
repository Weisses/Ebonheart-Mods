package com.viesis.viescraft.common.utils.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	public static final int ALCHEMICAL_COMPENDIUM_GUI = 0;
	public static final int TEST_TILE_ENTITY_GUI = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == 1)
		{
			return z; //new ContainerTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else 
		{
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == 0)
		{
			//return new GuiCompendium();
		}
		else if (ID == 1)
		{
			return z; //new GuiTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else
		{
			return null;
		}
		return z;
	}
}

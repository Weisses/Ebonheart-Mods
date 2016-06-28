package com.viesis.viescraft.common.utils.gui;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.client.ContainerTestTileEntity;
import com.viesis.viescraft.client.GuiTestTileEntity;
import com.viesis.viescraft.common.entity.EntityAirshipVC;
import com.viesis.viescraft.common.entity.EntityVC;

public class GuiHandler implements IGuiHandler {

	public static final int ENTITYAIRSHIPVC_GUI = 0;
	public static final int TEST_TILE_ENTITY_GUI = 1;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		
		if (ID == 0)
	        return new ContainerTestTileEntity(player.inventory, null)
	        		//(ModTileEntity) world.getTileEntity(new BlockPos(x, y, z))
	        		;

	    return null;
		//if (ID == 1)
		//{
		//	return new EntityAirshipVC(world); //new ContainerTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		//}
		//else 
		//{
		//	return null;
		//}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == 0)
		{
			return new GuiTestTileEntity(player.inventory, null);
		}
		else if (ID == 1)
		{
			return null; //new GuiTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		}
		else
		{
			return null;
		}
	}
}

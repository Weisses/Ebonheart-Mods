package com.viesis.viescraft.api.gui;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiAirshipVC;
import com.viesis.viescraft.common.entity.ContainerAirshipVC;
import com.viesis.viescraft.common.entity.EntityAirshipVC;

public class GuiHandler implements IGuiHandler {
	
	public static GuiHandler instance;
	public static final int ENTITYAIRSHIPVC_GUI = 0;
	//public static final int TEST_TILE_ENTITY_GUI = 1;
	
	public GuiHandler() {
    	instance = this;
    	//LogHelper.info("works to HERE!");
    }
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == 0)
		{
			//LogHelper.info("works to getServerGuiElement");
			Entity entity = world.getEntityByID(x);
			
			if(entity instanceof EntityAirshipVC)
			{
			return new ContainerAirshipVC(player.inventory, (EntityAirshipVC)entity);
			}
		}
			//if (ID == 0)
		//{
	    //    return new ContainerAirshipVC(player.inventory, player.getRidingEntity());
		//}
		//else
		//{
		//	return null;
		//}
		//if (ID == 1)
		//{
		//	return new EntityAirshipVC(world); //new ContainerTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		//}
		//else 
		//{
			return null;
		//}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		if (ID == 0)
		{
			Entity entity = world.getEntityByID(x);
			if(entity instanceof EntityAirshipVC)
				return new GuiAirshipVC(player.inventory, (EntityAirshipVC)entity);
			
			//return new GuiEntityAirship(player.inventory, null);
		}
		//else if (ID == 1)
		//{
		//	return null; //new GuiTestTileEntity(player.inventory, (TestTileEntity) world.getTileEntity(new BlockPos(x, y, z)));
		//}
		//else
		//{
		return null;
		//}
	}
}

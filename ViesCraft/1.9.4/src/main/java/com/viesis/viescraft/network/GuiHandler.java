package com.viesis.viescraft.network;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

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
		//if (ID == 0)
		//{
			//LogHelper.info("works to getServerGuiElement");
		//	Entity entity = world.getEntityByID(x);
			
		//	if(entity instanceof EntityAirshipNormal)
		//	{
		//	return new ContainerAirshipVC(player.inventory, (EntityAirshipNormal)entity);
		//	}
		//}
		
		//if (ID == ENTITYAIRSHIPVC_GUI)
			//return new ContainerModTileEntity(player.inventory, ); //(EntityAirshipNormal) world.getTileEntity(new BlockPos(x, y, z)));

		return null;
		
		
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) 
	{
		//if (ID == 0)
		//{
		//	Entity entity = world.getEntityByID(x);
		//	if(entity instanceof EntityAirshipNormal)
		//		return new GuiModTileEntity(player.inventory, (EntityAirshipNormal)entity);
			
			//return new GuiEntityAirship(player.inventory, null);
		//}
		
		//if (ID == ENTITYAIRSHIPVC_GUI)
			//return new GuiModTileEntity(player.inventory, );//(EntityAirshipNormal) world.getTileEntity(new BlockPos(x, y, z)));

		return null;
	}
}

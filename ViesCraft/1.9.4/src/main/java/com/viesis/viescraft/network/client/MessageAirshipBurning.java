package com.viesis.viescraft.network.client;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

public class MessageAirshipBurning extends MessageBase<MessageAirshipBurning> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageAirshipBurning message, EntityPlayer player) 
	{
		//int test = player.getEntityData().getInteger("BurnTime");
		//if(test > 0)
		//{
		//	EntityAirshipCore.isAirshipBurning(EntityAirshipCore.inventory)
		//}
		
	}
	
	@Override
	public void handleServerSide(MessageAirshipBurning message, EntityPlayer player) 
	{
		//player.openGui(ViesCraft.instance, GuiHandler.GUI_AIRSHIP_INVENTORY, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}
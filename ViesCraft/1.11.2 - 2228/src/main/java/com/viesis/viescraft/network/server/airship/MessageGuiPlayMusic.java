package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.client.gui.airship.modules.GuiModuleJukebox;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiPlayMusic extends MessageBase<MessageGuiPlayMusic> implements IMessage {
	
	static int airshipId;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		airshipId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiModuleJukebox.airshipId);
	}
	
	@Override
	public void handleClientSide(MessageGuiPlayMusic message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiPlayMusic message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		NetworkHandler.sendToAllAround(new MessageGuiPlayInArea(), 
    	new TargetPoint(airship.dimension, airship.posX, airship.posY, airship.posZ, 30));
	}
}

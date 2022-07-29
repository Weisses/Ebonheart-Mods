package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.client.gui.airship.main.GuiMainMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiPlayMusic extends MessageBase<MessageGuiPlayMusic> implements IMessage {
	
	static int airshipId;
	static int selectedSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		airshipId = buf.readInt();
		selectedSong = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMainMenu.airshipId);
		buf.writeInt(GuiMainMenu.selectedSong);
	}
	
	@Override
	public void handleClientSide(MessageGuiPlayMusic message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiPlayMusic message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		NetworkHandler.sendToAllAround(new MessageGuiPlayMusicArea(), 
    	new TargetPoint(airship.dimension, airship.posX, airship.posY, airship.posZ, 30));
	}
}

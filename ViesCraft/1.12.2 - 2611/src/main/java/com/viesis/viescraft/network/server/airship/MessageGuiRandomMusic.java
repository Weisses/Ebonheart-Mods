package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.airship.main.GuiMainMenuMusic;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageGuiRandomMusic extends MessageBase<MessageGuiRandomMusic> implements IMessage {
	
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
		buf.writeInt(GuiMainMenuMusic.airshipId);
		buf.writeInt(GuiMainMenuMusic.selectedSong);
	}
	
	@Override
	public void handleClientSide(MessageGuiRandomMusic message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiRandomMusic message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.metaJukeboxSelectedSong = message.selectedSong;
	}
}

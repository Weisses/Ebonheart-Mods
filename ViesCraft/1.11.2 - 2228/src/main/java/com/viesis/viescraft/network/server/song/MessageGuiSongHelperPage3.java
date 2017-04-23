package com.viesis.viescraft.network.server.song;

import com.viesis.viescraft.client.gui.airship.music.GuiAirshipMusicPg3;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiSongHelperPage3 extends MessageBase<MessageGuiSongHelperPage3> {
	
	private int metaSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaSong = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiAirshipMusicPg3.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageGuiSongHelperPage3 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiSongHelperPage3 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.jukeboxSelectedSong = message.metaSong;
	}
}

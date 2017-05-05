package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.client.sound.JukeboxMovingSoundVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGuiPlayMusicArea extends MessageBase<MessageGuiPlayMusicArea> {
	
	private int airshipId;
	private EntityAirshipBaseVC airship;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		airshipId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageGuiPlayMusic.airshipId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageGuiPlayMusicArea message, EntityPlayer player) 
	{
		message.airship = (EntityAirshipBaseVC) Minecraft.getMinecraft().world.getEntityByID(message.airshipId);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		soundHandler.playSound(new JukeboxMovingSoundVC(message.airship, EntityAirshipBaseVC.Song.byId(message.airship.jukeboxSelectedSong).getSong()));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageGuiPlayMusicArea message, EntityPlayer player) 
	{
		
	}
}

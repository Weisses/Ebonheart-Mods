package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.client.sound.JukeboxMovingSoundVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISoundEventListener;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGuiStopMusicArea extends MessageBase<MessageGuiStopMusicArea> {
	
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
	public void handleClientSide(MessageGuiStopMusicArea message, EntityPlayer player) 
	{
		message.airship = (EntityAirshipBaseVC) Minecraft.getMinecraft().world.getEntityByID(message.airshipId);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVC(message.airship, EnumsVC.AirshipSong.byId(0).getSong()));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageGuiStopMusicArea message, EntityPlayer player) 
	{
		
	}
}

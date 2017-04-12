package com.viesis.viescraft.network.server.airship;

import java.util.Iterator;
import java.util.Map;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.MovingSoundVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraftforge.fml.relauncher.ReflectionHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageGuiNoMusic extends MessageBase<MessageGuiNoMusic> {
	//final WorldClient worldClient = Minecraft.getMinecraft().world;
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageGuiNoMusic message, EntityPlayer player) 
	{
		LogHelper.info("Client within 15 blocks!1 " + new MessageGuiPlayMusic().airship);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		//Minecraft.getMinecraft().world.playSound(x, y, z, soundIn, category, volume, pitch, distanceDelay);
		//MessageGuiPlayMusic.airship.playSoundVC(SoundEvents.RECORD_WARD, 1, 1);
		//MessageGuiPlayMusic.airship.playSound(SoundEvents.RECORD_WARD, 1, 1);
		////////soundHandler.playSound(new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD));
		//this.airship.playSoundVC(null, 0, 0);
		
		/**
		SoundManager mng = ReflectionHelper.getPrivateValue(SoundHandler.class, Minecraft.getMinecraft().getSoundHandler(), "sndManager");
		Map playingSounds = ReflectionHelper.getPrivateValue(SoundManager.class, mng, "playingSounds");
		
		Iterator it = playingSounds.keySet().iterator();
		
		if(it.hasNext())
		{
			PositionedSound ps = (PositionedSound)playingSounds.get(it.next());
			
			if(ps != null
					&& ps.getCategory() == SoundCategory.MUSIC)
			{
				Minecraft.getMinecraft().getSoundHandler().stopSound(ps);
				//break;
			}
		}
		*/
		
		//LogHelper.info("Client within 15 blocks!1 " + MessageGuiPlayMusic.airship);
	}
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageGuiNoMusic message, EntityPlayer player) 
	{
		LogHelper.info("Client within 15 blocks!2");
	}
}

package com.viesis.viescraft.network.server.airship;

import org.apache.logging.log4j.core.config.plugins.ResolverUtil.Test;

import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.JukeboxSoundVC;
import com.viesis.viescraft.client.MovingSoundVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.client.audio.MovingSoundMinecart;
import net.minecraft.client.audio.MovingSoundMinecartRiding;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.audio.SoundManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;



public class MessageGuiPlayMusicCLIENT extends MessageBase<MessageGuiPlayMusicCLIENT> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiPlayMusicCLIENT message, EntityPlayer player) 
	{
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		//soundHandler.stopSounds();
		
		///////player.getRidingEntity().playSound(SoundEvents.RECORD_WARD, 0.5F, 0.5F);
		
		
		
		//soundHandler.playSound(new MovingSoundVC(player, SoundEvents.RECORD_WARD));
		LogHelper.info("-Client-");
	}
	
	@Override
	public void handleServerSide(MessageGuiPlayMusicCLIENT message, EntityPlayer player) 
	{
		LogHelper.info("-Server-" + player);
		
		///////this.airship = (EntityAirshipV1Core) player.getRidingEntity();
		
		///////this.airship.playSound(SoundEvents.RECORD_WARD, 0F, 0F);
		
		//////////////player.getRidingEntity().playSound(SoundEvents.RECORD_WARD, 0.5F, 0.5F);
		
		//message.handleClientSide(message, player);

		//if(player.world.isRemote)
		//{
			
		//	LogHelper.info("-Client-");
		//}
		//else
		//{
			
			//player.getRidingEntity().playSound(SoundEvents.RECORD_WARD, 0.5F, 0.5F);
			
			//SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
			//soundHandler.stopSounds();
			
			//////player.getRidingEntity().playSound(SoundEvents.RECORD_WARD, 0.5F, 0.5F);
			
			//message.handleClientSide(message.onMessage(message, "test"));
			
			//soundHandler.playSound(new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD));
			
			//NetworkHandler.sendToClient(new MessageGuiPlayMusic(), (EntityPlayerMP) player);
		//	LogHelper.info("-Server-");
		//}
		
		//player.playSound(SoundEvents.RECORD_WARD, 0.5F, 0.5F);
		
		//SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		//soundHandler.stopSounds();
		//soundHandler.playSound(new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD));
		
		//player.world.playSound(null, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ(), SoundEvents.RECORD_WARD, SoundCategory.RECORDS, 0.5F, 0.5F);
		
		/////MovingSoundVC Test = new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD);
		
		/////Test.update();
		
		//player.world.playRecord(new MovingSoundVC((EntityAirshipBaseVC) player.getRidingEntity(), SoundEvents.RECORD_WARD), null);
		
		//LogHelper.info("Server started playing = " + player);
	}
}

package com.vies.viesmachines.network.server.machine.gui.main.song;

import com.vies.viesmachines.client.sound.JukeboxMovingSoundVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelperGuiMachineMusicStopArea extends MessageBase<MessageHelperGuiMachineMusicStopArea> {
	
	private int machineIdArea;
	private EntityMachineBase machine;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.machineIdArea = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageHelperGuiMachineMusicStop.machineId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageHelperGuiMachineMusicStopArea message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineIdArea);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVM(message.machine, SoundEvents.UI_BUTTON_CLICK));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageHelperGuiMachineMusicStopArea message, EntityPlayer player) 
	{
		
	}
}

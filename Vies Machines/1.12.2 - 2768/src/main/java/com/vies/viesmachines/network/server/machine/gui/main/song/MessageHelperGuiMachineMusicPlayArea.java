package com.vies.viesmachines.network.server.machine.gui.main.song;

import com.vies.viesmachines.client.sound.JukeboxMovingSoundVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.proxy.ClientProxy;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class MessageHelperGuiMachineMusicPlayArea extends MessageBase<MessageHelperGuiMachineMusicPlayArea> {
	
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
		buf.writeInt(MessageHelperGuiMachineMusicPlay.machineId);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleClientSide(MessageHelperGuiMachineMusicPlayArea message, EntityPlayer player) 
	{
		this.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineIdArea);
		
		SoundHandler soundHandler = Minecraft.getMinecraft().getSoundHandler();
		soundHandler.stopSounds();
		
		soundHandler.playSound(new JukeboxMovingSoundVM(this.machine, ForgeRegistries.SOUND_EVENTS.getValue(ClientProxy.musicListRecord.get(this.machine.getSelectedRecord()))));
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void handleServerSide(MessageHelperGuiMachineMusicPlayArea message, EntityPlayer player) 
	{
		
	}
}

package com.vies.viesmachines.network.server.machine.gui.main.song;

import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMain;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageHelperGuiMachineMusicRandom extends MessageBase<MessageHelperGuiMachineMusicRandom> implements IMessage {
	
	public static int machineId;
	public static int selectedSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.machineId = buf.readInt();
		this.selectedSong = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMain.machineId);
		buf.writeInt(GuiMachineMenuMain.selectedSongId);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMusicRandom message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMusicRandom message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		machine.setSelectedRecord(message.selectedSong);
	}
}

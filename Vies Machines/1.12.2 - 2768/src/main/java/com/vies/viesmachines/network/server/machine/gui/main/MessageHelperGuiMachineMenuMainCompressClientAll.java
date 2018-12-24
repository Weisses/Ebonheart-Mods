package com.vies.viesmachines.network.server.machine.gui.main;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuMainCompressClientAll extends MessageBase<MessageHelperGuiMachineMenuMainCompressClientAll> {
	
	private int machineID;
	private EntityMachineBase machine;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		machineID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageHelperGuiMachineMenuMainCompress.machineID);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuMainCompressClientAll message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineID);
		
		message.machine.setEventTrigger(EnumsVM.EventTrigger.DESTRUCTION.getMetadata());
		message.machine.isDead = true;
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuMainCompressClientAll message, EntityPlayer player) 
	{
		
	}
}

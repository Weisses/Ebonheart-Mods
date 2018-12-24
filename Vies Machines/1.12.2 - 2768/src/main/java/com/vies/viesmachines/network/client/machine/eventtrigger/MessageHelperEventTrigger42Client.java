package com.vies.viesmachines.network.client.machine.eventtrigger;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger42Server;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperEventTrigger42Client extends MessageBase<MessageHelperEventTrigger42Client> {
	
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
		buf.writeInt(MessageHelperEventTrigger42Server.machineID);
	}
	
	@Override
	public void handleClientSide(MessageHelperEventTrigger42Client message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineID);
		
		message.machine.spawnUpgradeParticles2();
	}
	
	@Override
	public void handleServerSide(MessageHelperEventTrigger42Client message, EntityPlayer player) 
	{
		
	}
}

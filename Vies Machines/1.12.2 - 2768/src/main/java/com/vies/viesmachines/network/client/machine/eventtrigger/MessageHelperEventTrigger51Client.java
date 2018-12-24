package com.vies.viesmachines.network.client.machine.eventtrigger;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger51Server;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperEventTrigger51Client extends MessageBase<MessageHelperEventTrigger51Client> {
	
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
		buf.writeInt(MessageHelperEventTrigger51Server.machineID);
	}
	
	@Override
	public void handleClientSide(MessageHelperEventTrigger51Client message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineID);
		
		message.machine.spawnAmmoParticles1();
	}
	
	@Override
	public void handleServerSide(MessageHelperEventTrigger51Client message, EntityPlayer player) 
	{
		
	}
}

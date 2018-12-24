package com.vies.viesmachines.network.client.machine.eventtrigger;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.machine.eventtrigger.MessageHelperEventTrigger33Server;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperEventTrigger33Client extends MessageBase<MessageHelperEventTrigger33Client> {
	
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
		buf.writeInt(MessageHelperEventTrigger33Server.machineID);
	}
	
	@Override
	public void handleClientSide(MessageHelperEventTrigger33Client message, EntityPlayer player) 
	{
		message.machine = (EntityMachineBase) Minecraft.getMinecraft().world.getEntityByID(message.machineID);
		
		message.machine.spawnHealDurabilityParticles3();
	}
	
	@Override
	public void handleServerSide(MessageHelperEventTrigger33Client message, EntityPlayer player) 
	{
		
	}
}

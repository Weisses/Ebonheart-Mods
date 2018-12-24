package com.vies.viesmachines.network.server.machine;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageFlyingThunderStrike extends MessageBase<MessageFlyingThunderStrike> implements IMessage {
	
	public static int entityID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.entityID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(EntityMachineBase.entityID);
	}
	
	@Override
	public void handleClientSide(MessageFlyingThunderStrike message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageFlyingThunderStrike message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.world.getEntityByID(message.entityID);
		Entity lightning = new EntityLightningBolt(machine.world, (double)machine.posX + 0.5D, (double)machine.posY + 0.5D, (double)machine.posZ + 0.5D, false);
		
		machine.setPoweredOn(false);
		machine.world.addWeatherEffect(lightning);
	}
}

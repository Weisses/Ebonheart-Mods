package com.vies.viesmachines.network.server.machine;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.particles.EntityMachineFlyingBombNormal;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageMachineFlyingBombStandard extends MessageBase<MessageMachineFlyingBombStandard> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageMachineFlyingBombStandard message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageMachineFlyingBombStandard message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		EntityMachineFlyingBombNormal entityflyingbombstandard = new EntityMachineFlyingBombNormal(player.world, 
				player.posX, 
				player.posY - 1.0D, 
				player.posZ);
		
		player.world.spawnEntity(entityflyingbombstandard);
	}
}

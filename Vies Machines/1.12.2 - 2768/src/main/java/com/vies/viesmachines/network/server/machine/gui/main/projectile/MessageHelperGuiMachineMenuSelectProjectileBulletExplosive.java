package com.vies.viesmachines.network.server.machine.gui.main.projectile;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuSelectProjectileBulletExplosive extends MessageBase<MessageHelperGuiMachineMenuSelectProjectileBulletExplosive> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuSelectProjectileBulletExplosive message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuSelectProjectileBulletExplosive message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setAmmoType(2);
	}
}

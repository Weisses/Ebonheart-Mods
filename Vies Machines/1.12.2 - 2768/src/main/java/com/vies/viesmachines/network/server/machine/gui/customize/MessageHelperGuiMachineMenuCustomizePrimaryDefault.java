package com.vies.viesmachines.network.server.machine.gui.customize;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimaryDefault extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimaryDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimaryDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimaryDefault message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setVisualFrameTransparent(false);
		machineIn.setVisualFrameTexture(0);
		machineIn.setVisualFrameColor(false);
	}
}

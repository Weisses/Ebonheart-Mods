package com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault extends MessageBase<MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setVisualComponentColor(false);
		machineIn.setVisualComponentColorRed(0);
		machineIn.setVisualComponentColorGreen(0);
		machineIn.setVisualComponentColorBlue(0);
	}
}

package com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimarySkinColorDefault message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setVisualFrameColor(false);
		machineIn.setVisualFrameColorRed(0);
		machineIn.setVisualFrameColorGreen(0);
		machineIn.setVisualFrameColorBlue(0);
	}
}

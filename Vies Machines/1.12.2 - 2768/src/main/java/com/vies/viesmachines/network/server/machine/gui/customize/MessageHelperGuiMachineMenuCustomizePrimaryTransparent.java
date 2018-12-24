package com.vies.viesmachines.network.server.machine.gui.customize;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimaryTransparent extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimaryTransparent> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimaryTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimaryTransparent message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualFrameTransparent(!machineIn.getVisualFrameTransparent());
		}
		else if (!machineIn.getVisualFrameTransparent()
		&& machineIn.getEnergy() >= CostsVM.COST_FRAME_TRANSPARENCY)
		{
			machineIn.setVisualFrameTransparent(true);
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_FRAME_TRANSPARENCY);
		}
		else
		{
			machineIn.setVisualFrameTransparent(false);
		}
	}
}

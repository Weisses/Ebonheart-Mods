package com.vies.viesmachines.network.server.machine.gui.customize;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeSecondaryTransparent extends MessageBase<MessageHelperGuiMachineMenuCustomizeSecondaryTransparent> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeSecondaryTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeSecondaryTransparent message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualComponentTransparent(!machineIn.getVisualComponentTransparent());
		}
		else if (!machineIn.getVisualComponentTransparent()
		&& machineIn.getEnergy() >= CostsVM.COST_COMPONENT_TRANSPARENCY)
		{
			machineIn.setVisualComponentTransparent(true);
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_COMPONENT_TRANSPARENCY);
		}
		else
		{
			machineIn.setVisualComponentTransparent(false);
		}
	}
}

package com.vies.viesmachines.network.server.machine.gui.customize.activemodels;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeActiveModelApply extends MessageBase<MessageHelperGuiMachineMenuCustomizeActiveModelApply> {
	
	public static int modelFrameIn;
	public static int modelEngineIn;
	public static int modelComponentIn;
	
	private int totalEnergyCost;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.modelFrameIn = buf.readInt();
		this.modelEngineIn = buf.readInt();
		this.modelComponentIn = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuCustomizeActiveModels.modelFrame);
		buf.writeInt(GuiMachineMenuCustomizeActiveModels.modelEngine);
		buf.writeInt(GuiMachineMenuCustomizeActiveModels.modelComponent);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeActiveModelApply message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeActiveModelApply message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		this.totalEnergyCost = 0;
		
		// Calculates total costs depending on what is selected:
		if (machineIn.getVisualModelFrame() != message.modelFrameIn)
		{
			this.totalEnergyCost = this.totalEnergyCost + CostsVM.COST_CHANGE_MODEL_FRAME;
		}
		if (machineIn.getVisualModelEngine() != message.modelEngineIn)
		{
			this.totalEnergyCost = this.totalEnergyCost + CostsVM.COST_CHANGE_MODEL_ENGINE;
		}
		if (machineIn.getVisualModelComponent() != message.modelComponentIn)
		{
			this.totalEnergyCost = this.totalEnergyCost + CostsVM.COST_CHANGE_MODEL_COMPONENT;
		}
		
		if (player.isCreative())
		{
			machineIn.setVisualModelFrame(message.modelFrameIn);
			machineIn.setVisualModelEngine(message.modelEngineIn);
			machineIn.setVisualModelComponent(message.modelComponentIn);
		}
		else
		{
			// Initiates the changes if the machine has enough energy:
			if (machineIn.getEnergy() >= message.totalEnergyCost)
			{
				machineIn.setVisualModelFrame(message.modelFrameIn);
				machineIn.setVisualModelEngine(message.modelEngineIn);
				machineIn.setVisualModelComponent(message.modelComponentIn);
				
				machineIn.setEnergy(machineIn.getEnergy() - this.totalEnergyCost);
			}
		}
	}
}

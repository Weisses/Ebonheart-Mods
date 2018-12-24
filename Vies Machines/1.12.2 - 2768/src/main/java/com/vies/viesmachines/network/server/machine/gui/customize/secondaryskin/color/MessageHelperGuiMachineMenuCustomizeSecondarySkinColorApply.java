package com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizeSecondarySkinColor;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply extends MessageBase<MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply> {
	
	private static int textRedIn;
	private static int textGreenIn;
	private static int textBlueIn;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.textRedIn = buf.readInt();
		this.textGreenIn = buf.readInt();
		this.textBlueIn = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuCustomizeSecondarySkinColor.textRedNumber);
		buf.writeInt(GuiMachineMenuCustomizeSecondarySkinColor.textGreenNumber);
		buf.writeInt(GuiMachineMenuCustomizeSecondarySkinColor.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualComponentColor(true);
			machineIn.setVisualComponentColorRed(message.textRedIn);
			machineIn.setVisualComponentColorGreen(message.textGreenIn);
			machineIn.setVisualComponentColorBlue(message.textBlueIn);
		}
		else if (machineIn.getEnergy() >= CostsVM.COST_COMPONENT_COLOR)
		{
			machineIn.setVisualComponentColor(true);
			machineIn.setVisualComponentColorRed(message.textRedIn);
			machineIn.setVisualComponentColorGreen(message.textGreenIn);
			machineIn.setVisualComponentColorBlue(message.textBlueIn);
			
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_COMPONENT_COLOR);
		}
	}
}

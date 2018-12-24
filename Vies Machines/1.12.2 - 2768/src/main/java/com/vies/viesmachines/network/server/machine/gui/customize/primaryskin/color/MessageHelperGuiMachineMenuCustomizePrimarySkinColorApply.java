package com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizePrimarySkinColor;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply> {
	
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
		buf.writeInt(GuiMachineMenuCustomizePrimarySkinColor.textRedNumber);
		buf.writeInt(GuiMachineMenuCustomizePrimarySkinColor.textGreenNumber);
		buf.writeInt(GuiMachineMenuCustomizePrimarySkinColor.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimarySkinColorApply message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualFrameColor(true);
			machineIn.setVisualFrameColorRed(message.textRedIn);
			machineIn.setVisualFrameColorGreen(message.textGreenIn);
			machineIn.setVisualFrameColorBlue(message.textBlueIn);
		}
		else if (machineIn.getEnergy() >= CostsVM.COST_FRAME_COLOR)
		{
			machineIn.setVisualFrameColor(true);
			machineIn.setVisualFrameColorRed(message.textRedIn);
			machineIn.setVisualFrameColorGreen(message.textGreenIn);
			machineIn.setVisualFrameColorBlue(message.textBlueIn);
			
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_FRAME_COLOR);
		}
	}
}

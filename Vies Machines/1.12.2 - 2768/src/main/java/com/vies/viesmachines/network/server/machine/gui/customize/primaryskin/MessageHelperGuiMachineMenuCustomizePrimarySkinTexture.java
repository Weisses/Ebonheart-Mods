package com.vies.viesmachines.network.server.machine.gui.customize.primaryskin;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimarySkinTexture extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimarySkinTexture> {
	
	public static int textureID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.textureID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuCustomizePrimarySkinTexture.machineTexture);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimarySkinTexture message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimarySkinTexture message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualFrameTexture(message.textureID);
		}
		else if (message.textureID == 0)
		{
			machineIn.setVisualFrameTexture(message.textureID);
		}
		else if (machineIn.getEnergy() >= CostsVM.COST_FRAME_TEXTURE)
		{
			machineIn.setVisualFrameTexture(message.textureID);
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_FRAME_TEXTURE);
		}
	}
}

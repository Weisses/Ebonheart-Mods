package com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture extends MessageBase<MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture> {
	
	public static int textureID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.textureID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuCustomizeSecondarySkinTexture.machineTexture);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinTexture message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualComponentTexture(message.textureID);
		}
		else if (message.textureID == 0)
		{
			machineIn.setVisualComponentTexture(message.textureID);
		}
		else if (machineIn.getEnergy() >= CostsVM.COST_COMPONENT_TEXTURE)
		{
			machineIn.setVisualComponentTexture(message.textureID);
			machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_COMPONENT_TEXTURE);
		}
	}
}

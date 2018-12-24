package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.customize.GuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday extends MessageBase<MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday> {
	
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
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday message, EntityPlayer player) 
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

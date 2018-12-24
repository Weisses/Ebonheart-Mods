package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.client.gui.machines.customize.holiday.GuiMachineMenuCustomizePrimarySkinTextureHoliday;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday extends MessageBase<MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday> {
	
	public static int textureID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.textureID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuCustomizePrimarySkinTextureHoliday.machineTexture);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuCustomizePrimarySkinTextureHoliday message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setVisualFrameTexture(message.textureID);
	}
}

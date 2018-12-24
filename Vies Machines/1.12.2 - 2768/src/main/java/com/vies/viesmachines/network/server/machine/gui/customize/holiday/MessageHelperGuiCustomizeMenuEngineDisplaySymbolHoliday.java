package com.vies.viesmachines.network.server.machine.gui.customize.holiday;

import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday> {
	
	private int metaDisplayID;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVM.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplaySymbolHoliday message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		machine.setVisualEngineDisplayType(message.metaDisplayID);
		
		machine.setVisualEngineDisplayItemstack(0);
		machine.setVisualEngineDisplayItemstackMeta(0);
		machine.setVisualEngineDisplayHead(0);
		machine.setVisualEngineDisplaySupporterHead(0);
		machine.setVisualEngineDisplayHoliday(0);
	}
}

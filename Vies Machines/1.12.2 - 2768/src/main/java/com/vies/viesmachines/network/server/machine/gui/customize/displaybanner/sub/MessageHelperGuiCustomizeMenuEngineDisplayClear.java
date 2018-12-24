package com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayClear extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayClear> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayClear message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayClear message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		machine.setVisualEngineDisplayType(0);
		
		machine.setVisualEngineDisplayItemstack(0);
		machine.setVisualEngineDisplayItemstackMeta(0);
		machine.setVisualEngineDisplayHead(0);
		machine.setVisualEngineDisplaySupporterHead(0);
		machine.setVisualEngineDisplayHoliday(0);
	}
}

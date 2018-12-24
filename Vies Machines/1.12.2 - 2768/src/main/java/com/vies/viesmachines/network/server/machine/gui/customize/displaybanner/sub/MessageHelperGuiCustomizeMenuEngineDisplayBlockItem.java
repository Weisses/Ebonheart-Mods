package com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuEngineDisplayBlockItem extends MessageBase<MessageHelperGuiCustomizeMenuEngineDisplayBlockItem> {
	
	private int metaDisplayID;
	private int metaItemStack;
	private int metaItemStackMeta;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaDisplayID = buf.readInt();
		metaItemStack = buf.readInt();
		metaItemStackMeta = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVM.metaInfo);
		buf.writeInt(GuiContainerVM.itemstackInfo);
		buf.writeInt(GuiContainerVM.itemstackMetaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuEngineDisplayBlockItem message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machine.setVisualEngineDisplayType(message.metaDisplayID);
			machine.setVisualEngineDisplayItemstack(message.metaItemStack);
			machine.setVisualEngineDisplayItemstackMeta(message.metaItemStackMeta);
			
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
		}
		else if(message.metaDisplayID == 0)
		{
			machine.setVisualEngineDisplayType(0);

			machine.setVisualEngineDisplayItemstack(0);
			machine.setVisualEngineDisplayItemstackMeta(0);
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
		}
		else if (machine.getEnergy() >= CostsVM.COST_ENGINE_DISPLAY_SYMBOL)
		{
			machine.setVisualEngineDisplayType(message.metaDisplayID);
			machine.setVisualEngineDisplayItemstack(message.metaItemStack);
			machine.setVisualEngineDisplayItemstackMeta(message.metaItemStackMeta);
			
			machine.setVisualEngineDisplayHead(0);
			machine.setVisualEngineDisplaySupporterHead(0);
			machine.setVisualEngineDisplayHoliday(0);
			
			machine.setEnergy(machine.getEnergy() - CostsVM.COST_ENGINE_DISPLAY_SYMBOL);
		}
	}
}

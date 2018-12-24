package com.vies.viesmachines.network.server.machine.gui.main;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMain;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuMainCompress extends MessageBase<MessageHelperGuiMachineMenuMainCompress> {
	
	public static int machineID;
	private EntityMachineBase machine;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.machineID = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMain.machineId);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuMainCompress message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuMainCompress message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		message.machine = (EntityMachineBase) player.world.getEntityByID(message.machineID);
		
		machineIn.entityDropItem(machineIn.getItemMachine(), 1);
		
		NetworkHandler.sendToAll(new MessageHelperGuiMachineMenuMainCompressClientAll());
		
		machineIn.setEventTrigger(EnumsVM.EventTrigger.DESTRUCTION.getMetadata());
	}
}

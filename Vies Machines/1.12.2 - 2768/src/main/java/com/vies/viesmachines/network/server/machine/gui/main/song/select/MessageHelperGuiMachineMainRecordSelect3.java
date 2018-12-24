package com.vies.viesmachines.network.server.machine.gui.main.song.select;

import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.proxy.ClientProxy;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageHelperGuiMachineMainRecordSelect3 extends MessageBase<MessageHelperGuiMachineMainRecordSelect3> implements IMessage {
	
	private int setSong;
	private String selectedSong;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMainRecordSelect3 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMainRecordSelect3 message, EntityPlayer player) 
	{
		EntityMachineBase machine = (EntityMachineBase) player.getRidingEntity();
		
		this.selectedSong = machine.getLearnedRecordSlot3();
		
		for(int i = 0; i < ClientProxy.musicListRecord.size(); i++)
		{
			if(ClientProxy.musicListRecord.get(i).toString().toLowerCase().contains(selectedSong.toString().toLowerCase()))
		    {
				this.setSong = i;
		    }
		}
		
		machine.setSelectedRecord(this.setSong);
	}
}

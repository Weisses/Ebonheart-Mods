package com.vies.viesmachines.network.server.machine.gui.main.name;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectName;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageNameColor;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuChangeNameColor extends MessageBase<MessageHelperGuiMachineMenuChangeNameColor> {
	
	private int nameColor;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.nameColor = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMainSelectName.nameColor);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuChangeNameColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuChangeNameColor message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setVisualNameColor(message.nameColor);
			
			NetworkHandler.sendToServer(new PlayerMessageNameColor());
		}
		else
		{
			if(machineIn.getEnergy() >= CostsVM.COST_NAME_COLOR)
			{
				machineIn.setVisualNameColor(message.nameColor);
				
				machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_NAME_COLOR);
				
				NetworkHandler.sendToServer(new PlayerMessageNameColor());
			}
		}
	}
}

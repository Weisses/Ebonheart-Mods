package com.vies.viesmachines.network.server.machine.gui.main.name;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectName;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.world.menu.main.PlayerMessageNameColor;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;

public class MessageHelperGuiMachineMenuChangeName extends MessageBase<MessageHelperGuiMachineMenuChangeName> {
	
	private String customName;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.customName = ByteBufUtils.readUTF8String(buf);
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		ByteBufUtils.writeUTF8String(buf, GuiMachineMenuMainSelectName.textNameStorage);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuChangeName message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuChangeName message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		if (player.isCreative())
		{
			machineIn.setCustomNameTag(message.customName);
			
			NetworkHandler.sendToServer(new PlayerMessageNameColor());
		}
		else
		{
			if(machineIn.getEnergy() >= CostsVM.COST_NAME_CHANGE)
			{
				machineIn.setCustomNameTag(message.customName);
				
				machineIn.setEnergy(machineIn.getEnergy() - CostsVM.COST_NAME_CHANGE);
				
				NetworkHandler.sendToServer(new PlayerMessageNameColor());
			}
		}
	}
}

package com.vies.viesmachines.network.server.world.menu.main;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class PlayerMessageNameColor extends MessageBase<PlayerMessageNameColor> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(PlayerMessageNameColor message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(PlayerMessageNameColor message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		player.sendMessage(new TextComponentString(References.Old_I18n.translateToLocalFormatted("viesmachines.message.nameandcolor.0") + " : " + 
				EnumsVM.SelectColor.byId(machineIn.getVisualNameColor()).getTextColor()
				+ machineIn.getCustomNameTag()));
	}
}

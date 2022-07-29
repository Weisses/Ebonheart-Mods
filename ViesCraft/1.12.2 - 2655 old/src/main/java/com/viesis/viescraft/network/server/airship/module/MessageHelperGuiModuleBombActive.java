package com.viesis.viescraft.network.server.airship.module;

import com.viesis.viescraft.client.gui.airship.main.GuiMainMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.packet.MessageBase;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusicArea;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.NetworkRegistry.TargetPoint;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageHelperGuiModuleBombActive extends MessageBase<MessageHelperGuiModuleBombActive> implements IMessage {
	
	static int bombTypeActive;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		bombTypeActive = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMainMenu.bombTypeActive);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiModuleBombActive message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiModuleBombActive message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.bombTypeActive = message.bombTypeActive;
	}
}

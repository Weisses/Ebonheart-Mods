package com.viesis.viescraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageTest extends MessageBase<MessageTest> {

	@Override
	public void fromBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
		
	}

	@Override
	public void handleClientSide(MessageTest message, EntityPlayer player) {
		
		
	}

	@Override
	public void handleServerSide(MessageTest message, EntityPlayer player) {
		player.worldObj.createExplosion(player, player.posX, player.posY, player.posZ, 3.0F, true);
		
	}
	
	
	
	
	
	
	
	
}
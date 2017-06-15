package com.ebonheart.EbonArtsMod.network.packets;

import io.netty.buffer.ByteBuf;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class EAPacket implements IMessage {

	private String message;

	public EAPacket() {}

	public EAPacket(String message) {
		this.message = message;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.message = ByteBufUtils.readUTF8String(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		ByteBufUtils.writeUTF8String(buf, this.message);
	}

	// =========================================================================

	//public static class Handler extends MessageHandler.Server<EAPacket> {

	//	@Override
	//	public IMessage handleServerMessage(EntityPlayer player, final EAPacket msg, MessageContext ctx) {
	//		ServerUtils.addScheduledTask(new Runnable() {
	//			@Override public void run() {
	//				ServerUtils.mc().getConfigurationManager().sendChatMsg(new ChatComponentText(msg.message));
	//			}
	//		});
	//		return null;
	//	}
	//}
}
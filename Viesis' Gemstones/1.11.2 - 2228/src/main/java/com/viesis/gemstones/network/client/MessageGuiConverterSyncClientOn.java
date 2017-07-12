package com.viesis.gemstones.network.client;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.network.packet.MessageBase;
import com.viesis.gemstones.network.server.MessageGuiConverterSyncServerOn;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiConverterSyncClientOn extends MessageBase<MessageGuiConverterSyncClientOn> {
	
	private boolean metaOn;
	private int metaPosX;
	private int metaPosY;
	private int metaPosZ;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaOn = buf.readBoolean();
		metaPosX = buf.readInt();
		metaPosY = buf.readInt();
		metaPosZ = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(MessageGuiConverterSyncServerOn.metaOn);
		buf.writeInt(MessageGuiConverterSyncServerOn.metaPosX);
		buf.writeInt(MessageGuiConverterSyncServerOn.metaPosY);
		buf.writeInt(MessageGuiConverterSyncServerOn.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiConverterSyncClientOn message, EntityPlayer player) 
	{
		TileEntityGemstoneConverter workbench = (TileEntityGemstoneConverter) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
	}
	
	@Override
	public void handleServerSide(MessageGuiConverterSyncClientOn message, EntityPlayer player) 
	{
		
	}
}

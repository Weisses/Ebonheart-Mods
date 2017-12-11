package com.viesis.gemstones.network.client;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.network.packet.MessageBase;
import com.viesis.gemstones.network.server.MessageGuiConverterSyncServerGem;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiConverterSyncClientGem extends MessageBase<MessageGuiConverterSyncClientGem> {
	
	private int metaGem;
	private int metaPosX;
	private int metaPosY;
	private int metaPosZ;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaGem = buf.readInt();
		metaPosX = buf.readInt();
		metaPosY = buf.readInt();
		metaPosZ = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageGuiConverterSyncServerGem.metaGem);
		buf.writeInt(MessageGuiConverterSyncServerGem.metaPosX);
		buf.writeInt(MessageGuiConverterSyncServerGem.metaPosY);
		buf.writeInt(MessageGuiConverterSyncServerGem.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiConverterSyncClientGem message, EntityPlayer player) 
	{
		TileEntityGemstoneConverter workbench = (TileEntityGemstoneConverter) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.gemstoneMeta = message.metaGem;
		workbench.cutTime = 0;
	}
	
	@Override
	public void handleServerSide(MessageGuiConverterSyncClientGem message, EntityPlayer player) 
	{
		
	}
}

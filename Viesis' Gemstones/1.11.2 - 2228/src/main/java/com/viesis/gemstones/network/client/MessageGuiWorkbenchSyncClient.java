package com.viesis.gemstones.network.client;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.packet.MessageBase;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchSyncServer;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiWorkbenchSyncClient extends MessageBase<MessageGuiWorkbenchSyncClient> {
	
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
		buf.writeInt(MessageGuiWorkbenchSyncServer.metaGem);
		buf.writeInt(MessageGuiWorkbenchSyncServer.metaPosX);
		buf.writeInt(MessageGuiWorkbenchSyncServer.metaPosY);
		buf.writeInt(MessageGuiWorkbenchSyncServer.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSyncClient message, EntityPlayer player) 
	{
		TileEntityGemstoneWorkbench workbench = (TileEntityGemstoneWorkbench) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.gemstoneMeta = message.metaGem;
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSyncClient message, EntityPlayer player) 
	{
		
	}
}

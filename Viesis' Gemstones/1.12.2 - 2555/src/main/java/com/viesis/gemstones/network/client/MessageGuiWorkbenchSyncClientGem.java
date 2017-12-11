package com.viesis.gemstones.network.client;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.packet.MessageBase;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchSyncServerGem;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiWorkbenchSyncClientGem extends MessageBase<MessageGuiWorkbenchSyncClientGem> {
	
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
		buf.writeInt(MessageGuiWorkbenchSyncServerGem.metaGem);
		buf.writeInt(MessageGuiWorkbenchSyncServerGem.metaPosX);
		buf.writeInt(MessageGuiWorkbenchSyncServerGem.metaPosY);
		buf.writeInt(MessageGuiWorkbenchSyncServerGem.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSyncClientGem message, EntityPlayer player) 
	{
		TileEntityGemstoneWorkbench workbench = (TileEntityGemstoneWorkbench) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.gemstoneMeta = message.metaGem;
		workbench.cutTime = 0;
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSyncClientGem message, EntityPlayer player) 
	{
		
	}
}

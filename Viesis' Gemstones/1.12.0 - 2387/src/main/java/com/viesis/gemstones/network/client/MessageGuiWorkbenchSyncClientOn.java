package com.viesis.gemstones.network.client;

import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.packet.MessageBase;
import com.viesis.gemstones.network.server.MessageGuiWorkbenchSyncServerOn;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiWorkbenchSyncClientOn extends MessageBase<MessageGuiWorkbenchSyncClientOn> {
	
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
		buf.writeBoolean(MessageGuiWorkbenchSyncServerOn.metaOn);
		buf.writeInt(MessageGuiWorkbenchSyncServerOn.metaPosX);
		buf.writeInt(MessageGuiWorkbenchSyncServerOn.metaPosY);
		buf.writeInt(MessageGuiWorkbenchSyncServerOn.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSyncClientOn message, EntityPlayer player) 
	{
		TileEntityGemstoneWorkbench workbench = (TileEntityGemstoneWorkbench) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSyncClientOn message, EntityPlayer player) 
	{
		
	}
}

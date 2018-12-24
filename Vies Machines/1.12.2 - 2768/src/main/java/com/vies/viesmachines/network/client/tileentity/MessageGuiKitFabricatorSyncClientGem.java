package com.vies.viesmachines.network.client.tileentity;

import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.network.packet.MessageBase;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerGem;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiKitFabricatorSyncClientGem extends MessageBase<MessageGuiKitFabricatorSyncClientGem> {
	
	private int metaItem;
	private int metaPosX;
	private int metaPosY;
	private int metaPosZ;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.metaItem = buf.readInt();
		this.metaPosX = buf.readInt();
		this.metaPosY = buf.readInt();
		this.metaPosZ = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(MessageGuiKitFabricatorSyncServerGem.metaItem);
		buf.writeInt(MessageGuiKitFabricatorSyncServerGem.metaPosX);
		buf.writeInt(MessageGuiKitFabricatorSyncServerGem.metaPosY);
		buf.writeInt(MessageGuiKitFabricatorSyncServerGem.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiKitFabricatorSyncClientGem message, EntityPlayer player) 
	{
		TileEntityKitFabricator workbench = (TileEntityKitFabricator) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.itemToFindMeta = message.metaItem;
		workbench.processTime = 0;
	}
	
	@Override
	public void handleServerSide(MessageGuiKitFabricatorSyncClientGem message, EntityPlayer player) 
	{
		
	}
}

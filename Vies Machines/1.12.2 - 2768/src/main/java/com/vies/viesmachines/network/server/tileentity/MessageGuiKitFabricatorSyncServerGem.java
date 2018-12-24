package com.vies.viesmachines.network.server.tileentity;

import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientGem;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiKitFabricatorSyncServerGem extends MessageBase<MessageGuiKitFabricatorSyncServerGem> {
	
	public static int metaItem;
	public static int metaPosX;
	public static int metaPosY;
	public static int metaPosZ;
	
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
		buf.writeInt(GuiTileEntityKitFabricator.metaItem);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosX);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosY);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiKitFabricatorSyncServerGem message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiKitFabricatorSyncServerGem message, EntityPlayer player) 
	{
		TileEntityKitFabricator workbench = (TileEntityKitFabricator) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.itemToFindMeta = message.metaItem;
		workbench.processTime = 0;
		workbench.serializeNBT().setInteger("ItemToFindMeta", message.metaItem);
		
		NetworkHandler.sendToAll(new MessageGuiKitFabricatorSyncClientGem());
	}
}

package com.vies.viesmachines.network.server.tileentity;

import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.client.tileentity.MessageGuiKitFabricatorSyncClientOn;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiKitFabricatorSyncServerOn extends MessageBase<MessageGuiKitFabricatorSyncServerOn> {
	
	public static boolean metaOn;
	public static int metaPosX;
	public static int metaPosY;
	public static int metaPosZ;
	
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
		buf.writeBoolean(GuiTileEntityKitFabricator.metaOn);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosX);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosY);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiKitFabricatorSyncServerOn message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiKitFabricatorSyncServerOn message, EntityPlayer player) 
	{
		TileEntityKitFabricator workbench = (TileEntityKitFabricator) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.isOn = message.metaOn;
		workbench.serializeNBT().setBoolean("IsOn", message.metaOn);
		
		NetworkHandler.sendToAll(new MessageGuiKitFabricatorSyncClientOn());
	}
}

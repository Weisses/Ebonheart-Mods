package com.vies.viesmachines.network.server.tileentity;

import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.client.tileentity.MessageGuiExtractorSyncClientOn;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiExtractorSyncServerOn extends MessageBase<MessageGuiExtractorSyncServerOn> {
	
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
		buf.writeBoolean(GuiTileEntityExtractor.metaOn);
		buf.writeInt(GuiTileEntityExtractor.metaPosX);
		buf.writeInt(GuiTileEntityExtractor.metaPosY);
		buf.writeInt(GuiTileEntityExtractor.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiExtractorSyncServerOn message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiExtractorSyncServerOn message, EntityPlayer player) 
	{
		TileEntityExtractor workbench = (TileEntityExtractor) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
		workbench.serializeNBT().setBoolean("IsOn", message.metaOn);
		NetworkHandler.sendToAll(new MessageGuiExtractorSyncClientOn());
	}
}

package com.viesis.gemstones.network.server;

import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneConverterMain;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.network.NetworkHandler;
import com.viesis.gemstones.network.client.MessageGuiConverterSyncClientOn;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiConverterSyncServerOn extends MessageBase<MessageGuiConverterSyncServerOn> {
	
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
		buf.writeBoolean(GuiTileEntityGemstoneConverterMain.metaOn);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosX);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosY);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiConverterSyncServerOn message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiConverterSyncServerOn message, EntityPlayer player) 
	{
		TileEntityGemstoneConverter workbench = (TileEntityGemstoneConverter) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
		workbench.serializeNBT().setBoolean("IsOn", message.metaOn);
		NetworkHandler.sendToAll(new MessageGuiConverterSyncClientOn());
	}
}

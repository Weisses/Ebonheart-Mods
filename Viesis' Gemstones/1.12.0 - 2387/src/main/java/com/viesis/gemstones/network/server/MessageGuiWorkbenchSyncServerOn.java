package com.viesis.gemstones.network.server;

import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneWorkbenchMain;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.NetworkHandler;
import com.viesis.gemstones.network.client.MessageGuiWorkbenchSyncClientOn;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiWorkbenchSyncServerOn extends MessageBase<MessageGuiWorkbenchSyncServerOn> {
	
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
		buf.writeBoolean(GuiTileEntityGemstoneWorkbenchMain.metaOn);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosX);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosY);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSyncServerOn message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSyncServerOn message, EntityPlayer player) 
	{
		TileEntityGemstoneWorkbench workbench = (TileEntityGemstoneWorkbench) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
		workbench.serializeNBT().setBoolean("IsOn", message.metaOn);
		NetworkHandler.sendToAll(new MessageGuiWorkbenchSyncClientOn());
	}
}

package com.viesis.gemstones.network.server;

import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneWorkbenchMain;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;
import com.viesis.gemstones.network.NetworkHandler;
import com.viesis.gemstones.network.client.MessageGuiWorkbenchSyncClientGem;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiWorkbenchSyncServerGem extends MessageBase<MessageGuiWorkbenchSyncServerGem> {
	
	public static int metaGem;
	public static int metaPosX;
	public static int metaPosY;
	public static int metaPosZ;
	
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
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaGem);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosX);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosY);
		buf.writeInt(GuiTileEntityGemstoneWorkbenchMain.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiWorkbenchSyncServerGem message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiWorkbenchSyncServerGem message, EntityPlayer player) 
	{
		TileEntityGemstoneWorkbench workbench = (TileEntityGemstoneWorkbench) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.gemstoneMeta = message.metaGem;
		workbench.cutTime = 0;
		workbench.serializeNBT().setInteger("GemstoneMeta", message.metaGem);
		
		NetworkHandler.sendToAll(new MessageGuiWorkbenchSyncClientGem());
	}
}

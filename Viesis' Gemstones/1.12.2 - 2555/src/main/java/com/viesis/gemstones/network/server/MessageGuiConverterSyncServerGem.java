package com.viesis.gemstones.network.server;

import com.viesis.gemstones.client.gui.workbench.GuiTileEntityGemstoneConverterMain;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.network.NetworkHandler;
import com.viesis.gemstones.network.client.MessageGuiConverterSyncClientGem;
import com.viesis.gemstones.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiConverterSyncServerGem extends MessageBase<MessageGuiConverterSyncServerGem> {
	
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
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaGem);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosX);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosY);
		buf.writeInt(GuiTileEntityGemstoneConverterMain.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiConverterSyncServerGem message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiConverterSyncServerGem message, EntityPlayer player) 
	{
		TileEntityGemstoneConverter workbench = (TileEntityGemstoneConverter) player.world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		
		workbench.gemstoneMeta = message.metaGem;
		workbench.cutTime = 0;
		workbench.serializeNBT().setInteger("GemstoneMeta", message.metaGem);
		
		NetworkHandler.sendToAll(new MessageGuiConverterSyncClientGem());
	}
}

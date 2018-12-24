package com.vies.viesmachines.network.client.tileentity;

import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityExtractor;
import com.vies.viesmachines.common.tileentity.TileEntityExtractor;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiExtractorSyncClientOn extends MessageBase<MessageGuiExtractorSyncClientOn> {
	
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
		buf.writeBoolean(GuiTileEntityExtractor.metaOn);
		buf.writeInt(GuiTileEntityExtractor.metaPosX);
		buf.writeInt(GuiTileEntityExtractor.metaPosY);
		buf.writeInt(GuiTileEntityExtractor.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiExtractorSyncClientOn message, EntityPlayer player) 
	{
		TileEntityExtractor workbench = (TileEntityExtractor) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
	}
	
	@Override
	public void handleServerSide(MessageGuiExtractorSyncClientOn message, EntityPlayer player) 
	{
		
	}
}

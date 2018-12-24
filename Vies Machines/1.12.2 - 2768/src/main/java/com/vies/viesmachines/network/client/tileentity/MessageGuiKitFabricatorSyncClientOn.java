package com.vies.viesmachines.network.client.tileentity;

import com.vies.viesmachines.client.gui.tileentity.GuiTileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;

public class MessageGuiKitFabricatorSyncClientOn extends MessageBase<MessageGuiKitFabricatorSyncClientOn> {
	
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
		buf.writeBoolean(GuiTileEntityKitFabricator.metaOn);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosX);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosY);
		buf.writeInt(GuiTileEntityKitFabricator.metaPosZ);
	}
	
	@Override
	public void handleClientSide(MessageGuiKitFabricatorSyncClientOn message, EntityPlayer player) 
	{
		TileEntityKitFabricator workbench = (TileEntityKitFabricator) Minecraft.getMinecraft().world.getTileEntity(new BlockPos(message.metaPosX, message.metaPosY, message.metaPosZ));
		workbench.isOn = message.metaOn;
	}
	
	@Override
	public void handleServerSide(MessageGuiKitFabricatorSyncClientOn message, EntityPlayer player) 
	{
		
	}
}

package com.viesis.viescraft.network.server.airship.visual.undobuttons;

import com.viesis.viescraft.client.gui.airship.main.GuiVisualMenu;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuUndoFrame1 extends MessageBase<MessageHelperGuiVisualMenuUndoFrame1> {
	
	private boolean metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiVisualMenu.undoFrame1);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuUndoFrame1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuUndoFrame1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaFrameVisualTransparent = message.metaFrame;
	}
}

package com.viesis.viescraft.network.server.airship.visual.undobuttons;

import com.viesis.viescraft.client.gui.airship.main.GuiCustomizeMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuUndoFrame3 extends MessageBase<MessageHelperGuiVisualMenuUndoFrame3> {
	
	private boolean metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiCustomizeMenu.undoFrame3);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuUndoFrame3 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuUndoFrame3 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.frameSkinVisualColor = message.metaFrame;
		airship.frameSkinColorRed = 0;
		airship.frameSkinColorGreen = 0;
		airship.frameSkinColorBlue = 0;
	}
}

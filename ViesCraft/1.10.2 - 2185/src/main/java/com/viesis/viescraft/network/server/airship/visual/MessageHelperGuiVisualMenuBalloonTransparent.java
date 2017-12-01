package com.viesis.viescraft.network.server.airship.visual;

import com.viesis.viescraft.client.gui.airship.main.GuiVisualMenu;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuBalloonTransparent extends MessageBase<MessageHelperGuiVisualMenuBalloonTransparent> {
	
	private boolean metaBalloonTransparent;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloonTransparent = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiVisualMenu.metaBalloonTransparentInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuBalloonTransparent message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuBalloonTransparent message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaBalloonVisualTransparent = message.metaBalloonTransparent;
	}
}

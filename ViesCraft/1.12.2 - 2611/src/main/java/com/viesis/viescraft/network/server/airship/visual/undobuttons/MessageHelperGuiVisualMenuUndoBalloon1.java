package com.viesis.viescraft.network.server.airship.visual.undobuttons;

import com.viesis.viescraft.client.gui.airship.main.GuiVisualMenu;
import com.viesis.viescraft.client.gui.airship.visual.balloon.GuiVisualMenuBalloonTier1Pg1;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiVisualMenuUndoBalloon1 extends MessageBase<MessageHelperGuiVisualMenuUndoBalloon1> {
	
	private boolean metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readBoolean();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeBoolean(GuiVisualMenu.undoBalloon1);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiVisualMenuUndoBalloon1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiVisualMenuUndoBalloon1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaBalloonVisualTransparent = message.metaBalloon;
	}
}

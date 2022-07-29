package com.viesis.viescraft.network.server.airship.customize.balloon.sub;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageGuiCustomizeMenuBalloonTier5Pg1 extends MessageBase<MessageGuiCustomizeMenuBalloonTier5Pg1> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiCustomizeMenuBalloonTier5Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiCustomizeMenuBalloonTier5Pg1 message, EntityPlayer player) 
	{
		player.openGui(ViesCraft.instance, GuiHandler.GUI_APPEARANCE_MENU_BALLOON_TIER5_PG1, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}

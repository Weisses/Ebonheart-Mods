package com.viesis.viescraft.network.server.airship.customize.balloon;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.client.gui.airship.customize.balloon.GuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonColorDefault extends MessageBase<MessageHelperGuiCustomizeMenuBalloonColorDefault> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonColorDefault message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonColorDefault message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.balloonPatternColor = false;
		airship.balloonPatternColorRed = 200;
		airship.balloonPatternColorGreen = 180;
		airship.balloonPatternColorBlue = 140;
	}
}

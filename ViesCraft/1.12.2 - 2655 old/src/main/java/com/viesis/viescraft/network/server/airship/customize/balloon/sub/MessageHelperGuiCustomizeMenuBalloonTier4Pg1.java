package com.viesis.viescraft.network.server.airship.customize.balloon.sub;

import com.viesis.viescraft.client.gui.airship.customize.balloon.sub.GuiCustomizeMenuBalloonTier4Pg1;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuBalloonTier4Pg1 extends MessageBase<MessageHelperGuiCustomizeMenuBalloonTier4Pg1> {
	
	private int metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiCustomizeMenuBalloonTier4Pg1.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuBalloonTier4Pg1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuBalloonTier4Pg1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.balloonPatternTexture = message.metaBalloon;
	}
}

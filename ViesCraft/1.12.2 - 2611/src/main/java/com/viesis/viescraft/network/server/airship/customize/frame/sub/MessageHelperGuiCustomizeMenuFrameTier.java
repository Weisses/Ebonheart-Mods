package com.viesis.viescraft.network.server.airship.customize.frame.sub;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuFrameTier extends MessageBase<MessageHelperGuiCustomizeMenuFrameTier> {
	
	private int metaFrame;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaFrame = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuFrameTier message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuFrameTier message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_TEXTURE_COST
		&& message.metaFrame != 0
		&& message.metaFrame != airship.frameSkinTexture)
		{
			airship.frameSkinTexture = message.metaFrame;
			airship.storedRedstone = airship.storedRedstone - CostsVC.FRAME_SKIN_TEXTURE_COST;
		}
		
		if(message.metaFrame == 0)
		{
			airship.frameSkinTexture = message.metaFrame;
		}
	}
}

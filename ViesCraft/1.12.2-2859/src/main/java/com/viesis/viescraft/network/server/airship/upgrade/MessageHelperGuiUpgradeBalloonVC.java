package com.viesis.viescraft.network.server.airship.upgrade;

import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiUpgradeBalloonVC extends MessageBase<MessageHelperGuiUpgradeBalloonVC> {
	
	private int metaBalloon;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaBalloon = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiUpgradeBalloonVC message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiUpgradeBalloonVC message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.mainTierBalloon = message.metaBalloon;
		airship.inventory.extractItem(4, 1, false);
	}
}

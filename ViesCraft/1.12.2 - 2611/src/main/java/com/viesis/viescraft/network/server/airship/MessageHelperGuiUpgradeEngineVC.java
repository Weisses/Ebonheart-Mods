package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.client.gui.airship.main.GuiUpgradeMenu;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiUpgradeEngineVC extends MessageBase<MessageHelperGuiUpgradeEngineVC> {
	
	private int metaEngine;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaEngine = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiUpgradeMenu.metaUpgradeInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiUpgradeEngineVC message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiUpgradeEngineVC message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaTierEngine = message.metaEngine;
		airship.inventory.extractItem(3, 1, false);
	}
}

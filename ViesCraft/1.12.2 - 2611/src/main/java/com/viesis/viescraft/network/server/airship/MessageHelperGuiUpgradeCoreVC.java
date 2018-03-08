package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.client.gui.airship.main.GuiUpgradeMenu;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiUpgradeCoreVC extends MessageBase<MessageHelperGuiUpgradeCoreVC> {
	
	private int metaCore;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaCore = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiUpgradeMenu.metaUpgradeInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiUpgradeCoreVC message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiUpgradeCoreVC message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		airship.metaTierCore = message.metaCore;
		airship.inventory.extractItem(1, 1, false);
	}
}

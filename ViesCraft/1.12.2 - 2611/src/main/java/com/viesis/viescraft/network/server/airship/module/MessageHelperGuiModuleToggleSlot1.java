package com.viesis.viescraft.network.server.airship.module;

import com.viesis.viescraft.client.gui.airship.main.GuiModuleMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiModuleToggleSlot1 extends MessageBase<MessageHelperGuiModuleToggleSlot1> {
	
	private int metaToggleModule;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaToggleModule = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiModuleMenu.toggleModule);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiModuleToggleSlot1 message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiModuleToggleSlot1 message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.metaModuleVariantSlot1 = message.metaToggleModule;
	}
}

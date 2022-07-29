package com.viesis.viescraft.network.server.airship.customize.core.sub;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiCustomizeMenuCoreModelEngine extends MessageBase<MessageHelperGuiCustomizeMenuCoreModelEngine> {
	
	private int metaCore;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaCore = buf.readInt();
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiContainerVC.metaInfo);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiCustomizeMenuCoreModelEngine message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiCustomizeMenuCoreModelEngine message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		if(airship.getStoredRedstone() >= CostsVC.CORE_MODEL_ENGINE_COST
		&& message.metaCore != 0
		&& message.metaCore != airship.coreModelVisualEngine)
		{
			airship.coreModelVisualEngine = message.metaCore;
			airship.storedRedstone = airship.storedRedstone - CostsVC.CORE_MODEL_ENGINE_COST;
		}
		
		if(message.metaCore == 0)
		{
			airship.coreModelVisualEngine = message.metaCore;
		}
	}
}

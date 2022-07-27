package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.common.entity.EntityBombBig;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageDropBombBig extends MessageBase<MessageDropBombBig> implements IMessage {
	
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageDropBombBig message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageDropBombBig message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		EntityBombBig entitybomb = new EntityBombBig(airship.world, airship.posX, airship.posY - 1.25D, airship.posZ);
		
		airship.world.spawnEntity(entitybomb);
		airship.storedBombType2 = airship.storedBombType2 - 1;
		airship.canDropBomb = false;
	}
}

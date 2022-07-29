package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.common.entity.EntityBombScatter;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageDropBombScatter extends MessageBase<MessageDropBombScatter> implements IMessage {
	
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageDropBombScatter message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageDropBombScatter message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		EntityBombScatter entitybomb = new EntityBombScatter(airship.world, airship.posX, airship.posY - 1.25D, airship.posZ);
		
		airship.world.spawnEntity(entitybomb);
		airship.storedBombType3 = airship.storedBombType3 - 1;
		airship.canDropBomb = false;
	}
}

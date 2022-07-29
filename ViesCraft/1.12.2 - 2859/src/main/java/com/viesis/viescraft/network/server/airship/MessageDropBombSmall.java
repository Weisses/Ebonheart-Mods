package com.viesis.viescraft.network.server.airship;

import com.viesis.viescraft.common.entity.EntityBombSmall;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class MessageDropBombSmall extends MessageBase<MessageDropBombSmall> implements IMessage {
	
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageDropBombSmall message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageDropBombSmall message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		EntityBombSmall entitybomb = new EntityBombSmall(airship.world, airship.posX, airship.posY - 1.25D, airship.posZ);
		
		airship.world.spawnEntity(entitybomb);
		airship.storedBombType1 = airship.storedBombType1 - 1;
		airship.canDropBomb = false;
	}
}

package com.vies.viesmachines.network.server.machine.gui.main.projectile;

import com.vies.viesmachines.client.gui.machines.main.GuiMachineMenuMainSelectProjectile;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiMachineMenuSelectProjectileBulletConsume extends MessageBase<MessageHelperGuiMachineMenuSelectProjectileBulletConsume> {
	
	private int ammoToApply;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		this.ammoToApply = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiMachineMenuMainSelectProjectile.ammoToApply);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiMachineMenuSelectProjectileBulletConsume message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiMachineMenuSelectProjectileBulletConsume message, EntityPlayer player) 
	{
		EntityMachineBase machineIn = (EntityMachineBase) player.getRidingEntity();
		
		machineIn.setAmmoAmount(machineIn.getAmmoAmount() + message.ammoToApply);
		machineIn.inventory.extractItem(1, message.ammoToApply, false);
	}
}

package com.vies.viesmachines.network.server.item;

import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.misc.GuiRadioExpansionSelectMusic;
import com.vies.viesmachines.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageHelperItemToolRadioExpansion extends MessageBase<MessageHelperItemToolRadioExpansion> {
	
	private int songId;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		songId = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiRadioExpansionSelectMusic.setSong);
	}
	
	@Override
	public void handleClientSide(MessageHelperItemToolRadioExpansion message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperItemToolRadioExpansion message, EntityPlayer player) 
	{
		ItemStack stack = player.getHeldItemMainhand();
        
		stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger(References.TOOL_RECORD_TO_ADD_TAG, message.songId);
	}
}

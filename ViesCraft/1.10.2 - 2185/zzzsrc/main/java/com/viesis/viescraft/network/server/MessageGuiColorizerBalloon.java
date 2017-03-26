package com.viesis.viescraft.network.server;

import com.viesis.viescraft.client.gui.GuiItemBalloonColorizer;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageGuiColorizerBalloon extends MessageBase<MessageGuiColorizerBalloon> {
	
	private int colorRed;
	private int colorGreen;
	private int colorBlue;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		colorRed = buf.readInt();
		colorGreen = buf.readInt();
		colorBlue = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiItemBalloonColorizer.textRedNumber);
		buf.writeInt(GuiItemBalloonColorizer.textGreenNumber);
		buf.writeInt(GuiItemBalloonColorizer.textBlueNumber);
	}
	
	@Override
	public void handleClientSide(MessageGuiColorizerBalloon message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageGuiColorizerBalloon message, EntityPlayer player) 
	{
		ItemStack stack = player.getHeldItemMainhand();
        
		stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger("ColorRed", message.colorRed);
    	stack.getTagCompound().setInteger("ColorGreen", message.colorGreen);
    	stack.getTagCompound().setInteger("ColorBlue", message.colorBlue);
	}
}

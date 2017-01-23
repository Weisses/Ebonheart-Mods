package com.viesis.viescraft.network.server;

import com.viesis.viescraft.client.gui.GuiItemBalloonColorizer;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class MessageGuiColorizerBalloon extends MessageBase<MessageGuiColorizerBalloon> {
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		
	}
	
	@Override
	public void handleClientSide(MessageGuiColorizerBalloon message, EntityPlayer player) 
	{
		ItemStack stack = player.getHeldItemMainhand();
        
		stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setInteger("ColorRed", GuiItemBalloonColorizer.textRedNumber);
    	stack.getTagCompound().setInteger("ColorGreen", GuiItemBalloonColorizer.textGreenNumber);
    	stack.getTagCompound().setInteger("ColorBlue", GuiItemBalloonColorizer.textBlueNumber);
	}
	
	@Override
	public void handleServerSide(MessageGuiColorizerBalloon message, EntityPlayer player) 
	{
		//player.openGui(ViesCraft.instance, GuiHandler.GUI_COLORIZER_BALLOON, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}

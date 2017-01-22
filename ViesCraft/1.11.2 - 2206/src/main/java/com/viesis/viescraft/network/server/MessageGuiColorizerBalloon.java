package com.viesis.viescraft.network.server;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.client.gui.GuiItemBalloonColorizer;
import com.viesis.viescraft.common.items.parts.ItemColorizerBalloon;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.packet.MessageBase;

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
		
	}
	
	@Override
	public void handleServerSide(MessageGuiColorizerBalloon message, EntityPlayer player) 
	{
		ItemStack stack = player.getHeldItemMainhand();
        
		stack.setTagCompound(new NBTTagCompound());
    	
    	stack.getTagCompound().setFloat("ColorRed", GuiItemBalloonColorizer.textRedNumber);
    	stack.getTagCompound().setFloat("ColorGreen", GuiItemBalloonColorizer.textGreenNumber);
    	stack.getTagCompound().setFloat("ColorBlue", GuiItemBalloonColorizer.textBlueNumber);
    	
		
		//player.openGui(ViesCraft.instance, GuiHandler.GUI_COLORIZER_BALLOON, player.world, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
	}
}

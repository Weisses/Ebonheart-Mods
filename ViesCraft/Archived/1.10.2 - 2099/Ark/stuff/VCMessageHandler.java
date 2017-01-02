package com.viesis.viescraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class VCMessageHandler implements IMessage {
	
	private String text;

    public VCMessageHandler() { }

    public VCMessageHandler(String text) 
    {
        this.text = text;
    }

    @Override
    public void fromBytes(ByteBuf buf) 
    {
        text = ByteBufUtils.readUTF8String(buf); // this class is very useful in general for writing more complex objects
    }

    @Override
    public void toBytes(ByteBuf buf) 
    {
        ByteBufUtils.writeUTF8String(buf, text);
    }
	
	
	
	
	
}

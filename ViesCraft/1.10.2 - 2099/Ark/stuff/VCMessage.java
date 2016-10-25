package com.viesis.viescraft.network;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class VCMessage implements IMessage {
	
	private String text;

    public VCMessage() { }

    public VCMessage(String text) 
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
	
    public static class Handler implements IMessageHandler<VCMessage, IMessage> {
        
        //@Override
        //public IMessage onMessage(VCMessage message, MessageContext ctx) {
        //    System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
        //    return null; // no response in this case
        //}

        // or in 1.8:
        @Override
        public IMessage onMessage(final VCMessage message, final MessageContext ctx) 
        {
            IThreadListener mainThread = (WorldServer) ctx.getServerHandler().playerEntity.worldObj; // or Minecraft.getMinecraft() on the client
            mainThread.addScheduledTask(new Runnable() 
            {
                @Override
                public void run() 
                {
                    System.out.println(String.format("Received %s from %s", message.text, ctx.getServerHandler().playerEntity.getDisplayName()));
                }
            });
            return null; // no response in this case
        }
    }
}
	
	
	


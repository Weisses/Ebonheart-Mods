package com.viesis.viescraft.network.test;

import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class SMessageHandlerTestDummy implements IMessageHandler<CMessageIMessageTest, IMessage>
{
  public IMessage onMessage(final CMessageIMessageTest message, MessageContext ctx) {
    System.err.println("CMessageIMessageTest received on wrong side:" + ctx.side);
    return null;
  }
}
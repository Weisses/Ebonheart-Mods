package com.viesis.viescraft.network.test;

import java.security.Security;

import com.viesis.viescraft.api.util.LogHelper;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.API;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class CMessageIMessageTest implements IMessage
{
  public CMessageIMessageTest(Vec3d i_targetCoordinates)
  {
    targetCoordinates = i_targetCoordinates;
    messageIsValid = true;
  }

  public Vec3d getTargetCoordinates() {
    return targetCoordinates;
  }

  public boolean isMessageValid() {
    return messageIsValid;
  }

  // for use by the message handler only.
  public CMessageIMessageTest()
  {
    messageIsValid = false;
  }

  /**
   * Called by the network code once it has received the message bytes over the network.
   * Used to read the ByteBuf contents into your member variables
   * @param buf
   */
  @Override
  public void fromBytes(ByteBuf buf)
  {
    try {
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      targetCoordinates = new Vec3d(x, y, z);

      // these methods may also be of use for your code:
      // for Itemstacks - ByteBufUtils.readItemStack()
      // for NBT tags ByteBufUtils.readTag();
      // for Strings: ByteBufUtils.readUTF8String();

    } catch (IndexOutOfBoundsException ioe) {
      System.err.println("Exception while reading ActualThing: " + ioe);
      return;
    }
    LogHelper.info("Client - " + targetCoordinates);
    messageIsValid = true;
  }

  /**
   * Called by the network code.
   * Used to write the contents of your message member variables into the ByteBuf, ready for transmission over the network.
   * @param buf
   */
  @Override
  public void toBytes(ByteBuf buf)
  {
    if (!messageIsValid) return;
    buf.writeDouble(targetCoordinates.xCoord);
    buf.writeDouble(targetCoordinates.yCoord);
    buf.writeDouble(targetCoordinates.zCoord);

    // these methods may also be of use for your code:
    // for Itemstacks - ByteBufUtils.writeItemStack()
    // for NBT tags ByteBufUtils.writeTag();
    // for Strings: ByteBufUtils.writeUTF8String();
    System.out.println("ActualThing:toBytes length=" + buf.readableBytes());  // debugging only
  }

  @Override
  public String toString()
  {
    return "ActualThing[targetCoordinates=" + String.valueOf(targetCoordinates) + "]";
  }

  private Vec3d targetCoordinates;
  private boolean messageIsValid;
}

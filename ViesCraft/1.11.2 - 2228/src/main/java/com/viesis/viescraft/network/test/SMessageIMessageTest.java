package com.viesis.viescraft.network.test;

import io.netty.buffer.ByteBuf;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class SMessageIMessageTest implements IMessage {

  public SMessageIMessageTest(Projectile i_projectile, Vec3d i_targetCoordinates)
  {
    projectile = i_projectile;
    targetCoordinates = i_targetCoordinates;
    messageIsValid = true;
  }

  public Vec3d getTargetCoordinates() {
    return targetCoordinates;
  }

  public Projectile getProjectile() {
    return projectile;
  }

  public boolean isMessageValid() {
    return messageIsValid;
  }

  // for use by the message handler only.
  public SMessageIMessageTest()
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
      projectile = Projectile.fromBytes(buf);
      double x = buf.readDouble();
      double y = buf.readDouble();
      double z = buf.readDouble();
      targetCoordinates = new Vec3d(x, y, z);

      // these methods may also be of use for your code:
      // for Itemstacks - ByteBufUtils.readItemStack()
      // for NBT tags ByteBufUtils.readTag();
      // for Strings: ByteBufUtils.readUTF8String();

    } catch (IndexOutOfBoundsException ioe) {
      System.err.println("Exception while reading CMessageTest: " + ioe);
      return;
    }
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
    projectile.toBytes(buf);
    buf.writeDouble(targetCoordinates.xCoord);
    buf.writeDouble(targetCoordinates.yCoord);
    buf.writeDouble(targetCoordinates.zCoord);

    // these methods may also be of use for your code:
    // for Itemstacks - ByteBufUtils.writeItemStack()
    // for NBT tags ByteBufUtils.writeTag();
    // for Strings: ByteBufUtils.writeUTF8String();
  }

  public enum Projectile {
    PIG(1, "PIG"), SNOWBALL(2, "SNOWBALL"), TNT(3, "TNT"), SNOWMAN(4, "SNOWMAN"), EGG(5, "EGG"), FIREBALL(6, "FIREBALL");

    public void toBytes(ByteBuf buffer) {
      buffer.writeByte(projectileID);
    }

    public static Projectile fromBytes(ByteBuf buffer) {
      byte ID = buffer.readByte();
      for (Projectile projectile : Projectile.values()) {
        if (ID == projectile.projectileID) return projectile;
      }
      return null;
    }

    @Override
    public String toString() {return name;}

    private Projectile(int i_projectileID, String i_name) {
      projectileID = (byte)i_projectileID;
      name = i_name;
    }

    private final byte projectileID;
    private final String name;
  }

  @Override
  public String toString()
  {
    return "CMessageTest[projectile=" + String.valueOf(projectile)
                                                  + ", targetCoordinates=" + String.valueOf(targetCoordinates) + "]";
  }

  private Vec3d targetCoordinates;
  private Projectile projectile;
  private boolean messageIsValid;
}
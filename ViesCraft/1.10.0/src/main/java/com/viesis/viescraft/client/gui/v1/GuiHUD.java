package com.viesis.viescraft.client.gui.v1;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;

@SideOnly(Side.CLIENT)
public class GuiHUD extends Gui {
	
	/**
	 * @author Nephroid
	 *
	 * This class contains code that replaces the vanilla heart and armor bars with a
	 * custom unified status bar.
	 */
	
	/* I extend Gui because it has already implemented a bunch of drawing functions */
	//public class StatusBarRenderer extends Gui {
	
	  /* This line tells Minecraft/Forge where your texture is. The first argument is your MODID,
	   * and the second argument is the path to your texture starting at "resources/assets/MODID"
	   *
	   * In this case, the location of the texture is
	   *
	   *   "resources/assets/MODID/textures/gui/advanced_overlay.png"
	   */
	  private final ResourceLocation overlayBar = new ResourceLocation(Reference.MOD_ID, "/textures/gui/mbe40_hud_overlay.png");
	
	  /* These two variables describe the size of the bar */
	  private final static int BAR_WIDTH = 81;
	  private final static int BAR_HEIGHT = 9;
	  private final static int BAR_SPACING_ABOVE_EXP_BAR = 3;   //pixels between the BAR and the Experience Bar below it
	
	  /* Sometimes you want to include extra information from the game. This instance of
	   * Minecraft will let you access the World and EntityPlayer objects which is more than
	   * enough for most purposes. It also contains some helper objects for OpenGL which can be
	   * used for drawing things.
	   *
	   * To actually get the instance of Minecraft, you should pass it in through the constructor.
	   * It is possible to import Minecraft and use Minecraft.getMinecraft() here, but this won't
	   * always be possible if you want to include information that's part of another class.
	   */
	  private Minecraft mc;
	
	  public GuiHUD(Minecraft mc) {
	    this.mc = mc;
	  }
	  
	  
	  
	  @SideOnly(Side.CLIENT)
	  @SubscribeEvent
	  public void onRenderTextOverlay(RenderGameOverlayEvent.Text event) 
	  {
		  //ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(Minecraft.getMinecraft().thePlayer);
		  // special new case: no hud for this type
		  ////if (wand != null) 
		  //{
			//  spellHud.drawSpellWheel(wand);
		  //}
	  }
	  
	  
	  
	  @SideOnly(Side.CLIENT)
	  @SubscribeEvent(priority = EventPriority.LOWEST)
	  public void onRender(RenderGameOverlayEvent.Post event) 
	  {
		  
		  
		  /**
		  if (event.isCanceled() || event.getType() != ElementType.EXPERIENCE) { return; }
		  EntityPlayer effectivePlayer = Minecraft.getMinecraft().thePlayer;
		  ItemStack heldWand = UtilSpellCaster.getPlayerWandIfHeld(effectivePlayer);
		  if (heldWand == null) { return; }
		  RenderItem itemRender = Minecraft.getMinecraft().getRenderItem();
		  GlStateManager.color(1, 1, 1, 1);
		  RenderHelper.enableStandardItemLighting();
		  RenderHelper.enableGUIStandardItemLighting();
		  int itemSlot = ItemCyclicWand.BuildType.getSlot(heldWand);
		  ItemStack current = InventoryWand.getFromSlot(heldWand, itemSlot);
		  if (current != null) 
		  {
			  itemRender.renderItemAndEffectIntoGUI(current,
					  SpellHud.xoffset - 1, SpellHud.ymain + SpellHud.spellSize * 2);
		  }
		  RenderHelper.disableStandardItemLighting();
		  
		  */
	  }
}


	  /**
	  private class SpellHud {
		  private static final int xoffset = 14;//was 30 if manabar is showing
		  private static final int ymain = 6;
		  private static final int spellSize = 16;
		  private int xmain;
		  @SideOnly(Side.CLIENT)
		  public void drawSpellWheel(ItemStack wand) {
    if (SpellRegistry.renderOnLeft) {
      xmain = xoffset;
    }
    else {
      ScaledResolution res = new ScaledResolution(Minecraft.getMinecraft());
      xmain = res.getScaledWidth() - xoffset;
    }
    EntityPlayer player = Minecraft.getMinecraft().thePlayer;
    ISpell spellCurrent = UtilSpellCaster.getPlayerCurrentISpell(player);
    //if theres only one spell, do not do the rest eh
    if (SpellRegistry.getSpellbook(wand) == null || SpellRegistry.getSpellbook(wand).size() <= 1) { return; }
    drawCurrentSpell(player, spellCurrent);
    drawNextSpells(player, spellCurrent);
    drawPrevSpells(player, spellCurrent);
  }
  private void drawCurrentSpell(EntityPlayer player, ISpell spellCurrent) {
    UtilTextureRender.drawTextureSquare(spellCurrent.getIconDisplay(), xmain, ymain, spellSize);
  }
  private void drawPrevSpells(EntityPlayer player, ISpell spellCurrent) {
    ItemStack wand = UtilSpellCaster.getPlayerWandIfHeld(player);
    ISpell prev = SpellRegistry.prev(wand, spellCurrent);
    if (prev != null) {
      int x = xmain + 9;
      int y = ymain + spellSize;
      int dim = spellSize / 2;
      UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
      prev = SpellRegistry.prev(wand, prev);
      if (prev != null) {
        x += 5;
        y += 14;
        dim -= 2;
        UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
        prev = SpellRegistry.prev(wand, prev);
        if (prev != null) {
          x += 3;
          y += 10;
          dim -= 2;
          UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
          prev = SpellRegistry.prev(wand, prev);
          if (prev != null) {
            x += 2;
            y += 10;
            dim -= 1;
            UtilTextureRender.drawTextureSquare(prev.getIconDisplay(), x, y, dim);
          }
        }
      }
    }
  }
  
    }
  }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 // the parachute-hud.png image uses some ELD Unofficial Continuation Project textures, modified to suit the parachute HUD.
    protected static final ResourceLocation hudTexture = new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/test.png");
    private static FontRenderer fontRenderer;
    public static double altitude;
    private final Minecraft mc = Minecraft.getMinecraft();

    private EntityAirshipCore airship;
    
    private int blink = 0;
    private final int hudWidth;
    private final int hudHeight;
    private final int ledWidth;
    private final int ledHeight;
    private final int fieldWidth;
    private final int colorYellow;
    private final int colorRed;
    private final int colorGreen;
    private final int colorBlue;
    private final int colorDimBlue;
    private final int colorDimGreen;
    // AAD icon
    private final int aadWidth;
    private final int aadHeight;
    private final int ledY;
    // manual dismount indicators
    private final int lightY;
    private final int red;
    private final int darkRed;
    private final int green;
    private final int dark;
    private int blinkX;
    private final int blinkTime;
    private final int yOffset;
    // waypoint
    public static int wayPointX;
    public static int wayPointZ;
    private static boolean wayPointEnabled;
    // home direction
    public static int homePointX;
    public static int homePointZ;

    public EntityPlayer player;
    
    public GuiEntityAirshipHUD() {
        super();
        hudWidth = 182;
        hudHeight = 39;
        ledWidth = 11;
        ledHeight = 5;
        colorYellow = 0xffaaaa00;
        colorRed = 0xffaa0000;
        colorGreen = 0xff00aa00;
        colorBlue = 0xff0000aa;
        colorDimBlue = 0xcc000088;
        colorDimGreen = 0xcc008800;
        aadWidth = 16;
        aadHeight = 25;
        ledY = 39;
        lightY = 44;
        red = 0;
        darkRed = 48;
        green = 16;
        dark = 32;
        blinkX = red;
        blinkTime = 5;
        yOffset = 14;
        wayPointX = 0;
        wayPointZ = 0;
        homePointX = 0;
        homePointZ = 0;
        // disable the waypoint display
        wayPointEnabled = false;

        
        
        fontRenderer = mc.fontRendererObj;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
    }

    //@SuppressWarnings("unused")
    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        // todo: add end biome to the excluded list
        if (event.isCancelable() || mc.gameSettings.showDebugInfo || mc.thePlayer.onGround) {
           
        	LogHelper.info("GUI!");
        	return;
        }

        if (mc.inGameHasFocus && event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            ScaledResolution sr = new ScaledResolution(mc);
            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
            int hudY = 2; // top edge of GUI
            int textX = hudX + 30; // xcoord for text
            int textY = hudY + 22; // ycoord for text
            int ledX = 1;

            if(EntityAirshipCore.isAirshipBeingDriven(airship))
            {
            	LogHelper.info("GUI!");
            }
            
            
            
            /**
			if (player.getRidingEntity() instanceof EntityAirshipCore
            		//ParachuteCommonProxy.onParachute(mc.thePlayer)
            		) {
                mc.getTextureManager().bindTexture(hudTexture);

                GlStateManager.enableRescaleNormal();
                GlStateManager.enableBlend();
                GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                                                     GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
                RenderHelper.enableGUIStandardItemLighting();

                BlockPos entityPos = new BlockPos(mc.thePlayer.posX, mc.thePlayer.getEntityBoundingBox().minY, mc.thePlayer.posZ);
                altitude = getCurrentAltitude(entityPos);
                //double homeDir = getHomeDirection();
                //double distance = getHomeDistance();
                double heading = (((mc.thePlayer.rotationYaw + 180.0) % 360) + 360) % 360;

                // Params: int screenX, int screenY, int textureX, int textureY, int width, int height
                drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight); // draw the main hud

                // determine which LED to light, homeDir is in range -180 to 180
                // for any value under -80 or over 80 the LED is fixed to the
                // left or right end of the slider respectively.
                //if (homeDir < -80) {
                //    ledX = 1;
                //} else if ((homeDir - 80) * (homeDir - -80) < 0) {
                //    ledX = (int) Math.floor((homeDir + 80.0) + 4);
                //} else if (homeDir > 80) {
                //    ledX = 170;
                //}
                drawTexturedModalRect(hudX + ledX, hudY, ledX, ledY, ledWidth, ledHeight); // draw the lit LED

                // AAD status
                int aadIconX;
                int aadIconY = 8;
                //if (ConfigHandler.getIsAADActive()) {
                //    aadIconX = 199;
                //} else {
                    aadIconX = 182;
                //}
                drawTexturedModalRect(hudX + hudWidth + 2, hudY + 8, aadIconX, aadIconY, aadWidth, aadHeight); // draw the AAD indicator

                // manual dismount indicator
                //if (ConfigHandler.isAutoDismount()) { // auto dismount is engaged
                //    drawTexturedModalRect(hudX - 18, hudY + yOffset, dark, lightY, 16, 16);
                //} else { // auto dismount is disabled
                //    if (altitude > 10) {
                //        drawTexturedModalRect(hudX - 18, hudY + yOffset, green, lightY, 16, 16);
                //    } else if (altitude <= 10 && altitude > 3) {
                //        drawTexturedModalRect(hudX - 18, hudY + yOffset, red, lightY, 16, 16);
                //    } else if (altitude <= 3) { // make this blink
                //        if ((blink % blinkTime) == 0) {
                ////            blinkX = blinkX == red ? darkRed : red;
                //        }
                //        drawTexturedModalRect(hudX - 18, hudY + yOffset, blinkX, lightY, 16, 16);
                //        blink++;
                //    }
                //}

                if (wayPointEnabled) {
                    double waypointDirection = getWaypointDirection(wayPointX, wayPointZ);
                    // draw the waypoint heading
                    if (waypointDirection < -80) {
                        ledX = 1;
                    } else if ((waypointDirection - 80) * (waypointDirection - -80) < 0) {
                        ledX = (int) Math.floor((waypointDirection + 80.0) + 4);
                    } else if (waypointDirection > 80) {
                        ledX = 170;
                    }
                    // draw the waypoint bar background
                    drawTexturedModalRect(hudX, hudY + hudHeight, 0, 0, hudWidth, ledHeight);
                    // draw the lit LED
                    drawTexturedModalRect(hudX + ledX, hudY + hudHeight, ledX, ledY, ledWidth, ledHeight);
                }

                // draw the altitude text
                fontRenderer.drawStringWithShadow(I18n.format("gui.hud.altitude"), hudX + 18, hudY + 12, colorDimBlue);
                fontRenderer.drawStringWithShadow(format(altitude), (textX + 5) - fieldWidth, textY, colorAltitude());
                // draw the compass heading text
                fontRenderer.drawStringWithShadow(I18n.format("gui.hud.compass"), hudX + 123, hudY + 12, colorDimBlue);
                fontRenderer.drawStringWithShadow(format(heading), (textX + 118) - fieldWidth, textY, colorCompass(heading));
                // draw the distance to the home point text
                //fontRenderer.drawStringWithShadow(format(distance), (textX + 65) - fieldWidth, textY, colorDimGreen);
            }
            */
 /**           RenderHelper.disableStandardItemLighting();
            GlStateManager.disableRescaleNormal();
            GlStateManager.disableBlend();
        }
    }

    public String format(double d) {
        return String.format("%.1f", d);
    }

    // difference angle in degrees the player is facing from the home point.
    // zero degrees means the player is facing the home point.
    // the home point can be either the world spawn point or a waypoint
    // set by the player in the config.
    //public double getHomeDirection() {
    //    BlockPos blockpos;
        //if (ConfigHandler.getUseSpawnPoint()) {
        //    blockpos = mc.theWorld.getSpawnPoint();
        //} else {
        //    blockpos = ConfigHandler.getHomepoint();
        //}
    //    double delta = Math.atan2(blockpos.getZ() - mc.thePlayer.posZ, blockpos.getX() - mc.thePlayer.posX);
    //    double relAngle = delta - Math.toRadians(mc.thePlayer.rotationYaw);
    //    return MathHelper.wrapDegrees(Math.toDegrees(relAngle) - 90.0); // degrees
    //}

    //public double getHomeDistance() {
        //BlockPos blockpos;
        //if (ConfigHandler.getUseSpawnPoint()) {
        //    blockpos = mc.theWorld.getSpawnPoint();
        //} else {
        //    blockpos = ConfigHandler.getHomepoint();
        //}
        //double a = Math.pow(blockpos.getZ() - mc.thePlayer.posZ, 2);
        //double b = Math.pow(blockpos.getX() - mc.thePlayer.posX, 2);
        //return Math.sqrt(a + b);
    //}

    public int colorAltitude() {
        return (altitude <= 10.0 && altitude >= 0.0) ? colorRed : altitude < 0.0 ? colorYellow : colorGreen;
    }

    // quadrant color code
    // 315 to 44 green, mostly north
    // 45 to 134 yellow, mostly east
    // 135 to 224 red, mostly south
    // 225 to 314 blue, mostly west
    public int colorCompass(double d) {
        return (d >= 0 && d < 45.0) ? colorGreen : (d >= 45.0 && d < 135.0) ? colorYellow :
               (d >= 135.0 && d < 225.0) ? colorRed : (d >= 225.0 && d < 315.0) ? colorBlue : colorGreen;
    }

    // calculate altitude in meters above ground. starting at the entity
    // count down until a non-air block is encountered.
    // only allow altitude calculations in the surface world
    // return a weirdly random number if in nether or end.
    public double getCurrentAltitude(BlockPos entityPos) {
        if (mc.theWorld.provider.isSurfaceWorld()) {
            BlockPos blockPos = new BlockPos(entityPos.getX(), entityPos.getY(), entityPos.getZ());
            while (mc.theWorld.isAirBlock(blockPos.down())) {
                blockPos = blockPos.down();
            }
            // calculate the entity's current altitude above the ground
            return entityPos.getY() - blockPos.getY();
        }
        return 1000.0 * mc.theWorld.rand.nextGaussian();
    }

    // difference angle in degrees the player is facing from the waypoint.
    // zero degrees means the player is facing the waypoint.
    public double getWaypointDirection(int waypointX, int waypointZ) {
        BlockPos blockpos = new BlockPos(waypointX, 0, waypointZ);
        double delta = Math.atan2(blockpos.getZ() - mc.thePlayer.posZ, blockpos.getX() - mc.thePlayer.posX);
        double relAngle = delta - Math.toRadians(mc.thePlayer.rotationYaw);
        return MathHelper.wrapDegrees(Math.toDegrees(relAngle) - 90.0); // degrees
    }

    public static int[] getWaypoint() {
        return new int[] {wayPointX, wayPointZ};
    }

    public static void setWaypoint(int[] waypoint) {
        wayPointX = waypoint[0];
        wayPointZ = waypoint[1];
    }

    public static void setHomepoint(int[] homepoint) {
        homePointX = homepoint[0];
        homePointZ = homepoint[1];
    }

    public static void enableWaypoint(boolean enabled) {
        wayPointEnabled = enabled;
    }

    public static boolean getEnableWaypoint() {
        return wayPointEnabled;
    }

}
	
	
	/**
	private Minecraft mc;

	private static final ResourceLocation texture = new ResourceLocation("tutorial", "textures/gui/mana_bar.png");

	public GuiEntityAirshipHUD(Minecraft mc) {
		super();
		this.mc = mc;
	}

	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderExperienceBar1(RenderGameOverlayEvent.Post event) {
		if (event.getType()//.type 
				!= ElementType.EXPERIENCE) {
			return;
		}

		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);
		if (props == null || props.getMaxMana() == 0) {
			return;
		}

		int xPos = 2;
		int yPos = 2;
		this.mc.getTextureManager().bindTexture(texture);

		// Add this block of code before you draw the section of your texture containing transparency
		GlStateManager.pushAttrib();
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		GlStateManager.disableLighting();
		// alpha test and blend needed due to vanilla or Forge rendering bug
		GlStateManager.enableAlpha();
		GlStateManager.enableBlend();
		// Here we draw the background bar which contains a transparent section; note the new size
		drawTexturedModalRect(xPos, yPos, 0, 0, 56, 9);
		// You can keep drawing without changing anything
		int manabarwidth = (int)(((float) props.getCurrentMana() / props.getMaxMana()) * 49);
		drawTexturedModalRect(xPos + 3, yPos + 3, 0, 9, manabarwidth, 3);
		String s = "Mana " + props.getCurrentMana() + "/" + props.getMaxMana();
		yPos += 10;
		this.mc.fontRendererObj.drawString(s, xPos + 1, yPos, 0);
		this.mc.fontRendererObj.drawString(s, xPos - 1, yPos, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos + 1, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos - 1, 0);
		this.mc.fontRendererObj.drawString(s, xPos, yPos, 8453920);
		GlStateManager.popAttrib();
	}
}
	
	*/
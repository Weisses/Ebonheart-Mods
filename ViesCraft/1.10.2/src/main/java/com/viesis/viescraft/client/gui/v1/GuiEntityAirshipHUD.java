package com.viesis.viescraft.client.gui.v1;

import java.text.DecimalFormat;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;

@SideOnly(Side.CLIENT)
public class GuiEntityAirshipHUD extends Gui {
	
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
	
	  public GuiEntityAirshipHUD(Minecraft mc) {
	    this.mc = mc;
	  }
	
	  /* This helper method will render the bar */
	  public void renderStatusBar(int screenWidth, int screenHeight) {
	    /* These are the variables that contain world and player information */
	    World world = mc.theWorld;
	    EntityPlayer player = mc.thePlayer;
	
	    /* This object draws text using the Minecraft font */
	    FontRenderer fr = mc.fontRendererObj;
	
	    /* This object inserts commas into number strings */
	    DecimalFormat d = new DecimalFormat("#,###");
	
	    /* Saving the current state of OpenGL so that I can restore it when I'm done */
	    GL11.glPushAttrib(GL11.GL_ALL_ATTRIB_BITS);
	    GL11.glPushMatrix();
	
	      /* I like to indent the code whenever I push. It helps me visualize what is
	       * happening better. This is a personal preference though.
	       */
	
	      /* Set the rendering color to white */
	    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	
	      /* This method tells OpenGL to draw with the custom texture */
	    mc.renderEngine.bindTexture(overlayBar);
	
	    // we will draw the status bar just above the hotbar.
	    //  obtained by inspecting the vanilla hotbar rendering code
	    final int vanillaExpLeftX = screenWidth / 2 - 91;  //leftmost edge of the experience bar
	    final int vanillaExpTopY = screenHeight - 32 + 3;  // top of the experience bar
	
	      /* Shift our rendering origin to just above the experience bar
	       * The top left corner of the screen is x=0, y=0
	       */
	    GL11.glTranslatef(vanillaExpLeftX, vanillaExpTopY - BAR_SPACING_ABOVE_EXP_BAR - BAR_HEIGHT, 0);
	
	      /* Draw a part of the image file at the current position
	       *
	       * The first two arguments are the x,y position that you want to draw the texture at
	       * (with respect to the current transformations).
	       *
	       * The next four arguments specify what part of the image file to draw, in the order below:
	       *
	       *   1. Left-most side
	       *   2. Top-most side
	       *   3. Right-most side
	       *   4. Bottom-most side
	       *
	       * The units of these four arguments are pixels in the image file. These arguments will form a
	       * rectangle, which is then "cut" from your image and used as the texture
	       *
	       * This line draws the background of the custom bar
	       */
	    drawTexturedModalRect(0, 0, 0, 0, BAR_WIDTH, BAR_HEIGHT);
	
	      /* This line draws the outline effect that corresponds to how much armor the player has.
	       * I slide the right-most side of the rectangle using the player's armor value.
	       */
	    drawTexturedModalRect(0, 0, 0, BAR_HEIGHT, (int)(BAR_WIDTH*(player.getTotalArmorValue()/20f)), BAR_HEIGHT);
	
	      /* This part draws the inside of the bar, which starts 1 pixel right and down */
	    GL11.glPushMatrix();
	
	        /* Shift 1 pixel right and down */
	    GL11.glTranslatef(1, 1, 0);
	
	        /* These few numbers will store the HP values of the player. This includes the Health Boost
	         * and Absorption potion effects
	         */
	    float maxHp = player.getMaxHealth();
	    float absorptionAmount = player.getAbsorptionAmount();
	    float effectiveHp = player.getHealth() + absorptionAmount;
	
	        /* The part of the bar that fills up will be a rectangle that stretches based on how much hp the player
	         * has. To do this, I need to use a scaling transform, which is why I push again.
	         */
	    GL11.glPushMatrix();
	
	          /* I scale horizontally based on the fraction effectiveHp/maxHp. However, I don't want the scaled
	           * value to exceed the actual width of the bar's interior, so I cap it at 1 using Math.min.
	           *
	           * The width of the bar's interior is BAR_WIDTH - 2
	           */
	    GL11.glScalef((BAR_WIDTH - 2)*Math.min(1, effectiveHp/maxHp), 1, 1);
	
	
	          /* This chain of if-else blocks checks if the player has any status effects. I check if a potion effect
	           * is active, then draw the filling bar based on what potion effect is active. Unfortunately, it is
	           * not possible to use a switch statement here since multiple potion effects may be active at once.
	           *
	           * The effects I check for are
	           *   20: Wither
	           *   19: Poison
	           *   10: Regeneration
	           *
	           * For a more comprehensive list of status effects, see http:minecraft.gamepedia.com/Status_effect
	           */
	    final int WITHER_EFFECT_ID = 20;
	    final int POISON_EFFECT_ID = 19;
	    final int REGEN_EFFECT_ID = 10;
	    final int NORMAL_TEXTURE_U = BAR_WIDTH;      //red texels  - see mbe40_hud_overlay.png
	    final int REGEN_TEXTURE_U = BAR_WIDTH + 1;   // green texels
	    final int POISON_TEXTURE_U = BAR_WIDTH + 2;  // black texels
	    final int WITHER_TEXTURE_U = BAR_WIDTH + 3;  // brown texels
	
	    //if (player.isPotionActive(WITHER_EFFECT_ID)) {
	    //  drawTexturedModalRect(0, 0, WITHER_TEXTURE_U, 0, 1, BAR_HEIGHT - 2);
	    //}
	    //else if (player.isPotionActive(POISON_EFFECT_ID)) {
	    //  drawTexturedModalRect(0, 0, POISON_TEXTURE_U, 0, 1, BAR_HEIGHT - 2);
	    //}
	    //else if (player.isPotionActive(REGEN_EFFECT_ID)) {
	    //  drawTexturedModalRect(0, 0, REGEN_TEXTURE_U, 0, 1, BAR_HEIGHT - 2);
	    //}
	    //else {
	    //  drawTexturedModalRect(0, 0, NORMAL_TEXTURE_U, 0, 1, BAR_HEIGHT - 2);
	    //}
	
	    GL11.glPopMatrix();
	
	        /* Move to the right end of the bar, minus a few pixels. */
	    GL11.glTranslatef(BAR_WIDTH - 3, 1, 0);
	
	        /* The default minecraft font is too big, so I scale it down a bit. */
	    GL11.glPushMatrix();
	    GL11.glScalef(0.5f, 0.5f, 1);
	
	          /* This generates the string that I want to draw. */
	    String s = d.format(effectiveHp) + "/" + d.format(maxHp);
	
	          /* If the player has the absorption effect, draw the string in gold color, otherwise
	           * draw the string in white color. For each case, I call drawString twice, once to
	           * draw the shadow, and once for the actual string.
	           */
	    if (absorptionAmount > 0) {
	
	            /* Draw the shadow string */
	      fr.drawString(s, -fr.getStringWidth(s) + 1, 2, 0x5A2B00);
	
	            /* Draw the actual string */
	      fr.drawString(s, -fr.getStringWidth(s), 1, 0xFFD200);
	    }
	    else {
	      fr.drawString(s, -fr.getStringWidth(s) + 1, 2, 0x4D0000);
	      fr.drawString(s, -fr.getStringWidth(s), 1, 0xFFFFFF);
	    }
	    GL11.glPopMatrix();
	
	    GL11.glPopMatrix();
	
	    GL11.glPopMatrix();
	    GL11.glPopAttrib();
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
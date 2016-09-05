package com.viesis.viescraft.client.gui.v1;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;

//@SideOnly(Side.CLIENT)
public class GuiHUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/viescraft_hud.png");
	
	private final int hudWidth;
	private final int hudHeight;
	
	private final int fieldWidth;
	
	private final int ledWidth;
    private final int ledHeight;
    
	private final int colorDimBlue;
	
	private int itemFuelStack;
	private boolean isAirshipV1;// = Minecraft.getMinecraft().thePlayer.getRidingEntity() instanceof EntityAirshipV1Core;
	//private boolean airshipOn;
	
	private EntityAirshipV1Core airship;
	
	private ItemStack itemFuel;
	
	public GuiHUD()
	{
		super();
		
		hudWidth = 182;//277;//182;
        hudHeight = 40;//54;//39;
        
        ledWidth = 11;
        ledHeight = 5;
        
        colorDimBlue = 0xcc000088;
        
        fontRenderer = mc.fontRendererObj;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
        
	}
	
	
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) 
	{
		airship = (EntityAirshipV1Core) Minecraft.getMinecraft().thePlayer.getRidingEntity();
		isAirshipV1 = mc.thePlayer.getRidingEntity() instanceof EntityAirshipV1Core;
		//airshipOn = this.airship.isAirshipOn();
		if (event.getType() != ElementType.EXPERIENCE) 
		{
			return;
		}
		
		if(isAirshipV1)
	    {
			itemFuel = this.airship.getStackInSlot(9);
			
			if(itemFuel != null)
			{
				this.itemFuelStack = itemFuel.stackSize * (ViesCraftConfig.v1FuelBurnTime);
			}
			else
			{
				this.itemFuelStack = 0;
			}
			
			GlStateManager.enableRescaleNormal();
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                                                 GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            
            // Add this block of code before you draw the section of your texture containing transparency
 			GlStateManager.pushAttrib();
 			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
 			GlStateManager.disableLighting();
 			
 			// alpha test and blend needed due to vanilla or Forge rendering bug
 			GlStateManager.enableAlpha();
 			GlStateManager.enableBlend();
         			
            Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			
            //Calculation from ticks to seconds.
            int timer = (((airship.airshipBurnTime + 18) ) / 20) + itemFuelStack ;
			int remainder = (timer % 3600);
			
			int minutes = remainder / 60;
			int seconds = remainder % 60;
			int hours = timer / 3600;
			
			
			String hrs = (hours < 10 ? "0" : "") + hours;
			String mins = (minutes < 10 ? "0" : "") + minutes;
			String secs = (seconds < 10 ? "0" : "") + seconds;
			//LogHelper.info(hours);
			
			//String formattedTime = mins + ":" + secs;
			
			//LogHelper.info(itemFuelStack);
			
			ScaledResolution sr = new ScaledResolution(mc);
            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
            int hudY = 2; // top edge of GUI
            int textX = hudX + 30; // xcoord for text
            int textY = hudY + 22; // ycoord for text
            int ledX = 1;
			
			
            
			//if(airshipOn)
			//{
			//	LogHelper.info("On!");
						//itemFuel
						//airship.airshipBurnTime
						//);
			//}
			
			
			//int xPos = 2;
			//int yPos = 2;
			
			
			//Draw the background static texture.
			// Params: int screenX, int screenY, int textureX, int textureY, int width, int height
			drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight + 2);
			
            // Params: int screenX, int screenY, int textureX, int textureY, int width, int height
            //drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight); // draw the main hud

			
			
			// Here we draw the background bar which contains a transparent section; note the new size
			//drawTexturedModalRect(xPos, yPos, 0, 0, 56, 9);
			
			
			
			//SMALL % BAR
			// You can keep drawing without changing anything
			int fuelbarwidth1 = (int)((((float) (this.airship.airshipBurnTime) / (ViesCraftConfig.v1FuelBurnTime * 20))) * 110);
			
			drawTexturedModalRect(hudX + 36, hudY + 33, 36, 53, fuelbarwidth1, 6);
			
			//BIG % BAR
			// You can keep drawing without changing anything
			int fuelbarwidth2 = (int)(((float) (this.itemFuelStack * 20) / ((ViesCraftConfig.v1FuelBurnTime * 20) * 64)) * 178);
			
			drawTexturedModalRect(hudX + 2, hudY + 14, 2, 69, fuelbarwidth2, 6);
			
			if(airship.airshipBurnTime >= 1)
			{
				Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
				
				drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
			}
			
			
			//Time in seconds to display
			String s = hrs + ":" + mins + ":" + secs;
			
			//yPos += 10;
			//Minecraft.getMinecraft().fontRendererObj.drawString(s, (hudX + 71) + 1, (hudY + 22), 0);
			//Minecraft.getMinecraft().fontRendererObj.drawString(s, (hudX + 71) - 1, (hudY + 22), 0);
			//Minecraft.getMinecraft().fontRendererObj.drawString(s, (hudX + 71), (hudY + 22) + 1, 0);
			//Minecraft.getMinecraft().fontRendererObj.drawString(s, (hudX + 71), (hudY + 22) - 1, 0);
			
			
			//Aqua timer
			if(hours > 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 60155);
				
			}
			else if(minutes >= 15 && seconds >= 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 60155);
			}
			//Green timer
			else if(minutes >= 5 && seconds >= 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 1571584);
			}
			//Yellow timer
			else if(minutes >= 2 && seconds >= 30)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 15596288);
			}
			//Orange timer
			else if(minutes >= 1 && seconds >= 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 16493312);
			}
			//Red timer
			else if(seconds >= 1)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 16449536);
			}
			else if(seconds >= 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 0);
			}
			
			
			
			GlStateManager.popAttrib();
			
	    }
		
	}
	
}

package com.viesis.viescraft.client.gui.v2;

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
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class GuiV2HUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/viescraft_hud.png");
	
	private final int hudWidth;
	private final int hudHeight;
	private final int fieldWidth;
	private int itemFuelStack;
	private boolean isAirshipV2;
	
	private EntityAirshipV2Core airshipV2;
	private ItemStack itemFuel;
	
	public GuiV2HUD()
	{
		super();
		
		hudWidth = 182;
        hudHeight = 40;
        
        fontRenderer = mc.fontRendererObj;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) 
	{
		isAirshipV2 = mc.thePlayer.getRidingEntity() instanceof EntityAirshipV2Core;
		
		if (event.getType() != ElementType.EXPERIENCE) 
		{
			return;
		}
		
		if(isAirshipV2)
	    {
			airshipV2 = (EntityAirshipV2Core) Minecraft.getMinecraft().thePlayer.getRidingEntity();
			itemFuel = this.airshipV2.getStackInSlot(9);
			
			if(itemFuel != null)
			{
				this.itemFuelStack = itemFuel.stackSize * (ViesCraftConfig.v2FuelBurnTime);
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
			
			//Screen resolution
			ScaledResolution sr = new ScaledResolution(mc);
            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
            int hudY = 2; // top edge of GUI
            int textX = hudX + 30; // xcoord for text
            int textY = hudY + 22; // ycoord for text
            int ledX = 1;
			
			//Draw the background static texture.
			// Params: int screenX, int screenY, int textureX, int textureY, int width, int height
			drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight + 2);
			
			//SMALL % BAR
			// You can keep drawing without changing anything
			int fuelbarwidth1 = (int)((((float) (this.airshipV2.airshipBurnTime) / (ViesCraftConfig.v2FuelBurnTime * 20))) * 110);
			drawTexturedModalRect(hudX + 36, hudY + 33, 36, 53, fuelbarwidth1, 6);
			
			//BIG % BAR
			// You can keep drawing without changing anything
			int fuelbarwidth2 = (int)(((float) (this.itemFuelStack * 20) / ((ViesCraftConfig.v2FuelBurnTime * 20) * 64)) * 178);
			drawTexturedModalRect(hudX + 2, hudY + 14, 2, 69, fuelbarwidth2, 6);
			
			//Airship lights on
			if(airshipV2.airshipBurnTime >= 1)
			{
				drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
			}
			
            //Calculation from ticks to seconds.
            int timer = (((airshipV2.airshipBurnTime + 18) ) / 20) + itemFuelStack ;
			int remainder = (timer % 3600);
			int minutes = remainder / 60;
			int seconds = remainder % 60;
			int hours = timer / 3600;
			
			String hrs = (hours < 10 ? "0" : "") + hours;
			String mins = (minutes < 10 ? "0" : "") + minutes;
			String secs = (seconds < 10 ? "0" : "") + seconds;
			
			//Time in seconds to display
			String s = hrs + ":" + mins + ":" + secs;
			
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
			else if(minutes >= 2 && seconds >= 0)
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
			//Black timer (Off)
			else if(seconds >= 0)
			{
				Minecraft.getMinecraft().fontRendererObj.drawString(s, (int) (hudX + 71.5), (hudY + 23), 0);
			}
			
			GlStateManager.popAttrib();
	    }
	}
}

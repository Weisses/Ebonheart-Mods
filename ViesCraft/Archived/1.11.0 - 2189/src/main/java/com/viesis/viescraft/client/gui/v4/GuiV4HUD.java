package com.viesis.viescraft.client.gui.v4;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;

public class GuiV4HUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/viescraft_hud.png");
	
	private final int hudWidth;
	private final int hudHeight;
	private final int fieldWidth;
	
	private boolean isAirshipV4;
	private EntityAirshipV4Core airshipV4;
	
	public GuiV4HUD()
	{
		super();
		
		hudWidth = 182;
        hudHeight = 40;
        
        fontRenderer = mc.fontRendererObj;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderAirshipBar(RenderGameOverlayEvent.Post event) 
	{
		if(event.getType() == ElementType.ALL) 
		{
			GuiIngameForge.renderFood = true;
			
			this.isAirshipV4 = mc.player.getRidingEntity() instanceof EntityAirshipV4Core;
			
			if(this.isAirshipV4)
		    {
				this.airshipV4 = (EntityAirshipV4Core) Minecraft.getMinecraft().player.getRidingEntity();
				
				GlStateManager.enableRescaleNormal();
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	            
	            //Add this block of code before you draw the section of your texture containing transparency
	 			GlStateManager.pushAttrib();
	 			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	 			GlStateManager.disableLighting();
	 			
	 			//Alpha test and blend needed due to vanilla or Forge rendering bug
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
				// I can keep drawing without changing anything
				if(EventHandlerAirship.creativeBurn)
	        	{
					//Same as the infinite fuel module
					drawTexturedModalRect(hudX + 36, hudY + 33, 36, 77, 110, 6);
	        	}
				else
				{
					//Creates a solid green bar
					if(this.airshipV4.getModuleFuelInfinite())
					{
						drawTexturedModalRect(hudX + 36, hudY + 33, 36, 77, 110, 6);
					}
					else
					{
						int fuelbarwidth1 = (int)(((float) (this.airshipV4.getPowered()) / (this.airshipV4.getPowered() + this.airshipV4.getTotalPowered())) * 220);
						drawTexturedModalRect(hudX + 36, hudY + 33, 36, 53, fuelbarwidth1, 6);
					}
				}
				
				//BIG % BAR
				// I can keep drawing without changing anything
				if(EventHandlerAirship.creativeBurn)
	        	{
					//Same as the infinite fuel module
					drawTexturedModalRect(hudX + 2, hudY + 14, 2, 93, 178, 6);
	        	}
				else
				{
					//Creates a solid green bar
					if(this.airshipV4.getModuleFuelInfinite())
					{
						drawTexturedModalRect(hudX + 2, hudY + 14, 2, 93, 178, 6);
					}
					else
					{
						int fuelbarwidth2 = (int)(((float) this.airshipV4.getItemFuelStackSizePowered() / 64) * 178);
						drawTexturedModalRect(hudX + 2, hudY + 14, 2, 69, fuelbarwidth2, 6);
					}
				}
				
				//Airship lights on
				if(this.airshipV4.getPowered() >= 1)
				{
					drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
				}
				
				//Draw current module icons in HUD
				if(this.airshipV4.getModuleInventorySmall())
				{
					drawTexturedModalRect(hudX + 83, hudY, 0, 240, 16, 16);
				}
				if(this.airshipV4.getModuleInventoryLarge())
				{
					drawTexturedModalRect(hudX + 83, hudY, 16, 240, 16, 16);
				}
				if(this.airshipV4.getModuleSpeedMinor())
				{
					drawTexturedModalRect(hudX + 83, hudY, 32, 240, 16, 16);
				}
				if(this.airshipV4.getModuleSpeedMajor())
				{
					drawTexturedModalRect(hudX + 83, hudY, 96, 240, 16, 16);
				}
				if(this.airshipV4.getModuleFuelInfinite())
				{
					drawTexturedModalRect(hudX + 83, hudY, 48, 240, 16, 16);
				}
				
				int timer;
				int remainder;
				int minutes;
				int seconds;
				int hours;
				
				if(this.airshipV4.getModuleInventoryLarge()
				|| this.airshipV4.getModuleSpeedMajor())
				{
					//Calculation from ticks to seconds.
		            timer = (((this.airshipV4.getPowered() + 18) + this.airshipV4.getItemFuelStackPowered()) / 20) / 2;
					remainder = (timer % 3600);
					minutes = remainder / 60;
					seconds = remainder % 60;
					hours = timer / 3600;
				}
				else
				{
					//Calculation from ticks to seconds.
		            timer = (((this.airshipV4.getPowered() + 18) + this.airshipV4.getItemFuelStackPowered()) / 20);
					remainder = (timer % 3600);
					minutes = remainder / 60;
					seconds = remainder % 60;
					hours = timer / 3600;
				}
				
				String hrs = (hours < 10 ? "0" : "") + hours;
				String mins = (minutes < 10 ? "0" : "") + minutes;
				String secs = (seconds < 10 ? "0" : "") + seconds;
				if(EventHandlerAirship.creativeBurn)
	        	{
					//Time "infinite" to display
					String s1 = "\u221e" + ":" + "\u221e" + ":" + "\u221e";
					Minecraft.getMinecraft().fontRendererObj.drawString(s1, (hudX + 76), (hudY + 23), 982784);
	        	}
				else if(this.airshipV4.getModuleFuelInfinite())
				{
					//Time "infinite" to display
					String s1 = "\u221e" + ":" + "\u221e" + ":" + "\u221e";
					Minecraft.getMinecraft().fontRendererObj.drawString(s1, (hudX + 76), (hudY + 23), 982784);
				}
				else
				{
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
				}
				
				GlStateManager.popAttrib();
		    }
		}
	}
}

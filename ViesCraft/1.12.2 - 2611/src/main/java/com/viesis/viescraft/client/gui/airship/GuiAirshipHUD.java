package com.viesis.viescraft.client.gui.airship;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;

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

public class GuiAirshipHUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation HUD_TEXTURE = new ResourceLocation(References.MOD_ID, "textures/gui/viescraft_hud.png");
	
	private final int hudWidth;
	private final int hudHeight;
	private final int fieldWidth;
	private float speedMod;
	
	private boolean isAirship;
	private EntityAirshipBaseVC airship;
	
	public GuiAirshipHUD()
	{
		super();
		
		hudWidth = 182;
        hudHeight = 40;
        
        fontRenderer = mc.fontRenderer;
        fieldWidth = fontRenderer.getStringWidth("000.0") / 2;
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderAirshipBar(RenderGameOverlayEvent.Post event) 
	{
		if(event.getType() == ElementType.ALL) 
		{
			GuiIngameForge.renderFood = true;
			
			this.isAirship = mc.player.getRidingEntity() instanceof EntityAirshipBaseVC;
			
			if(this.isAirship)
		    {
				this.airship = (EntityAirshipBaseVC) Minecraft.getMinecraft().player.getRidingEntity();
				
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
	         	
	            Minecraft.getMinecraft().getTextureManager().bindTexture(HUD_TEXTURE);
				
	            //Screen resolution
				ScaledResolution sr = new ScaledResolution(mc);
	            int hudX = sr.getScaledWidth() / 2 - (hudWidth / 2); // left edge of GUI
	            int hudY = 2; // top edge of GUI
	            int textX = hudX + 30; // xcoord for text
	            int textY = hudY + 22; // ycoord for text
	            int ledX = 1;
				
				//Draw the background static texture.
				drawTexturedModalRect(hudX, hudY, 0, 0, hudWidth, hudHeight + 2);
				
				//Bottom lower fuel bar
				//Creates a solid green bar
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				{
					drawTexturedModalRect(hudX + 36, hudY + 31, 36, 72, hudX, 6);
				}
				else
				{
					int fuelbarwidth1 = (int)(((float) this.airship.getStoredFuel() / (this.airship.getStoredFuelTotal())) * 110);
					
					drawTexturedModalRect(hudX + 36, hudY + 31, 36, 59, fuelbarwidth1, 6);
				}
				
				//Top bigger stack bar
				//Creates a solid green bar
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
				|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
				|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				{
					drawTexturedModalRect(hudX + 2, hudY + 14, 2, 66, 177, 6);
				}
				else
				{
					int fuelbarwidth2 = (int)(((float) this.airship.getFuelItemStackSizePowered() / 64) * 178);
					drawTexturedModalRect(hudX + 2, hudY + 14, 2, 53, fuelbarwidth2, 6);
				}
				
				//Airship lights on
				if(this.airship.getStoredFuel() >= 1)
				{
					drawTexturedModalRect(hudX + 16, hudY, 16, 44, 150, 7);
				}
				
				//Draw Module Icon
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudX + 85, hudY + 2, 0);
					GlStateManager.scale(1.5, 1.5, 1.5);
					
					if(this.airship.getModuleActiveSlot1() > 0)
					{
						this.drawModuleIcon(this.airship.getModuleActiveSlot1());
					}
				}
				GlStateManager.popMatrix();
				
				//Draw Yellow Border over Module Icon
				if(this.airship.getModuleActiveSlot1() > 0)
				{
					this.drawTexturedModalRect(hudX + 83, hudY + 0, 0, 224, 16, 16);
				}
				
				//Altitude Logic
				this.renderHUDAltitude(hudX, hudY);
				
				//Timer Logic
				this.renderHUDFuelTimer(hudX, hudY);
				
				GlStateManager.popAttrib();
		    }
		}
	}
	
	private void drawModuleIcon(int metaIn)
	{
		if(metaIn == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 0, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 8, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 16, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 24, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 32, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 40, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 48, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 56, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 64, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.FUEL_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 72, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 80, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 88, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 96, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 104, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 112, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 120, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 128, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 136, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 144, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 152, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 160, 248, 8, 8);
		}
		
		if(metaIn == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 168, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 176, 248, 8, 8);
		}
		if(metaIn == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(0, 0, 184, 248, 8, 8);
		}
	}
	
	private void renderHUDAltitude(int hudXIn, int hudYIn)
	{
		//Altitude Current
		//Check if Altitude module is in.
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 60155);
			}
			GlStateManager.popMatrix();
		}
		else
		{
			//Makes Current Altitude color Red
			if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 5)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 16711680);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Yellow
			else if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 15)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 16187136);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Green
			else
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 74, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getPosition().getY()), 0, 0, 196352);
				}
				GlStateManager.popMatrix();
			}
		}
		
		
		
		//Altitude Max
		//Check if Altitude module is in.
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "225", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "250", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, "\u221e", 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
		}
		else
		{
			//Makes Current Altitude color Red
			if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 5)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 16711680);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Yellow
			else if(this.airship.getPosition().getY() >= (int)EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude() - 15)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 16187136);
				}
				GlStateManager.popMatrix();
			}
			//Makes Current Altitude color Green
			else
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 108.5, hudYIn + 6, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, Integer.toString(EnumsVC.MainTierBalloon.byId(this.airship.getMainTierBalloon()).getMaxAltitude()), 0, 0, 196352);
				}
				GlStateManager.popMatrix();
			}
		}
	}
	
	private void renderHUDFuelTimer(int hudXIn, int hudYIn)
	{
		//Timer logic
		int timer;
		int remainder;
		int minutes;
		int seconds;
		int hours;
		
		//Calculation from ticks to seconds.
		if(this.airship.airshipFuelTick == 0)
		{
			timer = ((((this.airship.getStoredFuel() / 10) + 18) + (this.airship.getFuelItemStackPowered() / 10)) / 20);
		}
		else
		{
			timer = ((((this.airship.getStoredFuel() / this.airship.airshipFuelTick) + 18) + (this.airship.getFuelItemStackPowered() / this.airship.airshipFuelTick)) / 20);
		}
		
		remainder = (timer % 3600);
		minutes = remainder / 60;
		seconds = remainder % 60;
		hours = timer / 3600;
		
		//Converts time to normal standards
		String hrs = (hours < 10 ? "0" : "") + hours;
		String mins = (minutes < 10 ? "0" : "") + minutes;
		String secs = (seconds < 10 ? "0" : "") + seconds;
		
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			//Time "infinite" to display
			String s1 = "\u221e" + ":" + "\u221e" + ":" + "\u221e";
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXIn + 91, hudYIn + 22.5, 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.drawCenteredString(fontRenderer, s1, 0, 0, 196352);
			}
			GlStateManager.popMatrix();
		}
		else
		{
			//Time in seconds to display
			String s = hrs + ":" + mins + ":" + secs;
			String s2 = "*" + References.localNameVC("vc.hud.nofuel") + "*";
			
			//Aqua timer
			if(hours > 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			else if(minutes >= 15 && seconds >= 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 60155);
				}
				GlStateManager.popMatrix();
			}
			//Green timer
			else if(minutes >= 5 && seconds >= 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 1571584);
				}
				GlStateManager.popMatrix();
			}
			//Yellow timer
			else if(minutes >= 2 && seconds >= 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 15596288);
				}
				GlStateManager.popMatrix();
			}
			//Orange timer
			else if(minutes >= 1 && seconds >= 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 16493312);
				}
				GlStateManager.popMatrix();
			}
			//Red timer
			else if(seconds >= 1)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91.5, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s, 0, 0, 16449536);
				}
				GlStateManager.popMatrix();
			}
			//Timer Off
			else if(seconds >= 0)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXIn + 91, hudYIn + 23, 0);
					GlStateManager.scale(0.75, 0.75, 0.75);
					
					this.drawCenteredString(fontRenderer, s2, 0, 0, 16449536);
				}
				GlStateManager.popMatrix();
			}
		}
	}
}

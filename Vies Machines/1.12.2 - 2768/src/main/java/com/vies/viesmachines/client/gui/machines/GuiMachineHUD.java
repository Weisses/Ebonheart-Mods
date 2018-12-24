package com.vies.viesmachines.client.gui.machines;

import java.awt.Color;
import java.util.ArrayList;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.EntityMachineFlying;
import com.vies.viesmachines.common.entity.machines.types.flying.EntityMachineFlyingAirship;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.GuiIngameForge;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiMachineHUD extends Gui {
	
	private final Minecraft mc = Minecraft.getMinecraft();
	private static FontRenderer fontRenderer;
	private static final ResourceLocation FLYING_HUD_TEXTURE = new ResourceLocation(References.MOD_ID, "textures/gui/hud_machine_flying.png");
	
	private final int hudWidth;
	private final int hudHeight;
	private float speedMod;
	
	private EntityMachineFlyingAirship machine;
	private ArrayList activeBuffIcons = new ArrayList();
	private ArrayList activeDebuffIcons = new ArrayList();
	
	public GuiMachineHUD()
	{
		super();
		
		this.hudWidth = 108;
        this.hudHeight = 26;
        
        this.fontRenderer = this.mc.fontRenderer;
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderFlyingMachineBarPre(RenderGameOverlayEvent.Pre event) 
	{
		if (event.getType() == ElementType.ALL) 
		{
			if (mc.player.getRidingEntity() instanceof EntityMachineBase)
		    {
				GuiIngameForge.renderHealthMount = false;
		    }
			else
			{
				if (GuiIngameForge.renderHealthMount == false)
				{
					GuiIngameForge.renderHealthMount = true;
				}
			}
		}
	}
	
	@SubscribeEvent(priority=EventPriority.NORMAL)
	public void onRenderFlyingMachineBar(RenderGameOverlayEvent.Post event) 
	{
		if (event.getType() == ElementType.ALL) 
		{
			if (mc.player.getRidingEntity() instanceof EntityMachineFlying)
		    {
				this.machine = (EntityMachineFlyingAirship) Minecraft.getMinecraft().player.getRidingEntity();
				
				GlStateManager.enableRescaleNormal();
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	            
	            // Add this block of code before you draw the section of your texture containing transparency:
	 			GlStateManager.pushAttrib();
	 			GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
	 			GlStateManager.disableLighting();
	 			
	 			// Alpha test and blend needed due to vanilla or Forge rendering bug:
	 			GlStateManager.enableAlpha();
	 			GlStateManager.enableBlend();
	 			
	            // Screen resolution:
				ScaledResolution sr = new ScaledResolution(mc);
	            int hudX = sr.getScaledWidth() / 2 - (this.hudWidth / 2); // left edge of GUI
	            int hudY = sr.getScaledHeight() - 56; // top edge of GUI
	            
	            int hudXDefault = hudX + 45;
	            int hudYDefault = hudY;
	         	
	            Minecraft.getMinecraft().getTextureManager().bindTexture(FLYING_HUD_TEXTURE);
				
	            // Renders the Main image:
	            GlStateManager.pushMatrix();
				{
					GlStateManager.translate(hudXDefault, hudYDefault, 0);
					
					// Draw the background static texture:
					this.drawTexturedModalRect(0, 0, 0, 0, 101, 26);
				}
				GlStateManager.popMatrix();
				
				// Machine lights on:
				if (this.machine.getFuel() >= 1
				|| this.mc.player.isCreative())
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault + 84.5, hudYDefault, 0);
						
						// Left Light:
						this.drawTexturedModalRect(0, 0, 101, 0, 4, 7);
					}
					GlStateManager.popMatrix();
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault + 97.5, hudYDefault, 0);
						
						// Right Light:
						this.drawTexturedModalRect(0, 0, 101, 0, 4, 7);
					}
					GlStateManager.popMatrix();
				}
				
				// Is machine armed light:
				if (this.machine.getArmed())
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault + 66.5, hudYDefault + 2, 0);
						
						this.drawTexturedModalRect(0, 0, 101, 7, 5, 5);
					}
					GlStateManager.popMatrix();
				}
				
				
				this.renderBuffIcons(hudXDefault, hudYDefault);
				this.renderDebuffIcons(hudXDefault, hudYDefault);
				
				// Handles Fuel Display logic:
				if (this.mc.player.isCreative())
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault, hudYDefault + 9, 0);
						
						// Draws the 'Creative' fuel bar:
						this.drawTexturedModalRect(0, 0, 128, 8, 101, 7);
					}
					GlStateManager.popMatrix();
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault + 51, hudYDefault + 10.5, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						
						// Draws the black box the 'Creative Mode' text goes over:
						this.drawRect(-25-14, -3, 23+14, 10, Color.BLACK.getRGB());
						//this.drawRect(-25, -3, 23, 9, Color.BLACK.getRGB());
						this.centeredString(fontRenderer, this.stringToRainbow("Creative Mode", false), 0, 0, Color.WHITE.getRGB());
					}
					GlStateManager.popMatrix();
				}
				else
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault, hudYDefault + 9, 0);
						
						int fuelbarwidth = (int)(((float) this.machine.getFuel() / (this.machine.getFuelTotal())) * 101);
						
						// Draws the fuel bar:
						this.drawTexturedModalRect(0, 0, 128, 0, fuelbarwidth, 7);
					}
					GlStateManager.popMatrix();
				}
				
				this.renderHUDMachineHealth(hudXDefault, hudYDefault);
				this.renderHUDMachineEnergy(hudXDefault, hudYDefault);
				this.renderHUDMachineDurability(hudXDefault, hudYDefault);
				
				/*
				//Use for ammo
				if (this.machine.getAmmoType() == 0)
				{
					
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault - 0.875, hudYDefault, 0);
						
						this.drawItemStack(ItemsVM
								//.MACHINE_PELLETS
								.PARTICLE_BULLET_EXPLOSIVE
								.getDefaultInstance(), 0, 0);
					}
					GlStateManager.popMatrix();
					
					
				}
				*/
				
				// Use for ammo:
				if (this.machine.getAmmoType() == 0)
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault - 1.0, hudYDefault, 0);
						
						this.drawItemStack(ItemsVM.PARTICLE_BULLET_NORMAL.getDefaultInstance(), 0, 0, false);
					}
					GlStateManager.popMatrix();
				}
				// Use for ammo:
				if (this.machine.getAmmoType() == 1)
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault - 1.0, hudYDefault, 0);
						
						this.drawItemStack(ItemsVM.PARTICLE_BULLET_ELECTRICAL.getDefaultInstance(), 0, 0, false);
					}
					GlStateManager.popMatrix();
				}
				// Use for ammo:
				if (this.machine.getAmmoType() == 2)
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault - 1.0, hudYDefault, 0);
						
						this.drawItemStack(ItemsVM.PARTICLE_BULLET_EXPLOSIVE.getDefaultInstance(), 0, 0, false);
					}
					GlStateManager.popMatrix();
				}
				
				// Shows the item in the fuel slot regardless of creative or survival:
				if (!this.machine.inventory.getStackInSlot(0).isEmpty())
				{
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(hudXDefault + 16.125, hudYDefault, 0);
						
						this.drawItemStack(this.machine.inventory.getStackInSlot(0).getItem().getDefaultInstance(), 0, 0, true);
					}
					GlStateManager.popMatrix();
				}
				
				this.getSpecialStat(this.machine, hudXDefault, hudYDefault);
				
				
				GlStateManager.popAttrib();
		    }
		}
	}
	
	//==================================================
	
	/**  */
	private TextFormatting getColorTextHealth()
	{
		TextFormatting textColor = TextFormatting.WHITE;
		
		if (this.machine.getHealth() == 0)
		{
			textColor = TextFormatting.BLACK;
		}
		else if (this.machine.getHealth() <= (this.machine.getMaxHealth() * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (this.machine.getHealth() <= (this.machine.getMaxHealth() * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (this.machine.getHealth() <= (this.machine.getMaxHealth() * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (this.machine.getHealth() <= (this.machine.getMaxHealth() * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (this.machine.getHealth() == this.machine.getMaxHealth())
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/**  */
	private TextFormatting getColorTextEnergy()
	{
		TextFormatting textColor = TextFormatting.WHITE;
		
		if (this.machine.getEnergy() == 0)
		{
			textColor = TextFormatting.BLACK;
		}
		else if (this.machine.getEnergy() <= (this.machine.getMaxEnergy() * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (this.machine.getEnergy() <= (this.machine.getMaxEnergy() * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (this.machine.getEnergy() <= (this.machine.getMaxEnergy() * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (this.machine.getEnergy() <= (this.machine.getMaxEnergy() * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (this.machine.getEnergy() == this.machine.getMaxEnergy())
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/**  */
	private TextFormatting getColorTextDurability()
	{
		TextFormatting textColor = TextFormatting.WHITE;
		
		if (this.machine.getDurabilityPercent() <= 1)
		{
			textColor = TextFormatting.DARK_RED;
		}
		else if (this.machine.getDurabilityPercent() <= (100 * 0.24))
		{
			textColor = TextFormatting.RED;
		}
		else if (this.machine.getDurabilityPercent() <= (100 * 0.49))
		{
			textColor = TextFormatting.YELLOW;
		}
		else if (this.machine.getDurabilityPercent() <= (100 * 0.74))
		{
			textColor = TextFormatting.GREEN;
		}
		else if (this.machine.getDurabilityPercent() <= (100 * 0.99))
		{
			textColor = TextFormatting.AQUA;
		}
		else if (this.machine.getDurabilityPercent() == 100)
		{
			textColor = TextFormatting.AQUA;
		}
		
		return textColor;
	}
	
	/** Renders the Machine Health. */
	private void renderHUDMachineHealth(int hudXIn, int hudYIn)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXIn + 13.25, hudYIn + 3.25, 0);
			GlStateManager.scale(0.375, 0.375, 0.375);
			
			this.centeredString(fontRenderer, this.getColorTextHealth() + Integer.toString((int)this.machine.getHealth()), 0, 0, Color.RED.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	/** Renders the Machine Energy. */
	private void renderHUDMachineEnergy(int hudXIn, int hudYIn)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXIn + 32.25, hudYIn + 3.25, 0);
			GlStateManager.scale(0.375, 0.375, 0.375);
			
			this.centeredString(fontRenderer, this.getColorTextEnergy() + Integer.toString((int)this.machine.getEnergy()), 0, 0, Color.YELLOW.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	/** Renders the Machine Durability. */
	private void renderHUDMachineDurability(int hudXIn, int hudYIn)
	{
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXIn + 51.25, hudYIn + 3.25, 0);
			GlStateManager.scale(0.375, 0.375, 0.375);
			
			this.centeredString(fontRenderer, this.getColorTextDurability() + Integer.toString((int)this.machine.getDurabilityPercent()) + "%", 0, 0, Color.GREEN.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	/** Draws an ItemStack with stack size. */
    private void drawItemStack(ItemStack stack, int xIn, int yIn, boolean size)
    {
    	GlStateManager.pushMatrix();
		{
			GlStateManager.translate(xIn + 73.35, yIn + 1.5, 0);
			GlStateManager.scale(0.41, 0.41, 0.41);
			
			Minecraft.getMinecraft().getRenderItem().renderItemAndEffectIntoGUI(stack, 0, 0);
			if (size)
			{
				Minecraft.getMinecraft().getRenderItem().renderItemOverlayIntoGUI(this.fontRenderer, stack, 0, 0, Integer.toString(this.machine.inventory.getStackInSlot(0).getCount()));
			}
		}
		GlStateManager.popMatrix();
    }
    
    /** Makes the inserted string centered with no shadow. */
    public void centeredString(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, (x - fontRendererIn.getStringWidth(text) / 2), y, color);
    }
	
	/** Makes the inserted string rainbow colored. */
	protected static String stringToRainbow(String parString, boolean parReturnToBlack)
	{
	   int stringLength = parString.length();
	   
	   if (stringLength < 1)
	   {
	      return "";
	   }
	   
	   String outputString = "";
	   
	   TextFormatting[] colorChar = 
	      {
	         TextFormatting.RED,
	         TextFormatting.DARK_RED,
	         TextFormatting.GOLD,
	         TextFormatting.YELLOW,
	         TextFormatting.GREEN,
	         TextFormatting.DARK_GREEN,
	         TextFormatting.AQUA,
	         TextFormatting.BLUE,
	         TextFormatting.LIGHT_PURPLE,
	         TextFormatting.DARK_PURPLE
	      };
	   
	   for (int i = 0; i < stringLength; i++)
	   {
	      outputString = outputString+colorChar[i%8]+parString.substring(i, i+1);
	   }
	   
	   // Return color to a common one after (most chat is white, but for other GUI might want black):
	   if (parReturnToBlack)
	   {
	      return outputString+TextFormatting.BLACK;
	   }
	   
	   return outputString+TextFormatting.WHITE;
	}
    
	/** Renders buff icons. */
	private void renderBuffIcons(int hudXDefault, int hudYDefault)
	{
		// Clears the buff array:
		this.activeBuffIcons.clear();
		
		// Checks what is active and adds them to the buff array:
		// Special ammo use on:
		if (this.machine.getArmed()
		&& this.machine.getAmmoAmount() > 0
		&& this.machine.getAmmoType() > 0)
		{
			this.activeBuffIcons.add(0);
		}
		
		// Autorun on:
		if (this.machine.getAutorun())
		{
			this.activeBuffIcons.add(12);
		}
		
		//TO BE DETERMINED:
		//if (this.machine.getPoweredOn())
		//{
			//this.activeBuffIcons.add(24);
		//}
		
		// Checks if the buff array has something in it:
		if (!this.activeBuffIcons.isEmpty())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXDefault + 1.75, hudYDefault + 17.5, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				// Renders the active buff icons in order:
				for (int i = 0; i < this.activeBuffIcons.size(); i++)
				{
					this.drawTexturedModalRect((i * 16), 0, 244, (int) this.activeBuffIcons.get(i), 12, 12);
				}
			}
			GlStateManager.popMatrix();
		}
	}
    
	/** Renders debuff icons. */
	private void renderDebuffIcons(int hudXDefault, int hudYDefault)
	{
		// Clears the debuff array:
		this.activeDebuffIcons.clear();
		
		// Checks what is active and adds them to the debuff array:
		// Durability warnings:
		if (this.machine.getDurabilityPercent() <= 4)
		{
			this.activeDebuffIcons.add(12);
		}
		else if (this.machine.getDurabilityPercent() <= 24)
		{
			this.activeDebuffIcons.add(0);
		}
		
		// Static charge buildup:
		if (this.machine.getPrimedForLightningStrike() > 0)
		{
			this.activeDebuffIcons.add(24);
		}
		
		// Checks if the array has something in it:
		if (!this.activeDebuffIcons.isEmpty())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(hudXDefault + 1.75, hudYDefault + 17.5, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				String test = "";
				
				// Renders the active debuff icons in order:
				for (int i = 0; i < this.activeDebuffIcons.size(); i++)
				{
					Minecraft.getMinecraft().getTextureManager().bindTexture(FLYING_HUD_TEXTURE);
					
					this.drawTexturedModalRect(51 + (i * 16), 0, 232, (int) this.activeDebuffIcons.get(i), 12, 12);
					
					if (Integer.parseInt(this.activeDebuffIcons.get(i).toString()) == 24)
					{
						GlStateManager.translate(59 + (i * 16), 7, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						test = Integer.toString(this.machine.getPrimedForLightningStrike());
						this.centeredString(fontRenderer, test, 0, 0, Color.WHITE.getRGB());
						
						Minecraft.getMinecraft().getTextureManager().bindTexture(FLYING_HUD_TEXTURE);
					}
				}
			}
			GlStateManager.popMatrix();
		}
	}
	
	private void getSpecialStat(EntityMachineFlyingAirship machineIn, int hudXDefault, int hudYDefault)
	{
		// Current Y:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXDefault + 71.75, hudYDefault + 19, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			
			//Makes Current Altitude color Red
			if(machineIn.getPosition().getY() >= (int)EnumsVM.FlyingMachineComponentTier.byId(machineIn.getTierComponent()).getMaxElevationModifier() - 5)
			{
				this.centeredString(fontRenderer, Integer.toString((int)machineIn.posY), 0, 0, Color.RED.getRGB());
			}
			//Makes Current Altitude color Yellow
			else if(machineIn.getPosition().getY() >= (int)EnumsVM.FlyingMachineComponentTier.byId(machineIn.getTierComponent()).getMaxElevationModifier() - 15)
			{
				this.centeredString(fontRenderer, Integer.toString((int)machineIn.posY), 0, 0, Color.YELLOW.getRGB());
			}
			//Makes Current Altitude color Green
			else
			{
				this.centeredString(fontRenderer, Integer.toString((int)machineIn.posY), 0, 0, Color.GREEN.getRGB());
			}
			
			
			
		}
		GlStateManager.popMatrix();
		// Max Y:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(hudXDefault + 87.25, hudYDefault + 19, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			
			if (machineIn.getTierComponent() >= 3)
			{
				this.centeredString(fontRenderer, "\u221e", 0, 0, Color.CYAN.getRGB());
			}
			else
			{
				this.centeredString(fontRenderer, Integer.toString(machineIn.getMaxElevation()), 0, 0, Color.CYAN.getRGB());
			}
			
		}
		GlStateManager.popMatrix();
	}
}

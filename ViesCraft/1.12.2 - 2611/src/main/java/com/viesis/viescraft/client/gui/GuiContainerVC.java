package com.viesis.viescraft.client.gui;

import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.text.TextFormatting;

public class GuiContainerVC extends GuiContainer {
	
	public static int textRedNumber;
	public static int textGreenNumber;
	public static int textBlueNumber;
	
	public static boolean frameTransparentInfo;
	public static boolean balloonTransparentInfo;
	
	public static String textNameStorage;
	
	public static int storedRedstone;
	
	public static int metaInfo;
	
	public IInventory playerInv;
	public EntityAirshipCore airship;
	
	public GuiContainerVC(Container inventorySlotsIn) 
	{
		super(inventorySlotsIn);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		
	}
	
	/**
	 * Makes the inserted string flash.
	 */
	protected static String stringToGolden(String parString, int parShineLocation, boolean parReturnToBlack, TextFormatting colorIn)
	{
	   int stringLength = parString.length();
	   
	   if(stringLength < 1)
	   {
	      return "";
	   }
	   
	   String outputString = "";
	   
	   for(int i = 0; i < stringLength; i++)
	   {
	      if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 0)
	      {
	         outputString = outputString + TextFormatting.WHITE + parString.substring(i, i + 1);    
	      }
	      else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 1)
	      {
	          outputString = outputString + TextFormatting.YELLOW + parString.substring(i, i + 1);    
	      }
	      else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 87)
	      {
	         outputString = outputString + TextFormatting.YELLOW + parString.substring(i, i + 1);    
	      }
	      else
	      {
	         outputString = outputString + colorIn + parString.substring(i, i + 1);        
	      }
	   }
	   
	   // return color to a common one after (most chat is white, but for other GUI might want black)
	   if(parReturnToBlack)
	   {
	      return outputString + TextFormatting.BLACK;
	   }
	   
	   return outputString + TextFormatting.WHITE;
	}
	
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
	         TextFormatting.GOLD,
	         TextFormatting.YELLOW,
	         TextFormatting.GREEN,
	         TextFormatting.AQUA,
	         TextFormatting.BLUE,
	         TextFormatting.LIGHT_PURPLE,
	         TextFormatting.DARK_PURPLE
	      };
	   for (int i = 0; i < stringLength; i++)
	   {
	      outputString = outputString+colorChar[i%8]+parString.substring(i, i+1);
	   }
	   // return color to a common one after (most chat is white, but for other GUI might want black)
	   if (parReturnToBlack)
	   {
	      return outputString+TextFormatting.BLACK;
	   }
	   return outputString+TextFormatting.WHITE;
	}
    
    protected FontRenderer getFontRenderer()
    {
        return this.mc.fontRenderer;
    }
}

package com.viesis.viescraft.client.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	/**
	 * Makes the inserted string flash.
	 */
	protected static String stringToFlashGolden(String parString, int parShineLocation, boolean parReturnToBlack, TextFormatting colorIn)
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
	
	/**
     * Draws an ItemStack.
     */
    protected void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
	
	/**
     * Draws a Rotating ItemStack.
     */
    protected void drawRotatingItemStack(ItemStack stack, int posXIn, int posYIn)
    {
    	GlStateManager.pushMatrix();
		{
			float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        GlStateManager.translate(posXIn, posYIn, 50F);
	        GlStateManager.scale(50, 50, 0);
	        
	        //Flips/rotates the model right side up.
            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
            
            //if(isBlockIn)
            //{
            //	GlStateManager.rotate(25.0F, 1.0F, 0.0F, 0.0F);
            //}
            
	        //Spins Item
	        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
            
	        Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
		}
		GlStateManager.popMatrix();
    }
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipBaseVC entityIn)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glCullFace(GL11.GL_FRONT);
	        
	        GlStateManager.translate(posX, posY, 100.0F);
	        GlStateManager.scale((float)(scale), (float)scale, (float)scale);
	        
	        /////Flips the model right side up.
	        GlStateManager.rotate(200.0F, 0.0F, 0.0F, 1.0F);
	        GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(30.0F, 1.0F, 0.0F, 0.0F);
	        
	        //Fixes the position to be at a right
	        GlStateManager.rotate(entityIn.prevRotationYaw, 0.0F, 1.0F, 0.0F);
	        
	        RenderHelper.disableStandardItemLighting();
	        
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        
	        //This is the non-multipass rendering way to render an entity.
	        //rendermanager.renderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        rendermanager.renderEntityStatic(entityIn, 0, false);
	        rendermanager.renderMultipass(entityIn, 0F);
	        
	        rendermanager.setRenderShadow(true);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
    }
}

package com.viesis.viescraft.client.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.buttons.GuiButtonMenuCustomizeVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonMenuMainVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonMenuModuleVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonMenuRedstoneVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonMenuUpgradeVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.module.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.redstone.MessageGuiRedstoneMenu;
import com.viesis.viescraft.network.server.airship.upgrade.MessageGuiUpgradeMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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
	public static int itemstackInfo;
	public static int itemstackMetaInfo;
	public static int headInfo;
	public static int supporterHeadInfo;
	public static int holidayInfo;
	
	protected IInventory playerInv;
	protected EntityAirshipBaseVC airship;
	
	public GuiContainerVC(Container inventorySlotsIn, IInventory playerInvIn, EntityAirshipBaseVC airshipIn) 
	{
		super(inventorySlotsIn);

		this.playerInv = playerInvIn;
		this.airship = airshipIn;
		
		this.xSize = 176;
		this.ySize = 202;
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVC.buttonMM1 = new GuiButtonMenuMainVC(1001, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonMM2 = new GuiButtonMenuUpgradeVC(1002, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 0);
    	GuiVC.buttonMM3 = new GuiButtonMenuCustomizeVC(1003, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 0);
    	GuiVC.buttonMM4 = new GuiButtonMenuModuleVC(1004, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 0);
    	GuiVC.buttonMM5 = new GuiButtonMenuRedstoneVC(1005, this.guiLeft - 35, this.guiTop + 7 + (16 * 6), 36, 14, "", 0);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		//if (parButton.id == 1)
	    //{
			//Lesser Storage
        //	if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        //	{
        //		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageLesser());
        //	}
        	//Normal Storage
        //	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        //	{
        //		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageNormal());
        //	}
        	//Greater Storage
        //	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        //	{
        //		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageGreater());
        //	}
        	//Any Music
        //	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    	//		 || this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    	//		 || this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
        //	{
        //		NetworkHandler.sendToServer(new MessageGuiMainMenuMusic());
        //	}
        	//Default for airship gui
        //	else
        //	{
        //		NetworkHandler.sendToServer(new MessageGuiMainMenu());
        //	}
	    //}
		if (parButton.id == 1001)
	    {
			NetworkHandler.sendToServer(new MessageGuiMainMenu());
	    }
		if (parButton.id == 1002)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 1003)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		if (parButton.id == 1004)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		if (parButton.id == 1005)
	    {
			NetworkHandler.sendToServer(new MessageGuiRedstoneMenu());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		//Draws the left Redstone extension for the current Redstone amount
		this.drawRect(this.guiLeft - 35, this.guiTop + 117, this.guiLeft + 1, this.guiTop + 137, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft - 34, this.guiTop + 118, this.guiLeft, this.guiTop + 136, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft - 32, this.guiTop + 120, this.guiLeft - 2, this.guiTop + 134, Color.BLACK.getRGB());
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		//Balance
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 121.5, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.available"), 0, false, TextFormatting.DARK_GREEN), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		//Redstone amount
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 127, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(Integer.toString(this.airship.getStoredRedstone()), 0, false, TextFormatting.WHITE), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
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

        if(!this.mc.player.isEntityAlive() 
         || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	//==============================
	
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
	        
	        if(stack.getItem() instanceof ItemBlock)
			{
	        	GlStateManager.rotate(25.0F, 1.0F, 0.0F, 0.0F);
	        	GlStateManager.translate(posXIn, posYIn, 0F);
            	GlStateManager.translate(0F, -5.0F, 0F);
            	GlStateManager.scale(50, 50, 50);
            	
            	//Spins Item
    	        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
			}
	        else
	        {
	        	GlStateManager.translate(posXIn, posYIn, 50F);
		        GlStateManager.scale(50, 50, 0);
		        
		        //Flips/rotates the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	        }
			
	        
            
            
            
	        
            
	        Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
		}
		GlStateManager.popMatrix();
    }
	
	/**
     * Draws an Entity Head.
     */
    protected void drawEntityHead(int xIn, int yIn, int skullType)
    {
    	
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/gui_heads.png"));
	    	
	    	GlStateManager.translate(this.guiLeft + 41 + xIn, this.guiTop + 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		
    	

			
	        
	        /////Flips the model right side up.
	        //GlStateManager.rotate(200.0F, 0.0F, 0.0F, 1.0F);
	        //GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
	        //GlStateManager.rotate(30.0F, 1.0F, 0.0F, 0.0F);
	        
	        //Fixes the position to be at a right
	        //GlStateManager.rotate(entityIn.prevRotationYaw, 0.0F, 1.0F, 0.0F);
	        
	        RenderHelper.disableStandardItemLighting();
	        
	        //RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        //rendermanager.setPlayerViewY(180.0F);
	        //rendermanager.setRenderShadow(false);
	        
	        //This is the non-multipass rendering way to render an entity.
	        //rendermanager.renderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        //rendermanager.renderEntityStatic(entityIn, 0, false);
	        //rendermanager.renderMultipass(entityIn, 0F);
	        
	        //rendermanager.setRenderShadow(true);
		}
		GlStateManager.popMatrix();
    }
	
	/**
     * Draws a Supporter Head.
     */
    protected void drawEntitySupporterHead(int xIn, int yIn, int skullType)
    {
    	
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/gui_supporter_heads.png"));
	    	
	    	GlStateManager.translate(this.guiLeft + 41 + xIn, this.guiTop + 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		
    	

			
	        
	        /////Flips the model right side up.
	        //GlStateManager.rotate(200.0F, 0.0F, 0.0F, 1.0F);
	        //GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
	        //GlStateManager.rotate(30.0F, 1.0F, 0.0F, 0.0F);
	        
	        //Fixes the position to be at a right
	        //GlStateManager.rotate(entityIn.prevRotationYaw, 0.0F, 1.0F, 0.0F);
	        
	        RenderHelper.disableStandardItemLighting();
	        
	        //RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        //rendermanager.setPlayerViewY(180.0F);
	        //rendermanager.setRenderShadow(false);
	        
	        //This is the non-multipass rendering way to render an entity.
	        //rendermanager.renderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        //rendermanager.renderEntityStatic(entityIn, 0, false);
	        //rendermanager.renderMultipass(entityIn, 0F);
	        
	        //rendermanager.setRenderShadow(true);
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

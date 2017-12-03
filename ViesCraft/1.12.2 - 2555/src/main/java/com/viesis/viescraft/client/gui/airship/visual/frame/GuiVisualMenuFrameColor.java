package com.viesis.viescraft.client.gui.airship.visual.frame;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuFrameColor;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiVisualMenuFrameColor extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;

	private GuiTextField textRed;
	private GuiTextField textGreen;
	private GuiTextField textBlue;
	
	public static int textRedNumber;
	public static int textGreenNumber;
	public static int textBlueNumber;
	
	public static boolean isColored;
	
	private GuiButton buttonAccept;
	
	public GuiVisualMenuFrameColor(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipAppearance(playerInv, airshipIn));
		
		this.playerInv = playerInv;
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
    	int startPlace = 49;
    	
        this.textRed = new GuiTextField(11, this.fontRenderer, this.guiLeft + 63, this.guiTop + 66, 28, 20);
        textRed.setMaxStringLength(3);
        textRed.setText(String.valueOf(this.textRedNumber));
    	this.textRed.setFocused(false);
    	
    	this.textGreen = new GuiTextField(12, this.fontRenderer, this.guiLeft + 63, this.guiTop + 110, 28, 20);
        textGreen.setMaxStringLength(3);
        textGreen.setText(String.valueOf(this.textGreenNumber));
    	this.textGreen.setFocused(false);
    	
    	this.textBlue = new GuiTextField(13, this.fontRenderer, this.guiLeft + 63, this.guiTop + 154, 28, 20);
        textBlue.setMaxStringLength(3);
        textBlue.setText(String.valueOf(this.textBlueNumber));
    	this.textBlue.setFocused(false);
    	
        //=============================================
        
    	GuiVC.buttonRed = new GuiButtonGeneralVC( 11, this.guiLeft + 13, this.guiTop + 68, 37, 14, "Save");
		this.buttonList.add(GuiVC.buttonRed);
		
		GuiVC.buttonGreen = new GuiButtonGeneralVC( 12, this.guiLeft + 13, this.guiTop + 112, 37, 14, "Save");
		this.buttonList.add(GuiVC.buttonGreen);
		
		GuiVC.buttonBlue = new GuiButtonGeneralVC( 13, this.guiLeft + 13, this.guiTop + 156, 37, 14, "Save");
		this.buttonList.add(GuiVC.buttonBlue);
		
		GuiVC.buttonRemoveColor = new GuiButtonGeneralVC( 14, this.guiLeft + 13, this.guiTop + 34, 77, 14, "Remove Color");
		this.buttonList.add(GuiVC.buttonRemoveColor);
		
        //=============================================
        
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 32, this.guiTop + 10, 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 32, this.guiTop + 24, 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 32, this.guiTop + 38, 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 32, this.guiTop + 52, 36, 14, "", 3);
    	
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, "Back");
    	
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.button505);
		
		GuiVC.buttonM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			//If airship has small inv module installed
        	if(this.airship.getModuleVariantSlot1() == 3)
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageLesser());
        	}
        	//If airship has large inv module installed
        	else if(this.airship.getModuleVariantSlot1() == 4)
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageGreater());
        	}
        	//If airship has jukebox module installed
        	else if(this.airship.getModuleVariantSlot1() == 10)
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuMusic());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenu());
        	}
	    }
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 3)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenu());
	    }
		if (parButton.id == 4)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenu());
	    }
		
		if (parButton.id == 11)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
				
				if(textRedNumber > 255)
				{
					textRedNumber = 255;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
				
				if(textGreenNumber > 255)
				{
					textGreenNumber = 255;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
				
				if(textBlueNumber > 255)
				{
					textBlueNumber = 255;
				}
			}
			
			this.isColored = true;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameColor());
	    }
		
		if (parButton.id == 12)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
				
				if(textRedNumber > 255)
				{
					textRedNumber = 255;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
				
				if(textGreenNumber > 255)
				{
					textGreenNumber = 255;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
				
				if(textBlueNumber > 255)
				{
					textBlueNumber = 255;
				}
			}
			
			this.isColored = true;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameColor());
	    }
		
		if (parButton.id == 13)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
				
				if(textRedNumber > 255)
				{
					textRedNumber = 255;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
				
				if(textGreenNumber > 255)
				{
					textGreenNumber = 255;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
				
				if(textBlueNumber > 255)
				{
					textBlueNumber = 255;
				}
			}
			
			this.isColored = true;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameColor());
	    }
		
		if (parButton.id == 14)
	    {
			this.textRedNumber = 0;
			this.textGreenNumber = 0;
			this.textBlueNumber = 0;
			
			this.isColored = false;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameColor());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_menu_visual_frame_color.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
        float red = this.textRedNumber / 255.0f;
        float green = this.textGreenNumber / 255.0f;
        float blue = this.textBlueNumber / 255.0f;
        
        //Color Box made from the r/g/b values
        GlStateManager.color(red, green, blue, 1.0F);
        this.drawTexturedModalRect(this.guiLeft + 106, this.guiTop + 148, 176, 0, 64, 25);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        //Color name of the Color Box made from the r/g/b values
  		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 110, this.guiTop + 140.5, 0);
  			GlStateManager.scale(.65, .65, .65);
      		
  			if(this.airship.getFrameVisualColor())
  			{
  				this.fontRenderer.drawString("- " + ColorHelperVC.getColorNameFromRgb(this.textRedNumber, this.textGreenNumber, this.textBlueNumber), 0, 0, 16777215);
  			}
  			else
  			{
  				this.fontRenderer.drawString("- None", 0, 0, 16777215);
  			}
		}
		GlStateManager.popMatrix();
        
    	this.fontRenderer.drawString("Red", this.guiLeft + 23, this.guiTop + 55, 16711680);
		this.fontRenderer.drawString("Green", this.guiLeft + 17, this.guiTop + 99, 32768);
		this.fontRenderer.drawString("Blue", this.guiLeft + 21, this.guiTop + 143, 255);
		
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 55, 16777215);
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 99, 16777215);
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 143, 16777215);
    	
    	this.textRed.drawTextBox();
    	this.textGreen.drawTextBox();
    	this.textBlue.drawTextBox();
    	
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawEntityOnScreen(i + 141, j + 126, 15, mouseX, mouseY, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString("Frame Color", 58, 18, 11111111);
		this.fontRenderer.drawString("Appearance", 58, -10, 65521);
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		super.keyTyped(typedChar, keyCode);
		
        this.textRed.textboxKeyTyped(typedChar, keyCode);
        this.textGreen.textboxKeyTyped(typedChar, keyCode);
        this.textBlue.textboxKeyTyped(typedChar, keyCode);
        
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
        
        this.textRed.updateCursorCounter();
        this.textGreen.updateCursorCounter();
        this.textBlue.updateCursorCounter();
        
        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
        
        this.textRed.mouseClicked(x, y, btn);
        this.textGreen.mouseClicked(x, y, btn);
        this.textBlue.mouseClicked(x, y, btn);
    }
	
	/**
     * Draws an ItemStack.
     */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
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
     * Draws an entity on the screen looking toward the cursor.
     */
    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, Entity entityIn)
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
	        
	        RenderHelper.disableStandardItemLighting();
	        
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        rendermanager.renderMultipass(entityIn, 0);
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        rendermanager.renderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        rendermanager.setRenderShadow(true);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
    }
}

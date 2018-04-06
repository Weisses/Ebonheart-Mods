package com.viesis.viescraft.client.gui.airship.customize.balloon;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonMain;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageHelperGuiCustomizeMenuBalloonColorDefault;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuBalloonColor extends GuiContainerVC {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;

	private GuiTextField textRed;
	private GuiTextField textGreen;
	private GuiTextField textBlue;
	
	private GuiButton buttonAccept;
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_color.png");
	
	public GuiCustomizeMenuBalloonColor(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
		
		this.textRedNumber = this.airship.balloonPatternColorRed;
		this.textGreenNumber = this.airship.balloonPatternColorGreen;
		this.textBlueNumber = this.airship.balloonPatternColorBlue;
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
    	
        this.textRed = new GuiTextField(11, this.fontRenderer, this.guiLeft + 63, this.guiTop + 57-6, 28, 20);
        textRed.setMaxStringLength(3);
        textRed.setText(String.valueOf(this.textRedNumber));
    	this.textRed.setFocused(false);
    	this.textRed.setTextColor(Color.RED.getRGB());
    	
    	this.textGreen = new GuiTextField(12, this.fontRenderer, this.guiLeft + 63, this.guiTop + 98-3, 28, 20);
        textGreen.setMaxStringLength(3);
        textGreen.setText(String.valueOf(this.textGreenNumber));
    	this.textGreen.setFocused(false);
    	this.textGreen.setTextColor(Color.GREEN.getRGB());
    	
    	this.textBlue = new GuiTextField(13, this.fontRenderer, this.guiLeft + 63, this.guiTop + 139, 28, 20);
        textBlue.setMaxStringLength(3);
        textBlue.setText(String.valueOf(this.textBlueNumber));
    	this.textBlue.setFocused(false);
    	this.textBlue.setTextColor(Color.BLUE.getRGB());
    	
        //=============================================
        
    	GuiVC.buttonRed = new GuiButtonGeneral1VC( 11, this.guiLeft + 13, this.guiTop + 60-6, 37, 14, References.localNameVC("vc.button.save"), 3);
		this.buttonList.add(GuiVC.buttonRed);
		
		GuiVC.buttonGreen = new GuiButtonGeneral1VC( 12, this.guiLeft + 13, this.guiTop + 101-3, 37, 14, References.localNameVC("vc.button.save"), 3);
		this.buttonList.add(GuiVC.buttonGreen);
		
		GuiVC.buttonBlue = new GuiButtonGeneral1VC( 13, this.guiLeft + 13, this.guiTop + 142, 37, 14, References.localNameVC("vc.button.save"), 3);
		this.buttonList.add(GuiVC.buttonBlue);
		
		GuiVC.buttonRemoveColor = new GuiButtonGeneral1VC( 14, this.guiLeft + 13, this.guiTop + 177, 77, 14, References.localNameVC("vc.button.defaultcolor"), 1);
		this.buttonList.add(GuiVC.buttonRemoveColor);
		
        //=============================================
        
		GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 3);
		
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
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
        	if(this.airship.getModuleActiveSlot1() == 3)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageLesser());
        	}
        	//If airship has large inv module installed
        	else if(this.airship.getModuleActiveSlot1() == 4)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageGreater());
        	}
        	//If airship has jukebox module installed
        	else if(this.airship.getModuleActiveSlot1() == 10)
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuMusic());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenu());
        	}
	    }
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 3)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		if (parButton.id == 4)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
		//Back to main customize gui menu
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonMain());
	    }
		
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonColor());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonColor());
	    }
		if (parButton.id == 13)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonColor());
	    }
		
		if (parButton.id == 14)
	    {
			this.textRedNumber = 200;
			this.textGreenNumber = 180;
			this.textBlueNumber = 140;
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonColorDefault());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
        float red = this.textRedNumber / 255.0f;
        float green = this.textGreenNumber / 255.0f;
        float blue = this.textBlueNumber / 255.0f;
        
        //Color Box made from the r/g/b values
        GlStateManager.color(red, green, blue, 1.0F);
        this.drawTexturedModalRect(this.guiLeft + 106, this.guiTop + 140, 176, 0, 64, 25);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        //Color name of the Color Box made from the r/g/b values
  		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 110, this.guiTop + 132.5, 0);
  			GlStateManager.scale(.65, .65, .65);
      		
  			this.fontRenderer.drawString("- " + ColorHelperVC.getColorNameFromRgb(this.textRedNumber, this.textGreenNumber, this.textBlueNumber), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
        
    	this.fontRenderer.drawString(References.localNameVC("vc.main.red"), this.guiLeft + 23, this.guiTop + 48-6, Color.RED.getRGB());
		this.fontRenderer.drawString(References.localNameVC("vc.main.green"), this.guiLeft + 17, this.guiTop + 89-3, Color.GREEN.getRGB());
		this.fontRenderer.drawString(References.localNameVC("vc.main.blue"), this.guiLeft + 21, this.guiTop + 130, Color.BLUE.getRGB());
		
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 48-6, Color.RED.getRGB());
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 89-3, Color.GREEN.getRGB());
    	this.fontRenderer.drawString("0-255", this.guiLeft + 62, this.guiTop + 130, Color.BLUE.getRGB());
    	
    	this.textRed.drawTextBox();
    	this.textGreen.drawTextBox();
    	this.textBlue.drawTextBox();
    	
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134+3, this.guiTop + 107+7.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden("Stored Redstone", 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.RED;
		
		if(this.airship.storedRedstone >= 500)
		{
			redstoneColor = Color.CYAN;
		}
		else if(this.airship.storedRedstone >= 375)
		{
			redstoneColor = Color.GREEN;
		}
		else if(this.airship.storedRedstone >= 250)
		{
			redstoneColor = Color.YELLOW;
		}
		else if(this.airship.storedRedstone >= 125)
		{
			redstoneColor = Color.ORANGE;
		}
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 127+3, this.guiTop + 113.5+8, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134.25+3, this.guiTop + 113.5+8, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 142+3, this.guiTop + 113.5+8, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
        this.drawEntityOnScreen(this.guiLeft + 138, this.guiTop + 100, 13, mouseX, mouseY, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.ballooncolor"), 55, 16, 11111111);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		super.keyTyped(typedChar, keyCode);
		
        this.textRed.textboxKeyTyped(typedChar, keyCode);
        this.textGreen.textboxKeyTyped(typedChar, keyCode);
        this.textBlue.textboxKeyTyped(typedChar, keyCode);
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        if(textRed.getText() != null)
		{
    		try 
			{
				textRedNumber = Integer.parseInt(textRed.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textRed.setText("0");
				textRedNumber = 0;
			}
    		
			if(textRedNumber > 255)
			{
				textRed.setText("255");
				textRedNumber = 255;
			}
		}
        
        if(textGreen.getText() != null)
		{
    		try 
			{
				textGreenNumber = Integer.parseInt(textGreen.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textGreen.setText("0");
				textGreenNumber = 0;
			}
    		
			if(textGreenNumber > 255)
			{
				textGreen.setText("255");
				textGreenNumber = 255;
			}
		}
        
        if(textBlue.getText() != null)
		{
    		try 
			{
				textBlueNumber = Integer.parseInt(textBlue.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textBlue.setText("0");
				textBlueNumber = 0;
			}
    		
			if(textBlueNumber > 255)
			{
				textBlue.setText("255");
				textBlueNumber = 255;
			}
		}
        
        this.textRed.updateCursorCounter();
        this.textGreen.updateCursorCounter();
        this.textBlue.updateCursorCounter();
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
     * Draws an entity on the screen looking toward the cursor.
     */
    protected void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityAirshipBaseVC entityIn)
    {
    	int currentR = entityIn.balloonPatternColorRed;
    	int currentG = entityIn.balloonPatternColorGreen;
    	int currentB = entityIn.balloonPatternColorBlue;
    	
        entityIn.balloonPatternColorRed = textRedNumber;
        entityIn.balloonPatternColorGreen = textGreenNumber;
        entityIn.balloonPatternColorBlue = textBlueNumber;
        
        super.drawEntityOnScreen(posX, posY, scale, mouseX, mouseY, entityIn);
    	
        entityIn.balloonPatternColorRed = currentR;
        entityIn.balloonPatternColorGreen = currentG;
        entityIn.balloonPatternColorBlue = currentB;
    }
}

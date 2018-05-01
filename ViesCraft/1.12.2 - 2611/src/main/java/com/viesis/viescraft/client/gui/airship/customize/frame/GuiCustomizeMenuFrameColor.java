package com.viesis.viescraft.client.gui.airship.customize.frame;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.ColorHelperVC;
import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColor;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColorDefault;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuFrameColor extends GuiContainerVC {
	
	private GuiTextField textRed;
	private GuiTextField textGreen;
	private GuiTextField textBlue;
	
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_color.png");
	
	public GuiCustomizeMenuFrameColor(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.textRedNumber = this.airship.frameSkinColorRed;
		this.textGreenNumber = this.airship.frameSkinColorGreen;
		this.textBlueNumber = this.airship.frameSkinColorBlue;
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
    	int buttonStart = 107;
    	
        this.textRed = new GuiTextField(11, this.fontRenderer, this.guiLeft + 8, this.guiTop + 65, 26, 18);
        textRed.setMaxStringLength(3);
        textRed.setText(String.valueOf(this.textRedNumber));
    	this.textRed.setFocused(false);
    	this.textRed.setTextColor(Color.RED.getRGB());
    	
    	this.textGreen = new GuiTextField(12, this.fontRenderer, this.guiLeft + 41, this.guiTop + 65, 26, 18);
        textGreen.setMaxStringLength(3);
        textGreen.setText(String.valueOf(this.textGreenNumber));
    	this.textGreen.setFocused(false);
    	this.textGreen.setTextColor(Color.GREEN.getRGB());
    	
    	this.textBlue = new GuiTextField(13, this.fontRenderer, this.guiLeft + 74, this.guiTop + 65, 26, 18);
        textBlue.setMaxStringLength(3);
        textBlue.setText(String.valueOf(this.textBlueNumber));
    	this.textBlue.setFocused(false);
    	this.textBlue.setTextColor(Color.BLUE.getRGB());
    	
        //=============================================
        
		GuiVC.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 13, this.guiTop + 177, 48, 14, References.localNameVC("vc.button.apply"), 1);
		this.buttonList.add(GuiVC.button501);
		
		GuiVC.button502 = new GuiButtonGeneral2VC(502, this.guiLeft + 63, this.guiTop + 177, 48, 14, References.localNameVC("vc.button.default"), 1);
		this.buttonList.add(GuiVC.button502);
		
        //=============================================
        
		GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.button01 = new GuiButtonGeneral1VC(201, this.guiLeft + 6, this.guiTop + buttonStart, 32, 14, References.localNameVC("Red"), 0);
    	GuiVC.button02 = new GuiButtonGeneral1VC(202, this.guiLeft + 38, this.guiTop + buttonStart, 32, 14, References.localNameVC("Green"), 0);
    	GuiVC.button03 = new GuiButtonGeneral1VC(203, this.guiLeft + 70, this.guiTop + buttonStart, 32, 14, References.localNameVC("Blue"), 0);
    	
    	GuiVC.button04 = new GuiButtonGeneral1VC(204, this.guiLeft + 6, this.guiTop + buttonStart + (14 * 1), 32, 14, References.localNameVC("Yellow"), 0);
    	GuiVC.button05 = new GuiButtonGeneral1VC(205, this.guiLeft + 38, this.guiTop + buttonStart + (14 * 1), 32, 14, References.localNameVC("Magenta"), 0);
    	GuiVC.button06 = new GuiButtonGeneral1VC(206, this.guiLeft + 70, this.guiTop + buttonStart + (14 * 1), 32, 14, References.localNameVC("Cyan"), 0);
    	
    	GuiVC.button07 = new GuiButtonGeneral1VC(207, this.guiLeft + 6, this.guiTop + buttonStart + (14 * 2), 32, 14, References.localNameVC("Orange"), 0);
    	GuiVC.button08 = new GuiButtonGeneral1VC(208, this.guiLeft + 38, this.guiTop + buttonStart + (14 * 2), 32, 14, References.localNameVC("Purple"), 0);
    	GuiVC.button09 = new GuiButtonGeneral1VC(209, this.guiLeft + 70, this.guiTop + buttonStart + (14 * 2), 32, 14, References.localNameVC("Teal"), 0);
    	
    	GuiVC.button10 = new GuiButtonGeneral1VC(210, this.guiLeft + 6, this.guiTop + buttonStart + (14 * 3), 32, 14, References.localNameVC("Crimson"), 0);
    	GuiVC.button11 = new GuiButtonGeneral1VC(211, this.guiLeft + 38, this.guiTop + buttonStart + (14 * 3), 32, 14, References.localNameVC("Gold"), 0);
    	GuiVC.button12 = new GuiButtonGeneral1VC(212, this.guiLeft + 70, this.guiTop + buttonStart + (14 * 3), 32, 14, References.localNameVC("Violet"), 0);
    	
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.button01);
		this.buttonList.add(GuiVC.button02);
		this.buttonList.add(GuiVC.button03);
		this.buttonList.add(GuiVC.button04);
		this.buttonList.add(GuiVC.button05);
		this.buttonList.add(GuiVC.button06);
		this.buttonList.add(GuiVC.button07);
		this.buttonList.add(GuiVC.button08);
		this.buttonList.add(GuiVC.button09);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		//Back to main customize gui menu
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameMain());
	    }
		
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameColor());
	    }
		
		if (parButton.id == 502)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 255;
			this.textBlueNumber = 255;
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameColorDefault());
	    }
		
		if (parButton.id == 201)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 0;
			this.textBlueNumber = 0;
	    }
		if (parButton.id == 202)
	    {
			this.textRedNumber = 0;
			this.textGreenNumber = 255;
			this.textBlueNumber = 0;
	    }
		if (parButton.id == 203)
	    {
			this.textRedNumber = 0;
			this.textGreenNumber = 0;
			this.textBlueNumber = 255;
	    }
		if (parButton.id == 204)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 255;
			this.textBlueNumber = 0;
	    }
		if (parButton.id == 205)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 0;
			this.textBlueNumber = 255;
	    }
		if (parButton.id == 206)
	    {
			this.textRedNumber = 0;
			this.textGreenNumber = 255;
			this.textBlueNumber = 255;
	    }
		if (parButton.id == 207)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 165;
			this.textBlueNumber = 0;
	    }
		if (parButton.id == 208)
	    {
			this.textRedNumber = 128;
			this.textGreenNumber = 0;
			this.textBlueNumber = 128;
	    }
		if (parButton.id == 209)
	    {
			this.textRedNumber = 0;
			this.textGreenNumber = 128;
			this.textBlueNumber = 128;
	    }
		if (parButton.id == 210)
	    {
			this.textRedNumber = 220;
			this.textGreenNumber = 20;
			this.textBlueNumber = 60;
	    }
		if (parButton.id == 211)
	    {
			this.textRedNumber = 255;
			this.textGreenNumber = 215;
			this.textBlueNumber = 0;
	    }
		if (parButton.id == 212)
	    {
			this.textRedNumber = 238;
			this.textGreenNumber = 130;
			this.textBlueNumber = 238;
	    }

        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
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
  			GlStateManager.translate(this.guiLeft + 137, this.guiTop + 132.5, 0);
  			GlStateManager.scale(.65, .65, .65);
      		
  			this.drawCenteredString(fontRenderer, ColorHelperVC.getColorNameFromRgb(this.textRedNumber, this.textGreenNumber, this.textBlueNumber), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
        
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 21.5, this.guiTop + 41.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("vc.main.red"), 0, 0, Color.RED.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 54.5, this.guiTop + 41.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("vc.main.green"), 0, 0, Color.GREEN.getRGB());
		}
		GlStateManager.popMatrix();;
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 87.5, this.guiTop + 41.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("vc.main.blue"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 21.5, this.guiTop + 55, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 54.5, this.guiTop + 55, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();;
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 87.5, this.guiTop + 55, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
    	
    	this.textRed.drawTextBox();
    	this.textGreen.drawTextBox();
    	this.textBlue.drawTextBox();
    	
    	//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        this.drawEntityOnScreen(this.guiLeft + 138, this.guiTop + 100, 13, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134+3, this.guiTop + 105.5+8, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46+3, this.guiTop + 77+34+8, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.FRAME_SKIN_COLOR_COST), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.framecolor"), 58, 16, 11111111);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		
		//Logic for mouse-over Reset tooltip
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
		&& mouseY >= this.guiTop + 143 && mouseY <= this.guiTop + 156)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Default skin, costs nothing!"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 38, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
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
	@Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipBaseVC entityIn)
    {
    	int currentR = entityIn.frameSkinColorRed;
    	int currentG = entityIn.frameSkinColorGreen;
    	int currentB = entityIn.frameSkinColorBlue;
    	
        entityIn.frameSkinColorRed = this.textRedNumber;
        entityIn.frameSkinColorGreen = this.textGreenNumber;
        entityIn.frameSkinColorBlue = this.textBlueNumber;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
        entityIn.frameSkinColorRed = currentR;
        entityIn.frameSkinColorGreen = currentG;
        entityIn.frameSkinColorBlue = currentB;
    }
}

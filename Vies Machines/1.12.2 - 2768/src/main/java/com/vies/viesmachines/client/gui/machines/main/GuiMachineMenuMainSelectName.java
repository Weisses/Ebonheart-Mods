package com.vies.viesmachines.client.gui.machines.main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeName;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameColor;
import com.vies.viesmachines.network.server.machine.gui.main.name.MessageHelperGuiMachineMenuChangeNameUndo;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuMainSelectName extends GuiContainerVM {
	
	private ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_main_change_name.png");
	
	private GuiTextField textName;
	public static int nameColor;
	
	public GuiMachineMenuMainSelectName(IInventory playerInv, EntityMachineBase machineIn)
	{
		super(new ContainerMachineNoSlots(playerInv, machineIn), playerInv, machineIn);
		
		this.textNameStorage = machineIn.getCustomNameTag();
		this.nameColor = machineIn.getVisualNameColor();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	this.textName = new GuiTextField(11, this.fontRenderer, this.guiLeft + 37, this.guiTop + 33+4, 102, 14);
        this.textName.setMaxStringLength(30);
        this.textName.setText(String.valueOf(this.textNameStorage));
    	this.textName.setFocused(false);
    	
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(12, this.guiLeft + 8, this.guiTop + 59, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(13, this.guiLeft + 126, this.guiTop + 59, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		GuiVM.buttonUndo = new GuiButtonGeneral2VM(20, this.guiLeft + 148, this.guiTop + 37, 14, 14, "", 1);
		
		GuiVM.buttonColorWhite = new GuiButtonGeneral1VM((EnumsVM.SelectColor.WHITE.getMetadata() + 100), this.guiLeft + 11, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorGray = new GuiButtonGeneral1VM((EnumsVM.SelectColor.GRAY.getMetadata() + 100), this.guiLeft + 31, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorBlue = new GuiButtonGeneral1VM((EnumsVM.SelectColor.BLUE.getMetadata() + 100), this.guiLeft + 51, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorGreen = new GuiButtonGeneral1VM((EnumsVM.SelectColor.GREEN.getMetadata() + 100), this.guiLeft + 71, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorAqua = new GuiButtonGeneral1VM((EnumsVM.SelectColor.AQUA.getMetadata() + 100), this.guiLeft + 91, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorRed = new GuiButtonGeneral1VM((EnumsVM.SelectColor.RED.getMetadata() + 100), this.guiLeft + 111, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorLightPurple = new GuiButtonGeneral1VM((EnumsVM.SelectColor.LIGHT_PURPLE.getMetadata() + 100), this.guiLeft + 131, this.guiTop + 96, 14, 14, "", 1);
		GuiVM.buttonColorYellow = new GuiButtonGeneral1VM((EnumsVM.SelectColor.YELLOW.getMetadata() + 100), this.guiLeft + 151, this.guiTop + 96, 14, 14, "", 1);
		
		GuiVM.buttonColorBlack = new GuiButtonGeneral1VM((EnumsVM.SelectColor.BLACK.getMetadata() + 100), this.guiLeft + 11, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkGray = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_GRAY.getMetadata() + 100), this.guiLeft + 31, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkBlue = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_BLUE.getMetadata() + 100), this.guiLeft + 51, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkGreen = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_GREEN.getMetadata() + 100), this.guiLeft + 71, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkAqua = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_AQUA.getMetadata() + 100), this.guiLeft + 91, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkRed = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_RED.getMetadata() + 100), this.guiLeft + 111, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorDarkPurple = new GuiButtonGeneral1VM((EnumsVM.SelectColor.DARK_PURPLE.getMetadata() + 100), this.guiLeft + 131, this.guiTop + 116, 14, 14, "", 1);
		GuiVM.buttonColorGold = new GuiButtonGeneral1VM((EnumsVM.SelectColor.GOLD.getMetadata() + 100), this.guiLeft + 151, this.guiTop + 116, 14, 14, "", 1);
		
		//--------------------------------------------------

		this.buttonList.add(GuiVM.buttonColorWhite);
		this.buttonList.add(GuiVM.buttonColorGray);
		this.buttonList.add(GuiVM.buttonColorBlue);
		this.buttonList.add(GuiVM.buttonColorGreen);
		this.buttonList.add(GuiVM.buttonColorAqua);
		this.buttonList.add(GuiVM.buttonColorRed);
		this.buttonList.add(GuiVM.buttonColorLightPurple);
		this.buttonList.add(GuiVM.buttonColorYellow);
		
		this.buttonList.add(GuiVM.buttonColorBlack);
		this.buttonList.add(GuiVM.buttonColorDarkGray);
		this.buttonList.add(GuiVM.buttonColorDarkBlue);
		this.buttonList.add(GuiVM.buttonColorDarkGreen);
		this.buttonList.add(GuiVM.buttonColorDarkAqua);
		this.buttonList.add(GuiVM.buttonColorDarkRed);
		this.buttonList.add(GuiVM.buttonColorDarkPurple);
		this.buttonList.add(GuiVM.buttonColorGold);
		
		this.buttonList.add(GuiVM.buttonUndo);
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonUndo.enabled = false;
		GuiVM.buttonMM1.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Text input:
		if (parButton.id == 11)
	    {
			if(textName.getText() != null)
			{
				try {
					textNameStorage = textName.getText();
				} catch(NumberFormatException ex) {
					textNameStorage = "Airship";
				}
			}
	    }
		
		// Apply:
		if(parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuChangeName());
	    }
		
		// Back:
		if(parButton.id == 13)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    }
		
		// Undo:
		if(parButton.id == 20)
	    {
			this.textNameStorage = this.machine.getMachineDefaultName();
			
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuChangeNameUndo());
			GuiVM.buttonUndo.enabled = false;
	    }
		
		// Name Color Picker:
		if(parButton.id >= 100
		&& parButton.id <= 200)
	    {
			this.nameColor = (parButton.id - 100);
			
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuChangeNameColor());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Draws a gray box behind the main background texture:
		this.drawRect(this.guiLeft + 8, this.guiTop + 8, this.guiLeft + 168, this.guiTop + 126, Color.BLACK.getRGB());
				
		// Binds the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Draws a white background so that black text can be read in the gui:
		if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.BLACK.getMetadata()) 
		{
			this.drawRect(this.guiLeft + 21, this.guiTop + 13, this.guiLeft + 155, this.guiTop+25, Color.WHITE.getRGB());
		}
		
		// Draws the actual text box to type in:
		this.textName.drawTextBox();
		
		// If the string in the text box is not null:
		if(textName.getText() != null)
		{
			try {
				textNameStorage = textName.getText();
			} catch(NumberFormatException ex) {
				textNameStorage = "Airship";
			}
		}
		
		// Checks to see if the default button can be pressed:
        if(this.machine.getCustomNameTag()!= this.machine.getMachineDefaultName())
        {
        	GuiVM.buttonUndo.enabled = true;
        }
		else
		{
			GuiVM.buttonUndo.enabled = false;
		}
        
        // Select Color label:
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88, this.guiTop + 83.5, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.gui.selectcolor.0"), false), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Binds the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Undo buttons Core:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 40, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		// Draws all of the colors over the buttons:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(14.5, 99.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 242, 32, 14, 14);
	        this.drawTexturedModalRect(40, 0, 242, 46, 14, 14);
	        this.drawTexturedModalRect(80, 0, 242, 60, 14, 14);
	        this.drawTexturedModalRect(120, 0, 242, 74, 14, 14);
	        this.drawTexturedModalRect(160, 0, 242, 88, 14, 14);
	        this.drawTexturedModalRect(200, 0, 242, 102, 14, 14);
	        this.drawTexturedModalRect(240, 0, 242, 116, 14, 14);
	        this.drawTexturedModalRect(280, 0, 242, 130, 14, 14);
	        
	        this.drawTexturedModalRect(0, 40, 242, 144, 14, 14);
	        this.drawTexturedModalRect(40, 40, 242, 158, 14, 14);
	        this.drawTexturedModalRect(80, 40, 242, 172, 14, 14);
	        this.drawTexturedModalRect(120, 40, 242, 186, 14, 14);
	        this.drawTexturedModalRect(160, 40, 242, 200, 14, 14);
	        this.drawTexturedModalRect(200, 40, 242, 214, 14, 14);
	        this.drawTexturedModalRect(240, 40, 242, 228, 14, 14);
	        this.drawTexturedModalRect(280, 40, 242, 242, 14, 14);
		}
		GlStateManager.popMatrix();
		
		// Displays the current name / color combo of the machine:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 16, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
			this.drawCenteredString(fontRenderer, EnumsVM.SelectColor.byId(this.machine.getVisualNameColor()).getTextColor() + this.machine.getCustomNameTag(), 0, 0, 0);
		}
		GlStateManager.popMatrix();
		
		// Logic for mouse-over tooltip - Apply:
		if(mouseX >= this.guiLeft + 8 && mouseX <= this.guiLeft + 49
		&& mouseY >= this.guiTop + 59 && mouseY <= this.guiTop + 72)
		{
			if (GuiVM.buttonApply.enabled)
			{
				List<String> text = new ArrayList<String>();
				
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("viesmachines.gui.tt.namechange.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - StringUtils.length(References.localNameVC("viesmachines.gui.tt.namechange.0")) - (int)(StringUtils.length(References.localNameVC("viesmachines.gui.tt.namechange.0")) / 2), mouseY - this.guiTop - 12, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		// Logic for mouse-over tooltip - Undo:
		if(mouseX >= this.guiLeft + 148 && mouseX <= this.guiLeft + 161
		&& mouseY >= this.guiTop + 37 && mouseY <= this.guiTop + 50)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("viesmachines.gui.tt.nameundo.1"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("viesmachines.gui.tt.nameundo.2"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - StringUtils.length(References.localNameVC("viesmachines.gui.tt.nameundo.1")) - (StringUtils.length(References.localNameVC("viesmachines.gui.tt.nameundo.1")) / 2), mouseY - this.guiTop - 18, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		// Logic for mouse-over tooltip - Color Buttons
		if(mouseX >= this.guiLeft + 8 && mouseX <= this.guiLeft + 167
		&& mouseY >= this.guiTop + 93 && mouseY <= this.guiTop + 132)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("viesmachines.gui.tt.namecolor.0"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - StringUtils.length(References.localNameVC("viesmachines.gui.tt.namecolor.0")) - (StringUtils.length(References.localNameVC("viesmachines.gui.tt.namecolor.0")) / 2), mouseY - this.guiTop - 12, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
	@Override
	public void updateScreen()
    {
		super.updateScreen();
		
		// Handles when the 'Apply' button is enabled:
		if (this.machine.getControllingPassenger() instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
    		
	        // Checks to see if the apply button can be pressed:
	        if(this.machine.getCustomNameTag().equals(this.textName.getText()))
	        {
	        	GuiVM.buttonApply.enabled = false;
	        }
	        else if (player.isCreative())
			{
	        	GuiVM.buttonApply.enabled = true;
			}
	        else if (this.machine.getEnergy() < CostsVM.COST_NAME_CHANGE)
			{
	        	GuiVM.buttonApply.enabled = false;
			}
	        else
	        {
	        	GuiVM.buttonApply.enabled = true;
	        }
    	}
        
        this.textName.updateCursorCounter();
        
        this.enableAllButtons();
        this.colorButtonToDisable();
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
		super.mouseClicked(x, y, btn);
        
        this.textName.mouseClicked(x, y, btn);
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		this.textName.textboxKeyTyped(typedChar, keyCode);
		
		// If the escape key is pressed, exit:
		if (keyCode == 1)
        {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
        }
    }
	
	/** Enables all color buttons. */
	protected void enableAllButtons()
	{
    	GuiVM.buttonColorWhite.enabled = true;
		GuiVM.buttonColorGray.enabled = true;
		GuiVM.buttonColorBlue.enabled = true;
		GuiVM.buttonColorGreen.enabled = true;
		GuiVM.buttonColorAqua.enabled = true;
		GuiVM.buttonColorRed.enabled = true;
		GuiVM.buttonColorLightPurple.enabled = true;
		GuiVM.buttonColorYellow.enabled = true;
		
		GuiVM.buttonColorBlack.enabled = true;
		GuiVM.buttonColorDarkGray.enabled = true;
		GuiVM.buttonColorDarkBlue.enabled = true;
		GuiVM.buttonColorDarkGreen.enabled = true;
		GuiVM.buttonColorDarkAqua.enabled = true;
		GuiVM.buttonColorDarkRed.enabled = true;
		GuiVM.buttonColorDarkPurple.enabled = true;
		GuiVM.buttonColorGold.enabled = true;
    }
	
	/** Checks what a machine is currently using and disables that color button. */
	private void colorButtonToDisable()
	{
		if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.BLACK.getMetadata())
        {
        	GuiVM.buttonColorBlack.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_BLUE.getMetadata())
        {
        	GuiVM.buttonColorDarkBlue.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_GREEN.getMetadata())
        {
        	GuiVM.buttonColorDarkGreen.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_AQUA.getMetadata())
        {
        	GuiVM.buttonColorDarkAqua.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_RED.getMetadata())
        {
        	GuiVM.buttonColorDarkRed.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_PURPLE.getMetadata())
        {
        	GuiVM.buttonColorDarkPurple.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.GOLD.getMetadata())
        {
        	GuiVM.buttonColorGold.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.GRAY.getMetadata())
        {
        	GuiVM.buttonColorGray.enabled = false;
        }
        
        
        
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.DARK_GRAY.getMetadata())
        {
        	GuiVM.buttonColorDarkGray.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.BLUE.getMetadata())
        {
        	GuiVM.buttonColorBlue.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.GREEN.getMetadata())
        {
        	GuiVM.buttonColorGreen.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.AQUA.getMetadata())
        {
        	GuiVM.buttonColorAqua.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.RED.getMetadata())
        {
        	GuiVM.buttonColorRed.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.LIGHT_PURPLE.getMetadata())
        {
        	GuiVM.buttonColorLightPurple.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.YELLOW.getMetadata())
        {
        	GuiVM.buttonColorYellow.enabled = false;
        }
        if (this.machine.getVisualNameColor() == EnumsVM.SelectColor.WHITE.getMetadata())
        {
        	GuiVM.buttonColorWhite.enabled = false;
        }
	}
}

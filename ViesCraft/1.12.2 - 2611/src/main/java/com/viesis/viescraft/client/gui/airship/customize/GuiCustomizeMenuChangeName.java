package com.viesis.viescraft.client.gui.airship.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuUndo;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuChangeName extends GuiContainerVC {
	
	private GuiTextField textName;
	
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_change_name.png");
	
	public GuiCustomizeMenuChangeName(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.textNameStorage = airshipIn.customName;
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
    	
    	this.textName = new GuiTextField(11, this.fontRenderer, this.guiLeft + 37, this.guiTop + 33+4, 102, 14);
        this.textName.setMaxStringLength(16);
        this.textName.setText(String.valueOf(this.textNameStorage));
    	this.textName.setFocused(false);
    	
    	GuiVC.buttonA12 = new GuiButtonGeneral1VC(12, this.guiLeft + 22, this.guiTop + 58+12, 42, 14, "Apply", 1);
		GuiVC.buttonA13 = new GuiButtonGeneral1VC(13, this.guiLeft + 112, this.guiTop + 58+12, 42, 14, "Back", 2);
		
		GuiVC.buttonA20 = new GuiButtonGeneral2VC(20, this.guiLeft + 148, this.guiTop + 33+4, 14, 14, "", 1);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.buttonA20);
		this.buttonList.add(GuiVC.buttonA12);
		this.buttonList.add(GuiVC.buttonA13);
		
		GuiVC.buttonA20.enabled = false;
		GuiVC.buttonMM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		//Text input
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
		//Apply
		if(parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuChangeName());
	    }
		//Back
		if(parButton.id == 13)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		//Undo
		if(parButton.id == 20)
	    {
			textNameStorage = "Airship";
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuUndo());
			GuiVC.buttonA20.enabled = false;
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
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
		this.textName.drawTextBox();
		
		if(textName.getText() != null)
		{
			try {
				textNameStorage = textName.getText();
			} catch(NumberFormatException ex) {
				textNameStorage = "Airship";
			}
		}
		
        if(this.airship.customName != "Airship")
        {
        	GuiVC.buttonA20.enabled = true;
        }
		else
		{
			GuiVC.buttonA20.enabled = false;
		}
        
        if(!this.airship.customName.equals(this.textName.getText()))
        {
        	GuiVC.buttonA12.enabled = true;
        }
		else
		{
			GuiVC.buttonA12.enabled = false;
		}
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88, this.guiTop + 72, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25, this.guiTop + 77, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.RENAME_COST), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.mc.getTextureManager().bindTexture(texture);
		
		//Undo buttons Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 36+4, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		this.fontRenderer.drawString("Customize Menu", 50, -10, Color.CYAN.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88.5, 14.5, 0);
	        GlStateManager.scale(1.25F, 1.25F, 1.25F);
	        
			this.drawCenteredString(fontRenderer, this.airship.getCustomName(), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 30 && mouseX <= this.guiLeft + 71
		&& mouseY >= this.guiTop + 73 && mouseY <= this.guiTop + 86)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.main.costs")+ " " + CostsVC.RENAME_COST + " " + References.localNameVC("vc.main.engine.cost.1"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 30, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Default tooltip
		if(mouseX >= this.guiLeft + 148 && mouseX <= this.guiLeft + 161
		&& mouseY >= this.guiTop + 37 && mouseY <= this.guiTop + 50)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.main.default"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 23, mouseY - this.guiTop - 8, 0);
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
        
        this.textName.updateCursorCounter();
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
		
		if (keyCode == 1)
        {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
        }
    }
}

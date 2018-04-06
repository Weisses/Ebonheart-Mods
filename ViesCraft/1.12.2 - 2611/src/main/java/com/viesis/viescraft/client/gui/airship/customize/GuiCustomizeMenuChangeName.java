package com.viesis.viescraft.client.gui.airship.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonConfirmVC;
import com.viesis.viescraft.client.gui.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.MessageHelperGuiCustomizeMenuUndo;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuChangeName extends GuiContainerVC {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	private GuiTextField textName;
	
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_change_name.png");
	
	public GuiCustomizeMenuChangeName(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
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
    	
    	this.textName = new GuiTextField(11, this.fontRenderer, this.guiLeft + 39, this.guiTop + 33, 98, 14);
        this.textName.setMaxStringLength(15);
        this.textName.setText(String.valueOf(this.textNameStorage));
    	this.textName.setFocused(false);
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 3);
		
    	GuiVC.buttonA12 = new GuiButtonGeneral1VC(12, this.guiLeft + 31, this.guiTop + 53, 42, 14, "Apply", 1);
		GuiVC.buttonA13 = new GuiButtonGeneral1VC(13, this.guiLeft + 103, this.guiTop + 53, 42, 14, "Back", 2);
		
		GuiVC.buttonA20 = new GuiButtonConfirmVC(20, this.guiLeft + 148, this.guiTop + 33, 14, 14, "");
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.buttonA20);
		this.buttonList.add(GuiVC.buttonA12);
		this.buttonList.add(GuiVC.buttonA13);
		
		GuiVC.buttonA20.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			//Lesser Storage
        	if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageLesser());
        	}
        	//Normal Storage
        	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageNormal());
        	}
        	//Greater Storage
        	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiMainMenuStorageGreater());
        	}
        	//Any Music
        	else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    			 || this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    			 || this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
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
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
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
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 132 - 44, this.guiTop + 115 - 29, 0);
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
			GlStateManager.translate(this.guiLeft + 77+48 - 44, this.guiTop + 102 + 19.5 - 29, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25+44 - 44, this.guiTop + 102 + 19.5 - 29, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 100+40 - 44, this.guiTop + 102 + 19.5 - 29, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.mc.getTextureManager().bindTexture(texture);

		
		//Undo buttons Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 36, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		this.fontRenderer.drawString("Customize Menu", 50, -10, Color.CYAN.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88.5, 14, 0);
	        GlStateManager.scale(1.25F, 1.25F, 1.25F);
	        
			this.drawCenteredString(fontRenderer, this.airship.getCustomName(), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 31 && mouseX <= this.guiLeft + 72
		&& mouseY >= this.guiTop + 53 && mouseY <= this.guiTop + 67)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Renaming airships costs"));
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("10 Redstone."));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 34, mouseY - this.guiTop - 13, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		this.textName.textboxKeyTyped(typedChar, keyCode);
		
		if (keyCode == 1)
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        this.textName.updateCursorCounter();
		
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
        
        this.textName.mouseClicked(x, y, btn);
    }
}

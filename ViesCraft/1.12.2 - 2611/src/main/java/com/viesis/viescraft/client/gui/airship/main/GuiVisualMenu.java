package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonConfirmVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiButtonVisual1VC;
import com.viesis.viescraft.client.gui.GuiButtonVisual2VC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloon;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuCore;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrame;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrameColor;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuBalloonTransparent;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuFrameTransparent;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoBalloon1;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoBalloon2;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoBalloon3;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoCore2;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoFrame1;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoFrame2;
import com.viesis.viescraft.network.server.airship.visual.undobuttons.MessageHelperGuiVisualMenuUndoFrame3;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class GuiVisualMenu extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static boolean metaCoreTransparentInfo;
	public static boolean metaFrameTransparentInfo;
	public static boolean metaEngineTransparentInfo;
	public static boolean metaBalloonTransparentInfo;
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_menu_visual.png");
	
	public static int undoCore2;
	
	public static boolean undoFrame1;
	public static int undoFrame2;
	public static boolean undoFrame3;
	
	public static boolean undoBalloon1;
	public static int undoBalloon2;
	public static boolean undoBalloon3;
	
	public GuiVisualMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	
    	int startPlaceTop = 91;
    	int startPlaceBottom = 151;
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 32, this.guiTop + 10, 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 32, this.guiTop + 24, 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 32, this.guiTop + 38, 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 32, this.guiTop + 52, 36, 14, "", 3);
		
    	GuiVC.buttonCore1 = new GuiButtonVisual2VC(11, this.guiLeft + 28,  this.guiTop + startPlaceTop + (14 * 0), 42, 14, "", 0);
    	GuiVC.buttonCore2 = new GuiButtonVisual1VC(12, this.guiLeft + 28,  this.guiTop + startPlaceTop + (14 * 1), 42, 14, "", 0);
		GuiVC.buttonCore3 = new GuiButtonVisual2VC(13, this.guiLeft + 28,  this.guiTop + startPlaceTop + (14 * 2), 42, 14, "", 1);
		
		GuiVC.buttonFrame1 = new GuiButtonVisual2VC(21, this.guiLeft + 106, this.guiTop + startPlaceTop + (14 * 0), 42, 14, "", 0);
		GuiVC.buttonFrame2 = new GuiButtonVisual1VC(22, this.guiLeft + 106, this.guiTop + startPlaceTop + (14 * 1), 42, 14, "", 1);
		GuiVC.buttonFrame3 = new GuiButtonVisual2VC(23, this.guiLeft + 106, this.guiTop + startPlaceTop + (14 * 2), 42, 14, "", 1);
		
    	GuiVC.buttonEngine1 = new GuiButtonVisual2VC(31, this.guiLeft + 28,  this.guiTop + startPlaceBottom + (14 * 0), 42, 14, "", 0);
    	GuiVC.buttonEngine2 = new GuiButtonVisual1VC(31, this.guiLeft + 28,  this.guiTop + startPlaceBottom + (14 * 1), 42, 14, "", 2);
		GuiVC.buttonEngine3 = new GuiButtonVisual2VC(32, this.guiLeft + 28,  this.guiTop + startPlaceBottom + (14 * 2), 42, 14, "", 1);
		
		GuiVC.buttonBalloon1 = new GuiButtonVisual2VC(41, this.guiLeft + 106, this.guiTop + startPlaceBottom + (14 * 0), 42, 14, "", 0);
		GuiVC.buttonBalloon2 = new GuiButtonVisual1VC(42, this.guiLeft + 106, this.guiTop + startPlaceBottom + (14 * 1), 42, 14, "", 3);
		GuiVC.buttonBalloon3 = new GuiButtonVisual2VC(43, this.guiLeft + 106, this.guiTop + startPlaceBottom + (14 * 2), 42, 14, "", 1);
		
		GuiVC.buttonA01 = new GuiButtonConfirmVC(51, this.guiLeft + 70, this.guiTop + startPlaceTop + (14 * 0), 14, 14, "");
		GuiVC.buttonA02 = new GuiButtonConfirmVC(52, this.guiLeft + 70, this.guiTop + startPlaceTop + (14 * 1), 14, 14, "");
		GuiVC.buttonA03 = new GuiButtonConfirmVC(53, this.guiLeft + 70, this.guiTop + startPlaceTop + (14 * 2), 14, 14, "");
		
		GuiVC.buttonA04 = new GuiButtonConfirmVC(54, this.guiLeft + 148, this.guiTop + startPlaceTop + (14 * 0), 14, 14, "");
		GuiVC.buttonA05 = new GuiButtonConfirmVC(55, this.guiLeft + 148, this.guiTop + startPlaceTop + (14 * 1), 14, 14, "");
		GuiVC.buttonA06 = new GuiButtonConfirmVC(56, this.guiLeft + 148, this.guiTop + startPlaceTop + (14 * 2), 14, 14, "");
		
		GuiVC.buttonA07 = new GuiButtonConfirmVC(57, this.guiLeft + 70, this.guiTop + startPlaceBottom + (14 * 0), 14, 14, "");
		GuiVC.buttonA08 = new GuiButtonConfirmVC(58, this.guiLeft + 70, this.guiTop + startPlaceBottom + (14 * 1), 14, 14, "");
		GuiVC.buttonA09 = new GuiButtonConfirmVC(59, this.guiLeft + 70, this.guiTop + startPlaceBottom + (14 * 2), 14, 14, "");
		
		GuiVC.buttonA10 = new GuiButtonConfirmVC(60, this.guiLeft + 148, this.guiTop + startPlaceBottom + (14 * 0), 14, 14, "");
		GuiVC.buttonA11 = new GuiButtonConfirmVC(61, this.guiLeft + 148, this.guiTop + startPlaceBottom + (14 * 1), 14, 14, "");
		GuiVC.buttonA12 = new GuiButtonConfirmVC(62, this.guiLeft + 148, this.guiTop + startPlaceBottom + (14 * 2), 14, 14, "");
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		//this.buttonList.add(GuiVC.buttonCore1);
		this.buttonList.add(GuiVC.buttonCore2);
		//this.buttonList.add(GuiVC.buttonCore3);
		
		this.buttonList.add(GuiVC.buttonFrame1);
		this.buttonList.add(GuiVC.buttonFrame2);
		this.buttonList.add(GuiVC.buttonFrame3);
		
		//this.buttonList.add(GuiVC.buttonEngine1);
		//this.buttonList.add(GuiVC.buttonEngine2);
		//this.buttonList.add(GuiVC.buttonEngine3);
		
		this.buttonList.add(GuiVC.buttonBalloon1);
		this.buttonList.add(GuiVC.buttonBalloon2);
		this.buttonList.add(GuiVC.buttonBalloon3);
		
		//this.buttonList.add(GuiVC.buttonA01);
		this.buttonList.add(GuiVC.buttonA02);
		//this.buttonList.add(GuiVC.buttonA03);
		
		this.buttonList.add(GuiVC.buttonA04);
		this.buttonList.add(GuiVC.buttonA05);
		this.buttonList.add(GuiVC.buttonA06);
		
		//this.buttonList.add(GuiVC.buttonA07);
		//this.buttonList.add(GuiVC.buttonA08);
		//this.buttonList.add(GuiVC.buttonA09);
		
		this.buttonList.add(GuiVC.buttonA10);
		this.buttonList.add(GuiVC.buttonA11);
		this.buttonList.add(GuiVC.buttonA12);
		
		
		
		GuiVC.buttonM3.enabled = false;
		GuiVC.buttonCore1.enabled = false;
		GuiVC.buttonCore2.enabled = false;
		GuiVC.buttonCore3.enabled = false;
		GuiVC.buttonFrame1.enabled = false;
		GuiVC.buttonFrame2.enabled = false;
		GuiVC.buttonFrame3.enabled = false;
		GuiVC.buttonEngine1.enabled = false;
		GuiVC.buttonEngine2.enabled = false;
		GuiVC.buttonEngine3.enabled = false;
		GuiVC.buttonBalloon1.enabled = false;
		GuiVC.buttonBalloon2.enabled = false;
		GuiVC.buttonBalloon3.enabled = false;
		
		//Enables the Main Visual button.
        if(this.airship.getMetaTierCore() > 0)
        {
        	GuiVC.buttonCore2.enabled = true;
        }
        if(this.airship.getMetaTierFrame() > 0)
        {
        	GuiVC.buttonFrame2.enabled = true;
        }
        if(this.airship.getMetaTierEngine() > 0)
        {
        	GuiVC.buttonEngine2.enabled = true;
        }
        if(this.airship.getMetaTierBalloon() > 0)
        {
        	GuiVC.buttonBalloon2.enabled = true;
        }
        
        //Enables the Transparent and Color buttons.
        if(this.airship.getMetaTierCore() == 5)
        {
        	GuiVC.buttonCore1.enabled = true;
        	GuiVC.buttonCore3.enabled = true;
        }
        if(this.airship.getMetaTierFrame() == 5)
        {
        	GuiVC.buttonFrame1.enabled = true;
        	GuiVC.buttonFrame3.enabled = true;
        }
        if(this.airship.getMetaTierEngine() == 5)
        {
        	GuiVC.buttonEngine1.enabled = true;
        	GuiVC.buttonEngine3.enabled = true;
        }
        if(this.airship.getMetaTierBalloon() == 5)
        {
        	GuiVC.buttonBalloon1.enabled = true;
        	GuiVC.buttonBalloon3.enabled = true;
        }
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
        	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageLesser());
        	}
        	//Normal Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageNormal());
        	}
        	//Greater Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageGreater());
        	}
        	//Any Music
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
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
		
		//this.metaCoreTransparentInfo = this.airship.getCoreVisualTransparent();
		this.metaFrameTransparentInfo = this.airship.getFrameVisualTransparent();
		//this.metaEngineTransparentInfo = this.airship.getEngineVisualTransparent();
		this.metaBalloonTransparentInfo = this.airship.getBalloonVisualTransparent();
		

		
		//Core
		if (parButton.id == 11)
	    {
			//this.metaCoreTransparentInfo = !this.metaCoreTransparentInfo;
			
			//NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuCoreTransparent());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuCore());
	    }
		if (parButton.id == 13)
	    {
			//NetworkHandler.sendToServer(new MessageGuiVisualMenuCoreColor());
	    }
		
		//Frame
		if (parButton.id == 21)
	    {
			this.metaFrameTransparentInfo = !this.metaFrameTransparentInfo;
			
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTransparent());
	    }
		if (parButton.id == 22)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrame());
	    }
		if (parButton.id == 23)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrameColor());
	    }
		
		//Engine
		if (parButton.id == 31)
	    {
			//this.metaEngineTransparentInfo = !this.metaEngineTransparentInfo;
			
			//NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuEngineTransparent());
	    }
		if (parButton.id == 32)
	    {
			//NetworkHandler.sendToServer(new MessageGuiVisualMenuEngineColor());
	    }
		if (parButton.id == 33)
	    {
			//NetworkHandler.sendToServer(new MessageGuiVisualMenuEngine());
	    }
		
		//Balloon
		if (parButton.id == 41)
	    {
			this.metaBalloonTransparentInfo = !this.metaBalloonTransparentInfo;
			
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuBalloonTransparent());
	    }
		if (parButton.id == 42)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuBalloon());
	    }
		if (parButton.id == 43)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuBalloonColor());
	    }
		
		//Core - Undo Models
		if (parButton.id == 52)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoCore2());
	    }
		//Frame - Undo
		if (parButton.id == 54)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoFrame1());
	    }
		if (parButton.id == 55)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoFrame2());
	    }
		if (parButton.id == 56)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoFrame3());
	    }
		//Balloon - Undo
		if (parButton.id == 60)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoBalloon1());
	    }
		if (parButton.id == 61)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoBalloon2());
	    }
		if (parButton.id == 62)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuUndoBalloon3());
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
		
		//Core 'On' button is green in gui
		if(this.airship.getCoreVisual() > 0)
		{
			this.drawTexturedModalRect(this.guiLeft + 17, this.guiTop + 107, 177, 0, 10, 10);
			GuiVC.buttonA02.enabled = true;
		}
		else
		{
			GuiVC.buttonA02.enabled = false;
		}
		//Frame 'On' button is green in gui
		if(this.airship.getFrameVisualTransparent())
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 93, 177, 0, 10, 10);
			GuiVC.buttonA04.enabled = true;
		}
		else
		{
			GuiVC.buttonA04.enabled = false;
		}
		if(this.airship.getFrameVisual() > 0)
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 107, 177, 0, 10, 10);
			GuiVC.buttonA05.enabled = true;
		}
		else
		{
			GuiVC.buttonA05.enabled = false;
		}
		if(this.airship.getFrameVisualColor())
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 121, 177, 0, 10, 10);
			GuiVC.buttonA06.enabled = true;
		}
		else
		{
			GuiVC.buttonA06.enabled = false;
		}
		//Engine 'On' button is green in gui
		//if(this.airship.getEngineVisual() > 0)
		//{
		//	this.drawTexturedModalRect(this.guiLeft + 17, this.guiTop + 100, 177, 0, 10, 10);
		//}
		//Balloon transparent 'On' button is green in gui
		if(this.airship.getBalloonVisualTransparent())
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 153, 177, 0, 10, 10);
			GuiVC.buttonA10.enabled = true;
		}
		else
		{
			GuiVC.buttonA10.enabled = false;
		}
		if(this.airship.getBalloonVisual() > 0)
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 167, 177, 0, 10, 10);
			GuiVC.buttonA11.enabled = true;
		}
		else
		{
			GuiVC.buttonA11.enabled = false;
		}
		if(this.airship.getBalloonVisualColor())
		{
			this.drawTexturedModalRect(this.guiLeft + 95, this.guiTop + 181, 177, 0, 10, 10);
			GuiVC.buttonA12.enabled = true;
		}
		else
		{
			GuiVC.buttonA12.enabled = false;
		}
				
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawEntityOnScreen(i + 128, j + 68, 13, mouseX, mouseY, this.airship);
        
        
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.mc.getTextureManager().bindTexture(texture);
		
		//Undo buttons Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(73, 108, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		//Undo buttons Frame
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 94, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 108, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 122, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		//Undo button Balloon
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 154, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 168, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(151, 182, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 10, 16, 16);
		}
		GlStateManager.popMatrix();
		
		this.fontRenderer.drawString("Appearance Menu", 44, -10, Color.CYAN.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39, 82, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Core", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(114.5, 82, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Frame", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(35.5, 142, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Engine", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(112, 142, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Balloon", 0, 0, 11111111);
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

        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
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

package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiButtonTransparentVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloon;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuBalloonColor;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrame;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrameColor;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuBalloonTransparent;
import com.viesis.viescraft.network.server.airship.visual.MessageHelperGuiVisualMenuFrameTransparent;

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
    	
    	int startPlace = 134;
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 32, this.guiTop + 10, 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 32, this.guiTop + 24, 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 32, this.guiTop + 38, 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 32, this.guiTop + 52, 36, 14, "", 3);
		
    	GuiVC.buttonCore1 = new GuiButtonTransparentVC(11, this.guiLeft + 14,  this.guiTop + startPlace - 50 + (14 * 0), 56, 14, "");
    	GuiVC.buttonCore2 = new GuiButtonGeneralVC(12, this.guiLeft + 14, this.guiTop + startPlace - 50 + (14 * 1), 70, 14, "Core");
		GuiVC.buttonCore3 = new GuiButtonGeneralVC(13, this.guiLeft + 14, this.guiTop + startPlace - 50 + (14 * 2), 70, 14, "Core Color");
		
		GuiVC.buttonFrame1 = new GuiButtonTransparentVC(21, this.guiLeft + 92,  this.guiTop + startPlace - 50 + (14 * 0), 56, 14, "");
		GuiVC.buttonFrame2 = new GuiButtonGeneralVC(22, this.guiLeft + 92, this.guiTop + startPlace - 50 + (14 * 1), 70, 14, "Frame");
		GuiVC.buttonFrame3 = new GuiButtonGeneralVC(23, this.guiLeft + 92, this.guiTop + startPlace - 50 + (14 * 2), 70, 14, "Frame Color");
		
    	GuiVC.buttonEngine1 = new GuiButtonTransparentVC(31, this.guiLeft + 14,  this.guiTop + startPlace + (14 * 0), 56, 14, "");
    	GuiVC.buttonEngine2 = new GuiButtonGeneralVC(31, this.guiLeft + 14, this.guiTop + startPlace + (14 * 1), 70, 14, "Engine");
		GuiVC.buttonEngine3 = new GuiButtonGeneralVC(32, this.guiLeft + 14, this.guiTop + startPlace + (14 * 2), 70, 14, "Engine Color");
		
		GuiVC.buttonBalloon1 = new GuiButtonTransparentVC(41, this.guiLeft + 92,  this.guiTop + startPlace + (14 * 0), 56, 14, "");
		GuiVC.buttonBalloon2 = new GuiButtonGeneralVC(42, this.guiLeft + 92, this.guiTop + startPlace + (14 * 1), 70, 14, "Balloon");
		GuiVC.buttonBalloon3 = new GuiButtonGeneralVC(43, this.guiLeft + 92, this.guiTop + startPlace + (14 * 2), 70, 14, "Balloon Color");
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		//this.buttonList.add(GuiVC.buttonCore1);
		//this.buttonList.add(GuiVC.buttonCore2);
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
		
		//this.buttonList.add(GuiVC.buttonT1);
		//this.buttonList.add(GuiVC.buttonT2);
		//this.buttonList.add(GuiVC.buttonT3);
		//this.buttonList.add(GuiVC.buttonT4);
		
		
		
		GuiVC.buttonM3.enabled = false;
		GuiVC.buttonFrame1.enabled = false;
		GuiVC.buttonFrame2.enabled = false;
		GuiVC.buttonFrame3.enabled = false;
		GuiVC.buttonCore1.enabled = false;
		GuiVC.buttonCore2.enabled = false;
		GuiVC.buttonCore3.enabled = false;
		GuiVC.buttonEngine1.enabled = false;
		GuiVC.buttonEngine2.enabled = false;
		GuiVC.buttonEngine3.enabled = false;
		GuiVC.buttonBalloon1.enabled = false;
		GuiVC.buttonBalloon2.enabled = false;
		GuiVC.buttonBalloon3.enabled = false;
		
		
		if(this.airship.getMetaTierFrame() > 0)
        {
        	GuiVC.buttonFrame2.enabled = true;
        }
        if(this.airship.getMetaTierCore() > 0)
        {
        	GuiVC.buttonCore2.enabled = true;
        }
        if(this.airship.getMetaTierEngine() > 0)
        {
        	GuiVC.buttonEngine2.enabled = true;
        }
        if(this.airship.getMetaTierBalloon() > 0)
        {
        	GuiVC.buttonBalloon2.enabled = true;
        }
        
        if(this.airship.getMetaTierFrame() == 5)
        {
        	GuiVC.buttonFrame1.enabled = true;
        	GuiVC.buttonFrame3.enabled = true;
        }
        if(this.airship.getMetaTierCore() == 5)
        {
        	GuiVC.buttonCore1.enabled = true;
        	GuiVC.buttonCore3.enabled = true;
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

		this.metaFrameTransparentInfo = this.airship.getFrameVisualTransparent();
		//this.metaCoreTransparentInfo = this.airship.getCoreVisualTransparent();
		//this.metaEngineTransparentInfo = this.airship.getEngineVisualTransparent();
		this.metaBalloonTransparentInfo = this.airship.getBalloonVisualTransparent();
		
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
		
		//Core
		if (parButton.id == 11)
	    {
			//this.metaCoreTransparentInfo = !this.metaCoreTransparentInfo;
			
			//NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuCoreTransparent());
	    }
		if (parButton.id == 12)
	    {
			//NetworkHandler.sendToServer(new MessageGuiVisualMenuCore());
	    }
		if (parButton.id == 13)
	    {
			//NetworkHandler.sendToServer(new MessageGuiVisualMenuCoreColor());
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
		
		
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_menu_visual.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Frame transparent 'On' button is green in gui
		if(this.airship.getFrameVisualTransparent())
		{
			this.drawTexturedModalRect(this.guiLeft + 151, this.guiTop + 86, 177, 0, 10, 10);
		}
		//Core transparent 'On' button is green in gui
		//if(this.airship.getCoreVisualTransparent())
		//{
		//	this.drawTexturedModalRect(this.guiLeft + 73, this.guiTop + 136, 177, 0, 10, 10);
		//}
		//Engine transparent 'On' button is green in gui
		//if(this.airship.getEngineVisualTransparent())
		//{
		//	this.drawTexturedModalRect(this.guiLeft + 73, this.guiTop + 136, 177, 0, 10, 10);
		//}
		//Balloon transparent 'On' button is green in gui
		if(this.airship.getBalloonVisualTransparent())
		{
			this.drawTexturedModalRect(this.guiLeft + 151, this.guiTop + 136, 177, 0, 10, 10);
		}
				
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawEntityOnScreen(i + 89, j + 67, 13, mouseX, mouseY, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString("Appearance Menu", 44, -10, 65521);
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.thePlayer.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead
        || !this.mc.thePlayer.isRiding())
        {
            this.mc.thePlayer.closeScreen();
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
        if (font == null) font = fontRendererObj;
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
	        rendermanager.doRenderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        rendermanager.setRenderShadow(true);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
    }
}

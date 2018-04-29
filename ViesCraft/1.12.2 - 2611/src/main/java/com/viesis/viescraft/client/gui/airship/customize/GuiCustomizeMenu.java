package com.viesis.viescraft.client.gui.airship.customize;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonMain;
import com.viesis.viescraft.network.server.airship.customize.core.MessageGuiCustomizeMenuCoreMain;
import com.viesis.viescraft.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.redstone.MessageGuiRedstoneMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenu extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_customize.png");
	
	public GuiCustomizeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
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
    	
    	GuiVC.buttonA21 = new GuiButtonGeneral1VC(21, this.guiLeft + 28, this.guiTop + 143, 42, 14, "Options", 0);
		GuiVC.buttonA22 = new GuiButtonGeneral1VC(22, this.guiLeft + 106, this.guiTop + 143, 42, 14, "Options", 0);
		GuiVC.buttonA23 = new GuiButtonGeneral1VC(23, this.guiLeft + 28, this.guiTop + 179, 42, 14, "Options", 0);
		GuiVC.buttonA24 = new GuiButtonGeneral1VC(24, this.guiLeft + 106, this.guiTop + 179, 42, 14, "Options", 0);
		
		GuiVC.buttonA11 = new GuiButtonGeneral1VC(11, this.guiLeft + 22, this.guiTop + 44, 54, 14, "Change Name", 0);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.buttonA21);
		this.buttonList.add(GuiVC.buttonA22);
		this.buttonList.add(GuiVC.buttonA23);
		this.buttonList.add(GuiVC.buttonA24);
		
		this.buttonList.add(GuiVC.buttonA11);
		
		GuiVC.buttonMM3.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		//Core
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuChangeName());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiRedstoneMenu());
	    }
		
		if (parButton.id == 21)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuCoreMain());
	    }
		if (parButton.id == 22)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameMain());
	    }
		if (parButton.id == 23)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineMain());
	    }
		if (parButton.id == 24)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonMain());
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
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
        this.drawEntityOnScreen(this.guiLeft + 128, this.guiTop + 68, 13, mouseX, mouseY, this.airship);
        
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 15, this.guiTop + 9, 0);
	        GlStateManager.scale(1F, 1F, 1F);
	        
	        this.fontRenderer.drawString("Current Name", 0, 0, 0);
		}
		GlStateManager.popMatrix();
	}
	
	private int getRedstoneLeftScaled(int pixels)
    {
        int i = this.airship.getField(3);
        
        if (i == 0)
        {
        	i = this.airship.fuelItemStack + 1;
        }
        
        return this.airship.getField(2) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.fontRenderer.drawString("Customize Menu", 50, -10, Color.CYAN.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39, 134, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Core", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(114.5, 134, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Frame", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(35.5, 170, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Engine", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(112, 170, 0);
	        GlStateManager.scale(0.85F, 0.85F, 0.85F);
	        
			this.fontRenderer.drawString("Balloon", 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(49, 26, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
			this.drawCenteredString(fontRenderer, this.airship.getCustomName(), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
    }
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		//this.textName.textboxKeyTyped(typedChar, keyCode);
		
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
        
        //this.textName.updateCursorCounter();
		
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
        
        //this.textName.mouseClicked(x, y, btn);
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

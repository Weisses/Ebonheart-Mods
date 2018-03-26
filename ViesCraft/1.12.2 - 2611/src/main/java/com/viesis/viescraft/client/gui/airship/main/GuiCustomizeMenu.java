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
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenuChangeName;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenuOptionsRedstone;
import com.viesis.viescraft.network.server.airship.customize.balloon.MessageGuiCustomizeMenuBalloonMain;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiCustomizeMenuCore;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenu extends GuiContainerVC {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	private ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_1.png");
	
	
	public GuiCustomizeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
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
    	
    	//this.textName = new GuiTextField(11, this.fontRenderer, this.guiLeft, this.guiTop, 98, 14);
        //this.textName.setMaxStringLength(15);
        //this.textName.setText(String.valueOf(this.textNameStorage));
    	//this.textName.setFocused(false);
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 3);
		
    	GuiVC.buttonA21 = new GuiButtonGeneralVC(21, this.guiLeft + 28, this.guiTop + 143, 42, 14, "Options", 0);
		GuiVC.buttonA22 = new GuiButtonGeneralVC(22, this.guiLeft + 106, this.guiTop + 143, 42, 14, "Options", 0);
		GuiVC.buttonA23 = new GuiButtonGeneralVC(23, this.guiLeft + 28, this.guiTop + 179, 42, 14, "Options", 0);
		GuiVC.buttonA24 = new GuiButtonGeneralVC(24, this.guiLeft + 106, this.guiTop + 179, 42, 14, "Options", 0);
		
		GuiVC.buttonA11 = new GuiButtonGeneralVC(11, this.guiLeft + 22, this.guiTop + 47, 54, 14, "Change Name", 0);
		
		GuiVC.buttonA12 = new GuiButtonGeneralVC(12, this.guiLeft + 67, this.guiTop + 109, 42, 14, "Options", 0);
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.buttonA21);
		this.buttonList.add(GuiVC.buttonA22);
		this.buttonList.add(GuiVC.buttonA23);
		this.buttonList.add(GuiVC.buttonA24);
		
		this.buttonList.add(GuiVC.buttonA11);
		this.buttonList.add(GuiVC.buttonA12);
		
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
		
		
		
		//Core
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuChangeName());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuOptionsRedstone());
	    }
		
		
		
		if (parButton.id == 21)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuCore());
	    }
		if (parButton.id == 22)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameMain());
	    }
		if (parButton.id == 23)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineMain());
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
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(texture);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		int k = this.getRedstoneLeftScaled(108);
		
		this.drawTexturedModalRect(this.guiLeft + 33, this.guiTop + 93, 0, 203, 1 + k, 8);
		
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
        this.drawEntityOnScreen(this.guiLeft + 128, this.guiTop + 68, 13, mouseX, mouseY, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88, this.guiTop + 84.5, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToGolden("Stored Redstone", 1, false, TextFormatting.RED), 0, 0, 111111);
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
			GlStateManager.translate(this.guiLeft + 77, this.guiTop + 102, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25, this.guiTop + 102, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 100, this.guiTop + 102, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
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
		this.mc.getTextureManager().bindTexture(texture);
		
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

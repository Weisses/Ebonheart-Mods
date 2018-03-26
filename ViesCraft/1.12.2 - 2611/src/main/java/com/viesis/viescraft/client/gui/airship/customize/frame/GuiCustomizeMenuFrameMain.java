package com.viesis.viescraft.client.gui.airship.customize.frame;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonConfirmVC;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColor;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColorUndo;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameTransparent;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier2Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier3Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier4Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier5Pg1;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;

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

public class GuiCustomizeMenuFrameMain extends GuiContainerVC {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_2.png");
	
	public GuiCustomizeMenuFrameMain(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	int startPlace = 43;
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 35, this.guiTop + 7 + (16 * 0), 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 35, this.guiTop + 7 + (16 * 1), 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 35, this.guiTop + 7 + (16 * 2), 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 35, this.guiTop + 7 + (16 * 3), 36, 14, "", 3);
		
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonT1 = new GuiButtonGeneralVC(11, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 0), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.1"), 0);
		GuiVC.buttonT2 = new GuiButtonGeneralVC(12, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 1), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.2"), 0);
		GuiVC.buttonT3 = new GuiButtonGeneralVC(13, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 2), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.3"), 0);
		GuiVC.buttonT4 = new GuiButtonGeneralVC(14, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 3), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.4"), 0);
		GuiVC.buttonT5 = new GuiButtonGeneralVC(15, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 4), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.5"), 0);
		
		GuiVC.buttonA16 = new GuiButtonGeneralVC(16, this.guiLeft + 21, this.guiTop + startPlace + 117, 60, 14, References.localNameVC("vc.main.setcolor"), 0);
		GuiVC.buttonA17 = new GuiButtonGeneralVC(17, this.guiLeft + 21, this.guiTop + startPlace + 137, 60, 14, References.localNameVC("vc.main.transparent"), 0);
		
		GuiVC.buttonA18 = new GuiButtonConfirmVC(18, this.guiLeft + 81, this.guiTop + startPlace + 117, 14, 14, "");
		GuiVC.buttonA19 = new GuiButtonConfirmVC(19, this.guiLeft + 81, this.guiTop + startPlace + 137, 14, 14, "");
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonT1);
		this.buttonList.add(GuiVC.buttonT2);
		this.buttonList.add(GuiVC.buttonT3);
		this.buttonList.add(GuiVC.buttonT4);
		this.buttonList.add(GuiVC.buttonT5);
		
		this.buttonList.add(GuiVC.buttonA16);
		this.buttonList.add(GuiVC.buttonA17);
		
		this.buttonList.add(GuiVC.buttonA18);
		this.buttonList.add(GuiVC.buttonA19);
		
		GuiVC.buttonM3.enabled = false;
		
		GuiVC.buttonT1.visible = false;
		GuiVC.buttonT2.visible = false;
		GuiVC.buttonT3.visible = false;
		GuiVC.buttonT4.visible = false;
		GuiVC.buttonT5.visible = false;
		
		
		//if(this.airship.getMainTierFrame() > 0)
        //{
			GuiVC.buttonT1.visible = true;
        //}
        //if(this.airship.getMainTierFrame() > 1)
        //{
        	GuiVC.buttonT2.visible = true;
        //}
        //if(this.airship.getMainTierFrame() > 2)
        //{
        	GuiVC.buttonT3.visible = true;
        //}
        //if(this.airship.getMainTierFrame() > 3)
        //{
        	GuiVC.buttonT4.visible = true;
        //}
        //if(this.airship.getMainTierFrame() > 4)
        ///{
        	GuiVC.buttonT5.visible = true;
        //}
        	
    	if(this.airship.getFrameSkinTransparent())
		{
			GuiVC.buttonA17.enabled = false;
			GuiVC.buttonA19.enabled = true;
		}
		else
		{
			GuiVC.buttonA17.enabled = true;
			GuiVC.buttonA19.enabled = false;
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
		
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenu());
	    }
		
		if (parButton.id == 11)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg1());
	    }
		if (parButton.id == 12)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier2Pg1());
	    }
		if (parButton.id == 13)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier3Pg1());
	    }
		if (parButton.id == 14)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier4Pg1());
	    }
		if (parButton.id == 15)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier5Pg1());
	    }
		
		if (parButton.id == 16)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameColor());
	    }
		if (parButton.id == 17)
	    {
			this.frameTransparentInfo = !this.frameTransparentInfo;
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTransparent());
	    }
		
		
		
		if(parButton.id == 18)
		{
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameColorUndo());
		}
		
		if(parButton.id == 19)
		{
			this.frameTransparentInfo = !this.frameTransparentInfo;
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTransparent());
		}
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Appearance 'On' button is green in gui
		if(this.airship.frameSkinTransparent == true)
		{
			this.drawTexturedModalRect(this.guiLeft + 136, this.guiTop + 36, 177, 85, 8, 8);
		}
		
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawEntityOnScreen(i + 134, j + 100, 13, mouseX, mouseY, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 132, this.guiTop + 115, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
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
			GlStateManager.translate(this.guiLeft + 77+48, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25+44, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 100+40, this.guiTop + 102 + 19.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
		if(this.airship.getFrameSkinTransparent())
		{
			GuiVC.buttonA17.enabled = false;
			GuiVC.buttonA19.enabled = true;
		}
		else
		{
			GuiVC.buttonA17.enabled = true;
			GuiVC.buttonA19.enabled = false;
		}
		
		
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.frame"), 73, 16, 11111111);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        if(this.airship.getMainTierFrame() > 0)
        {
        	this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 1), 7, 48, "");
        }
        if(this.airship.getMainTierFrame() > 1)
        {
        	this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 2), 7, 48 + (19 * 1), "");
        }
        if(this.airship.getMainTierFrame() > 2)
        {
        	this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 3), 7, 48 + (19 * 2), "");
        }
        if(this.airship.getMainTierFrame() > 3)
        {
        	this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 4), 7, 48 + (19 * 3), "");
        }
        if(this.airship.getMainTierFrame() > 4)
        {
        	this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 5), 7, 48 + (19 * 4), "");
        }
        
        //Undo arrows
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(84, 163, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(84, 183, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
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

package com.viesis.viescraft.client.gui.airship.visual.frame;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.visual.MessageGuiVisualMenuFrame;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageGuiVisualMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier1Pg1;

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

public class GuiVisualMenuFrameTier1Pg1 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	
	public GuiVisualMenuFrameTier1Pg1(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	int startPlace = 25;
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.reset"));
    	GuiVC.button503 = new GuiButtonGeneralVC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"));
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"));
    	
    	GuiVC.buttonA01 = new GuiButtonGeneralVC( 1, this.guiLeft + 15, this.guiTop + startPlace + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.1"));
		GuiVC.buttonA02 = new GuiButtonGeneralVC( 2, this.guiLeft + 15, this.guiTop + startPlace + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.2"));
		GuiVC.buttonA03 = new GuiButtonGeneralVC( 3, this.guiLeft + 15, this.guiTop + startPlace + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.3"));
		GuiVC.buttonA04 = new GuiButtonGeneralVC( 4, this.guiLeft + 15, this.guiTop + startPlace + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.4"));
		GuiVC.buttonA05 = new GuiButtonGeneralVC( 5, this.guiLeft + 15, this.guiTop + startPlace + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.5"));
		GuiVC.buttonA06 = new GuiButtonGeneralVC( 6, this.guiLeft + 15, this.guiTop + startPlace + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.6"));
		
		GuiVC.buttonA07 = new GuiButtonGeneralVC( 7, this.guiLeft + 15, this.guiTop + startPlace + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.7"));
		GuiVC.buttonA08 = new GuiButtonGeneralVC( 8, this.guiLeft + 15, this.guiTop + startPlace + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.8"));
		GuiVC.buttonA09 = new GuiButtonGeneralVC( 9, this.guiLeft + 15, this.guiTop + startPlace + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.9"));
		GuiVC.buttonA10 = new GuiButtonGeneralVC(10, this.guiLeft + 15, this.guiTop + startPlace + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.10"));
		GuiVC.buttonA11 = new GuiButtonGeneralVC(11, this.guiLeft + 15, this.guiTop + startPlace + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.11"));
		GuiVC.buttonA12 = new GuiButtonGeneralVC(12, this.guiLeft + 15, this.guiTop + startPlace + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.12"));
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button503);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA01);
		this.buttonList.add(GuiVC.buttonA02);
		this.buttonList.add(GuiVC.buttonA03);
		this.buttonList.add(GuiVC.buttonA04);
		this.buttonList.add(GuiVC.buttonA05);
		this.buttonList.add(GuiVC.buttonA06);

		this.buttonList.add(GuiVC.buttonA07);
		this.buttonList.add(GuiVC.buttonA08);
		this.buttonList.add(GuiVC.buttonA09);
		this.buttonList.add(GuiVC.buttonA10);
		this.buttonList.add(GuiVC.buttonA11);
		this.buttonList.add(GuiVC.buttonA12);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 502)
	    {
			this.metaInfo = 0;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier1Pg1());
	    }
		if (parButton.id == 503)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrameTier1Pg2());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrame());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier1Pg1());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_menu_visual_frame2.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawEntityOnScreen(i + 134, j + 134, 15, mouseX, mouseY, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.enum.tier.1"), 120, 29, 16777215);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 0), 46, 8, "");
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

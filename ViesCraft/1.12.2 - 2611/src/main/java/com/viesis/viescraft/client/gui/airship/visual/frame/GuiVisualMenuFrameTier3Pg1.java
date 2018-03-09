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
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier3Pg1;

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

public class GuiVisualMenuFrameTier3Pg1 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	
	public GuiVisualMenuFrameTier3Pg1(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
		GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"));
    	
    	GuiVC.buttonA31 = new GuiButtonGeneralVC(31, this.guiLeft + 15, this.guiTop + startPlace + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.31"));
		GuiVC.buttonA32 = new GuiButtonGeneralVC(32, this.guiLeft + 15, this.guiTop + startPlace + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.32"));
		GuiVC.buttonA33 = new GuiButtonGeneralVC(33, this.guiLeft + 15, this.guiTop + startPlace + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.33"));
		GuiVC.buttonA34 = new GuiButtonGeneralVC(34, this.guiLeft + 15, this.guiTop + startPlace + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.34"));
		GuiVC.buttonA35 = new GuiButtonGeneralVC(35, this.guiLeft + 15, this.guiTop + startPlace + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.35"));
		GuiVC.buttonA36 = new GuiButtonGeneralVC(36, this.guiLeft + 15, this.guiTop + startPlace + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.36"));
		
		GuiVC.buttonA37 = new GuiButtonGeneralVC(37, this.guiLeft + 15, this.guiTop + startPlace + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.37"));
		GuiVC.buttonA38 = new GuiButtonGeneralVC(38, this.guiLeft + 15, this.guiTop + startPlace + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.38"));
		GuiVC.buttonA39 = new GuiButtonGeneralVC(39, this.guiLeft + 15, this.guiTop + startPlace + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.39"));
		GuiVC.buttonA40 = new GuiButtonGeneralVC(40, this.guiLeft + 15, this.guiTop + startPlace + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.40"));
		GuiVC.buttonA41 = new GuiButtonGeneralVC(41, this.guiLeft + 15, this.guiTop + startPlace + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.41"));
		GuiVC.buttonA42 = new GuiButtonGeneralVC(42, this.guiLeft + 15, this.guiTop + startPlace + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.42"));
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA31);
		this.buttonList.add(GuiVC.buttonA32);
		this.buttonList.add(GuiVC.buttonA33);
		this.buttonList.add(GuiVC.buttonA34);
		this.buttonList.add(GuiVC.buttonA35);
		this.buttonList.add(GuiVC.buttonA36);

		this.buttonList.add(GuiVC.buttonA37);
		this.buttonList.add(GuiVC.buttonA38);
		this.buttonList.add(GuiVC.buttonA39);
		this.buttonList.add(GuiVC.buttonA40);
		this.buttonList.add(GuiVC.buttonA41);
		this.buttonList.add(GuiVC.buttonA42);
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
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier3Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrame());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier3Pg1());
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
		this.fontRenderer.drawString(References.localNameVC("vc.enum.tier.3"), 120, 29, 16777215);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, 3), 46, 8, "");
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

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
import com.viesis.viescraft.network.server.airship.visual.frame.MessageHelperGuiVisualMenuFrameTier2Pg1;

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

public class GuiVisualMenuFrameTier2Pg1 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	
	public GuiVisualMenuFrameTier2Pg1(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, "Reset");
		GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, "Back");
    	
    	GuiVC.buttonA19 = new GuiButtonGeneralVC(19, this.guiLeft + 15, this.guiTop + startPlace + (14 * 0), 76, 14, "Granite");
		GuiVC.buttonA20 = new GuiButtonGeneralVC(20, this.guiLeft + 15, this.guiTop + startPlace + (14 * 1), 76, 14, "Diorite");
		GuiVC.buttonA21 = new GuiButtonGeneralVC(21, this.guiLeft + 15, this.guiTop + startPlace + (14 * 2), 76, 14, "Andesite");
		GuiVC.buttonA22 = new GuiButtonGeneralVC(22, this.guiLeft + 15, this.guiTop + startPlace + (14 * 3), 76, 14, "Sandstone");
		GuiVC.buttonA23 = new GuiButtonGeneralVC(23, this.guiLeft + 15, this.guiTop + startPlace + (14 * 4), 76, 14, "Cobblestone");
		GuiVC.buttonA24 = new GuiButtonGeneralVC(24, this.guiLeft + 15, this.guiTop + startPlace + (14 * 5), 76, 14, "Stone");
		
		GuiVC.buttonA25 = new GuiButtonGeneralVC(25, this.guiLeft + 15, this.guiTop + startPlace + (14 * 6), 76, 14, "Snow");
		GuiVC.buttonA26 = new GuiButtonGeneralVC(26, this.guiLeft + 15, this.guiTop + startPlace + (14 * 7), 76, 14, "Packed Ice");
		GuiVC.buttonA27 = new GuiButtonGeneralVC(27, this.guiLeft + 15, this.guiTop + startPlace + (14 * 8), 76, 14, "Bone");
		GuiVC.buttonA28 = new GuiButtonGeneralVC(28, this.guiLeft + 15, this.guiTop + startPlace + (14 * 9), 76, 14, "Podzol");
		GuiVC.buttonA29 = new GuiButtonGeneralVC(29, this.guiLeft + 15, this.guiTop + startPlace + (14 * 10), 76, 14, "Mycelium");
		GuiVC.buttonA30 = new GuiButtonGeneralVC(30, this.guiLeft + 15, this.guiTop + startPlace + (14 * 11), 76, 14, "Glass");
		
		this.buttonList.add(GuiVC.button502);
		this.buttonList.add(GuiVC.button505);
		
		this.buttonList.add(GuiVC.buttonA19);
		this.buttonList.add(GuiVC.buttonA20);
		this.buttonList.add(GuiVC.buttonA21);
		this.buttonList.add(GuiVC.buttonA22);
		this.buttonList.add(GuiVC.buttonA23);
		this.buttonList.add(GuiVC.buttonA24);

		this.buttonList.add(GuiVC.buttonA25);
		this.buttonList.add(GuiVC.buttonA26);
		this.buttonList.add(GuiVC.buttonA27);
		this.buttonList.add(GuiVC.buttonA28);
		this.buttonList.add(GuiVC.buttonA29);
		this.buttonList.add(GuiVC.buttonA30);
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
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier2Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenuFrame());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiVisualMenuFrameTier2Pg1());
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
		this.fontRendererObj.drawString("Tier 2", 120, 29, 16777215);
		this.fontRendererObj.drawString("Appearance", 58, -10, 65521);
		
		int i = this.guiLeft;
        int j = this.guiTop;
		
        this.drawItemStack(new ItemStack(InitItemsVC.upgrade_frame, 1, 2), 46, 8, "");
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

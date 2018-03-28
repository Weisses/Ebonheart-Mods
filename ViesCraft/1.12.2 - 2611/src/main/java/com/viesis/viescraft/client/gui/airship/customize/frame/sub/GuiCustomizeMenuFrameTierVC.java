package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageHelperGuiCustomizeMenuFrameTier;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuFrameTierVC extends GuiContainerVC {
	
	private ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuFrameTierVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
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
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTier());
	    }
		if (parButton.id == 503)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameMain());
	    }
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTier());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			//NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTier());
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
		
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        this.drawEntityOnScreen(this.guiLeft + 135, this.guiTop + 110-18, 13, mouseX, mouseY, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 107, 0);
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
			GlStateManager.translate(this.guiLeft + 127, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134.25, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 142, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
		if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_TEXTURE_COST
		&& metaInfo != 0
		&& metaInfo != airship.frameSkinTexture)
		{
			if(this.airship.storedRedstone >= CostsVC.FRAME_SKIN_TEXTURE_COST)
			{
				GuiVC.button501.enabled = true;
			}
			else
			{
				GuiVC.button501.enabled = false;
			}
		}
		else
		{
			GuiVC.button501.enabled = false;
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Cost tooltip
		if(mouseX >= this.guiLeft + 12 && mouseX <= this.guiLeft + 87
		&& mouseY >= this.guiTop + 22 && mouseY <= this.guiTop + 189)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_TEXTURE_COST + " Redstone"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Reset tooltip
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
		&& mouseY >= this.guiTop + 143 && mouseY <= this.guiTop + 156)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Default skin, costs nothing!"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 38, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
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
    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityAirshipBaseVC entityIn)
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
	        
	        int currentSkin = entityIn.frameSkinTexture;
	        entityIn.frameSkinTexture = metaInfo;
	        
	        rendermanager.renderEntityStatic(entityIn, 0, false);
	        rendermanager.renderMultipass(entityIn, 0F);
	        
	        entityIn.frameSkinTexture = currentSkin;
	        rendermanager.setRenderShadow(true);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
    }
}

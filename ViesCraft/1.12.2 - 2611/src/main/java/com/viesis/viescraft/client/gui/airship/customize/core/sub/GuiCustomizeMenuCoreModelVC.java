package com.viesis.viescraft.client.gui.airship.customize.core.sub;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.GuiButtonGeneral2VC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuCoreModelVC extends GuiContainerVC {
	
	private ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuCoreModelVC(IInventory playerInv, EntityAirshipCore airshipIn)
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
    	
    	GuiVC.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	GuiVC.button502 = new GuiButtonGeneral2VC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVC.button503 = new GuiButtonGeneral1VC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button504 = new GuiButtonGeneral1VC(504, this.guiLeft + 2, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.prev"), 3);
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonA00 = new GuiButtonGeneral1VC( 0, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 0), 76, 14, References.localNameVC("vc.enum.visualcoreframe.0"), 0);
		GuiVC.buttonA01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 1), 76, 14, References.localNameVC("vc.enum.visualcoreframe.1"), 0);
		GuiVC.buttonA02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 2), 76, 14, References.localNameVC("vc.enum.visualcoreframe.2"), 0);
		GuiVC.buttonA03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 3), 76, 14, References.localNameVC("vc.enum.visualcoreframe.3"), 0);
		GuiVC.buttonA04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 4), 76, 14, References.localNameVC("vc.enum.visualcoreframe.4"), 0);
    	
    	GuiVC.buttonB00 = new GuiButtonGeneral1VC( 0, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 0), 76, 14, References.localNameVC("vc.enum.visualcoreengine.0"), 0);
		GuiVC.buttonB01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 1), 76, 14, References.localNameVC("vc.enum.visualcoreengine.1"), 0);
		GuiVC.buttonB02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 2), 76, 14, References.localNameVC("vc.enum.visualcoreengine.2"), 0);
		GuiVC.buttonB03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 3), 76, 14, References.localNameVC("vc.enum.visualcoreengine.3"), 0);
		GuiVC.buttonB04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 4), 76, 14, References.localNameVC("vc.enum.visualcoreengine.4"), 0);
    	
    	GuiVC.buttonC00 = new GuiButtonGeneral1VC( 0, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 0), 76, 14, References.localNameVC("vc.enum.visualcoreballoon.0"), 0);
		GuiVC.buttonC01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 1), 76, 14, References.localNameVC("vc.enum.visualcoreballoon.1"), 0);
		GuiVC.buttonC02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 2), 76, 14, References.localNameVC("vc.enum.visualcoreballoon.2"), 0);
		GuiVC.buttonC03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 3), 76, 14, References.localNameVC("vc.enum.visualcoreballoon.3"), 0);
		GuiVC.buttonC04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (18 * 4), 76, 14, References.localNameVC("vc.enum.visualcoreballoon.4"), 0);
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
		
        this.drawEntityOnScreen(this.guiLeft + 135, this.guiTop + 110-18, 13, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 107, 0);
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
}

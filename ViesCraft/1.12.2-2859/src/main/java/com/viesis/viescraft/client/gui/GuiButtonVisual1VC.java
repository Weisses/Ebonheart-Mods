package com.viesis.viescraft.client.gui;

import com.viesis.viescraft.api.References;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class GuiButtonVisual1VC extends GuiButtonVisualBaseVC {
	
	protected static ResourceLocation BUTTON_TEXTURES = new ResourceLocation(References.MOD_ID_COLON + "textures/gui/buttons_visual1.png");
	
	public GuiButtonVisual1VC(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int buttonLocationYIn) 
	{
		super(buttonId, x, y, widthIn, heightIn, buttonText, buttonLocationYIn);
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
		
		super.drawButton(mc, mouseX, mouseY, partialTicks);
	}
}

package com.viesis.viescraft.client.gui;

import com.viesis.viescraft.api.References;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonGuideBookVC extends GuiButton {
	
	protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation(References.MOD_ID_COLON + "textures/gui/buttons_guidebook.png");
    protected float scaleX;
    protected float scaleY;
    protected float scaleZ;
    protected int buttonLocationY;
    
	public GuiButtonGuideBookVC(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, float scaleXIn, float scaleYIn, float scaleZIn, int buttonLocationYIn) 
	{
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		
		this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.xPosition = x;
        this.yPosition = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;
        this.scaleX = scaleXIn;
        this.scaleY = scaleYIn;
        this.scaleZ = scaleZIn;
        this.buttonLocationY = buttonLocationYIn;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY)
	{
		if (this.visible)
        {
			FontRenderer fontrenderer = mc.fontRendererObj;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.xPosition && mouseY >= this.yPosition && mouseX < this.xPosition + this.width && mouseY < this.yPosition + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            
            //First half of the button
            this.drawTexturedModalRect(this.xPosition, this.yPosition, 0, 0 + i * 20, this.width / 2, this.height);
            //Second half of the button
            this.drawTexturedModalRect(this.xPosition + this.width / 2, this.yPosition, 200 - this.width / 2, 0 + i * 20, this.width / 2, this.height);
            //Test overlay
            
            GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.xPosition+1, this.yPosition+1, 0);
				GlStateManager.scale(.25, .25, .25);
            
				this.drawTexturedModalRect(0, 0, 0, 64 + (48 * this.buttonLocationY), 136, 48);
			}
			GlStateManager.popMatrix();
			
            this.mouseDragged(mc, mouseX, mouseY);
            int j = 14737632;
			
            if (packedFGColour != 0)
            {
                j = packedFGColour;
            }
            else
            if (!this.enabled)
            {
                j = 10526880;
            }
            else if (this.hovered)
            {
                j = 16777120;
            }
            
            GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.xPosition + this.width / 2, this.yPosition + (this.height - 4) / 2, 0); //-6 was a -8 by default
				GlStateManager.scale(this.scaleX, this.scaleY, this.scaleZ);
            
				this.drawCenteredString(fontrenderer, this.displayString, 0, 0, j);
			}
			GlStateManager.popMatrix();
        }
	}
}

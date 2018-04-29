package com.viesis.viescraft.client.gui;

import com.viesis.viescraft.api.References;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiButtonModuleToggleVC extends GuiButton {
	
	protected static final ResourceLocation BUTTON_TEXTURES = new ResourceLocation(References.MOD_ID_COLON + "textures/gui/buttons_general1.png");
    protected int buttonLocationY;
    
	public GuiButtonModuleToggleVC(int buttonId, int x, int y, int widthIn, int heightIn, String buttonText, int buttonLocationYIn) 
	{
		super(buttonId, x, y, widthIn, heightIn, buttonText);
		
		this.width = 200;
        this.height = 20;
        this.enabled = true;
        this.visible = true;
        this.id = buttonId;
        this.x = x;
        this.y = y;
        this.width = widthIn;
        this.height = heightIn;
        this.displayString = buttonText;
        this.buttonLocationY = buttonLocationYIn;
	}
	
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks)
	{
		if (this.visible)
        {
			FontRenderer fontrenderer = mc.fontRenderer;
            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int i = this.getHoverState(this.hovered);
            GlStateManager.enableBlend();
            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
            
            //First half of the button
            this.drawTexturedModalRect(this.x, this.y, 0, (54 * this.buttonLocationY) + 0 + i * 20, this.width / 2, this.height);
            //Second half of the button
            this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 0 + i * 20 + (54 * this.buttonLocationY), this.width / 2, this.height);
            //Test overlay
            
            //GlStateManager.pushMatrix();
			//{
			//	GlStateManager.translate(this.x+1, this.y+1, 0);
			//	GlStateManager.scale(.25, .25, .25);
            
			//	this.drawTexturedModalRect(0, 0, 0, 74, 136, 48);
			//}
			//GlStateManager.popMatrix();
			
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
				GlStateManager.translate(this.x + this.width / 2, this.y + (this.height - 6) / 2, 0); //-6 was a -8 by default
				GlStateManager.scale(.8, .8, .8);
            
				this.drawCenteredString(fontrenderer, this.displayString, 0, 0, j);
			}
			GlStateManager.popMatrix();
        }
	}
}

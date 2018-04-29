package com.viesis.viescraft.client.gui.airship.customize.frame;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.MessageGuiCustomizeMenu;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameColor;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameColorDefault;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageHelperGuiCustomizeMenuFrameTransparent;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier2Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier3Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier4Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier5Pg1;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuFrameMain extends GuiContainerVC {
	
	private static final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_2.png");
	
	public GuiCustomizeMenuFrameMain(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
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
    	
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	
    	GuiVC.buttonT1 = new GuiButtonGeneral1VC(11, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 0), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.1"), 0);
		GuiVC.buttonT2 = new GuiButtonGeneral1VC(12, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 1), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.2"), 0);
		GuiVC.buttonT3 = new GuiButtonGeneral1VC(13, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 2), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.3"), 0);
		GuiVC.buttonT4 = new GuiButtonGeneral1VC(14, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 3), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.4"), 0);
		GuiVC.buttonT5 = new GuiButtonGeneral1VC(15, this.guiLeft + 17, this.guiTop + startPlace - 4 + (15 * 4), 69, 14, References.localNameVC("vc.main.skins") + " - " + References.localNameVC("vc.enum.tier.5"), 0);
		
		GuiVC.buttonA16 = new GuiButtonGeneral1VC(16, this.guiLeft + 21, this.guiTop + startPlace + 117, 60, 14, References.localNameVC("vc.main.setcolor"), 0);
		GuiVC.buttonA17 = new GuiButtonGeneral1VC(17, this.guiLeft + 21, this.guiTop + startPlace + 137, 60, 14, References.localNameVC("vc.main.transparent"), 0);
		
		GuiVC.buttonA18 = new GuiButtonGeneral2VC(18, this.guiLeft + 81, this.guiTop + startPlace + 117, 14, 14, "", 1);
		GuiVC.buttonA19 = new GuiButtonGeneral2VC(19, this.guiLeft + 81, this.guiTop + startPlace + 137, 14, 14, "", 1);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
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
		
		GuiVC.buttonMM3.enabled = false;
		
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
		super.actionPerformed(parButton);
		
		//Back to main customize gui menu
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
		
		//Frame Color
		if (parButton.id == 16)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuFrameColor());
	    }
		if (parButton.id == 18)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameColorDefault());
	    }
		
		//Frame Transparency
		if(parButton.id == 17)
		{
			this.frameTransparentInfo = !this.frameTransparentInfo;
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTransparent());
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
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
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
    	
		if(airship.frameSkinColorRed == 255
		&& airship.frameSkinColorGreen == 255
		&& airship.frameSkinColorBlue == 255)
		{
			GuiVC.buttonA18.enabled = false;
		}
		else
		{
			GuiVC.buttonA18.enabled = true;
		}
		
		this.drawEntityOnScreen(this.guiLeft + 134, this.guiTop + 100, 13, this.airship);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.frame"), 73, 16, 11111111);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
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
		
		if(GuiVC.buttonA16.enabled)
		{
			//Logic for mouse-over Color Cost tooltip
			if(mouseX >= this.guiLeft + 21 && mouseX <= this.guiLeft + 80
			&& mouseY >= this.guiTop + 160 && mouseY <= this.guiTop + 173)
			{
				List<String> text = new ArrayList<String>();
				
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_COLOR_COST + " Redstone"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 28, mouseY - this.guiTop - 8, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		if(GuiVC.buttonA17.enabled)
		{
			//Logic for mouse-over Transparency Cost tooltip
			if(mouseX >= this.guiLeft + 21 && mouseX <= this.guiLeft + 80
			&& mouseY >= this.guiTop + 180 && mouseY <= this.guiTop + 193)
			{
				List<String> text = new ArrayList<String>();
				
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_TRANSPARENCY_COST + " Redstone"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 28, mouseY - this.guiTop - 8, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		if(GuiVC.buttonA18.enabled)
		{
			//Logic for mouse-over 0 Cost tooltip
			if(mouseX >= this.guiLeft + 81 && mouseX <= this.guiLeft + 94
			&& mouseY >= this.guiTop + 160 && mouseY <= this.guiTop + 173)
			{
				List<String> text = new ArrayList<String>();
				
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs 0 Redstone"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 28, mouseY - this.guiTop - 8, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		if(GuiVC.buttonA19.enabled)
		{
			//Logic for mouse-over 0 Cost tooltip
			if(mouseX >= this.guiLeft + 81 && mouseX <= this.guiLeft + 94
			&& mouseY >= this.guiTop + 180 && mouseY <= this.guiTop + 193)
			{
				List<String> text = new ArrayList<String>();
				
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs 0 Redstone"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 28, mouseY - this.guiTop - 8, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
    }
}

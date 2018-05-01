package com.viesis.viescraft.client.gui.airship.customize.frame.sub;

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
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.frame.MessageGuiCustomizeMenuFrameMain;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg1;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageGuiCustomizeMenuFrameTier1Pg2;
import com.viesis.viescraft.network.server.airship.customize.frame.sub.MessageHelperGuiCustomizeMenuFrameTier;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuFrameTierVC extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuFrameTierVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.metaInfo = this.airship.frameSkinTexture;
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
    	
    	//Tier1 Pg1
    	GuiVC.button01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.1"), 0);
		GuiVC.button02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.2"), 0);
		GuiVC.button03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.3"), 0);
		GuiVC.button04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.4"), 0);
		GuiVC.button05 = new GuiButtonGeneral1VC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.5"), 0);
		GuiVC.button06 = new GuiButtonGeneral1VC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.6"), 0);
		
		GuiVC.button07 = new GuiButtonGeneral1VC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.7"), 0);
		GuiVC.button08 = new GuiButtonGeneral1VC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.8"), 0);
		GuiVC.button09 = new GuiButtonGeneral1VC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.9"), 0);
		GuiVC.button10 = new GuiButtonGeneral1VC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.10"), 0);
		GuiVC.button11 = new GuiButtonGeneral1VC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.11"), 0);
		GuiVC.button12 = new GuiButtonGeneral1VC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.12"), 0);
		
		//Tier1 Pg2
    	GuiVC.button13 = new GuiButtonGeneral1VC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.13"), 0);
		GuiVC.button14 = new GuiButtonGeneral1VC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.14"), 0);
		GuiVC.button15 = new GuiButtonGeneral1VC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.15"), 0);
		GuiVC.button16 = new GuiButtonGeneral1VC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.16"), 0);
		GuiVC.button17 = new GuiButtonGeneral1VC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.17"), 0);
		GuiVC.button18 = new GuiButtonGeneral1VC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.18"), 0);
		
		//Tier2 Pg1
    	GuiVC.button19 = new GuiButtonGeneral1VC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.19"), 0);
		GuiVC.button20 = new GuiButtonGeneral1VC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.20"), 0);
		GuiVC.button21 = new GuiButtonGeneral1VC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.21"), 0);
		GuiVC.button22 = new GuiButtonGeneral1VC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.22"), 0);
		GuiVC.button23 = new GuiButtonGeneral1VC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.23"), 0);
		GuiVC.button24 = new GuiButtonGeneral1VC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.24"), 0);
		
		GuiVC.button25 = new GuiButtonGeneral1VC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.25"), 0);
		GuiVC.button26 = new GuiButtonGeneral1VC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.26"), 0);
		GuiVC.button27 = new GuiButtonGeneral1VC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.27"), 0);
		GuiVC.button28 = new GuiButtonGeneral1VC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.28"), 0);
		GuiVC.button29 = new GuiButtonGeneral1VC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.29"), 0);
		GuiVC.button30 = new GuiButtonGeneral1VC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.30"), 0);
		
		//Tier3 Pg1
    	GuiVC.button31 = new GuiButtonGeneral1VC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.31"), 0);
		GuiVC.button32 = new GuiButtonGeneral1VC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.32"), 0);
		GuiVC.button33 = new GuiButtonGeneral1VC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.33"), 0);
		GuiVC.button34 = new GuiButtonGeneral1VC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.34"), 0);
		GuiVC.button35 = new GuiButtonGeneral1VC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.35"), 0);
		GuiVC.button36 = new GuiButtonGeneral1VC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.36"), 0);
		
		GuiVC.button37 = new GuiButtonGeneral1VC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.37"), 0);
		GuiVC.button38 = new GuiButtonGeneral1VC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.38"), 0);
		GuiVC.button39 = new GuiButtonGeneral1VC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.39"), 0);
		GuiVC.button40 = new GuiButtonGeneral1VC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.40"), 0);
		GuiVC.button41 = new GuiButtonGeneral1VC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.41"), 0);
		GuiVC.button42 = new GuiButtonGeneral1VC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.42"), 0);
		
		//Tier4 Pg1
    	GuiVC.button43 = new GuiButtonGeneral1VC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.43"), 0);
		GuiVC.button44 = new GuiButtonGeneral1VC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.44"), 0);
		GuiVC.button45 = new GuiButtonGeneral1VC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.45"), 0);
		GuiVC.button46 = new GuiButtonGeneral1VC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.46"), 0);
		GuiVC.button47 = new GuiButtonGeneral1VC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.47"), 0);
		GuiVC.button48 = new GuiButtonGeneral1VC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.48"), 0);
		
		GuiVC.button49 = new GuiButtonGeneral1VC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.49"), 0);
		GuiVC.button50 = new GuiButtonGeneral1VC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.50"), 0);
		GuiVC.button51 = new GuiButtonGeneral1VC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.51"), 0);
		GuiVC.button52 = new GuiButtonGeneral1VC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.52"), 0);
		GuiVC.button53 = new GuiButtonGeneral1VC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.53"), 0);
		GuiVC.button54 = new GuiButtonGeneral1VC(54, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.54"), 0);
		
		//Tier5 Pg1
    	GuiVC.button55 = new GuiButtonGeneral1VC(55, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.visualframe.55"), 0);
		GuiVC.button56 = new GuiButtonGeneral1VC(56, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.visualframe.56"), 0);
		GuiVC.button57 = new GuiButtonGeneral1VC(57, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.visualframe.57"), 0);
		GuiVC.button58 = new GuiButtonGeneral1VC(58, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.visualframe.58"), 0);
		GuiVC.button59 = new GuiButtonGeneral1VC(59, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.visualframe.59"), 0);
		GuiVC.button60 = new GuiButtonGeneral1VC(60, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.visualframe.60"), 0);
		
		GuiVC.button61 = new GuiButtonGeneral1VC(61, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.visualframe.61"), 0);
		GuiVC.button62 = new GuiButtonGeneral1VC(62, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.visualframe.62"), 0);
		GuiVC.button63 = new GuiButtonGeneral1VC(63, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.visualframe.63"), 0);
		GuiVC.button64 = new GuiButtonGeneral1VC(64, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.visualframe.64"), 0);
		GuiVC.button65 = new GuiButtonGeneral1VC(65, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.visualframe.65"), 0);
		GuiVC.button66 = new GuiButtonGeneral1VC(66, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.visualframe.66"), 0);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuFrameTier());
	    }
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
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
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
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        this.drawEntityOnScreen(this.guiLeft + 135, this.guiTop + 110-18, 13, this.airship);
        
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
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 105.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46, this.guiTop + 77+34, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.FRAME_SKIN_TEXTURE_COST), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Cost tooltip
		if(mouseX >= this.guiLeft + 12 && mouseX <= this.guiLeft + 87
		&& mouseY >= this.guiTop + 22 && mouseY <= this.guiTop + 189)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_TEXTURE_COST + " Redstone if applied."));
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
		
		if(airship.getStoredRedstone() >= CostsVC.FRAME_SKIN_TEXTURE_COST
		&& metaInfo != 0
		&& metaInfo != airship.frameSkinTexture)
		{
			if(this.airship.storedRedstone >= CostsVC.FRAME_SKIN_TEXTURE_COST)
			{
				//Logic for mouse-over Cost tooltip
				if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
				&& mouseY >= this.guiTop + 125 && mouseY <= this.guiTop + 138)
				{
					List<String> text = new ArrayList<String>();
					
					text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_TEXTURE_COST + " Redstone."));
					
					FontRenderer fontrenderer = this.getFontRenderer();
					
					GlStateManager.pushMatrix();
					{
						GlStateManager.translate(mouseX - this.guiLeft - 30, mouseY - this.guiTop - 8, 0);
						GlStateManager.scale(0.5, 0.5, 0.5);
						
						this.drawHoveringText(text, 0, 0);
					}
					GlStateManager.popMatrix();
				}
			}
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
	
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
	@Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipBaseVC entityIn)
    {
    	int current = entityIn.frameSkinTexture;
        entityIn.frameSkinTexture = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		entityIn.frameSkinTexture = current;
    }
}

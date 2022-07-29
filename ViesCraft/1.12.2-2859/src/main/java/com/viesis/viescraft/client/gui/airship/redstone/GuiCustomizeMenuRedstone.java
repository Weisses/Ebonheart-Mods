package com.viesis.viescraft.client.gui.airship.redstone;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMenuRedstone;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.redstone.MessageHelperGuiRedstoneMenuConsume;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuRedstone extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_redstone.png");
	
	public GuiCustomizeMenuRedstone(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerMenuRedstone(playerInv, airshipIn), playerInv, airshipIn);
		
		this.storedRedstone = airshipIn.storedRedstone;
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
    	
    	GuiVC.buttonA12 = new GuiButtonGeneral1VC(12, this.guiLeft + 67, this.guiTop + 94, 42, 14,  References.localNameVC("vc.button.apply"), 1);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.buttonA12);
		
		GuiVC.buttonMM5.enabled = false;
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		//Apply
		if(parButton.id == 12)
	    {
			if(!this.airship.inventory.getStackInSlot(16).isEmpty())
			{
				this.storedRedstone = this.airship.inventory.getStackInSlot(16).getCount();
				
				if(this.airship.storedRedstoneTotal == (this.airship.storedRedstone))
				{
					
				}
				else if(this.airship.storedRedstoneTotal >= (this.storedRedstone + this.airship.storedRedstone))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiRedstoneMenuConsume());
				}
				else if(this.airship.storedRedstoneTotal < (this.storedRedstone + this.airship.storedRedstone))
				{
					this.storedRedstone = this.airship.storedRedstoneTotal - this.airship.storedRedstone;
					
					NetworkHandler.sendToServer(new MessageHelperGuiRedstoneMenuConsume());
				}
			}
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
		
		int k = this.getRedstoneLeftScaled(108);
		
		this.drawTexturedModalRect(this.guiLeft + 33, this.guiTop + 39, 0, 203, 1 + k, 8);
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49-12, this.guiTop - 17, this.guiLeft + 127+12, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-12, this.guiTop - 16, this.guiLeft + 126+12, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-12, this.guiTop - 14, this.guiLeft + 124+12, this.guiTop, Color.BLACK.getRGB());
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88, this.guiTop + 28, 0);
	        GlStateManager.scale(0.875F, 0.875F, 0.875F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden("Redstone Balance", 1, false, TextFormatting.DARK_GREEN), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
		/**if(this.airship.storedRedstone >= 500)
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
		}*/
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 75, this.guiTop + 50, 0);
	        GlStateManager.scale(1.0F, 1.0F, 1.0F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.75, this.guiTop + 50, 0);
	        GlStateManager.scale(1.0F, 1.0F, 1.0F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 102.5, this.guiTop + 50, 0);
	        GlStateManager.scale(1.0F, 1.0F, 1.0F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
		if(this.airship.inventory.getStackInSlot(16).isEmpty()
				|| this.airship.getStoredRedstone() == this.airship.getStoredRedstoneTotal())
		{
			GuiVC.buttonA12.enabled = false;
		}
		else
		{
			GuiVC.buttonA12.enabled = true;
		}
	}
	
	private int getRedstoneLeftScaled(int pixels)
    {
        int i = this.airship.getField(3);
        
        if (i == 0)
        {
        	i = this.airship.fuelItemStack + 1;
        }
        
        return this.airship.getField(2) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.fontRenderer.drawString("Customize Menu", 50, -10, Color.CYAN.getRGB());
    }
}

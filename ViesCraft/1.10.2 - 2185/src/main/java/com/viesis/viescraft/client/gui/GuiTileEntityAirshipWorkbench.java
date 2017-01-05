package com.viesis.viescraft.client.gui;

import java.io.IOException;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;

public class GuiTileEntityAirshipWorkbench extends GuiContainer {
	
	private InventoryPlayer thePlayerInventory;
	private TileEntityAirshipWorkbench airship;
	private final World worldObj;
    
	public GuiTileEntityAirshipWorkbench(InventoryPlayer thePlayerInventory, World worldIn, TileEntityAirshipWorkbench airship)
	{
		super(new ContainerAirshipWorkbench(thePlayerInventory, worldIn, airship));
		
		this.worldObj = worldIn;
        this.thePlayerInventory = thePlayerInventory;
		this.airship = airship;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_workbench.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 176, 50, 8, 1);
        this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 176, 14, 26, 16);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		//String s = this.airship.getDisplayName().getUnformattedText();
		////this.fontRendererObj.drawString(s, 8, 6, 4210752);
		//////////////////////this.fontRendererObj.drawString("Input", 32, 6, 4210752);
		// This sets the Airship name in the top center.
		//this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		//this.fontRendererObj.drawString(this.thePlayerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
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
}		

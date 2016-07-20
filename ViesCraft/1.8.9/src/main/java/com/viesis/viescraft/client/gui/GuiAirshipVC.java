package com.viesis.viescraft.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ResourceLocation;

import com.viesis.viescraft.common.entity.ContainerAirshipVC;
import com.viesis.viescraft.common.entity.EntityAirshipBase;



public class GuiAirshipVC extends GuiContainer//GuiInventory
{

    private IInventory playerInv;
    private EntityAirshipBase te;
    private IChatComponent icc;
    
	public GuiAirshipVC(InventoryPlayer playerInv, EntityAirshipBase te) {
		//super(new EntityAirshipBase(playerInv, te));
		super(new ContainerAirshipVC(playerInv, te));
		this.playerInv = playerInv;
		this.te = te;
		
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation("vc:textures/gui/container/test_tile_entity.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String s = this.te.getDisplayName().getUnformattedText();
        this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);		//#404040
        this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);	//#404040
	}
}

package com.viesis.viescraft.client.gui.pouch;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.parts.pouch.ContainerPouchModule;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.util.ResourceLocation;

public class GuiPouchModule extends GuiContainer {
	
	private static final ResourceLocation texture = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_module_pouch.png");
	
	public GuiPouchModule(EntityPlayer player, InventoryPouch box) 
	{
		super(new ContainerPouchModule(player, box));
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		for(int i1 = 0; i1 < 7; ++i1) 
		{
			Slot slot = inventorySlots.inventorySlots.get(i1);
			
			if(slot.getHasStack() && slot.getSlotStackLimit() == 1)
			{
				drawTexturedModalRect(guiLeft+slot.xPos, guiTop+slot.yPos, 200, 0, 16, 16);
			}
		}
	}
}

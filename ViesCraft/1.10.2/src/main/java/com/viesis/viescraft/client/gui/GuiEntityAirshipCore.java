package com.viesis.viescraft.client.gui;

import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class GuiEntityAirshipCore extends GuiContainer {

	public GuiEntityAirshipCore(Container t) {
		super(t);

		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
	}

}

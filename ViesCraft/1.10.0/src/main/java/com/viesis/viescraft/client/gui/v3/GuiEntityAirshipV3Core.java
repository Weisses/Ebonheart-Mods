package com.viesis.viescraft.client.gui.v3;

import java.io.IOException;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class GuiEntityAirshipV3Core extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV3Core airshipV3;
	
	public GuiEntityAirshipV3Core(IInventory playerInv, EntityAirshipV3Core airshipV3)
	{
		super(new ContainerAirshipV3Core(playerInv, airshipV3));
		
		this.playerInv = playerInv;
		this.airshipV3 = airshipV3;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (EntityAirshipV3Core.isAirshipBurning(this.airshipV3))
        {
            int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 176, 14, 26, 16);
        }
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV3.getField(1);
        
        if (i == 0)
        {
        	i = (ViesCraftConfig.v3FuelBurnTime * 20);
        }
        
        return this.airshipV3.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV3.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString("Fuel", 150, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
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

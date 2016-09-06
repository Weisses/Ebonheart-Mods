package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class GuiEntityAirshipV1Core extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	
	public GuiEntityAirshipV1Core(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1Core(playerInv, airshipV1));
		
		this.playerInv = playerInv;
		this.airshipV1 = airshipV1;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (EntityAirshipV1Core.isAirshipBurning(this.airshipV1))
        {
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 176, 14, 26, 16);
        }
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV1.getField(1);
        
        if (i == 0)
        {
        	i = (ViesCraftConfig.v1FuelBurnTime * 20);//i = 1200;
        }
        
        return this.airshipV1.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV1.getDisplayName().getUnformattedText();
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
	
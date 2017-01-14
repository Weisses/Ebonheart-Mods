package com.viesis.viescraft.client.gui.v4;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV4Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v4.ContainerAirshipV4Module;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v4.MessageGuiV4Default;
import com.viesis.viescraft.network.server.v4.MessageGuiV4ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v4.MessageGuiV4ModuleInventorySmall;

public class GuiEntityAirshipV4Module extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipV4Core airshipV4;
	
	public GuiEntityAirshipV4Module(IInventory playerInv, EntityAirshipV4Core airshipV4)
	{
		super(new ContainerAirshipV4Module(playerInv, airshipV4));
		
		this.playerInv = playerInv;
		this.airshipV4 = airshipV4;
		this.xSize = 176;
		this.ySize = 166;
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
    	
		buttonModule = new GuiButton( 1, this.guiLeft + 133, this.guiTop + 60, 37, 20, "Back");
		this.buttonList.add(buttonModule);
    }
	
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			if(this.airshipV4.getModuleInventorySmall())
			{
				NetworkHandler.sendToServer(new MessageGuiV4ModuleInventorySmall());
			}
			else if(this.airshipV4.getModuleInventoryLarge())
			{
				NetworkHandler.sendToServer(new MessageGuiV4ModuleInventoryLarge());
			}
			else
			{
				NetworkHandler.sendToServer(new MessageGuiV4Default());
			}
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_module.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//If any Module installed
		if(this.airshipV4.getModuleInventorySmall()
		|| this.airshipV4.getModuleInventoryLarge()
		|| this.airshipV4.getModuleSpeedMinor()
		|| this.airshipV4.getModuleSpeedMajor()
		|| this.airshipV4.getModuleFuelInfinite())
		{
		    //Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 14, 176, 0, 48, 48);
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV4.getDisplayName().getUnformattedText();
		//this.fontRendererObj.drawString("Fuel", 150, 6, 4210752);
		this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
}

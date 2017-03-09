package com.viesis.viescraft.client.gui.v2;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2Module;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v2.MessageGuiV2Default;
import com.viesis.viescraft.network.server.v2.MessageGuiV2ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v2.MessageGuiV2ModuleInventorySmall;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEntityAirshipV2Module extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipV2Core airshipV2;
	
	public GuiEntityAirshipV2Module(IInventory playerInv, EntityAirshipV2Core airshipV2)
	{
		super(new ContainerAirshipV2Module(playerInv, airshipV2));
		
		this.playerInv = playerInv;
		this.airshipV2 = airshipV2;
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
			if(this.airshipV2.getModuleInventorySmall())
			{
				NetworkHandler.sendToServer(new MessageGuiV2ModuleInventorySmall());
			}
			else if(this.airshipV2.getModuleInventoryLarge())
			{
				NetworkHandler.sendToServer(new MessageGuiV2ModuleInventoryLarge());
			}
			else
			{
				NetworkHandler.sendToServer(new MessageGuiV2Default());
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
		if(this.airshipV2.getModuleInventorySmall()
		|| this.airshipV2.getModuleInventoryLarge()
		|| this.airshipV2.getModuleSpeedMinor()
		|| this.airshipV2.getModuleSpeedMajor()
		|| this.airshipV2.getModuleFuelInfinite())
		{
		    //Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 14, 176, 0, 48, 48);
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV2.getDisplayName().getUnformattedText();
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
            this.mc.thePlayer.closeScreen();
        }
    }
}

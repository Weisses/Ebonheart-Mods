package com.viesis.viescraft.client.gui.v3;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV3Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3Module;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v3.MessageGuiV3Default;
import com.viesis.viescraft.network.server.v3.MessageGuiV3ModuleInventoryLarge;
import com.viesis.viescraft.network.server.v3.MessageGuiV3ModuleInventorySmall;

public class GuiEntityAirshipV3Module extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory thePlayerInv;
	private EntityAirshipV3Core airshipV3;
	
	public GuiEntityAirshipV3Module(IInventory thePlayerInv, EntityAirshipV3Core airshipV3)
	{
		super(new ContainerAirshipV3Module(thePlayerInv, airshipV3));
		
		this.thePlayerInv = thePlayerInv;
		this.airshipV3 = airshipV3;
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
			if(this.airshipV3.getModuleInventorySmall())
			{
				NetworkHandler.sendToServer(new MessageGuiV3ModuleInventorySmall());
			}
			else if(this.airshipV3.getModuleInventoryLarge())
			{
				NetworkHandler.sendToServer(new MessageGuiV3ModuleInventoryLarge());
			}
			else
			{
				NetworkHandler.sendToServer(new MessageGuiV3Default());
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
		if(this.airshipV3.getModuleInventorySmall()
		|| this.airshipV3.getModuleInventoryLarge()
		|| this.airshipV3.getModuleSpeedMinor()
		|| this.airshipV3.getModuleSpeedMajor()
		|| this.airshipV3.getModuleFuelInfinite())
		{
		    //Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 14, 176, 0, 48, 48);
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV3.getDisplayName().getUnformattedText();
		//this.fontRendererObj.drawString("Fuel", 150, 6, 4210752);
		this.fontRendererObj.drawString(this.thePlayerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
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

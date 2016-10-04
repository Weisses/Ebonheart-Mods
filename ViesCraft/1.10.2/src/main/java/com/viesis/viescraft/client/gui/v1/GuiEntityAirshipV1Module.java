package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.ContainerAirshipV1Module;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiV1Default;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventoryLarge;
import com.viesis.viescraft.network.server.MessageGuiV1ModuleInventorySmall;

public class GuiEntityAirshipV1Module extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	
	public GuiEntityAirshipV1Module(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1Module(playerInv, airshipV1));
		
		this.playerInv = playerInv;
		this.airshipV1 = airshipV1;
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
			if(this.airshipV1.getModuleInventorySmall())
			{
				NetworkHandler.sendToServer(new MessageGuiV1ModuleInventorySmall());
			}
			else if(this.airshipV1.getModuleInventoryLarge())
			{
				NetworkHandler.sendToServer(new MessageGuiV1ModuleInventoryLarge());
			}
			else
			{
				NetworkHandler.sendToServer(new MessageGuiV1Default());
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
		//if(this.airshipV1.moduleInventorySmall
		//|| this.airshipV1.getModuleInventoryLarge()
		//|| this.airshipV1.getModuleFuelEfficiency()
		//|| this.airshipV1.getModuleFuelInfinite())
		//{
		    //Draws the box overlay around module slot
			//this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 14, 176, 0, 48, 48);
			//LogHelper.info("true!");
		//}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV1.getDisplayName().getUnformattedText();
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

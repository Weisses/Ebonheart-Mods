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
import com.viesis.viescraft.common.entity.airshipcolors.containers.v3.ContainerAirshipV3Default;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v3.MessageGuiV3Module;

public class GuiEntityAirshipV3Default extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipV3Core airshipV3;
	
	public GuiEntityAirshipV3Default(IInventory playerInv, EntityAirshipV3Core airshipV3)
	{
		super(new ContainerAirshipV3Default(playerInv, airshipV3));
		
		this.playerInv = playerInv;
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
    	
		buttonModule = new GuiButton( 1, this.guiLeft + 133, this.guiTop + 60, 37, 20, "Module");
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
			NetworkHandler.sendToServer(new MessageGuiV3Module());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_default.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (this.airshipV3.getPowered() > 0)
        {
			if(EventHandlerAirship.creativeBurn)
			{
				this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
				this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
				this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
			}
			else
			{
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
			}
		}
		
		//On button is green in gui
		if(this.airshipV3.getModuleSpeedMinor()
		|| this.airshipV3.getModuleSpeedMajor()
		|| this.airshipV3.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 124, this.guiTop + 61, 176, 100, 8, 8);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(EventHandlerAirship.creativeBurn
		|| this.airshipV3.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
		}
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV3.getField(1);
        if (i == 0)
        {
        	i = this.airshipV3.itemFuelStack + 1;
        }
        
        return this.airshipV3.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV3.getDisplayName().getUnformattedText();
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

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
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1ModuleInvLarge;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v1.MessageGuiV1Module;

public class GuiEntityAirshipV1ModuleInventoryLarge extends GuiContainer {
	
	private GuiButton buttonModule;
	private IInventory thePlayerInv;
	private EntityAirshipV1Core airshipV1;
	
	public GuiEntityAirshipV1ModuleInventoryLarge(IInventory thePlayerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1ModuleInvLarge(thePlayerInv, airshipV1));
		
		this.thePlayerInv = thePlayerInv;
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
			NetworkHandler.sendToServer(new MessageGuiV1Module());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_module2.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (this.airshipV1.getPowered() > 0)
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
		
		//Draw a green fuel bar and magma in the coal slot
		if(EventHandlerAirship.creativeBurn
		|| this.airshipV1.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
		}
    }
	
	private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV1.getField(1);
        if (i == 0)
        {
        	i = this.airshipV1.itemFuelStack + 1;
        }
        
        return this.airshipV1.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airshipV1.getDisplayName().getUnformattedText();
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

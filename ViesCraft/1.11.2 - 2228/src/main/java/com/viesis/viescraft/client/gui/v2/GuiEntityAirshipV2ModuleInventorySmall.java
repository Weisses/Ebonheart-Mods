package com.viesis.viescraft.client.gui.v2;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV2Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v2.ContainerAirshipV2ModuleInvSmall;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage1;
import com.viesis.viescraft.network.server.v2.MessageGuiV2Module;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEntityAirshipV2ModuleInventorySmall extends GuiContainer {
	/** Frame */
	private GuiButton buttonFrame;
	/** Module */
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipV2Core airshipV2;
	
	public GuiEntityAirshipV2ModuleInventorySmall(IInventory playerInv, EntityAirshipV2Core airshipV2)
	{
		super(new ContainerAirshipV2ModuleInvSmall(playerInv, airshipV2));
		
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
    	
    	buttonModule = new GuiButton( 1, this.guiLeft + 133, this.guiTop + 67, 37, 14, "Module");
		this.buttonList.add(buttonModule);
		
		buttonFrame = new GuiButton( 2, this.guiLeft + 133, this.guiTop + 53, 37, 14, "Frame");
		this.buttonList.add(buttonFrame);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			NetworkHandler.sendToServer(new MessageGuiV2Module());
	    }
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage1());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_module1.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (this.airshipV2.getPowered() > 0)
        {
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(this.airshipV2.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
		}
    }
	
	private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV2.getField(1);
        if (i == 0)
        {
        	i = this.airshipV2.itemFuelStack + 1;
        }
        
        return this.airshipV2.getField(0) * pixels / i;
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
            this.mc.player.closeScreen();
        }
    }
}

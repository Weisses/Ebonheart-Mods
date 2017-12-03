package com.viesis.viescraft.client.gui.airship.modules;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipModule;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiDefault;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventoryLarge;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventorySmall;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiModuleSocket extends GuiContainer {
	
	/** Module */
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	public GuiModuleSocket(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipModule(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
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
			if(this.airship.getModuleInventorySmall())
			{
				NetworkHandler.sendToServer(new MessageGuiModuleInventorySmall());
			}
			else if(this.airship.getModuleInventoryLarge())
			{
				NetworkHandler.sendToServer(new MessageGuiModuleInventoryLarge());
			}
			else if(this.airship.getModuleJukebox())
			{
				NetworkHandler.sendToServer(new MessageGuiModuleJukebox());
			}
			else
			{
				NetworkHandler.sendToServer(new MessageGuiDefault());
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
		if(this.airship.getModuleSpeedMinor()
		|| this.airship.getModuleSpeedMajor()
		|| this.airship.getModuleInventorySmall()
		|| this.airship.getModuleInventoryLarge()
		|| this.airship.getModuleFuelInfinite()
		|| this.airship.getModuleWaterLanding()
		|| this.airship.getModuleMaxAltitude()
		|| this.airship.getModuleMinorEfficiency()
		|| this.airship.getModuleMajorEfficiency()
		|| this.airship.getModuleJukebox()
		|| this.airship.getModuleCruiseControl())
		{
		    //Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 64, this.guiTop + 14, 176, 0, 48, 48);
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airship.getDisplayName().getUnformattedText();
		this.fontRenderer.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
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
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
}

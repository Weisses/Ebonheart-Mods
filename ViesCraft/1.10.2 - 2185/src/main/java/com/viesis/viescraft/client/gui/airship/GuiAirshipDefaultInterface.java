package com.viesis.viescraft.client.gui.airship;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipDefault;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiModule;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipDefaultInterface extends GuiContainer {
	
	/** Frame */
	private GuiButton buttonFrame;
	/** Module */
	private GuiButton buttonModule;
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	public GuiAirshipDefaultInterface(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipDefault(playerInv, airshipIn));
		
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
			NetworkHandler.sendToServer(new MessageGuiModule());
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
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_default.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if (this.airship.getPowered() > 0)
        {
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
		}
		
		//On button is green in gui
		if(this.airship.getModuleSpeedMinor()
		|| this.airship.getModuleSpeedMajor()
		|| this.airship.getModuleFuelInfinite()
		|| this.airship.getModuleWaterLanding()
		|| this.airship.getModuleMaxAltitude()
		|| this.airship.getModuleMinorEfficiency()
		|| this.airship.getModuleMajorEfficiency())
		{
			this.drawTexturedModalRect(this.guiLeft + 124, this.guiTop + 61, 176, 100, 8, 8);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(this.airship.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
		}
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(1);
        if (i == 0)
        {
        	i = this.airship.itemFuelStack + 1;
        }
        
        return this.airship.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		String s = this.airship.getDisplayName().getUnformattedText();
		
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
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead
        || !this.mc.thePlayer.isRiding())
        {
            this.mc.thePlayer.closeScreen();
        }
    }
}

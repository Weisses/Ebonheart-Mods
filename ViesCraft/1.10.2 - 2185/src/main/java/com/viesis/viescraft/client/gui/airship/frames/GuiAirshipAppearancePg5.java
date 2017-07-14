package com.viesis.viescraft.client.gui.airship.frames;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiDefault;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventoryLarge;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleInventorySmall;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage5;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage4;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipAppearancePg5 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiAirshipAppearancePg5(IInventory playerInv, EntityAirshipBaseVC airship)
	{
		super(new ContainerAirshipAppearance(playerInv, airship));
		
		this.playerInv = playerInv;
		this.airship = airship;
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
    	
    	GuiVC.buttonDone = new GuiButton( 30, this.guiLeft + 40, this.guiTop + 156, 96, 20, "Done");
    	GuiVC.buttonPrev = new GuiButton( 32, this.guiLeft + 4, this.guiTop + 4, 57, 20, "Prev");
		
    	GuiVC.button26 = new GuiButton( 26, this.guiLeft + 15, this.guiTop + 62, 57, 20, "Mythic");
    	GuiVC.button39 = new GuiButton( 39, this.guiLeft + 15, this.guiTop + 97, 57, 20, "Water");
    	GuiVC.button40 = new GuiButton( 40, this.guiLeft + 105, this.guiTop + 62, 57, 20, "Lava");
    	GuiVC.button41 = new GuiButton( 41, this.guiLeft + 105, this.guiTop + 97, 57, 20, "Ender");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonPrev);
		
		this.buttonList.add(GuiVC.button26);
		this.buttonList.add(GuiVC.button39);
		this.buttonList.add(GuiVC.button40);
		this.buttonList.add(GuiVC.button41);
		
		if(this.airship.metaFrameCore == 26)
    	{
    		GuiVC.button39.visible = false;
    		GuiVC.button40.visible = false;
    		GuiVC.button41.visible = false;
    	}
		if(this.airship.metaFrameCore == 27)
    	{
			GuiVC.button40.visible = false;
    		GuiVC.button41.visible = false;
    	}
		if(this.airship.metaFrameCore == 28)
    	{
			GuiVC.button41.visible = false;
    	}
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 30)
	    {
			//If airship has small inv module installed
        	if(this.airship.getModuleInventorySmall())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleInventorySmall());
        	}
        	//If airship has large inv module installed
        	else if(this.airship.getModuleInventoryLarge())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleInventoryLarge());
        	}
        	//If airship has jukebox module installed
        	else if(this.airship.getModuleJukebox())
        	{
        		NetworkHandler.sendToServer(new MessageGuiModuleJukebox());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiDefault());
        	}
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage4());
	    }
		if (parButton.id == 26)
	    {
			this.metaInfo = 26;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage5());
	    }
		if (parButton.id == 39)
	    {
			this.metaInfo = 27;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage5());
	    }
		if (parButton.id == 40)
	    {
			this.metaInfo = 28;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage5());
	    }
		if (parButton.id == 41)
	    {
			this.metaInfo = 29;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage5());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_appearance.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		this.drawRect(this.guiLeft + 32, this.guiTop - 16, this.guiLeft + 142, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 34, this.guiTop - 14, this.guiLeft + 140, this.guiTop, Color.BLACK.getRGB());
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString("Tier IV", 71, 10, 11111111);
		this.fontRendererObj.drawString("Frame Appearance", 40, -10, 65521);
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

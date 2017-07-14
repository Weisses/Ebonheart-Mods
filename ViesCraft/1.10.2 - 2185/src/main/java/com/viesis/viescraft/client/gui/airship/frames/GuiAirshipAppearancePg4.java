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
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage4;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage5;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipAppearancePg4 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiAirshipAppearancePg4(IInventory playerInv, EntityAirshipBaseVC airship)
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
    	GuiVC.buttonNext = new GuiButton( 31, this.guiLeft + 116, this.guiTop + 4, 57, 20, "Next");
    	GuiVC.buttonPrev = new GuiButton( 32, this.guiLeft + 4, this.guiTop + 4, 57, 20, "Prev");
		
    	GuiVC.button21 = new GuiButton( 21, this.guiLeft + 15, this.guiTop + 46, 57, 20, "Diamond");
		GuiVC.button22 = new GuiButton( 22, this.guiLeft + 15, this.guiTop + 81, 57, 20, "Emerald");
		GuiVC.button23 = new GuiButton( 23, this.guiLeft + 15, this.guiTop + 115, 57, 20, "Prismarine");
		GuiVC.button24 = new GuiButton( 24, this.guiLeft + 105, this.guiTop + 62, 57, 20, "Purpur");
		GuiVC.button25 = new GuiButton( 25, this.guiLeft + 105, this.guiTop + 97, 57, 20, "N. Star");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		this.buttonList.add(GuiVC.buttonPrev);
		
		this.buttonList.add(GuiVC.button21);
		this.buttonList.add(GuiVC.button22);
		this.buttonList.add(GuiVC.button23);
		this.buttonList.add(GuiVC.button24);
		this.buttonList.add(GuiVC.button25);
		
		if(this.airship.metaFrameCore == 21)
    	{
    		GuiVC.button22.visible = false;
    		GuiVC.button23.visible = false;
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    	}
		if(this.airship.metaFrameCore == 22)
    	{
    		GuiVC.button23.visible = false;
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    	}
		if(this.airship.metaFrameCore == 23)
    	{
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    	}
		if(this.airship.metaFrameCore == 24)
    	{
    		GuiVC.button25.visible = false;
    	}
    	if(this.airship.metaFrameCore < 26)
    	{
    		GuiVC.buttonNext.visible = false;
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
		if (parButton.id == 31)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage5());
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage3());
	    }
		if (parButton.id == 21)
	    {
			this.metaInfo = 21;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage4());
	    }
		if (parButton.id == 22)
	    {
			this.metaInfo = 22;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage4());
	    }
		if (parButton.id == 23)
	    {
			this.metaInfo = 23;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage4());
	    }
		if (parButton.id == 24)
	    {
			this.metaInfo = 24;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage4());
	    }
		if (parButton.id == 25)
	    {
			this.metaInfo = 25;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage4());
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

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
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage1;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage3;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipAppearancePg2 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiAirshipAppearancePg2(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipAppearance(playerInv, airshipIn));
		
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
    	
    	GuiVC.buttonDone = new GuiButton( 30, this.guiLeft + 40, this.guiTop + 156, 96, 20, "Done");
    	GuiVC.buttonNext = new GuiButton( 31, this.guiLeft + 116, this.guiTop + 4, 57, 20, "Next");
    	GuiVC.buttonPrev = new GuiButton( 32, this.guiLeft + 4, this.guiTop + 4, 57, 20, "Prev");
		
    	GuiVC.button8 = new GuiButton( 8, this.guiLeft + 15, this.guiTop + 40, 57, 20, "Bone");
		GuiVC.button9 = new GuiButton( 9, this.guiLeft + 15, this.guiTop + 67, 57, 20, "Iron");
		GuiVC.button10 = new GuiButton( 10, this.guiLeft + 15, this.guiTop + 94, 57, 20, "Redstone");
		GuiVC.button11 = new GuiButton( 11, this.guiLeft + 15, this.guiTop + 121, 57, 20, "Gold");
		GuiVC.button12 = new GuiButton( 12, this.guiLeft + 105, this.guiTop + 46, 57, 20, "Lapis");
		GuiVC.button13 = new GuiButton( 13, this.guiLeft + 105, this.guiTop + 81, 57, 20, "Slime");
		GuiVC.button14 = new GuiButton( 14, this.guiLeft + 105, this.guiTop + 115, 57, 20, "Mycelium");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		this.buttonList.add(GuiVC.buttonPrev);
		
		this.buttonList.add(GuiVC.button8);
		this.buttonList.add(GuiVC.button9);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);
		this.buttonList.add(GuiVC.button13);
		this.buttonList.add(GuiVC.button14);
		
		if(this.airship.metaFrameCore == 8)
    	{
    		GuiVC.button9.visible = false;
    		GuiVC.button10.visible = false;
    		GuiVC.button11.visible = false;
    		GuiVC.button12.visible = false;
    		GuiVC.button13.visible = false;
    		GuiVC.button14.visible = false;
    	}
		if(this.airship.metaFrameCore == 9)
    	{
    		GuiVC.button10.visible = false;
    		GuiVC.button11.visible = false;
    		GuiVC.button12.visible = false;
    		GuiVC.button13.visible = false;
    		GuiVC.button14.visible = false;
    	}
		if(this.airship.metaFrameCore == 10)
    	{
    		GuiVC.button11.visible = false;
    		GuiVC.button12.visible = false;
    		GuiVC.button13.visible = false;
    		GuiVC.button14.visible = false;
    	}
		if(this.airship.metaFrameCore == 11)
    	{
    		GuiVC.button12.visible = false;
    		GuiVC.button13.visible = false;
    		GuiVC.button14.visible = false;
    	}
		if(this.airship.metaFrameCore == 12)
    	{
    		GuiVC.button13.visible = false;
    		GuiVC.button14.visible = false;
    	}
		if(this.airship.metaFrameCore == 13)
    	{
    		GuiVC.button14.visible = false;
    	}
    	if(this.airship.metaFrameCore < 15)
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
			NetworkHandler.sendToServer(new MessageGuiAppearancePage3());
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage1());
	    }
		if (parButton.id == 8)
	    {
			this.metaInfo = 8;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 9)
	    {
			this.metaInfo = 9;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 10)
	    {
			this.metaInfo = 10;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 11)
	    {
			this.metaInfo = 11;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 12)
	    {
			this.metaInfo = 12;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 13)
	    {
			this.metaInfo = 13;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
	    }
		if (parButton.id == 14)
	    {
			this.metaInfo = 14;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage2());
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
		this.fontRenderer.drawString("Tier II", 72, 10, 11111111);
		this.fontRenderer.drawString("Frame Appearance", 40, -10, 65521);
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

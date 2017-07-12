package com.viesis.viescraft.client.gui.airship.frames;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearanceHelperPage3;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage2;
import com.viesis.viescraft.network.server.appearance.MessageGuiAppearancePage4;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipAppearancePg3 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiAirshipAppearancePg3(IInventory playerInv, EntityAirshipBaseVC airship)
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
		
    	GuiVC.button15 = new GuiButton( 15, this.guiLeft + 15, this.guiTop + 46, 57, 20, "N. Brick");
		GuiVC.button16 = new GuiButton( 16, this.guiLeft + 15, this.guiTop + 81, 57, 20, "Soul Sand");
		GuiVC.button17 = new GuiButton( 17, this.guiLeft + 15, this.guiTop + 115, 57, 20, "Quartz");
		GuiVC.button18 = new GuiButton( 18, this.guiLeft + 105, this.guiTop + 46, 57, 20, "Ice");
		GuiVC.button19 = new GuiButton( 19, this.guiLeft + 105, this.guiTop + 81, 57, 20, "Glowstone");
		GuiVC.button20 = new GuiButton( 20, this.guiLeft + 105, this.guiTop + 115, 57, 20, "Obsidian");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		this.buttonList.add(GuiVC.buttonPrev);
		
		this.buttonList.add(GuiVC.button15);
		this.buttonList.add(GuiVC.button16);
		this.buttonList.add(GuiVC.button17);
		this.buttonList.add(GuiVC.button18);
		this.buttonList.add(GuiVC.button19);
		this.buttonList.add(GuiVC.button20);
		
		if(this.airship.metaFrameCore == 15)
    	{
    		GuiVC.button16.visible = false;
    		GuiVC.button17.visible = false;
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airship.metaFrameCore == 16)
    	{
    		GuiVC.button17.visible = false;
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airship.metaFrameCore == 17)
    	{
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airship.metaFrameCore == 18)
    	{
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airship.metaFrameCore == 19)
    	{
    		GuiVC.button20.visible = false;
    	}
    	if(this.airship.metaFrameCore < 21)
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
			this.mc.player.closeScreen();
	    }
		if (parButton.id == 31)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage4());
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiAppearancePage2());
	    }
		if (parButton.id == 15)
	    {
			this.metaInfo = 15;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
	    }
		if (parButton.id == 16)
	    {
			this.metaInfo = 16;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
	    }
		if (parButton.id == 17)
	    {
			this.metaInfo = 17;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
	    }
		if (parButton.id == 18)
	    {
			this.metaInfo = 18;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
	    }
		if (parButton.id == 19)
	    {
			this.metaInfo = 19;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
	    }
		if (parButton.id == 20)
	    {
			this.metaInfo = 20;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearanceHelperPage3());
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
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRenderer.drawString("Tier III", 70, 10, 11111111);
		this.fontRenderer.drawString("Appearance", 58, -10, 65521);
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

package com.viesis.viescraft.client.gui.airship.music;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiModuleJukebox;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg2;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg4;
import com.viesis.viescraft.network.server.song.MessageGuiSongHelperPage3;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipMusicPg3 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	
	public GuiAirshipMusicPg3(IInventory playerInv, EntityAirshipBaseVC airship)
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

    	GuiVC.button35 = new GuiButton( 9, this.guiLeft + 15, this.guiTop + 40, 57, 20, "Far");
		GuiVC.button36 = new GuiButton( 10, this.guiLeft + 15, this.guiTop + 94, 57, 20, "Mall");
		GuiVC.button37 = new GuiButton( 11, this.guiLeft + 105, this.guiTop + 40, 57, 20, "Wait");
		GuiVC.button38 = new GuiButton( 12, this.guiLeft + 105, this.guiTop + 94, 57, 20, "Ward");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		this.buttonList.add(GuiVC.buttonPrev);

		this.buttonList.add(GuiVC.button35);
		this.buttonList.add(GuiVC.button36);
		this.buttonList.add(GuiVC.button37);
		this.buttonList.add(GuiVC.button38);
		
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
			NetworkHandler.sendToServer(new MessageGuiModuleJukebox());
	    }
		if (parButton.id == 31)
	    {
			NetworkHandler.sendToServer(new MessageGuiMusicPg4());
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiMusicPg2());
	    }
		if (parButton.id == 9)
	    {
			this.metaInfo = 9;
			NetworkHandler.sendToServer(new MessageGuiSongHelperPage3());
	    }
		if (parButton.id == 10)
	    {
			this.metaInfo = 10;
			NetworkHandler.sendToServer(new MessageGuiSongHelperPage3());
	    }
		if (parButton.id == 11)
	    {
			this.metaInfo = 11;
			NetworkHandler.sendToServer(new MessageGuiSongHelperPage3());
	    }
		if (parButton.id == 12)
	    {
			this.metaInfo = 12;
			NetworkHandler.sendToServer(new MessageGuiSongHelperPage3());
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
		this.fontRendererObj.drawString("Tier III", 70, 10, 11111111);
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

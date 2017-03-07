package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1AppearancePage4;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearanceHelperPage4;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearancePage3;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEntityAirshipV1AppearancePage4 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiEntityAirshipV1AppearancePage4(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1AppearancePage4(playerInv, airshipV1));
		
		this.playerInv = playerInv;
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
    	
    	GuiVC.buttonDone = new GuiButton( 30, this.guiLeft + 40, this.guiTop + 156, 96, 20, "Done");
    	GuiVC.buttonPrev = new GuiButton( 32, this.guiLeft + 4, this.guiTop + 4, 57, 20, "Prev");
		
    	GuiVC.button21 = new GuiButton( 21, this.guiLeft + 15, this.guiTop + 46, 57, 20, "Diamond");
		GuiVC.button22 = new GuiButton( 22, this.guiLeft + 15, this.guiTop + 81, 57, 20, "Emerald");
		GuiVC.button23 = new GuiButton( 23, this.guiLeft + 15, this.guiTop + 115, 57, 20, "Prismarine");
		GuiVC.button24 = new GuiButton( 24, this.guiLeft + 105, this.guiTop + 46, 57, 20, "Purpur");
		GuiVC.button25 = new GuiButton( 25, this.guiLeft + 105, this.guiTop + 81, 57, 20, "N. Star");
		GuiVC.button26 = new GuiButton( 26, this.guiLeft + 105, this.guiTop + 115, 57, 20, "Mythic");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		this.buttonList.add(GuiVC.buttonPrev);
		
		this.buttonList.add(GuiVC.button21);
		this.buttonList.add(GuiVC.button22);
		this.buttonList.add(GuiVC.button23);
		this.buttonList.add(GuiVC.button24);
		this.buttonList.add(GuiVC.button25);
		this.buttonList.add(GuiVC.button26);
		
		if(this.airshipV1.metaFrameCore == 21)
    	{
    		GuiVC.button22.visible = false;
    		GuiVC.button23.visible = false;
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    		GuiVC.button26.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 22)
    	{
    		GuiVC.button23.visible = false;
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    		GuiVC.button26.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 23)
    	{
    		GuiVC.button24.visible = false;
    		GuiVC.button25.visible = false;
    		GuiVC.button26.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 24)
    	{
    		GuiVC.button25.visible = false;
    		GuiVC.button26.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 25)
    	{
    		GuiVC.button26.visible = false;
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
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiV1AppearancePage3());
	    }
		if (parButton.id == 21)
	    {
			this.metaInfo = 21;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
	    }
		if (parButton.id == 22)
	    {
			this.metaInfo = 22;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
	    }
		if (parButton.id == 23)
	    {
			this.metaInfo = 23;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
	    }
		if (parButton.id == 24)
	    {
			this.metaInfo = 24;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
	    }
		if (parButton.id == 25)
	    {
			this.metaInfo = 25;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
	    }
		if (parButton.id == 26)
	    {
			this.metaInfo = 26;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage4());
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
		this.fontRendererObj.drawString("Tier IV", 71, 10, 11111111);
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

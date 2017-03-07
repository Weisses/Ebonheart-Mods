package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1AppearancePage1;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearanceHelperPage1;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearancePage1;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearancePage2;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEntityAirshipV1AppearancePage1 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiEntityAirshipV1AppearancePage1(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1AppearancePage1(playerInv, airshipV1));
		
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
    	GuiVC.buttonNext = new GuiButton( 31, this.guiLeft + 116, this.guiTop + 4, 57, 20, "Next");
		
    	GuiVC.button0 = new GuiButton( 0, this.guiLeft + 15, this.guiTop + 40, 57, 20, "Oak");
		GuiVC.button1 = new GuiButton( 1, this.guiLeft + 15, this.guiTop + 67, 57, 20, "Spruce");
		GuiVC.button2 = new GuiButton( 2, this.guiLeft + 15, this.guiTop + 94, 57, 20, "Birch");
		GuiVC.button3 = new GuiButton( 3, this.guiLeft + 15, this.guiTop + 121, 57, 20, "Jungle");
		GuiVC.button4 = new GuiButton( 4, this.guiLeft + 105, this.guiTop + 40, 57, 20, "Acacia");
		GuiVC.button5 = new GuiButton( 5, this.guiLeft + 105, this.guiTop + 67, 57, 20, "Dark Oak");
		GuiVC.button6 = new GuiButton( 6, this.guiLeft + 105, this.guiTop + 94, 57, 20, "Sandstone");
		GuiVC.button7 = new GuiButton( 7, this.guiLeft + 105, this.guiTop + 121, 57, 20, "Brick");
		
		this.buttonList.add(GuiVC.buttonDone);
		this.buttonList.add(GuiVC.buttonNext);
		
		this.buttonList.add(GuiVC.button0);
		this.buttonList.add(GuiVC.button1);
		this.buttonList.add(GuiVC.button2);
		this.buttonList.add(GuiVC.button3);
		this.buttonList.add(GuiVC.button4);
		this.buttonList.add(GuiVC.button5);
		this.buttonList.add(GuiVC.button6);
		this.buttonList.add(GuiVC.button7);
		
		if(this.airshipV1.metaFrameCore <= 5)
    	{
    		GuiVC.button0.visible = false;
    		GuiVC.button1.visible = false;
    		GuiVC.button2.visible = false;
    		GuiVC.button3.visible = false;
    		GuiVC.button4.visible = false;
    		GuiVC.button5.visible = false;
    		GuiVC.button6.visible = false;
    		GuiVC.button7.visible = false;
    	}
		
    	if(this.airshipV1.metaFrameCore == 6)
    	{
    		GuiVC.button7.visible = false;
    	}
    	
    	if(this.airshipV1.metaFrameCore < 8)
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
			NetworkHandler.sendToServer(new MessageGuiV1AppearancePage2());
	    }
		if (parButton.id == 0)
	    {
			this.metaInfo = 0;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 1)
	    {
			this.metaInfo = 1;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 2)
	    {
			this.metaInfo = 2;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 3)
	    {
			this.metaInfo = 3;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 4)
	    {
			this.metaInfo = 4;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 5)
	    {
			this.metaInfo = 5;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 6)
	    {
			this.metaInfo = 6;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
	    }
		if (parButton.id == 7)
	    {
			this.metaInfo = 7;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage1());
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
		this.fontRendererObj.drawString("Tier I", 74, 10, 11111111);
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

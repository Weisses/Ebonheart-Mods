package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1AppearancePage3;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearanceHelperPage3;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearancePage2;
import com.viesis.viescraft.network.server.v1.appearance.MessageGuiV1AppearancePage4;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiEntityAirshipV1AppearancePage3 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiEntityAirshipV1AppearancePage3(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1AppearancePage3(playerInv, airshipV1));
		
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
		
		if(this.airshipV1.metaFrameCore == 15)
    	{
    		GuiVC.button16.visible = false;
    		GuiVC.button17.visible = false;
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 16)
    	{
    		GuiVC.button17.visible = false;
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 17)
    	{
    		GuiVC.button18.visible = false;
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 18)
    	{
    		GuiVC.button19.visible = false;
    		GuiVC.button20.visible = false;
    	}
		if(this.airshipV1.metaFrameCore == 19)
    	{
    		GuiVC.button20.visible = false;
    	}
    	if(this.airshipV1.metaFrameCore < 21)
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
			NetworkHandler.sendToServer(new MessageGuiV1AppearancePage4());
	    }
		if (parButton.id == 32)
	    {
			NetworkHandler.sendToServer(new MessageGuiV1AppearancePage2());
	    }
		if (parButton.id == 15)
	    {
			this.metaInfo = 15;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
	    }
		if (parButton.id == 16)
	    {
			this.metaInfo = 16;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
	    }
		if (parButton.id == 17)
	    {
			this.metaInfo = 17;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
	    }
		if (parButton.id == 18)
	    {
			this.metaInfo = 18;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
	    }
		if (parButton.id == 19)
	    {
			this.metaInfo = 19;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
	    }
		if (parButton.id == 20)
	    {
			this.metaInfo = 20;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiV1AppearanceHelperPage3());
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
}

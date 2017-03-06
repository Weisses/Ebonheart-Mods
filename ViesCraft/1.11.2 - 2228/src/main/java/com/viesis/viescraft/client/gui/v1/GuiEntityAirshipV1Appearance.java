package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipV1Core;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1Appearance;
import com.viesis.viescraft.common.entity.airshipcolors.containers.v1.ContainerAirshipV1Default;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiAppearance;
import com.viesis.viescraft.network.server.v1.MessageGuiV1Module;

public class GuiEntityAirshipV1Appearance extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipV1Core airshipV1;
	public static int metaInfo;
	public static boolean metaActiveInfo;
	
	public GuiEntityAirshipV1Appearance(IInventory playerInv, EntityAirshipV1Core airshipV1)
	{
		super(new ContainerAirshipV1Appearance(playerInv, airshipV1));
		
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
    	
    	GuiVC.buttonDone = new GuiButton( 30, this.guiLeft + 42, this.guiTop + 156, 96, 20, "Done");
    	GuiVC.buttonNext = new GuiButton( 31, this.guiLeft + 117, this.guiTop + 3, 57, 20, "Next");
		
    	GuiVC.button0 = new GuiButton( 0, this.guiLeft + 10, this.guiTop + 30, 57, 20, "Oak");
		GuiVC.button1 = new GuiButton( 1, this.guiLeft + 10, this.guiTop + 50, 57, 20, "Spruce");
		GuiVC.button2 = new GuiButton( 2, this.guiLeft + 10, this.guiTop + 70, 57, 20, "Birch");
		GuiVC.button3 = new GuiButton( 3, this.guiLeft + 10, this.guiTop + 90, 57, 20, "Jungle");
		GuiVC.button4 = new GuiButton( 4, this.guiLeft + 10, this.guiTop + 110, 57, 20, "Acacia");
		GuiVC.button5 = new GuiButton( 5, this.guiLeft + 10, this.guiTop + 130, 57, 20, "Dark Oak");
		GuiVC.button6 = new GuiButton( 6, this.guiLeft + 70, this.guiTop + 130, 57, 20, "Sandstone");
		GuiVC.button7 = new GuiButton( 7, this.guiLeft + 70, this.guiTop + 150, 57, 20, "Brick");
		
		/**
		GuiVC.button8 = new GuiButton( 9, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Bone");
		GuiVC.button9 = new GuiButton( 10, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Iron");
		GuiVC.button10 = new GuiButton( 11, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Redstone");
		GuiVC.button11 = new GuiButton( 12, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Gold");
		GuiVC.button12 = new GuiButton( 13, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Lapis Lazuli");
		GuiVC.button13 = new GuiButton( 14, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Slime");
		GuiVC.button14 = new GuiButton( 15, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Mycelium");
		
		GuiVC.button15 = new GuiButton( 16, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Nether Brick");
		GuiVC.button16 = new GuiButton( 17, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Soul Sand");
		GuiVC.button17 = new GuiButton( 18, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Quartz");
		GuiVC.button18 = new GuiButton( 19, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Ice");
		GuiVC.button19 = new GuiButton( 20, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Glowstone");
		GuiVC.button20 = new GuiButton( 21, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Obsidian");
		
		GuiVC.button21 = new GuiButton( 22, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Diamond");
		GuiVC.button22 = new GuiButton( 23, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Emerald");
		GuiVC.button23 = new GuiButton( 24, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Prismarine");
		GuiVC.button24 = new GuiButton( 25, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Purpur");
		GuiVC.button25 = new GuiButton( 26, this.guiLeft + 133, this.guiTop + 60, 57, 20, "Nether Star");
		*/
		
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
		
		/**
		this.buttonList.add(GuiVC.button8);
		this.buttonList.add(GuiVC.button9);
		this.buttonList.add(GuiVC.button10);
		this.buttonList.add(GuiVC.button11);
		this.buttonList.add(GuiVC.button12);
		this.buttonList.add(GuiVC.button13);
		this.buttonList.add(GuiVC.button14);
		
		this.buttonList.add(GuiVC.button15);
		this.buttonList.add(GuiVC.button16);
		this.buttonList.add(GuiVC.button17);
		this.buttonList.add(GuiVC.button18);
		this.buttonList.add(GuiVC.button19);
		this.buttonList.add(GuiVC.button20);
		
		this.buttonList.add(GuiVC.button21);
		this.buttonList.add(GuiVC.button22);
		this.buttonList.add(GuiVC.button23);
		this.buttonList.add(GuiVC.button24);
		this.buttonList.add(GuiVC.button25);
		*/
		
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
    	
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 30)
	    {
			//this.airshipV1.metaFrameCore = 6;
			//NetworkHandler.sendToServer(new MessageGuiV1Module());
	    }
		if (parButton.id == 0)
	    {
			this.metaInfo = 0;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 1)
	    {
			this.metaInfo = 1;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 2)
	    {
			this.metaInfo = 2;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 3)
	    {
			this.metaInfo = 3;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 4)
	    {
			this.metaInfo = 4;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 5)
	    {
			this.metaInfo = 5;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 6)
	    {
			this.metaInfo = 6;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
	    }
		if (parButton.id == 7)
	    {
			this.metaInfo = 7;
			metaActiveInfo = true;
			NetworkHandler.sendToServer(new MessageGuiAppearance());
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
		
		if (this.airshipV1.getPowered() > 0)
        {
			//if(EventHandlerAirship.creativeBurn)
			//{
			//	this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			//	this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
			//	this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
			//}
			//else
			//{
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 176, 50, 8, 1 + k);
            this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 30, 176, 14, 26, 16);
			//}
		}
		
		//On button is green in gui
		if(this.airshipV1.getModuleSpeedMinor()
		|| this.airshipV1.getModuleSpeedMajor()
		|| this.airshipV1.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 124, this.guiTop + 61, 176, 100, 8, 8);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(//EventHandlerAirship.creativeBurn
		//|| 
		this.airshipV1.getModuleFuelInfinite())
		{
			this.drawTexturedModalRect(this.guiLeft + 138, this.guiTop + 4, 184, 50, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 152, this.guiTop + 17, 176, 119, 16, 16);
		}
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airshipV1.getField(1);
        if (i == 0)
        {
        	i = this.airshipV1.itemFuelStack + 1;
        }
        
        return this.airshipV1.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString("Tier I", 72, 6, 4210752);
		
		//String s = this.airshipV1.getDisplayName().getUnformattedText();
		//this.fontRendererObj.drawString("Fuel", 150, 6, 4210752);
		//this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
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

package com.viesis.viescraft.client.gui.airship.main;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiRandomMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiStopMusic;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;

public class GuiMainMenuMusic extends GuiMainMenu {
	
	public static int airshipId;
	public static int selectedSong;
	
	public GuiMainMenuMusic(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(playerInv, airshipIn);
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	super.initGui();
    	
    	GuiVC.buttonM5 = new GuiButtonGeneralVC(5, this.guiLeft + 49, this.guiTop + 62 , 78, 14, References.localNameVC("vc.button.choosemusic"));
    	GuiVC.buttonM6 = new GuiButtonGeneralVC(6, this.guiLeft + 35, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.play"));
    	GuiVC.buttonM7 = new GuiButtonGeneralVC(7, this.guiLeft + 71, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.stop"));
    	GuiVC.buttonM8 = new GuiButtonGeneralVC(8, this.guiLeft + 107, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.random"));
		
		this.buttonList.add(GuiVC.buttonM5);
		this.buttonList.add(GuiVC.buttonM6);
		this.buttonList.add(GuiVC.buttonM7);
		this.buttonList.add(GuiVC.buttonM8);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 5)
	    {
			NetworkHandler.sendToServer(new MessageGuiMusicPg1());
	    }
		
		if (parButton.id == 6)
	    {
			airshipId = this.airship.getEntityId();
			NetworkHandler.sendToServer(new MessageGuiPlayMusic());
	    }
		if (parButton.id == 7)
	    {
			airshipId = this.airship.getEntityId();
			NetworkHandler.sendToServer(new MessageGuiStopMusic());
	    }
		if (parButton.id == 8)
	    {
			this.selectedSong = References.random.nextInt(18) + 1;
			
			airshipId = this.airship.getEntityId();
			NetworkHandler.sendToServer(new MessageGuiRandomMusic());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		//Selected song
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88, this.guiTop + 84, 0);
			GlStateManager.scale(1.00, 1.00, 1.00);
			
			this.drawCenteredString(fontRenderer, EnumsVC.AirshipSong.byId(this.airship.metaJukeboxSelectedSong).getRegistryName(), 0, 0, 255);
		}
		GlStateManager.popMatrix();
	}
}

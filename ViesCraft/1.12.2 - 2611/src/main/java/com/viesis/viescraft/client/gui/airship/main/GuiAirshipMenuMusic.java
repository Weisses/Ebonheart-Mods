package com.viesis.viescraft.client.gui.airship.main;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;

public class GuiAirshipMenuMusic extends GuiAirshipMenu {
	
	public static int airshipId;
	
	public GuiAirshipMenuMusic(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	
    	GuiVC.buttonM5 = new GuiButtonGeneralVC(5, this.guiLeft + 21, this.guiTop + 62 , 78, 14, References.localNameVC("vc.button.choosemusic"));
    	GuiVC.buttonM6 = new GuiButtonGeneralVC(6, this.guiLeft + 78, this.guiTop + 100, 37, 14, References.localNameVC("vc.button.play"));
		
		this.buttonList.add(GuiVC.buttonM5);
		this.buttonList.add(GuiVC.buttonM6);
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
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
    @Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
    	super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		//Selected song
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(26, 85, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.selected") + " : " + EnumsVC.AirshipSong.byId(this.airship.metaJukeboxSelectedSong).getName(), 0, 0, 255);
		}
		GlStateManager.popMatrix();
	}
}

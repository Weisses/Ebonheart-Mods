package com.viesis.viescraft.client.gui.airship.music;

import java.awt.Color;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.main.MessageGuiMainMenu;
import com.viesis.viescraft.network.server.song.MessageHelperGuiMusicPg1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiAirshipMusicPg1 extends GuiContainerVC {
	
	public GuiAirshipMusicPg1(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
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
    	int startPlace = 16;
    	
    	GuiVC.button501 = new GuiButton(501, this.guiLeft + 40, this.guiTop + 156, 96, 20, References.localNameVC("vc.button.done"));
    	
    	GuiVC.buttonR01 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORD11.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 0), 62, 14, References.localNameVC("vc.item.enum.song.1"), 0);
		GuiVC.buttonR02 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORD13.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 1), 62, 14, References.localNameVC("vc.item.enum.song.2"), 0);
    	GuiVC.buttonR03 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDBLOCKS.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 2), 62, 14, References.localNameVC("vc.item.enum.song.3"), 0);

		GuiVC.buttonR04 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDSTRAD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 0), 62, 14, References.localNameVC("vc.item.enum.song.7"), 0);
		GuiVC.buttonR05 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDCHIRP.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 1), 62, 14, References.localNameVC("vc.item.enum.song.8"), 0);
		GuiVC.buttonR06 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDFAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 2), 62, 14, References.localNameVC("vc.item.enum.song.9"), 0);
		
		//======================================
		
    	GuiVC.buttonR07 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDMELLOHI.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 3), 62, 14, References.localNameVC("vc.item.enum.song.4"), 0);
		GuiVC.buttonR08 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDCAT.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 4), 62, 14, References.localNameVC("vc.item.enum.song.5"), 0);
		GuiVC.buttonR09 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDSTAL.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 5), 62, 14, References.localNameVC("vc.item.enum.song.6"), 0);

		GuiVC.buttonR10 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDMALL.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 3), 62, 14, References.localNameVC("vc.item.enum.song.10"), 0);
		GuiVC.buttonR11 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDWAIT.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 4), 62, 14, References.localNameVC("vc.item.enum.song.11"), 0);
		GuiVC.buttonR12 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDWARD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 5), 62, 14, References.localNameVC("vc.item.enum.song.12"), 0);
		
		//======================================
		
		GuiVC.buttonR13 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDBRAMBLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 6), 62, 14, References.localNameVC("vc.item.enum.song.13"), 0);
		GuiVC.buttonR14 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDCASTLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 7), 62, 14, References.localNameVC("vc.item.enum.song.14"), 0);
		GuiVC.buttonR15 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDJUNGLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 8), 62, 14, References.localNameVC("vc.item.enum.song.15"), 0);
		
		GuiVC.buttonR16 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDDIRE.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 6), 62, 14, References.localNameVC("vc.item.enum.song.16"), 0);
		GuiVC.buttonR17 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDSTORMS.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 7), 62, 14, References.localNameVC("vc.item.enum.song.17"), 0);
		GuiVC.buttonR18 = new GuiButtonGeneral1VC(EnumsVC.AirshipSong.RECORDTIMESCAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 8), 62, 14, References.localNameVC("vc.item.enum.song.18"), 0);
    	
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.button501);
		
		this.buttonList.add(GuiVC.buttonR01);
		this.buttonList.add(GuiVC.buttonR02);
		this.buttonList.add(GuiVC.buttonR03);
		this.buttonList.add(GuiVC.buttonR04);
		this.buttonList.add(GuiVC.buttonR05);
		this.buttonList.add(GuiVC.buttonR06);
		
		this.buttonList.add(GuiVC.buttonR07);
		this.buttonList.add(GuiVC.buttonR08);
		this.buttonList.add(GuiVC.buttonR09);
		this.buttonList.add(GuiVC.buttonR10);
		this.buttonList.add(GuiVC.buttonR11);
		this.buttonList.add(GuiVC.buttonR12);
		
		this.buttonList.add(GuiVC.buttonR13);
		this.buttonList.add(GuiVC.buttonR14);
		this.buttonList.add(GuiVC.buttonR15);
		this.buttonList.add(GuiVC.buttonR16);
		this.buttonList.add(GuiVC.buttonR17);
		this.buttonList.add(GuiVC.buttonR18);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageGuiMainMenu());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiMusicPg1());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_music.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 29, this.guiTop - 17, this.guiLeft + 147, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 30, this.guiTop - 16, this.guiLeft + 146, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 32, this.guiTop - 14, this.guiLeft + 144, this.guiTop, Color.BLACK.getRGB());
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 117, this.guiTop + -9, 0);
			GlStateManager.scale(.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(EnumsVC.AirshipSong.byId(this.airship.metaJukeboxSelectedSong).getRegistryName(), 0, false, TextFormatting.GREEN), 0, 0, 255);
		}
		GlStateManager.popMatrix();
		
		GuiVC.buttonR07.visible = false;
		GuiVC.buttonR08.visible = false;
		GuiVC.buttonR09.visible = false;
		GuiVC.buttonR10.visible = false;
		GuiVC.buttonR11.visible = false;
		GuiVC.buttonR12.visible = false;
		
		GuiVC.buttonR13.visible = false;
		GuiVC.buttonR14.visible = false;
		GuiVC.buttonR15.visible = false;
		GuiVC.buttonR16.visible = false;
		GuiVC.buttonR17.visible = false;
		GuiVC.buttonR18.visible = false;
		
		if(this.airship.getModuleSelectedMusic() == 2)
		{
			GuiVC.buttonR07.visible = true;
			GuiVC.buttonR08.visible = true;
			GuiVC.buttonR09.visible = true;
			GuiVC.buttonR10.visible = true;
			GuiVC.buttonR11.visible = true;
			GuiVC.buttonR12.visible = true;
		}
		if(this.airship.getModuleSelectedMusic() == 3)
		{
			GuiVC.buttonR07.visible = true;
			GuiVC.buttonR08.visible = true;
			GuiVC.buttonR09.visible = true;
			GuiVC.buttonR10.visible = true;
			GuiVC.buttonR11.visible = true;
			GuiVC.buttonR12.visible = true;
			
			GuiVC.buttonR13.visible = true;
			GuiVC.buttonR14.visible = true;
			GuiVC.buttonR15.visible = true;
			GuiVC.buttonR16.visible = true;
			GuiVC.buttonR17.visible = true;
			GuiVC.buttonR18.visible = true;
		}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.selected") + " :", 41, -10, 11111111);
	}
}

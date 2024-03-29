package com.viesis.viescraft.client.gui.airship.music;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipAppearance;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.song.MessageHelperGuiMusicPg1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;

public class GuiAirshipMusicPg1 extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	public static int metaInfo;
	
	public GuiAirshipMusicPg1(IInventory playerInv, EntityAirshipBaseVC airshipIn)
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
    	int startPlace = 16;
    	
    	GuiVC.button501 = new GuiButton(501, this.guiLeft + 40, this.guiTop + 156, 96, 20, "Done");
    	
    	GuiVC.buttonR01 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORD11.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 0), 62, 14, "11");
		GuiVC.buttonR02 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORD13.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 1), 62, 14, "13");
    	GuiVC.buttonR03 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDBLOCKS.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 2), 62, 14, "Blocks");

		GuiVC.buttonR04 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDSTRAD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 0), 62, 14, "Strad");
		GuiVC.buttonR05 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDCHIRP.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 1), 62, 14, "Chirp");
		GuiVC.buttonR06 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDFAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 2), 62, 14, "Far");
		
		//======================================
		
    	GuiVC.buttonR07 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDMELLOHI.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 3), 62, 14, "Mellohi");
		GuiVC.buttonR08 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDCAT.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 4), 62, 14, "Cat");
		GuiVC.buttonR09 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDSTAL.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 5), 62, 14, "Stal");

		GuiVC.buttonR10 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDMALL.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 3), 62, 14, "Mall");
		GuiVC.buttonR11 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDWAIT.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 4), 62, 14, "Wait");
		GuiVC.buttonR12 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDWARD.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 5), 62, 14, "Ward");
		
		//======================================
		
		GuiVC.buttonR13 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDBRAMBLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 6), 62, 14, "Bramble");
		GuiVC.buttonR14 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDCASTLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 7), 62, 14, "Castle");
		GuiVC.buttonR15 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDJUNGLE.getMetadata(), this.guiLeft + 16, this.guiTop + startPlace + (14 * 8), 62, 14, "Jungle");
		
		GuiVC.buttonR16 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDDIRE.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 6), 62, 14, "Dire");
		GuiVC.buttonR17 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDSTORMS.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 7), 62, 14, "Storms");
		GuiVC.buttonR18 = new GuiButtonGeneralVC(EnumsVC.AirshipSong.RECORDTIMESCAR.getMetadata(), this.guiLeft + 98, this.guiTop + startPlace + (14 * 8), 62, 14, "Timescar");
    	
		
		
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
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageGuiAirshipMenuMusic());
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
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_music.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawRect(this.guiLeft + 29, this.guiTop - 17, this.guiLeft + 147, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 30, this.guiTop - 16, this.guiLeft + 146, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 32, this.guiTop - 14, this.guiLeft + 144, this.guiTop, Color.BLACK.getRGB());
		
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
		this.fontRendererObj.drawString("Selected :", 41, -10, 11111111);
		this.fontRendererObj.drawString(EnumsVC.AirshipSong.byId(this.airship.metaJukeboxSelectedSong).getName(), 93, -10, 4587264);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.thePlayer.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        
        
        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead
        || !this.mc.thePlayer.isRiding())
        {
            this.mc.thePlayer.closeScreen();
        }
    }
}

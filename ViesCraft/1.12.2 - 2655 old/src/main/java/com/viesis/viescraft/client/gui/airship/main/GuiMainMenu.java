package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMenuMain;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiPlayMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiRandomMusic;
import com.viesis.viescraft.network.server.airship.MessageGuiStopMusic;
import com.viesis.viescraft.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb1;
import com.viesis.viescraft.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb2;
import com.viesis.viescraft.network.server.airship.main.MessageHelperGuiMainMenuConsumeBomb3;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleBombActive;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleBombArmed;
import com.viesis.viescraft.network.server.song.MessageGuiMusicPg1;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMainMenu extends GuiContainerVC {
	
	public static int airshipId;
	public static int selectedSong;
	public static boolean isArmed;
	public static int storedBombType1;
	public static int storedBombType2;
	public static int storedBombType3;
	public static int bombTypeActive;
	public static int bombslotCount;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main.png");
	private final ResourceLocation TEXTURE_STORAGE_LESSER = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main_storage_lesser.png");
	private final ResourceLocation TEXTURE_STORAGE_NORMAL = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main_storage_normal.png");
	private final ResourceLocation TEXTURE_STORAGE_GREATER = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main_storage_greater.png");
	private final ResourceLocation TEXTURE_MUSIC = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main_music.png");
	private final ResourceLocation TEXTURE_BOMB = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_main_bomb.png");
	
	public GuiMainMenu(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerMenuMain(playerInv, airshipIn), playerInv, airshipIn);
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVC.buttonA01 = new GuiButtonGeneral2VC(601, this.guiLeft + 99 + (18 * 0), this.guiTop + 97 + (16 * 0), 14, 14, "", 3);
    	GuiVC.buttonA02 = new GuiButtonGeneral2VC(602, this.guiLeft + 99 + (18 * 1), this.guiTop + 97 + (16 * 0), 14, 14, "", 3);
    	GuiVC.buttonA03 = new GuiButtonGeneral2VC(603, this.guiLeft + 99 + (18 * 2), this.guiTop + 97 + (16 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonArmed = new GuiButtonGeneral2VC(600, this.guiLeft + 93, this.guiTop + 62 + (16 * 0), 14, 14, "", 0);
    	
    	GuiVC.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 44, this.guiTop + 66 + (16 * 0), 34, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	GuiVC.buttonM5 = new GuiButtonGeneral1VC(5, this.guiLeft + 49, this.guiTop + 62 , 78, 14, References.localNameVC("vc.button.choosemusic"), 0);
    	GuiVC.buttonM6 = new GuiButtonGeneral1VC(6, this.guiLeft + 35, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.play"), 0);
    	GuiVC.buttonM7 = new GuiButtonGeneral1VC(7, this.guiLeft + 71, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.stop"), 0);
    	GuiVC.buttonM8 = new GuiButtonGeneral1VC(8, this.guiLeft + 107, this.guiTop + 100, 35, 14, References.localNameVC("vc.button.random"), 0);
		
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
			this.buttonList.add(GuiVC.buttonM5);
			this.buttonList.add(GuiVC.buttonM6);
			this.buttonList.add(GuiVC.buttonM7);
			this.buttonList.add(GuiVC.buttonM8);
		}
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			this.buttonList.add(GuiVC.buttonArmed);
			this.buttonList.add(GuiVC.buttonA01);
			this.buttonList.add(GuiVC.buttonA02);
			this.buttonList.add(GuiVC.buttonA03);
			this.buttonList.add(GuiVC.button501);
		}
		
		GuiVC.buttonMM1.enabled = false;
    }
    
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
			this.airshipId = this.airship.getEntityId();
			NetworkHandler.sendToServer(new MessageGuiStopMusic());
	    }
		if (parButton.id == 8)
	    {
			if(this.airship.selectedModuleMusic == 1)
			{
				this.selectedSong = References.random.nextInt(6) + 1;
			}
			if(this.airship.selectedModuleMusic == 2)
			{
				this.selectedSong = References.random.nextInt(12) + 1;
			}
			if(this.airship.selectedModuleMusic == 3)
			{
				this.selectedSong = References.random.nextInt(18) + 1;
			}
			
			airshipId = this.airship.getEntityId();
			NetworkHandler.sendToServer(new MessageGuiRandomMusic());
	    }
		
		if (parButton.id == 600)
	    {
			this.isArmed = !this.airship.bombArmedToggle;
			NetworkHandler.sendToServer(new MessageHelperGuiModuleBombArmed());
	    }
		if (parButton.id == 601)
	    {
			this.bombTypeActive = 1;
			NetworkHandler.sendToServer(new MessageHelperGuiModuleBombActive());
	    }
		if (parButton.id == 602)
	    {
			this.bombTypeActive = 2;
			NetworkHandler.sendToServer(new MessageHelperGuiModuleBombActive());
	    }
		if (parButton.id == 603)
	    {
			this.bombTypeActive = 3;
			NetworkHandler.sendToServer(new MessageHelperGuiModuleBombActive());
	    }
		
		//Comsume
		if (parButton.id == 501)
	    {
			ItemStack bombslot = this.airship.inventory.getStackInSlot(51);
			
			if(!bombslot.isEmpty())
			{
				bombslotCount = bombslot.getCount();
				
				//Small
				if(bombslot.getMetadata() == 1)
				{
					if(this.airship.storedBombType1 == 64)
					{
						
					}
					else if(64 >= (bombslotCount + this.airship.storedBombType1))
					{
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb1());
					}
					else if(64 < (bombslotCount + this.airship.storedBombType1))
					{
						bombslotCount = 64 - this.airship.storedBombType1;
						
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb1());
					}
				}
				//Big
				if(bombslot.getMetadata() == 2)
				{
					if(this.airship.storedBombType2 == 16)
					{
						
					}
					else if(16 >= (bombslotCount + this.airship.storedBombType2))
					{
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb2());
					}
					else if(16 < (bombslotCount + this.airship.storedBombType2))
					{
						bombslotCount = 16 - this.airship.storedBombType2;
						
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb2());
					}
				}
				//Scatter
				if(bombslot.getMetadata() == 3)
				{
					if(this.airship.storedBombType2 == 8)
					{
						
					}
					else if(8 >= (bombslotCount + this.airship.storedBombType3))
					{
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb3());
					}
					else if(8 < (bombslotCount + this.airship.storedBombType3))
					{
						bombslotCount = 8 - this.airship.storedBombType3;
						
						NetworkHandler.sendToServer(new MessageHelperGuiMainMenuConsumeBomb3());
					}
				}
			}
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
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_STORAGE_LESSER);
		}
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_STORAGE_NORMAL);
		}
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_STORAGE_GREATER);
		}
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_MUSIC);
		}
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_BOMB);
		}
		
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			//Draws the inventory slots for bomb modules.
			//if(this.airship.selectedModuleBomb == 2)
			//{
			//	this.drawTexturedModalRect(this.guiLeft + 88, this.guiTop + 88, 97, 88, 18, 18);
			//	this.drawTexturedModalRect(this.guiLeft + 88 + (18 * 1), this.guiTop + 88, 97, 88, 18, 18);
			//}
			//else if(this.airship.selectedModuleBomb == 3)
			//{
			//	this.drawTexturedModalRect(this.guiLeft + 79 + (18 * 0), this.guiTop + 88, 97, 88, 18, 18);
			//	this.drawTexturedModalRect(this.guiLeft + 79 + (18 * 1), this.guiTop + 88, 97, 88, 18, 18);
			//	this.drawTexturedModalRect(this.guiLeft + 79 + (18 * 2), this.guiTop + 88, 97, 88, 18, 18);
			//}
			
			if(this.airship.bombArmedToggle)
			{
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(this.guiLeft + 108, this.guiTop + 62, 0);
					GlStateManager.scale(0.5F, 0.5F, 0.5F);
					this.drawTexturedModalRect(0, 0, 195, 0, 28, 28);
				}
				GlStateManager.popMatrix();
			}
			
			if(this.airship.bombTypeActive == 1)
			{
				GuiVC.buttonA01.enabled = false;
				GuiVC.buttonA02.enabled = true;
				GuiVC.buttonA03.enabled = true;
			}
			else if(this.airship.bombTypeActive == 2)
			{
				GuiVC.buttonA01.enabled = true;
				GuiVC.buttonA02.enabled = false;
				GuiVC.buttonA03.enabled = true;
			}
			else if(this.airship.bombTypeActive == 3)
			{
				GuiVC.buttonA01.enabled = true;
				GuiVC.buttonA02.enabled = true;
				GuiVC.buttonA03.enabled = false;
			}
			else
			{
				GuiVC.buttonA01.enabled = true;
				GuiVC.buttonA02.enabled = true;
				GuiVC.buttonA03.enabled = true;
			}
			
			ItemStack bombslot = this.airship.inventory.getStackInSlot(51);
			
			if(!bombslot.isEmpty())
			{
				GuiVC.button501.enabled = true;
				
				if(this.airship.storedBombType1 >= 64
				&& this.airship.storedBombType1 >= 16
				&& this.airship.storedBombType1 >= 8)
				{
					GuiVC.button501.enabled = false;
				}
				if(bombslot.getMetadata() == 1)
				{
					if(this.airship.storedBombType1 >= 64)
					{
						GuiVC.button501.enabled = false;
					}
					else
					{
						GuiVC.button501.enabled = true;
					}
				}
				if(bombslot.getMetadata() == 2)
				{
					if(this.airship.storedBombType2 >= 16)
					{
						GuiVC.button501.enabled = false;
					}
					else
					{
						GuiVC.button501.enabled = true;
					}
				}
				if(bombslot.getMetadata() == 3)
				{
					if(this.airship.storedBombType3 >= 8)
					{
						GuiVC.button501.enabled = false;
					}
					else
					{
						GuiVC.button501.enabled = true;
					}
				}
			}
			else
			{
				GuiVC.button501.enabled = false;
			}
		}
		
		//Draw "on" indicators
		if (this.airship.getStoredFuel() > 0)
        {
			int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 9, 176, 19, 8, 1 + k);
            //left bulb
            this.drawTexturedModalRect(this.guiLeft + 140, this.guiTop + 34, 176, 0, 9, 19);
            //right bulb
            this.drawTexturedModalRect(this.guiLeft + 161, this.guiTop + 34, 176 + 9, 0, 9, 19);
		}
		
		//Draw a green fuel bar and magma in the coal slot
		if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			this.drawTexturedModalRect(this.guiLeft + 131, this.guiTop + 9, 184, 19, 8, 1 + 47);
			this.drawTexturedModalRect(this.guiLeft + 147, this.guiTop + 22, 177, 67, 17, 17);
		}
		
		//Logic for mouse-over Module Slot1 tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 0) && mouseX <= this.guiLeft + 28 + (24 * 0)
		&& mouseY >= this.guiTop + 7 && mouseY <= this.guiTop + 30)
		{
			this.drawTexturedModalRect(this.guiLeft + 6 + (24 * 0), this.guiTop + 5, 177, 83, 24, 28);
		}
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 0) && mouseX <= this.guiLeft + 28 + (24 * 0)
		&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			this.drawTexturedModalRect(this.guiLeft + 6 + (24 * 0), this.guiTop + 31, 177, 83, 24, 28);
		}
		//Logic for mouse-over Frame tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 1) && mouseX <= this.guiLeft + 28 + (24 * 1)
		&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			this.drawTexturedModalRect(this.guiLeft + 6 + (24 * 1), this.guiTop + 31, 177, 83, 24, 28);
		}
		//Logic for mouse-over Engine tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 2) && mouseX <= this.guiLeft + 28 + (24 * 2)
		&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			this.drawTexturedModalRect(this.guiLeft + 6 + (24 * 2), this.guiTop + 31, 177, 83, 24, 28);
		}
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 3) && mouseX <= this.guiLeft + 28 + (24 * 3)
		&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			this.drawTexturedModalRect(this.guiLeft + 6 + (24 * 3), this.guiTop + 31, 177, 83, 24, 28);
		}
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 55, this.guiTop - 17, this.guiLeft + 127-6, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 56, this.guiTop - 16, this.guiLeft + 126-6, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 58, this.guiTop - 14, this.guiLeft + 124-6, this.guiTop, Color.BLACK.getRGB());
		
		//Draws a gray box over the red X if there is an item in the slot
		if(this.airship.getMainTierCore() > 0)
		{
			this.drawRect(this.guiLeft + 13 + (24 * 0), this.guiTop + 43, this.guiLeft + 23 + (24 * 0), this.guiTop + 53, Color.GRAY.getRGB());
		}
		if(this.airship.getMainTierFrame() > 0)
		{
			this.drawRect(this.guiLeft + 13 + (24 * 1), this.guiTop + 43, this.guiLeft + 23 + (24 * 1), this.guiTop + 53, Color.GRAY.getRGB());
		}
		if(this.airship.getMainTierEngine() > 0)
		{
			this.drawRect(this.guiLeft + 13 + (24 * 2), this.guiTop + 43, this.guiLeft + 23 + (24 * 2), this.guiTop + 53, Color.GRAY.getRGB());
		}
		if(this.airship.getMainTierBalloon() > 0)
		{
			this.drawRect(this.guiLeft + 13 + (24 * 3), this.guiTop + 43, this.guiLeft + 23 + (24 * 3), this.guiTop + 53, Color.GRAY.getRGB());
		}
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
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
	
	/**
	 * Calculates the % bar
	 */
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(1);
        
        if (i == 0)
        {
        	i = this.airship.fuelItemStack + 1;
        }
        
        return this.airship.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			this.mc.getTextureManager().bindTexture(TEXTURE_BOMB);
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(96.5, 65.5, 0);
				GlStateManager.scale(0.25F, 0.25F, 0.25F);
				this.drawTexturedModalRect(0, 0, 195, 0, 28, 28);
			}
			GlStateManager.popMatrix();
		}
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.mainmenu"), 64, -10, Color.CYAN.getRGB());
		
		//Main Fuel
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(155, 10.5, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.fuel"), 0, false, TextFormatting.GOLD), 0, 0, Color.ORANGE.getRGB());
		}
		GlStateManager.popMatrix();
		
		//Redstone
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(59, 9.5 + (5 * 0), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.redstone") + ":", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(92.5, 9.5 + (5 * 0), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String storedIn = TextFormatting.GREEN + "" + String.valueOf((int)(EnumsVC.MainTierCore.byId(this.airship.mainTierCore).getStoredRedstone()));
			
			if(this.airship.mainTierCore == 0)
			{
				storedIn = TextFormatting.BLACK + "-" + TextFormatting.GREEN + "" + String.valueOf((int)(EnumsVC.MainTierCore.byId(this.airship.mainTierCore).getStoredRedstone()));
			}
			
			this.drawCenteredString(fontRenderer, storedIn, 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		//Speed
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(67.75, 9.5 + (5 * 1), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.speed") + ":", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(92.5, 9.5 + (5 * 1), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String speedIn = TextFormatting.BLACK + "-" + TextFormatting.GREEN + "+" + String.valueOf((int)(EnumsVC.MainTierFrame.byId(this.airship.mainTierFrame).getSpeedModifier() *100));
			
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.RED + "+" + String.valueOf((int)(EnumsVC.MainTierFrame.byId(this.airship.mainTierFrame).getSpeedModifier() *100));
				
			}
				
				
				
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.MainTierFrame.byId(this.airship.mainTierFrame).getSpeedModifier() *100)  + 1);
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.MainTierFrame.byId(this.airship.mainTierFrame).getSpeedModifier() *100)  + 2);
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
			{
				speedIn = TextFormatting.BLACK + "-" + TextFormatting.AQUA + "+" + String.valueOf((int)(EnumsVC.MainTierFrame.byId(this.airship.mainTierFrame).getSpeedModifier() *100)  + 3);
			}
			
			this.drawCenteredString(fontRenderer, speedIn, 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		//Fuel
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(72.65, 9.5 + (5 * 2), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.fuel") + ":", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(92.5, 9.5 + (5 * 2), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String fuelIn = TextFormatting.RED + "-" + String.valueOf(this.airship.getAirshipFuelTick());
			
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
			{
				fuelIn = TextFormatting.GOLD + "-" + String.valueOf(this.airship.getAirshipFuelTick());
				
				if(this.airship.getMainTierEngine() == 5)
				{
					fuelIn = TextFormatting.BLACK + "-" + TextFormatting.GOLD + "-" + String.valueOf(this.airship.getAirshipFuelTick());
				}
			}
			else if (this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
					|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
					|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				fuelIn = TextFormatting.AQUA + "---";
			}
			
			this.drawCenteredString(fontRenderer, fuelIn, 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		//Altitude
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(63.95, 9.5 + (5 * 3), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.altitude") + ":", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(92.5, 9.5 + (5 * 3), 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			String altitudeIn = TextFormatting.GREEN + String.valueOf((int)EnumsVC.MainTierBalloon.byId(this.airship.mainTierBalloon).getMaxAltitude());
			
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
			{
				altitudeIn = TextFormatting.AQUA + "225";
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
			{
				altitudeIn = TextFormatting.AQUA + "250";
			}
			else if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
			{
				altitudeIn = TextFormatting.AQUA + "\u221e";
			}
			else if(this.airship.getMainTierBalloon() == 0)
			{
				altitudeIn = TextFormatting.BLACK + "-" + TextFormatting.GREEN + String.valueOf((int)EnumsVC.MainTierBalloon.byId(this.airship.mainTierBalloon).getMaxAltitude());
			}
			
			this.drawCenteredString(fontRenderer, altitudeIn, 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		
		
		//Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(19.5-8, 31.5+3, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.core"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(12 + (24 * 0), 42, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMainTierCore() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_CORE
						, 1, this.airship.getMainTierCore()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Frame
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(41-7, 31.5+3, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.frame"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(12 + (24 * 1), 42, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMainTierFrame() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_FRAME, 1, this.airship.getMainTierFrame()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		
		//Engine
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(63.5-6, 31.5+3, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.engine"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(12 + (24 * 2), 42, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMainTierEngine() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_ENGINE, 1, this.airship.getMainTierEngine()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Balloon
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(85.5-5, 31.5+3, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.balloon"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(12 + (24 * 3), 42, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			if(this.airship.getMainTierBalloon() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.UPGRADE_BALLOON, 1, this.airship.getMainTierBalloon()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//Module Slot 1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(10.5, 8.75, 0);
			GlStateManager.scale(0.55, 0.55, 0.55);
			
			this.fontRenderer.drawString(References.localNameVC("vc.main.slot1"), 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(10, 14, 0);
			GlStateManager.scale(1, 1, 1);
			
			if(this.airship.getModuleActiveSlot1() > 0)
			{
				this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, this.airship.getModuleActiveSlot1()), 0, 0, "");
			}
		}
		GlStateManager.popMatrix();
		
		//TODO
		
		if(this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
		|| this.airship.moduleActiveSlot1 == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
		{
			
			
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(106 + (18 * 0), 92, 0);
				GlStateManager.scale(0.350, 0.350, 0.350);
				
				this.drawCenteredString(fontRenderer, "Small", 0, 0, Color.WHITE.getRGB());
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(106 + (18 * 1), 92, 0);
				GlStateManager.scale(0.350, 0.350, 0.350);
				
				this.drawCenteredString(fontRenderer, "Big", 0, 0, Color.WHITE.getRGB());
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(106 + (18 * 2), 92, 0);
				GlStateManager.scale(0.350, 0.350, 0.350);
				
				this.drawCenteredString(fontRenderer, "Scatter", 0, 0, Color.WHITE.getRGB());
			}
			GlStateManager.popMatrix();
			
			//Small Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(102 + (18 * 0), 100, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				this.drawItemStack(new ItemStack(InitItemsVC.ITEM_DISPLAY_SYMBOL, 1, 0), 0, 0, "");
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 1), 0, 0, "");
			}
			GlStateManager.popMatrix();
			//Big Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(102 + (18 * 1), 100, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				this.drawItemStack(new ItemStack(InitItemsVC.ITEM_DISPLAY_SYMBOL, 1, 0), 0, 0, "");
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 2), 0, 0, "");
			}
			GlStateManager.popMatrix();
			//Scatter Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(102 + (18 * 2), 100, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				this.drawItemStack(new ItemStack(InitItemsVC.ITEM_DISPLAY_SYMBOL, 1, 0), 0, 0, "");
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 3), 0, 0, "");
			}
			GlStateManager.popMatrix();
			
			//Small Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(9.75, 64 + (18 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 1), 0, 0, "");
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(25, 67 + (18 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString("=", 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(31, 67 + (18 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString(Integer.toString(this.airship.storedBombType1), 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			
			//Big Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(10.25, 64 + (18 * 1), 0);
				GlStateManager.scale(0.7, 0.7, 0.7);
				
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 2), 0, 0, "");
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(25, 67 + (18 * 1), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString("=", 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(31, 67 + (18 * 1), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString(Integer.toString(this.airship.storedBombType2), 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			
			//Scatter Bomb
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(10.25, 64 + (18 * 2), 0);
				GlStateManager.scale(0.7, 0.7, 0.7);
				
				this.drawItemStack(new ItemStack(InitItemsVC.BOMB, 1, 3), 0, 0, "");
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(25, 67 + (18 * 2), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString("=", 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(33, 67 + (18 * 2), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				this.fontRenderer.drawString(Integer.toString(this.airship.storedBombType3), 0, 0, Color.WHITE.getRGB(), false);
			}
			GlStateManager.popMatrix();
			
			if(this.airship.bombArmedToggle)
			{
				this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.armed"), 0, false, TextFormatting.DARK_RED), 139, 65, Color.WHITE.getRGB());
			}
			else
			{
				this.drawCenteredString(fontRenderer, References.localNameVC("vc.main.unarmed"), 131, 65, Color.GREEN.getRGB());
			}
		}
		
		
		
		//Logic for mouse-over Main Fuel tooltip
		if(mouseX >= this.guiLeft + 146 && mouseX <= this.guiLeft + 163
		&& mouseY >= this.guiTop + 21 && mouseY <= this.guiTop + 38
		&& this.airship.inventory.getStackInSlot(0).isEmpty())
		{
			if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			|| this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
			{
				
			}
			else 
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("vc.gui.tt.fuel.1"));
				text.add(TextFormatting.YELLOW + References.localNameVC("vc.gui.tt.fuel.2"));
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 20, mouseY - this.guiTop - 13, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Module Slot1 tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 0) && mouseX <= this.guiLeft + 28 + (24 * 0)
		&& mouseY >= this.guiTop + 7 && mouseY <= this.guiTop + 30)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.module1.1") + ":");
				text.add(TextFormatting.LIGHT_PURPLE + "");
				
				if(this.airship.getModuleActiveSlot1() == 0)
				{
					text.add(TextFormatting.GOLD + "- " + TextFormatting.WHITE + References.localNameVC("vc.main.none"));
				}
				else
				{
					text.add(TextFormatting.GOLD + "- " + TextFormatting.GREEN + EnumsVC.ModuleType.byId(this.airship.getModuleActiveSlot1()).getLocalizedName());
				}
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 32, mouseY - this.guiTop - 18, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 0) && mouseX <= this.guiLeft + 28 + (24 * 0)
		&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + EnumsVC.MainTierCore.byId(this.airship.mainTierCore).getStoredRedstone());
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Frame tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 1) && mouseX <= this.guiLeft + 28 + (24 * 1)
				&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.frame.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + "+" + this.airship.mainTierFrame);
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Engine tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 2) && mouseX <= this.guiLeft + 28 + (24 * 2)
				&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.engine.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.RED + "-" + (EnumsVC.MainTierEngine.byId(this.airship.mainTierEngine).getFuelPerTick()));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= this.guiLeft + 7 + (24 * 3) && mouseX <= this.guiLeft + 28 + (24 * 3)
				&& mouseY >= this.guiTop + 33 && mouseY <= this.guiTop + 57)
		{
			List<String> text = new ArrayList<String>();
			
			if(this.isShiftKeyDown())
			{
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.1"));
				text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.balloon.2"));
				text.add(TextFormatting.LIGHT_PURPLE + "");
				text.add(TextFormatting.WHITE + References.localNameVC("vc.gui.tt.basebonus") + ": " + TextFormatting.GREEN + (EnumsVC.MainTierBalloon.byId(this.airship.mainTierBalloon).getMaxAltitude()));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 23, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				text.add(TextFormatting.WHITE + References.localNameVC("vc.item.tt.shifthelper.0"));
				
				FontRenderer fontrenderer = this.getFontRenderer();
				
				GlStateManager.pushMatrix();
				{
					GlStateManager.translate(mouseX - this.guiLeft - 35, mouseY - this.guiTop - 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
	}
}

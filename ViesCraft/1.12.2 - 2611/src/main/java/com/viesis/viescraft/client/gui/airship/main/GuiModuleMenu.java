package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonConfirmVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.client.gui.GuiButtonModuleToggleVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerAirshipModule;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiModuleMenu extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	public static int learnModule;
	public static int toggleModule;
	
	// 0 = Gray	/ 1 = Green / 2 = Red
	private static int buttonAltitude;
	private static int buttonSpeed;
	private static int buttonStorage;
	private static int buttonFuel;
	private static int buttonMusic;
	private static int buttonCruise;
	private static int buttonWater;
	private static int buttonInfiniteFuel;
	
	public GuiModuleMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerAirshipModule(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
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
    	
    	this.buttonColor();
        
    	GuiVC.buttonM1 = new GuiButtonMenuVC(101, this.guiLeft - 32, this.guiTop + 10, 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(102, this.guiLeft - 32, this.guiTop + 24, 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(103, this.guiLeft - 32, this.guiTop + 38, 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(104, this.guiLeft - 32, this.guiTop + 52, 36, 14, "", 3);
    	
    	GuiVC.buttonModuleAltitudeLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonAltitude);
    	GuiVC.buttonModuleAltitudeNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonAltitude);
    	GuiVC.buttonModuleAltitudeGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonAltitude);
    	
    	GuiVC.buttonModuleSpeedLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.SPEED_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonSpeed);
    	GuiVC.buttonModuleSpeedNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.SPEED_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonSpeed);
    	GuiVC.buttonModuleSpeedGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.SPEED_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonSpeed);
    	
    	GuiVC.buttonModuleStorageLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.STORAGE_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonStorage);
    	GuiVC.buttonModuleStorageNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonStorage);
    	GuiVC.buttonModuleStorageGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.STORAGE_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonStorage);
    	
    	GuiVC.buttonModuleFuelLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.FUEL_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 3), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonFuel);
    	GuiVC.buttonModuleFuelNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.FUEL_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 3), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonFuel);
    	GuiVC.buttonModuleFuelGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.FUEL_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 3), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonFuel);
    	
    	GuiVC.buttonModuleMusicLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.MUSIC_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 4), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonMusic);
    	GuiVC.buttonModuleMusicNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 4), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonMusic);
    	GuiVC.buttonModuleMusicGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.MUSIC_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 4), this.guiTop + 16 + (19 * 0), 14, 14, "", this.buttonMusic);
    	
    	GuiVC.buttonModuleCruiseLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.CRUISE_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonCruise);
    	GuiVC.buttonModuleCruiseNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonCruise);
    	GuiVC.buttonModuleCruiseGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.CRUISE_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 0), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonCruise);
    	
    	GuiVC.buttonModuleWaterLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.WATER_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonWater);
    	GuiVC.buttonModuleWaterNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.WATER_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonWater);
    	GuiVC.buttonModuleWaterGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.WATER_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 1), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonWater);
    	
    	GuiVC.buttonModuleInfiniteFuelLesser = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonInfiniteFuel);
    	GuiVC.buttonModuleInfiniteFuelNormal = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonInfiniteFuel);
    	GuiVC.buttonModuleInfiniteFuelGreater = new GuiButtonModuleToggleVC(EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata(), this.guiLeft + 28 + (26 * 2), this.guiTop + 16 + (19 * 1), 14, 14, "", this.buttonInfiniteFuel);
    	
    	GuiVC.buttonModuleLearn = new GuiButtonConfirmVC(100, this.guiLeft + 116, this.guiTop + 89, 36, 14, References.localNameVC("vc.button.learn"));
		
    	
    	
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
		
		this.buttonList.add(GuiVC.buttonModuleAltitudeLesser);
		this.buttonList.add(GuiVC.buttonModuleAltitudeNormal);
		this.buttonList.add(GuiVC.buttonModuleAltitudeGreater);
		this.buttonList.add(GuiVC.buttonModuleSpeedLesser);
		this.buttonList.add(GuiVC.buttonModuleSpeedNormal);
		this.buttonList.add(GuiVC.buttonModuleSpeedGreater);
		this.buttonList.add(GuiVC.buttonModuleStorageLesser);
		this.buttonList.add(GuiVC.buttonModuleStorageNormal);
		this.buttonList.add(GuiVC.buttonModuleStorageGreater);
		this.buttonList.add(GuiVC.buttonModuleFuelLesser);
		this.buttonList.add(GuiVC.buttonModuleFuelNormal);
		this.buttonList.add(GuiVC.buttonModuleFuelGreater);
		this.buttonList.add(GuiVC.buttonModuleMusicLesser);
		this.buttonList.add(GuiVC.buttonModuleMusicNormal);
		this.buttonList.add(GuiVC.buttonModuleMusicGreater);
		this.buttonList.add(GuiVC.buttonModuleCruiseLesser);
		this.buttonList.add(GuiVC.buttonModuleCruiseNormal);
		this.buttonList.add(GuiVC.buttonModuleCruiseGreater);
		this.buttonList.add(GuiVC.buttonModuleWaterLesser);
		this.buttonList.add(GuiVC.buttonModuleWaterNormal);
		this.buttonList.add(GuiVC.buttonModuleWaterGreater);
		this.buttonList.add(GuiVC.buttonModuleInfiniteFuelLesser);
		this.buttonList.add(GuiVC.buttonModuleInfiniteFuelNormal);
		this.buttonList.add(GuiVC.buttonModuleInfiniteFuelGreater);
		
		this.buttonList.add(GuiVC.buttonModuleLearn);
		
		
		
		GuiVC.buttonModuleAltitudeLesser.visible = false;
		GuiVC.buttonModuleAltitudeNormal.visible = false;
		GuiVC.buttonModuleAltitudeGreater.visible = false;
		GuiVC.buttonModuleSpeedLesser.visible = false;
		GuiVC.buttonModuleSpeedNormal.visible = false;
		GuiVC.buttonModuleSpeedGreater.visible = false;
		GuiVC.buttonModuleStorageLesser.visible = false;
		GuiVC.buttonModuleStorageNormal.visible = false;
		GuiVC.buttonModuleStorageGreater.visible = false;
		GuiVC.buttonModuleFuelLesser.visible = false;
		GuiVC.buttonModuleFuelNormal.visible = false;
		GuiVC.buttonModuleFuelGreater.visible = false;
		GuiVC.buttonModuleMusicLesser.visible = false;
		GuiVC.buttonModuleMusicNormal.visible = false;
		GuiVC.buttonModuleMusicGreater.visible = false;
		GuiVC.buttonModuleCruiseLesser.visible = false;
		GuiVC.buttonModuleCruiseNormal.visible = false;
		GuiVC.buttonModuleCruiseGreater.visible = false;
		GuiVC.buttonModuleWaterLesser.visible = false;
		GuiVC.buttonModuleWaterNormal.visible = false;
		GuiVC.buttonModuleWaterGreater.visible = false;
		GuiVC.buttonModuleInfiniteFuelLesser.visible = false;
		GuiVC.buttonModuleInfiniteFuelNormal.visible = false;
		GuiVC.buttonModuleInfiniteFuelGreater.visible = false;
		
		
		
		GuiVC.buttonM4.enabled = false;
    }
	
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 101)
	    {
			//Lesser Storage
        	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageLesser());
        	}
        	//Normal Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageNormal());
        	}
        	//Greater Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageGreater());
        	}
        	//Any Music
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuMusic());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenu());
        	}
	    }
		if (parButton.id == 102)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 103)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenu());
	    }
		if (parButton.id == 104)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
		
		
		if (parButton.id <= 75)
	    {
			if(this.toggleModule == parButton.id)
			{
				this.toggleModule = 0;
				//this.allButtonsRed();
				this.airship.setModuleVariantSlot1(0);
			}
			else
			{
				this.toggleModule = parButton.id;
				this.airship.setModuleVariantSlot1(parButton.id);
			}
			
			NetworkHandler.sendToServer(new MessageHelperGuiModuleToggleSlot1());
	    }
		
		
		
		if (parButton.id == 100)
	    {
			if(!this.airship.inventory.getStackInSlot(11).isEmpty())
			{
				if(this.airship.inventory.getStackInSlot(11).getItem() == InitItemsVC.MODULE_CREATIVE)
				{
					this.learnModule = 50;
				}
				else
				{
					this.learnModule = this.airship.inventory.getStackInSlot(11).getMetadata();
				}
				
				NetworkHandler.sendToServer(new MessageHelperGuiModuleLearn());
				this.airship.metaModuleVariantSlot1 = 0;
				this.airship.inventory.extractItem(11, 1, false);
			}
	    }
		
		this.buttonColor();
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_module.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//On indicator if any Module is in learn slot
		if(!this.airship.inventory.getStackInSlot(11).isEmpty())
		{
			//Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 96, this.guiTop + 87, 176, 0, 48, 48);
		}
		
		//If any Module installed
		if(this.airship.getModuleVariantSlot1() > 0)
		{
			String nameIn = EnumsVC.ModuleType.byId(this.airship.getModuleVariantSlot1()).getLocalizedName();
			
			//Module name
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 53.25, this.guiTop + 82, 0);
				GlStateManager.scale(0.44, 0.44, 0.44);
				
				this.drawCenteredString(fontRenderer, TextFormatting.LIGHT_PURPLE + "" + TextFormatting.UNDERLINE + "" + TextFormatting.BOLD + nameIn, 0, 0, 0);
			}
			GlStateManager.popMatrix();
			
			//Pros1
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 53.25, this.guiTop + 90, 0);
				GlStateManager.scale(0.38, 0.38, 0.38);
				
				this.drawCenteredString(fontRenderer, TextFormatting.GREEN + References.localNameVC("vc.item.tt.moduletype.#." + this.airship.getModuleVariantSlot1() + ".pros1"), 0, 0, 0);
			}
			GlStateManager.popMatrix();
			//Pros2
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 53.25, this.guiTop + 95, 0);
				GlStateManager.scale(0.38, 0.38, 0.38);
				
				this.drawCenteredString(fontRenderer, TextFormatting.GREEN + References.localNameVC("vc.item.tt.moduletype.#." + this.airship.getModuleVariantSlot1() + ".pros2"), 0, 0, 0);
			}
			GlStateManager.popMatrix();
			
			//Cons1
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 53.25, this.guiTop + 102, 0);
				GlStateManager.scale(0.38, 0.38, 0.38);
				
				this.drawCenteredString(fontRenderer, TextFormatting.RED + References.localNameVC("vc.item.tt.moduletype.#." + this.airship.getModuleVariantSlot1() + ".cons1"), 0, 0, 0);
			}
			GlStateManager.popMatrix();
			//Cons2
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 53.25, this.guiTop + 107, 0);
				GlStateManager.scale(0.38, 0.38, 0.38);
				
				this.drawCenteredString(fontRenderer, TextFormatting.RED + References.localNameVC("vc.item.tt.moduletype.#." + this.airship.getModuleVariantSlot1() + ".cons2"), 0, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		this.drawRect(this.guiLeft + 49-1, this.guiTop - 17, this.guiLeft + 127+1, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-1, this.guiTop - 16, this.guiLeft + 126+1, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-1, this.guiTop - 14, this.guiLeft + 124+1, this.guiTop, Color.BLACK.getRGB());
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRenderer.drawString(References.localNameVC("vc.main.modulemenu"), 58, -10, Color.CYAN.getRGB());
		
		//Altitude Icons
		if(this.airship.getModuleLearnedAltitude())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 0), 17 + (19 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedAltitude() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedAltitude() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedAltitude() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Speed Icons
		if(this.airship.getModuleLearnedSpeed())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 1), 17 + (19 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedSpeed() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.SPEED_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedSpeed() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.SPEED_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedSpeed() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.SPEED_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Storage Icons
		if(this.airship.getModuleLearnedStorage())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 2), 17 + (19 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedStorage() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedStorage() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedStorage() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Fuel Icons
		if(this.airship.getModuleLearnedFuel())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 3), 17 + (19 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedFuel() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.FUEL_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuel() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuel() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.FUEL_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Music Icons
		if(this.airship.getModuleLearnedMusic())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 4), 17 + (19 * 0), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedMusic() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedMusic() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedMusic() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.MUSIC_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Cruise Icons
		if(this.airship.getModuleLearnedCruise())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 0), 17 + (19 * 1), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedCruise() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedCruise() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedCruise() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.CRUISE_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Water Icons
		if(this.airship.getModuleLearnedWater())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 1), 17 + (19 * 1), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedWater() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.WATER_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedWater() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.WATER_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedWater() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.WATER_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Infinite Fuel Icons
		if(this.airship.getModuleLearnedFuelInfinite())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(29 + (26 * 2), 17 + (19 * 1), 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				
				if(this.airship.getModuleSelectedFuelInfinite() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuelInfinite() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedFuelInfinite() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
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
        
        //Module Restrictions
		if(!this.airship.inventory.getStackInSlot(11).isEmpty())
		{
			//Altitude
			if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedAltitude() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Speed
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata()
			&& this.airship.getModuleSelectedSpeed() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Storage
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedStorage() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Fuel
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata()
			&& this.airship.getModuleSelectedFuel() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Music
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata()
			&& this.airship.getModuleSelectedMusic() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Cruise
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata()
			&& this.airship.getModuleSelectedCruise() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Water
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.WATER_LESSER.getMetadata()
			&& this.airship.getModuleSelectedWater() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedWater() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.WATER_GREATER.getMetadata()
			&& this.airship.getModuleSelectedWater() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//Infinite Fuel
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata()
			&& this.airship.getModuleSelectedFuelInfinite() != 2)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			//On status
			else
	        {
	        	GuiVC.buttonModuleLearn.enabled = true;
	        }
		}
        else
        {
        	GuiVC.buttonModuleLearn.enabled = false;
        }
        
		
		GuiVC.buttonModuleAltitudeLesser.visible = false;
		GuiVC.buttonModuleAltitudeNormal.visible = false;
		GuiVC.buttonModuleAltitudeGreater.visible = false;
		GuiVC.buttonModuleSpeedLesser.visible = false;
		GuiVC.buttonModuleSpeedNormal.visible = false;
		GuiVC.buttonModuleSpeedGreater.visible = false;
		GuiVC.buttonModuleStorageLesser.visible = false;
		GuiVC.buttonModuleStorageNormal.visible = false;
		GuiVC.buttonModuleStorageGreater.visible = false;
		GuiVC.buttonModuleFuelLesser.visible = false;
		GuiVC.buttonModuleFuelNormal.visible = false;
		GuiVC.buttonModuleFuelGreater.visible = false;
		GuiVC.buttonModuleMusicLesser.visible = false;
		GuiVC.buttonModuleMusicNormal.visible = false;
		GuiVC.buttonModuleMusicGreater.visible = false;
		GuiVC.buttonModuleCruiseLesser.visible = false;
		GuiVC.buttonModuleCruiseNormal.visible = false;
		GuiVC.buttonModuleCruiseGreater.visible = false;
		GuiVC.buttonModuleWaterLesser.visible = false;
		GuiVC.buttonModuleWaterNormal.visible = false;
		GuiVC.buttonModuleWaterGreater.visible = false;
		GuiVC.buttonModuleInfiniteFuelLesser.visible = false;
		GuiVC.buttonModuleInfiniteFuelNormal.visible = false;
		GuiVC.buttonModuleInfiniteFuelGreater.visible = false;
		
		
		//What Altitude button is enabled
		if(this.airship.getModuleLearnedAltitude())
		{
			if(this.airship.getModuleSelectedAltitude() == 1)
			{
				GuiVC.buttonModuleAltitudeLesser.enabled = true;
				GuiVC.buttonModuleAltitudeLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedAltitude() == 2)
			{
				GuiVC.buttonModuleAltitudeNormal.enabled = true;
				GuiVC.buttonModuleAltitudeNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedAltitude() == 3)
			{
				GuiVC.buttonModuleAltitudeGreater.enabled = true;
				GuiVC.buttonModuleAltitudeGreater.visible = true;
			}
		}
		else
		{
			GuiVC.buttonModuleAltitudeLesser.enabled = false;
	    	GuiVC.buttonModuleAltitudeNormal.enabled = false;
	    	GuiVC.buttonModuleAltitudeGreater.enabled = false;
		}
		
		//What Speed button is enabled
		if(this.airship.getModuleLearnedSpeed())
		{
			if(this.airship.getModuleSelectedSpeed() == 1)
			{
				GuiVC.buttonModuleSpeedLesser.enabled = true;
				GuiVC.buttonModuleSpeedLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedSpeed() == 2)
			{
				GuiVC.buttonModuleSpeedNormal.enabled = true;
				GuiVC.buttonModuleSpeedNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedSpeed() == 3)
			{
				GuiVC.buttonModuleSpeedGreater.enabled = true;
				GuiVC.buttonModuleSpeedGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleSpeedLesser.enabled = false;
        	GuiVC.buttonModuleSpeedNormal.enabled = false;
        	GuiVC.buttonModuleSpeedGreater.enabled = false;
        }
		
		//What Storage button is enabled
		if(this.airship.getModuleLearnedStorage())
		{
			if(this.airship.getModuleSelectedStorage() == 1)
			{
				GuiVC.buttonModuleStorageLesser.enabled = true;
				GuiVC.buttonModuleStorageLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedStorage() == 2)
			{
				GuiVC.buttonModuleStorageNormal.enabled = true;
				GuiVC.buttonModuleStorageNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedStorage() == 3)
			{
				GuiVC.buttonModuleStorageGreater.enabled = true;
				GuiVC.buttonModuleStorageGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleStorageLesser.enabled = false;
        	GuiVC.buttonModuleStorageNormal.enabled = false;
        	GuiVC.buttonModuleStorageGreater.enabled = false;
        }
		
		//What Fuel button is enabled
		if(this.airship.getModuleLearnedFuel())
		{
			if(this.airship.getModuleSelectedFuel() == 1)
			{
				GuiVC.buttonModuleFuelLesser.enabled = true;
				GuiVC.buttonModuleFuelLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedFuel() == 2)
			{
				GuiVC.buttonModuleFuelNormal.enabled = true;
				GuiVC.buttonModuleFuelNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedFuel() == 3)
			{
				GuiVC.buttonModuleFuelGreater.enabled = true;
				GuiVC.buttonModuleFuelGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleFuelLesser.enabled = false;
        	GuiVC.buttonModuleFuelNormal.enabled = false;
        	GuiVC.buttonModuleFuelGreater.enabled = false;
        }
		
		//What Music button is enabled
		if(this.airship.getModuleLearnedMusic())
		{
			if(this.airship.getModuleSelectedMusic() == 1)
			{
				GuiVC.buttonModuleMusicLesser.enabled = true;
				GuiVC.buttonModuleMusicLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedMusic() == 2)
			{
				GuiVC.buttonModuleMusicNormal.enabled = true;
				GuiVC.buttonModuleMusicNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedMusic() == 3)
			{
				GuiVC.buttonModuleMusicGreater.enabled = true;
				GuiVC.buttonModuleMusicGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleMusicLesser.enabled = false;
        	GuiVC.buttonModuleMusicNormal.enabled = false;
        	GuiVC.buttonModuleMusicGreater.enabled = false;
        }
		
		//What Cruise button is enabled
		if(this.airship.getModuleLearnedCruise())
		{
			if(this.airship.getModuleSelectedCruise() == 1)
			{
				GuiVC.buttonModuleCruiseLesser.enabled = true;
				GuiVC.buttonModuleCruiseLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedCruise() == 2)
			{
				GuiVC.buttonModuleCruiseNormal.enabled = true;
				GuiVC.buttonModuleCruiseNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedCruise() == 3)
			{
				GuiVC.buttonModuleCruiseGreater.enabled = true;
				GuiVC.buttonModuleCruiseGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleCruiseLesser.enabled = false;
        	GuiVC.buttonModuleCruiseNormal.enabled = false;
        	GuiVC.buttonModuleCruiseGreater.enabled = false;
        }
		
		//What Water button is enabled
		if(this.airship.getModuleLearnedWater())
		{
			if(this.airship.getModuleSelectedWater() == 1)
			{
				GuiVC.buttonModuleWaterLesser.enabled = true;
				GuiVC.buttonModuleWaterLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedWater() == 2)
			{
				GuiVC.buttonModuleWaterNormal.enabled = true;
				GuiVC.buttonModuleWaterNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedWater() == 3)
			{
				GuiVC.buttonModuleWaterGreater.enabled = true;
				GuiVC.buttonModuleWaterGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleWaterLesser.enabled = false;
        	GuiVC.buttonModuleWaterNormal.enabled = false;
        	GuiVC.buttonModuleWaterGreater.enabled = false;
        }
		
		//What FuelInfinite button is enabled
		if(this.airship.getModuleLearnedFuelInfinite())
		{
			if(this.airship.getModuleSelectedFuelInfinite() == 1)
			{
				GuiVC.buttonModuleInfiniteFuelLesser.enabled = true;
				GuiVC.buttonModuleInfiniteFuelLesser.visible = true;
			}
			else if(this.airship.getModuleSelectedFuelInfinite() == 2)
			{
				GuiVC.buttonModuleInfiniteFuelNormal.enabled = true;
				GuiVC.buttonModuleInfiniteFuelNormal.visible = true;
			}
			else if(this.airship.getModuleSelectedFuelInfinite() == 3)
			{
				GuiVC.buttonModuleInfiniteFuelGreater.enabled = true;
				GuiVC.buttonModuleInfiniteFuelGreater.visible = true;
			}
		}
        else
        {
        	GuiVC.buttonModuleInfiniteFuelLesser.enabled = false;
        	GuiVC.buttonModuleInfiniteFuelNormal.enabled = false;
        	GuiVC.buttonModuleInfiniteFuelGreater.enabled = false;
        }
		
		this.buttonColor();
		
		if(!this.mc.player.isEntityAlive() 
         || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	/**
     * Draws an ItemStack.
     */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
    
    private void allButtonsRed()
	{
		this.buttonAltitude = 2;
		this.buttonSpeed = 2;
		this.buttonStorage = 2;
		this.buttonFuel = 2;
		this.buttonMusic = 2;
		this.buttonCruise = 2;
		this.buttonWater = 2;
		this.buttonInfiniteFuel = 2;
	}
	
    private void buttonColor()
    {
    	this.allButtonsRed();
        
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
        {
        	this.buttonAltitude = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
        {
        	this.buttonSpeed = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        {
        	this.buttonStorage = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
        {
        	this.buttonFuel = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
        {
        	this.buttonMusic = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
        {
        	this.buttonCruise = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
        {
        	this.buttonWater = 1;
        }
    	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata()
		|| this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
        {
        	this.buttonInfiniteFuel = 1;
        }
    	
    	super.updateScreen();
    }
}

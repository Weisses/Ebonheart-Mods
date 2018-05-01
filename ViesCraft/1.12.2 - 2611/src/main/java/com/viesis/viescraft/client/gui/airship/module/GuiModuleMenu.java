package com.viesis.viescraft.client.gui.airship.module;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerMainModule;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleLearn;
import com.viesis.viescraft.network.server.airship.module.MessageHelperGuiModuleToggleSlot1;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiModuleMenu extends GuiContainerVC {
	
	public static int learnModule;
	public static int toggleModule;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_menu_module.png");
	
	public GuiModuleMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerMainModule(playerInv, airshipIn), playerInv, airshipIn);
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
    	
    	GuiVC.buttonModuleReset = new GuiButtonGeneral2VC(501, this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (19 * 0), 14, 14, "", 1);
		
    	GuiVC.buttonModuleLesserAltitude = new GuiButtonGeneral2VC(EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalAltitude = new GuiButtonGeneral2VC(EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterAltitude = new GuiButtonGeneral2VC(EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserSpeed = new GuiButtonGeneral2VC(EnumsVC.ModuleType.SPEED_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalSpeed = new GuiButtonGeneral2VC(EnumsVC.ModuleType.SPEED_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterSpeed = new GuiButtonGeneral2VC(EnumsVC.ModuleType.SPEED_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 2), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserStorage = new GuiButtonGeneral2VC(EnumsVC.ModuleType.STORAGE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalStorage = new GuiButtonGeneral2VC(EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterStorage = new GuiButtonGeneral2VC(EnumsVC.ModuleType.STORAGE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 3), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.FUEL_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.FUEL_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.FUEL_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 4), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserMusic = new GuiButtonGeneral2VC(EnumsVC.ModuleType.MUSIC_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalMusic = new GuiButtonGeneral2VC(EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterMusic = new GuiButtonGeneral2VC(EnumsVC.ModuleType.MUSIC_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 5), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserCruise = new GuiButtonGeneral2VC(EnumsVC.ModuleType.CRUISE_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalCruise = new GuiButtonGeneral2VC(EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterCruise = new GuiButtonGeneral2VC(EnumsVC.ModuleType.CRUISE_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 6), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserWater = new GuiButtonGeneral2VC(EnumsVC.ModuleType.WATER_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalWater = new GuiButtonGeneral2VC(EnumsVC.ModuleType.WATER_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterWater = new GuiButtonGeneral2VC(EnumsVC.ModuleType.WATER_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 7), this.guiTop + 11 + (20 * 0), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserInfiniteFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalInfiniteFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterInfiniteFuel = new GuiButtonGeneral2VC(EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 0), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	
    	GuiVC.buttonModuleLesserBomb = new GuiButtonGeneral2VC(EnumsVC.ModuleType.BOMB_LESSER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVC.buttonModuleNormalBomb = new GuiButtonGeneral2VC(EnumsVC.ModuleType.BOMB_NORMAL.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	GuiVC.buttonModuleGreaterBomb = new GuiButtonGeneral2VC(EnumsVC.ModuleType.BOMB_GREATER.getMetadata(), this.guiLeft + 11 + (20 * 1), this.guiTop + 11 + (20 * 1), 14, 14, "", 3);
    	
    	
    	
    	GuiVC.buttonModuleLearn = new GuiButtonGeneral1VC(550, this.guiLeft + 128, this.guiTop + 94, 36, 14, References.localNameVC("vc.button.learn"), 1);
		
    	
    	
    	this.buttonList.add(GuiVC.buttonMM1);
		this.buttonList.add(GuiVC.buttonMM2);
		this.buttonList.add(GuiVC.buttonMM3);
		this.buttonList.add(GuiVC.buttonMM4);
		this.buttonList.add(GuiVC.buttonMM5);
		
		this.buttonList.add(GuiVC.buttonModuleLesserAltitude);
		this.buttonList.add(GuiVC.buttonModuleNormalAltitude);
		this.buttonList.add(GuiVC.buttonModuleGreaterAltitude);
		
		this.buttonList.add(GuiVC.buttonModuleLesserSpeed);
		this.buttonList.add(GuiVC.buttonModuleNormalSpeed);
		this.buttonList.add(GuiVC.buttonModuleGreaterSpeed);
		
		this.buttonList.add(GuiVC.buttonModuleLesserStorage);
		this.buttonList.add(GuiVC.buttonModuleNormalStorage);
		this.buttonList.add(GuiVC.buttonModuleGreaterStorage);
		
		this.buttonList.add(GuiVC.buttonModuleLesserFuel);
		this.buttonList.add(GuiVC.buttonModuleNormalFuel);
		this.buttonList.add(GuiVC.buttonModuleGreaterFuel);
		
		this.buttonList.add(GuiVC.buttonModuleLesserMusic);
		this.buttonList.add(GuiVC.buttonModuleNormalMusic);
		this.buttonList.add(GuiVC.buttonModuleGreaterMusic);
		
		this.buttonList.add(GuiVC.buttonModuleLesserCruise);
		this.buttonList.add(GuiVC.buttonModuleNormalCruise);
		this.buttonList.add(GuiVC.buttonModuleGreaterCruise);
		
		this.buttonList.add(GuiVC.buttonModuleLesserWater);
		this.buttonList.add(GuiVC.buttonModuleNormalWater);
		this.buttonList.add(GuiVC.buttonModuleGreaterWater);
		
		this.buttonList.add(GuiVC.buttonModuleLesserInfiniteFuel);
		this.buttonList.add(GuiVC.buttonModuleNormalInfiniteFuel);
		this.buttonList.add(GuiVC.buttonModuleGreaterInfiniteFuel);
		
		this.buttonList.add(GuiVC.buttonModuleLesserBomb);
		this.buttonList.add(GuiVC.buttonModuleNormalBomb);
		this.buttonList.add(GuiVC.buttonModuleGreaterBomb);
		
		this.buttonList.add(GuiVC.buttonModuleLearn);
		this.buttonList.add(GuiVC.buttonModuleReset);
		
		
		
		GuiVC.buttonModuleLesserAltitude.visible = false;
		GuiVC.buttonModuleNormalAltitude.visible = false;
		GuiVC.buttonModuleGreaterAltitude.visible = false;
		
		GuiVC.buttonModuleLesserSpeed.visible = false;
		GuiVC.buttonModuleNormalSpeed.visible = false;
		GuiVC.buttonModuleGreaterSpeed.visible = false;
		
		GuiVC.buttonModuleLesserStorage.visible = false;
		GuiVC.buttonModuleNormalStorage.visible = false;
		GuiVC.buttonModuleGreaterStorage.visible = false;
		
		GuiVC.buttonModuleLesserFuel.visible = false;
		GuiVC.buttonModuleNormalFuel.visible = false;
		GuiVC.buttonModuleGreaterFuel.visible = false;
		
		GuiVC.buttonModuleLesserMusic.visible = false;
		GuiVC.buttonModuleNormalMusic.visible = false;
		GuiVC.buttonModuleGreaterMusic.visible = false;
		
		GuiVC.buttonModuleLesserCruise.visible = false;
		GuiVC.buttonModuleNormalCruise.visible = false;
		GuiVC.buttonModuleGreaterCruise.visible = false;
		
		GuiVC.buttonModuleLesserWater.visible = false;
		GuiVC.buttonModuleNormalWater.visible = false;
		GuiVC.buttonModuleGreaterWater.visible = false;
		
		GuiVC.buttonModuleLesserInfiniteFuel.visible = false;
		GuiVC.buttonModuleNormalInfiniteFuel.visible = false;
		GuiVC.buttonModuleGreaterInfiniteFuel.visible = false;
		
		GuiVC.buttonModuleLesserBomb.visible = false;
		GuiVC.buttonModuleNormalBomb.visible = false;
		GuiVC.buttonModuleGreaterBomb.visible = false;
		
		
		
		GuiVC.buttonMM4.enabled = false;
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
			this.toggleModule = 0;
			
			NetworkHandler.sendToServer(new MessageHelperGuiModuleToggleSlot1());
	    }
		
		if (parButton.id <= 400)
	    {
			this.toggleModule = parButton.id;
			
			NetworkHandler.sendToServer(new MessageHelperGuiModuleToggleSlot1());
	    }
		
		
		
		if (parButton.id == 550)
	    {
			if(!this.airship.inventory.getStackInSlot(11).isEmpty())
			{
				if(this.airship.inventory.getStackInSlot(11).getItem() == InitItemsVC.MODULE_CREATIVE)
				{
					this.learnModule = 550;
				}
				else
				{
					this.learnModule = this.airship.inventory.getStackInSlot(11).getMetadata();
				}
				
				NetworkHandler.sendToServer(new MessageHelperGuiModuleLearn());
				this.airship.moduleActiveSlot1 = 0;
				this.airship.inventory.extractItem(11, 1, false);
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
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//On indicator if any Module is in learn slot
		if(!this.airship.inventory.getStackInSlot(11).isEmpty())
		{
			//Draws the box overlay around module slot
			this.drawTexturedModalRect(this.guiLeft + 108, this.guiTop + 92, 176, 0, 18, 18);
		}
		
		String nameIn = "";
		String pros1 = "";
		String pros2 = "";
		String cons1 = "";
		String cons2 = "";
		
		//Logic for mouse-over Altitude tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 1) && mouseX <= this.guiLeft + 24 + (20 * 1)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleAltitude == 1)
			{
				nameIn = EnumsVC.ModuleType.ALTITUDE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleAltitude == 2)
			{
				nameIn = EnumsVC.ModuleType.ALTITUDE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleAltitude == 3)
			{
				nameIn = EnumsVC.ModuleType.ALTITUDE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Speed tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 2) && mouseX <= this.guiLeft + 24 + (20 * 2)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleSpeed == 1)
			{
				nameIn = EnumsVC.ModuleType.SPEED_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleSpeed == 2)
			{
				nameIn = EnumsVC.ModuleType.SPEED_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleSpeed == 3)
			{
				nameIn = EnumsVC.ModuleType.SPEED_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.SPEED_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Storage tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 3) && mouseX <= this.guiLeft + 24 + (20 * 3)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleStorage == 1)
			{
				nameIn = EnumsVC.ModuleType.STORAGE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleStorage == 2)
			{
				nameIn = EnumsVC.ModuleType.STORAGE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleStorage == 3)
			{
				nameIn = EnumsVC.ModuleType.STORAGE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.STORAGE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Fuel tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 4) && mouseX <= this.guiLeft + 24 + (20 * 4)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleFuel == 1)
			{
				nameIn = EnumsVC.ModuleType.FUEL_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleFuel == 2)
			{
				nameIn = EnumsVC.ModuleType.FUEL_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleFuel == 3)
			{
				nameIn = EnumsVC.ModuleType.FUEL_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.FUEL_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Music tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 5) && mouseX <= this.guiLeft + 24 + (20 * 5)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleMusic == 1)
			{
				nameIn = EnumsVC.ModuleType.MUSIC_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleMusic == 2)
			{
				nameIn = EnumsVC.ModuleType.MUSIC_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleMusic == 3)
			{
				nameIn = EnumsVC.ModuleType.MUSIC_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.MUSIC_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Cruise tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 6) && mouseX <= this.guiLeft + 24 + (20 * 6)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleCruise == 1)
			{
				nameIn = EnumsVC.ModuleType.CRUISE_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleCruise == 2)
			{
				nameIn = EnumsVC.ModuleType.CRUISE_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleCruise == 3)
			{
				nameIn = EnumsVC.ModuleType.CRUISE_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.CRUISE_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Water tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 7) && mouseX <= this.guiLeft + 24 + (20 * 7)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			if(this.airship.selectedModuleWater == 1)
			{
				nameIn = EnumsVC.ModuleType.WATER_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleWater == 2)
			{
				nameIn = EnumsVC.ModuleType.WATER_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleWater == 3)
			{
				nameIn = EnumsVC.ModuleType.WATER_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.WATER_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Fuel Infinite tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 0) && mouseX <= this.guiLeft + 24 + (20 * 0)
		&& mouseY >= this.guiTop + 11 + (20 * 1) && mouseY <= this.guiTop + 24 + (20 * 1))
		{
			if(this.airship.selectedModuleFuelInfinite == 1)
			{
				nameIn = EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleFuelInfinite == 2)
			{
				nameIn = EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleFuelInfinite == 3)
			{
				nameIn = EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata() + ".cons2");
			}
		}
		
		//Logic for mouse-over Bomb tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 1) && mouseX <= this.guiLeft + 24 + (20 * 1)
		&& mouseY >= this.guiTop + 11 + (20 * 1) && mouseY <= this.guiTop + 24 + (20 * 1))
		{
			if(this.airship.selectedModuleBomb == 1)
			{
				nameIn = EnumsVC.ModuleType.BOMB_LESSER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_LESSER.getMetadata() + ".pros2");
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_LESSER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_LESSER.getMetadata() + ".pros2");
			}
			if(this.airship.selectedModuleBomb == 2)
			{
				nameIn = EnumsVC.ModuleType.BOMB_NORMAL.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_NORMAL.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_NORMAL.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_NORMAL.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_NORMAL.getMetadata() + ".cons2");
			}
			if(this.airship.selectedModuleBomb == 3)
			{
				nameIn = EnumsVC.ModuleType.BOMB_GREATER.getLocalizedName();
				pros1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_GREATER.getMetadata() + ".pros1");
				pros2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_GREATER.getMetadata() + ".pros2");
				cons1 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_GREATER.getMetadata() + ".cons1");
				cons2 = References.localNameVC("vc.item.tt.moduletype.#." + EnumsVC.ModuleType.BOMB_GREATER.getMetadata() + ".cons2");
			}
		}
		
		
		
		//Module name
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 77, 0);
			GlStateManager.scale(0.45, 0.45, 0.45);
			
			this.drawCenteredString(fontRenderer, TextFormatting.LIGHT_PURPLE + "" + TextFormatting.UNDERLINE + "" + TextFormatting.BOLD + nameIn, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Pros1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 88, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.GREEN + pros1, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Pros2
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 93, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.GREEN + pros2, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Cons1
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 103, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.RED + cons1, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		//Cons2
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 52, this.guiTop + 108, 0);
			GlStateManager.scale(0.4, 0.4, 0.4);
			
			this.drawCenteredString(fontRenderer, TextFormatting.RED + cons2, 0, 0, 0);
		}
		GlStateManager.popMatrix();
		
		//Draws the top menu extension for the main label
		this.drawRect(this.guiLeft + 49-1, this.guiTop - 17, this.guiLeft + 127+1, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-1, this.guiTop - 16, this.guiLeft + 126+1, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-1, this.guiTop - 14, this.guiLeft + 124+1, this.guiTop, Color.BLACK.getRGB());
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88+50.25, this.guiTop + 72-16.25, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88+50.25, this.guiTop + 77-16.25, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.RENAME_COST), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		//Undo buttons Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawTexturedModalRect(27, 27, 176, 0, 18, 18);
		}
		GlStateManager.popMatrix();
		
		this.fontRenderer.drawString(References.localNameVC("vc.main.modulemenu"), 58, -10, Color.CYAN.getRGB());
		
		//Altitude Icons
		if(this.airship.getModuleLearnedAltitude())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 1), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 2), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 3), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 4), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 5), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 6), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 7), 11.03 + (20 * 0), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
				GlStateManager.translate(11.03 + (20 * 0), 11.03 + (20 * 1), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
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
		
		//Bomb Icons
		if(this.airship.getModuleLearnedBomb())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(11.03 + (20 * 1), 11.03 + (20 * 1), 0);
				GlStateManager.scale(0.875, 0.875, 0.875);
				
				if(this.airship.getModuleSelectedBomb() == 1)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.BOMB_LESSER.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedBomb() == 2)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()), 0, 0, "");
				}
				else if(this.airship.getModuleSelectedBomb() == 3)
				{
					this.drawItemStack(new ItemStack(InitItemsVC.MODULE_TYPE, 1, EnumsVC.ModuleType.BOMB_GREATER.getMetadata()), 0, 0, "");
				}
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Default tooltip
		if(mouseX >= this.guiLeft + 11 + (20 * 0) && mouseX <= this.guiLeft + 24 + (20 * 0)
		&& mouseY >= this.guiTop + 11 + (20 * 0) && mouseY <= this.guiTop + 24 + (20 * 0))
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.main.default"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 23, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
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
			//Bomb
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.BOMB_LESSER.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 0)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 1)
			{
				GuiVC.buttonModuleLearn.enabled = false;
			}
			else if(this.airship.inventory.getStackInSlot(11).getMetadata() == EnumsVC.ModuleType.BOMB_GREATER.getMetadata()
			&& this.airship.getModuleSelectedBomb() != 2)
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
		
		
		GuiVC.buttonModuleLesserAltitude.visible = false;
		GuiVC.buttonModuleNormalAltitude.visible = false;
		GuiVC.buttonModuleGreaterAltitude.visible = false;
		
		GuiVC.buttonModuleLesserSpeed.visible = false;
		GuiVC.buttonModuleNormalSpeed.visible = false;
		GuiVC.buttonModuleGreaterSpeed.visible = false;
		
		GuiVC.buttonModuleLesserStorage.visible = false;
		GuiVC.buttonModuleNormalStorage.visible = false;
		GuiVC.buttonModuleGreaterStorage.visible = false;
		
		GuiVC.buttonModuleLesserFuel.visible = false;
		GuiVC.buttonModuleNormalFuel.visible = false;
		GuiVC.buttonModuleGreaterFuel.visible = false;
		
		GuiVC.buttonModuleLesserMusic.visible = false;
		GuiVC.buttonModuleNormalMusic.visible = false;
		GuiVC.buttonModuleGreaterMusic.visible = false;
		
		GuiVC.buttonModuleLesserCruise.visible = false;
		GuiVC.buttonModuleNormalCruise.visible = false;
		GuiVC.buttonModuleGreaterCruise.visible = false;
		
		GuiVC.buttonModuleLesserWater.visible = false;
		GuiVC.buttonModuleNormalWater.visible = false;
		GuiVC.buttonModuleGreaterWater.visible = false;
		
		GuiVC.buttonModuleLesserInfiniteFuel.visible = false;
		GuiVC.buttonModuleNormalInfiniteFuel.visible = false;
		GuiVC.buttonModuleGreaterInfiniteFuel.visible = false;
		
		GuiVC.buttonModuleLesserBomb.visible = false;
		GuiVC.buttonModuleNormalBomb.visible = false;
		GuiVC.buttonModuleGreaterBomb.visible = false;
		
		
		
		//What Altitude button is enabled
		if(this.airship.getModuleLearnedAltitude())
		{
			if(this.airship.getModuleSelectedAltitude() == 1)
			{
				GuiVC.buttonModuleLesserAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserAltitude.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserAltitude.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedAltitude() == 2)
			{
				GuiVC.buttonModuleNormalAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalAltitude.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalAltitude.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedAltitude() == 3)
			{
				GuiVC.buttonModuleGreaterAltitude.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterAltitude.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterAltitude.enabled = true;
				}
			}
		}
		//What Speed button is enabled
		if(this.airship.getModuleLearnedSpeed())
		{
			if(this.airship.getModuleSelectedSpeed() == 1)
			{
				GuiVC.buttonModuleLesserSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserSpeed.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserSpeed.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedSpeed() == 2)
			{
				GuiVC.buttonModuleNormalSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalSpeed.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalSpeed.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedSpeed() == 3)
			{
				GuiVC.buttonModuleGreaterSpeed.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterSpeed.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterSpeed.enabled = true;
				}
			}
		}
		//What Storage button is enabled
		if(this.airship.getModuleLearnedStorage())
		{
			if(this.airship.getModuleSelectedStorage() == 1)
			{
				GuiVC.buttonModuleLesserStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserStorage.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserStorage.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedStorage() == 2)
			{
				GuiVC.buttonModuleNormalStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalStorage.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalStorage.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedStorage() == 3)
			{
				GuiVC.buttonModuleGreaterStorage.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterStorage.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterStorage.enabled = true;
				}
			}
		}
		//What Fuel button is enabled
		if(this.airship.getModuleLearnedFuel())
		{
			if(this.airship.getModuleSelectedFuel() == 1)
			{
				GuiVC.buttonModuleLesserFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuel() == 2)
			{
				GuiVC.buttonModuleNormalFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuel() == 3)
			{
				GuiVC.buttonModuleGreaterFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterFuel.enabled = true;
				}
			}
		}
		//What Music button is enabled
		if(this.airship.getModuleLearnedMusic())
		{
			if(this.airship.getModuleSelectedMusic() == 1)
			{
				GuiVC.buttonModuleLesserMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserMusic.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserMusic.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedMusic() == 2)
			{
				GuiVC.buttonModuleNormalMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalMusic.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalMusic.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedMusic() == 3)
			{
				GuiVC.buttonModuleGreaterMusic.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterMusic.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterMusic.enabled = true;
				}
			}
		}
		//What Cruise button is enabled
		if(this.airship.getModuleLearnedCruise())
		{
			if(this.airship.getModuleSelectedCruise() == 1)
			{
				GuiVC.buttonModuleLesserCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserCruise.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserCruise.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedCruise() == 2)
			{
				GuiVC.buttonModuleNormalCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalCruise.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalCruise.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedCruise() == 3)
			{
				GuiVC.buttonModuleGreaterCruise.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterCruise.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterCruise.enabled = true;
				}
			}
		}
		//What Water button is enabled
		if(this.airship.getModuleLearnedWater())
		{
			if(this.airship.getModuleSelectedWater() == 1)
			{
				GuiVC.buttonModuleLesserWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserWater.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserWater.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedWater() == 2)
			{
				GuiVC.buttonModuleNormalWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalWater.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalWater.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedWater() == 3)
			{
				GuiVC.buttonModuleGreaterWater.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterWater.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterWater.enabled = true;
				}
			}
		}
		//What InfiniteFuel button is enabled
		if(this.airship.getModuleLearnedFuelInfinite())
		{
			if(this.airship.getModuleSelectedFuelInfinite() == 1)
			{
				GuiVC.buttonModuleLesserInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserInfiniteFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuelInfinite() == 2)
			{
				GuiVC.buttonModuleNormalInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalInfiniteFuel.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedFuelInfinite() == 3)
			{
				GuiVC.buttonModuleGreaterInfiniteFuel.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterInfiniteFuel.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterInfiniteFuel.enabled = true;
				}
			}
		}
		//What Bomb button is enabled
		if(this.airship.getModuleLearnedBomb())
		{
			if(this.airship.getModuleSelectedBomb() == 1)
			{
				GuiVC.buttonModuleLesserBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_LESSER.getMetadata())
				{
					GuiVC.buttonModuleLesserBomb.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleLesserBomb.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedBomb() == 2)
			{
				GuiVC.buttonModuleNormalBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_NORMAL.getMetadata())
				{
					GuiVC.buttonModuleNormalBomb.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleNormalBomb.enabled = true;
				}
			}
			if(this.airship.getModuleSelectedBomb() == 3)
			{
				GuiVC.buttonModuleGreaterBomb.visible = true;
				
				if(this.airship.getModuleActiveSlot1() == EnumsVC.ModuleType.BOMB_GREATER.getMetadata())
				{
					GuiVC.buttonModuleGreaterBomb.enabled = false;
				}
				else
				{
					GuiVC.buttonModuleGreaterBomb.enabled = true;
				}
			}
		}
    }
}

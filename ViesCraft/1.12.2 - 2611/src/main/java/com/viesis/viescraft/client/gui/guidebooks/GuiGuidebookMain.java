package com.viesis.viescraft.client.gui.guidebooks;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.client.gui.GuiButtonGuideBookVC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuidebookMain extends GuiGuidebookMainStrings {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 256;
    private int currPage = 0;
    
    /** The X size of the inventory window in pixels. */
    protected int xSize = 176;
    /** The Y size of the inventory window in pixels. */
    protected int ySize = 166;
    /** Starting X position for the Gui. Inconsistent use for Gui backgrounds. */
    protected int guiLeft;
    /** Starting Y position for the Gui. Inconsistent use for Gui backgrounds. */
    protected int guiTop;
    
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
    /** Basic Assembly */
    private GuiButton buttonMainTab1;
    /** Airship Interaction */
    private GuiButton buttonMainTab2;
    /** Upgrade System */
    private GuiButton buttonMainTab3;
    /** Module System */
    private GuiButton buttonMainTab4;
    /** Misc Information */
    private GuiButton buttonMainTab5;
    
    private GuiButton buttonRecipeLogicChip;
    private GuiButton buttonRecipeWorkbench;
    private GuiButton buttonRecipeBalloon;
    private GuiButton buttonRecipeFrame;
    private GuiButton buttonRecipeEngine;
    private GuiButton buttonRecipeIgnition;
    
    private GuiButton buttonRecipeAirshipV1;
    private GuiButton buttonRecipeAirshipV2;
    private GuiButton buttonRecipeAirshipV3;
    private GuiButton buttonRecipeAirshipV4;
    
    private GuiButton buttonRecipeViesolinePellets;
    private GuiButton buttonRecipeDismounter;
    private GuiButton buttonRecipeDismounterPlayer;
    
    private GuiButton buttonRecipeUpgradeFrame0;
    private GuiButton buttonRecipeUpgradeFrame1;
    private GuiButton buttonRecipeUpgradeFrame2;
    private GuiButton buttonRecipeUpgradeFrame3;
    private GuiButton buttonRecipeUpgradeFrame4;
    private GuiButton buttonRecipeUpgradeFrame5;

    private GuiButton buttonRecipeUpgradeCore0;
    private GuiButton buttonRecipeUpgradeCore1;
    private GuiButton buttonRecipeUpgradeCore2;
    private GuiButton buttonRecipeUpgradeCore3;
    private GuiButton buttonRecipeUpgradeCore4;
    private GuiButton buttonRecipeUpgradeCore5;

    private GuiButton buttonRecipeUpgradeEngine0;
    private GuiButton buttonRecipeUpgradeEngine1;
    private GuiButton buttonRecipeUpgradeEngine2;
    private GuiButton buttonRecipeUpgradeEngine3;
    private GuiButton buttonRecipeUpgradeEngine4;
    private GuiButton buttonRecipeUpgradeEngine5;

    private GuiButton buttonRecipeUpgradeBalloon0;
    private GuiButton buttonRecipeUpgradeBalloon1;
    private GuiButton buttonRecipeUpgradeBalloon2;
    private GuiButton buttonRecipeUpgradeBalloon3;
    private GuiButton buttonRecipeUpgradeBalloon4;
    private GuiButton buttonRecipeUpgradeBalloon5;
    
    private GuiButton buttonRecipeModuleChip;
    private GuiButton buttonRecipeModuleAltitudeL;
    private GuiButton buttonRecipeModuleAltitudeN;
    private GuiButton buttonRecipeModuleAltitudeG;
    private GuiButton buttonRecipeModuleSpeedL;
    private GuiButton buttonRecipeModuleSpeedN;
    private GuiButton buttonRecipeModuleSpeedG;
    private GuiButton buttonRecipeModuleStorageL;
    private GuiButton buttonRecipeModuleStorageN;
    private GuiButton buttonRecipeModuleStorageG;
    private GuiButton buttonRecipeModuleFuelL;
    private GuiButton buttonRecipeModuleFuelN;
    private GuiButton buttonRecipeModuleFuelG;
    private GuiButton buttonRecipeModuleMusicL;
    private GuiButton buttonRecipeModuleMusicN;
    private GuiButton buttonRecipeModuleMusicG;
    private GuiButton buttonRecipeModuleCruiseL;
    private GuiButton buttonRecipeModuleCruiseN;
    private GuiButton buttonRecipeModuleCruiseG;
    private GuiButton buttonRecipeModuleWaterL;
    private GuiButton buttonRecipeModuleWaterN;
    private GuiButton buttonRecipeModuleWaterG;
    private GuiButton buttonRecipeModuleInfiniteFuelL;
    private GuiButton buttonRecipeModuleInfiniteFuelN;
    private GuiButton buttonRecipeModuleInfiniteFuelG;
    
    
    
    private boolean recipeLogicChip;
    private boolean recipeWorkbench;
    private boolean recipeBalloon;
    private boolean recipeFrame;
    private boolean recipeEngine;
    private boolean recipeIgnition;
    
    private boolean recipeAirshipV1;
    private boolean recipeAirshipV2;
    private boolean recipeAirshipV3;
    private boolean recipeAirshipV4;
    
    private boolean recipeViesolinePellets;
    private boolean recipeDismounter;
    private boolean recipeDismounterPlayer;

    private boolean recipeUpgradeFrame0;
    private boolean recipeUpgradeFrame1;
    private boolean recipeUpgradeFrame2;
    private boolean recipeUpgradeFrame3;
    private boolean recipeUpgradeFrame4;
    private boolean recipeUpgradeFrame5;

    private boolean recipeUpgradeCore0;
    private boolean recipeUpgradeCore1;
    private boolean recipeUpgradeCore2;
    private boolean recipeUpgradeCore3;
    private boolean recipeUpgradeCore4;
    private boolean recipeUpgradeCore5;

    private boolean recipeUpgradeEngine0;
    private boolean recipeUpgradeEngine1;
    private boolean recipeUpgradeEngine2;
    private boolean recipeUpgradeEngine3;
    private boolean recipeUpgradeEngine4;
    private boolean recipeUpgradeEngine5;

    private boolean recipeUpgradeBalloon0;
    private boolean recipeUpgradeBalloon1;
    private boolean recipeUpgradeBalloon2;
    private boolean recipeUpgradeBalloon3;
    private boolean recipeUpgradeBalloon4;
    private boolean recipeUpgradeBalloon5;

    private boolean recipeModuleChip;
    private boolean recipeModuleAltitudeL;
    private boolean recipeModuleAltitudeN;
    private boolean recipeModuleAltitudeG;
    private boolean recipeModuleSpeedL;
    private boolean recipeModuleSpeedN;
    private boolean recipeModuleSpeedG;
    private boolean recipeModuleStorageL;
    private boolean recipeModuleStorageN;
    private boolean recipeModuleStorageG;
    private boolean recipeModuleFuelL;
    private boolean recipeModuleFuelN;
    private boolean recipeModuleFuelG;
    private boolean recipeModuleMusicL;
    private boolean recipeModuleMusicN;
    private boolean recipeModuleMusicG;
    private boolean recipeModuleCruiseL;
    private boolean recipeModuleCruiseN;
    private boolean recipeModuleCruiseG;
    private boolean recipeModuleWaterL;
    private boolean recipeModuleWaterN;
    private boolean recipeModuleWaterG;
    private boolean recipeModuleInfiniteFuelL;
    private boolean recipeModuleInfiniteFuelN;
    private boolean recipeModuleInfiniteFuelG;
    
    public GuiGuidebookMain()
    {
    	
    }
    
    //TODO Adds Buttons
    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	buttonList.clear();
        Keyboard.enableRepeatEvents(true);
        
    	this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        int startY = 77;
        
        buttonDone = new GuiButtonGeneralVC(0, this.guiLeft + 60, 184, 57, 14, I18n.format("gui.done", new Object[0]), 0);
        
        buttonMainTab1 = new GuiButtonGuideBookVC(101, this.guiLeft - 84, 32, 57, 14, I18n.format("Basic Assembly", new Object[0]), 0.5F, 0.5F, 0.5F, 0);
        buttonMainTab2 = new GuiButtonGuideBookVC(102, this.guiLeft - 84, 32 + (14 * 1), 57, 14, I18n.format("Airship Interaction", new Object[0]), 0.5F, 0.5F, 0.5F, 0);
        buttonMainTab3 = new GuiButtonGuideBookVC(103, this.guiLeft - 84, 32 + (14 * 2), 57, 14, I18n.format("Upgrade System", new Object[0]), 0.5F, 0.5F, 0.5F, 0);
        buttonMainTab4 = new GuiButtonGuideBookVC(104, this.guiLeft - 84, 32 + (14 * 3), 57, 14, I18n.format("Module System", new Object[0]), 0.5F, 0.5F, 0.5F, 0);
        buttonMainTab5 = new GuiButtonGuideBookVC(105, this.guiLeft - 84, 32 + (14 * 4), 57, 14, I18n.format("Airship Behavior", new Object[0]), 0.5F, 0.5F, 0.5F, 0);
        
        
        
        buttonRecipeLogicChip = new GuiButtonGeneralVC(1, this.guiLeft - 16, startY + (14 * 0), 78, 14, I18n.format("Logic Chip", new Object[0]), 0);
        buttonRecipeWorkbench = new GuiButtonGeneralVC(2, this.guiLeft - 16, startY + (14 * 1), 78, 14, I18n.format("Workbench", new Object[0]), 0);
        buttonRecipeBalloon = new GuiButtonGeneralVC(3, this.guiLeft - 16, startY + (14 * 2), 78, 14, I18n.format("Balloon", new Object[0]), 0);
        buttonRecipeFrame = new GuiButtonGeneralVC(4, this.guiLeft - 16, startY + (14 * 3), 78, 14, I18n.format("Frame", new Object[0]), 0);
        buttonRecipeEngine = new GuiButtonGeneralVC(5, this.guiLeft - 16, startY + (14 * 4), 78, 14, I18n.format("Engine", new Object[0]), 0);
        buttonRecipeIgnition = new GuiButtonGeneralVC(6, this.guiLeft - 16, startY + (14 * 5), 78, 14, I18n.format("Ignition", new Object[0]), 0);
        
        buttonRecipeAirshipV1 = new GuiButtonGeneralVC(5, this.guiLeft - 16, startY + (14 * 2), 78, 14, I18n.format(ViesCraftConfig.v1AirshipName, new Object[0]), 0);
        buttonRecipeAirshipV2 = new GuiButtonGeneralVC(6, this.guiLeft - 16, startY + (14 * 3), 78, 14, I18n.format(ViesCraftConfig.v2AirshipName, new Object[0]), 0);
        buttonRecipeAirshipV3 = new GuiButtonGeneralVC(7, this.guiLeft - 16, startY + (14 * 4), 78, 14, I18n.format(ViesCraftConfig.v3AirshipName, new Object[0]), 0);
        buttonRecipeAirshipV4 = new GuiButtonGeneralVC(8, this.guiLeft - 16, startY + (14 * 5), 78, 14, ViesCraftConfig.v4AirshipName, 0);
        
        buttonRecipeViesolinePellets = new GuiButtonGeneralVC(9, this.guiLeft - 16, startY + (14 * 3), 78, 14, I18n.format("Viesoline Pellets", new Object[0]), 0);
        buttonRecipeDismounter = new GuiButtonGeneralVC(10, this.guiLeft - 16, startY + (14 * 4), 78, 14, I18n.format("Dismounter", new Object[0]), 0);
        buttonRecipeDismounterPlayer = new GuiButtonGeneralVC(11, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Player Dismounter", 0);
        
        buttonRecipeUpgradeFrame0 = new GuiButtonGeneralVC(20, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Frame Casing", 0);
        buttonRecipeUpgradeFrame1 = new GuiButtonGeneralVC(21, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Frame Upgrade 1", 0);
        buttonRecipeUpgradeFrame2 = new GuiButtonGeneralVC(22, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Frame Upgrade 2", 0);
        buttonRecipeUpgradeFrame3 = new GuiButtonGeneralVC(23, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Frame Upgrade 3", 0);
        buttonRecipeUpgradeFrame4 = new GuiButtonGeneralVC(24, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Frame Upgrade 4", 0);
        buttonRecipeUpgradeFrame5 = new GuiButtonGeneralVC(25, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Frame Upgrade 5", 0);

        buttonRecipeUpgradeCore0 = new GuiButtonGeneralVC(30, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Core Shard", 0);
        buttonRecipeUpgradeCore1 = new GuiButtonGeneralVC(31, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Core Upgrade 1", 0);
        buttonRecipeUpgradeCore2 = new GuiButtonGeneralVC(32, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Core Upgrade 2", 0);
        buttonRecipeUpgradeCore3 = new GuiButtonGeneralVC(33, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Core Upgrade 3", 0);
        buttonRecipeUpgradeCore4 = new GuiButtonGeneralVC(34, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Core Upgrade 4", 0);
        buttonRecipeUpgradeCore5 = new GuiButtonGeneralVC(35, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Core Upgrade 5", 0);

        buttonRecipeUpgradeEngine0 = new GuiButtonGeneralVC(40, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Engine Fragment", 0);
        buttonRecipeUpgradeEngine1 = new GuiButtonGeneralVC(41, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Engine Upgrade 1", 0);
        buttonRecipeUpgradeEngine2 = new GuiButtonGeneralVC(42, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Engine Upgrade 2", 0);
        buttonRecipeUpgradeEngine3 = new GuiButtonGeneralVC(43, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Engine Upgrade 3", 0);
        buttonRecipeUpgradeEngine4 = new GuiButtonGeneralVC(44, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Engine Upgrade 4", 0);
        buttonRecipeUpgradeEngine5 = new GuiButtonGeneralVC(45, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Engine Upgrade 5", 0);

        buttonRecipeUpgradeBalloon0 = new GuiButtonGeneralVC(50, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Balloon Remnant", 0);
        buttonRecipeUpgradeBalloon1 = new GuiButtonGeneralVC(51, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Balloon Upgrade 1", 0);
        buttonRecipeUpgradeBalloon2 = new GuiButtonGeneralVC(52, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Balloon Upgrade 2", 0);
        buttonRecipeUpgradeBalloon3 = new GuiButtonGeneralVC(53, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Balloon Upgrade 3", 0);
        buttonRecipeUpgradeBalloon4 = new GuiButtonGeneralVC(54, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Balloon Upgrade 4", 0);
        buttonRecipeUpgradeBalloon5 = new GuiButtonGeneralVC(55, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Balloon Upgrade 5", 0);
        
        buttonRecipeModuleChip = new GuiButtonGeneralVC(61, this.guiLeft - 16, startY + (14 * 0) - 28, 78, 14, "Module Chip", 0);
        buttonRecipeModuleAltitudeL = new GuiButtonGeneralVC(62, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Lesser Altitude", 0);
        buttonRecipeModuleAltitudeN = new GuiButtonGeneralVC(63, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Altitude", 0);
        buttonRecipeModuleAltitudeG = new GuiButtonGeneralVC(64, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Greater Altitude", 0);
        buttonRecipeModuleSpeedL = new GuiButtonGeneralVC(65, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Lesser Speed", 0);
        buttonRecipeModuleSpeedN = new GuiButtonGeneralVC(66, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Speed", 0);
        buttonRecipeModuleSpeedG = new GuiButtonGeneralVC(67, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Greater Speed", 0);
        
        buttonRecipeModuleStorageL = new GuiButtonGeneralVC(62, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Lesser Storage", 0);
        buttonRecipeModuleStorageN = new GuiButtonGeneralVC(63, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Storage", 0);
        buttonRecipeModuleStorageG = new GuiButtonGeneralVC(64, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Greater Storage", 0);
        buttonRecipeModuleFuelL = new GuiButtonGeneralVC(65, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Lesser Fuel", 0);
        buttonRecipeModuleFuelN = new GuiButtonGeneralVC(66, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Fuel", 0);
        buttonRecipeModuleFuelG = new GuiButtonGeneralVC(67, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Greater Fuel", 0);
        
        buttonRecipeModuleMusicL = new GuiButtonGeneralVC(62, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Lesser Music", 0);
        buttonRecipeModuleMusicN = new GuiButtonGeneralVC(63, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Music", 0);
        buttonRecipeModuleMusicG = new GuiButtonGeneralVC(64, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Greater Music", 0);
        buttonRecipeModuleCruiseL = new GuiButtonGeneralVC(65, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Lesser Cruise", 0);
        buttonRecipeModuleCruiseN = new GuiButtonGeneralVC(66, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Cruise", 0);
        buttonRecipeModuleCruiseG = new GuiButtonGeneralVC(67, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Greater Cruise", 0);
        
        buttonRecipeModuleWaterL = new GuiButtonGeneralVC(62, this.guiLeft - 16, startY + (14 * 0), 78, 14, "Lesser Water", 0);
        buttonRecipeModuleWaterN = new GuiButtonGeneralVC(63, this.guiLeft - 16, startY + (14 * 1), 78, 14, "Water", 0);
        buttonRecipeModuleWaterG = new GuiButtonGeneralVC(64, this.guiLeft - 16, startY + (14 * 2), 78, 14, "Greater Water", 0);
        buttonRecipeModuleInfiniteFuelL = new GuiButtonGeneralVC(65, this.guiLeft - 16, startY + (14 * 3), 78, 14, "Lesser Inf. Fuel", 0);
        buttonRecipeModuleInfiniteFuelN = new GuiButtonGeneralVC(66, this.guiLeft - 16, startY + (14 * 4), 78, 14, "Infinite Fuel", 0);
        buttonRecipeModuleInfiniteFuelG = new GuiButtonGeneralVC(67, this.guiLeft - 16, startY + (14 * 5), 78, 14, "Greater Inf. Fuel", 0);
        
        
        
        buttonList.add(buttonDone);
        
        buttonList.add(buttonMainTab1);
        buttonList.add(buttonMainTab2);
        buttonList.add(buttonMainTab3);
        buttonList.add(buttonMainTab4);
        buttonList.add(buttonMainTab5);
        
        buttonList.add(buttonRecipeLogicChip);
        buttonList.add(buttonRecipeWorkbench);
        buttonList.add(buttonRecipeBalloon);
        buttonList.add(buttonRecipeFrame);
        buttonList.add(buttonRecipeEngine);
        buttonList.add(buttonRecipeIgnition);
        
        buttonList.add(buttonRecipeAirshipV1);
        buttonList.add(buttonRecipeAirshipV2);
        buttonList.add(buttonRecipeAirshipV3);
        buttonList.add(buttonRecipeAirshipV4);
        
        buttonList.add(buttonRecipeViesolinePellets);
        buttonList.add(buttonRecipeDismounter);
        buttonList.add(buttonRecipeDismounterPlayer);
        
        buttonList.add(buttonRecipeUpgradeFrame0);
        buttonList.add(buttonRecipeUpgradeFrame1);
        buttonList.add(buttonRecipeUpgradeFrame2);
        buttonList.add(buttonRecipeUpgradeFrame3);
        buttonList.add(buttonRecipeUpgradeFrame4);
        buttonList.add(buttonRecipeUpgradeFrame5);

        buttonList.add(buttonRecipeUpgradeCore0);
        buttonList.add(buttonRecipeUpgradeCore1);
        buttonList.add(buttonRecipeUpgradeCore2);
        buttonList.add(buttonRecipeUpgradeCore3);
        buttonList.add(buttonRecipeUpgradeCore4);
        buttonList.add(buttonRecipeUpgradeCore5);

        buttonList.add(buttonRecipeUpgradeEngine0);
        buttonList.add(buttonRecipeUpgradeEngine1);
        buttonList.add(buttonRecipeUpgradeEngine2);
        buttonList.add(buttonRecipeUpgradeEngine3);
        buttonList.add(buttonRecipeUpgradeEngine4);
        buttonList.add(buttonRecipeUpgradeEngine5);

        buttonList.add(buttonRecipeUpgradeBalloon0);
        buttonList.add(buttonRecipeUpgradeBalloon1);
        buttonList.add(buttonRecipeUpgradeBalloon2);
        buttonList.add(buttonRecipeUpgradeBalloon3);
        buttonList.add(buttonRecipeUpgradeBalloon4);
        buttonList.add(buttonRecipeUpgradeBalloon5);
        
        buttonList.add(buttonRecipeModuleChip);
        buttonList.add(buttonRecipeModuleAltitudeL);
        buttonList.add(buttonRecipeModuleAltitudeN);
        buttonList.add(buttonRecipeModuleAltitudeG);
        buttonList.add(buttonRecipeModuleSpeedL);
        buttonList.add(buttonRecipeModuleSpeedN);
        buttonList.add(buttonRecipeModuleSpeedG);
        buttonList.add(buttonRecipeModuleStorageL);
        buttonList.add(buttonRecipeModuleStorageN);
        buttonList.add(buttonRecipeModuleStorageG);
        buttonList.add(buttonRecipeModuleFuelL);
        buttonList.add(buttonRecipeModuleFuelN);
        buttonList.add(buttonRecipeModuleFuelG);
        buttonList.add(buttonRecipeModuleMusicL);
        buttonList.add(buttonRecipeModuleMusicN);
        buttonList.add(buttonRecipeModuleMusicG);
        buttonList.add(buttonRecipeModuleCruiseL);
        buttonList.add(buttonRecipeModuleCruiseN);
        buttonList.add(buttonRecipeModuleCruiseG);
        buttonList.add(buttonRecipeModuleWaterL);
        buttonList.add(buttonRecipeModuleWaterN);
        buttonList.add(buttonRecipeModuleWaterG);
        buttonList.add(buttonRecipeModuleInfiniteFuelL);
        buttonList.add(buttonRecipeModuleInfiniteFuelN);
        buttonList.add(buttonRecipeModuleInfiniteFuelG);
        
        
        
        buttonRecipeLogicChip.visible = false;
        buttonRecipeWorkbench.visible = false;
        buttonRecipeBalloon.visible = false;
        buttonRecipeFrame.visible = false;
        buttonRecipeEngine.visible = false;
        buttonRecipeIgnition.visible = false;
        
        buttonRecipeAirshipV1.visible = false;
        buttonRecipeAirshipV2.visible = false;
        buttonRecipeAirshipV3.visible = false;
        buttonRecipeAirshipV4.visible = false;
        
        buttonRecipeViesolinePellets.visible = false;
        buttonRecipeDismounter.visible = false;
        buttonRecipeDismounterPlayer.visible = false;
        
        buttonRecipeUpgradeFrame0.visible = false;
        buttonRecipeUpgradeFrame1.visible = false;
        buttonRecipeUpgradeFrame2.visible = false;
        buttonRecipeUpgradeFrame3.visible = false;
        buttonRecipeUpgradeFrame4.visible = false;
        buttonRecipeUpgradeFrame5.visible = false;

        buttonRecipeUpgradeCore0.visible = false;
        buttonRecipeUpgradeCore1.visible = false;
        buttonRecipeUpgradeCore2.visible = false;
        buttonRecipeUpgradeCore3.visible = false;
        buttonRecipeUpgradeCore4.visible = false;
        buttonRecipeUpgradeCore5.visible = false;

        buttonRecipeUpgradeEngine0.visible = false;
        buttonRecipeUpgradeEngine1.visible = false;
        buttonRecipeUpgradeEngine2.visible = false;
        buttonRecipeUpgradeEngine3.visible = false;
        buttonRecipeUpgradeEngine4.visible = false;
        buttonRecipeUpgradeEngine5.visible = false;

        buttonRecipeUpgradeBalloon0.visible = false;
        buttonRecipeUpgradeBalloon1.visible = false;
        buttonRecipeUpgradeBalloon2.visible = false;
        buttonRecipeUpgradeBalloon3.visible = false;
        buttonRecipeUpgradeBalloon4.visible = false;
        buttonRecipeUpgradeBalloon5.visible = false;
        
        buttonRecipeModuleChip.visible = false;
        buttonRecipeModuleAltitudeL.visible = false;
        buttonRecipeModuleAltitudeN.visible = false;
        buttonRecipeModuleAltitudeG.visible = false;
        buttonRecipeModuleSpeedL.visible = false;
        buttonRecipeModuleSpeedN.visible = false;
        buttonRecipeModuleSpeedG.visible = false;
        buttonRecipeModuleStorageL.visible = false;
        buttonRecipeModuleStorageN.visible = false;
        buttonRecipeModuleStorageG.visible = false;
        buttonRecipeModuleFuelL.visible = false;
        buttonRecipeModuleFuelN.visible = false;
        buttonRecipeModuleFuelG.visible = false;
        buttonRecipeModuleMusicL.visible = false;
        buttonRecipeModuleMusicN.visible = false;
        buttonRecipeModuleMusicG.visible = false;
        buttonRecipeModuleCruiseL.visible = false;
        buttonRecipeModuleCruiseN.visible = false;
        buttonRecipeModuleCruiseG.visible = false;
        buttonRecipeModuleWaterL.visible = false;
        buttonRecipeModuleWaterN.visible = false;
        buttonRecipeModuleWaterG.visible = false;
        buttonRecipeModuleInfiniteFuelL.visible = false;
        buttonRecipeModuleInfiniteFuelN.visible = false;
        buttonRecipeModuleInfiniteFuelG.visible = false;
        
        
        
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, offsetFromScreenLeft + 38, 156, false));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
    	buttonNextPage.visible = (currPage < 17);
        buttonPreviousPage.visible = currPage > 0;
        
        buttonRecipeLogicChip.visible = (currPage == 1);
        buttonRecipeWorkbench.visible = (currPage == 1);
        buttonRecipeBalloon.visible = (currPage == 1);
        buttonRecipeFrame.visible = (currPage == 1);
        buttonRecipeEngine.visible = (currPage == 1);
        buttonRecipeIgnition.visible = (currPage == 1);
        
        buttonRecipeAirshipV1.visible = (currPage == 2);
        buttonRecipeAirshipV2.visible = (currPage == 2);
        buttonRecipeAirshipV3.visible = (currPage == 2);
        buttonRecipeAirshipV4.visible = (currPage == 2);
         
        buttonRecipeViesolinePellets.visible = (currPage == 3);
        buttonRecipeDismounter.visible = (currPage == 3);
        buttonRecipeDismounterPlayer.visible = (currPage == 3);
        
        buttonRecipeUpgradeFrame0.visible = (currPage == 8);
        buttonRecipeUpgradeFrame1.visible = (currPage == 8);
        buttonRecipeUpgradeFrame2.visible = (currPage == 8);
        buttonRecipeUpgradeFrame3.visible = (currPage == 8);
        buttonRecipeUpgradeFrame4.visible = (currPage == 8);
        buttonRecipeUpgradeFrame5.visible = (currPage == 8);

        buttonRecipeUpgradeCore0.visible = (currPage == 9);
        buttonRecipeUpgradeCore1.visible = (currPage == 9);
        buttonRecipeUpgradeCore2.visible = (currPage == 9);
        buttonRecipeUpgradeCore3.visible = (currPage == 9);
        buttonRecipeUpgradeCore4.visible = (currPage == 9);
        buttonRecipeUpgradeCore5.visible = (currPage == 9);

        buttonRecipeUpgradeEngine0.visible = (currPage == 10);
        buttonRecipeUpgradeEngine1.visible = (currPage == 10);
        buttonRecipeUpgradeEngine2.visible = (currPage == 10);
        buttonRecipeUpgradeEngine3.visible = (currPage == 10);
        buttonRecipeUpgradeEngine4.visible = (currPage == 10);
        buttonRecipeUpgradeEngine5.visible = (currPage == 10);

        buttonRecipeUpgradeBalloon0.visible = (currPage == 11);
        buttonRecipeUpgradeBalloon1.visible = (currPage == 11);
        buttonRecipeUpgradeBalloon2.visible = (currPage == 11);
        buttonRecipeUpgradeBalloon3.visible = (currPage == 11);
        buttonRecipeUpgradeBalloon4.visible = (currPage == 11);
        buttonRecipeUpgradeBalloon5.visible = (currPage == 11);
        
        buttonRecipeModuleChip.visible = (currPage == 13);
        buttonRecipeModuleAltitudeL.visible = (currPage == 13);
        buttonRecipeModuleAltitudeN.visible = (currPage == 13);
        buttonRecipeModuleAltitudeG.visible = (currPage == 13);
        buttonRecipeModuleSpeedL.visible = (currPage == 13);
        buttonRecipeModuleSpeedN.visible = (currPage == 13);
        buttonRecipeModuleSpeedG.visible = (currPage == 13);
        
        buttonRecipeModuleStorageL.visible = (currPage == 14);
        buttonRecipeModuleStorageN.visible = (currPage == 14);
        buttonRecipeModuleStorageG.visible = (currPage == 14);
        buttonRecipeModuleFuelL.visible = (currPage == 14);
        buttonRecipeModuleFuelN.visible = (currPage == 14);
        buttonRecipeModuleFuelG.visible = (currPage == 14);
        
        buttonRecipeModuleMusicL.visible = (currPage == 15);
        buttonRecipeModuleMusicN.visible = (currPage == 15);
        buttonRecipeModuleMusicG.visible = (currPage == 15);
        buttonRecipeModuleCruiseL.visible = (currPage == 15);
        buttonRecipeModuleCruiseN.visible = (currPage == 15);
        buttonRecipeModuleCruiseG.visible = (currPage == 15);
        
        buttonRecipeModuleWaterL.visible = (currPage == 16);
        buttonRecipeModuleWaterN.visible = (currPage == 16);
        buttonRecipeModuleWaterG.visible = (currPage == 16);
        buttonRecipeModuleInfiniteFuelL.visible = (currPage == 16);
        buttonRecipeModuleInfiniteFuelN.visible = (currPage == 16);
        buttonRecipeModuleInfiniteFuelG.visible = (currPage == 16);
        
        
        
        if(currPage == 1 
		|| currPage == 2 
		|| currPage == 3)
        {
        	buttonMainTab1.enabled = false;
        }
        else
        {
        	buttonMainTab1.enabled = true;
        }
        
        if(currPage == 4 
        || currPage == 5 
	    || currPage == 6)
        {
        	buttonMainTab2.enabled = false;
        }
        else
        {
        	buttonMainTab2.enabled = true;
        }
	
	    if(currPage == 7 
		|| currPage == 8 
		|| currPage == 9 
		|| currPage == 10 
		|| currPage == 11)
	    {
	    	buttonMainTab3.enabled = false;
	    }
	    else
	    {
	    	buttonMainTab3.enabled = true;
	    }
	
	    if(currPage == 12 
		|| currPage == 13 
		|| currPage == 14 
		|| currPage == 15 
		|| currPage == 16)
	    {
	    	buttonMainTab4.enabled = false;
	    }
	    else
	    {
	    	buttonMainTab4.enabled = true;
	    }
	    
	    if(currPage == 17)
	    {
	    	buttonMainTab5.enabled = false;
	    }
	    else
	    {
	    	buttonMainTab5.enabled = true;
	    }
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        
        mc.getTextureManager().bindTexture(bookPageTextures[currPage]);
        
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRenderer.getStringWidth(stringPageIndicator);
        
        //Pages
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(offsetFromScreenLeft + 102, 18, 0);
			GlStateManager.scale(.5, .5, .5);
			
			if(Integer.valueOf(currPage) == 0)
			{
				fontRenderer.drawString("Page 1", 0, 0, 1);
				fontRenderer.drawString("Page 2", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 1)
			{
				fontRenderer.drawString("Page 3", 0, 0, 1);
				fontRenderer.drawString("Page 4", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 2)
			{
				fontRenderer.drawString("Page 5", 0, 0, 1);
				fontRenderer.drawString("Page 6", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 3)
			{
				fontRenderer.drawString("Page 7", 0, 0, 1);
				fontRenderer.drawString("Page 8", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 4)
			{
				fontRenderer.drawString("Page 9", 0, 0, 1);
				fontRenderer.drawString("Page 10", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 5)
			{
				fontRenderer.drawString("Page 11", 0, 0, 1);
				fontRenderer.drawString("Page 12", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 6)
			{
				fontRenderer.drawString("Page 13", 0, 0, 1);
				fontRenderer.drawString("Page 14", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 7)
			{
				fontRenderer.drawString("Page 15", 0, 0, 1);
				fontRenderer.drawString("Page 16", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 8)
			{
				fontRenderer.drawString("Page 17", 0, 0, 1);
				fontRenderer.drawString("Page 18", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 9)
			{
				fontRenderer.drawString("Page 19", 0, 0, 1);
				fontRenderer.drawString("Page 20", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 10)
			{
				fontRenderer.drawString("Page 21", 0, 0, 1);
				fontRenderer.drawString("Page 22", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 11)
			{
				fontRenderer.drawString("Page 23", 0, 0, 1);
				fontRenderer.drawString("Page 24", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 12)
			{
				fontRenderer.drawString("Page 25", 0, 0, 1);
				fontRenderer.drawString("Page 26", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 13)
			{
				fontRenderer.drawString("Page 27", 0, 0, 1);
				fontRenderer.drawString("Page 28", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 14)
			{
				fontRenderer.drawString("Page 29", 0, 0, 1);
				fontRenderer.drawString("Page 30", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 15)
			{
				fontRenderer.drawString("Page 31", 0, 0, 1);
				fontRenderer.drawString("Page 32", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 16)
			{
				fontRenderer.drawString("Page 33", 0, 0, 1);
				fontRenderer.drawString("Page 34", 241, 0, 1);
			}
			if(Integer.valueOf(currPage) == 17)
			{
				fontRenderer.drawString("Page 35", 0, 0, 1);
				fontRenderer.drawString("Page 36", 241, 0, 1);
			}
		}
		GlStateManager.popMatrix();
		
		//Left
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(offsetFromScreenLeft + 20, 32, 0);
			GlStateManager.scale(.5, .5, .5);
			
			GlStateManager.translate(0, 0, 0);
			
			fontRenderer.drawSplitString(stringPageTextLeft[currPage], 0, 0, 196, 0);
		}
		GlStateManager.popMatrix();
		
		//Right page
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(offsetFromScreenLeft + 138, 32, 0);
			GlStateManager.scale(.5, .5, .5);
			
			fontRenderer.drawSplitString(stringPageTextRight[currPage], 0, 0, 196, 0);
		}
		GlStateManager.popMatrix();
		
		if(currPage == 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeft + 20, 32, 0);
				GlStateManager.scale(0.75, 0.75, 0.75);
				drawCenteredString(fontRenderer, References.MOD_VERSION, 64, 144, 13565952);
				fontRenderer.drawSplitString(stringPageTextLeftTitle[currPage], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		
        super.drawScreen(parWidth, parHeight, p_73863_3_);
        
        
        //TODO Main Recipe Section
        this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesMain.png"));
		this.getRecipeMain(offsetFromScreenLeft);
		
		
		
		//TODO Airship Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesAirship.png"));
		this.getRecipeAirship(offsetFromScreenLeft);
		
		
		
		//TODO Misc Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesMisc.png"));
		this.getRecipeMisc(offsetFromScreenLeft);
		
		
		
		//TODO Frame Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesFrame.png"));
		this.getRecipeFrame(offsetFromScreenLeft);
		
		
		
		//TODO Core Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesCore.png"));
		this.getRecipeCore(offsetFromScreenLeft);
		
		
		
		//TODO Engine Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesEngine.png"));
		this.getRecipeEngine(offsetFromScreenLeft);
		
		
		
		//TODO Balloon Recipe Section
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesBalloon.png"));
		this.getRecipeBalloon(offsetFromScreenLeft);
		
		
		
		//TODO Module1 Recipe Section
		this.getRecipeModule1(offsetFromScreenLeft);
		
		//TODO Module2 Recipe Section
		this.getRecipeModule2(offsetFromScreenLeft);
		
		//TODO Module3 Recipe Section
		this.getRecipeModule3(offsetFromScreenLeft);
		
		//TODO Module4 Recipe Section
		this.getRecipeModule4(offsetFromScreenLeft);
    }
    
    /**
     * Called when a mouse button is pressed and the mouse is moved around. 
     * Parameters are : mouseX, mouseY, lastButtonClicked & 
     * timeSinceMouseClick.
     */
    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, 
          int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
     
    }

    //TODO Action Performed
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
    	this.recipeLogicChip = false;
		this.recipeWorkbench = false;
		this.recipeBalloon = false;
		this.recipeFrame = false;
		this.recipeEngine = false;
		this.recipeIgnition = false;
		
		this.recipeAirshipV1 = false;
		this.recipeAirshipV2 = false;
		this.recipeAirshipV3 = false;
		this.recipeAirshipV4 = false;
		
		this.recipeViesolinePellets = false;
		this.recipeDismounter = false;
		this.recipeDismounterPlayer = false;
		
		this.recipeUpgradeFrame0 = false;
		this.recipeUpgradeFrame1 = false;
		this.recipeUpgradeFrame2 = false;
		this.recipeUpgradeFrame3 = false;
		this.recipeUpgradeFrame4 = false;
		this.recipeUpgradeFrame5 = false;

		this.recipeUpgradeCore0 = false;
		this.recipeUpgradeCore1 = false;
		this.recipeUpgradeCore2 = false;
		this.recipeUpgradeCore3 = false;
		this.recipeUpgradeCore4 = false;
		this.recipeUpgradeCore5 = false;

		this.recipeUpgradeEngine0 = false;
		this.recipeUpgradeEngine1 = false;
		this.recipeUpgradeEngine2 = false;
		this.recipeUpgradeEngine3 = false;
		this.recipeUpgradeEngine4 = false;
		this.recipeUpgradeEngine5 = false;

		this.recipeUpgradeBalloon0 = false;
		this.recipeUpgradeBalloon1 = false;
		this.recipeUpgradeBalloon2 = false;
		this.recipeUpgradeBalloon3 = false;
		this.recipeUpgradeBalloon4 = false;
		this.recipeUpgradeBalloon5 = false;
		
		this.recipeModuleChip = false;
        this.recipeModuleAltitudeL = false;
        this.recipeModuleAltitudeN = false;
        this.recipeModuleAltitudeG = false;
        this.recipeModuleSpeedL = false;
        this.recipeModuleSpeedN = false;
        this.recipeModuleSpeedG = false;
        this.recipeModuleStorageL = false;
        this.recipeModuleStorageN = false;
        this.recipeModuleStorageG = false;
        this.recipeModuleFuelL = false;
        this.recipeModuleFuelN = false;
        this.recipeModuleFuelG = false;
        this.recipeModuleMusicL = false;
        this.recipeModuleMusicN = false;
        this.recipeModuleMusicG = false;
        this.recipeModuleCruiseL = false;
        this.recipeModuleCruiseN = false;
        this.recipeModuleCruiseG = false;
        this.recipeModuleWaterL = false;
        this.recipeModuleWaterN = false;
        this.recipeModuleWaterG = false;
        this.recipeModuleInfiniteFuelL = false;
        this.recipeModuleInfiniteFuelN = false;
        this.recipeModuleInfiniteFuelG = false;
		
		
		
		if (parButton == buttonRecipeLogicChip)
    	{
    		this.recipeLogicChip = true;
    	}
		if (parButton == buttonRecipeWorkbench)
    	{
    		this.recipeWorkbench = true;
    	}
    	if (parButton == buttonRecipeBalloon)
    	{
    		this.recipeBalloon = true;
    	}
    	if (parButton == buttonRecipeFrame)
    	{
    		this.recipeFrame = true;
    	}
    	if (parButton == buttonRecipeEngine)
    	{
    		this.recipeEngine = true;
    	}
    	if (parButton == buttonRecipeIgnition)
    	{
    		this.recipeIgnition = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeAirshipV1)
    	{
    		this.recipeAirshipV1 = true;
    	}
    	if (parButton == buttonRecipeAirshipV2)
    	{
    		this.recipeAirshipV2 = true;
    	}
    	if (parButton == buttonRecipeAirshipV3)
    	{
    		this.recipeAirshipV3 = true;
    	}
    	if (parButton == buttonRecipeAirshipV4)
    	{
    		this.recipeAirshipV4 = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeViesolinePellets)
    	{
    		this.recipeViesolinePellets = true;
    	}
    	if (parButton == buttonRecipeDismounter)
    	{
    		this.recipeDismounter = true;
    	}
    	if (parButton == buttonRecipeDismounterPlayer)
    	{
    		this.recipeDismounterPlayer = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeUpgradeFrame0)
    	{
    		this.recipeUpgradeFrame0 = true;
    	}
    	if (parButton == buttonRecipeUpgradeFrame1)
    	{
    		this.recipeUpgradeFrame1 = true;
    	}
    	if (parButton == buttonRecipeUpgradeFrame2)
    	{
    		this.recipeUpgradeFrame2 = true;
    	}
    	if (parButton == buttonRecipeUpgradeFrame3)
    	{
    		this.recipeUpgradeFrame3 = true;
    	}
    	if (parButton == buttonRecipeUpgradeFrame4)
    	{
    		this.recipeUpgradeFrame4 = true;
    	}
    	if (parButton == buttonRecipeUpgradeFrame5)
    	{
    		this.recipeUpgradeFrame5 = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeUpgradeCore0)
    	{
    		this.recipeUpgradeCore0 = true;
    	}
    	if (parButton == buttonRecipeUpgradeCore1)
    	{
    		this.recipeUpgradeCore1 = true;
    	}
    	if (parButton == buttonRecipeUpgradeCore2)
    	{
    		this.recipeUpgradeCore2 = true;
    	}
    	if (parButton == buttonRecipeUpgradeCore3)
    	{
    		this.recipeUpgradeCore3 = true;
    	}
    	if (parButton == buttonRecipeUpgradeCore4)
    	{
    		this.recipeUpgradeCore4 = true;
    	}
    	if (parButton == buttonRecipeUpgradeCore5)
    	{
    		this.recipeUpgradeCore5 = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeUpgradeEngine0)
    	{
    		this.recipeUpgradeEngine0 = true;
    	}
    	if (parButton == buttonRecipeUpgradeEngine1)
    	{
    		this.recipeUpgradeEngine1 = true;
    	}
    	if (parButton == buttonRecipeUpgradeEngine2)
    	{
    		this.recipeUpgradeEngine2 = true;
    	}
    	if (parButton == buttonRecipeUpgradeEngine3)
    	{
    		this.recipeUpgradeEngine3 = true;
    	}
    	if (parButton == buttonRecipeUpgradeEngine4)
    	{
    		this.recipeUpgradeEngine4 = true;
    	}
    	if (parButton == buttonRecipeUpgradeEngine5)
    	{
    		this.recipeUpgradeEngine5 = true;
    	}
    	
    	
    	
    	if (parButton == buttonRecipeUpgradeBalloon0)
    	{
    		this.recipeUpgradeBalloon0 = true;
    	}
    	if (parButton == buttonRecipeUpgradeBalloon1)
    	{
    		this.recipeUpgradeBalloon1 = true;
    	}
    	if (parButton == buttonRecipeUpgradeBalloon2)
    	{
    		this.recipeUpgradeBalloon2 = true;
    	}
    	if (parButton == buttonRecipeUpgradeBalloon3)
    	{
    		this.recipeUpgradeBalloon3 = true;
    	}
    	if (parButton == buttonRecipeUpgradeBalloon4)
    	{
    		this.recipeUpgradeBalloon4 = true;
    	}
    	if (parButton == buttonRecipeUpgradeBalloon5)
    	{
    		this.recipeUpgradeBalloon5 = true;
    	}
    	
    	
        
    	if (parButton == buttonRecipeModuleChip)
    	{
    		this.recipeModuleChip = true;
    	}
    	if (parButton == buttonRecipeModuleAltitudeL)
    	{
    		this.recipeModuleAltitudeL = true;
    	}
    	if (parButton == buttonRecipeModuleAltitudeN)
    	{
    		this.recipeModuleAltitudeN = true;
    	}
    	if (parButton == buttonRecipeModuleAltitudeG)
    	{
    		this.recipeModuleAltitudeG = true;
    	}
    	if (parButton == buttonRecipeModuleSpeedL)
    	{
    		this.recipeModuleSpeedL = true;
    	}
    	if (parButton == buttonRecipeModuleSpeedN)
    	{
    		this.recipeModuleSpeedN = true;
    	}
    	if (parButton == buttonRecipeModuleSpeedG)
    	{
    		this.recipeModuleSpeedG = true;
    	}
    	
    	if (parButton == buttonRecipeModuleStorageL)
    	{
    		this.recipeModuleStorageL = true;
    	}
    	if (parButton == buttonRecipeModuleStorageN)
    	{
    		this.recipeModuleStorageN = true;
    	}
    	if (parButton == buttonRecipeModuleStorageG)
    	{
    		this.recipeModuleStorageG = true;
    	}
    	if (parButton == buttonRecipeModuleFuelL)
    	{
    		this.recipeModuleFuelL = true;
    	}
    	if (parButton == buttonRecipeModuleFuelN)
    	{
    		this.recipeModuleFuelN = true;
    	}
    	if (parButton == buttonRecipeModuleFuelG)
    	{
    		this.recipeModuleFuelG = true;
    	}
    	
    	if (parButton == buttonRecipeModuleMusicL)
    	{
    		this.recipeModuleMusicL = true;
    	}
    	if (parButton == buttonRecipeModuleMusicN)
    	{
    		this.recipeModuleMusicN = true;
    	}
    	if (parButton == buttonRecipeModuleMusicG)
    	{
    		this.recipeModuleMusicG = true;
    	}
    	if (parButton == buttonRecipeModuleCruiseL)
    	{
    		this.recipeModuleCruiseL = true;
    	}
    	if (parButton == buttonRecipeModuleCruiseN)
    	{
    		this.recipeModuleCruiseN = true;
    	}
    	if (parButton == buttonRecipeModuleCruiseG)
    	{
    		this.recipeModuleCruiseG = true;
    	}
    	
    	if (parButton == buttonRecipeModuleWaterL)
    	{
    		this.recipeModuleWaterL = true;
    	}
    	if (parButton == buttonRecipeModuleWaterN)
    	{
    		this.recipeModuleWaterN = true;
    	}
    	if (parButton == buttonRecipeModuleWaterG)
    	{
    		this.recipeModuleWaterG = true;
    	}
    	if (parButton == buttonRecipeModuleInfiniteFuelL)
    	{
    		this.recipeModuleInfiniteFuelL = true;
    	}
    	if (parButton == buttonRecipeModuleInfiniteFuelN)
    	{
    		this.recipeModuleInfiniteFuelN = true;
    	}
    	if (parButton == buttonRecipeModuleInfiniteFuelG)
    	{
    		this.recipeModuleInfiniteFuelG = true;
    	}
    	
    	
    	
    	if(parButton == buttonMainTab1)
    	{
    		currPage = 1;
    		
    		if(currPage == 1)
    		{
	        	this.buttonRecipeLogicChip.enabled = false;
	        	this.recipeLogicChip = true;
    		}
    	}
    	if(parButton == buttonMainTab2)
    	{
    		currPage = 4;
    	}
    	if(parButton == buttonMainTab3)
    	{
    		currPage = 7;
    	}
    	if(parButton == buttonMainTab4)
    	{
    		currPage = 12;
    	}

    	if(parButton == buttonMainTab5)
    	{
    		currPage = 17;
    	}
    	
    	
    	
    	if (parButton == buttonDone)
    	{
		    mc.displayGuiScreen((GuiScreen)null);
		}
        else if (parButton == buttonNextPage)
        {
        	if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
    		
    		if(currPage == 1)
    		{
	        	this.buttonRecipeLogicChip.enabled = false;
	        	this.recipeLogicChip = true;
    		}
    		if(currPage == 2)
    		{
	        	this.buttonRecipeAirshipV1.enabled = false;
	        	this.recipeAirshipV1 = true;
    		}
    		if(currPage == 3)
    		{
	        	this.buttonRecipeViesolinePellets.enabled = false;
	        	this.recipeViesolinePellets = true;
    		}
    		if(currPage == 8)
    		{
	        	this.buttonRecipeUpgradeFrame0.enabled = false;
	        	this.recipeUpgradeFrame0 = true;
    		}
    		if(currPage == 9)
    		{
	        	this.buttonRecipeUpgradeCore0.enabled = false;
	        	this.recipeUpgradeCore0 = true;
    		}
    		if(currPage == 10)
    		{
	        	this.buttonRecipeUpgradeEngine0.enabled = false;
	        	this.recipeUpgradeEngine0 = true;
    		}
    		if(currPage == 11)
    		{
	        	this.buttonRecipeUpgradeBalloon0.enabled = false;
	        	this.recipeUpgradeBalloon0 = true;
    		}
    		if(currPage == 13)
    		{
	        	this.buttonRecipeModuleChip.enabled = false;
	        	this.recipeModuleChip = true;
    		}
    		if(currPage == 14)
    		{
	        	this.buttonRecipeModuleStorageL.enabled = false;
	        	this.recipeModuleStorageL = true;
    		}
    		if(currPage == 15)
    		{
	        	this.buttonRecipeModuleMusicL.enabled = false;
	        	this.recipeModuleMusicL = true;
    		}
    		if(currPage == 16)
    		{
	        	this.buttonRecipeModuleWaterL.enabled = false;
	        	this.recipeModuleWaterL = true;
    		}
        }
        else if (parButton == buttonPreviousPage)
        {
        	if (currPage > 0)
            {
                --currPage;
            }
    		
    		if(currPage == 1)
    		{
	        	this.buttonRecipeLogicChip.enabled = false;
	        	this.recipeLogicChip = true;
    		}
    		if(currPage == 2)
    		{
	        	this.buttonRecipeAirshipV1.enabled = false;
	        	this.recipeAirshipV1 = true;
    		}
    		if(currPage == 3)
    		{
	        	this.buttonRecipeViesolinePellets.enabled = false;
	        	this.recipeViesolinePellets = true;
    		}
    		if(currPage == 8)
    		{
	        	this.buttonRecipeUpgradeFrame0.enabled = false;
	        	this.recipeUpgradeFrame0 = true;
    		}
    		if(currPage == 9)
    		{
	        	this.buttonRecipeUpgradeCore0.enabled = false;
	        	this.recipeUpgradeCore0 = true;
    		}
    		if(currPage == 10)
    		{
	        	this.buttonRecipeUpgradeEngine0.enabled = false;
	        	this.recipeUpgradeEngine0 = true;
    		}
    		if(currPage == 11)
    		{
	        	this.buttonRecipeUpgradeBalloon0.enabled = false;
	        	this.recipeUpgradeBalloon0 = true;
    		}
    		if(currPage == 13)
    		{
	        	this.buttonRecipeModuleChip.enabled = false;
	        	this.recipeModuleChip = true;
    		}
    		if(currPage == 14)
    		{
	        	this.buttonRecipeModuleStorageL.enabled = false;
	        	this.recipeModuleStorageL = true;
    		}
    		if(currPage == 15)
    		{
	        	this.buttonRecipeModuleMusicL.enabled = false;
	        	this.recipeModuleMusicL = true;
    		}
    		if(currPage == 16)
    		{
	        	this.buttonRecipeModuleWaterL.enabled = false;
	        	this.recipeModuleWaterL = true;
    		}
        }
    	
    	
    	
    	this.buttonRecipeLogicChip.enabled = true;
		this.buttonRecipeWorkbench.enabled = true;
		this.buttonRecipeBalloon.enabled = true;
		this.buttonRecipeFrame.enabled = true;
		this.buttonRecipeEngine.enabled = true;
		this.buttonRecipeIgnition.enabled = true;
		
		this.buttonRecipeAirshipV1.enabled = true;
		this.buttonRecipeAirshipV2.enabled = true;
		this.buttonRecipeAirshipV3.enabled = true;
		this.buttonRecipeAirshipV4.enabled = true;
		
		this.buttonRecipeViesolinePellets.enabled = true;
		this.buttonRecipeDismounter.enabled = true;
		this.buttonRecipeDismounterPlayer.enabled = true;
		
		this.buttonRecipeUpgradeFrame0.enabled = true;
		this.buttonRecipeUpgradeFrame1.enabled = true;
		this.buttonRecipeUpgradeFrame2.enabled = true;
		this.buttonRecipeUpgradeFrame3.enabled = true;
		this.buttonRecipeUpgradeFrame4.enabled = true;
		this.buttonRecipeUpgradeFrame5.enabled = true;

		this.buttonRecipeUpgradeCore0.enabled = true;
		this.buttonRecipeUpgradeCore1.enabled = true;
		this.buttonRecipeUpgradeCore2.enabled = true;
		this.buttonRecipeUpgradeCore3.enabled = true;
		this.buttonRecipeUpgradeCore4.enabled = true;
		this.buttonRecipeUpgradeCore5.enabled = true;

		this.buttonRecipeUpgradeEngine0.enabled = true;
		this.buttonRecipeUpgradeEngine1.enabled = true;
		this.buttonRecipeUpgradeEngine2.enabled = true;
		this.buttonRecipeUpgradeEngine3.enabled = true;
		this.buttonRecipeUpgradeEngine4.enabled = true;
		this.buttonRecipeUpgradeEngine5.enabled = true;

		this.buttonRecipeUpgradeBalloon0.enabled = true;
		this.buttonRecipeUpgradeBalloon1.enabled = true;
		this.buttonRecipeUpgradeBalloon2.enabled = true;
		this.buttonRecipeUpgradeBalloon3.enabled = true;
		this.buttonRecipeUpgradeBalloon4.enabled = true;
		this.buttonRecipeUpgradeBalloon5.enabled = true;
		
		this.buttonRecipeModuleChip.enabled = true;
        this.buttonRecipeModuleAltitudeL.enabled = true;
        this.buttonRecipeModuleAltitudeN.enabled = true;
        this.buttonRecipeModuleAltitudeG.enabled = true;
        this.buttonRecipeModuleSpeedL.enabled = true;
        this.buttonRecipeModuleSpeedN.enabled = true;
        this.buttonRecipeModuleSpeedG.enabled = true;
        this.buttonRecipeModuleStorageL.enabled = true;
        this.buttonRecipeModuleStorageN.enabled = true;
        this.buttonRecipeModuleStorageG.enabled = true;
        this.buttonRecipeModuleFuelL.enabled = true;
        this.buttonRecipeModuleFuelN.enabled = true;
        this.buttonRecipeModuleFuelG.enabled = true;
        this.buttonRecipeModuleMusicL.enabled = true;
        this.buttonRecipeModuleMusicN.enabled = true;
        this.buttonRecipeModuleMusicG.enabled = true;
        this.buttonRecipeModuleCruiseL.enabled = true;
        this.buttonRecipeModuleCruiseN.enabled = true;
        this.buttonRecipeModuleCruiseG.enabled = true;
        this.buttonRecipeModuleWaterL.enabled = true;
        this.buttonRecipeModuleWaterN.enabled = true;
        this.buttonRecipeModuleWaterG.enabled = true;
        this.buttonRecipeModuleInfiniteFuelL.enabled = true;
        this.buttonRecipeModuleInfiniteFuelN.enabled = true;
        this.buttonRecipeModuleInfiniteFuelG.enabled = true;
		
		
		
		if(this.recipeLogicChip)
    	{
    		this.buttonRecipeLogicChip.enabled = false;
    	}
		if(this.recipeWorkbench)
    	{
    		this.buttonRecipeWorkbench.enabled = false;
    	}
		if(this.recipeBalloon)
    	{
    		this.buttonRecipeBalloon.enabled = false;
    	}
		if(this.recipeFrame)
    	{
    		this.buttonRecipeFrame.enabled = false;
    	}
		if(this.recipeEngine)
    	{
    		this.buttonRecipeEngine.enabled = false;
    	}
		if(this.recipeIgnition)
    	{
    		this.buttonRecipeIgnition.enabled = false;
    	}
		
		if(this.recipeAirshipV1)
    	{
    		this.buttonRecipeAirshipV1.enabled = false;
    	}
		if(this.recipeAirshipV2)
    	{
    		this.buttonRecipeAirshipV2.enabled = false;
    	}
		if(this.recipeAirshipV3)
    	{
    		this.buttonRecipeAirshipV3.enabled = false;
    	}
		if(this.recipeAirshipV4)
    	{
    		this.buttonRecipeAirshipV4.enabled = false;
    	}
		
		
		if(this.recipeViesolinePellets)
    	{
    		this.buttonRecipeViesolinePellets.enabled = false;
    	}
		if(this.recipeDismounter)
    	{
    		this.buttonRecipeDismounter.enabled = false;
    	}
		if(this.recipeDismounterPlayer)
    	{
    		this.buttonRecipeDismounterPlayer.enabled = false;
    	}
		
		if(this.recipeUpgradeFrame0)
    	{
    		this.buttonRecipeUpgradeFrame0.enabled = false;
    	}
		if(this.recipeUpgradeFrame1)
    	{
    		this.buttonRecipeUpgradeFrame1.enabled = false;
    	}
		if(this.recipeUpgradeFrame2)
    	{
    		this.buttonRecipeUpgradeFrame2.enabled = false;
    	}
		if(this.recipeUpgradeFrame3)
    	{
    		this.buttonRecipeUpgradeFrame3.enabled = false;
    	}
		if(this.recipeUpgradeFrame4)
    	{
    		this.buttonRecipeUpgradeFrame4.enabled = false;
    	}
		if(this.recipeUpgradeFrame5)
    	{
    		this.buttonRecipeUpgradeFrame5.enabled = false;
    	}
		
		if(this.recipeUpgradeCore0)
    	{
    		this.buttonRecipeUpgradeCore0.enabled = false;
    	}
		if(this.recipeUpgradeCore1)
    	{
    		this.buttonRecipeUpgradeCore1.enabled = false;
    	}
		if(this.recipeUpgradeCore2)
    	{
    		this.buttonRecipeUpgradeCore2.enabled = false;
    	}
		if(this.recipeUpgradeCore3)
    	{
    		this.buttonRecipeUpgradeCore3.enabled = false;
    	}
		if(this.recipeUpgradeCore4)
    	{
    		this.buttonRecipeUpgradeCore4.enabled = false;
    	}
		if(this.recipeUpgradeCore5)
    	{
    		this.buttonRecipeUpgradeCore5.enabled = false;
    	}
		
		if(this.recipeUpgradeEngine0)
    	{
    		this.buttonRecipeUpgradeEngine0.enabled = false;
    	}
		if(this.recipeUpgradeEngine1)
    	{
    		this.buttonRecipeUpgradeEngine1.enabled = false;
    	}
		if(this.recipeUpgradeEngine2)
    	{
    		this.buttonRecipeUpgradeEngine2.enabled = false;
    	}
		if(this.recipeUpgradeEngine3)
    	{
    		this.buttonRecipeUpgradeEngine3.enabled = false;
    	}
		if(this.recipeUpgradeEngine4)
    	{
    		this.buttonRecipeUpgradeEngine4.enabled = false;
    	}
		if(this.recipeUpgradeEngine5)
    	{
    		this.buttonRecipeUpgradeEngine5.enabled = false;
    	}
		
		if(this.recipeUpgradeBalloon0)
    	{
    		this.buttonRecipeUpgradeBalloon0.enabled = false;
    	}
		if(this.recipeUpgradeBalloon1)
    	{
    		this.buttonRecipeUpgradeBalloon1.enabled = false;
    	}
		if(this.recipeUpgradeBalloon2)
    	{
    		this.buttonRecipeUpgradeBalloon2.enabled = false;
    	}
		if(this.recipeUpgradeBalloon3)
    	{
    		this.buttonRecipeUpgradeBalloon3.enabled = false;
    	}
		if(this.recipeUpgradeBalloon4)
    	{
    		this.buttonRecipeUpgradeBalloon4.enabled = false;
    	}
		if(this.recipeUpgradeBalloon5)
    	{
    		this.buttonRecipeUpgradeBalloon5.enabled = false;
    	}
		
		if(this.recipeModuleChip)
    	{
    		this.buttonRecipeModuleChip.enabled = false;
    	}
		if(this.recipeModuleAltitudeL)
    	{
    		this.buttonRecipeModuleAltitudeL.enabled = false;
    	}
		if(this.recipeModuleAltitudeN)
    	{
    		this.buttonRecipeModuleAltitudeN.enabled = false;
    	}
		if(this.recipeModuleAltitudeG)
    	{
    		this.buttonRecipeModuleAltitudeG.enabled = false;
    	}
		if(this.recipeModuleSpeedL)
    	{
    		this.buttonRecipeModuleSpeedL.enabled = false;
    	}
		if(this.recipeModuleSpeedN)
    	{
    		this.buttonRecipeModuleSpeedN.enabled = false;
    	}
		if(this.recipeModuleSpeedG)
    	{
    		this.buttonRecipeModuleSpeedG.enabled = false;
    	}
		
		if(this.recipeModuleStorageL)
    	{
    		this.buttonRecipeModuleStorageL.enabled = false;
    	}
		if(this.recipeModuleStorageN)
    	{
    		this.buttonRecipeModuleStorageN.enabled = false;
    	}
		if(this.recipeModuleStorageG)
    	{
    		this.buttonRecipeModuleStorageG.enabled = false;
    	}
		if(this.recipeModuleFuelL)
    	{
    		this.buttonRecipeModuleFuelL.enabled = false;
    	}
		if(this.recipeModuleFuelN)
    	{
    		this.buttonRecipeModuleFuelN.enabled = false;
    	}
		if(this.recipeModuleFuelG)
    	{
    		this.buttonRecipeModuleFuelG.enabled = false;
    	}
		
		if(this.recipeModuleMusicL)
    	{
    		this.buttonRecipeModuleMusicL.enabled = false;
    	}
		if(this.recipeModuleMusicN)
    	{
    		this.buttonRecipeModuleMusicN.enabled = false;
    	}
		if(this.recipeModuleMusicG)
    	{
    		this.buttonRecipeModuleMusicG.enabled = false;
    	}
		if(this.recipeModuleCruiseL)
    	{
    		this.buttonRecipeModuleCruiseL.enabled = false;
    	}
		if(this.recipeModuleCruiseN)
    	{
    		this.buttonRecipeModuleCruiseN.enabled = false;
    	}
		if(this.recipeModuleCruiseG)
    	{
    		this.buttonRecipeModuleCruiseG.enabled = false;
    	}
		
		if(this.recipeModuleWaterL)
    	{
    		this.buttonRecipeModuleWaterL.enabled = false;
    	}
		if(this.recipeModuleWaterN)
    	{
    		this.buttonRecipeModuleWaterN.enabled = false;
    	}
		if(this.recipeModuleWaterG)
    	{
    		this.buttonRecipeModuleWaterG.enabled = false;
    	}
		if(this.recipeModuleInfiniteFuelL)
    	{
    		this.buttonRecipeModuleInfiniteFuelL.enabled = false;
    	}
		if(this.recipeModuleInfiniteFuelN)
    	{
    		this.buttonRecipeModuleInfiniteFuelN.enabled = false;
    	}
		if(this.recipeModuleInfiniteFuelG)
    	{
    		this.buttonRecipeModuleInfiniteFuelG.enabled = false;
    	}
   }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat 
     * events
     */
    @Override
    public void onGuiClosed() 
    {
     
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;//true;
    }
    
    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, 
              boolean parIsNextButton)
        {
            super(parButtonId, parPosX + 37, parPosY + 28, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY, float partialTicks)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= x 
                      && parY >= y 
                      && parX < x + width 
                      && parY < y + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed)
                {
                    textureX += 23;
                }

                if (!isNextButton)
                {
                    textureY += 13;
                }
                
                //Draws the arrows for the next/prev pages
                drawTexturedModalRect(x, y, 
                      textureX, textureY, 
                      23, 13);
            }
        }
    }


    
    
    
    //TODO Recipes
    private void getRecipeMain(int offsetFromScreenLeftIn)
    {
    	if(this.recipeLogicChip)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[1], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.recipeWorkbench)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[2], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.recipeBalloon)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[3], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.recipeFrame)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[4], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.recipeEngine)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[5], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		if(this.recipeIgnition)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[6], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeAirship(int offsetFromScreenLeftIn)
    {
    	//AirshipV1
		if(this.recipeAirshipV1)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[7], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//AirshipV2
		if(this.recipeAirshipV2)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[8], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//AirshipV3
		if(this.recipeAirshipV3)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[9], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//AirshipV4
		if(this.recipeAirshipV4)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[10], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeMisc(int offsetFromScreenLeftIn)
    {
    	//Viesoline Pellets
		if(this.recipeViesolinePellets)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[11], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Dismounter
		if(this.recipeDismounter)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[12], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Dismounter Player
		if(this.recipeDismounterPlayer)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[13], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeFrame(int offsetFromScreenLeftIn)
    {
		//Frame Casing
		if(this.recipeUpgradeFrame0)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[14], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Frame Upgrade 1
		if(this.recipeUpgradeFrame1)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
		
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[15], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Frame Upgrade 2
		if(this.recipeUpgradeFrame2)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[16], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Frame Upgrade 3
		if(this.recipeUpgradeFrame3)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[17], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Frame Upgrade 4
		if(this.recipeUpgradeFrame4)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[18], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Frame Upgrade 5
		if(this.recipeUpgradeFrame5)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[19], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeCore(int offsetFromScreenLeftIn)
    {
		//Core Shard
		if(this.recipeUpgradeCore0)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[20], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Core Upgrade 1
		if(this.recipeUpgradeCore1)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[21], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Core Upgrade 2
		if(this.recipeUpgradeCore2)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[22], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Core Upgrade 3
		if(this.recipeUpgradeCore3)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[23], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Core Upgrade 4
		if(this.recipeUpgradeCore4)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[24], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Core Upgrade 5
		if(this.recipeUpgradeCore5)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[25], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeEngine(int offsetFromScreenLeftIn)
    {
		//Engine Fragment
		if(this.recipeUpgradeEngine0)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[26], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Engine Upgrade 1
		if(this.recipeUpgradeEngine1)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[27], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Engine Upgrade 2
		if(this.recipeUpgradeEngine2)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[28], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Engine Upgrade 3
		if(this.recipeUpgradeEngine3)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[29], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Engine Upgrade 4
		if(this.recipeUpgradeEngine4)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[30], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Engine Upgrade 5
		if(this.recipeUpgradeEngine5)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[31], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeBalloon(int offsetFromScreenLeftIn)
    {
		//Balloon Remnant
		if(this.recipeUpgradeBalloon0)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[32], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon Upgrade 1
		if(this.recipeUpgradeBalloon1)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[33], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon Upgrade 2
		if(this.recipeUpgradeBalloon2)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[34], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon Upgrade 3
		if(this.recipeUpgradeBalloon3)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[35], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon Upgrade 4
		if(this.recipeUpgradeBalloon4)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[36], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon Upgrade 5
		if(this.recipeUpgradeBalloon5)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[37], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
    
    private void getRecipeModule1(int offsetFromScreenLeftIn)
    {
    	this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesmodule1.png"));
		
    	//Module Chip
		if(this.recipeModuleChip)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0) - 28, 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[38], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Lesser Altitude
		if(this.recipeModuleAltitudeL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[39], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Altitude
		if(this.recipeModuleAltitudeN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[40], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Altitude
		if(this.recipeModuleAltitudeG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[41], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Lesser Speed
		if(this.recipeModuleSpeedL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[42], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Speed
		if(this.recipeModuleSpeedN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[43], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Speed
		if(this.recipeModuleSpeedG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[44], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
    private void getRecipeModule2(int offsetFromScreenLeftIn)
    {
    	this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesmodule2.png"));
		
		//Lesser Storage
		if(this.recipeModuleStorageL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[45], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Storage
		if(this.recipeModuleStorageN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[46], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Storage
		if(this.recipeModuleStorageG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[47], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Lesser Fuel
		if(this.recipeModuleFuelL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 0), 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[48], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Fuel
		if(this.recipeModuleFuelN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[49], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Fuel
		if(this.recipeModuleFuelG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[50], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
    private void getRecipeModule3(int offsetFromScreenLeftIn)
    {
    	this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesmodule3.png"));
		
		//Lesser Music
		if(this.recipeModuleMusicL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[51], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Music
		if(this.recipeModuleMusicN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[52], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Music
		if(this.recipeModuleMusicG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[53], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Lesser Cruise
		if(this.recipeModuleCruiseL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 0), 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[54], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Cruise
		if(this.recipeModuleCruiseN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[55], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Cruise
		if(this.recipeModuleCruiseG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[56], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
	
    private void getRecipeModule4(int offsetFromScreenLeftIn)
    {
    	this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/guides/main/recipesmodule4.png"));
		
		//Lesser Water
		if(this.recipeModuleWaterL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 0), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[57], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Water
		if(this.recipeModuleWaterN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 1), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[58], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater Water
		if(this.recipeModuleWaterG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0, 0 + (54 * 2), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 2), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[59], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Lesser InfiniteFuel
		if(this.recipeModuleInfiniteFuelL)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 0), 0 + (54 * 3), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 3), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[60], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//InfiniteFuel
		if(this.recipeModuleInfiniteFuelN)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 0), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 4), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[61], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Greater InfiniteFuel
		if(this.recipeModuleInfiniteFuelG)
		{
			//Draw recipe
			this.drawTexturedModalRect(this.guiLeft + 102, 106, 0 + (92 * 1), 0 + (54 * 1), 92, 54);
			
			//Draw Green Arrow
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(this.guiLeft + 64, 77 + (14 * 5), 0);
				this.drawTexturedModalRect(0, 0, 242, 0 + (13 * 0), 14, 13);
			}
			GlStateManager.popMatrix();
			
			//Draw Info text on the right page
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(offsetFromScreenLeftIn + 138, 32, 0);
				GlStateManager.scale(.5, .5, .5);
				
				fontRenderer.drawSplitString(stringPageTextRightTooltip[62], 0, 0, 196, 0);
			}
			GlStateManager.popMatrix();
		}
    }
}

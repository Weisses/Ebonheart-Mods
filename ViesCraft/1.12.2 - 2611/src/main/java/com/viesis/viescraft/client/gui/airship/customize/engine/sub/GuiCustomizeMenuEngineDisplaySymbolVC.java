package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGeneralVC;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.balloon.sub.MessageHelperGuiCustomizeMenuBalloonTier;
import com.viesis.viescraft.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplaySymbols;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineDisplaySymbolVC extends GuiContainerVC {
	
	private ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuEngineDisplaySymbolVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
		
		this.metaInfo = this.airship.engineDisplayIDVisual;
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
    	
		GuiVC.button502 = new GuiButtonGeneralVC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVC.button503 = new GuiButtonGeneralVC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneralVC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVC.button501 = new GuiButtonGeneralVC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	
    	//Symbols Pg1
    	GuiVC.button06 = new GuiButtonGeneralVC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.6"), 0);
		GuiVC.button07 = new GuiButtonGeneralVC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.7"), 0);
		GuiVC.button08 = new GuiButtonGeneralVC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.8"), 0);
		GuiVC.button09 = new GuiButtonGeneralVC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.9"), 0);
		GuiVC.button10 = new GuiButtonGeneralVC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.10"), 0);
		GuiVC.button11 = new GuiButtonGeneralVC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.11"), 0);
		
		GuiVC.button12 = new GuiButtonGeneralVC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.12"), 0);
		GuiVC.button13 = new GuiButtonGeneralVC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.13"), 0);
		GuiVC.button14 = new GuiButtonGeneralVC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.14"), 0);
		GuiVC.button15 = new GuiButtonGeneralVC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.15"), 0);
		GuiVC.button16 = new GuiButtonGeneralVC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.16"), 0);
		GuiVC.button17 = new GuiButtonGeneralVC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.17"), 0);
		
		//--------------------------------------
		
		//Symbols Pg2
		GuiVC.button18 = new GuiButtonGeneralVC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.18"), 0);
		GuiVC.button19 = new GuiButtonGeneralVC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.19"), 0);
		GuiVC.button20 = new GuiButtonGeneralVC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.20"), 0);
		GuiVC.button21 = new GuiButtonGeneralVC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.21"), 0);
		GuiVC.button22 = new GuiButtonGeneralVC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVC.button23 = new GuiButtonGeneralVC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		
		GuiVC.button24 = new GuiButtonGeneralVC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		GuiVC.button25 = new GuiButtonGeneralVC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVC.button26 = new GuiButtonGeneralVC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVC.button27 = new GuiButtonGeneralVC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		GuiVC.button28 = new GuiButtonGeneralVC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVC.button29 = new GuiButtonGeneralVC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		
		//--------------------------------------
		
		//Symbols Pg3
		GuiVC.button30 = new GuiButtonGeneralVC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVC.button31 = new GuiButtonGeneralVC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVC.button32 = new GuiButtonGeneralVC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVC.button33 = new GuiButtonGeneralVC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		GuiVC.button34 = new GuiButtonGeneralVC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVC.button35 = new GuiButtonGeneralVC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		
		GuiVC.button36 = new GuiButtonGeneralVC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		GuiVC.button37 = new GuiButtonGeneralVC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVC.button38 = new GuiButtonGeneralVC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVC.button39 = new GuiButtonGeneralVC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		GuiVC.button40 = new GuiButtonGeneralVC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVC.button41 = new GuiButtonGeneralVC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		
		//--------------------------------------
		
		//Symbols Pg4
		GuiVC.button42 = new GuiButtonGeneralVC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVC.button43 = new GuiButtonGeneralVC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVC.button44 = new GuiButtonGeneralVC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVC.button45 = new GuiButtonGeneralVC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		GuiVC.button46 = new GuiButtonGeneralVC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVC.button47 = new GuiButtonGeneralVC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		
		GuiVC.button48 = new GuiButtonGeneralVC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
		GuiVC.button49 = new GuiButtonGeneralVC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.49"), 0);
		GuiVC.button50 = new GuiButtonGeneralVC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.50"), 0);
		GuiVC.button51 = new GuiButtonGeneralVC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.51"), 0);
		GuiVC.button52 = new GuiButtonGeneralVC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.52"), 0);
		GuiVC.button53 = new GuiButtonGeneralVC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.53"), 0);
		
		//--------------------------------------
		
		
		
		//Holiday Symbols
		//Easter
		GuiVC.buttonEDH01 = new GuiButtonGeneralVC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.1"), 0);
		GuiVC.buttonEDH02 = new GuiButtonGeneralVC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.2"), 0);
		GuiVC.buttonEDH03 = new GuiButtonGeneralVC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.3"), 0);
		GuiVC.buttonEDH04 = new GuiButtonGeneralVC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.4"), 0);
		GuiVC.buttonEDH05 = new GuiButtonGeneralVC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.5"), 0);
		GuiVC.buttonEDH06 = new GuiButtonGeneralVC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.6"), 0);
		GuiVC.buttonEDH07 = new GuiButtonGeneralVC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.7"), 0);
		GuiVC.buttonEDH08 = new GuiButtonGeneralVC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.8"), 0);
		GuiVC.buttonEDH09 = new GuiButtonGeneralVC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.9"), 0);
		GuiVC.buttonEDH10 = new GuiButtonGeneralVC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.10"), 0);
		GuiVC.buttonEDH11 = new GuiButtonGeneralVC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.11"), 0);
		GuiVC.buttonEDH12 = new GuiButtonGeneralVC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.12"), 0);
		//4th of July
		GuiVC.buttonEDH13 = new GuiButtonGeneralVC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.13"), 0);
		GuiVC.buttonEDH14 = new GuiButtonGeneralVC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.14"), 0);
		GuiVC.buttonEDH15 = new GuiButtonGeneralVC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.15"), 0);
		GuiVC.buttonEDH16 = new GuiButtonGeneralVC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.16"), 0);
		GuiVC.buttonEDH17 = new GuiButtonGeneralVC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.17"), 0);
		GuiVC.buttonEDH18 = new GuiButtonGeneralVC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.18"), 0);
		GuiVC.buttonEDH19 = new GuiButtonGeneralVC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.19"), 0);
		GuiVC.buttonEDH20 = new GuiButtonGeneralVC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.20"), 0);
		GuiVC.buttonEDH21 = new GuiButtonGeneralVC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.21"), 0);
		GuiVC.buttonEDH22 = new GuiButtonGeneralVC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVC.buttonEDH23 = new GuiButtonGeneralVC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		GuiVC.buttonEDH24 = new GuiButtonGeneralVC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		//Halloween
		GuiVC.buttonEDH25 = new GuiButtonGeneralVC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVC.buttonEDH26 = new GuiButtonGeneralVC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVC.buttonEDH27 = new GuiButtonGeneralVC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		GuiVC.buttonEDH28 = new GuiButtonGeneralVC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVC.buttonEDH29 = new GuiButtonGeneralVC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		GuiVC.buttonEDH30 = new GuiButtonGeneralVC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVC.buttonEDH31 = new GuiButtonGeneralVC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVC.buttonEDH32 = new GuiButtonGeneralVC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVC.buttonEDH33 = new GuiButtonGeneralVC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		GuiVC.buttonEDH34 = new GuiButtonGeneralVC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVC.buttonEDH35 = new GuiButtonGeneralVC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		GuiVC.buttonEDH36 = new GuiButtonGeneralVC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		//Christmas
		GuiVC.buttonEDH37 = new GuiButtonGeneralVC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVC.buttonEDH38 = new GuiButtonGeneralVC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVC.buttonEDH39 = new GuiButtonGeneralVC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		GuiVC.buttonEDH40 = new GuiButtonGeneralVC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVC.buttonEDH41 = new GuiButtonGeneralVC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		GuiVC.buttonEDH42 = new GuiButtonGeneralVC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVC.buttonEDH43 = new GuiButtonGeneralVC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVC.buttonEDH44 = new GuiButtonGeneralVC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVC.buttonEDH45 = new GuiButtonGeneralVC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		GuiVC.buttonEDH46 = new GuiButtonGeneralVC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVC.buttonEDH47 = new GuiButtonGeneralVC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		GuiVC.buttonEDH48 = new GuiButtonGeneralVC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
		
		
		
		
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 502)
	    {
			//this.metaInfo = 0;
			//NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonTier());
	    }
		if (parButton.id == 503)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg2());
	    }
		if (parButton.id == 504)
	    {
			//NetworkHandler.sendToServer(new MessageGuiCustomizeMenuBalloonTier1Pg1());
	    }
		if (parButton.id == 505)
	    {
			NetworkHandler.sendToServer(new MessageGuiCustomizeMenuEngineMain());
	    }
		if (parButton.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuBalloonTier());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplaySymbols());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 107, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToGolden("Stored Redstone", 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.RED;
		
		if(this.airship.storedRedstone >= 500)
		{
			redstoneColor = Color.CYAN;
		}
		else if(this.airship.storedRedstone >= 375)
		{
			redstoneColor = Color.GREEN;
		}
		else if(this.airship.storedRedstone >= 250)
		{
			redstoneColor = Color.YELLOW;
		}
		else if(this.airship.storedRedstone >= 125)
		{
			redstoneColor = Color.ORANGE;
		}
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 127, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstone()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134.25, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, "/", 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 142, this.guiTop + 113.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(this.airship.getStoredRedstoneTotal()), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		
		if(this.airship.storedRedstone >= CostsVC.BALLOON_PATTERN_TEXTURE_COST)
		{
			GuiVC.button501.enabled = true;
		}
		else
		{
			GuiVC.button501.enabled = false;
		}
		
		this.drawRotatingItemStack(new ItemStack(ItemsVC.ITEM_DISPLAY_SYMBOL, 1, metaInfo), this.guiLeft + 134, this.guiTop + 70);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Cost tooltip
		if(mouseX >= this.guiLeft + 12 && mouseX <= this.guiLeft + 87
		&& mouseY >= this.guiTop + 22 && mouseY <= this.guiTop + 189)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.FRAME_SKIN_TEXTURE_COST + " Redstone"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Reset tooltip
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 157
		&& mouseY >= this.guiTop + 143 && mouseY <= this.guiTop + 156)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Default skin, costs nothing!"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.2"));
			//text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("vc.gui.tt.core.3"));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 38, mouseY - this.guiTop - 8, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
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

        if (!this.mc.player.isEntityAlive() || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
}

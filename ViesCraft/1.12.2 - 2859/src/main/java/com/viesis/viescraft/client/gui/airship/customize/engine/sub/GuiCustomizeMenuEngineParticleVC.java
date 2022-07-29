package com.viesis.viescraft.client.gui.airship.customize.engine.sub;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.CostsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.client.gui.GuiContainerVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral2VC;
import com.viesis.viescraft.common.entity.airships.EntityAirshipCore;
import com.viesis.viescraft.common.entity.airships.containers.all.ContainerCustomizeMenu;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.customize.engine.MessageGuiCustomizeMenuEngineMain;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayParticle;
import com.viesis.viescraft.network.server.airship.customize.engine.sub.MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderGlobal;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiCustomizeMenuEngineParticleVC extends GuiContainerVC {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_customize_menu_3.png");
	
	public int startPlaceLeft = 12;
	public int startPlaceTop = 22;
	
	public GuiCustomizeMenuEngineParticleVC(IInventory playerInv, EntityAirshipCore airshipIn)
	{
		super(new ContainerCustomizeMenu(playerInv, airshipIn), playerInv, airshipIn);
		
		this.metaInfo = this.airship.engineParticleVisual;
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
    	
		GuiVC.button502 = new GuiButtonGeneral2VC(502, this.guiLeft + 110, this.guiTop + 143, 48, 14, References.localNameVC("vc.button.default"), 1);
    	GuiVC.button503 = new GuiButtonGeneral1VC(503, this.guiLeft + 126, this.guiTop - 13, 48, 14, References.localNameVC("vc.button.next"), 3);
    	GuiVC.button505 = new GuiButtonGeneral1VC(505, this.guiLeft + 125, this.guiTop + 177, 40, 14, References.localNameVC("vc.button.back"), 2);
    	GuiVC.button501 = new GuiButtonGeneral1VC(501, this.guiLeft + 110, this.guiTop + 125, 48, 14, References.localNameVC("vc.button.apply"), 1);
    	
    	//Symbols Pg1
    	GuiVC.button01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.engineparticle.1"), 0);
		GuiVC.button02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.engineparticle.2"), 0);
		GuiVC.button03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.engineparticle.3"), 0);
		GuiVC.button04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.engineparticle.4"), 0);
		GuiVC.button05 = new GuiButtonGeneral1VC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.engineparticle.5"), 0);
		GuiVC.button06 = new GuiButtonGeneral1VC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.engineparticle.6"), 0);
		
		GuiVC.button07 = new GuiButtonGeneral1VC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.engineparticle.7"), 0);
		GuiVC.button08 = new GuiButtonGeneral1VC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.engineparticle.8"), 0);
		GuiVC.button09 = new GuiButtonGeneral1VC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.engineparticle.9"), 0);
		GuiVC.button10 = new GuiButtonGeneral1VC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.engineparticle.10"), 0);
		GuiVC.button11 = new GuiButtonGeneral1VC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.engineparticle.11"), 0);
		GuiVC.button12 = new GuiButtonGeneral1VC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.engineparticle.12"), 0);
		
		//--------------------------------------
		/**
		//Symbols Pg2
		GuiVC.button22 = new GuiButtonGeneral1VC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVC.button23 = new GuiButtonGeneral1VC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		GuiVC.button24 = new GuiButtonGeneral1VC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		GuiVC.button25 = new GuiButtonGeneral1VC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVC.button26 = new GuiButtonGeneral1VC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVC.button27 = new GuiButtonGeneral1VC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		
		GuiVC.button28 = new GuiButtonGeneral1VC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVC.button29 = new GuiButtonGeneral1VC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		GuiVC.button30 = new GuiButtonGeneral1VC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVC.button31 = new GuiButtonGeneral1VC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVC.button32 = new GuiButtonGeneral1VC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVC.button33 = new GuiButtonGeneral1VC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		
		//--------------------------------------
		
		//Symbols Pg3
		GuiVC.button34 = new GuiButtonGeneral1VC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVC.button35 = new GuiButtonGeneral1VC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		GuiVC.button36 = new GuiButtonGeneral1VC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		GuiVC.button37 = new GuiButtonGeneral1VC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVC.button38 = new GuiButtonGeneral1VC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVC.button39 = new GuiButtonGeneral1VC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		
		GuiVC.button40 = new GuiButtonGeneral1VC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVC.button41 = new GuiButtonGeneral1VC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		GuiVC.button42 = new GuiButtonGeneral1VC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVC.button43 = new GuiButtonGeneral1VC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVC.button44 = new GuiButtonGeneral1VC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVC.button45 = new GuiButtonGeneral1VC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		
		//--------------------------------------
		
		//Symbols Pg4
		GuiVC.button46 = new GuiButtonGeneral1VC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVC.button47 = new GuiButtonGeneral1VC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		GuiVC.button48 = new GuiButtonGeneral1VC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
		GuiVC.button49 = new GuiButtonGeneral1VC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.49"), 0);
		GuiVC.button50 = new GuiButtonGeneral1VC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.50"), 0);
		GuiVC.button51 = new GuiButtonGeneral1VC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.51"), 0);
		
		GuiVC.button52 = new GuiButtonGeneral1VC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.52"), 0);
		GuiVC.button53 = new GuiButtonGeneral1VC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.53"), 0);
		GuiVC.button54 = new GuiButtonGeneral1VC(54, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.54"), 0);
		GuiVC.button55 = new GuiButtonGeneral1VC(55, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.55"), 0);
		GuiVC.button56 = new GuiButtonGeneral1VC(56, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.56"), 0);
		GuiVC.button57 = new GuiButtonGeneral1VC(57, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.57"), 0);
		
		//--------------------------------------
		*/
		
		/**
		//Holiday Symbols
		//New Years
		GuiVC.buttonEDH01 = new GuiButtonGeneral1VC( 1, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 0), 76, 14, References.localNameVC("vc.enum.displaysymbol.1"), 0);
		GuiVC.buttonEDH02 = new GuiButtonGeneral1VC( 2, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.2"), 0);
		GuiVC.buttonEDH03 = new GuiButtonGeneral1VC( 3, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.3"), 0);
		GuiVC.buttonEDH04 = new GuiButtonGeneral1VC( 4, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.4"), 0);
		GuiVC.buttonEDH05 = new GuiButtonGeneral1VC( 5, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.5"), 0);
		GuiVC.buttonEDH06 = new GuiButtonGeneral1VC( 6, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.6"), 0);
		GuiVC.buttonEDH07 = new GuiButtonGeneral1VC( 7, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.7"), 0);
		GuiVC.buttonEDH08 = new GuiButtonGeneral1VC( 8, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.8"), 0);
		GuiVC.buttonEDH09 = new GuiButtonGeneral1VC( 9, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.9"), 0);
		GuiVC.buttonEDH10 = new GuiButtonGeneral1VC(10, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.10"), 0);
		GuiVC.buttonEDH11 = new GuiButtonGeneral1VC(11, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.11"), 0);
		GuiVC.buttonEDH12 = new GuiButtonGeneral1VC(12, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.12"), 0);
		//Valentine's Day
		GuiVC.buttonEDH13 = new GuiButtonGeneral1VC(13, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.13"), 0);
		GuiVC.buttonEDH14 = new GuiButtonGeneral1VC(14, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.14"), 0);
		GuiVC.buttonEDH15 = new GuiButtonGeneral1VC(15, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.15"), 0);
		GuiVC.buttonEDH16 = new GuiButtonGeneral1VC(16, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.16"), 0);
		GuiVC.buttonEDH17 = new GuiButtonGeneral1VC(17, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.17"), 0);
		GuiVC.buttonEDH18 = new GuiButtonGeneral1VC(18, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.18"), 0);
		GuiVC.buttonEDH19 = new GuiButtonGeneral1VC(19, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.19"), 0);
		GuiVC.buttonEDH20 = new GuiButtonGeneral1VC(20, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.20"), 0);
		GuiVC.buttonEDH21 = new GuiButtonGeneral1VC(21, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.21"), 0);
		GuiVC.buttonEDH22 = new GuiButtonGeneral1VC(22, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.22"), 0);
		GuiVC.buttonEDH23 = new GuiButtonGeneral1VC(23, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.23"), 0);
		GuiVC.buttonEDH24 = new GuiButtonGeneral1VC(24, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.24"), 0);
		//Easter
		GuiVC.buttonEDH25 = new GuiButtonGeneral1VC(25, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.25"), 0);
		GuiVC.buttonEDH26 = new GuiButtonGeneral1VC(26, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.26"), 0);
		GuiVC.buttonEDH27 = new GuiButtonGeneral1VC(27, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.27"), 0);
		GuiVC.buttonEDH28 = new GuiButtonGeneral1VC(28, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.28"), 0);
		GuiVC.buttonEDH29 = new GuiButtonGeneral1VC(29, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.29"), 0);
		GuiVC.buttonEDH30 = new GuiButtonGeneral1VC(30, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.30"), 0);
		GuiVC.buttonEDH31 = new GuiButtonGeneral1VC(31, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.31"), 0);
		GuiVC.buttonEDH32 = new GuiButtonGeneral1VC(32, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.32"), 0);
		GuiVC.buttonEDH33 = new GuiButtonGeneral1VC(33, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.33"), 0);
		GuiVC.buttonEDH34 = new GuiButtonGeneral1VC(34, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.34"), 0);
		GuiVC.buttonEDH35 = new GuiButtonGeneral1VC(35, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.35"), 0);
		GuiVC.buttonEDH36 = new GuiButtonGeneral1VC(36, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.36"), 0);
		//4th of July
		GuiVC.buttonEDH37 = new GuiButtonGeneral1VC(37, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.37"), 0);
		GuiVC.buttonEDH38 = new GuiButtonGeneral1VC(38, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.38"), 0);
		GuiVC.buttonEDH39 = new GuiButtonGeneral1VC(39, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.39"), 0);
		GuiVC.buttonEDH40 = new GuiButtonGeneral1VC(40, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.40"), 0);
		GuiVC.buttonEDH41 = new GuiButtonGeneral1VC(41, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.41"), 0);
		GuiVC.buttonEDH42 = new GuiButtonGeneral1VC(42, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.42"), 0);
		GuiVC.buttonEDH43 = new GuiButtonGeneral1VC(43, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.43"), 0);
		GuiVC.buttonEDH44 = new GuiButtonGeneral1VC(44, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.44"), 0);
		GuiVC.buttonEDH45 = new GuiButtonGeneral1VC(45, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.45"), 0);
		GuiVC.buttonEDH46 = new GuiButtonGeneral1VC(46, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.46"), 0);
		GuiVC.buttonEDH47 = new GuiButtonGeneral1VC(47, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.47"), 0);
		GuiVC.buttonEDH48 = new GuiButtonGeneral1VC(48, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.48"), 0);
		//Halloween
		GuiVC.buttonEDH49 = new GuiButtonGeneral1VC(49, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.49"), 0);
		GuiVC.buttonEDH50 = new GuiButtonGeneral1VC(50, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.50"), 0);
		GuiVC.buttonEDH51 = new GuiButtonGeneral1VC(51, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.51"), 0);
		GuiVC.buttonEDH52 = new GuiButtonGeneral1VC(52, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.52"), 0);
		GuiVC.buttonEDH53 = new GuiButtonGeneral1VC(53, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.53"), 0);
		GuiVC.buttonEDH54 = new GuiButtonGeneral1VC(54, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.54"), 0);
		GuiVC.buttonEDH55 = new GuiButtonGeneral1VC(55, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.55"), 0);
		GuiVC.buttonEDH56 = new GuiButtonGeneral1VC(56, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.56"), 0);
		GuiVC.buttonEDH57 = new GuiButtonGeneral1VC(57, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.57"), 0);
		GuiVC.buttonEDH58 = new GuiButtonGeneral1VC(58, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.58"), 0);
		GuiVC.buttonEDH59 = new GuiButtonGeneral1VC(59, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.59"), 0);
		GuiVC.buttonEDH60 = new GuiButtonGeneral1VC(60, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.60"), 0);
		//Thanksgiving
		GuiVC.buttonEDH61 = new GuiButtonGeneral1VC(61, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.61"), 0);
		GuiVC.buttonEDH62 = new GuiButtonGeneral1VC(62, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.62"), 0);
		GuiVC.buttonEDH63 = new GuiButtonGeneral1VC(63, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.63"), 0);
		GuiVC.buttonEDH64 = new GuiButtonGeneral1VC(64, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.64"), 0);
		GuiVC.buttonEDH65 = new GuiButtonGeneral1VC(65, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.65"), 0);
		GuiVC.buttonEDH66 = new GuiButtonGeneral1VC(66, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.66"), 0);
		GuiVC.buttonEDH67 = new GuiButtonGeneral1VC(67, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.67"), 0);
		GuiVC.buttonEDH68 = new GuiButtonGeneral1VC(68, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.68"), 0);
		GuiVC.buttonEDH69 = new GuiButtonGeneral1VC(69, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.69"), 0);
		GuiVC.buttonEDH70 = new GuiButtonGeneral1VC(70, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.70"), 0);
		GuiVC.buttonEDH71 = new GuiButtonGeneral1VC(71, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.71"), 0);
		GuiVC.buttonEDH72 = new GuiButtonGeneral1VC(72, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.72"), 0);
		//Christmas
		GuiVC.buttonEDH73 = new GuiButtonGeneral1VC(73, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 1), 76, 14, References.localNameVC("vc.enum.displaysymbol.73"), 0);
		GuiVC.buttonEDH74 = new GuiButtonGeneral1VC(74, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 2), 76, 14, References.localNameVC("vc.enum.displaysymbol.74"), 0);
		GuiVC.buttonEDH75 = new GuiButtonGeneral1VC(75, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 3), 76, 14, References.localNameVC("vc.enum.displaysymbol.75"), 0);
		GuiVC.buttonEDH76 = new GuiButtonGeneral1VC(76, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 4), 76, 14, References.localNameVC("vc.enum.displaysymbol.76"), 0);
		GuiVC.buttonEDH77 = new GuiButtonGeneral1VC(77, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 5), 76, 14, References.localNameVC("vc.enum.displaysymbol.77"), 0);
		GuiVC.buttonEDH78 = new GuiButtonGeneral1VC(78, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 6), 76, 14, References.localNameVC("vc.enum.displaysymbol.78"), 0);
		GuiVC.buttonEDH79 = new GuiButtonGeneral1VC(79, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 7), 76, 14, References.localNameVC("vc.enum.displaysymbol.79"), 0);
		GuiVC.buttonEDH80 = new GuiButtonGeneral1VC(80, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 8), 76, 14, References.localNameVC("vc.enum.displaysymbol.80"), 0);
		GuiVC.buttonEDH81 = new GuiButtonGeneral1VC(81, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 9), 76, 14, References.localNameVC("vc.enum.displaysymbol.81"), 0);
		GuiVC.buttonEDH82 = new GuiButtonGeneral1VC(82, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 10), 76, 14, References.localNameVC("vc.enum.displaysymbol.82"), 0);
		GuiVC.buttonEDH83 = new GuiButtonGeneral1VC(83, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 11), 76, 14, References.localNameVC("vc.enum.displaysymbol.83"), 0);
		GuiVC.buttonEDH84 = new GuiButtonGeneral1VC(84, this.guiLeft + startPlaceLeft, this.guiTop + startPlaceTop + (14 * 12), 76, 14, References.localNameVC("vc.enum.displaysymbol.84"), 0);
		*/
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		if (parButton.id == 502)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayParticleDefault());
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
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayParticle());
	    }
		
		if (parButton.id <= 450)
	    {
			this.metaInfo = parButton.id;
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
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49, this.guiTop - 17, this.guiLeft + 127, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50, this.guiTop - 16, this.guiLeft + 126, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52, this.guiTop - 14, this.guiLeft + 124, this.guiTop, Color.BLACK.getRGB());
		
		//this.drawEntityOnScreen(this.guiLeft + 135, this.guiTop + 110-18, 13, this.airship);
        
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 134, this.guiTop + 105.5, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("vc.main.cost"), 1, false, TextFormatting.RED), 0, 0, 111111);
		}
		GlStateManager.popMatrix();
		
		Color redstoneColor = Color.WHITE;
		
        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46, this.guiTop + 77+34, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, Integer.toString(CostsVC.ENGINE_PARTICLES_COST), 0, 0, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
		

        GlStateManager.pushMatrix();
		{
			GlStateManager.translate(this.guiLeft + 88.25 + 46, this.guiTop + 57, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.drawCenteredString(fontRenderer, "Preview Not", 0, 0, redstoneColor.getRGB());
	        this.drawCenteredString(fontRenderer, "Available", 0, 10, redstoneColor.getRGB());
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.fontRenderer.drawString(References.localNameVC("vc.main.appearance"), 58, -10, 65521);
		this.fontRenderer.drawString(References.localNameVC("vc.main.preview"), 115, 17, Color.BLACK.getRGB());
		
		//Logic for mouse-over Cost tooltip
		if(mouseX >= this.guiLeft + 12 && mouseX <= this.guiLeft + 87
		&& mouseY >= this.guiTop + 22 && mouseY <= this.guiTop + 189)
		{
			List<String> text = new ArrayList<String>();
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Costs " + CostsVC.ENGINE_PARTICLES_COST + " Redstone"));
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
			
			text.add(TextFormatting.LIGHT_PURPLE + References.localNameVC("Removes particles, costs nothing!"));
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
    
    /**
     * Draws an entity on the screen looking toward the cursor.
     */
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int scale, EntityAirshipCore entityIn)
    {
    	//int current = entityIn.engineParticleVisual;
        //entityIn.engineParticleVisual = metaInfo;
        
        super.drawEntityOnScreen(posX, posY, scale, entityIn);
    	
		//entityIn.engineParticleVisual = current;
    }
}

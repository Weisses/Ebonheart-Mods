package com.vies.viesmachines.client.gui.machines.customize.holiday;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageGuiMachineMenuCustomizeSecondarySkinTexture;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeSecondarySkinTextureHolidayCreative extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_holiday.png");
	private final ResourceLocation ICON_TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_holiday_icons.png");
	private int previewPart;
	
	public GuiMachineMenuCustomizeSecondarySkinTextureHolidayCreative(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.previewPart = 0;
		
		this.machineTexture = this.machine.getVisualComponentTexture();
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
		
		// New Years:
		GuiVM.buttonTexture00 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture01 = new GuiButtonGeneral1VM(101, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture02 = new GuiButtonGeneral1VM(102, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture03 = new GuiButtonGeneral1VM(103, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture04 = new GuiButtonGeneral1VM(104, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture05 = new GuiButtonGeneral1VM(105, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture06 = new GuiButtonGeneral1VM(106, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture07 = new GuiButtonGeneral1VM(107, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture08 = new GuiButtonGeneral1VC(108, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture09 = new GuiButtonGeneral1VC(109, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Valentines Day:
		GuiVM.buttonTexture10 = new GuiButtonGeneral1VM(110, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture11 = new GuiButtonGeneral1VM(111, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture12 = new GuiButtonGeneral1VM(112, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture13 = new GuiButtonGeneral1VM(113, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture14 = new GuiButtonGeneral1VM(114, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture15 = new GuiButtonGeneral1VM(115, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture16 = new GuiButtonGeneral1VM(116, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture17 = new GuiButtonGeneral1VM(117, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture18 = new GuiButtonGeneral1VC(118, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture19 = new GuiButtonGeneral1VC(119, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Easter:
		GuiVM.buttonTexture20 = new GuiButtonGeneral1VM(120, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture21 = new GuiButtonGeneral1VM(121, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture22 = new GuiButtonGeneral1VM(122, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture23 = new GuiButtonGeneral1VM(123, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture24 = new GuiButtonGeneral1VM(124, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture25 = new GuiButtonGeneral1VM(125, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture26 = new GuiButtonGeneral1VM(126, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture27 = new GuiButtonGeneral1VM(127, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture28 = new GuiButtonGeneral1VC(128, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture29 = new GuiButtonGeneral1VC(129, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// 4th of July:
		GuiVM.buttonTexture30 = new GuiButtonGeneral1VM(130, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture31 = new GuiButtonGeneral1VM(131, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture32 = new GuiButtonGeneral1VM(132, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture33 = new GuiButtonGeneral1VM(133, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture34 = new GuiButtonGeneral1VM(134, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture35 = new GuiButtonGeneral1VM(135, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture36 = new GuiButtonGeneral1VM(136, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture37 = new GuiButtonGeneral1VM(137, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture38 = new GuiButtonGeneral1VC(138, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture39 = new GuiButtonGeneral1VC(139, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Halloween:
		GuiVM.buttonTexture40 = new GuiButtonGeneral1VM(140, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture41 = new GuiButtonGeneral1VM(141, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture42 = new GuiButtonGeneral1VM(142, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture43 = new GuiButtonGeneral1VM(143, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture44 = new GuiButtonGeneral1VM(144, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture45 = new GuiButtonGeneral1VM(145, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture46 = new GuiButtonGeneral1VM(146, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture47 = new GuiButtonGeneral1VM(147, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture48 = new GuiButtonGeneral1VC(148, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture49 = new GuiButtonGeneral1VC(149, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Thanksgiving:
		GuiVM.buttonTexture50 = new GuiButtonGeneral1VM(150, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture51 = new GuiButtonGeneral1VM(151, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture52 = new GuiButtonGeneral1VM(152, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture53 = new GuiButtonGeneral1VM(153, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture54 = new GuiButtonGeneral1VM(154, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture55 = new GuiButtonGeneral1VM(155, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture56 = new GuiButtonGeneral1VM(156, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture57 = new GuiButtonGeneral1VM(157, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture58 = new GuiButtonGeneral1VC(158, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture59 = new GuiButtonGeneral1VC(159, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Christmas:
		GuiVM.buttonTexture60 = new GuiButtonGeneral1VM(160, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture61 = new GuiButtonGeneral1VM(161, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture62 = new GuiButtonGeneral1VM(162, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture63 = new GuiButtonGeneral1VM(163, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture64 = new GuiButtonGeneral1VM(164, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture65 = new GuiButtonGeneral1VM(165, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture66 = new GuiButtonGeneral1VM(166, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture67 = new GuiButtonGeneral1VM(167, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture68 = new GuiButtonGeneral1VC(168, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		//GuiVM.buttonTexture69 = new GuiButtonGeneral1VC(169, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		// Holidays:
		GuiVM.button11 = new GuiButtonGeneral2VM(51, this.guiLeft + 22 + (70 * 0), this.guiTop + 98 - 14 + (14 * 0), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.newyears"), false), 2);
		GuiVM.button12 = new GuiButtonGeneral2VM(52, this.guiLeft + 22 + (70 * 1), this.guiTop + 98 - 14 + (14 * 0), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.valentinesday"), false), 2);
		GuiVM.button13 = new GuiButtonGeneral2VM(53, this.guiLeft + 22 + (70 * 0), this.guiTop + 98 - 14 + (14 * 1), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.easter"), false), 2);
		GuiVM.button14 = new GuiButtonGeneral2VM(54, this.guiLeft + 22 + (70 * 1), this.guiTop + 98 - 14 + (14 * 1), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.4thofjuly"), false), 2);
		GuiVM.button15 = new GuiButtonGeneral2VM(55, this.guiLeft + 22 + (70 * 0), this.guiTop + 98 - 14 + (14 * 2), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.halloween"), false), 2);
		GuiVM.button16 = new GuiButtonGeneral2VM(56, this.guiLeft + 22 + (70 * 1), this.guiTop + 98 - 14 + (14 * 2), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.thanksgiving"), false), 2);
		GuiVM.button17 = new GuiButtonGeneral2VM(57, this.guiLeft + 22 + (70 * 0), this.guiTop + 98 - 14 + (14 * 3), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.christmas"), false), 2);
		
		//--------------------------------------------------
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonTexture00);
		this.buttonList.add(GuiVM.buttonTexture01);
		this.buttonList.add(GuiVM.buttonTexture02);
		this.buttonList.add(GuiVM.buttonTexture03);
		this.buttonList.add(GuiVM.buttonTexture04);
		this.buttonList.add(GuiVM.buttonTexture05);
		this.buttonList.add(GuiVM.buttonTexture06);
		this.buttonList.add(GuiVM.buttonTexture07);
		//this.buttonList.add(GuiVM.buttonTexture08);
		//this.buttonList.add(GuiVM.buttonTexture09);
		
		this.buttonList.add(GuiVM.buttonTexture10);
		this.buttonList.add(GuiVM.buttonTexture11);
		this.buttonList.add(GuiVM.buttonTexture12);
		this.buttonList.add(GuiVM.buttonTexture13);
		this.buttonList.add(GuiVM.buttonTexture14);
		this.buttonList.add(GuiVM.buttonTexture15);
		this.buttonList.add(GuiVM.buttonTexture16);
		this.buttonList.add(GuiVM.buttonTexture17);
		//this.buttonList.add(GuiVM.buttonTexture18);
		//this.buttonList.add(GuiVM.buttonTexture19);
		
		this.buttonList.add(GuiVM.buttonTexture20);
		this.buttonList.add(GuiVM.buttonTexture21);
		this.buttonList.add(GuiVM.buttonTexture22);
		this.buttonList.add(GuiVM.buttonTexture23);
		this.buttonList.add(GuiVM.buttonTexture24);
		this.buttonList.add(GuiVM.buttonTexture25);
		this.buttonList.add(GuiVM.buttonTexture26);
		this.buttonList.add(GuiVM.buttonTexture27);
		//this.buttonList.add(GuiVM.buttonTexture28);
		//this.buttonList.add(GuiVM.buttonTexture29);
		
		this.buttonList.add(GuiVM.buttonTexture30);
		this.buttonList.add(GuiVM.buttonTexture31);
		this.buttonList.add(GuiVM.buttonTexture32);
		this.buttonList.add(GuiVM.buttonTexture33);
		this.buttonList.add(GuiVM.buttonTexture34);
		this.buttonList.add(GuiVM.buttonTexture35);
		this.buttonList.add(GuiVM.buttonTexture36);
		this.buttonList.add(GuiVM.buttonTexture37);
		//this.buttonList.add(GuiVM.buttonTexture38);
		//this.buttonList.add(GuiVM.buttonTexture39);
		
		this.buttonList.add(GuiVM.buttonTexture40);
		this.buttonList.add(GuiVM.buttonTexture41);
		this.buttonList.add(GuiVM.buttonTexture42);
		this.buttonList.add(GuiVM.buttonTexture43);
		this.buttonList.add(GuiVM.buttonTexture44);
		this.buttonList.add(GuiVM.buttonTexture45);
		this.buttonList.add(GuiVM.buttonTexture46);
		this.buttonList.add(GuiVM.buttonTexture47);
		//this.buttonList.add(GuiVM.buttonTexture48);
		//this.buttonList.add(GuiVM.buttonTexture49);
		
		this.buttonList.add(GuiVM.buttonTexture50);
		this.buttonList.add(GuiVM.buttonTexture51);
		this.buttonList.add(GuiVM.buttonTexture52);
		this.buttonList.add(GuiVM.buttonTexture53);
		this.buttonList.add(GuiVM.buttonTexture54);
		this.buttonList.add(GuiVM.buttonTexture55);
		this.buttonList.add(GuiVM.buttonTexture56);
		this.buttonList.add(GuiVM.buttonTexture57);
		//this.buttonList.add(GuiVM.buttonTexture58);
		//this.buttonList.add(GuiVM.buttonTexture59);
		
		this.buttonList.add(GuiVM.buttonTexture60);
		this.buttonList.add(GuiVM.buttonTexture61);
		this.buttonList.add(GuiVM.buttonTexture62);
		this.buttonList.add(GuiVM.buttonTexture63);
		this.buttonList.add(GuiVM.buttonTexture64);
		this.buttonList.add(GuiVM.buttonTexture65);
		this.buttonList.add(GuiVM.buttonTexture66);
		this.buttonList.add(GuiVM.buttonTexture67);
		//this.buttonList.add(GuiVM.buttonTexture68);
		//this.buttonList.add(GuiVM.buttonTexture69);
		
		this.buttonList.add(GuiVM.button11);
		this.buttonList.add(GuiVM.button12);
		this.buttonList.add(GuiVM.button13);
		this.buttonList.add(GuiVM.button14);
		this.buttonList.add(GuiVM.button15);
		this.buttonList.add(GuiVM.button16);
		this.buttonList.add(GuiVM.button17);
		
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Apply:
		if (parButton.id == 21)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondarySkinTextureHoliday());
		}
		
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeSecondarySkinTexture());
		}
		
		// Symbol Holiday Buttons:
		if (parButton.id >= 51
		 && parButton.id <= 60)
	    {
			int fixedNumber = parButton.id - 50;
			
			this.previewPart = fixedNumber;
	    }
		
		// Symbol Holiday Buttons:
		if (parButton.id >= 100)
	    {
			int fixedNumber = parButton.id + 900;
			
			this.machineTexture = fixedNumber;
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Draws a gray box behind the main background texture:
		this.drawRect(this.guiLeft + 8, this.guiTop + 8, this.guiLeft + 168, this.guiTop + 76, Color.GRAY.getRGB());
		
		// Colors, binds, and draws the background texture:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

		// Current texture:
		if (this.machine.getVisualComponentTexture() < 1000)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(EnumsVM.VisualMachineTexture.byId(this.machine.getVisualComponentTexture()).getBlock(), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Current Texture:
		if (this.machine.getVisualComponentTexture() >= 1000)
		{
			GlStateManager.pushMatrix();
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
		    	GlStateManager.translate(28.865 + (14 * 1), 25, 0);
				GlStateManager.scale(0.75F, 0.75F, 0.75F);
				
				// Colors, binds, and draws the background texture:
				GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
				this.mc.getTextureManager().bindTexture(ICON_TEXTURE);
				
				// Christmas:
				{
					if (this.machine.getVisualComponentTexture() == 1060)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 0), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1061)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 1), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1062)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 2), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1063)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 3), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1064)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 4), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1065)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 5), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1066)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 6), 0, 32, 32);
					}
					if (this.machine.getVisualComponentTexture() == 1067)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 7), 0, 32, 32);
					}
				}
			}
			GlStateManager.popMatrix();
		}
		
		// Preview:
		GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
	    	GlStateManager.translate(28 + (14 * 7), 25, 0);
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			// Colors, binds, and draws the background texture:
			GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
			this.mc.getTextureManager().bindTexture(ICON_TEXTURE);
			
			// Christmas:
			if(this.previewPart == 7)
			{
				if (this.machineTexture == 1060)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 0), 0, 32, 32);
				}
				if (this.machineTexture == 1061)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 1), 0, 32, 32);
				}
				if (this.machineTexture == 1062)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 2), 0, 32, 32);
				}
				if (this.machineTexture == 1063)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 3), 0, 32, 32);
				}
				if (this.machineTexture == 1064)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 4), 0, 32, 32);
				}
				if (this.machineTexture == 1065)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 5), 0, 32, 32);
				}
				if (this.machineTexture == 1066)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 6), 0, 32, 32);
				}
				if (this.machineTexture == 1067)
				{
					this.drawTexturedModalRect((56 * 0), 0, (32 * 7), 0, 32, 32);
				}
			}
		}
		GlStateManager.popMatrix();
		
		// 'New Years':
		if(this.previewPart == 1)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.newyears"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// 'Valentines Day':
		if(this.previewPart == 2)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.valentinesday"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// 'Easter':
		if(this.previewPart == 3)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.easter"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// '4th of July':
		if(this.previewPart == 4)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.4thofjuly"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// 'Halloween':
		if(this.previewPart == 5)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.halloween"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// 'Thanksgiving':
		if(this.previewPart == 6)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.thanksgiving"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		// 'Christmas':
		if(this.previewPart == 7)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(39, 83+33+33, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.christmas"), false), 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// 'Holiday':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, this.stringToRainbow(References.localNameVC("viesmachines.button.holiday"), false), 0, 0, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Current Banner':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.25, 53, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.currentbanner.0"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Preview':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(138.5, 10, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.main.preview"), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Draws a black box over the preview buttons:
		this.drawRect(108, 66, 130, 76, Color.BLACK.getRGB());
		
		// General Row item over button:
		GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
	    	GlStateManager.translate(21+14, 164, 0);
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			// Colors, binds, and draws the background texture:
			GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
			this.mc.getTextureManager().bindTexture(ICON_TEXTURE);
			
			// Christmas:
			if(this.previewPart == 7)
			{
				this.drawTexturedModalRect((56 * 0), 0, (32 * 0), 0, 32, 32);
				this.drawTexturedModalRect((56 * 1), 0, (32 * 1), 0, 32, 32);
				this.drawTexturedModalRect((56 * 2), 0, (32 * 2), 0, 32, 32);
				this.drawTexturedModalRect((56 * 3), 0, (32 * 3), 0, 32, 32);
				this.drawTexturedModalRect((56 * 4), 0, (32 * 4), 0, 32, 32);
				this.drawTexturedModalRect((56 * 5), 0, (32 * 5), 0, 32, 32);
				this.drawTexturedModalRect((56 * 6), 0, (32 * 6), 0, 32, 32);
				this.drawTexturedModalRect((56 * 7), 0, (32 * 7), 0, 32, 32);
				
			}
		}
		GlStateManager.popMatrix();
		
		this.mouseOverTooltipHandler(mouseX, mouseY);
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Apply:
		if (mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop +63 && mouseY <= this.guiTop +63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (!GuiVM.buttonApply.enabled)
			{
				text.add(TextFormatting.RED + References.localNameVC("viesmachines.gui.tt.customize.color.cost.0"));
			}
			else
			{
				text.add(this.stringToRainbow(References.localNameVC("viesmachines.button.holiday.cost"), false));
			}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = References.localNameVC("viesmachines.button.holiday.cost").length();
				
				GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 13, 0);
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
        ||	keyCode == Keybinds.openGuiMenu.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        // Handles when the 'Apply' button is enabled:
        if (this.machineTexture < 1000)
        {
        	GuiVM.buttonApply.enabled = false;
        }
        else
        {
        	if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (this.machineTexture == this.machine.getVisualComponentTexture())
        		{
        			GuiVM.buttonApply.enabled = false;
        		}
        		else
        		{
        			GuiVM.buttonApply.enabled = true;
        		}
        	}
        }
        
        this.hideAllButtons();
        
 		// Handles the buttons for Previewing New Years:
 		if(this.previewPart == 1)
		{
 			GuiVM.button11.enabled = false;
 			
			GuiVM.buttonTexture00.visible = true;
	    	GuiVM.buttonTexture01.visible = true;
	    	GuiVM.buttonTexture02.visible = true;
			GuiVM.buttonTexture03.visible = true;
	    	GuiVM.buttonTexture04.visible = true;
	    	GuiVM.buttonTexture05.visible = true;
			GuiVM.buttonTexture06.visible = true;
			GuiVM.buttonTexture07.visible = true;
			//GuiVM.buttonTexture08.visible = true;
			//GuiVM.buttonTexture09.visible = true;
		}
 		else
 		{
 			GuiVM.button11.enabled = true;
 		}
        
 		// Handles the buttons for Previewing Valentines Day:
 		if(this.previewPart == 2)
		{
 			GuiVM.button12.enabled = false;
 			
			GuiVM.buttonTexture10.visible = true;
	    	GuiVM.buttonTexture11.visible = true;
	    	GuiVM.buttonTexture12.visible = true;
			GuiVM.buttonTexture13.visible = true;
	    	GuiVM.buttonTexture14.visible = true;
	    	GuiVM.buttonTexture15.visible = true;
			GuiVM.buttonTexture16.visible = true;
			GuiVM.buttonTexture17.visible = true;
			//GuiVM.buttonTexture18.visible = true;
			//GuiVM.buttonTexture19.visible = true;
		}
 		else
 		{
 			GuiVM.button12.enabled = true;
 		}
        
 		// Handles the buttons for Previewing Easter:
 		if(this.previewPart == 3)
		{
 			GuiVM.button13.enabled = false;
 			
			GuiVM.buttonTexture20.visible = true;
	    	GuiVM.buttonTexture21.visible = true;
	    	GuiVM.buttonTexture22.visible = true;
			GuiVM.buttonTexture23.visible = true;
	    	GuiVM.buttonTexture24.visible = true;
	    	GuiVM.buttonTexture25.visible = true;
			GuiVM.buttonTexture26.visible = true;
			GuiVM.buttonTexture27.visible = true;
			//GuiVM.buttonTexture28.visible = true;
			//GuiVM.buttonTexture29.visible = true;
		}
 		else
 		{
 			GuiVM.button13.enabled = true;
 		}
        
 		// Handles the buttons for Previewing 4th of July:
 		if(this.previewPart == 4)
		{
 			GuiVM.button14.enabled = false;
 			
			GuiVM.buttonTexture30.visible = true;
	    	GuiVM.buttonTexture31.visible = true;
	    	GuiVM.buttonTexture32.visible = true;
			GuiVM.buttonTexture33.visible = true;
	    	GuiVM.buttonTexture34.visible = true;
	    	GuiVM.buttonTexture35.visible = true;
			GuiVM.buttonTexture36.visible = true;
			GuiVM.buttonTexture37.visible = true;
			//GuiVM.buttonTexture38.visible = true;
			//GuiVM.buttonTexture39.visible = true;
		}
 		else
 		{
 			GuiVM.button14.enabled = true;
 		}
        
 		// Handles the buttons for Previewing Halloween:
 		if(this.previewPart == 5)
		{
 			GuiVM.button15.enabled = false;
 			
			GuiVM.buttonTexture40.visible = true;
	    	GuiVM.buttonTexture41.visible = true;
	    	GuiVM.buttonTexture42.visible = true;
			GuiVM.buttonTexture43.visible = true;
	    	GuiVM.buttonTexture44.visible = true;
	    	GuiVM.buttonTexture45.visible = true;
			GuiVM.buttonTexture46.visible = true;
			GuiVM.buttonTexture47.visible = true;
			//GuiVM.buttonTexture48.visible = true;
			//GuiVM.buttonTexture49.visible = true;
		}
 		else
 		{
 			GuiVM.button15.enabled = true;
 		}
        
 		// Handles the buttons for Previewing Thanksgiving:
 		if(this.previewPart == 6)
		{
 			GuiVM.button16.enabled = false;
 			
			GuiVM.buttonTexture50.visible = true;
	    	GuiVM.buttonTexture51.visible = true;
	    	GuiVM.buttonTexture52.visible = true;
			GuiVM.buttonTexture53.visible = true;
	    	GuiVM.buttonTexture54.visible = true;
	    	GuiVM.buttonTexture55.visible = true;
			GuiVM.buttonTexture56.visible = true;
			GuiVM.buttonTexture57.visible = true;
			//GuiVM.buttonTexture58.visible = true;
			//GuiVM.buttonTexture59.visible = true;
		}
 		else
 		{
 			GuiVM.button16.enabled = true;
 		}
        
 		// Handles the buttons for Previewing Christmas:
 		if(this.previewPart == 7)
		{
 			GuiVM.button17.enabled = false;
 			
			GuiVM.buttonTexture60.visible = true;
	    	GuiVM.buttonTexture61.visible = true;
	    	GuiVM.buttonTexture62.visible = true;
			GuiVM.buttonTexture63.visible = true;
	    	GuiVM.buttonTexture64.visible = true;
	    	GuiVM.buttonTexture65.visible = true;
			GuiVM.buttonTexture66.visible = true;
			GuiVM.buttonTexture67.visible = true;
			//GuiVM.buttonTexture68.visible = true;
			//GuiVM.buttonTexture69.visible = true;
		}
 		else
 		{
 			GuiVM.button17.enabled = true;
 		}
 		
 		//TODO Placed to block unfinished holidays
 		GuiVM.button11.enabled = false;
 		GuiVM.button12.enabled = false;
 		GuiVM.button13.enabled = false;
 		GuiVM.button14.enabled = false;
 		GuiVM.button15.enabled = false;
 		GuiVM.button16.enabled = false;
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
    }
	
	/** Handles spacing/name of texture mouseover tooltips. */
	protected void mouseOverTooltipNames(int mouseX, int mouseY, int xIn, int yIn, int enumIn) 
	{
		// Logic for mouse-over tooltip - Default Row:
		if(mouseX >= this.guiLeft + xIn && mouseX <= this.guiLeft + xIn + 13
		&& mouseY >= this.guiTop + yIn && mouseY <= this.guiTop + yIn + 13)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.GREEN + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(EnumsVM.VisualTextureHoliday.byId(enumIn).getLocalizedName()));
			
			GlStateManager.pushMatrix();
			{
				int textNumber = text.toString().length();
				
				GlStateManager.translate(mouseX - this.guiLeft +3 - textNumber - (textNumber / 2), mouseY - this.guiTop - 11, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
	}
	
	/** Deals with visibility and enabled texture buttons. */
	protected void mouseOverTooltipHandler(int mouseX, int mouseY) 
	{
		// Christmas:
		if(this.previewPart == 7)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 1) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_TREE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 2) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_WREATH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 3) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_ORNAMENT.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 4) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_STOCKING.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 5) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_NIGHTSKY.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 6) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_GRINCH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 7) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_MAX.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 8) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_FROSTY.getMetadata());
			//this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 8) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_PEANUTS.getMetadata());
			//this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 9) * 1), 102-7+33+33, EnumsVM.VisualDisplaySymbolHoliday.SYMBOL_CHRISTMAS_POKEMON.getMetadata());
		}
	}
	
	/** Deals with visibility of all holiday symbol buttons. */
	protected void hideAllButtons() 
	{
		// New Years:
		GuiVM.buttonTexture00.visible = false;
    	GuiVM.buttonTexture01.visible = false;
    	GuiVM.buttonTexture02.visible = false;
		GuiVM.buttonTexture03.visible = false;
    	GuiVM.buttonTexture04.visible = false;
    	GuiVM.buttonTexture05.visible = false;
		GuiVM.buttonTexture06.visible = false;
		GuiVM.buttonTexture07.visible = false;
		//GuiVM.buttonTexture08.visible = false;
		//GuiVM.buttonTexture09.visible = false;
		
		// Valentines Day:
		GuiVM.buttonTexture10.visible = false;
    	GuiVM.buttonTexture11.visible = false;
    	GuiVM.buttonTexture12.visible = false;
		GuiVM.buttonTexture13.visible = false;
    	GuiVM.buttonTexture14.visible = false;
    	GuiVM.buttonTexture15.visible = false;
		GuiVM.buttonTexture16.visible = false;
		GuiVM.buttonTexture17.visible = false;
		//GuiVM.buttonTexture18.visible = false;
		//GuiVM.buttonTexture19.visible = false;
		
		// Easter:
		GuiVM.buttonTexture20.visible = false;
    	GuiVM.buttonTexture21.visible = false;
    	GuiVM.buttonTexture22.visible = false;
		GuiVM.buttonTexture23.visible = false;
    	GuiVM.buttonTexture24.visible = false;
    	GuiVM.buttonTexture25.visible = false;
		GuiVM.buttonTexture26.visible = false;
		GuiVM.buttonTexture27.visible = false;
		//GuiVM.buttonTexture28.visible = false;
		//GuiVM.buttonTexture29.visible = false;
		
		// 4th of July:
		GuiVM.buttonTexture30.visible = false;
    	GuiVM.buttonTexture31.visible = false;
    	GuiVM.buttonTexture32.visible = false;
		GuiVM.buttonTexture33.visible = false;
    	GuiVM.buttonTexture34.visible = false;
    	GuiVM.buttonTexture35.visible = false;
		GuiVM.buttonTexture36.visible = false;
		GuiVM.buttonTexture37.visible = false;
		//GuiVM.buttonTexture38.visible = false;
		//GuiVM.buttonTexture39.visible = false;
		
		// Halloween:
		GuiVM.buttonTexture40.visible = false;
    	GuiVM.buttonTexture41.visible = false;
    	GuiVM.buttonTexture42.visible = false;
		GuiVM.buttonTexture43.visible = false;
    	GuiVM.buttonTexture44.visible = false;
    	GuiVM.buttonTexture45.visible = false;
		GuiVM.buttonTexture46.visible = false;
		GuiVM.buttonTexture47.visible = false;
		//GuiVM.buttonTexture48.visible = false;
		//GuiVM.buttonTexture49.visible = false;
		
		// Thanksgiving:
		GuiVM.buttonTexture50.visible = false;
    	GuiVM.buttonTexture51.visible = false;
    	GuiVM.buttonTexture52.visible = false;
		GuiVM.buttonTexture53.visible = false;
    	GuiVM.buttonTexture54.visible = false;
    	GuiVM.buttonTexture55.visible = false;
		GuiVM.buttonTexture56.visible = false;
		GuiVM.buttonTexture57.visible = false;
		//GuiVM.buttonTexture58.visible = false;
		//GuiVM.buttonTexture59.visible = false;
		
		// Christmas:
		GuiVM.buttonTexture60.visible = false;
    	GuiVM.buttonTexture61.visible = false;
    	GuiVM.buttonTexture62.visible = false;
		GuiVM.buttonTexture63.visible = false;
    	GuiVM.buttonTexture64.visible = false;
    	GuiVM.buttonTexture65.visible = false;
		GuiVM.buttonTexture66.visible = false;
		GuiVM.buttonTexture67.visible = false;
		//GuiVM.buttonTexture68.visible = false;
		//GuiVM.buttonTexture69.visible = false;
	}
}

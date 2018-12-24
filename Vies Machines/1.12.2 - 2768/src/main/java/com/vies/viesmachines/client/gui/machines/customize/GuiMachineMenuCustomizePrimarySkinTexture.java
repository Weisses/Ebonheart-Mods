package com.vies.viesmachines.client.gui.machines.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayCreative;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageHelperGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizePrimarySkinTexture extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_texture.png");
	private final ResourceLocation ICON_TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_holiday_icons.png");
	
	public GuiMachineMenuCustomizePrimarySkinTexture(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.machineTexture = this.machine.getVisualFrameTexture();
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	String holidayName = "";
    	
    	// 'New Years':
		if(References.isDateAroundNewYears(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.newyears");
		}
		// 'Valentines Day':
		if(References.isDateAroundValentinesDay(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.valentinesday");
		}
		// 'Easter':
		if(References.isDateAroundEaster(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.easter");
		}
		// '4th of July':
		if(References.isDateAroundIndependenceDay(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.4thofJuly");
		}
		// 'Halloween':
		if(References.isDateAroundHalloween(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.halloween");
		}
		// 'Thanksgiving':
		if(References.isDateAroundThanksgiving(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.thanksgiving");
		}
		// 'Christmas':
		if(References.isDateAroundChristmas(Calendar.getInstance()))
		{
			holidayName = References.localNameVC("viesmachines.button.christmas");
		}
    	
    	GuiVM.buttonRotateLeft = new GuiButtonGeneral2VM(10, this.guiLeft + 110, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VM(10, this.guiLeft + 122, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRidingPlayerTrue = new GuiButtonGeneral1VM(12, this.guiLeft + 130, this.guiTop + 66, 10, 10, "", 1);
    	GuiVM.buttonRidingPlayerFalse = new GuiButtonGeneral1VM(13, this.guiLeft + 140, this.guiTop + 66, 10, 10, "", 2);
    	GuiVM.buttonUndo = new GuiButtonGeneral2VM(11, this.guiLeft + 158, this.guiTop + 66, 10, 10, "", 1);
		
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
		
		GuiVM.buttonTexture00 = new GuiButtonGeneral2VM(100, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 86, 14, 14, "", 1);
		GuiVM.buttonTexture01 = new GuiButtonGeneral1VM(101, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 86, 14, 14, "", 3);
		GuiVM.buttonTexture02 = new GuiButtonGeneral1VM(102, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 86, 14, 14, "", 3);
		GuiVM.buttonTexture03 = new GuiButtonGeneral1VM(103, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 86, 14, 14, "", 3);
		GuiVM.buttonTexture04 = new GuiButtonGeneral1VM(104, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 86, 14, 14, "", 3);
		
		// Tier 1:
		GuiVM.buttonTexture05 = new GuiButtonGeneral1VM(105, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture06 = new GuiButtonGeneral1VM(106, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture07 = new GuiButtonGeneral1VM(107, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture08 = new GuiButtonGeneral1VM(108, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture09 = new GuiButtonGeneral1VM(109, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture10 = new GuiButtonGeneral1VM(110, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 106, 14, 14, "", 3);
		GuiVM.buttonTexture11 = new GuiButtonGeneral1VM(111, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 106, 14, 14, "", 3);
		
		GuiVM.buttonTexture12 = new GuiButtonGeneral1VM(112, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture13 = new GuiButtonGeneral1VM(113, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture14 = new GuiButtonGeneral1VM(114, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture15 = new GuiButtonGeneral1VM(115, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture16 = new GuiButtonGeneral1VM(116, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture17 = new GuiButtonGeneral1VM(117, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture18 = new GuiButtonGeneral1VM(118, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 106 + (14 * 1), 14, 14, "", 3);
		
		// Tier 2:
		GuiVM.buttonTexture19 = new GuiButtonGeneral1VM(119, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture20 = new GuiButtonGeneral1VM(120, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture21 = new GuiButtonGeneral1VM(121, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture22 = new GuiButtonGeneral1VM(122, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture23 = new GuiButtonGeneral1VM(123, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture24 = new GuiButtonGeneral1VM(124, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 136, 14, 14, "", 3);
		GuiVM.buttonTexture25 = new GuiButtonGeneral1VM(125, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 136, 14, 14, "", 3);
		
		GuiVM.buttonTexture26 = new GuiButtonGeneral1VM(126, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture27 = new GuiButtonGeneral1VM(127, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture28 = new GuiButtonGeneral1VM(128, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture29 = new GuiButtonGeneral1VM(129, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture30 = new GuiButtonGeneral1VM(130, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture31 = new GuiButtonGeneral1VM(131, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture32 = new GuiButtonGeneral1VM(132, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 136 + (14 * 1), 14, 14, "", 3);
		
		// Tier 3:
		GuiVM.buttonTexture33 = new GuiButtonGeneral1VM(133, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 166 + (14 * 0), 14, 14, "", 3);
		GuiVM.buttonTexture34 = new GuiButtonGeneral1VM(134, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 166, 14, 14, "", 3);
		GuiVM.buttonTexture35 = new GuiButtonGeneral1VM(135, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 166, 14, 14, "", 3);
		GuiVM.buttonTexture36 = new GuiButtonGeneral1VM(136, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 166, 14, 14, "", 3);
		GuiVM.buttonTexture37 = new GuiButtonGeneral1VM(137, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 166, 14, 14, "", 3);
		GuiVM.buttonTexture38 = new GuiButtonGeneral1VM(138, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 166, 14, 14, "", 3);
		GuiVM.buttonTexture39 = new GuiButtonGeneral1VM(139, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 166, 14, 14, "", 3);
		
		GuiVM.buttonTexture40 = new GuiButtonGeneral1VM(140, this.guiLeft + 32-26 + (14 * 0), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture41 = new GuiButtonGeneral1VM(141, this.guiLeft + 32-26 + (14 * 1), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture42 = new GuiButtonGeneral1VM(142, this.guiLeft + 32-26 + (14 * 2), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture43 = new GuiButtonGeneral1VM(143, this.guiLeft + 32-26 + (14 * 3), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture44 = new GuiButtonGeneral1VM(144, this.guiLeft + 32-26 + (14 * 4), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture45 = new GuiButtonGeneral1VM(145, this.guiLeft + 32-26 + (14 * 5), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		GuiVM.buttonTexture46 = new GuiButtonGeneral1VM(146, this.guiLeft + 32-26 + (14 * 6), this.guiTop + 166 + (14 * 1), 14, 14, "", 3);
		
		//--------------------------------------------------
		
		// Holidays:
		GuiVM.button11 = new GuiButtonGeneral2VM(1111, this.guiLeft + 67+40, this.guiTop + 92 - 14 + (14 * 2), 62, 14, this.stringToRainbow(holidayName, false), 2);
		
		// Creative:
		GuiVM.button01 = new GuiButtonGeneral2VM(1101, this.guiLeft + 67+40, this.guiTop + 92 - 14 + (14 * 2), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.holiday1"), false), 2);
		
		//--------------------------------------------------
		
		this.buttonList.add(GuiVM.buttonTexture00);
		this.buttonList.add(GuiVM.buttonTexture01);
		this.buttonList.add(GuiVM.buttonTexture02);
		this.buttonList.add(GuiVM.buttonTexture03);
		this.buttonList.add(GuiVM.buttonTexture04);
		
		this.buttonList.add(GuiVM.buttonTexture05);
		this.buttonList.add(GuiVM.buttonTexture06);
		this.buttonList.add(GuiVM.buttonTexture07);
		this.buttonList.add(GuiVM.buttonTexture08);
		this.buttonList.add(GuiVM.buttonTexture09);
		this.buttonList.add(GuiVM.buttonTexture10);
		this.buttonList.add(GuiVM.buttonTexture11);
		
		this.buttonList.add(GuiVM.buttonTexture12);
		this.buttonList.add(GuiVM.buttonTexture13);
		this.buttonList.add(GuiVM.buttonTexture14);
		this.buttonList.add(GuiVM.buttonTexture15);
		this.buttonList.add(GuiVM.buttonTexture16);
		this.buttonList.add(GuiVM.buttonTexture17);
		this.buttonList.add(GuiVM.buttonTexture18);
		
		this.buttonList.add(GuiVM.buttonTexture19);
		this.buttonList.add(GuiVM.buttonTexture20);
		this.buttonList.add(GuiVM.buttonTexture21);
		this.buttonList.add(GuiVM.buttonTexture22);
		this.buttonList.add(GuiVM.buttonTexture23);
		this.buttonList.add(GuiVM.buttonTexture24);
		this.buttonList.add(GuiVM.buttonTexture25);
		
		this.buttonList.add(GuiVM.buttonTexture26);
		this.buttonList.add(GuiVM.buttonTexture27);
		this.buttonList.add(GuiVM.buttonTexture28);
		this.buttonList.add(GuiVM.buttonTexture29);
		this.buttonList.add(GuiVM.buttonTexture30);
		this.buttonList.add(GuiVM.buttonTexture31);
		this.buttonList.add(GuiVM.buttonTexture32);
		
		this.buttonList.add(GuiVM.buttonTexture33);
		this.buttonList.add(GuiVM.buttonTexture34);
		this.buttonList.add(GuiVM.buttonTexture35);
		this.buttonList.add(GuiVM.buttonTexture36);
		this.buttonList.add(GuiVM.buttonTexture37);
		this.buttonList.add(GuiVM.buttonTexture38);
		this.buttonList.add(GuiVM.buttonTexture39);

		this.buttonList.add(GuiVM.buttonTexture40);
		this.buttonList.add(GuiVM.buttonTexture41);
		this.buttonList.add(GuiVM.buttonTexture42);
		this.buttonList.add(GuiVM.buttonTexture43);
		this.buttonList.add(GuiVM.buttonTexture44);
		this.buttonList.add(GuiVM.buttonTexture45);
		this.buttonList.add(GuiVM.buttonTexture46);
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonRotateLeft);
    	this.buttonList.add(GuiVM.buttonRotateRight);
    	this.buttonList.add(GuiVM.buttonRidingPlayerTrue);
    	this.buttonList.add(GuiVM.buttonRidingPlayerFalse);
    	this.buttonList.add(GuiVM.buttonUndo);
		
		if(Minecraft.getMinecraft().player.isCreative())
		{
			this.buttonList.add(GuiVM.button01);
		}
		else
		{
			if(References.isDateAroundNewYears(Calendar.getInstance())
			|| References.isDateAroundValentinesDay(Calendar.getInstance())
			|| References.isDateAroundEaster(Calendar.getInstance())
			|| References.isDateAroundIndependenceDay(Calendar.getInstance())
			|| References.isDateAroundHalloween(Calendar.getInstance())
			|| References.isDateAroundThanksgiving(Calendar.getInstance())
			|| References.isDateAroundChristmas(Calendar.getInstance()))
			{
				this.buttonList.add(GuiVM.button11);
			}
		}
    	
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
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizePrimarySkinTexture());
		}
		
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomize());
		}
		
		// All main texture buttons:
		if (parButton.id >= 100
		&& parButton.id <= 199)
		{
			this.machineTexture = (parButton.id - 100);
		}
		
		// Holiday Normal:
		if (parButton.id == 1111)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizePrimarySkinTextureHoliday());
	    }
		// Holiday Creative:
		if (parButton.id == 1101)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizePrimarySkinTextureHolidayCreative());
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
		this.drawRect(this.guiLeft +8, this.guiTop + 6, this.guiLeft +168, this.guiTop + 64, Color.GRAY.getRGB());
		
		// Current texture:
		if (this.machine.getVisualFrameTexture() < 1000)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(EnumsVM.VisualMachineTexture.byId(this.machine.getVisualFrameTexture()).getBlock(), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
		
		// Colors, binds, and draws the background texture:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Render Preview Entity of Machine:
		this.drawEntityOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 13, this.machine, this.modelRidingEntity);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Current Texture:
		if (this.machine.getVisualFrameTexture() >= 1000)
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
				if(References.isDateAroundChristmas(Calendar.getInstance()))
				{
					if (this.machine.getVisualFrameTexture() == 1060)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 0), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1061)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 1), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1062)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 2), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1063)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 3), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1064)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 4), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1065)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 5), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1066)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 6), 0, 32, 32);
					}
					if (this.machine.getVisualFrameTexture() == 1067)
					{
						this.drawTexturedModalRect((56 * 0), 0, (32 * 7), 0, 32, 32);
					}
				}
			}
			GlStateManager.popMatrix();
		}
		
		// 'Primary Texture':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.primarycolor.primarytexture.0"), 0, 0, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// 'Current Texture':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.25, 53, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.currenttexture.0"), 0, 0, Color.BLUE.getRGB());
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
		
		//--------------------------------------------------
		
		// Renders the default row blocks over buttons:
		GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
	    	GlStateManager.translate(39-26, 89.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawItemStack(EnumsVM.VisualMachineTexture.DEFAULT.getBlock(), ((14 * 1) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualMachineTexture.COBBLESTONE.getBlock(), ((14 * 2) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualMachineTexture.SANDSTONE.getBlock(), ((14 * 3) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualMachineTexture.SNOW.getBlock(), ((14 * 4) * 2), 0, "");
			this.drawItemStack(EnumsVM.VisualMachineTexture.HAY_BLOCK.getBlock(), ((14 * 5) * 2), 0, "");
		}
		GlStateManager.popMatrix();
		
		// Renders the Tier 1 row blocks over buttons:
		if (this.machine.getTierFrame() >= 1)
		{
			GlStateManager.pushMatrix();
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
		    	GlStateManager.translate(39-26, 91+18.75, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_OAK.getBlock(), ((14 * 0) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_SPRUCE.getBlock(), ((14 * 1) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_BIRCH.getBlock(), ((14 * 2) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_JUNGLE.getBlock(), ((14 * 3) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_ACACIA.getBlock(), ((14 * 4) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PLANK_DARK_OAK.getBlock(), ((14 * 5) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PODZOL.getBlock(), ((14 * 6) * 2), 0, "");
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_OAK.getBlock(), ((14 * 0) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_SPRUCE.getBlock(), ((14 * 1) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_BIRCH.getBlock(), ((14 * 2) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_JUNGLE.getBlock(), ((14 * 3) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_ACACIA.getBlock(), ((14 * 4) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LOG_DARK_OAK.getBlock(), ((14 * 5) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.MYCELIUM.getBlock(), ((14 * 6) * 2), 28, "");
			}
			GlStateManager.popMatrix();
		}
		else
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 112, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Frame Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 118, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_FRAME_TIER1.getUnlocalizedName() + ".name"), 0, 8, Color.YELLOW.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// Renders the Tier 2 row blocks over buttons:
		if (this.machine.getTierFrame() >= 2)
		{
			GlStateManager.pushMatrix();
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
		    	GlStateManager.translate(39-26, 89+50.75, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_QUARTZ.getBlock(), ((14 * 0) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_IRON.getBlock(), ((14 * 1) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_GOLD.getBlock(), ((14 * 2) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_REDSTONE.getBlock(), ((14 * 3) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_LAPIS_LAZULI.getBlock(), ((14 * 4) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_DIAMOND.getBlock(), ((14 * 5) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ORE_EMERALD.getBlock(), ((14 * 6) * 2), 0, "");
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.BRICK.getBlock(), ((14 * 0) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.IRON.getBlock(), ((14 * 1) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.GOLD.getBlock(), ((14 * 2) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.REDSTONE.getBlock(), ((14 * 3) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LAPIS_LAZULI.getBlock(), ((14 * 4) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.DIAMOND.getBlock(), ((14 * 5) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.EMERALD.getBlock(), ((14 * 6) * 2), 28, "");
			}
			GlStateManager.popMatrix();
		}
		else
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 112+30, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Frame Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 118+30, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_FRAME_TIER2.getUnlocalizedName() + ".name"), 0, 8, Color.CYAN.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// Renders the Tier 3 row blocks over buttons:
		if (this.machine.getTierFrame() >= 3)
		{
			GlStateManager.pushMatrix();
			{
				GL11.glColor4f(1F, 1F, 1F, 1F);
				
		    	GlStateManager.translate(39-26, 87+50.75 + 32, 0);
				GlStateManager.scale(0.5F, 0.5F, 0.5F);
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.ICE.getBlock(), ((14 * 0) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.SLIME.getBlock(), ((14 * 1) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.NETHER_BRICK.getBlock(), ((14 * 2) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.SOUL_SAND.getBlock(), ((14 * 3) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.QUARTZ.getBlock(), ((14 * 4) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.GLOWSTONE.getBlock(), ((14 * 5) * 2), 0, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.OBSIDIAN.getBlock(), ((14 * 6) * 2), 0, "");
				
				this.drawItemStack(EnumsVM.VisualMachineTexture.BEDROCK.getBlock(), ((14 * 0) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PRISMARINE.getBlock(), ((14 * 1) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.END_STONE.getBlock(), ((14 * 2) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.PURPUR.getBlock(), ((14 * 3) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.WATER.getBlock(), ((14 * 4) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.LAVA.getBlock(), ((14 * 5) * 2), 28, "");
				this.drawItemStack(EnumsVM.VisualMachineTexture.ENDER.getBlock(), ((14 * 6) * 2), 28, "");
			}
			GlStateManager.popMatrix();
		}
		else
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 112+60, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Frame Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5, 118+60, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_FRAME_TIER3.getUnlocalizedName() + ".name"), 0, 8, Color.MAGENTA.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(130, 75, 168, 76, Color.BLACK.getRGB());
		
		// Colors and binds the background texture:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Preview Left Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(110, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 16, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Right Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(122, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 28, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Steve head symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(132, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 40, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Steve head 'X' symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(142, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 52, 12, 12);
		}
		GlStateManager.popMatrix();
		// Preview Undo symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(161, 69, 0);
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		this.mouseOverTooltipHandler(mouseX, mouseY);
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Turn Left:
		if(mouseX >= this.guiLeft + 110 && mouseX <= this.guiLeft + 115
		&& mouseY >= this.guiTop + 68 && mouseY <= this.guiTop + 73)
		{
			if(this.isShiftKeyDown())
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturnleft.0"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturn.0"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		// Logic for mouse-over tooltip - Turn Right:
		if(mouseX >= this.guiLeft + 122 && mouseX <= this.guiLeft + 127
		&& mouseY >= this.guiTop + 68 && mouseY <= this.guiTop + 73)
		{
			if(this.isShiftKeyDown())
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturnright.0"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
			else
			{
				List<String> text = new ArrayList<String>();
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.general.previewturn.0"));
				
				GlStateManager.pushMatrix();
				{
					int textNumber = text.toString().length();
					
					GlStateManager.translate(mouseX - this.guiLeft + 3 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
					GlStateManager.scale(0.5, 0.5, 0.5);
					
					this.drawHoveringText(text, 0, 0);
				}
				GlStateManager.popMatrix();
			}
		}
		
		// Logic for mouse-over tooltip - Accept:
		if(mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop + 63 && mouseY <= this.guiTop + 63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (!GuiVM.buttonApply.enabled
				&& this.machine.getEnergy() < CostsVM.COST_FRAME_TEXTURE
				&& !player.isCreative())
				{
					text.add(TextFormatting.DARK_RED + "" + CostsVM.COST_FRAME_TEXTURE + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
				}
        		else if (!GuiVM.buttonApply.enabled)
				{
					text.add(TextFormatting.RED + References.localNameVC("viesmachines.gui.tt.customize.color.cost.0"));
				}
				else if (player.isCreative())
				{
					text.add(TextFormatting.GREEN + References.localNameVC("viesmachines.gui.tt.customize.color.cost.5"));
				}
        		else if (this.machineTexture == 0
        		&& this.machineTexture != this.machine.getVisualFrameTexture())
				{
        			text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.3"));
				}
				else
				{
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_FRAME_TEXTURE + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
				}
        	}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = text.toString().length();
				
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
        if (this.machine.getControllingPassenger() instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
    		
    		if (this.machineTexture == this.machine.getVisualFrameTexture())
    		{
    			GuiVM.buttonApply.enabled = false;
    		}
    		else if (this.machineTexture == 0)
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else if (player.isCreative())
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else if (this.machine.getEnergy() >= CostsVM.COST_FRAME_TEXTURE)
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else
    		{
    			GuiVM.buttonApply.enabled = false;
    		}
    	}
        
        //--------------------------------------------------
        
        // Deals with the Preview player buttons toggle:
        if(!this.modelRidingEntity)
		{
        	GuiVM.buttonRidingPlayerTrue.enabled = true;
			GuiVM.buttonRidingPlayerFalse.enabled = false;
		}
		else
		{
			GuiVM.buttonRidingPlayerTrue.enabled = false;
			GuiVM.buttonRidingPlayerFalse.enabled = true;
		}
        
        // Turn machine preview left with shift down:
        if (GuiVM.buttonRotateLeft.isMouseOver() 
		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal - 2;
 		}
 		// Turn machine preview right with shift down:
 		if (GuiVM.buttonRotateRight.isMouseOver()
 		&& this.isShiftKeyDown())
 	    {
 			this.modelRotationHorizontal = this.modelRotationHorizontal + 2;
 		}
 		
 		this.buttonHandler();
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
			text.add(TextFormatting.GREEN + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(EnumsVM.VisualMachineTexture.byId(enumIn).getLocalizedName()));
			
			GlStateManager.pushMatrix();
			{
				int textNumber = References.Old_I18n.translateToLocal(EnumsVM.VisualMachineTexture.byId(enumIn).getLocalizedName()).length();
				
				GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop - 11, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
	}
	
	/** Deals with visibility and enabled texture buttons: */
	protected void buttonHandler()
	{
		// Tier 1:
		if (this.machine.getTierFrame() >= 1)
		{
			GuiVM.buttonTexture05.visible = true;
			GuiVM.buttonTexture06.visible = true;
			GuiVM.buttonTexture07.visible = true;
			GuiVM.buttonTexture08.visible = true;
			GuiVM.buttonTexture09.visible = true;
			GuiVM.buttonTexture10.visible = true;
			GuiVM.buttonTexture11.visible = true;
			
			GuiVM.buttonTexture12.visible = true;
			GuiVM.buttonTexture13.visible = true;
			GuiVM.buttonTexture14.visible = true;
			GuiVM.buttonTexture15.visible = true;
			GuiVM.buttonTexture16.visible = true;
			GuiVM.buttonTexture17.visible = true;
			GuiVM.buttonTexture18.visible = true;
		}
		else
		{
			GuiVM.buttonTexture05.visible = false;
			GuiVM.buttonTexture06.visible = false;
			GuiVM.buttonTexture07.visible = false;
			GuiVM.buttonTexture08.visible = false;
			GuiVM.buttonTexture09.visible = false;
			GuiVM.buttonTexture10.visible = false;
			GuiVM.buttonTexture11.visible = false;
			
			GuiVM.buttonTexture12.visible = false;
			GuiVM.buttonTexture13.visible = false;
			GuiVM.buttonTexture14.visible = false;
			GuiVM.buttonTexture15.visible = false;
			GuiVM.buttonTexture16.visible = false;
			GuiVM.buttonTexture17.visible = false;
			GuiVM.buttonTexture18.visible = false;
		}
		
		// Tier 2:
		if (this.machine.getTierFrame() >= 2)
		{
			GuiVM.buttonTexture19.visible = true;
			GuiVM.buttonTexture20.visible = true;
			GuiVM.buttonTexture21.visible = true;
			GuiVM.buttonTexture22.visible = true;
			GuiVM.buttonTexture23.visible = true;
			GuiVM.buttonTexture24.visible = true;
			GuiVM.buttonTexture25.visible = true;
			
			GuiVM.buttonTexture26.visible = true;
			GuiVM.buttonTexture27.visible = true;
			GuiVM.buttonTexture28.visible = true;
			GuiVM.buttonTexture29.visible = true;
			GuiVM.buttonTexture30.visible = true;
			GuiVM.buttonTexture31.visible = true;
			GuiVM.buttonTexture32.visible = true;
		}
		else
		{
			GuiVM.buttonTexture19.visible = false;
			GuiVM.buttonTexture20.visible = false;
			GuiVM.buttonTexture21.visible = false;
			GuiVM.buttonTexture22.visible = false;
			GuiVM.buttonTexture23.visible = false;
			GuiVM.buttonTexture24.visible = false;
			GuiVM.buttonTexture25.visible = false;
			
			GuiVM.buttonTexture26.visible = false;
			GuiVM.buttonTexture27.visible = false;
			GuiVM.buttonTexture28.visible = false;
			GuiVM.buttonTexture29.visible = false;
			GuiVM.buttonTexture30.visible = false;
			GuiVM.buttonTexture31.visible = false;
			GuiVM.buttonTexture32.visible = false;
		}
		
		// Tier 3:
		if (this.machine.getTierFrame() >= 3)
		{
			GuiVM.buttonTexture33.visible = true;
			GuiVM.buttonTexture34.visible = true;
			GuiVM.buttonTexture35.visible = true;
			GuiVM.buttonTexture36.visible = true;
			GuiVM.buttonTexture37.visible = true;
			GuiVM.buttonTexture38.visible = true;
			GuiVM.buttonTexture39.visible = true;
			
			GuiVM.buttonTexture40.visible = true;
			GuiVM.buttonTexture41.visible = true;
			GuiVM.buttonTexture42.visible = true;
			GuiVM.buttonTexture43.visible = true;
			GuiVM.buttonTexture44.visible = true;
			GuiVM.buttonTexture45.visible = true;
			GuiVM.buttonTexture46.visible = true;
		}
		else
		{
			GuiVM.buttonTexture33.visible = false;
			GuiVM.buttonTexture34.visible = false;
			GuiVM.buttonTexture35.visible = false;
			GuiVM.buttonTexture36.visible = false;
			GuiVM.buttonTexture37.visible = false;
			GuiVM.buttonTexture38.visible = false;
			GuiVM.buttonTexture39.visible = false;
			
			GuiVM.buttonTexture40.visible = false;
			GuiVM.buttonTexture41.visible = false;
			GuiVM.buttonTexture42.visible = false;
			GuiVM.buttonTexture43.visible = false;
			GuiVM.buttonTexture44.visible = false;
			GuiVM.buttonTexture45.visible = false;
			GuiVM.buttonTexture46.visible = false;
		}
		
		//==================================================
		
		if(this.machine.getVisualFrameTexture() == 0)
		{
			GuiVM.buttonTexture00.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture00.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 1)
		{
			GuiVM.buttonTexture01.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture01.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 2)
		{
			GuiVM.buttonTexture02.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture02.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 3)
		{
			GuiVM.buttonTexture03.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture03.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 4)
		{
			GuiVM.buttonTexture04.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture04.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualFrameTexture() == 5)
		{
			GuiVM.buttonTexture05.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture05.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 6)
		{
			GuiVM.buttonTexture06.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture06.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 7)
		{
			GuiVM.buttonTexture07.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture07.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 8)
		{
			GuiVM.buttonTexture08.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture08.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 9)
		{
			GuiVM.buttonTexture09.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture09.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 10)
		{
			GuiVM.buttonTexture10.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture10.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 11)
		{
			GuiVM.buttonTexture11.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture11.enabled = true;
		}
		
		if(this.machine.getVisualFrameTexture() == 12)
		{
			GuiVM.buttonTexture12.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture12.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 13)
		{
			GuiVM.buttonTexture13.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture13.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 14)
		{
			GuiVM.buttonTexture14.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture14.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 15)
		{
			GuiVM.buttonTexture15.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture15.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 16)
		{
			GuiVM.buttonTexture16.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture16.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 17)
		{
			GuiVM.buttonTexture17.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture17.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 18)
		{
			GuiVM.buttonTexture18.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture18.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualFrameTexture() == 19)
		{
			GuiVM.buttonTexture19.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture19.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 20)
		{
			GuiVM.buttonTexture20.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture20.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 21)
		{
			GuiVM.buttonTexture21.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture21.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 22)
		{
			GuiVM.buttonTexture22.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture22.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 23)
		{
			GuiVM.buttonTexture23.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture23.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 24)
		{
			GuiVM.buttonTexture24.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture24.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 25)
		{
			GuiVM.buttonTexture25.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture25.enabled = true;
		}
		
		if(this.machine.getVisualFrameTexture() == 26)
		{
			GuiVM.buttonTexture26.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture26.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 27)
		{
			GuiVM.buttonTexture27.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture27.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 28)
		{
			GuiVM.buttonTexture28.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture28.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 29)
		{
			GuiVM.buttonTexture29.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture29.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 30)
		{
			GuiVM.buttonTexture30.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture30.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 31)
		{
			GuiVM.buttonTexture31.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture31.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 32)
		{
			GuiVM.buttonTexture32.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture32.enabled = true;
		}
		
		//--------------------------------------------------
		
		if(this.machine.getVisualFrameTexture() == 33)
		{
			GuiVM.buttonTexture33.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture33.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 34)
		{
			GuiVM.buttonTexture34.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture34.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 35)
		{
			GuiVM.buttonTexture35.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture35.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 36)
		{
			GuiVM.buttonTexture36.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture36.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 37)
		{
			GuiVM.buttonTexture37.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture37.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 38)
		{
			GuiVM.buttonTexture38.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture38.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 39)
		{
			GuiVM.buttonTexture39.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture39.enabled = true;
		}
		
		if(this.machine.getVisualFrameTexture() == 40)
		{
			GuiVM.buttonTexture40.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture40.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 41)
		{
			GuiVM.buttonTexture41.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture41.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 42)
		{
			GuiVM.buttonTexture42.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture42.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 43)
		{
			GuiVM.buttonTexture43.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture43.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 44)
		{
			GuiVM.buttonTexture44.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture44.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 45)
		{
			GuiVM.buttonTexture45.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture45.enabled = true;
		}
		if(this.machine.getVisualFrameTexture() == 46)
		{
			GuiVM.buttonTexture46.enabled = false;
		}
		else
		{
			GuiVM.buttonTexture46.enabled = true;
		}
	}
	
	/** Handles all of the mouseover tooltip names for all texture buttons. */
	protected void mouseOverTooltipHandler(int mouseX, int mouseY) 
	{
		// Default Row:
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 86, EnumsVM.VisualMachineTexture.DEFAULT.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 86, EnumsVM.VisualMachineTexture.COBBLESTONE.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 86, EnumsVM.VisualMachineTexture.SANDSTONE.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 86, EnumsVM.VisualMachineTexture.SNOW.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 86, EnumsVM.VisualMachineTexture.HAY_BLOCK.getMetadata());
		
		//--------------------------------------------------
		
		// Tier 1 Row:
		if (this.machine.getTierFrame() >= 1)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 106, EnumsVM.VisualMachineTexture.PLANK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 106, EnumsVM.VisualMachineTexture.PLANK_SPRUCE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 106, EnumsVM.VisualMachineTexture.PLANK_BIRCH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 106, EnumsVM.VisualMachineTexture.PLANK_JUNGLE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 106, EnumsVM.VisualMachineTexture.PLANK_ACACIA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 106, EnumsVM.VisualMachineTexture.PLANK_DARK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 106, EnumsVM.VisualMachineTexture.PODZOL.getMetadata());
			
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_SPRUCE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_BIRCH.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_JUNGLE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_ACACIA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 106 + (14 * 1), EnumsVM.VisualMachineTexture.LOG_DARK_OAK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 106 + (14 * 1), EnumsVM.VisualMachineTexture.MYCELIUM.getMetadata());
		}
		
		//--------------------------------------------------
		
		// Tier 2 Row:
		if (this.machine.getTierFrame() >= 2)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 136, EnumsVM.VisualMachineTexture.ORE_QUARTZ.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 136, EnumsVM.VisualMachineTexture.ORE_IRON.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 136, EnumsVM.VisualMachineTexture.ORE_GOLD.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 136, EnumsVM.VisualMachineTexture.ORE_REDSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 136, EnumsVM.VisualMachineTexture.ORE_LAPIS_LAZULI.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 136, EnumsVM.VisualMachineTexture.ORE_DIAMOND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 136, EnumsVM.VisualMachineTexture.ORE_EMERALD.getMetadata());
	
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 136 + (14 * 1), EnumsVM.VisualMachineTexture.BRICK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 136 + (14 * 1), EnumsVM.VisualMachineTexture.IRON.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 136 + (14 * 1), EnumsVM.VisualMachineTexture.GOLD.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 136 + (14 * 1), EnumsVM.VisualMachineTexture.REDSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 136 + (14 * 1), EnumsVM.VisualMachineTexture.LAPIS_LAZULI.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 136 + (14 * 1), EnumsVM.VisualMachineTexture.DIAMOND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 136 + (14 * 1), EnumsVM.VisualMachineTexture.EMERALD.getMetadata());
		}
		
		//--------------------------------------------------
		
		// Tier 3 Row:
		if (this.machine.getTierFrame() >= 3)
		{
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 166, EnumsVM.VisualMachineTexture.ICE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 166, EnumsVM.VisualMachineTexture.SLIME.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 166, EnumsVM.VisualMachineTexture.NETHER_BRICK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 166, EnumsVM.VisualMachineTexture.SOUL_SAND.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 166, EnumsVM.VisualMachineTexture.QUARTZ.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 166, EnumsVM.VisualMachineTexture.GLOWSTONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 166, EnumsVM.VisualMachineTexture.OBSIDIAN.getMetadata());
	
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 0), 166 + (14 * 1), EnumsVM.VisualMachineTexture.BEDROCK.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 1), 166 + (14 * 1), EnumsVM.VisualMachineTexture.PRISMARINE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 2), 166 + (14 * 1), EnumsVM.VisualMachineTexture.END_STONE.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 3), 166 + (14 * 1), EnumsVM.VisualMachineTexture.PURPUR.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 4), 166 + (14 * 1), EnumsVM.VisualMachineTexture.WATER.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 5), 166 + (14 * 1), EnumsVM.VisualMachineTexture.LAVA.getMetadata());
			this.mouseOverTooltipNames(mouseX, mouseY, 32-26 + (14 * 6), 166 + (14 * 1), EnumsVM.VisualMachineTexture.ENDER.getMetadata());
		}
	}
	
	@Override
	protected void drawEntityOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn)
    {
		int oldTexture = this.machine.getVisualFrameTexture();
		
		this.machine.setVisualFrameTexture(this.machineTexture);
		
		super.drawEntityOnScreen(posX, posY, horizontalIn, scale, entityIn, ridingEntityIn);
		
		this.machine.setVisualFrameTexture(oldTexture);
    }
}

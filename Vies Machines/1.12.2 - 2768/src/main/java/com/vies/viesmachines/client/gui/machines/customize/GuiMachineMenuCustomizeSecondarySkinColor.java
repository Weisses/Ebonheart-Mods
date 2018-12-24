package com.vies.viesmachines.client.gui.machines.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.ColorHelperVM;
import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeSecondarySkinColor extends GuiContainerVM {
	
	private GuiTextField textRed;
	private GuiTextField textGreen;
	private GuiTextField textBlue;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_color.png");
	
	public GuiMachineMenuCustomizeSecondarySkinColor(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
		
		this.machineColorActive = this.machine.getVisualComponentColor();
		this.textRedNumber = this.machine.getVisualComponentColorRed();
		this.textGreenNumber = this.machine.getVisualComponentColorGreen();
		this.textBlueNumber = this.machine.getVisualComponentColorBlue();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
        this.textRed = new GuiTextField(11, this.fontRenderer, this.guiLeft + 8+2, this.guiTop + 56, 26, 18);
        textRed.setMaxStringLength(3);
        textRed.setText(String.valueOf(this.textRedNumber));
    	this.textRed.setFocused(false);
    	this.textRed.setTextColor(Color.RED.getRGB());
    	
    	this.textGreen = new GuiTextField(12, this.fontRenderer, this.guiLeft + 41+1, this.guiTop + 56, 26, 18);
        textGreen.setMaxStringLength(3);
        textGreen.setText(String.valueOf(this.textGreenNumber));
    	this.textGreen.setFocused(false);
    	this.textGreen.setTextColor(Color.GREEN.getRGB());
    	
    	this.textBlue = new GuiTextField(13, this.fontRenderer, this.guiLeft + 74, this.guiTop + 56, 26, 18);
        textBlue.setMaxStringLength(3);
        textBlue.setText(String.valueOf(this.textBlueNumber));
    	this.textBlue.setFocused(false);
    	this.textBlue.setTextColor(Color.BLUE.getRGB());
    	
        //--------------------------------------------------
        
    	GuiVM.buttonRotateLeft = new GuiButtonGeneral2VM(10, this.guiLeft + 110, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VM(10, this.guiLeft + 122, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRidingPlayerTrue = new GuiButtonGeneral1VM(12, this.guiLeft + 130, this.guiTop + 66, 10, 10, "", 1);
    	GuiVM.buttonRidingPlayerFalse = new GuiButtonGeneral1VM(13, this.guiLeft + 140, this.guiTop + 66, 10, 10, "", 2);
    	GuiVM.buttonUndo = new GuiButtonGeneral2VM(11, this.guiLeft + 158, this.guiTop + 66, 10, 10, "", 1);
		
    	GuiVM.button00 = new GuiButtonGeneral2VM(20, this.guiLeft + 7, this.guiTop + 81, 42, 14, References.localNameVC("viesmachines.button.remove"), 0);
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(21, this.guiLeft + 7, this.guiTop + 99, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 99, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
    	
		// Red:
    	GuiVM.button01 = new GuiButtonGeneral1VM(201, this.guiLeft + 25, this.guiTop + 119, 42, 14, References.localNameVC("viesmachines.item.color.114"), 0);
    	// Green:
    	GuiVM.button02 = new GuiButtonGeneral1VM(202, this.guiLeft + 67, this.guiTop + 119, 42, 14, References.localNameVC("viesmachines.item.color.77"), 0);
    	// Blue:
    	GuiVM.button03 = new GuiButtonGeneral1VM(203, this.guiLeft + 109, this.guiTop + 119, 42, 14, References.localNameVC("viesmachines.item.color.10"), 0);
    	
    	// Yellow:
    	GuiVM.button04 = new GuiButtonGeneral1VM(204, this.guiLeft + 25, this.guiTop + 119 + (14 * 1), 42, 14, References.localNameVC("viesmachines.item.color.139"), 0);
    	// Magenta:
    	GuiVM.button05 = new GuiButtonGeneral1VM(205, this.guiLeft + 67, this.guiTop + 119 + (14 * 1), 42, 14, References.localNameVC("viesmachines.item.color.46"), 0);
    	// Cyan:
    	GuiVM.button06 = new GuiButtonGeneral1VM(206, this.guiLeft + 109, this.guiTop + 119 + (14 * 1), 42, 14, References.localNameVC("viesmachines.item.color.3"), 0);
    	
    	// Orange:
    	GuiVM.button07 = new GuiButtonGeneral1VM(207, this.guiLeft + 25, this.guiTop + 119 + (14 * 2), 42, 14, References.localNameVC("viesmachines.item.color.100"), 0);
    	// Purple:
    	GuiVM.button08 = new GuiButtonGeneral1VM(208, this.guiLeft + 67, this.guiTop + 119 + (14 * 2), 42, 14, References.localNameVC("viesmachines.item.color.113"), 0);
    	// Teal:
    	GuiVM.button09 = new GuiButtonGeneral1VM(209, this.guiLeft + 109, this.guiTop + 119 + (14 * 2), 42, 14, References.localNameVC("viesmachines.item.color.131"), 0);
    	
    	// Crimson:
    	GuiVM.button10 = new GuiButtonGeneral1VM(210, this.guiLeft + 25, this.guiTop + 119 + (14 * 3), 42, 14, References.localNameVC("viesmachines.item.color.20"), 0);
    	// Black:
    	GuiVM.button11 = new GuiButtonGeneral1VM(211, this.guiLeft + 67, this.guiTop + 119 + (14 * 3), 42, 14, References.localNameVC("viesmachines.item.color.8"), 0);
    	// White:
    	GuiVM.button12 = new GuiButtonGeneral1VM(212, this.guiLeft + 109, this.guiTop + 119 + (14 * 3), 42, 14, References.localNameVC("viesmachines.item.color.137"), 0);
    	
    	//--------------------------------------------------
		
		this.buttonList.add(GuiVM.button01);
		this.buttonList.add(GuiVM.button02);
		this.buttonList.add(GuiVM.button03);
		this.buttonList.add(GuiVM.button04);
		this.buttonList.add(GuiVM.button05);
		this.buttonList.add(GuiVM.button06);
		this.buttonList.add(GuiVM.button07);
		this.buttonList.add(GuiVM.button08);
		this.buttonList.add(GuiVM.button09);
		this.buttonList.add(GuiVM.button10);
		this.buttonList.add(GuiVM.button11);
		this.buttonList.add(GuiVM.button12);
		
		this.buttonList.add(GuiVM.button00);
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonRotateLeft);
    	this.buttonList.add(GuiVM.buttonRotateRight);
    	this.buttonList.add(GuiVM.buttonRidingPlayerTrue);
    	this.buttonList.add(GuiVM.buttonRidingPlayerFalse);
    	this.buttonList.add(GuiVM.buttonUndo);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Remove:
		if (parButton.id == 20)
		{
			this.machineColorActive = false;
			this.textRedNumber = 0;
			this.textGreenNumber = 0;
			this.textBlueNumber = 0;
			
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondarySkinColorDefault());
		}
		
		// Apply:
		if (parButton.id == 21)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondarySkinColorApply());
		}
		
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomize());
		}
		
		//--------------------------------------------------
		
		// Red:
    	if (parButton.id == 201)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 255;
			this.textGreenNumber = 0;
			this.textBlueNumber = 0;
	    }
    	// Green:
    	if (parButton.id == 202)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 0;
			this.textGreenNumber = 255;
			this.textBlueNumber = 0;
	    }
    	// Blue:
    	if (parButton.id == 203)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 0;
			this.textGreenNumber = 0;
			this.textBlueNumber = 255;
	    }
    	// Yellow:
    	if (parButton.id == 204)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 255;
			this.textGreenNumber = 255;
			this.textBlueNumber = 0;
	    }
		// Magenta:
    	if (parButton.id == 205)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 255;
			this.textGreenNumber = 0;
			this.textBlueNumber = 255;
	    }
    	// Cyan:
    	if (parButton.id == 206)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 0;
			this.textGreenNumber = 255;
			this.textBlueNumber = 255;
	    }
    	// Orange:
    	if (parButton.id == 207)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 255;
			this.textGreenNumber = 165;
			this.textBlueNumber = 0;
	    }
    	// Purple:
    	if (parButton.id == 208)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 128;
			this.textGreenNumber = 0;
			this.textBlueNumber = 128;
	    }
    	// Teal:
    	if (parButton.id == 209)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 0;
			this.textGreenNumber = 128;
			this.textBlueNumber = 128;
	    }
    	// Crimson:
    	if (parButton.id == 210)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 220;
			this.textGreenNumber = 20;
			this.textBlueNumber = 60;
	    }
    	// Black:
    	if (parButton.id == 211)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 0;
			this.textGreenNumber = 0;
			this.textBlueNumber = 0;
	    }
    	// White:
    	if (parButton.id == 212)
	    {
    		this.machineColorActive = true;
			this.textRedNumber = 255;
			this.textGreenNumber = 255;
			this.textBlueNumber = 255;
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
		this.drawRect(this.guiLeft + 108, this.guiTop + 6, this.guiLeft + 168, this.guiTop + 64, Color.GRAY.getRGB());
		
		// Draws a black box behind the r/g/b input boxes:
		this.drawRect(this.guiLeft + 8, this.guiTop + 6, this.guiLeft + 108, this.guiTop + 84, Color.BLACK.getRGB());
		
		// Draws a black box behind the color name:
		this.drawRect(this.guiLeft + 108, this.guiTop + 78, this.guiLeft + 168, this.guiTop + 100, Color.BLACK.getRGB());
		
		// Colors, binds, and draws the background texture:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		float red = this.textRedNumber / 255.0F;
        float green = this.textGreenNumber / 255.0F;
        float blue = this.textBlueNumber / 255.0F;
        
        // Color Box made from the r/g/b values:
        GlStateManager.color(red, green, blue, 1.0F);
        this.drawTexturedModalRect(this.guiLeft + 108, this.guiTop + 91, 176, 65, 64, 25);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		
        // Color name of the Color Box made from the r/g/b values:
  		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 138.25, this.guiTop + 82.5, 0);
  			GlStateManager.scale(.65, .65, .65);
      		
  			if (this.machineColorActive)
  			{
  				this.centeredString(getFontRenderer(), ColorHelperVM.getColorNameFromRgb(this.textRedNumber, this.textGreenNumber, this.textBlueNumber), 0, 0, Color.WHITE.getRGB());
  			}
  			else
  			{
  				this.centeredString(getFontRenderer(), References.localNameVC("viesmachines.button.none"), 0, 0, Color.WHITE.getRGB());
  			}
		}
		GlStateManager.popMatrix();
		
        // Red label:
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 23.5, this.guiTop + 32.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("viesmachines.main.red"), 0, 0, Color.RED.getRGB());
		}
		GlStateManager.popMatrix();
		// Green label:
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 55.5, this.guiTop + 32.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("viesmachines.main.green"), 0, 0, Color.GREEN.getRGB());
		}
		GlStateManager.popMatrix();;
		// Blue label:
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 87.5, this.guiTop + 32.5, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, References.localNameVC("viesmachines.main.blue"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Red label '0-255':
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 23.5, this.guiTop + 46, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		// Green label '0-255':
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 55.5, this.guiTop + 46, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();;
		// Blue label '0-255':
		GlStateManager.pushMatrix();
  		{
  			GlStateManager.translate(this.guiLeft + 87.5, this.guiTop + 46, 0);
  			GlStateManager.scale(0.75F, 0.75F, 0.75F);
      		
  			this.drawCenteredString(fontRenderer, "0-255", 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
    	
		// Draws the 3 text boxes:
    	this.textRed.drawTextBox();
    	this.textGreen.drawTextBox();
    	this.textBlue.drawTextBox();
    	
    	// Renders the 'Preview Entity' for the current machine:
    	this.drawEntityOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 11, this.machine, this.modelRidingEntity);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Secondary Color:
		GlStateManager.pushMatrix();
		{
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			
			this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.secondarycolor.secondarycolor.0"), 74, 16, Color.BLACK.getRGB());
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
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(130, 75, 168, 76, Color.BLACK.getRGB());
		
		// Colors and binds the background texture:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
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
		
		// Logic for mouse-over tooltip - Apply:
		if (mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop + 36+63 && mouseY <= this.guiTop + 36+63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (!GuiVM.buttonApply.enabled
				&& this.machine.getEnergy() < CostsVM.COST_COMPONENT_COLOR
				&& !player.isCreative())
				{
					text.add(TextFormatting.DARK_RED + "" + CostsVM.COST_COMPONENT_COLOR + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
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
        		&& this.machineTexture != this.machine.getVisualComponentTexture())
				{
        			text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.3"));
				}
				else
				{
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_COMPONENT_COLOR + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
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
		
		// Logic for mouse-over tooltip - Remove:
		if (mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop - 18+36+63 && mouseY <= this.guiTop - 18 +36+63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (!GuiVM.button00.enabled)
			{
				
			}
			else
			{
				text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.3"));
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
		super.keyTyped(typedChar, keyCode);
		
        this.textRed.textboxKeyTyped(typedChar, keyCode);
        this.textGreen.textboxKeyTyped(typedChar, keyCode);
        this.textBlue.textboxKeyTyped(typedChar, keyCode);
		
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
        
        // Fix invalid input in the Red box:
        if (textRed.getText() != null)
		{
    		try 
			{
				textRedNumber = Integer.parseInt(textRed.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textRed.setText("0");
				textRedNumber = 0;
			}
    		
			if(textRedNumber > 255)
			{
				textRed.setText("255");
				textRedNumber = 255;
			}
		}
        
        // Fix invalid input in the Green box:
        if (textGreen.getText() != null)
		{
    		try 
			{
				textGreenNumber = Integer.parseInt(textGreen.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textGreen.setText("0");
				textGreenNumber = 0;
			}
    		
			if(textGreenNumber > 255)
			{
				textGreen.setText("255");
				textGreenNumber = 255;
			}
		}
        
        // Fix invalid input in the Blue box:
        if (textBlue.getText() != null)
		{
    		try 
			{
				textBlueNumber = Integer.parseInt(textBlue.getText());
			} 
			catch(NumberFormatException ex) 
			{
				textBlue.setText("0");
				textBlueNumber = 0;
			}
    		
			if(textBlueNumber > 255)
			{
				textBlue.setText("255");
				textBlueNumber = 255;
			}
		}
        
        // Updates the cursor position of each box:
        this.textRed.updateCursorCounter();
        this.textGreen.updateCursorCounter();
        this.textBlue.updateCursorCounter();
        
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
 		
 		// Checks to see if the 'Apply' button is enabled:
 		if (this.machine.getVisualComponentColorRed() == this.textRedNumber
		&& this.machine.getVisualComponentColorGreen() == this.textGreenNumber
		&& this.machine.getVisualComponentColorBlue() == this.textBlueNumber)
 		{
 			GuiVM.buttonApply.enabled = false;
 		}
 		else if (this.mc.player.isCreative())
 		{
 			GuiVM.buttonApply.enabled = true;
 		}
 		else if (CostsVM.COST_COMPONENT_COLOR > this.machine.getEnergy())
 		{
 			GuiVM.buttonApply.enabled = false;
 		}
 		else
 		{
 			GuiVM.buttonApply.enabled = true;
 		}
 		
 		// Checks to see if the 'Remove' button is enabled:
 		if (this.machine.getVisualComponentColor())
 		{
 			GuiVM.button00.enabled = true;
 		}
 		else
 		{
 			GuiVM.button00.enabled = false;
 		}
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
        
        this.textRed.mouseClicked(x, y, btn);
        this.textGreen.mouseClicked(x, y, btn);
        this.textBlue.mouseClicked(x, y, btn);
    }
    
    @Override
    protected void drawEntityOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn)
    {
		EntityMachineBase machineIn = (EntityMachineBase)entityIn;
		
		boolean currentColor = machineIn.getVisualComponentColor();
    	int currentR = machineIn.getVisualComponentColorRed();
    	int currentG = machineIn.getVisualComponentColorGreen();
    	int currentB = machineIn.getVisualComponentColorBlue();
    	
    	machineIn.setVisualComponentColor(this.machineColorActive);
    	machineIn.setVisualComponentColorRed(this.textRedNumber);
    	machineIn.setVisualComponentColorGreen(this.textGreenNumber);
    	machineIn.setVisualComponentColorBlue(this.textBlueNumber);
        
        super.drawEntityOnScreen(posX, posY, horizontalIn, scale, entityIn, ridingEntityIn);
    	
        machineIn.setVisualComponentColor(currentColor);
    	machineIn.setVisualComponentColorRed(currentR);
    	machineIn.setVisualComponentColorGreen(currentG);
    	machineIn.setVisualComponentColorBlue(currentB);
    }
}

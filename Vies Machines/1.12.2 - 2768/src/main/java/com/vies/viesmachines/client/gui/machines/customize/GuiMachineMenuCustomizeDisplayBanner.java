package com.vies.viesmachines.client.gui.machines.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.lwjgl.input.Keyboard;

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
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayBlockItemPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplayHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageGuiMachineMenuCustomizeDisplaySymbolPg1;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayClear;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday;
import com.vies.viesmachines.network.server.machine.gui.customize.holiday.MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayCreative;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeDisplayBanner extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_banner.png");
	
	public GuiMachineMenuCustomizeDisplayBanner(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
		
		this.metaInfo = this.machine.getVisualEngineDisplayType();
		this.itemstackInfo = this.machine.getVisualEngineDisplayItemstack();
		this.itemstackMetaInfo = this.machine.getVisualEngineDisplayItemstackMeta();
		this.headInfo = this.machine.getVisualEngineDisplayHead();
		this.supporterHeadInfo = this.machine.getVisualEngineDisplaySupporterHead();
		this.holidayInfo = this.machine.getVisualEngineDisplayHoliday();
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
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VM(11, this.guiLeft + 122, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRidingPlayerTrue = new GuiButtonGeneral1VM(12, this.guiLeft + 130, this.guiTop + 66, 10, 10, "", 1);
    	GuiVM.buttonRidingPlayerFalse = new GuiButtonGeneral1VM(13, this.guiLeft + 140, this.guiTop + 66, 10, 10, "", 2);
    	GuiVM.buttonUndo = new GuiButtonGeneral2VM(11, this.guiLeft + 158, this.guiTop + 66, 10, 10, "", 1);
		
    	GuiVM.button00 = new GuiButtonGeneral2VM(20, this.guiLeft + 89, this.guiTop + 45, 14, 14, "", 1);
    	GuiVM.buttonApply = new GuiButtonGeneral2VM(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.remove"), 0);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		//--------------------------------------------------
		
		GuiVM.buttonT1 = new GuiButtonGeneral1VM(51, this.guiLeft + 17, this.guiTop + 92 + 12 + (18 * 0), 75, 14, References.localNameVC("viesmachines.button.symbols"), 0);
		GuiVM.buttonT2 = new GuiButtonGeneral1VM(52, this.guiLeft + 17, this.guiTop + 92 + 12 + (18 * 1), 75, 14, References.localNameVC("viesmachines.button.blockitems"), 0);
		GuiVM.buttonT3 = new GuiButtonGeneral1VM(53, this.guiLeft + 17, this.guiTop + 92 + 12 + (18 * 2), 75, 14, References.localNameVC("viesmachines.button.entityheads"), 0);
		GuiVM.buttonT4 = new GuiButtonGeneral1VM(54, this.guiLeft + 17, this.guiTop + 92 + 12 + (18 * 3), 75, 14, References.localNameVC("viesmachines.button.supporterheads"), 0);
		
		// Holidays:
		GuiVM.button11 = new GuiButtonGeneral2VM(1111, this.guiLeft + 67+40, this.guiTop + 92 - 16 + (14 * 2), 62, 14, this.stringToRainbow(holidayName, false), 2);
		
		// Creative:
		GuiVM.button01 = new GuiButtonGeneral2VM(1101, this.guiLeft + 67+40, this.guiTop + 92 - 16 + (14 * 2), 62, 14, this.stringToRainbow(References.localNameVC("viesmachines.button.holiday1"), false), 2);
		
		//--------------------------------------------------
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonT1);
		this.buttonList.add(GuiVM.buttonT2);
		this.buttonList.add(GuiVM.buttonT3);
		this.buttonList.add(GuiVM.buttonT4);
		
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
		
		// Clear:
		if (parButton.id == 21)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayClear());
		}
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomize());
		}
		
		// Menu Buttons:
		if (parButton.id == 51)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplaySymbolPg1());
	    }
		if (parButton.id == 52)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplayBlockItemPg1());
	    }
		if (parButton.id == 53)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplayHeadPg1());
	    }
		if (parButton.id == 54)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplaySupporterHeadPg1());
	    }
		
		// Holiday Normal:
		if (parButton.id == 1111)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplaySymbolPg1Holiday());
	    }
		// Holiday Creative:
		if (parButton.id == 1101)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplaySymbolPg1HolidayCreative());
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

		// Block/Item:
		if(this.machine.getVisualEngineDisplayType() == 1)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(new ItemStack(Item.getItemById(this.machine.getVisualEngineDisplayItemstack()), 1, this.machine.getVisualEngineDisplayItemstackMeta()), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
		// Entity Head:
		else if(this.machine.getVisualEngineDisplayType() == 2)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(4, -36, 0);
				
				this.drawEntityHead(0, 0, this.headInfo);
			}
			GlStateManager.popMatrix();
		}
		// Supporter Head:
		else if(this.machine.getVisualEngineDisplayType() == 3)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(4, -36, 0);
				
				this.drawEntitySupporterHead(0, 0, this.machine.getVisualEngineDisplaySupporterHead());
			}
			GlStateManager.popMatrix();
		}
		// Holiday:
		else if (this.machine.getVisualEngineDisplayType() >= 1000)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(EnumsVM.VisualDisplaySymbolHoliday.byId(this.machine.getVisualEngineDisplayType() - 1000).getItemStack(), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
		// Display Symbol:
		else if(this.machine.getVisualEngineDisplayType() >= 10)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(EnumsVM.VisualDisplaySymbol.byId(this.machine.getVisualEngineDisplayType() - 10).getItemStack(), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
		
		// Renders the 'Preview Entity' for the current machine:
		this.drawEntityOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 11, this.machine, this.modelRidingEntity);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Display Banner':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.displaybanner.0"), 0, 0, Color.BLACK.getRGB());
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
		&& mouseY >= this.guiTop +63 && mouseY <= this.guiTop +63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (!GuiVM.buttonApply.enabled)
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
        
        // Checks to see if the 'Remove' button is enabled:
        if(this.machine.getVisualEngineDisplayType() == 0)
        {
        	GuiVM.buttonApply.enabled = false;
        }
        else
        {
        	GuiVM.buttonApply.enabled = true;
        }
        
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
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
    }
}

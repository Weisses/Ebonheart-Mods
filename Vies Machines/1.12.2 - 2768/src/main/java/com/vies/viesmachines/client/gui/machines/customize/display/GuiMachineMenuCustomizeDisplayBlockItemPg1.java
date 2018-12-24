package com.vies.viesmachines.client.gui.machines.customize.display;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.MessageGuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplayBlockItem;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeDisplayBlockItemPg1 extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_blockitem.png");
	
	public GuiMachineMenuCustomizeDisplayBlockItemPg1(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineMenuCustomizeDisplayBanner(playerInv, airshipIn), playerInv, airshipIn);
		
		this.metaInfo = this.machine.getVisualEngineDisplayType();//.engineDisplayTypeVisual;
		this.itemstackInfo = this.machine.getVisualEngineDisplayItemstack();//.engineDisplayItemstackVisual;
		this.itemstackMetaInfo = this.machine.getVisualEngineDisplayItemstackMeta();//.engineDisplayItemstackMetaVisual;
		this.headInfo = this.machine.getVisualEngineDisplayHead();//.engineDisplayHeadVisual;
		this.supporterHeadInfo = this.machine.getVisualEngineDisplaySupporterHead();//.engineDisplaySupporterHeadVisual;
		this.holidayInfo = this.machine.getVisualEngineDisplayHoliday();//.engineDisplayHolidayVisual;
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
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
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
			this.metaInfo = 1;
			this.itemstackInfo = Item.getIdFromItem(this.machine.inventory.getStackInSlot(2).getItem());
			this.itemstackMetaInfo = this.machine.inventory.getStackInSlot(2).getMetadata();
			
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplayBlockItem());
		}
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplayBanner());
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
		
		// Renders the selected Display Banner for the current machine:
		if (!this.machine.inventory.getStackInSlot(2).isEmpty())
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(138, 43, 0);
				
				this.drawRotatingItemStack(new ItemStack(Item.getItemById(this.itemstackInfo), 1, this.itemstackMetaInfo), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Block/Item Options':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.blockitemoptions.0"), 0, 0, Color.BLACK.getRGB());
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
		
		// Instructions:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(124.25, 92, 0);
	        GlStateManager.scale(0.4F, 0.4F, 0.4F);
	        
	        // Instructions:
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.0") + ":", 0, 2, Color.RED.getRGB());
	        // Place any block/item from any mod:
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.1"), 0, 20, Color.WHITE.getRGB());
	        // into the slot to the left from here.:
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.2"), 0, 32, Color.WHITE.getRGB());
	        // Once the block/item is placed, simply:
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.3"), 0, 44, Color.WHITE.getRGB());
	        // click on apply! You can remove the
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.4"), 0, 56, Color.WHITE.getRGB());
	        // block/item after it is applied.
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.instructions.5"), 0, 68, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Draws a black box over the preview buttons:
		this.drawRect(108, 66, 130, 76, Color.BLACK.getRGB());
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Apply:
		if (mouseX >= this.guiLeft + 7 && mouseX <= this.guiLeft + 7+41
		&& mouseY >= this.guiTop +63 && mouseY <= this.guiTop +63+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
				if (!GuiVM.buttonApply.enabled
				&& this.machine.getEnergy() < CostsVM.COST_ENGINE_DISPLAY_SYMBOL
				&& !player.isCreative())
				{
					text.add(TextFormatting.DARK_RED + "" + CostsVM.COST_ENGINE_DISPLAY_SYMBOL + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
				}
				else if (!GuiVM.buttonApply.enabled)
				{
					text.add(TextFormatting.RED + References.localNameVC("viesmachines.gui.tt.customize.color.cost.0"));
				}
				else if (player.isCreative())
				{
					text.add(TextFormatting.GREEN + References.localNameVC("viesmachines.gui.tt.customize.color.cost.5"));
				}
				else
				{
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_ENGINE_DISPLAY_SYMBOL + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
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
        if (!this.machine.inventory.getStackInSlot(2).isEmpty())
		{
        	this.itemstackInfo = Item.getIdFromItem(this.machine.inventory.getStackInSlot(2).getItem());
			this.itemstackMetaInfo = this.machine.inventory.getStackInSlot(2).getMetadata();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (this.itemstackInfo == this.machine.getVisualEngineDisplayItemstack()
        		&& this.itemstackMetaInfo == this.machine.getVisualEngineDisplayItemstackMeta())
        		{
        			GuiVM.buttonApply.enabled = false;
        		}
        		else if (player.isCreative())
        		{
        			GuiVM.buttonApply.enabled = true;
        		}
        		else if (this.machine.getEnergy() >= CostsVM.COST_ENGINE_DISPLAY_SYMBOL)
        		{
        			GuiVM.buttonApply.enabled = true;
        		}
        		else
        		{
        			GuiVM.buttonApply.enabled = false;
        		}
        	}
		}
        else
        {
        	GuiVM.buttonApply.enabled = false;
        }
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
		if(mouseX >= this.guiLeft + xIn && mouseX <= this.guiLeft + xIn + 14
		&& mouseY >= this.guiTop + yIn && mouseY <= this.guiTop + yIn + 14)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.GREEN + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(EnumsVM.VisualDisplaySymbol.byId(enumIn).getLocalizedName()));
			
			GlStateManager.pushMatrix();
			{
				int textNumber = text.toString().length();
				
				GlStateManager.translate(mouseX - this.guiLeft - (textNumber*2) -(textNumber/2), mouseY - this.guiTop - 11, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
	}
}

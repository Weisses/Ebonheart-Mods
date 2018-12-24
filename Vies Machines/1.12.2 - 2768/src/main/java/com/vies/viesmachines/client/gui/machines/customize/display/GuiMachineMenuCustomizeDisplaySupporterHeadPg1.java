package com.vies.viesmachines.client.gui.machines.customize.display;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.EnumsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.MessageGuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.sub.MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeDisplaySupporterHeadPg1 extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_display_supporterhead.png");
	
	public GuiMachineMenuCustomizeDisplaySupporterHeadPg1(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
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
    	
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		GuiVM.buttonTexture00 = new GuiButtonGeneral1VM(101, this.guiLeft + 32-14 + (14 * 0), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture01 = new GuiButtonGeneral1VM(102, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture02 = new GuiButtonGeneral1VM(103, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture03 = new GuiButtonGeneral1VM(104, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture04 = new GuiButtonGeneral1VM(105, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture05 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture06 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture07 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture08 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7, 14, 14, "", 3);
		GuiVM.buttonTexture09 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7, 14, 14, "", 3);
		
		GuiVM.buttonTexture11 = new GuiButtonGeneral1VM(103, this.guiLeft + 32-14 + (14 * 0), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture12 = new GuiButtonGeneral1VM(104, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture13 = new GuiButtonGeneral1VM(105, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture14 = new GuiButtonGeneral1VM(106, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture15 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture16 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture17 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture18 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture19 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33, 14, 14, "", 3);
		GuiVM.buttonTexture20 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33, 14, 14, "", 3);
		
		GuiVM.buttonTexture21 = new GuiButtonGeneral1VM(106, this.guiLeft + 32-14 + (14 * 0), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture22 = new GuiButtonGeneral1VM(107, this.guiLeft + 32-14 + (14 * 1), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture23 = new GuiButtonGeneral1VM(108, this.guiLeft + 32-14 + (14 * 2), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture24 = new GuiButtonGeneral1VM(109, this.guiLeft + 32-14 + (14 * 3), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture25 = new GuiButtonGeneral1VM(110, this.guiLeft + 32-14 + (14 * 4), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture26 = new GuiButtonGeneral1VM(111, this.guiLeft + 32-14 + (14 * 5), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture27 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 6), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture28 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 7), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture29 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 8), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		GuiVM.buttonTexture30 = new GuiButtonGeneral1VM(100, this.guiLeft + 32-14 + (14 * 9), this.guiTop + 102-7+33+33, 14, 14, "", 3);
		
		//--------------------------------------------------
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonTexture00);
		this.buttonList.add(GuiVM.buttonTexture01);
		this.buttonList.add(GuiVM.buttonTexture02);
		this.buttonList.add(GuiVM.buttonTexture03);
		//this.buttonList.add(GuiVM.buttonTexture04);
		//this.buttonList.add(GuiVM.buttonTexture05);
		//this.buttonList.add(GuiVM.buttonTexture06);
		//this.buttonList.add(GuiVM.buttonTexture07);
		//this.buttonList.add(GuiVM.buttonTexture08);
		//this.buttonList.add(GuiVM.buttonTexture09);

		//this.buttonList.add(GuiVM.buttonTexture11);
		//this.buttonList.add(GuiVM.buttonTexture12);
		//this.buttonList.add(GuiVM.buttonTexture13);
		//this.buttonList.add(GuiVM.buttonTexture14);
		//this.buttonList.add(GuiVM.buttonTexture15);
		//this.buttonList.add(GuiVM.buttonTexture16);
		//this.buttonList.add(GuiVM.buttonTexture17);
		//this.buttonList.add(GuiVM.buttonTexture18);
		//this.buttonList.add(GuiVM.buttonTexture19);
		//this.buttonList.add(GuiVM.buttonTexture20);

		//this.buttonList.add(GuiVM.buttonTexture21);
		//this.buttonList.add(GuiVM.buttonTexture22);
		//this.buttonList.add(GuiVM.buttonTexture23);
		//this.buttonList.add(GuiVM.buttonTexture24);
		//this.buttonList.add(GuiVM.buttonTexture25);
		//this.buttonList.add(GuiVM.buttonTexture26);
		//this.buttonList.add(GuiVM.buttonTexture27);
		//this.buttonList.add(GuiVM.buttonTexture28);
		//this.buttonList.add(GuiVM.buttonTexture29);
		//this.buttonList.add(GuiVM.buttonTexture30);
		
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
			NetworkHandler.sendToServer(new MessageHelperGuiCustomizeMenuEngineDisplaySupporterHead());
		}
		
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplayBanner());
		}
		
		// Symbol Buttons:
		if (parButton.id >= 100)
	    {
			int fixedNumber = parButton.id - 100;
			
			this.supporterHeadInfo = fixedNumber;
			this.metaInfo = 3;
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
		if (this.machine.getVisualEngineDisplayType() == 1)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55, 43, 0);
				
				this.drawStillItemStack(new ItemStack(Item.getItemById(this.machine.getVisualEngineDisplayItemstack()), 1, this.machine.getVisualEngineDisplayItemstackMeta()), this.guiLeft , this.guiTop);
			}
			GlStateManager.popMatrix();
		}
		// Entity Head:
		else if (this.machine.getVisualEngineDisplayType() == 2)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(4, -36, 0);
				
				this.drawEntityHead(0, 0, this.headInfo);
			}
			GlStateManager.popMatrix();
		}
		// Supporter Head:
		else if (this.machine.getVisualEngineDisplayType() == 3)
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
		if (this.supporterHeadInfo >= 1)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(86, -37, 0);
				
				this.drawEntitySupporterHead(0, 0, this.supporterHeadInfo);
			}
			GlStateManager.popMatrix();
		}
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Supporter Head Options':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.supporterheadoptions.0"), 0, 0, Color.BLACK.getRGB());
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
		
		// 'Supporters':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(39, 83, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.displaybanner.supporters.0"), 0, 0, Color.CYAN.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Draws a black box over the preview buttons:
		this.drawRect(108, 66, 130, 76, Color.BLACK.getRGB());
		
		// Supporters Row item over button:
		GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
			
	    	GlStateManager.translate(-0.5, 65.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawEntitySupporterHeadForground((28 * 0), 0, EnumsVM.PatreonHead.VIES.getMetadata());
			this.drawEntitySupporterHeadForground((28 * 1), 0, EnumsVM.PatreonHead.SOULFORGE7.getMetadata());
			this.drawEntitySupporterHeadForground((28 * 2), 0, EnumsVM.PatreonHead.NEMANOR.getMetadata());
			this.drawEntitySupporterHeadForground((28 * 3), 0, EnumsVM.PatreonHead.VELOURVAULTSUIT.getMetadata());
		}
		GlStateManager.popMatrix();
		
		this.mouseOverTooltipHandler(mouseX, mouseY);
		
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
        if (this.supporterHeadInfo != 0)
        {
        	if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (this.supporterHeadInfo == this.machine.getVisualEngineDisplaySupporterHead())
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
        
        //--------------------------------------------------
 		
 		if (this.machine.getVisualEngineDisplaySupporterHead() == EnumsVM.PatreonHead.VIES.getMetadata())
 		{
 			GuiVM.buttonTexture00.enabled = false;
 		}
 		else
 		{
 			GuiVM.buttonTexture00.enabled = true;
 		}
 		if (this.machine.getVisualEngineDisplaySupporterHead() == EnumsVM.PatreonHead.SOULFORGE7.getMetadata())
 		{
 			GuiVM.buttonTexture01.enabled = false;
 		}
 		else
 		{
 			GuiVM.buttonTexture01.enabled = true;
 		}
 		if (this.machine.getVisualEngineDisplaySupporterHead() == EnumsVM.PatreonHead.NEMANOR.getMetadata())
 		{
 			GuiVM.buttonTexture02.enabled = false;
 		}
 		else
 		{
 			GuiVM.buttonTexture02.enabled = true;
 		}
 		if (this.machine.getVisualEngineDisplaySupporterHead() == EnumsVM.PatreonHead.VELOURVAULTSUIT.getMetadata())
 		{
 			GuiVM.buttonTexture03.enabled = false;
 		}
 		else
 		{
 			GuiVM.buttonTexture03.enabled = true;
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
		if(mouseX >= this.guiLeft + xIn && mouseX <= this.guiLeft + xIn + 13
		&& mouseY >= this.guiTop + yIn && mouseY <= this.guiTop + yIn + 13)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.GREEN + "" + TextFormatting.BOLD + References.Old_I18n.translateToLocal(EnumsVM.PatreonHead.byId(enumIn).getLocalizedName()));
			
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
		this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 0) * 1), 102-7, EnumsVM.PatreonHead.VIES.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 1) * 1), 102-7, EnumsVM.PatreonHead.SOULFORGE7.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 2) * 1), 102-7, EnumsVM.PatreonHead.NEMANOR.getMetadata());
		this.mouseOverTooltipNames(mouseX, mouseY, 32-14 + ((14 * 3) * 1), 102-7, EnumsVM.PatreonHead.VELOURVAULTSUIT.getMetadata());
	}
}

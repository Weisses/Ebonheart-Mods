package com.vies.viesmachines.client.gui.machines.customize;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Loghelper;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizePrimaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryDefault;
import com.vies.viesmachines.network.server.machine.gui.customize.MessageHelperGuiMachineMenuCustomizeSecondaryTransparent;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageGuiMachineMenuCustomizeActiveModels;
import com.vies.viesmachines.network.server.machine.gui.customize.displaybanner.MessageGuiMachineMenuCustomizeDisplayBanner;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.MessageGuiMachineMenuCustomizePrimarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.primaryskin.color.MessageGuiMachineMenuCustomizePrimarySkinColor;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.MessageGuiMachineMenuCustomizeSecondarySkinTexture;
import com.vies.viesmachines.network.server.machine.gui.customize.secondaryskin.color.MessageGuiMachineMenuCustomizeSecondarySkinColor;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualPrimaryTransparentEnabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryTransparentDisabled;
import com.vies.viesmachines.network.server.world.menu.customize.PlayerMessageVisualSecondaryTransparentEnabled;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomize extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize.png");
	
	public GuiMachineMenuCustomize(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonRotateLeft = new GuiButtonGeneral2VM(10, this.guiLeft + 60, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VM(10, this.guiLeft + 72, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRidingPlayerTrue = new GuiButtonGeneral1VM(12, this.guiLeft + 80, this.guiTop + 66, 10, 10, "", 1);
    	GuiVM.buttonRidingPlayerFalse = new GuiButtonGeneral1VM(13, this.guiLeft + 90, this.guiTop + 66, 10, 10, "", 2);
    	GuiVM.buttonUndo = new GuiButtonGeneral2VM(11, this.guiLeft + 108, this.guiTop + 66, 10, 10, "", 1);
		
    	GuiVM.buttonCustomizeActiveModels = new GuiButtonGeneral1VM(30, this.guiLeft + 28, this.guiTop + 102, 42, 14, References.Old_I18n.translateToLocal("Model"), 0);
    	GuiVM.buttonCustomizeDisplayBanner = new GuiButtonGeneral1VM(31, this.guiLeft + 106, this.guiTop + 102, 42, 14, References.Old_I18n.translateToLocal("Display"), 0);
    	GuiVM.buttonCustomizePrimaryTexture = new GuiButtonGeneral1VM(32, this.guiLeft + 28, this.guiTop + 143, 42, 14, References.Old_I18n.translateToLocal("Texture"), 0);
    	GuiVM.buttonCustomizePrimaryColor = new GuiButtonGeneral1VM(33, this.guiLeft + 28, this.guiTop + 161, 42, 14, References.Old_I18n.translateToLocal("Color"), 0);
    	GuiVM.buttonCustomizePrimaryTransparentTrue = new GuiButtonGeneral1VM(34, this.guiLeft + 28, this.guiTop + 179, 14, 14, References.Old_I18n.translateToLocal(""), 1);
    	GuiVM.buttonCustomizePrimaryTransparentFalse = new GuiButtonGeneral1VM(35, this.guiLeft + 28, this.guiTop + 179, 14, 14, References.Old_I18n.translateToLocal(""), 2);
    	GuiVM.buttonCustomizeSecondaryTexture = new GuiButtonGeneral1VM(36, this.guiLeft + 106, this.guiTop + 143, 42, 14, References.Old_I18n.translateToLocal("Texture"), 0);
    	GuiVM.buttonCustomizeSecondaryColor = new GuiButtonGeneral1VM(37, this.guiLeft + 106, this.guiTop + 161, 42, 14, References.Old_I18n.translateToLocal("Color"), 0);
    	GuiVM.buttonCustomizeSecondaryTransparentTrue = new GuiButtonGeneral1VM(38, this.guiLeft + 106, this.guiTop + 179, 14, 14, References.Old_I18n.translateToLocal(""), 1);
		GuiVM.buttonCustomizeSecondaryTransparentFalse = new GuiButtonGeneral1VM(39, this.guiLeft + 106, this.guiTop + 179, 14, 14, References.Old_I18n.translateToLocal(""), 2);
		
		//--------------------------------------------------
    	
		this.buttonList.add(GuiVM.buttonCustomizeActiveModels);
		this.buttonList.add(GuiVM.buttonCustomizeDisplayBanner);
		this.buttonList.add(GuiVM.buttonCustomizePrimaryTexture);
		this.buttonList.add(GuiVM.buttonCustomizePrimaryColor);
		this.buttonList.add(GuiVM.buttonCustomizePrimaryTransparentTrue);
		this.buttonList.add(GuiVM.buttonCustomizePrimaryTransparentFalse);
		this.buttonList.add(GuiVM.buttonCustomizeSecondaryTexture);
		this.buttonList.add(GuiVM.buttonCustomizeSecondaryColor);
		this.buttonList.add(GuiVM.buttonCustomizeSecondaryTransparentTrue);
		this.buttonList.add(GuiVM.buttonCustomizeSecondaryTransparentFalse);
		
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
		
		// Primary Transparency Buttons:
		if (parButton.id == 34
		|| parButton.id == 35)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizePrimaryTransparent());			
			
			if (!this.machine.getVisualFrameTransparent())
			{
				NetworkHandler.sendToServer(new PlayerMessageVisualPrimaryTransparentEnabled());
			}
			else
			{
				NetworkHandler.sendToServer(new PlayerMessageVisualPrimaryTransparentDisabled());
			}
	    }
		
		// Secondary Transparency buttons:
		if (parButton.id == 38
		|| parButton.id == 39)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondaryTransparent());			
			
			if (!this.machine.getVisualComponentTransparent())
			{
				NetworkHandler.sendToServer(new PlayerMessageVisualSecondaryTransparentEnabled());
			}
			else
			{
				NetworkHandler.sendToServer(new PlayerMessageVisualSecondaryTransparentDisabled());
			}
	    }
		
		// Active Models:
		if (parButton.id == 30)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeActiveModels());
		}
		
		// Display Banner:
		if (parButton.id == 31)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeDisplayBanner());
		}
		
		// Primary Skin Texture:
		if (parButton.id == 32)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizePrimarySkinTexture());
		}
		
		// Primary Skin Color:
		if (parButton.id == 33)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizePrimarySkinColor());
		}
		
		// Secondary Skin Texture:
		if (parButton.id == 36)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeSecondarySkinTexture());
		}
		
		// Secondary Skin Color:
		if (parButton.id == 37)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomizeSecondarySkinColor());
		}
		
		// Primary Skin Default:
		if (parButton.id == 40)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizePrimaryDefault());
		}
		
		// Secondary Skin Default:
		if (parButton.id == 41)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeSecondaryDefault());
		}
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Draws a gray:
		this.drawRect(this.guiLeft +58, this.guiTop + 6, this.guiLeft +168, this.guiTop + 64, Color.GRAY.getRGB());
		
		// Binds and draws the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Renders the 'Preview Entity' for the current machine:
		this.drawEntityOnScreen(this.guiLeft + 89, this.guiTop + 58, this.modelRotationHorizontal, 13, this.machine, this.modelRidingEntity);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Preview':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(87.5, 10, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.Old_I18n.translateToLocal("viesmachines.main.preview"), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Active Models label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(49, 91.5, 0);
	        GlStateManager.scale(0.6F, 0.6F, 0.6F);
	        
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.active"), 0, -10, 11111111);
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.models"), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		// Display Banner label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(127, 91.5, 0);
	        GlStateManager.scale(0.6F, 0.6F, 0.6F);
	        
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.display"), 0, -10, 11111111);
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.banner"), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		// Primary Skin label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(49, 132.5, 0);
	        GlStateManager.scale(0.6F, 0.6F, 0.6F);
	        
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.primary"), 0, -10, 11111111);
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.skin"), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		// Secondary Skin label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(127, 132.5, 0);
	        GlStateManager.scale(0.6F, 0.6F, 0.6F);
	        
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.secondary"), 0, -10, 11111111);
	        this.centeredString(getFontRenderer(), TextFormatting.BOLD + References.Old_I18n.translateToLocal("viesmachines.main.skin"), 0, 0, 11111111);
		}
		GlStateManager.popMatrix();
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(80, 75, 118, 76, Color.BLACK.getRGB());
		
		// Binds the texture to use:
		GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Primary Semi-Transparent symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(28, 179, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 0, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Secondary Semi-Transparent symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(106, 179, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 228, 0, 28, 28);
		}
		GlStateManager.popMatrix();
		
		// Preview Left Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(60, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 16, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Preview Right Arrow symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(72, 67.75, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 28, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Preview Steve head symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(82, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 40, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Preview Steve head 'X' symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(92, 67.5, 0);
			GlStateManager.scale(0.5F, 0.5F, 0.5F);
			
			this.drawTexturedModalRect(0, 0, 176, 52, 12, 12);
		}
		GlStateManager.popMatrix();
		
		// Preview Undo symbol:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(111, 69, 0);
			GlStateManager.scale(0.25F, 0.25F, 0.25F);
			
			this.drawTexturedModalRect(0, 0, 176, 0, 16, 16);
		}
		GlStateManager.popMatrix();
		
		//--------------------------------------------------
		
		// Logic for mouse-over tooltip - Turn Left:
		if(mouseX >= this.guiLeft + 60 && mouseX <= this.guiLeft + 65
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
		if(mouseX >= this.guiLeft + 72 && mouseX <= this.guiLeft + 77
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
		
		// Logic for mouse-over tooltip - Primary Transparency:
		if(mouseX >= this.guiLeft + 28 && mouseX <= this.guiLeft + 28+13
		&& mouseY >= this.guiTop + 179 && mouseY <= this.guiTop + 179+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
	 		{
	        	EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
				
	        	if (player.isCreative())
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0"));
					text.add(TextFormatting.GREEN + References.localNameVC("viesmachines.gui.tt.customize.color.cost.5"));
	        	}
	        	else if (this.machine.getVisualFrameTransparent())
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0"));
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.transparency.0"));
	        	}
	        	else if (this.machine.getEnergy() >= CostsVM.COST_FRAME_TRANSPARENCY)
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0"));
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_FRAME_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
	        	}
	        	else
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0"));
					text.add(whitespaceCentering(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0"), TextFormatting.DARK_RED + "" + CostsVM.COST_FRAME_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4")) + TextFormatting.DARK_RED + "" + CostsVM.COST_FRAME_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
	        	}
			}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = (TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.primarytransparency.0")).length();
				
				GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		// Logic for mouse-over tooltip - Secondary Transparency:
		if(mouseX >= this.guiLeft + 28 + 78 && mouseX <= this.guiLeft + 28+13+78
		&& mouseY >= this.guiTop + 179 && mouseY <= this.guiTop + 179+13)
		{
			List<String> text = new ArrayList<String>();
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
	 		{
	        	EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
				
	        	if (player.isCreative())
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.secondarytransparency.0"));
					text.add(TextFormatting.GREEN + References.localNameVC("viesmachines.gui.tt.customize.color.cost.5"));
	        	}
	        	else if (this.machine.getVisualComponentTransparent())
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.secondarytransparency.0"));
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.transparency.0"));
	        	}
	        	else if (this.machine.getEnergy() >= CostsVM.COST_COMPONENT_TRANSPARENCY)
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.secondarytransparency.0"));
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_COMPONENT_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
	        	}
	        	else
	        	{
	        		text.add(TextFormatting.WHITE + References.localNameVC("viesmachines.gui.tt.customize.secondarytransparency.0"));
					text.add(TextFormatting.DARK_RED + "" + CostsVM.COST_COMPONENT_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
	        	}
			}
			
			GlStateManager.pushMatrix();
			{
				int textNumber = (TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_COMPONENT_TRANSPARENCY + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2")).length();
				
				GlStateManager.translate(mouseX - this.guiLeft - 6 - textNumber - (textNumber / 2), mouseY - this.guiTop + 6, 0);
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
        
        // Deals with the Primary Transparent toggle:
        if (this.machine.getControllingPassenger() instanceof EntityPlayer)
 		{
        	EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
			
        	if(this.machine.getVisualFrameTransparent())
        	{
				GuiVM.buttonCustomizePrimaryTransparentFalse.visible = false;
				GuiVM.buttonCustomizePrimaryTransparentTrue.visible = true;
			}
			else
			{
				if (player.isCreative())
				{
					GuiVM.buttonCustomizePrimaryTransparentFalse.enabled = true;
					GuiVM.buttonCustomizePrimaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizePrimaryTransparentFalse.visible = true;
				}
				else if (this.machine.getEnergy() >= CostsVM.COST_FRAME_TRANSPARENCY)
		 		{
					GuiVM.buttonCustomizePrimaryTransparentFalse.enabled = true;
					GuiVM.buttonCustomizePrimaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizePrimaryTransparentFalse.visible = true;
		 		}
				else
				{
					GuiVM.buttonCustomizePrimaryTransparentFalse.enabled = false;
					GuiVM.buttonCustomizePrimaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizePrimaryTransparentFalse.visible = false;
				}
	 		}
		}
        
        // Deals with the Secondary Transparent toggle:
        if (this.machine.getControllingPassenger() instanceof EntityPlayer)
 		{
        	EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
			
        	if(this.machine.getVisualComponentTransparent())
        	{
				GuiVM.buttonCustomizeSecondaryTransparentFalse.visible = false;
				GuiVM.buttonCustomizeSecondaryTransparentTrue.visible = true;
			}
			else
			{
				if (player.isCreative())
				{
					GuiVM.buttonCustomizeSecondaryTransparentFalse.enabled = true;
					GuiVM.buttonCustomizeSecondaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizeSecondaryTransparentFalse.visible = true;
				}
				else if (this.machine.getEnergy() >= CostsVM.COST_COMPONENT_TRANSPARENCY)
		 		{
					GuiVM.buttonCustomizeSecondaryTransparentFalse.enabled = true;
					GuiVM.buttonCustomizeSecondaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizeSecondaryTransparentFalse.visible = true;
		 		}
				else
				{
					GuiVM.buttonCustomizeSecondaryTransparentFalse.enabled = false;
					GuiVM.buttonCustomizeSecondaryTransparentTrue.visible = false;
					GuiVM.buttonCustomizeSecondaryTransparentFalse.visible = false;
				}
	 		}
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
 		
 		if (this.machine.getBroken())
 		{
 			GuiVM.buttonCustomizeActiveModels.enabled = false;
 	    	GuiVM.buttonCustomizeDisplayBanner.enabled = false;
 	    	GuiVM.buttonCustomizePrimaryTexture.enabled = false;
 	    	GuiVM.buttonCustomizePrimaryColor.enabled = false;
 	    	GuiVM.buttonCustomizePrimaryTransparentTrue.enabled = false;
 	    	GuiVM.buttonCustomizePrimaryTransparentFalse.enabled = false;
 	    	GuiVM.buttonCustomizeSecondaryTexture.enabled = false;
 	    	GuiVM.buttonCustomizeSecondaryColor.enabled = false;
 	    	GuiVM.buttonCustomizeSecondaryTransparentTrue.enabled = false;
 			GuiVM.buttonCustomizeSecondaryTransparentFalse.enabled = false;
 			
 		}
    }
}

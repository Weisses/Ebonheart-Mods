package com.vies.viesmachines.client.gui.machines.customize;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.CostsVM;
import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.api.util.Loghelper;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.customize.activemodels.MessageHelperGuiMachineMenuCustomizeActiveModelApply;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiMachineMenuCustomizeActiveModels extends GuiContainerVM {
	
	public static int modelFrame;
	public static int modelEngine;
	public static int modelComponent;
	
	private int previewPart;
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_machine_menu_customize_active_models.png");
	
	public GuiMachineMenuCustomizeActiveModels(IInventory playerInv, EntityMachineBase airshipIn)
	{
		super(new ContainerMachineNoSlots(playerInv, airshipIn), playerInv, airshipIn);
		
		this.modelRotationHorizontal = 160;
		this.modelRidingEntity = false;
		this.previewPart = 1;
		
		this.modelFrame = this.machine.getVisualModelFrame();
		this.modelEngine = this.machine.getVisualModelEngine();
		this.modelComponent = this.machine.getVisualModelComponent();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonRotateLeft = new GuiButtonGeneral2VM(10, this.guiLeft + 110, this.guiTop + 68, 6, 6, "", 3);
    	GuiVM.buttonRotateRight = new GuiButtonGeneral2VM(10, this.guiLeft + 122, this.guiTop + 68, 6, 6, "", 3);
    	
    	GuiVM.buttonApply = new GuiButtonGeneral1VM(21, this.guiLeft + 7, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.apply"), 1);
		GuiVM.buttonBack = new GuiButtonGeneral1VM(22, this.guiLeft + 61, this.guiTop + 63, 42, 14, References.localNameVC("viesmachines.button.back"), 2);
		
		GuiVM.button41 = new GuiButtonGeneral1VM(41, this.guiLeft + 12, this.guiTop + 141, 50, 14, "Standard", 3);
		GuiVM.button42 = new GuiButtonGeneral1VM(42, this.guiLeft + 12+51, this.guiTop + 141, 50, 14, "Reinforced", 3);
		GuiVM.button43 = new GuiButtonGeneral1VM(43, this.guiLeft + 12+51+51, this.guiTop + 141, 50, 14, "Spiked", 3);
    	
		GuiVM.button51 = new GuiButtonGeneral1VM(51, this.guiLeft + 12, this.guiTop + 141, 50, 14, "Standard", 3);
		GuiVM.button52 = new GuiButtonGeneral1VM(52, this.guiLeft + 12+51, this.guiTop + 141, 50, 14, "Big", 3);
		GuiVM.button53 = new GuiButtonGeneral1VM(53, this.guiLeft + 12+51+51, this.guiTop + 141, 50, 14, "Dual", 3);
    	
		GuiVM.button61 = new GuiButtonGeneral1VM(61, this.guiLeft + 12, this.guiTop + 141, 50, 14, "Standard", 3);
		GuiVM.button62 = new GuiButtonGeneral1VM(62, this.guiLeft + 12+51, this.guiTop + 141, 50, 14, "Hindenburg", 3);
		GuiVM.button63 = new GuiButtonGeneral1VM(63, this.guiLeft + 12+51+51, this.guiTop + 141, 50, 14, "Dirgible", 3);
    	GuiVM.button64 = new GuiButtonGeneral1VM(64, this.guiLeft + 12, this.guiTop + 159, 50, 14, "Zeppelin", 3);
    	GuiVM.button65 = new GuiButtonGeneral1VM(65, this.guiLeft + 12+51, this.guiTop + 159, 50, 14, "Akronus", 3);
    	GuiVM.button66 = new GuiButtonGeneral1VM(66, this.guiLeft + 12+51+51, this.guiTop + 159, 50, 14, "Standard", 3);
    	
    	GuiVM.buttonFrame = new GuiButtonGeneral2VM(1, this.guiLeft + 13, this.guiTop + 94, 48, 14, "Frame", 1);
    	GuiVM.buttonEngine = new GuiButtonGeneral2VM(2, this.guiLeft + 13+51, this.guiTop + 94, 48, 14, "Engine", 1);
    	GuiVM.buttonComponent = new GuiButtonGeneral2VM(3, this.guiLeft + 13+51+51, this.guiTop + 94, 48, 14, "Component", 1);
    	
    	//--------------------------------------------------
    	
    	this.buttonList.add(GuiVM.buttonFrame);
    	this.buttonList.add(GuiVM.buttonEngine);
    	this.buttonList.add(GuiVM.buttonComponent);
		
    	this.buttonList.add(GuiVM.button41);
    	this.buttonList.add(GuiVM.button42);
    	this.buttonList.add(GuiVM.button43);
		this.buttonList.add(GuiVM.button51);
    	this.buttonList.add(GuiVM.button52);
    	this.buttonList.add(GuiVM.button53);
		this.buttonList.add(GuiVM.button61);
		this.buttonList.add(GuiVM.button62);
		this.buttonList.add(GuiVM.button63);
		//this.buttonList.add(GuiVM.button64);
		//this.buttonList.add(GuiVM.button65);
		//this.buttonList.add(GuiVM.button66);
		
		this.buttonList.add(GuiVM.buttonApply);
		this.buttonList.add(GuiVM.buttonBack);
		
		this.buttonList.add(GuiVM.buttonRotateLeft);
    	this.buttonList.add(GuiVM.buttonRotateRight);
    	
    	this.buttonList.add(GuiVM.buttonMM1);
		this.buttonList.add(GuiVM.buttonMM2);
		this.buttonList.add(GuiVM.buttonMM3);
		
		GuiVM.buttonMM3.enabled = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		super.actionPerformed(parButton);
		
		// Frame button:
		if (parButton.id == 1)
		{
			this.previewPart = 1;
			this.modelEngine = this.machine.getVisualModelEngine();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Engine button:
		if (parButton.id == 2)
		{
			this.previewPart = 2;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Component button:
		if (parButton.id == 3)
		{
			this.previewPart = 3;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
		// Apply:
		if (parButton.id == 21)
		{
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMenuCustomizeActiveModelApply());
		}
		
		// Back:
		if (parButton.id == 22)
		{
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomize());
		}
		
		// Frame-Standard:
		if (parButton.id == 41)
		{
			this.modelFrame = 0;
			this.modelEngine = this.machine.getVisualModelEngine();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Frame-Reinforced:
		if (parButton.id == 42)
		{
			this.modelFrame = 1;
			this.modelEngine = this.machine.getVisualModelEngine();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Frame-Spiked:
		if (parButton.id == 43)
		{
			this.modelFrame = 2;
			this.modelEngine = this.machine.getVisualModelEngine();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Engine-Standard:
		if (parButton.id == 51)
		{
			this.modelEngine = 0;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Engine-Big:
		if (parButton.id == 52)
		{
			this.modelEngine = 1;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		
		// Engine-Dual:
		if (parButton.id == 53)
		{
			this.modelEngine = 2;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelComponent = this.machine.getVisualModelComponent();
		}
		

		// Component-Standard:
		if (parButton.id == 61)
		{
			this.modelComponent = 0;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
		// Component-Hindenburg:
		if (parButton.id == 62)
		{
			this.modelComponent = 1;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
		// Component-Dirigible:
		if (parButton.id == 63)
		{
			this.modelComponent = 2;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}

		// Component-Zeppelin:
		if (parButton.id == 64)
		{
			this.modelComponent = 3;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
		// Component-Akronus:
		if (parButton.id == 65)
		{
			this.modelComponent = 4;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
		// Component-XXX:
		if (parButton.id == 66)
		{
			this.modelComponent = 5;
			this.modelFrame = this.machine.getVisualModelFrame();
			this.modelEngine = this.machine.getVisualModelEngine();
		}
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Draws a black line under the machine preview options buttons:
		this.drawRect(this.guiLeft +108, this.guiTop + 6, this.guiLeft +168, this.guiTop + 64, Color.GRAY.getRGB());
		
		// Binds and draws the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		// Render Preview Entity of Machine:
		this.drawEntityMachinePartOnScreen(this.guiLeft + 139, this.guiTop + 58, this.modelRotationHorizontal, 11, this.machine, this.modelRidingEntity, this.previewPart);
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// 'Active Models':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(55.5, 11, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.tt.customize.activemodels.activemodels.0"), 0, 0, Color.BLACK.getRGB());
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
		
		// Choose a ____:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88.5, 127, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        if (this.previewPart == 1)
	        {
	        	this.centeredString(getFontRenderer(), TextFormatting.BOLD + "Choose a frame.", 0, 0, 11111111);
	        }
	        else if (this.previewPart == 2)
	        {
	        	this.centeredString(getFontRenderer(), TextFormatting.BOLD + "Choose an engine.", 0, 0, 11111111);
	        }
	        else if (this.previewPart == 3)
	        {
	        	this.centeredString(getFontRenderer(), TextFormatting.BOLD + "Choose a component.", 0, 0, 11111111);
	        }
		}
		GlStateManager.popMatrix();
		
		// Binds the texture to use:
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
					int textNumber = References.localNameVC("viesmachines.gui.tt.general.previewturnleft.0").length();
					
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
					int textNumber = References.localNameVC("viesmachines.gui.tt.general.previewturn.0").length();
					
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
					int textNumber = References.localNameVC("viesmachines.gui.tt.general.previewturnright.0").length();
					
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
					int textNumber = References.localNameVC("viesmachines.gui.tt.general.previewturn.0").length();
					
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
			
			if (this.machine.getControllingPassenger() instanceof EntityPlayer)
        	{
        		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
        		
        		if (!GuiVM.buttonApply.enabled
				&& this.machine.getEnergy() < CostsVM.COST_CHANGE_MODEL_FRAME
				&& !player.isCreative())
				{
					text.add(TextFormatting.DARK_RED + "" + CostsVM.COST_CHANGE_MODEL_FRAME + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.4"));
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
					text.add(TextFormatting.YELLOW + References.localNameVC("viesmachines.gui.tt.customize.color.cost.1") + " " + CostsVM.COST_CHANGE_MODEL_FRAME + " " + References.localNameVC("viesmachines.gui.tt.customize.color.cost.2"));
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
 		
 		// Handles the buttons for Previewing the Frame:
 		if(this.previewPart == 1)
		{
			GuiVM.buttonFrame.enabled = false;
			GuiVM.buttonEngine.enabled = true;
			GuiVM.buttonComponent.enabled = true;
			
			GuiVM.button41.visible = true;
	    	GuiVM.button42.visible = true;
	    	GuiVM.button43.visible = true;
			GuiVM.button51.visible = false;
	    	GuiVM.button52.visible = false;
	    	GuiVM.button53.visible = false;
			GuiVM.button61.visible = false;
			GuiVM.button62.visible = false;
			GuiVM.button63.visible = false;
			GuiVM.button64.visible = false;
			GuiVM.button65.visible = false;
			GuiVM.button66.visible = false;
		}
 		// Handles the buttons for Previewing the Engine:
 		if(this.previewPart == 2)
		{
			GuiVM.buttonFrame.enabled = true;
			GuiVM.buttonEngine.enabled = false;
			GuiVM.buttonComponent.enabled = true;
			
			GuiVM.button41.visible = false;
	    	GuiVM.button42.visible = false;
	    	GuiVM.button43.visible = false;
			GuiVM.button51.visible = true;
	    	GuiVM.button52.visible = true;
	    	GuiVM.button53.visible = true;
			GuiVM.button61.visible = false;
			GuiVM.button62.visible = false;
			GuiVM.button63.visible = false;
			GuiVM.button64.visible = false;
			GuiVM.button65.visible = false;
			GuiVM.button66.visible = false;
		}
 		// Handles the buttons for Previewing the Component:
 		if(this.previewPart == 3)
		{
			GuiVM.buttonFrame.enabled = true;
			GuiVM.buttonEngine.enabled = true;
			GuiVM.buttonComponent.enabled = false;
			
			GuiVM.button41.visible = false;
	    	GuiVM.button42.visible = false;
	    	GuiVM.button43.visible = false;
			GuiVM.button51.visible = false;
	    	GuiVM.button52.visible = false;
	    	GuiVM.button53.visible = false;
			GuiVM.button61.visible = true;
			GuiVM.button62.visible = true;
			GuiVM.button63.visible = true;
			GuiVM.button64.visible = true;
			GuiVM.button65.visible = true;
			GuiVM.button66.visible = true;
		}
		
		this.selectedButtonDisable();
		
		// Handles the Apply button:
		if (this.machine.getControllingPassenger() instanceof EntityPlayer)
    	{
    		EntityPlayer player = (EntityPlayer) this.machine.getControllingPassenger();
    		
    		if (this.modelFrame == this.machine.getVisualModelFrame()
			&& this.previewPart == 1)
			{
				GuiVM.buttonApply.enabled = false;
			}
			else if(this.modelEngine == this.machine.getVisualModelEngine()
			&& this.previewPart == 2)
			{
				GuiVM.buttonApply.enabled = false;
			}
			else if(this.modelComponent == this.machine.getVisualModelComponent()
			&& this.previewPart == 3)
			{
				GuiVM.buttonApply.enabled = false;
			}
    		else if (player.isCreative())
    		{
    			GuiVM.buttonApply.enabled = true;
    		}
    		else if (CostsVM.COST_CHANGE_MODEL_FRAME > this.machine.getEnergy())
			{
				GuiVM.buttonApply.enabled = false;
			}
			else
			{
				GuiVM.buttonApply.enabled = true;
			}
    	}
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException 
	{
        super.mouseClicked(x, y, btn);
    }
	
	private void selectedButtonDisable()
	{
		// Frame:
		if (this.machine.getVisualModelFrame() == 0)
		{
			GuiVM.button41.enabled = false;
		}
		else
		{
			GuiVM.button41.enabled = true;
		}
		if (this.machine.getVisualModelFrame() == 1)
		{
			GuiVM.button42.enabled = false;
		}
		else
		{
			GuiVM.button42.enabled = true;
		}
		if (this.machine.getVisualModelFrame() == 2)
		{
			GuiVM.button43.enabled = false;
		}
		else
		{
			GuiVM.button43.enabled = true;
		}
		
		// Engine:
		if (this.machine.getVisualModelEngine() == 0)
		{
			GuiVM.button51.enabled = false;
		}
		else
		{
			GuiVM.button51.enabled = true;
		}
		if (this.machine.getVisualModelEngine() == 1)
		{
			GuiVM.button52.enabled = false;
		}
		else
		{
			GuiVM.button52.enabled = true;
		}
		if (this.machine.getVisualModelEngine() == 2)
		{
			GuiVM.button53.enabled = false;
		}
		else
		{
			GuiVM.button53.enabled = true;
		}
		
		// Component:
		if (this.machine.getVisualModelComponent() == 0)
		{
			GuiVM.button61.enabled = false;
		}
		else
		{
			GuiVM.button61.enabled = true;
		}
		if (this.machine.getVisualModelComponent() == 1)
		{
			GuiVM.button62.enabled = false;
		}
		else
		{
			GuiVM.button62.enabled = true;
		}
		if (this.machine.getVisualModelComponent() == 2)
		{
			GuiVM.button63.enabled = false;
		}
		else
		{
			GuiVM.button63.enabled = true;
		}
		if (this.machine.getVisualModelComponent() == 3)
		{
			GuiVM.button64.enabled = false;
		}
		else
		{
			GuiVM.button64.enabled = true;
		}
		if (this.machine.getVisualModelComponent() == 4)
		{
			GuiVM.button65.enabled = false;
		}
		else
		{
			GuiVM.button65.enabled = true;
		}
		if (this.machine.getVisualModelComponent() == 5)
		{
			GuiVM.button66.enabled = false;
		}
		else
		{
			GuiVM.button66.enabled = true;
		}
	}
	
	@Override
	protected void drawEntityMachinePartOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn, int previewPartIn)
    {
		int originalFrameModel = this.machine.getVisualModelFrame();
		int originalEngineModel = this.machine.getVisualModelEngine();
		int originalComponentModel = this.machine.getVisualModelComponent();
		
		this.machine.setVisualModelFrame(this.modelFrame);
		this.machine.setVisualModelEngine(this.modelEngine);
		this.machine.setVisualModelComponent(this.modelComponent);
		
		super.drawEntityMachinePartOnScreen(posX, posY, horizontalIn, scale, entityIn, ridingEntityIn, previewPartIn);
	    
		this.machine.setVisualModelFrame(originalFrameModel);
		this.machine.setVisualModelEngine(originalEngineModel);
		this.machine.setVisualModelComponent(originalComponentModel);
    }
}

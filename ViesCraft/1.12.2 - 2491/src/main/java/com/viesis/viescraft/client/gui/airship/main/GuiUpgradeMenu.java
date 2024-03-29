package com.viesis.viescraft.client.gui.airship.main;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.GuiVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonConfirmVC;
import com.viesis.viescraft.client.gui.GuiButtonMenuVC;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.common.entity.airshipcolors.containers.all.ContainerUpgradeMenu;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.airship.MessageGuiUpgradeMenu;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeBalloonVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeCoreVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeEngineVC;
import com.viesis.viescraft.network.server.airship.MessageHelperGuiUpgradeFrameVC;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuMusic;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageGreater;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageLesser;
import com.viesis.viescraft.network.server.airship.main.MessageGuiAirshipMenuStorageNormal;
import com.viesis.viescraft.network.server.airship.main.MessageGuiModuleMenu;
import com.viesis.viescraft.network.server.airship.main.MessageGuiVisualMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiUpgradeMenu extends GuiContainer {
	
	private IInventory playerInv;
	private EntityAirshipBaseVC airship;
	
	public static int metaUpgradeInfo;
	
	public GuiUpgradeMenu(IInventory playerInv, EntityAirshipBaseVC airshipIn)
	{
		super(new ContainerUpgradeMenu(playerInv, airshipIn));
		
		this.playerInv = playerInv;
		this.airship = airshipIn;
		this.xSize = 176;
		this.ySize = 202;
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
    	
    	GuiVC.buttonM1 = new GuiButtonMenuVC(1, this.guiLeft - 32, this.guiTop + 10, 36, 14, "", 0);
    	GuiVC.buttonM2 = new GuiButtonMenuVC(2, this.guiLeft - 32, this.guiTop + 24, 36, 14, "", 1);
    	GuiVC.buttonM3 = new GuiButtonMenuVC(3, this.guiLeft - 32, this.guiTop + 38, 36, 14, "", 2);
    	GuiVC.buttonM4 = new GuiButtonMenuVC(4, this.guiLeft - 32, this.guiTop + 52, 36, 14, "", 3);
    	
    	GuiVC.buttonC1 = new GuiButtonConfirmVC(11, this.guiLeft + 24, this.guiTop + 88, 14, 14, "");
    	GuiVC.buttonC2 = new GuiButtonConfirmVC(12, this.guiLeft + 62, this.guiTop + 88, 14, 14, "");
    	GuiVC.buttonC3 = new GuiButtonConfirmVC(13, this.guiLeft + 100, this.guiTop + 88, 14, 14, "");
    	GuiVC.buttonC4 = new GuiButtonConfirmVC(14, this.guiLeft + 138, this.guiTop + 88, 14, 14, "");
		
    	this.buttonList.add(GuiVC.buttonM1);
		this.buttonList.add(GuiVC.buttonM2);
		this.buttonList.add(GuiVC.buttonM3);
		this.buttonList.add(GuiVC.buttonM4);
    	
		this.buttonList.add(GuiVC.buttonC1);
    	this.buttonList.add(GuiVC.buttonC2);
    	this.buttonList.add(GuiVC.buttonC3);
    	this.buttonList.add(GuiVC.buttonC4);
    	
		GuiVC.buttonM2.enabled = false;
    }
	
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			//Lesser Storage
        	if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageLesser());
        	}
        	//Normal Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageNormal());
        	}
        	//Greater Storage
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuStorageGreater());
        	}
        	//Any Music
        	else if(this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata()
    			 || this.airship.getModuleVariantSlot1() == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenuMusic());
        	}
        	//Default for airship gui
        	else
        	{
        		NetworkHandler.sendToServer(new MessageGuiAirshipMenu());
        	}
	    }
		if (parButton.id == 2)
	    {
			NetworkHandler.sendToServer(new MessageGuiUpgradeMenu());
	    }
		if (parButton.id == 3)
	    {
			NetworkHandler.sendToServer(new MessageGuiVisualMenu());
	    }
		if (parButton.id == 4)
	    {
			NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		
		this.metaUpgradeInfo = 0;
		
		if (parButton.id == 11)
	    {
			if(this.airship.inventory.getStackInSlot(1) != null)
			{
				this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(1).getMetadata();
				
				if(this.metaUpgradeInfo > this.airship.getMetaTierFrame()
				&& this.metaUpgradeInfo == (this.airship.getMetaTierFrame() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeFrameVC());
				}
			}
	    }
		
		if (parButton.id == 12)
	    {
			if(this.airship.inventory.getStackInSlot(2) != null)
			{
				this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(2).getMetadata();
				
				if(this.airship.getMetaTierFrame() > this.airship.getMetaTierCore()
				&& this.metaUpgradeInfo > this.airship.getMetaTierCore()
				&& this.metaUpgradeInfo == (this.airship.getMetaTierCore() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeCoreVC());
				}
				
			}
	    }
		
		if (parButton.id == 13)
	    {
			if(this.airship.inventory.getStackInSlot(3) != null)
			{
				this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(3).getMetadata();
				
				if(this.airship.getMetaTierFrame() > this.airship.getMetaTierEngine()
				&& this.metaUpgradeInfo > this.airship.getMetaTierEngine()
				&& this.metaUpgradeInfo == (this.airship.getMetaTierEngine() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeEngineVC());
				}
				
			}
	    }
		
		if (parButton.id == 14)
	    {
			if(this.airship.inventory.getStackInSlot(4) != null)
			{
				this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(4).getMetadata();
				
				if(this.airship.getMetaTierFrame() > this.airship.getMetaTierBalloon()
				&& this.metaUpgradeInfo > this.airship.getMetaTierBalloon()
				&& this.metaUpgradeInfo == (this.airship.getMetaTierBalloon() + 1))
				{
					NetworkHandler.sendToServer(new MessageHelperGuiUpgradeBalloonVC());
				}
				
			}
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_airship_menu_upgrade.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//Draws the checkbox when things are maxed.
		if((this.airship.getMetaTierFrame()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 23, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMetaTierCore()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 61, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 61, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMetaTierEngine()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 99, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 99, this.guiTop + 83, 176, 16, 16, 20);
		}
		if((this.airship.getMetaTierBalloon()) >= 5)
		{
			this.drawTexturedModalRect(this.guiLeft + 137, this.guiTop + 57, 176, 0, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(this.guiLeft + 137, this.guiTop + 83, 176, 16, 16, 20);
		}
		
		
		//Draws the top menu texture extension for the label
		this.drawRect(this.guiLeft + 49-4, this.guiTop - 17, this.guiLeft + 127+4, this.guiTop, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft + 50-4, this.guiTop - 16, this.guiLeft + 126+4, this.guiTop, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft + 52-4, this.guiTop - 14, this.guiLeft + 124+4, this.guiTop, Color.BLACK.getRGB());
		
		//Disable/hides all button on default
    	GuiVC.buttonC1.enabled = false;
    	GuiVC.buttonC2.enabled = false;
    	GuiVC.buttonC3.enabled = false;
    	GuiVC.buttonC4.enabled = false;
    	GuiVC.buttonC1.visible = false;
    	GuiVC.buttonC2.visible = false;
    	GuiVC.buttonC3.visible = false;
    	GuiVC.buttonC4.visible = false;
    	
    	//Enables a button if the conditions are right
    	if(this.airship.inventory.getStackInSlot(1) != null)
		{
			this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(1).getMetadata();
			
			if(this.metaUpgradeInfo > this.airship.getMetaTierFrame()
					&& this.metaUpgradeInfo == (this.airship.getMetaTierFrame() + 1))
			{
				GuiVC.buttonC1.enabled = true;
				GuiVC.buttonC1.visible = true;
			}
			
		}
    	if(this.airship.inventory.getStackInSlot(2) != null)
		{
			this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(2).getMetadata();
			
			if(this.airship.getMetaTierFrame() > this.airship.getMetaTierCore()
			&& this.metaUpgradeInfo > this.airship.getMetaTierCore()
			&& this.metaUpgradeInfo == (this.airship.getMetaTierCore() + 1))
			{
				GuiVC.buttonC2.enabled = true;
				GuiVC.buttonC2.visible = true;
			}
			
		}
    	if(this.airship.inventory.getStackInSlot(3) != null)
		{
			this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(3).getMetadata();
			
			if(this.airship.getMetaTierFrame() > this.airship.getMetaTierEngine()
			&& this.metaUpgradeInfo > this.airship.getMetaTierEngine()
			&& this.metaUpgradeInfo == (this.airship.getMetaTierEngine() + 1))
			{
				GuiVC.buttonC3.enabled = true;
				GuiVC.buttonC3.visible = true;
			}
			
		}
    	if(this.airship.inventory.getStackInSlot(4) != null)
		{
			this.metaUpgradeInfo = this.airship.inventory.getStackInSlot(4).getMetadata();
			
			if(this.airship.getMetaTierFrame() > this.airship.getMetaTierBalloon()
			&& this.metaUpgradeInfo > this.airship.getMetaTierBalloon()
			&& this.metaUpgradeInfo == (this.airship.getMetaTierBalloon() + 1))
			{
				GuiVC.buttonC4.enabled = true;
				GuiVC.buttonC4.visible = true;
			}
			
		}
    	
    	//Hides the button if airship is maxed
    	if(this.airship.getMetaTierFrame() >= 5)
    	{
    		GuiVC.buttonC1.visible = false;
    	}
    	if(this.airship.getMetaTierCore() >= 5)
    	{
    		GuiVC.buttonC2.visible = false;
    	}
    	if(this.airship.getMetaTierEngine() >= 5)
    	{
    		GuiVC.buttonC3.visible = false;
    	}
    	if(this.airship.getMetaTierBalloon() >= 5)
    	{
    		GuiVC.buttonC4.visible = false;
    	}
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		this.fontRendererObj.drawString("Upgrade Menu", 53, -10, 65535);
		
		//Frame
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(20, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRendererObj.drawString("Frame", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMetaTierFrame() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(21, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.upgrade_frame, 1, this.airship.getMetaTierFrame()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		//Core
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(60, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRendererObj.drawString("Core", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMetaTierCore() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(59, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.upgrade_core, 1, this.airship.getMetaTierCore()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
				
		//Engine
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(95.5, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRendererObj.drawString("Engine", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMetaTierEngine() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(97, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.upgrade_engine, 1, this.airship.getMetaTierEngine()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		//Balloon
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(132, 22.2, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.fontRendererObj.drawString("Balloon", 0, 0, 16777215);
		}
		GlStateManager.popMatrix();
		if(this.airship.getMetaTierBalloon() > 0)
		{
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(135, 32, 0);
				GlStateManager.scale(1.25, 1.25, 1.25);
				
				this.drawItemStack(new ItemStack(InitItemsVC.upgrade_balloon, 1, this.airship.getMetaTierBalloon()), 0, 0, "");
			}
			GlStateManager.popMatrix();
		}
		
		int tooltipFrameX = 22;
		int tooltipFrameY = 33;
		
		//Logic for mouse-over Frame tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 0 && mouseX <= this.guiLeft + tooltipFrameX + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + "Frame affects the Core, Engine,");
			text.add(TextFormatting.LIGHT_PURPLE + "and Balloon tier upgrades that");
			text.add(TextFormatting.LIGHT_PURPLE + "can be applied.");
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 10, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Core tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 38 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 38 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + "Core affects an airship's");
			text.add(TextFormatting.LIGHT_PURPLE + "base speed.");
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + "Base bonus: " + TextFormatting.GREEN + "+" + this.airship.metaTierCore);
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 15, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Engine tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 76 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 76 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + "Engine affects an airship's");
			text.add(TextFormatting.LIGHT_PURPLE + "fuel efficiency.");
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + "Base bonus: " + TextFormatting.RED + "-" + (EnumsVC.AirshipTierEngine.byId(this.airship.metaTierEngine).getFuelPerTick()));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 15, 0);
				GlStateManager.scale(0.5, 0.5, 0.5);
				
				this.drawHoveringText(text, 0, 0);
			}
			GlStateManager.popMatrix();
		}
		
		//Logic for mouse-over Balloon tooltip
		if(mouseX >= this.guiLeft + tooltipFrameX + 114 + 0 && mouseX <= this.guiLeft + tooltipFrameX + 114 + 17
		&& mouseY >= this.guiTop + tooltipFrameY + 0 && mouseY <= this.guiTop + tooltipFrameY + 17)
		{
			List<String> text = new ArrayList<String>();
			text.add(TextFormatting.LIGHT_PURPLE + "Balloon affects an airship's");
			text.add(TextFormatting.LIGHT_PURPLE + "maximum elevation.");
			text.add(TextFormatting.LIGHT_PURPLE + "");
			text.add(TextFormatting.WHITE + "Base bonus: " + TextFormatting.GREEN + (EnumsVC.AirshipTierBalloon.byId(this.airship.metaTierCore).getMaxAltitude()));
			
			FontRenderer fontrenderer = this.getFontRenderer();
			
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(mouseX - this.guiLeft - 42, mouseY - this.guiTop - 15, 0);
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
            this.mc.thePlayer.closeScreen();
        }
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();

        if (!this.mc.thePlayer.isEntityAlive() || this.mc.thePlayer.isDead
        || !this.mc.thePlayer.isRiding())
        {
            this.mc.thePlayer.closeScreen();
        }
    }
	
	/**
     * Draws an ItemStack.
     */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRendererObj;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
    
    public FontRenderer getFontRenderer()
    {
        return this.mc.fontRendererObj;
    }
}

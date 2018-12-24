package com.vies.viesmachines.client.gui;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.api.util.Keybinds;
import com.vies.viesmachines.client.gui.buttons.GuiButtonMenuCustomizeVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonMenuMainVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonMenuStatsVM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuCustomize;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuStats;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;

public class GuiContainerVM extends GuiContainer {
	
	protected String localizedModName = "";
	protected int modelRotationHorizontal;
	protected boolean modelRidingEntity;
	
	public static int machineTexture;
	
	public static boolean machineColorActive;
	public static int textRedNumber;
	public static int textGreenNumber;
	public static int textBlueNumber;
	
	public static String textNameStorage;
	
	public static int ammoToApply;
	
	public static int metaInfo;
	public static int itemstackInfo;
	public static int itemstackMetaInfo;
	public static int headInfo;
	public static int supporterHeadInfo;
	public static int holidayInfo;
	
	protected IInventory playerInv;
	protected EntityMachineBase machine;
	
	
	
	public GuiContainerVM(Container inventorySlotsIn, IInventory playerInvIn, EntityMachineBase machineIn) 
	{
		super(inventorySlotsIn);

		this.playerInv = playerInvIn;
		this.machine = machineIn;
		
		this.xSize = 176;
		this.ySize = 222;
		
		this.zLevel = 200.0F;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	GuiVM.buttonMM1 = new GuiButtonMenuMainVM(1001, this.guiLeft - 35, this.guiTop + 14 + (14 * 0)+50, 36, 14, "", 0);
    	GuiVM.buttonMM2 = new GuiButtonMenuStatsVM(1002, this.guiLeft - 35, this.guiTop + 14 + (14 * 1)+50, 36, 14, "", 0);
    	GuiVM.buttonMM3 = new GuiButtonMenuCustomizeVM(1003, this.guiLeft - 35, this.guiTop + 14 + (14 * 2)+50, 36, 14, "", 0);
    	//GuiVM.buttonMM4 = new GuiButtonMenuModuleVC(1004, this.guiLeft - 35, this.guiTop + 14 + (14 * 3)+50, 36, 14, "", 0);
    	//GuiVM.buttonMM5 = new GuiButtonMenuRedstoneVC(1005, this.guiLeft - 35, this.guiTop + 14 + (14 * 6)+50, 36, 14, "", 0);
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1001)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    }
		if (parButton.id == 1002)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuStats());
	    }
		if (parButton.id == 1003)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuCustomize());
	    }
		if (parButton.id == 1004)
	    {
			//NetworkHandler.sendToServer(new MessageGuiModuleMenu());
	    }
		if (parButton.id == 1005)
	    {
			//NetworkHandler.sendToServer(new MessageGuiRedstoneMenu());
	    }
		
		// Preview Undo:
		if (parButton.id == 11)
	    {
			this.modelRotationHorizontal = 160;
		}
		
		// Preview Toggle Riding Entity:
		if (parButton.id == 12
		|| parButton.id == 13)
	    {
			this.modelRidingEntity = !this.modelRidingEntity;
		}
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
	{
		int x = 110+5;
		int x1 = 91+5;
		int x2 = 72+5;
		
		// Draws the top left extension for the current Health amount:
		this.drawRect(this.guiLeft - 35, this.guiTop + 117-x, this.guiLeft + 1, this.guiTop + 137-x, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft - 34, this.guiTop + 118-x, this.guiLeft, this.guiTop + 136-x, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft - 32, this.guiTop + 120-x, this.guiLeft - 2, this.guiTop + 134-x, Color.BLACK.getRGB());
		
		// Draws the bottom left extension for the current Energy amount:
		this.drawRect(this.guiLeft - 35, this.guiTop + 117-x1, this.guiLeft + 1, this.guiTop + 137-x1, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft - 34, this.guiTop + 118-x1, this.guiLeft, this.guiTop + 136-x1, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft - 32, this.guiTop + 120-x1, this.guiLeft - 2, this.guiTop + 134-x1, Color.BLACK.getRGB());
		
		// Draws the bottom left extension for the current Durability amount:
		this.drawRect(this.guiLeft - 35, this.guiTop + 117-x2, this.guiLeft + 1, this.guiTop + 137-x2, Color.BLACK.getRGB());
		this.drawRect(this.guiLeft - 34, this.guiTop + 118-x2, this.guiLeft, this.guiTop + 136-x2, Color.LIGHT_GRAY.getRGB());
		this.drawRect(this.guiLeft - 32, this.guiTop + 120-x2, this.guiLeft - 2, this.guiTop + 134-x2, Color.BLACK.getRGB());
	}
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		// Health label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 7, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("viesmachines.gui.tt.health.0"), 0, false, TextFormatting.RED, 0), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Energy label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 7+19, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("viesmachines.gui.tt.energy.0"), 0, false, TextFormatting.YELLOW, 1), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Durability label:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 7+19+19, 0);
			GlStateManager.scale(0.5, 0.5, 0.5);
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(References.localNameVC("viesmachines.gui.tt.durability.0"), 0, false, TextFormatting.GREEN, 1), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Health amount:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 12, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(Integer.toString((int)this.machine.getHealth()), 0, false, TextFormatting.WHITE, 0), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Energy amount:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 12+19, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(Integer.toString((int)this.machine.getEnergy()), 0, false, TextFormatting.WHITE, 0), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();

		// Durability amount:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(-16.5, 12+19+19, 0);
			GlStateManager.scale(0.75, 0.75, 0.75);
			
			this.drawCenteredString(fontRenderer, this.stringToFlashGolden(Integer.toString((int)this.machine.getDurabilityPercent()) + "%", 0, false, TextFormatting.WHITE, 0), 0, 0, Color.WHITE.getRGB());
		}
		GlStateManager.popMatrix();
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
        
        if(!this.mc.player.isEntityAlive() 
         || this.mc.player.isDead
        || !this.mc.player.isRiding())
        {
            this.mc.player.closeScreen();
        }
    }
	
	//==============================
	
    /** Makes the inserted string centered with no shadow. */
    public void centeredString(FontRenderer fontRendererIn, String text, int x, int y, int color)
    {
        fontRendererIn.drawString(text, (x - fontRendererIn.getStringWidth(text) / 2), y, color);
    }
    
	/** Makes the inserted string flash. */
	protected static String stringToFlashGolden(String parString, int parShineLocation, boolean parReturnToBlack, TextFormatting colorIn, int colorTypeIn)
	{
		int stringLength = parString.length();
		
		TextFormatting color1 = TextFormatting.WHITE;
		TextFormatting color2 = TextFormatting.YELLOW;
		
		if (colorTypeIn == 1)
		{
			color1 = TextFormatting.LIGHT_PURPLE;
			color2 = TextFormatting.DARK_PURPLE;
		}
		
		if(stringLength < 1)
		{
			return "";
		}
		
		String outputString = "";
		
		for(int i = 0; i < stringLength; i++)
		{
			if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 0)
			{
				outputString = outputString + color1 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 1)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else if((i + parShineLocation+Minecraft.getSystemTime() / 20) % 68 == 87)
			{
				outputString = outputString + color2 + parString.substring(i, i + 1);    
			}
			else
			{
				outputString = outputString + colorIn + parString.substring(i, i + 1);        
			}
		}
		
		// Return color to a common one after (most chat is white, but for other GUI might want black):
		if(parReturnToBlack)
		{
			return outputString + TextFormatting.BLACK;
		}
		
		return outputString + TextFormatting.WHITE;
	}
	
	/** Makes the inserted string rainbow colored. */
	protected static String stringToRainbow(String parString, boolean parReturnToBlack)
	{
		int stringLength = parString.length();
	    if (stringLength < 1)
	    {
	    	return "";
	    }
	    String outputString = "";
	    TextFormatting[] colorChar = 
	    {
	        TextFormatting.RED,
	        TextFormatting.DARK_RED,
	        TextFormatting.GOLD,
	        TextFormatting.YELLOW,
	        TextFormatting.GREEN,
	        TextFormatting.DARK_GREEN,
	        TextFormatting.AQUA,
	        TextFormatting.BLUE,
	        TextFormatting.LIGHT_PURPLE,
	        TextFormatting.DARK_PURPLE
        };
	    
	    for (int i = 0; i < stringLength; i++)
	    {
	       outputString = outputString+colorChar[i%8]+parString.substring(i, i+1);
	    }
	    
	    // Return color to a common one after (most chat is white, but for other GUI might want black):
	    if (parReturnToBlack)
	    {
	       return outputString+TextFormatting.BLACK;
	    }
	    return outputString+TextFormatting.WHITE;
	}
    
	/** Get the instance of the font renderer. */
    protected FontRenderer getFontRenderer()
    {
        return this.mc.fontRenderer;
    }
	
	/** Draws an ItemStack. */
    protected void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glEnable(GL11.GL_CULL_FACE);
	        
			float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        if(stack.getItem() instanceof ItemBlock)
			{
	        	GL11.glColor4f(1F, 1F, 1F, 1F);

	        	GlStateManager.translate(x, y, 0F);
            	GlStateManager.translate(0F, 15.0F, 0F);
		    	GlStateManager.rotate(25.0F, 1.0F, 0.0F, 0.0F);
		    	GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
            	GlStateManager.scale(50, 50, 50);
            	
            	GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
            	//Spins Item
    	        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
			}
	        else
	        {
	        	GlStateManager.translate(x, y, 0F);
	        	//GlStateManager.translate(posXIn, posYIn, 50F);
		        GlStateManager.scale(50, 50, 50);
		        
		        //Flips/rotates the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	            

            	//Spins Item
    	        //GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
	        }
			
	        Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
	        
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
    }
	
	/** Draws a Rotating ItemStack. */
    protected void drawRotatingItemStack(ItemStack stack, int posXIn, int posYIn)
    {
    	GlStateManager.pushMatrix();
		{
			float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        if(stack.getItem() instanceof ItemBlock)
			{
	        	GlStateManager.rotate(25.0F, 1.0F, 0.0F, 0.0F);
	        	GlStateManager.translate(posXIn, posYIn, 0F);
            	GlStateManager.translate(0F, 15.0F, 20F);
            	GlStateManager.scale(50, 50, 50);
            	
            	GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
            	//Spins Item
    	        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
			}
	        else
	        {
	        	GlStateManager.translate(posXIn, posYIn, 50F);
		        GlStateManager.scale(50, 50, 0);
		        
		        //Flips/rotates the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	            

            	//Spins Item
    	        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
	        }
			
	        Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
		}
		GlStateManager.popMatrix();
    }
    
    /** Draws a Rotating ItemStack. */
    protected void drawStillItemStack(ItemStack stack, int posXIn, int posYIn)
    {
    	GlStateManager.pushMatrix();
		{
			float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 20.0F) * (180F / (float)Math.PI);
	        
	        if(stack.getItem() instanceof ItemBlock)
			{
	        	
	        	GlStateManager.translate(posXIn, posYIn, 0F);
            	GlStateManager.translate(0F, 2.5F, 30F);
            	
            	GlStateManager.rotate(25.0F, 1.0F, 0.0F, 0.0F);
	        	GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
            	GlStateManager.scale(50, 50, 50);
            	
            	GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            
            	//Spins Item
    	        //GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
			}
	        else
	        {
	        	GlStateManager.translate(posXIn, posYIn, 50F);
		        GlStateManager.scale(50, 50, 0);
		        
		        //Flips/rotates the model right side up.
	            GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
	            GlStateManager.rotate(180.0F, 0.0F, 1.0F, 0.0F);
	            

            	//Spins Item
    	        //GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
	        }
			
	        Minecraft.getMinecraft().getRenderItem().renderItem(stack, TransformType.GROUND);
		}
		GlStateManager.popMatrix();
    }
	
	/** Draws an Entity Head. */
    protected void drawEntityHead(int xIn, int yIn, int skullType)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/gui_heads.png"));
	    	
	    	GlStateManager.translate(this.guiLeft + 41 + xIn, this.guiTop + 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		}
		GlStateManager.popMatrix();
    }
    
    /** Draws an Entity Head Forground. */
    protected void drawEntityHeadForground(int xIn, int yIn, int skullType)
    {
    	
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/gui_heads.png"));
	    	
	    	GlStateManager.translate(41 + xIn, 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		}
		GlStateManager.popMatrix();
    }
	
	/** Draws a Supporter Head. */
    protected void drawEntitySupporterHead(int xIn, int yIn, int skullType)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/gui_supporter_heads.png"));
	    	
	    	GlStateManager.translate(this.guiLeft + 41 + xIn, this.guiTop + 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		}
		GlStateManager.popMatrix();
    }
    
    /** Draws a Supporter Head Forground. */
    protected void drawEntitySupporterHeadForground(int xIn, int yIn, int skullType)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glColor4f(1F, 1F, 1F, 1F);
	    	mc.renderEngine.bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/models/heads/supporters/gui_supporter_heads.png"));
	    	
	    	GlStateManager.translate(41 + xIn, 63 + yIn, 100.0F);
	        GlStateManager.scale(0.625F, 0.625F, 0.625F);
	    	
	    	switch(skullType)
			{
			    case 0:
			    case 1:
			    default:
			    	this.drawTexturedModalRect(0, 0, 0, 0, 32, 32);
			        break;
			    case 2:
			    	this.drawTexturedModalRect(0, 0, 32, 0, 32, 32);
			        break;
			    case 3:
			    	this.drawTexturedModalRect(0, 0, 64, 0, 32, 32);
			        break;
			    case 4:
			    	this.drawTexturedModalRect(0, 0, 96, 0, 32, 32);
			        break;
			    case 5:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			    case 6:
			    	this.drawTexturedModalRect(0, 0, 160, 0, 32, 32);
			        break;
			    case 7:
			    	this.drawTexturedModalRect(0, 0, 192, 0, 32, 32);
			        break;
			    case 8:
			    	this.drawTexturedModalRect(0, 0, 224, 0, 32, 32);
			        break;
			    case 9:
			    	this.drawTexturedModalRect(0, 0, 0, 32, 32, 32);
			        break;
			    case 10:
			    	this.drawTexturedModalRect(0, 0, 32, 32, 32, 32);
			        break;
			    case 11:
			    	this.drawTexturedModalRect(0, 0, 64, 32, 32, 32);
			        break;
			    case 12:
			    	this.drawTexturedModalRect(0, 0, 96, 32, 32, 32);
			        break;
			    case 13:
			    	this.drawTexturedModalRect(0, 0, 128, 0, 32, 32);
			        break;
			}
		}
		GlStateManager.popMatrix();
    }
    
    /** Draws an entity on the screen. */
    protected void drawEntityOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glCullFace(GL11.GL_FRONT);
	        
	        GlStateManager.translate(posX, posY, 100.0F);
	        GlStateManager.scale((float)(scale), (float)scale, (float)scale);
	        
	        /////Flips the model right side up.
	        GlStateManager.rotate(200.0F, 0.0F, 0.0F, 1.0F);
	        GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(30.0F, 1.0F, 0.0F, 0.0F);
	        
	        if (!GuiVM.buttonRotateLeft.isMouseOver() 
    		&& !GuiVM.buttonRotateRight.isMouseOver() 
	        && !this.isShiftKeyDown())
     	    {
		        float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 50.0F) * (180F / (float)Math.PI);
		        
				//Spins Item
		        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
     	    }
	        
	        GlStateManager.rotate(horizontalIn, 0.0F, 1.0F, 0.0F);
	    	
	        RenderHelper.disableStandardItemLighting();
	        
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        
	        //This is the non-multipass rendering way to render an entity.
	        //rendermanager.renderEntity(entityIn, 10.0D, 10.0D, 10.0D, 0.0F, 1.0F, false);
	        
	        rendermanager.renderEntityStatic(entityIn, 0, false);
	        rendermanager.renderMultipass(entityIn, 0F);
	        
	        if (ridingEntityIn)
	        {
	        	Entity rider = entityIn.getControllingPassenger();
	    		
	        	rendermanager.renderEntityStatic(rider, 0, false);
	        }
	        
	        rendermanager.setRenderShadow(true);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
		
		// Fixes the brightness for buttons in relation to the day/night cycle:
		int i = 15728880;
		int j = i % 65536;
        int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
    }
    
    /** Draws a machine part on the screen. */
    protected void drawEntityMachinePartOnScreen(int posX, int posY, int horizontalIn, int scale, Entity entityIn, boolean ridingEntityIn, int previewPartIn)
    {
    	GlStateManager.pushMatrix();
		{
			GL11.glEnable(GL11.GL_CULL_FACE);
	        GL11.glCullFace(GL11.GL_FRONT);
	        
	        EntityMachineBase machineIn = (EntityMachineBase) entityIn;
	        
	        machineIn.setPreviewPart(previewPartIn);
	        
	        GlStateManager.translate(posX, posY, 100.0F);
	        GlStateManager.scale((float)(scale), (float)scale, (float)scale);
	        
	        /////Flips the model right side up.
	        GlStateManager.rotate(200.0F, 0.0F, 0.0F, 1.0F);
	        GlStateManager.rotate(45.0F, 0.0F, 1.0F, 0.0F);
	        GlStateManager.rotate(30.0F, 1.0F, 0.0F, 0.0F);
	        
	        //Fixes the position to be at a right
	        //GlStateManager.rotate(horizontalIn, 0.0F, 1.0F, 0.0F);
	        if (!GuiVM.buttonRotateLeft.isMouseOver() 
    		&& !GuiVM.buttonRotateRight.isMouseOver() 
	        && !this.isShiftKeyDown())
     	    {
		        float itemSpin = (((float)Minecraft.getMinecraft().player.getEntityWorld().getTotalWorldTime() + 1) / 50.0F) * (180F / (float)Math.PI);
		        
				//Spins Item
		        GlStateManager.rotate(itemSpin * 1, 0F, 1F, 0F);
     	    }
	        
	        
	        GlStateManager.rotate(horizontalIn, 0.0F, 1.0F, 0.0F);
	        
	        RenderHelper.disableStandardItemLighting();
	        
	        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
	        
	        rendermanager.setPlayerViewY(180.0F);
	        rendermanager.setRenderShadow(false);
	        
	        //This is the non-multipass rendering way to render an entity.
	        //rendermanager.renderEntity(entityIn, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
	        
	        rendermanager.renderEntityStatic(entityIn, 0, false);
	        rendermanager.renderMultipass(entityIn, 0F);
	        
	        if (ridingEntityIn)
	        {
	        	Entity rider = entityIn.getControllingPassenger();
	        	
	        	rendermanager.renderEntityStatic(rider, 0, false);
	        }
	        
	        rendermanager.setRenderShadow(true);
	        
	        machineIn.setPreviewPart(0);
	        
	        GL11.glCullFace(GL11.GL_BACK);
	        GL11.glDisable(GL11.GL_CULL_FACE);
		}
		GlStateManager.popMatrix();
		
		// Fixes the brightness for buttons in relation to the day/night cycle:
		int i = 15728880;
		int j = i % 65536;
        int k = i / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j, (float)k);
        //GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
    }
    
    public String whitespaceCentering(String main, String toadjust)
    {
    	String frontString = "";
    	int a = main.toString().length();
    	int b = toadjust.toString().length();
    	int spacetoadd = ((a - b) / 2) + 1;
    	
    	
    	for (int i = 0; i < spacetoadd; i++)
    	{
    		frontString = frontString + " ";
    	}
    	
    	
    	return frontString;
    }
}

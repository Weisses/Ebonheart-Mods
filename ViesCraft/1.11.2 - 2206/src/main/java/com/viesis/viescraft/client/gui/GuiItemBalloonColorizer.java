package com.viesis.viescraft.client.gui;

import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.google.common.collect.Lists;
import com.google.gson.JsonParseException;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.network.NetworkHandler;
import com.viesis.viescraft.network.server.MessageGuiColorizerBalloon;
import com.viesis.viescraft.network.server.v1.MessageGuiV1ModuleInventorySmall;

import io.netty.buffer.Unpooled;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemWrittenBook;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.client.CPacketCustomPayload;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiItemBalloonColorizer extends GuiScreen {
	
	private static final ResourceLocation ITEM_GUI_TEXTURES = new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_balloon_colorizer.png");
	
	private NBTTagList tagColor;
	
    private boolean hasScrollBar = true;
    
    protected int guiLeft;
    protected int guiTop;
    protected int xSize = 176;
    protected int ySize = 166;
    
	public static GuiTextField textRed;
	public static GuiTextField textGreen;
	public static GuiTextField textBlue;
	
	public static int textRedNumber;
	public static int textGreenNumber;
	public static int textBlueNumber;
	
	private GuiButton buttonRed;
	private GuiButton buttonGreen;
	private GuiButton buttonBlue;
	private GuiButton buttonAccept;
	
	private final EntityPlayer editingPlayer;
    private final ItemStack itemObj;
    
	public GuiItemBalloonColorizer(EntityPlayer player, ItemStack item)
	{
		this.editingPlayer = player;
		this.itemObj = item;
		this.allowUserInput = true;
		
		if (item.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = item.getTagCompound();
            
            this.textRedNumber = nbttagcompound.getInteger("ColorRed");
            this.textGreenNumber = nbttagcompound.getInteger("ColorGreen");
            this.textBlueNumber = nbttagcompound.getInteger("ColorBlue");
            
        }
		else
		{
			this.tagColor = new NBTTagList();
            this.tagColor.appendTag(new NBTTagString("Author"));
            
            this.textRedNumber = 0;
            this.textGreenNumber = 0;
            this.textBlueNumber = 0;
		}
		
		if (this.tagColor == null)
        {
            this.tagColor = new NBTTagList();
            this.tagColor.appendTag(new NBTTagString("Author"));
        }
	}
	
	
	@Override
	public void initGui()
    {
		Keyboard.enableRepeatEvents(true);
		
		this.guiLeft = (this.width - this.xSize) / 2;
        this.guiTop = (this.height - this.ySize) / 2;
        
        //=============================================
        
        
        this.textRed = new GuiTextField(1, this.fontRendererObj, this.guiLeft + 76, this.guiTop + 36, 28, 20);
        textRed.setMaxStringLength(3);
        textRed.setText(String.valueOf(this.textRedNumber));
    	this.textRed.setFocused(false);
    	
    	this.textGreen = new GuiTextField(2, this.fontRendererObj, this.guiLeft + 76, this.guiTop + 80, 28, 20);
        textGreen.setMaxStringLength(3);
        textGreen.setText(String.valueOf(this.textGreenNumber));
    	this.textGreen.setFocused(false);
    	
    	this.textBlue = new GuiTextField(3, this.fontRendererObj, this.guiLeft + 76, this.guiTop + 124, 28, 20);
        textBlue.setMaxStringLength(3);
        textBlue.setText(String.valueOf(this.textBlueNumber));
    	this.textBlue.setFocused(false);

        //=============================================
        
    	buttonRed = new GuiButton( 1, this.guiLeft + 26, this.guiTop + 36, 37, 20, "Save");
		this.buttonList.add(buttonRed);
		
		buttonGreen = new GuiButton( 2, this.guiLeft + 26, this.guiTop + 80, 37, 20, "Save");
		this.buttonList.add(buttonGreen);
		
		buttonBlue = new GuiButton( 3, this.guiLeft + 26, this.guiTop + 124, 37, 20, "Save");
		this.buttonList.add(buttonBlue);
		
    	buttonAccept = new GuiButton( 4, this.guiLeft + 42, this.guiTop + 156, 96, 20, "Done");
		this.buttonList.add(buttonAccept);
		
    }
	
	/**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        this.mc.getTextureManager().bindTexture(ITEM_GUI_TEXTURES);
        int i = (this.width - 192) / 2;
        int j = 2;
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, 176, 192);
        
        float red = this.textRedNumber / 255.0f;
        float green = this.textGreenNumber / 255.0f;
        float blue = this.textBlueNumber / 255.0f;
        
        GlStateManager.color(red, green, blue, 1.0F);
        this.drawTexturedModalRect(this.guiLeft + 124, this.guiTop + 26, 176, 0, 35, 120);
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        
        String title = "Balloon Color";
    	this.fontRendererObj.drawString(title, this.guiLeft + 56, this.guiTop + 8, 4210752);
		
    	String stringRed = "Red";
    	this.fontRendererObj.drawString(stringRed, this.guiLeft + 36, this.guiTop + 26, 16711680);
		
    	String stringGreen = "Green";
    	this.fontRendererObj.drawString(stringGreen, this.guiLeft + 30, this.guiTop + 70, 32768);
		
    	String stringBlue = "Blue";
    	this.fontRendererObj.drawString(stringBlue, this.guiLeft + 34, this.guiTop + 114, 255);
		
    	String max = "0-255";
    	this.fontRendererObj.drawString(max, this.guiLeft + 75, this.guiTop + 26, 16777215);
    	this.fontRendererObj.drawString(max, this.guiLeft + 75, this.guiTop + 70, 16777215);
    	this.fontRendererObj.drawString(max, this.guiLeft + 75, this.guiTop + 114, 16777215);
    	
    	this.textRed.drawTextBox();
    	this.textGreen.drawTextBox();
    	this.textBlue.drawTextBox();
    	
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
	@Override
	protected void mouseClicked(int x, int y, int btn) throws IOException {
        super.mouseClicked(x, y, btn);
        
        this.textRed.mouseClicked(x, y, btn);
        this.textGreen.mouseClicked(x, y, btn);
        this.textBlue.mouseClicked(x, y, btn);
    }
	
	@Override
	public void updateScreen()
    {
        super.updateScreen();
        
        this.textRed.updateCursorCounter();
        this.textGreen.updateCursorCounter();
        this.textBlue.updateCursorCounter();
    }
	
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if (parButton.id == 1)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
			}
			
			this.sendTagToServer(1);
	    }
		
		if (parButton.id == 2)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
			}
			
			this.sendTagToServer(2);
	    }
		
		if (parButton.id == 3)
	    {
			if(textRed.getText() != null)
			{
				try {
					textRedNumber = Integer.parseInt(textRed.getText());
				} catch(NumberFormatException ex) {
					textRedNumber = 0;
				}
			}
			
			if(textGreen.getText() != null)
			{
				try {
					textGreenNumber = Integer.parseInt(textGreen.getText());
				} catch(NumberFormatException ex) {
					textGreenNumber = 0;
				}
			}
			
			if(textBlue.getText() != null)
			{
				try {
					textBlueNumber = Integer.parseInt(textBlue.getText());
				} catch(NumberFormatException ex) {
					textBlueNumber = 0;
				}
			}
			
			this.sendTagToServer(3);
	    }
		
		if (parButton.id == 4)
	    {
			this.sendTagToServer(4);
			
			this.mc.displayGuiScreen((GuiScreen)null);
			//this.mc.player.closeScreen();
	    }
		
		
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		super.keyTyped(typedChar, keyCode);
		
        this.textRed.textboxKeyTyped(typedChar, keyCode);
        this.textGreen.textboxKeyTyped(typedChar, keyCode);
        this.textBlue.textboxKeyTyped(typedChar, keyCode);
        
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	@Override
	public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }
	
	private void sendTagToServer(int publish)// throws IOException
    {
		
		NBTTagCompound nbttagcompound = this.itemObj.getTagCompound();
        /**
		//if (publish == 1)
        //{
			if (this.itemObj.hasTagCompound())
	        {
				nbttagcompound.setInteger("ColorRed", this.textRedNumber);//this.textRedNumber);
	        }
			else
	        {
	        	this.itemObj.setTagInfo("Author", this.tagColor);
	        	
	        	nbttagcompound.setInteger("ColorRed", this.textRedNumber);
	        }
        //}
		
		//if (publish == 2)
        //{
			if (this.itemObj.hasTagCompound())
	        {
				nbttagcompound.setInteger("ColorGreen", this.textGreenNumber);//this.textGreenNumber);
	        }
			else
	        {
	        	this.itemObj.setTagInfo("Author", this.tagColor);
	        	
	        	nbttagcompound.setInteger("ColorGreen", this.textGreenNumber);
	        }
        //}
		
		//if (publish == 3)
        //{
			if (this.itemObj.hasTagCompound())
	        {
				nbttagcompound.setInteger("ColorBlue", this.textBlueNumber);//this.textBlueNumber);
	        }
			else
	        {
	        	this.itemObj.setTagInfo("Author", this.tagColor);
	        	
	        	nbttagcompound.setInteger("ColorBlue", this.textBlueNumber);
	        }
        //}
		*/
		
		
		
		if (this.itemObj.hasTagCompound())
        {
        	//NBTTagCompound nbttagcompound = this.itemObj.getTagCompound();
            
            nbttagcompound.setInteger("ColorRed", this.textRedNumber);//this.textRedNumber);
            nbttagcompound.setInteger("ColorGreen", this.textGreenNumber);//this.textGreenNumber);
            nbttagcompound.setInteger("ColorBlue", this.textBlueNumber);//this.textBlueNumber);
            
        }
        else
        {
        	
        	this.itemObj.setTagInfo("Author", this.tagColor);
        	
        	//NBTTagCompound nbttagcompound = this.itemObj.getTagCompound();
        	
        	//nbttagcompound.setInteger("ColorRed", this.textRedNumber);
        	//nbttagcompound.setInteger("ColorGreen", this.textGreenNumber);
            //nbttagcompound.setInteger("ColorBlue", this.textBlueNumber);
        }

        String s1 = "VC|Edit";

        //if (publish == 4)
        //{
        //    //s1 = "VC|Bsign";
        //    this.itemObj.setTagInfo("Author", new NBTTagString(this.editingPlayer.getName()));
        //    //this.itemObj.setTagInfo("title", new NBTTagString(this.textRed.getText()));
        //}
        
        NetworkHandler.sendToServer(new MessageGuiColorizerBalloon());
        
        //PacketBuffer packetbuffer = new PacketBuffer(Unpooled.buffer());
        //packetbuffer.writeItemStack(this.itemObj);
        //this.mc.getConnection().sendPacket(new CPacketCustomPayload(s1, packetbuffer));
    }
	
	
	
	
}		

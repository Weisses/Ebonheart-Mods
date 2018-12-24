package com.vies.viesmachines.client.gui.misc;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiScrollingListRadioExpansion;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.common.items.tools.ContainerToolNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.item.MessageHelperItemToolRadioExpansion;
import com.vies.viesmachines.proxy.ClientProxy;
import com.vies.viesmachines.proxy.CommonProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiUtilRenderComponents;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.client.GuiScrollingList;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class GuiRadioExpansionSelectMusic extends GuiContainer {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_radio_expansion.png");
	
	private NBTTagList tagSong;
	
	private String localizedModName = "";
	
	//protected int guiLeft;
    //protected int guiTop;
    protected int xSize = 176;
    protected int ySize = 222;
    
	private ArrayList<ResourceLocation> songs;
	private GuiScrollingListRadioExpansion songList;
	
    private GuiScreen mainMenu;
    private GuiScrollingList songInfo;
    private int selected = -1;
    private ResourceLocation selectedSong;
    private int listWidth;
    private int buttonMargin = 1;
    
    public static int setSong;
    
    private final EntityPlayer editingPlayer;
    private final ItemStack itemObj;
    
	public GuiRadioExpansionSelectMusic(EntityPlayer player, ItemStack itemstackIn)
	{
		super(new ContainerToolNoSlots(player.inventory));
		
		//this.guiLeft = (this.width - this.xSize) / 2;
        //this.guiTop = (this.height - this.ySize) / 2;
        this.songs = CommonProxy.musicListRecord;
        this.zLevel = 0.0F;
        //this.guiTop = ySize;
        //this.guiLeft = xSize;
        this.editingPlayer = player;
		this.itemObj = itemstackIn;
		this.allowUserInput = true;
		
		this.xSize = 176;
		this.ySize = 222;
		
		if (itemstackIn.hasTagCompound())
        {
            NBTTagCompound nbttagcompound = itemstackIn.getTagCompound();
            
            this.setSong = nbttagcompound.getInteger(References.TOOL_RECORD_TO_ADD_TAG);
            //this.textGreenNumber = nbttagcompound.getInteger("ColorGreen");
            //this.textBlueNumber = nbttagcompound.getInteger("ColorBlue");
        }
		else
		{
			this.tagSong = new NBTTagList();
            //this.tagSong.appendTag(new NBTTagString("Author"));
            
            this.setSong = 0;
            //this.textGreenNumber = 0;
            //this.textBlueNumber = 0;
            
            this.tagSong.appendTag(new NBTTagString(References.TOOL_RECORD_TO_ADD_TAG));
            //this.tagColor.appendTag(new NBTTagString("ColorGreen"));
            //this.tagColor.appendTag(new NBTTagString("ColorBlue"));
		}
		
		if (this.tagSong == null)
        {
            this.tagSong = new NBTTagList();
            this.tagSong.appendTag(new NBTTagString(References.TOOL_RECORD_TO_ADD_TAG));
        }
		
		/*
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
            
            this.tagColor.appendTag(new NBTTagString("ColorRed"));
            this.tagColor.appendTag(new NBTTagString("ColorGreen"));
            this.tagColor.appendTag(new NBTTagString("ColorBlue"));
		}
		
		if (this.tagColor == null)
        {
            this.tagColor = new NBTTagList();
            this.tagColor.appendTag(new NBTTagString("Author"));
        }
        */
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		
		//this.guiLeft = (this.width - this.xSize) / 2;
        //this.guiTop = (this.height - this.ySize) / 2;
        
		
		
    	int slotHeight = 15;
    	
    	for (ResourceLocation mod : songs)
        {
            this.listWidth = Math.max(this.listWidth,References.getFontRenderer().getStringWidth(mod.getResourcePath()) + 10);
        }
    	
    	this.listWidth = Math.min(this.listWidth, 150);
        
    	this.songList = new GuiScrollingListRadioExpansion(this, this.songs, this.listWidth, slotHeight);
    	
    	GuiVM.button501 = new GuiButtonGeneral1VM(501, this.guiLeft + 60, this.guiTop + 169, 56, 14, References.localNameVC("gui.done"), 0);
    	this.buttonList.add(GuiVM.button501);
    }
    
    @Override
    protected void actionPerformed(GuiButton button)
    {
    	//super.actionPerformed(button);
        
		//if (button.id == 501)
	    //{
		//	NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    //}
		
		

		
		this.sendTagToServer(4);
		
		this.mc.player.closeScreen();
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		//super.drawGuiContainerBackgroundLayer(partialTicks, mouseX, mouseY);
		
		// Binds the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop-28, 0, 0, this.xSize, this.ySize);
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		super.drawGuiContainerForegroundLayer(mouseX, mouseY);
		
		// Radio Expansion Tool:
		this.centeredString(fontRenderer, References.localNameVC(
				//"viesmachines.gui.currentsong.0"
				"viesmachines.gui.radioexpansiontoolmenu.0"
				), 88, -20, Color.BLACK.getRGB());
		
		// 'Selected Record':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 12, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.selectsong.0"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		
		
		for (ModContainer mod : Loader.instance().getModList())
        {
			if (mod.getModId().equals(
					ClientProxy.musicListRecord
					.get(this.setSong).getResourceDomain().toString()
					
					//"viesmachines"
					
					))
			{
				this.localizedModName = mod.getName();
			}
        }
		
		// 'Modid':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 21, 0);
	        GlStateManager.scale(0.75F, 0.75F, 0.75F);
	        
	        this.centeredString(fontRenderer, 
	        	this.stringToFlashGolden(this.localizedModName, 1, false, TextFormatting.GREEN, 0)
    		, 0, 0, Color.BLACK.getRGB());
		}
		GlStateManager.popMatrix();
		
		// Song:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 35, 0);
			GlStateManager.scale(0.75F, 0.75F, 0.75F);
			// Current Song label:
			//this.centeredString(fontRenderer, References.localNameVC(
			//		//"viesmachines.gui.currentsong.0"
			//		"Selected Record"
			//		), 0, -24, Color.BLACK.getRGB());
			
			this.centeredString(fontRenderer, 
			this.stringToFlashGolden(
			References.localNameVC( "item." + ClientProxy.musicListRecord.get(this.setSong).getResourcePath().toString() + ".desc")
			, 1, false, TextFormatting.DARK_AQUA, 0)	
			, 0, 0, Color.BLUE.getRGB());
			
		}
		GlStateManager.popMatrix();
	}
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.songList.drawScreen(mouseX, mouseY, partialTicks);
        
        if (this.songInfo != null)
        {
            this.songInfo.drawScreen(mouseX, mouseY, partialTicks);
        }
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	
    @Override
    public void handleMouseInput() throws IOException
    {
        int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        super.handleMouseInput();
        if (this.songInfo != null)
        {
        	this.songInfo.handleMouseInput(mouseX, mouseY);
        }
        
        this.songList.handleMouseInput(mouseX, mouseY);
    }
    
    private void updateCache()
    {
        songInfo = null;
        
        if (selectedSong == null)
        {
        	return;
        }
        
        ResourceLocation logoPath = null;
        Dimension logoDims = new Dimension(0, 0);
        List<String> lines = new ArrayList<String>();
        
        for(int i = 0; i < ClientProxy.musicListRecord.size(); i++)
		{
			if(ClientProxy.musicListRecord.get(i).toString().toLowerCase().contains(selectedSong.toString().toLowerCase()))
		    {
				this.setSong = i;
				//this.machine.selectedSong = i;
				//NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicSet());
		    }
		}
    }
    
    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException
    {
        super.mouseClicked(x, y, button);
    }
    
    @Override
    protected void keyTyped(char c, int keyCode) throws IOException
    {
        super.keyTyped(c, keyCode);
    }
    
    public Minecraft getMinecraftInstance()
    {
        return mc;
    }
    
    public void selectModIndex(int index)
    {
        if (index == this.selected)
            return;
        this.selected = index;
        this.selectedSong = (index >= 0 && index <= songs.size()) ? songs.get(selected) : null;

        updateCache();
    }

    public boolean modIndexSelected(int index)
    {
        return index == selected;
    }
    
    private void sendTagToServer(int publish)
    {
		NBTTagCompound nbttagcompound = this.itemObj.getTagCompound();
        
		if (this.itemObj.hasTagCompound())
        {
        	nbttagcompound.setInteger(References.TOOL_RECORD_TO_ADD_TAG, this.setSong);
            //nbttagcompound.setInteger("ColorGreen", this.textGreenNumber);
            //nbttagcompound.setInteger("ColorBlue", this.textBlueNumber);
        }
        else
        {
        	this.itemObj.setTagInfo("Author", this.tagSong);
        }
		
		NetworkHandler.sendToServer(new MessageHelperItemToolRadioExpansion());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @Override
	public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	@Override
	public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
    }
    
    //==================================================
    
    private class Info extends GuiScrollingList
    {
        @Nullable
        private ResourceLocation logoPath;
        private Dimension logoDims;
        private List<ITextComponent> lines = null;

        public Info(int width, List<String> lines, @Nullable ResourceLocation logoPath, Dimension logoDims)
        {
            super(GuiRadioExpansionSelectMusic.this.getMinecraftInstance(),
                  width,
                  GuiRadioExpansionSelectMusic.this.height,
                  32, GuiRadioExpansionSelectMusic.this.height - 88 + 4,
                  GuiRadioExpansionSelectMusic.this.listWidth + 20, 60,
                  GuiRadioExpansionSelectMusic.this.width,
                  GuiRadioExpansionSelectMusic.this.height);
            this.lines    = resizeContent(lines);
            this.logoPath = logoPath;
            this.logoDims = logoDims;

            this.setHeaderInfo(true, getHeaderHeight());
        }

        @Override protected int getSize() { return 0; }
        @Override protected void elementClicked(int index, boolean doubleClick) { }
        @Override protected boolean isSelected(int index) { return false; }
        @Override protected void drawBackground() {}
        @Override protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) { }

        private List<ITextComponent> resizeContent(List<String> lines)
        {
            List<ITextComponent> ret = new ArrayList<ITextComponent>();
            for (String line : lines)
            {
                if (line == null)
                {
                    ret.add(null);
                    continue;
                }

                ITextComponent chat = ForgeHooks.newChatWithLinks(line, false);
                int maxTextLength = this.listWidth - 8;
                if (maxTextLength >= 0)
                {
                    ret.addAll(GuiUtilRenderComponents.splitText(chat, maxTextLength, GuiRadioExpansionSelectMusic.this.fontRenderer, false, true));
                }
            }
            return ret;
        }

        private int getHeaderHeight()
        {
          int height = 0;
          if (logoPath != null)
          {
              double scaleX = logoDims.width / 200.0;
              double scaleY = logoDims.height / 65.0;
              double scale = 1.0;
              if (scaleX > 1 || scaleY > 1)
              {
                  scale = 1.0 / Math.max(scaleX, scaleY);
              }
              logoDims.width *= scale;
              logoDims.height *= scale;

              height += logoDims.height;
              height += 10;
          }
          height += (lines.size() * 10);
          if (height < this.bottom - this.top - 8) height = this.bottom - this.top - 8;
          return height;
        }
        
        
        @Override
        protected void drawHeader(int entryRight, int relativeY, Tessellator tess)
        {
            int top = relativeY;

            if (logoPath != null)
            {
                GlStateManager.enableBlend();
                GuiRadioExpansionSelectMusic.this.mc.renderEngine.bindTexture(logoPath);
                BufferBuilder wr = tess.getBuffer();
                int offset = (this.left + this.listWidth/2) - (logoDims.width / 2);
                wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                wr.pos(offset,                  top + logoDims.height, zLevel).tex(0, 1).endVertex();
                wr.pos(offset + logoDims.width, top + logoDims.height, zLevel).tex(1, 1).endVertex();
                wr.pos(offset + logoDims.width, top,                   zLevel).tex(1, 0).endVertex();
                wr.pos(offset,                  top,                   zLevel).tex(0, 0).endVertex();
                tess.draw();
                GlStateManager.disableBlend();
                top += logoDims.height + 10;
            }

            for (ITextComponent line : lines)
            {
                if (line != null)
                {
                    GlStateManager.enableBlend();
                    GuiRadioExpansionSelectMusic.this.fontRenderer.drawStringWithShadow(line.getFormattedText(), this.left + 4, top, 0xFFFFFF);
                    GlStateManager.disableAlpha();
                    GlStateManager.disableBlend();
                }
                top += 10;
            }
        }

        @Override
        protected void clickHeader(int x, int y)
        {
            int offset = y;
            if (logoPath != null) {
              offset -= logoDims.height + 10;
            }
            if (offset <= 0)
                return;

            int lineIdx = offset / 10;
            if (lineIdx >= lines.size())
                return;

            ITextComponent line = lines.get(lineIdx);
            if (line != null)
            {
                int k = -4;
                for (ITextComponent part : line) {
                    if (!(part instanceof TextComponentString))
                        continue;
                    k += GuiRadioExpansionSelectMusic.this.fontRenderer.getStringWidth(((TextComponentString)part).getText());
                    if (k >= x)
                    {
                        GuiRadioExpansionSelectMusic.this.handleComponentClick(part);
                        break;
                    }
                }
            }
        }
    }

	
	/** Get the instance of the font renderer. */
	public FontRenderer getFontRenderer()
	{
	    return this.mc.fontRenderer;
	}
	
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
	
}

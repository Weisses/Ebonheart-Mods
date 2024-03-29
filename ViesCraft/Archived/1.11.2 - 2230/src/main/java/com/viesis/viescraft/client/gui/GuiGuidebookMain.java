package com.viesis.viescraft.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuidebookMain extends GuiScreen {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 29;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
    public GuiGuidebookMain()
    {
    	bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_0.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_1.png");
        bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_2.png");
        bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_3.png");
        bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_4.png");
        bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_5.png");
        bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_6.png");
        bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_7.png");
        bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_8.png");
        bookPageTextures[9] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_9.png");
        bookPageTextures[10] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_10.png");
        bookPageTextures[11] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_11.png");
        bookPageTextures[12] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_12.png");
        bookPageTextures[13] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_13.png");
        bookPageTextures[14] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_14.png");
        bookPageTextures[15] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_15.png");
        bookPageTextures[16] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_16.png");
        bookPageTextures[17] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_17.png");
        bookPageTextures[18] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_18.png");
        bookPageTextures[19] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_19.png");
        bookPageTextures[20] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_20.png");
        bookPageTextures[21] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_21.png");
        bookPageTextures[22] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_22.png");
        bookPageTextures[23] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_23.png");
        bookPageTextures[24] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_24.png");
        bookPageTextures[25] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_25.png");
        bookPageTextures[26] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_26.png");
        bookPageTextures[27] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_27.png");
        bookPageTextures[28] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/main/page_28.png");
        
        //Title
        stringPageText[0] = "\n\n\n\n\n\n\n"
        		+ "   " + "\u00A7l\u00A7nThe \'Vies\' Craft\u00A7r"
        		+ "\n\n" 
        		+ "         " + "\u00A7oby Viesis\u00A7r"
        		+ "\n\n\n\n" 
        		+ "           " + Reference.MOD_VERSION;
        
        stringPageText[1] = "   Nem said it wasn't possible! He always said players can only fly via the power "
        		+ "of \"\u00A7ocreative\u00A7r\". "
        		+ "Well today I prove him "
        		+ "wrong! "
        		+ "\n\n"
        		+ "   These \"\u00A7oairships\u00A7r\" will "
        		+ "forever change how "
        		+ "we explore our world. "
        		+ "I now share my wisdom "
        		+ "with you... ";
        
        stringPageText[2] = "Block Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Workbench\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oA\u00A7r \u00A7l\u00A7nmust\u00A7r \u00A7ohave! Used in \u00A7r"
        		+ "\u00A7omaking all recipes.\u00A7r";
        
        stringPageText[3] = "   All of the airship "
        		+ "related items in all of "
        		+ "my guide books are "
        		+ "made using the \u00A7oAirship "
        		+ "Workbench.\u00A7r "
        		+ "\n\n"
        		+ "   Now that we have our workbench, let's go over some of the basic parts you will need.";
        		
        stringPageText[4] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Balloon\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oMade out of leather and built to last.\u00A7r";
        
        stringPageText[5] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Engine\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oGenerates power so you don't have to.\u00A7r";
        
        stringPageText[6] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Ignition\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oThe \"heart\" of the airship.\u00A7r";
        
        
        stringPageText[7] = "   Now that you have "
        		+ "your basic parts, it's "
        		+ "time to create the "
        		+ "\u00A7oAirship Frame\u00A7r! "
        		+ ""
        		+ "This item dictates what "
        		+ "your frame looks like "
        		+ "and can be changed "
        		+ "using any frame, any time. "
        		+ "\n\n\n\n"
        		+ "Note: Frames don't affect speed! ";
        
        stringPageText[8] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nOak"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lWood Planks\u00A7r";
        
        stringPageText[9] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nIron"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lIron Ingot\u00A7r";
        
        stringPageText[10] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nRedstone"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lRedstone Dust\u00A7r";
        
        stringPageText[11] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nGold"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lGold Ingot\u00A7r";
        
        stringPageText[12] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nLapis Lazuli"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lLapis Lazuli\u00A7r";
        
        stringPageText[13] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nObsidian"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lObsidian Block\u00A7r";
        
        stringPageText[14] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nDiamond"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lDiamond\u00A7r";
        
        stringPageText[15] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nEmerald"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lEmerald\u00A7r";
        
        stringPageText[16] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nNether Brick"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lNether Brick\u00A7r";
        
        stringPageText[17] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nPurpur"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lPurpur\u00A7r";
        
        stringPageText[18] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nIce"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lIce\u00A7r";
        
        stringPageText[19] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nSandstone"
        		+ "\nAirship Frame\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lSandstone\u00A7r";
        
        stringPageText[20] = "   Now that you have "
        		+ "the parts, let's get "
        		+ "\u00A7obuilding\u00A7r! There are \u00A7l4\u00A7r "
        		+ "airship styles: "
        		+ "\n\n"
        		+ "The \u00A75\u00A7l\u00A7o"
        		+ ViesCraftConfig.v1AirshipName
        		+ "\u00A7r\u00A70. "
        		+ "\n"
        		+ "The \u00A75\u00A7l\u00A7o"
        		+ ViesCraftConfig.v2AirshipName
        		+ "\u00A7r\u00A70. "
        		+ "\n"
        		+ "The \u00A75\u00A7l\u00A7o"
        		+ ViesCraftConfig.v3AirshipName
        		+ "\u00A7r\u00A70. "
        		+ "\n"
        		+ "The \u00A75\u00A7l\u00A7o"
        		+ ViesCraftConfig.v4AirshipName
        		+ "\u00A7r\u00A70. "
        		+ "\n"
        		+ "\n\n"
        		+ "Names can be changed via the config. "
        		;
        
        stringPageText[21] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v1AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oClassic airship. Some things can't be beat.\u00A7r";
        
        stringPageText[22] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v2AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oA unique twist on the airship design.\u00A7r";
    	
        stringPageText[23] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v3AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oAn airship built for the tech enthusiast.\u00A7r";
        
        stringPageText[24] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v4AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oSteampunk airship ingenuity at its finest.\u00A7r";
        
        stringPageText[25] = "Extra Tools:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nDismounter\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oEject mobs from what they are riding in.\u00A7r";
    		
        stringPageText[26] = "Further Reading:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nTaking Control\u00A7r\u00A70"
        		+ "\n               \u00A7l\u00A7nvol.2\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oPiloting airships like a pro.\u00A7r";
    		
        stringPageText[27] = "Further Reading:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nFlaming Paint?!\u00A7r\u00A70"
        		+ "\n               \u00A7l\u00A7nvol.3\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIns and outs of airship-safe paint.\u00A7r";
        
        stringPageText[28] = "Further Reading:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nModules & You\u00A7r\u00A70"
        		+ "\n               \u00A7l\u00A7nvol.4\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oAirship expansion system made easy.\u00A7r";
 }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
     // DEBUG
     //System.out.println("GuiMysteriousStranger initGUI()");
        buttonList.clear();
        Keyboard.enableRepeatEvents(true);

        buttonDone = new GuiButton(0, width / 2 + 2, 4 + bookImageHeight, 
              98, 20, I18n.format("gui.done", new Object[0]));
  
        buttonList.add(buttonDone);
        int offsetFromScreenLeft = (width - bookImageWidth) / 2;
        buttonList.add(buttonNextPage = new NextPageButton(1, 
              offsetFromScreenLeft + 120, 156, true));
        buttonList.add(buttonPreviousPage = new NextPageButton(2, 
              offsetFromScreenLeft + 38, 156, false));
    }

    /**
     * Called from the main game loop to update the screen.
     */
    @Override
    public void updateScreen() 
    {
        buttonDone.visible = (currPage == bookTotalPages - 1);
        buttonNextPage.visible = (currPage < bookTotalPages - 1);
        buttonPreviousPage.visible = currPage > 0;
    }
 
    /**
     * Draws the screen and all the components in it.
     */
    @Override
    public void drawScreen(int parWidth, int parHeight, float p_73863_3_)
    {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        if (currPage == 0)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[0]);
        }
        if (currPage == 1)
        {
        	
        	mc.getTextureManager().bindTexture(bookPageTextures[1]);
        }
        if (currPage == 2)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[2]);
        }
        if (currPage == 3)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[3]);
        }
        if (currPage == 4)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[4]);
        }
        if (currPage == 5)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[5]);
        }
        if (currPage == 6)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[6]);
        }
        if (currPage == 7)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[7]);
        }
        if (currPage == 8)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[8]);
        }
        if (currPage == 9)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[9]);
        }
        if (currPage == 10)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[10]);
        }
        if (currPage == 11)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[11]);
        }
        if (currPage == 12)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[12]);
        }
        if (currPage == 13)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[13]);
        }
        if (currPage == 14)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[14]);
        }
        if (currPage == 15)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[15]);
        }
        if (currPage == 16)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[16]);
        }
        if (currPage == 17)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[17]);
        }
        if (currPage == 18)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[18]);
        }
        if (currPage == 19)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[19]);
        }
        if (currPage == 20)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[20]);
        }
        if (currPage == 21)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[21]);
        }
        if (currPage == 22)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[22]);
        }
        if (currPage == 23)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[23]);
        }
        if (currPage == 24)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[24]);
        }
        if (currPage == 25)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[25]);
        }
        if (currPage == 26)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[26]);
        }
        if (currPage == 27)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[27]);
        }
        if (currPage == 28)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[28]);
        }
        
        //else
        //{
        // mc.getTextureManager().bindTexture(bookPageTextures[2]);
        //}
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
              bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", 
              new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, 
              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
              18, 1);
        fontRendererObj.drawSplitString(stringPageText[currPage], 
              offsetFromScreenLeft + 36, 34, 116, 0);
        super.drawScreen(parWidth, parHeight, p_73863_3_);
        
        /**            ON TO SOMETHING FOR RESIZING
        int offsetFromScreenLeft = (width - bookImageWidth ) / 2;
        drawTexturedModalRect(offsetFromScreenLeft, 2, 0, 0, bookImageWidth, 
              bookImageHeight);
        int widthOfString;
        String stringPageIndicator = I18n.format("book.pageIndicator", 
              new Object[] {Integer.valueOf(currPage + 1), bookTotalPages});
        widthOfString = fontRendererObj.getStringWidth(stringPageIndicator);
        fontRendererObj.drawString(stringPageIndicator, 
              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
              18, 1);
        GlStateManager.scale(0.75, 0.75, 0.75);
        fontRendererObj.drawSplitString(stringPageText[currPage], 
              offsetFromScreenLeft + 36 + 66, //x
              34 + 20, //y
              widthOfString  + 60, //wordwrap
              0); //text color
        GlStateManager.scale(1.25, 1.25, 1.25);
        super.drawScreen(parWidth, parHeight, p_73863_3_);
        */
    }

    /**
     * Called when a mouse button is pressed and the mouse is moved around. 
     * Parameters are : mouseX, mouseY, lastButtonClicked & 
     * timeSinceMouseClick.
     */
    @Override
    protected void mouseClickMove(int parMouseX, int parMouseY, 
          int parLastButtonClicked, long parTimeSinceMouseClick) 
    {
     
    }

    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
     if (parButton == buttonDone)
     {
         // You can send a packet to server here if you need server to do 
         // something
         mc.displayGuiScreen((GuiScreen)null);
     }
        else if (parButton == buttonNextPage)
        {
            if (currPage < bookTotalPages - 1)
            {
                ++currPage;
            }
        }
        else if (parButton == buttonPreviousPage)
        {
            if (currPage > 0)
            {
                --currPage;
            }
        }
   }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat 
     * events
     */
    @Override
    public void onGuiClosed() 
    {
     
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in 
     * single-player
     */
    @Override
    public boolean doesGuiPauseGame()
    {
        return false;//true;
    }
    
    @SideOnly(Side.CLIENT)
    static class NextPageButton extends GuiButton
    {
        private final boolean isNextButton;

        public NextPageButton(int parButtonId, int parPosX, int parPosY, 
              boolean parIsNextButton)
        {
            super(parButtonId, parPosX, parPosY, 23, 13, "");
            isNextButton = parIsNextButton;
        }

        /**
         * Draws this button to the screen.
         */
        @Override
        public void drawButton(Minecraft mc, int parX, int parY)
        {
            if (visible)
            {
                boolean isButtonPressed = (parX >= xPosition 
                      && parY >= yPosition 
                      && parX < xPosition + width 
                      && parY < yPosition + height);
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                mc.getTextureManager().bindTexture(bookPageTextures[1]);
                int textureX = 0;
                int textureY = 192;

                if (isButtonPressed)
                {
                    textureX += 23;
                }

                if (!isNextButton)
                {
                    textureY += 13;
                }

                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      23, 13);
            }
        }
    }
}
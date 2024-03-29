package com.viesis.viescraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitBlocksVC;

public class GuiGuidebookMain extends GuiScreen {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 15;
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
        
        //Title
        stringPageText[0] = "\n\n\n\n\n\n\n"
        		+ "   " + "\u00A7l\u00A7nThe \'Vies\' Craft\u00A7r"
        		+ "\n\n" 
        		+ "         " + "\u00A7oby Viesis\u00A7r"
        		+ "\n\n\n\n" 
        		+ "          " + Reference.MOD_VERSION.substring(0, 7);
        
        stringPageText[1] = "   Nem said it couldn't "
        		+ "be done! Players can "
        		+ "only fly via the power "
        		+ "of \"\u00A7ocreative\u00A7r\" he said. "
        		+ "Well today I prove him "
        		+ "wrong! "
        		+ "\n\n\n"
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
        
        stringPageText[3] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Balloon\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oMade out of leather and hide, built to last.\u00A7r";
        
        stringPageText[4] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Engine\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oGenerates power so you don't have to.\u00A7r";
        
        stringPageText[5] = "Part Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nAirship Ignition\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oThe \"heart\" of the airship.\u00A7r";
        
        stringPageText[6] = "   Now that you have "
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
        
        stringPageText[7] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v1AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oClassic airship. Some things can't be beat.\u00A7r";
        
        stringPageText[8] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v2AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oA unique twist on the airship design.\u00A7r";
    	
        stringPageText[9] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v3AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oAn airship built for the tech enthusiast.\u00A7r";
        
        stringPageText[10] = "Airship Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7n"
        		+ ViesCraftConfig.v4AirshipName
        		+ "\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oSteampunk airship ingenuity at its finest.\u00A7r";
        
        stringPageText[11] = "Extra Tools:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nDismounter\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oEject mobs from what they are riding in.\u00A7r";
    		
        stringPageText[12] = "Further Reading:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nTaking Control\u00A7r\u00A70"
        		+ "\n               \u00A7l\u00A7nvol.2\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oPiloting airships like a pro.\u00A7r";
    		
        stringPageText[13] = "Further Reading:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nFlaming Paint?!\u00A7r\u00A70"
        		+ "\n               \u00A7l\u00A7nvol.3\u00A7r"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIns and outs of airship-safe paint.\u00A7r";
        
        stringPageText[14] = "Further Reading:"
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
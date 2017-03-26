package com.viesis.viescraft.client.gui;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuidebookSocket extends GuiScreen {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 9;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
    public GuiGuidebookSocket()
    {
    	bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_0.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_1.png");
        bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_2.png");
        bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_3.png");
        bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_4.png");
        bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_5.png");
        bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_6.png");
        bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_7.png");
        bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_8.png");
        ////bookPageTextures[9] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/socket/page_9.png");
        
        
        //Title
        stringPageText[0] = "\n\n\n\n\n\n\n"
        		+ "    " + "\u00A7l\u00A7nModules & You\u00A7r"
        		+ "\n\n" 
        		+ "         " + "\u00A7oby Viesis\u00A7r"
        		+ "\n\n\n\n" 
        		+ "          " + Reference.MOD_VERSION;
        
        stringPageText[1] = "   The sky is within our "
        		+ "reach, but what if you "
        		+ "had a way to get more "
        		+ "out of your airships? "
        		+ "A way to do more..."
        		+ "\n\n\n"
        		+ "   I have developed a "
        		+ "new system that will "
        		+ "allow you to enhance "
        		+ "your airships. This is "
        		+ "called the module "
        		+ "system. "
        		
        		;
        
        stringPageText[2] = "\n\n\n\n\n\n"
        		+ "   To navigate to your "
        		+ "airship module slot, open the gui and "
        		+ "click on the module button. "
        		+ "\n\n"
        		+ "*Only 1 module can be used at a time."
        		;
        
        stringPageText[3] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nModule Chip\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oBasic chip used to"
        		+ "\nmake modules.\u00A7r";
        
        stringPageText[4] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nSmall Inventory\nModule\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7o9 slot inventory."
        		+ "\n80% speed.\u00A7r";
        
        stringPageText[5] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nLarge Inventory\nModule\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7o18 slot inventory."
        		+ "\n70% speed & fuel x2.\u00A7r";
        
        stringPageText[6] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nMinor Speed\nModule\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7o125% Speed.";
        
        stringPageText[7] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nMajor Speed\nModule\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7o150% Speed."
        		+ "\nFuel x2.\u00A7r";
        
        stringPageText[8] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nInfinite Fuel\nModule\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oNo fuel needed."
        		+ "\n60% speed.\u00A7r";
        /**
        stringPageText[8] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nStealth Module\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7oVanish for 18s."
        		+ "\nCooldown = 2m.\u00A7r";
        
        stringPageText[9] = "Module Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nDash Module\u00A70\u00A7r\u00A70"
        		+ "\n\n\n\n\n\n\n\n"
        		+ "\u00A7o400% speed for 5s."
        		+ "\nCooldown = 1m.\u00A7r";
        */
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
        /**
        if (currPage == 9)
        {
        	mc.getTextureManager().bindTexture(bookPageTextures[9]);
        }
        */
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
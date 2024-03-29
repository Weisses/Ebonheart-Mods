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
import com.viesis.viescraft.init.InitBlocksVC;

public class GuiGuidebookPaint extends GuiScreen {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 18;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
    public GuiGuidebookPaint()
    {
    	bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_0.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_1.png");
        bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_2.png");
        bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_3.png");
        bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_4.png");
        bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_5.png");
        bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_6.png");
        bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_7.png");
        bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_8.png");
        bookPageTextures[9] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_9.png");
        bookPageTextures[10] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_10.png");
        bookPageTextures[11] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_11.png");
        bookPageTextures[12] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_12.png");
        bookPageTextures[13] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_13.png");
        bookPageTextures[14] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_14.png");
        bookPageTextures[15] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_15.png");
        bookPageTextures[16] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_16.png");
        bookPageTextures[17] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/paint/page_17.png");
        
        //Title
        stringPageText[0] = "\n\n\n\n\n\n\n"
        		+ "    " + "\u00A7l\u00A7nFlaming Paint?!\u00A7r"
        		+ "\n\n" 
        		+ "         " + "\u00A7oby Viesis\u00A7r"
        		+ "\n\n\n\n" 
        		+ "          " + Reference.MOD_VERSION.substring(0, 7);
        
        stringPageText[1] = "   Now that you built "
        		+ "your airship and can "
        		+ "pilot it like a pro, let's "
        		+ "move on to customizing "
        		+ "our airships... "
        		+ "\n\n\n"
        		+ "   Using dye, coal or "
        		+ "charcoal to disolve it, "
        		+ "and a bucket to hold it "
        		+ "all in, you can color "
        		+ "your airships to your "
        		+ "liking!  "
        		;
        
        stringPageText[2] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nBlack Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lInk Sac\u00A7r";
        
        stringPageText[3] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nBlue Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lLapis Lazuli\u00A7r";
        
        stringPageText[4] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nBrown Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lCocoa Beans\u00A7r";
        
        stringPageText[5] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nCyan Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lCyan Dye\u00A7r";
        
        stringPageText[6] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nGray Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lGray Dye\u00A7r";
        
        stringPageText[7] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nGreen Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lCactus Green\u00A7r";
        
        stringPageText[8] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nLight Blue Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lLight Blue Dye\u00A7r";
    	
        stringPageText[9] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nLight Gray Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lLight Gray Dye\u00A7r";
        
        stringPageText[10] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nLime Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lLime Dye\u00A7r";
    		
        stringPageText[11] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nMagenta Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lMagenta Dye\u00A7r";
        
        stringPageText[12] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nOrange Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lOrange Dye\u00A7r";
        
        stringPageText[13] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nPink Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lPink Dye\u00A7r";
        
        stringPageText[14] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nPurple Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lPurple Dye\u00A7r";
        
        stringPageText[15] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nRed Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lRose Red\u00A7r";
        
        stringPageText[16] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nWhite Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lBone Meal\u00A7r";
        
        stringPageText[17] = "Paint Recipe:"
        		+ "\n\n"
        		+ "\u00A7l\u00A7nYellow Paint\u00A7r"
        		+ "\n\n\n\n\n\n\n\n\n"
        		+ "\u00A7oIngredient:\u00A7r"
        		+ "\n"
        		+ "\u00A7o\u00A7lDandelion Yellow\u00A7r";
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
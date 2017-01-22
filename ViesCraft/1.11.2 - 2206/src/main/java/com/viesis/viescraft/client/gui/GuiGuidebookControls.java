package com.viesis.viescraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;

public class GuiGuidebookControls extends GuiScreen {
	
    private final int bookImageHeight = 192;
    private final int bookImageWidth = 192;
    private int currPage = 0;
    private static final int bookTotalPages = 12;
    private static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    private static String[] stringPageText = new String[bookTotalPages];
    
    private GuiButton buttonDone;
    private NextPageButton buttonNextPage;
    private NextPageButton buttonPreviousPage;
    
    public GuiGuidebookControls()
    {
    	bookPageTextures[0] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_0.png");
        bookPageTextures[1] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_1.png");
        bookPageTextures[2] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_2.png");
        bookPageTextures[3] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_3.png");
        bookPageTextures[4] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_4.png");
        bookPageTextures[5] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_5.png");
        bookPageTextures[6] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_6.png");
        bookPageTextures[7] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_7.png");
        bookPageTextures[8] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_8.png");
        bookPageTextures[9] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_9.png");
        bookPageTextures[10] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_10.png");
        bookPageTextures[11] = new ResourceLocation(Reference.MOD_ID + ":textures/gui/guides/controls/page_11.png");
        
        //Title
        stringPageText[0] = "\n\n\n\n\n\n\n"
        		+ "    " + "\u00A7l\u00A7nTaking Control\u00A7r"
        		+ "\n\n" 
        		+ "         " + "\u00A7oby Viesis\u00A7r"
        		+ "\n\n\n\n" 
        		+ "           " + Reference.MOD_VERSION;
        
        stringPageText[1] = "\n\n\n\n\n\n\n"
        		+ "   Before you decide "
        		+ "to set sail into that "
        		+ "square sunset, let's "
        		+ "take a few moments to "
        		+ "go over some of the "
        		+ "airship basics.";
        
        stringPageText[2] = "\n"
        		+ "   With an airship in "
        		+ "hand, hold \u00A75[Shift] \u00A70+ "
        		+ "\u00A75[Right Click] \u00A70to throw it. "
        		+ "Upon impact, it will "
        		+ "explode and spawn "
        		+ "your airship."
        		+ "\n\n\n\n\n"
        		+ "*Don't worry, these explosions are safe.";
        
        stringPageText[3] = "   To turn an airship "
        		+ "back into an item, just "
        		+ "hit it a few times. No "
        		+ "need for any tools."
        		+ "\n\n\n\n\n\n\n\n"
        		+ "*One good shot with an "
        		+ "arrow works well.";
        
        stringPageText[4] = "\n"
        		+ "   Once your airship is "
        		+ "out, \u00A75[Right Click] \u00A70on it "
        		+ "to begin riding. While in "
        		+ "the airship, press the "
        		+ "\u00A75["
        		+ Keybinds.vcInventory.getDisplayName()
        		+ " Key] \u00A70to open the "
        		+ "airship's GUI."
        		+ "\n\n\n\n\n"
        		+ "*Only the driver can use the GUI.";
        
        stringPageText[5] = "   While in the GUI, you "
        		+ "can add modules and "
        		+ "fuel. For more info on the module system, please refer to the Module Guidebook.";
        
        stringPageText[6] = "\n\n\n\n\n\n\n\n"
        		+ "   All airships need "
        		+ "fuel to fly. Once fuel is placed "
        		+ "in the fuel "
        		+ "slot, it will start using "
        		+ "it right away.";
        
        stringPageText[7] = "Here is a list of fuel items: "
        		+ "\n\n"
        		+ "Viesoline Pellets"
        		+ "\nSticks / Saplings"
        		+ "\nCoal / Charcoal"
        		+ "\nCoal Blocks"
        		+ "\nBlaze Rods"
        		+ "\nWood material blocks"
        		+ "\n\n\n"
        		+ "*Items burn for their vanilla times."
        		;
        
        stringPageText[8] = "\n\n\n\n\n"
        		+ "   With the right module "
        		+ "installed, airships "
        		+ "can have a \u00A769 \u00A70or \u00A7618 "
        		+ "slot inventory\u00A70."
        		+ "\n\n"
        		+ ""
        		+ "   Stored items will fall out if broken or the module is removed."
        		;
    	
        stringPageText[9] = "\n"
        		+ "Use the following keys "
        		+ "to pilot airships: "
        		+ "\n\n"
        		+ "\u00A75[" + Keybinds.vcForward.getDisplayName() + "] \u00A70= Forward \n"
        		+ "\u00A75[" + Keybinds.vcBack.getDisplayName() + "] \u00A70= Back \n"
        		+ "\u00A75[" + Keybinds.vcLeft.getDisplayName() + "] \u00A70= Left \n"
        		+ "\u00A75[" + Keybinds.vcRight.getDisplayName() + "] \u00A70= Right \n"
        		+ "\u00A75[" + Keybinds.vcUp.getDisplayName() + "] \u00A70= Ascend \n"
        		+ "\u00A75[" + Keybinds.vcDown.getDisplayName() + "] \u00A70= Descend "
        				+ "\n\n"
        				+ "*Based on current key bindings."
        		
        		;
        
        stringPageText[10] = "\n"
        		+ "   Airships hate water! "
        		+ "Once in water, you will "
        		+ "begin to move very "
        		+ "slowly. If you go "
        		+ "deeper, your airship "
        		+ "will begin to smoke. If "
        		+ "you do not get out of "
        		+ "the water in time, it will "
        		+ "explode. "
        		+ "\n\n\n"
        		+ "*Warning! It will hurt..."
        		;
    		
        stringPageText[11] = "   If an airship is destroyed by water, you may be able to recover parts, if you are lucky. "
        		+ "\n\n\n"
        		+ "Airships can hold 2 players, or 1 player and 1 animal. Monsters can also hop in your airship so don\'t leave them lying around! "
        		;
        
        
        
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
        
        //Page number at the top
        fontRendererObj.drawString(
        		stringPageIndicator, 
              offsetFromScreenLeft - widthOfString + bookImageWidth - 44, 
              18, 1);
        
        
        //The actual text on the pages
        fontRendererObj.drawSplitString(stringPageText[currPage], 
            //offsetFromScreenLeft + 98, 34, 124, 0);
        	offsetFromScreenLeft + 36, 34, 116, 0);
        //GL11.glScalef(1.25F, 1.25F, 1.25F);
        
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
                
                //Draws the arrows for the next/prev pages
                drawTexturedModalRect(xPosition, yPosition, 
                      textureX, textureY, 
                      23, 13);
            }
        }
    }
}
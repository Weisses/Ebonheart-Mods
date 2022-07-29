package com.viesis.viescraft.client.gui.guidebooks;

import org.apache.commons.lang3.StringUtils;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.ItemsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGuideBookVC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuidebookMainStrings extends GuiScreen {
	
    protected static final int bookTotalPages = 77;
    protected static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    protected static String[] stringPageText = new String[bookTotalPages];
    
    protected static String[] stringPageTextLeftTitle = new String[bookTotalPages];
    protected static String[] stringPageTextLeft = new String[bookTotalPages];
    protected static String[] stringPageTextLeftButtons = new String[bookTotalPages];
    protected static String[] stringPageTextRight = new String[bookTotalPages];
    protected static String[] stringPageTextRightTooltip = new String[bookTotalPages];
    protected static String[] stringPageTextRightTooltipIngredient = new String[bookTotalPages];
    
    public GuiGuidebookMainStrings()
    {
    	bookPageTextures[0] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_0.png");
        bookPageTextures[1] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_1.png");
        bookPageTextures[2] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_2.png");
        bookPageTextures[3] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_3.png");
        bookPageTextures[4] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_4.png");
        bookPageTextures[5] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_5.png");
        bookPageTextures[6] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_6.png");
        bookPageTextures[7] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_7.png");
        bookPageTextures[8] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_8.png");
        bookPageTextures[9] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_9.png");
        bookPageTextures[10] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_10.png");
        bookPageTextures[11] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_11.png");
        bookPageTextures[12] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_12.png");
        bookPageTextures[13] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_13.png");
        bookPageTextures[14] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_14.png");
        bookPageTextures[15] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_15.png");
        bookPageTextures[16] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_16.png");
        bookPageTextures[17] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_17.png");
        bookPageTextures[18] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_18.png");
        bookPageTextures[19] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_19.png");
        bookPageTextures[20] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_20.png");
        bookPageTextures[21] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_21.png");
        bookPageTextures[22] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_22.png");
        bookPageTextures[23] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_23.png");
        bookPageTextures[24] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_24.png");
        bookPageTextures[25] = new ResourceLocation(References.MOD_ID + ":textures/gui/guides/main/page_25.png");
        
		//+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
        
        //Title
        stringPageTextLeftTitle[0] = 
    		  "\u00A7l\u00A7nThe \'Vies\' Craft\u00A7r"
    		+ "\n\n" 
    		+ "       " + "\u00A7oby Viesis\u00A7r"
    		+ "\n\n\n\n";
        
        stringPageTextLeft[0] = " ";
        stringPageTextLeftButtons[0] = " ";
        
        stringPageTextRight[0] = 
    		  "\n\n\n" 
    		+ "    " + References.localNameVC("vc.guidebook.pg2.1")
    		+ References.localNameVC("vc.guidebook.pg2.2")
    		+ References.localNameVC("vc.guidebook.pg2.3")
    		+ References.localNameVC("vc.guidebook.pg2.4")
    		+ References.localNameVC("vc.guidebook.pg2.5")
    		+ "\n\n"
    		+ "    " + References.localNameVC("vc.guidebook.pg2.6")
    		+ References.localNameVC("vc.guidebook.pg2.7")
    		+ "\n\n"
    		+ "    " + References.localNameVC("vc.guidebook.pg2.8")
    		+ References.localNameVC("vc.guidebook.pg2.9");
        
        //TODO Main Info
        stringPageTextLeft[1] = 
    		  "\n\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg3.1")
    		;
        stringPageTextLeftButtons[1] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
        
        stringPageTextRight[1] = " ";
        
        //------------------------------------
        
        stringPageTextRightTooltip[1] = 
        		References.localNameVC("vc.guidebook.generic.2") + " : "
    		+ "\n\n"
    		+ "                 \u00A7l\u00A7n" + "Logic Chip" + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg4.1a");
        stringPageTextRightTooltipIngredient[1] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    	    + Blocks.COBBLESTONE.getLocalizedName() + ", " 
    		+ References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + ", " 
    		+ References.localNameVC(Items.GOLD_NUGGET.getUnlocalizedName() + ".name") + "\u00A7r";
        	
        stringPageTextRightTooltip[2] = 
        		References.localNameVC("vc.guidebook.generic.3") + " : "
      		+ "\n\n"
      		+ "           \u00A7l\u00A7nAirship Workbench\u00A7r"
      		+ "\n\n"
      		+ "   " + References.localNameVC("vc.guidebook.pg4.1b");
        stringPageTextRightTooltipIngredient[2] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    	    + Blocks.CRAFTING_TABLE.getLocalizedName() + ", " 
    		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name")+ "\u00A7r";
        
        stringPageTextRightTooltip[3] = 
        		References.localNameVC("vc.guidebook.generic.2") + " : "
      		+ "\n\n"
      		+ "              \u00A7l\u00A7nAirship Balloon\u00A7r"
      		+ "\n\n"
      		+ "   " + References.localNameVC("vc.guidebook.pg4.1c");
        stringPageTextRightTooltipIngredient[3] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    	    + References.localNameVC(Items.LEATHER.getUnlocalizedName() + ".name") + ", " 
    		+ References.localNameVC(Items.STRING.getUnlocalizedName() + ".name") + "\u00A7r";
        
        stringPageTextRightTooltip[4] = 
        		References.localNameVC("vc.guidebook.generic.2") + " : "
    		+ "\n\n"
    		+ "               \u00A7l\u00A7nAirship Frame\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg4.1d");
        stringPageTextRightTooltipIngredient[4] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC(Items.MINECART.getUnlocalizedName() + ".name") + ", " 
    		+ References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + "\u00A7r";
        
        stringPageTextRightTooltip[5] = 
        		References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "              \u00A7l\u00A7nAirship Engine\u00A7r"
      		+ "\n\n"
      		+ "   " + References.localNameVC("vc.guidebook.pg4.1e");
        stringPageTextRightTooltipIngredient[5] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    	    + Blocks.PISTON.getLocalizedName() + ", " 
    	    + Blocks.IRON_BARS.getLocalizedName() + ", " 
    		+ References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + "\u00A7r";
        
        stringPageTextRightTooltip[6] = 
        		References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
          	+ "             \u00A7l\u00A7nAirship Ignition\u00A7r"
      		+ "\n\n"
      		+ "   " + References.localNameVC("vc.guidebook.pg4.1f");
        stringPageTextRightTooltipIngredient[6] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
    		+ Blocks.IRON_BARS.getLocalizedName() + ", " 
    	    + References.localNameVC(Items.GOLD_INGOT.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
    		+ Blocks.MAGMA.getLocalizedName() + ", " 
    	    + References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + "\u00A7r";
      
      //===========================================================
      
      stringPageTextLeft[2] = 
  	  		"   "
  	  		+ References.localNameVC("vc.guidebook.pg5.1") 
  	  		+ References.localNameVC("vc.guidebook.pg5.2")
  	  		+ References.localNameVC("vc.guidebook.pg5.3");
      stringPageTextLeftButtons[2] = " ";
      
      stringPageTextRight[2] = " ";
      
      stringPageTextRightTooltip[7] = 
    		  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Airship" + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg6.1a");
      stringPageTextRightTooltipIngredient[7] = 
      		References.localNameVC("vc.guidebook.generic.4") + " : "
  	    + "\n" + "\u00A7o\u00A7l"
  		+ References.localNameVC(ItemsVC.AIRSHIP_BALLOON.getUnlocalizedName() + ".name") + ", " 
  		+ References.localNameVC(ItemsVC.AIRSHIP_FRAME.getUnlocalizedName() + ".name") + ", " 
  	    + References.localNameVC(ItemsVC.AIRSHIP_ENGINE.getUnlocalizedName() + ".name") + ", " 
  	    + References.localNameVC(ItemsVC.AIRSHIP_IGNITION.getUnlocalizedName() + ".name") + ", " 
		+ References.localNameVC(Items.LEAD.getUnlocalizedName() + ".name") + "\u00A7r";
    
	  
//===========================================================
      
      stringPageTextLeft[3] = 
  	  		  "   " + References.localNameVC("vc.guidebook.pg7.1");
      stringPageTextLeftButtons[3] = "\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
      
      stringPageTextRight[3] = " ";
        
      stringPageTextRightTooltip[11] = 
    		  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Viesoline Pellets" + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg8.1a");
      stringPageTextRightTooltipIngredient[11] = 
	      		References.localNameVC("vc.guidebook.generic.4") + " : "
	  	    + "\n" 
	  		+ "\u00A7o\u00A7l"
	  		+ References.localNameVC(Items.COAL.getUnlocalizedName() + ".name") + "/Charcoal, " 
	  		+ References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + "\u00A7r";
      
      
	  stringPageTextRightTooltip[12] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + "Dismounter" + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg8.1b");
	  stringPageTextRightTooltipIngredient[12] = 
    		References.localNameVC("vc.guidebook.generic.4") + " : "
	    + "\n" + "\u00A7o\u00A7l"
		+ References.localNameVC(Items.LEATHER.getUnlocalizedName() + ".name") + ", " 
	    + References.localNameVC(Items.STICK.getUnlocalizedName() + ".name") + ", " 
	    + References.localNameVC(Items.FEATHER.getUnlocalizedName() + ".name") + "\u00A7r";
        		
	  stringPageTextRightTooltip[13] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "         \u00A7l\u00A7n" + "Dismounter (Player)" + "\u00A7r"
    		+ "\n\n"
    		+ "    " + References.localNameVC("vc.guidebook.pg8.1c")
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg8.1d");
	  stringPageTextRightTooltipIngredient[13] =  
	    		References.localNameVC("vc.guidebook.generic.4") + " : "
		    + "\n" + "\u00A7o\u00A7l"
			+ References.localNameVC(Items.LEATHER.getUnlocalizedName() + ".name") + ", " 
		    + References.localNameVC(Items.STICK.getUnlocalizedName() + ".name") + ", " 
		    + References.localNameVC(Items.FEATHER.getUnlocalizedName() + ".name") + "\u00A7r";
        	
	  stringPageTextRightTooltip[71] = 
	    		References.localNameVC("vc.guidebook.generic.2") + " : "
	          + "\n\n"
	      	+ "             \u00A7l\u00A7n" + "Bomb Casing" + "\u00A7r"
	  		+ "\n\n"
	  		+ "   " + References.localNameVC("vc.guidebook.pg8.1e");
	    stringPageTextRightTooltipIngredient[71] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
    		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") +  ", "
    	    + Blocks.COBBLESTONE.getLocalizedName() + "\u00A7r";
	    
	    stringPageTextRightTooltip[72] = 
	    		References.localNameVC("vc.guidebook.generic.2") + " : "
	          + "\n\n"
	      	+ "             \u00A7l\u00A7n" + "Small Bomb" + "\u00A7r"
	  		+ "\n\n"
	  		+ "   " + References.localNameVC("vc.guidebook.pg8.1f");
	    stringPageTextRightTooltipIngredient[72] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
    	    + "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC("item.vc:item_bomb_casing.name") + ", " 
    		+ Blocks.TNT.getLocalizedName() + ", " 
    	    + References.localNameVC(Items.STRING.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + "\u00A7r";
	    
	    stringPageTextRightTooltip[73] = 
	    		References.localNameVC("vc.guidebook.generic.2") + " : "
	          + "\n\n"
	      	+ "             \u00A7l\u00A7n" + "Big Bomb" + "\u00A7r"
	  		+ "\n\n"
	  		+ "   " + References.localNameVC("vc.guidebook.pg8.1g");
	    stringPageTextRightTooltipIngredient[73] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC("item.vc:item_bomb_casing.name") + ", " 
    		+ Blocks.TNT.getLocalizedName() + ", " 
    	    + References.localNameVC(Items.STRING.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + "\u00A7r";
        
	    stringPageTextRightTooltip[74] = 
	    		References.localNameVC("vc.guidebook.generic.2") + " : "
	          + "\n\n"
	      	+ "             \u00A7l\u00A7n" + "Scatter Bomb" + "\u00A7r"
	  		+ "\n\n"
	  		+ "   " + References.localNameVC("vc.guidebook.pg8.1h");
	    stringPageTextRightTooltipIngredient[74] = 
        		References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
    		+ References.localNameVC("item.vc:item_bomb_casing.name") + ", " 
    		+ Blocks.TNT.getLocalizedName() + ", " 
    	    + References.localNameVC(Items.STRING.getUnlocalizedName() + ".name") + ", " 
    	    + References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + "\u00A7r";
        
	  //===================================
	  
	  //TODO Airship Interactions Strings
	  stringPageTextLeft[4] = 
			  "\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg9.1")
			+ "\u00A75" + References.localNameVC("vc.guidebook.pg9.2") + "\u00A70"
			+ References.localNameVC("vc.guidebook.pg9.3")
    		+ "\n\n"
    		+ "   \u00A7o\u00A7l " + References.localNameVC("vc.guidebook.pg9.4") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg9.5")
    		+ "\n\n\n\n\n\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg9.6")
    		+ "\u00A75" + References.localNameVC("vc.guidebook.pg9.7") + "\u00A70"
    		+ References.localNameVC("vc.guidebook.pg9.8")
    		;
	  stringPageTextLeftButtons[4] = " ";
	  
	  stringPageTextRight[4] = 
		    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) " + References.localNameVC("vc.guidebook.pg10.1")
		    + "\n\n"
		    + "      2.) " + References.localNameVC("vc.guidebook.pg10.2")
		    + "\n\n"
		    + "      3.) " + References.localNameVC("vc.guidebook.pg10.3")
		    + "\n\n"
		    + "      4.) " + References.localNameVC("vc.guidebook.pg10.4")
		    + "\n\n"
		    + "      5.) " + References.localNameVC("vc.guidebook.pg10.5")
		    + "\n\n"
		    + "      6.) " + References.localNameVC("vc.guidebook.pg10.6")
		    + "\n\n"
		    + "      7.) " + References.localNameVC("vc.guidebook.pg10.7")
		    + "\u00A7r"
		    ;
	  
	  stringPageTextLeft[5] = 
		      "   " + References.localNameVC("vc.guidebook.pg11.1")
		    + "\n\n"
		    + "   " + References.localNameVC("vc.guidebook.pg11.2") + "\u00A75["
    		+ Keybinds.vcInventory.getDisplayName()
    		+ " Key]\u00A70 " + References.localNameVC("vc.guidebook.pg11.3")
    		+ "\n\n"
    		+ " \u00A7l\u00A7o" + References.localNameVC("vc.guidebook.pg11.4") + "\u00A7r"
    		+ "\n\n\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg11.5")
    		+ "\n\n"
    		+ "   \u00A7l1). \u00A7n" + References.localNameVC("vc.guidebook.pg11.6") + "\u00A7r is how you "
    		+  References.localNameVC("vc.guidebook.pg11.7")
    		+ "\n\n"
    		+ "   \u00A7l2). \u00A7n" +  References.localNameVC("vc.guidebook.pg11.8") + "\u00A7r "
    		+  References.localNameVC("vc.guidebook.pg11.9")
    		;
	  stringPageTextLeftButtons[5] = " ";
	  
	  stringPageTextRight[5] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) " + References.localNameVC("vc.guidebook.pg11.6")
		    + "\n\n"
		    + "      2.) " + References.localNameVC("vc.guidebook.pg11.8")
		    + "\n\n"
		    + "      3.) " + References.localNameVC("vc.guidebook.pg11.10")
		    + "\n\n"
		    + "      4.) " + References.localNameVC("vc.guidebook.pg11.15")
		    + "\u00A7r";
	  
	  stringPageTextLeft[6] = 
			  "   \u00A7l3). \u00A7n" + References.localNameVC("vc.guidebook.pg11.10") + "\u00A7r "
			+ References.localNameVC("vc.guidebook.pg11.11")
		    + "\n\n\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg11.12")
			+ "\n\n"
			+ "   "+ References.localNameVC("vc.guidebook.pg11.13")
			+ "\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg11.14")
			;
	  stringPageTextLeftButtons[6] = " ";
	  
	  stringPageTextRight[6] =  
			  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\u00A7l"
			+ "      1.) " + References.localNameVC("vc.guidebook.pg14.1")
			+ "\n\n"
			+ "      2.) " + References.localNameVC("vc.guidebook.pg14.2")
			+ "\n\n"
			+ "      3.) " + References.localNameVC("vc.guidebook.pg14.3")
			+ "\u00A7r"
			;
	  
	  //===================================
	  
	  //TODO Upgrade System Strings
	  
	  stringPageTextLeft[7] = 
			  "\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg15.1")
			+ "\u00A7l 4 \u00A7r"
			+ References.localNameVC("vc.guidebook.pg15.2")
			+ " : "
			+ "\n\n"
			+ "\u00A75\u00A7l\u00A7o"
			+ "- " + References.localNameVC("vc.main.core")
			+ "\n"
			+ "- " + References.localNameVC("vc.main.frame")
			+ "\n"
			+ "- " + References.localNameVC("vc.main.engine")
			+ "\n"
			+ "- " + References.localNameVC("vc.main.balloon")
			+ "\u00A7r\u00A70"
			+ "\n\n"
			+ References.localNameVC("vc.guidebook.pg15.3")
			+ "\n\n\n\n\n\n\n\n\n\n\n"
			+ References.localNameVC("vc.guidebook.pg15.4")
			+ "\n\n\n\n";
	  stringPageTextLeftButtons[7] = " ";
	  
	  stringPageTextRight[7] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) "+ References.localNameVC("vc.guidebook.pg11.6")
		    + "\n\n"
		    + "      2.) "+ References.localNameVC("vc.guidebook.pg16.1")
		    + "\n\n"
		    + "      3.) "+ References.localNameVC("vc.guidebook.pg16.2")
		    + "\n\n"
		    + "      4.) "+ References.localNameVC("vc.guidebook.pg16.3")
		    + "\u00A7r";
	  
	  stringPageTextLeft[8] = 
			  "                    \u00A7l\u00A7n" + References.localNameVC("vc.main.core") + "\u00A7r "
		    + "\n\n"
		    + "   " + References.localNameVC("vc.guidebook.pg17.1");
	  stringPageTextLeftButtons[8] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[8] = " ";
	  
	  stringPageTextLeft[9] = 
			  "                    \u00A7l\u00A7n" + References.localNameVC("vc.main.frame") + "\u00A7r "
		    + "\n\n"
		    + "   " + References.localNameVC("vc.guidebook.pg19.1");
	  stringPageTextLeftButtons[9] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[9] = " ";
	  
	  stringPageTextLeft[10] = 
			  "                    \u00A7l\u00A7n" + References.localNameVC("vc.main.engine") + "\u00A7r "
		    + "\n\n"
		    + "   " + References.localNameVC("vc.guidebook.pg21.1");
	  stringPageTextLeftButtons[10] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[10] = " ";
	  
	  stringPageTextLeft[11] = 
			  "                    \u00A7l\u00A7n" + References.localNameVC("vc.main.balloon") + "\u00A7r "
		    + "\n\n"
		    + "   " + References.localNameVC("vc.guidebook.pg23.1");
	  stringPageTextLeftButtons[11] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[11] = " ";
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[20] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "                \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_shard.name") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg18.1a");
	  stringPageTextRightTooltipIngredient[20] = 
      		  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
	  		+ Blocks.GLASS.getLocalizedName() + ", " 
	  	    + References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
	  	    + References.localNameVC(Items.GOLD_INGOT.getUnlocalizedName() + ".name") + "\u00A7r";
      
	  stringPageTextRightTooltip[21] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_upgrade.name") + " 1" + "\u00A7r"
    		+ "\n\n"
    		+ "            -=" + References.localNameVC("vc.guidebook.pg18.0") + "=-"
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg18.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1b");
	  stringPageTextRightTooltipIngredient[21] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_shard.name") + ", " 
  	  	    + References.localNameVC(ItemsVC.AIRSHIP_IGNITION.getUnlocalizedName() + ".name") + "\u00A7r";
	      	      
	  stringPageTextRightTooltip[22] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
            + "            \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_upgrade.name") + " 2" + "\u00A7r"
            + "\n\n"
    		+ References.localNameVC("vc.guidebook.pg18.1d") + "1 " + References.localNameVC("vc.main.core") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg18.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1b");
	  stringPageTextRightTooltipIngredient[22] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
  			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", "
  	  	  	+ Blocks.GOLD_BLOCK.getLocalizedName() + ", "  
  	  	    + References.localNameVC("item.vc:item_core_shard.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_upgrade.name") + " 1\u00A7r";
	  
	  stringPageTextRightTooltip[23] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
            + "            \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_upgrade.name") + " 3" + "\u00A7r"
            + "\n\n"
    		+ References.localNameVC("vc.guidebook.pg18.1d") + "2 " + References.localNameVC("vc.main.core") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg18.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1b");
	  stringPageTextRightTooltipIngredient[23] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
  			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.DIAMOND_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_core_shard.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_upgrade.name") + " 2\u00A7r";
	  
	  stringPageTextRightTooltip[24] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
            + "            \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_upgrade.name") + " 4" + "\u00A7r"
            + "\n\n"
    		+ References.localNameVC("vc.guidebook.pg18.1d") + "3 " + References.localNameVC("vc.main.core") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg18.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1b");
	  stringPageTextRightTooltipIngredient[24] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
  			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.EMERALD_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_core_shard.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_upgrade.name") + " 3\u00A7r";
	  
	  stringPageTextRightTooltip[25] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
            + "            \u00A7l\u00A7n" + References.localNameVC("item.vc:item_core_upgrade.name") + " 5" + "\u00A7r"
            + "\n\n"
    		+ References.localNameVC("vc.guidebook.pg18.1d") + "4 " + References.localNameVC("vc.main.core") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg18.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg18.1f");
	  stringPageTextRightTooltipIngredient[25] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC(Items.NETHER_STAR.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_shard.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_core_upgrade.name") + " 4\u00A7r";
	  
	  //--------------------------------------------------
	  
	  stringPageTextRightTooltip[14] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_casing.name") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg20.1a");
	  stringPageTextRightTooltipIngredient[14] = 
      		  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
	  		+ Blocks.IRON_BARS.getLocalizedName() + ", " 
	  	    + References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
	  	    + References.localNameVC(Items.GOLD_INGOT.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[15] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_upgrade.name") + " 1" + "\u00A7r"
        	+ "\n\n"
    		+ "            -=" + References.localNameVC("vc.guidebook.pg18.0") + "=-"
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg20.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1e");
	  stringPageTextRightTooltipIngredient[15] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_casing.name") + ", " 
  	  	    + References.localNameVC(ItemsVC.AIRSHIP_FRAME.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[16] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_upgrade.name") + " 2" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg20.1d") + "1 " + References.localNameVC("vc.main.frame") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg20.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1e");
	  stringPageTextRightTooltipIngredient[16] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.GOLD_BLOCK.getLocalizedName() + ", "  
  	  	    + References.localNameVC("item.vc:item_frame_casing.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_upgrade.name") + " 1\u00A7r";
	  
	  stringPageTextRightTooltip[17] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_upgrade.name") + " 3" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg20.1d") + "2 " + References.localNameVC("vc.main.frame") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg20.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1e");
	  stringPageTextRightTooltipIngredient[17] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.DIAMOND_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_casing.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_upgrade.name") + " 2\u00A7r";
	  
	  stringPageTextRightTooltip[18] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_upgrade.name") + " 4" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg20.1d") + "3 " + References.localNameVC("vc.main.frame") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg20.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1e");
	  stringPageTextRightTooltipIngredient[18] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.EMERALD_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_casing.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_upgrade.name") + " 3\u00A7r";
	  
	  stringPageTextRightTooltip[19] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_frame_upgrade.name") + " 5" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg20.1d") + "4 " + References.localNameVC("vc.main.frame") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg20.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1e")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg20.1f");
	  stringPageTextRightTooltipIngredient[19] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.NETHER_STAR.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_casing.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_frame_upgrade.name") + " 4\u00A7r";
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[26] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Engine Fragment" + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg22.1a");
	  stringPageTextRightTooltipIngredient[26] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.GOLD_INGOT.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.BLAZE_ROD.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[27] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_engine_upgrade.name") + " 1" + "\u00A7r"
    		+ "\n\n"
    		+ "            -=" + References.localNameVC("vc.guidebook.pg18.0") + "=-"
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg22.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1e");
	  stringPageTextRightTooltipIngredient[27] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_fragment.name") + ", " 
  	  	    + References.localNameVC(ItemsVC.AIRSHIP_ENGINE.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[28] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_engine_upgrade.name") + " 2" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg22.1d") + "1 " + References.localNameVC("vc.main.engine") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg22.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1e");
	  stringPageTextRightTooltipIngredient[28] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.GOLD_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_fragment.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_upgrade.name") + " 1\u00A7r";
	  
	  stringPageTextRightTooltip[29] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_engine_upgrade.name") + " 3" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg22.1d") + "2 " + References.localNameVC("vc.main.engine") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg22.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1e");
	  stringPageTextRightTooltipIngredient[29] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.DIAMOND_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_fragment.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_upgrade.name") + " 2\u00A7r";
	  
	  stringPageTextRightTooltip[30] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_engine_upgrade.name") + " 4" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg22.1d") + "3 " + References.localNameVC("vc.main.engine") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg22.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1e");
	  stringPageTextRightTooltipIngredient[30] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.EMERALD_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_fragment.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_upgrade.name") + " 3\u00A7r";
	  
	  stringPageTextRightTooltip[31] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + References.localNameVC("item.vc:item_engine_upgrade.name") + " 5" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg22.1d") + "4 " + References.localNameVC("vc.main.engine") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg22.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1e")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg22.1f");
	  stringPageTextRightTooltipIngredient[31] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.NETHER_STAR.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_fragment.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_engine_upgrade.name") + " 4\u00A7r";
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[32] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_remnant.name") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg24.1a");
	  stringPageTextRightTooltipIngredient[32] = 
      		  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
	  		+ References.localNameVC(Items.LEATHER.getUnlocalizedName() + ".name") + ", " 
	  	    + References.localNameVC(Items.IRON_INGOT.getUnlocalizedName() + ".name") + ", " 
	  	    + References.localNameVC(Items.GOLD_INGOT.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[33] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 1" + "\u00A7r"
    		+ "\n\n"
    		+ "            -=" + References.localNameVC("vc.guidebook.pg18.0") + "=-"
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg24.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1e");
	  stringPageTextRightTooltipIngredient[33] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_remnant.name") + ", " 
  	  	    + References.localNameVC(ItemsVC.AIRSHIP_BALLOON.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[34] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 2" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg24.1d") + "1 " + References.localNameVC("vc.main.balloon") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg24.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1e");
	  stringPageTextRightTooltipIngredient[34] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.GOLD_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_remnant.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 1\u00A7r";
	  
	  stringPageTextRightTooltip[35] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 3" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg24.1d") + "2 " + References.localNameVC("vc.main.balloon") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg24.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1e");
	  
	  stringPageTextRightTooltipIngredient[35] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.DIAMOND_BLOCK.getLocalizedName() + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_remnant.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 2\u00A7r";
	  
	  stringPageTextRightTooltip[36] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 4" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg24.1d") + "3 " + References.localNameVC("vc.main.balloon") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg24.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1e");
	  
	  stringPageTextRightTooltipIngredient[36] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.EMERALD_BLOCK.getLocalizedName() + ", "  
  	  	    + References.localNameVC("item.vc:item_balloon_remnant.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 3\u00A7r";
	  
	  stringPageTextRightTooltip[37] = 
			  References.localNameVC("vc.guidebook.generic.2") + " : "
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 5" + "\u00A7r"
    		+ "\n\n"
    		+ References.localNameVC("vc.guidebook.pg24.1d") + "4 " + References.localNameVC("vc.main.balloon") + "."
    		+ "\n"
    		+ References.localNameVC("vc.guidebook.pg24.1c")
		    + "\n\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1b")
		    + "\n"
			+ "-" + References.localNameVC("vc.guidebook.pg24.1e");
	  stringPageTextRightTooltipIngredient[37] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.NETHER_STAR.getUnlocalizedName() + ".name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_remnant.name") + ", " 
  	  	    + References.localNameVC("item.vc:item_balloon_upgrade.name") + " 4\u00A7r";
	  
	  
	  //===================================
	  
	  //TODO Module System Strings
	  
	  stringPageTextLeft[12] = 
			  "\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg25.1") + References.localNameVC("vc.guidebook.pg25.2") + References.localNameVC("vc.guidebook.pg25.3")
			+ "\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg25.4")
			+ "\u00A7l"
			+ "9 \u00A7r"
			+ References.localNameVC("vc.guidebook.pg25.5") + References.localNameVC("vc.guidebook.pg25.6") + References.localNameVC("vc.guidebook.pg25.7")
			+ "\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg25.8") + References.localNameVC("vc.guidebook.pg25.9");
	  stringPageTextLeftButtons[12] = "";
	  
	  stringPageTextRight[12] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) " + References.localNameVC("vc.guidebook.pg26.1")
		    + "\n\n"
		    + "      2.) " + References.localNameVC("vc.guidebook.pg26.2")
		    + "\n\n"
		    + "      3.) " + References.localNameVC("vc.guidebook.pg26.3")
		    + "\n\n"
		    + "      4.) " + References.localNameVC("vc.guidebook.pg26.4")
		    + "\n\n"
		    + "      5.) " + References.localNameVC("vc.guidebook.pg26.5")
		    + "\u00A7r";
	  
	  stringPageTextLeft[13] = "";
	  stringPageTextLeftButtons[13] = "\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[13] = "";
	  
	  stringPageTextLeft[14] = "";
	  stringPageTextLeftButtons[14] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[14] = "";
	  
	  stringPageTextLeft[15] = "";
	  stringPageTextLeftButtons[15] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[15] = "";
	  
	  stringPageTextLeft[16] = "";
	  stringPageTextLeftButtons[16] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[16] = "";
	  
	  stringPageTextLeft[17] = "";
	  stringPageTextLeftButtons[17] = "\n\n\n\n\n\n\n" + References.localNameVC("vc.guidebook.generic.1");
	  stringPageTextRight[17] = "";
	  
	  //--------------------------------------
	  
	  stringPageTextRightTooltip[38] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                \u00A7l\u00A7n" + References.localNameVC("item.vc:item_module_chip.name") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.1");
	  stringPageTextRightTooltipIngredient[38] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + " \u00A7r";
	  
	  //========================================
	  //Altitude
	  stringPageTextRightTooltip[39] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.1") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.2");
	  stringPageTextRightTooltipIngredient[39] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.GLOWSTONE_DUST.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.FEATHER.getUnlocalizedName() + ".name") + ", " 
	    	+ Blocks.REDSTONE_TORCH.getLocalizedName() + "\u00A7r";
	  
	  stringPageTextRightTooltip[40] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                  \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.2") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.3");
	  stringPageTextRightTooltipIngredient[40] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.1") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[41] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.3") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.4");
	  stringPageTextRightTooltipIngredient[41] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.2") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Speed
	  stringPageTextRightTooltip[42] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.4") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.5");
	  stringPageTextRightTooltipIngredient[42] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.GUNPOWDER.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.FLINT.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.FIRE_CHARGE.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[43] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                     \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.5") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.6");
	  stringPageTextRightTooltipIngredient[43] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.4") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[44] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.6") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg28.7");
	  stringPageTextRightTooltipIngredient[44] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.5") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Storage
	  stringPageTextRightTooltip[45] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.7") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.1");
	  stringPageTextRightTooltipIngredient[45] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.TRIPWIRE_HOOK.getLocalizedName() + ", " 
	    	+ References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + ", " 
	    	+ Blocks.CHEST.getLocalizedName() + "\u00A7r";
	  
	  stringPageTextRightTooltip[46] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                 \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.8") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.2");
	  stringPageTextRightTooltipIngredient[46] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.7") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[47] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.9") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.3");
	  stringPageTextRightTooltipIngredient[47] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.8") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Fuel Eff.
	  stringPageTextRightTooltip[48] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "         \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.10") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.4");
	  stringPageTextRightTooltipIngredient[48] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.STONE_PRESSURE_PLATE.getLocalizedName() + ", " 
	    	+ References.localNameVC(Items.BLAZE_POWDER.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[49] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.11") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.5");
	  stringPageTextRightTooltipIngredient[49] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.10") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[50] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "        \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.12") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg30.6");
	  stringPageTextRightTooltipIngredient[50] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.11") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Music
	  stringPageTextRightTooltip[51] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.13") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.1");
	  stringPageTextRightTooltipIngredient[51] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.REDSTONE.getUnlocalizedName() + ".name") + ", " 
	    	+ Blocks.NOTEBLOCK.getLocalizedName() + ", " 
	    	+ Blocks.JUKEBOX.getLocalizedName() + "\u00A7r";
	  
	  stringPageTextRightTooltip[52] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "                   \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.14") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.2");
	  stringPageTextRightTooltipIngredient[52] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.13") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[53] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.15") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.3");
	  stringPageTextRightTooltipIngredient[53] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.14") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Cruise
	  stringPageTextRightTooltip[54] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "        \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.16") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.4");
	  stringPageTextRightTooltipIngredient[54] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ Blocks.LEVER.getLocalizedName() + ", " 
	    	+ References.localNameVC(Items.CLOCK.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.GLOWSTONE_DUST.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[55] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.17") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.5");
	  stringPageTextRightTooltipIngredient[55] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.16") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[56] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "      \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.18") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg32.6");
	  stringPageTextRightTooltipIngredient[56] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.17") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Water
	  stringPageTextRightTooltip[57] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.19") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.1");
	  stringPageTextRightTooltipIngredient[57] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.SLIME_BALL.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.COMPASS.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.BOAT.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[58] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.20") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.2");
	  stringPageTextRightTooltipIngredient[58] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.19") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[59] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.21") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.3");
	  stringPageTextRightTooltipIngredient[59] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.20") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Infinite Fuel
	  stringPageTextRightTooltip[60] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.22") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.4");
	  stringPageTextRightTooltipIngredient[60] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.ENDER_PEARL.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.BLAZE_ROD.getUnlocalizedName() + ".name") + ", " 
	    	+ References.localNameVC(Items.GHAST_TEAR.getUnlocalizedName() + ".name") + "\u00A7r";
	  
	  stringPageTextRightTooltip[61] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.23") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.5");
	  stringPageTextRightTooltipIngredient[61] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.22") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[62] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.24") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg34.6");
	  stringPageTextRightTooltipIngredient[62] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.23") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //========================================
	  //Bomb
	  stringPageTextRightTooltip[63] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.25") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg36.1");
	  stringPageTextRightTooltipIngredient[63] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.COMPASS.getUnlocalizedName() + ".name") + ", " 
	    	+ Blocks.PISTON.getLocalizedName() + ", " 
	    	+ Blocks.REDSTONE_TORCH.getLocalizedName() + "\u00A7r";
	  
	  stringPageTextRightTooltip[64] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.26") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg36.2");
	  stringPageTextRightTooltipIngredient[64] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.DIAMOND.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.25") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  stringPageTextRightTooltip[65] = 
			  References.localNameVC("vc.guidebook.generic.5") + " : "
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + References.localNameVC("vc.item.enum.module.27") + "\u00A7r"
    		+ "\n\n"
    		+ "   " + References.localNameVC("vc.guidebook.pg36.3");
	  stringPageTextRightTooltipIngredient[65] = 
	      	  References.localNameVC("vc.guidebook.generic.4") + " : "
			+ "\n" + "\u00A7o\u00A7l"
  	  		+ References.localNameVC(ItemsVC.LOGIC_CHIP.getUnlocalizedName() + ".name") + ", " 
  	  		+ References.localNameVC("vc.guidebook.generic.6") + ", " 
  	    	+ References.localNameVC(Items.QUARTZ.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC(Items.EMERALD.getUnlocalizedName() + ".name") + ", " 
  	    	+ References.localNameVC("vc.item.enum.module.26") + " " + References.localNameVC("vc.item.module.#") + "\u00A7r";
	  
	  //===================================
	  
	  //TODO Stored Redstone Strings
	  
	  stringPageTextLeft[18] = 
			  "\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg37.1")
			+ "\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg37.2")
			+ "\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg37.3")
			+ "\n\n";
	  stringPageTextLeftButtons[18] = "";
	  
	  stringPageTextRight[18] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) " + References.localNameVC("vc.guidebook.pg38.1")
		    + "\n\n"
		    + "      2.) " + References.localNameVC("vc.guidebook.pg38.2")
		    + "\n\n"
		    + "      3.) " + References.localNameVC("vc.guidebook.pg38.3")
		    + "\n\n"
		    + "      4.) " + References.localNameVC("vc.guidebook.pg38.4")
		    + "\n\n"
		    + "      5.) " + References.localNameVC("vc.guidebook.pg38.5")
		    + "\u00A7r";
      
	  //===================================
	  
	  //TODO Airship Behavior Strings
	  
	  stringPageTextLeft[19] = 
			  "\n\n\n"
			+ "   " + References.localNameVC("vc.guidebook.pg39.1")
			+ "\n\n"
    		+ "- " + References.localNameVC("vc.guidebook.pg39.2")
    		+ "\n\n"
			+ "- " +References.localNameVC("vc.guidebook.pg39.3")
    		+ "\n\n";
	  stringPageTextLeftButtons[19] = "";
	  
	  stringPageTextRight[19] = 
			  References.localNameVC("vc.guidebook.pg40.1")
    		+ "\n\n"
    		+ "\u00A75[" + Keybinds.vcForward.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveForward") + " \n"
    		+ "\u00A75[" + Keybinds.vcBack.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveBack") + " \n"
    		+ "\u00A75[" + Keybinds.vcLeft.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveLeft") + " \n"
    		+ "\u00A75[" + Keybinds.vcRight.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveRight") + " \n"
    		+ "\u00A75[" + Keybinds.vcUp.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveUp") + " \n"
    		+ "\u00A75[" + Keybinds.vcDown.getDisplayName() + "] \u00A70= " + References.localNameVC("vc.key.moveDown") + " "
			+ "\n\n"
			+ References.localNameVC("vc.guidebook.pg40.2");
    
    }
}



/**
 * 
 * 
    

        stringPageText[9] = "\n"
        		+ 
        		
        		;
        
 */








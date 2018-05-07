package com.viesis.viescraft.client.gui.guidebooks;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.viesis.viescraft.api.References;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.gui.GuiButtonGuideBookVC;
import com.viesis.viescraft.client.gui.buttons.GuiButtonGeneral1VC;
import com.viesis.viescraft.configs.ViesCraftConfig;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GuiGuidebookMainStrings extends GuiScreen {
	
    protected static final int bookTotalPages = 75;
    protected static ResourceLocation[] bookPageTextures = new ResourceLocation[bookTotalPages];
    protected static String[] stringPageText = new String[bookTotalPages];
    
    protected static String[] stringPageTextLeftTitle = new String[bookTotalPages];
    protected static String[] stringPageTextLeft = new String[bookTotalPages];
    protected static String[] stringPageTextRight = new String[bookTotalPages];
    protected static String[] stringPageTextRightTooltip = new String[bookTotalPages];
    
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
        
        
        
		//+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
        
        
        
        //Title
        stringPageTextLeftTitle[0] = 
    		  "\n\n\n\n\n\n\n\n\n\n"
    		+ "    " + "\u00A7l\u00A7nThe \'Vies\' Craft\u00A7r"
    		+ "\n\n" 
    		+ "          " + "\u00A7oby Viesis\u00A7r"
    		+ "\n\n\n\n" 
    		;
        
        stringPageTextLeft[0] = 
  		  	  " "
    		;
        
        stringPageTextRight[0] = 
    		  "\n\n\n"
    		+ "    Nemanor said it wasn't possible! He "
    		+ "always said players can only fly via "
    		+ "the powers of the \"\u00A7ocreative\u00A7r\". Well "
    		+ "today I prove him wrong. My airships "
    		+ "will forever change how we explore "
    		+ "our world. I now share my wisdom with "
    		+ "you... "
    		+ "\n\n"
    		+ "    In this guide, you will learn what "
    		+ "you need to know to get the most out "
    		+ "of your airships. This includes basic "
    		+ "info on airship use, behavior, and "
    		+ "various items/recipes, among other "
    		+ "things.";
        
        //TODO Main Info
        stringPageTextLeft[1] = 
    		  "\n\n\n"
    		+ "   Let's get into a few recipes to get "
    		+ "you started. "
    		+ "\n\n\n"
    		+ "Select an item below to display basic "
    		+ "information and crafting recipes."
    		+ "\n\n"
    		//+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
    		;
        
        stringPageTextRight[1] = " ";
        
        //------------------------------------
        
        stringPageTextRightTooltip[1] = 
    		  "Item Recipe:"
    		+ "\n\n"
    		+ "                 \u00A7l\u00A7nLogic Chip\u00A7r"
    		+ "\n\n"
    		+ "   This sleek and compact chip is an "
    		+ "item that will be used a lot when making "
    		+ "airship parts, modules, upgrades... "
    		+ "\n"
    		+ "You name it! "
    		+ "\n\n\n\n\n"
    		+ "\u00A7o"
    		+ "Ingredient list:"
    		+ "\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Cobblestone, Redstone, Gold Nugget"
    		+ "\u00A7r"
    		;
        
        stringPageTextRightTooltip[2] = 
      		  "Block Recipe:"
      		+ "\n\n"
      		+ "           \u00A7l\u00A7nAirship Workbench\u00A7r"
      		+ "\n\n"
      		+ "   Items placed inside will stay upon "
      		+ "leaving the workbench! As an added "
      		+ "bonus, the items stored can be seen "
      		+ "by anyone looking at the workbench "
      		+ "itself."
      		+ "\n\n\n\n"
      		+ "\u00A7o"
      		+ "Ingredient list:"
      		+ "\u00A7r"
      		+ "\n"
      		+ "\u00A7o\u00A7l"
      		+ "Crafting Table, Logic Chip"
      		+ "\u00A7r"
      		;
        
        stringPageTextRightTooltip[3] = 
      		  "Item Recipe:"
      		+ "\n\n"
      		+ "              \u00A7l\u00A7nAirship Balloon\u00A7r"
      		+ "\n\n"
      		+ "   Leather that has been processed "
      		+ "to create a durable balloon. Note that "
      		+ "some airship types may require more "
      		+ "than 1 balloon."
      		+ "\n\n\n\n\n"
      		+ "\u00A7o"
      		+ "Ingredient list:"
      		+ "\u00A7r"
      		+ "\n"
      		+ "\u00A7o\u00A7l"
      		+ "Leather, String"
      		+ "\u00A7r"
      		;
        
        stringPageTextRightTooltip[4] = 
    		  "Item Recipe:"
    		+ "\n\n"
    		+ "               \u00A7l\u00A7nAirship Frame\u00A7r"
    		+ "\n\n"
    		+ "   A reinforced frame that all airship "
    		+ "parts can connect to. This is a core "
      		+ "component in all airships."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7o"
    		+ "Ingredient list:"
    		+ "\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Minecart, Iron Ingot, Logic Chip"
    		+ "\u00A7r"
    		;
        
        stringPageTextRightTooltip[5] = 
        	  "Item Recipe:"
            + "\n\n"
        	+ "              \u00A7l\u00A7nAirship Engine\u00A7r"
      		+ "\n\n"
      		+ "   A special, light-weight engine "
      		+ "designed for all airships. This is a "
      		+ "core component in all airships."
      		+ "\n\n\n\n\n\n"
      		+ "\u00A7oIngredient list:\u00A7r"
      		+ "\n"
      		+ "\u00A7o\u00A7lIron Ingot, Iron Bars, Piston, "
      		+ "Logic Chip"
      		+ "\u00A7r"
      		;
        stringPageTextRightTooltip[6] = 
          	  "Item Recipe:"
            + "\n\n"
          	+ "             \u00A7l\u00A7nAirship Ignition\u00A7r"
      		+ "\n\n"
      		+ "   Converts fuel into energy that all "
      		+ "airships can safely use. This is a core "
      		+ "component in all airships."
      		+ "\n\n\n\n\n\n"
      		+ "\u00A7oIngredient list:\u00A7r"
      		+ "\n"
      		+ "\u00A7o\u00A7lIron Ingot, Iron Bars, Gold "
      		+ "Ingot, Diamond, Magma Block, "
      		+ "Logic Chip"
      		+ "\u00A7r"
      		;
      
      //===========================================================
      
      stringPageTextLeft[2] = 
  	  		"   It is now time to assemble our airships. "
  	  		+ "There are \u00A7l4\u00A7r "
			+ "airship types to choose from: "
			+ "\n\n"
			+ "The \u00A75\u00A7l\u00A7o"
			+ "Viesdenburg"
			+ "\u00A7r\u00A70. "
			+ "\n"
			+ "The \u00A75\u00A7l\u00A7o"
			+ "Viesigible"
			+ "\u00A7r\u00A70. "
			+ "\n"
			+ "The \u00A75\u00A7l\u00A7o"
			+ "Viesepelin"
			+ "\u00A7r\u00A70. "
			+ "\n"
			+ "The \u00A75\u00A7l\u00A7o"
			+ "Viesakron"
			+ "\u00A7r\u00A70. "
			+ "\n\n"
			+ "\u00A7o(Names can be changed in the config.)\u00A7r"
  	  		+ "\n\n\n\n"
	  	  	+ "Select an item below to display basic "
			+ "information and crafting recipes."
    		+ "\n"
    		+ "\n"
    		//+ "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii"
    		;
        
      stringPageTextRight[2] = " ";
        
      stringPageTextRightTooltip[7] = 
    		  "V1 Airship Recipe:"
            + "\n\n"
        	//+ "             \u00A7l\u00A7n" + ViesCraftConfig.v1AirshipName + " (V1)\u00A7r"
    		+ "\n\n"
    		+ "   This is the classic airship style for classy people."
    		+ "\n\n\n\n"
    		+ "Versions "
    		+ "\u00A7l"
    		+ "DO NOT "
    		+ "\u00A7r"
    		+ "affect the speed, max altitude, or fuel efficiency."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Airship Balloon, Airship Frame, "
    		+ "Airship Engine, Airship Ignition, "
    		+ "Lead"
    		+ "\u00A7r"
    		;
        		
	  stringPageTextRightTooltip[8] = 
    		  "V2 Airship Recipe:"
            + "\n\n"
        	//+ "               \u00A7l\u00A7n" + ViesCraftConfig.v2AirshipName + " (V2)\u00A7r"
    		+ "\n\n"
    		+ "   This is a unique twist on the airship design."
    		+ "\n\n\n\n"
    		+ "Versions "
    		+ "\u00A7l"
    		+ "DO NOT "
    		+ "\u00A7r"
    		+ "affect the speed, max altitude, or fuel efficiency."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Airship Balloon, Airship Frame, "
    		+ "Airship Engine, Airship Ignition, "
    		+ "Lead"
    		+ "\u00A7r"
    		;
        		
	  stringPageTextRightTooltip[9] = 
    		  "V3 Airship Recipe:"
            + "\n\n"
        	//+ "              \u00A7l\u00A7n" + ViesCraftConfig.v3AirshipName + " (V3)\u00A7r"
    		+ "\n\n"
    		+ "   An airship made for enthusiasts, by airship enthusiasts."
    		+ "\n\n\n\n"
    		+ "Versions "
    		+ "\u00A7l"
    		+ "DO NOT "
    		+ "\u00A7r"
    		+ "affect the speed, max altitude, or fuel efficiency."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Airship Balloon, Airship Frame, "
    		+ "Airship Engine, Airship Ignition, "
    		+ "Lead"
    		+ "\u00A7r"
    		;
        		
	  stringPageTextRightTooltip[10] = 
    		  "V4 Airship Recipe:"
            + "\n\n"
        	//+ "              \u00A7l\u00A7n" + ViesCraftConfig.v4AirshipName + " (V4)\u00A7r"
    		+ "\n\n"
    		+ "   Steampunk airship ingenuity at its finest. Modeled after V1 airships."
    		+ "\n\n\n\n"
    		+ "Versions "
    		+ "\u00A7l"
    		+ "DO NOT "
    		+ "\u00A7r"
    		+ "affect the speed, max altitude, or fuel efficiency."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Airship Balloon, Airship Frame, "
    		+ "Airship Engine, Airship Ignition, "
    		+ "Lead"
    		+ "\u00A7r"
    		;
	  
//===========================================================
      
      stringPageTextLeft[3] = 
  	  		  "   Here are a few random items you can make, just for some extra utility. "
  	  		+ "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
	  	  	+ "Select an item below to display basic "
			+ "information and crafting recipes."
    		+ "\n"
    		+ "\n"
    		;
        
      stringPageTextRight[3] = " ";
        
      stringPageTextRightTooltip[11] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Viesoline Pellets" + "\u00A7r"
    		+ "\n\n"
    		+ "   Redstone-infused fuel designed for "
    		+ "all airship versions. You can use "
    		+ "either Coal or Charcoal when making "
    		+ "this fuel."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Coal/Charcoal, Redstone "
    		+ "\u00A7r"
    		;
        		
	  stringPageTextRightTooltip[12] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + "Dismounter" + "\u00A7r"
    		+ "\n\n"
    		+ "   Left-Click on a mounted entity to "
    		+ "safely dismount it. This does no "
    		+ "damage, may cause laughter. Doesn't "
    		+ "work on players."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Leather, Stick, Feather"
    		+ "\u00A7r"
    		;
        		
	  stringPageTextRightTooltip[13] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "         \u00A7l\u00A7n" + "Dismounter (Player)" + "\u00A7r"
    		+ "\n\n"
    		+ "   This item works the same as the "
    		+ "Dismounter, except it also dismounts "
    		+ "players riding anything. This includes "
    		+ "airships, minecarts, boats, animals, etc. "
    		+ "\n\n"
    		+ "This can be disabled via the configs."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Leather, Stick, Feather"
    		+ "\u00A7r"
    		;
        		
	  //===================================
	  
	  //TODO Airship Interactions Strings
	  stringPageTextLeft[4] = 
			  "\n\n\n"
			+ "   Now that we have our airships made, "
			+ "it is time to use the item to spawn it. "
			+ "With your airship in your main hand, "
			+ "\u00A75[Hold Shift + Right Click]\u00A70 to throw "
			+ "it! Upon impact, it will explode and spawn your airship."
    		+ "\n\n"
    		+ "   \u00A7o\u00A7l*These explosions are safe.*\u00A7r"
    		+ "\n\n"
    		+ "   To turn an airship back into an item, "
    		+ "just hit it a few times empty handed. "
    		+ "No need for any tools! I find that one "
    		+ "shot with an arrow works quite well."
    		+ "\n\n\n\n\n\n\n"
    		+ "   Once you have your airship out, "
    		+ "\u00A75[Right Click]\u00A70 on it to begin riding. While "
    		+ "in the airship, you will be able to see a "
    		+ "HUD appear at the top of the screen. "
    		+ "This will give you important information "
    		+ "about the status of your airship."
    		;
    		
	  stringPageTextRight[4] = 
		    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) On Indicator"
		    + "\n\n"
		    + "      2.) Current Altitude"
		    + "\n\n"
		    + "      3.) Current Module"
		    + "\n\n"
		    + "      4.) Max Altitude"
		    + "\n\n"
		    + "      5.) Total Fuel"
		    + "\n\n"
		    + "      6.) Active Fuel"
		    + "\n\n"
		    + "      7.) Fuel Timer"
		    + "\u00A7r"
		    ;
	  
	  stringPageTextLeft[5] = 
		      "   Spawning your airship is only the "
		    + "start. It doesn't do much good if you "
		    + "don't know how to use it! "
		    + "\n\n"
		    + "   Interacting with your airship is quite easy. While riding in the airship, simply press the \u00A75["
    		+ Keybinds.vcInventory.getDisplayName()
    		+ " Key]\u00A70 to open the Main Menu of your airship."
    		+ "\n\n"
    		+ " \u00A7l\u00A7o*Only drivers can use the GUI.*\u00A7r"
    		+ "\n\n\n\n"
    		+ "   Your airship's Main Menu will look like the image on Page 12. Module info is covered in the Module section. "
    		+ "\n\n"
    		+ "   \u00A7l1). \u00A7nMenu Navigation\u00A7r is how you "
    		+ "will interact with various main menus "
    		+ "available to your airships. The menu's "
    		+ "button you are currently in will be "
    		+ "grayed out."
    		+ "\n\n"
    		+ "   \u00A7l2). \u00A7nStats Info\u00A7r will display your "
    		+ "airships current stats. This includes "
    		+ "Current Speed, Max Altitude, and Fuel "
    		+ "Efficiency, along with any upgrades or "
    		+ "enhancements already learned."
    		;
	  
	  stringPageTextRight[5] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) Menu Navigation"
		    + "\n\n"
		    + "      2.) Stats Info"
		    + "\n\n"
		    + "      3.) Fuel Interface"
		    + "\n\n"
		    + "      4.) Module Interface"
		    + "\u00A7r"
		    ;
	  
	  stringPageTextLeft[6] = 
			  "   \u00A7l3). \u00A7nFuel Interface\u00A7r will display "
			+ "info on your airships current fuel. All "
			+ "airships require fuel to fly. This does "
			+ "include vanilla Minecraft fuels along "
			+ "with most other mod's fuel."
			+ "\n\n\n\n\n"
			+ "   To add fuel, simply drag and drop "
			+ "the fuel item into the fuel slot! When "
			+ "this happens, the airship will consume "
			+ "the item \u00A7o\u00A7l(only one at a time)\u00A7r and "
			+ "start using it right away in the form of "
			+ "\"Active Fuel\". "
			+ "\n\n"
			+ "   You can leave stacks of fuel "
			+ "items in your fuel slot! Airships use only "
			+ "one item at a time, only when there is "
			+ "no \"Active Fuel\" left. No additional "
			+ "items will be used without something "
			+ "riding in the airship. "
			+ "\n\n"
			+ "   If the airship has \"Active Fuel\", it "
			+ "will use it until it runs out, even if the "
			+ "airship is empty. Don't leave animals in "
			+ "your airships with fuel items! That is a "
			+ "good way to waste your fuel...";
			;
	  
	  stringPageTextRight[6] =  
			  "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
			+ "\u00A7l"
			+ "      1.) Fuel Item Slot"
			+ "\n\n"
			+ "      2.) Active Fuel"
			+ "\n\n"
			+ "      3.) On Indicator"
			+ "\u00A7r"
			;
	  
	  //===================================
	  
	  //TODO Upgrade System Strings
	  
	  stringPageTextLeft[7] = 
			  "\n\n\n"
			+ "   The Upgrade system is a way for "
			+ "players to enhance their base airship "
			+ "stats. Currently there are "
			+ "\u00A7l4 \u00A7r"
			+ "types of "
			+ "upgrades : "
			+ "\n\n"
			+ "\u00A75\u00A7l\u00A7o"
			+ "- Frame"
			+ "\n"
			+ "- Core"
			+ "\n"
			+ "- Engine"
			+ "\n"
			+ "- Balloon"
			+ "\u00A7r\u00A70"
			+ "\n\n"
			+ "The following pages will describe how "
			+ "each upgrade affects your airships. "
			+ "\n\n\n\n\n\n\n\n\n\n\n"
			+ "   Please note that you cannot skip "
			+ "upgrade tiers! I.E.- You can't just "
			+ "go right to the max tier!"
			+ "\n\n "
			+ "\n\n"
			;
	  stringPageTextRight[7] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) Menu Navigation"
		    + "\n\n"
		    + "      2.) Installed Upgrade"
		    + "\n\n"
		    + "      3.) Item Upgrade Slot"
		    + "\n\n"
		    + "      4.) Accept Button"
		    + "\u00A7r"
		    ;
	  
	  stringPageTextLeft[8] = 
			  "                    \u00A7l\u00A7nFrame\u00A7r "
		    + "\n\n"
		    + "   This upgrade affects the max tier "
		    + "an airship's Core, Engine, and Balloon "
		    + "can have. Upgrading this will also "
		    + "increase the overall rarity of the "
		    + "airship. "
		    + "\n\n"
			;
	  stringPageTextRight[8] = 
			  " "
			;
	  
	  stringPageTextLeft[9] = 
			  "                    \u00A7l\u00A7nCore\u00A7r "
		    + "\n\n"
		    + "   This upgrade affects an airship's "
		    + "base speed! The max Core tier is "
		    + "dependant on the max Frame tier."
		    + "\n\n"
			;
	  stringPageTextRight[9] = 
			  " "
			;
	  
	  stringPageTextLeft[10] = 
			  "                    \u00A7l\u00A7nEngine\u00A7r "
		    + "\n\n"
		    + "   This upgrade affects an airship's "
		    + "fuel efficiency. The max Engine tier is "
		    + "dependant on the max Frame tier."
		    + "\n\n"
			;
	  stringPageTextRight[10] = 
			  " "
			;
	  
	  stringPageTextLeft[11] = 
			  "                    \u00A7l\u00A7nBalloon\u00A7r "
		    + "\n\n"
		    + "   This upgrade affects an airship's "
		    + "max altitude.  The max Balloon tier is "
		    + "dependant on the max Frame tier."
		    + "\n\n"
			;
	  stringPageTextRight[11] = 
			  " "
			;
	  
	  //--------------------------------------------------
	  
	  stringPageTextRightTooltip[14] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + "Frame Casing" + "\u00A7r"
    		+ "\n\n"
    		+ "   This casing has been upgraded with gold suitable for airship expansion. This is used in all Frame Tier upgrades."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Iron Ingot, Gold Ingot, Iron Bar"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[15] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Frame Upgrade 1" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "       \u00A7nUnlocks new frame visuals!\u00A7r"
    		+ "\n\n"
    		+ "           -=Base Upgrade=-"
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Frame Casing, Logic Chip, Airship Frame "
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[16] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Frame Upgrade 2" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "       \u00A7nUnlocks new frame visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 1 Frame."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Frame Casing, Logic Chip, Frame Upgrade 1"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[17] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Frame Upgrade 3" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "       \u00A7nUnlocks new frame visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 2 Frame."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Frame Casing, Logic Chip, Frame Upgrade 2"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[18] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Frame Upgrade 4" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "       \u00A7nUnlocks new frame visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 3 Frame."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Frame Casing, Logic Chip, Frame Upgrade 3"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[19] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Frame Upgrade 5" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "       \u00A7nUnlocks new frame visuals!\u00A7r"
    		+ "\n"
    		+ "\u00A7nUnlocks Transparency and Coloring!\u00A7r"
    		+ "\n"
    		+ "Must upgrade from a Tier 4 Frame."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Frame Casing, Logic Chip, Frame Upgrade 4"
    		+ "\u00A7r"
    		;
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[20] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "                \u00A7l\u00A7n" + "Core Shard" + "\u00A7r"
    		+ "\n\n"
    		+ "   This shard is densely packed with a few logic chips. This is used in all Core Tier upgrades."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Iron Ingot, Gold Ingot, Glass"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[21] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Core Upgrade 1" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to move faster! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "           -=Base Upgrade=-"
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Core Shard, Logic Chip, Airship Ignition"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[22] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Core Upgrade 2" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to move faster! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 1 Core."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Core Shard, Logic Chip, Core Upgrade 1"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[23] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Core Upgrade 3" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to move faster! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 2 Core."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Core Shard, Logic Chip, Core Upgrade 2"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[24] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Core Upgrade 4" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to move faster! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 3 Core."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Core Shard, Logic Chip, Core Upgrade 3"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[25] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Core Upgrade 5" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to move faster! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 4 Core."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Core Shard, Logic Chip, Core Upgrade 4"
    		+ "\u00A7r"
    		;
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[26] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "            \u00A7l\u00A7n" + "Engine Fragment" + "\u00A7r"
    		+ "\n\n"
    		+ "   A fragment of a super-charged blaze rod encrusted engine. This is used in all Engine Tier upgrades."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Iron Ingot, Gold Ingot, Blaze Rod"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[27] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Engine Upgrade 1" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to burn less fuel! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "           -=Base Upgrade=-"
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Engine Fragment, Logic Chip, Airship Engine"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[28] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Engine Upgrade 2" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 1 Engine."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Engine Fragment, Logic Chip, Engine Upgrade 1"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[29] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Engine Upgrade 3" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 2 Engine."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Engine Fragment, Logic Chip, Engine Upgrade 2"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[30] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Engine Upgrade 4" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 3 Engine."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Engine Fragment, Logic Chip, Engine Upgrade 3"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[31] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "           \u00A7l\u00A7n" + "Engine Upgrade 5" + "\u00A7r"
    		+ "\n\n"
    		+ "   Allow airships to get upgrades! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "   "
    		+ "\n\n"
    		+ "Must upgrade from a Tier 4 Engine."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Engine Fragment, Logic Chip, Engine Upgrade 4"
    		+ "\u00A7r"
    		;
	  
	  //-----------------------------------------
	  
	  stringPageTextRightTooltip[32] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Balloon Casing" + "\u00A7r"
    		+ "\n\n"
    		+ "   This remnant has been infused with a light-weight treated leather. This is used in all Balloon Tier upgrades."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Coal/Charcoal, Redstone "
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[33] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + "Balloon Upgrade 1" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to fly higher! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "      \u00A7nUnlocks new balloon visuals!\u00A7r"
    		+ "\n\n"
    		+ "           -=Base Upgrade=-"
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Balloon Remnant, Logic Chip, Airship Balloon "
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[34] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + "Balloon Upgrade 2" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to fly higher! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "      \u00A7nUnlocks new balloon visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 1 Balloon."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Balloon Remnant, Logic Chip, Balloon Upgrade 1"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[35] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + "Balloon Upgrade 3" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to fly higher! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "      \u00A7nUnlocks new balloon visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 2 Balloon."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Balloon Remnant, Logic Chip, Balloon Upgrade 2"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[36] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + "Balloon Upgrade 4" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to fly higher! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "      \u00A7nUnlocks new balloon visuals!\u00A7r"
    		+ "\n\n"
    		+ "Must upgrade from a Tier 3 Balloon."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Balloon Remnant, Logic Chip, Balloon Upgrade 3"
    		+ "\u00A7r"
    		;
	  stringPageTextRightTooltip[37] = 
    		  "Item Recipe:"
            + "\n\n"
        	+ "          \u00A7l\u00A7n" + "Balloon Upgrade 5" + "\u00A7r"
    		+ "\n\n"
    		+ "     Allow airships to fly higher! "
    		+ "\n"
    		+ "  This works in any airship version."
    		+ "\n\n"
    		+ "      \u00A7nUnlocks new balloon visuals!\u00A7r"
    		+ "\n"
    		+ "\u00A7nUnlocks Transparency and Coloring!\u00A7r"
    		+ "\n"
    		+ "Must upgrade from a Tier 4 Balloon."
    		+ "\n"
    		+ "Use in the airship's \"Upgrade\" menu."
    		+ "\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Balloon Remnant, Logic Chip, Balloon Upgrade 4"
    		+ "\u00A7r"
    		;
	  
	  
	  
	  
	  
	  
	  
	  
	  
	  //===================================
	  
	  //TODO Module System Strings
	  
	  stringPageTextLeft[12] = 
			  "\n\n\n"
			+ "   The Module system is another way "
			+ "for players to enhance their airships "
			+ "with special abilities. Modules are "
			+ "learned by airships and are able to "
			+ "be toggled on and off. Only one "
			+ "module can be active at a time. "
			+ "\n\n"
			+ "   There are currently "
			+ "\u00A7l8 \u00A7r"
			+ "types of "
			+ "modules to choose from. Each module "
			+ "is upgradeable. All modules have a "
			+ "Lesser, Normal, and Greater version. "
			+ "The better the version, the better the "
			+ "benefits. "
			+ "\n\n"
			+ "   All modules must be upgraded in "
			+ "sequence like the main Tiers. The "
			+ "following pages will list all of the "
			+ "module recipes."
			;
	  stringPageTextRight[12] = 
		      "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n"
		    + "\u00A7l"
		    + "      1.) Menu Navigation"
		    + "\n\n"
		    + "      2.) Active Module"
		    + "\n\n"
		    + "      3.) Turned off Module"
		    + "\n\n"
		    + "      4.) Module Upgrade Slot"
		    + "\u00A7r"
			;
	  
	  stringPageTextLeft[13] = 
			  "Select an item below to display basic "
    		+ "information and crafting recipes."
    		+ "\n\n"
			;
	  
	  stringPageTextRight[13] = 
			  " "
			;
	  
	  stringPageTextLeft[14] = 
			  "Select an item below to display basic "
    		+ "information and crafting recipes."
    		+ "\n\n"
			;
	  
	  stringPageTextRight[14] = 
			  " "
			;
	  
	  stringPageTextLeft[15] = 
			  "Select an item below to display basic "
    		+ "information and crafting recipes."
    		+ "\n\n"
			;
	  
	  stringPageTextRight[15] = 
			  " "
			;
	  
	  stringPageTextLeft[16] = 
			  "Select an item below to display basic "
    		+ "information and crafting recipes."
    		+ "\n\n"
			;
	  
	  stringPageTextRight[16] = 
			  " "
			;
	  
	  //--------------------------------------
	  
	  stringPageTextRightTooltip[38] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                \u00A7l\u00A7n" + "Module Chip" + "\u00A7r"
    		+ "\n\n"
    		+ "   A base module chip formatted for "
    		+ "airship interfaces. This is use to make "
    		+ "every module."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Emerald"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[39] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Lesser Altitude" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly higher beyond the normal Balloon Tier "
    		+ "cap (225 height max). The speed that "
    		+ "airships can ascend is slightly "
    		+ "increased as well."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Glowstone Dust, "
    		+ "Feather, Redstone Torch"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[40] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                  \u00A7l\u00A7n" + "Altitude" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly higher beyond the normal Balloon Tier "
    		+ "cap (250 height max). The speed that "
    		+ "airships can ascend is moderately "
    		+ "increased as well."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Altitude Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[41] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Greater Altitude" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly higher beyond the normal Balloon Tier "
    		+ "cap (unlimited height max). The speed "
    		+ "that airships can ascend is greatly "
    		+ "increased as well."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Altitude Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[42] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + "Lesser Speed" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly faster (+1 Speed Modifier). The speed that "
    		+ "airships can turn is slightly "
    		+ "increased as well."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Gunpowder, "
    		+ "Flint, Fire Charge"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[43] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                 \u00A7l\u00A7n" + "Speed" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly faster (+2 Speed Modifier). The speed that "
    		+ "airships can turn is moderately "
    		+ "increased as well."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Speed Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[44] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + "Greater Speed" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly faster (+3 Speed Modifier). The speed that "
    		+ "airships can turn is greatly "
    		+ "increased as well."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Speed Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[45] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Lesser Storage" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to store items (9 slots). There is a "
    		+ "30% speed decrease due to the extra "
    		+ "weight."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Tripwire Hook, "
    		+ "Redstone, Chest"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[46] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                 \u00A7l\u00A7n" + "Storage" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to store items (18 slots). There is a "
    		+ "30% speed decrease due to the extra "
    		+ "weight."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Storage Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[47] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Greater Storage" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to store items (27 slots). There is a "
    		+ "30% speed decrease due to the extra "
    		+ "weight."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Storage Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[48] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + "Lesser Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to burn fuel more efficiently (20% savings)."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Stone Pressure Plate, Blaze Powder, "
    		+ "Fire Charge"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[49] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                    \u00A7l\u00A7n" + "Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to burn fuel more efficiently (40% savings)."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Fuel Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[50] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "               \u00A7l\u00A7n" + "Greater Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to burn fuel more efficiently (60% savings)."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Fuel Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[51] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + "Lesser Music" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to play music (6 songs). This can be "
    		+ "heard all around the airship."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Redstone, "
    		+ "Note Block, Jukebox"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[52] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "                 \u00A7l\u00A7n" + "Music" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to play music (12 songs). This can be "
    		+ "heard all around the airship."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Music Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[53] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "              \u00A7l\u00A7n" + "Greater Music" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to play music (18 songs). This can be "
    		+ "heard all around the airship."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Music Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[54] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Lesser Cruise" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to Auto-Forward. This module applies a 66% speed decrease."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Lever, "
    		+ "Glowstone Dust, Clock"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[55] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Cruise" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to Auto-Forward. This module applies a 33% speed decrease."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Cruise Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[56] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Greater Cruise" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to Auto-Forward. This module applies no speed decrease."
    		+ "\n\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Cruise Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[57] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Lesser Water" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to hover on water. Airship will no longer be damaged by water. Speed is slowed while on water."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Slimeball, "
    		+ "Compass, Oak Boat"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[58] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Water" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to hover on water. Airship will no longer be damaged by water. Medium speed while on water."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Water Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[59] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Greater Water" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to hover on water. Airship will no longer be damaged by water. Fast speed while on water."
    		+ "\n\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Water Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[60] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Lesser Infinite Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly without fuel. You don't get a lot of power making energy out of nothing. There is a 90% speed decrease."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Ender Pearl, "
    		+ "Blaze Rod, Ghast Tear"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[61] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Infinite Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly without fuel. You don't get a lot of power making energy out of nothing. There is a 80% speed decrease."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Diamond, "
    		+ "Lesser Inf. Fuel Module"
    		+ "\u00A7r"
    		;
	  
	  stringPageTextRightTooltip[62] = 
    		  "Module Recipe:"
            + "\n\n"
        	+ "             \u00A7l\u00A7n" + "Greater Infinite Fuel" + "\u00A7r"
    		+ "\n\n"
    		+ "   This module gives airships the ability "
    		+ "to fly without fuel. You don't get a lot of power making energy out of nothing. There is a 70% speed decrease."
    		+ "\n\n\n\n"
    		+ "\u00A7oIngredient list:\u00A7r"
    		+ "\n"
    		+ "\u00A7o\u00A7l"
    		+ "Logic Chip, Weighted Pressure "
    		+ "Plate, Quartz, Emerald, "
    		+ "Inf. Fuel Module"
    		+ "\u00A7r"
    		;
	  
	  
	  
	  
	  //===================================
	  
	  //TODO Airship Behavior Strings
	  
	  stringPageTextLeft[17] = 
			  "\n\n\n"
			+ "   Interesting facts about airships:"
			+ "\n\n"
    		+ "- Airships can hold 2 players, or 1 player and 1 animal. Monsters can also hop in your airship so keep a Dismounter handy! "
    		+ "\n\n"
			+ "- Airships hate water! Once in water, you will begin to move very slowly. If you go deeper, your airship will begin to smoke. If you do not get out of the water in time, it will explode. Warning! It will hurt and destroy your airship."
    		+ "\n\n"
			;
	  
	  stringPageTextRight[17] = 
			  "Use the following keys "
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
    }
}



/**
 * 
 * 
    

        stringPageText[9] = "\n"
        		+ 
        		
        		;
        
 */








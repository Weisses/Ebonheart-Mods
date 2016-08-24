package com.viesis.viescraft.client.gui.v1;

import java.io.IOException;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.api.util.LogHelper;
import com.viesis.viescraft.common.entity.airshipcolors.ContainerAirshipCore;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipCore;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.configs.ViesCraftConfig;

public class GuiTileEntityAirshipWorkbench extends GuiContainer {
	
	//private IInventory playerInv;
	private InventoryPlayer playerInventory;
	private TileEntityAirshipWorkbench airship;
	private final World worldObj;
    /** Position of the workbench */
    //private final BlockPos pos;
    
	public GuiTileEntityAirshipWorkbench(//IInventory playerInv, TileEntityAirshipWorkbench airship
			InventoryPlayer playerInventory, World worldIn, TileEntityAirshipWorkbench airship// BlockPos posIn
			
			//IInventory playerInv
			//, World world, BlockPos pos
			)
	{
		super(new ContainerAirshipWorkbench(playerInventory, worldIn, airship));
		
		this.worldObj = worldIn;
        //this.pos = posIn;
		this.playerInventory = playerInventory;
		this.airship = airship;
		this.xSize = 176;
		this.ySize = 166;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + ":" + "textures/gui/container_airship_workbench.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		//int i = (this.width - this.xSize) / 2;
        //int j = (this.height - this.ySize) / 2;
        
		//if (EntityAirshipCore.isAirshipBurning(this.airship))
        //{
			//int x = airship.getFuelScaled(10);
            //int k = this.getBurnLeftScaled(47);
            this.drawTexturedModalRect(
            		this.guiLeft + 156, this.guiTop + 19, //i + 56, j + 36 + 12 - k, 
            		176,  50, //176, 12 - k, 
            		8, 1); //+ k); //8, 48 + k);//14, k + 1);
            this.drawTexturedModalRect(
            		this.guiLeft + 129, this.guiTop + 48,//i + 79, j + 34, 
            		176, 14, 
            		26, 16);
        //}

        //int l = this.getCookProgressScaled(24);
      //Light bulbs that are lite up.
        //this.drawTexturedModalRect(
        //		this.guiLeft + 129, this.guiTop + 48,//i + 79, j + 34, 
        //		176, 14, 
        //		16 + 1, 16);
    }

    //private int getCookProgressScaled(int pixels)
    //{
    //    int i = this.airship.getField(2);
    //    int j = this.airship.getField(3);
    //    return j != 0 && i != 0 ? i * pixels / j : 0;
    //}

    /**private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(1);

        if (i == 0)
        {
        	i = (ViesCraftConfig.fuelBurnTime * 20);//i = 1200;
        }

        return this.airship.getField(0) * pixels / i;
    }
		*/

    
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		//String s = this.airship.getDisplayName().getUnformattedText();
		////this.fontRendererObj.drawString(s, 8, 6, 4210752);
		this.fontRendererObj.drawString("Fuel", 150, 6, 4210752);
		// This sets the Airship name in the top center.
		//this.fontRendererObj.drawString(s, 88 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		//this.fontRendererObj.drawString(this.playerInv.getDisplayName().getUnformattedText(), 8, 72, 4210752);
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if (keyCode == 1 
        ||	keyCode == Keybinds.vcInventory.getKeyCode()
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.thePlayer.closeScreen();
        }
    }
}		
		
		
		
		
		
		/**
		if (EntityAirshipCore.isBurning(this.airship))
        {
			int x = airship.getFuelScaled(10);
            //int k = this.getBurnLeftScaled(13);
            //LogHelper.info("Test!");
            this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 
            		176,  50,//12 - k, 
            		8, 48 - x);
        }
		int l = this.getCookProgressScaled(24);
		//Light bulbs that are lite up.
        this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 
        176, 14, 
        l + 1, 16);
	}
	
	private int getCookProgressScaled(int pixels)
    {
        int i = this.airship.getField(2);
        //int j = this.airship.getField(3);
        return i != 0 && i != 0 ? i * pixels / i : 0;
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.airship.getField(2);

        if (i == 0)
        {
            i = 200;
        }
        
        return this.airship.getField(0) * pixels / i;
    }
    
    
    
    
    
    
    
}
*/
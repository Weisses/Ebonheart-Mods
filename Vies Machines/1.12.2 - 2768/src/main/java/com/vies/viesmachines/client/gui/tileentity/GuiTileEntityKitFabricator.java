package com.vies.viesmachines.client.gui.tileentity;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.tileentity.TileEntityKitFabricator;
import com.vies.viesmachines.common.tileentity.containers.ContainerKitFabricator;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerGem;
import com.vies.viesmachines.network.server.tileentity.MessageGuiKitFabricatorSyncServerOn;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiTileEntityKitFabricator extends GuiContainer {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_appliance_kit_fabricator.png");
	
	private InventoryPlayer playerInventory;
	private TileEntityKitFabricator appliance;
	private final World world;
	private ItemStack draggedStack = ItemStack.EMPTY;
	
	public static boolean metaOn;
	public static int metaItem;
	public static int metaPosX;
	public static int metaPosY;
	public static int metaPosZ;
	
	private GuiButton buttonPower;
	private GuiButton buttonKitHealth1;
	private GuiButton buttonKitHealth2;
	private GuiButton buttonKitHealth3;
	private GuiButton buttonKitEnergy1;
	private GuiButton buttonKitEnergy2;
	private GuiButton buttonKitEnergy3;
	private GuiButton buttonKitDurability1;
	private GuiButton buttonKitDurability2;
	private GuiButton buttonKitDurability3;
	private GuiButton buttonKitAmmo1;
	private GuiButton buttonKitAmmo2;
	private GuiButton buttonKitAmmo3;
	
	public GuiTileEntityKitFabricator(InventoryPlayer playerInventory, World worldIn, TileEntityKitFabricator applianceIn)
	{
		super(new ContainerKitFabricator(playerInventory, worldIn, applianceIn));
		
		this.world = worldIn;
        this.playerInventory = playerInventory;
		this.appliance = applianceIn;
		this.xSize = 176;
		this.ySize = 166;
		this.metaOn = this.appliance.isOn;
		this.metaItem = this.appliance.itemToFindMeta;
		
		this.metaPosX = this.appliance.getPos().getX();
		this.metaPosY = this.appliance.getPos().getY();
		this.metaPosZ = this.appliance.getPos().getZ();
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	this.buttonPower = new GuiButton(99, this.guiLeft + 17+9+9, this.guiTop + 53+10, 16, 16, " ");
    	
    	this.buttonKitHealth1 = new GuiButton(0, this.guiLeft + 8, this.guiTop + 8, 16, 16, " ");
    	this.buttonKitHealth2 = new GuiButton(1, this.guiLeft + 8, this.guiTop + 24, 16, 16, " ");
    	this.buttonKitHealth3 = new GuiButton(2, this.guiLeft + 8, this.guiTop + 40, 16, 16, " ");
    	this.buttonKitEnergy1 = new GuiButton(3, this.guiLeft + 26, this.guiTop + 8, 16, 16, " ");
    	this.buttonKitEnergy2 = new GuiButton(4, this.guiLeft + 26, this.guiTop + 24, 16, 16, " ");
    	this.buttonKitEnergy3 = new GuiButton(5, this.guiLeft + 26, this.guiTop + 40, 16, 16, " ");
    	this.buttonKitDurability1 = new GuiButton(6, this.guiLeft + 44, this.guiTop + 8, 16, 16, " ");
    	this.buttonKitDurability2 = new GuiButton(7, this.guiLeft + 44, this.guiTop + 24, 16, 16, " ");
    	this.buttonKitDurability3 = new GuiButton(8, this.guiLeft + 44, this.guiTop + 40, 16, 16, " ");
    	this.buttonKitAmmo1 = new GuiButton(9, this.guiLeft + 62, this.guiTop + 8, 16, 16, " ");
    	this.buttonKitAmmo2 = new GuiButton(10, this.guiLeft + 62, this.guiTop + 24, 16, 16, " ");
    	this.buttonKitAmmo3 = new GuiButton(11, this.guiLeft + 62, this.guiTop + 40, 16, 16, " ");
		
    	this.buttonList.add(this.buttonPower);
    	this.buttonList.add(this.buttonKitHealth1);
    	this.buttonList.add(this.buttonKitHealth2);
    	this.buttonList.add(this.buttonKitHealth3);
    	this.buttonList.add(this.buttonKitEnergy1);
    	this.buttonList.add(this.buttonKitEnergy2);
    	this.buttonList.add(this.buttonKitEnergy3);
    	this.buttonList.add(this.buttonKitDurability1);
    	this.buttonList.add(this.buttonKitDurability2);
    	this.buttonList.add(this.buttonKitDurability3);
    	this.buttonList.add(this.buttonKitAmmo1);
    	this.buttonList.add(this.buttonKitAmmo2);
    	this.buttonList.add(this.buttonKitAmmo3);
    }
    
    @Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if(parButton.id == 0)
	    {
			this.metaItem = 0;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 1)
	    {
			this.metaItem = 1;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 2)
	    {
			this.metaItem = 2;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 3)
	    {
			this.metaItem = 3;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 4)
	    {
			this.metaItem = 4;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 5)
	    {
			this.metaItem = 5;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 6)
	    {
			this.metaItem = 6;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 7)
	    {
			this.metaItem = 7;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 8)
	    {
			this.metaItem = 8;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 9)
	    {
			this.metaItem = 9;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 10)
	    {
			this.metaItem = 10;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		if(parButton.id == 11)
	    {
			this.metaItem = 11;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerGem());
	    }
		
		
		
		if(parButton.id == 99)
	    {
			this.metaOn = !this.metaOn;
			NetworkHandler.sendToServer(new MessageGuiKitFabricatorSyncServerOn());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 176, 50, 8, 1);
        this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 176, 14, 26, 16);
        
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        
        if(this.appliance.isApplianceOn())
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 81+12, j + 50+9 - k, 176, 13 - k, 14, k + 1);
        }
    }
	
    private int getBurnLeftScaled(int pixels)
    {
        int i = this.appliance.getField(1);
        
        if(i == 0)
        {
            i = 200;
        }
        
        return this.appliance.getField(0) * pixels / i;
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{
		// Draws a black line under the kit buttons:
		this.drawRect(8 + (18 * 0), 23 + (16 * 0), 24 + (18 * 0), 24 + (16 * 0), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 0), 23 + (16 * 1), 24 + (18 * 0), 24 + (16 * 1), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 0), 23 + (16 * 2), 24 + (18 * 0), 24 + (16 * 2), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 1), 23 + (16 * 0), 24 + (18 * 1), 24 + (16 * 0), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 1), 23 + (16 * 1), 24 + (18 * 1), 24 + (16 * 1), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 1), 23 + (16 * 2), 24 + (18 * 1), 24 + (16 * 2), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 2), 23 + (16 * 0), 24 + (18 * 2), 24 + (16 * 0), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 2), 23 + (16 * 1), 24 + (18 * 2), 24 + (16 * 1), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 2), 23 + (16 * 2), 24 + (18 * 2), 24 + (16 * 2), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 3), 23 + (16 * 0), 24 + (18 * 3), 24 + (16 * 0), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 3), 23 + (16 * 1), 24 + (18 * 3), 24 + (16 * 1), Color.BLACK.getRGB());
		this.drawRect(8 + (18 * 3), 23 + (16 * 2), 24 + (18 * 3), 24 + (16 * 2), Color.BLACK.getRGB());
		
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_appliance_extractor.png"));
		
		if(this.appliance.isOn)
		{
			this.drawTexturedModalRect(17+9+9, 53+10, 16, 166, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(17+9+9, 53+10, 0, 166, 16, 16);
		}
		
		ItemStack[] stack = new ItemStack[]
		{
			new ItemStack(ItemsVM.KIT_HEALTH_2, 1),
			new ItemStack(ItemsVM.KIT_HEALTH_8, 1),
			new ItemStack(ItemsVM.KIT_HEALTH_MAX, 1),
			new ItemStack(ItemsVM.KIT_ENERGY_25, 1),
			new ItemStack(ItemsVM.KIT_ENERGY_100, 1),
			new ItemStack(ItemsVM.KIT_ENERGY_MAX, 1),
			new ItemStack(ItemsVM.KIT_DURABILITY_50, 1),
			new ItemStack(ItemsVM.KIT_DURABILITY_200, 1),
			new ItemStack(ItemsVM.KIT_DURABILITY_MAX, 1),
			new ItemStack(ItemsVM.KIT_AMMO_4, 1),
			new ItemStack(ItemsVM.KIT_AMMO_16, 1),
			new ItemStack(ItemsVM.KIT_AMMO_64, 1)
		};
		
		
		
		this.drawItemStack(stack[this.metaItem], 56+24+12, 17+9, "");
		
		
		
		this.drawItemStack(new ItemStack(ItemsVM.KIT_HEALTH_2, 1), 8, 8-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_HEALTH_8, 1), 8, 24-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_HEALTH_MAX, 1), 8, 40-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_ENERGY_25, 1), 26, 8-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_ENERGY_100, 1), 26, 24-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_ENERGY_MAX, 1), 26, 40-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_DURABILITY_50, 1), 44, 8-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_DURABILITY_200, 1), 44, 24-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_DURABILITY_MAX, 1), 44, 40-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_AMMO_4, 1), 62, 8-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_AMMO_16, 1), 62, 24-1, "");
		this.drawItemStack(new ItemStack(ItemsVM.KIT_AMMO_64, 1), 62, 40-1, "");
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(0, 0.5F, 0);
			
			if(this.appliance.getField(2) >= 200)
			{
				this.fontRenderer.drawString(this.appliance.getField(2) + "%", 14+9+27+27+13, 27-10-8, 0);
			}
			else if(this.appliance.getField(2) >= 100)
			{
				this.fontRenderer.drawString(this.appliance.getField(2) + "%", 16+9+27+27+13, 27-10-8, 0);
			}
			else if(this.appliance.getField(2) > 9)
			{
				this.fontRenderer.drawString(this.appliance.getField(2) + "%", 17+9+27+27+13, 27-10-8, 0);
			}
			else if(this.appliance.getField(2) > 0)
			{
				this.fontRenderer.drawString(this.appliance.getField(2) + "%", 20+9+27+27+13, 27-10-8, 0);
			}
			else if(this.appliance.getField(2) == 0)
			{
				this.fontRenderer.drawString("0%", 20+9+27+27+13, 27-10-8, 0);
			}
		}
		GlStateManager.popMatrix();
	}
	
	@Override
	protected void keyTyped(char typedChar, int keyCode) throws IOException
    {
		if(keyCode == 1 
        || this.mc.gameSettings.keyBindInventory.isActiveAndMatches(keyCode))
        {
            this.mc.player.closeScreen();
        }
    }
	
	/** Draws an ItemStack. The z index is increased by 32 (and not decreased afterwards), and the item is then rendered at z=200. */
    private void drawItemStack(ItemStack stack, int x, int y, String altText)
    {
        GlStateManager.translate(0.0F, 0.0F, 32.0F);
        this.zLevel = 200.0F;
        this.itemRender.zLevel = 200.0F;
        net.minecraft.client.gui.FontRenderer font = stack.getItem().getFontRenderer(stack);
        if (font == null) font = fontRenderer;
        this.itemRender.renderItemAndEffectIntoGUI(stack, x, y);
        this.itemRender.renderItemOverlayIntoGUI(font, stack, x, y - (this.draggedStack.isEmpty() ? 0 : 8), altText);
        this.zLevel = 0.0F;
        this.itemRender.zLevel = 0.0F;
    }
    
    @Override
	public void updateScreen()
    {
        super.updateScreen();
        
        if (this.metaItem == 0)
        {
        	this.buttonKitHealth1.enabled = false;
        }
        else
        {
        	this.buttonKitHealth1.enabled = true;
        }
        if (this.metaItem == 1)
        {
        	this.buttonKitHealth2.enabled = false;
        }
        else
        {
        	this.buttonKitHealth2.enabled = true;
        }
        if (this.metaItem == 2)
        {
        	this.buttonKitHealth3.enabled = false;
        }
        else
        {
        	this.buttonKitHealth3.enabled = true;
        }
        
        if (this.metaItem == 3)
        {
        	this.buttonKitEnergy1.enabled = false;
        }
        else
        {
        	this.buttonKitEnergy1.enabled = true;
        }
        if (this.metaItem == 4)
        {
        	this.buttonKitEnergy2.enabled = false;
        }
        else
        {
        	this.buttonKitEnergy2.enabled = true;
        }
        if (this.metaItem == 5)
        {
        	this.buttonKitEnergy3.enabled = false;
        }
        else
        {
        	this.buttonKitEnergy3.enabled = true;
        }
        
        if (this.metaItem == 6)
        {
        	this.buttonKitDurability1.enabled = false;
        }
        else
        {
        	this.buttonKitDurability1.enabled = true;
        }
        if (this.metaItem == 7)
        {
        	this.buttonKitDurability2.enabled = false;
        }
        else
        {
        	this.buttonKitDurability2.enabled = true;
        }
        if (this.metaItem == 8)
        {
        	this.buttonKitDurability3.enabled = false;
        }
        else
        {
        	this.buttonKitDurability3.enabled = true;
        }
        
        if (this.metaItem == 9)
        {
        	this.buttonKitAmmo1.enabled = false;
        }
        else
        {
        	this.buttonKitAmmo1.enabled = true;
        }
        if (this.metaItem == 10)
        {
        	this.buttonKitAmmo2.enabled = false;
        }
        else
        {
        	this.buttonKitAmmo2.enabled = true;
        }
        if (this.metaItem == 11)
        {
        	this.buttonKitAmmo3.enabled = false;
        }
        else
        {
        	this.buttonKitAmmo3.enabled = true;
        }
    }
}

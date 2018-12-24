package com.vies.viesmachines.client.gui.tileentity;

import java.awt.Color;
import java.io.IOException;

import org.lwjgl.input.Keyboard;

import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.tileentity.TileEntityMachineTransmogrifier;
import com.vies.viesmachines.common.tileentity.containers.ContainerMachineTransmogrifier;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.tileentity.MessageGuiExtractorSyncServerOn;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class GuiTileEntityMachineTransmogrifier extends GuiContainer {
	
	private InventoryPlayer playerInventory;
	private TileEntityMachineTransmogrifier appliance;
	private final World world;
	private ItemStack draggedStack = ItemStack.EMPTY;
	
	public static boolean metaOn;
	public static int metaGem;
	public static int metaPosX;
	public static int metaPosY;
	public static int metaPosZ;
	
	private GuiButton buttonPower;
	//private GuiButton buttonDraconite;
	//private GuiButton buttonVelious;
	//private GuiButton buttonArcanite;
	//private GuiButton buttonKatcheen;
	//private GuiButton buttonCarnelian;
	//private GuiButton buttonNecrocite;
	//private GuiButton buttonOnyxius;
	//private GuiButton buttonSoularite;
	//private GuiButton buttonEbonheart;
	
	public GuiTileEntityMachineTransmogrifier(InventoryPlayer playerInventory, World worldIn, TileEntityMachineTransmogrifier applianceIn)
	{
		super(new ContainerMachineTransmogrifier(playerInventory, worldIn, applianceIn));
		
		this.world = worldIn;
        this.playerInventory = playerInventory;
		this.appliance = applianceIn;
		this.xSize = 176;
		this.ySize = 166;
		this.metaOn = this.appliance.isOn;
		
		this.metaPosX = this.appliance.getPos().getX();
		this.metaPosY = this.appliance.getPos().getY();
		this.metaPosZ = this.appliance.getPos().getZ();
	}
	
	/**
     * Adds the buttons (and other controls) to the screen in question.
     */
    @Override
    public void initGui() 
    {
    	super.initGui();
    	
    	buttonList.clear();
    	Keyboard.enableRepeatEvents(true);
    	
    	buttonPower = new GuiButton(9, this.guiLeft + 17+9, this.guiTop + 53, 16, 16, " ");
    	//buttonDraconite = new GuiButton(0, this.guiLeft - 31, this.guiTop + 8, 16, 16, " ");
    	//buttonVelious = new GuiButton(1, this.guiLeft - 31, this.guiTop + 24, 16, 16, " ");
    	//buttonArcanite = new GuiButton(2, this.guiLeft - 31, this.guiTop + 40, 16, 16, " ");
    	//buttonKatcheen = new GuiButton(3, this.guiLeft - 31, this.guiTop + 56, 16, 16, " ");
    	//buttonCarnelian = new GuiButton(4, this.guiLeft - 15, this.guiTop + 8, 16, 16, " ");
    	//buttonNecrocite = new GuiButton(5, this.guiLeft - 15, this.guiTop + 24, 16, 16, " ");
    	//buttonOnyxius = new GuiButton(6, this.guiLeft - 15, this.guiTop + 40, 16, 16, " ");
    	//buttonSoularite = new GuiButton(7, this.guiLeft - 15, this.guiTop + 56, 16, 16, " ");
    	//buttonEbonheart = new GuiButton(8, this.guiLeft - 23, this.guiTop + 72, 16, 16, " ");
		
    	this.buttonList.add(buttonPower);
    	//this.buttonList.add(buttonDraconite);
    	//this.buttonList.add(buttonVelious);
    	//this.buttonList.add(buttonArcanite);
    	//this.buttonList.add(buttonKatcheen);
    	//this.buttonList.add(buttonCarnelian);
    	//this.buttonList.add(buttonNecrocite);
    	//this.buttonList.add(buttonOnyxius);
    	//this.buttonList.add(buttonSoularite);
    	//this.buttonList.add(buttonEbonheart);
    }
    
    /**
     * Called by the controls from the buttonList when activated. (Mouse pressed for buttons)
     */
	@Override
    protected void actionPerformed(GuiButton parButton) 
    {
		if(parButton.id == 0)
	    {
			this.metaGem = 0;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 1)
	    {
			this.metaGem = 1;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 2)
	    {
			this.metaGem = 2;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 3)
	    {
			this.metaGem = 3;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 4)
	    {
			this.metaGem = 4;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 5)
	    {
			this.metaGem = 5;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 6)
	    {
			this.metaGem = 6;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 7)
	    {
			this.metaGem = 7;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 8)
	    {
			this.metaGem = 8;
			//NetworkHandler.sendToServer(new MessageGuiWorkbenchSyncServerGem());
	    }
		if(parButton.id == 9)
	    {
			this.metaOn = !this.metaOn;
			NetworkHandler.sendToServer(new MessageGuiExtractorSyncServerOn());
	    }
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_appliance_extractor.png"));
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
		this.drawTexturedModalRect(this.guiLeft + 156, this.guiTop + 19, 176, 50, 8, 1);
        this.drawTexturedModalRect(this.guiLeft + 129, this.guiTop + 48, 176, 14, 26, 16);
        
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        
        if(this.appliance.isApplianceOn())
        {
            int k = this.getBurnLeftScaled(13);
            this.drawTexturedModalRect(i + 81, j + 50 - k, 176, 13 - k, 14, k + 1);
        }
        
        this.drawRect(this.guiLeft, this.guiTop + 8, this.guiLeft - 31, this.guiTop + 73, Color.BLACK.getRGB());
        this.drawRect(this.guiLeft - 7, this.guiTop + 73, this.guiLeft - 23, this.guiTop + 89, Color.BLACK.getRGB());
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
		this.mc.getTextureManager().bindTexture(new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_gui_appliance_extractor.png"));
		
		if(this.appliance.isOn)
		{
			this.drawTexturedModalRect(17+9, 53, 16, 166, 16, 16);
		}
		else
		{
			this.drawTexturedModalRect(17+9, 53, 0, 166, 16, 16);
		}
		
		this.drawItemStack(new ItemStack(ItemsVM.XEGONITE, 1), 56+24, 17, "");
		
		/*
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, this.appliance.gemstoneMeta), 56, 17, "");
		
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 0), -31, 9, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 1), -31, 25, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 2), -31, 41, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 3), -31, 57, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 4), -15, 9, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 5), -15, 25, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 6), -15, 41, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 7), -15, 57, "");
		this.drawItemStack(new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 8), -23, 73, "");
		*/
		if(this.appliance.getField(2) >= 200)
		{
			this.fontRenderer.drawString(this.appliance.getField(2) + "%", 14+9, 27, 0);
		}
		else if(this.appliance.getField(2) >= 100)
		{
			this.fontRenderer.drawString(this.appliance.getField(2) + "%", 16+9, 27, 0);
		}
		else if(this.appliance.getField(2) > 9)
		{
			this.fontRenderer.drawString(this.appliance.getField(2) + "%", 17+9, 27, 0);
		}
		else if(this.appliance.getField(2) > 0)
		{
			this.fontRenderer.drawString(this.appliance.getField(2) + "%", 20+9, 27, 0);
		}
		else if(this.appliance.getField(2) == 0)
		{
			this.fontRenderer.drawString("0%", 20+9, 27, 0);
		}
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
	
	/**
     * Draws an ItemStack.
     *  
     * The z index is increased by 32 (and not decreased afterwards), and the item is then rendered at z=200.
     */
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
}

package com.vies.viesmachines.client.gui.machines.main;

import java.awt.Color;
import java.io.IOException;

import com.vies.viesmachines.api.GuiVM;
import com.vies.viesmachines.api.ItemsVM;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.client.gui.GuiContainerVM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral1VM;
import com.vies.viesmachines.client.gui.buttons.GuiButtonGeneral2VM;
import com.vies.viesmachines.common.entity.machines.EntityMachineBase;
import com.vies.viesmachines.common.entity.machines.containers.ContainerMachineNoSlots;
import com.vies.viesmachines.network.NetworkHandler;
import com.vies.viesmachines.network.server.machine.gui.main.song.MessageHelperGuiMachineMainRecordDefault;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete1;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete2;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete3;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete4;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete5;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete6;
import com.vies.viesmachines.network.server.machine.gui.main.song.delete.MessageHelperGuiMachineMainRecordDelete7;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect1;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect2;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect3;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect4;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect5;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect6;
import com.vies.viesmachines.network.server.machine.gui.main.song.select.MessageHelperGuiMachineMainRecordSelect7;
import com.vies.viesmachines.network.server.machine.gui.navigation.MessageGuiMachineMenuMain;
import com.vies.viesmachines.proxy.ClientProxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class GuiMachineMenuMainSelectMusic extends GuiContainerVM {
	
	private final ResourceLocation TEXTURE = new ResourceLocation(References.MOD_ID + ":" + "textures/gui/container_machine_music.png");
	
	//private ArrayList<ResourceLocation> songs;
	//private GuiScrollingListVC songList;
	
    //private GuiScreen mainMenu;
    //private GuiScrollingList songInfo;
    //private int selected = -1;
    private ResourceLocation selectedSong;
    //private int listWidth;
    //private int buttonMargin = 1;
    
    private boolean recordSlot1Delete;
    private boolean recordSlot2Delete;
    private boolean recordSlot3Delete;
    private boolean recordSlot4Delete;
    private boolean recordSlot5Delete;
    private boolean recordSlot6Delete;
    private boolean recordSlot7Delete;
    
    public static int setSong;
    
    
    
	public GuiMachineMenuMainSelectMusic(IInventory playerInv, EntityMachineBase machineIn)
	{
		super(new ContainerMachineNoSlots(playerInv, machineIn), playerInv, machineIn);
		
        this.zLevel = 0.0F;
	}
	
	@Override
    public void initGui() 
    {
    	super.initGui();
    	
    	
    	
    	String empty_name = "[ " + References.localNameVC("viesmachines.main.empty") + " ]";
    	String confirm_name = References.localNameVC("viesmachines.main.confirmdelete") +"?";
    	
    	String slotName1 = "";
    	String slotName2 = "";
    	String slotName3 = "";
    	String slotName4 = "";
    	String slotName5 = "";
    	String slotName6 = "";
    	String slotName7 = "";
    	
    	
    	if (!this.machine.getLearnedRecordSlot1().equals(""))
    	{
    		slotName1 = References.localNameVC("item." + this.machine.getLearnedRecordSlot1() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot2().equals(""))
    	{
    		slotName2 = References.localNameVC("item." + this.machine.getLearnedRecordSlot2() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot3().equals(""))
    	{
    		slotName3 = References.localNameVC("item." + this.machine.getLearnedRecordSlot3() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot4().equals(""))
    	{
    		slotName4 = References.localNameVC("item." + this.machine.getLearnedRecordSlot4() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot5().equals(""))
    	{
    		slotName5 = References.localNameVC("item." + this.machine.getLearnedRecordSlot5() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot6().equals(""))
    	{
    		slotName6 = References.localNameVC("item." + this.machine.getLearnedRecordSlot6() + ".desc");
    	}
    	if (!this.machine.getLearnedRecordSlot7().equals(""))
    	{
    		slotName7 = References.localNameVC("item." + this.machine.getLearnedRecordSlot7() + ".desc");
    	}
    	
    	//--------------------------------------------------
    	
    	GuiVM.button501 = new GuiButtonGeneral1VM(501, this.guiLeft + 60, this.guiTop + 197, 56, 14, References.localNameVC("gui.done"), 0);
    	
    	GuiVM.buttonLearnedRecordSlot1 = new GuiButtonGeneral1VM(71, this.guiLeft + 46, this.guiTop +  69 + (16 * 0), 84, 14, slotName1, 0);
    	GuiVM.buttonLearnedRecordSlot2 = new GuiButtonGeneral1VM(72, this.guiLeft + 46, this.guiTop +  89 + (16 * 0), 84, 14, slotName2, 0);
    	GuiVM.buttonLearnedRecordSlot3 = new GuiButtonGeneral1VM(73, this.guiLeft + 46, this.guiTop +  89 + (16 * 1), 84, 14, slotName3, 0);
    	GuiVM.buttonLearnedRecordSlot4 = new GuiButtonGeneral1VM(74, this.guiLeft + 46, this.guiTop + 125 + (16 * 0), 84, 14, slotName4, 0);
    	GuiVM.buttonLearnedRecordSlot5 = new GuiButtonGeneral1VM(75, this.guiLeft + 46, this.guiTop + 125 + (16 * 1), 84, 14, slotName5, 0);
    	GuiVM.buttonLearnedRecordSlot6 = new GuiButtonGeneral1VM(76, this.guiLeft + 46, this.guiTop + 161 + (16 * 0), 84, 14, slotName6, 0);
    	GuiVM.buttonLearnedRecordSlot7 = new GuiButtonGeneral1VM(77, this.guiLeft + 46, this.guiTop + 161 + (16 * 1), 84, 14, slotName7, 0);
    	
    	GuiVM.buttonLearnedRecordSlot1Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop +  69 + (16 * 0), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot2Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop +  89 + (16 * 0), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot3Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop +  89 + (16 * 1), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot4Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop + 125 + (16 * 0), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot5Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop + 125 + (16 * 1), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot6Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop + 161 + (16 * 0), 84, 14, empty_name, 0);
    	GuiVM.buttonLearnedRecordSlot7Empty = new GuiButtonGeneral1VM(1, this.guiLeft + 46, this.guiTop + 161 + (16 * 1), 84, 14, empty_name, 0);
    	
    	GuiVM.buttonLearnedRecordSlot1Confirm = new GuiButtonGeneral2VM(81, this.guiLeft + 46, this.guiTop +  69 + (16 * 0), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot2Confirm = new GuiButtonGeneral2VM(82, this.guiLeft + 46, this.guiTop +  89 + (16 * 0), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot3Confirm = new GuiButtonGeneral2VM(83, this.guiLeft + 46, this.guiTop +  89 + (16 * 1), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot4Confirm = new GuiButtonGeneral2VM(84, this.guiLeft + 46, this.guiTop + 125 + (16 * 0), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot5Confirm = new GuiButtonGeneral2VM(85, this.guiLeft + 46, this.guiTop + 125 + (16 * 1), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot6Confirm = new GuiButtonGeneral2VM(86, this.guiLeft + 46, this.guiTop + 161 + (16 * 0), 84, 14, confirm_name, 0);
    	GuiVM.buttonLearnedRecordSlot7Confirm = new GuiButtonGeneral2VM(87, this.guiLeft + 46, this.guiTop + 161 + (16 * 1), 84, 14, confirm_name, 0);
    	
    	GuiVM.buttonLearnedRecordSlot1Delete = new GuiButtonGeneral1VM(21, this.guiLeft + 132, this.guiTop +  69 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot2Delete = new GuiButtonGeneral1VM(22, this.guiLeft + 132, this.guiTop +  89 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot3Delete = new GuiButtonGeneral1VM(23, this.guiLeft + 132, this.guiTop +  89 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot4Delete = new GuiButtonGeneral1VM(24, this.guiLeft + 132, this.guiTop + 125 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot5Delete = new GuiButtonGeneral1VM(25, this.guiLeft + 132, this.guiTop + 125 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot6Delete = new GuiButtonGeneral1VM(26, this.guiLeft + 132, this.guiTop + 161 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot7Delete = new GuiButtonGeneral1VM(27, this.guiLeft + 132, this.guiTop + 161 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	
    	GuiVM.buttonLearnedRecordSlot1Cancel = new GuiButtonGeneral1VM(31, this.guiLeft +  30, this.guiTop +  69 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot2Cancel = new GuiButtonGeneral1VM(32, this.guiLeft +  30, this.guiTop +  89 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot3Cancel = new GuiButtonGeneral1VM(33, this.guiLeft +  30, this.guiTop +  89 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot4Cancel = new GuiButtonGeneral1VM(34, this.guiLeft +  30, this.guiTop + 125 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot5Cancel = new GuiButtonGeneral1VM(35, this.guiLeft +  30, this.guiTop + 125 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot6Cancel = new GuiButtonGeneral1VM(36, this.guiLeft +  30, this.guiTop + 161 + (16 * 0), 14, 14, References.localNameVC(""), 2);
    	GuiVM.buttonLearnedRecordSlot7Cancel = new GuiButtonGeneral1VM(37, this.guiLeft +  30, this.guiTop + 161 + (16 * 1), 14, 14, References.localNameVC(""), 2);
    	
    	//--------------------------------------------------
    	
    	this.buttonList.add(GuiVM.button501);
    	
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot1Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot2Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot3Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot4Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot5Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot6Delete);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot7Delete);
    	
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot1Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot2Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot3Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot4Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot5Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot6Cancel);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot7Cancel);
    	
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot1Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot2Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot3Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot4Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot5Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot6Empty);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot7Empty);
    	
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot1);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot2);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot3);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot4);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot5);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot6);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot7);
    	
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot1Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot2Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot3Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot4Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot5Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot6Confirm);
    	this.buttonList.add(GuiVM.buttonLearnedRecordSlot7Confirm);
    	
    	//--------------------------------------------------
    	
    	GuiVM.buttonLearnedRecordSlot1Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot2Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot3Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot4Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot5Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot6Confirm.visible = false;
    	GuiVM.buttonLearnedRecordSlot7Confirm.visible = false;
    	
    	GuiVM.buttonLearnedRecordSlot1Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot2Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot3Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot4Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot5Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot6Empty.visible = false;
    	GuiVM.buttonLearnedRecordSlot7Empty.visible = false;
    	
    	GuiVM.buttonLearnedRecordSlot1Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot2Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot3Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot4Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot5Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot6Cancel.visible = false;
    	GuiVM.buttonLearnedRecordSlot7Cancel.visible = false;
    }
    
    @Override
    protected void actionPerformed(GuiButton button)
    {
    	super.actionPerformed(button);
        
    	// Back:
		if (button.id == 501)
	    {
			NetworkHandler.sendToServer(new MessageGuiMachineMenuMain());
	    }
		
		
        
		if (button.id == 21
		|| button.id == 31)
	    {
			this.recordSlot1Delete = !this.recordSlot1Delete;
			
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 22
		|| button.id == 32)
	    {
			this.recordSlot2Delete = !this.recordSlot2Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 23
		|| button.id == 33)
	    {
			this.recordSlot3Delete = !this.recordSlot3Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 24
		|| button.id == 34)
	    {
			this.recordSlot4Delete = !this.recordSlot4Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 25
		|| button.id == 35)
	    {
			this.recordSlot5Delete = !this.recordSlot5Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 26
		|| button.id == 36)
	    {
			this.recordSlot6Delete = !this.recordSlot6Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 27
		|| button.id == 37)
	    {
			this.recordSlot7Delete = !this.recordSlot7Delete;
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
	    }
		

		if (button.id == 81)
	    {
			
			//this.selectedSong = machine.getLearnedRecordSlot7();
			
			for(int i = 0; i < ClientProxy.musicListRecord.size(); i++)
			{
				if(ClientProxy.musicListRecord.get(i).toString().toLowerCase().contains(this.machine.getLearnedRecordSlot7().toString().toLowerCase()))
			    {
					this.setSong = i;
			    }
			}
			
			//if (this.machine.getLearnedRecordSlot1().contains(this.machine.getLearnedRecordSlot1()) == this.machine.getSelectedRecord())
			//{
			//	
			//TODO }
			
			
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete1());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 82)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete2());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 83)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete3());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 84)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete4());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 85)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete5());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 86)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete6());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		if (button.id == 87)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDelete7());
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordDefault());
			
			this.recordSlot1Delete = false;
			this.recordSlot2Delete = false;
			this.recordSlot3Delete = false;
			this.recordSlot4Delete = false;
			this.recordSlot5Delete = false;
			this.recordSlot6Delete = false;
			this.recordSlot7Delete = false;
	    }
		

        
		if (button.id == 71)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect1());
	    }
		if (button.id == 72)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect2());
	    }
		if (button.id == 73)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect3());
	    }
		if (button.id == 74)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect4());
	    }
		if (button.id == 75)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect5());
	    }
		if (button.id == 76)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect6());
	    }
		if (button.id == 77)
	    {
			NetworkHandler.sendToServer(new MessageHelperGuiMachineMainRecordSelect7());
	    }
		
		
		
        this.buttonList.clear();
        this.initGui();
        this.updateScreen();
    }
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
		// Binds the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the background texture:
		this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
		
    }
	
	@Override
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
	{


		//if (this.machine.getTierComponent() <= 1)
		{
			//TODO this.drawRect(30, 84, 140, 104, Color.BLUE.getRGB());
			
		}
		
		if (this.machine.getTierComponent() <= 0)
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 112-15, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Component Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 118-15, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_COMPONENT_TIER1.getUnlocalizedName() + ".name"), 0, 8, Color.YELLOW.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		if (this.machine.getTierComponent() <= 1)
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 112+30-9, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Component Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 118+30-9, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_COMPONENT_TIER2.getUnlocalizedName() + ".name"), 0, 8, Color.CYAN.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		if (this.machine.getTierComponent() <= 2)
		{
			// 'Requires':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 112+60-3, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, TextFormatting.BOLD + References.localNameVC("viesmachines.main.requires") + ":", 0, 0, Color.RED.getRGB());
			}
			GlStateManager.popMatrix();
			// 'Component Tier Item':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(55.5+33, 118+60-3, 0);
		        GlStateManager.scale(0.5F, 0.5F, 0.5F);
		        
		        this.centeredString(fontRenderer, References.localNameVC(ItemsVM.UPGRADE_COMPONENT_TIER3.getUnlocalizedName() + ".name"), 0, 8, Color.MAGENTA.getRGB());
			}
			GlStateManager.popMatrix();
		}
		
		
		// Binds the texture to use:
		GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
		this.mc.getTextureManager().bindTexture(TEXTURE);
		
		// Draws the Delete texture:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(134, 71, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
			
	        if (this.machine.getTierComponent() >= 0)
	        {
				if (!this.recordSlot1Delete
				&& !this.machine.getLearnedRecordSlot1().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 0), 236, 0, 20, 20);
				}
			}
			if (this.machine.getTierComponent() >= 1)
	        {
				if (!this.recordSlot2Delete
				&& !this.machine.getLearnedRecordSlot2().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 0) + 40, 236, 0, 20, 20);
				}
				if (!this.recordSlot3Delete
				&& !this.machine.getLearnedRecordSlot3().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 1) + 40, 236, 0, 20, 20);
				}
	        }
			if (this.machine.getTierComponent() >= 2)
	        {
				if (!this.recordSlot4Delete
				&& !this.machine.getLearnedRecordSlot4().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 0) + 112, 236, 0, 20, 20);
				}
				if (!this.recordSlot5Delete
				&& !this.machine.getLearnedRecordSlot5().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 1) + 112, 236, 0, 20, 20);
				}
	        }
			if (this.machine.getTierComponent() >= 3)
	        {
				if (!this.recordSlot6Delete
				&& !this.machine.getLearnedRecordSlot6().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 0) + 184, 236, 0, 20, 20);
				}
				if (!this.recordSlot7Delete
				&& !this.machine.getLearnedRecordSlot7().equals(""))
				{
					this.drawTexturedModalRect(0, (32 * 1) + 184, 236, 0, 20, 20);
				}
	        }
		}
		GlStateManager.popMatrix();
		
		// Draws the Cancel texture:
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(32, 71, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
			if (this.recordSlot1Delete)
			{
				this.drawTexturedModalRect(0, (32 * 0), 236, 20, 20, 20);
			}
			if (this.recordSlot2Delete)
			{
				this.drawTexturedModalRect(0, (32 * 0) + 40, 236, 20, 20, 20);
			}
			if (this.recordSlot3Delete)
			{
				this.drawTexturedModalRect(0, (32 * 1) + 40, 236, 20, 20, 20);
			}
			if (this.recordSlot4Delete)
			{
				this.drawTexturedModalRect(0, (32 * 0) + 112, 236, 20, 20, 20);
			}
			if (this.recordSlot5Delete)
			{
				this.drawTexturedModalRect(0, (32 * 1) + 112, 236, 20, 20, 20);
			}
			if (this.recordSlot6Delete)
			{
				this.drawTexturedModalRect(0, (32 * 0) + 184, 236, 20, 20, 20);
			}
			if (this.recordSlot7Delete)
			{
				this.drawTexturedModalRect(0, (32 * 1) + 184, 236, 20, 20, 20);
			}
		}
		GlStateManager.popMatrix();
		
		
		
		
		
		
		
		
		// 'Selected Record':
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(88, 29, 0);
	        GlStateManager.scale(0.5F, 0.5F, 0.5F);
	        
	        this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.selectsong.0"), 0, 0, Color.BLUE.getRGB());
		}
		GlStateManager.popMatrix();
		
		
		//LogHelper.info("1 - " +ForgeModIdHelper.getInstance().getModNameForModId("viesmachines"));
		
		
		
		
		
		
		if (this.machine.getSelectedRecord() >= 0)
		{
			
			for (ModContainer mod : Loader.instance().getModList())
	        {
				if (mod.getModId().equals(
						ClientProxy.musicListRecord
						.get(this.machine.getSelectedRecord()).getResourceDomain().toString()
						
						//"viesmachines"
						
						))
				{
					this.localizedModName = mod.getName();
				}
	        }
			//LogHelper.info(this.localizedModName);
			
			// 'Modid':
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(88, 38, 0);
		        GlStateManager.scale(0.75F, 0.75F, 0.75F);
		        
		        this.centeredString(fontRenderer, 
		        	this.stringToFlashGolden(this.localizedModName, 1, false, TextFormatting.GREEN, 0)
        		, 0, 0, Color.BLACK.getRGB());
			}
			GlStateManager.popMatrix();
			
			// Song:
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(88, 27.5+24, 0);
				GlStateManager.scale(0.75F, 0.75F, 0.75F);
				
				this.centeredString(fontRenderer, 
				this.stringToFlashGolden(
				References.localNameVC( "item." + 
				//TODO this.machine.currentMusicListRecord
				ClientProxy.musicListRecord
				.get(this.machine.getSelectedRecord()).getResourcePath().toString() + ".desc")
				, 1, false, TextFormatting.DARK_AQUA, 0)	
				, 0, 0, Color.BLUE.getRGB());
				
			}
			GlStateManager.popMatrix();
			
		}
		else
		{

			// Song:
			GlStateManager.pushMatrix();
			{
				GlStateManager.translate(88, 27.5+24, 0);
				GlStateManager.scale(0.75F, 0.75F, 0.75F);
				
				this.centeredString(fontRenderer, References.localNameVC("viesmachines.gui.selectsong.0"), 0, -13, Color.BLACK.getRGB());
				
				this.centeredString(fontRenderer, 
						References.localNameVC("--------")	
				, 0, 0, Color.RED.getRGB());
				
			}
			GlStateManager.popMatrix();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	@Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        //this.songList.drawScreen(mouseX, mouseY, partialTicks);
        
        //if (this.songInfo != null)
        //{
        //    this.songInfo.drawScreen(mouseX, mouseY, partialTicks);
        //}
        
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
	/*
    @Override
    public void handleMouseInput() throws IOException
    {
        int mouseX = Mouse.getEventX() * this.width / this.mc.displayWidth;
        int mouseY = this.height - Mouse.getEventY() * this.height / this.mc.displayHeight - 1;

        super.handleMouseInput();
        if (this.songInfo != null)
        {
        	this.songInfo.handleMouseInput(mouseX, mouseY);
        }
        
        //this.songList.handleMouseInput(mouseX, mouseY);
    }
    
    private void updateCache()
    {
        songInfo = null;
        
        if (selectedSong == null)
        {
        	return;
        }
        
        ResourceLocation logoPath = null;
        Dimension logoDims = new Dimension(0, 0);
        List<String> lines = new ArrayList<String>();
        
        for(int i = 0; i < 
        		//this.machine.currentMusicListRecord
        		ClientProxy.musicListRecord
        		
        		.size(); i++)
		{
			if(
					//TODO this.machine.currentMusicListRecord
					ClientProxy.musicListRecord
					.get(i).toString().toLowerCase().contains(selectedSong.toString().toLowerCase()))
		    {
				this.setSong = i;
				this.machine.setSelectedRecord(i);
				NetworkHandler.sendToServer(new MessageHelperGuiMachineMusicSet());
		    }
		}
    }
    */
    @Override
    protected void mouseClicked(int x, int y, int button) throws IOException
    {
        super.mouseClicked(x, y, button);
    }
    
    @Override
    protected void keyTyped(char c, int keyCode) throws IOException
    {
        super.keyTyped(c, keyCode);
    }
    
    public Minecraft getMinecraftInstance()
    {
        return mc;
    }
    /*
    public void selectModIndex(int index)
    {
        if (index == this.selected)
            return;
        this.selected = index;
        //this.selectedSong = (index >= 0 && index <= songs.size()) ? songs.get(selected) : null;

        //updateCache();
    }

    public boolean modIndexSelected(int index)
    {
        return index == selected;
    }
    */
    @Override
    public void updateScreen()
    {
        super.updateScreen();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        if (this.recordSlot1Delete)
        {
        	GuiVM.buttonLearnedRecordSlot1Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot1.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot1Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot1Cancel.visible = true;
        	
        	//this.recordSlot2Delete = false;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot1Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot1.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot1Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot1Cancel.visible = false;
        }
        
        
        
        if (this.recordSlot2Delete)
        {
        	GuiVM.buttonLearnedRecordSlot2Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot2.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot2Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot2Cancel.visible = true;
        	
        	//this.recordSlot1Delete = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot2Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot2.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot2Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot2Cancel.visible = false;
        }
        
        if (this.recordSlot3Delete)
        {
        	GuiVM.buttonLearnedRecordSlot3Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot3.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot3Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot3Cancel.visible = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot3Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot3.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot3Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot3Cancel.visible = false;
        }

        if (this.recordSlot4Delete)
        {
        	GuiVM.buttonLearnedRecordSlot4Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot4.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot4Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot4Cancel.visible = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot4Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot4.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot4Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot4Cancel.visible = false;
        }

        if (this.recordSlot5Delete)
        {
        	GuiVM.buttonLearnedRecordSlot5Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot5.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot5Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Cancel.visible = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot5Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot5.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot5Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot5Cancel.visible = false;
        }

        if (this.recordSlot6Delete)
        {
        	GuiVM.buttonLearnedRecordSlot6Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot6.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Cancel.visible = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot6Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot6.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot6Cancel.visible = false;
        }
        
        if (this.recordSlot7Delete)
        {
        	GuiVM.buttonLearnedRecordSlot7Confirm.visible = true;
        	GuiVM.buttonLearnedRecordSlot7.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Cancel.visible = true;
        }
        else
        {
        	GuiVM.buttonLearnedRecordSlot7Confirm.visible = false;
        	GuiVM.buttonLearnedRecordSlot7.visible = true;
        	
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = true;
        	GuiVM.buttonLearnedRecordSlot7Cancel.visible = false;
        }
        
        
        
        
        if (this.machine.getLearnedRecordSlot1().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot1Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot1.visible = false;
        	GuiVM.buttonLearnedRecordSlot1Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot1Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot1.visible = true;
        }
        if (this.machine.getLearnedRecordSlot2().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot2Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot2.visible = false;
        	GuiVM.buttonLearnedRecordSlot2Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot2Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot2.visible = true;
        }
        if (this.machine.getLearnedRecordSlot3().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot3Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot3.visible = false;
        	GuiVM.buttonLearnedRecordSlot3Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot3Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot3.visible = true;
        }
        if (this.machine.getLearnedRecordSlot4().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot4Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot4.visible = false;
        	GuiVM.buttonLearnedRecordSlot4Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot4Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot4.visible = true;
        }
        if (this.machine.getLearnedRecordSlot5().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot5Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot5.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot5Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot5.visible = true;
        }
        if (this.machine.getLearnedRecordSlot6().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot6Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot6.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot6Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot6.visible = true;
        }
        if (this.machine.getLearnedRecordSlot7().equals(""))
        {
        	GuiVM.buttonLearnedRecordSlot7Empty.visible = true;
        	GuiVM.buttonLearnedRecordSlot7.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = false;
        }
        else
        {

        	GuiVM.buttonLearnedRecordSlot7Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot7.visible = true;
        }
        
        
        
        
        if (this.machine.getTierComponent() <= 0)
        {
        	GuiVM.buttonLearnedRecordSlot2Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot3Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot4Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Empty.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot2Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot3Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot4Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = false;
        }
        if (this.machine.getTierComponent() <= 1)
        {
        	GuiVM.buttonLearnedRecordSlot4Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Empty.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot4Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot5Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = false;
        }
        if (this.machine.getTierComponent() <= 2)
        {
        	GuiVM.buttonLearnedRecordSlot6Empty.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Empty.visible = false;
        	
        	GuiVM.buttonLearnedRecordSlot6Delete.visible = false;
        	GuiVM.buttonLearnedRecordSlot7Delete.visible = false;
        }
        
        
        
        
        
        
        
        
        //LogHelper.info(this.machine.getSelectedRecord());
    }
    
    
    
    
    //==================================================
    /*
    private class Info extends GuiScrollingList
    {
        @Nullable
        private ResourceLocation logoPath;
        private Dimension logoDims;
        private List<ITextComponent> lines = null;

        public Info(int width, List<String> lines, @Nullable ResourceLocation logoPath, Dimension logoDims)
        {
            super(GuiMachineMenuMainSelectMusic.this.getMinecraftInstance(),
                  width,
                  GuiMachineMenuMainSelectMusic.this.height,
                  32, GuiMachineMenuMainSelectMusic.this.height - 88 + 4,
                  GuiMachineMenuMainSelectMusic.this.listWidth + 20, 60,
                  GuiMachineMenuMainSelectMusic.this.width,
                  GuiMachineMenuMainSelectMusic.this.height);
            this.lines    = resizeContent(lines);
            this.logoPath = logoPath;
            this.logoDims = logoDims;

            this.setHeaderInfo(true, getHeaderHeight());
        }

        @Override protected int getSize() { return 0; }
        @Override protected void elementClicked(int index, boolean doubleClick) { }
        @Override protected boolean isSelected(int index) { return false; }
        @Override protected void drawBackground() {}
        @Override protected void drawSlot(int slotIdx, int entryRight, int slotTop, int slotBuffer, Tessellator tess) { }

        private List<ITextComponent> resizeContent(List<String> lines)
        {
            List<ITextComponent> ret = new ArrayList<ITextComponent>();
            for (String line : lines)
            {
                if (line == null)
                {
                    ret.add(null);
                    continue;
                }

                ITextComponent chat = ForgeHooks.newChatWithLinks(line, false);
                int maxTextLength = this.listWidth - 8;
                if (maxTextLength >= 0)
                {
                    ret.addAll(GuiUtilRenderComponents.splitText(chat, maxTextLength, GuiMachineMenuMainSelectMusic.this.fontRenderer, false, true));
                }
            }
            return ret;
        }

        private int getHeaderHeight()
        {
          int height = 0;
          if (logoPath != null)
          {
              double scaleX = logoDims.width / 200.0;
              double scaleY = logoDims.height / 65.0;
              double scale = 1.0;
              if (scaleX > 1 || scaleY > 1)
              {
                  scale = 1.0 / Math.max(scaleX, scaleY);
              }
              logoDims.width *= scale;
              logoDims.height *= scale;

              height += logoDims.height;
              height += 10;
          }
          height += (lines.size() * 10);
          if (height < this.bottom - this.top - 8) height = this.bottom - this.top - 8;
          return height;
        }
        
        
        @Override
        protected void drawHeader(int entryRight, int relativeY, Tessellator tess)
        {
            int top = relativeY;

            if (logoPath != null)
            {
                GlStateManager.enableBlend();
                GuiMachineMenuMainSelectMusic.this.mc.renderEngine.bindTexture(logoPath);
                BufferBuilder wr = tess.getBuffer();
                int offset = (this.left + this.listWidth/2) - (logoDims.width / 2);
                wr.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
                wr.pos(offset,                  top + logoDims.height, zLevel).tex(0, 1).endVertex();
                wr.pos(offset + logoDims.width, top + logoDims.height, zLevel).tex(1, 1).endVertex();
                wr.pos(offset + logoDims.width, top,                   zLevel).tex(1, 0).endVertex();
                wr.pos(offset,                  top,                   zLevel).tex(0, 0).endVertex();
                tess.draw();
                GlStateManager.disableBlend();
                top += logoDims.height + 10;
            }

            for (ITextComponent line : lines)
            {
                if (line != null)
                {
                    GlStateManager.enableBlend();
                    GuiMachineMenuMainSelectMusic.this.fontRenderer.drawStringWithShadow(line.getFormattedText(), this.left + 4, top, 0xFFFFFF);
                    GlStateManager.disableAlpha();
                    GlStateManager.disableBlend();
                }
                top += 10;
            }
        }

        @Override
        protected void clickHeader(int x, int y)
        {
            int offset = y;
            if (logoPath != null) {
              offset -= logoDims.height + 10;
            }
            if (offset <= 0)
                return;

            int lineIdx = offset / 10;
            if (lineIdx >= lines.size())
                return;

            ITextComponent line = lines.get(lineIdx);
            if (line != null)
            {
                int k = -4;
                for (ITextComponent part : line) {
                    if (!(part instanceof TextComponentString))
                        continue;
                    k += GuiMachineMenuMainSelectMusic.this.fontRenderer.getStringWidth(((TextComponentString)part).getText());
                    if (k >= x)
                    {
                        GuiMachineMenuMainSelectMusic.this.handleComponentClick(part);
                        break;
                    }
                }
            }
        }
    }*/
}

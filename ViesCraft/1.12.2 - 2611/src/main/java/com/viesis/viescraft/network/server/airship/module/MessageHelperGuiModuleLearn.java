package com.viesis.viescraft.network.server.airship.module;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.client.gui.airship.main.GuiModuleMenu;
import com.viesis.viescraft.common.entity.airships.EntityAirshipBaseVC;
import com.viesis.viescraft.network.packet.MessageBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;

public class MessageHelperGuiModuleLearn extends MessageBase<MessageHelperGuiModuleLearn> {
	
	private int metaLearnModule;
	
	@Override
	public void fromBytes(ByteBuf buf) 
	{
		metaLearnModule = buf.readInt();
	}
	
	@Override
	public void toBytes(ByteBuf buf) 
	{
		buf.writeInt(GuiModuleMenu.learnModule);
	}
	
	@Override
	public void handleClientSide(MessageHelperGuiModuleLearn message, EntityPlayer player) 
	{
		
	}
	
	@Override
	public void handleServerSide(MessageHelperGuiModuleLearn message, EntityPlayer player) 
	{
		EntityAirshipBaseVC airship = (EntityAirshipBaseVC) player.getRidingEntity();
		
		airship.moduleActiveSlot1 = 0;
		
		if(message.metaLearnModule == EnumsVC.ModuleType.ALTITUDE_LESSER.getMetadata())
		{
			airship.learnedModuleAltitude = true;
			airship.selectedModuleAltitude = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.ALTITUDE_NORMAL.getMetadata())
		{
			airship.learnedModuleAltitude = true;
			airship.selectedModuleAltitude = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.ALTITUDE_GREATER.getMetadata())
		{
			airship.learnedModuleAltitude = true;
			airship.selectedModuleAltitude = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.SPEED_LESSER.getMetadata())
		{
			airship.learnedModuleSpeed = true;
			airship.selectedModuleSpeed = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.SPEED_NORMAL.getMetadata())
		{
			airship.learnedModuleSpeed = true;
			airship.selectedModuleSpeed = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.SPEED_GREATER.getMetadata())
		{
			airship.learnedModuleSpeed = true;
			airship.selectedModuleSpeed = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.STORAGE_LESSER.getMetadata())
		{
			airship.learnedModuleStorage = true;
			airship.selectedModuleStorage = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.STORAGE_NORMAL.getMetadata())
		{
			airship.learnedModuleStorage = true;
			airship.selectedModuleStorage = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.STORAGE_GREATER.getMetadata())
		{
			airship.learnedModuleStorage = true;
			airship.selectedModuleStorage = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.FUEL_LESSER.getMetadata())
		{
			airship.learnedModuleFuel = true;
			airship.selectedModuleFuel = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.FUEL_NORMAL.getMetadata())
		{
			airship.learnedModuleFuel = true;
			airship.selectedModuleFuel = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.FUEL_GREATER.getMetadata())
		{
			airship.learnedModuleFuel = true;
			airship.selectedModuleFuel = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.MUSIC_LESSER.getMetadata())
		{
			airship.learnedModuleMusic = true;
			airship.selectedModuleMusic = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.MUSIC_NORMAL.getMetadata())
		{
			airship.learnedModuleMusic = true;
			airship.selectedModuleMusic = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.MUSIC_GREATER.getMetadata())
		{
			airship.learnedModuleMusic = true;
			airship.selectedModuleMusic = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.CRUISE_LESSER.getMetadata())
		{
			airship.learnedModuleCruise = true;
			airship.selectedModuleCruise = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.CRUISE_NORMAL.getMetadata())
		{
			airship.learnedModuleCruise = true;
			airship.selectedModuleCruise = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.CRUISE_GREATER.getMetadata())
		{
			airship.learnedModuleCruise = true;
			airship.selectedModuleCruise = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.WATER_LESSER.getMetadata())
		{
			airship.learnedModuleWater = true;
			airship.selectedModuleWater = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.WATER_NORMAL.getMetadata())
		{
			airship.learnedModuleWater = true;
			airship.selectedModuleWater = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.WATER_GREATER.getMetadata())
		{
			airship.learnedModuleWater = true;
			airship.selectedModuleWater = 3;
			airship.inventory.extractItem(11, 1, false);
		}

		if(message.metaLearnModule == EnumsVC.ModuleType.INFINITE_FUEL_LESSER.getMetadata())
		{
			airship.learnedModuleFuelInfinite = true;
			airship.selectedModuleFuelInfinite = 1;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.INFINITE_FUEL_NORMAL.getMetadata())
		{
			airship.learnedModuleFuelInfinite = true;
			airship.selectedModuleFuelInfinite = 2;
			airship.inventory.extractItem(11, 1, false);
		}
		if(message.metaLearnModule == EnumsVC.ModuleType.INFINITE_FUEL_GREATER.getMetadata())
		{
			airship.learnedModuleFuelInfinite = true;
			airship.selectedModuleFuelInfinite = 3;
			airship.inventory.extractItem(11, 1, false);
		}
		
		
		
		//All active
		if(message.metaLearnModule == 50)
		{
			airship.learnedModuleAltitude = true;
			airship.selectedModuleAltitude = 3;
			airship.learnedModuleSpeed = true;
			airship.selectedModuleSpeed = 3;
			airship.learnedModuleStorage = true;
			airship.selectedModuleStorage = 3;
			airship.learnedModuleFuel = true;
			airship.selectedModuleFuel = 3;
			airship.learnedModuleMusic = true;
			airship.selectedModuleMusic = 3;
			airship.learnedModuleCruise = true;
			airship.selectedModuleCruise = 3;
			airship.learnedModuleWater = true;
			airship.selectedModuleWater = 3;
			airship.learnedModuleFuelInfinite = true;
			airship.selectedModuleFuelInfinite = 3;
			
			airship.inventory.extractItem(11, 1, false);
		}
	}
}

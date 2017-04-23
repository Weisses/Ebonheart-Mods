package com.viesis.viescraft.proxy;

import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.InitBlocksVCRender;
import com.viesis.viescraft.client.InitEntityVCRender;
import com.viesis.viescraft.client.InitItemsVCRender;
import com.viesis.viescraft.client.InitTileEntityVCRender;
import com.viesis.viescraft.client.InitSoundEventsVC;
import com.viesis.viescraft.client.gui.airship.GuiAirshipHUD;
import com.viesis.viescraft.network.NetworkHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		InitSoundEventsVC.registerSounds();
		InitItemsVCRender.registerItemRender();
		InitBlocksVCRender.registerBlockRender();
		InitEntityVCRender.registerEntityRender();
		InitTileEntityVCRender.registerTileEntityRender();
		
		Keybinds.init();
		//NetworkHandler.preInitClient();
		//InitItemsVCRender.registerItemRenderTEMP();
		//InitBlocksVCRender.registerBlockRenderTEMP();
		//InitEntityVCRender.registerEntityRenderTEMP();
		//InitTileEntityVCRender.registerTileEntityRenderTEMP();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		MinecraftForge.EVENT_BUS.register(new GuiAirshipHUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
}

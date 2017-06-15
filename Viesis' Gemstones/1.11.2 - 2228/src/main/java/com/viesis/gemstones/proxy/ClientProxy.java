package com.viesis.gemstones.proxy;

import com.viesis.gemstones.client.InitBlocksVGRender;
import com.viesis.gemstones.client.InitEntityVGRender;
import com.viesis.gemstones.client.InitItemsVGRender;
import com.viesis.gemstones.client.InitSoundEventsVG;
import com.viesis.gemstones.client.InitTileEntityVGRender;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		InitSoundEventsVG.registerSounds();
		InitItemsVGRender.registerItemRender();
		InitBlocksVGRender.registerBlockRender();
		InitEntityVGRender.registerEntityRender();
		InitTileEntityVGRender.registerTileEntityRender();
		
		//Keybinds.init();
		//NetworkHandler.preInitClient();
		//InitItemsEARender.registerItemRenderTEMP();
		//InitBlocksEARender.registerBlockRenderTEMP();
		//InitEntityEARender.registerEntityRenderTEMP();
		//InitTileEntityEARender.registerTileEntityRenderTEMP();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);

		//MinecraftForge.EVENT_BUS.register(new GuiAirshipHUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
}

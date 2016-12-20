package com.viesis.dismounter.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.viesis.dismounter.api.util.Keybinds;
import com.viesis.dismounter.client.InitItemsVDRender;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		
		Keybinds.init();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		InitItemsVDRender.registerRenders();
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
}

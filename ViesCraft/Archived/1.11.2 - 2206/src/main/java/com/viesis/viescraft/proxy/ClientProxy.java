package com.viesis.viescraft.proxy;

import com.viesis.viescraft.api.util.Keybinds;
import com.viesis.viescraft.client.InitBlocksVCRender;
import com.viesis.viescraft.client.InitEntityVCRender;
import com.viesis.viescraft.client.InitItemsVCRender;
import com.viesis.viescraft.client.InitTileEntityVCRender;
import com.viesis.viescraft.client.gui.v1.GuiV1HUD;
import com.viesis.viescraft.client.gui.v2.GuiV2HUD;
import com.viesis.viescraft.client.gui.v3.GuiV3HUD;
import com.viesis.viescraft.client.gui.v4.GuiV4HUD;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void preInit(FMLPreInitializationEvent event) 
	{
		super.preInit(event);
		
		InitItemsVCRender.registerItemRender();
		InitBlocksVCRender.registerBlockRender();
		InitEntityVCRender.registerEntityRender();
		InitTileEntityVCRender.registerTileEntityRender();
		
		Keybinds.init();
		
		//InitItemsVCRender.registerItemRenderTEMP();
		//InitBlocksVCRender.registerBlockRenderTEMP();
		//InitEntityVCRender.registerEntityRenderTEMP();
		//InitTileEntityVCRender.registerTileEntityRenderTEMP();
	}
	
	@Override
	public void init(FMLInitializationEvent event) 
	{
		super.init(event);
		
		MinecraftForge.EVENT_BUS.register(new GuiV1HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV2HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV3HUD());
		MinecraftForge.EVENT_BUS.register(new GuiV4HUD());
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) 
	{
		super.postInit(event);
	}
}

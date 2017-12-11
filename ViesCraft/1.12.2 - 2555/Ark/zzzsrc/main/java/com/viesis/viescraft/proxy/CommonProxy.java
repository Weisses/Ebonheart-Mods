package com.viesis.viescraft.proxy;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.utils.events.EventHandlerAirship;
import com.viesis.viescraft.common.utils.events.EventHandlerConfig;
import com.viesis.viescraft.init.InitEntityVC;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.NetworkHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		InitEntityVC.registerEntity();
		
		NetworkHandler.preInit();
		
		//InitItemsVC.registerItemTEMP();
		//InitBlocksVC.registerBlockTEMP();
		//InitTileEntitiesVC.registerTileEntityTEMP();
		//InitEntityVC.registerEntityTEMP();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		//InitAchievementsVC.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersVC());
		//MinecraftForge.EVENT_BUS.register(new EventHandlerAchievement());
		
		MinecraftForge.EVENT_BUS.register(new EventHandlerConfig());
		MinecraftForge.EVENT_BUS.register(new EventHandlerAirship());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		//RecipeRemoverVC.removeRecipe();
	}
}

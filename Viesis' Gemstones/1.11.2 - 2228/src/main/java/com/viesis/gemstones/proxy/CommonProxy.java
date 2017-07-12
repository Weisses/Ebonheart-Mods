package com.viesis.gemstones.proxy;

import com.viesis.gemstones.api.References;
import com.viesis.gemstones.common.world.WorldGeneratorVG;
import com.viesis.gemstones.init.InitBlocksVG;
import com.viesis.gemstones.init.InitEntityVG;
import com.viesis.gemstones.init.InitItemsVG;
import com.viesis.gemstones.init.InitRecipesVG;
import com.viesis.gemstones.init.InitTileEntitiesVG;
import com.viesis.gemstones.network.GuiHandler;
import com.viesis.gemstones.network.NetworkHandler;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		//SoundEventsEA.registerSounds();

		InitItemsVG.registerItem();
		InitBlocksVG.registerBlock();
		InitTileEntitiesVG.registerTileEntity();
		InitEntityVG.registerEntity();
		
		NetworkHandler.preInit();
		
		//InitItemsVC.registerItemTEMP();
		//InitBlocksVC.registerBlockTEMP();
		//InitTileEntitiesVC.registerTileEntityTEMP();
		//InitEntityVC.registerEntityTEMP();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		InitRecipesVG.initShapedRecipe();
		
		//InitAchievementsVC.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersVC());
		//MinecraftForge.EVENT_BUS.register(new EventHandlerAchievement());
		//MinecraftForge.EVENT_BUS.register(new EventHandlerConfig());
		//MinecraftForge.EVENT_BUS.register(new EventHandlerAirship());
		
		//NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
		
		//////////////////////////////////////////////////WorldChestHooks.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersEA());
		//MinecraftForge.EVENT_BUS.register(new ArmorBuffHandler());
	    
		
		GameRegistry.registerWorldGenerator(new WorldGeneratorVG(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(References.MOD_ID, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
}

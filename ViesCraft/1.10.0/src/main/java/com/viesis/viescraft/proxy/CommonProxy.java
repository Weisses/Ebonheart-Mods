package com.viesis.viescraft.proxy;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.common.AchievementTriggersVC;
import com.viesis.viescraft.common.utils.events.ArmorBuffHandler;
import com.viesis.viescraft.common.utils.gui.GuiHandler;
import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitEntityVC;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.init.InitRecipesVC;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		//SoundEventsEA.registerSounds();
		
		InitItemsVC.preInit();
		//InitItemsEA.register();
		//InitBlocksEA.preInit();
		InitEntityVC.preInit();
		
		
		//=======================================//
		//InitTileEntitiesEA.init();
		//InitTileEntitiesEA.register();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		InitRecipesVC.initShapedRecipe();
		InitRecipesVC.initShapelessRecipe();
		//InitRecipesEA.initSmeltingRecipe();
		InitAchievementsVC.init();
		
		//WorldChestHooks.init();
		
		MinecraftForge.EVENT_BUS.register(new AchievementTriggersVC());
		MinecraftForge.EVENT_BUS.register(new ArmorBuffHandler());
	    
		
		//GameRegistry.registerWorldGenerator(new WorldGeneratorEA(), 0);
		NetworkRegistry.INSTANCE.registerGuiHandler(ViesCraft.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
	
	//public void generateSprintParticles(Entity entity) { }
	
	//public void generateUnholyParticles(Entity entity) { }
	
	//public void generateFlightParticles(Entity entity) { }
	
	//public void generateEnchEbonParticles(Entity entity) { }
	
	
}

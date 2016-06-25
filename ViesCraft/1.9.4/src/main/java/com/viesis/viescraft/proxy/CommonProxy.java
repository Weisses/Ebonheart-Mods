package com.viesis.viescraft.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.viesis.viescraft.api.util.MovementControl;
import com.viesis.viescraft.init.InitEntityEA;
import com.viesis.viescraft.init.InitItemsEA;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		//SoundEventsEA.registerSounds();
		
		InitItemsEA.preInit();
		//InitItemsEA.register();
		//InitBlocksEA.preInit();
		InitEntityEA.preInit();
		
		
		//=======================================//
		//InitTileEntitiesEA.init();
		//InitTileEntitiesEA.register();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		//InitRecipesEA.initShapedRecipe();
		//InitRecipesEA.initShapelessRecipe();
		//InitRecipesEA.initSmeltingRecipe();
		//InitAchievementsEA.init();
		
		//WorldChestHooks.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersEA());
		//MinecraftForge.EVENT_BUS.register(new ArmorBuffHandler());
	    
		
		//GameRegistry.registerWorldGenerator(new WorldGeneratorEA(), 0);
		//NetworkRegistry.INSTANCE.registerGuiHandler(EbonArtsMod.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
	
	//public void generateSprintParticles(Entity entity) { }
	
	//public void generateUnholyParticles(Entity entity) { }
	
	//public void generateFlightParticles(Entity entity) { }
	
	//public void generateEnchEbonParticles(Entity entity) { }
	
	
}

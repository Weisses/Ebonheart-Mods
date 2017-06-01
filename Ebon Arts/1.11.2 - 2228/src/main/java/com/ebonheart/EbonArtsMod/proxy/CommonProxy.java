package com.ebonheart.EbonArtsMod.proxy;

import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.AchievementTriggersEA;
import com.ebonheart.EbonArtsMod.common.utils.SoundEventsEA;
import com.ebonheart.EbonArtsMod.common.utils.events.ArmorBuffHandler;
import com.ebonheart.EbonArtsMod.common.utils.gui.GuiHandler;
import com.ebonheart.EbonArtsMod.common.world.WorldGeneratorEA;
import com.ebonheart.EbonArtsMod.init.InitAchievementsEA;
import com.ebonheart.EbonArtsMod.init.InitBlocksEA;
import com.ebonheart.EbonArtsMod.init.InitEntityEA;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;
import com.ebonheart.EbonArtsMod.init.InitRecipesEA;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		SoundEventsEA.registerSounds();
		
		InitItemsEA.registerItem();
		InitBlocksEA.registerBlock();
		//InitEntityEA.preInit();
		
		
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
		
		//////////////////////////////////////////////////WorldChestHooks.init();
		
		//MinecraftForge.EVENT_BUS.register(new AchievementTriggersEA());
		//MinecraftForge.EVENT_BUS.register(new ArmorBuffHandler());
	    
		
		//GameRegistry.registerWorldGenerator(new WorldGeneratorEA(), 0);
		//NetworkRegistry.INSTANCE.registerGuiHandler(EbonArtsMod.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		
	}
	
	public void generateSprintParticles(Entity entity) { }
	
	public void generateUnholyParticles(Entity entity) { }
	
	public void generateFlightParticles(Entity entity) { }
	
	public void generateEnchEbonParticles(Entity entity) { }
	
	
}

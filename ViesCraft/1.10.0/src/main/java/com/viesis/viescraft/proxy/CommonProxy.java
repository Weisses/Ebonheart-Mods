package com.viesis.viescraft.proxy;

import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.api.compat.jei.ViesCraftPlugin;
import com.viesis.viescraft.common.AchievementTriggersVC;
import com.viesis.viescraft.common.tileentity.TileEntityAirshipWorkbench;
import com.viesis.viescraft.common.utils.events.EventHandlerAchievement;
import com.viesis.viescraft.common.utils.events.EventHandlerConfig;
import com.viesis.viescraft.common.utils.events.ItemHUDactivator;
import com.viesis.viescraft.init.InitAchievementsVC;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitEntityVC;
import com.viesis.viescraft.init.InitItemsVC;
import com.viesis.viescraft.init.InitRecipesVC;
import com.viesis.viescraft.init.InitTileEntitiesVC;
import com.viesis.viescraft.network.GuiHandler;
import com.viesis.viescraft.network.NetworkHandler;

public class CommonProxy {
	
	//public static ItemHUDactivator itemHUDactivator;
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		//SoundEventsEA.registerSounds();
		InitItemsVC.preInit();
		InitBlocksVC.preInit();
		InitTileEntitiesVC.preInit();
		InitEntityVC.preInit();
		
		NetworkHandler.preInit();
		
		
		
		//itemHUDactivator = (ItemHUDactivator)(new ItemHUDactivator().setUnlocalizedName("mbe40_hud_overlay_item"));
	    //GameRegistry.registerItem(itemHUDactivator, "mbe40_hud_overlay_item");
		
	}
	
	public void init(FMLInitializationEvent event) 
	{
		InitRecipesVC.initShapedRecipe();
		InitRecipesVC.initShapelessRecipe();
		InitAchievementsVC.init();
		
		
		MinecraftForge.EVENT_BUS.register(new AchievementTriggersVC());
		MinecraftForge.EVENT_BUS.register(new EventHandlerAchievement());
		MinecraftForge.EVENT_BUS.register(new EventHandlerConfig());
		
		NetworkRegistry.INSTANCE.registerGuiHandler(Reference.MOD_ID, new GuiHandler());
		
		//GameRegistry.registerWorldGenerator(new WorldGeneratorEA(), 0);
		//NetworkRegistry.INSTANCE.registerGuiHandler(ViesCraft.instance, new GuiHandler());
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		ViesCraftPlugin.removeRecipe();
	}
	
	public void generateSmokeParticles(Entity entity) { }
	//public void generateSprintParticles(Entity entity) { }
	//public void generateUnholyParticles(Entity entity) { }
	//public void generateFlightParticles(Entity entity) { }
	//public void generateEnchEbonParticles(Entity entity) { }
}

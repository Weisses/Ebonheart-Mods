package com.viesis.dismounter.proxy;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

import com.viesis.dismounter.api.Reference;
import com.viesis.dismounter.init.InitItemsVD;
import com.viesis.dismounter.init.InitRecipesVD;

public class CommonProxy {
	
	public void preInit(FMLPreInitializationEvent event) 
	{
		InitItemsVD.preInit();
	}
	
	public void init(FMLInitializationEvent event) 
	{
		InitRecipesVD.initShapedRecipe();
		InitRecipesVD.initShapelessRecipe();
		
	}
	
	public void postInit(FMLPostInitializationEvent event) 
	{
		//RecipeRemoverVC.removeRecipe();
	}
	
	public void generateSmokeParticles(Entity entity) { }
	//public void generateSprintParticles(Entity entity) { }
	//public void generateUnholyParticles(Entity entity) { }
	//public void generateFlightParticles(Entity entity) { }
	//public void generateEnchEbonParticles(Entity entity) { }
}

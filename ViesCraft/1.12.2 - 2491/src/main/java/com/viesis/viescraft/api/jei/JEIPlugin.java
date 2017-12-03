package com.viesis.viescraft.api.jei;

import javax.annotation.Nonnull;

import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

import mezz.jei.api.IItemBlacklist;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	
	@Override
	public void register(@Nonnull IModRegistry registry) 
	{
		//Adds all recipes in the crafting manager.
        //registry.addRecipes(CraftingManagerVC.getInstance().getRecipeList());
		
		//Adds my Airship Workbench to the list with the vanilla crafting table.
		registry.addRecipeCategoryCraftingItem(new ItemStack(InitBlocksVC.airship_workbench), VanillaRecipeCategoryUid.CRAFTING);
		
		//Adds items with no recipes to the black list.
		IItemBlacklist itemBlacklist = registry.getJeiHelpers().getItemBlacklist();
		
		//Adds the recipe transfer handlers.
		IRecipeTransferRegistry recipeTranferRegistry = registry.getRecipeTransferRegistry();
		
		//Items to be blacklisted.
		for (EnumsVC.Achievement meta : EnumsVC.Achievement.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.achievement_airship, 1, meta.getMetadata()));
    	}
		
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.guidebook_controls));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.guidebook_socket));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.guidebook_paint));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_entity_airship));
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_airship_v1, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_airship_v2, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_airship_v3, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_airship_v4, 1, ii));
    	}
		
		for (EnumsVC.AirshipBalloon meta : EnumsVC.AirshipBalloon.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_balloon_pattern, 1, meta.getMetadata()));
    	}
		
		for (EnumsVC.AirshipModule meta : EnumsVC.AirshipModule.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_module, 1, meta.getMetadata()));
    	}
		
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_dismounter));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.item_balloon_colorizer));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_balloon_pattern));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 0));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 1));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 2));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 3));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 4));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.airship_baseframe, 1, 5));
		
		
		
		//Adds "+" sign capability.
		recipeTranferRegistry.addRecipeTransferHandler(ContainerAirshipWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
	}
	
	@Override
	public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) 
	{
		
	}
	
	@Override
	public void registerIngredients(IModIngredientRegistration registry) 
	{
		
	}
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) 
	{
		
	}
}

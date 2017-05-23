package com.viesis.viescraft.api.jei;

import javax.annotation.Nonnull;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IIngredientBlacklist;
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
        registry.addRecipes(CraftingManagerVC.getInstance().getRecipeList());
		
		//Adds my Airship Workbench to the list with the vanilla crafting table.
		registry.addRecipeCategoryCraftingItem(new ItemStack(InitBlocksVC.airship_workbench), VanillaRecipeCategoryUid.CRAFTING);
		
		//Adds items with no recipes to the black list.
		IIngredientBlacklist itemBlacklist = registry.getJeiHelpers().getIngredientBlacklist();
		
		//Adds the recipe transfer handlers.
		IRecipeTransferRegistry recipeTranferRegistry = registry.getRecipeTransferRegistry();
		
		//Items to be blacklisted.
		for (int ii = 0; ii < 8; ++ii)
    	{
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.achievement_airship, 1, ii));
    	}
		
		itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_entity_airship));
		
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

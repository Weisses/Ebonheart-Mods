package com.viesis.viescraft.api.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.init.InitBlocksVC;

@mezz.jei.api.JEIPlugin
public class JEIPlugin implements IModPlugin {
	
	@Override
	public void register(@Nonnull IModRegistry registry) 
	{
		//Adds all recipes in the crafting manager
        registry.addRecipes(CraftingManagerVC.getInstance().getRecipeList());
		
		//Adds my Airship Workbench to the list with the vanilla crafting table
		registry.addRecipeCategoryCraftingItem(new ItemStack(InitBlocksVC.airship_workbench), VanillaRecipeCategoryUid.CRAFTING);
	}
	
	//@Override
	//public void registerItemSubtypes(ISubtypeRegistry subtypeRegistry) 
	//{
	//	
	//}
	
	//@Override
	//public void registerIngredients(IModIngredientRegistration registry) 
	//{
	//	
	//}
	
	@Override
	public void onRuntimeAvailable(IJeiRuntime jeiRuntime) 
	{
		
	}
}

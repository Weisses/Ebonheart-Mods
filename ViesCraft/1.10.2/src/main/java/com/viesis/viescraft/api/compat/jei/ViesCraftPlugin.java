package com.viesis.viescraft.api.compat.jei;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Nonnull;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;

import mezz.jei.api.IJeiHelpers;
import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;

@JEIPlugin
public class ViesCraftPlugin implements IModPlugin {

	@Override
	public void register(@Nonnull IModRegistry registry) {
		IJeiHelpers jeiHelpers = registry.getJeiHelpers();

		
		
		registry.addRecipes(CraftingManagerVC.getInstance().getRecipeList());
		
	}

	@Override
	public void onRuntimeAvailable(@Nonnull IJeiRuntime jeiRuntime) {}

}

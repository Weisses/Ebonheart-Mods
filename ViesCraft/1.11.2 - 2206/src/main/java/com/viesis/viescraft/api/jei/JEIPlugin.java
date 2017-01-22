package com.viesis.viescraft.api.jei;

import javax.annotation.Nonnull;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.VanillaRecipeCategoryUid;
import net.minecraft.item.ItemStack;

import com.viesis.viescraft.common.items.crafting.CraftingManagerVC;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

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
		
		//Items to be blacklisted.
		for (int ii = 0; ii < 18; ++ii)
    	{
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_wood0, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_iron, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_redstone, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_gold, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_lapislazuli, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_obsidian, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_diamond, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_emerald, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_netherbrick, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v1_purpur, 1, ii));
			
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_wood0, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_iron, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_redstone, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_gold, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_lapislazuli, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_obsidian, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_diamond, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_emerald, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_netherbrick, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v2_purpur, 1, ii));
			
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_wood0, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_iron, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_redstone, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_gold, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_lapislazuli, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_obsidian, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_diamond, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_emerald, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_netherbrick, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v3_purpur, 1, ii));
			
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_wood0, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_iron, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_redstone, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_gold, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_lapislazuli, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_obsidian, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_diamond, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_emerald, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_netherbrick, 1, ii));
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_airship_v4_purpur, 1, ii));
		}
		
		for (int ii = 0; ii < 8; ++ii)
    	{
			itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.achievement_airship, 1, ii));
    	}
		
		itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.item_entity_airship));
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

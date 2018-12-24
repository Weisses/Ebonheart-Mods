package com.vies.viesmachines.api.jei;

import com.vies.viesmachines.api.ItemsVM;

import mezz.jei.api.IJeiRuntime;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.IModRegistry;
import mezz.jei.api.ISubtypeRegistry;
import mezz.jei.api.JEIPlugin;
import mezz.jei.api.ingredients.IIngredientBlacklist;
import mezz.jei.api.ingredients.IModIngredientRegistration;
import mezz.jei.api.recipe.transfer.IRecipeTransferRegistry;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

@JEIPlugin
public class JEIPluginVC implements IModPlugin {
	
	@Override
	public void register(IModRegistry registry) 
	{
		//Adds items with no recipes to the black list.
		IIngredientBlacklist itemBlacklist = registry.getJeiHelpers().getIngredientBlacklist();
		
		itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVM.PARTICLE_BULLET_NORMAL, 1, OreDictionary.WILDCARD_VALUE));
		itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVM.PARTICLE_BULLET_ELECTRICAL, 1, OreDictionary.WILDCARD_VALUE));
		itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVM.PARTICLE_BULLET_EXPLOSIVE, 1, OreDictionary.WILDCARD_VALUE));
		itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVM.PARTICLE_STATIC_CHARGE, 1, OreDictionary.WILDCARD_VALUE));
		
		//itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVC.ACHIEVEMENT_AIRSHIP, 1, OreDictionary.WILDCARD_VALUE));
		//itemBlacklist.addIngredientToBlacklist(new ItemStack(ItemsVC.ITEM_ENTITY_AIRSHIP, 1, OreDictionary.WILDCARD_VALUE));
		
		//Adds my Airship Workbench to the list with the vanilla crafting table.
		//registry.addRecipeCatalyst(new ItemStack(BlocksVC.AIRSHIP_WORKBENCH), VanillaRecipeCategoryUid.CRAFTING);
		
		//Adds the recipe transfer handlers.
		IRecipeTransferRegistry recipeTranferRegistry = registry.getRecipeTransferRegistry();
		
		//Adds "+" sign capability.
		//recipeTranferRegistry.addRecipeTransferHandler(ContainerAirshipWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
		
		//Adds all recipes in the crafting manager. Not used since VC 5.0.0
        //registry.addRecipes(CraftingManagerVC.getInstance().getRecipeList());
		
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

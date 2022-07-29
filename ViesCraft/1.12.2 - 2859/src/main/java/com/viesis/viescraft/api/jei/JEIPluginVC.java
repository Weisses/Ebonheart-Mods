package com.viesis.viescraft.api.jei;

import com.viesis.viescraft.common.tileentity.ContainerAirshipWorkbench;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;


import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

//@JEIPlugin
public class JEIPluginVC //implements IModPlugin
{
	/*
	@Override
	public void register(IModRegistry registry) 
	{
		//Adds items with no recipes to the black list.
		IIngredientBlacklist itemBlacklist = registry.getJeiHelpers().getIngredientBlacklist();
		
		itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.ACHIEVEMENT_AIRSHIP, 1, OreDictionary.WILDCARD_VALUE));
		itemBlacklist.addIngredientToBlacklist(new ItemStack(InitItemsVC.ITEM_ENTITY_AIRSHIP, 1, OreDictionary.WILDCARD_VALUE));
		
		//Adds my Airship Workbench to the list with the vanilla crafting table.
		registry.addRecipeCatalyst(new ItemStack(InitBlocksVC.AIRSHIP_WORKBENCH), VanillaRecipeCategoryUid.CRAFTING);
		
		//Adds the recipe transfer handlers.
		IRecipeTransferRegistry recipeTranferRegistry = registry.getRecipeTransferRegistry();
		
		//Adds "+" sign capability.
		recipeTranferRegistry.addRecipeTransferHandler(ContainerAirshipWorkbench.class, VanillaRecipeCategoryUid.CRAFTING, 1, 9, 10, 36);
		
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
		
	}*/
}

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
		registry.addRecipeCategoryCraftingItem(new ItemStack(InitBlocksVC.AIRSHIP_WORKBENCH), VanillaRecipeCategoryUid.CRAFTING);
		
		//Adds items with no recipes to the black list.
		IItemBlacklist itemBlacklist = registry.getJeiHelpers().getItemBlacklist();
		
		//Adds the recipe transfer handlers.
		IRecipeTransferRegistry recipeTranferRegistry = registry.getRecipeTransferRegistry();
		
		//Items to be blacklisted.
		for (EnumsVC.Achievement meta : EnumsVC.Achievement.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ACHIEVEMENT_AIRSHIP, 1, meta.getMetadata()));
    	}
		
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.GUIDEBOOK_CONTROL));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.GUIDEBOOK_SOCKET));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.GUIDEBOOK_PAINT));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_ENTITY_AIRSHIP));
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V3, 1, ii));
    	}
		
		for (int ii = 0; ii < 30; ++ii)
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V4, 1, ii));
    	}
		
		for (EnumsVC.AirshipBalloon meta : EnumsVC.AirshipBalloon.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, meta.getMetadata()));
    	}
		
		for (EnumsVC.AirshipModule meta : EnumsVC.AirshipModule.values())
    	{
			itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, meta.getMetadata()));
    	}
		
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_DISMOUNTER));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.ITEM_BALLOON_COLORIZER));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 0));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 1));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 2));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 3));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 4));
		itemBlacklist.addItemToBlacklist(new ItemStack(InitItemsVC.AIRSHIP_BASEFRAME, 1, 5));
		
		
		
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

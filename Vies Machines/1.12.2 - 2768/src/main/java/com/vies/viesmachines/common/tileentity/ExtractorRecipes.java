package com.vies.viesmachines.common.tileentity;

import java.util.Random;

import com.vies.viesmachines.api.ItemsVM;

import net.minecraft.item.ItemStack;

public class ExtractorRecipes {
	
    private static final ExtractorRecipes CUTTING_BASE = new ExtractorRecipes();
    
    /** Returns an instance of GemRecipes. */
    public static ExtractorRecipes instance()
    {
        return CUTTING_BASE;
    }
    
    public final static ItemStack[] CUT_GEM_OUTPUT = new ItemStack[] 
	{
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1),
		new ItemStack(ItemsVM.XEGONITE, 1)
	};
    
    /** Returns a random gem from the gem array. */
    public static ItemStack getRandomGem(ItemStack[] array) 
    {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
}

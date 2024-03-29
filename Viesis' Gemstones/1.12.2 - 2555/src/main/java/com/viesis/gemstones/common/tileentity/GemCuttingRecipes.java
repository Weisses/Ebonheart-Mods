package com.viesis.gemstones.common.tileentity;

import java.util.Random;

import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.item.ItemStack;

public class GemCuttingRecipes {
	
    private static final GemCuttingRecipes CUTTING_BASE = new GemCuttingRecipes();
    //private final Map<ItemStack, ItemStack> smeltingList = Maps.<ItemStack, ItemStack>newHashMap();
    //private final Map<ItemStack, Float> experienceList = Maps.<ItemStack, Float>newHashMap();
    
    /**
     * Returns an instance of GemRecipes.
     */
    public static GemCuttingRecipes instance()
    {
        return CUTTING_BASE;
    }
    
    public final static ItemStack[] CUT_GEM_OUTPUT = new ItemStack[] 
	{
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 0),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 1),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 2),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 3),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 4),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 5),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 6),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 7),
		new ItemStack(InitItemsVG.GEMSTONE_ITEM_BASIC_V1, 1, 8)
	};
    
    /**
     * Returns a random gem from the gem array.
     */
    public static ItemStack getRandomGem(ItemStack[] array) 
    {
        int rnd = new Random().nextInt(array.length);
        return array[rnd];
    }
    
    /**
    private GemCuttingRecipes()
    {
    	this.addSmelting(Items.STICK, new ItemStack(InitItemsVG.gemstone_item_basic_v1), 0.1F);
    	
    	this.addSmeltingRecipeForBlock(Blocks.IRON_ORE, new ItemStack(Items.IRON_INGOT), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.GOLD_ORE, new ItemStack(Items.GOLD_INGOT), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.DIAMOND_ORE, new ItemStack(Items.DIAMOND), 1.0F);
        this.addSmeltingRecipeForBlock(Blocks.SAND, new ItemStack(Blocks.GLASS), 0.1F);
        this.addSmelting(Items.PORKCHOP, new ItemStack(Items.COOKED_PORKCHOP), 0.35F);
        this.addSmelting(Items.BEEF, new ItemStack(Items.COOKED_BEEF), 0.35F);
        this.addSmelting(Items.CHICKEN, new ItemStack(Items.COOKED_CHICKEN), 0.35F);
        this.addSmelting(Items.RABBIT, new ItemStack(Items.COOKED_RABBIT), 0.35F);
        this.addSmelting(Items.MUTTON, new ItemStack(Items.COOKED_MUTTON), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.COBBLESTONE, new ItemStack(Blocks.STONE), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.DEFAULT_META), new ItemStack(Blocks.STONEBRICK, 1, BlockStoneBrick.CRACKED_META), 0.1F);
        this.addSmelting(Items.CLAY_BALL, new ItemStack(Items.BRICK), 0.3F);
        this.addSmeltingRecipeForBlock(Blocks.CLAY, new ItemStack(Blocks.HARDENED_CLAY), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.CACTUS, new ItemStack(Items.DYE, 1, EnumDyeColor.GREEN.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.LOG, new ItemStack(Items.COAL, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.LOG2, new ItemStack(Items.COAL, 1, 1), 0.15F);
        this.addSmeltingRecipeForBlock(Blocks.EMERALD_ORE, new ItemStack(Items.EMERALD), 1.0F);
        this.addSmelting(Items.POTATO, new ItemStack(Items.BAKED_POTATO), 0.35F);
        this.addSmeltingRecipeForBlock(Blocks.NETHERRACK, new ItemStack(Items.NETHERBRICK), 0.1F);
        this.addSmeltingRecipe(new ItemStack(Blocks.SPONGE, 1, 1), new ItemStack(Blocks.SPONGE, 1, 0), 0.15F);
        this.addSmelting(Items.CHORUS_FRUIT, new ItemStack(Items.CHORUS_FRUIT_POPPED), 0.1F);

        for (ItemFishFood.FishType itemfishfood$fishtype : ItemFishFood.FishType.values())
        {
            if (itemfishfood$fishtype.canCook())
            {
                this.addSmeltingRecipe(new ItemStack(Items.FISH, 1, itemfishfood$fishtype.getMetadata()), new ItemStack(Items.COOKED_FISH, 1, itemfishfood$fishtype.getMetadata()), 0.35F);
            }
        }

        this.addSmeltingRecipeForBlock(Blocks.COAL_ORE, new ItemStack(Items.COAL), 0.1F);
        this.addSmeltingRecipeForBlock(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE), 0.7F);
        this.addSmeltingRecipeForBlock(Blocks.LAPIS_ORE, new ItemStack(Items.DYE, 1, EnumDyeColor.BLUE.getDyeDamage()), 0.2F);
        this.addSmeltingRecipeForBlock(Blocks.QUARTZ_ORE, new ItemStack(Items.QUARTZ), 0.2F);
        this.addSmelting(Items.CHAINMAIL_HELMET, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.CHAINMAIL_CHESTPLATE, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.CHAINMAIL_LEGGINGS, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.CHAINMAIL_BOOTS, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_PICKAXE, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_SHOVEL, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_AXE, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_HOE, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_SWORD, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_HELMET, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_CHESTPLATE, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_LEGGINGS, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_BOOTS, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.IRON_HORSE_ARMOR, new ItemStack(Items.field_191525_da), 0.1F);
        this.addSmelting(Items.GOLDEN_PICKAXE, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_SHOVEL, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_AXE, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_HOE, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_SWORD, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_HELMET, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_CHESTPLATE, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_LEGGINGS, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_BOOTS, new ItemStack(Items.GOLD_NUGGET), 0.1F);
        this.addSmelting(Items.GOLDEN_HORSE_ARMOR, new ItemStack(Items.GOLD_NUGGET), 0.1F);
    }
*/
    /**
     * Adds a smelting recipe, where the input item is an instance of Block.
     */
/**    public void addSmeltingRecipeForBlock(Block input, ItemStack stack, float experience)
    {
        this.addSmelting(Item.getItemFromBlock(input), stack, experience);
    }

    /**
     * Adds a smelting recipe using an Item as the input item.
     */
/**    public void addSmelting(Item input, ItemStack stack, float experience)
    {
        this.addSmeltingRecipe(new ItemStack(input, 1, 32767), stack, experience);
    }

    /**
     * Adds a smelting recipe using an ItemStack as the input for the recipe.
     */
/**    public void addSmeltingRecipe(ItemStack input, ItemStack stack, float experience)
    {
        if (getSmeltingResult(input) != ItemStack.EMPTY) { net.minecraftforge.fml.common.FMLLog.info("Ignored smelting recipe with conflicting input: " + input + " = " + stack); return; }
        this.smeltingList.put(input, stack);
        this.experienceList.put(stack, Float.valueOf(experience));
    }

    /**
     * Returns the smelting result of an item.
     */
/**    public ItemStack getSmeltingResult(ItemStack stack)
    {
        for (Entry<ItemStack, ItemStack> entry : this.smeltingList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return (ItemStack)entry.getValue();
            }
        }

        return ItemStack.EMPTY;
    }

    /**
     * Compares two itemstacks to ensure that they are the same. This checks both the item and the metadata of the item.
     */
/**    private boolean compareItemStacks(ItemStack stack1, ItemStack stack2)
    {
        return stack2.getItem() == stack1.getItem() && (stack2.getMetadata() == 32767 || stack2.getMetadata() == stack1.getMetadata());
    }

    public Map<ItemStack, ItemStack> getSmeltingList()
    {
        return this.smeltingList;
    }

    public float getSmeltingExperience(ItemStack stack)
    {
        float ret = stack.getItem().getSmeltingExperience(stack);
        if (ret != -1) return ret;

        for (Entry<ItemStack, Float> entry : this.experienceList.entrySet())
        {
            if (this.compareItemStacks(stack, (ItemStack)entry.getKey()))
            {
                return ((Float)entry.getValue()).floatValue();
            }
        }

        return 0.0F;
    }
    */
}

package com.viesis.viescraft.common.items.crafting;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.viesis.viescraft.api.Reference;
import com.viesis.viescraft.common.entity.airshipcolors.EntityAirshipBaseVC;
import com.viesis.viescraft.configs.ViesCraftConfig;
import com.viesis.viescraft.init.InitBlocksVC;
import com.viesis.viescraft.init.InitItemsVC;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCloning;
import net.minecraft.item.crafting.RecipeFireworks;
import net.minecraft.item.crafting.RecipeRepairItem;
import net.minecraft.item.crafting.RecipeTippedArrow;
import net.minecraft.item.crafting.RecipesArmorDyes;
import net.minecraft.item.crafting.RecipesBanners;
import net.minecraft.item.crafting.RecipesMapCloning;
import net.minecraft.item.crafting.RecipesMapExtending;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.item.crafting.ShieldRecipes;
import net.minecraft.item.crafting.ShulkerBoxRecipes;
import net.minecraft.util.JsonUtils;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.RegistryNamespaced;
import net.minecraft.world.World;

public class CraftingManagerVC {
	
}
	/**
	private static final Logger LOGGER = LogManager.getLogger();
    private static int nextAvailableId;
    public static final RegistryNamespaced<ResourceLocation, IRecipe> REGISTRY = net.minecraftforge.registries.GameData.getWrapper(IRecipe.class);

    public static boolean init()
    {
        try
        {
            //register("armordye", new RecipesArmorDyes());
            //register("bookcloning", new RecipeBookCloning());
            //register("mapcloning", new RecipesMapCloning());
            //register("mapextending", new RecipesMapExtending());
            //register("fireworks", new RecipeFireworks());
            //register("repairitem", new RecipeRepairItem());
            //register("tippedarrow", new RecipeTippedArrow());
            //register("bannerduplicate", new RecipesBanners.RecipeDuplicatePattern());
            //register("banneraddpattern", new RecipesBanners.RecipeAddPattern());
            //register("shielddecoration", new ShieldRecipes.Decoration());
            //register("shulkerboxcoloring", new ShulkerBoxRecipes.ShulkerBoxColoring());
            return parseJsonRecipes();
        }
        catch (Throwable var1)
        {
            return false;
        }
    }

    private static boolean parseJsonRecipes()
    {
        FileSystem filesystem = null;
        Gson gson = (new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
        boolean flag1;

        try
        {
            URL url = CraftingManagerVC.class.getResource("vc:.mcassetsroot");
            
            if (url != null)
            {
                URI uri = url.toURI();
                Path path;

                if ("file".equals(uri.getScheme()))
                {
                    path = Paths.get(CraftingManagerVC.class.getResource(
                    		//Reference.MOD_ID + ":"
                    		//+ ""
                    		//+ 
                    		"/assets/vc/recipes").toURI());
                }
                else
                {
                    if (!"jar".equals(uri.getScheme()))
                    {
                        LOGGER.error("Unsupported scheme " + uri + " trying to list all recipes");
                        boolean flag2 = false;
                        return flag2;
                    }

                    filesystem = FileSystems.newFileSystem(uri, Collections.emptyMap());
                    //TODO 
                    path = filesystem.getPath(
                    		//Reference.MOD_ID + 
                    		//":"
                    		//+ 
                    		"/assets/vc/recipes");
                }

                Iterator<Path> iterator = Files.walk(path).iterator();

                while (iterator.hasNext())
                {
                    Path path1 = iterator.next();

                    if ("json".equals(FilenameUtils.getExtension(path1.toString())))
                    {
                        Path path2 = path.relativize(path1);
                        String s = FilenameUtils.removeExtension(path2.toString()).replaceAll("\\\\", "/");
                        ResourceLocation resourcelocation = new ResourceLocation(s);
                        BufferedReader bufferedreader = null;

                        try
                        {
                            boolean flag;

                            try
                            {
                                bufferedreader = Files.newBufferedReader(path1);
                                register(s, parseRecipeJson((JsonObject)JsonUtils.fromJson(gson, bufferedreader, JsonObject.class)));
                            }
                            catch (JsonParseException jsonparseexception)
                            {
                                LOGGER.error("Parsing error loading recipe " + resourcelocation, (Throwable)jsonparseexception);
                                flag = false;
                                return flag;
                            }
                            catch (IOException ioexception)
                            {
                                LOGGER.error("Couldn't read recipe " + resourcelocation + " from " + path1, (Throwable)ioexception);
                                flag = false;
                                return flag;
                            }
                        }
                        finally
                        {
                            IOUtils.closeQuietly((Reader)bufferedreader);
                        }
                    }
                }

                return true;
            }

            LOGGER.error("Couldn't find .mcassetsroot");
            flag1 = false;
        }
        catch (IOException | URISyntaxException urisyntaxexception)
        {
            LOGGER.error("Couldn't get a list of all recipe files", (Throwable)urisyntaxexception);
            flag1 = false;
            return flag1;
        }
        finally
        {
            IOUtils.closeQuietly((Closeable)filesystem);
        }

        return flag1;
    }

    private static IRecipe parseRecipeJson(JsonObject p_193376_0_)
    {
        String s = JsonUtils.getString(p_193376_0_, "type");

        if ("crafting_shaped".equals(s))
        {
            return ShapedRecipes.deserialize(p_193376_0_);
        }
        else if ("crafting_shapeless".equals(s))
        {
            return ShapelessRecipes.deserialize(p_193376_0_);
        }
        else
        {
            throw new JsonSyntaxException("Invalid or unsupported recipe type '" + s + "'");
        }
    }

    //Forge: Made private use GameData/Registry events!
    private static void register(String name, IRecipe recipe)
    {
        register(new ResourceLocation(name), recipe);
    }

    //Forge: Made private use GameData/Registry events!
    private static void register(ResourceLocation name, IRecipe recipe)
    {
        if (REGISTRY.containsKey(name))
        {
            throw new IllegalStateException("Duplicate recipe ignored with ID " + name);
        }
        else
        {
            REGISTRY.register(nextAvailableId++, name, recipe);
        }
    }

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     *
    public static ItemStack findMatchingResult(InventoryCrafting p_82787_0_, World craftMatrix)
    {
        for (IRecipe irecipe : REGISTRY)
        {
            if (irecipe.matches(p_82787_0_, craftMatrix))
            {
                return irecipe.getCraftingResult(p_82787_0_);
            }
        }

        return ItemStack.EMPTY;
    }

    @Nullable
    public static IRecipe findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : REGISTRY)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe;
            }
        }

        return null;
    }

    public static NonNullList<ItemStack> getRemainingItems(InventoryCrafting p_180303_0_, World craftMatrix)
    {
        for (IRecipe irecipe : REGISTRY)
        {
            if (irecipe.matches(p_180303_0_, craftMatrix))
            {
                return irecipe.getRemainingItems(p_180303_0_);
            }
        }

        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(p_180303_0_.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            nonnulllist.set(i, p_180303_0_.getStackInSlot(i));
        }

        return nonnulllist;
    }

    @Nullable
    public static IRecipe getRecipe(ResourceLocation name)
    {
        return REGISTRY.getObject(name);
    }

    @Deprecated //DO NOT USE THIS
    public static int getIDForRecipe(IRecipe recipe)
    {
        return REGISTRY.getIDForObject(recipe);
    }

    @Deprecated //DO NOT USE THIS
    @Nullable
    public static IRecipe getRecipeById(int id)
    {
        return REGISTRY.getObjectById(id);
    }
}
	
    /** The static instance of this class */
/**    private static final CraftingManagerVCVC INSTANCE = new CraftingManagerVCVC();
    private final List<IRecipe> recipes = Lists.<IRecipe>newArrayList();
    
    /**
     * Returns the static instance of this class
     */
/**   public static CraftingManagerVCVC getInstance()
    {
        /** The static instance of this class */
/**        return INSTANCE;
    }
    
    /**    public CraftingManagerVCVC()
    {
    	this.addRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_MAIN, 1), new Object[]{
    	" F ", 
    	"FBF", 
    	" F ", 
    	'B', Items.BOOK, 'F', Items.FEATHER});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_CONTROL), new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(Items.FEATHER));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_PAINT), new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(Items.DYE, 1, 0));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_SOCKET), new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(Items.REDSTONE));
		
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(InitItemsVC.GUIDEBOOK_CONTROL));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(InitItemsVC.GUIDEBOOK_PAINT));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.GUIDEBOOK_MAIN), new ItemStack(InitItemsVC.GUIDEBOOK_SOCKET));
		
		this.addRecipe(new ItemStack(InitBlocksVC.airship_workbench, 1), new Object[]{
		"ICI", 
		"GFG", 
		"#L#", 
		'C', Blocks.CRAFTING_TABLE, 
		'I', Items.IRON_INGOT, 
		'G', Items.GOLD_INGOT, 
		'F', Items.FIRE_CHARGE, 
		'#', Blocks.IRON_BLOCK, 
		'L', Blocks.LAPIS_BLOCK});
		
		this.addRecipe(new ItemStack(InitItemsVC.ITEM_DISMOUNTER, 1), new Object[]{
		"  F", " S ", "L  ", 
		'L', Items.LEATHER, 
		'S', Items.STICK, 
		'F', Items.FEATHER});
		
    	//=================================================
        
		//Fuel
		this.addShapelessRecipe(new ItemStack(InitItemsVC.VIESOLINE_PELLETS), new ItemStack(Items.COAL), new ItemStack(Items.REDSTONE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.VIESOLINE_PELLETS), new ItemStack(Items.COAL, 1, 1), new ItemStack(Items.REDSTONE));
		
    	//Airship parts
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON, 1), new Object[]{
    	"LLL", 
    	"L#L", 
    	"LLL", 
    	'L', Items.LEATHER, '#', Items.STRING});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_ENGINE, 1), new Object[]{
    	"IBI", 
    	"P#P", 
    	"IBI", 
    	'P', Blocks.PISTON, 
    	'I', Items.IRON_INGOT, 
    	'B', Blocks.IRON_BARS, 
    	'#', Blocks.REDSTONE_BLOCK});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_IGNITION, 1), new Object[]{
    	"IBI", 
    	"D#D", 
    	"IGI", 
    	'I', Items.IRON_INGOT, 
    	'G', Items.GOLD_INGOT, 
    	'D', Items.DIAMOND, 
    	'B', Blocks.IRON_BARS, 
    	'#', Blocks.MAGMA});
    	
    	//Airship Frames
    	//Tier 1
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 0), new Object[]{
    	"###", "#M#", "###", 
    	'#', new ItemStack(Blocks.PLANKS, 1, 0), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 1), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 1), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 2), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 2), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 3), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 3), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 4), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 4), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 5), new Object[]{"###", "#M#", "###", '#', new ItemStack(Blocks.PLANKS, 1, 5), 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 6), new Object[]{"###", "#M#", "###", '#', Blocks.SANDSTONE, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 7), new Object[]{"###", "#M#", "###", '#', Blocks.BRICK_BLOCK, 'M', Items.MINECART});
    	//Tier 2
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 8), new Object[]{"###", "#M#", "###", '#', Blocks.BONE_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 9), new Object[]{"###", "#M#", "###", '#', Blocks.IRON_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 10), new Object[]{"###", "#M#", "###", '#', Blocks.REDSTONE_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 11), new Object[]{"###", "#M#", "###", '#', Blocks.GOLD_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 12), new Object[]{"###", "#M#", "###", '#', Blocks.LAPIS_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 13), new Object[]{"###", "#M#", "###", '#', Blocks.SLIME_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 14), new Object[]{"###", "#M#", "###", '#', Blocks.MYCELIUM, 'M', Items.MINECART});
    	//Tier 3
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 15), new Object[]{"###", "#M#", "###", '#', Blocks.NETHER_BRICK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 16), new Object[]{"###", "#M#", "###", '#', Blocks.SOUL_SAND, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 17), new Object[]{"###", "#M#", "###", '#', Blocks.QUARTZ_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 18), new Object[]{"###", "#M#", "###", '#', Blocks.ICE, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 19), new Object[]{"###", "#M#", "###", '#', Blocks.GLOWSTONE, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 20), new Object[]{"###", "#M#", "###", '#', Blocks.OBSIDIAN, 'M', Items.MINECART});
    	//Tier 4
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 21), new Object[]{"###", "#M#", "###", '#', Blocks.DIAMOND_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 22), new Object[]{"###", "#M#", "###", '#', Blocks.EMERALD_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 23), new Object[]{"###", "#M#", "###", '#', Blocks.PRISMARINE, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 24), new Object[]{"###", "#M#", "###", '#', Blocks.PURPUR_BLOCK, 'M', Items.MINECART});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 25), new Object[]{"###", "#M#", "###", '#', Items.NETHER_STAR, 'M', Items.MINECART});
    	
    	if(ViesCraftConfig.recipeMythic)
    	{
    		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 26), new Object[]{"###", "#M#", "###", 
    		'#', Items.END_CRYSTAL, 
    		'M', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 25)});
    		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 27), new Object[]{"###", "#M#", "###", 
    		'#', Items.WATER_BUCKET, 
    		'M', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 26)});
    		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 28), new Object[]{"###", "#M#", "###", 
    		'#', Items.LAVA_BUCKET, 
    		'M', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 26)});
    		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 29), new Object[]{"###", "#M#", "###", 
    		'#', Items.ENDER_EYE, 
    		'M', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, 26)});
    	}
    	
    	//=================================================
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//Airships
    	for (EntityAirshipBaseVC.FrameCore meta : EntityAirshipBaseVC.FrameCore.values()) 
		{
    		this.addRecipe(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V1, 1, meta.getMetadata()), new Object[]{
    		"LBL", 
    		"E#E", 
    		"LIL", 
    		'B', InitItemsVC.AIRSHIP_BALLOON, 
    		'E', InitItemsVC.AIRSHIP_ENGINE, 
    		'I', InitItemsVC.AIRSHIP_IGNITION, 
    		'L', Items.LEAD, 
    		'#', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, meta.getMetadata())});
    		
    		this.addRecipe(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V2, 1, meta.getMetadata()), new Object[]{
    		"BLB", 
    		"L#L", 
    		"EIE", 
    		'B', InitItemsVC.AIRSHIP_BALLOON, 
    		'E', InitItemsVC.AIRSHIP_ENGINE, 
    		'I', InitItemsVC.AIRSHIP_IGNITION, 
    		'L', Items.LEAD, 
    		'#', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, meta.getMetadata())});
        	
        	this.addRecipe(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V3, 1, meta.getMetadata()), new Object[]{
        	"ELE", 
        	"B#B", 
        	"LIL", 
        	'B', InitItemsVC.AIRSHIP_BALLOON, 
        	'E', InitItemsVC.AIRSHIP_ENGINE, 
        	'I', InitItemsVC.AIRSHIP_IGNITION, 
        	'L', Items.LEAD, 
        	'#', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, meta.getMetadata())});
        	
        	this.addRecipe(new ItemStack(InitItemsVC.ITEM_AIRSHIP_V4, 1, meta.getMetadata()), new Object[]{
        	"EBE", 
        	"L#L", 
        	"LIL", 
        	'B', InitItemsVC.AIRSHIP_BALLOON, 
        	'E', InitItemsVC.AIRSHIP_ENGINE, 
        	'I', InitItemsVC.AIRSHIP_IGNITION, 
        	'L', Items.LEAD, 
        	'#', new ItemStack(InitItemsVC.AIRSHIP_FRAME, 1, meta.getMetadata())});
		}
    	
    	//=================================================
    	
    	//Airship modules
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), new Object[]{
    	"CRC", "GGG", 
    	'C', Blocks.COBBLESTONE, 
    	'R', Items.REDSTONE, 
    	'G', Items.GOLD_NUGGET});///////////////////////////////////////////
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 1), new Object[]{
    	"CGC", "FDF", "CGC", 
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'G', Items.GOLD_INGOT, 
    	'D', Items.DIAMOND, 
    	'F', Items.FIRE_CHARGE});///////////////////////////////////////////
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 2), new Object[]{
    	"CDC", 
    	"FEF", 
    	"CDC", 
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'E', Items.EMERALD, 
    	'D', Items.DIAMOND, 
    	'F', Items.FIRE_CHARGE});///////////////////////////////////////////
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 3), new Object[]{
    	"CNC", 
    	"D#D", 
    	"CNC", ///////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'N', Items.GOLD_NUGGET, 
    	'D', Items.DIAMOND, '#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 4), new Object[]{
    	"C#C", 
    	"D#D", 
    	"CEC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'E', Items.EMERALD, 
    	'D', Items.DIAMOND, 
    	'#', Blocks.CHEST});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 5), new Object[]{
    	"CBC", 
    	"Q#Q", 
    	"CBC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'B', Items.BLAZE_ROD, 
    	'Q', Items.QUARTZ, 
    	'#', Items.NETHER_STAR});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 6), new Object[]{
    	"CBC", 
    	"Q#Q", 
    	"CBC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'B', Items.GLASS_BOTTLE, 
    	'Q', Items.QUARTZ, 
    	'#', Items.GHAST_TEAR});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 7), new Object[]{
    	"CGC", 
    	"F#F", 
    	"CGC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'G', Items.GLOWSTONE_DUST, 
    	'F', Items.FEATHER, 
    	'#', Items.DIAMOND});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 8), new Object[]{
    	"CPC", 
    	"D#D", 
    	"CPC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'P', Items.ENDER_PEARL, 
    	'D', Items.DIAMOND, 
    	'#', Items.BLAZE_ROD});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 9), new Object[]{
    	"CPC", 
    	"E#E", 
    	"CPC", ////////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'P', Items.ENDER_PEARL, 
    	'E', Items.EMERALD, 
    	'#', Items.BLAZE_ROD});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 10), new Object[]{
    	"CPC", 
    	"Q#Q", 
    	"CPC", ///////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'P', Items.ENDER_PEARL, 
    	'Q', Items.QUARTZ, 
    	'#', Blocks.JUKEBOX});
    	this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 11), new Object[]{
    	"CQC", 
    	"N#N", 
    	"CQC", //////////////////////////
    	'C', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
    	'N', Items.GOLD_NUGGET, 
    	'Q', Items.QUARTZ, 
    	'#', Items.CLOCK});
    	
    	//=================================================
		
		//Colorizer using coal or charcoal
    	this.addRecipe(new ItemStack(InitItemsVC.ITEM_BALLOON_COLORIZER), new Object[]{
    	"I#I", "#M#", "I#I", 
    	'#', new ItemStack(Items.COAL, 1, 0), 
    	'I', Items.IRON_INGOT, 
    	'M', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0)});
		this.addRecipe(new ItemStack(InitItemsVC.ITEM_BALLOON_COLORIZER), new Object[]{
		"I#I", "#M#", "I#I", 
		'#', new ItemStack(Items.COAL, 1, 1), 
		'I', Items.IRON_INGOT, 
		'M', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0)});
    	
    	//=================================================
		
		//Balloon Patterns
		//Plain
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 0), new Object[]{
		"LLL", 
		"LLL", ///////////////////////////////
		"L#L", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 'L', Items.LEATHER});
		
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 1), 
		new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 0), 
		new ItemStack(Items.ENDER_EYE));
		
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 2), 
		new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 1), 
		new ItemStack(Items.NETHER_WART));
		
		//Checker
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 3), new Object[]{
		"ILI", 
		"LIL", /////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 4), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 3), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 5), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 4), new ItemStack(Items.NETHER_WART));
		
		//Polka Dot
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 6), new Object[]{
		"ILI", 
		"LLL", ///////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 7), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 6), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 8), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 7), new ItemStack(Items.NETHER_WART));
		//Zigzag
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 9), new Object[]{
		"ILL", 
		"LIL", ///////////////////////////////
		"L#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 10), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 9), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 11), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 10), new ItemStack(Items.NETHER_WART));
		//Creeper
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 12), new Object[]{
		"IGI", 
		"LGL", ///////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0), 
		'G', new ItemStack(Items.GUNPOWDER)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 13), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 12), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 14), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 13), new ItemStack(Items.NETHER_WART));
		//Water
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 15), new Object[]{
		"ILI", 
		"LBL", ////////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0), 
		'B', new ItemStack(Items.WATER_BUCKET)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 16), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 15), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 17), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 16), new ItemStack(Items.NETHER_WART));
		//Lava
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 18), new Object[]{
		"ILI", 
		"LBL", /////////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0), 
		'B', new ItemStack(Items.LAVA_BUCKET)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 19), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 18), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 20), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 19), new ItemStack(Items.NETHER_WART));
		//Ender
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 21), new Object[]{
		"ILI", 
		"LEL", /////////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0), 
		'E', new ItemStack(Items.ENDER_PEARL)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 22), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 21), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 23), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 22), new ItemStack(Items.NETHER_WART));
		//Tools
		this.addRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 24), new Object[]{
		"ILI", 
		"LTL", /////////////////////////////////
		"I#I", 
		'#', new ItemStack(InitItemsVC.AIRSHIP_MODULE, 1, 0), 
		'L', Items.LEATHER, 
		'I', new ItemStack(Items.DYE, 1, 0), 
		'T', new ItemStack(Items.DIAMOND)});
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 25), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 24), new ItemStack(Items.ENDER_EYE));
		this.addShapelessRecipe(new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 26), new ItemStack(InitItemsVC.AIRSHIP_BALLOON_PATTERN, 1, 25), new ItemStack(Items.NETHER_WART));
		
		
		
		//=================================================
		
		
		
		Collections.sort(this.recipes, new Comparator<IRecipe>()
        {
            public int compare(IRecipe p_compare_1_, IRecipe p_compare_2_)
            {
                return p_compare_1_ instanceof ShapelessRecipes && p_compare_2_ instanceof ShapedRecipes ? 1 : (p_compare_2_ instanceof ShapelessRecipes && p_compare_1_ instanceof ShapedRecipes ? -1 : (p_compare_2_.getRecipeSize() < p_compare_1_.getRecipeSize() ? -1 : (p_compare_2_.getRecipeSize() > p_compare_1_.getRecipeSize() ? 1 : 0)));
            }
        });
    }
    
    /**
     * Adds a shaped recipe to the games recipe list.
     */
    /**   public ShapedRecipes addRecipe(ItemStack stack, Object... recipeComponents)
    {
        String s = "";
        int i = 0;
        int j = 0;
        int k = 0;

        if (recipeComponents[i] instanceof String[])
        {
            String[] astring = (String[])((String[])recipeComponents[i++]);

            for (String s2 : astring)
            {
                ++k;
                j = s2.length();
                s = s + s2;
            }
        }
        else
        {
            while (recipeComponents[i] instanceof String)
            {
                String s1 = (String)recipeComponents[i++];
                ++k;
                j = s1.length();
                s = s + s1;
            }
        }

        Map<Character, ItemStack> map;

        for (map = Maps.<Character, ItemStack>newHashMap(); i < recipeComponents.length; i += 2)
        {
            Character character = (Character)recipeComponents[i];
            ItemStack itemstack = ItemStack.EMPTY;

            if (recipeComponents[i + 1] instanceof Item)
            {
                itemstack = new ItemStack((Item)recipeComponents[i + 1]);
            }
            else if (recipeComponents[i + 1] instanceof Block)
            {
                itemstack = new ItemStack((Block)recipeComponents[i + 1], 1, 32767);
            }
            else if (recipeComponents[i + 1] instanceof ItemStack)
            {
                itemstack = (ItemStack)recipeComponents[i + 1];
            }

            map.put(character, itemstack);
        }

        ItemStack[] aitemstack = new ItemStack[j * k];

        for (int l = 0; l < j * k; ++l)
        {
            char c0 = s.charAt(l);

            if (map.containsKey(Character.valueOf(c0)))
            {
                aitemstack[l] = ((ItemStack)map.get(Character.valueOf(c0))).copy();
            }
            else
            {
                aitemstack[l] = ItemStack.EMPTY;
            }
        }

        ShapedRecipes shapedrecipes = new ShapedRecipes(j, k, aitemstack, stack);
        this.recipes.add(shapedrecipes);
        return shapedrecipes;
    }

    /**
     * Adds a shapeless crafting recipe to the the game.
     */
    /**    public void addShapelessRecipe(ItemStack stack, Object... recipeComponents)
    {
        List<ItemStack> list = Lists.<ItemStack>newArrayList();

        for (Object object : recipeComponents)
        {
            if (object instanceof ItemStack)
            {
                list.add(((ItemStack)object).copy());
            }
            else if (object instanceof Item)
            {
                list.add(new ItemStack((Item)object));
            }
            else
            {
                if (!(object instanceof Block))
                {
                    throw new IllegalArgumentException("Invalid shapeless recipe: unknown type " + object.getClass().getName() + "!");
                }

                list.add(new ItemStack((Block)object));
            }
        }

        this.recipes.add(new ShapelessRecipes(stack, list));
    }

    /**
     * Adds an IRecipe to the list of crafting recipes.
     */
    /**    public void addRecipe(IRecipe recipe)
    {
        this.recipes.add(recipe);
    }

    /**
     * Retrieves an ItemStack that has multiple recipes for it.
     */
    /**    public ItemStack findMatchingRecipe(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getCraftingResult(craftMatrix);
            }
        }

        return ItemStack.EMPTY;
    }

    public NonNullList<ItemStack> getRemainingItems(InventoryCrafting craftMatrix, World worldIn)
    {
        for (IRecipe irecipe : this.recipes)
        {
            if (irecipe.matches(craftMatrix, worldIn))
            {
                return irecipe.getRemainingItems(craftMatrix);
            }
        }

        NonNullList<ItemStack> nonnulllist = NonNullList.<ItemStack>withSize(craftMatrix.getSizeInventory(), ItemStack.EMPTY);

        for (int i = 0; i < nonnulllist.size(); ++i)
        {
            nonnulllist.set(i, craftMatrix.getStackInSlot(i));
        }

        return nonnulllist;
    }

    public List<IRecipe> getRecipeList()
    {
        return this.recipes;
    }
}*/
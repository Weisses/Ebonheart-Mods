package com.viesis.gemstones.init;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;
import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.VGBlocks;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneConverter;
import com.viesis.gemstones.common.tileentity.TileEntityGemstoneWorkbench;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(References.MOD_ID)
public class InitBlocksVG extends VGBlocks {

	public static void registerBlockTEMP()
	{
		//========================
		//    To be deleted
		//========================
		
		
		
	}
	
	@Mod.EventBusSubscriber(modid = References.MOD_ID)
	public static class RegistrationHandler 
	{
		public static final Set<Block> BLOCKS = new HashSet<>();
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBlocks(RegistryEvent.Register<Block> event) 
		{
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					GEMSTONE_WORKBENCH,
					GEMSTONE_CONVERTER,
					GEMINFUSED_ORE,
					GEMSTONE_BASIC_BLOCK_V1,
					GEMSTONE_BASIC_BRICK_V1,
					GEMSTONE_BASIC_FANCYBRICK_V1,
					BASIC_DOUBLESLAB_ARCANITE,
					BASIC_DOUBLESLAB_VELIOUS,
					BASIC_DOUBLESLAB_FENRYTE,
					BASIC_DOUBLESLAB_ELECTIUM,
					BASIC_DOUBLESLAB_IGNEELIS,
					BASIC_DOUBLESLAB_NECROCITE,
					BASIC_DOUBLESLAB_ZEPHYRIUM,
					BASIC_DOUBLESLAB_ONYXIUS,
					BASIC_DOUBLESLAB_SOULARITE,
					BASIC_HALFSLAB_ARCANITE,
					BASIC_HALFSLAB_VELIOUS,
					BASIC_HALFSLAB_FENRYTE,
					BASIC_HALFSLAB_ELECTIUM,
					BASIC_HALFSLAB_IGNEELIS,
					BASIC_HALFSLAB_NECROCITE,
					BASIC_HALFSLAB_ZEPHYRIUM,
					BASIC_HALFSLAB_ONYXIUS,
					BASIC_HALFSLAB_SOULARITE,
					BASIC_STAIRS_ARCANITE,
					BASIC_STAIRS_VELIOUS,
					BASIC_STAIRS_FENRYTE,
					BASIC_STAIRS_ELECTIUM,
					BASIC_STAIRS_IGNEELIS,
					BASIC_STAIRS_NECROCITE,
					BASIC_STAIRS_ZEPHYRIUM,
					BASIC_STAIRS_ONYXIUS,
					BASIC_STAIRS_SOULARITE,
					BASIC_FENCE_ARCANITE,
					BASIC_FENCE_VELIOUS,
					BASIC_FENCE_FENRYTE,
					BASIC_FENCE_ELECTIUM,
					BASIC_FENCE_IGNEELIS,
					BASIC_FENCE_NECROCITE,
					BASIC_FENCE_ZEPHYRIUM,
					BASIC_FENCE_ONYXIUS,
					BASIC_FENCE_SOULARITE,
					BASIC_GATE_ARCANITE,
					BASIC_GATE_VELIOUS,
					BASIC_GATE_FENRYTE,
					BASIC_GATE_ELECTIUM,
					BASIC_GATE_IGNEELIS,
					BASIC_GATE_NECROCITE,
					BASIC_GATE_ZEPHYRIUM,
					BASIC_GATE_ONYXIUS,
					BASIC_GATE_SOULARITE,
					BASIC_WALL_ARCANITE,
					BASIC_WALL_VELIOUS,
					BASIC_WALL_FENRYTE,
					BASIC_WALL_ELECTIUM,
					BASIC_WALL_IGNEELIS,
					BASIC_WALL_NECROCITE,
					BASIC_WALL_ZEPHYRIUM,
					BASIC_WALL_ONYXIUS,
					BASIC_WALL_SOULARITE,
					BASIC_TORCH_ARCANITE,
					BASIC_TORCH_VELIOUS,
					BASIC_TORCH_FENRYTE,
					BASIC_TORCH_ELECTIUM,
					BASIC_TORCH_IGNEELIS,
					BASIC_TORCH_NECROCITE,
					BASIC_TORCH_ZEPHYRIUM,
					BASIC_TORCH_ONYXIUS,
					BASIC_TORCH_SOULARITE,
					BASIC_TRAPDOOR_ARCANITE,
					BASIC_TRAPDOOR_VELIOUS,
					BASIC_TRAPDOOR_FENRYTE,
					BASIC_TRAPDOOR_ELECTIUM,
					BASIC_TRAPDOOR_IGNEELIS,
					BASIC_TRAPDOOR_NECROCITE,
					BASIC_TRAPDOOR_ZEPHYRIUM,
					BASIC_TRAPDOOR_ONYXIUS,
					BASIC_TRAPDOOR_SOULARITE,
					BASIC_LADDER_ARCANITE,
					BASIC_LADDER_VELIOUS,
					BASIC_LADDER_FENRYTE,
					BASIC_LADDER_ELECTIUM,
					BASIC_LADDER_IGNEELIS,
					BASIC_LADDER_NECROCITE,
					BASIC_LADDER_ZEPHYRIUM,
					BASIC_LADDER_ONYXIUS,
					BASIC_LADDER_SOULARITE,
					BASIC_PILLAR_ARCANITE,
					BASIC_PILLAR_VELIOUS,
					BASIC_PILLAR_FENRYTE,
					BASIC_PILLAR_ELECTIUM,
					BASIC_PILLAR_IGNEELIS,
					BASIC_PILLAR_NECROCITE,
					BASIC_PILLAR_ZEPHYRIUM,
					BASIC_PILLAR_ONYXIUS,
					BASIC_PILLAR_SOULARITE,
			};
			
			registry.registerAll(blocks);

			//registerSlabGroup(registry, Slabs.STAINED_CLAY_SLABS.high);
			//registerSlabGroup(registry, Slabs.STAINED_CLAY_SLABS.low);
		}

		/**
		 * Register the {@link Block}s of a {@link BlockSlabTestMod3.SlabGroup}.
		 *
		 * @param registry  The registry
		 * @param slabGroup The slab group
		 */
		//private static void registerSlabGroup(IForgeRegistry<Block> registry, BlockSlabTestMod3.SlabGroup<?, ?, ?> slabGroup) {
		//	registry.register(slabGroup.singleSlab);
		//	registry.register(slabGroup.doubleSlab);
		//}

		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(RegistryEvent.Register<Item> event) 
		{
			final ItemBlock[] items = {
					new ItemBlock(GEMSTONE_WORKBENCH),
					new ItemBlock(GEMSTONE_CONVERTER),
					new ItemBlock(GEMINFUSED_ORE),
					new ItemBlock(GEMSTONE_BASIC_BLOCK_V1),
					new ItemBlock(GEMSTONE_BASIC_BRICK_V1),
					new ItemBlock(GEMSTONE_BASIC_FANCYBRICK_V1),
					new ItemBlock(BASIC_DOUBLESLAB_ARCANITE),
					new ItemBlock(BASIC_DOUBLESLAB_VELIOUS),
					new ItemBlock(BASIC_DOUBLESLAB_FENRYTE),
					new ItemBlock(BASIC_DOUBLESLAB_ELECTIUM),
					new ItemBlock(BASIC_DOUBLESLAB_IGNEELIS),
					new ItemBlock(BASIC_DOUBLESLAB_NECROCITE),
					new ItemBlock(BASIC_DOUBLESLAB_ZEPHYRIUM),
					new ItemBlock(BASIC_DOUBLESLAB_ONYXIUS),
					new ItemBlock(BASIC_DOUBLESLAB_SOULARITE),
					new ItemBlock(BASIC_HALFSLAB_ARCANITE),
					new ItemBlock(BASIC_HALFSLAB_VELIOUS),
					new ItemBlock(BASIC_HALFSLAB_FENRYTE),
					new ItemBlock(BASIC_HALFSLAB_ELECTIUM),
					new ItemBlock(BASIC_HALFSLAB_IGNEELIS),
					new ItemBlock(BASIC_HALFSLAB_NECROCITE),
					new ItemBlock(BASIC_HALFSLAB_ZEPHYRIUM),
					new ItemBlock(BASIC_HALFSLAB_ONYXIUS),
					new ItemBlock(BASIC_HALFSLAB_SOULARITE),
					new ItemBlock(BASIC_STAIRS_ARCANITE),
					new ItemBlock(BASIC_STAIRS_VELIOUS),
					new ItemBlock(BASIC_STAIRS_FENRYTE),
					new ItemBlock(BASIC_STAIRS_ELECTIUM),
					new ItemBlock(BASIC_STAIRS_IGNEELIS),
					new ItemBlock(BASIC_STAIRS_NECROCITE),
					new ItemBlock(BASIC_STAIRS_ZEPHYRIUM),
					new ItemBlock(BASIC_STAIRS_ONYXIUS),
					new ItemBlock(BASIC_STAIRS_SOULARITE),
					new ItemBlock(BASIC_FENCE_ARCANITE),
					new ItemBlock(BASIC_FENCE_VELIOUS),
					new ItemBlock(BASIC_FENCE_FENRYTE),
					new ItemBlock(BASIC_FENCE_ELECTIUM),
					new ItemBlock(BASIC_FENCE_IGNEELIS),
					new ItemBlock(BASIC_FENCE_NECROCITE),
					new ItemBlock(BASIC_FENCE_ZEPHYRIUM),
					new ItemBlock(BASIC_FENCE_ONYXIUS),
					new ItemBlock(BASIC_FENCE_SOULARITE),
					new ItemBlock(BASIC_GATE_ARCANITE),
					new ItemBlock(BASIC_GATE_VELIOUS),
					new ItemBlock(BASIC_GATE_FENRYTE),
					new ItemBlock(BASIC_GATE_ELECTIUM),
					new ItemBlock(BASIC_GATE_IGNEELIS),
					new ItemBlock(BASIC_GATE_NECROCITE),
					new ItemBlock(BASIC_GATE_ZEPHYRIUM),
					new ItemBlock(BASIC_GATE_ONYXIUS),
					new ItemBlock(BASIC_GATE_SOULARITE),
					new ItemBlock(BASIC_WALL_ARCANITE),
					new ItemBlock(BASIC_WALL_VELIOUS),
					new ItemBlock(BASIC_WALL_FENRYTE),
					new ItemBlock(BASIC_WALL_ELECTIUM),
					new ItemBlock(BASIC_WALL_IGNEELIS),
					new ItemBlock(BASIC_WALL_NECROCITE),
					new ItemBlock(BASIC_WALL_ZEPHYRIUM),
					new ItemBlock(BASIC_WALL_ONYXIUS),
					new ItemBlock(BASIC_WALL_SOULARITE),
					new ItemBlock(BASIC_TORCH_ARCANITE),
					new ItemBlock(BASIC_TORCH_VELIOUS),
					new ItemBlock(BASIC_TORCH_FENRYTE),
					new ItemBlock(BASIC_TORCH_ELECTIUM),
					new ItemBlock(BASIC_TORCH_IGNEELIS),
					new ItemBlock(BASIC_TORCH_NECROCITE),
					new ItemBlock(BASIC_TORCH_ZEPHYRIUM),
					new ItemBlock(BASIC_TORCH_ONYXIUS),
					new ItemBlock(BASIC_TORCH_SOULARITE),
					new ItemBlock(BASIC_TRAPDOOR_ARCANITE),
					new ItemBlock(BASIC_TRAPDOOR_VELIOUS),
					new ItemBlock(BASIC_TRAPDOOR_FENRYTE),
					new ItemBlock(BASIC_TRAPDOOR_ELECTIUM),
					new ItemBlock(BASIC_TRAPDOOR_IGNEELIS),
					new ItemBlock(BASIC_TRAPDOOR_NECROCITE),
					new ItemBlock(BASIC_TRAPDOOR_ZEPHYRIUM),
					new ItemBlock(BASIC_TRAPDOOR_ONYXIUS),
					new ItemBlock(BASIC_TRAPDOOR_SOULARITE),
					new ItemBlock(BASIC_LADDER_ARCANITE),
					new ItemBlock(BASIC_LADDER_VELIOUS),
					new ItemBlock(BASIC_LADDER_FENRYTE),
					new ItemBlock(BASIC_LADDER_ELECTIUM),
					new ItemBlock(BASIC_LADDER_IGNEELIS),
					new ItemBlock(BASIC_LADDER_NECROCITE),
					new ItemBlock(BASIC_LADDER_ZEPHYRIUM),
					new ItemBlock(BASIC_LADDER_ONYXIUS),
					new ItemBlock(BASIC_LADDER_SOULARITE),
					new ItemBlock(BASIC_PILLAR_ARCANITE),
					new ItemBlock(BASIC_PILLAR_VELIOUS),
					new ItemBlock(BASIC_PILLAR_FENRYTE),
					new ItemBlock(BASIC_PILLAR_ELECTIUM),
					new ItemBlock(BASIC_PILLAR_IGNEELIS),
					new ItemBlock(BASIC_PILLAR_NECROCITE),
					new ItemBlock(BASIC_PILLAR_ZEPHYRIUM),
					new ItemBlock(BASIC_PILLAR_ONYXIUS),
					new ItemBlock(BASIC_PILLAR_SOULARITE),
					
					
					
					//new ItemBlock(AIRSHIP_WORKBENCH)
				/**	new ItemBlock(WATER_GRASS),
					new ItemBlock(LARGE_COLLISION_TEST),
					new ItemBlock(RIGHT_CLICK_TEST),
					new ItemBlock(CLIENT_PLAYER_RIGHT_CLICK),
					new ItemBlock(ROTATABLE_LAMP),
					new ItemBlock(ITEM_COLLISION_TEST),
					new ItemFluidTank(FLUID_TANK),
					new ItemBlock(ITEM_DEBUGGER),
					new ItemBlock(END_PORTAL_FRAME_FULL),
					new ItemCloth(COLORED_ROTATABLE),
					new ItemCloth(COLORED_MULTI_ROTATABLE),
					new ItemBlock(POTION_EFFECT),
					new ItemMultiTexture(VARIANTS, VARIANTS, VARIANTS::getName),
					new ItemBlock(CLIENT_PLAYER_ROTATION),
					new ItemBlock(PIG_SPAWNER_REFILLER),
					new ItemBlock(MIRROR_PLANE),
					new ItemBlock(VANILLA_MODEL_TEST),
					new ItemBlock(FULLBRIGHT),
					new ItemBlock(NORMAL_BRIGHTNESS),
					new ItemBlock(MAX_HEALTH_SETTER),
					new ItemBlock(MAX_HEALTH_GETTER),
					new ItemBlock(SMALL_COLLISION_TEST),
					new ItemBlock(CHEST),
					new ItemBlock(HIDDEN),
					new ItemBlock(BASIC_PIPE),
					new ItemBlock(FLUID_PIPE),
					new ItemBlock(SURVIVAL_COMMAND_BLOCK),
					new ItemBlock(REPEATING_SURVIVAL_COMMAND_BLOCK),
					new ItemBlock(CHAIN_SURVIVAL_COMMAND_BLOCK),
					new ItemMultiTexture(SAPLING, SAPLING, BlockSaplingTestMod3::getName),
					Slabs.STAINED_CLAY_SLABS.low.item,
					Slabs.STAINED_CLAY_SLABS.high.item,*/
			};

			final IForgeRegistry<Item> registry = event.getRegistry();
			
			for (final ItemBlock item : items) 
			{
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}

			registerTileEntities();
			//for (final ItemBlock item : items) {
			//	registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
			//	ITEM_BLOCKS.add(item);
			//}//
		}
	}

	public static void registerTileEntities() 
	{
		registerTileEntity(TileEntityGemstoneWorkbench.class, "container_gemstone_workbench");
		registerTileEntity(TileEntityGemstoneConverter.class, "container_gemstone_converter");
		//registerTileEntity(TileEntityFluidTank.class, "fluid_tank", "FluidTank");
		//registerTileEntity(TileEntityColoredRotatable.class, "colored_rotatable", "ColoredRotatable");
		//registerTileEntity(TileEntityColoredMultiRotatable.class, "colored_multi_rotatable", "ColoredMultiRotatable");
		//registerTileEntity(TileEntityPotionEffect.class, "potion_effect", "PotionEffect");
		//registerTileEntity(TileEntityModChest.class, "mod_chest", "ModChest");
		//registerTileEntity(TileEntityHidden.class, "hidden");
	}

	private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name) 
	{
		GameRegistry.registerTileEntity(tileEntityClass, References.MOD_ID_COLON + name);
	}

	//private static void registerTileEntity(Class<? extends TileEntity> tileEntityClass, String name, String legacyName) 
	//{
	//	GameRegistry.registerTileEntityWithAlternatives(tileEntityClass, Reference.MOD_ID_COLON//Constants.RESOURCE_PREFIX 
	//			+ name, Reference.MOD_ID_COLON//Constants.RESOURCE_PREFIX 
	//			+ legacyName);
	//}
	
}

	
	
	
	
	
	
	
	
	
	
	
	/**
	
	public static final Set<Block> blocks = new HashSet<>();
	
	public static void registerBlock()
	{
		//geminfused_ore = registerBlockMetaGemstoneOre(new BlockOreVG("gemstone/ore/block_ore"));
		
		//gemstone_workbench = registerBlock(new BlockGemstoneCutter("gemstone_workbench"));
		////gemstone_converter = registerBlock(new BlockGemstoneConverter("gemstone_converter"));
		
		
		//gemstone_basic_block_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/basic/block_basic"));
		//gemstone_basic_brick_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/brick/block_brick"));
		//gemstone_basic_fancybrick_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/fancybrick/block_fancybrick"));
				
		//basic_doubleslab_arcanite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_arcanite").setResistance(4.0F).setLightLevel(0.4f);
		//basic_doubleslab_velious = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_velious").setResistance(15.0F);
		//basic_doubleslab_fenryte = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_fenryte").setResistance(30.0F);
		//basic_doubleslab_electium = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_electium").setResistance(100.0F);
		//basic_doubleslab_igneelis = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_igneelis").setResistance(45.0F).setLightLevel(1.0f);
		//basic_doubleslab_necrocite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_necrocite").setResistance(45.0F);
		//basic_doubleslab_zephyrium = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_zephyrium").setResistance(2000.0F);
		//basic_doubleslab_onyxius = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_onyxius").setResistance(45.0F);
		//basic_doubleslab_soularite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_soularite").setResistance(2000.0F);
		
		//basic_halfslab_arcanite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_arcanite").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_velious = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_velious").setResistance(15.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_fenryte = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_fenryte").setResistance(30.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_electium = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_electium").setResistance(100.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_igneelis = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_igneelis").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_necrocite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_necrocite").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_zephyrium = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_zephyrium").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_onyxius = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_onyxius").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		//basic_halfslab_soularite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_soularite").setResistance(2000.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
		/**
		registerBlockSlab(basic_halfslab_arcanite, basic_doubleslab_arcanite);
		registerBlockSlab(basic_halfslab_velious, basic_doubleslab_velious);
		registerBlockSlab(basic_halfslab_fenryte, basic_doubleslab_fenryte);
		registerBlockSlab(basic_halfslab_electium, basic_doubleslab_electium);
		registerBlockSlab(basic_halfslab_igneelis, basic_doubleslab_igneelis);
		registerBlockSlab(basic_halfslab_necrocite, basic_doubleslab_necrocite);
		registerBlockSlab(basic_halfslab_zephyrium, basic_doubleslab_zephyrium);
		registerBlockSlab(basic_halfslab_onyxius, basic_doubleslab_onyxius);
		registerBlockSlab(basic_halfslab_soularite, basic_doubleslab_soularite);
		*/
		//basic_stairs_arcanite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_arcanite", gemstone_basic_block_v1).setResistance(4.0F).setLightLevel(0.4f));
		//basic_stairs_velious = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_velious", gemstone_basic_block_v1).setResistance(15.0F));
		//basic_stairs_fenryte = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_fenryte", gemstone_basic_block_v1).setResistance(30.0F));
		//basic_stairs_electium = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_electium", gemstone_basic_block_v1).setResistance(100.0F));
		//basic_stairs_igneelis = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_igneelis", gemstone_basic_block_v1).setResistance(100.0F));
		//basic_stairs_necrocite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_necrocite", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_stairs_zephyrium = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_zephyrium", gemstone_basic_block_v1).setResistance(100.0F));
		//basic_stairs_onyxius = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_onyxius", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_stairs_soularite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_soularite", gemstone_basic_block_v1).setResistance(2000.0F));
		
		//basic_fence_arcanite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_arcanite").setResistance(4.0F).setLightLevel(0.4f));
		//basic_fence_velious = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_velious").setResistance(15.0F));
		//basic_fence_fenryte = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_fenryte").setResistance(30.0F));
		//basic_fence_electium = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_electium").setResistance(100.0F));
		//basic_fence_igneelis = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_igneelis").setResistance(45.0F));
		//basic_fence_necrocite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_necrocite").setResistance(45.0F));
		//basic_fence_zephyrium = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_zephyrium").setResistance(45.0F));
		//basic_fence_onyxius = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_onyxius").setResistance(45.0F));
		//basic_fence_soularite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_soularite").setResistance(2000.0F));

		//basic_gate_arcanite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_arcanite").setResistance(4.0F).setLightLevel(0.4f));
		//basic_gate_velious = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_velious").setResistance(15.0F));
		//basic_gate_fenryte = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_fenryte").setResistance(30.0F));
		//basic_gate_electium = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_electium").setResistance(100.0F));
		//basic_gate_igneelis = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_igneelis").setResistance(45.0F));
		//basic_gate_necrocite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_necrocite").setResistance(45.0F));
		//basic_gate_zephyrium = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_zephyrium").setResistance(45.0F));
		//basic_gate_onyxius = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_onyxius").setResistance(45.0F));
		//basic_gate_soularite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_soularite").setResistance(2000.0F));
		
		//basic_wall_arcanite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_arcanite", gemstone_basic_block_v1).setResistance(4.0F).setLightLevel(0.4f));
		//basic_wall_velious = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_velious", gemstone_basic_block_v1).setResistance(15.0F));
		//basic_wall_fenryte = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_fenryte", gemstone_basic_block_v1).setResistance(30.0F));
		//basic_wall_electium = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_electium", gemstone_basic_block_v1).setResistance(100.0F));
		//basic_wall_igneelis = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_igneelis", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_wall_necrocite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_necrocite", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_wall_zephyrium = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_zephyrium", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_wall_onyxius = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_onyxius", gemstone_basic_block_v1).setResistance(45.0F));
		//basic_wall_soularite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_soularite", gemstone_basic_block_v1).setResistance(2000.0F));
		
		//basic_torch_arcanite = registerBlock(new BlockTorchDraconiteVG("gemstone/regular/torch/basic_torch_arcanite").setResistance(4.0F));
		//basic_torch_velious = registerBlock(new BlockTorchVeliousVG("gemstone/regular/torch/basic_torch_velious").setResistance(15.0F));
		//basic_torch_fenryte = registerBlock(new BlockTorchArcaniteVG("gemstone/regular/torch/basic_torch_fenryte").setResistance(30.0F));
		//basic_torch_electium = registerBlock(new BlockTorchKatcheenVG("gemstone/regular/torch/basic_torch_electium").setResistance(100.0F));
		//basic_torch_igneelis = registerBlock(new BlockTorchCarnelianVG("gemstone/regular/torch/basic_torch_igneelis").setResistance(45.0F));
		//basic_torch_necrocite = registerBlock(new BlockTorchNecrociteVG("gemstone/regular/torch/basic_torch_necrocite").setResistance(45.0F));
		//basic_torch_zephyrium = registerBlock(new BlockTorchOnyxiusVG("gemstone/regular/torch/basic_torch_zephyrium").setResistance(45.0F));
		//basic_torch_onyxius = registerBlock(new BlockTorchSoulariteVG("gemstone/regular/torch/basic_torch_onyxius").setResistance(45.0F));
		//basic_torch_soularite = registerBlock(new BlockTorchEbonheartVG("gemstone/regular/torch/basic_torch_soularite").setResistance(2000.0F));

		//basic_trapdoor_arcanite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_arcanite").setResistance(4.0F));
		//basic_trapdoor_velious = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_velious").setResistance(15.0F));
		//basic_trapdoor_fenryte = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_fenryte").setResistance(30.0F));
		//basic_trapdoor_electium = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_electium").setResistance(100.0F));
		//basic_trapdoor_igneelis = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_igneelis").setResistance(45.0F));
		//basic_trapdoor_necrocite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_necrocite").setResistance(45.0F));
		//basic_trapdoor_zephyrium = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_zephyrium").setResistance(45.0F));
		//basic_trapdoor_onyxius = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_onyxius").setResistance(45.0F));
		//basic_trapdoor_soularite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_soularite").setResistance(2000.0F));

		//basic_ladder_arcanite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_arcanite").setResistance(4.0F));
		//basic_ladder_velious = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_velious").setResistance(15.0F));
		//basic_ladder_fenryte = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_fenryte").setResistance(30.0F));
		//basic_ladder_electium = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_electium").setResistance(100.0F));
		//basic_ladder_igneelis = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_igneelis").setResistance(45.0F));
		//basic_ladder_necrocite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_necrocite").setResistance(45.0F));
		//basic_ladder_zephyrium = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_zephyrium").setResistance(45.0F));
		//basic_ladder_onyxius = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_onyxius").setResistance(45.0F));
		//basic_ladder_soularite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_soularite").setResistance(2000.0F));

		//basic_pillar_arcanite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_arcanite").setResistance(4.0F));
		//basic_pillar_velious = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_velious").setResistance(15.0F));
		//basic_pillar_fenryte = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_fenryte").setResistance(30.0F));
		//basic_pillar_electium = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_electium").setResistance(100.0F));
		//basic_pillar_igneelis = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_igneelis").setResistance(45.0F));
		//basic_pillar_necrocite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_necrocite").setResistance(45.0F));
		//basic_pillar_zephyrium = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_zephyrium").setResistance(45.0F));
		//basic_pillar_onyxius = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_onyxius").setResistance(45.0F));
		//basic_pillar_soularite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_soularite").setResistance(2000.0F));
		
		
		
		
		
		
		
		
		
		/**
		gemstone_block_doubleslab_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_halfslab_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		
		gemstone_block_stairs_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_fence_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_gate_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_wall_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_torch_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_ladder_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_pillar_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_trapdoor_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		gemstone_block_fancybrick_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/basic/block_basic"));
		*/
		
		
		
		
		//gemstone_block_cryptic_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/cryptic/block_cryptic"));
		
		
		
		/**
		draconium_ore = registerBlock(new BlockOreDraconium(2, 0.4f, 10f));
		velious_ore = registerBlock(new BlockOreVelious(2, 15f));
		fenryte_ore = registerBlock(new BlockOreArcanite(2, 20f));
		electium_ore = registerBlock(new BlockOreKatcheen(3, 30f));
		necrocite_ore = registerBlock(new BlockOreNecrocite(3, 30f));
		onyxius_ore = registerBlock(new BlockOreSoularite(3, 30f));
		soularite_ore = registerBlock(new BlockOreEbonheart(3, 30f));
		ebon_ore = registerBlock(new BlockMultiOre("ore/ebon_ore"));
		ebon_ore_nether = registerBlock(new BlockMultiOre("ore/ebon_ore_nether"));
		
		draconium_block = registerBlock(new BlockEA("gem/draconium/draconium_block").setResistance(4.0F).setLightLevel(0.4f));
		velious_block = registerBlock(new BlockEA("gem/velious/velious_block").setResistance(15.0F));
		fenryte_block = registerBlock(new BlockEA("gem/fenryte/fenryte_block").setResistance(30.0F));
		electium_block = registerBlock(new BlockEA("gem/electium/electium_block").setResistance(100.0F));
		necrocite_block = registerBlock(new BlockEA("gem/necrocite/necrocite_block").setResistance(45.0F));
		onyxius_block = registerBlock(new BlockEA("gem/onyxius/onyxius_block").setResistance(45.0F));
		soularite_block = registerBlock(new BlockEA("gem/soularite/soularite_block").setResistance(2000.0F));
		obsidian_block = registerBlock(new BlockEA("gem/obsidian/obsidian_block").setResistance(2000.0F));
		glowstone_block = registerBlock(new BlockEA("gem/glowstone/glowstone_block").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_brick = registerBlock(new BlockEA("gem/draconium/draconium_block_brick").setResistance(4.0F).setLightLevel(0.4f));
		velious_block_brick = registerBlock(new BlockEA("gem/velious/velious_block_brick").setResistance(15.0F));
		fenryte_block_brick = registerBlock(new BlockEA("gem/fenryte/fenryte_block_brick").setResistance(30.0F));
		electium_block_brick = registerBlock(new BlockEA("gem/electium/electium_block_brick").setResistance(100.0F));
		necrocite_block_brick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_brick").setResistance(45.0F));
		onyxius_block_brick = registerBlock(new BlockEA("gem/onyxius/onyxius_block_brick").setResistance(45.0F));
		soularite_block_brick = registerBlock(new BlockEA("gem/soularite/soularite_block_brick").setResistance(2000.0F));
		obsidian_block_brick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_brick").setResistance(2000.0F));
		glowstone_block_brick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_stairs = registerBlock(new EABlockStairs("stairs/draconium_stairs", draconium_block).setResistance(4.0F).setLightLevel(0.4f));
		velious_stairs = registerBlock(new EABlockStairs("stairs/velious_stairs", velious_block).setResistance(15.0F));
		fenryte_stairs = registerBlock(new EABlockStairs("stairs/fenryte_stairs", fenryte_block).setResistance(30.0F));
		electium_stairs = registerBlock(new EABlockStairs("stairs/electium_stairs", electium_block).setResistance(100.0F));
		necrocite_stairs = registerBlock(new EABlockStairs("stairs/necrocite_stairs", necrocite_block).setResistance(45.0F));
		onyxius_stairs = registerBlock(new EABlockStairs("stairs/onyxius_stairs", onyxius_block).setResistance(45.0F));
		soularite_stairs = registerBlock(new EABlockStairs("stairs/soularite_stairs", soularite_block).setResistance(2000.0F));
		obsidian_stairs = registerBlock(new EABlockStairs("stairs/obsidian_stairs", obsidian_block).setResistance(2000.0F));
		glowstone_stairs = registerBlock(new EABlockStairs("stairs/glowstone_stairs", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence = registerBlock(new EABlockFence("fence/draconium_fence").setResistance(4.0F).setLightLevel(0.4f));
		velious_fence = registerBlock(new EABlockFence("fence/velious_fence").setResistance(15.0F));
		fenryte_fence = registerBlock(new EABlockFence("fence/fenryte_fence").setResistance(30.0F));
		electium_fence = registerBlock(new EABlockFence("fence/electium_fence").setResistance(100.0F));
		necrocite_fence = registerBlock(new EABlockFence("fence/necrocite_fence").setResistance(45.0F));
		onyxius_fence = registerBlock(new EABlockFence("fence/onyxius_fence").setResistance(45.0F));
		soularite_fence = registerBlock(new EABlockFence("fence/soularite_fence").setResistance(2000.0F));
		obsidian_fence = registerBlock(new EABlockFence("fence/obsidian_fence").setResistance(2000.0F));
		glowstone_fence = registerBlock(new EABlockFence("fence/glowstone_fence").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence_gate = registerBlock(new EABlockFenceGate("fence/draconium_fence_gate").setResistance(4.0F).setLightLevel(0.4f));
		velious_fence_gate = registerBlock(new EABlockFenceGate("fence/velious_fence_gate").setResistance(15.0F));
		fenryte_fence_gate = registerBlock(new EABlockFenceGate("fence/fenryte_fence_gate").setResistance(30.0F));
		electium_fence_gate = registerBlock(new EABlockFenceGate("fence/electium_fence_gate").setResistance(100.0F));
		necrocite_fence_gate = registerBlock(new EABlockFenceGate("fence/necrocite_fence_gate").setResistance(45.0F));
		onyxius_fence_gate = registerBlock(new EABlockFenceGate("fence/onyxius_fence_gate").setResistance(45.0F));
		soularite_fence_gate = registerBlock(new EABlockFenceGate("fence/soularite_fence_gate").setResistance(2000.0F));
		obsidian_fence_gate = registerBlock(new EABlockFenceGate("fence/obsidian_fence_gate").setResistance(2000.0F));
		glowstone_fence_gate = registerBlock(new EABlockFenceGate("fence/glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_wall 	= registerBlock(new EABlockWall("wall/draconium_wall", draconium_block).setResistance(4.0F).setLightLevel(0.4f));
		velious_wall 	= registerBlock(new EABlockWall("wall/velious_wall", velious_block).setResistance(15.0F));
		fenryte_wall 	= registerBlock(new EABlockWall("wall/fenryte_wall", fenryte_block).setResistance(30.0F));
		electium_wall 	= registerBlock(new EABlockWall("wall/electium_wall", electium_block).setResistance(100.0F));
		necrocite_wall 	= registerBlock(new EABlockWall("wall/necrocite_wall", necrocite_block).setResistance(45.0F));
		onyxius_wall 	= registerBlock(new EABlockWall("wall/onyxius_wall", onyxius_block).setResistance(45.0F));
		soularite_wall 	= registerBlock(new EABlockWall("wall/soularite_wall", soularite_block).setResistance(2000.0F));
		obsidian_wall 	= registerBlock(new EABlockWall("wall/obsidian_wall", obsidian_block).setResistance(2000.0F));
		glowstone_wall	= registerBlock(new EABlockWall("wall/glowstone_wall", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		fenryte_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		electium_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		onyxius_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		soularite_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		draconium_trapdoor = registerBlock(new EABlockTrapDoor("door/draconium_trapdoor").setResistance(4.0F).setLightLevel(0.4f));
		velious_trapdoor = registerBlock(new EABlockTrapDoor("door/velious_trapdoor").setResistance(4.0F));
		fenryte_trapdoor = registerBlock(new EABlockTrapDoor("door/fenryte_trapdoor").setResistance(4.0F));
		electium_trapdoor = registerBlock(new EABlockTrapDoor("door/electium_trapdoor").setResistance(4.0F));
		necrocite_trapdoor = registerBlock(new EABlockTrapDoor("door/necrocite_trapdoor").setResistance(4.0F));
		onyxius_trapdoor = registerBlock(new EABlockTrapDoor("door/onyxius_trapdoor").setResistance(4.0F));
		soularite_trapdoor = registerBlock(new EABlockTrapDoor("door/soularite_trapdoor").setResistance(4.0F));
		obsidian_trapdoor = registerBlock(new EABlockTrapDoor("door/obsidian_trapdoor").setResistance(4.0F));
		glowstone_trapdoor = registerBlock(new EABlockTrapDoor("door/glowstone_trapdoor").setResistance(4.0F));
		
		draconium_ladder = registerBlock(new EABlockLadder("ladder/draconium_ladder").setLightLevel(0.4f));
		velious_ladder = registerBlock(new EABlockLadder("ladder/velious_ladder"));
		fenryte_ladder = registerBlock(new EABlockLadder("ladder/fenryte_ladder"));
		electium_ladder = registerBlock(new EABlockLadder("ladder/electium_ladder"));
		necrocite_ladder = registerBlock(new EABlockLadder("ladder/necrocite_ladder"));
		onyxius_ladder = registerBlock(new EABlockLadder("ladder/onyxius_ladder"));
		soularite_ladder = registerBlock(new EABlockLadder("ladder/soularite_ladder"));
		obsidian_ladder = registerBlock(new EABlockLadder("ladder/obsidian_ladder"));
		glowstone_ladder = registerBlock(new EABlockLadder("ladder/glowstone_ladder").setLightLevel(1.0f));
		
		draconium_pillar = registerBlock(new EABlockPillar("pillar/draconium_pillar").setResistance(4.0F).setLightLevel(0.4f));
		velious_pillar = registerBlock(new EABlockPillar("pillar/velious_pillar").setResistance(15.0F));
		fenryte_pillar = registerBlock(new EABlockPillar("pillar/fenryte_pillar").setResistance(30.0F));
		electium_pillar = registerBlock(new EABlockPillar("pillar/electium_pillar").setResistance(100.0F));
		necrocite_pillar = registerBlock(new EABlockPillar("pillar/necrocite_pillar").setResistance(45.0F));
		onyxius_pillar = registerBlock(new EABlockPillar("pillar/onyxius_pillar").setResistance(45.0F));
		soularite_pillar = registerBlock(new EABlockPillar("pillar/soularite_pillar").setResistance(2000.0F));
		obsidian_pillar = registerBlock(new EABlockPillar("pillar/obsidian_pillar").setResistance(2000.0F));
		glowstone_pillar = registerBlock(new EABlockPillar("pillar/glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_fancybrick = registerBlock(new BlockEA("gem/draconium/draconium_block_fancybrick").setResistance(4.0F).setLightLevel(0.4f));
		velious_block_fancybrick = registerBlock(new BlockEA("gem/velious/velious_block_fancybrick").setResistance(15.0F));
		fenryte_block_fancybrick = registerBlock(new BlockEA("gem/fenryte/fenryte_block_fancybrick").setResistance(30.0F));
		electium_block_fancybrick = registerBlock(new BlockEA("gem/electium/electium_block_fancybrick").setResistance(100.0F));
		necrocite_block_fancybrick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_fancybrick").setResistance(45.0F));
		onyxius_block_fancybrick = registerBlock(new BlockEA("gem/onyxius/onyxius_block_fancybrick").setResistance(45.0F));
		soularite_block_fancybrick = registerBlock(new BlockEA("gem/soularite/soularite_block_fancybrick").setResistance(2000.0F));
		obsidian_block_fancybrick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_fancybrick").setResistance(2000.0F));
		glowstone_block_fancybrick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f));
		
		cobble_mystic_block_normal = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_normal"));
		cobble_mystic_block_glass = registerBlock(new BlockMysticCobblestoneGlass("gem/mystic/cobblestone/cobble_mystic_block_glass"));
		cobble_mystic_block_white = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_white"));
		cobble_mystic_block_orange = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_orange"));
		cobble_mystic_block_magenta = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_magenta"));
		cobble_mystic_block_lightblue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightblue"));
		cobble_mystic_block_yellow = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_yellow"));
		cobble_mystic_block_lime = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lime"));
		cobble_mystic_block_pink = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_pink"));
		cobble_mystic_block_gray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_gray"));
		cobble_mystic_block_lightgray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightgray"));
		cobble_mystic_block_cyan = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_cyan"));
		cobble_mystic_block_purple = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_purple"));
		cobble_mystic_block_blue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_blue"));
		cobble_mystic_block_brown = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_brown"));
		cobble_mystic_block_green = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_green"));
		cobble_mystic_block_red = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_red"));
		cobble_mystic_block_black = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_black"));
		
		mystic_block_normal = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_normal"));
		mystic_block_glass = registerBlock(new BlockMysticStoneGlass("gem/mystic/stone/mystic_block_glass"));
		mystic_block_white = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_white"));
		mystic_block_orange = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_orange"));
		mystic_block_magenta = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_magenta"));
		mystic_block_lightblue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightblue"));
		mystic_block_yellow = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_yellow"));
		mystic_block_lime = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lime"));
		mystic_block_pink = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_pink"));
		mystic_block_gray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_gray"));
		mystic_block_lightgray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightgray"));
		mystic_block_cyan = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_cyan"));
		mystic_block_purple = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_purple"));
		mystic_block_blue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_blue"));
		mystic_block_brown = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_brown"));
		mystic_block_green = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_green"));
		mystic_block_red = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_red"));
		mystic_block_black = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_black"));
		
		wood_mystic_block_normal = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_normal"));
		wood_mystic_block_glass = registerBlock(new BlockMysticWoodGlass("gem/mystic/wood/wood_mystic_block_glass"));
		wood_mystic_block_white = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_white"));
		wood_mystic_block_orange = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_orange"));
		wood_mystic_block_magenta = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_magenta"));
		wood_mystic_block_lightblue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightblue"));
		wood_mystic_block_yellow = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_yellow"));
		wood_mystic_block_lime = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lime"));
		wood_mystic_block_pink = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_pink"));
		wood_mystic_block_gray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_gray"));
		wood_mystic_block_lightgray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightgray"));
		wood_mystic_block_cyan = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_cyan"));
		wood_mystic_block_purple = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_purple"));
		wood_mystic_block_blue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_blue"));
		wood_mystic_block_brown = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_brown"));
		wood_mystic_block_green = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_green"));
		wood_mystic_block_red = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_red"));
		wood_mystic_block_black = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_black"));
		
		necrocite_ore_end = registerBlock(new BlockEndOreNecrocite(3, 30f));
		onyxius_ore_end = registerBlock(new BlockEndOreSoularite(3, 30f));
		soularite_ore_end = registerBlock(new BlockEndOreEbonheart(3, 30f));
		ebon_ore_end = registerBlock(new BlockMultiOre("ore/ebon_ore_end"));
		
		paper_block = registerBlock(new EABlockDirectional("paper_block").setResistance(4.0F));
		leather_block = registerBlock(new EABlockDirectional("leather_block").setResistance(4.0F));
		reed_block = registerBlock(new EABlockDirectional("reed_block").setResistance(4.0F));
		
		//hellion_fruit = registerBlock(new HellionFruitCrop());
		//sacred_fruit = registerBlock(new SacredFruitCrop());
		//dragon_fruit = registerBlock(new DragonFruitCrop());
		
		
		
		//----------------------------------------------
		
		
		
		cryptic_draconium_block = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_block = registerBlock(new BlockEA("cryptic/block/cryptic_fenryte_block").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_block = registerBlock(new BlockEA("cryptic/block/cryptic_electium_block").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_block = registerBlock(new BlockEA("cryptic/block/cryptic_onyxius_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_brick").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_brick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_fenryte_block_brick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_electium_block_brick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_onyxius_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		double_cryptic_draconium_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_draconium_slab", "cryptic/slab/double_cryptic_draconium_slab").setResistance(4.0F).setLightLevel(0.4f);
		double_cryptic_velious_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_velious_slab", "cryptic/slab/double_cryptic_velious_slab").setResistance(15.0F);
		double_cryptic_fenryte_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_fenryte_slab", "cryptic/slab/double_cryptic_fenryte_slab").setResistance(30.0F);
		double_cryptic_electium_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_electium_slab", "cryptic/slab/double_cryptic_electium_slab").setResistance(100.0F);
		double_cryptic_necrocite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_necrocite_slab", "cryptic/slab/double_cryptic_necrocite_slab").setResistance(45.0F);
		double_cryptic_onyxius_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_onyxius_slab", "cryptic/slab/double_cryptic_onyxius_slab").setResistance(45.0F);
		double_cryptic_soularite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_soularite_slab", "cryptic/slab/double_cryptic_soularite_slab").setResistance(2000.0F);
		double_cryptic_obsidian_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_obsidian_slab", "cryptic/slab/double_cryptic_obsidian_slab").setResistance(2000.0F);
		double_cryptic_glowstone_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_glowstone_slab", "cryptic/slab/double_cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		cryptic_draconium_slab = new BlockHalfSlab("cryptic/slab/cryptic_draconium_slab", "cryptic/slab/cryptic_draconium_slab").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_velious_slab = new BlockHalfSlab("cryptic/slab/cryptic_velious_slab", "cryptic/slab/cryptic_velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_fenryte_slab = new BlockHalfSlab("cryptic/slab/cryptic_fenryte_slab", "cryptic/slab/cryptic_fenryte_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_electium_slab = new BlockHalfSlab("cryptic/slab/cryptic_electium_slab", "cryptic/slab/cryptic_electium_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_necrocite_slab = new BlockHalfSlab("cryptic/slab/cryptic_necrocite_slab", "cryptic/slab/cryptic_necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_onyxius_slab = new BlockHalfSlab("cryptic/slab/cryptic_onyxius_slab", "cryptic/slab/cryptic_onyxius_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_soularite_slab = new BlockHalfSlab("cryptic/slab/cryptic_soularite_slab", "cryptic/slab/cryptic_soularite_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_obsidian_slab = new BlockHalfSlab("cryptic/slab/cryptic_obsidian_slab", "cryptic/slab/cryptic_obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_glowstone_slab = new BlockHalfSlab("cryptic/slab/cryptic_glowstone_slab", "cryptic/slab/cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		
		registerBlockSlab(cryptic_draconium_slab, double_cryptic_draconium_slab);
		registerBlockSlab(cryptic_velious_slab, double_cryptic_velious_slab);
		registerBlockSlab(cryptic_fenryte_slab, double_cryptic_fenryte_slab);
		registerBlockSlab(cryptic_electium_slab, double_cryptic_electium_slab);
		registerBlockSlab(cryptic_necrocite_slab, double_cryptic_necrocite_slab);
		registerBlockSlab(cryptic_onyxius_slab, double_cryptic_onyxius_slab);
		registerBlockSlab(cryptic_soularite_slab, double_cryptic_soularite_slab);
		registerBlockSlab(cryptic_obsidian_slab, double_cryptic_obsidian_slab);
		registerBlockSlab(cryptic_glowstone_slab, double_cryptic_glowstone_slab);
		
		cryptic_draconium_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_draconium_stairs", cryptic_draconium_block).setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_velious_stairs", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_fenryte_stairs", cryptic_fenryte_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_electium_stairs", cryptic_electium_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_necrocite_stairs", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_onyxius_stairs", cryptic_onyxius_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_soularite_stairs", cryptic_soularite_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_obsidian_stairs", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_glowstone_stairs", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_draconium_fence").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_velious_fence").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_fenryte_fence").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_electium_fence").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_necrocite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_onyxius_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_soularite_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_obsidian_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_glowstone_fence").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_draconium_fence_gate").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_velious_fence_gate").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_fenryte_fence_gate").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_electium_fence_gate").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_necrocite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_onyxius_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_soularite_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_obsidian_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_draconium_wall", cryptic_draconium_block).setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_velious_wall", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_fenryte_wall", cryptic_fenryte_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_electium_wall", cryptic_electium_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_necrocite_wall", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_onyxius_wall", cryptic_onyxius_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_soularite_wall", cryptic_soularite_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_obsidian_wall", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_glowstone_wall", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		//cryptic_draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		//cryptic_velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		//cryptic_fenryte_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		//cryptic_electium_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		//cryptic_necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		//cryptic_onyxius_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		//cryptic_soularite_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		//cryptic_obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		//cryptic_glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		cryptic_draconium_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_draconium_trapdoor").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_velious_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_fenryte_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_electium_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_necrocite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_onyxius_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_soularite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_obsidian_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_glowstone_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_draconium_ladder").setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_velious_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_fenryte_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_electium_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_necrocite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_onyxius_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_soularite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_obsidian_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_glowstone_ladder").setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_draconium_pillar").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_velious_pillar").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_fenryte_pillar").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_electium_pillar").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_necrocite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_onyxius_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_soularite_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_obsidian_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_fancybrick").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_fancybrick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_fenryte_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_fenryte_block_fancybrick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_electium_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_electium_block_fancybrick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_onyxius_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_onyxius_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		*//**
	}
	
	
	
	protected static <V extends Block> V registerBlock(V block)
	{
		return registerBlock(block, ItemBlock::new);
	}
	
	/**
	 * Register a basic Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
/**	protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) 
	{
		GameRegistry.register(block);
		
		if (itemFactory != null) 
		{
			final ItemBlock itemBlock = itemFactory.apply(block);
			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		
		blocks.add(block);
		return block;
	}
	
	protected static <V extends Block> V registerBlockMetaGemstoneBasicV1(V block)
	{
		return registerBlock(block, ItemBlockGemstoneBasicV1::new);
	}
	
	/**
	 * Register a "meta" Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
/**	protected static <BLOCK extends Block> BLOCK registerBlockMetaGemstoneBasicV1(BLOCK block, @Nullable Function<BLOCK, ItemBlockGemstoneBasicV1> itemFactory) 
	{
		GameRegistry.register(block);
		
		if (itemFactory != null) 
		{
			final ItemBlockGemstoneBasicV1 itemBlock = itemFactory.apply(block);
			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		
		blocks.add(block);
		return block;
	}
	
	protected static <V extends Block> V registerBlockMetaGemstoneOre(V block)
	{
		return registerBlock(block, ItemBlockOreVG::new);
	}
	
	/**
	 * Register a "meta" Ore Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
/**	protected static <BLOCK extends Block> BLOCK registerBlockMetaGemstoneOre(BLOCK block, @Nullable Function<BLOCK, ItemBlockOreVG> itemFactory) 
	{
		GameRegistry.register(block);
		
		if (itemFactory != null) 
		{
			final ItemBlockOreVG itemBlock = itemFactory.apply(block);
			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		
		blocks.add(block);
		return block;
	}
	
	private static void registerBlockSlab(Block slab, Block doubleslab)
	{
		GameRegistry.register(slab);
		GameRegistry.register(doubleslab);
		ItemSlab item = new ItemSlab(slab, (BlockSlab) slab, (BlockSlab) doubleslab);
		item.setRegistryName(slab.getRegistryName());
		GameRegistry.register(item);
	}

	
	
}*/

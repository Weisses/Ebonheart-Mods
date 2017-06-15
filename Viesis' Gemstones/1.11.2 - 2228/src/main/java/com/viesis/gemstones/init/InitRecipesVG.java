package com.viesis.gemstones.init;

import com.viesis.gemstones.configs.ViesisGemstonesConfig;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitRecipesVG {
	
	public static void initShapedRecipe()
	{
		/**
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_draconium_dust), new Object[]{"###", "###", "###", '#', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_velious), new Object[]{"###", "###", "###", '#', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_arcanite), new Object[]{"###", "###", "###", '#', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_katcheen), new Object[]{"###", "###", "###", '#', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_necrocite), new Object[]{"###", "###", "###", '#', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dense_soularite), new Object[]{"###", "###", "###", '#', InitItemsEA.soularite});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.enchanted_ebonheart, 1), new Object[]{"EGE", "G#G", "EGE", 'G', Items.GLOWSTONE_DUST, 'E', Items.ENDER_PEARL, '#', InitItemsEA.ebonheart});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.glowing_disc, 1), new Object[]{"DDD", "D#D", "DDD", '#', Items.DIAMOND,'D', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.shimmering_disc, 1), new Object[]{"VVV", "V#V", "VVV", '#', Items.DIAMOND,'V', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.laminate_disc, 1), new Object[]{"AAA", "A#A", "AAA", '#', Items.DIAMOND,'A', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.resilient_disc, 1), new Object[]{"KKK", "K#K", "KKK", '#', Items.DIAMOND,'K', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.dismal_disc, 1), new Object[]{"NNN", "N#N", "NNN", '#', Items.DIAMOND,'N', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.ethereal_disc, 1), new Object[]{"SSS", "S#S", "SSS", '#', Items.DIAMOND,'S', InitItemsEA.soularite});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal, 8), new Object[]{"CCC", "CEC", "CCC", 'E', InitItemsEA.ebonheart, 'C', Blocks.COBBLESTONE});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.mystic_block_normal, 8), new Object[]{"SSS", "SES", "SSS", 'E', InitItemsEA.ebonheart, 'S', Blocks.STONE});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal, 8), new Object[]{"WWW", "WEW", "WWW", 'E', InitItemsEA.ebonheart, 'W', Blocks.PLANKS});
		
		if(!EbonArtsConfig.storageRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.paper_block), new Object[]{"PPP", "P P", "PPP", 'P', Items.PAPER});
			GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.reed_block), new Object[]{"RRR", "R R", "RRR", 'R', Items.REEDS});
			GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.leather_block), new Object[]{"LLL", "L L", "LLL", 'L', Items.LEATHER});
		}
		
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.obsidian_shards), new Object[]{"DGD", "GQG", "DGD", 'D', InitItemsEA.draconium_dust, 'G', Items.GUNPOWDER, 'Q', Items.QUARTZ});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.obsidian_shards, 4), new Object[]{"DGD", "GQG", "DGD", 'D', InitItemsEA.draconium_dust, 'G', Items.GUNPOWDER, 'Q', Blocks.OBSIDIAN});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.glowstone_shards), new Object[]{"DGD", "GQG", "DGD", 'D', InitItemsEA.draconium_dust, 'G', Items.GUNPOWDER, 'Q', Items.GLOWSTONE_DUST});
		GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.glowstone_shards, 4), new Object[]{"DGD", "GQG", "DGD", 'D', InitItemsEA.draconium_dust, 'G', Items.GUNPOWDER, 'Q', Blocks.GLOWSTONE});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_block), new Object[]{"##", "##", '#', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_slab, 6), new Object[]{"DDD", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_stairs, 4), new Object[]{"  D", " DD", "DDD", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_stairs, 4), new Object[]{"D  ", "DD ", "DDD", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_stairs, 4), new Object[]{"DDD", " DD", "  D", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_stairs, 4), new Object[]{"DDD", "DD ", "D  ", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_fence, 3), new Object[]{"D#D", "D#D", 'D', InitBlocksEA.draconium_block, '#', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_fence_gate), new Object[]{"#D#", "#D#", 'D', InitBlocksEA.draconium_block, '#', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_wall, 3), new Object[]{"DDD", "DDD", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_block_brick, 4), new Object[]{"DD", "DD", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_torch, 4), new Object[]{"C", "D", 'D', InitBlocksEA.draconium_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_torch, 4), new Object[]{"C", "D", 'D', InitBlocksEA.draconium_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_ladder, 4), new Object[]{"D D", "DDD", "D D", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_pillar, 2), new Object[]{"D", "D", 'D', InitBlocksEA.draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.draconium_block_fancybrick, 2), new Object[]{"D", "D", 'D', InitBlocksEA.draconium_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_block), new Object[]{"##", "##", '#', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_slab, 6), new Object[]{"VVV", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_stairs, 4), new Object[]{"  V", " VV", "VVV", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_stairs, 4), new Object[]{"V  ", "VV ", "VVV", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_stairs, 4), new Object[]{"VVV", " VV", "  V", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_stairs, 4), new Object[]{"VVV", "VV ", "V  ", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_fence, 3), new Object[]{"V#V", "V#V", 'V', InitBlocksEA.velious_block, '#', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_fence_gate), new Object[]{"#V#", "#V#", 'V', InitBlocksEA.velious_block, '#', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_wall, 3), new Object[]{"VVV", "VVV", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_block_brick, 4), new Object[]{"VV", "VV", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_torch, 4), new Object[]{"C", "V", 'V', InitBlocksEA.velious_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_torch, 4), new Object[]{"C", "V", 'V', InitBlocksEA.velious_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_ladder, 4), new Object[]{"V V", "VVV", "V V", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_pillar, 2), new Object[]{"V", "V", 'V', InitBlocksEA.velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.velious_block_fancybrick, 2), new Object[]{"V", "V", 'V', InitBlocksEA.velious_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_block), new Object[]{"##", "##", '#', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_slab, 6), new Object[]{"AAA", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_stairs, 4), new Object[]{"  A", " AA", "AAA", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_stairs, 4), new Object[]{"A  ", "AA ", "AAA", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_stairs, 4), new Object[]{"AAA", " AA", "  A", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_stairs, 4), new Object[]{"AAA", "AA ", "A  ", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_fence, 3), new Object[]{"A#A", "A#A", 'A', InitBlocksEA.arcanite_block, '#', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_fence_gate), new Object[]{"#A#", "#A#", 'A', InitBlocksEA.arcanite_block, '#', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_wall, 3), new Object[]{"AAA", "AAA", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_block_brick, 4), new Object[]{"AA", "AA", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_torch, 4), new Object[]{"C", "A", 'A', InitBlocksEA.arcanite_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_torch, 4), new Object[]{"C", "A", 'A', InitBlocksEA.arcanite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_ladder, 4), new Object[]{"A A", "AAA", "A A", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_pillar, 2), new Object[]{"A", "A", 'A', InitBlocksEA.arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.arcanite_block_fancybrick, 2), new Object[]{"A", "A", 'A', InitBlocksEA.arcanite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_block), new Object[]{"##", "##", '#', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_slab, 6), new Object[]{"KKK", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_stairs, 4), new Object[]{"  K", " KK", "KKK", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_stairs, 4), new Object[]{"K  ", "KK ", "KKK", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_stairs, 4), new Object[]{"KKK", " KK", "  K", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_stairs, 4), new Object[]{"KKK", "KK ", "K  ", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_fence, 3), new Object[]{"K#K", "K#K", 'K', InitBlocksEA.katcheen_block, '#', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_fence_gate), new Object[]{"#K#", "#K#", 'K', InitBlocksEA.katcheen_block, '#', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_wall, 3), new Object[]{"KKK", "KKK", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_block_brick, 4), new Object[]{"KK", "KK", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_torch, 4), new Object[]{"C", "K", 'K', InitBlocksEA.katcheen_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_torch, 4), new Object[]{"C", "K", 'K', InitBlocksEA.katcheen_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_ladder, 4), new Object[]{"K K", "KKK", "K K", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_pillar, 2), new Object[]{"K", "K", 'K', InitBlocksEA.katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.katcheen_block_fancybrick, 2), new Object[]{"K", "K", 'K', InitBlocksEA.katcheen_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_block), new Object[]{"##", "##", '#', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_slab, 6), new Object[]{"NNN", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_stairs, 4), new Object[]{"  N", " NN", "NNN", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_stairs, 4), new Object[]{"N  ", "NN ", "NNN", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_stairs, 4), new Object[]{"NNN", " NN", "  N", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_stairs, 4), new Object[]{"NNN", "NN ", "N  ", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_fence, 3), new Object[]{"N#N", "N#N", 'N', InitBlocksEA.necrocite_block, '#', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_fence_gate), new Object[]{"#N#", "#N#", 'N', InitBlocksEA.necrocite_block, '#', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_wall, 3), new Object[]{"NNN", "NNN", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_block_brick, 4), new Object[]{"NN", "NN", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_torch, 4), new Object[]{"C", "N", 'N', InitBlocksEA.necrocite_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_torch, 4), new Object[]{"C", "N", 'N', InitBlocksEA.necrocite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_ladder, 4), new Object[]{"N N", "NNN", "N N", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_pillar, 2), new Object[]{"N", "N", 'N', InitBlocksEA.necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.necrocite_block_fancybrick, 2), new Object[]{"N", "N", 'N', InitBlocksEA.necrocite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_block), new Object[]{"##", "##", '#', InitItemsEA.soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_slab, 6), new Object[]{"SSS", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_stairs, 4), new Object[]{"  S", " SS", "SSS", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_stairs, 4), new Object[]{"S  ", "SS ", "SSS", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_stairs, 4), new Object[]{"SSS", " SS", "  S", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_stairs, 4), new Object[]{"SSS", "SS ", "S  ", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_fence, 3), new Object[]{"S#S", "S#S", 'S', InitBlocksEA.soularite_block, '#', InitItemsEA.soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_fence_gate), new Object[]{"#S#", "#S#", 'S', InitBlocksEA.soularite_block, '#', InitItemsEA.soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_wall, 3), new Object[]{"SSS", "SSS", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_block_brick, 4), new Object[]{"SS", "SS", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.soularite_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.soularite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_ladder, 4), new Object[]{"S S", "SSS", "S S", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_pillar, 2), new Object[]{"S", "S", 'S', InitBlocksEA.soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.soularite_block_fancybrick, 2), new Object[]{"S", "S", 'S', InitBlocksEA.soularite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_block), new Object[]{"##", "##", '#', InitItemsEA.obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_slab, 6), new Object[]{"OOO", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_stairs, 4), new Object[]{"  O", " OO", "OOO", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_stairs, 4), new Object[]{"O  ", "OO ", "OOO", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_stairs, 4), new Object[]{"OOO", " OO", "  O", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_stairs, 4), new Object[]{"OOO", "OO ", "O  ", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_fence, 3), new Object[]{"O#O", "O#O", 'O', InitBlocksEA.obsidian_block, '#', InitItemsEA.obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_fence_gate), new Object[]{"#O#", "#O#", 'O', InitBlocksEA.obsidian_block, '#', InitItemsEA.obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_wall, 3), new Object[]{"OOO", "OOO", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_block_brick, 4), new Object[]{"OO", "OO", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_torch, 4), new Object[]{"C", "O", 'O', InitBlocksEA.obsidian_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_torch, 4), new Object[]{"C", "O", 'O', InitBlocksEA.obsidian_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_ladder, 4), new Object[]{"O O", "OOO", "O O", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_pillar, 2), new Object[]{"O", "O", 'O', InitBlocksEA.obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.obsidian_block_fancybrick, 2), new Object[]{"O", "O", 'O', InitBlocksEA.obsidian_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_block), new Object[]{"##", "##", '#', InitItemsEA.glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_slab, 6), new Object[]{"GGG", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_stairs, 4), new Object[]{"  G", " GG", "GGG", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_stairs, 4), new Object[]{"G  ", "GG ", "GGG", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_stairs, 4), new Object[]{"GGG", " GG", "  G", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_stairs, 4), new Object[]{"GGG", "GG ", "G  ", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_fence, 3), new Object[]{"G#G", "G#G", 'G', InitBlocksEA.glowstone_block, '#', InitItemsEA.glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_fence_gate), new Object[]{"#G#", "#G#", 'G', InitBlocksEA.glowstone_block, '#', InitItemsEA.glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_wall, 3), new Object[]{"GGG", "GGG", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_block_brick, 4), new Object[]{"GG", "GG", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_torch, 4), new Object[]{"C", "G", 'G', InitBlocksEA.glowstone_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_torch, 4), new Object[]{"C", "G", 'G', InitBlocksEA.glowstone_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_ladder, 4), new Object[]{"G G", "GGG", "G G", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_pillar, 2), new Object[]{"G", "G", 'G', InitBlocksEA.glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.glowstone_block_fancybrick, 2), new Object[]{"G", "G", 'G', InitBlocksEA.glowstone_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_block), new Object[]{"##", "##", '#', InitItemsEA.ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_slab, 6), new Object[]{"SSS", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_stairs, 4), new Object[]{"  S", " SS", "SSS", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_stairs, 4), new Object[]{"S  ", "SS ", "SSS", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_stairs, 4), new Object[]{"SSS", " SS", "  S", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_stairs, 4), new Object[]{"SSS", "SS ", "S  ", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_fence, 3), new Object[]{"S#S", "S#S", 'S', InitBlocksEA.ebonheart_block, '#', InitItemsEA.ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_fence_gate), new Object[]{"#S#", "#S#", 'S', InitBlocksEA.ebonheart_block, '#', InitItemsEA.ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_wall, 3), new Object[]{"SSS", "SSS", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_block_brick, 4), new Object[]{"SS", "SS", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.ebonheart_block, 'C', Items.COAL});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.ebonheart_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_ladder, 4), new Object[]{"S S", "SSS", "S S", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_pillar, 2), new Object[]{"S", "S", 'S', InitBlocksEA.ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.ebonheart_block_fancybrick, 2), new Object[]{"S", "S", 'S', InitBlocksEA.ebonheart_block_brick});
		
		//====================================================================
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_slab, 6), new Object[]{"DDD", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_stairs, 4), new Object[]{"  D", " DD", "DDD", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_stairs, 4), new Object[]{"D  ", "DD ", "DDD", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_stairs, 4), new Object[]{"DDD", " DD", "  D", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_stairs, 4), new Object[]{"DDD", "DD ", "D  ", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_fence, 3), new Object[]{"D#D", "D#D", 'D', InitBlocksEA.cryptic_draconium_block, '#', InitItemsEA.cryptic_draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_fence_gate), new Object[]{"#D#", "#D#", 'D', InitBlocksEA.cryptic_draconium_block, '#', InitItemsEA.cryptic_draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_wall, 3), new Object[]{"DDD", "DDD", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_block_brick, 4), new Object[]{"DD", "DD", 'D', InitBlocksEA.cryptic_draconium_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_torch, 4), new Object[]{"C", "D", 'D', InitBlocksEA.cryptic_draconium_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_torch, 4), new Object[]{"C", "D", 'D', InitBlocksEA.cryptic_draconium_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_ladder, 4), new Object[]{"D D", "DDD", "D D", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_pillar, 2), new Object[]{"D", "D", 'D', InitBlocksEA.cryptic_draconium_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_draconium_dust});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_draconium_block_fancybrick, 2), new Object[]{"D", "D", 'D', InitBlocksEA.cryptic_draconium_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_slab, 6), new Object[]{"VVV", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_stairs, 4), new Object[]{"  V", " VV", "VVV", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_stairs, 4), new Object[]{"V  ", "VV ", "VVV", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_stairs, 4), new Object[]{"VVV", " VV", "  V", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_stairs, 4), new Object[]{"VVV", "VV ", "V  ", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_fence, 3), new Object[]{"V#V", "V#V", 'V', InitBlocksEA.cryptic_velious_block, '#', InitItemsEA.cryptic_velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_fence_gate), new Object[]{"#V#", "#V#", 'V', InitBlocksEA.cryptic_velious_block, '#', InitItemsEA.cryptic_velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_wall, 3), new Object[]{"VVV", "VVV", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_block_brick, 4), new Object[]{"VV", "VV", 'V', InitBlocksEA.cryptic_velious_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_torch, 4), new Object[]{"C", "V", 'V', InitBlocksEA.cryptic_velious_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_torch, 4), new Object[]{"C", "V", 'V', InitBlocksEA.cryptic_velious_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_ladder, 4), new Object[]{"V V", "VVV", "V V", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_pillar, 2), new Object[]{"V", "V", 'V', InitBlocksEA.cryptic_velious_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_velious});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_velious_block_fancybrick, 2), new Object[]{"V", "V", 'V', InitBlocksEA.cryptic_velious_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_slab, 6), new Object[]{"AAA", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_stairs, 4), new Object[]{"  A", " AA", "AAA", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_stairs, 4), new Object[]{"A  ", "AA ", "AAA", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_stairs, 4), new Object[]{"AAA", " AA", "  A", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_stairs, 4), new Object[]{"AAA", "AA ", "A  ", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_fence, 3), new Object[]{"A#A", "A#A", 'A', InitBlocksEA.cryptic_arcanite_block, '#', InitItemsEA.cryptic_arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_fence_gate), new Object[]{"#A#", "#A#", 'A', InitBlocksEA.cryptic_arcanite_block, '#', InitItemsEA.cryptic_arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_wall, 3), new Object[]{"AAA", "AAA", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_block_brick, 4), new Object[]{"AA", "AA", 'A', InitBlocksEA.cryptic_arcanite_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_torch, 4), new Object[]{"C", "A", 'A', InitBlocksEA.cryptic_arcanite_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_torch, 4), new Object[]{"C", "A", 'A', InitBlocksEA.cryptic_arcanite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_ladder, 4), new Object[]{"A A", "AAA", "A A", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_pillar, 2), new Object[]{"A", "A", 'A', InitBlocksEA.cryptic_arcanite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_arcanite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_arcanite_block_fancybrick, 2), new Object[]{"A", "A", 'A', InitBlocksEA.cryptic_arcanite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_slab, 6), new Object[]{"KKK", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_stairs, 4), new Object[]{"  K", " KK", "KKK", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_stairs, 4), new Object[]{"K  ", "KK ", "KKK", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_stairs, 4), new Object[]{"KKK", " KK", "  K", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_stairs, 4), new Object[]{"KKK", "KK ", "K  ", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_fence, 3), new Object[]{"K#K", "K#K", 'K', InitBlocksEA.cryptic_katcheen_block, '#', InitItemsEA.cryptic_katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_fence_gate), new Object[]{"#K#", "#K#", 'K', InitBlocksEA.cryptic_katcheen_block, '#', InitItemsEA.cryptic_katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_wall, 3), new Object[]{"KKK", "KKK", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_block_brick, 4), new Object[]{"KK", "KK", 'K', InitBlocksEA.cryptic_katcheen_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_torch, 4), new Object[]{"C", "K", 'K', InitBlocksEA.cryptic_katcheen_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_torch, 4), new Object[]{"C", "K", 'K', InitBlocksEA.cryptic_katcheen_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_ladder, 4), new Object[]{"K K", "KKK", "K K", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_pillar, 2), new Object[]{"K", "K", 'K', InitBlocksEA.cryptic_katcheen_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_katcheen});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_katcheen_block_fancybrick, 2), new Object[]{"K", "K", 'K', InitBlocksEA.cryptic_katcheen_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_slab, 6), new Object[]{"NNN", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_stairs, 4), new Object[]{"  N", " NN", "NNN", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_stairs, 4), new Object[]{"N  ", "NN ", "NNN", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_stairs, 4), new Object[]{"NNN", " NN", "  N", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_stairs, 4), new Object[]{"NNN", "NN ", "N  ", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_fence, 3), new Object[]{"N#N", "N#N", 'N', InitBlocksEA.cryptic_necrocite_block, '#', InitItemsEA.cryptic_necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_fence_gate), new Object[]{"#N#", "#N#", 'N', InitBlocksEA.cryptic_necrocite_block, '#', InitItemsEA.cryptic_necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_wall, 3), new Object[]{"NNN", "NNN", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_block_brick, 4), new Object[]{"NN", "NN", 'N', InitBlocksEA.cryptic_necrocite_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_torch, 4), new Object[]{"C", "N", 'N', InitBlocksEA.cryptic_necrocite_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_torch, 4), new Object[]{"C", "N", 'N', InitBlocksEA.cryptic_necrocite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_ladder, 4), new Object[]{"N N", "NNN", "N N", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_pillar, 2), new Object[]{"N", "N", 'N', InitBlocksEA.cryptic_necrocite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_necrocite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_necrocite_block_fancybrick, 2), new Object[]{"N", "N", 'N', InitBlocksEA.cryptic_necrocite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_slab, 6), new Object[]{"SSS", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_stairs, 4), new Object[]{"  S", " SS", "SSS", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_stairs, 4), new Object[]{"S  ", "SS ", "SSS", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_stairs, 4), new Object[]{"SSS", " SS", "  S", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_stairs, 4), new Object[]{"SSS", "SS ", "S  ", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_fence, 3), new Object[]{"S#S", "S#S", 'S', InitBlocksEA.cryptic_soularite_block, '#', InitItemsEA.cryptic_soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_fence_gate), new Object[]{"#S#", "#S#", 'S', InitBlocksEA.cryptic_soularite_block, '#', InitItemsEA.cryptic_soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_wall, 3), new Object[]{"SSS", "SSS", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_block_brick, 4), new Object[]{"SS", "SS", 'S', InitBlocksEA.cryptic_soularite_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.cryptic_soularite_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.cryptic_soularite_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_ladder, 4), new Object[]{"S S", "SSS", "S S", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_pillar, 2), new Object[]{"S", "S", 'S', InitBlocksEA.cryptic_soularite_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_soularite});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_soularite_block_fancybrick, 2), new Object[]{"S", "S", 'S', InitBlocksEA.cryptic_soularite_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_slab, 6), new Object[]{"OOO", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_stairs, 4), new Object[]{"  O", " OO", "OOO", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_stairs, 4), new Object[]{"O  ", "OO ", "OOO", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_stairs, 4), new Object[]{"OOO", " OO", "  O", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_stairs, 4), new Object[]{"OOO", "OO ", "O  ", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_fence, 3), new Object[]{"O#O", "O#O", 'O', InitBlocksEA.cryptic_obsidian_block, '#', InitItemsEA.cryptic_obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_fence_gate), new Object[]{"#O#", "#O#", 'O', InitBlocksEA.cryptic_obsidian_block, '#', InitItemsEA.cryptic_obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_wall, 3), new Object[]{"OOO", "OOO", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_block_brick, 4), new Object[]{"OO", "OO", 'O', InitBlocksEA.cryptic_obsidian_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_torch, 4), new Object[]{"C", "O", 'O', InitBlocksEA.cryptic_obsidian_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_torch, 4), new Object[]{"C", "O", 'O', InitBlocksEA.cryptic_obsidian_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_ladder, 4), new Object[]{"O O", "OOO", "O O", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_pillar, 2), new Object[]{"O", "O", 'O', InitBlocksEA.cryptic_obsidian_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_obsidian_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_obsidian_block_fancybrick, 2), new Object[]{"O", "O", 'O', InitBlocksEA.cryptic_obsidian_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_slab, 6), new Object[]{"GGG", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_stairs, 4), new Object[]{"  G", " GG", "GGG", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_stairs, 4), new Object[]{"G  ", "GG ", "GGG", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_stairs, 4), new Object[]{"GGG", " GG", "  G", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_stairs, 4), new Object[]{"GGG", "GG ", "G  ", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_fence, 3), new Object[]{"G#G", "G#G", 'G', InitBlocksEA.cryptic_glowstone_block, '#', InitItemsEA.cryptic_glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_fence_gate), new Object[]{"#G#", "#G#", 'G', InitBlocksEA.cryptic_glowstone_block, '#', InitItemsEA.cryptic_glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_wall, 3), new Object[]{"GGG", "GGG", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_block_brick, 4), new Object[]{"GG", "GG", 'G', InitBlocksEA.cryptic_glowstone_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_torch, 4), new Object[]{"C", "G", 'G', InitBlocksEA.cryptic_glowstone_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_torch, 4), new Object[]{"C", "G", 'G', InitBlocksEA.cryptic_glowstone_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_ladder, 4), new Object[]{"G G", "GGG", "G G", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_pillar, 2), new Object[]{"G", "G", 'G', InitBlocksEA.cryptic_glowstone_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_glowstone_shards});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_glowstone_block_fancybrick, 2), new Object[]{"G", "G", 'G', InitBlocksEA.cryptic_glowstone_block_brick});
		
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_block), new Object[]{"##", "##", '#', InitItemsEA.cryptic_ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_slab, 6), new Object[]{"SSS", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_stairs, 4), new Object[]{"  S", " SS", "SSS", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_stairs, 4), new Object[]{"S  ", "SS ", "SSS", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_stairs, 4), new Object[]{"SSS", " SS", "  S", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_stairs, 4), new Object[]{"SSS", "SS ", "S  ", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_fence, 3), new Object[]{"S#S", "S#S", 'S', InitBlocksEA.cryptic_ebonheart_block, '#', InitItemsEA.cryptic_ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_fence_gate), new Object[]{"#S#", "#S#", 'S', InitBlocksEA.cryptic_ebonheart_block, '#', InitItemsEA.cryptic_ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_wall, 3), new Object[]{"SSS", "SSS", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_block_brick, 4), new Object[]{"SS", "SS", 'S', InitBlocksEA.cryptic_ebonheart_block});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.cryptic_ebonheart_block, 'C', Items.COAL});
		//GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_torch, 4), new Object[]{"C", "S", 'S', InitBlocksEA.cryptic_ebonheart_block, 'C', new ItemStack(Items.COAL, 1, 1)});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_ladder, 4), new Object[]{"S S", "SSS", "S S", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_pillar, 2), new Object[]{"S", "S", 'S', InitBlocksEA.cryptic_ebonheart_block});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_trapdoor, 2), new Object[]{"###", "###", '#', InitItemsEA.cryptic_ebonheart});
		GameRegistry.addShapedRecipe(new ItemStack(InitBlocksEA.cryptic_ebonheart_block_fancybrick, 2), new Object[]{"S", "S", 'S', InitBlocksEA.cryptic_ebonheart_block_brick});
		
		if(!EbonArtsConfig.armorWeaponDifficult)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_pickaxe), new Object[]{"AAA", " S ", " S ", 'A', InitItemsEA.dense_arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_axe), new Object[]{"AA ", "AS ", " S ", 'A', InitItemsEA.dense_arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_shovel), new Object[]{"A", "S", "S", 'A', InitItemsEA.dense_arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_hoe), new Object[]{"AA", " S", " S", 'A', InitItemsEA.dense_arcanite, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_pickaxe), new Object[]{"KKK", " S ", " S ", 'K', InitItemsEA.dense_katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_axe), new Object[]{"KK ", "KS ", " S ", 'K', InitItemsEA.dense_katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_shovel), new Object[]{"K", "S", "S", 'K', InitItemsEA.dense_katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_hoe), new Object[]{"KK", " S", " S", 'K', InitItemsEA.dense_katcheen, 'S', Items.STICK});
			
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.necrosis), new Object[]{"B#B", " I ", " N ", 'N', InitItemsEA.dense_necrocite, 'B', InitItemsEA.dense_necrocite, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.consecration), new Object[]{"B#B", " I ", " S ", 'S', InitItemsEA.dense_soularite, 'B', InitItemsEA.dense_soularite, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_sword), new Object[]{"A", "A", "S", 'A', InitItemsEA.dense_arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_sword), new Object[]{"K", "K", "S", 'K', InitItemsEA.dense_katcheen, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.empowered_blade), new Object[]{" E#", "E#E", "#E ", '#', Items.DIAMOND, 'E', InitItemsEA.ebonheart});
			
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.deception), new Object[]{"DED", "D#D", "DID", 'D', InitItemsEA.dense_draconium_dust, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.frostbite), new Object[]{"VEV", "V#V", "VIV", 'V', InitItemsEA.dense_velious, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.massacre), new Object[]{"AEA", "A#A", "AIA", 'A', InitItemsEA.dense_arcanite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.blazefury), new Object[]{"KEK", "K#K", "KIK", 'K', InitItemsEA.dense_katcheen, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.despair), new Object[]{"NEN", "N#N", "NIN", 'N', InitItemsEA.dense_necrocite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.souleater), new Object[]{"SES", "S#S", "SIS", 'S', InitItemsEA.dense_soularite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_helmet), new Object[]{"AEA", "A A", 'A', InitItemsEA.dense_arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_chestplate), new Object[]{"A A", "ACA", "EEE", 'A', InitItemsEA.dense_arcanite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.CLOCK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_leggings), new Object[]{"EEE", "A A", "A A", 'A', InitItemsEA.dense_arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_boots), new Object[]{"E E", "A A", 'A', InitItemsEA.dense_arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_helmet), new Object[]{"KEK", "K K", 'K', InitItemsEA.dense_katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_chestplate), new Object[]{"K K", "KFK", "EEE", 'K', InitItemsEA.dense_katcheen, 'E', InitItemsEA.enchanted_ebonheart, 'F', Items.FIRE_CHARGE});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_leggings), new Object[]{"EEE", "K K", "K K", 'K', InitItemsEA.dense_katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_boots), new Object[]{"E E", "K K", 'K', InitItemsEA.dense_katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_helmet), new Object[]{"NEN", "N N", 'N', InitItemsEA.dense_necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_chestplate), new Object[]{"N N", "NCN", "EEE", 'N', InitItemsEA.dense_necrocite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.END_CRYSTAL});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_leggings), new Object[]{"EEE", "N N", "N N", 'N', InitItemsEA.dense_necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_boots), new Object[]{"E E", "N N", 'N', InitItemsEA.dense_necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_helmet), new Object[]{"SES", "S S", 'S', InitItemsEA.dense_soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_chestplate), new Object[]{"S S", "SNS", "EEE", 'S', InitItemsEA.dense_soularite, 'E', InitItemsEA.enchanted_ebonheart, 'N', Items.NETHER_STAR});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_leggings), new Object[]{"EEE", "S S", "S S", 'S', InitItemsEA.dense_soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_boots), new Object[]{"E E", "S S", 'S', InitItemsEA.dense_soularite, 'E', InitItemsEA.enchanted_ebonheart});
			
		}
		else
		{
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_pickaxe), new Object[]{"AAA", " S ", " S ", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_axe), new Object[]{"AA ", "AS ", " S ", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_shovel), new Object[]{"A", "S", "S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_hoe), new Object[]{"AA", " S", " S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_pickaxe), new Object[]{"KKK", " S ", " S ", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_axe), new Object[]{"KK ", "KS ", " S ", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_shovel), new Object[]{"K", "S", "S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_hoe), new Object[]{"KK", " S", " S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.necrosis), new Object[]{"B#B", " I ", " N ", 'N', InitItemsEA.necrocite, 'B', InitItemsEA.necrocite, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.consecration), new Object[]{"B#B", " I ", " S ", 'S', InitItemsEA.soularite, 'B', InitItemsEA.soularite, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_sword), new Object[]{"A", "A", "S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_sword), new Object[]{"K", "K", "S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.empowered_blade), new Object[]{" E#", "E#E", "#E ", '#', Items.DIAMOND, 'E', InitItemsEA.ebonheart});
			
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.deception), new Object[]{"DED", "D#D", "DID", 'D', InitItemsEA.draconium_dust, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.frostbite), new Object[]{"VEV", "V#V", "VIV", 'V', InitItemsEA.velious, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.massacre), new Object[]{"AEA", "A#A", "AIA", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.blazefury), new Object[]{"KEK", "K#K", "KIK", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.despair), new Object[]{"NEN", "N#N", "NIN", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.souleater), new Object[]{"SES", "S#S", "SIS", 'S', InitItemsEA.soularite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		
			
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_helmet), new Object[]{"AEA", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_chestplate), new Object[]{"A A", "ACA", "EEE", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.CLOCK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_leggings), new Object[]{"EEE", "A A", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_boots), new Object[]{"E E", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_helmet), new Object[]{"KEK", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_chestplate), new Object[]{"K K", "KFK", "EEE", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart, 'F', Items.FIRE_CHARGE});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_leggings), new Object[]{"EEE", "K K", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_boots), new Object[]{"E E", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_helmet), new Object[]{"NEN", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_chestplate), new Object[]{"N N", "NCN", "EEE", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.END_CRYSTAL});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_leggings), new Object[]{"EEE", "N N", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_boots), new Object[]{"E E", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_helmet), new Object[]{"SES", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_chestplate), new Object[]{"S S", "SNS", "EEE", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart, 'N', Items.NETHER_STAR});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_leggings), new Object[]{"EEE", "S S", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_boots), new Object[]{"E E", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
			
			
		}
		
		if(!EbonArtsConfig.vanillaRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.WEB), new Object[]{"SSS", "S#S", "SSS", 'S', Items.STRING, '#', Items.SLIME_BALL});
			GameRegistry.addShapedRecipe(new ItemStack(Items.NAME_TAG), new Object[]{"#", "P", "L", '#', Items.LEAD, 'P', Items.PAPER, 'L', Items.LEATHER});
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.PACKED_ICE), new Object[]{"III", "III", "III", 'I', Blocks.ICE});
			GameRegistry.addShapedRecipe(new ItemStack(Blocks.ICE, 9), new Object[]{"I", 'I', Blocks.PACKED_ICE});
			GameRegistry.addShapelessRecipe(new ItemStack(Items.SNOWBALL, 4), Blocks.SNOW);
			GameRegistry.addShapelessRecipe(new ItemStack(Items.CLAY_BALL, 4), Blocks.CLAY);
		}
		else
		{
			
		}
		
		/**
		
		if(!EbonArtsConfiguration.toolRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_pickaxe), new Object[]{"AAA", " S ", " S ", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_axe), new Object[]{"AA ", "AS ", " S ", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_shovel), new Object[]{"A", "S", "S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_hoe), new Object[]{"AA", " S", " S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_pickaxe), new Object[]{"KKK", " S ", " S ", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_axe), new Object[]{"KK ", "KS ", " S ", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_shovel), new Object[]{"K", "S", "S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_hoe), new Object[]{"KK", " S", " S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.necrosis), new Object[]{"B#B", " I ", " N ", 'N', InitItemsEA.necrocite, 'B', InitBlocksEA.necrocite_block, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.consecration), new Object[]{"B#B", " I ", " S ", 'S', InitItemsEA.soularite, 'B', InitBlocksEA.soularite_block, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		}
		else
		{
			
		}
		
		
		
		if(!EbonArtsConfiguration.weaponRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.arcanite_sword), new Object[]{"A", "A", "S", 'A', InitItemsEA.arcanite, 'S', Items.STICK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.katcheen_sword), new Object[]{"K", "K", "S", 'K', InitItemsEA.katcheen, 'S', Items.STICK});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.empowered_blade), new Object[]{" E#", "E#E", "#E ", '#', Items.DIAMOND, 'E', InitItemsEA.ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.deception), new Object[]{"DED", "D#D", "DID", 'D', InitItemsEA.draconium_dust, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.frostbite), new Object[]{"VEV", "V#V", "VIV", 'V', InitItemsEA.velious, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.massacre), new Object[]{"AEA", "A#A", "AIA", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.blazefury), new Object[]{"KEK", "K#K", "KIK", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.despair), new Object[]{"NEN", "N#N", "NIN", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.souleater), new Object[]{"SES", "S#S", "SIS", 'S', InitItemsEA.soularite, 'E', InitItemsEA.empowered_blade, '#', InitItemsEA.enchanted_ebonheart, 'I', Items.IRON_INGOT});
		}
		else
		{
			
		}
		
		
		
		if(!EbonArtsConfiguration.armorRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_helmet), new Object[]{"AEA", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_chestplate), new Object[]{"A A", "ACA", "EEE", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.CLOCK});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_leggings), new Object[]{"EEE", "A A", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.burnished_boots), new Object[]{"E E", "A A", 'A', InitItemsEA.arcanite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_helmet), new Object[]{"KEK", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_chestplate), new Object[]{"K K", "KFK", "EEE", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart, 'F', Items.FIRE_CHARGE});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_leggings), new Object[]{"EEE", "K K", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.scalemail_boots), new Object[]{"E E", "K K", 'K', InitItemsEA.katcheen, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_helmet), new Object[]{"NEN", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_chestplate), new Object[]{"N N", "NCN", "EEE", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart, 'C', Items.END_CRYSTAL});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_leggings), new Object[]{"EEE", "N N", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.vengeance_boots), new Object[]{"E E", "N N", 'N', InitItemsEA.necrocite, 'E', InitItemsEA.enchanted_ebonheart});
			
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_helmet), new Object[]{"SES", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_chestplate), new Object[]{"S S", "SNS", "EEE", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart, 'N', Items.NETHER_STAR});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_leggings), new Object[]{"EEE", "S S", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.celestial_boots), new Object[]{"E E", "S S", 'S', InitItemsEA.soularite, 'E', InitItemsEA.enchanted_ebonheart});
		}
		else
		{
			
		}
		
		*/
		/**
		if(!EbonArtsConfig.musicRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(InitItemsEA.mirroring_disc, 1), new Object[]{"GGG", "D#D", "GGG", '#', Items.DIAMOND,'D', InitItemsEA.draconium_dust,'G', Blocks.GLASS});
		}
		else
		{
			
		}
		
		
		
		if(!EbonArtsConfig.horseRecipe)
		{
			GameRegistry.addShapedRecipe(new ItemStack(Items.SADDLE), new Object[]{"LLL", "LIL", "I I", 'L', Items.LEATHER, 'I', Items.IRON_INGOT});
			GameRegistry.addShapedRecipe(new ItemStack(Items.IRON_HORSE_ARMOR), new Object[]{"  I", "ISI", "III", 'I', Items.IRON_INGOT, 'S', Items.SADDLE});
			GameRegistry.addShapedRecipe(new ItemStack(Items.GOLDEN_HORSE_ARMOR), new Object[]{"  G", "GSG", "GGG", 'G', Items.GOLD_INGOT, 'S', Items.SADDLE});
			GameRegistry.addShapedRecipe(new ItemStack(Items.DIAMOND_HORSE_ARMOR), new Object[]{"  D", "DSD", "DDD", 'D', Items.DIAMOND, 'S', Items.SADDLE});
		}
		else
		{
			
		}
		
	}
	
	public static void initShapelessRecipe()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust), InitItemsEA.draconium_dust, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious), InitItemsEA.velious, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite), InitItemsEA.arcanite, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen), InitItemsEA.katcheen, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite), InitItemsEA.necrocite, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite), InitItemsEA.soularite, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards), InitItemsEA.obsidian_shards, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards), InitItemsEA.glowstone_shards, new ItemStack(Items.REDSTONE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart), InitItemsEA.ebonheart, new ItemStack(Items.REDSTONE));
		
		
		
		//Mystic Cobblestone
		//Recipes that dye the basic block into any color
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_white), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_orange), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_magenta), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_lightblue), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_yellow), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_lime), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_pink), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_gray), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_lightgray), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_cyan), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_purple), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_blue), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_brown), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_green), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_red), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_black), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Items.DYE, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_glass), InitBlocksEA.cobble_mystic_block_normal, new ItemStack(Blocks.GLASS));		
		
		//Mystic Cobblestone
		//conversion back from dye block to normal block
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_glass));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_white));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_orange));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_magenta));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_lightblue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_yellow));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_lime));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_pink));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_gray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_lightgray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_cyan));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_purple));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_blue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_brown));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_green));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_red));		
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.cobble_mystic_block_normal), new ItemStack(InitBlocksEA.cobble_mystic_block_black));
		
		
		
		//Mystic Stone
		//Recipes that dye the basic block into any color
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_white), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_orange), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_magenta), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_lightblue), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_yellow), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_lime), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_pink), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_gray), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_lightgray), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_cyan), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_purple), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_blue), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_brown), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_green), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_red), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_black), InitBlocksEA.mystic_block_normal, new ItemStack(Items.DYE, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_glass), InitBlocksEA.mystic_block_normal, new ItemStack(Blocks.GLASS));		
				
		//Mystic Stone
		//conversion back from dye block to normal block
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_glass));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_white));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_orange));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_magenta));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_lightblue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_yellow));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_lime));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_pink));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_gray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_lightgray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_cyan));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_purple));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_blue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_brown));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_green));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_red));		
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.mystic_block_normal), new ItemStack(InitBlocksEA.mystic_block_black));
		
		
		
		//Mystic Wood Planks
		//Recipes that dye the basic block into any color
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_white), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 15));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_orange), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 14));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_magenta), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 13));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_lightblue), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 12));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_yellow), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 11));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_lime), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 10));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_pink), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 9));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_gray), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 8));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_lightgray), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 7));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_cyan), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 6));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_purple), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 5));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_blue), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 4));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_brown), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 3));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_green), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 2));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_red), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 1));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_black), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Items.DYE, 1, 0));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_glass), InitBlocksEA.wood_mystic_block_normal, new ItemStack(Blocks.GLASS));		
		
		//Mystic Wood Planks
		//conversion back from dye block to normal block
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_glass));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_white));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_orange));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_magenta));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_lightblue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_yellow));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_lime));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_pink));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_gray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_lightgray));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_cyan));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_purple));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_blue));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_brown));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_green));
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_red));		
		GameRegistry.addShapelessRecipe(new ItemStack(InitBlocksEA.wood_mystic_block_normal), new ItemStack(InitBlocksEA.wood_mystic_block_black));
		
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.hellion_fruit), InitItemsEA.necrocite, new ItemStack(Items.APPLE));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.sacred_fruit), InitItemsEA.soularite, new ItemStack(Items.NETHER_WART));
		GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.dragon_fruit), InitItemsEA.ebonheart, new ItemStack(Items.CHORUS_FRUIT));
		
		GameRegistry.addRecipe(new ItemStack(Items.PAPER, 8), new Object[]{"P", 'P', InitBlocksEA.paper_block});
		GameRegistry.addRecipe(new ItemStack(Items.REEDS, 8), new Object[]{"R", 'R', InitBlocksEA.reed_block});
		GameRegistry.addRecipe(new ItemStack(Items.LEATHER, 8), new Object[]{"L", 'L', InitBlocksEA.leather_block});
		
		
		if(!EbonArtsConfig.musicRecipe)
		{
			
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_13), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 11));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_CAT), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 2));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_BLOCKS), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 14));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_CHIRP), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 1));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_FAR), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 10));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_MALL), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 4));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_MELLOHI), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 5));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_STAL), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 0));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_STRAD), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 15));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_WARD), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 6));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_11), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 8));
			GameRegistry.addShapelessRecipe(new ItemStack(Items.RECORD_WAIT), InitItemsEA.mirroring_disc, new ItemStack(Items.DYE, 1, 12));
			
		}
		else
		{
			
		}
		
		
		
		if(!EbonArtsConfig.decraftRecipe1)
		{
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 4), new ItemStack(InitBlocksEA.draconium_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 4), new ItemStack(InitBlocksEA.draconium_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 2), new ItemStack(InitBlocksEA.draconium_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 6), new ItemStack(InitBlocksEA.draconium_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 12), new ItemStack(InitBlocksEA.draconium_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 8), new ItemStack(InitBlocksEA.draconium_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 6), new ItemStack(InitBlocksEA.draconium_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 1), new ItemStack(InitBlocksEA.draconium_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 7), new ItemStack(InitBlocksEA.draconium_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 4), new ItemStack(InitBlocksEA.draconium_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 3), new ItemStack(InitBlocksEA.draconium_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 4), new ItemStack(InitBlocksEA.draconium_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 4), new ItemStack(InitBlocksEA.velious_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 4), new ItemStack(InitBlocksEA.velious_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 2), new ItemStack(InitBlocksEA.velious_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 6), new ItemStack(InitBlocksEA.velious_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 12), new ItemStack(InitBlocksEA.velious_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 8), new ItemStack(InitBlocksEA.velious_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 6), new ItemStack(InitBlocksEA.velious_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 1), new ItemStack(InitBlocksEA.velious_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 7), new ItemStack(InitBlocksEA.velious_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 4), new ItemStack(InitBlocksEA.velious_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 3), new ItemStack(InitBlocksEA.velious_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 4), new ItemStack(InitBlocksEA.velious_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 4), new ItemStack(InitBlocksEA.arcanite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 4), new ItemStack(InitBlocksEA.arcanite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 2), new ItemStack(InitBlocksEA.arcanite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 6), new ItemStack(InitBlocksEA.arcanite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 12), new ItemStack(InitBlocksEA.arcanite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 8), new ItemStack(InitBlocksEA.arcanite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 6), new ItemStack(InitBlocksEA.arcanite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 1), new ItemStack(InitBlocksEA.arcanite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 7), new ItemStack(InitBlocksEA.arcanite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 4), new ItemStack(InitBlocksEA.arcanite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 3), new ItemStack(InitBlocksEA.arcanite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 4), new ItemStack(InitBlocksEA.arcanite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 4), new ItemStack(InitBlocksEA.katcheen_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 4), new ItemStack(InitBlocksEA.katcheen_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 2), new ItemStack(InitBlocksEA.katcheen_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 6), new ItemStack(InitBlocksEA.katcheen_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 12), new ItemStack(InitBlocksEA.katcheen_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 8), new ItemStack(InitBlocksEA.katcheen_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 6), new ItemStack(InitBlocksEA.katcheen_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 1), new ItemStack(InitBlocksEA.katcheen_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 7), new ItemStack(InitBlocksEA.katcheen_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 4), new ItemStack(InitBlocksEA.katcheen_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 3), new ItemStack(InitBlocksEA.katcheen_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 4), new ItemStack(InitBlocksEA.katcheen_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 4), new ItemStack(InitBlocksEA.necrocite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 4), new ItemStack(InitBlocksEA.necrocite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 2), new ItemStack(InitBlocksEA.necrocite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 6), new ItemStack(InitBlocksEA.necrocite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 12), new ItemStack(InitBlocksEA.necrocite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 8), new ItemStack(InitBlocksEA.necrocite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 6), new ItemStack(InitBlocksEA.necrocite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 1), new ItemStack(InitBlocksEA.necrocite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 7), new ItemStack(InitBlocksEA.necrocite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 4), new ItemStack(InitBlocksEA.necrocite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 3), new ItemStack(InitBlocksEA.necrocite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 4), new ItemStack(InitBlocksEA.necrocite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 4), new ItemStack(InitBlocksEA.soularite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 4), new ItemStack(InitBlocksEA.soularite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 2), new ItemStack(InitBlocksEA.soularite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 6), new ItemStack(InitBlocksEA.soularite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 12), new ItemStack(InitBlocksEA.soularite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 8), new ItemStack(InitBlocksEA.soularite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 6), new ItemStack(InitBlocksEA.soularite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 1), new ItemStack(InitBlocksEA.soularite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 7), new ItemStack(InitBlocksEA.soularite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 4), new ItemStack(InitBlocksEA.soularite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 3), new ItemStack(InitBlocksEA.soularite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 4), new ItemStack(InitBlocksEA.soularite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 4), new ItemStack(InitBlocksEA.obsidian_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 4), new ItemStack(InitBlocksEA.obsidian_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 2), new ItemStack(InitBlocksEA.obsidian_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 6), new ItemStack(InitBlocksEA.obsidian_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 12), new ItemStack(InitBlocksEA.obsidian_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 8), new ItemStack(InitBlocksEA.obsidian_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 6), new ItemStack(InitBlocksEA.obsidian_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 1), new ItemStack(InitBlocksEA.obsidian_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 7), new ItemStack(InitBlocksEA.obsidian_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 4), new ItemStack(InitBlocksEA.obsidian_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 3), new ItemStack(InitBlocksEA.obsidian_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards, 4), new ItemStack(InitBlocksEA.obsidian_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 4), new ItemStack(InitBlocksEA.glowstone_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 4), new ItemStack(InitBlocksEA.glowstone_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 2), new ItemStack(InitBlocksEA.glowstone_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 6), new ItemStack(InitBlocksEA.glowstone_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 12), new ItemStack(InitBlocksEA.glowstone_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 8), new ItemStack(InitBlocksEA.glowstone_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 6), new ItemStack(InitBlocksEA.glowstone_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 1), new ItemStack(InitBlocksEA.glowstone_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 7), new ItemStack(InitBlocksEA.glowstone_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 4), new ItemStack(InitBlocksEA.glowstone_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 3), new ItemStack(InitBlocksEA.glowstone_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards, 4), new ItemStack(InitBlocksEA.glowstone_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 4), new ItemStack(InitBlocksEA.ebonheart_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 4), new ItemStack(InitBlocksEA.ebonheart_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 2), new ItemStack(InitBlocksEA.ebonheart_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 6), new ItemStack(InitBlocksEA.ebonheart_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 12), new ItemStack(InitBlocksEA.ebonheart_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 8), new ItemStack(InitBlocksEA.ebonheart_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 6), new ItemStack(InitBlocksEA.ebonheart_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 1), new ItemStack(InitBlocksEA.ebonheart_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 7), new ItemStack(InitBlocksEA.ebonheart_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 4), new ItemStack(InitBlocksEA.ebonheart_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 3), new ItemStack(InitBlocksEA.ebonheart_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart, 4), new ItemStack(InitBlocksEA.ebonheart_block_fancybrick));
			
			//=================================================================================
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 4), new ItemStack(InitBlocksEA.cryptic_draconium_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 4), new ItemStack(InitBlocksEA.cryptic_draconium_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 2), new ItemStack(InitBlocksEA.cryptic_draconium_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 6), new ItemStack(InitBlocksEA.cryptic_draconium_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 12), new ItemStack(InitBlocksEA.cryptic_draconium_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 8), new ItemStack(InitBlocksEA.cryptic_draconium_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 6), new ItemStack(InitBlocksEA.cryptic_draconium_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 1), new ItemStack(InitBlocksEA.cryptic_draconium_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 7), new ItemStack(InitBlocksEA.cryptic_draconium_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 4), new ItemStack(InitBlocksEA.cryptic_draconium_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 3), new ItemStack(InitBlocksEA.cryptic_draconium_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_draconium_dust, 4), new ItemStack(InitBlocksEA.cryptic_draconium_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 4), new ItemStack(InitBlocksEA.cryptic_velious_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 4), new ItemStack(InitBlocksEA.cryptic_velious_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 2), new ItemStack(InitBlocksEA.cryptic_velious_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 6), new ItemStack(InitBlocksEA.cryptic_velious_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 12), new ItemStack(InitBlocksEA.cryptic_velious_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 8), new ItemStack(InitBlocksEA.cryptic_velious_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 6), new ItemStack(InitBlocksEA.cryptic_velious_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 1), new ItemStack(InitBlocksEA.cryptic_velious_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 7), new ItemStack(InitBlocksEA.cryptic_velious_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 4), new ItemStack(InitBlocksEA.cryptic_velious_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 3), new ItemStack(InitBlocksEA.cryptic_velious_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_velious, 4), new ItemStack(InitBlocksEA.cryptic_velious_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 4), new ItemStack(InitBlocksEA.cryptic_arcanite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 4), new ItemStack(InitBlocksEA.cryptic_arcanite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 2), new ItemStack(InitBlocksEA.cryptic_arcanite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 6), new ItemStack(InitBlocksEA.cryptic_arcanite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 12), new ItemStack(InitBlocksEA.cryptic_arcanite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 8), new ItemStack(InitBlocksEA.cryptic_arcanite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 6), new ItemStack(InitBlocksEA.cryptic_arcanite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 1), new ItemStack(InitBlocksEA.cryptic_arcanite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 7), new ItemStack(InitBlocksEA.cryptic_arcanite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 4), new ItemStack(InitBlocksEA.cryptic_arcanite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 3), new ItemStack(InitBlocksEA.cryptic_arcanite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_arcanite, 4), new ItemStack(InitBlocksEA.cryptic_arcanite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 4), new ItemStack(InitBlocksEA.cryptic_katcheen_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 4), new ItemStack(InitBlocksEA.cryptic_katcheen_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 2), new ItemStack(InitBlocksEA.cryptic_katcheen_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 6), new ItemStack(InitBlocksEA.cryptic_katcheen_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 12), new ItemStack(InitBlocksEA.cryptic_katcheen_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 8), new ItemStack(InitBlocksEA.cryptic_katcheen_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 6), new ItemStack(InitBlocksEA.cryptic_katcheen_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 1), new ItemStack(InitBlocksEA.cryptic_katcheen_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 7), new ItemStack(InitBlocksEA.cryptic_katcheen_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 4), new ItemStack(InitBlocksEA.cryptic_katcheen_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 3), new ItemStack(InitBlocksEA.cryptic_katcheen_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_katcheen, 4), new ItemStack(InitBlocksEA.cryptic_katcheen_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 4), new ItemStack(InitBlocksEA.cryptic_necrocite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 4), new ItemStack(InitBlocksEA.cryptic_necrocite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 2), new ItemStack(InitBlocksEA.cryptic_necrocite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 6), new ItemStack(InitBlocksEA.cryptic_necrocite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 12), new ItemStack(InitBlocksEA.cryptic_necrocite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 8), new ItemStack(InitBlocksEA.cryptic_necrocite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 6), new ItemStack(InitBlocksEA.cryptic_necrocite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 1), new ItemStack(InitBlocksEA.cryptic_necrocite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 7), new ItemStack(InitBlocksEA.cryptic_necrocite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 4), new ItemStack(InitBlocksEA.cryptic_necrocite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 3), new ItemStack(InitBlocksEA.cryptic_necrocite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_necrocite, 4), new ItemStack(InitBlocksEA.cryptic_necrocite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 4), new ItemStack(InitBlocksEA.cryptic_soularite_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 4), new ItemStack(InitBlocksEA.cryptic_soularite_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 2), new ItemStack(InitBlocksEA.cryptic_soularite_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 6), new ItemStack(InitBlocksEA.cryptic_soularite_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 12), new ItemStack(InitBlocksEA.cryptic_soularite_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 8), new ItemStack(InitBlocksEA.cryptic_soularite_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 6), new ItemStack(InitBlocksEA.cryptic_soularite_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 1), new ItemStack(InitBlocksEA.cryptic_soularite_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 7), new ItemStack(InitBlocksEA.cryptic_soularite_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 4), new ItemStack(InitBlocksEA.cryptic_soularite_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 3), new ItemStack(InitBlocksEA.cryptic_soularite_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_soularite, 4), new ItemStack(InitBlocksEA.cryptic_soularite_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 4), new ItemStack(InitBlocksEA.cryptic_obsidian_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 4), new ItemStack(InitBlocksEA.cryptic_obsidian_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 2), new ItemStack(InitBlocksEA.cryptic_obsidian_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 6), new ItemStack(InitBlocksEA.cryptic_obsidian_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 12), new ItemStack(InitBlocksEA.cryptic_obsidian_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 8), new ItemStack(InitBlocksEA.cryptic_obsidian_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 6), new ItemStack(InitBlocksEA.cryptic_obsidian_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 1), new ItemStack(InitBlocksEA.cryptic_obsidian_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 7), new ItemStack(InitBlocksEA.cryptic_obsidian_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 4), new ItemStack(InitBlocksEA.cryptic_obsidian_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 3), new ItemStack(InitBlocksEA.cryptic_obsidian_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_obsidian_shards, 4), new ItemStack(InitBlocksEA.cryptic_obsidian_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 4), new ItemStack(InitBlocksEA.cryptic_glowstone_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 4), new ItemStack(InitBlocksEA.cryptic_glowstone_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 2), new ItemStack(InitBlocksEA.cryptic_glowstone_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 6), new ItemStack(InitBlocksEA.cryptic_glowstone_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 12), new ItemStack(InitBlocksEA.cryptic_glowstone_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 8), new ItemStack(InitBlocksEA.cryptic_glowstone_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 6), new ItemStack(InitBlocksEA.cryptic_glowstone_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 1), new ItemStack(InitBlocksEA.cryptic_glowstone_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 7), new ItemStack(InitBlocksEA.cryptic_glowstone_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 4), new ItemStack(InitBlocksEA.cryptic_glowstone_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 3), new ItemStack(InitBlocksEA.cryptic_glowstone_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_glowstone_shards, 4), new ItemStack(InitBlocksEA.cryptic_glowstone_block_fancybrick));
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 4), new ItemStack(InitBlocksEA.cryptic_ebonheart_block));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 4), new ItemStack(InitBlocksEA.cryptic_ebonheart_block_brick));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 2), new ItemStack(InitBlocksEA.cryptic_ebonheart_slab));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 6), new ItemStack(InitBlocksEA.cryptic_ebonheart_fence));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 12), new ItemStack(InitBlocksEA.cryptic_ebonheart_fence_gate));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 8), new ItemStack(InitBlocksEA.cryptic_ebonheart_wall));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 6), new ItemStack(InitBlocksEA.cryptic_ebonheart_stairs));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 1), new ItemStack(InitBlocksEA.cryptic_ebonheart_torch));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 7), new ItemStack(InitBlocksEA.cryptic_ebonheart_ladder));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 4), new ItemStack(InitBlocksEA.cryptic_ebonheart_pillar));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 3), new ItemStack(InitBlocksEA.cryptic_ebonheart_trapdoor));
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.cryptic_ebonheart, 4), new ItemStack(InitBlocksEA.cryptic_ebonheart_block_fancybrick));
			
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust), InitItemsEA.cryptic_draconium_dust);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious), InitItemsEA.cryptic_velious);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite), InitItemsEA.cryptic_arcanite);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen), InitItemsEA.cryptic_katcheen);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite), InitItemsEA.cryptic_necrocite);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite), InitItemsEA.cryptic_soularite);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.obsidian_shards), InitItemsEA.cryptic_obsidian_shards);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.glowstone_shards), InitItemsEA.cryptic_glowstone_shards);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.ebonheart), InitItemsEA.cryptic_ebonheart);
			
			
			
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.draconium_dust, 9), InitItemsEA.dense_draconium_dust);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.velious, 9), InitItemsEA.dense_velious);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.arcanite, 9), InitItemsEA.dense_arcanite);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.katcheen, 9), InitItemsEA.dense_katcheen);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.necrocite, 9), InitItemsEA.dense_necrocite);
			GameRegistry.addShapelessRecipe(new ItemStack(InitItemsEA.soularite, 9), InitItemsEA.dense_soularite);
			
			
			
		}
		else
		{
			
		}
		
		
		
		
		
	}
	
	public static void initSmeltingRecipe()
	{
		//GameRegistry.addSmelting(new ItemStack(InitBlocksEA.draconium_ore), new ItemStack(InitItemsEA.draconium_dust), 10f);
		
		
		//smelt stone back into cobblestone.
		//GameRegistry.addSmelting(new ItemStack(Blocks.cobblestone), new ItemStack(Blocks.stone), 0.1f);
		
		
	}
	*/
	}
}

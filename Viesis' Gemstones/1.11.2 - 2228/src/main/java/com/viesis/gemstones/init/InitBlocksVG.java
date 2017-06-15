package com.viesis.gemstones.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.VGBlocks;
import com.viesis.gemstones.common.blocks.basic.BlockFenceVG;
import com.viesis.gemstones.common.blocks.basic.BlockGateVG;
import com.viesis.gemstones.common.blocks.basic.BlockLadderVG;
import com.viesis.gemstones.common.blocks.basic.BlockPillarVG;
import com.viesis.gemstones.common.blocks.basic.BlockStairsVG;
import com.viesis.gemstones.common.blocks.basic.BlockTrapDoorVG;
import com.viesis.gemstones.common.blocks.basic.BlockWallVG;
import com.viesis.gemstones.common.blocks.gemstones.BlockGemstoneBasicV1;
import com.viesis.gemstones.common.blocks.gemstones.ItemBlockGemstoneBasicV1;
import com.viesis.gemstones.common.blocks.slabs.BlockDoubleSlabVG;
import com.viesis.gemstones.common.blocks.slabs.BlockHalfSlabVG;
import com.viesis.gemstones.common.blocks.tileentity.BlockGemstoneWorkbench;
import com.viesis.gemstones.common.blocks.torches.BlockTorchArcaniteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchCarnelianVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchDraconiteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchEbonheartVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchKatcheenVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchNecrociteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchOnyxiusVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchSoulariteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchVeliousVG;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class InitBlocksVG extends VGBlocks {
	
	public static final Set<Block> blocks = new HashSet<>();
	
	public static void registerBlock()
	{
		gemstone_workbench = registerBlock(new BlockGemstoneWorkbench("gemstone_workbench"));
		
		gemstone_block_basic_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/basic/block_basic"));
		gemstone_block_brick_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/brick/block_brick"));
		gemstone_block_fancybrick_v1 = registerBlockMetaGemstoneBasicV1(new BlockGemstoneBasicV1("gemstone/regular/fancybrick/block_fancybrick"));
				
		basic_doubleslab_draconite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_draconite").setResistance(4.0F).setLightLevel(0.4f);
		basic_doubleslab_velious = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_velious").setResistance(15.0F);
		basic_doubleslab_arcanite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_arcanite").setResistance(30.0F);
		basic_doubleslab_katcheen = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_katcheen").setResistance(100.0F);
		basic_doubleslab_carnelian = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_carnelian").setResistance(45.0F).setLightLevel(1.0f);
		basic_doubleslab_necrocite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_necrocite").setResistance(45.0F);
		basic_doubleslab_onyxius = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_onyxius").setResistance(2000.0F);
		basic_doubleslab_soularite = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_soularite").setResistance(45.0F);
		basic_doubleslab_ebonheart = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_ebonheart").setResistance(2000.0F);
		
		basic_halfslab_draconite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_draconite").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_velious = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_velious").setResistance(15.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_arcanite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_arcanite").setResistance(30.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_katcheen = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_katcheen").setResistance(100.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_carnelian = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_carnelian").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_necrocite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_necrocite").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_onyxius = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_onyxius").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_soularite = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_soularite").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		basic_halfslab_ebonheart = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_ebonheart").setResistance(2000.0F).setCreativeTab(ViesisGemstones.tabVGBlocks);
		
		registerBlockSlab(basic_halfslab_draconite, basic_doubleslab_draconite);
		registerBlockSlab(basic_halfslab_velious, basic_doubleslab_velious);
		registerBlockSlab(basic_halfslab_arcanite, basic_doubleslab_arcanite);
		registerBlockSlab(basic_halfslab_katcheen, basic_doubleslab_katcheen);
		registerBlockSlab(basic_halfslab_carnelian, basic_doubleslab_carnelian);
		registerBlockSlab(basic_halfslab_necrocite, basic_doubleslab_necrocite);
		registerBlockSlab(basic_halfslab_onyxius, basic_doubleslab_onyxius);
		registerBlockSlab(basic_halfslab_soularite, basic_doubleslab_soularite);
		registerBlockSlab(basic_halfslab_ebonheart, basic_doubleslab_ebonheart);
		
		basic_stairs_draconite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_draconite", gemstone_block_basic_v1).setResistance(4.0F).setLightLevel(0.4f));
		basic_stairs_velious = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_velious", gemstone_block_basic_v1).setResistance(15.0F));
		basic_stairs_arcanite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_arcanite", gemstone_block_basic_v1).setResistance(30.0F));
		basic_stairs_katcheen = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_katcheen", gemstone_block_basic_v1).setResistance(100.0F));
		basic_stairs_carnelian = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_carnelian", gemstone_block_basic_v1).setResistance(100.0F));
		basic_stairs_necrocite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_necrocite", gemstone_block_basic_v1).setResistance(45.0F));
		basic_stairs_onyxius = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_onyxius", gemstone_block_basic_v1).setResistance(100.0F));
		basic_stairs_soularite = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_soularite", gemstone_block_basic_v1).setResistance(45.0F));
		basic_stairs_ebonheart = registerBlock(new BlockStairsVG("gemstone/regular/stairs/basic_stairs_ebonheart", gemstone_block_basic_v1).setResistance(2000.0F));
		
		basic_fence_draconite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_draconite").setResistance(4.0F).setLightLevel(0.4f));
		basic_fence_velious = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_velious").setResistance(15.0F));
		basic_fence_arcanite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_arcanite").setResistance(30.0F));
		basic_fence_katcheen = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_katcheen").setResistance(100.0F));
		basic_fence_carnelian = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_carnelian").setResistance(45.0F));
		basic_fence_necrocite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_necrocite").setResistance(45.0F));
		basic_fence_onyxius = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_onyxius").setResistance(45.0F));
		basic_fence_soularite = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_soularite").setResistance(45.0F));
		basic_fence_ebonheart = registerBlock(new BlockFenceVG("gemstone/regular/fence/basic_fence_ebonheart").setResistance(2000.0F));

		basic_gate_draconite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_draconite").setResistance(4.0F).setLightLevel(0.4f));
		basic_gate_velious = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_velious").setResistance(15.0F));
		basic_gate_arcanite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_arcanite").setResistance(30.0F));
		basic_gate_katcheen = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_katcheen").setResistance(100.0F));
		basic_gate_carnelian = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_carnelian").setResistance(45.0F));
		basic_gate_necrocite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_necrocite").setResistance(45.0F));
		basic_gate_onyxius = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_onyxius").setResistance(45.0F));
		basic_gate_soularite = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_soularite").setResistance(45.0F));
		basic_gate_ebonheart = registerBlock(new BlockGateVG("gemstone/regular/gate/basic_gate_ebonheart").setResistance(2000.0F));

		basic_wall_draconite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_draconite", gemstone_block_basic_v1).setResistance(4.0F).setLightLevel(0.4f));
		basic_wall_velious = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_velious", gemstone_block_basic_v1).setResistance(15.0F));
		basic_wall_arcanite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_arcanite", gemstone_block_basic_v1).setResistance(30.0F));
		basic_wall_katcheen = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_katcheen", gemstone_block_basic_v1).setResistance(100.0F));
		basic_wall_carnelian = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_carnelian", gemstone_block_basic_v1).setResistance(45.0F));
		basic_wall_necrocite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_necrocite", gemstone_block_basic_v1).setResistance(45.0F));
		basic_wall_onyxius = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_onyxius", gemstone_block_basic_v1).setResistance(45.0F));
		basic_wall_soularite = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_soularite", gemstone_block_basic_v1).setResistance(45.0F));
		basic_wall_ebonheart = registerBlock(new BlockWallVG("gemstone/regular/wall/basic_wall_ebonheart", gemstone_block_basic_v1).setResistance(2000.0F));

		basic_torch_draconite = registerBlock(new BlockTorchDraconiteVG("gemstone/regular/torch/basic_torch_draconite").setResistance(4.0F));
		basic_torch_velious = registerBlock(new BlockTorchVeliousVG("gemstone/regular/torch/basic_torch_velious").setResistance(15.0F));
		basic_torch_arcanite = registerBlock(new BlockTorchArcaniteVG("gemstone/regular/torch/basic_torch_arcanite").setResistance(30.0F));
		basic_torch_katcheen = registerBlock(new BlockTorchKatcheenVG("gemstone/regular/torch/basic_torch_katcheen").setResistance(100.0F));
		basic_torch_carnelian = registerBlock(new BlockTorchCarnelianVG("gemstone/regular/torch/basic_torch_carnelian").setResistance(45.0F));
		basic_torch_necrocite = registerBlock(new BlockTorchNecrociteVG("gemstone/regular/torch/basic_torch_necrocite").setResistance(45.0F));
		basic_torch_onyxius = registerBlock(new BlockTorchOnyxiusVG("gemstone/regular/torch/basic_torch_onyxius").setResistance(45.0F));
		basic_torch_soularite = registerBlock(new BlockTorchSoulariteVG("gemstone/regular/torch/basic_torch_soularite").setResistance(45.0F));
		basic_torch_ebonheart = registerBlock(new BlockTorchEbonheartVG("gemstone/regular/torch/basic_torch_ebonheart").setResistance(2000.0F));

		basic_trapdoor_draconite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_draconite").setResistance(4.0F));
		basic_trapdoor_velious = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_velious").setResistance(15.0F));
		basic_trapdoor_arcanite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_arcanite").setResistance(30.0F));
		basic_trapdoor_katcheen = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_katcheen").setResistance(100.0F));
		basic_trapdoor_carnelian = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_carnelian").setResistance(45.0F));
		basic_trapdoor_necrocite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_necrocite").setResistance(45.0F));
		basic_trapdoor_onyxius = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_onyxius").setResistance(45.0F));
		basic_trapdoor_soularite = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_soularite").setResistance(45.0F));
		basic_trapdoor_ebonheart = registerBlock(new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_ebonheart").setResistance(2000.0F));

		basic_ladder_draconite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_draconite").setResistance(4.0F));
		basic_ladder_velious = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_velious").setResistance(15.0F));
		basic_ladder_arcanite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_arcanite").setResistance(30.0F));
		basic_ladder_katcheen = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_katcheen").setResistance(100.0F));
		basic_ladder_carnelian = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_carnelian").setResistance(45.0F));
		basic_ladder_necrocite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_necrocite").setResistance(45.0F));
		basic_ladder_onyxius = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_onyxius").setResistance(45.0F));
		basic_ladder_soularite = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_soularite").setResistance(45.0F));
		basic_ladder_ebonheart = registerBlock(new BlockLadderVG("gemstone/regular/ladder/basic_ladder_ebonheart").setResistance(2000.0F));

		basic_pillar_draconite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_draconite").setResistance(4.0F));
		basic_pillar_velious = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_velious").setResistance(15.0F));
		basic_pillar_arcanite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_arcanite").setResistance(30.0F));
		basic_pillar_katcheen = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_katcheen").setResistance(100.0F));
		basic_pillar_carnelian = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_carnelian").setResistance(45.0F));
		basic_pillar_necrocite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_necrocite").setResistance(45.0F));
		basic_pillar_onyxius = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_onyxius").setResistance(45.0F));
		basic_pillar_soularite = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_soularite").setResistance(45.0F));
		basic_pillar_ebonheart = registerBlock(new BlockPillarVG("gemstone/regular/pillar/basic_pillar_ebonheart").setResistance(2000.0F));
		
		
		
		
		
		
		
		
		
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
		arcanite_ore = registerBlock(new BlockOreArcanite(2, 20f));
		katcheen_ore = registerBlock(new BlockOreKatcheen(3, 30f));
		necrocite_ore = registerBlock(new BlockOreNecrocite(3, 30f));
		soularite_ore = registerBlock(new BlockOreSoularite(3, 30f));
		ebonheart_ore = registerBlock(new BlockOreEbonheart(3, 30f));
		ebon_ore = registerBlock(new BlockMultiOre("ore/ebon_ore"));
		ebon_ore_nether = registerBlock(new BlockMultiOre("ore/ebon_ore_nether"));
		
		draconium_block = registerBlock(new BlockEA("gem/draconium/draconium_block").setResistance(4.0F).setLightLevel(0.4f));
		velious_block = registerBlock(new BlockEA("gem/velious/velious_block").setResistance(15.0F));
		arcanite_block = registerBlock(new BlockEA("gem/arcanite/arcanite_block").setResistance(30.0F));
		katcheen_block = registerBlock(new BlockEA("gem/katcheen/katcheen_block").setResistance(100.0F));
		necrocite_block = registerBlock(new BlockEA("gem/necrocite/necrocite_block").setResistance(45.0F));
		soularite_block = registerBlock(new BlockEA("gem/soularite/soularite_block").setResistance(45.0F));
		ebonheart_block = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block").setResistance(2000.0F));
		obsidian_block = registerBlock(new BlockEA("gem/obsidian/obsidian_block").setResistance(2000.0F));
		glowstone_block = registerBlock(new BlockEA("gem/glowstone/glowstone_block").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_brick = registerBlock(new BlockEA("gem/draconium/draconium_block_brick").setResistance(4.0F).setLightLevel(0.4f));
		velious_block_brick = registerBlock(new BlockEA("gem/velious/velious_block_brick").setResistance(15.0F));
		arcanite_block_brick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_brick").setResistance(30.0F));
		katcheen_block_brick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_brick").setResistance(100.0F));
		necrocite_block_brick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_brick").setResistance(45.0F));
		soularite_block_brick = registerBlock(new BlockEA("gem/soularite/soularite_block_brick").setResistance(45.0F));
		ebonheart_block_brick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_brick").setResistance(2000.0F));
		obsidian_block_brick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_brick").setResistance(2000.0F));
		glowstone_block_brick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_stairs = registerBlock(new EABlockStairs("stairs/draconium_stairs", draconium_block).setResistance(4.0F).setLightLevel(0.4f));
		velious_stairs = registerBlock(new EABlockStairs("stairs/velious_stairs", velious_block).setResistance(15.0F));
		arcanite_stairs = registerBlock(new EABlockStairs("stairs/arcanite_stairs", arcanite_block).setResistance(30.0F));
		katcheen_stairs = registerBlock(new EABlockStairs("stairs/katcheen_stairs", katcheen_block).setResistance(100.0F));
		necrocite_stairs = registerBlock(new EABlockStairs("stairs/necrocite_stairs", necrocite_block).setResistance(45.0F));
		soularite_stairs = registerBlock(new EABlockStairs("stairs/soularite_stairs", soularite_block).setResistance(45.0F));
		ebonheart_stairs = registerBlock(new EABlockStairs("stairs/ebonheart_stairs", ebonheart_block).setResistance(2000.0F));
		obsidian_stairs = registerBlock(new EABlockStairs("stairs/obsidian_stairs", obsidian_block).setResistance(2000.0F));
		glowstone_stairs = registerBlock(new EABlockStairs("stairs/glowstone_stairs", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence = registerBlock(new EABlockFence("fence/draconium_fence").setResistance(4.0F).setLightLevel(0.4f));
		velious_fence = registerBlock(new EABlockFence("fence/velious_fence").setResistance(15.0F));
		arcanite_fence = registerBlock(new EABlockFence("fence/arcanite_fence").setResistance(30.0F));
		katcheen_fence = registerBlock(new EABlockFence("fence/katcheen_fence").setResistance(100.0F));
		necrocite_fence = registerBlock(new EABlockFence("fence/necrocite_fence").setResistance(45.0F));
		soularite_fence = registerBlock(new EABlockFence("fence/soularite_fence").setResistance(45.0F));
		ebonheart_fence = registerBlock(new EABlockFence("fence/ebonheart_fence").setResistance(2000.0F));
		obsidian_fence = registerBlock(new EABlockFence("fence/obsidian_fence").setResistance(2000.0F));
		glowstone_fence = registerBlock(new EABlockFence("fence/glowstone_fence").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence_gate = registerBlock(new EABlockFenceGate("fence/draconium_fence_gate").setResistance(4.0F).setLightLevel(0.4f));
		velious_fence_gate = registerBlock(new EABlockFenceGate("fence/velious_fence_gate").setResistance(15.0F));
		arcanite_fence_gate = registerBlock(new EABlockFenceGate("fence/arcanite_fence_gate").setResistance(30.0F));
		katcheen_fence_gate = registerBlock(new EABlockFenceGate("fence/katcheen_fence_gate").setResistance(100.0F));
		necrocite_fence_gate = registerBlock(new EABlockFenceGate("fence/necrocite_fence_gate").setResistance(45.0F));
		soularite_fence_gate = registerBlock(new EABlockFenceGate("fence/soularite_fence_gate").setResistance(45.0F));
		ebonheart_fence_gate = registerBlock(new EABlockFenceGate("fence/ebonheart_fence_gate").setResistance(2000.0F));
		obsidian_fence_gate = registerBlock(new EABlockFenceGate("fence/obsidian_fence_gate").setResistance(2000.0F));
		glowstone_fence_gate = registerBlock(new EABlockFenceGate("fence/glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_wall 	= registerBlock(new EABlockWall("wall/draconium_wall", draconium_block).setResistance(4.0F).setLightLevel(0.4f));
		velious_wall 	= registerBlock(new EABlockWall("wall/velious_wall", velious_block).setResistance(15.0F));
		arcanite_wall 	= registerBlock(new EABlockWall("wall/arcanite_wall", arcanite_block).setResistance(30.0F));
		katcheen_wall 	= registerBlock(new EABlockWall("wall/katcheen_wall", katcheen_block).setResistance(100.0F));
		necrocite_wall 	= registerBlock(new EABlockWall("wall/necrocite_wall", necrocite_block).setResistance(45.0F));
		soularite_wall 	= registerBlock(new EABlockWall("wall/soularite_wall", soularite_block).setResistance(45.0F));
		ebonheart_wall 	= registerBlock(new EABlockWall("wall/ebonheart_wall", ebonheart_block).setResistance(2000.0F));
		obsidian_wall 	= registerBlock(new EABlockWall("wall/obsidian_wall", obsidian_block).setResistance(2000.0F));
		glowstone_wall	= registerBlock(new EABlockWall("wall/glowstone_wall", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		draconium_trapdoor = registerBlock(new EABlockTrapDoor("door/draconium_trapdoor").setResistance(4.0F).setLightLevel(0.4f));
		velious_trapdoor = registerBlock(new EABlockTrapDoor("door/velious_trapdoor").setResistance(4.0F));
		arcanite_trapdoor = registerBlock(new EABlockTrapDoor("door/arcanite_trapdoor").setResistance(4.0F));
		katcheen_trapdoor = registerBlock(new EABlockTrapDoor("door/katcheen_trapdoor").setResistance(4.0F));
		necrocite_trapdoor = registerBlock(new EABlockTrapDoor("door/necrocite_trapdoor").setResistance(4.0F));
		soularite_trapdoor = registerBlock(new EABlockTrapDoor("door/soularite_trapdoor").setResistance(4.0F));
		ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("door/ebonheart_trapdoor").setResistance(4.0F));
		obsidian_trapdoor = registerBlock(new EABlockTrapDoor("door/obsidian_trapdoor").setResistance(4.0F));
		glowstone_trapdoor = registerBlock(new EABlockTrapDoor("door/glowstone_trapdoor").setResistance(4.0F));
		
		draconium_ladder = registerBlock(new EABlockLadder("ladder/draconium_ladder").setLightLevel(0.4f));
		velious_ladder = registerBlock(new EABlockLadder("ladder/velious_ladder"));
		arcanite_ladder = registerBlock(new EABlockLadder("ladder/arcanite_ladder"));
		katcheen_ladder = registerBlock(new EABlockLadder("ladder/katcheen_ladder"));
		necrocite_ladder = registerBlock(new EABlockLadder("ladder/necrocite_ladder"));
		soularite_ladder = registerBlock(new EABlockLadder("ladder/soularite_ladder"));
		ebonheart_ladder = registerBlock(new EABlockLadder("ladder/ebonheart_ladder"));
		obsidian_ladder = registerBlock(new EABlockLadder("ladder/obsidian_ladder"));
		glowstone_ladder = registerBlock(new EABlockLadder("ladder/glowstone_ladder").setLightLevel(1.0f));
		
		draconium_pillar = registerBlock(new EABlockPillar("pillar/draconium_pillar").setResistance(4.0F).setLightLevel(0.4f));
		velious_pillar = registerBlock(new EABlockPillar("pillar/velious_pillar").setResistance(15.0F));
		arcanite_pillar = registerBlock(new EABlockPillar("pillar/arcanite_pillar").setResistance(30.0F));
		katcheen_pillar = registerBlock(new EABlockPillar("pillar/katcheen_pillar").setResistance(100.0F));
		necrocite_pillar = registerBlock(new EABlockPillar("pillar/necrocite_pillar").setResistance(45.0F));
		soularite_pillar = registerBlock(new EABlockPillar("pillar/soularite_pillar").setResistance(45.0F));
		ebonheart_pillar = registerBlock(new EABlockPillar("pillar/ebonheart_pillar").setResistance(2000.0F));
		obsidian_pillar = registerBlock(new EABlockPillar("pillar/obsidian_pillar").setResistance(2000.0F));
		glowstone_pillar = registerBlock(new EABlockPillar("pillar/glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_fancybrick = registerBlock(new BlockEA("gem/draconium/draconium_block_fancybrick").setResistance(4.0F).setLightLevel(0.4f));
		velious_block_fancybrick = registerBlock(new BlockEA("gem/velious/velious_block_fancybrick").setResistance(15.0F));
		arcanite_block_fancybrick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_fancybrick").setResistance(30.0F));
		katcheen_block_fancybrick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_fancybrick").setResistance(100.0F));
		necrocite_block_fancybrick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_fancybrick").setResistance(45.0F));
		soularite_block_fancybrick = registerBlock(new BlockEA("gem/soularite/soularite_block_fancybrick").setResistance(45.0F));
		ebonheart_block_fancybrick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_fancybrick").setResistance(2000.0F));
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
		soularite_ore_end = registerBlock(new BlockEndOreSoularite(3, 30f));
		ebonheart_ore_end = registerBlock(new BlockEndOreEbonheart(3, 30f));
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
		cryptic_arcanite_block = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_brick").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_brick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_brick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_brick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		double_cryptic_draconium_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_draconium_slab", "cryptic/slab/double_cryptic_draconium_slab").setResistance(4.0F).setLightLevel(0.4f);
		double_cryptic_velious_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_velious_slab", "cryptic/slab/double_cryptic_velious_slab").setResistance(15.0F);
		double_cryptic_arcanite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_arcanite_slab", "cryptic/slab/double_cryptic_arcanite_slab").setResistance(30.0F);
		double_cryptic_katcheen_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_katcheen_slab", "cryptic/slab/double_cryptic_katcheen_slab").setResistance(100.0F);
		double_cryptic_necrocite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_necrocite_slab", "cryptic/slab/double_cryptic_necrocite_slab").setResistance(45.0F);
		double_cryptic_soularite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_soularite_slab", "cryptic/slab/double_cryptic_soularite_slab").setResistance(45.0F);
		double_cryptic_ebonheart_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_ebonheart_slab", "cryptic/slab/double_cryptic_ebonheart_slab").setResistance(2000.0F);
		double_cryptic_obsidian_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_obsidian_slab", "cryptic/slab/double_cryptic_obsidian_slab").setResistance(2000.0F);
		double_cryptic_glowstone_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_glowstone_slab", "cryptic/slab/double_cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		cryptic_draconium_slab = new BlockHalfSlab("cryptic/slab/cryptic_draconium_slab", "cryptic/slab/cryptic_draconium_slab").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_velious_slab = new BlockHalfSlab("cryptic/slab/cryptic_velious_slab", "cryptic/slab/cryptic_velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_arcanite_slab = new BlockHalfSlab("cryptic/slab/cryptic_arcanite_slab", "cryptic/slab/cryptic_arcanite_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_katcheen_slab = new BlockHalfSlab("cryptic/slab/cryptic_katcheen_slab", "cryptic/slab/cryptic_katcheen_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_necrocite_slab = new BlockHalfSlab("cryptic/slab/cryptic_necrocite_slab", "cryptic/slab/cryptic_necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_soularite_slab = new BlockHalfSlab("cryptic/slab/cryptic_soularite_slab", "cryptic/slab/cryptic_soularite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_ebonheart_slab = new BlockHalfSlab("cryptic/slab/cryptic_ebonheart_slab", "cryptic/slab/cryptic_ebonheart_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_obsidian_slab = new BlockHalfSlab("cryptic/slab/cryptic_obsidian_slab", "cryptic/slab/cryptic_obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_glowstone_slab = new BlockHalfSlab("cryptic/slab/cryptic_glowstone_slab", "cryptic/slab/cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		
		registerBlockSlab(cryptic_draconium_slab, double_cryptic_draconium_slab);
		registerBlockSlab(cryptic_velious_slab, double_cryptic_velious_slab);
		registerBlockSlab(cryptic_arcanite_slab, double_cryptic_arcanite_slab);
		registerBlockSlab(cryptic_katcheen_slab, double_cryptic_katcheen_slab);
		registerBlockSlab(cryptic_necrocite_slab, double_cryptic_necrocite_slab);
		registerBlockSlab(cryptic_soularite_slab, double_cryptic_soularite_slab);
		registerBlockSlab(cryptic_ebonheart_slab, double_cryptic_ebonheart_slab);
		registerBlockSlab(cryptic_obsidian_slab, double_cryptic_obsidian_slab);
		registerBlockSlab(cryptic_glowstone_slab, double_cryptic_glowstone_slab);
		
		cryptic_draconium_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_draconium_stairs", cryptic_draconium_block).setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_velious_stairs", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_arcanite_stairs", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_katcheen_stairs", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_necrocite_stairs", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_soularite_stairs", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_ebonheart_stairs", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_obsidian_stairs", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_glowstone_stairs", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_draconium_fence").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_velious_fence").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_arcanite_fence").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_katcheen_fence").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_necrocite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_soularite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_ebonheart_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_obsidian_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_glowstone_fence").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_draconium_fence_gate").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_velious_fence_gate").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_arcanite_fence_gate").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_katcheen_fence_gate").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_necrocite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_soularite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_ebonheart_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_obsidian_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_draconium_wall", cryptic_draconium_block).setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_velious_wall", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_arcanite_wall", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_katcheen_wall", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_necrocite_wall", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_soularite_wall", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_ebonheart_wall", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_obsidian_wall", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_glowstone_wall", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		//cryptic_draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		//cryptic_velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		//cryptic_arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		//cryptic_katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		//cryptic_necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		//cryptic_soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		//cryptic_ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		//cryptic_obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		//cryptic_glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		cryptic_draconium_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_draconium_trapdoor").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_velious_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_arcanite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_katcheen_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_necrocite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_soularite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_ebonheart_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_obsidian_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_glowstone_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_draconium_ladder").setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_velious_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_arcanite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_katcheen_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_necrocite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_soularite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_ebonheart_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_obsidian_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_glowstone_ladder").setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_draconium_pillar").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_velious_pillar").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_arcanite_pillar").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_katcheen_pillar").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_necrocite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_soularite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_ebonheart_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_obsidian_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_fancybrick").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_fancybrick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_fancybrick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_fancybrick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		*/
	}
	
	
	
	protected static <V extends Block> V registerBlock(V block)
	{
		return registerBlock(block, ItemBlock::new);
	}
	
	/**
	 * Register a Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
	protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
		GameRegistry.register(block);

		if (itemFactory != null) {
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
	 * Register a Block with a custom ItemBlock class.
	 *
	 * @param <BLOCK>     The Block type
	 * @param block       The Block instance
	 * @param itemFactory A function that creates the ItemBlock instance, or null if no ItemBlock should be created
	 * @return The Block instance
	 */
	protected static <BLOCK extends Block> BLOCK registerBlockMetaGemstoneBasicV1(BLOCK block, @Nullable Function<BLOCK, ItemBlockGemstoneBasicV1> itemFactory) {
		GameRegistry.register(block);

		if (itemFactory != null) {
			final ItemBlockGemstoneBasicV1 itemBlock = itemFactory.apply(block);

			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		blocks.add(block);
		return block;
	}
	
	
	
	
	
	
	private static void registerBlockSlab(Block slab, Block doubleslab){
		GameRegistry.register(slab);
		GameRegistry.register(doubleslab);
		ItemSlab item = new ItemSlab(slab, (BlockSlab) slab, (BlockSlab) doubleslab);
		item.setRegistryName(slab.getRegistryName());
		GameRegistry.register(item);
	}
	
}

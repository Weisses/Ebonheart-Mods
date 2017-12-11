package com.viesis.gemstones.api;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.common.blocks.basic.BlockFenceVG;
import com.viesis.gemstones.common.blocks.basic.BlockGateVG;
import com.viesis.gemstones.common.blocks.basic.BlockLadderVG;
import com.viesis.gemstones.common.blocks.basic.BlockPillarVG;
import com.viesis.gemstones.common.blocks.basic.BlockStairsVG;
import com.viesis.gemstones.common.blocks.basic.BlockTrapDoorVG;
import com.viesis.gemstones.common.blocks.basic.BlockWallVG;
import com.viesis.gemstones.common.blocks.gemstones.BlockGemstoneBasicV1;
import com.viesis.gemstones.common.blocks.slabs.BlockDoubleSlabVG;
import com.viesis.gemstones.common.blocks.slabs.BlockHalfSlabVG;
import com.viesis.gemstones.common.blocks.tileentity.BlockGemstoneConverter;
import com.viesis.gemstones.common.blocks.tileentity.BlockGemstoneCutter;
import com.viesis.gemstones.common.blocks.torches.BlockTorchArcaniteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchCarnelianVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchDraconiteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchEbonheartVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchKatcheenVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchNecrociteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchOnyxiusVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchSoulariteVG;
import com.viesis.gemstones.common.blocks.torches.BlockTorchVeliousVG;
import com.viesis.gemstones.common.blocks.world.BlockOreVG;

import net.minecraft.block.Block;

public class VGBlocks {
	
	public static final BlockGemstoneCutter GEMSTONE_WORKBENCH = new BlockGemstoneCutter("gemstone_workbench");
	public static final BlockGemstoneConverter GEMSTONE_CONVERTER = new BlockGemstoneConverter("gemstone_converter");
	
	public static final BlockOreVG GEMINFUSED_ORE = new BlockOreVG("gemstone/ore/block_ore");
	
	public static final BlockGemstoneBasicV1 GEMSTONE_BASIC_BLOCK_V1 = new BlockGemstoneBasicV1("gemstone/regular/basic/block_basic");
	public static final BlockGemstoneBasicV1 GEMSTONE_BASIC_BRICK_V1 = new BlockGemstoneBasicV1("gemstone/regular/brick/block_brick");
	public static final BlockGemstoneBasicV1 GEMSTONE_BASIC_FANCYBRICK_V1 = new BlockGemstoneBasicV1("gemstone/regular/fancybrick/block_fancybrick");
	
	public static final Block BASIC_DOUBLESLAB_ARCANITE = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_arcanite").setResistance(4.0F).setLightLevel(0.4f);
	public static final Block BASIC_DOUBLESLAB_VELIOUS = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_velious").setResistance(15.0F);
	public static final Block BASIC_DOUBLESLAB_FENRYTE = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_fenryte").setResistance(30.0F);;
	public static final Block BASIC_DOUBLESLAB_ELECTIUM = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_electium").setResistance(100.0F);
	public static final Block BASIC_DOUBLESLAB_IGNEELIS = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_igneelis").setResistance(45.0F).setLightLevel(1.0f);
	public static final Block BASIC_DOUBLESLAB_NECROCITE = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_necrocite").setResistance(45.0F);
	public static final Block BASIC_DOUBLESLAB_ZEPHYRIUM = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_zephyrium").setResistance(2000.0F);
	public static final Block BASIC_DOUBLESLAB_ONYXIUS = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_onyxius").setResistance(45.0F);
	public static final Block BASIC_DOUBLESLAB_SOULARITE = new BlockDoubleSlabVG("gemstone/regular/slab/basic_doubleslab_soularite").setResistance(2000.0F);
	
	public static final Block BASIC_HALFSLAB_ARCANITE = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_arcanite").setResistance(4.0F).setLightLevel(0.4f).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_VELIOUS = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_velious").setResistance(15.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_FENRYTE = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_fenryte").setResistance(30.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_ELECTIUM = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_electium").setResistance(100.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_IGNEELIS = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_igneelis").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_NECROCITE = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_necrocite").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_ZEPHYRIUM = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_zephyrium").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_ONYXIUS = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_onyxius").setResistance(45.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	public static final Block BASIC_HALFSLAB_SOULARITE = new BlockHalfSlabVG("gemstone/regular/slab/basic_halfslab_soularite").setResistance(2000.0F).setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	
	public static final Block BASIC_STAIRS_ARCANITE = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_arcanite", GEMSTONE_BASIC_BLOCK_V1).setResistance(4.0F).setLightLevel(0.4f);
	public static final Block BASIC_STAIRS_VELIOUS = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_velious", GEMSTONE_BASIC_BLOCK_V1).setResistance(15.0F);
	public static final Block BASIC_STAIRS_FENRYTE = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_fenryte", GEMSTONE_BASIC_BLOCK_V1).setResistance(30.0F);
	public static final Block BASIC_STAIRS_ELECTIUM = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_electium", GEMSTONE_BASIC_BLOCK_V1).setResistance(100.0F);
	public static final Block BASIC_STAIRS_IGNEELIS = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_igneelis", GEMSTONE_BASIC_BLOCK_V1).setResistance(100.0F);
	public static final Block BASIC_STAIRS_NECROCITE = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_necrocite", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_STAIRS_ZEPHYRIUM = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_zephyrium", GEMSTONE_BASIC_BLOCK_V1).setResistance(100.0F);
	public static final Block BASIC_STAIRS_ONYXIUS = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_onyxius", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_STAIRS_SOULARITE = new BlockStairsVG("gemstone/regular/stairs/basic_stairs_soularite", GEMSTONE_BASIC_BLOCK_V1).setResistance(2000.0F);
	
	public static final Block BASIC_FENCE_ARCANITE = new BlockFenceVG("gemstone/regular/fence/basic_fence_arcanite").setResistance(4.0F).setLightLevel(0.4f);
	public static final Block BASIC_FENCE_VELIOUS = new BlockFenceVG("gemstone/regular/fence/basic_fence_velious").setResistance(15.0F);
	public static final Block BASIC_FENCE_FENRYTE = new BlockFenceVG("gemstone/regular/fence/basic_fence_fenryte").setResistance(30.0F);
	public static final Block BASIC_FENCE_ELECTIUM = new BlockFenceVG("gemstone/regular/fence/basic_fence_electium").setResistance(100.0F);
	public static final Block BASIC_FENCE_IGNEELIS = new BlockFenceVG("gemstone/regular/fence/basic_fence_igneelis").setResistance(45.0F);
	public static final Block BASIC_FENCE_NECROCITE = new BlockFenceVG("gemstone/regular/fence/basic_fence_necrocite").setResistance(45.0F);
	public static final Block BASIC_FENCE_ZEPHYRIUM = new BlockFenceVG("gemstone/regular/fence/basic_fence_zephyrium").setResistance(45.0F);
	public static final Block BASIC_FENCE_ONYXIUS = new BlockFenceVG("gemstone/regular/fence/basic_fence_onyxius").setResistance(45.0F);
	public static final Block BASIC_FENCE_SOULARITE = new BlockFenceVG("gemstone/regular/fence/basic_fence_soularite").setResistance(2000.0F);

	public static final Block BASIC_GATE_ARCANITE = new BlockGateVG("gemstone/regular/gate/basic_gate_arcanite").setResistance(4.0F).setLightLevel(0.4f);
	public static final Block BASIC_GATE_VELIOUS = new BlockGateVG("gemstone/regular/gate/basic_gate_velious").setResistance(15.0F);
	public static final Block BASIC_GATE_FENRYTE = new BlockGateVG("gemstone/regular/gate/basic_gate_fenryte").setResistance(30.0F);
	public static final Block BASIC_GATE_ELECTIUM = new BlockGateVG("gemstone/regular/gate/basic_gate_electium").setResistance(100.0F);
	public static final Block BASIC_GATE_IGNEELIS = new BlockGateVG("gemstone/regular/gate/basic_gate_igneelis").setResistance(45.0F);
	public static final Block BASIC_GATE_NECROCITE = new BlockGateVG("gemstone/regular/gate/basic_gate_necrocite").setResistance(45.0F);
	public static final Block BASIC_GATE_ZEPHYRIUM = new BlockGateVG("gemstone/regular/gate/basic_gate_zephyrium").setResistance(45.0F);
	public static final Block BASIC_GATE_ONYXIUS = new BlockGateVG("gemstone/regular/gate/basic_gate_onyxius").setResistance(45.0F);
	public static final Block BASIC_GATE_SOULARITE = new BlockGateVG("gemstone/regular/gate/basic_gate_soularite").setResistance(2000.0F);

	public static final Block BASIC_WALL_ARCANITE = new BlockWallVG("gemstone/regular/wall/basic_wall_arcanite", GEMSTONE_BASIC_BLOCK_V1).setResistance(4.0F).setLightLevel(0.4f);
	public static final Block BASIC_WALL_VELIOUS = new BlockWallVG("gemstone/regular/wall/basic_wall_velious", GEMSTONE_BASIC_BLOCK_V1).setResistance(15.0F);
	public static final Block BASIC_WALL_FENRYTE = new BlockWallVG("gemstone/regular/wall/basic_wall_fenryte", GEMSTONE_BASIC_BLOCK_V1).setResistance(30.0F);
	public static final Block BASIC_WALL_ELECTIUM = new BlockWallVG("gemstone/regular/wall/basic_wall_electium", GEMSTONE_BASIC_BLOCK_V1).setResistance(100.0F);
	public static final Block BASIC_WALL_IGNEELIS = new BlockWallVG("gemstone/regular/wall/basic_wall_igneelis", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_WALL_NECROCITE = new BlockWallVG("gemstone/regular/wall/basic_wall_necrocite", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_WALL_ZEPHYRIUM = new BlockWallVG("gemstone/regular/wall/basic_wall_zephyrium", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_WALL_ONYXIUS = new BlockWallVG("gemstone/regular/wall/basic_wall_onyxius", GEMSTONE_BASIC_BLOCK_V1).setResistance(45.0F);
	public static final Block BASIC_WALL_SOULARITE = new BlockWallVG("gemstone/regular/wall/basic_wall_soularite", GEMSTONE_BASIC_BLOCK_V1).setResistance(2000.0F);

	public static final Block BASIC_TORCH_ARCANITE = new BlockTorchDraconiteVG("gemstone/regular/torch/basic_torch_arcanite").setResistance(4.0F);
	public static final Block BASIC_TORCH_VELIOUS = new BlockTorchVeliousVG("gemstone/regular/torch/basic_torch_velious").setResistance(15.0F);
	public static final Block BASIC_TORCH_FENRYTE = new BlockTorchArcaniteVG("gemstone/regular/torch/basic_torch_fenryte").setResistance(30.0F);
	public static final Block BASIC_TORCH_ELECTIUM = new BlockTorchKatcheenVG("gemstone/regular/torch/basic_torch_electium").setResistance(100.0F);
	public static final Block BASIC_TORCH_IGNEELIS = new BlockTorchCarnelianVG("gemstone/regular/torch/basic_torch_igneelis").setResistance(45.0F);
	public static final Block BASIC_TORCH_NECROCITE = new BlockTorchNecrociteVG("gemstone/regular/torch/basic_torch_necrocite").setResistance(45.0F);
	public static final Block BASIC_TORCH_ZEPHYRIUM = new BlockTorchOnyxiusVG("gemstone/regular/torch/basic_torch_zephyrium").setResistance(45.0F);
	public static final Block BASIC_TORCH_ONYXIUS = new BlockTorchSoulariteVG("gemstone/regular/torch/basic_torch_onyxius").setResistance(45.0F);
	public static final Block BASIC_TORCH_SOULARITE = new BlockTorchEbonheartVG("gemstone/regular/torch/basic_torch_soularite").setResistance(2000.0F);

	public static final Block BASIC_TRAPDOOR_ARCANITE = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_arcanite").setResistance(4.0F);
	public static final Block BASIC_TRAPDOOR_VELIOUS = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_velious").setResistance(15.0F);
	public static final Block BASIC_TRAPDOOR_FENRYTE = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_fenryte").setResistance(30.0F);
	public static final Block BASIC_TRAPDOOR_ELECTIUM = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_electium").setResistance(100.0F);
	public static final Block BASIC_TRAPDOOR_IGNEELIS = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_igneelis").setResistance(45.0F);
	public static final Block BASIC_TRAPDOOR_NECROCITE = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_necrocite").setResistance(45.0F);
	public static final Block BASIC_TRAPDOOR_ZEPHYRIUM = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_zephyrium").setResistance(45.0F);
	public static final Block BASIC_TRAPDOOR_ONYXIUS = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_onyxius").setResistance(45.0F);
	public static final Block BASIC_TRAPDOOR_SOULARITE = new BlockTrapDoorVG("gemstone/regular/trapdoor/basic_trapdoor_soularite").setResistance(2000.0F);

	public static final Block BASIC_LADDER_ARCANITE = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_arcanite").setResistance(4.0F);
	public static final Block BASIC_LADDER_VELIOUS = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_velious").setResistance(15.0F);
	public static final Block BASIC_LADDER_FENRYTE = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_fenryte").setResistance(30.0F);
	public static final Block BASIC_LADDER_ELECTIUM = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_electium").setResistance(100.0F);
	public static final Block BASIC_LADDER_IGNEELIS = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_igneelis").setResistance(45.0F);
	public static final Block BASIC_LADDER_NECROCITE = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_necrocite").setResistance(45.0F);
	public static final Block BASIC_LADDER_ZEPHYRIUM = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_zephyrium").setResistance(45.0F);
	public static final Block BASIC_LADDER_ONYXIUS = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_onyxius").setResistance(45.0F);
	public static final Block BASIC_LADDER_SOULARITE = new BlockLadderVG("gemstone/regular/ladder/basic_ladder_soularite").setResistance(2000.0F);

	public static final Block BASIC_PILLAR_ARCANITE = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_arcanite").setResistance(4.0F);
	public static final Block BASIC_PILLAR_VELIOUS = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_velious").setResistance(15.0F);
	public static final Block BASIC_PILLAR_FENRYTE = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_fenryte").setResistance(30.0F);
	public static final Block BASIC_PILLAR_ELECTIUM = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_electium").setResistance(100.0F);
	public static final Block BASIC_PILLAR_IGNEELIS = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_igneelis").setResistance(45.0F);
	public static final Block BASIC_PILLAR_NECROCITE = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_necrocite").setResistance(45.0F);
	public static final Block BASIC_PILLAR_ZEPHYRIUM = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_zephyrium").setResistance(45.0F);
	public static final Block BASIC_PILLAR_ONYXIUS = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_onyxius").setResistance(45.0F);
	public static final Block BASIC_PILLAR_SOULARITE = new BlockPillarVG("gemstone/regular/pillar/basic_pillar_soularite").setResistance(2000.0F);
	
}

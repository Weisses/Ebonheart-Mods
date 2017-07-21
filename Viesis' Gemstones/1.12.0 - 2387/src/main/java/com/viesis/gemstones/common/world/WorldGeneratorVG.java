package com.viesis.gemstones.common.world;

import java.util.Random;

import com.viesis.gemstones.configs.ViesisGemstonesConfig;
import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorVG implements IWorldGenerator {
	
	private WorldGenerator gen_geminfused_ore_overworld; //Generates Gem-Infused Ore (used in Overworld)
	private WorldGenerator gen_geminfused_ore_nether; //Generates Gem-Infused Ore (used in Nether)
	private WorldGenerator gen_geminfused_ore_end; //Generates Gem-Infused Ore (used in End)
	
	//private WorldGenerator gen_multi_ore; //Generates Multi Ore (used in Overworld)
	
	public WorldGeneratorVG() 
	{
	    //for multi ore gens
		this.gen_geminfused_ore_overworld = new WorldGenMinable(InitBlocksVG.GEMINFUSED_ORE.getStateFromMeta(0), ViesisGemstonesConfig.gemInfusedOre_Overworld_ValueVein, BlockMatcher.forBlock(Blocks.STONE));
		this.gen_geminfused_ore_nether = new WorldGenMinable(InitBlocksVG.GEMINFUSED_ORE.getStateFromMeta(1), ViesisGemstonesConfig.gemInfusedOre_Nether_ValueVein, BlockMatcher.forBlock(Blocks.NETHERRACK));
		this.gen_geminfused_ore_end = new WorldGenMinable(InitBlocksVG.GEMINFUSED_ORE.getStateFromMeta(2), ViesisGemstonesConfig.gemInfusedOre_End_ValueVein, BlockMatcher.forBlock(Blocks.END_STONE));
		
		//for single ore gens
		//this.gen_ebon_ore = new WorldGenSingleMinable(InitBlocksEA.ebon_ore.getDefaultState(), BlockMatcher.forBlock(Blocks.STONE));
		//this.gen_ebon_ore_nether = new WorldGenSingleMinable(InitBlocksEA.ebon_ore_nether.getDefaultState(), BlockMatcher.forBlock(Blocks.NETHERRACK));
		//this.gen_ebon_ore_end = new WorldGenSingleMinable(InitBlocksEA.ebon_ore_end.getDefaultState(), BlockMatcher.forBlock(Blocks.END_STONE));
	}
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, net.minecraft.world.gen.IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		switch (world.provider.getDimension()) 
		{
			//Overworld
			case 0: 
				this.runGenerator(this.gen_geminfused_ore_overworld, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_Overworld_ValueChunk, 5, 128);//16 //# of veins per chunk; height min; height max
				break;
		        
		    //Nether
			case -1: 
				this.runGenerator(this.gen_geminfused_ore_nether, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_Nether_ValueChunk, 15, 125);//32
				break;
		        
		    //End
			case 1: 
				this.runGenerator(this.gen_geminfused_ore_end, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_End_ValueChunk, 5, 125);//32
				break;
		        
			//Default Gen
			default:
				this.runGenerator(this.gen_geminfused_ore_overworld, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_Overworld_ValueChunk, 32, 128);//16 //# of veins per chunk; height min; height max
				this.runGenerator(this.gen_geminfused_ore_nether, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_Nether_ValueChunk, 15, 125);//32
				this.runGenerator(this.gen_geminfused_ore_end, world, random, chunkX, chunkZ, ViesisGemstonesConfig.gemInfusedOre_End_ValueChunk, 5, 125);//32
				break;
		}
	}
	
	//standard method for running world generators at a random position within a chunk
	private void runGenerator(WorldGenerator generator, World world, Random rand, int chunk_X, int chunk_Z, int chancesToSpawn, int minHeight, int maxHeight) 
	{
	    if (minHeight < 0 || maxHeight > 256 || minHeight > maxHeight)
	    {
	        throw new IllegalArgumentException("Illegal Height Arguments for WorldGenerator, so says Viesis.");
	    }
	    
	    int heightDiff = maxHeight - minHeight + 1;
	    for (int i = 0; i < chancesToSpawn; i ++) 
	    {
	        int x = chunk_X * 16 + rand.nextInt(16);
	        int y = minHeight + rand.nextInt(heightDiff);
	        int z = chunk_Z * 16 + rand.nextInt(16);
	        generator.generate(world, rand, new BlockPos(x, y, z));
	    }
	}
}

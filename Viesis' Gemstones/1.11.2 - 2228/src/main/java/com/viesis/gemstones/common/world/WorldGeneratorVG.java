package com.viesis.gemstones.common.world;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGeneratorVG implements IWorldGenerator
{
	private WorldGenerator gen_draconium_ore; //Generates Draconium Ore (used in Overworld)
	private WorldGenerator gen_velious_ore; //Generates Velious Ore (used in Overworld)
	private WorldGenerator gen_arcanite_ore; //Generates Arcanite Ore (used in Overworld)
	private WorldGenerator gen_katcheen_ore; //Generates katcheen Ore (used in Overworld)
	private WorldGenerator gen_ebon_ore; //Generates Ebon Ore (used in Overworld)
	private WorldGenerator gen_necrocite_ore; //Generates Necrocite Ore (used in Nether)
	private WorldGenerator gen_soularite_ore; //Generates Soularite Ore (used in Nether)
	private WorldGenerator gen_ebonheart_ore; //Generates Ebonheart Ore (used in Nether)
	private WorldGenerator gen_ebon_ore_nether; //Generates Ebon Ore (used in Nether)
	
	private WorldGenerator gen_ebon_ore_end; //Generates Ebon Ore (used in Overworld)
	private WorldGenerator gen_necrocite_ore_end; //Generates Necrocite Ore (used in Nether)
	private WorldGenerator gen_soularite_ore_end; //Generates Soularite Ore (used in Nether)
	private WorldGenerator gen_ebonheart_ore_end; //Generates Ebonheart Ore (used in Nether)
	
	//private WorldGenerator gen_multi_ore; //Generates Multi Ore (used in Overworld)
	
	//create a new instance of a WorldGenMinable which can generate a bunch of tutorial ores (up to 8 in one call)
	public WorldGeneratorVG() 
	{
	    /**
		//for multi ore gens
		this.gen_draconium_ore = new WorldGenMinable(InitBlocksEA.draconium_ore.getDefaultState(), 
				//EbonArtsConfiguration.draconiumValueVein
				8, BlockMatcher.forBlock(Blocks.STONE)); //the 8 is the max vein size
		this.gen_velious_ore = new WorldGenMinable(InitBlocksEA.velious_ore.getDefaultState(), 
				//EbonArtsConfiguration.veliousValueVein
				6, BlockMatcher.forBlock(Blocks.STONE));
		this.gen_arcanite_ore = new WorldGenMinable(InitBlocksEA.arcanite_ore.getDefaultState(), 
				//EbonArtsConfiguration.arcaniteValueVein
				5, BlockMatcher.forBlock(Blocks.STONE));
		this.gen_katcheen_ore = new WorldGenMinable(InitBlocksEA.katcheen_ore.getDefaultState(), 
				//EbonArtsConfiguration.katcheenValueVein
				4, BlockMatcher.forBlock(Blocks.STONE));
		this.gen_necrocite_ore = new WorldGenMinable(InitBlocksEA.necrocite_ore.getDefaultState(), 
				//EbonArtsConfiguration.necrociteValueVein
				3, BlockMatcher.forBlock(Blocks.NETHERRACK));
		this.gen_soularite_ore = new WorldGenMinable(InitBlocksEA.soularite_ore.getDefaultState(), 
				//EbonArtsConfiguration.soulariteValueVein
				3, BlockMatcher.forBlock(Blocks.NETHERRACK));
		this.gen_ebonheart_ore = new WorldGenMinable(InitBlocksEA.ebonheart_ore.getDefaultState(), 
				//EbonArtsConfiguration.ebonheartValueVein
				3, BlockMatcher.forBlock(Blocks.NETHERRACK));
		this.gen_necrocite_ore_end = new WorldGenMinable(InitBlocksEA.necrocite_ore_end.getDefaultState(), 
				//EbonArtsConfiguration.necrociteValueVein
				3, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_soularite_ore_end = new WorldGenMinable(InitBlocksEA.soularite_ore_end.getDefaultState(), 
				//EbonArtsConfiguration.soulariteValueVein
				3, BlockMatcher.forBlock(Blocks.END_STONE));
		this.gen_ebonheart_ore_end = new WorldGenMinable(InitBlocksEA.ebonheart_ore_end.getDefaultState(), 
				//EbonArtsConfiguration.ebonheartValueVein
				3, BlockMatcher.forBlock(Blocks.END_STONE));
		
		//for single ore gens
		this.gen_ebon_ore = new WorldGenSingleMinable(InitBlocksEA.ebon_ore.getDefaultState(), BlockMatcher.forBlock(Blocks.STONE));
		this.gen_ebon_ore_nether = new WorldGenSingleMinable(InitBlocksEA.ebon_ore_nether.getDefaultState(), BlockMatcher.forBlock(Blocks.NETHERRACK));
		this.gen_ebon_ore_end = new WorldGenSingleMinable(InitBlocksEA.ebon_ore_end.getDefaultState(), BlockMatcher.forBlock(Blocks.END_STONE));
		*/
	}
	
	

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider) 
	{
		/**switch (world.provider.getDimension()) 
		{
		//Overworld
		case 0: 
			//for multi ore gen
			this.runGenerator(this.gen_draconium_ore, world, random, chunkX, chunkZ, EbonArtsConfig.draconiumValueChunk, 32, 128);//16 //# of veins per chunk; height min; height max
			this.runGenerator(this.gen_velious_ore, world, random, chunkX, chunkZ, EbonArtsConfig.veliousValueChunk, 24, 128);//8
			this.runGenerator(this.gen_arcanite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.arcaniteValueChunk, 5, 48);//6
			this.runGenerator(this.gen_katcheen_ore, world, random, chunkX, chunkZ, EbonArtsConfig.katcheenValueChunk, 5, 16);//3
			
			//for single ore gen
			this.runGenerator(this.gen_ebon_ore, world, random, chunkX, chunkZ, 1, 5, 16);//1
			break;
	        
	    //Nether
		case -1: 
			//for multi ore gen
			this.runGenerator(this.gen_necrocite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.necrociteValueChunk, 15, 125);//32
			this.runGenerator(this.gen_soularite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.soulariteValueChunk, 15, 125);//32
			this.runGenerator(this.gen_ebonheart_ore, world, random, chunkX, chunkZ, EbonArtsConfig.ebonheartValueChunk, 15, 125);//32
			
			//for single ore gen
			this.runGenerator(this.gen_ebon_ore_nether, world, random, chunkX, chunkZ, 8, 15, 125);//8
			
	        break;
	        
	    //End
		case 1: 
			//for multi ore gen
			this.runGenerator(this.gen_necrocite_ore_end, world, random, chunkX, chunkZ, EbonArtsConfig.necrociteEndValueChunk, 5, 125);//32
			this.runGenerator(this.gen_soularite_ore_end, world, random, chunkX, chunkZ, EbonArtsConfig.soulariteEndValueChunk, 5, 125);//32
			this.runGenerator(this.gen_ebonheart_ore_end, world, random, chunkX, chunkZ, EbonArtsConfig.ebonheartEndValueChunk, 5, 125);//32
			
			//for single ore gen
			this.runGenerator(this.gen_ebon_ore_end, world, random, chunkX, chunkZ, 8, 15, 125);//8
			
	        break;
	    //}
		
		//Default Gen
		default:
			//Overworld
			this.runGenerator(this.gen_draconium_ore, world, random, chunkX, chunkZ, EbonArtsConfig.draconiumValueChunk, 32, 128);//16 //# of veins per chunk; height min; height max
			this.runGenerator(this.gen_velious_ore, world, random, chunkX, chunkZ, EbonArtsConfig.veliousValueChunk, 24, 128);//8
			this.runGenerator(this.gen_arcanite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.arcaniteValueChunk, 5, 48);//6
			this.runGenerator(this.gen_katcheen_ore, world, random, chunkX, chunkZ, EbonArtsConfig.katcheenValueChunk, 5, 16);//3
			
			//nether
			this.runGenerator(this.gen_necrocite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.necrociteValueChunk, 15, 125);//32
			this.runGenerator(this.gen_soularite_ore, world, random, chunkX, chunkZ, EbonArtsConfig.soulariteValueChunk, 15, 125);//32
			this.runGenerator(this.gen_ebonheart_ore, world, random, chunkX, chunkZ, EbonArtsConfig.ebonheartValueChunk, 15, 125);//32
			
			//for single ore gen
			this.runGenerator(this.gen_ebon_ore, world, random, chunkX, chunkZ, 1, 5, 16);//1
			this.runGenerator(this.gen_ebon_ore_nether, world, random, chunkX, chunkZ, 8, 15, 125);//8
			
		 break;
		}
		*/
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
	
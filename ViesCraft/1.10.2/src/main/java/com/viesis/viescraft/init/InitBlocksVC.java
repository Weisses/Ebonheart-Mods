package com.viesis.viescraft.init;

import com.viesis.viescraft.api.BlocksVC;

public class InitBlocksVC extends BlocksVC {
	
	//public static final Set<Block> blocks = new HashSet<>();
	
	public static void preInit()
	{
		
		/**
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
		/**	protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) {
		GameRegistry.register(block);

		if (itemFactory != null) {
			final ItemBlock itemBlock = itemFactory.apply(block);

			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		blocks.add(block);
		return block;
	}
	*/
	}
}

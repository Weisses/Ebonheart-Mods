package com.viesis.viescraft.init;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.viesis.viescraft.api.BlocksVC;
import com.viesis.viescraft.common.blocks.BlockAirshipWorkbench;

public class InitBlocksVC extends BlocksVC {
	
	public static final Set<Block> blocks = new HashSet<>();
	
	public static void registerBlock()
	{
		airship_workbench = registerBlock(new BlockAirshipWorkbench("airship_workbench"));
	}
	
	public static void registerBlockTEMP()
	{
		
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
	protected static <BLOCK extends Block> BLOCK registerBlock(BLOCK block, @Nullable Function<BLOCK, ItemBlock> itemFactory) 
	{
		GameRegistry.register(block);
		
		if (itemFactory != null) {
			final ItemBlock itemBlock = itemFactory.apply(block);
			
			GameRegistry.register(itemBlock.setRegistryName(block.getRegistryName()));
		}
		blocks.add(block);
		return block;
	}
}

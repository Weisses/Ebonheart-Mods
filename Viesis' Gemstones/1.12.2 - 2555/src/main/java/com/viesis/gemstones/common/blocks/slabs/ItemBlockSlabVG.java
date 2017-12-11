package com.viesis.gemstones.common.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockSlabVG extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemBlockSlabVG(final Block block, final BlockHalfSlabVG slab, final BlockDoubleSlabVG doubleSlab, final Boolean stacked) 
    {
        super(block, slab, doubleSlab);
    }
}

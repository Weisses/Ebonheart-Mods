package com.ebonheart.EbonArtsMod.common.blocks.slabs;

import net.minecraft.block.Block;
import net.minecraft.item.ItemSlab;

public class ItemBlockSlabEA extends ItemSlab {
    /**
     * Initializes a new instance of the ItemBlockSlab class.
     * @param block the block behind the item.
     * @param slab the half height slab.
     * @param doubleSlab the full height slab.
     * @param stacked whether or not the block is the stacked version.
     */
    public ItemBlockSlabEA(final Block block, final BlockHalfSlabEA slab, final BlockDoubleSlabEA doubleSlab, final Boolean stacked) 
    {
        super(block, slab, doubleSlab);
    }
}

package com.ebonheart.EbonArtsMod.common.blocks.misc;

import com.ebonheart.EbonArtsMod.EbonArtsMod;

import net.minecraft.block.BlockDynamicLiquid;
import net.minecraft.block.material.Material;

public class TestBlockDynamicLiquidEA extends BlockDynamicLiquid {

	public TestBlockDynamicLiquidEA(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("flowing_test_liquid");
		this.setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		this.setHardness(100.0F);
		this.setLightOpacity(3);
		this.disableStats();
	}
}

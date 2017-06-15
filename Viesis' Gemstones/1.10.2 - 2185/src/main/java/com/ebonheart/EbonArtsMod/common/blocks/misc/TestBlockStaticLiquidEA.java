package com.ebonheart.EbonArtsMod.common.blocks.misc;

import com.ebonheart.EbonArtsMod.EbonArtsMod;

import net.minecraft.block.BlockStaticLiquid;
import net.minecraft.block.material.Material;

public class TestBlockStaticLiquidEA extends BlockStaticLiquid {

	public TestBlockStaticLiquidEA(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("test_liquid");
		this.setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		this.setHardness(100.0F);
		this.setLightOpacity(3);
		this.disableStats();
	}

}

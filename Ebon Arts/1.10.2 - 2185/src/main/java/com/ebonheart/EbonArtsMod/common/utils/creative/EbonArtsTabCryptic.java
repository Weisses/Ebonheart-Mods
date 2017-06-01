package com.ebonheart.EbonArtsMod.common.utils.creative;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.ebonheart.EbonArtsMod.api.BlocksEA;
import com.ebonheart.EbonArtsMod.init.InitBlocksEA;
import com.ebonheart.EbonArtsMod.init.InitItemsEA;

public class EbonArtsTabCryptic extends CreativeTabs {

	public EbonArtsTabCryptic(String label) 
	{
		super(label);
		this.setBackgroundImageName("ebonarts.png");
	}

	@Override
	public Item getTabIconItem() 
	{
		return Item.getItemFromBlock(BlocksEA.cryptic_necrocite_block);
	}
}

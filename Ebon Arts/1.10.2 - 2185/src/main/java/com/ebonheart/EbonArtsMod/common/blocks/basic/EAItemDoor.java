package com.ebonheart.EbonArtsMod.common.blocks.basic;

import com.ebonheart.EbonArtsMod.common.items.ItemHelper;

import net.minecraft.block.Block;
import net.minecraft.item.ItemDoor;

public class EAItemDoor extends ItemDoor {
	
	public EAItemDoor(Block block) 
	{
		super(block);
		
		ItemHelper.setItemName(this, "test_door");
	}
	
}

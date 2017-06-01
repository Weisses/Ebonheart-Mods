package com.ebonheart.EbonArtsMod.common.blocks.slabs;

public class BlockDoubleSlabEA extends BlockSlabEA {
	
	public BlockDoubleSlabEA(String unlocalname) 
	{
		super(unlocalname, unlocalname);
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
}

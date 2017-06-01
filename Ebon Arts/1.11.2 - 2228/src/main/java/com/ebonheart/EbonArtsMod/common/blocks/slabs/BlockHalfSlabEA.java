package com.ebonheart.EbonArtsMod.common.blocks.slabs;

public class BlockHalfSlabEA extends BlockSlabEA {
	
	public BlockHalfSlabEA(String unlocalname) 
	{
		super(unlocalname, unlocalname);
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}
}

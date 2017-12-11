package com.viesis.gemstones.common.blocks.slabs;

public class BlockHalfSlabVG extends BlockSlabVG {
	
	public BlockHalfSlabVG(String unlocalname) 
	{
		super(unlocalname, unlocalname);
	}
	
	@Override
	public boolean isDouble() 
	{
		return false;
	}
}

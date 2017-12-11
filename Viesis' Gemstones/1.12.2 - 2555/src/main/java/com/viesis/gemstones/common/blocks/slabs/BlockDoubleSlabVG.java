package com.viesis.gemstones.common.blocks.slabs;

public class BlockDoubleSlabVG extends BlockSlabVG {
	
	public BlockDoubleSlabVG(String unlocalname) 
	{
		super(unlocalname, unlocalname);
	}
	
	@Override
	public boolean isDouble() 
	{
		return true;
	}
}

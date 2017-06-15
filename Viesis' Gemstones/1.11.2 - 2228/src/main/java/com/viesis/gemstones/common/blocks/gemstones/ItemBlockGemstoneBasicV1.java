package com.viesis.gemstones.common.blocks.gemstones;

import com.viesis.gemstones.api.VGEnum.GemstoneTypeBlockV1;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockGemstoneBasicV1 extends ItemBlock {
	
    public ItemBlockGemstoneBasicV1(Block block) 
    {
        super(block);
        
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }
    
    @Override
    public int getMetadata(int metadata)
    {
      return metadata;
    }
    
    @Override
    public String getUnlocalizedName(ItemStack stack) 
    {
        return super.getUnlocalizedName() + "_" + GemstoneTypeBlockV1.byMetadata(stack.getMetadata()).getName();
    }
    
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return GemstoneTypeBlockV1.byMetadata(this.getMetadata(stack)).getEnumRarity();
    }
}

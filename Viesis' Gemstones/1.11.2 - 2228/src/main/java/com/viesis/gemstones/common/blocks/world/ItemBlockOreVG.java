package com.viesis.gemstones.common.blocks.world;

import com.viesis.gemstones.api.VGEnum.GemstoneTypeOre;

import net.minecraft.block.Block;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockOreVG extends ItemBlock {
	
    public ItemBlockOreVG(Block block) 
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
        return super.getUnlocalizedName() + "_" + GemstoneTypeOre.byMetadata(stack.getMetadata()).getName();
    }
    
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return GemstoneTypeOre.byMetadata(this.getMetadata(stack)).getEnumRarity();
    }
}

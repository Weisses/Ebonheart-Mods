package com.viesis.gemstones.common.blocks.world;

import java.util.ArrayList;
import java.util.Random;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.References;
import com.viesis.gemstones.api.VGEnum.GemstoneTypeOre;
import com.viesis.gemstones.common.blocks.IMetaBlockGemstone;
import com.viesis.gemstones.common.blocks.basic.BlockBaseVG;
import com.viesis.gemstones.init.InitItemsVG;

import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockOreVG extends BlockBaseVG implements IMetaBlockGemstone {
	
	public static final IProperty<GemstoneTypeOre> VARIANT = PropertyEnum.create("variant", GemstoneTypeOre.class);
	
	public BlockOreVG(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.setCreativeTab(ViesisGemstones.tabVGGeneral);
	}
	
    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, GemstoneTypeOre.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return GemstoneTypeOre.byMetadata(stack.getMetadata()).getLocalizedName() + " " 
        		+ I18n.translateToLocal("ea.block.ore");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    {
		for (GemstoneTypeOre contents : GemstoneTypeOre.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(this, 1, meta);
			items.add(subItemStack);
    	}
    }
	
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
    {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int j = random.nextInt(fortune + 2) - 1;

            if (j < 0)
            {
                j = 0;
            }
            return this.quantityDropped(random) * (j + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
	
    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune)
    {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this))
        {
            int i = MathHelper.getInt(rand, 3, 7);
            
            return i;
        }
        
        return 0;
    }
	
	@Override
	public ArrayList<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState blockstate, int fortune) 
	{
		ArrayList<ItemStack> drops = new ArrayList<ItemStack>();
		drops.add(new ItemStack(InitItemsVG.gemstone_item_unidentified, References.random.nextInt(3) + 2));
		
		if (References.random.nextFloat() < 0.5F)
		{
			drops.add(new ItemStack(InitItemsVG.gemstone_item_basic_v1, References.random.nextInt(4), References.random.nextInt(8)));
		}
		
		return drops;
	}
}

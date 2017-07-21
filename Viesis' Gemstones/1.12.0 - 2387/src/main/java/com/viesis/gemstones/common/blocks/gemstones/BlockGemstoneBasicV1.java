package com.viesis.gemstones.common.blocks.gemstones;

import com.viesis.gemstones.ViesisGemstones;
import com.viesis.gemstones.api.VGEnum.GemstoneTypeBlockV1;
import com.viesis.gemstones.api.VGEnum.RegistryType;
import com.viesis.gemstones.common.blocks.BlockHelper;
import com.viesis.gemstones.common.blocks.IMetaBlockGemstone;
import com.viesis.gemstones.common.blocks.basic.BlockBaseVG;

import net.minecraft.block.BlockWall;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockGemstoneBasicV1 extends BlockBaseVG implements IMetaBlockGemstone {
	
	public static final IProperty<GemstoneTypeBlockV1> VARIANT = PropertyEnum.create("variant", GemstoneTypeBlockV1.class);
	
	public BlockGemstoneBasicV1(String unlocalizedName) 
	{
		super(unlocalizedName);
		
		this.setCreativeTab(ViesisGemstones.tabVGBlocksRegular);
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, GemstoneTypeBlockV1.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
	    return getMetaFromState(state);
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return GemstoneTypeBlockV1.byMetadata(stack.getMetadata()).getLocalizedName() + " " 
        		+ I18n.translateToLocal("ea.block.gemstone");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items)
    //public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list)
    {
		for (GemstoneTypeBlockV1 contents : GemstoneTypeBlockV1.values()) 
    	{
			if(contents.getRegistryType() == RegistryType.ALL
			|| contents.getRegistryType() == RegistryType.BLOCKONLY)
			{
				int meta = contents.getMetadata();
				ItemStack subItemStack = new ItemStack(this, 1, meta);
				items.add(subItemStack);
			}
    	}
    }



	//This cycles through all variants witha  right click!!!!
	//@Override
	//public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) 
	//{
	//	return worldIn.setBlockState(pos, state.cycleProperty(VARIANT));
	//}
	
}

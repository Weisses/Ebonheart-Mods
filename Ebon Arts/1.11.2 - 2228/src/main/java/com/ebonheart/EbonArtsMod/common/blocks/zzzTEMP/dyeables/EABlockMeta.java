package com.ebonheart.EbonArtsMod.common.blocks.zzzTEMP.dyeables;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.world.World;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.blocks.BlockHelper;
import com.ebonheart.EbonArtsMod.common.utils.meta.IMetaBlockName;


public class EABlockMeta extends Block implements IMetaBlockName {

	public static final PropertyEnum TYPE = PropertyEnum.create("type", EABlockMeta.EnumType.class);
	
	public EABlockMeta(String unlocalizedName, Material materialIn) 
	{
		super(materialIn);
		//BlockHelper.setBlockName(this, unlocalizedName);
		this.setUnlocalizedName(unlocalizedName);
		this.setCreativeTab(EbonArtsMod.tabEbonArtsDyeables);
		this.setHarvestLevel("pickaxe", 2);
		this.setSoundType(SoundType.STONE);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TYPE, EnumType.WHITE));
	}

	//This methods returns a BlockState which contains every property the block has.
	@Override
	protected BlockStateContainer createBlockState() 
	{
	    return new BlockStateContainer(this, new IProperty[] { TYPE });
	}
	
	//@Override
	//protected BlockState createBlockState() 
	//{
	//    return new BlockState(this, new IProperty[] { TYPE });
	//}

	//These 2 methods are used to convert a IBlocState into metadata and the other way around.
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		switch(meta)
		{
		case 0:
			return getDefaultState().withProperty(TYPE, EnumType.WHITE);
			
		case 1:
			return getDefaultState().withProperty(TYPE, EnumType.ORANGE);
			
		case 2:
			return getDefaultState().withProperty(TYPE, EnumType.MAGENTA);
			
		case 3:
			return getDefaultState().withProperty(TYPE, EnumType.LIGHTBLUE);
			
		case 4:
			return getDefaultState().withProperty(TYPE, EnumType.YELLOW);
			
		case 5:
			return getDefaultState().withProperty(TYPE, EnumType.LIME);
			
		case 6:
			return getDefaultState().withProperty(TYPE, EnumType.PINK);
			
		case 7:
			return getDefaultState().withProperty(TYPE, EnumType.GRAY);
			
		case 8:
			return getDefaultState().withProperty(TYPE, EnumType.LIGHTGRAY);
			
		case 9:
			return getDefaultState().withProperty(TYPE, EnumType.CYAN);
			
		case 10:
			return getDefaultState().withProperty(TYPE, EnumType.PURPLE);
			
		case 11:
			return getDefaultState().withProperty(TYPE, EnumType.BLUE);
			
		case 12:
			return getDefaultState().withProperty(TYPE, EnumType.BROWN);
			
		case 13:
			return getDefaultState().withProperty(TYPE, EnumType.GREEN);
			
		case 14:
			return getDefaultState().withProperty(TYPE, EnumType.RED);
			
		case 15:
			return getDefaultState().withProperty(TYPE, EnumType.BLACK);
		}
		return getDefaultState().withProperty(TYPE, EnumType.WHITE);
	}

	@Override
	public int getMetaFromState(IBlockState state) 
	{
	    EnumType type = (EnumType) state.getValue(TYPE);
	    return type.getID();
	}

	//Override the method damageDropped so that the block drops the item with the corresponding metadata.
	@Override
	public int damageDropped(IBlockState state) 
	{
	    return getMetaFromState(state);
	}

	//Add the ItemStacks with the different metadata values to the list of itemstacks that is finally displayed in the creative tab
	@Override
	public void getSubBlocks(
			Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list
			//Item itemIn, CreativeTabs tab, List list
			) 
	{
	    list.add(new ItemStack(itemIn, 1, 0)); //Meta 0
	    list.add(new ItemStack(itemIn, 1, 1)); //Meta 1
	    list.add(new ItemStack(itemIn, 1, 2)); //Meta 2
	    list.add(new ItemStack(itemIn, 1, 3)); //Meta 3
	    list.add(new ItemStack(itemIn, 1, 4)); //Meta 4
	    list.add(new ItemStack(itemIn, 1, 5)); //Meta 5
	    list.add(new ItemStack(itemIn, 1, 6)); //Meta 6
	    list.add(new ItemStack(itemIn, 1, 7)); //Meta 7
	    list.add(new ItemStack(itemIn, 1, 8)); //Meta 8
	    list.add(new ItemStack(itemIn, 1, 9)); //Meta 9
	    list.add(new ItemStack(itemIn, 1, 10)); //Meta 10
	    list.add(new ItemStack(itemIn, 1, 11)); //Meta 11
	    list.add(new ItemStack(itemIn, 1, 12)); //Meta 12
	    list.add(new ItemStack(itemIn, 1, 13)); //Meta 13
	    list.add(new ItemStack(itemIn, 1, 14)); //Meta 14
	    list.add(new ItemStack(itemIn, 1, 15)); //Meta 15
	}

	//get the type name from the metadata
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		switch(stack.getItemDamage())
		{
		case 0:
			return "white";
			
		case 1:
			return "orange";
			
		case 2:
			return "magenta";
			
		case 3:
			return "lightblue";
			
		case 4:
			return "yellow";
			
		case 5:
			return "lime";
			
		case 6:
			return "pink";
			
		case 7:
			return "gray";
			
		case 8:
			return "lightgray";
			
		case 9:
			return "cyan";
			
		case 10:
			return "purple";
			
		case 11:
			return "blue";
			
		case 12:
			return "brown";
			
		case 13:
			return "green";
			
		case 14:
			return "red";
			
		case 15:
			return "black";
		}
		return "white";
	}

	//define which ItemStack we'll get when we pick the block in creative mode
	//@Override
	public ItemStack getPickBlock(
			//MovingObjectPosition
			RayTraceResult 
			target, World world, BlockPos pos) 
	{
	    return new ItemStack(Item.getItemFromBlock(this), 1, this.getMetaFromState(world.getBlockState(pos)));
	}
	
	/**
     * Get the MapColor for this Block and the given BlockState
     */
    public MapColor getMapColor(IBlockState state)
    {
        return ((EABlockMeta.EnumType)state.getValue(TYPE)).func_181074_c();
    }

	//Simple Enum enclosed class.
	public enum EnumType implements IStringSerializable 
	{
	    WHITE(0, null, "white"),
	    ORANGE(1, null, "orange"),
	    MAGENTA(2, null, "magenta"),
	    LIGHTBLUE(3, null, "lightblue"),
	    YELLOW(4, null, "yellow"),
	    LIME(5, null, "lime"),
	    PINK(6, null, "pink"),
	    GRAY(7, null, "gray"),
	    LIGHTGRAY(8, null, "lightgray"),
	    CYAN(9, null, "cyan"),
	    PURPLE(10, null, "purple"),
	    BLUE(11, null, "blue"),
	    BROWN(12, null, "brown"),
	    GREEN(13, null, "green"),
	    RED(14, null, "red"),
	    BLACK(15, null, "black");

	    private int ID;
	    private String name;
	    private final MapColor mapColorIn;
	    
	    private EnumType(int ID, MapColor p_i46382_4_, String name) 
	    {
	        this.ID = ID;
	        this.name = name;
	        this.mapColorIn = p_i46382_4_;
	    }
	    
	    public MapColor func_181074_c()
        {
            return this.mapColorIn;
        }
	    
	    @Override
	    public String getName() 
	    {
	        return name;
	    }

	    public int getID() 
	    {
	        return ID;
	    }
	    
	    @Override
	    public String toString() 
	    {
	        return getName();
	    }
	}
}

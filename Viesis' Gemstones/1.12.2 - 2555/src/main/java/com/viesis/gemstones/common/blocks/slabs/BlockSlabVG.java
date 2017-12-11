package com.viesis.gemstones.common.blocks.slabs;

import java.util.List;
import java.util.Random;

import com.viesis.gemstones.init.InitBlocksVG;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class BlockSlabVG extends BlockSlab {
	
	public static final PropertyEnum TYPE = PropertyEnum.create("type", BlockSlabVG.EnumType.class);
	
	public BlockSlabVG(String unlocalname, String registryname) 
	{
		super(Material.ROCK);
		
		setUnlocalizedName(unlocalname);
		setRegistryName(registryname);
		useNeighborBrightness = true;
		setHardness(0.8F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        
		IBlockState state = this.blockState.getBaseState();
		state.withProperty(TYPE, EnumType.STONE);
		
		if(!this.isDouble())
		{
			state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		
		setDefaultState(state);
	}
	
	@Override
	public String getUnlocalizedName(int meta)
	{
		return this.getUnlocalizedName();
	}
	
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) 
	{
		return BlockSlabVG.EnumType.byMetadata(stack.getMetadata() & 7);
	}
	
	@Override
	public IProperty<?> getVariantProperty()
	{
		return TYPE;
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return this == InitBlocksVG.BASIC_DOUBLESLAB_ARCANITE ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ARCANITE)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_VELIOUS ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_VELIOUS) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_FENRYTE ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_FENRYTE) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ELECTIUM ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ELECTIUM) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_IGNEELIS ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_IGNEELIS)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_NECROCITE ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_NECROCITE) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ZEPHYRIUM ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ZEPHYRIUM) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ONYXIUS ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ONYXIUS) 
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_SOULARITE ? Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_SOULARITE) 
						
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_draconium ? Item.getItemFromBlock(InitBlocksEA.cryptic_draconium)
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_velious ? Item.getItemFromBlock(InitBlocksEA.cryptic_velious) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_arcanite ? Item.getItemFromBlock(InitBlocksEA.cryptic_arcanite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_katcheen ? Item.getItemFromBlock(InitBlocksEA.cryptic_katcheen) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_necrocite ? Item.getItemFromBlock(InitBlocksEA.cryptic_necrocite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_soularite ? Item.getItemFromBlock(InitBlocksEA.cryptic_soularite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_ebonheart ? Item.getItemFromBlock(InitBlocksEA.cryptic_ebonheart) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_obsidian ? Item.getItemFromBlock(InitBlocksEA.cryptic_obsidian) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_glowstone ? Item.getItemFromBlock(InitBlocksEA.cryptic_glowstone)
				: Item.getItemFromBlock(this)))))))
				//)))))))))
				));
    }
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player)
	{
		return this == InitBlocksVG.BASIC_DOUBLESLAB_ARCANITE ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ARCANITE), 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_VELIOUS ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_VELIOUS) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_FENRYTE ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_FENRYTE) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ELECTIUM ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ELECTIUM) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_IGNEELIS ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_IGNEELIS), 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_NECROCITE ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_NECROCITE) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ZEPHYRIUM ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ZEPHYRIUM) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_ONYXIUS ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_ONYXIUS) , 1)
				: (this == InitBlocksVG.BASIC_DOUBLESLAB_SOULARITE ? new ItemStack(Item.getItemFromBlock(InitBlocksVG.BASIC_HALFSLAB_SOULARITE) , 1)
						
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_draconium ? Item.getItemFromBlock(InitBlocksEA.cryptic_draconium)
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_velious ? Item.getItemFromBlock(InitBlocksEA.cryptic_velious) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_arcanite ? Item.getItemFromBlock(InitBlocksEA.cryptic_arcanite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_katcheen ? Item.getItemFromBlock(InitBlocksEA.cryptic_katcheen) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_necrocite ? Item.getItemFromBlock(InitBlocksEA.cryptic_necrocite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_soularite ? Item.getItemFromBlock(InitBlocksEA.cryptic_soularite) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_ebonheart ? Item.getItemFromBlock(InitBlocksEA.cryptic_ebonheart) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_obsidian ? Item.getItemFromBlock(InitBlocksEA.cryptic_obsidian) 
				//: (this == InitBlocksEA.basic_doubleslab_cryptic_glowstone ? Item.getItemFromBlock(InitBlocksEA.cryptic_glowstone)
				: new ItemStack(Item.getItemFromBlock(this))))))))
				//)))))))))
				));
	}
	
	@Override
	public int quantityDropped(Random random)
    {
        return this.isDouble() ? 2 : 1;
    }
	
	@Override
	public int damageDropped (IBlockState state)
	{
		return ((BlockSlabVG.EnumType)state.getValue(TYPE)).getID();
	}
	
	@Override
	public final IBlockState getStateFromMeta (int meta)
	{
		IBlockState blockstate = this.getDefaultState();
		blockstate = blockstate.withProperty(TYPE,BlockSlabVG.EnumType.byMetadata(meta & 7));
		
		if(!this.isDouble())
		{
			blockstate = blockstate.withProperty(HALF, (meta & 8 ) == 8 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
		}
		
		return blockstate;
	}
	
	@Override
	public final int getMetaFromState(IBlockState state)
	{
		int meta = ((BlockSlabVG.EnumType) state.getValue(TYPE)).getID();
		
		if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP)
		{
			meta |=8;
		}
		
		return meta;
	}
	
	@Override
	protected final BlockStateContainer createBlockState()
	{
		if (this.isDouble())
		{
			return new BlockStateContainer(this, getVariantProperty());
		}
		else 
		{
			return new BlockStateContainer(this, getVariantProperty(), HALF);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	{
		for (EnumType t : EnumType.values())
	    list.add(new ItemStack(itemIn, 1, t.ordinal()));  
	}
	
	public enum EnumType implements IStringSerializable
	{
		STONE(0, "stone")
		//RAW(0, "raw"),
		//SMOOTH(1, "smooth"), 
		//BRICKED(2, "bricked")
		;
		private static final BlockSlabVG.EnumType[] META_LOOKUP = new BlockSlabVG.EnumType[values().length];
		
	    private int ID;
	    private String name;
	    
	    private EnumType(int ID, String name) 
	    {
	        this.ID = ID;
	        this.name = name;
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
	    
	    public static BlockSlabVG.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }
            
            return META_LOOKUP[meta];
        }
	    static
        {
            for (BlockSlabVG.EnumType types : values())
            {
                META_LOOKUP[types.getID()] = types;
            }
        }
	}
}

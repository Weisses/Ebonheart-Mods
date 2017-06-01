package com.ebonheart.EbonArtsMod.common.blocks.basic.slabs;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockSlab;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ebonheart.EbonArtsMod.init.InitBlocksEA;

//Slab main class.
public abstract class EABlockSlab extends BlockSlab {
	
	//private static final PropertyBool VARIANT = PropertyBool.create("variant");
	public static final PropertyEnum TYPE = PropertyEnum.create("type", EABlockSlab.EnumType.class);

	public EABlockSlab(String unlocalname, String registryname) {
		super(Material.ROCK);
		setUnlocalizedName(unlocalname);
		setRegistryName(registryname);
		useNeighborBrightness = true;
		setHardness(0.8F);
        setResistance(5.0F);
        setSoundType(SoundType.STONE);
        //setCreativeTab(Tem.slabstab);
		IBlockState state = this.blockState.getBaseState();
		//state.withProperty(VARIANT, false);
		state.withProperty(TYPE, EnumType.STONE);
		if(!this.isDouble()){
			state.withProperty(HALF, EnumBlockHalf.BOTTOM);
		}
		setDefaultState(state);
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String getUnlocalizedName(int meta){
		return this.getUnlocalizedName() //+ "_" + EnumType.values()[meta]
				;
	}
	@Override
	public Comparable<?> getTypeForItem(ItemStack stack) {
		// TODO Auto-generated method stub
		return EABlockSlab.EnumType.byMetadata(stack.getMetadata() & 7);
	}
	@Override
	public IProperty<?> getVariantProperty(){
		return TYPE;
	}
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
		return this == InitBlocksEA.double_draconium_slab ? Item.getItemFromBlock(InitBlocksEA.draconium_slab)
				: (this == InitBlocksEA.double_velious_slab ? Item.getItemFromBlock(InitBlocksEA.velious_slab) 
				: (this == InitBlocksEA.double_arcanite_slab ? Item.getItemFromBlock(InitBlocksEA.arcanite_slab) 
				: (this == InitBlocksEA.double_katcheen_slab ? Item.getItemFromBlock(InitBlocksEA.katcheen_slab) 
				: (this == InitBlocksEA.double_necrocite_slab ? Item.getItemFromBlock(InitBlocksEA.necrocite_slab) 
				: (this == InitBlocksEA.double_soularite_slab ? Item.getItemFromBlock(InitBlocksEA.soularite_slab) 
				: (this == InitBlocksEA.double_ebonheart_slab ? Item.getItemFromBlock(InitBlocksEA.ebonheart_slab) 
				: (this == InitBlocksEA.double_obsidian_slab ? Item.getItemFromBlock(InitBlocksEA.obsidian_slab) 
				: (this == InitBlocksEA.double_glowstone_slab ? Item.getItemFromBlock(InitBlocksEA.glowstone_slab)
						
				: (this == InitBlocksEA.double_cryptic_draconium_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_draconium_slab)
				: (this == InitBlocksEA.double_cryptic_velious_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_velious_slab) 
				: (this == InitBlocksEA.double_cryptic_arcanite_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_arcanite_slab) 
				: (this == InitBlocksEA.double_cryptic_katcheen_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_katcheen_slab) 
				: (this == InitBlocksEA.double_cryptic_necrocite_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_necrocite_slab) 
				: (this == InitBlocksEA.double_cryptic_soularite_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_soularite_slab) 
				: (this == InitBlocksEA.double_cryptic_ebonheart_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_ebonheart_slab) 
				: (this == InitBlocksEA.double_cryptic_obsidian_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_obsidian_slab) 
				: (this == InitBlocksEA.double_cryptic_glowstone_slab ? Item.getItemFromBlock(InitBlocksEA.cryptic_glowstone_slab)
				: Item.getItemFromBlock(this))))))))))))))))));
		
		//return Item.getItemFromBlock(InitBlocksEA.draconium_slab);
    }
	@Override
	public int quantityDropped(Random random)
    {
        return this.isDouble() ? 2 : 1;
    }
	
	@Override
	public int damageDropped (IBlockState state){
		//return ((BlockBrickedClayBlockSlab1.EnumType) state.getValue(TYPE)).getID();
		return ((EABlockSlab.EnumType)state.getValue(TYPE)).getID();
	}
	
	@Override
	public final IBlockState getStateFromMeta (int meta){
		IBlockState blockstate = this.getDefaultState();
		blockstate = blockstate.withProperty(TYPE,EABlockSlab.EnumType.byMetadata(meta & 7));
		if(!this.isDouble()){
			blockstate = blockstate.withProperty(HALF, (meta & 8 ) == 8 ? EnumBlockHalf.BOTTOM : EnumBlockHalf.TOP);
			}
		return blockstate;
	}
	
	@Override
	public final int getMetaFromState(IBlockState state){
		int meta = ((EABlockSlab.EnumType) state.getValue(TYPE)).getID();
		if (!this.isDouble() && state.getValue(HALF) == EnumBlockHalf.TOP){
			meta |=8;
		}
		return meta;
	}
	@Override
	protected final BlockStateContainer createBlockState(){
		if (this.isDouble()){
			return new BlockStateContainer(this, getVariantProperty());
		}
		else {
			return new BlockStateContainer(this, getVariantProperty(), HALF);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item itemIn, CreativeTabs tab, List<ItemStack> list)
	{
		for (EnumType t : EnumType.values())
	    list.add(new ItemStack(itemIn, 1, t.ordinal()));  
	}
	
	//@Override
	public String getSpecialName(ItemStack stack) {
		return EnumType.values()[stack.getItemDamage()].name().toLowerCase();
	}
	
	public enum EnumType implements IStringSerializable{

		STONE(0, "stone")
		//RAW(0, "raw"),
		//SMOOTH(1, "smooth"), 
		//BRICKED(2, "bricked")
		;
		private static final EABlockSlab.EnumType[] META_LOOKUP = new EABlockSlab.EnumType[values().length];

	    private int ID;
	    private String name;
	   
	    private EnumType(int ID, String name) {
	        this.ID = ID;
	        this.name = name;
	            
	    }
	    @Override
	    public String getName() {
	        return name;
	    }
	    public int getID() {
	        return ID;
	    }
	    @Override
	    public String toString() {
	        return getName();
	    }
	    public static EABlockSlab.EnumType byMetadata(int meta)
        {
            if (meta < 0 || meta >= META_LOOKUP.length)
            {
                meta = 0;
            }

            return META_LOOKUP[meta];
        }
	    static
        {
            for (EABlockSlab.EnumType types : values())
            {
                META_LOOKUP[types.getID()] = types;
            }
        }
	}

}
package com.ebonheart.EbonArtsMod.common.items.tools;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ebonheart.EbonArtsMod.EbonArtsMod;
import com.ebonheart.EbonArtsMod.common.items.ItemHelper;
import com.google.common.collect.ImmutableSet;


public class ItemConsecration extends ItemTool {
	
	private static final float DIG_SPEED_WEB = 15.0f;
	private static final float DIG_SPEED_SWORD = 1.5f;
	private static final float DIG_SPEED_DEFAULT = 1.0f;
	private static final float BASE_DAMAGE = 3.0f;
	private static final float ATTACK_SPEED = -2.4f;
	
	public ItemConsecration(ToolMaterial material) 
	{
		super(BASE_DAMAGE, ATTACK_SPEED, material, Collections.emptySet());
		ItemHelper.setItemName(this, "tool/consecration");

		setHarvestLevel("pickaxe", material.getHarvestLevel());
		setHarvestLevel("shovel", material.getHarvestLevel());
		setCreativeTab(EbonArtsMod.tabEbonArtsItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		toolTip.add(TextFormatting.DARK_PURPLE + "\"Divine might rules over");
		toolTip.add(TextFormatting.DARK_PURPLE + "all of creation.\"");
		toolTip.add(" ");
		toolTip.add(TextFormatting.GOLD + "Multi-Tool");
		toolTip.add(TextFormatting.GREEN + "Pickaxe");
		toolTip.add(TextFormatting.GREEN + "Shovel");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.EPIC;
    }
	
	private static final Set<Material> EFFECTIVE_MATERIALS = ImmutableSet.of(
			// Pickaxe
			Material.ROCK, Material.IRON, Material.ICE, Material.GLASS, Material.PISTON, Material.ANVIL, Material.CIRCUITS, //Material., 
			
			// Shovel
			Material.GRASS, Material.GROUND, Material.SAND, Material.SNOW, Material.CRAFTED_SNOW, Material.CLAY
	);
	
	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) 
	{
		for (String type : getToolClasses(stack)) {
			if (state.getBlock().isToolEffective(type, state))
				return efficiencyOnProperMaterial;
		}

		// Not all blocks have a harvest tool/level set, so we need to fall back to checking the Material like the vanilla tools do
		if (EFFECTIVE_MATERIALS.contains(state.getMaterial())) {
			return efficiencyOnProperMaterial;
		}

		return DIG_SPEED_DEFAULT;
	}
	
	public boolean canHarvestBlock(IBlockState blockIn)
    {
        Block block = blockIn.getBlock();
        return block == Blocks.field_189877_df || block == Blocks.field_189879_dh || block == Blocks.field_189880_di || block == Blocks.STAINED_HARDENED_CLAY || block == Blocks.HARDENED_CLAY;
    }
	
}

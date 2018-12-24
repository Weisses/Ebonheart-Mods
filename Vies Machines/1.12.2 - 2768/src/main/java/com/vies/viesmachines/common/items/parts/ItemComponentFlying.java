package com.vies.viesmachines.common.items.parts;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemComponentFlying extends Item {
	
	private String procName;
	
	public ItemComponentFlying(String unlocalizedNameIn) 
	{
		ItemHelper.setItemName(this, unlocalizedNameIn);
		
		this.procName = "ComponentFlyingProc";
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		TextFormatting color = TextFormatting.GOLD;
		
		tooltip.add(color + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add(color + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
		tooltip.add(" ");
		tooltip.add(color + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.3"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
        return EnumRarity.UNCOMMON;
    }

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }
}

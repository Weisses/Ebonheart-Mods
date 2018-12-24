package com.vies.viesmachines.common.items.misc;

import java.util.List;

import javax.annotation.Nullable;

import com.vies.viesmachines.ViesMachines;
import com.vies.viesmachines.api.References;
import com.vies.viesmachines.common.items.ItemHelper;
import com.vies.viesmachines.configs.VMConfiguration;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemMachinePellets extends Item {
	
	private EnumRarity rarity;
	private String procName;
	
	public ItemMachinePellets(String unlocalizedNameIn, EnumRarity rarityIn) 
	{
		ItemHelper.setItemName(this, unlocalizedNameIn);
		
		this.rarity = rarityIn;
		
		this.procName = "AmmoProc";
		
		this.setMaxStackSize(64);
		this.setCreativeTab(ViesMachines.tabItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		TextFormatting textColor = TextFormatting.GRAY;
		
		if (this.rarity == EnumRarity.UNCOMMON)
		{
			textColor = TextFormatting.GOLD;
		}
		
		if (this.rarity == EnumRarity.RARE)
		{
			textColor = TextFormatting.DARK_AQUA;
		}
		
		if (this.rarity == EnumRarity.EPIC)
		{
			textColor = TextFormatting.DARK_PURPLE;
		}
		
		tooltip.add(textColor + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.1"));
		tooltip.add(textColor + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.2"));
		tooltip.add("");
		tooltip.add(textColor + References.Old_I18n.translateToLocal(this.getUnlocalizedName() + ".tt.3") + " : " + VMConfiguration.machinePelletsBurnTime + " " + References.Old_I18n.translateToLocal("viesmachines.main.seconds"));
	}
	
	@Override
	public EnumRarity getRarity(ItemStack stack)
    {
		return this.rarity;
    }

    /** Return the name for this gem proc. */
	public String getGemProcName()
    {
        return this.procName.toString();
    }
}

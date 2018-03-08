package com.viesis.viescraft.common.items.upgrades;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.ItemHelper;

public class ItemUpgradeCore extends Item {
	
	public ItemUpgradeCore() 
	{
		ItemHelper.setItemName(this, "upgrades/upgrade_airship_type");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.AirshipTierCore.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		TextFormatting stringColorMain = References.mainColorTooltip(stack);
		TextFormatting stringColorText = References.textColorTooltip(stack);
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			tooltip.add(I18n.format("vc.item.tt.upgradecore.0.1", new Object[0]));
			tooltip.add(I18n.format("vc.item.tt.upgradecore.0.2", new Object[0]));
			tooltip.add("");
			tooltip.add(I18n.format("vc.item.tt.upgradecore.0.3", new Object[0]));
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			if(stack.getMetadata() == 1)
			{
				//Make your airships move faster!
				//Works in any airship version.
				tooltip.add(TextFormatting.BLACK + "--ii" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.1", new Object[0]));
				tooltip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.2", new Object[0]));
				
				tooltip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Speed
				tooltip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------l" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.11", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain + "+" 
						+ df.format(EnumsVC.AirshipTierCore.byId(this.getMetadata(stack)).getSpeedModifier() * 100)
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "----------il" + TextFormatting.DARK_GREEN + "||");
				
				tooltip.add(TextFormatting.DARK_GREEN + "================================");
				
				//tooltip.add("");
				
				//Used in the airship's "Upgrade" menu.
				tooltip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradecore.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradecore.#.6", new Object[0]));
				
				tooltip.add("");
				//Base Upgrade
				tooltip.add(TextFormatting.BLACK + "-------iil" + TextFormatting.DARK_BLUE + "-=" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.10", new Object[0]) + TextFormatting.DARK_BLUE + "=-");
				//Core Tier can't exceed Frame Tier.
				tooltip.add(TextFormatting.BLACK + "-l" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradecore.#.9", new Object[0]));
			}
			else
			{
				//Make your airships move faster!
				//Works in any airship version.
				tooltip.add(TextFormatting.BLACK + "--ii" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.1", new Object[0]));
				tooltip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.2", new Object[0]));
				
				tooltip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Speed
				tooltip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------l" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.11", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain + "+" 
						+ df.format(EnumsVC.AirshipTierCore.byId(this.getMetadata(stack)).getSpeedModifier() * 100)
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "----------il" + TextFormatting.DARK_GREEN + "||");
				
				tooltip.add(TextFormatting.DARK_GREEN + "================================");
				
				//tooltip.add("");
				
				//Used in the airship's "Upgrade" menu.
				tooltip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradecore.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradecore.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradecore.#.6", new Object[0]));
				
				tooltip.add("");
				
				//Must upgrade from a Tier # core.
				tooltip.add(TextFormatting.BLACK + "-iil" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradecore.#.7", new Object[0])
				+ " " + (stack.getMetadata() - 1) + " "
				+ I18n.format("vc.item.tt.upgradecore.#.8", new Object[0]));
				//Core Tier can't exceed Frame Tier.
				tooltip.add(TextFormatting.BLACK + "-l" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradecore.#.9", new Object[0]));
			}
		}
		else
		{
			tooltip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.shifthelper.0", new Object[0]));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	public EnumRarity getRarity(ItemStack stack)
    {
		if(stack.getMetadata() == 0)
        {
        	this.setMaxStackSize(64);
        }
        else
        {
        	this.setMaxStackSize(1);
        }
		
		switch (this.getMetadata(stack))
        {
            case 0:
            	return EnumRarity.COMMON;
            case 1:
            	return EnumRarity.COMMON;
            case 2:
            	return EnumRarity.UNCOMMON;
            case 3:
            	return EnumRarity.RARE;
            case 4:
            	return EnumRarity.EPIC;
            case 5:
            	return EnumRarity.EPIC;
            default:
            	return EnumRarity.COMMON;
        }
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
        String colorName = TextFormatting.WHITE + "Upgrade Tier";
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE 
				+ "Core Shard";
			case 1:
				return colorName = TextFormatting.WHITE 
				+ "Core Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.WHITE + EnumsVC.AirshipTierType.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 2:
				return colorName = TextFormatting.YELLOW 
				+ "Core Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.YELLOW + EnumsVC.AirshipTierType.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 3:
				return colorName = TextFormatting.AQUA 
				+ "Core Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.AQUA + EnumsVC.AirshipTierType.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 4:
				return colorName = TextFormatting.LIGHT_PURPLE 
				+ "Core Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.LIGHT_PURPLE + EnumsVC.AirshipTierType.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 5:
				return colorName = TextFormatting.RED 
				+ "Core Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.RED + EnumsVC.AirshipTierType.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
		}
		
		return colorName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.AirshipTierCore.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

package com.viesis.viescraft.common.items.upgrades;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.ItemHelper;

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

public class ItemUpgradeCore extends Item {
	
	public ItemUpgradeCore() 
	{
		ItemHelper.setItemName(this, "upgrades/item_upgrade_airship_core");
		
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
		float speedModCal = EnumsVC.MainTierFrame.byId(this.getMetadata(stack)).getSpeedModifier() * 100;
		String speedMod = df.format(speedModCal);
		
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		TextFormatting stringColorMain = References.mainColorTooltip(stack);
		TextFormatting stringColorText = References.textColorTooltip(stack);
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			tooltip.add(References.localNameVC("vc.item.tt.upgradecore.0.1"));
			tooltip.add(References.localNameVC("vc.item.tt.upgradecore.0.2"));
			tooltip.add("");
			tooltip.add(References.localNameVC("vc.item.tt.upgradecore.0.3"));
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			if(stack.getMetadata() == 1)
			{
				//Make an airship hold more Redstone.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgradecore.#.1"));
				tooltip.add("");
				//This is the base upgrade.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.4"));
				//Use in the airship's Upgrade menu.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.1"));
				tooltip.add("");
				//Unlocks:
				tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.main.unlocks") + ":");
				//New Frame, Engine, and Balloon models.
				tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.BLUE + References.localNameVC("vc.item.tt.upgradecore.#.2"));
			}
			else if(stack.getMetadata() == 5)
			{
				//Make an airship hold more Redstone.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgradecore.#.1"));
				tooltip.add("");
				//Airship must me Tier # to apply.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.2") + " " + (stack.getMetadata() - 1) + " " + References.localNameVC("vc.item.tt.upgrade.#.3"));
				//Use in the airship's Upgrade menu.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.1"));
				tooltip.add("");
				//Unlocks:
				tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.main.unlocks") + ":");
				//New Frame, Engine, and Balloon models.
				tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.BLUE + References.localNameVC("vc.item.tt.upgradecore.#.2"));
				//Transparency + Coloring options.
				tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.BLUE + References.localNameVC("vc.item.tt.upgradecore.#.3"));
			}
			else
			{
				//Make an airship hold more Redstone.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgradecore.#.1"));
				tooltip.add("");
				//Airship must me Tier # to apply.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.2") + " " + (stack.getMetadata() - 1) + " " + References.localNameVC("vc.item.tt.upgrade.#.3"));
				//Use in the airship's Upgrade menu.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.1"));
				tooltip.add("");
				//Unlocks:
				tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.main.unlocks") + ":");
				//New Frame, Engine, and Balloon models.
				tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.BLUE + References.localNameVC("vc.item.tt.upgradecore.#.2"));
			}
		}
		else
		{
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.shifthelper.0"));
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
	}
	
	@Override
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
        String colorName = "";
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_shard.name");
			case 1:
				return colorName = TextFormatting.WHITE 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_upgrade.name") + " "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.WHITE + EnumsVC.MainTierCore.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 2:
				return colorName = TextFormatting.YELLOW 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_upgrade.name") + " "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.YELLOW + EnumsVC.MainTierCore.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 3:
				return colorName = TextFormatting.AQUA 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_upgrade.name") + " "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.AQUA + EnumsVC.MainTierCore.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 4:
				return colorName = TextFormatting.LIGHT_PURPLE 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_upgrade.name") + " "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.LIGHT_PURPLE + EnumsVC.MainTierCore.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 5:
				return colorName = TextFormatting.RED 
				+ References.Old_I18n.translateToLocalFormatted("item.vc:item_core_upgrade.name") + " "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.RED + EnumsVC.MainTierCore.byId(this.getMetadata(stack)).getLocalizedName()
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
			final List<ItemStack> items = Stream.of(EnumsVC.MainTierCore.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
}

/**
@Override
public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
{
	//ItemStack itemstack = player.getHeldItemMainhand();
    
	if (entity instanceof EntityAirshipBaseVC)
    {
		if(player.isSneaking())
		{
			EntityAirshipBaseVC airship = (EntityAirshipBaseVC) entity;
			
			if(airship.metaAirshipTier < this.getMetadata(stack))
			{
				airship.metaAirshipTier = this.getMetadata(stack);
				player.addStat(InitAchievementsVC.airship_create_color);
				
				if (!player.capabilities.isCreativeMode)
                {
					player.inventory.decrStackSize(player.inventory.currentItem, 1);
                }
				return true;
			}
			return true;
		}
		return true;
    }
    return false;
}
*/

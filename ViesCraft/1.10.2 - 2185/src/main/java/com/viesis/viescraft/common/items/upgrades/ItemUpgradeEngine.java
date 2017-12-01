package com.viesis.viescraft.common.items.upgrades;

import java.text.DecimalFormat;
import java.util.List;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.api.EnumsVC;
import com.viesis.viescraft.api.References;
import com.viesis.viescraft.common.items.ItemHelper;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemUpgradeEngine extends Item {
	
	public ItemUpgradeEngine() 
	{
		ItemHelper.setItemName(this, "upgrades/upgrade_airship_engine");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		DecimalFormat df = new DecimalFormat("###.#");
		float speedModCal = EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getFuelPerTick();
		String speedMod = df.format(speedModCal);
		
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		TextFormatting stringColorMain = References.mainColorTooltip(stack);
		TextFormatting stringColorText = References.textColorTooltip(stack);
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			toolTip.add(I18n.format("vc.item.tt.upgradeengine.0.1", new Object[0]));
			toolTip.add(I18n.format("vc.item.tt.upgradeengine.0.2", new Object[0]));
			toolTip.add("");
			toolTip.add(I18n.format("vc.item.tt.upgradeengine.0.3", new Object[0]));
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			if(stack.getMetadata() == 1)
			{
				//Make your airships move faster!
				//Works in any airship version.
				toolTip.add(TextFormatting.BLACK + "-l" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.1", new Object[0]));
				toolTip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.2", new Object[0]));
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Fuel
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------iiiiii" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.13", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain + "-" 
						+ df.format(EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getFuelPerTick())
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "---------il" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//toolTip.add("");
				
				//Used in the airship's "Upgrade" menu.
				toolTip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeengine.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradeengine.#.6", new Object[0]));
				
				toolTip.add("");
				//Base Upgrade
				toolTip.add(TextFormatting.BLACK + "-------iil" + TextFormatting.DARK_BLUE + "-=" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeengine.#.10", new Object[0]) + TextFormatting.DARK_BLUE + "=-");
				//Engine Tier can't exceed Frame Tier.
				toolTip.add(TextFormatting.BLACK + "ii" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeengine.#.9", new Object[0]));
			}
			else
			{
				//Make your airships move faster!
				//Works in any airship version.
				toolTip.add(TextFormatting.BLACK + "-l" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.1", new Object[0]));
				toolTip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.2", new Object[0]));
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Fuel
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------iiiiii" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.13", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain + "-" 
						+ df.format(EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getFuelPerTick())
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "---------il" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//toolTip.add("");
				
				//Used in the airship's "Upgrade" menu.
				toolTip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradeengine.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeengine.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradeengine.#.6", new Object[0]));
				
				toolTip.add("");
				
				//Must upgrade from a Tier # engine.
				toolTip.add(TextFormatting.BLACK + "iiii" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeengine.#.7", new Object[0])
				+ " " + (stack.getMetadata() - 1) + " "
				+ I18n.format("vc.item.tt.upgradeengine.#.8", new Object[0]));
				//Engine Tier can't exceed Frame Tier.
				toolTip.add(TextFormatting.BLACK + "ii" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeengine.#.9", new Object[0]));
			}
		}
		else
		{
			toolTip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.shifthelper.0", new Object[0]));
		}
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
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
        
		String colorName = "";
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE 
				+ "Engine Fragment";
			case 1:
				return colorName = TextFormatting.WHITE 
				+ "Engine Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.WHITE + EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 2:
				return colorName = TextFormatting.YELLOW 
				+ "Engine Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.YELLOW + EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 3:
				return colorName = TextFormatting.AQUA 
				+ "Engine Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.AQUA + EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 4:
				return colorName = TextFormatting.LIGHT_PURPLE 
				+ "Engine Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.LIGHT_PURPLE + EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 5:
				return colorName = TextFormatting.RED 
				+ "Engine Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.RED + EnumsVC.AirshipTierEngine.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
		}
		
		return colorName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EnumsVC.AirshipTierEngine contents : EnumsVC.AirshipTierEngine.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
    	}
    }
}

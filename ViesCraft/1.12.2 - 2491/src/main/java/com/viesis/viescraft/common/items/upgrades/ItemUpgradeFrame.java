package com.viesis.viescraft.common.items.upgrades;

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

public class ItemUpgradeFrame extends Item {
	
	public ItemUpgradeFrame() 
	{
		ItemHelper.setItemName(this, "upgrades/upgrade_airship_frame");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setMaxStackSize(1);
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, EntityPlayer playerIn, List toolTip, boolean advanced) 
	{
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		TextFormatting stringColorMain = References.mainColorTooltip(stack);
		TextFormatting stringColorText = References.textColorTooltip(stack);
		
		toolTip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			toolTip.add(I18n.format("vc.item.tt.upgradeframe.0.1", new Object[0]));
			toolTip.add(I18n.format("vc.item.tt.upgradeframe.0.2", new Object[0]));
			toolTip.add("");
			toolTip.add(I18n.format("vc.item.tt.upgradeframe.0.3", new Object[0]));
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			if(stack.getMetadata() == 1)
			{
				//Make your airships move faster!
				//Works in any airship version.
				toolTip.add(TextFormatting.BLACK + "i" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.1", new Object[0]));
				toolTip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.2", new Object[0]));
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Speed
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------l" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.14", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain
						+ EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "-------il" + TextFormatting.DARK_GREEN + "||");
				
				//Bonus-Visuals
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "----l" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.11", new Object[0])
						+ TextFormatting.BLACK + "---il" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//toolTip.add("");
				
				//Used in the airship's "Upgrade" menu.
				toolTip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradeframe.#.6", new Object[0]));
				
				toolTip.add("");
				
				//Base Upgrade
				toolTip.add(TextFormatting.BLACK + "-------iil" + TextFormatting.DARK_BLUE + "-=" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.10", new Object[0]) + TextFormatting.DARK_BLUE + "=-");
			}
			else if(stack.getMetadata() == 5)
			{
				//Make your airships move faster!
				//Works in any airship version.
				toolTip.add(TextFormatting.BLACK + "i" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.1", new Object[0]));
				toolTip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.2", new Object[0]));
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Speed
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------l" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.14", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain  
						+ EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "-------il" + TextFormatting.DARK_GREEN + "||");
				
				//Bonus-Visuals
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "----l" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.11", new Object[0])
						+ TextFormatting.BLACK + "---il" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.DARK_GREEN + "------------" + TextFormatting.BLACK + "il" + TextFormatting.GREEN + I18n.format("vc.item.tt.upgradeframe.#.12", new Object[0])
						+ TextFormatting.BLACK +  "il" + TextFormatting.DARK_GREEN + "------------" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "iii" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.13", new Object[0])
						+ TextFormatting.BLACK + "iil" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//toolTip.add("");
				
				//Used in the airship's "Upgrade" menu.
				toolTip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradeframe.#.6", new Object[0]));
				
				//toolTip.add("");
				
				//Must upgrade from a Tier # frame.
				//toolTip.add(TextFormatting.BLACK + "-iil" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeframe.#.7")
				//+ " " + (stack.getMetadata() - 1) + " "
				//+ I18n.format("vc.item.tt.upgradeframe.#.8"));
				//Frame Tier can't exceed Frame Tier.
				//toolTip.add(TextFormatting.BLACK + "-l" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeframe.#.9"));
			}
			else
			{
				//Make your airships move faster!
				//Works in any airship version.
				toolTip.add(TextFormatting.BLACK + "i" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.1", new Object[0]));
				toolTip.add(TextFormatting.BLACK + "---iii" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.2", new Object[0]));
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//Airship Speed
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "---------l" + TextFormatting.BLUE + I18n.format("vc.item.tt.airship.14", new Object[0]) + TextFormatting.DARK_BLUE + " : " 
						+ TextFormatting.GRAY + "(" + stringColorMain  
						+ EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
						+ TextFormatting.GRAY + ")"
						+ TextFormatting.BLACK + "-------il" + TextFormatting.DARK_GREEN + "||");
				
				//Bonus-Visuals
				toolTip.add(TextFormatting.DARK_GREEN + "||" + TextFormatting.BLACK + "----l" + TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.11", new Object[0])
						+ TextFormatting.BLACK + "---il" + TextFormatting.DARK_GREEN + "||");
				
				toolTip.add(TextFormatting.DARK_GREEN + "================================");
				
				//toolTip.add("");
				
				//Used in the airship's "Upgrade" menu.
				toolTip.add(TextFormatting.BLACK + "il" + stringColorText + I18n.format("vc.item.tt.upgradeframe.#.4", new Object[0])
				+ TextFormatting.DARK_BLUE + " \"" 
				+ TextFormatting.BLUE + I18n.format("vc.item.tt.upgradeframe.#.5", new Object[0]) 
				+ TextFormatting.DARK_BLUE + "\" "
				+ stringColorText + I18n.format("vc.item.tt.upgradeframe.#.6", new Object[0]));
				
				//toolTip.add("");
				
				//Must upgrade from a Tier # frame.
				//toolTip.add(TextFormatting.BLACK + "-iil" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeframe.#.7")
				//+ " " + (stack.getMetadata() - 1) + " "
				//+ I18n.format("vc.item.tt.upgradeframe.#.8"));
				//Frame Tier can't exceed Frame Tier.
				//toolTip.add(TextFormatting.BLACK + "-l" + TextFormatting.DARK_RED + I18n.format("vc.item.tt.upgradeframe.#.9"));
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
        
		String colorName = TextFormatting.WHITE + "Upgrade Tier";
		
		switch(stack.getMetadata())
		{
			case 0:
				return colorName = TextFormatting.WHITE 
				+ "Frame Casing";
			case 1:
				return colorName = TextFormatting.WHITE 
				+ "Frame Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.WHITE + EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 2:
				return colorName = TextFormatting.YELLOW 
				+ "Frame Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.YELLOW + EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 3:
				return colorName = TextFormatting.AQUA 
				+ "Frame Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.AQUA + EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 4:
				return colorName = TextFormatting.LIGHT_PURPLE 
				+ "Frame Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.LIGHT_PURPLE + EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
			case 5:
				return colorName = TextFormatting.RED 
				+ "Frame Upgrade "
				+ TextFormatting.GRAY + "("
				+ TextFormatting.RED + EnumsVC.AirshipTierFrame.byId(this.getMetadata(stack)).getLocalizedName()
				+ TextFormatting.GRAY + ")";
		}
		
		return colorName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems)
    {
    	for (EnumsVC.AirshipTierFrame contents : EnumsVC.AirshipTierFrame.values()) 
    	{
			int meta = contents.getMetadata();
			ItemStack subItemStack = new ItemStack(itemIn, 1, meta);
			subItems.add(subItemStack);
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

package com.viesis.viescraft.common.items.parts;

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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemModuleType extends Item {
	
	public ItemModuleType() 
	{
		ItemHelper.setItemName(this, "modules/item_module_type");
		
		this.setHasSubtypes(true);
        this.setMaxDamage(0);
        
		this.setCreativeTab(ViesCraft.tabViesCraftItems);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
		GameSettings gameSettingsIn = Minecraft.getMinecraft().gameSettings;
		
		TextFormatting stringColorText = this.getCustomRarityText(stack);
		
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String line4 = "";
		String line5 = "";
		String line6 = "";
		
		if(stack.getMetadata() == 0)
		{
			line1 = References.localNameVC("vc.item.tt.moduletype.0.1");
			line2 = References.localNameVC("vc.item.tt.moduletype.0.2");
		}
		else if(stack.getMetadata() >= 1)
		{
			line3 = References.localNameVC("vc.item.tt.moduletype.#." + stack.getMetadata() + ".pros1");
			line4 = References.localNameVC("vc.item.tt.moduletype.#." + stack.getMetadata() + ".pros2");
			line5 = References.localNameVC("vc.item.tt.moduletype.#." + stack.getMetadata() + ".cons1");
			line6 = References.localNameVC("vc.item.tt.moduletype.#." + stack.getMetadata() + ".cons2");
		}
		
		tooltip.add(TextFormatting.DARK_GREEN + "================================");
		
		if(stack.getMetadata() == 0)
		{
			tooltip.add(stringColorText + line1);
			tooltip.add(stringColorText + line2);
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			//Designed to enhance an airship.
			tooltip.add(stringColorText + References.localNameVC("vc.item.tt.moduletype.#.05"));
			tooltip.add("");
			
			if(stack.getMetadata() == 1
			|| stack.getMetadata() == 4
			|| stack.getMetadata() == 7
			|| stack.getMetadata() == 10
			|| stack.getMetadata() == 13
			|| stack.getMetadata() == 16
			|| stack.getMetadata() == 19
			|| stack.getMetadata() == 22
			|| stack.getMetadata() == 25)
			{
				//This is the base upgrade.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.upgrade.#.4"));
			}
			else
			{
				//Must have 'ModuleString' to apply.
				tooltip.add(stringColorText + References.localNameVC("vc.item.tt.moduletype.#.06") + " " 
				+ EnumsVC.ModuleType.byId((stack.getMetadata() - 1)).getLocalizedName()+ " " +References.localNameVC("vc.item.tt.moduletype.#.07"));
			}
			
			//Use in the airship's "Module" menu.
			tooltip.add(stringColorText + References.localNameVC("vc.item.tt.moduletype.#.04"));
			
			tooltip.add("");
			
			//Toggled Effects
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.moduletype.#.01") + ":");
			
			//-=Pros=-
			tooltip.add(TextFormatting.GREEN + "+ " + TextFormatting.BLUE + line3);
			tooltip.add(TextFormatting.GREEN + "+ " + TextFormatting.BLUE + line4);
			
			//tooltip.add("");
			
			//-=Cons=-
			tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.RED + line5);	
			tooltip.add(TextFormatting.GREEN + "- " + TextFormatting.RED + line6);	
			
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
		}
		else
		{
			tooltip.add(TextFormatting.GREEN + References.localNameVC("vc.item.tt.shifthelper.0"));
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
		}
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
				return EnumRarity.RARE;
			default:
            	return EnumRarity.EPIC;
        }
    }
	
	@Override
	public String getItemStackDisplayName(ItemStack stack)
    {
		String itemName;
		TextFormatting stringColorMain = this.getCustomRarityMain(stack);
		
		if(stack.getMetadata() == 0)
        {
        	itemName = stringColorMain + References.localNameVC("item.vc:item_module_chip.name");
        }
        else
        {
        	itemName = stringColorMain + EnumsVC.ModuleType.byId(this.getMetadata(stack)).getLocalizedName() 
        			+ " " + TextFormatting.GRAY + "("
        			+ TextFormatting.DARK_RED + References.localNameVC("vc.item.module.#")
        			+ TextFormatting.GRAY + ")";
        }
		
		return itemName;
    }
	
	@SideOnly(Side.CLIENT)
	@Override
	public void getSubItems(final CreativeTabs tab, final NonNullList<ItemStack> subItems) 
	{
		if (isInCreativeTab(tab)) 
		{
			final List<ItemStack> items = Stream.of(EnumsVC.ModuleType.values())
					.map(enumType -> new ItemStack(this, 1, enumType.getMetadata()))
					.collect(Collectors.toList());

			subItems.addAll(items);
		}
	}
	
	public TextFormatting getCustomRarityText(ItemStack stack)
	{
		switch (this.getMetadata(stack))
        {
			case 0:
				return TextFormatting.GRAY;
			case 1:
				return TextFormatting.GOLD;
			case 2:
				return TextFormatting.DARK_AQUA;
			case 3:
				return TextFormatting.DARK_PURPLE;
			case 4:
				return TextFormatting.GOLD;
			case 5:
				return TextFormatting.DARK_AQUA;
			case 6:
				return TextFormatting.DARK_PURPLE;
			case 7:
				return TextFormatting.GOLD;
			case 8:
				return TextFormatting.DARK_AQUA;
			case 9:
				return TextFormatting.DARK_PURPLE;
			case 10:
				return TextFormatting.GOLD;
			case 11:
				return TextFormatting.DARK_AQUA;
			case 12:
				return TextFormatting.DARK_PURPLE;
			case 13:
				return TextFormatting.GOLD;
			case 14:
				return TextFormatting.DARK_AQUA;
			case 15:
				return TextFormatting.DARK_PURPLE;
			case 16:
				return TextFormatting.GOLD;
			case 17:
				return TextFormatting.DARK_AQUA;
			case 18:
				return TextFormatting.DARK_PURPLE;
			case 19:
				return TextFormatting.GOLD;
			case 20:
				return TextFormatting.DARK_AQUA;
			case 21:
				return TextFormatting.DARK_PURPLE;
			case 22:
				return TextFormatting.GOLD;
			case 23:
				return TextFormatting.DARK_AQUA;
			case 24:
				return TextFormatting.DARK_PURPLE;
			case 25:
				return TextFormatting.GOLD;
			case 26:
				return TextFormatting.DARK_AQUA;
			case 27:
				return TextFormatting.DARK_PURPLE;
			default:
            	return TextFormatting.WHITE;
        }
	}
	
	public TextFormatting getCustomRarityMain(ItemStack stack)
	{
		switch (this.getMetadata(stack))
        {
			case 0:
				return TextFormatting.WHITE;
			case 1:
				return TextFormatting.YELLOW;
			case 2:
				return TextFormatting.AQUA;
			case 3:
				return TextFormatting.LIGHT_PURPLE;
			case 4:
				return TextFormatting.YELLOW;
			case 5:
				return TextFormatting.AQUA;
			case 6:
				return TextFormatting.LIGHT_PURPLE;
			case 7:
				return TextFormatting.YELLOW;
			case 8:
				return TextFormatting.AQUA;
			case 9:
				return TextFormatting.LIGHT_PURPLE;
			case 10:
				return TextFormatting.YELLOW;
			case 11:
				return TextFormatting.AQUA;
			case 12:
				return TextFormatting.LIGHT_PURPLE;
			case 13:
				return TextFormatting.YELLOW;
			case 14:
				return TextFormatting.AQUA;
			case 15:
				return TextFormatting.LIGHT_PURPLE;
			case 16:
				return TextFormatting.YELLOW;
			case 17:
				return TextFormatting.AQUA;
			case 18:
				return TextFormatting.LIGHT_PURPLE;
			case 19:
				return TextFormatting.YELLOW;
			case 20:
				return TextFormatting.AQUA;
			case 21:
				return TextFormatting.LIGHT_PURPLE;
			case 22:
				return TextFormatting.YELLOW;
			case 23:
				return TextFormatting.AQUA;
			case 24:
				return TextFormatting.LIGHT_PURPLE;
			case 25:
				return TextFormatting.YELLOW;
			case 26:
				return TextFormatting.AQUA;
			case 27:
				return TextFormatting.LIGHT_PURPLE;
			default:
            	return TextFormatting.WHITE;
        }
	}
}

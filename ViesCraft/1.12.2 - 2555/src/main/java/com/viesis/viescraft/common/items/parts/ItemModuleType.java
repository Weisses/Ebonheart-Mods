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
		
		TextFormatting stringColorMain = References.mainColorTooltip(stack);
		TextFormatting stringColorText = References.textColorTooltip(stack);
		
		String line1 = "";
		String line2 = "";
		String line3 = "";
		String line4 = "";
		String line5 = "";
		String line6 = "";
		
		if(stack.getMetadata() == 0)
		{
			line1 = I18n.format("vc.item.tt.moduletype.0.1");
			line2 = I18n.format("vc.item.tt.moduletype.0.2");
		}
		else if(stack.getMetadata() >= 1)
		{
			line3 = I18n.format("vc.item.tt.moduletype.#." + stack.getMetadata() + ".pros1");
			line4 = I18n.format("vc.item.tt.moduletype.#." + stack.getMetadata() + ".pros2");
			line5 = I18n.format("vc.item.tt.moduletype.#." + stack.getMetadata() + ".cons1");
			line6 = I18n.format("vc.item.tt.moduletype.#." + stack.getMetadata() + ".cons2");
		}
		
		if(stack.getMetadata() == 0)
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			
			tooltip.add(TextFormatting.DARK_AQUA + line1);
			tooltip.add(TextFormatting.DARK_AQUA + line2);
			
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
		}
		else if(gameSettingsIn.isKeyDown(gameSettingsIn.keyBindSneak))
		{
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			
			//-----Toggled Effects-------
			tooltip.add(TextFormatting.DARK_GREEN + "||" + "--------" + TextFormatting.BLACK + "l" 
					+ TextFormatting.BLUE + I18n.format("vc.item.tt.moduletype.#.01", new Object[0])
					+ TextFormatting.BLACK + "ii" + TextFormatting.DARK_GREEN + "--------" + "||");
			
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			
			
			//-=Pros=-
			tooltip.add(TextFormatting.DARK_AQUA + line3);
			tooltip.add(TextFormatting.DARK_AQUA + line4);
			
			//-=Cons=-
			tooltip.add(TextFormatting.DARK_RED + line5);	
			tooltip.add(TextFormatting.DARK_RED + line6);	
			
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
			
			//Used in the airship's "Upgrade" menu.
					tooltip.add(TextFormatting.BLACK + "iiil" + stringColorText + I18n.format("vc.item.tt.moduletype.#.04", new Object[0])
					+ TextFormatting.DARK_BLUE + " \"" 
					+ TextFormatting.BLUE + I18n.format("vc.item.tt.moduletype.#.05", new Object[0]) 
					+ TextFormatting.DARK_BLUE + "\" "
					+ stringColorText + I18n.format("vc.item.tt.moduletype.#.06", new Object[0]));
					
			
			tooltip.add(TextFormatting.DARK_GREEN + "================================");
		}
		else
		{
			tooltip.add(TextFormatting.GREEN + I18n.format("vc.item.tt.shifthelper.0", new Object[0]));
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
		
		if(stack.getMetadata() == 0)
        {
        	itemName = References.Old_I18n.translateToLocalFormatted("Module Chip", new Object[0]);
        }
        else
        {
        	itemName = EnumsVC.ModuleType.byId(this.getMetadata(stack)).getLocalizedName() 
        			+ " " + TextFormatting.GRAY + "("
        			+ TextFormatting.DARK_RED + References.Old_I18n.translateToLocalFormatted("vc.item.module.#", new Object[0])
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
}
